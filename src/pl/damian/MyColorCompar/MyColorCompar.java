package pl.damian.MyColorCompar;

import java.util.Comparator;

public class MyColorCompar implements Comparator<MyColor> {

    ColComponent sortValue;

    public MyColorCompar(ColComponent sortValue) {
        this.sortValue = sortValue;
    }

    @Override
    public int compare(MyColor o1, MyColor o2) {
        if (sortValue.equals(ColComponent.BLUE)) {
            return o1.getBlue() - o2.getBlue();
        } else if (sortValue.equals(ColComponent.RED)) {
            return o1.getRed() - o2.getRed();
        } else {
            return o1.getGreen() - o2.getGreen();
        }
    }
}
