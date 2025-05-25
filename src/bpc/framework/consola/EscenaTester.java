package bpc.framework.consola;


public class EscenaTester extends Escena {
    private GameObject tester;

    public EscenaTester(GameObject t) {
        super();
        this.tester = t;
    }

    @Override
    public void añadirObjetosIniciales() {
        if (this.tester != null) {
            this.añadir(this.tester);
        }
    }

    public GameObject getTester() {
        return this.tester;
    }
}