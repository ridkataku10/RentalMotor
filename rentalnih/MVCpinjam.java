/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalnih;

/**
 *
 * @author sistem
 */
public class MVCpinjam {
    VPeminjaman vPeminjaman = new VPeminjaman();
    MPinjam mPinjam = new MPinjam();
    CPinjam cPinjam = new CPinjam(vPeminjaman, mPinjam);
}
