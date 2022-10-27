package es.ull.patrones.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PieDataset implements DrawCircleGraphics {
    @Override
    public ChartPanel show(DefaultPieDataset dataset) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Piechart of Cases Per Sex",
                dataset,
                true,
                true, true);

        ChartPanel chartPanel = new ChartPanel( pieChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ));
        return chartPanel;
    }
}
