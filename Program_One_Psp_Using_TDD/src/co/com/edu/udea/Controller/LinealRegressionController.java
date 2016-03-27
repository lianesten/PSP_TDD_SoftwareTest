/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Controller;

import co.com.edu.udea.Commons.GlobalConfigProperties;
import co.com.edu.udea.Helpers.Helper;
import co.com.edu.udea.Model.LinkedListModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author julianesten
 */
public class LinealRegressionController {
    public static LinkedListModel linkedListModel = new LinkedListModel();
    //get path of data
    //Call Helper to parse the data
//    ArrayList data = new ArrayList();
    
    
    public static void insertLinkedListregression(){
        ArrayList data = Helper.readCvs(GlobalConfigProperties.pathFileMultimpleColumns);
        ArrayList x = (ArrayList)data.get(0);
        ArrayList y = (ArrayList)data.get(1);
        int n = x.size();
        int i=0;
        while(i<n){
            System.out.println(Double.parseDouble(x.get(i).toString()));
            linkedListModel.insertObjectAfterNodoRegression(Double.parseDouble(x.get(i).toString()), Double.parseDouble(y.get(i).toString()));
            i++;
        }
    }
    
    //Call method to calculate the Linear regression, B0 and B1
    public static double getB1(){
        return linkedListModel.linearRegressionB1();
    }
    
    public static double getB0(){
        return linkedListModel.linearRegresionB0();
    }    
    
    //Call method to calculate the correlation coefficients
    public static double getCorrelationCoefficient(){
        return linkedListModel.correlationCoefficient();
    }
    
    public static double getRPow(){
        return linkedListModel.getRPow();
    }    
    
    public static double getYk(double yk){
        return linkedListModel.getYk(yk);
    }
    
    
}
