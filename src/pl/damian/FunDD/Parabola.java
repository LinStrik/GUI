package pl.damian.FunDD;

public class Parabola implements FunDD {

    private int a, b, c;

    Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double fun(double x) {

        return (a*x*x) + (b*x) + c;

    }
}
