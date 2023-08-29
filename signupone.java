package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;


public class signupone extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField , fnameTextField , dobTextField , emailTextField ,cityTextField , addressTextField , stateTextField , pinTextField ;
    JButton next;
    JRadioButton male , female , other , married , unmarried ;
    JDateChooser dateChooser ; 
    ConnectionManager dbConnection;

    public signupone() {

        setLayout(null);
        dbConnection = new ConnectionManager();

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Railway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno); 

        JLabel personalDetails = new JLabel("page 1 : personal details");
        personalDetails.setFont(new Font("Railway",Font.BOLD,22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of birth :");
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        // JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
        // JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        // timeSpinner.setEditor(timeEditor);
        // timeSpinner.setValue(new Date());
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300 , 240 , 400 ,30 );
        dateChooser.setForeground(new Color(105, 105 , 105 ));
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD,14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);


        JLabel pincode = new JLabel("Pin Code :");
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Railway",Font.BOLD,14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620, 630, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 730);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)     {

        String formno = "" + random;  //long
        String name = nameTextField.getText();  // setText
        String fname = fnameTextField.getText();
        // String dob = dateChooser.getDateEditor().getUiComponent().getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null ;
        if (male.isSelected())  {
            gender = "MALE";
        }   else if    (female.isSelected())    {
            gender = "FEMALE";
        }

        String email = emailTextField.getText();
        String  marrital = null;
        if (married.isSelected())   {
            marrital = "MARRIED";
        }   else if(unmarried.isSelected())   {
            marrital = "UNMARRIED";
        }   else if (other.isSelected())    {
            marrital = "OTHER";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
     
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required ");
            } else {
                Statement stmt = dbConnection.getStatement();
                String query = "insert into signupone (formno,name,father_name,tdob,gender,email,marrital,address,city,pin,state)"
                        + " values ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '"
                        + email + "', '" + marrital + "', '" + address + "', '" + city + "', '" + pin + "', '" + state
                        + "')";

                stmt.executeUpdate(query);

                // After the data is inserted, close the connection
                dbConnection.closeConnection();
                // setVisible(false);
                // new signuptwo(formno).setVisible(true);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new signupone();
    }
}
