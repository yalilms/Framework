package bpc.framework.consola;

import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {

    protected Juego juego;
    protected Consola consola;
    private List<GameObject> objetos;

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

    protected abstract void añadirObjetosIniciales();

    public void añadir(GameObject gameObject) {

        gameObject.juego = this.juego;
        gameObject.consola = this.consola;
        gameObject.escena = this;

        this.objetos.add(gameObject);

        gameObject.inicializar();
    }

    public void retirar(GameObject gameObject) {
        gameObject.finalizar();

        this.objetos.remove(gameObject);

        gameObject.consola = null;
        gameObject.escena = null;
    }

    @Override
    public void ejecutarFrame() {
        for (int i = 0; i < this.objetos.size(); i++) {
            this.objetos.get(i).ejecutarFrame();
        }
    }

    @Override
    public void finalizar() {
        List<GameObject> objetosACopiar = new ArrayList<>(this.objetos);

        for (GameObject gameObject : objetosACopiar) {
            retirar(gameObject);
        }
    }
}