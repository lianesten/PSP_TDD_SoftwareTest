/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Entities;

/**
 *
 * @author julianesten
 */
public class CountLinesOfCodeEntity {
    private String nameFile;
    private String pathFile;
    private int classes;
    private int instances;
    private int cycles;
    private int conditionals;    
    private int variablesDeclarations;  
    private int methods;
    private int constructors;

    public CountLinesOfCodeEntity(){}
    public CountLinesOfCodeEntity(String nameFile, String pathFile, int classes, int instances, int cycles, int conditionals, int variablesDeclarations, int metodos, int intconstructors) {
        this.nameFile = nameFile;
        this.pathFile = pathFile;
        this.classes = classes;
        this.instances = instances;
        this.cycles = cycles;
        this.conditionals = conditionals;
        this.variablesDeclarations = variablesDeclarations;
        this.methods = metodos;
        this.constructors = intconstructors;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int getConditionals() {
        return conditionals;
    }

    public void setConditionals(int conditionals) {
        this.conditionals = conditionals;
    }

    public int getVariablesDeclarations() {
        return variablesDeclarations;
    }

    public void setVariablesDeclarations(int variablesDeclarations) {
        this.variablesDeclarations = variablesDeclarations;
    }

    public int getmethods() {
        return methods;
    }

    public void setmethods(int methods) {
        this.methods = methods;
    }

    public int getConstructors() {
        return constructors;
    }

    public void setConstructors(int constructors) {
        this.constructors = constructors;
    }
    
    
    
}
