package jntua.Networking;

import java.rmi.Naming;

public class Server {
    public static void main(String[] args) throws Exception
    {
        Impl obj = new Impl();
        Naming.rebind("MYCAL", obj);
        System.out.println("Server Started");
    }
}