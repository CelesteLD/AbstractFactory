package es.ull.patrones.graphics;

import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

public abstract class LinealGraphics extends ApplicationFrame {
    CategoryDataset dataset;


    public LinealGraphics(String title) {
        super(title);
    }

    public abstract CategoryDataset getDataset();


    public abstract void setStrategy(DrawLinealGraphics dg);

    public abstract void showOutput();
}
