package es.ull.patrones.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class LineDataset implements DrawLinealGraphics {
    @Override
    public ChartPanel show(CategoryDataset dataset) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Linechart of Cases Per Month",
                "Dates",
                "Number Of Cases",
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ));
        return chartPanel;
    }
}
