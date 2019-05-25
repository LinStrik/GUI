package pl.damian.JSquare;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private JSlider slider;

    public Panel(JSlider slider) {
        this.slider = slider;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        float value = (float) slider.getValue() / 100;

        g.setColor(Color.BLUE);

        int s = (int) Math.min(getHeight(), getHeight() * value);
        g.fillRect(getWidth() / 2 - s / 2, getHeight() / 2 - s / 2, s, s);
    }


}
