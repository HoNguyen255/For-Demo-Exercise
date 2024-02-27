package Exercise.StudentManagement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;

public class Login extends JFrame implements ActionListener {

    JTextField usernamTextField;
    JPasswordField passwordTextField;

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        usernamTextField = new JTextField();
        usernamTextField.setBounds(150, 20, 200, 30);
        add(usernamTextField);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(150, 70, 200, 30);
        add(passwordTextField);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 200, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/student.png"));
        Image im = ic.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(im);
        JLabel image = new JLabel(icc);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
        try {
            String username = usernamTextField.getText();
            String password = passwordTextField.getText();

            Connect c = new Connect();
            String query = "Select * from login where username = '" + username + "' and password = '" + password
                    + "'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
