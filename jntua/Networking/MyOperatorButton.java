package jntua.Networking;

import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.rmi.RemoteException;

class MyOperatorButton extends Button implements ActionListener
{
    MyCalculator cl;

    MyOperatorButton(int x,int y, int width,int height,String cap, MyCalculator clc)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.cl=clc;
        this.cl.add(this);
        addActionListener(this);
    }
    ///////////////////////
    public void actionPerformed(ActionEvent ev)
    {

        String opText=((MyOperatorButton)ev.getSource()).getLabel();

        cl.setClear=true;
        double temp=Double.parseDouble(cl.displayLabel.getText());
        cl.Fn  = temp ;
        if(opText.equals("sqrt"))
        {
            try{
                double tempd=cl.ServObj.sqr(cl.number);
                cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
            }catch(ArithmeticException excp) {
                cl.displayLabel.setText("Divide by 0.");
            }catch (RemoteException e) {
                e.printStackTrace();
            }return;
        }
        if(!opText.equals("="))
        {
            cl.number=temp;
            cl.op=opText.charAt(0);
            return;
        }
// process = button pressed
        switch(cl.op)
        {
            case '+':
                try {
                    temp = cl.ServObj.addi(temp,cl.number);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                //temp+=cl.number;
                break;
            case '-':
                try {
                    temp = cl.ServObj.sub(temp,cl.number);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
                //temp=cl.number-temp;break;
            case '*':
                try {
                    temp = cl.ServObj.mul(temp,cl.number);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
                //temp*=cl.number;break;
            case '%':
                try {
                    temp = cl.ServObj.mod((int)cl.number,(int)temp);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                /*try{temp=cl.number%temp;}
                catch(ArithmeticException excp)
                {cl.displayLabel.setText("Divide by 0."); return;}*/
                break;
            case '/':
                try{cl.ServObj.div((int)cl.number,(int)temp);}
                catch(ArithmeticException | RemoteException excp)
                {cl.displayLabel.setText("Divide by 0."); return;}
                break;
            case '^':
                try {
                    temp = cl.ServObj.pow((int)cl.number,(int)temp);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;

        }//switch

        cl.displayLabel.setText(MyCalculator.getFormattedText(temp));
//cl.number=temp;
    }//actionPerformed
}//class
