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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistem
 */
public class VPengembalian extends JFrame{
    JLabel awal = new JLabel("Data Pengembalian Motor");
    JLabel kodeBali = new JLabel("Kode Pengembalian");
    JLabel kodemo = new JLabel("Kode Motor");
    JLabel id = new JLabel("ID Member");
    JLabel tglPinjam = new JLabel("Tanggal Peminjaman");
    JLabel tglBali = new JLabel("Tanggal Pengembalian");
    JLabel lama = new JLabel("Lama Pinjam");
    JLabel totharga = new JLabel("Total Harga Pinjam");
    JButton denda = new JButton("Harga Denda");
    JLabel cari = new JLabel("Cari Data Pengembalian");
    JTextField tkodeBali = new JTextField();
    JTextField tkodemo = new JTextField();
    JTextField tid = new JTextField();
    JTextField ttPinjam = new JTextField();
    JTextField ttBali = new JTextField();
    JTextField tlama = new JTextField();
    JTextField ttot = new JTextField();
    JTextField tdenda = new JTextField();
    JTextField tcari = new JTextField();
    JButton simpan = new JButton("Simpan");
    JButton edit = new JButton("Edit");
    JButton hapus = new JButton("Hapus");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    
    DefaultTableModel model;
    String kolom[] = {"Kode Pengembalian","Tgl Peminjaman","Tgl Pengembalian","Harga Denda","Lama Pinjam","Total Harga Pinjam","Kode Motor","ID Member"};
    JTable table;
    JScrollPane sp;
    
    VPengembalian(){
        setTitle("Data Pengembalian Motor");
        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp).setBounds(30,420,950,200);
        add(awal).setBounds(300,30,200,20);
        add(kodeBali).setBounds(30,80,200,20);
        add(kodemo).setBounds(30,150,200,20);
        add(id).setBounds(30,220,90,20);
        add(tglPinjam).setBounds(200,80,200,20);
        add(tglBali).setBounds(200,150,200,20);
        add(lama).setBounds(380,80,200,20);
        add(totharga).setBounds(380,150,200,20);
        add(denda).setBounds(380,220,120,20);
        add(cari).setBounds(30,370,200,20);
        add(tkodeBali).setBounds(30,115,120,20);
        add(tkodemo).setBounds(30,185,120,20);
        add(tid).setBounds(30,255,120,20);
        add(ttPinjam).setBounds(200,115,120,20);
        add(ttBali).setBounds(200,185,120,20);
        add(tlama).setBounds(380,115,120,20);
        add(ttot).setBounds(380,185,120,20);
        add(tdenda).setBounds(380,255,120,20);
        add(tcari).setBounds(180,370,200,20);
        add(simpan).setBounds(30,320,90,20);
        add(edit).setBounds(150,320,90,20);
        add(hapus).setBounds(270,320,90,20);
        add(reset).setBounds(390,320,90,20);
        add(exit).setBounds(510,320,90,20);
}
    
    public String getKodeK(){
        return tkodeBali.getText();
    }
    public String getPinjam(){
        return ttPinjam.getText();
    }
    public String getKembali(){
        return ttBali.getText();
    }
    public String getDenda(){
        return tdenda.getText();
    }
    public String getLama(){
        return tlama.getText();
    }
    public String getTot(){
        return ttot.getText();
    }
    public String getKodemo(){
        return tkodemo.getText();
    }
    public String getID(){
        return tid.getText();
    }
}