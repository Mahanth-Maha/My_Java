package Networking;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	public int add(int x, int y) throws RemoteException;
	public int sub(int x, int y) throws RemoteException;
	public int mul(int x, int y) throws RemoteException;
	public int div(int x, int y) throws RemoteException;
	public int mod(int x, int y) throws RemoteException;
	public int pow(int x, int y) throws RemoteException;
}
