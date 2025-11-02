package ar.edu.unahur.obj2.observer;

public class Oferta {

    private Subastador subastador;
    private double monto;

    public Oferta(Subastador subastador, double monto) {
        this.subastador = subastador;
        this.monto = monto;
    }

    public double getValor() {
        return monto;
    }

    public Subastador getSubastador() {
        return subastador;
    }

}
