 
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class siserver {
    public static void main(String[] args) throws Exception{
        try {
            siimplement si =new siimplement();
            Registry Naming=LocateRegistry.createRegistry(1100);
            Naming.rebind("NamingMethod", si);
            System.out.println(" si Server is started");

}   
catch (Exception e) {
    System.err.println(" Server Exception: " + e.toString());
    e.printStackTrace();
    }
    
    }
} 

