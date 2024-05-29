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
public class Financial extends JFrame{
    private static int balance = 0;
    
    JPanel financialPanel = new JPanel();
    JLabel lInputSaldo = new JLabel("Masukkan Saldo : ");
    JTextField fInputSaldo = new JTextField(10);
    JLabel balanceLabel = new JLabel("Saldo: Rp " + balance);
    JButton saveButton = new JButton("Simpan");
    JButton ambilButton = new JButton("Ambil");
    JLabel financialMessage = new JLabel("");
    
    public Financial(){
        setTitle("Halaman Financial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        financialPanel.add(lInputSaldo);
        financialPanel.add(fInputSaldo);
        financialPanel.add(balanceLabel);
        financialPanel.add(saveButton);
        financialPanel.add(ambilButton);
        financialPanel.add(financialMessage);

        add(financialPanel);
        setVisible(true);

        // Aksi untuk tombol simpan
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cekInputSaldo = getSaldo();
                    if (cekInputSaldo.equals("")) { // Error Handling jika inputan kosong
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
                       return;
                    }else if(cekInputSaldo.matches("(?i)[a-z]+")){ // Error Handling jika inputan mengandung huruf
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Mengandung Huruf!");
                       return;
                    }
                    int inputSaldo = Integer.parseInt(getSaldo());
                    balance = balance + inputSaldo; // menambah saldo sesuai inputan
                    balanceLabel.setText("Saldo: Rp " + balance);
                    financialMessage.setText("Saldo berhasil ditambah!");
                }catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Input Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aksi untuk tombol ambil
        ambilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cekInputSaldo = getSaldo();
                    if (cekInputSaldo.equals("")) { // Error Handling jika inputan kosong
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
                       return;
                    }else if(cekInputSaldo.matches("(?i)[a-z]+")){ // Error Handling jika inputan mengandung huruf
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Mengandung Huruf!");
                       return;
                    }
                    int inputSaldo = Integer.parseInt(getSaldo());
                    if (balance >= inputSaldo) {
                        balance = balance - inputSaldo; // mengurangi saldo sesuai inputan
                        balanceLabel.setText("Saldo: Rp " + balance);
                        financialMessage.setText("Saldo berhasil diambil!");
                    } else {
                        financialMessage.setText("Saldo tidak cukup!");
                    }
                }catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Input Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public String getSaldo(){
        return fInputSaldo.getText();
    }
}
