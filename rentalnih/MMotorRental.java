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
public class MMotorRental {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rentalmotor";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;

    public MMotorRental() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public int inputdata(String kode_motor, String merk_motor, String tahun_rilis, String harga, String stok, String kode_jenis) {
        try {
            String sql = "INSERT INTO `motor`(kode_motor,merk_motor,tahun_rilis,harga,stok,kode_jenis) VALUES ('" + kode_motor + "','" + merk_motor + "','" + tahun_rilis + "','" + harga + "','" + stok + "','" + kode_jenis + "')";
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
            String sql = "DELETE FROM `motor` WHERE `kode_motor` = '" + ID + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    public String[][] ReadMotor() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][6];
            String query = "SELECT * FROM `motor` JOIN `jenis` ON `motor`.`kode_jenis` = `jenis`.`kode_jenis` ORDER BY `kode_motor` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("kode_motor");
                data[jmlData][1] = rs.getString("merk_motor");
                data[jmlData][2] = rs.getString("tahun_rilis");
                data[jmlData][3] = rs.getString("harga");
                data[jmlData][4] = rs.getString("stok");
                data[jmlData][5] = rs.getString("kode_jenis");

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
            String query = "SELECT*FROM `motor`";
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
            String data[][] = new String[getBanyakData()][6];
            String query = "SELECT*FROM `motor` WHERE `kode_motor` LIKE '%" + jd + "%' ORDER BY `kode_motor` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("kode_motor");
                data[jmlData][1] = rs.getString("merk_motor");
                data[jmlData][2] = rs.getString("tahun_rilis");
                data[jmlData][3] = rs.getString("harga");
                data[jmlData][4] = rs.getString("stok");
                data[jmlData][5] = rs.getString("kode_jenis");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }

    public void Update(String kode_motor, String merk_motor, String tahun_rilis, String harga, String stok, String kode_jenis) {
        try {
            String query = "UPDATE `motor` SET `merk_motor` = '" + merk_motor + "', `tahun_rilis` = '" + tahun_rilis + "', `harga` = '" + harga + "', `stok` = '" + stok + "', `kode_jenis` = '"+kode_jenis+"' WHERE `kode_motor` ='" + kode_motor + "'";
            statement = (Statement) (java.sql.Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
