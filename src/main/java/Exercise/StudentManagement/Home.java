package Exercise.StudentManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

public class Home extends JFrame implements ActionListener {

    JButton add, view, update, delete;

    Home() {

        setLayout(null);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/home.png"));
        Image im = ic.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(im);
        JLabel image = new JLabel(icc);
        image.setBounds(0, 0, 900, 500);
        add(image);

        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(500, 20, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add Student");
        add.setBounds(500, 80, 130, 30);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Student");
        view.setBounds(650, 80, 130, 30);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Student");
        update.setBounds(500, 150, 130, 30);
        update.addActionListener(this);
        image.add(update);

        delete = new JButton("Remove Student");
        delete.setBounds(650, 150, 130, 30);
        delete.addActionListener(this);
        image.add(delete);

        setSize(900, 500);
        setLocation(250, 100);
        setVisible(true);

    }

    public static void main(String args[]) {
        new Home();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
        if (ae.getSource() == add) {
            // new AddStudent();
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewStudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewStudent();
        } else {
            setVisible(false);
            new RemoveStudent();
        }
    }
}
