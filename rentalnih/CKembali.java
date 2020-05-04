/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.ResultSet;

/**
 *
 * @author sistem
 */
public class CKembali {

    VPengembalian vPengembalian;
    MKembali mKembali;
    String dataTerpilih;

    public CKembali(VPengembalian vPengembalian, MKembali mKembali) {
        this.mKembali = mKembali;
        this.vPengembalian = this.vPengembalian;

        if (mKembali.getBanyakData() != 0) {
            String dataKembali[][] = mKembali.ReadKembali();
            vPengembalian.table.setModel((new JTable(dataKembali, vPengembalian.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vPengembalian.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kodekem = vPengembalian.getKodeK();
                String tglPin = vPengembalian.getPinjam();
                String tglKem = vPengembalian.getKembali();
                String denda = vPengembalian.getDenda();
                String lama = vPengembalian.getLama();
                String total = vPengembalian.getTot();
                String kodemo = vPengembalian.getKodemo();
                String id = vPengembalian.getID();

                mKembali.inputdata(kodekem, tglPin, tglKem, denda,lama,total, kodemo, id);
                String dataKembali[][] = mKembali.ReadKembali();
                vPengembalian.table.setModel(new JTable(dataKembali, vPengembalian.kolom).getModel());

            }
        });

        vPengembalian.hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = dataTerpilih;

                if (vPengembalian.tkodeBali.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
                } else {
                    int jawab = JOptionPane.showConfirmDialog(null, "Hapus data peminjaman" + vPengembalian.tkodeBali.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (jawab == JOptionPane.YES_NO_OPTION) {
                        mKembali.hapusdata(ID);
                        String dataKembali[][] = mKembali.ReadKembali();
                        vPengembalian.table.setModel(new JTable(dataKembali, vPengembalian.kolom).getModel());

                    }

                }

            }
        }
        );

        vPengembalian.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idy = dataTerpilih;
                String kodekem = vPengembalian.getKodeK();
                String tglPin = vPengembalian.getPinjam();
                String tglKem = vPengembalian.getKembali();
                String denda = vPengembalian.getDenda();
                String lama = vPengembalian.getLama();
                String total = vPengembalian.getTot();
                String kodemo = vPengembalian.getKodemo();
                String id = vPengembalian.getID();

                mKembali.Update(kodekem, tglPin, tglKem, denda, lama, total, kodemo, id);

                String dataKembali[][] = mKembali.ReadKembali();
                vPengembalian.table.setModel(new JTable(dataKembali, vPengembalian.kolom).getModel());
            }
        }
        );

        vPengembalian.tcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vPengembalian.tcari.getText();

                mKembali.Search(jd);

                String dataKembali[][] = mKembali.Search(jd);
                vPengembalian.table.setModel(new JTable(dataKembali, vPengembalian.kolom).getModel());
            }
        });

        vPengembalian.ttBali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date tglAwal =  (Date) date.parse(vPengembalian.getPinjam());
                    Date tglAkhir =  (Date) date.parse(vPengembalian.getKembali());
                    long bedaHari = Math.abs(tglAkhir.getTime()-tglAwal.getTime());
                     int a = (int) (TimeUnit.MILLISECONDS.toDays(bedaHari));
                    String berapa = String.valueOf(a);
                    vPengembalian.tlama.setText(berapa);
                   
                }catch(ParseException ex){
                    ex.getMessage();
                }
            }   
        });

        vPengembalian.denda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lama, total;
                lama = Integer.valueOf(vPengembalian.tlama.getText());
                total = Integer.valueOf(vPengembalian.ttot.getText());
                if(lama<=3){
                    vPengembalian.tcari.setText("");
                }
                else{
                    vPengembalian.tdenda.setText(String.valueOf( lama*total));
                }
                    
            }
        }); 
        
        vPengembalian.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vPengembalian.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vPengembalian.tkodeBali.setText("");
                vPengembalian.ttPinjam.setText("");
                vPengembalian.ttBali.setText("");
                vPengembalian.tdenda.setText("");
                vPengembalian.tlama.setText("");
                vPengembalian.ttot.setText("");
                vPengembalian.tkodemo.setText("");
                vPengembalian.tid.setText("");
                vPengembalian.tcari.setText("");

                String dataKembali[][] = mKembali.ReadKembali();
                vPengembalian.table.setModel(new JTable(dataKembali, vPengembalian.kolom).getModel());

            }
        });

        vPengembalian.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vPengembalian.table.getSelectedRow();
                int kolom = vPengembalian.table.getSelectedColumn();
                dataTerpilih = vPengembalian.table.getValueAt(baris, kolom).toString();

                String kodeK = vPengembalian.table.getValueAt(baris, 0).toString();
                vPengembalian.tkodeBali.setText(kodeK);
                String tP = vPengembalian.table.getValueAt(baris, 1).toString();
                vPengembalian.ttPinjam.setText(tP);
                String tK = vPengembalian.table.getValueAt(baris, 2).toString();
                vPengembalian.ttBali.setText(tK);
                String denda = vPengembalian.table.getValueAt(baris, 3).toString();
                vPengembalian.tdenda.setText(denda);
                String lama = vPengembalian.table.getValueAt(baris, 4).toString();
                vPengembalian.tlama.setText(lama);
                String tot = vPengembalian.table.getValueAt(baris, 5).toString();
                vPengembalian.ttot.setText(tot);
                String kodemo = vPengembalian.table.getValueAt(baris, 6).toString();
                vPengembalian.tkodemo.setText(kodemo);
                String id = vPengembalian.table.getValueAt(baris, 7).toString();
                vPengembalian.tid.setText(id);

            }
        });

    }

}
