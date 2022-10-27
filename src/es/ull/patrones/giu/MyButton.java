package es.ull.patrones.giu;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String text, int x, int y, int width, int height) {
        setText(text);
        setFont(new Font("Cascadia Code", Font.PLAIN, 15));
        setBounds(x, y, width, height);
        setVisible(true);
    }
}
