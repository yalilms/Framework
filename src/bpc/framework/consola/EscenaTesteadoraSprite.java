package bpc.framework.consola;

public class EscenaTesteadoraSprite extends Escena{
    private GameObject tester;

    public EscenaTesteadoraSprite(GameObject t) {
        this.tester = t;
    }


    public GameObject getTester() {
        return this.tester;
    }

    @Override
    public void añadirObjetosIniciales() {
        this.añadir(this.tester);
    }
}
