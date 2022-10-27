package es.ull.patrones.giu;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel() { }

    public MyLabel(String text, int x, int y, int width, int height) {
        setText(text);
        setBounds(x, y, width, height);
        setFont(new Font("Cascadia Code", Font.BOLD, 20));
        setVisible(true);
    }
}