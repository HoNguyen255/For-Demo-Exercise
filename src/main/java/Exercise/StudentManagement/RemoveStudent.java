package Exercise.StudentManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveStudent extends JFrame implements ActionListener {

    Choice cEmpId;
    JButton delete, back;

    RemoveStudent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = new JLabel("Student Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        try {
            Connect c = new Connect();
            String query = "select * from studentOne";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("studentId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);

        JLabel labelclass = new JLabel("Class");
        labelclass.setBounds(50, 150, 100, 30);
        add(labelclass);

        JLabel lblclass = new JLabel();
        lblclass.setBounds(200, 150, 100, 30);
        add(lblclass);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);

        try {
            Connect c = new Connect();
            String query = "select * from studentOne where studentId = '" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblclass.setText(rs.getString("Class"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connect c = new Connect();
                    String query = "select * from studentOne where studentId = '" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblclass.setText(rs.getString("Class"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/home.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);

        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Connect c = new Connect();
                String query = "delete from studentOne where studentId = '" + cEmpId.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveStudent();
    }
}
