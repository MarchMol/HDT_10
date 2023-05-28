import java.util.ArrayList;
public class Main {
    public static View view = new View();
    public static Grafo gr = new Grafo();
    public static AlgoritmoFloyd floyd = new AlgoritmoFloyd();

    public static void main(String[] args) {
        gr = Reader.Leer();
        genHashMap();
        boolean boo = true;
        while (boo) {
            int op = view.menu();
            switch (op) {
                case 1:
                    ArrayList<Integer> datos = view.AskRut(gr.decifrar);
                    ArrayList<Integer> ruta = floyd.RutaMasCorta(gr.grafo, gr.decifrar.length, datos.get(2)-1, datos.get(0), datos.get(1));
                    view.RetRut(ruta,gr.ciudades);
                    break;
                case 2:
                    int[] excen = floyd.centroGrafo(gr.grafo,gr.decifrar.length,view.tiempo()-1);
                    view.centrGrafo(excen[2],excen[0],gr.ciudades);
                    break;
                case 3:
                    gr.grafo.add(view.AddNode(gr.ciudades));
                    break;
                case 4:
                    int index = view.ElimRut(gr.grafo,gr.ciudades);
                    gr.grafo.remove(index-1);
                    break;
                default:
                    boo = false;
            }
        }
    }
    public static void genHashMap(){
        String[] tem = new String[0];
        for(String st: gr.decifrar){
            tem =st.split(" ");
            gr.ciudades.put(Integer.parseInt(tem[1]),tem[0]);
        }
    }

}