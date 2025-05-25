package bpc.framework.consola;

import bpc.daw.consola.Sprite;
import bpc.daw.consola.Teclado;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SpriteGameObjectTesteador extends GameObject {

    private Sprite sprite;
    private Image imagen;
    private int inicialX, inicialY;

    public SpriteGameObjectTesteador(Image imagen, int x, int y) {
        this.imagen = imagen;
        this.inicialX = x;
        this.inicialY = y;
        this.sprite = null;
    }

    @Override
    public void inicializar() {
        if (this.consola != null && this.imagen != null) {
            Rectangle rectanguloCompleto = new Rectangle(0, 0,
                    this.imagen.getWidth(null),
                    this.imagen.getHeight(null)
            );

            this.sprite = this.consola.getCapaSprites().crearSprite(
                    this.imagen,
                    rectanguloCompleto,
                    this.inicialX,
                    this.inicialY
            );
        }
    }

    @Override
    public void ejecutarFrame() {
        if (this.consola != null && this.sprite != null) {
            Teclado teclado = this.consola.getTeclado();

            if (teclado.teclaPulsada(KeyEvent.VK_UP)) {
                this.sprite.moverY(-1);
            }
            if (teclado.teclaPulsada(KeyEvent.VK_DOWN)) {
                this.sprite.moverY(1);
            }
            if (teclado.teclaPulsada(KeyEvent.VK_LEFT)) {
                this.sprite.moverX(-1);
            }
            if (teclado.teclaPulsada(KeyEvent.VK_RIGHT)) {
                this.sprite.moverX(1);
            }
        }
    }

    @Override
    public void finalizar() {
        if (this.sprite != null && this.consola != null) {
            this.consola.getCapaSprites().eliminarSprite(this.sprite);
            this.sprite = null;
        }
    }
}