package StudentUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentUI extends JFrame {

    JTextField studentName = new JTextField("Insert Name", 20);
    JTextField studentID = new JTextField("Insert ID", 20);
    JTextField studentAge = new JTextField("Insert Age", 20);
    JButton button = new JButton("OK");

    public StudentUI() {
        super("Insert Student Details");
        setLayout(new FlowLayout());




        // adds event listener which listens to Enter key event
        studentName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(StudentUI.this,
                        "Student name:\n" + studentName.getText());
            }
        });
        studentID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(StudentUI.this,
                        "Student ID:\n" + studentID.getText());
            }
        });
        studentAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(StudentUI.this,
                        "Student Age:\n" + studentAge.getText());
            }
        });

        // adds key event listener
        studentName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {
                String content = studentName.getText();
                button.setEnabled(!content.equals(""));
            }
        });

        // adds action listener for the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(StudentUI.this,
                        "Student Details:\n" +"Name: "+ studentName.getText()+"  ID: "+ studentID.getText()+"  Age: "+studentAge.getText());
            }
        });

        add(studentName);
        add(studentID);
        add(studentAge);
        add(button);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentUI();
            }
        });
    }
}