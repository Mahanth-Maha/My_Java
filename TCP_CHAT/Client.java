import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client
{
            public static void main(String[] args) throws Exception
            {
                        Socket s=new Socket("127.0.0.1",60057);
                        if(s.isConnected())
                        {
                                    System.out.println("Connected to server");
                        }
                        DataInputStream msg=new DataInputStream(System.in);
                        String str="Start Chat......";
                        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                        dout.writeUTF(str);
                        System.out.println(str);
                        DataInputStream din=new DataInputStream(s.getInputStream());
                        while(!str.equalsIgnoreCase("exit"))
                        {
                                    System.out.print("Client:\t");
                                    str=msg.readLine();
                                    dout.writeUTF(str+"\n");
                                    str=din.readUTF();
                                    System.out.println("Server:\t"+str);
                        }
			s.close();
            }
}