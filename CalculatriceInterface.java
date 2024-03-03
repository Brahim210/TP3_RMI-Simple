import java.rmi.*;

public interface CalculatriceInterface extends Remote {

    public int addition(int a, int b) throws RemoteException;

    public int soustraction(int a, int b) throws RemoteException;

    public int multiplication(int a, int b) throws RemoteException;

    public double division(int a, int b) throws RemoteException;
}