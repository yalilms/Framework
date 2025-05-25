package bpc.framework.consola;

import bpc.daw.consola.Consola;
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
        this.sprite = this.consola.getCapaSprites().crearSprite(
                this.imagen,
                this.sprite.getRectangulo(),
                this.puntoInicial.x,
                this.puntoInicial.y
        );
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
        this.sprite.setPosicion(this.sprite.getX() - x, this.sprite.getY());
    }

    public void setY(int y) {
        this.sprite.setPosicion(this.sprite.getX(), this.sprite.getY() - y);
    }

    @Override
    public void finalizar() {
        this.consola.getCapaSprites().eliminarSprite(this.sprite);
    }
}
