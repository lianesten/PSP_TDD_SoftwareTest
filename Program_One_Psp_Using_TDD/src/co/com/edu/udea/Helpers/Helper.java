/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Helpers;

import co.com.edu.udea.Commons.GlobalConfigProperties;
import co.com.edu.udea.Controller.LinealRegressionController;
import co.com.edu.udea.Controller.LinkedListController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        boolean isMultipleColumns=false;
        ArrayList data = new ArrayList();
        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (line.contains(",")) {
                    isMultipleColumns =true;
                    String[] parameter = line.split(splitBy);
                    x.add(parameter[0]);
                    y.add(parameter[1]);
                } else {
                    data.add(line);
                }
            }
            if(isMultipleColumns){
                data.add(x);
                data.add(y);
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

    public static void chooseFiler(int typeOfFile) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                if (typeOfFile == 1) {//File psp1
                    GlobalConfigProperties.pathFile = fileChooser.getSelectedFile().getAbsolutePath();
                    LinkedListController.insertLinkedList();
                    JOptionPane.showMessageDialog(fileChooser, "File saved successfully");
                } else if (typeOfFile == 2) {//Folder psp2
                    GlobalConfigProperties.pathFolder = fileChooser.getSelectedFile().getAbsolutePath();
                    JOptionPane.showMessageDialog(fileChooser, "Directory saved successfully");
                }
                else if(typeOfFile == 3){//File psp3 with multiple columns, used by lineal regresion
                     GlobalConfigProperties.pathFileMultimpleColumns = fileChooser.getSelectedFile().getAbsolutePath();
//                     LinealRegressionController.insertLinkedListregression();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(fileChooser, "Error saving file, contact the administrator program");
            }

        } else {
            JOptionPane.showMessageDialog(fileChooser, "Error saving file, contact the administrator program");
        }
    }
}
