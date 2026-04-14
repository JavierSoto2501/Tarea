public class NodoTrayectoria {
    int i;
    Trayectoria trayectoria;
    NodoTrayectoria siguiente;

    public NodoTrayectoria(int i, Trayectoria trayectoria) {
        this.i = i;
        this.trayectoria = trayectoria;
        this.siguiente = null;
    }
}