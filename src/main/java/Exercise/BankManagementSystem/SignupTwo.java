package Exercise.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JTextField nameTextFiled, fnameTextFiled , emailTextFiled, stateTextFiled, addressTextFiled, pinTextFiled, cityTextFiled;
    JLabel formo, additionalDetails, name, fname, dob, gender, email, marital, address, city, pincode, state;

    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, married, unmarried, other;

    SignupTwo(){



        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        additionalDetails = new JLabel("Page 2: Ađitional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextFiled = new JTextField();
        nameTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextFiled.setBounds(300, 140, 400, 30);
        add(nameTextFiled);

        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextFiled = new JTextField();
        fnameTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextFiled.setBounds(300, 190, 400, 30);
        add(fnameTextFiled);

        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 80, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextFiled = new JTextField();
        emailTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextFiled.setBounds(300, 340, 400, 30);
        add(emailTextFiled);

        marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 80, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(520, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextFiled = new JTextField();
        addressTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextFiled.setBounds(300, 440, 400, 30);
        add(addressTextFiled);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextFiled = new JTextField();
        cityTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextFiled.setBounds(300, 490, 400, 30);
        add(cityTextFiled);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextFiled = new JTextField();
        stateTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextFiled.setBounds(300, 540, 400, 30);
        add(stateTextFiled);

        pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinTextFiled = new JTextField();
        pinTextFiled.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextFiled.setBounds(300, 590, 400, 30);
        add(pinTextFiled);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public static void main(String args[]){
        new SignupTwo();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String formo = "" + random;
        String name = nameTextFiled.getText();
        String fname = fnameTextFiled.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String address = addressTextFiled.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Felmale";
        }
        String email = emailTextFiled.getText();
        String marial = null;
        if(married.isSelected()){
            marial = "Married";
        }else if(unmarried.isSelected()){
            marial = "Unmarried";
        } else  if(other.isSelected()){
            marial = "Other";
        }
        String city = cityTextFiled.getText();
        String state = stateTextFiled.getText();
        String pin = pinTextFiled.getText();
        try{
            if(name.equals("")){
                JOptionPane.showConfirmDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into sigupone values('"+formo+"', '"+name+"', '"+ fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marial+"', '"+ address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    
    }

}