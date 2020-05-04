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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistem
 */
public class VPeminjaman extends JFrame {
    JLabel awal = new JLabel("Data Peminjaman Motor");
    JLabel no = new JLabel("No Peminjaman");
    JLabel id = new JLabel("ID Member");
    JLabel kodeje = new JLabel("Kode Jenis");
    JLabel kodemo = new JLabel("Kode Motor");
    JLabel tglPinjam = new JLabel("Tanggal Pinjam");
    JLabel harga = new JLabel("Harga Motor");
    JLabel jumlah = new JLabel("Jumlah Motor");
    JLabel total = new JLabel("Total");
    JLabel cari = new JLabel("Cari Data Peminjaman");
    JTextField tno = new JTextField();
    JTextField tid = new JTextField();
    JTextField tkodeje = new JTextField();
    JTextField tkodemo = new JTextField();
    JTextField ttgl = new JTextField();
    JTextField tharga = new JTextField();
    JTextField tjumlah = new JTextField();
    JTextField ttotal = new JTextField();
    JTextField tcari = new JTextField();
    JButton hitung = new JButton("Hitung");
    JButton simpan = new JButton("Simpan");
    JButton edit = new JButton("Edit");
    JButton hapus = new JButton("Hapus");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    
    DefaultTableModel model;
    String kolom[] = {"No Peminjaman","ID Member","Kode Motor","Kode Jenis","Tanggal Pinjam","Harga Motor","Jumlah Motor","Total"};
    JTable table;
    JScrollPane sp;
    
    VPeminjaman(){
        setTitle("Data Peminjaman Motor");
        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp).setBounds(30,300,800,200);
        add(awal).setBounds(300,30,200,20);
        add(no).setBounds(30,80,90,20);
        add(id).setBounds(30,115,90,20);
        add(kodemo).setBounds(30,150,90,20);
        add(kodeje).setBounds(30,185,90,20);
        add(tglPinjam).setBounds(320,80,90,20);
        add(harga).setBounds(320,115,90,20);
        add(jumlah).setBounds(320,150,90,20);
        add(total).setBounds(320,185,90,20);
        add(cari).setBounds(50,250,200,20);
        add(tno).setBounds(150,80,120,20);
        add(tid).setBounds(150,115,120,20);
        add(tkodemo).setBounds(150,150,120,20);
        add(tkodeje).setBounds(150,185,120,20);
        add(ttgl).setBounds(430,80,120,20);
        add(tharga).setBounds(430,115,120,20);
        add(tjumlah).setBounds(430,150,120,20);
        add(ttotal).setBounds(430,185,120,20);
        add(tcari).setBounds(200,250,200,20);
        add(simpan).setBounds(600,80,90,20);
        add(edit).setBounds(700,80,90,20);
        add(hapus).setBounds(600,115,90,20);
        add(reset).setBounds(700,115,90,20);
        add(exit).setBounds(650,150,90,20);
    }
    
    public String getNo(){
        return tno.getText();
    }
    public String getID(){
        return tid.getText();
    }
    public String getKodeJe(){
        return tkodeje.getText();
    }
    public String getKodeMo(){
        return tkodemo.getText();
    }
    public String getTgl(){
        return ttgl.getText();
    }
    public String getHarga(){
        return tharga.getText();
    }
   
    public String getJumlah(){
        return tjumlah.getText();
    }
    public String getTotal(){
        return ttotal.getText();
    }
}

