
import java.rmi.*;

public interface InterfazOperaciones extends Remote {
    void introducirvalor(String arg) throws RemoteException;
    String invertir() throws RemoteException;
    String aumentarespacios(int num) throws RemoteException;
    String aumentar(String cadena) throws RemoteException;
    
}


