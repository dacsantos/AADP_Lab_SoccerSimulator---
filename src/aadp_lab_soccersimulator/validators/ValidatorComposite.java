/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator.validators;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dacsa
 */
public class ValidatorComposite implements PlayerDataValidatorInterface {

    private List<PlayerDataValidatorInterface> children;
    
    public ValidatorComposite() {
        this.children = new ArrayList<>();
    }
    
    public void addComponent(PlayerDataValidatorInterface component) {
        children.add(component);
    }
    
        public void removeComponent(PlayerDataValidatorInterface component) {
        children.remove(component);
    }
    
    
    @Override
    public boolean ValidateData(String[] playerData) {
        boolean isValid = true;
        for (PlayerDataValidatorInterface component: children) {
            
            isValid = isValid && component.ValidateData(playerData);
        }
        return isValid;
    }
    
    
}
