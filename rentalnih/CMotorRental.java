/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CMotorRental {

    MMotorRental mMotorRental;
    VMotorRental vMotorRental;
    String dataTerpilih;

    CMotorRental(MMotorRental mMotorRental, VMotorRental vMotorRental) {
        this.mMotorRental = mMotorRental;
        this.vMotorRental = vMotorRental;

        if (mMotorRental.getBanyakData() != 0) {
            String dataMotor[][] = mMotorRental.ReadMotor();
            vMotorRental.table.setModel((new JTable(dataMotor, vMotorRental.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vMotorRental.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kode_motor = vMotorRental.getKode_motor();
                String merk_motor = vMotorRental.getMerk_motor();
                String tahun_rilis = vMotorRental.getTahun_rilis();
                String harga = vMotorRental.getHarga();
                String stok = vMotorRental.getStok();
                String kode_jenis = vMotorRental.getKode_jenis();

                mMotorRental.inputdata(kode_motor, merk_motor, tahun_rilis, harga, stok, kode_jenis);
                vMotorRental.tkodemo.setText("");
                vMotorRental.tmerk.setText("");
                vMotorRental.tthn.setText("");
                vMotorRental.tharga.setText("");
                vMotorRental.tstok.setText("");
                vMotorRental.tkodeje.setText("");

                String dataMotor[][] = mMotorRental.ReadMotor();
                vMotorRental.table.setModel(new JTable(dataMotor, vMotorRental.kolom).getModel());

            }
        });

        vMotorRental.hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = dataTerpilih;

                if (vMotorRental.tkodemo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
                } else {
                    int jawab = JOptionPane.showConfirmDialog(null, "Hapus data jenis" + vMotorRental.tkodemo.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (jawab == JOptionPane.YES_NO_OPTION) {
                        mMotorRental.hapusdata(ID);
                        String dataMotor[][] = mMotorRental.ReadMotor();
                        vMotorRental.table.setModel(new JTable(dataMotor, vMotorRental.kolom).getModel());

                    }

                }
            }
        }
        );

        vMotorRental.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = dataTerpilih;
                String kode_motor = vMotorRental.getKode_motor();
                String merk_motor = vMotorRental.getMerk_motor();
                String tahun_rilis = vMotorRental.getTahun_rilis();
                String harga = vMotorRental.getHarga();
                String stok = vMotorRental.getStok();
                String kode_jenis = vMotorRental.getKode_jenis();

                mMotorRental.Update(kode_motor, merk_motor, tahun_rilis, harga, stok, kode_jenis);

                String dataMotor[][] = mMotorRental.ReadMotor();
                vMotorRental.table.setModel(new JTable(dataMotor, vMotorRental.kolom).getModel());
            }
        }
        );

        vMotorRental.tcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vMotorRental.tcari.getText();

                mMotorRental.Search(jd);

                String dataMotor[][] = mMotorRental.Search(jd);
                vMotorRental.table.setModel(new JTable(dataMotor, vMotorRental.kolom).getModel());
            }
        });

        vMotorRental.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vMotorRental.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vMotorRental.tkodemo.setText("");
                vMotorRental.tmerk.setText("");
                vMotorRental.tthn.setText("");
                vMotorRental.tharga.setText("");
                vMotorRental.tstok.setText("");
                vMotorRental.tkodeje.setText("");
                vMotorRental.tcari.setText("");
                ;
                String dataMotor[][] = mMotorRental.ReadMotor();
                vMotorRental.table.setModel(new JTable(dataMotor, vMotorRental.kolom).getModel());

            }
        });

        vMotorRental.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vMotorRental.table.getSelectedRow();
                int kolom = vMotorRental.table.getSelectedColumn();
                dataTerpilih = vMotorRental.table.getValueAt(baris, kolom).toString();

                String kodemo = vMotorRental.table.getValueAt(baris, 0).toString();
                vMotorRental.tkodemo.setText(kodemo);
                String merk = vMotorRental.table.getValueAt(baris, 1).toString();
                vMotorRental.tmerk.setText(merk);
                String thn = vMotorRental.table.getValueAt(baris, 2).toString();
                vMotorRental.tthn.setText(thn);
                String harga = vMotorRental.table.getValueAt(baris, 3).toString();
                vMotorRental.tharga.setText(harga);
                String stok = vMotorRental.table.getValueAt(baris, 4).toString();
                vMotorRental.tstok.setText(stok);
                String kodeje = vMotorRental.table.getValueAt(baris, 5).toString();
                vMotorRental.tkodeje.setText(kodeje);

            }
        });

    }
}
