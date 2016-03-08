/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.UnitTest;

import co.com.edu.udea.Model.LinkedListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julianesten
 */
public class TestUnitLinkedList {
    private static final double DELTA = 1e-15;
    public TestUnitLinkedList() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void isVoid(){
        LinkedListModel linkedListModel = new LinkedListModel();
        assertEquals(linkedListModel.isVoid(), true);
                
    }
    
    @Test
    public void insertObjectAfter(){
        LinkedListModel linkedListModel = new LinkedListModel();
//        assertEquals(linkedListModel.insertObjectAfter(3),true);
    }
    @Test
    public void size(){
        LinkedListModel linkedListModel = new LinkedListModel();
        assertEquals(linkedListModel.size(), 0);
    }
    @Test
    public void getLinkedList(){
        //assertEquals(linkedListModel.getLinkedList(),linkedListEntity);
    }
    
    @Test
    public void print(){}
    
    @Test
    public void avg(){
        LinkedListModel linkedListModel = new LinkedListModel();
        String list = "12345";
        for(int i = 0; i<list.length();i++){
            linkedListModel.insertObjectAfter(list.charAt(i));
        }
        int avg =  (int) linkedListModel.avg();
        assertEquals(3, 3);
    }
    
    @Test
    public void standarDeviation(){
        LinkedListModel linkedListModel = new LinkedListModel();
        String list = "12345";
        for(int i = 0; i<list.length();i++){
            linkedListModel.insertObjectAfter(list.charAt(i));
        }
        assertEquals(1, (int)linkedListModel.standarDeviaton());
    
    }
    
    @Test
    public void classesCount(){}    
    
    
}
