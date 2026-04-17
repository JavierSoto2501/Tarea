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
        while(actual.siguiente != null && actual.siguiente.tiempo < t) {
            actual=actual.siguiente;
        }
        punto.siguiente = actual.siguiente;
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

            if(actual.tiempo == t) {
                anterior.siguiente=actual.siguiente;
                return;
            }

            anterior= actual;
            actual=actual.siguiente;
        }



    }


    public float Distancia(){
        if(this.cabeza==null || this.cabeza.siguiente==null)return 0;
        float distancia=0;
        NodoTrayectoria actual =  this.cabeza;
        NodoTrayectoria siguiente= this.cabeza.siguiente;
        while(siguiente!=null){
            float x1= actual.trayectoria.x;
            float y1= actual.trayectoria.y;

            float x2= siguiente.trayectoria.x;
            float y2= siguiente.trayectoria.y;

            distancia+= (float) Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y2-y1,2));

            actual= actual.siguiente;
            siguiente= actual.siguiente;
        }
        return distancia;
    }
    public boolean Intersectan(MovingObject movingObject){
        if(this.cabeza==null || this.cabeza.siguiente==null || movingObject.cabeza==null || movingObject.cabeza.siguiente == null){
            return false;
        }
        NodoTrayectoria tramoA = this.cabeza;
        while (tramoA.siguiente!= null){
            Trayectoria p1 = tramoA.trayectoria;
            Trayectoria q1 = tramoA.siguiente.trayectoria;
            NodoTrayectoria tramoB = movingObject.cabeza;
            while (tramoB.siguiente!= null){
                Trayectoria p2 = tramoB.trayectoria;
                Trayectoria q2 = tramoB.siguiente.trayectoria;
                int val1 = (q1.y - p1.y) * (p2.x - q1.x) - (q1.x - p1.x) * (p2.y - q1.y);
                int o1 = 0;
                if (val1 == 0) {
                    o1 = 0;
                } else if (val1 > 0) {
                    o1 = 1;
                } else {
                    o1 = 2;
                }
                int val2 = (q1.y - p1.y) * (q2.x - q1.x) - (q1.x - p1.x) * (q2.y - q1.y);
                int o2;
                if (val2 == 0) {
                    o2 = 0;
                } else if (val2 > 0) {
                    o2 = 1;
                } else {
                    o2 = 2;
                }
                int val3 = (q2.y - p2.y) * (p1.x - q2.x) - (q2.x - p2.x) * (p1.y - q2.y);
                int o3;
                if (val3 == 0) {
                    o3 = 0;
                } else if (val3 > 0) {
                    o3 = 1;
                } else {
                    o3 = 2;
                }

                int val4 = (q2.y - p2.y) * (q1.x - q2.x) - (q2.x - p2.x) * (q1.y - q2.y);
                int o4;
                if (val4 == 0) {
                    o4 = 0;
                } else if (val4 > 0) {
                    o4 = 1;
                } else {
                    o4 = 2;
                }

                if(o1 != o2 && o3 != o4){
                    return true;
                }
                tramoB = tramoB.siguiente;

            }
            tramoA = tramoA.siguiente;
        }
        return false;
    }
    public boolean IntersectaRangeST(Trayectoria rEsquina1, Trayectoria rEsquina2, int t1, int t2 ){
       int xMin, xMax, yMin, yMax;

        if(rEsquina1.x<rEsquina2.x){
            xMin= rEsquina1.x;
            xMax= rEsquina2.x;
        }else{
            xMin= rEsquina2.x;
            xMax= rEsquina1.x;
        }
        if(rEsquina1.y<rEsquina2.y){
            yMin= rEsquina1.y;
            yMax= rEsquina2.y;
        }else{
            yMin= rEsquina2.y;
            yMax= rEsquina1.y;
        }

        NodoTrayectoria actual= this.cabeza;
        NodoTrayectoria  siguiente= this.cabeza.siguiente;
        while(siguiente!=null){
            if(siguiente.tiempo>=t1 && actual.tiempo<=t2){
                if(actual.trayectoria.x>= xMin && actual.trayectoria.x<= xMax && actual.trayectoria.y>= yMin && actual.trayectoria.y<= yMax
                || siguiente.trayectoria.x>= xMin && siguiente.trayectoria.x<= xMax && siguiente.trayectoria.y>= yMin && siguiente.trayectoria.y<= yMax){
                    return true;
                }

            }

            actual= actual.siguiente;
            siguiente= actual.siguiente;
        }
        return false;
    }

}