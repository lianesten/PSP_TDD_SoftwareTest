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

/**
 *
 * @author julianesten
 */
public class LinkedListController {
    public static LinkedListModel linkedListModel;
    public static void insertLinkedList(){
        linkedListModel = new LinkedListModel();
        ArrayList data = Helper.readCvs(GlobalConfigProperties.pathFile);   
        //recorremos el String y llamamos al modelo para que inserte los datos en una lista simple ligada
        for(int i = 0; i<data.size();i++){
            linkedListModel.insertObjectAfter(data.get(i));
        }
        linkedListModel.print();  
    }
    
    public static double avg(){
        return linkedListModel.avg();
    }
    
    public static double standarDeviation(){   
        return linkedListModel.standarDeviaton();
    }  
}
