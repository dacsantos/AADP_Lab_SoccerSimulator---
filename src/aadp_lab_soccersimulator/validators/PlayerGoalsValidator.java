/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator.validators;

/**
 *
 * @author dacsa
 */
public class PlayerGoalsValidator implements PlayerDataValidatorInterface {

    @Override
    public boolean ValidateData(String[] playerData) {
       try {
            if (Integer.parseInt(playerData[5]) >= 0) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    
}
