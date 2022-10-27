package es.ull.patrones.graphics;

import org.jfree.chart.ChartPanel;
import org.jfree.data.category.CategoryDataset;

public interface DrawLinealGraphics {
    public ChartPanel show(CategoryDataset dataset);
}
