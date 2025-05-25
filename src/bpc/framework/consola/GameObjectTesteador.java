package bpc.framework.consola;

public class GameObjectTesteador extends GameObject{
    private boolean inicializado;
    private int frameCounter;

    public GameObjectTesteador(int id) {
        this.frameCounter = id;
        this.inicializado = false;
    }


    public boolean inicializado() {
        return this.inicializado;
    }

    public int frameCounter() {
        return this.frameCounter;
    }

    @Override
    public void inicializar() {
        this.inicializado = true;
    }

    @Override
    public void ejecutarFrame() {
        this.frameCounter++;
    }

    @Override
    public void finalizar() {
        this.inicializado = false;
    }
}