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
public class MVCmember {
    VMember vMember = new VMember();
    MMember mMember = new MMember();
    CMember cMember = new CMember(vMember, mMember);
}
