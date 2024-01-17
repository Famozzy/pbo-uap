package pbo.praktikum;

public class BentukSegitiga extends Bentuk {
    protected void setC() {
        c = 0.5 * a * b;
    }

    protected String cetak() {
        return "Luas Segitiga = 1/2 * " + getA() + " * " + getB() + " = " + getC();
    }
}
