package purifier;

import java.io.*;
import java.util.*;

/**
 *
 * @author big
 */
public class Purifier {
    static private String separator = "<SEP>";
    static private int numberOfColumnsToCompare = 3;
    static private int[] indexesOfColumnsToCompare = {0, 2, 3};
    
    static private int numberOfColumnsForSort = 3;
    static private int[] orderOfSorting = {0, 2, 3};
    
    static private ArrayList<String> Lista = new ArrayList<>();

    static private BufferedReader inputBuffer1;
    static private FileWriter outputWriter;
    
    static private int removed=0;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        purify();
    }
     
    public static void purify() throws FileNotFoundException,IOException{
        
        
        setPathToFileRead();
        setPathToFileWrite();
        setSeparator();
        setColumsToCompare();
        importList(Lista);
        clean(Lista);
        writeOnFile(Lista);
        
       
    }
    
    private static void setPathToFileRead() throws FileNotFoundException, IOException {
        System.out.print("Insert file's path of the repository to purify: ");
        inputBuffer1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(new Scanner(System.in).nextLine()))));
        
    }
    
    private static void setPathToFileWrite() throws FileNotFoundException, IOException{
        System.out.print("Insert path where to save the purified file: ");
        outputWriter = new FileWriter(new Scanner(System.in).nextLine()+"/purified.txt");        
    }
    
    private static void setSeparator(){
        System.out.print("Type the separator used in the file, Default is <SEP>: ");
        String choice =new Scanner(System.in).nextLine();
        if(!choice.equals("")) separator = choice;
    }
    
    private static void setColumsToCompare(){
        System.out.print("Type the number of the columns to compare, default is 3: ");
        String sceltaNumeroColonne  = new Scanner(System.in).nextLine();
        
        if(!sceltaNumeroColonne.equals("")) numberOfColumnsToCompare = Integer.parseInt(sceltaNumeroColonne);
        System.out.print("\r");
        
        if(numberOfColumnsToCompare == 3){
            System.out.println("Choose indexes of the columns to compare, starting from 0.");
            System.out.print("Type values separated by spaces, default columns are; 0 2 3: ");
            String scelta = new Scanner(System.in).nextLine();
            if(!scelta.equals("")){
                indexesOfColumnsToCompare = new int[numberOfColumnsToCompare];
                for (int i = 0; i < numberOfColumnsToCompare; i++) {
                    indexesOfColumnsToCompare[i] = Integer.parseInt(scelta.split(" ")[i]);
                }
            }

        } else {  
            System.out.println("Choose indexes of the columns to compare, starting from 0.");
            System.out.println("Type values separated by spaces (ex: 0 1 2): ");
            for(int i = 0; i<numberOfColumnsToCompare; i++){
                System.out.print("index " + (i+1) + ": ");
                indexesOfColumnsToCompare[i] = new Scanner(System.in).nextInt();
            }    
        }    
    }
    
    private static void importList(ArrayList<String> l) throws IOException, FileNotFoundException {
        String currentLine;
        while((currentLine = inputBuffer1.readLine()) != null){
            l.add(currentLine);
        }
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
    
    private static void clean(ArrayList<String> l){
        int splitProblem = l.size()/4;
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
    
    private static void writeOnFile(ArrayList<String> l) throws FileNotFoundException, IOException{
        for(int i = 0; i<l.size(); i++){
            outputWriter.write( l.get(i) + "\n"); 
        }
        outputWriter.flush();
    }
    
    private static void mergeSort(ArrayList<String> l){
        System.out.println("Select how many columns according to wich to sort the file's lines, "+"default is 3");
        String choice = new Scanner(System.in).nextLine();
        if (!choice.equals("")) numberOfColumnsForSort = Integer.parseInt(choice);
        
        if(numberOfColumnsForSort == 3){
            System.out.println("Type,in order of precedence and separed by spaces, the indexes of colum used to sort the file's lines, "+"default are 0 2 3:");
            choice = new Scanner(System.in).nextLine();
            if(!choice.equals("")){
                for (int i = 0; i < numberOfColumnsForSort; i++) {
                    orderOfSorting[i] = Integer.parseInt(choice.split(" ")[i]);
                }
            }
        } else {
            orderOfSorting = new int[numberOfColumnsForSort];
            System.out.println("Type,in order of precedence and separed by spaces, the indexes of colum used to sort the file's lines, "+"ex: 0 8 5 12 2:");
            choice = new Scanner(System.in).nextLine();
                for (int i = 0; i < numberOfColumnsForSort; i++) {
                    orderOfSorting[i] = Integer.parseInt(choice.split(" ")[i]);
                }
        }
        
        
        
        
    }
}

