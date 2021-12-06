package Networking;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Timestamp;

public class EchoCommand {
    public static void Echo(String ip) throws IOException {
        boolean flag = false;
        long min = 5000, max = 0, avg = 0;
        InetAddress InetAddr = InetAddress.getByName(ip);
        for (int i = 0; i < 5; i++) {
            Timestamp T1 = new Timestamp(System.currentTimeMillis());
            flag = InetAddr.isReachable(5000);
            Timestamp T2 = new Timestamp(System.currentTimeMillis());
            long diff = T2.getTime() - T1.getTime();
            avg += diff;
            if (diff < min) min = diff;
            if (diff > max) max = diff;
        }
        avg = avg / 5;
        if (flag)
            System.out.println("Approximate round trip times in milli-seconds: \n\tMinimum = " + min + "ms, Maximum = " + max + "ms, Average = " + avg + "ms");
        else
            System.out.println("Host Unreachable");
    }
}
