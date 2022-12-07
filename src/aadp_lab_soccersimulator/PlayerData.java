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
public class PlayerData {
    
    String name;
    int number;
    String birth;
    String position;
    int goalsScored;
    String background;
    
    public PlayerData(String name, int number, String birth, String position, int goalsScored, String background){
      this.name = name;
      this.number = number;
      this.birth = birth;
      this.position = position;
      this.goalsScored = goalsScored;
      this.background = background;
    }
    
}
