package bpc.framework.consola;

import org.junit.Test;

import static org.junit.Assert.*;
public class JuegoTest {

    @Test
    public void test1(){
        try {
            Juego juego = new Juego();
            EscenaTesteadora escena = new EscenaTesteadora();

            Thread hiloJuego = new Thread(() -> {
                juego.iniciar(Resolucion.VENTANA_VGA, escena);
            });

            hiloJuego.start();
            Thread.sleep(2000);
            juego.detener();
            System.out.println("Juego detenido");

            hiloJuego.join(1000);

            int frameCounter = escena.getFrameCounter();
            System.out.println("Contador: " + frameCounter);

            if (frameCounter >= 110 && frameCounter <= 130) {
                System.out.println("Esta en el rango correcto");
                System.out.println("No esta en el rango correcto");
            } else {
                System.out.println("Rango esperado");
                System.out.println("Rango no esperado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


