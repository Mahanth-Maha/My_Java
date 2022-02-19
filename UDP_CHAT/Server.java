import java.io.*;
import java.net.*;
public class Server {
            public static void main(String[] args) throws Exception
            {
                        DatagramSocket socket=new DatagramSocket(49652);
                        byte receiveByte[]=new byte[1024];
                        byte sendByte[]=new byte[1024];
                        while(true)
                        {
                                    //data receiving
                                    DatagramPacket receivePacket=new DatagramPacket(receiveByte,receiveByte.length);
                                    socket.receive(receivePacket);
                                    String receiveStr=new String(receivePacket.getData());
                                    receiveStr=receiveStr.trim();
                                    System.out.println("Client:"+receiveStr);
                                   
                                    //data sending
                                    DataInputStream din=new DataInputStream(System.in);
                                    System.out.print("Server:");
                                    String sendStr=din.readLine();
                                    sendByte=sendStr.getBytes();
                                    InetAddress ip=receivePacket.getAddress();
                                    int port=receivePacket.getPort();
                                    DatagramPacket sendPacket=new DatagramPacket(sendByte,sendByte.length,ip,port);
                                    socket.send(sendPacket);
                        }
            }

}

   