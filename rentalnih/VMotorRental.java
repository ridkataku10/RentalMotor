/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import java.awt.Color;
import java.awt.LayoutManager;
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
public class VMotorRental extends JFrame {
    JLabel awal = new JLabel("Data Motor Rental");
    JLabel kodemo = new JLabel("Kode Motor");
    JLabel merk = new JLabel("Merk Motor");
    JLabel thn = new JLabel("Tahun Rilis");
    JLabel harga = new JLabel("Harga Motor");
    JLabel stok = new JLabel("Stok");
    JLabel kodeje = new JLabel("Kode Jenis");
    JLabel cari = new JLabel("Cari Data Motor");
    JTextField tkodemo = new JTextField();
    JTextField tmerk = new JTextField();
    JTextField tthn = new JTextField();
    JTextField tharga = new JTextField();
    JTextField tstok = new JTextField();
    JTextField tkodeje = new JTextField();
    JTextField tcari = new JTextField();
    JButton simpan = new JButton("Simpan");
    JButton edit = new JButton("Edit");
    JButton hapus = new JButton("Hapus");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    DefaultTableModel model;
    String kolom[] = {"Kode Motor","Merk Motor","Tahun Rilis","Harga Motor","Stok","Kode Jenis"};
    JTable table;
    JScrollPane sp;
    
    VMotorRental(){
        setTitle("Data Motor Rental");
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp).setBounds(30,380,600,200);
        add(awal).setBounds(300,30,200,20);
        add(kodemo).setBounds(30,80,90,20);
        add(merk).setBounds(30,115,90,20);
        add(thn).setBounds(30,150,90,20);
        add(harga).setBounds(30,185,90,20);
        add(stok).setBounds(30,220,90,20);
        add(kodeje).setBounds(30,255,90,20);
        add(cari).setBounds(30,330,200,20);
        add(tkodemo).setBounds(150,80,120,20);
        add(tmerk).setBounds(150,115,200,20);
        add(tthn).setBounds(150,150,120,20);
        add(tharga).setBounds(150,185,120,20);
        add(tstok).setBounds(150,220,120,20);
        add(tkodeje).setBounds(150,255,120,20);
        add(tcari).setBounds(150,330,200,20);
        add(simpan).setBounds(430,100,90,20);
        add(edit).setBounds(530,100,90,20);
        add(hapus).setBounds(480,135,90,20);
        add(reset).setBounds(430,200,90,20);
        add(exit).setBounds(530,200,90,20);
        
    }
    
    
    
  public String getMerk_motor(){
      return tmerk.getText();
  }
 
  public String getHarga(){
      return tharga.getText();
  }
  
  public String getKode_motor(){
      return tkodemo.getText();
  }
  
  public String getKode_jenis(){
      return tkodeje.getText();
  }
  
  public String getStok(){
      return tstok.getText();
  }
  
  public String getTahun_rilis(){
      return tthn.getText();
  }
  
    
    
    
}

