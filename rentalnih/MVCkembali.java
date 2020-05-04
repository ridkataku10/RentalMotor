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
public class MVCkembali {
    VPengembalian vPengembalian = new  VPengembalian();
    MKembali mKembali = new MKembali();
    CKembali cKembali = new CKembali(vPengembalian, mKembali);
    
}
