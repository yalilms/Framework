package bpc.framework.consola;

public class GameObjectTesteador extends GameObject {
    private String id;
    private boolean inicializado;
    private int frameCounter;

    public GameObjectTesteador(String id) {
        super();
        this.id = id;
        this.inicializado = false;
        this.frameCounter = 0;
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

    public boolean inicializado() {
        return this.inicializado;
    }

    public int frameCounter() {
        return this.frameCounter;
    }
}