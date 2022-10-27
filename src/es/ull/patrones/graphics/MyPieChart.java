package es.ull.patrones.graphics;

import es.ull.patrones.data.CSVReader;
import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList;

public class MyPieChart extends CircleGraphics {

    DefaultPieDataset dataset;
    DrawCircleGraphics drawGraphics;
    CSVReader reader;

    public MyPieChart(String title, CSVReader reader) {
        super(title);
        this.reader = reader;
        setStrategy(new PieDataset());
        setDataset();
    }

    @Override
    public DefaultPieDataset getDataset() {
        return dataset;
    }

    @Override
    public void setStrategy(DrawCircleGraphics dg) {
        this.drawGraphics = dg;
    }

    @Override
    public void showOutput() {
        setContentPane(drawGraphics.show(dataset));
    }

    public void setDataset() {

        final DefaultPieDataset dataset =
                new DefaultPieDataset( );

        ArrayList<Integer> cases = reader.getAttributes().get(4).getArrayInt();
        ArrayList<String> sexs = reader.getAttributes().get(1).getArrayString();

        int numberWoman = numberOfCases(sexs, "M", cases);
        int numberMen = numberOfCases(sexs, "H", cases);
        int numberNC = numberOfCases(sexs, "NC", cases);

        dataset.setValue("Womans", numberWoman);
        dataset.setValue("Mens", numberMen);
        dataset.setValue("NC", numberNC);

        this.dataset = dataset;
    }

    public int numberOfCases (ArrayList<String> sexs, String sex, ArrayList<Integer> cases) {
        int sum = 0;
        for (int i = 0;i < sexs.size(); ++i) {
            if (sexs.get(i).equals(sex)) {
                sum = sum + cases.get(i);
            }
        }
        return sum;
    }
}