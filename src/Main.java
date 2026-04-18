import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

// carga datos iniciales, son los que estan en el pdf de la tarea
        MovingObject obj1 = new MovingObject(1,null);
        MovingObject obj2 = new MovingObject(2, null);

        obj1.Insertar(1, new Trayectoria(3, 2));
        obj1.Insertar(5, new Trayectoria(5, 8));
        obj1.Insertar(7, new Trayectoria(10, 5));
        obj1.Insertar(10, new Trayectoria(15, 6));

        obj2.Insertar(2, new Trayectoria(2, 5));
        obj2.Insertar(6, new Trayectoria(8, 5));

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("------ Prueba Tarea 1 ------");
            System.out.println("1) Insertar posicion");
            System.out.println("2) Eliminar posicion");
            System.out.println("3) Calcular distancia");
            System.out.println("4) Analizar interseccion objeto1 y objeto2");
            System.out.println("5) Analizar interseccion en rango");
            System.out.println("6) Salir");
            System.out.print("Elija una opcion: ");

            opcion = sc.nextInt();


            int id;
            MovingObject o;
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese id del MovingObject (1 o 2)");
                    id = sc.nextInt();
                    if (id == 1) {
                        o = obj1;
                    } else{
                        o = obj2;
                    }

                    System.out.println("-- INSERTAR --");
                    System.out.print("Ingrese el tiempo (t): ");
                    int tInsertar = sc.nextInt();
                    System.out.print("Ingrese la coordenada X: ");
                    int xInsertar = sc.nextInt();
                    System.out.print("Ingrese la coordenada Y: ");
                    int yInsertar = sc.nextInt();

                    o.Insertar(tInsertar, new Trayectoria(xInsertar, yInsertar));
                    break;

                case 2:
                    System.out.println("Ingrese id del MovingObject (1 o 2)");
                    id = sc.nextInt();
                    if (id == 1) {
                        o = obj1;
                    } else{
                        o = obj2;
                    }

                    System.out.println("-- ELIMINAR --");
                    System.out.print("Ingrese el tiempo del punto a borrar: ");
                    int tBorrar = sc.nextInt();


                    o.Eliminar(tBorrar, new Trayectoria(0, 0));
                    System.out.println("Se ejecutó la eliminación.");
                    break;

                case 3:
                    System.out.println("Ingrese id del MovingObject (1 o 2)");
                    id = sc.nextInt();
                    if (id == 1) {
                        o = obj1;
                    } else{
                        o = obj2;
                    }

                    System.out.println("-- DISTANCIA TOTAL --");
                    float dist = o.Distancia();
                    System.out.println("La distancia total recorrida es: " + dist);
                    break;

                case 4:


                    System.out.println("-- INTERSECTAN --");

                    System.out.println("Intersectan: "+ obj1.Intersectan(obj2));
                    break;

                case 5:
                    System.out.println("Ingrese id del MovingObject (1 o 2)");
                    id = sc.nextInt();
                    if (id == 1) {
                        o = obj1;
                    } else{
                        o = obj2;
                    }

                    System.out.println("-- INTERSECTA RANGO --");
                    System.out.println("Ingrese datos de la Esquina 1 (X Y): ");
                    int e1X = sc.nextInt();
                    int e1Y = sc.nextInt();

                    System.out.println("Ingrese datos de la Esquina 2 (X Y): ");
                    int e2X = sc.nextInt();
                    int e2Y = sc.nextInt();

                    System.out.print("Ingrese el tiempo inicial (t1): ");
                    int t1 = sc.nextInt();
                    System.out.print("Ingrese el tiempo final (t2): ");
                    int t2 = sc.nextInt();

                    Trayectoria esq1 = new Trayectoria(e1X, e1Y);
                    Trayectoria esq2 = new Trayectoria(e2X, e2Y);

                    boolean intersecta = o.IntersectaRangeST(esq1, esq2, t1, t2);
                    System.out.println("El objeto intersecta en ese rango en ese tiempo: " + intersecta);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

        sc.close();
    }


}