/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.util.List;

/**
 *
 * @author dacsa
 */
public interface DataOutputInterface {
     public void outputData(List<PlayerData> player) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
