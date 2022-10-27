package es.ull.patrones.graphics;

import es.ull.patrones.data.CSVReader;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MyLineChart extends LinealGraphics {

    DrawLinealGraphics drawGraphics;
    CategoryDataset dataset;
    CSVReader reader;

    public MyLineChart(String tittle, CSVReader reader) {
        super(tittle);
        this.reader = reader;
        setStrategy(new LineDataset());
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
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        String rowKey = "Cases";

        ArrayList<String> dates = reader.getAttributes().get(3).getArrayString();
        ArrayList<Integer> cases = reader.getAttributes().get(4).getArrayInt();

        Set<String> datesWithoutRep = new HashSet<>(dates);

        ArrayList<Integer> totalCases = new ArrayList<>();

        ArrayList<String> datesWithOutRepA = new ArrayList<>(datesWithoutRep);

        // Si las fechas coinciden se acumula en suma el numero de casos
        int suma = 0;
        for(int i = 0; i < datesWithOutRepA.size(); ++i) {
            for (int j = 0; j < dates.size(); ++j) {
                if (datesWithOutRepA.get(i).equals(dates.get(j))) {
                    suma += cases.get(j);
                }
            }
            totalCases.add(suma);
        }

        // Creando Dataset
        for (int i = 0; i < totalCases.size(); ++i) {
            dataset.addValue(totalCases.get(i), rowKey, datesWithOutRepA.get(i));
        }
        this.dataset = dataset;
    }
}
