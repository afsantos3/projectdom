package com.example.lukem.dom;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Option;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;

import java.util.List;

/**
 * Created by MLH on 3/26/2017.
 */
public class write_watson {
    private TradeoffAnalytics service;
    private Problem problem;
    private List<Column> columns;
    private List<Option> options;

    public TradeoffAnalytics getService() {
        return service;
    }
    public Problem getProblem() {
        return problem;
    }
    public List<Column> getColumns() {
        return columns;
    }
    public List<Option> getOptions() {
        return options;
    }

    public void setService(TradeoffAnalytics service) {
        this.service = service;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}