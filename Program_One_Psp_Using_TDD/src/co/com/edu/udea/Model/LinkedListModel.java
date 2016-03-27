/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Model;

import co.com.edu.udea.Entities.CountLinesOfCodeEntity;
import co.com.edu.udea.Entities.LinkedListEntity;
import co.com.edu.udea.Entities.NodoEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author julianesten
 */
public class LinkedListModel {

    LinkedListEntity linkedListEntity = new LinkedListEntity();

    public boolean isVoid() {
        return linkedListEntity.primero == null;

    }

    public void insertObjectAfter(Object data) {
        Boolean isInsert = false;
        if (isVoid()) {
            linkedListEntity.primero = linkedListEntity.ultimo = new NodoEntity(data);
            isInsert = true;
        } else {
            linkedListEntity.primero = new NodoEntity(data, linkedListEntity.primero);
//            isInsert= true;
        }
//        return isInsert;
    }
    
    public void insertObjectAfterNodoRegression(double xParameter,double yParameter) {
        if (isVoid()) {
            linkedListEntity.primero = linkedListEntity.ultimo = new NodoEntity(xParameter,yParameter);
        } else {
            linkedListEntity.primero = new NodoEntity(xParameter,yParameter, linkedListEntity.primero);
        }
    }    

    public int size() {
        int size = 0;
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            size = size + 1;
            actual = actual.getNext();
        }
        return size;
    }

    public LinkedListEntity getLinkedList() {
        return linkedListEntity;
    }

    //Those methods must not be here
    public double avg() {
        double avg = 0, avgTotal = 0;
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            avg = avg + Double.parseDouble(actual.getData().toString());
//            avg = avg +  (Integer) actual.getData();
            actual = actual.getNext();
        }
        avgTotal = avg / size();

        return avgTotal;
    }
    
    public double localAvgX() {
        double avg = 0, avgTotal = 0;
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            avg = avg + actual.getxParameter();
            actual = actual.getNext();
        }
        avgTotal = avg / size();
        return avgTotal;
    }    
    
    public double localAvgY() {
        double avg = 0, avgTotal = 0;
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            avg = avg + actual.getyParameter();
            actual = actual.getNext();
        }
        avgTotal = avg / size();
        return avgTotal;
    }        
    
    

    //Estos metodo no deberia de ir aqui
    public double standarDeviaton() {
        double sigma = 0, i = 0, sigmaTotal = 0, sumatoria = 0;
        double avg = avg();
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            i = Double.parseDouble(actual.getData().toString());
            sumatoria = Math.pow(i - avg, 2);
            sigma = sigma + sumatoria;
            actual = actual.getNext();
        }
        sigmaTotal = Math.sqrt(sigma / 9);//Math.pow(sigma/(size()-1), 1/2);
        return sigmaTotal;
    }

    public synchronized void print() {
        if (isVoid()) {
            System.out.println("Emty list, no data!");
            return;
        }
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            System.out.print(actual.getData().toString() + " ");
            actual = actual.getNext();
        }

        System.out.println("\n");
    }

    public CountLinesOfCodeEntity getFileCount(File javaFile) {
        CountLinesOfCodeEntity entity = null;
        String temp = "", content = "";
        int i = 0, classes = 0, instances = 0, cycles = 0, conditionals = 0, variablesDeclarations = 0, methods = 0;
        try {
            FileReader file = new FileReader(javaFile);
            BufferedReader read = new BufferedReader(file);
            //File iterator
            while ((temp = read.readLine()) != null) {
//                Method[] a = this.getClass().getDeclaredMethods();
                if (temp.contains("class")) {
                    classes += 1;
                }
                
                if(temp.contains(" public void") || temp.contains(" public double")){
                    methods += 1;
                }

                if (temp.contains("new")) {
                    instances += 1;
                }

                if (temp.contains(" while") || temp.contains(" for")) {
                    cycles += 1;
                }

                if (temp.contains("if")) {
                    conditionals += 1;
                }

                if (temp.replace(" ", "").contains("byte")
                        || temp.replace(" ", "").contains("short")
                        || temp.replace(" ", "").contains("int")
                        || temp.replace(" ", "").contains("long")
                        || temp.replace(" ", "").contains("float")
                        || temp.replace(" ", "").contains("double")
                        || temp.replace(" ", "").contains("char")
                        || temp.replace(" ", "").contains("String")
                        || temp.replace(" ", "").contains("boolean")) {
                    variablesDeclarations += 1;
                }

//                System.out.println("Line #"+i+": "+temp);
//                content += temp + "\n";
                i = 0;
            }
            read.close();
            entity = new CountLinesOfCodeEntity(
                    javaFile.getName(),
                    javaFile.getPath(),
                    classes,
                    instances,
                    cycles,
                    conditionals,
                    variablesDeclarations,
                    methods,
                    instances);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }

        return entity;

    }

    public CountLinesOfCodeEntity getTotalCount() {
        CountLinesOfCodeEntity entityAux = new CountLinesOfCodeEntity();
         CountLinesOfCodeEntity entity;
        int classes = 0, instances = 0, cycles = 0, conditionals = 0, variablesDeclarations = 0, methods = 0,constructors=0;
        if (isVoid()) {
            System.out.println("Empty list!, no data!");
            return null;
        }
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
           entityAux = (CountLinesOfCodeEntity) actual.getData();
           classes += entityAux.getClasses();
           instances += entityAux.getInstances();
           cycles+=entityAux.getCycles();
           conditionals+=entityAux.getConditionals();
           variablesDeclarations+=entityAux.getVariablesDeclarations();
           methods+=entityAux.getmethods();
           constructors+=entityAux.getConstructors();
            actual = actual.getNext();
        }
        entity = new CountLinesOfCodeEntity(null, null, classes, instances, cycles, conditionals, variablesDeclarations, methods, constructors);
        return entity;
    }
    
    
    //==Linear Regression==
    public double linearRegressionB1(){
        double sumXY = 0,sumXPotencia = 0,B1;
        int n ;
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            sumXY = sumXY + actual.getxParameter()*actual.getyParameter();
            sumXPotencia = sumXPotencia + Math.pow(actual.getxParameter(), 2);
            actual = actual.getNext();
        }        
        n = size();
        B1 = ((sumXY)-(n*localAvgX()*localAvgY()))/((sumXPotencia)-(n*Math.pow(localAvgX(), 2)));
        
        return B1;
    }
    
    public double linearRegresionB0(){
        double B0 =0;
        B0 = localAvgY() - (linearRegressionB1()*localAvgX());
        return B0;
    }
    
    public double correlationCoefficient(){
        double sumXY=0,sumX=0,sumY=0,sumXPow=0,sumYPow=0,rxy=0,n=0;
        NodoEntity actual = linkedListEntity.primero;
        while (actual != null) {
            sumXY = sumXY + actual.getxParameter()*actual.getyParameter();
            sumX = sumX + actual.getxParameter();
            sumY = sumY + actual.getyParameter();
            sumXPow = sumXPow + Math.pow(actual.getxParameter(), 2);
            sumYPow = sumYPow + Math.pow(actual.getyParameter(), 2);
            actual = actual.getNext();
        }
        n=size();
        rxy = ((n*sumXY)-(sumX*sumY))/(Math.sqrt(((n*sumXPow)-Math.pow(sumX, 2))*((n*sumYPow)-Math.pow(sumY, 2))));
        return rxy;
    }
    
    public double getRPow(){
        return Math.pow(correlationCoefficient(), 2);
    }
    
    public double getYk(Double xk){//Yk = Bo+B1Xk
        return linearRegresionB0() + linearRegressionB1()*xk;
    }
    
    //==END Linear Regression==

}
