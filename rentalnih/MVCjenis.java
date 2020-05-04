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
public class MVCjenis {
    VJenis vJenis = new VJenis();
    MJenis mJenis = new MJenis();
    CJenis cJenis = new CJenis(vJenis, mJenis);
    
}
