import bpc.framework.consola.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.Locale;

public class Programa {
    public static void main(String[] args) {
        try {
            SpriteGameObjectTesteador spriteGameObjectTesteador = new SpriteGameObjectTesteador(
                    ImageIO.read(new File("juan.png")),
                    100,
                    100
            );
            Juego juego = new Juego();
            EscenaTesteadoraSprite escena = new EscenaTesteadoraSprite(spriteGameObjectTesteador);
            juego.iniciar(Resolucion.PANTALLA_COMPLETA, escena);
        } catch (IOException error) {
            System.out.println("Error al cargar la imagen: " + error.getMessage());
        }
    }
}