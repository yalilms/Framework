package bpc.framework.consola;

public interface ElementoJuego {

    /*
     Este método se encargará de realizar las tareas necesarias para poner
     un objeto del juego en marcha, una vez que ha sido añadido a una escena de un
     juego.
     */
    void inicializar();

    /*
     Este método es el núcleo de todo el sistema. Este método es
     llamado en cada frame y en él se programará el comportamiento del elemento del
     juego en ese frame. Para que el juego no vaya lento es muy importante programar
     este método lo más eficiente posible.
     */
    void ejecutarFrame();

    /*
     Este método se encarga de realizar las tareas necesarias para eliminar un
     objeto del juego, justo antes de que sea retirado de la escena.
     */
    void finalizar();
}
