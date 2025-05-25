package bpc.framework.consola;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EscenaTest {

    /*
     * IMPORTANTE: Antes de ejecutar estos tests, debes comentar temporalmente
     * la protección en el método inicializar() de la clase Escena:
     */

    @Test
    public void test1(){
        EscenaTesteadora escena = new EscenaTesteadora();
        assertFalse(escena.esInicializado(), "La escena no debería estar inicializada al crearla");
    }

    @Test
    public void test2(){
        EscenaTesteadora escena = new EscenaTesteadora();
        escena.inicializar();
        assertTrue(escena.esInicializado(), "La escena debería estar inicializada después de llamar a inicializar()");
    }

    @Test
    public void test3(){
        EscenaTesteadora escena = new EscenaTesteadora();
        escena.inicializar();

        for (int i = 0; i < 1253; i++) {
            escena.ejecutarFrame();
        }

        GameObjectTesteador tester = escena.getTester();
        assertEquals(1253, tester.frameCounter(), "El frameCounter del GameObjectTesteador debería ser 1253 después de 1253 iteraciones");
    }

    @Test
    public void test4(){
        EscenaTesteadora escena = new EscenaTesteadora();
        escena.inicializar();
        assertTrue(escena.esInicializado(), "La escena debería estar inicializada antes de finalizar");

        escena.finalizar();
        assertFalse(escena.esInicializado(), "La escena no debería estar inicializada después de finalizar");
    }

    /*
     * IMPORTANTE: Después de ejecutar estos tests, vuelve a descomentar
     * la protección en el método inicializar() de la clase Escena
     */
}