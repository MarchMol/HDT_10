import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class View {
    public Scanner scan;

    public int menu(){
        int op = 0;
        while (op<1 || op>5){
            System.out.println("Escoga una opción: ");
            System.out.println("1. Calcular ruta");
            System.out.println("2. Centro del Grafo");
            System.out.println("3. Agregar Ruta");
            System.out.println("4. Eliminar Ruta");
            System.out.println("5. Salir");
            scan = new Scanner(System.in);
            try{
                op = scan.nextInt();
            } catch(Exception e){
                System.out.println("Ingrese una opción válida");
            }
        }
        return op;
    }

    public int tiempo(){
        System.out.println("Ingrese el tiempo:");
        System.out.println("1. Normal");
        System.out.println("2. Lluvioso");
        System.out.println("3. Nevado");
        System.out.println("4. Tormentoso");
        return defensivoInt(1, 4);
    }

    public void RetRut(ArrayList<Integer> ruta, HashMap<Integer,String> ciudades){
        String[] tem = new String[0];
        System.out.println("Usted deberá tomar las siguientes paradas: ");
        for(int i = 0;i<ruta.size()-1;i++){
            System.out.println(i+1+". "+ciudades.get(ruta.get(i)));
        }
        System.out.println("El valor de esta ruta es: "+ruta.get(ruta.size()-1));
        System.out.println("");
    }
    public ArrayList<Integer> AskRut(String[] ciudades){
        ArrayList<Integer> ruta = new ArrayList<Integer>();
        int tiempo = 0;
        String[] temp = new String[0];
        System.out.println("Ingrese la ciudad de origen: ");
        for(String st: ciudades){
            temp = st.split(" ");
            System.out.println(temp[1]+". "+temp[0]);
        }
        ruta.add(defensivoInt(1, ciudades.length));
        System.out.println("Ingrese la ciudad de destino: ");
        for(String st: ciudades){
            temp = st.split(" ");
            System.out.println(temp[1]+". "+temp[0]);
        }
        ruta.add(defensivoInt(1, ciudades.length));
        System.out.println("Ingrese el tiempo:");
        System.out.println("1. Normal");
        System.out.println("2. Lluvioso");
        System.out.println("3. Nevado");
        System.out.println("4. Tormentoso");
        ruta.add(defensivoInt(1, 4));
        return ruta;
    }
    public int defensivoInt(int min, int max){
        int op = 0;
        boolean boo = false;
        while (op<min || op>max){
            if(boo){
                System.out.println("Ingrese una opción válida");
            }
            boo = true;
            scan = new Scanner(System.in);
            try{
                op = scan.nextInt();
            } catch(Exception e){
                System.out.println("Ingrese una opción válida");
            }
        }
        return op;
    }
}
