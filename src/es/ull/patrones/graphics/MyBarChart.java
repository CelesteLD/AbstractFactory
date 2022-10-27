package es.ull.patrones.graphics;

import es.ull.patrones.data.CSVReader;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;

public class MyBarChart extends LinealGraphics {

    DrawLinealGraphics drawGraphics;
    CategoryDataset dataset;
    CSVReader reader;

    public MyBarChart(String title, CSVReader reader) {
        super(title);
        this.reader = reader;
        setStrategy(new BarDataset());
        setDataset();
    }

    @Override
    public CategoryDataset getDataset() {
        return dataset;
    }

    @Override
    public void setStrategy(DrawLinealGraphics dg) {
        this.drawGraphics = dg;
    }

    @Override
    public void showOutput() {
        setContentPane(drawGraphics.show(dataset));
    }

    public void setDataset() {
        final String tf = "Tenerife";
        final String gc = "Gran Canaria";
        final String m = "Madrid";
        final String ba = "Barcelona";

        final String woman = "Womans";
        final String men = "Men";
        final String nc = "NC";

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        /**** AUTOMATIZAR ESTO ****/
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "TF", reader.getAttributes().get(1).getArrayString(), "M", reader.getAttributes().get(4).getArrayInt()), tf, woman);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "GC", reader.getAttributes().get(1).getArrayString(), "M", reader.getAttributes().get(4).getArrayInt()), gc , woman);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "M", reader.getAttributes().get(1).getArrayString(), "M", reader.getAttributes().get(4).getArrayInt()), m , woman);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "BA", reader.getAttributes().get(1).getArrayString(), "M", reader.getAttributes().get(4).getArrayInt()), ba , woman);

        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "TF", reader.getAttributes().get(1).getArrayString(), "H", reader.getAttributes().get(4).getArrayInt()), tf , men);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "GC", reader.getAttributes().get(1).getArrayString(), "H", reader.getAttributes().get(4).getArrayInt()), gc , men);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "M", reader.getAttributes().get(1).getArrayString(), "H", reader.getAttributes().get(4).getArrayInt()), m , men);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "BA", reader.getAttributes().get(1).getArrayString(), "H", reader.getAttributes().get(4).getArrayInt()), ba , men);

        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "TF", reader.getAttributes().get(1).getArrayString(), "NC", reader.getAttributes().get(4).getArrayInt()), tf , nc);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "GC", reader.getAttributes().get(1).getArrayString(), "NC", reader.getAttributes().get(4).getArrayInt()), gc , nc);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "M", reader.getAttributes().get(1).getArrayString(), "NC", reader.getAttributes().get(4).getArrayInt()), m , nc);
        dataset.addValue(numberOfCases(reader.getAttributes().get(0).getArrayString(), "BA", reader.getAttributes().get(1).getArrayString(), "NC", reader.getAttributes().get(4).getArrayInt()), ba , nc);

        this.dataset = dataset;
    }

    public int numberOfCases (ArrayList<String> places, String placeToSearch, ArrayList<String> sexs, String sex, ArrayList<Integer> cases) {
        int sum = 0;
        for (int i = 0;i < places.size(); ++i) {
            if ((places.get(i).equals(placeToSearch)) && (sexs.get(i).equals(sex))) {
                sum = sum + cases.get(i);
            }
        }
        return sum;
    }
}
