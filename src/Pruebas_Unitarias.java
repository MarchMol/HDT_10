import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
public class Pruebas_Unitarias {
    @org.junit.Test
    public void AgregarNodo() {
        Nodo nod1 = new Nodo(1,0,new int[2]); // se crea un nodo sin conexión de id 1
        assertEquals(1, nod1.getId());
        assertEquals(0, nod1.getConexion());

        Nodo nod2 = new Nodo(2,1,new int[2]); // se crea un segundo nodo cnoectando a 1
        assertEquals(2, nod2.getId());
        assertEquals(1, nod2.getConexion());

        Grafo gr = new Grafo(); // se crea el grafo, deberia de estar vacío
        assertEquals(true, gr.grafo.isEmpty());

        gr.grafo.add(nod1); //se agregan ambos nodos
        gr.grafo.add(nod2);
        assertEquals(false, gr.grafo.isEmpty());
        assertEquals(2, gr.grafo.size());
    }
    @org.junit.Test
    public void EliminarNodo() {
        Nodo nod1 = new Nodo(1,0,new int[2]); // se crean 2 nodos
        Nodo nod2 = new Nodo(2,1,new int[2]);
        Grafo gr = new Grafo(); // se crea el grafo
        gr.grafo.add(nod1); //se agregan ambos nodos
        gr.grafo.add(nod2);
        assertEquals(2, gr.grafo.size());
        gr.grafo.remove(nod2); //se elimina el nodo 2
        assertEquals(1, gr.grafo.size());
        gr.grafo.remove(nod1); //se elimina el nodo 1
        assertEquals(true, gr.grafo.isEmpty());
    }
    @org.junit.Test
    public void FloydWarshall() {
        int[] tem = new int[2];
        tem[0] =1;
        tem[1] =2;
        Nodo nod1 = new Nodo(1,2,tem); // se crean 3 nodos en ciclo
        Nodo nod2 = new Nodo(2,3,tem);
        Nodo nod3 = new Nodo(3,1,tem);
        Grafo gr = new Grafo(); // se crea el grafo
        gr.grafo.add(nod1); //se agregan todos los nodos
        gr.grafo.add(nod2);
        gr.grafo.add(nod3);
        AlgoritmoFloyd fl = new AlgoritmoFloyd(); //se calcula con el grafo creado una ruta del nodo 1 al 3
        ArrayList<String> ruta = fl.RutaMasCorta(gr.grafo,3,0,1,3);

        //la ruta guarda el recorrido en los primeros valores y el peso en el último
        //Debería de tener tamaño 4, los nodos 1, 2 y 3 y el peso
        assertEquals(4, ruta.size());

        //El valor de esta ruta debería ser 2 con tiempo 0
        assertEquals(2, ruta.get(ruta.size()-1));
        //El orden de la ruta debería ser 1 - 2- 3, lo que está en las demas posiciones del array
        assertEquals(1, ruta.get(0));
        assertEquals(2, ruta.get(1));
        assertEquals(3, ruta.get(2));

        //al evaluar con el tiempo 1, este debería cambiar a 4
        ruta = fl.RutaMasCorta(gr.grafo,3,1,1,3);
        assertEquals(4, ruta.get(3));
        //El orden de la ruta debería ser 1 - 2- 3, lo que está en las demas posiciones del array
        assertEquals(1, ruta.get(0));
        assertEquals(2, ruta.get(1));
        assertEquals(3, ruta.get(2));

        //si se agrega otra arista conectando a 1 directamente con 3 debería de cambiar la ruta
        int[] tem2 = new int[2];
        tem2[0] = 1;
        tem2[1] = 1;
        Nodo arista = new Nodo(1,3,tem2); //se crea la arista
        gr.grafo.add(arista); // se agrega al grafo

        //El tamaño de la ruta debe ser 3, el nodo 1 y 3 y el peso
        ruta = fl.RutaMasCorta(gr.grafo,3,0,1,3);
        assertEquals(3, ruta.size());

        //La ruta debería de ser de peso 1 con tiempo 0
        assertEquals(1, ruta.get(3));
        //El orden de la ruta debe ser 1 3
        assertEquals(1, ruta.get(0));
        assertEquals(3, ruta.get(1));
    }

}
