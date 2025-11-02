package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.List;

public class ProductoSubastado {

    List<Observador> observadores;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    private List<Oferta> ofertas;

    public ProductoSubastado(String nombre) {
        this.nombre = nombre;
        observadores = new ArrayList<Observador>();
        ofertas = new ArrayList<Oferta>();
    }

    public void registrarSubastador(Observador subastador) {
        observadores.add(subastador);
    }

    public void agregarOferta(Oferta oferta) {
        if (!this.observadores.contains(oferta.getSubastador())) {
            throw new OfertaSubastadorException("El subastadaor no participa en la subasta");
        }
        ofertas.add(oferta);
        notificarObservadores(oferta);
    }

    private void notificarObservadores(Oferta oferta){
        observadores.forEach(s -> s.actualizar(oferta));
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public Oferta getUltimaOferta() {
        if (ofertas.isEmpty()) return null;
        return ofertas.get(ofertas.size() - 1);
    }

}
