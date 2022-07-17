package purifier;

import java.util.*;

/**
 *
 * @author big
 */
public class Cleaner {
    public String separator;

    public int[] indexesOfColumnsToCompare;
    
    private ArrayList<String> lista;
    
    private String[] array;

    //public String pathToFileRead;
    
    
    Cleaner(String[] arrayToPurify){
        //pathToFileRead = ParamSetter.setPathToFileRead();
        separator = ParamSetter.setSeparator();
        indexesOfColumnsToCompare = ParamSetter.setColumsToConsider();
        array = arrayToPurify;
    }
    
    private boolean linesEquals(String stringa1, String stringa2){
        String[] alfa = stringa1.split(separator);
        String[] beta = stringa2.split(separator);
        boolean equals = true;
        
        for (int i = 0; i < indexesOfColumnsToCompare.length; i++) {
            equals = equals && (alfa[indexesOfColumnsToCompare[i]].equalsIgnoreCase(beta[indexesOfColumnsToCompare[i]])); 
        }
        
        return equals;
    }
    
    public void cleanList(){
    
        int removed = 0;
        int splitProblem = lista.size()/4;
        //1/4
        for(int i = 0; i<splitProblem;i++){
            while(linesEquals(lista.get(i), lista.get((i+1)))){
                lista.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(lista.get(i), lista.get((j)))) {
                    lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        //2/4
        for(int i = splitProblem; i<2*splitProblem;i++){
           while(linesEquals(lista.get(i), lista.get((i+1)))){
                lista.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(lista.get(i), lista.get((j)))) {
                    lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        
        //3/4
        for(int i = 2*splitProblem; i<3*splitProblem;i++){
            while(linesEquals(lista.get(i), lista.get((i+1)))){
                lista.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(lista.get(i), lista.get((j)))) {
                    lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        //4/4
        for(int i = 3*splitProblem; i<lista.size()-7;i++){
            while(linesEquals(lista.get(i), lista.get((i+1)))){
                lista.remove(i+1);
                removed++;
            }
            for(int j = i+2;j<i+7;j++){
                if (linesEquals(lista.get(i), lista.get((j)))) {
                    lista.remove(j);
                    j--;
                    removed++;
                }
            }
        }
        System.out.println("Have been deleted "+removed+" lines!");
    }
    
    public String[] cleanArray(){
        int removedCounter=0;
        boolean[] doubles = new boolean[array.length];
        for(int i = 0;i<doubles.length;i++){
            doubles[i] = false;
        }
        for (int i = 0; i < array.length-2; i++) {
            for(int j = i+1;j<array.length-1;i++){
                if(linesEquals(array[i], array[j])){
                    doubles[j] = true;
                    removedCounter++;
                }
            }
        }
        
        String[] aux = new String[array.length-removedCounter];
        int segnaposto = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                aux[segnaposto++] = array[i];
            }
        }
        
        array = aux;
        return array;
    }
  
}

