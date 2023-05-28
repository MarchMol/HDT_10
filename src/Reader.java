import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static Grafo gr = new Grafo();

    public static Grafo Leer() {
        boolean boo = true;
        String[] tem;
        String[] ciudades = new String[0];
        Nodo temNodo;
        int id = 0;
        int conection = 0;
        ArrayList<Nodo> rslt = new ArrayList<Nodo>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/logistica.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (boo) {
                    ciudades = line.split(",");
                    gr.decifrar = ciudades;
                    boo = false;
                    for(String st: ciudades){
                        System.out.println(st);
                    }
                } else {
                    int[] tiempos = new int[4];
                    System.out.println("Resultado: " + line);
                    tem = line.split(" ");
                    tiempos[0] = Integer.parseInt(tem[2]);
                    tiempos[1] = Integer.parseInt(tem[3]);
                    tiempos[2] = Integer.parseInt(tem[4]);
                    tiempos[3] = Integer.parseInt(tem[5]);
                    for (int i = 0; i < ciudades.length; i++) {
                        if (ciudades[i].split(" ")[0].equals(tem[0])) {
                            id = Integer.parseInt(ciudades[i].split(" ")[1]);
                        }
                    }
                    for (int i = 0; i < ciudades.length; i++) {
                        if (ciudades[i].split(" ")[0].equals(tem[1])) {
                            conection = Integer.parseInt(ciudades[i].split(" ")[1]);
                        }
                    }
                    temNodo = new Nodo(id, conection, tiempos);
                    rslt.add(temNodo);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gr.grafo = rslt;
        return gr;
    }
}
