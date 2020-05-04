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
public class CPinjam {

    VPeminjaman vPeminjaman;
    MPinjam mPinjam;
    String dataTerpilih;

    public CPinjam(VPeminjaman vPeminjaman, MPinjam mPinjam) {
        this.mPinjam = mPinjam;
        this.vPeminjaman = vPeminjaman;

        if (mPinjam.getBanyakData() != 0) {
            String dataPinjam[][] = mPinjam.ReadPinjam();
            vPeminjaman.table.setModel((new JTable(dataPinjam, vPeminjaman.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vPeminjaman.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String no_peminjam = vPeminjaman.getNo();
                String id = vPeminjaman.getID();
                String kode_motor = vPeminjaman.getKodeMo();
                String kode_jenis = vPeminjaman.getKodeJe();
                String tgl_pinjam = vPeminjaman.getTgl();
                String harga = vPeminjaman.getHarga();
                String jumlah = vPeminjaman.getJumlah();
                String total = vPeminjaman.getTotal();

                mPinjam.inputdata(no_peminjam, id, kode_motor, kode_jenis, tgl_pinjam, harga, jumlah, total);
                String dataPinjam[][] = mPinjam.ReadPinjam();
                vPeminjaman.table.setModel(new JTable(dataPinjam, vPeminjaman.kolom).getModel());

            }
        });

        vPeminjaman.hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = dataTerpilih;

                if (vPeminjaman.tno.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
                } else {
                    int jawab = JOptionPane.showConfirmDialog(null, "Hapus data peminjaman" + vPeminjaman.tno.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (jawab == JOptionPane.YES_NO_OPTION) {
                        mPinjam.hapusdata(ID);
                        String dataPinjam[][] = mPinjam.ReadPinjam();
                        vPeminjaman.table.setModel(new JTable(dataPinjam, vPeminjaman.kolom).getModel());

                    }

                }

            }
        }
        );

        vPeminjaman.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idy = dataTerpilih;
                String no_peminjam = vPeminjaman.getNo();
                String id = vPeminjaman.getID();
                String kode_motor = vPeminjaman.getKodeMo();
                String kode_jenis = mPinjam.dataJenis;
                String tgl_pinjam = vPeminjaman.getTgl();
                String harga = mPinjam.dataHarga;
                String jumlah = vPeminjaman.getJumlah();
                String total = vPeminjaman.getTotal();

                mPinjam.Update(no_peminjam, id, kode_motor, kode_jenis, tgl_pinjam, harga, jumlah, total);

                String dataPinjam[][] = mPinjam.ReadPinjam();
                vPeminjaman.table.setModel(new JTable(dataPinjam, vPeminjaman.kolom).getModel());

            }
        }
        );

        vPeminjaman.tcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vPeminjaman.tcari.getText();

                mPinjam.Search(jd);

                String dataPinjam[][] = mPinjam.Search(jd);
                vPeminjaman.table.setModel(new JTable(dataPinjam, vPeminjaman.kolom).getModel());

            }
        });
        
        vPeminjaman.tjumlah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nilai1, nilai2;
                nilai1 = Integer.valueOf(vPeminjaman.tharga.getText());
                nilai2 = Integer.valueOf(vPeminjaman.tjumlah.getText());
                vPeminjaman.ttotal.setText(String.valueOf(nilai1*nilai2));
            }
        }); 
        vPeminjaman.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vPeminjaman.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vPeminjaman.tno.setText("");
                vPeminjaman.tid.setText("");
                vPeminjaman.tkodemo.setText("");
                vPeminjaman.tkodeje.setText("");
                vPeminjaman.ttgl.setText("");
                vPeminjaman.tharga.setText("");
                vPeminjaman.tjumlah.setText("");
                vPeminjaman.ttotal.setText("");
                vPeminjaman.tcari.setText("");

                String dataPinjam[][] = mPinjam.ReadPinjam();
                vPeminjaman.table.setModel(new JTable(dataPinjam, vPeminjaman.kolom).getModel());

            }
        });

        vPeminjaman.tkodemo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String kodemo = vPeminjaman.getKodeMo();
                mPinjam.Motor(kodemo);
                String harga = mPinjam.dataHarga;
                String kodeje = mPinjam.dataJenis;
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    vPeminjaman.tharga.setText(harga);
                    vPeminjaman.tkodeje.setText(kodeje);
                }

            }
        });

        vPeminjaman.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vPeminjaman.table.getSelectedRow();
                int kolom = vPeminjaman.table.getSelectedColumn();
                dataTerpilih = vPeminjaman.table.getValueAt(baris, kolom).toString();

                String no = vPeminjaman.table.getValueAt(baris, 0).toString();
                vPeminjaman.tno.setText(no);
                String id = vPeminjaman.table.getValueAt(baris, 1).toString();
                vPeminjaman.tid.setText(id);
                String motor = vPeminjaman.table.getValueAt(baris, 2).toString();
                vPeminjaman.tkodemo.setText(motor);
                String jenis = vPeminjaman.table.getValueAt(baris, 3).toString();
                vPeminjaman.tkodeje.setText(jenis);
                String tgl = vPeminjaman.table.getValueAt(baris, 4).toString();
                vPeminjaman.ttgl.setText(tgl);
                String harga = vPeminjaman.table.getValueAt(baris, 5).toString();
                vPeminjaman.tharga.setText(harga);
                String jumlah = vPeminjaman.table.getValueAt(baris, 6).toString();
                vPeminjaman.tjumlah.setText(jumlah);
                String total = vPeminjaman.table.getValueAt(baris, 7).toString();
                vPeminjaman.ttotal.setText(total);

            }
        });
    }

}
