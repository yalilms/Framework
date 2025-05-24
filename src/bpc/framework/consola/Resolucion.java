package bpc.framework.consola;

import java.awt.Dimension;
import java.awt.Toolkit;

public enum Resolucion {
    PANTALLA_COMPLETA(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())),
    VENTANA_4K(new Dimension(4096, 2160)),
    VENTANA_FULLHD(new Dimension(1920, 1080)),
    VENTANA_QHD(new Dimension(2560, 1440)),
    VENTANA_VGA(new Dimension(800, 600));

    private Dimension resolucion;

    private Resolucion(Dimension resolucion) {
        this.resolucion = resolucion;
    }

    public Dimension getResolucion() {
        return resolucion;
    }
}