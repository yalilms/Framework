package bpc.framework.consola;

import bpc.daw.consola.Sprite;
import bpc.daw.consola.Teclado;

import java.awt.*;

public class SpriteGameObjectTesteador extends GameObject {

    private Sprite sprite;

    public SpriteGameObjectTesteador(Image imagen, int x, int y) {
        this.sprite = this.consola.getCapaSprites().crearSprite(
                imagen,
                imagen.getGraphics().getClipBounds(),
                x,
                y
        );
    }


    @Override
    public void inicializar() {

    }

    @Override
    public void ejecutarFrame() {
        Teclado teclado = this.consola.getTeclado();
        switch (teclado.leerCaracter()) {
            case 'w' -> this.sprite.moverY(1);
            case 's' -> this.sprite.moverY(-1);
            case 'a' -> this.sprite.moverX(-1);
            case 'd' -> this.sprite.moverX(1);
        }
    }

    @Override
    public void finalizar() {

    }
}
