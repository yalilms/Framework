package bpc.framework.consola;

import bpc.daw.consola.*;
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
    public void iniciar(Escena escenaInicial, Resolucion resolucion) {
        // Crear la consola con la resolución especificada
        this.consola = new Consola("Juego", 
            (int)resolucion.getResolucion().getWidth(), 
            (int)resolucion.getResolucion().getHeight());
        
        this.resolucion = resolucion;
        
        // Configurar la escena inicial
        setEscena(escenaInicial);
        
        this.detener = false;
        
        // Bucle principal del juego a 60 FPS
        while (!this.detener) {
            if (this.consola.getTeclado().teclaPulsada(KeyEvent.VK_ESCAPE)) {
                break;
            }
            
            if (this.escena != null) {
                this.escena.ejecutarFrame();
            }
            
            this.consola.esperarSiguienteFrame();
            
            try {
                Thread.sleep(16); // Aproximadamente 60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    // Asigna nueva escena y la inicializa
    public void setEscena(Escena nuevaEscena) {
        if (nuevaEscena != null) {
            this.escena = nuevaEscena;
            this.escena.juego = this;
            this.escena.consola = this.consola;
            this.escena.inicializar();
        }
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
        return this.resolucion != null ? (int)this.resolucion.getResolucion().getWidth() : 0;
    }

    // Devuelve altura actual
    public int getAlturaPantalla() {
        return this.resolucion != null ? (int)this.resolucion.getResolucion().getHeight() : 0;
    }
}
