/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dacsa
 */
public class DataInput {
    
     public List<String> InputData(String Input) throws FileNotFoundException, IOException {
        BufferedReader myReader = new BufferedReader(new FileReader(Input));
        List<String> lines = new ArrayList<>();
        String inputLine = myReader.readLine();
        
        while ((inputLine = myReader.readLine()) != null) {
            lines.add(inputLine);
        }     
        return lines;
    }
    
}
