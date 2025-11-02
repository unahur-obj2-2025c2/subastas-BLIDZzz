package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Etapa1Test {
    @Test
    public void subastadorRecibeLaOferta(){
        ProductoSubastado producto = new ProductoSubastado("Cuadro de Picasso");
        Subastador gonzager = new Subastador("gonzager");

        producto.registrarSubastador(gonzager);

        producto.agregarOferta(new Oferta(gonzager, 10.0));

        assertEquals(10.0, gonzager.getUltimaOfertaRecibida().getValor(), 0.01);
    }

    @Test
    public void subastadorRecibeUltimaOferta(){
        ProductoSubastado p = new ProductoSubastado("Cuadro de Picasso");
        
        // 2 Subastadores
        Subastador s1 = new Subastador("s1");
        Subastador s2 = new Subastador("s2");

        // Los resgistramos
        p.registrarSubastador(s1);
        p.registrarSubastador(s2);

        // Agregar 3 ofertas (1ero, 2do, 1ero)
        p.agregarOferta(new Oferta(s1, 10));
        p.agregarOferta(new Oferta(s2, s2.getUltimaOfertaRecibida().getValor() + 10));
        p.agregarOferta(new Oferta(s1, s1.getUltimaOfertaRecibida().getValor() + 10));

        // Asertar que los 2 subastadores tienen como última oferta recibida un valor de 30
        assertEquals(30.0, s1.getUltimaOfertaRecibida().getValor(), 0.01);
        assertEquals(30.0, s2.getUltimaOfertaRecibida().getValor(), 0.01);
    }
}
