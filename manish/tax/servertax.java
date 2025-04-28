import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class servertax {
    public static void main(String[] args) {
        try {
            tax taxservant=new taximpl();
             Registry Naming=LocateRegistry.createRegistry(1100);
             Naming.rebind("NamingMethod",taxservant);
             System.out.println("taxcalculator server is ready");
        }catch(Exception e){
          System.err.println("serever exception"+e.toString());
          e.printStackTrace();
        }
    }
}
