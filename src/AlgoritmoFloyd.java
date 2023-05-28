import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlgoritmoFloyd {
    public int[][] Mpesos;
    public int[][] Mnodos;
    public ArrayList<Integer> Recorrido;

    public int[] centroGrafo(ArrayList<Nodo> arr, String[] decifrar, int tiempo){
        genMatrices(arr, decifrar, tiempo);
        int size = decifrar.length;
        int excen[] = new int[3];
        int MinExcen = 0;
        int nod = 0;
        excen[0]=10000;
        for(int j = 0;j<size;j++){
            for(int i = 0;i<size;i++){
                if(excen[1]<Mpesos[i][j]){
                    excen[1] = Mpesos[i][j];
                }
            }
            if(excen[1]<excen[0]){
                excen[0]=excen[1];
                excen[3]=j+1;
            }
        }
        return excen;
    }
    public ArrayList<Integer> RutaMasCorta(ArrayList<Nodo> arr, String[] decifrar, int tiempo, int inicio, int destino) {
        Recorrido  = new ArrayList<Integer>();
        int tem;
        int size = decifrar.length;
        genMatrices(arr, decifrar, tiempo);
        for (int nod = 0; nod < size; nod++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i != j && i != nod && j != nod) {
                        if ((Mpesos[i][nod] + Mpesos[nod][j]) < Mpesos[i][j]) {
                            Mpesos[i][j] = Mpesos[i][nod] + Mpesos[nod][j];
                            Mnodos[i][j] = nod + 1;
                        }
                    }
                }
            }
        }
        printMatrices(size);
        rec(inicio-1,destino-1);
        Recorrido.add(destino);
        Recorrido.add(Mpesos[inicio-1][destino-1]);
        return Recorrido;
    }

    public void rec(int inicio, int destino){
        Recorrido.add(inicio + 1);
        if(Mnodos[inicio][destino]-1 != destino && Mnodos[inicio][Mnodos[inicio][destino]-1] == Mnodos[inicio][destino]){
            rec(Mnodos[inicio][destino]-1,destino);
        } else if(Mnodos[inicio][destino]-1 != destino && Mnodos[inicio][Mnodos[inicio][destino]-1] != Mnodos[inicio][destino]){
            rec(Mnodos[inicio][Mnodos[inicio][destino]-1]-1,destino);
        }
    }

    public void printMatrices(int size) {
        String tem = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tem = tem + Mnodos[i][j] + " ";
            }
            System.out.println(tem);
            tem = "";
        }
        System.out.println("");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tem = tem + Mpesos[i][j] + " ";
            }
            System.out.println(tem);
            tem = "";
        }
        System.out.println("-----------");
    }

    public void genMatrices(ArrayList<Nodo> arr, String[] decifrar, int tiempo) {
        int size = decifrar.length;
        Mpesos = new int[size][size];
        Mnodos = new int[size][size];
        for (Nodo nod : arr) {
            int i = nod.getId();
            int j = nod.getConexion();
            int num = nod.getTiempos()[tiempo];
            Mpesos[i - 1][j - 1] = num;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Mnodos[i][j] = j + 1;
                if (Mpesos[i][j] == 0) {
                    Mpesos[i][j] = 1000;
                }
                if (i == j) {
                    Mpesos[i][j] = 0;
                    Mnodos[i][j] = 0;
                }
            }
        }
    }
}
