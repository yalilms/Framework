package bpc.framework.consola;

import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena {
    protected Juego juego;
    protected Consola consola;
    protected List<GameObject> objetos;

    public Escena() {
        this.consola = new Consola();
        this.objetos = new ArrayList<>();
    }

    public abstract void añadirObjetosIniciales();

    public void añadir(GameObject obj) {
        if (obj != null) {
            this.objetos.add(obj);
        }
    }

    public void retirar(GameObject obj) {
        if (obj != null) {
            this.objetos.remove(obj);
        }
    }

    public void ejecutarFrame() {
        for (GameObject obj : this.objetos) {
            obj.ejecutarFrame();
        }
        if (this.consola != null) {
            this.consola.esperarSiguienteFrame();
        }
    }

    public Consola getConsola() {
        return this.consola;
    }

    public List<GameObject> getObjetos() {
        return this.objetos;
    }
}