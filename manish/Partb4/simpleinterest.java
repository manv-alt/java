
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface simpleinterest extends Remote {
    public double getIntrest(double principle,int noy,double rate) throws 
    RemoteException;
}
