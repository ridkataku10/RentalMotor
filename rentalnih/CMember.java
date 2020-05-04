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
public class CMember {

    VMember vMember;
    MMember mMember;
    String dataTerpilih;

    public CMember(VMember vMember, MMember mMember) {
        this.mMember = mMember;
        this.vMember = this.vMember;

        if (mMember.getBanyakData() != 0) {
            String dataMember[][] = mMember.ReadMember();
            vMember.table.setModel((new JTable(dataMember, vMember.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vMember.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = vMember.getID();
                String nama = vMember.getNama();
                String ttl = vMember.getTtl();
                String alamat = vMember.getAlamat();
                String telp = vMember.getTelp();

                mMember.inputdata(id, nama, ttl, alamat, telp);
                vMember.tid.setText("");
                vMember.tnama.setText("");
                vMember.tttl.setText("");
                vMember.ta.setText("");
                vMember.ttelp.setText("");

                String dataMember[][] = mMember.ReadMember();
                vMember.table.setModel(new JTable(dataMember, vMember.kolom).getModel());

            }
        });

        vMember.hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = dataTerpilih;

                if (vMember.tid.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
                } else {
                    int jawab = JOptionPane.showConfirmDialog(null, "Hapus data peminjaman" + vMember.tid.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (jawab == JOptionPane.YES_NO_OPTION) {
                        mMember.hapusdata(ID);
                        String dataMember[][] = mMember.ReadMember();
                        vMember.table.setModel(new JTable(dataMember, vMember.kolom).getModel());

                    }

                }

            }
        }
        );

        vMember.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idm = dataTerpilih;
                String id = vMember.getID();
                String nama = vMember.getNama();
                String ttl = vMember.getTtl();
                String alamat = vMember.getAlamat();
                String telp = vMember.getTelp();

                mMember.Update(id, nama, ttl, alamat, telp);

                String dataMember[][] = mMember.ReadMember();
                vMember.table.setModel(new JTable(dataMember, vMember.kolom).getModel());
            }
        }
        );

        vMember.tcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vMember.tcari.getText();

                mMember.Search(jd);

                String dataMember[][] = mMember.Search(jd);
                vMember.table.setModel(new JTable(dataMember, vMember.kolom).getModel());
            }
        });

        vMember.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vMember.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vMember.tid.setText("");
                vMember.tnama.setText("");
                vMember.tttl.setText("");
                vMember.ta.setText("");
                vMember.ttelp.setText("");
                vMember.tcari.setText("");

                String dataMember[][] = mMember.ReadMember();
                vMember.table.setModel(new JTable(dataMember, vMember.kolom).getModel());

            }
        });

        vMember.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vMember.table.getSelectedRow();
                int kolom = vMember.table.getSelectedColumn();
                dataTerpilih = vMember.table.getValueAt(baris, kolom).toString();

                String id = vMember.table.getValueAt(baris, 0).toString();
                vMember.tid.setText(id);
                String nama = vMember.table.getValueAt(baris, 1).toString();
                vMember.tnama.setText(nama);
                String ttl = vMember.table.getValueAt(baris, 2).toString();
                vMember.tttl.setText(ttl);
                String alamat = vMember.table.getValueAt(baris, 3).toString();
                vMember.ta.setText(alamat);
                String telp = vMember.table.getValueAt(baris, 4).toString();
                vMember.ttelp.setText(telp);
            }
        });

    }

}
