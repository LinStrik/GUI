package pl.damian.PersonWithCar;

import java.awt.*;

public class Car {

    private Color color;
    private String marka;

    public Car(String marka, int r, int g, int b){
        this.marka = marka;
        color = new Color(r,g,b);
    }
    public String getMarka(){
        return marka;
    }

    public String toString(){
        return marka;
    }

    public Color getColor(){
        return color;
    }




}
