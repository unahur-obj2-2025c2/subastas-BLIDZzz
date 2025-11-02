package ar.edu.unahur.obj2.observer.estrategia;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public abstract class EstrategiaOferta {
    public Oferta crearOferta(Subastador subastador){
        if (subastador.getUltimaOfertaRecibida() == null) {
            return new Oferta(subastador, 10);
        } else {
            return crearOfertaEspecifica(subastador);
        }
    };

    protected abstract Oferta crearOfertaEspecifica(Subastador subastador);
}
