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
public class MVCmotor {
    VMotorRental vMotorRental = new VMotorRental();
    MMotorRental mMotorRental = new MMotorRental();
    CMotorRental cMotorRental = new CMotorRental(mMotorRental, vMotorRental);
}
