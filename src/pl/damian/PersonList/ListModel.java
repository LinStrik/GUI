package pl.damian.PersonList;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

public class ListModel extends AbstractListModel<String> {

    ArrayList<String> list;

    public ListModel(ArrayList<String> list) {
        this.list = list;
        this.fireIntervalAdded(this, 0, this.getSize());
    }

    public ListModel() {
        this.list = new ArrayList<>();
    }

    public boolean add(String s) {
        if (this.list.contains(s)) {
            return false;
        }

        boolean added = this.list.add(s);
        this.fireIntervalAdded(this, 0, this.getSize());
        return added;
    }

    public boolean remove(String stringToRemove) {
        boolean removed = this.list.removeIf(s -> s.equals(stringToRemove));
        if (removed) {
            this.fireIntervalRemoved(this, 0, this.getSize());
        }

        return removed;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.list.get(index);
    }



}
