/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.Controller;

import co.com.edu.udea.Commons.GlobalConfigProperties;
import co.com.edu.udea.Entities.CountLinesOfCodeEntity;
import co.com.edu.udea.Model.LinkedListModel;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author julianesten
 */
public class CountLinesOfCodeController {

    public static LinkedListModel linkedListModel = new LinkedListModel();
    private static ArrayList<File> extensions = new ArrayList();

    public static void insertFileDirectory() {
        final File folder = new File(GlobalConfigProperties.pathFolder);
        listFilesForFolder(folder);
        for (File javafile : extensions) {
            //Insert file content into the Local linkedList
            linkedListModel.insertObjectAfter(linkedListModel.getFileCount(javafile));
        }
        

    }

    private static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                String ext = getFileExtension(fileEntry);
                if (ext.equals("java")) {
                    extensions.add(fileEntry);
                }
            }
        }
    }
    
    public static CountLinesOfCodeEntity getTotalCount(){
        return linkedListModel.getTotalCount();
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

}
