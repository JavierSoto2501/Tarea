public class MovingObject {
    private int oid;
    private NodoTrayectoria cabeza;


    public MovingObject(int oid, NodoTrayectoria cabeza) {
        this.oid = oid;
        this.cabeza = null;
    }

    public void Insertar(int t, Trayectoria trayectoria) {
        NodoTrayectoria punto = new NodoTrayectoria(t, trayectoria);
        if(this.cabeza == null || t< this.cabeza.tiempo) {
            punto.siguiente = this.cabeza;
            this.cabeza = punto;
            return;
        }

        NodoTrayectoria actual = this.cabeza;
        while(actual != null && actual.siguiente.tiempo < t) {
            actual=actual.siguiente;
        }
        punto.siguiente = actual;
        actual.siguiente=punto;
    }

    public void Eliminar(int t, Trayectoria trayectoria) {
        if(this.cabeza == null) {
            return;
        }else{
            if(this.cabeza.tiempo == t) {
                this.cabeza = cabeza.siguiente;
                return;
            }
        }

        NodoTrayectoria anterior= this.cabeza;
        NodoTrayectoria actual = cabeza.siguiente;
        while(actual != null) {

            if(actual.siguiente.tiempo == t) {
                anterior.siguiente=actual.siguiente;
                return;
            }

            anterior= actual;
            actual=actual.siguiente;
        }



    }


    public float Distancia(){return 0;}
    public boolean Intersectan(MovingObject movingObject){return false;}
    public boolean IntersectaRangeST(Trayectoria rEsquina1, Trayectoria rEsquina2, int t1, int t2 ){return false;}

}