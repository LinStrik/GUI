package pl.damian.Transform;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin));

        StrToInt strToInt = new StrToInt();

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, strToInt);
        //System.out.println(Arrays.toString(iout));

        Character[] cout = new Character[sin.length];
        transform(sin, cout, new Transform<String, Character>() {
            @Override
            public Character[] apply(String[] in) {

                for (int i = 0; i < in.length ; i++) {

                    cout[i] = in[i].charAt(0);

                }

                return cout;
            }
        });

        String[] sout = new String[sin.length];
        transform(sin, sout,trans->{
            for (int i = 0; i < sout.length; i++) {
                sout[i] = sin[i].toUpperCase();
            }
            return sout;
        });

    }

    public static <T, R> void transform(T[] in, R[] out, Transform<T, R> transform) {

        out = transform.apply(in);

        System.out.println(Arrays.toString(out));

    }

}
