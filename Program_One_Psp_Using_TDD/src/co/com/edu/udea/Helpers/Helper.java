/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Helpers;

import co.com.edu.udea.Commons.GlobalConfigProperties;
import co.com.edu.udea.Controller.LinkedListController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author julianesten
 */
public class Helper {

    public static ArrayList readCvs(String path) {
        ArrayList data = new ArrayList();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
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

    public static double decimalFormat(double number) {
        DecimalFormat formatDecimal = new DecimalFormat("#.##");
        return Double.parseDouble(formatDecimal.format(number));

    }


    
    
    public static void chooseFiler(int typeOfFile){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try{
                if(typeOfFile==1){//File
                    GlobalConfigProperties.pathFile = fileChooser.getSelectedFile().getAbsolutePath();
                    LinkedListController.insertLinkedList();
                    JOptionPane.showMessageDialog(fileChooser, "File saved successfully");
                }else if(typeOfFile==2){//Folder
                    GlobalConfigProperties.pathFolder = fileChooser.getSelectedFile().getAbsolutePath();
                    JOptionPane.showMessageDialog(fileChooser, "Directory saved successfully");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(fileChooser, "Error saving file, contact the administrator program");
            }
            
        }else{
            JOptionPane.showMessageDialog(fileChooser, "Error saving file, contact the administrator program");
        } 
    }
}
