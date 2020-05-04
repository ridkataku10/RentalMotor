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
public class MMember {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rentalmotor";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;

    public MMember() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public int inputdata(String id, String nama, String ttl, String alamat, String telp) {
        try {
            String sql = "INSERT INTO `member` VALUES ('" + id + "','" + nama + "','" + ttl + "','" + alamat + "','" + telp + "')";
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

    public int hapusdata(String ID) {
        try {
            String sql = "DELETE FROM `member` WHERE `id_member` = '" + ID + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    public String[][] ReadMember() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][5];
            String query = "SELECT * FROM `member` ORDER BY `id_member` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("id_member");
                data[jmlData][1] = rs.getString("nama");
                data[jmlData][2] = rs.getString("tgl_lahir");
                data[jmlData][3] = rs.getString("alamat");
                data[jmlData][4] = rs.getString("no_telp");

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
            String query = "SELECT*FROM `member`";
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
            String data[][] = new String[getBanyakData()][5];
            String query = "SELECT*FROM `member` WHERE `id_member` LIKE '%" + jd + "%' ORDER BY `id_member` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("id_member");
                data[jmlData][1] = rs.getString("nama");
                data[jmlData][2] = rs.getString("tgl_lahir");
                data[jmlData][3] = rs.getString("alamat");
                data[jmlData][4] = rs.getString("no_telp");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }

    public void Update(String id, String nama, String ttl, String alamat, String telp) {
        try {
            String query = "UPDATE `member` SET `nama` = '" + nama + "', `tgl_lahir` = '"+ttl+"', `alamat` = '"+alamat+"', `no_telp` = '"+telp+"' WHERE `id_member` ='" + id + "'";
            statement = (Statement) (java.sql.Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
