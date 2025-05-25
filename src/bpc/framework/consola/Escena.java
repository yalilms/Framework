package bpc.framework.consola;

import bpc.daw.consola.Consola;
import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {
    protected Juego juego;
    protected Consola consola;
    protected List<GameObject> objetos;

    public Escena() {
        this.juego = null;
        this.consola = null;
        this.objetos = null;
    }

    @Override
    public void inicializar() {
        if (this.consola == null || this.juego == null) {
            throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        }
        this.objetos = new ArrayList<>();
        añadirObjetosIniciales();
    }

    public abstract void añadirObjetosIniciales();

    public void añadir(GameObject obj) {
        if (obj != null) {
            obj.juego = this.juego;
            obj.consola = this.consola;
            obj.escena = this;
            obj.inicializar();
            this.objetos.add(obj);
        }
    }

    public void retirar(GameObject obj) {
        if (obj != null) {
            obj.finalizar();
            this.objetos.remove(obj);
            obj.consola = null;
            obj.escena = null;
        }
    }

    @Override
    public void ejecutarFrame() {
        for (int i = 0; i < this.objetos.size(); i++) {
            this.objetos.get(i).ejecutarFrame();
        }
    }

    @Override
    public void finalizar() {
        while (!this.objetos.isEmpty()) {
            retirar(this.objetos.get(0));
        }
    }

    public Consola getConsola() {
        return this.consola;
    }

    public List<GameObject> getObjetos() {
        return this.objetos;
    }
}