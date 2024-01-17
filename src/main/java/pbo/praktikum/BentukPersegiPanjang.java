package pbo.praktikum;

public class BentukPersegiPanjang extends Bentuk {

    protected void setC() {
        c = a * b;
    }

    protected String cetak() {
        return "Luas Persegi Panjang = " + getA() + " * " + getB() + " = " + getC();
    }
}
