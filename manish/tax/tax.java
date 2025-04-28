import java.rmi.Remote;
import java.rmi.RemoteException;
public interface tax extends Remote {
 double calculateTax(double income)throws
 RemoteException ;
    
}