package bpc.framework.consola;

import bpc.daw.consola.Sprite;

import java.awt.*;

public abstract class SpriteGameObject extends GameObject {
    private Sprite sprite;
    private Image imagen;
    private Point puntoInicial;

    public SpriteGameObject(Image img, int x, int y) {
        this.imagen = img;
        this.puntoInicial = new Point(x, y);
        this.sprite = null;
    }

    @Override
    public void inicializar() {
        throw new UnsupportedOperationException("Metodo por completar");
    }

    public int getX() {
        return this.sprite.getX();
    }

    public int getY() {
        return this.sprite.getY();
    }

    public int getAnchura() {
        return this.imagen.getWidth(null);
    }

    public int getAltura() {
        return this.imagen.getHeight(null);
    }

    public void moverX(int cx) {
        this.sprite.moverX(cx);
    }

    public void moverY(int cy) {
        this.sprite.moverY(cy);
    }

    public void setX(int x) {

    }

    public void setY(int y) {}

    @Override
    public void finalizar() {
        throw new UnsupportedOperationException("Metodo sin terminar");
    }
}
