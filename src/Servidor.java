
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor
        extends UnicastRemoteObject
        implements InterfazOperaciones {
      String cadena ;
    Servidor() throws java.rmi.RemoteException {
        super();
    }
    
    public static void main(String args[]) {
        try {
            Servidor transformarCadena;
            LocateRegistry.createRegistry(1099);
            transformarCadena = new Servidor();
            Naming.bind("TransformarCadena", transformarCadena);
            System.out.println("El servidor esta listo\n");
            
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void introducirvalor(String arg) {
        cadena = arg;
    }

    @Override
    public String invertir() {
        String cadenaInvertida = "";
       for(int x = cadena.length()-1 ; x >=0 ; x --){
           cadenaInvertida += cadena.charAt(x);
       }
       return cadenaInvertida;
    }

    @Override
    public String aumentarespacios(int num){
        String cadenaconEspacios = "";
        String aux = "";
        for (int j = 0; j < num; j++) {
             aux +=" ";   
            }
        for (int i = 0 ; i < cadena.length() ; i++){
                cadenaconEspacios += cadena.charAt(i) + aux;
        }
        return cadenaconEspacios;
    }

    @Override
    public String aumentar(String cadena) {
        
        return this.cadena + " " + cadena;
            
    }

   

}
