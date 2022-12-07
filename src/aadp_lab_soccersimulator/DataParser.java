/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dacsa
 */
public class DataParser {
    
public List<PlayerData> ParseData(List<String> lines) {
        List<PlayerData> trades = new ArrayList<>();
        DataSeparator dataSeperator = new DataSeparator();
        InputDataValidator dataValidator = new InputDataValidator();
        DataMapper dataMapper = new DataMapper();
        
        lines.forEach(line -> {
            // Splitting
            String[] fields = dataSeperator.Seperate(line);
            
            // Validating
            if (dataValidator.ValidateData(fields) ) {
                // Mapping
                trades.add(dataMapper.Map(fields));
            }
        });   
        return trades;
    }    
    
}
