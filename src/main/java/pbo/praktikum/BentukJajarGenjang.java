package pbo.praktikum;

public class BentukJajarGenjang extends Bentuk {
    protected void setC() {
        c = a * b;
    }

    protected String cetak() {
        return "Luas Jajar Genjang = " + getA() + " * " + getB() + " = " + getC();
    }
}
