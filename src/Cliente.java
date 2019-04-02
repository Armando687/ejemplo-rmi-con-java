
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String args[]) {
        InterfazOperaciones transformarCadena;
        String cadena;
        int valor = 0;
        try {
            transformarCadena = (InterfazOperaciones) Naming.lookup("rmi://localhost/TransformarCadena");
            System.out.println("------------ MENU --------------------------");
            System.out.println("Introzuca una cadena : ");
            Scanner entradaS= new Scanner(System.in);
            cadena = entradaS.nextLine();
            transformarCadena.introducirvalor(cadena);
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
            while (!salir) {

                System.out.println("1. Invertir Cadena");
                System.out.println("2. Añadir N espacios");
                System.out.println("3. Añadir texto");
                System.out.println("4. Salir");

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("------------------------------------------");
                        System.out.println(transformarCadena.invertir());
                        System.out.println("------------------------------------------");
                        break;
                    case 2:
                        Scanner snum = new Scanner(System.in);
                        System.out.println("Inserte un numero de espacios a añadir entre letras.");
                        int num = snum.nextInt();
                        System.out.println("------------------------------------------");
                        System.out.println(transformarCadena.aumentarespacios(num));
                        System.out.println("------------------------------------------");
                        break;
                    case 3:
                        Scanner sCadena = new Scanner(System.in);
                        System.out.println("Inserte texto a añadir");
                        String texto = sCadena.nextLine();
                        System.out.println("------------------------------------------");
                        System.out.println(transformarCadena.aumentar(texto));
                        System.out.println("------------------------------------------");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("------------------------------------------");
                        System.out.println("Solo números entre 1 y 4");
                        System.out.println("------------------------------------------");
                }

            }

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.err.println(e.getMessage());
        }
    }

}
