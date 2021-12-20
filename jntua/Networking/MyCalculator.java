package jntua.Networking;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyCalculator extends Frame
{

    public boolean setClear=true;
    double number, memValue , Fn , Ln ;
    char op;
    Calculator ServObj = (Calculator) Naming.lookup("MYCAL");

    String[] digitButtonText = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "." };
    String[] operatorButtonText = {"/", "sqrt", "*", "%", "-", "^", "+", "=" };
    String[] specialButtonText = {"Backspc", "C" };

    MyDigitButton[] digitButton =new MyDigitButton[digitButtonText.length];
    MyOperatorButton[] operatorButton =new MyOperatorButton[operatorButtonText.length];
    MySpecialButton[] specialButton =new MySpecialButton[specialButtonText.length];

    Label displayLabel=new Label("0",Label.RIGHT);
    Label memLabel=new Label(" ",Label.RIGHT);

    final int FRAME_WIDTH=270,FRAME_HEIGHT=330;
    final int HEIGHT=30, WIDTH=30, H_SPACE=10,V_SPACE=10;
    final int TOPX=30, TOPY=50;
    ///////////////////////////
    MyCalculator(String frameText) throws MalformedURLException, NotBoundException, RemoteException//constructor
    {
        super(frameText);

        int tempX=TOPX, y=TOPY;
        displayLabel.setBounds(tempX,y,210,HEIGHT);
        displayLabel.setBackground(Color.BLUE);
        displayLabel.setForeground(Color.WHITE);
        add(displayLabel);

        memLabel.setBounds(TOPX,TOPY+HEIGHT+ V_SPACE,WIDTH, HEIGHT);
        //add(memLabel);

//set Co-ordinates for Special Buttons
        tempX=TOPX+H_SPACE; y=TOPY+HEIGHT+V_SPACE;

        specialButton[0]=new MySpecialButton(tempX,y,3*WIDTH+2*H_SPACE,HEIGHT,specialButtonText[0], this);
        specialButton[0].setForeground(Color.RED);
        tempX=tempX+3*(WIDTH+H_SPACE);
        specialButton[1]=new MySpecialButton(tempX,y,WIDTH*2+V_SPACE,HEIGHT,specialButtonText[1], this);
        specialButton[1].setForeground(Color.RED);


//set Co-ordinates for Digit Buttons
        int digitX=TOPX+H_SPACE;
        int digitY=TOPY+2*(HEIGHT+V_SPACE);
        tempX=digitX;  y=digitY;
        for(int i=0;i<digitButton.length -2 ;i++)
        {
            digitButton[i]=new MyDigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[i], this);
            digitButton[i].setForeground(Color.BLUE);
            tempX+=WIDTH+H_SPACE;
            if((i+1)%3==0){tempX=digitX; y+=HEIGHT+V_SPACE;}
        }
        digitButton[digitButton.length -2]=new MyDigitButton(tempX,y,2*WIDTH+H_SPACE,HEIGHT,digitButtonText[digitButton.length -2], this);
        digitButton[digitButton.length -2].setForeground(Color.BLUE);
        tempX+=2*(WIDTH+H_SPACE);
        digitButton[digitButton.length-1]=new MyDigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[digitButton.length-1], this);
        digitButton[digitButton.length-1].setForeground(Color.BLUE);


//set Co-ordinates for Operator Buttons
        int opsX=digitX+2*(WIDTH+H_SPACE);
        tempX=opsX;  y= digitY;
        for(int i=0;i<operatorButton.length;i++)
        {
            tempX+=WIDTH+H_SPACE;
            operatorButton[i]=new MyOperatorButton(tempX,y,WIDTH,HEIGHT,operatorButtonText[i], this);
            operatorButton[i].setForeground(Color.RED);
            if((i+1)%2==0){tempX=opsX; y+=HEIGHT+V_SPACE;}
        }

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent ev)
            {System.exit(0);}
        });

        setLayout(null);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);
    }
    //////////////////////////////////
    static String getFormattedText(double temp)
    {
        String resText=""+temp;
        if(resText.lastIndexOf(".0")>0)
            resText=resText.substring(0,resText.length()-2);
        return resText;
    }
    ////////////////////////////////////////
    public static void main(String []args) throws Exception{
        new MyCalculator("Calculator");
    }
}