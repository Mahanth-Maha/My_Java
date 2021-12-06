package Networking;
import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;

public class Impl extends UnicastRemoteObject implements Calculator {
	public Impl() throws Exception { super(); }
	public int add(int x, int y) { return x + y; }
	public int sub(int x, int y) { return x - y; }
	public int mul(int x, int y) { return x * y; }
	public int div(int x, int y) { return x / y; }
	public int mod(int x, int y) { return x % y; }
	public int pow(int x, int y) { return (int)Math.pow(x,y); }
}
