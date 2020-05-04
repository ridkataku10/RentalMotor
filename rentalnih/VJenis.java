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
public class VJenis extends JFrame {
    JLabel awal = new JLabel("Data Jenis Motor");
    JLabel kodeje = new JLabel("Kode Jenis");
    JLabel namaje = new JLabel("Nama Jenis Motor");
    JLabel cari = new JLabel("Cari Jenis Motor");
    JTextField tkodeje = new JTextField();
    JTextField tnamaje = new JTextField();
    JTextField tcari = new JTextField();
    JButton simpan = new JButton("Simpan");
    JButton edit = new JButton("Edit");
    JButton hapus = new JButton("Hapus");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    DefaultTableModel model;
    String kolom[] = {"Kode Jenis Motor","Nama Jenis Motor"};
    JTable table;
    JScrollPane sp;

    VJenis(){
        setTitle("Data Jenis Motor");
        setSize(500,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp).setBounds(30,330,400,300);
        add(awal).setBounds(200,30,200,20);
        add(kodeje).setBounds(30,80,90,20);
        add(namaje).setBounds(30,115,120,20);
        add(cari).setBounds(30,280,200,20);
        add(tkodeje).setBounds(150,80,120,20);
        add(tnamaje).setBounds(150,115,200,20);
        add(tcari).setBounds(150,280,200,20);
        add(simpan).setBounds(30,180,90,20);
        add(edit).setBounds(300,180,90,20);
        add(hapus).setBounds(300,220,90,20);
        add(reset).setBounds(30,220,90,20);
        add(exit).setBounds(170,200,90,20);
    }
    
    public String getKode_jenis(){
        return tkodeje.getText();
    }
    public String getNama_jenis(){
        return tnamaje.getText();
    }

}
