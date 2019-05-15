package pl.damian.PersonWithCar;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class main {

    public static void main(String[] args) {


        ArrayList<Person> personArrayList = new ArrayList<>();

        FileReader fr;
        BufferedReader br;
        String line;

        try {
            fr = new FileReader("data.txt");
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {

                String[] tmp = line.split("\\s");


                if (tmp.length == 2) {
                    personArrayList.add(new Person(tmp[0], Integer.decode(tmp[1])));
                }
                if (tmp.length == 6) {
                    personArrayList.add(new Person(
                            tmp[0],
                            Integer.decode(tmp[1]),
                            tmp[2],
                            Integer.decode(tmp[3]),
                            Integer.decode(tmp[4]),
                            Integer.decode(tmp[5]))
                    );
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Car c :
                Person.findAllCars(personArrayList)) {
            System.out.println(c);
        }


        for (Person c :
                Person.findOwners(personArrayList, "Mercedes")) {

            System.out.println(c);

        }

        System.out.println(Person.findColor(personArrayList, "Krystian", 1998));


    }

}
