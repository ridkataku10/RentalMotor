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
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CJenis {

    VJenis vJenis;
    MJenis mJenis;
    String dataTerpilih;

    public CJenis(VJenis vJenis, MJenis mJenis) {
        this.mJenis = mJenis;
        this.vJenis = vJenis;

        if (mJenis.getBanyakData() != 0) {
            String dataJenis[][] = mJenis.ReadJenis();
            vJenis.table.setModel((new JTable(dataJenis, vJenis.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vJenis.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kode_jenis = vJenis.getKode_jenis();
                String nama_jenis = vJenis.getNama_jenis();

                mJenis.inputdata(kode_jenis, nama_jenis);
                vJenis.tkodeje.setText("");
                vJenis.tnamaje.setText("");

                String dataJenis[][] = mJenis.ReadJenis();
                vJenis.table.setModel(new JTable(dataJenis, vJenis.kolom).getModel());

            }
        });

        vJenis.hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = dataTerpilih;

                if (vJenis.tkodeje.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
                } else {
                    int jawab = JOptionPane.showConfirmDialog(null, "Hapus data jenis" + vJenis.tkodeje.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (jawab == JOptionPane.YES_NO_OPTION) {
                        mJenis.hapusdata(ID);
                        String dataJenis[][] = mJenis.ReadJenis();
                        vJenis.table.setModel(new JTable(dataJenis, vJenis.kolom).getModel());

                    }

                }

            }
        }
        );

        vJenis.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = dataTerpilih;
                String kode_jenis = vJenis.getKode_jenis();
                String nama_jenis = vJenis.getNama_jenis();

                mJenis.Update(kode_jenis, nama_jenis);

                String dataJenis[][] = mJenis.ReadJenis();
                vJenis.table.setModel(new JTable(dataJenis, vJenis.kolom).getModel());
            }
        }
        );

        vJenis.tcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vJenis.tcari.getText();

                mJenis.Search(jd);

                String dataJenis[][] = mJenis.Search(jd);
                vJenis.table.setModel(new JTable(dataJenis, vJenis.kolom).getModel());
            }
        });

        vJenis.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vJenis.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vJenis.tkodeje.setText("");
                vJenis.tnamaje.setText("");
                vJenis.tcari.setText("");

                String dataJenis[][] = mJenis.ReadJenis();
                vJenis.table.setModel(new JTable(dataJenis, vJenis.kolom).getModel());

            }
        });

        vJenis.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vJenis.table.getSelectedRow();
                int kolom = vJenis.table.getSelectedColumn();
                dataTerpilih = vJenis.table.getValueAt(baris, kolom).toString();

                String kode_jenis = vJenis.table.getValueAt(baris, 0).toString();
                vJenis.tkodeje.setText(kode_jenis);
                String nama_jenis = vJenis.table.getValueAt(baris, 1).toString();
                vJenis.tnamaje.setText(nama_jenis);

            }
        });
    }

}
