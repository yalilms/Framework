package bpc.framework.consola;

import bpc.daw.consola.Consola;

public abstract class GameObject implements ElementoJuego {
    protected Juego juego;
    protected Consola consola;
    protected Escena escena;

    public GameObject() {
        this.juego = null;
        this.consola = null;
        this.escena = null;
    }

    @Override
    public abstract void inicializar();
    
    @Override
    public abstract void ejecutarFrame();
    
    @Override
    public abstract void finalizar();

    public Escena getEscena() {
        return this.escena;
    }

    public Consola getConsola() {
        return this.consola;
    }
}
