package Exercise.StudentManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("STUDENT MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.GRAY);
        add(heading);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/banner.png"));
        Image im = ic.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(im);
        JLabel image = new JLabel(icc);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        JButton clickkhere = new JButton("CLICK HERE TO CONTINUE");
        clickkhere.setBounds(400, 400, 300, 70);
        clickkhere.setBackground(Color.black);
        clickkhere.setForeground(Color.white);
        clickkhere.addActionListener(this);
        image.add(clickkhere);

        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String args[]) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        setVisible(false);
        new Login();
    }

}
