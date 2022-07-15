/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package purifier;

import java.io.*;

/**
 *
 * @author big
 */
public class performer {
    public static void main(String[] args) throws IOException,FileNotFoundException{
        String inputPath = Purifier.pathToFileRead;
        String outputPath = Purifier.pathToFileWrite;
        String separator = Purifier.separator;
        //ArrayList<String> list = Purifier.importInList(inputPath);
        //Purifier.stampaLista(list);
        //Purifier.cleanList(list);
        String[] vettore = Purifier.importInArray(inputPath);
        Sorter heap = new Sorter(vettore.length, 2);
        heap.heapSort(vettore, 3);
        //Purifier.stampaArray(lista);
        Purifier.writeOnFile(vettore,outputPath);
        
    }
}
