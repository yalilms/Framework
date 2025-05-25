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


    public Juego() {
        this.consola = null;
        this.escena = null;
        this.detener = false;
        this.resolucion = null;
    }


    public void iniciar(Resolucion resolucion, Escena escenaInicial) {
        this.resolucion = resolucion;
        this.consola = new Consola("Juego", resolucion.getResolucion().width, resolucion.getResolucion().height);
        setEscena(escenaInicial);
        this.detener = false;


        while (!this.detener && !this.consola.getTeclado().teclaPulsada(KeyEvent.VK_ESCAPE)) {
            this.consola.esperarSiguienteFrame();
            this.escena.ejecutarFrame();
        }
    }


    public void setEscena(Escena nuevaEscena) {
        this.escena = nuevaEscena;
        this.escena.juego = this;
        this.escena.consola = this.escena.juego.consola;
        this.escena.inicializar();
    }


    public Escena getEscena() {
        return this.escena;
    }


    public void detener() {
        this.detener = true;
    }


    public int getAnchuraPantalla() {
        return this.resolucion.getResolucion().width;
    }


    public int getAlturaPantalla() {
        return this.resolucion.getResolucion().height;
    }
}
