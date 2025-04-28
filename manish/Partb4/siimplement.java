 import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.rmi.server.*;
public class siimplement extends UnicastRemoteObject implements simpleinterest {
    siimplement()throws RemoteException{
        super();
    }
    public double getIntrest(double p,int i,double r) throws 
    RemoteException{
        return (p*i*r)/100;
    }
       
}
