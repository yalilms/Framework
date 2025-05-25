package bpc.framework.consola;

import bpc.daw.consola.Consola;
import bpc.framework.consola.Escena;
import bpc.framework.consola.Resolucion;

import java.awt.event.KeyEvent;

public class Juego {
    private Consola consola;
    private Escena escena;
    private boolean detener;
    private Resolucion resolucion;

    // Constructor: deja todo a valores por defecto
    public Juego() {
        this.consola = null;
        this.escena = null;
        this.detener = false;
        this.resolucion = null;
    }

    // Inicia el juego con una resolución y una escena
    public void iniciar(Resolucion resolucion, Escena escenaInicial) {
        this.resolucion = resolucion;
        this.consola = new Consola("Juego", resolucion.getResolucion().width, resolucion.getResolucion().height);
        setEscena(escenaInicial);
        this.detener = false;

        // Bucle principal de juego a 60FPS
        while (!detener && !consola.getTeclado().teclaPulsada(KeyEvent.VK_ESCAPE)) {
            consola.esperarSiguienteFrame(); // sincroniza con el siguiente frame
            escena.ejecutarFrame();
        }
    }

    // Asigna nueva escena y la inicializa
    public void setEscena(Escena nuevaEscena) {
        this.escena = nuevaEscena;
        this.escena.juego = this;
        this.escena.consola = this.escena.juego.consola;
        this.escena.inicializar();
    }

    // Devuelve la escena activa
    public Escena getEscena() {
        return this.escena;
    }

    // Detiene el juego
    public void detener() {
        this.detener = true;
    }

    // Devuelve anchura actual
    public int getAnchuraPantalla() {
        return this.resolucion.getResolucion().width;
    }

    // Devuelve altura actual
    public int getAlturaPantalla() {
        return this.resolucion.getResolucion().height;
    }
}
