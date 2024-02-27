package Exercise.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/icon.jpg"));
        Image i2 = ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel welcome = new JLabel("WELCOME TO TMA ");
        welcome.setFont(new Font("Osward", Font.BOLD, 20));
        welcome.setBounds(200, 40, 400, 40);
        add(welcome);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 16));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(200, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(120, 200, 400, 40);
        pin.setFont(new Font("Arial", Font.BOLD, 16));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(200, 200, 230, 30);
        add(pinTextField);

        login = new JButton("Sign in");
        login.setBounds(200, 250, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(330, 250, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(200, 300, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public static void main(String[] args) {
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (e.getSource() == login) {

        } else if (e.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

}
