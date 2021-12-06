package Networking;
import java.rmi.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("--- OPTIONS --- \n\n0.exit\n\n1.Addition\n2.Subtraction\n3.multiplication\n4.division\n5.Modulous\n6.Power\n\n");
		while (true) {
			System.out.print("Enter the option : ");
			int opt = sc.nextInt();
			if (opt == 0) break;
			System.out.print("Enter the first number : ");
			int a = sc.nextInt();
			System.out.print("Enter the second number : ");
			int b = sc.nextInt();
			Calculator obj = (Calculator)Naming.lookup("ADD");
			switch (opt) {	
				case 1:System.out.println("Addition = " + obj.add(a, b));break;
				case 2:System.out.println("Subtraction = " + obj.sub(a, b));break;
				case 3:System.out.println("Multiplication = " + obj.mul(a, b));break;
				case 4:System.out.println("Division = " + obj.div(a, b));break;
				case 5:System.out.println("Modulous = " + obj.mod(a, b));break;
				case 6:System.out.println("Power = " + obj.pow(a, b));break;
			}
		}
	}
}
