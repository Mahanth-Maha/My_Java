package Networking;

import java.util.Scanner;

public class CommandExe {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Ip Address of Host : ");
        String ip = sc.nextLine();
        String cmd;
        while (true) {
            System.out.print("Enter command : ");
            cmd = sc.nextLine();
            if (cmd.equalsIgnoreCase("exit")) {
                break;
            } else if (cmd.equalsIgnoreCase("hello")) {
                HelloCommand.Hello(ip);
            } else if (cmd.equalsIgnoreCase("echo")) {
                EchoCommand.Echo(ip);
            } else {
                System.out.println("\n--> USEAGE : Commands Availiable \n1.Hello \n2.Echo \n3.Exit \n");
            }
        }
    }
}