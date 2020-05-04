/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author sistem
 */
public class VLogin extends JFrame {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rentalmotor";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;

    JLabel user = new JLabel("Username");
    JLabel pass = new JLabel("Password");
    JTextField us = new JTextField(20);
    JPasswordField pa = new JPasswordField(20);
    JButton login = new JButton("Login");
    JButton batal = new JButton("Batal");

    VLogin() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }

        setTitle("Yok Login Yok!");
        setSize(350, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        add(user);
        add(us);
        add(pass);
        add(pa);
        add(login);
        add(batal);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "SELECT*FROM `login` WHERE `username`= '"+us.getText()+"'";
                    Statement statement = (Statement) conn.createStatement();
                    ResultSet rs = statement.executeQuery(sql);
                    if (rs.next()) {
                        System.out.println("sukses");
                        if (rs.getString(2).equals(pa.getText()) && rs.getString(1).equals(us.getText())) {
                            JOptionPane.showMessageDialog(null, "LOGIN SUKSES");
                            new MVCjenis();
                            setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "SALAH LUW");
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(VLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        batal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
