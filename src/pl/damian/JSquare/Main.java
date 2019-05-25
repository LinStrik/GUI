package pl.damian.JSquare;

import javax.swing.*;
import java.awt.*;

public class Main  extends JFrame{

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::new);

    }

    public Main(){
        this.setVisible(true);
        this.setPreferredSize(new Dimension(512,256));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0,100,50);

        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);

        JPanel main = new JPanel(new BorderLayout());
        main.add(slider,BorderLayout.SOUTH);

        Panel panel = new Panel(slider);
        main.add(panel,BorderLayout.CENTER);

        slider.addChangeListener((e)-> panel.repaint());

        this.add(main);
        this.pack();

    }
}
