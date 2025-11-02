package ar.edu.unahur.obj2.observer.estrategia;

import ar.edu.unahur.obj2.observer.EstrategiaException;
import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public class EstrategiaConLimite extends EstrategiaOferta{

    private Double limite;

    public EstrategiaConLimite(Double limite){
        if (limite < 10) {
            throw new EstrategiaException("El límite del valor de oferta no puede ser menor a 10");
        }
        this.limite = limite;
    }

    @Override
    public Oferta crearOfertaEspecifica(Subastador subastador) {
        if (! puedoOfertar(subastador)) {
            throw new EstrategiaException("La oferta superó el límite del subastador");
        }
        return ofertaValida(subastador);
    }

    private boolean puedoOfertar(Subastador subastador) {
        return subastador.getUltimaOfertaRecibida().getValor() < limite;
    }

    private Oferta ofertaValida(Subastador subastador) {
        if (subastador.getUltimaOfertaRecibida().getValor() + 10 < limite){
            return new Oferta(subastador, subastador.getUltimaOfertaRecibida().getValor() + 10);
        } else {
            return new Oferta(subastador, limite);
        }
    }

}
