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

    public NodoEntity(Object data, NodoEntity next) {
        this.data = data;
        this.next = next;
    }
    
        public NodoEntity(Object data) {
        this.data = data;
        this.next = null;
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
