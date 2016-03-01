/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Controller;

import co.com.edu.udea.Helpers.Helper;
import co.com.edu.udea.Model.LinkedListModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author julianesten
 */
public class LinkedListController {
    
    public static void insertLinkedList(){
        LinkedListModel linkedListModel = new LinkedListModel();
        String filePath = "/home/julianesten/Escritorio/file.csv";
        ArrayList data = Helper.readCvs(filePath);
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar los valores");
            //Exception
            return;
        }
        
        //recorremos el String y llamamos al modelo para que inserte los datos en una lista simple ligada
        for(int i = 0; i<data.size();i++){
            linkedListModel.insertObjectAfter(data.get(i));
        }
        
        linkedListModel.print();
        //Calculamos el avg 
        double avg = linkedListModel.avg();
        JOptionPane.showMessageDialog(null, "La media de los datos ingresados es: "+avg);
        
        //Calculamos la desviacion estandar
        double sigma = linkedListModel.standarDeviaton();
        DecimalFormat   formatDecimal = new DecimalFormat("#.##");
        JOptionPane.showMessageDialog(null, "La desciacion estandar de los datos ingresados es:  "+formatDecimal.format(sigma));
        
        
        
    }
    
    
  
    
}
