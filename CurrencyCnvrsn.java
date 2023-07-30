import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyCnvrsn 
{
    JFrame f=new JFrame("Currency Convertor");
    JLabel l1=new JLabel();
    JLabel l2=new JLabel();
    JLabel l3 =new JLabel();
    JTextField tf=new JTextField();
    JButton b =new JButton();
    JLabel result=new JLabel();

    CurrencyCnvrsn ()
    {
        double exchangeRates[]={82.26, 1, 0.91, 141.15, 1.50 };
        l1.setText("Amount :");
        l1.setBounds(30,50 ,150 , 25);

        l2.setText("From :");
        l2.setBounds(30, 100, 150, 25);

        l3.setText("To :");
        l3.setBounds(30, 150, 150, 25);
        
        
        tf.setBounds(100, 50, 100, 25);
        
        String Currency[]={"INR","USD","EUR","JPY","AUD"};
        JComboBox tf1= new JComboBox<>(Currency);
        tf1.setBounds(100,100,100,25);

        JComboBox tf2=new JComboBox<>(Currency);
        tf2.setBounds(100, 150, 100, 25);

        b.setText("Convert");
        b.setBounds(50, 200, 100, 25);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                String fromCurrency = (String) tf1.getSelectedItem();
                String toCurrency = (String) tf2.getSelectedItem();
                double amount = Double.parseDouble(tf.getText());

                
                double amountInUSD = amount / exchangeRates[getIndex(fromCurrency)];

                
                double resultAmount = amountInUSD * exchangeRates[getIndex(toCurrency)];

                
                result.setText("Converted Amount: " + resultAmount + " " +toCurrency);
                
                
            }
        });
        result.setBounds(20, 250, 350, 25);
        result.setBackground(Color.CYAN);
        f.setSize(350,350 );
        f.setLayout(null);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(tf1);
        f.add(tf2);
        f.add(tf);
        f.add(b);
        f.add(result);
        f.setVisible(true);

    }
    private int getIndex(String Currency) {
        switch (Currency) {
            case "INR":
                return 0;
            case "USD":
                return 1;
            case "EUR":
                return 2;
            case "JPY":
                return 3;
            case "AUD":
                return 4;
            default:
                return -1;
    
        }
    }

    public static void main(String[] args) 
    {
        new CurrencyCnvrsn();
    }  
}  
