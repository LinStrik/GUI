package pl.damian.FunDD;

@FunctionalInterface
public interface FunDD {

    double fun(double x);

    static double xminim(FunDD funDD, double a, double b) {

        double minVal = funDD.fun(a);
        double minX = a;

        for (double d = a; d <=b ; d = d + 0.00001) {

           if(minVal > funDD.fun(d)){
               minVal = funDD.fun(d);
               minX = d;
           }



        }


        return minX;
    }

}
