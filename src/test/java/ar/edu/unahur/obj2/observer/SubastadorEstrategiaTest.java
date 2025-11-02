package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.estrategia.EstrategiaArriesgada;
import ar.edu.unahur.obj2.observer.estrategia.EstrategiaConLimite;
import ar.edu.unahur.obj2.observer.estrategia.EstrategiaUnica;

public class SubastadorEstrategiaTest {

    private ProductoSubastado producto;
    private Subastador arriesgado;
    private Subastador conLimite;
    private Subastador unico;
    EstrategiaUnica estrategiaUnica = new EstrategiaUnica();

    @BeforeEach
    public void setUp(){
        arriesgado = new Subastador("arriesgado", new EstrategiaArriesgada());
        conLimite = new Subastador("arriesgado", new EstrategiaConLimite(50.0));
        unico = new Subastador("arriesgado", estrategiaUnica);

        producto = new ProductoSubastado("Cuadro de Picaso");

        producto.registrarSubastador(arriesgado);
        producto.registrarSubastador(conLimite);
        producto.registrarSubastador(unico);
    }

    @Test
    public void subastadorArriesgadoSiempreSube10(){
        producto.agregarOferta(arriesgado.ofertar());
        Double primerValor = producto.getUltimaOferta().getValor();
        producto.agregarOferta(arriesgado.ofertar());
        assertEquals(primerValor + 10, producto.getUltimaOferta().getValor());
    }

    @Test
    public void subastadorConLimiteNoSuperaElTope(){
        for (int i = 0; i < 5; i++) {
            producto.agregarOferta(conLimite.ofertar());
        }
        assertEquals(50, producto.getUltimaOferta().getValor());
        assertThrows(EstrategiaException.class, () -> producto.agregarOferta(conLimite.ofertar()));
    }

    @Test
    public void subastadorUnicoSoloOfertaUnaVez(){
        producto.agregarOferta(unico.ofertar());
        assertThrows(EstrategiaException.class, () -> producto.agregarOferta(unico.ofertar()));
        assertTrue(estrategiaUnica.getYaOferte());
    }
}
