package pbo.praktikum;

public class BentukLayangLayang extends Bentuk {
    protected void setC() {
        c = 0.5 * a * b;
    }

    protected String cetak() {
        return "Luas Layang-Layang =  1/2 * " + getA() + " * " + getB() + " = " + getC();
    }
}
