import java.lang.reflect.Array;
import java.util.ArrayList;
public class AlgoritmoFloyd {
    public int[][] Mpesos;
    public int[][] Mnodos;
    public ArrayList<Integer> Recorrido = new ArrayList<Integer>();

    public void FloydMatriz(ArrayList<Nodo> arr,String[] decifrar, int tiempo, int inicio, int destino){
        int tem;
        Recorrido.add(inicio);
        int size = decifrar.length;
        genMatrices(arr, decifrar, tiempo);
        for(int nod = 0; nod<size;nod++){
            tem = Mnodos[inicio-1][destino-1];
            for(int i = 0; i<size;i++){
                for(int j = 0; j<size;j++){
                    if(i!=j && i!=nod && j!=nod){
                        if((Mpesos[i][nod]+Mpesos[nod][j])<Mpesos[i][j]){
                            Mpesos[i][j]=Mpesos[i][nod]+Mpesos[nod][j];
                            Mnodos[i][j]=nod+1;
                        }
                    }
                }
            }
            if(tem!=Mnodos[inicio-1][destino-1]){
                Recorrido.add(Mnodos[inicio-1][destino-1]);
            }
        }
        printMatrices(size);
        for(Integer i:Recorrido){
            System.out.println(i);
        }
    }

    public void printMatrices(int size){
        String tem = "";
        for(int i = 0; i<size;i++){
            for(int j = 0; j<size;j++){
                tem = tem +Mnodos[i][j]+" ";
            }
            System.out.println(tem);
            tem = "";
        }
        System.out.println("");
        for(int i = 0; i<size;i++){
            for(int j = 0; j<size;j++){
                tem = tem +Mpesos[i][j]+" ";
            }
            System.out.println(tem);
            tem = "";
        }
        System.out.println("-----------");
    }
    public void genMatrices(ArrayList<Nodo> arr,String[] decifrar, int tiempo){
        int size = decifrar.length;
        Mpesos = new int[size][size];
        Mnodos = new int[size][size];
        for(Nodo nod: arr){
            int i = nod.getId();
            int j = nod.getConexion();
            int num = nod.getTiempos()[tiempo];
            Mpesos[i-1][j-1] = num;
        }
        for(int i = 0; i<size;i++){
            for(int j = 0; j<size;j++){
                Mnodos[i][j] = j+1;
                if (Mpesos[i][j] == 0) {
                    Mpesos[i][j] = 100;
                }
                if(i==j){
                    Mpesos[i][j] = 0;
                    Mnodos[i][j] = 0;
                }
            }
        }
    }
}
