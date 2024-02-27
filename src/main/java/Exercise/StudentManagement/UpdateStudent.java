package Exercise.StudentManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import Exercise.BankManagementSystem.Conn;

public class UpdateStudent extends JFrame implements ActionListener {

    // Random ran = new Random();
    // int number = ran.nextInt(999999);

    JButton update, back;
    JTextField tfname, tfadress, tfscoreone, tfscoretwo, tfscorethree, tffname, lblname, lbldob;
    JTextField tfClass;
    JDateChooser tfdob;
    JRadioButton male, female;
    JLabel code, tfcode, tfemail;
    String studentId;

    UpdateStudent(String studentId) {
        this.studentId = studentId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 25));
        add(labelname);

        lblname = new JTextField();
        lblname.setBounds(200, 150, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(lblname);

        JLabel labeldob = new JLabel("Date of birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 25));
        add(labeldob);

        lbldob = new JTextField();
        lbldob.setBounds(200, 200, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(lbldob);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.PLAIN, 25));
        add(address);

        tfadress = new JTextField();
        tfadress.setBounds(200, 250, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfadress);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("serif", Font.PLAIN, 25));
        add(email);

        tfemail = new JLabel();
        tfemail.setBounds(200, 300, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfemail);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(50, 350, 150, 30);
        lblgender.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblgender);

        JLabel gender = new JLabel();
        gender.setBounds(200, 350, 60, 30);
        gender.setBackground(Color.white);
        add(gender);

        // JLabel female = new JLabel("Female");
        // female.setBounds(280, 350, 100, 30);
        // female.setBackground(Color.white);
        // add(female);

        JLabel labelclass = new JLabel("Class");
        labelclass.setBounds(400, 200, 150, 30);
        labelclass.setFont(new Font("serif", Font.PLAIN, 25));
        add(labelclass);

        tfClass = new JTextField();
        // tfClass.setBackground(Color.white);
        tfClass.setBounds(600, 200, 150, 30);
        add(tfClass);

        JLabel labelfname = new JLabel("Father's name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 25));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tffname);

        code = new JLabel("Student id: ");
        code.setBounds(50, 400, 400, 30);
        code.setFont(new Font("serif", Font.PLAIN, 25));
        add(code);

        tfcode = new JLabel();
        tfcode.setBounds(200, 400, 400, 30);
        tfcode.setFont(new Font("serif", Font.PLAIN, 25));
        add(tfcode);

        JLabel scoreone = new JLabel("Subject score 1");
        scoreone.setBounds(400, 250, 200, 30);
        scoreone.setFont(new Font("serif", Font.PLAIN, 25));
        add(scoreone);

        tfscoreone = new JTextField();
        tfscoreone.setBounds(600, 250, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfscoreone);

        JLabel scoretwo = new JLabel("Subject score 2");
        scoretwo.setBounds(400, 300, 200, 30);
        scoretwo.setFont(new Font("serif", Font.PLAIN, 25));
        add(scoretwo);

        tfscoretwo = new JTextField();
        tfscoretwo.setBounds(600, 300, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfscoretwo);

        JLabel scorethree = new JLabel("Subject score 3");
        scorethree.setBounds(400, 350, 200, 30);
        scorethree.setFont(new Font("serif", Font.PLAIN, 25));
        add(scorethree);

        tfscorethree = new JTextField();
        tfscorethree.setBounds(600, 350, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfscorethree);

        try {
            Connect c = new Connect();
            String query = "select * from studentOne where studentId = '" + studentId + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfadress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                gender.setText(rs.getString("gender"));
                tfscoreone.setText(rs.getString("subjectScoreOne"));
                tfscoretwo.setText(rs.getString("subjectScoreTwo"));
                tfscorethree.setText(rs.getString("subjectScoreThree"));
                tfClass.setText(rs.getString("Class"));
                tfcode.setText(rs.getString("studentId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateStudent("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if (ae.getSource() == update) {
            String name = lblname.getText();
            String fathername = tffname.getText();
            String dob = lbldob.getText();
            String address = tfadress.getText();
            // String email = tfemail.getText();
            // String gender = gender.getText();
            String subjectScoreOne = tfscoreone.getText();
            String subjectScoreTwo = tfscoretwo.getText();
            String subjectScoreThree = tfscorethree.getText();
            String Class = tfClass.getText();
            Double changeScoreOne = Double.parseDouble(subjectScoreOne);
            Double changeScoreTwo = Double.parseDouble(subjectScoreTwo);
            Double changeScoreThree = Double.parseDouble(subjectScoreThree);
            Double gpa = (double) Math.round(((changeScoreOne + changeScoreTwo + changeScoreThree) / 3) * 100) / 100;
            // String studentId = studentdId.getText();

            try {
                Connect conn = new Connect();
                String query = "update studentOne set name = '" + name + "', fname = '" +
                        fathername + "', dob = '"
                        + dob + "', address = '"
                        + address + "', subjectScoreOne = '"
                        + subjectScoreOne + "', subjectScoreTwo = '"
                        + subjectScoreTwo + "', subjectScoreThree = '"
                        + subjectScoreThree + "', Class = '"
                        + Class + "', gpa = '" + gpa + "' where studentId = '" + studentId + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
                setVisible(false);
                new ViewStudent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewStudent();
        }
    }
}