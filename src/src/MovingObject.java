public class MovingObject {
    private int oid;
    private NodoTrayectoria cabeza;


    public MovingObject(int oid, NodoTrayectoria cabeza) {
        this.oid = oid;
        this.cabeza = null;
    }

    public void Insertar(int t, Trayectoria trayectoria) {

    }

    public void Eliminar(int t, Trayectoria trayectoria) {}
    public float Distancia(){return 0;}
    public boolean Intersectan(MovingObject movingObject){return false;}
    public boolean IntersectaRangeST(Trayectoria rEsquina1, Trayectoria rEsquina2, int t1, int t2 ){return false;}

}
