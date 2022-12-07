/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import aadp_lab_soccersimulator.validators.PlayerDataValidatorInterface;
import aadp_lab_soccersimulator.validators.PlayerNumberValidatorDecorator;
import aadp_lab_soccersimulator.validators.PlayerTeamValidatorDecorator;
import aadp_lab_soccersimulator.validators.ValidatorComposite;

/**
 *
 * @author dacsa
 */
public class InputDataValidator implements PlayerDataValidatorInterface {

    @Override
    public boolean ValidateData(String[] playerData) {
        ValidatorComposite validatorComposite = new ValidatorComposite();
        validatorComposite.addComponent(new PlayerNumberValidatorDecorator());
        validatorComposite.addComponent(new PlayerTeamValidatorDecorator());
        return validatorComposite.ValidateData(playerData);
    }
    
}
