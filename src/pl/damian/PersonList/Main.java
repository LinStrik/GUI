package pl.damian.PersonList;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends JFrame {

    ListModel listModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    new Main();
                }
        );
    }

    private void showWarning(String msg) {
        JOptionPane.showMessageDialog(
                this,
                msg,
                "WARNING",
                JOptionPane.WARNING_MESSAGE
        );
    }

    private void showHelp(String msg) {
        JOptionPane.showConfirmDialog(this, msg, "HELP", JOptionPane.PLAIN_MESSAGE);
    }

    private void handleCommand(String text) {
        Pattern p = Pattern.compile("([^ ]+) ?(.*)");
        Matcher m = p.matcher(text);
        if (m.matches()) {
            String command = m.group(1).toLowerCase();
            String argument = m.group(2);

            switch (command) {
                case "add": {
                    if (argument == null) {
                        this.showWarning("PLS specify person");
                    }

                    if (!listModel.add(argument)) {
                        this.showWarning("Entry person\t " + argument.toUpperCase() + "\talready exists");
                    }

                    break;
                }
                case "rm":
                    if (argument == null) {
                        this.showWarning("PLS specify person");
                    }

                    if (!listModel.remove(argument)) {
                        this.showWarning("Entry person \"" + argument + "\" doesn't exist");
                    }

                    break;

                case "quit":
                    System.exit(0);
                    break;

                case "help":
                    this.showHelp("Add new person - ADD \nDelete person - RM  \nIf you close program use - QUIT");
                    break;
                default:
                    this.showWarning("Unknown " + command.toUpperCase() + " Command");
                    break;

            }
        }
    }

    public Main() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        ArrayList<String> test = new ArrayList<>();
        test.add("Gajowy");
        test.add("Trojan");
        this.listModel = new ListModel(test);

        JList<String> list = new JList<>(this.listModel);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.SOUTH);
        this.add(panel);


        this.setPreferredSize(new Dimension(400, 200));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        list.addListSelectionListener(e->{
            String text = textField.getText();
            String chosen = listModel.getElementAt(list.getSelectedIndex());

            this.handleCommand(text + " " + chosen);

           // textField.setText(text + " " + chosen);

           // listModel.addListDataListener(null);

            textField.setText("");
            list.setSelectedIndex(0
            );
        });

        textField.addActionListener(e -> {
            String text = textField.getText();

            this.handleCommand(text);

            textField.setText(null);
        });
    }
}
