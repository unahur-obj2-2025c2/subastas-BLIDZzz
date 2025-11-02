package ar.edu.unahur.obj2.observer.estrategia;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public class EstrategiaArriesgada extends EstrategiaOferta{

    @Override
    public Oferta crearOfertaEspecifica(Subastador subastador) {
        Double valor = 10.0;
        if (subastador.getUltimaOfertaRecibida() != null) {
            valor = subastador.getUltimaOfertaRecibida().getValor() + 10.0;
        }
        return new Oferta(subastador, valor);
    }

}
