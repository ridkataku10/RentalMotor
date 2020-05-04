/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sistem
 */
public class MJenis {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rentalmotor";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;

    public MJenis() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public int inputdata(String kode_jenis, String nama_jenis) {
        try {
            String sql = "INSERT INTO `jenis` VALUES ('" + kode_jenis + "','" + nama_jenis + "')";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        return 0;
    }

    public String hapusdata(String ID) {
        try {
            String sql = "DELETE FROM `jenis` WHERE `kode_jenis` = '" + ID + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public String[][] ReadJenis() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][2];
            String query = "SELECT * FROM `jenis` ORDER BY `kode_jenis` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("kode_jenis");
                data[jmlData][1] = rs.getString("nama_jenis");
                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try {
            statement = (Statement) conn.createStatement();
            String query = "SELECT*FROM `jenis`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }

    }
    
    public String[][] Search(String jd) {

        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][2];
            String query = "SELECT*FROM `jenis` WHERE `kode_jenis` LIKE '%" + jd + "%' ORDER BY `kode_jenis` ASC ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("kode_jenis");
                data[jmlData][1] = rs.getString("nama_jenis");
                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }
    
     public void Update(String kode_jenis, String nama_jenis) {
        try {
            String query = "UPDATE `jenis` SET `nama_jenis` = '" + nama_jenis + "' WHERE `kode_jenis` ='" + kode_jenis + "'";
            statement = (Statement) (java.sql.Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
