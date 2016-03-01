/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Model;

import co.com.edu.udea.Entities.LinkedListEntity;
import co.com.edu.udea.Entities.NodoEntity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author julianesten
 */
public class LinkedListModel {
    LinkedListEntity linkedListEntity = new LinkedListEntity();
    
    public boolean isVoid(){
       return linkedListEntity.primero == null;
        
    }  
    
    public void insertObjectAfter(Object data){ 
        Boolean isInsert=false;
        if(isVoid()){
            System.err.println("Creating LinkedList");
           linkedListEntity.primero = linkedListEntity.ultimo = new NodoEntity(data);
           isInsert= true;
        }else{
            System.err.println("Adding new obect to the linkedList");
            linkedListEntity.primero = new NodoEntity(data,linkedListEntity.primero);
//            isInsert= true;
        }
//        return isInsert;
    }
    
    public int size(){
         int size =0;
        NodoEntity actual = linkedListEntity.primero;
        while(actual != null){
            size = size + 1;
            actual = actual.getNext();
        }         
        return size;
     }
    
    public LinkedListEntity getLinkedList(){
         return linkedListEntity;
     } 
     //Este metodo no deberia de ir aqui
    public double avg(){
        double avg = 0,avgTotal = 0;
        NodoEntity actual = linkedListEntity.primero;
        while(actual != null){
            avg = avg + Double.parseDouble(actual.getData().toString());
//            avg = avg +  (Integer) actual.getData();
            actual = actual.getNext();
        }
        avgTotal = avg/size();
        
    return avgTotal;
    }
    
     //Este metodo no deberia de ir aqui
    public double standarDeviaton(){
        double sigma = 0,i=0,sigmaTotal=0,sumatoria=0;
        double avg = avg();
        NodoEntity actual = linkedListEntity.primero;
        while(actual != null){
            i = Double.parseDouble(actual.getData().toString());
            sumatoria = Math.pow(i-avg,2 );
            sigma = sigma + sumatoria;
            actual = actual.getNext();
        }
        sigmaTotal = Math.sqrt(sigma/9);//Math.pow(sigma/(size()-1), 1/2);
        return sigmaTotal;
    }
    
    public synchronized void print(){
      if ( isVoid()) {
         System.out.println( "Lista vacia, por lo anto no se puede recorrer");
         return;
      }
      NodoEntity actual = linkedListEntity.primero;

      // mientras no es el final de la lista, se muestra
      // el dato del nodo actual
      while ( actual != null ) {
         System.out.print( actual.getData().toString() + " " );
         actual = actual.getNext();
      }

      System.out.println( "\n" );
   }
    
   

    
}
