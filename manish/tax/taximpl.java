import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class taximpl extends UnicastRemoteObject 
    implements tax{

    public taximpl() throws RemoteException {
        super();
    }

    public double calculateTax(double income) throws RemoteException {
       
        if (income < 300000) {
            return (0);
        } else if (income >= 300001 && income <= 600000) {
            return (income * 0.05);
        } else if (income >= 600001 && income <= 900000) {
            return (income * 0.1);
        } else if (income >= 900001 && income <= 1200000) {
            return (income * 0.15);
        } else if (income >= 1200001 && income <= 1500000) {
            return (income * 0.2);
        }
        else{
            return (income * 0.3);
        }
    }

}
