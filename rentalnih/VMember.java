/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistem
 */
public class VMember extends JFrame {

    JLabel awal = new JLabel("Data Member Rental");
    JLabel id = new JLabel("ID Member");
    JLabel nama = new JLabel("Nama Member");
    JLabel ttl = new JLabel("Tanggal Lahir");
    JLabel alamat = new JLabel("Alamat");
    JLabel telp = new JLabel("No. Telp");
    JLabel cari = new JLabel("Cari Data Member");
    JTextField tid = new JTextField();
    JTextField tnama = new JTextField();
    JTextField tttl = new JTextField();
    JTextField ttelp = new JTextField();
    JTextField tcari = new JTextField();
    JButton simpan = new JButton("Simpan");
    JButton edit = new JButton("Edit");
    JButton hapus = new JButton("Hapus");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    JScrollPane scroll;
    JTextArea ta = new JTextArea();

    DefaultTableModel model;
    String kolom[] = {"ID Member", "Nama Member", "Tanggal Lahir", "Alamat", "No. Telp"};
    JTable table;
    JScrollPane sp;

    VMember() {
        setTitle("Data Member Rental");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp).setBounds(500, 130, 500, 280);
        add(awal).setBounds(300, 30, 200, 20);
        add(id).setBounds(30, 80, 90, 20);
        add(nama).setBounds(30, 115, 90, 20);
        add(ttl).setBounds(30, 150, 90, 20);
        add(alamat).setBounds(30, 185, 90, 20);
        add(telp).setBounds(30, 280, 90, 20);
        add(cari).setBounds(500,80, 200, 20);
        add(tid).setBounds(150, 80, 120, 20);
        add(tnama).setBounds(150, 115, 200, 20);
        add(tttl).setBounds(150, 150, 120, 20);
        add(scroll).setBounds(150, 185, 250, 80);
        add(ttelp).setBounds(150, 280, 120, 20);
        add(tcari).setBounds(650, 80, 200, 20);
        add(simpan).setBounds(30, 350, 90, 20);
        add(edit).setBounds(30, 390, 90, 20);
        add(hapus).setBounds(320, 350, 90, 20);
        add(reset).setBounds(320, 390, 90, 20);
        add(exit).setBounds(180, 370, 90, 20);

    }
    
    public String getID(){
        return tid.getText();
    }
    public String getNama(){
        return tnama.getText();
    }
    public String getTtl(){
        return tttl.getText();
    }
    public String getAlamat(){
        return ta.getText();
    }
    public String getTelp(){
        return ttelp.getText();
    }

}
