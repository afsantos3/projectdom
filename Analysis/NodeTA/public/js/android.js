'use strict';

var dilemmaServiceUrl = 'https://gateway.watsonplatform.net/tradeoff-analytics/api/v1/dilemmas?generate_visualization=false';

/**
 * @type {ProblemData}
 */
var theProblem;
var comparedOps = [undefined, undefined];
var analyzedCols = [];
var previousOp = new Array();

var fs = require('fs');
var json = JSON.parse(fs.readFileSync('../data/rw.json', 'utf8'));

/**********SERVICE INTERACTION**********/
function dilemma(problem) {
  // automatically fetch the token right away
  // later, call getToken.then(function(token) {...}); to use it
  // it's valid for up to an hour
  var getToken = $.post('/api/tradeoff-analytics-token', {_csrf: $('meta[name="ct"]').attr('content')});
  getToken.fail(function(err) {
    console.log(err);
  });

  /**
   * Remove any info that is not relevant for the delima service,
   * returns the problem set with only objective fields that the user has selected
   * @param {ProblemData} problem
   * @returns {ProblemData}
   */
  function minimizeProblem(problem) {
    var objs = problem.columns
        .filter(function(col){
          return col.is_objective;
        })
        .map(function(obj, i) {
          return {
            full_name: obj.full_name || obj.key,
            orgKey: obj.key,
            key: i,
            goal: obj.goal,
            is_objective: true,
            //format
            type: obj.type,
            range: obj.range,
            preference: obj.preference
          };
        });
    return {
      subject: problem.subject,
      columns: objs,
      options: problem.options.map(function(op) {
        var vals = {};
        _.each(objs, function(obj, i) {
          vals[i] = op.values[obj.orgKey];
        });
        return {
          key: op.key,
          values: vals
        };
      })
    };
  }

  function tranformResolution(dilemma, minProblem) {
    var res = dilemma.resolution;
    var objKeys = minProblem.columns.map(function(c) {
      return c.orgKey;
    });
    res.map && res.map.anchors.forEach(function(anc) {
      anc.name = objKeys[Number(anc.name)];
    });
    res.solutions.forEach(function(sol) {
      if (sol.status === 'INCOMPLETE' && _.contains(['MISSING_OBJECTIVE_VALUE', 'RANGE_MISMATCH'], sol.status_cause.error_code)) {
        sol.status_cause.tokens[0] = objKeys[Number(sol.status_cause.tokens[0])];
        minProblem.columns.forEach(function(c) {
          var newMsg = sol.status_cause.message.replace('column: "'+c.key+'"', 'column: "'+c.orgKey+'"');
          sol.status_cause.message = newMsg;
        });
      }
    });
    return res;
  }
  var minProblem = minimizeProblem(problem);
  return getToken.then(function(token) {
    return $.ajax(dilemmaServiceUrl, {
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(minProblem),
      headers: {
        'X-Watson-Authorization-Token': token,
        'X-Watson-Metadata' : 'dataset-name=edmunds;client=ta_demo_app;client-version=2.0;'
      }
    })
        .then(function(response) {
          return {
            problem: problem,
            resolution: tranformResolution(response, minProblem)
          };
        });
  });
}
