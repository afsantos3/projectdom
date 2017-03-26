package com.example.lukem.dom;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.NumericColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.TextColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLH on 3/26/2017.
 */

public class watson_builder {
    write_watson watsonVals;
    avg_scores avgScores;

    public void define_problem() {
        Problem problem = new Problem("home");
        watsonVals.setProblem(problem);
    }
    public void get_service() {
        TradeoffAnalytics service = new TradeoffAnalytics();
    }
    public void create_columns() {
        List<Column> columns = new ArrayList<Column>();

        NumericColumn numCol = new NumericColumn();
        numCol.setFormat("number:0 | taPrefix: '$'");
        numCol.setDescription("Listing Price");
        numCol.setSignificantGain(0.2);
        columns.add(numCol.range(0.0, avgScores.getPrice_avg()).key("price").goal(Column.Goal.MIN).fullName("Price").objective(true));

        numCol = new NumericColumn();
        numCol.setFormat("number:0 | taPrefix: 'sq.ft.'");
        numCol.setDescription("The total floor size in sq ft");
        numCol.setSignificantLoss(0.4);
        columns.add(numCol.range(avgScores.getSqft_avg(), 999999999.0).key("square_footage").goal(Column.Goal.MAX).fullName("Square Footage").objective(true));

        numCol = new NumericColumn();
        numCol.setDescription("True if utilities are in rent");
        columns.add(numCol.range(0, 1).key("utilities").goal(Column.Goal.MAX).fullName("Utilities Included").objective(true));

        numCol = new NumericColumn();
        numCol.setFormat("number:0 | taPrefix: 'bed'");
        numCol.setDescription("Number of bedrooms in house");
        numCol.setSignificantLoss(0.5);
        columns.add(numCol.range(avgScores.getBed_avg(), 99.9).key("number_bedrooms").goal(Column.Goal.MAX).fullName("Number of Bedrooms").objective(true));

        numCol = new NumericColumn();
        numCol.setFormat("number:0 | taPrefix: 'bath'");
        numCol.setDescription("Number of bathrooms in house");
        numCol.setSignificantLoss(0.5);
        columns.add(numCol.range(avgScores.getBath_avg(), 99.9).key("number_bathrooms").goal(Column.Goal.MAX).fullName("Number of Bathrooms").objective(true));

        TextColumn textCol = new TextColumn();
        textCol.setDescription("Property Type");
        textCol.setObjective(false);
        columns.add(textCol.key("property type").fullName("Type of property").objective(true));
    }
}
