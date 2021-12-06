package Networking;

import java.io.IOException;
import java.net.InetAddress;

public class HelloCommand {
    public static void Hello(String ip) throws IOException {
        InetAddress InetAddr = InetAddress.getByName(ip);
        if (InetAddr.isReachable(5000))
            System.out.println("Host is Alive");
        else
            System.out.println("Host is Dead");
    }
}
