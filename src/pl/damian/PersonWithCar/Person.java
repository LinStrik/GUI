package pl.damian.PersonWithCar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int yearOfBirth;
    private Car car;
    private boolean haveCar;

    public Person(String name, int yearOfBirth, Car car) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.car = car;
        haveCar = true;
    }

    public Person(String name, int yearOfBirth, String marka, int r, int g, int b) {

        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.car = new Car(marka, r, g, b);
        haveCar = true;

    }

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        haveCar = false;
    }

    public String toString() {
        return name + "\t" + yearOfBirth + " " + (haveCar ? car.getMarka() : "");
    }

    public static List<Car> findAllCars(List<Person> list) {

        ArrayList<Car> tmp = new ArrayList<>();

        for (Person p :
                list) {

            if (p.haveCar) {
                tmp.add(p.car);
            }

        }
        return tmp;
    }

    public static List<Person> findOwners(List<Person> persons, String name) {

        ArrayList<Person> tmp = new ArrayList<>();

        for (Person p :
                persons) {
            if (p.car != null) {
                if (p.car.getMarka().equals(name)) {
                    tmp.add(p);
                }
            }
        }
        return tmp;
    }

    public static Color findColor(List<Person> list, String name, int yearOfBirth) {

        for (Person p :
                list) {

            if (p.name.equals(name) && p.yearOfBirth == yearOfBirth) {
                return p.car.getColor();
            }

        }
        return null;
    }

}
