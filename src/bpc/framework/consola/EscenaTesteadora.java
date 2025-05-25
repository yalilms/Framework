package bpc.framework.consola;

import bpc.daw.consola.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class EscenaTesteadora extends Escena {
    
    private GameObjectTesteador tester;
    private boolean inicializado;
    private int frameCounter;

    public EscenaTesteadora() {
        super();
        Image imagenTester = crearImagenPlaceholder(50, 50, Color.BLUE);
        this.tester = new GameObjectTesteador(this, imagenTester, 100, 100);
        this.inicializado = false;
        this.frameCounter = 0;
    }

    public void inicializar() {
        this.inicializado = true;
    }

    @Override
    public void añadirObjetosIniciales() {
        if (this.tester != null) {
            this.añadir(this.tester);
        }
    }

    public void ejecutarFrame() {
        if (this.inicializado) {
            this.frameCounter++;

            for (GameObject obj : this.getObjetos()) {
                obj.ejecutarFrame();
            }

            if (this.getConsola() != null) {
                this.getConsola().esperarSiguienteFrame();
            }
        }
    }

    public void finalizar() {
        this.inicializado = false;
    }

    public GameObjectTesteador getTester() {
        return this.tester;
    }

    public int getFrameCounter() {
        return this.frameCounter;
    }

    public boolean estaInicializada() {
        return this.inicializado;
    }

    private static Image crearImagenPlaceholder(int ancho, int alto, Color color) {
        BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, ancho, alto);
        g2d.dispose();
        return img;
    }

    public static void main(String[] args) {
        EscenaTesteadora escena = new EscenaTesteadora();
        escena.inicializar();
        escena.añadirObjetosIniciales();
        
        // Simular un bucle de juego simple (5 segundos a 60 FPS)
        for (int i = 0; i < 300 && escena.estaInicializada(); i++) {
            escena.ejecutarFrame();
            try {
                Thread.sleep(16); // Aproximadamente 60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        escena.finalizar();
        System.out.println("Frames ejecutados: " + escena.getFrameCounter());
    }
}
