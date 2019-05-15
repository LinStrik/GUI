package pl.damian.Offices;

import java.util.*;

public class main {

    public static void main(String[] args) {

        Map<String, LinkedList<Person>> listMap = new HashMap<>();

        String[] arr = {
                "Office A", "John", "Doe",
                "Office B", "Mary", "Em",
                "Office C", "John", "Snow",
                "Office E", "Janusz", "Paprocki",
                "Office E", "Lady", "Stark",
                "Office E", "Lil", "Pump",
                "Office E", "Stephan", "King",
                "Office E", "Arrya", "Stark",
                "Office E", "Sansa", "Stark",
                "Office B", "Rob", "Barethon",
                "Office C", "Pawulon", "Slomkowski",
                "Office PJWSTK", "Krystian", "Trojanowski",
                "Office PJWSTK", "Bartlomiej", "Wedrowniczek"
        };

        for (int i = 0; i < arr.length; i = i + 3) {

            if(!listMap.containsKey(arr[i])){
                listMap.put(arr[i], new LinkedList<>());
                listMap.get(arr[i]).add(new Person(arr[i+1],arr[i+2]));
            }else{
                listMap.get(arr[i]).add(new Person(arr[i+1],arr[i+2]));
            }
        }

        {
            int maxVal = -1;
            String maxKeyName = "";

            for (String a : listMap.keySet()) {

                if(maxVal < listMap.get(a).size()){
                    maxVal = listMap.get(a).size();
                    maxKeyName = a;
                }

                System.out.println(a+": ");
                for (Person p:
                     listMap.get(a)) {
                    System.out.print(p +", ");
                }
                System.out.println();

            }
            System.out.println();
            System.out.println("Najwiecej ludzi jest w " + maxKeyName + ": " + maxVal);

        }

    }
}
