import bpc.framework.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Programa {
    public static void main(String[] args) {
        try {
            SpriteGameObjectTesteador spriteGameObjectTesteador = new SpriteGameObjectTesteador(
                    ImageIO.read(new File("clasesProyecto.png")),
                    100,
                    100
            );
            Juego juego = new Juego();
            juego.setEscena(new EscenaTesteadoraSprite(spriteGameObjectTesteador));
            juego.iniciar(Resolucion.PANTALLA_COMPLETA, juego.getEscena());
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

    }
}
