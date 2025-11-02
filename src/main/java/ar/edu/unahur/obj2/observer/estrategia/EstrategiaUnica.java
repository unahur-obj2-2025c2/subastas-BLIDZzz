package ar.edu.unahur.obj2.observer.estrategia;

import ar.edu.unahur.obj2.observer.EstrategiaException;
import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public class EstrategiaUnica extends EstrategiaOferta{

    private Boolean yaOferte = false;

    @Override
    public Oferta crearOfertaEspecifica(Subastador subastador) {
        if (yaOferte) {
            throw new EstrategiaException("El subastador ya hizo su única oferta");
        }
        yaOferte = true;
        return new Oferta(subastador, subastador.getUltimaOfertaRecibida().getValor() + 10);
    }

    public Boolean getYaOferte(){
        return yaOferte;
    }

    @Override
    public Oferta crearOferta(Subastador subastador){
        if (subastador.getUltimaOfertaRecibida() == null) {
            yaOferte = true;
            return new Oferta(subastador, 10);
        } else {
            return crearOfertaEspecifica(subastador);
        }
    };
}
