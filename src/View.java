import java.util.ArrayList;
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
    public ArrayList<String> CalRut(){
        ArrayList<String> tem = new ArrayList<String>();
        int tiempo = 0;
        System.out.println("Ingrese la ciudad de origen: ");
        tem.add(scan.nextLine());
        System.out.println("Ingrese la ciudad de destino: ");
        tem.add(scan.nextLine());
        System.out.println("Ingrese el tiempo:");
        while(tiempo <1 || tiempo>3) {
            try {
                System.out.println("1. Normal");
                System.out.println("2. Lluvioso");
                System.out.println("3. Nevado");
                tem.add(scan.nextInt() + "");
            } catch (Exception e) {
                System.out.println("Ingrese un tiempo Válido");
            } ;
        }
        return tem;
    }
}
