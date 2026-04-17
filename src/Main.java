public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS TAREA 1: TDA MovingObject ===\n");

        // 1. Crear los objetos en movimiento
        MovingObject obj1 = new MovingObject(1,null); // El objeto del PDF
        MovingObject obj2 = new MovingObject(2, null); // Un objeto de prueba para chocar
        System.out.println("Objetos instanciados correctamente.");

        // 2. Probar el método Insertar con los datos exactos del PDF
        // Trayectoria s = {<1,(3,2)>, <5,(5,8)>, <7,(10,5)>, <10,(15,6)>}
        obj1.Insertar(1, new Trayectoria(3, 2));
        obj1.Insertar(5, new Trayectoria(5, 8));
        obj1.Insertar(7, new Trayectoria(10, 5));
        obj1.Insertar(10, new Trayectoria(15, 6));
        System.out.println("Trayectoria de obj1 insertada. (Debe mantenerse ordenada por tiempo).");

        // 3. Probar el método Distancia
        System.out.println("\n--- Calculando Distancia ---");
        float dist = obj1.Distancia();
        System.out.println("Distancia total recorrida por obj1: " + dist);

        // 4. Probar el método Intersectan
        System.out.println("\n--- Probando Intersección de Trayectorias ---");
        // Creamos una trayectoria para obj2 que cruce la primera línea de obj1 (de (3,2) a (5,8))
        // Una línea horizontal desde (2,5) hasta (8,5) cruzará el muro formando una 'X'
        obj2.Insertar(2, new Trayectoria(2, 5));
        obj2.Insertar(6, new Trayectoria(8, 5));

        boolean chocan = obj1.Intersectan(obj2);
        System.out.println("¿obj1 y obj2 se intersectan físicamente?: " + chocan); // Debería retornar true

        // 5. Probar el método IntersectaRangeST (Rango Espacio-Temporal)
        System.out.println("\n--- Probando Intersección en Rango (R, T) ---");
        // Usamos el rectángulo R del PDF con esquinas (4,5) y (8,4) [cite: 236]
        Trayectoria rEsquina1 = new Trayectoria(4, 5);
        Trayectoria rEsquina2 = new Trayectoria(8, 4);

        // Prueba A: Intervalo de tiempo [1, 6] donde SÍ intersecta
        boolean enRangoA = obj1.IntersectaRangeST(rEsquina1, rEsquina2, 1, 6);
        System.out.println("¿Intersecta a R en el tiempo [1, 6]?: " + enRangoA + " (Esperado: true)");

        // Prueba B: Intervalo de tiempo [8, 10] donde NO intersecta
        boolean enRangoB = obj1.IntersectaRangeST(rEsquina1, rEsquina2, 8, 10);
        System.out.println("¿Intersecta a R en el tiempo [8, 10]?: " + enRangoB + " (Esperado: false)");

        // 6. Probar el método Eliminar
        System.out.println("\n--- Probando Eliminación ---");
        // Vamos a eliminar el nodo intermedio <5, (5,8)>
        obj1.Eliminar(5, new Trayectoria(5, 8));
        System.out.println("Punto <5, (5,8)> eliminado.");

        // Recalculamos la distancia para confirmar que el puente se hizo correctamente
        float nuevaDist = obj1.Distancia();
        System.out.println("Nueva distancia de obj1 (sin el punto intermedio): " + nuevaDist);
        System.out.println("Si el programa no arroja error y la distancia cambia, el puente funciona.");
    }
}