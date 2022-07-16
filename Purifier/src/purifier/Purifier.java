package purifier;

import java.io.*;
import java.util.*;

/**
 *
 * @author big
 */
public class Purifier {
    static public String separator = "<SEP>";
    
    static private int numberOfColumnsToCompare = 3;
    static private int[] indexesOfColumnsToCompare = {0, 2, 3};
     
    static private int numberOfColumnsForSort = 3;
    static private int[] orderOfSorting = {0, 2, 3};
    
    static ArrayList<String> Lista = new ArrayList<>();
    static String[] Array = {"0","1","2"};

    static  String pathToFileRead = "/Users/big/Desktop/Canzoni.dati.txt";
    static  String pathToFileWrite = "/Users/big/Desktop/purified.txt";
     
    public static void purify() throws FileNotFoundException,IOException{

        
  
    }
    
    private static boolean linesEquals(String stringa1, String stringa2){
        String[] alfa = stringa1.split(separator);
        String[] beta = stringa2.split(separator);
        boolean equals = true;
        
        for (int i = 0; i < numberOfColumnsToCompare; i++) {
            equals = equals && (alfa[indexesOfColumnsToCompare[i]].equalsIgnoreCase(beta[indexesOfColumnsToCompare[i]])); 
        }
        
        return equals;
    }
    
    private static void cleanList(ArrayList<String> l){
    
        int removed = 0;
        int splitProblem = l.size()/4;
        //1/4
        for(int i = 0; i<splitProblem;i++){
            while(linesEquals(l.get(i), l.get((i+1)))){
                l.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(l.get(i), l.get((j)))) {
                    Lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        //2/4
        for(int i = splitProblem; i<2*splitProblem;i++){
           while(linesEquals(l.get(i), l.get((i+1)))){
                l.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(l.get(i), l.get((j)))) {
                    Lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        
        //3/4
        for(int i = 2*splitProblem; i<3*splitProblem;i++){
            while(linesEquals(l.get(i), l.get((i+1)))){
                l.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(l.get(i), l.get((j)))) {
                    Lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        //4/4
        for(int i = 3*splitProblem; i<l.size()-7;i++){
            while(linesEquals(l.get(i), l.get((i+1)))){
                l.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(l.get(i), l.get((j)))) {
                    Lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        System.out.println("Have been deleted "+removed+" lines!");
    }
  
}

