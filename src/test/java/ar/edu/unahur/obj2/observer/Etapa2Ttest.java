package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Etapa2Ttest {
    
    private ProductoSubastado producto;
    private Subastador gonzager;
    private Subastador martomau;
    private Subastador diasdan;

    @BeforeEach
    public void setUp(){
        producto = new ProductoSubastado("Cuadro de Picaso");
        gonzager = new Subastador("gonzager");
        martomau = new Subastador("martomau");
        diasdan = new Subastador("diasdan");

        producto.registrarSubastador(gonzager);
        producto.registrarSubastador(martomau);
    }

    @Test
    public void productoSubastaConIncrementoYRegistroCorrecto(){
        producto.agregarOferta(martomau.ofertar());
        producto.agregarOferta(gonzager.ofertar());
        producto.agregarOferta(martomau.ofertar());
        assertEquals(3, producto.getOfertas().size());
        assertEquals(3, producto.getUltimaOferta().getValor());
        assertEquals("martour", producto.getUltimaOferta().getSubastador().getNombre());
    }

    @Test
    public void sgdgh(){
        assertThrows(OfertaSubastadorException.class, () -> producto.agregarOferta(diasdan.ofertar()));
    }
}
