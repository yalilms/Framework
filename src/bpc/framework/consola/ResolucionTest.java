package bpc.framework.consola;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class ResolucionTest {

    @Test public void test1(){
        Dimension[] dimensionesEsperadas = {
                new Dimension(4096, 2160),
                new Dimension(1920, 1080),
                new Dimension(2560, 1440),
                new Dimension(800, 600)
        };

        Resolucion[] resoluciones = {
                Resolucion.VENTANA_4K,
                Resolucion.VENTANA_FULLHD,
                Resolucion.VENTANA_QHD,
                Resolucion.VENTANA_VGA
        };

        boolean testPasado = true;
        for (int i = 0; i < resoluciones.length; i++) {
            Dimension resolucionActual = resoluciones[i].getResolucion();
            Dimension esperada = dimensionesEsperadas[i];

            if (resolucionActual.width != esperada.width ||
                    resolucionActual.height != esperada.height) {
                System.out.println("No es la resolucion que debería");
                testPasado = false;
            } else {
                System.out.println("La resolución es correcta");
            }
        }

        Dimension pantallaCompleta = Resolucion.PANTALLA_COMPLETA.getResolucion();
        System.out.println( "Pantalla completa: " + pantallaCompleta.width + "x" + pantallaCompleta.height);

        if (testPasado) {
            System.out.println("Pasa el test");
        } else {
            System.out.println("No pasa el test");
        }
    }
}

