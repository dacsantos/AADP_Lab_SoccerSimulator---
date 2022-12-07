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
public class PlayerNumberValidatorDecorator implements PlayerDataValidatorInterface {

    @Override
    public boolean ValidateData(String[] playerData) {
        PlayerDataValidatorInterface numberValidator = new PlayerNumberValidator();
        if (numberValidator.ValidateData(playerData)) {
            return true;
        } else {
            System.out.println("That is not a valid number. please try again!");
            return false;
        }
    }

}
