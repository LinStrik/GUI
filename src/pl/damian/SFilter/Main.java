package pl.damian.SFilter;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        String[] arr = {"Alice", "Sue", "Janet", "Bea"};
        LenFilter lenFilter = new LenFilter(3);
        System.out.println(Arrays.toString(filtr(arr, lenFilter)));

        System.out.println(Arrays.toString(filtr(arr, new SFilter() {
            @Override
            public boolean test(String text) {
                return text.toUpperCase().charAt(0) < 'D';
            }
        })));

        System.out.println(Arrays.toString(filtr(arr, text -> text.toUpperCase().charAt(0) > 'H')));



    }

    public static String[] filtr(String[] arr, SFilter filtr) {

        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (filtr.test(arr[i])) {
                stringArrayList.add(arr[i]);
            }
        }

        String[] arrTmp = new String[stringArrayList.size()];

        for (int i = 0; i < arrTmp.length; i++) {
            arrTmp[i] = stringArrayList.get(i);
        }

        return arrTmp;


    }
}
