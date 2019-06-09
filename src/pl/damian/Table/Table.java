package pl.damian.Table;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class Table extends AbstractTableModel {

    public List<Person> people;
    public static String[] columnNames = {
            "Imię",
            "Nazwisko",
            "Dzień ur",
            "Ulub. kolor",
            "Wzrost [cm]",
            "Waga [kg]",
            "BMI"
    };

    public Table(List<Person> people) {
        this.people = people;
    }

    @Override
    public int getRowCount() {
        return people.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return this.columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = this.people.get(rowIndex);

        return person;
    }


}
