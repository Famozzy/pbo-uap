package pbo.praktikum;

public class BentukBelahKetupat extends Bentuk {
    protected void setC() {
        c = 0.5 * a * b;
    }

    protected String cetak() {
        return "Luas Belah Ketupat = 1/2 * " + getA() + " * " + getB() + " = " + getC();
    }
}
