package pl.damian.MyColorCompar;

import java.awt.*;

public class MyColor extends Color implements Comparable<MyColor> {


    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public String toString() {
        return "(" + getRed() + "," + getGreen() + "," + getBlue() + ")";
    }

    @Override
    public int compareTo(MyColor o) {
        return (this.getGreen() + this.getRed() + this.getBlue()) - (o.getRed() + o.getBlue() + o.getGreen());
    }
}
