package jntua.Networking;

import java.rmi.server.UnicastRemoteObject;

public class Impl extends UnicastRemoteObject implements Calculator {
    public Impl() throws Exception { super(); }
    public double addi(double x, double y) { return x + y; }
    public double sub(double x, double y) { return  y - x; }
    public double mul(double x, double y) { return x * y; }
    public int div(int x, int y) { return (int)(x / y); }
    public int mod(int x, int y) { return (int)(x % y); }
    public int pow(int x, int y) { return (int)Math.pow(x,y); }
    public double sqr(double x) { return Math.sqrt(x); }
}