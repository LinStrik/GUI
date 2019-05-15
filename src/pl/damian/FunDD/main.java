package pl.damian.FunDD;

public class main {

    public static void main(String[] args) {

        Parabola p = new Parabola(1,-1,5/4);
        System.out.println(FunDD.xminim(p,0,1));

        FunDD funDD = new FunDD() {
            @Override
            public double fun(double x) {
                return Math.sqrt(Math.pow(x-0.75,2)+1);
            }
        };
        System.out.println(FunDD.xminim(funDD, 0,2));

        FunDD d = (x)-> (x*x*x)-(2*x*x);

        System.out.println(FunDD.xminim(d,0,2));


    }
}
