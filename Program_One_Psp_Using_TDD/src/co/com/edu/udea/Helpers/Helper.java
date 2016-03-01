/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author julianesten
 */
public class Helper {
    
    
     public static ArrayList readCvs(String path){
        ArrayList data = new ArrayList();
    	String csvFile = path;
	BufferedReader br = null;
	String line = "";
//	String cvsSplitBy = ",";

	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
		        // coma para separar
			//String[] item = line.split(cvsSplitBy);   
                    data.add(line);
                       

		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        return data;
    




}
    
}
