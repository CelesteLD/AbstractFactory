package es.ull.patrones.giu;

import es.ull.patrones.data.CSVReader;
import es.ull.patrones.graphics.*;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private MyPanel panel = new MyPanel();
    public MyFrame() {
        CSVReader reader = new CSVReader();
        setSize(780, 600);
        setTitle("P2. Strategy Pattern");
        setLocationRelativeTo(this);
        panel.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().add(panel);
        setLabels();
        setButtons(reader);
    }

    public void setLabels() {
        MyLabel label1 = new MyLabel("Choose one of the options for represent your CSVFile", 100, 10, 600, 50);
        label1.setVisible(true);
        panel.add(label1);

        setLabelsImage("bars.png", 80, 300);
        setLabelsImage("line.png",280, 260);
        setLabelsImage("pastel.png", 500,260);
    }

    private void setLabelsImage(String text, int x, int y) {
        ImageIcon image = new ImageIcon(text);
        MyLabel label2 = new MyLabel();
        label2.setBounds(x, y, 150, 150);
        label2.setIcon(new ImageIcon(image.getImage().getScaledInstance(label2.getWidth(),label2.getHeight(), Image.SCALE_DEFAULT)));
        panel.add(label2);
    }

    public void setButtons(CSVReader reader) {
        MyButton button1 = new MyButton("BarChart", 100, 150, 100, 30);
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinealGraphics graphics = new MyBarChart("BarChart", reader);
                graphics.showOutput();
                graphics.pack();
                RefineryUtilities.centerFrameOnScreen(graphics);
                graphics.setVisible(true);
            }
        };
        button1.addActionListener(listener1);
        panel.add(button1);

        MyButton button2 = new MyButton("LineChart", 300, 150, 100, 30);
        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinealGraphics graphics = new MyLineChart("LineChart", reader);
                graphics.showOutput();
                graphics.pack();
                RefineryUtilities.centerFrameOnScreen(graphics);
                graphics.setVisible(true);
            }
        };
        button2.addActionListener(listener2);
        panel.add(button2);

        MyButton button3 = new MyButton("PieChart", 520, 150, 100,30);
        ActionListener listener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CircleGraphics graphics = new MyPieChart("LineChart", reader);
                graphics.showOutput();
                graphics.pack();
                RefineryUtilities.centerFrameOnScreen(graphics);
                graphics.setVisible(true);
            }
        };
        button3.addActionListener(listener3);
        panel.add(button3);

        MyButton exit = new MyButton("Exit", 600, 500, 100, 30);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        exit.addActionListener(listener);
        panel.add(exit);
    }
}