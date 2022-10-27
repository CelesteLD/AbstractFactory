package es.ull.patrones.graphics;

import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

public interface DrawCircleGraphics {
    public ChartPanel show(DefaultPieDataset dataset);
}