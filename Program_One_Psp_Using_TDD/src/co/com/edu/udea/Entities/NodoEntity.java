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
public class NodoEntity {
    private Object data;
    private NodoEntity next;
    private double xParameter;
    private double yParameter;
    
    
    public NodoEntity(Object data, NodoEntity next) {
        this.data = data;
        this.next = next;
    }
    
    public NodoEntity(double xParameter,double yParameter, NodoEntity next) {
        this.xParameter = xParameter;
        this.yParameter = yParameter;
        this.next = next;
    }    
    
    public NodoEntity(double xParameter,double yParameter) {
        this.xParameter = xParameter;
        this.yParameter = yParameter;
    }
    
    public NodoEntity(Object data) {
        this.data = data;
        this.next = null;
    }

    public double getxParameter() {
        return xParameter;
    }

    public void setxParameter(double xParameter) {
        this.xParameter = xParameter;
    }

    public double getyParameter() {
        return yParameter;
    }

    public void setyParameter(double yParameter) {
        this.yParameter = yParameter;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NodoEntity getNext() {
        return next;
    }

    public void setNext(NodoEntity next) {
        this.next = next;
    }

    
}
