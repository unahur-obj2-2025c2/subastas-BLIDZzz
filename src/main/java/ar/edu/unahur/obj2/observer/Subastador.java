package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.estrategia.EstrategiaOferta;
import ar.edu.unahur.obj2.observer.estrategia.EstrategiaArriesgada;


public class Subastador extends Observador{

    private EstrategiaOferta estrategia;

    private String nombre;

    // Para ver eje de cambio
    private Oferta ultimaOfertaRecibida;

    public Subastador(String nombre) {
        this.nombre = nombre;
        this.estrategia = new EstrategiaArriesgada();
    }

    public Subastador(String nombre, EstrategiaOferta estrategia) {
        this.nombre = nombre;
        this.estrategia = estrategia;
    }

    public Oferta getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }

    // No por ahora -> luego de descubrir el patrón
    public void actualizar(Oferta oferta){
        this.ultimaOfertaRecibida = oferta;
    }

    public Oferta ofertar() {
        return estrategia.crearOferta(this);
    }

    public String getNombre(){
        return nombre;
    }
}
