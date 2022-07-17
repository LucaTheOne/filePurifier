
package purifier;

import java.util.*;

/**
 *
 * @author big
 */
public class Utilities {
    public static String[] fromListToArray(ArrayList<String> list){
        
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        return array;
    } 
    
    public static ArrayList<String> fromArrayToList(String[] array){
        ArrayList<String> aux = new ArrayList<>();
        
        for (int i = 0; i < array.length; i++) {
            aux.add(array[i]);
        }
        return aux;
    }
    
    static void printArrayOnTerminal(String[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    static void printListOnTerminal(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
}
