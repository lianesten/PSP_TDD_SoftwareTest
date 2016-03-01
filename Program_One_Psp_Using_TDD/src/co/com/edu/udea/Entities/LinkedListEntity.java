/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Entities;


public class LinkedListEntity {
    public NodoEntity primero;
    public NodoEntity ultimo;

    public NodoEntity getPrimero() {
        return primero;
    }

    public void setPrimero(NodoEntity primero) {
        this.primero = primero;
    }

    public NodoEntity getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoEntity ultimo) {
        this.ultimo = ultimo;
    }
    
 
    
    public LinkedListEntity(){
        this.primero = null;
        this.ultimo = null;
    }
    
    
}
