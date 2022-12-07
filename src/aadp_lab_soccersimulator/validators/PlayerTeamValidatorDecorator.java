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
public class PlayerTeamValidatorDecorator implements PlayerDataValidatorInterface {

    @Override
    public boolean ValidateData(String[] playerData) {
        PlayerDataValidatorInterface teamValidator = new PlayerTeamValidator();
        if (teamValidator.ValidateData(playerData)) {
            return true;
        } else {
            System.out.println("That is not a valid team. Please try again!");
            return false;
        }
    }
}
