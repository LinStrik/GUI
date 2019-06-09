package pl.damian.Table;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Okieneczko extends JFrame {

    public Okieneczko(List<Person> people) {
        Table myModel = new Table(people);
        JTable table = new JTable(myModel);
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setDefaultRenderer(Object.class, new Render());
        table.setPreferredScrollableViewportSize(new Dimension(480, 70));

        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
