package bpc.framework.consola;

import bpc.daw.consola.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class GameObjectTesteador extends GameObject {
    private Sprite sprite;
    private boolean inicializado;
    private int frameCounter;
    private static final int VELOCIDAD = 5;

    public GameObjectTesteador(Escena escena, Image imagen, int x, int y) {
        super(escena);
        
        if (imagen == null) {
            throw new IllegalArgumentException("La imagen no puede ser null");
        }
        
        // Crear el rectángulo que define el área visible del sprite
        Rectangle rect = new Rectangle(0, 0, imagen.getWidth(null), imagen.getHeight(null));
        
        // Crear el sprite en la capa de sprites de la consola
        if (this.consola != null) {
            this.sprite = this.consola.getCapaSprites().crearSprite(imagen, rect, x, y);
        }
        
        this.inicializado = false;
        this.frameCounter = 0;
    }

    @Override
    public void inicializar() {
        this.inicializado = true;
    }

    @Override
    public void ejecutarFrame() {
        if (!this.inicializado || this.consola == null || this.sprite == null) {
            return;
        }

        this.frameCounter++;
        
        Teclado teclado = this.consola.getTeclado();
        
        // Mover el sprite según las teclas presionadas
        if (teclado.teclaPulsada(KeyEvent.VK_UP)) {
            this.sprite.moverY(-VELOCIDAD);
        }
        if (teclado.teclaPulsada(KeyEvent.VK_DOWN)) {
            this.sprite.moverY(VELOCIDAD);
        }
        if (teclado.teclaPulsada(KeyEvent.VK_LEFT)) {
            this.sprite.moverX(-VELOCIDAD);
        }
        if (teclado.teclaPulsada(KeyEvent.VK_RIGHT)) {
            this.sprite.moverX(VELOCIDAD);
        }
    }

    @Override
    public void finalizar() {
        this.inicializado = false;
        if (this.sprite != null && this.consola != null) {
            this.consola.getCapaSprites().eliminarSprite(this.sprite);
            this.sprite = null;
        }
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public boolean estaInicializado() {
        return this.inicializado;
    }

    public int getFrameCounter() {
        return this.frameCounter;
    }
}
