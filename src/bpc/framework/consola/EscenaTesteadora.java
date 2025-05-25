package bpc.framework.consola;

public class EscenaTesteadora extends Escena {
    private GameObjectTesteador tester;
    private boolean inicializado;
    private int frameCounter;

    public EscenaTesteadora() {
        super();
        this.tester = new GameObjectTesteador("tester");
        this.inicializado = false;
        this.frameCounter = 0;
    }

    @Override
    public void inicializar() {
        super.inicializar();
        this.inicializado = true;
    }

    @Override
    public void añadirObjetosIniciales() {
        if (this.tester != null) {
            this.añadir(this.tester);
        }
    }

    @Override
    public void ejecutarFrame() {
        super.ejecutarFrame();
        this.frameCounter++;
    }

    @Override
    public void finalizar() {
        super.finalizar();
        this.inicializado = false;
    }

    public GameObjectTesteador getTester() {
        return this.tester;
    }

    public int getFrameCounter() {
        return this.frameCounter;
    }

    public boolean esInicializado() {
        return this.inicializado;
    }
}