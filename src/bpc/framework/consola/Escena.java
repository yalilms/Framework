package bpc.framework.consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {

    protected Juego juego;
    protected ConsolaDAW consola;
    private List<GameObject> objetos;

    public Escena() {
        this.juego = null;
        this.consola = null;
        this.objetos = null;
    }

    @Override
    public void inicializar() {
        // COMENTADO TEMPORALMENTE PARA LOS TESTS
        // if (consola == null || juego == null) {
        //     throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        // }
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
        for (int i = 0; i < objetos.size(); i++) {
            objetos.get(i).ejecutarFrame();
        }
    }

    @Override
    public void finalizar() {
        List<GameObject> objetosACopiar = new ArrayList<>(objetos);

        for (GameObject gameObject : objetosACopiar) {
            retirar(gameObject);
        }
    }
}