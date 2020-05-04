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
public class MPinjam {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rentalmotor";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;
    String dataHarga, dataJenis;

    public MPinjam() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public int inputdata(String no_pinjam, String id, String kodemo, String kodeje, String tgl_pinjam, String harga, String jumlah, String total) {
        try {
            String sql = "INSERT INTO `peminjam` (`no_peminjam`,`id_member`,`kode_motor`,`kode_jenis`,`tgl_pinjam`, `harga`, `jumlah`,`total`) VALUES ('" + no_pinjam + "','" + id + "','" + kodemo + "','" + kodeje + "','" + tgl_pinjam + "', '" + harga + "', '" + jumlah + "','" + total + "')";
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

            String sql = "DELETE FROM `peminjam` WHERE `no_peminjam` = '" + ID + "'";

            statement = (Statement) conn.createStatement();

            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public String[][] ReadPinjam() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][8];
            String query = "SELECT * FROM `peminjam` JOIN `member` ON `peminjam`.`id_member` = `member`.`id_member` JOIN `motor` ON `peminjam`.`kode_motor`=`motor`.`kode_motor` ORDER BY `no_peminjam` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("no_peminjam");
                data[jmlData][1] = rs.getString("id_member");
                data[jmlData][2] = rs.getString("kode_motor");
                data[jmlData][3] = rs.getString("kode_jenis");
                data[jmlData][4] = rs.getString("tgl_pinjam");
                data[jmlData][5] = rs.getString("harga");
                data[jmlData][6] = rs.getString("jumlah");
                data[jmlData][7] = rs.getString("total");

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
            String query = "SELECT*FROM `peminjam";
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
            String query = "SELECT*FROM `peminjam` WHERE `no_peminjam` LIKE '%" + jd + "%' ORDER BY `no_peminjam` ASC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("no_peminjam");
                data[jmlData][1] = rs.getString("id_member");
                data[jmlData][2] = rs.getString("kode_motor");
                data[jmlData][3] = rs.getString("kode_jenis");
                data[jmlData][4] = rs.getString("tgl_pinjam");
                data[jmlData][5] = rs.getString("harga");
                data[jmlData][6] = rs.getString("jumlah");
                data[jmlData][7] = rs.getString("total");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }

    public void Motor(String jd) {

        try {
            int jmlData = 0;
            String query = "SELECT*FROM `motor` WHERE `kode_motor` = '" + jd + "'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                dataHarga = rs.getString("harga");
                dataJenis = rs.getString("kode_jenis");

                jmlData++;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
        }

    }


    public void Update(String no_pinjam, String id, String kodemo, String kodeje, String tgl_pinjam, String harga, String jumlah, String total) {
        try {
            String query = "UPDATE `peminjam` SET `id_member` = '" + id + "', `kode_motor`='" + kodemo + "',`kode_jenis`='" + kodeje + "', `tgl_pinjam` = '" + tgl_pinjam + "',`harga` = '" + harga + "', `jumlah`='" + jumlah + "',`total`= '" + total + "' WHERE `no_peminjam` ='" + no_pinjam + "'";
            statement = (Statement) (java.sql.Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
