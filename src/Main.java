public class Main {
    public static View view = new View();
    public static Grafo gr = new Grafo();
    public static void main(String[] args) {
        gr = Reader.Leer();
        boolean boo = true;
        while(boo){
            int op = view.menu();
            switch (op){
                case 1:
                    AlgoritmoFloyd floyd = new AlgoritmoFloyd();
                    floyd.FloydMatriz(gr.grafo,gr.decifrar,0,1,3);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    boo = false;
            }
        }
    }


}