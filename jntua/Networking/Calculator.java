package jntua.Networking;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public double addi(double x, double y) throws RemoteException;
    public double sub(double x, double y) throws RemoteException;
    public double mul(double x, double y) throws RemoteException;
    public int div(int x, int y) throws RemoteException;
    public int mod(int x, int y) throws RemoteException;
    public int pow(int x, int y) throws RemoteException;
    public double sqr(double x) throws RemoteException;
}