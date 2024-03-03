import java.rmi.*;
import java.rmi.server.*;

public class CalculatriceServeur extends UnicastRemoteObject implements CalculatriceInterface {

    public CalculatriceServeur() throws RemoteException {
        super();
    }

    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    public int soustraction(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public double division(int a, int b) throws RemoteException {
        if (b != 0)
            return (double) a / b;
        else
            throw new ArithmeticException("Division par zéro.");
    }

    public static void main(String args[]) {
        try {
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
            CalculatriceServeur serveur = new CalculatriceServeur();
            registry.rebind("Calculatrice", serveur);
            System.out.println("Serveur prêt.");
        } catch (Exception e) {
            System.out.println("Erreur: " + e);
        }
    }
}