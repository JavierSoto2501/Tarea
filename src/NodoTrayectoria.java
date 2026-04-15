public class NodoTrayectoria {
    int tiempo;
    Trayectoria trayectoria;
    NodoTrayectoria siguiente;

    public NodoTrayectoria(int tiempo, Trayectoria trayectoria) {
        this.tiempo = tiempo;
        this.trayectoria = trayectoria;
        this.siguiente = null;
    }
}