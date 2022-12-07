/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

/**
 *
 * @author dacsa
 */
public class DataMapper {

    public PlayerData Map(String[] fields) {
//        String team = fields[0];
        String name = fields[1];
        int number = Integer.parseInt(fields[2]);
        String birth = fields[3];
        String position = fields[4];
        int goalsScored = Integer.parseInt(fields[5]);
        String background = fields[6];
        
        return new PlayerData(
               name, number, birth, position, goalsScored, background      
        );
    }

}
