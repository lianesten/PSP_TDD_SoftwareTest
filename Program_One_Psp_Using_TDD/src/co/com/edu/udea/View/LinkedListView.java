/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.View;

import co.com.edu.udea.Controller.LinkedListController;
import javax.swing.JOptionPane;

/**
 *
 * @author julianesten
 */
public class LinkedListView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String dataAux = JOptionPane.showInputDialog("Ingrese los datos a operar separados por comas.\n ex: 1,2,...,n");
        
        
        LinkedListController.insertLinkedList();
    }
    
}
