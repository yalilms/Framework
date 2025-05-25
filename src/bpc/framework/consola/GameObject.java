package bpc.framework.consola;

import bpc.daw.consola.Consola;

public abstract class GameObject {
    protected Escena escena;
    protected Consola consola;

    public GameObject(Escena escena) {
        this.escena = escena;
        if (escena != null) {
            this.consola = escena.getConsola();
        }
    }

    public abstract void inicializar();
    
    public abstract void ejecutarFrame();
    
    public abstract void finalizar();

    public Escena getEscena() {
        return this.escena;
    }

    public Consola getConsola() {
        return this.consola;
    }
}
