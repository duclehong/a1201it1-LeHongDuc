package ptb2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PhuongTrinhBacHai {
    private double a;
    private double b;
    private double c;

//    public PhuongTrinhBacHai() {
//    }

    public PhuongTrinhBacHai(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public double getDiscriminant(){
        double d = this.b*this.b - (4 *this.a*this.c);
        return d;
    }
    public double getRoot1(){
        double root1 = (-this.b+ sqrt(this.getDiscriminant()))/(this.a*2);
        return root1;

    }
    public double getRoot2(){
        double root2 = (-this.b- sqrt(this.getDiscriminant()))/(this.a*2);
        return root2;

    }
}
