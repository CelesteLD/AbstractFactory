package es.ull.patrones.graphics;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;

public abstract class CircleGraphics extends ApplicationFrame {
    DefaultPieDataset dataset;

    public CircleGraphics(String title) {
        super(title);
    }

    public abstract DefaultPieDataset getDataset();


    public abstract void setStrategy(DrawCircleGraphics dg);

    public abstract void showOutput();
}
