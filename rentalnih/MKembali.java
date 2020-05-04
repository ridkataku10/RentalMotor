/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sistem
 */
public class MKembali {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rentalmotor";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;
    String PlamaPinjam,PbayarDenda;

    public MKembali() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public int inputdata(String kodekem, String tglPin, String tglKem, String denda,String lama, String total, String kodemo, String id) {
   
        try {
            String sql = "INSERT INTO `pengembalian` (kode_kembali, tgl_pinjam, tgl_kembali,denda,lama_pinjam,total, kode_motor, id_member) VALUES ('" + kodekem + "','" + tglPin + "','" + tglKem + "','"+denda+"','"+lama+"', '" + total + "', '" + kodemo + "', '" + id + "')";
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
            System.out.println(ID);
            String sql = "DELETE FROM `pengembalian` WHERE `kode_kembali` = '" + ID + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    public String[][] ReadKembali() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][8];
            String query = "SELECT * FROM `pengembalian` JOIN `member` ON `pengembalian`.`id_member` = `member`.`id_member` JOIN `motor` ON `pengembalian`.`kode_motor` = `motor`.`kode_motor` ORDER BY `kode_kembali` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("kode_kembali");
                data[jmlData][1] = rs.getString("tgl_pinjam");
                data[jmlData][2] = rs.getString("tgl_kembali");
                data[jmlData][3] = rs.getString("denda");
                data[jmlData][4] = rs.getString("lama_pinjam");
                data[jmlData][5] = rs.getString("total");
                data[jmlData][6] = rs.getString("kode_motor");
                data[jmlData][7] = rs.getString("id_member");

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
            String query = "SELECT*FROM `pengembalian`";
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
            String data[][] = new String[getBanyakData()][8];
            String query = "SELECT*FROM `pengembalian` WHERE `kode_kembali` LIKE '%" + jd + "%' ORDER BY `kode_kembali` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("kode_kembali");
                data[jmlData][1] = rs.getString("tgl_pinjam");
                data[jmlData][2] = rs.getString("tgl_kembali");
                data[jmlData][3] = rs.getString("denda");
                data[jmlData][4] = rs.getString("lama_pinjam");
                data[jmlData][5] = rs.getString("total");
                data[jmlData][6] = rs.getString("kode_motor");
                data[jmlData][7] = rs.getString("id_member");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }

    public void Update(String kodekem, String tglPin, String tglKem, String denda, String lama, String total, String kodemo, String id) {
        try {
            String query = "UPDATE `pengembalian` SET `tgl_pinjam` = '" + tglPin + "', `tgl_kembali` = '" + tglKem + "', `denda` = '" + denda + "',`lama_pinjam`='"+lama+"', `total`='"+total+"',`kode_motor`='"+kodemo+"',`id_member`='"+id+"' WHERE `kode_kembali` ='" + kodekem + "'";
            statement = (Statement) (java.sql.Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
   
}
