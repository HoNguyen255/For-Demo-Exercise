package Exercise.StudentManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class AddStudent extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JButton add, back;
    JTextField tfname, tfadress, tfemail, tfscoreone, tfscoretwo, tfscorethree, tffname;
    JComboBox cl;
    JDateChooser tfdob;
    JRadioButton male, female;
    JLabel code, tfcode;

    AddStudent() {

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add Student detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 25));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfname);

        JLabel labeldob = new JLabel("Date of birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 25));
        add(labeldob);

        tfdob = new JDateChooser();
        tfdob.setBounds(200, 200, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfdob);

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

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        // tfname.setFont(new Font("serif", Font.BOLD, 25));
        add(tfemail);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 350, 150, 30);
        gender.setFont(new Font("serif", Font.PLAIN, 25));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200, 350, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(280, 350, 100, 30);
        female.setBackground(Color.white);
        add(female);

        JLabel labelclass = new JLabel("Class");
        labelclass.setBounds(400, 200, 150, 30);
        labelclass.setFont(new Font("serif", Font.PLAIN, 25));
        add(labelclass);

        String classList[] = { "60A1", "60A2", "60A3" };
        cl = new JComboBox(classList);
        cl.setBounds(600, 200, 150, 30);
        // cl.setBackground(Color.white);
        add(cl);

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

        tfcode = new JLabel("" + number);
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

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String args[]) {
        new AddStudent();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) tfdob.getDateEditor().getUiComponent()).getText();
            String address = tfadress.getText();
            String email = tfemail.getText();
            String subjectScoreOne = tfscoreone.getText();
            String subjeectScoreTwo = tfscoretwo.getText();
            String subjectScoreThree = tfscorethree.getText();
            Double changeScoreOne = Double.parseDouble(subjectScoreOne);
            Double changeScoreTwo = Double.parseDouble(subjeectScoreTwo);
            Double changeScoreThree = Double.parseDouble(subjectScoreThree);
            Double gpa = (double) Math.round(((changeScoreOne+changeScoreTwo+changeScoreThree)/3)*100)/100;
            // gpa
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Felmale";
            }
            String Class = (String) cl.getSelectedItem();
            String studentId = tfcode.getText();
            try {
                if (name.equals("") || fname.equals("") || dob.equals("") || address.equals("") || email.equals("")
                        || subjectScoreOne.equals("") || subjeectScoreTwo.equals("") || subjectScoreThree.equals("")
                        || dob.equals("")) {
                    JOptionPane.showConfirmDialog(null, "Please enter all field");
                } else {
                    Connect c = new Connect();
                    String query = "insert into studentOne values('" + name + "', '" + fname + "', '" + dob + "', '"
                            + address
                            + "', '" + email + "', '" + gender + "','" + subjectScoreOne + "', '" + subjeectScoreTwo
                            + "', '"
                            + subjectScoreThree + "', '" + Class + "','" + studentId + "', '"+gpa+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Added student successfully");
                    setVisible(false);
                    new Home();
                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static boolean Checkdata(String t)
    {
        if(t == ""){
            return true;
        }
        return false;

    }
}
