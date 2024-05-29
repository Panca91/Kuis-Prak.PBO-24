/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author M S I
 */



public class Login extends JFrame{
    private static final String PIN = "123200099";
    public Login() {
        setTitle("Halaman Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Membuat panel login
        JPanel loginPanel = new JPanel();
        JLabel pinLabel = new JLabel("Masukkan PIN:");
        JPasswordField pinField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JLabel loginMessage = new JLabel("");

        loginPanel.add(pinLabel);
        loginPanel.add(pinField);
        loginPanel.add(loginButton);
        loginPanel.add(loginMessage);

        add(loginPanel);
        setVisible(true);

        // Aksi untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPin = new String(pinField.getPassword());
                if (enteredPin.equals(PIN)) {
                    Financial f = new Financial();
                } else {
                    loginMessage.setText("PIN salah!");
                }
            }
        });
    }
    
}
