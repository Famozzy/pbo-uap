package pbo.praktikum;

public abstract class BaseBentuk {
    protected double a, b, c;
    protected abstract double getA();
    protected abstract double getB();
    protected abstract double getC();
    protected abstract void setA(double a);
    protected abstract void setB(double b);
    protected abstract void setC();
    protected abstract String cetak();
}
