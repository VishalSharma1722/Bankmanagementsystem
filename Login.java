//package bankmanagement;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Login extends JFrame implements ActionListener {
//
//    JButton login, signup, clear;
//    JTextField cardTextField;
//    JPasswordField pinTextField;
//
//    Login() {
//        setTitle("BANK MANAGEMENT SYSTEM ");
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
//
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel label = new JLabel(i3);
//        label.setBounds(70, 10, 100, 100);
//        add(label);
//
//        JLabel text = new JLabel("Welcom to ATM");
//        text.setFont(new Font("Osward", Font.BOLD, 38));
//        text.setBounds(200, 40, 400, 40);
//        add(text);
//
//        JLabel cardno = new JLabel("CARD NO");
//        cardno.setFont(new Font("Railway", Font.BOLD, 28));
//        cardno.setBounds(120, 150, 150, 30);
//        add(cardno);
//
//        cardTextField = new JTextField();
//        cardTextField.setBounds(300, 150, 230, 30);
//        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
//        add(cardTextField);
//
//        JLabel pin = new JLabel("PIN");
//        pin.setFont(new Font("Railway", Font.BOLD, 28));
//        pin.setBounds(120, 220, 250, 30);
//        add(pin);
//
//        pinTextField = new JPasswordField();
//        pinTextField.setBounds(300, 220, 230, 30);
//        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
//        add(pinTextField);
//
//        login = new JButton(" SIGN IN");
//        login.setBounds(300, 300, 100, 30);
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        add(login);
//
//        clear = new JButton(" CLEAR");
//        clear.setBounds(430, 300, 100, 30);
//        clear.setBackground(Color.BLACK);
//        clear.setForeground(Color.WHITE);
//        clear.addActionListener(this);
//        add(clear);
//
//        signup = new JButton(" SIGN UP");
//        signup.setBounds(300, 350, 230, 30);
//        signup.setBackground(Color.BLACK);
//        signup.setForeground(Color.WHITE);
//        signup.addActionListener(this);
//        add(signup);
//
//        getContentPane().setBackground(Color.WHITE);
//
//        setSize(800, 480);
//        setVisible(true);
//        setLocation(350, 200);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//
//        if (ae.getSource() == clear) {
//
//            cardTextField.setText("");
//            pinTextField.setText("");
//
//        } else if (ae.getSource() == login) {
//
//        } else if (ae.getSource() == signup) {
//            setVisible(false);
//            new signupone().setVisible(true);
//            
//        }
//    }
//
//    public static void main(String args[])throws ClassNotFoundException {
//        new Login();
//    }
//}


package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100);
        add(l11);
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);
                
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,350,230,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signupone().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}