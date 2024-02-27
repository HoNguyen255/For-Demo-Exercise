package Exercise.StudentManagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Exercise.StudentManagement.rs2xml.DbUtils;

public class ViewStudent extends JFrame implements ActionListener {

    JTable table;
    Choice cstudentId;
    JButton search, print, update, back, refresh, searchStudentLargestGPA, searchStudentLowestGPA;
    JTextField tfsearchName;

    /**
     * 
     */
    ViewStudent() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchStudent = new JLabel("Search by Student Id");
        searchStudent.setBounds(20, 20, 150, 20);
        add(searchStudent);

        cstudentId = new Choice();
        cstudentId.setBounds(180, 20, 150, 20);
        add(cstudentId);

        JLabel searchName = new JLabel("Search by name");
        searchName.setBounds(500, 20, 100, 20);
        add(searchName);

        tfsearchName = new JTextField();
        tfsearchName.setBounds(620, 20, 150, 20);
        add(tfsearchName);

        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from studentOne");
            while (rs.next()) {
                cstudentId.add(rs.getString("studentId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from studentOne");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        refresh = new JButton("Refresh");
        refresh.setBounds(420, 70, 80, 20);
        refresh.addActionListener(this);
        add(refresh);

        searchStudentLargestGPA = new JButton("Largest GPA");
        searchStudentLargestGPA.setBounds(520, 70, 150, 20);
        searchStudentLargestGPA.addActionListener(this);
        add(searchStudentLargestGPA);

        searchStudentLowestGPA = new JButton("Lowest GPA");
        searchStudentLowestGPA.setBounds(690, 70, 150, 20);
        searchStudentLowestGPA.addActionListener(this);
        add(searchStudentLowestGPA);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String args[]) {
        new ViewStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
        if (e.getSource() == search) {
            String query = "select * from studentOne where studentId = '" + cstudentId.getSelectedItem()
                    + "' or name = '" + tfsearchName.getText() + "' or fname = '"+tfsearchName.getText()+"'";
            try {
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                // TODO: handle exception
                ae.printStackTrace();
            }
        } else if (e.getSource() == searchStudentLargestGPA) {
            String query = "SELECT * FROM studentOne WHERE gpa = (SELECT MAX(gpa) FROM studentOne)";
            try {
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == searchStudentLowestGPA) {
            String query = "SELECT * FROM studentOne WHERE gpa = (SELECT MIN(gpa) FROM studentOne)";
            try {
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == refresh) {
            setVisible(false);
            new ViewStudent();
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ae) {
                // TODO: handle exception
                ae.printStackTrace();
            }

        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateStudent(cstudentId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }
}
