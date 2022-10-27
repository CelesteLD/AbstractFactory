package es.ull.patrones.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class BarDataset implements DrawLinealGraphics {
    @Override
    public ChartPanel show(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Barchart of number of cases in TF and GC",
                "Places",
                "Number of cases",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );

        return chartPanel;
    }
}
