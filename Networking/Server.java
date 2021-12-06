package Networking;
import java.rmi.*;
import java.rmi.registry.*;

public class Server {
	public static void main(String[] args) throws Exception
	{
		Impl obj = new Impl();
		Naming.rebind("ADD", obj);
		System.out.println("Server Started");
	}
}
