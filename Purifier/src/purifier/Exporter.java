/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package purifier;

import java.io.*;
import java.util.*;

/**
 *
 * @author big
 */
public class Exporter {
    public static void  fromArrayIntoFile(String[] arr,String pathToFileWrite) throws IOException{
        
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(pathToFileWrite));
        for(int i = 0; i<arr.length; i++){
            outputWriter.write( arr[i] + "\n"); 
        }
        outputWriter.flush();
    }
    
    public static void fromListIntoFile(ArrayList<String> list,String pathToFileWrite) throws IOException{
        
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(pathToFileWrite));
        for(int i = 0; i<list.size(); i++){
            outputWriter.write( list.get(i) + "\n"); 
        }
        outputWriter.flush();
        
    }
}
