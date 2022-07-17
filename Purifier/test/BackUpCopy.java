


import java.io.*;
import java.util.*;

/**
 *
 * @author big
 */
public class BackUpCopy {
    static private String separator = "<SEP>";
    
    static private int numberOfColumnsToCompare = 3;
    static private int[] indexesOfColumnsToCompare = {0, 2, 3};
    
    static private int numberOfColumnsForSort = 3;
    static private int[] orderOfSorting = {0, 2, 3};
    
    static private ArrayList<String> Lista = new ArrayList<>();
    static private String[] Array = {"0","1","2"};

    static private String pathToFileRead = "/Users/big/Desktop/Canzoni.dati.non-filtrato.txt";
    static private String pathToFileWrite = "/Users/big/Desktop/purified.txt";
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //Lista = importInList();
        //cleanList(Lista);
        //Array = fromListToArray(Lista);
        Array = importInArray();
        sortAccordingOneColum(Array, 0, Array.length, 3);
        writeOnFile(Array);
    }
     
    public static void purify() throws FileNotFoundException,IOException{

        setPathToFileRead();
        setPathToFileWrite();
        setSeparator();
        setColumsToCompare();
        Lista = importInList();
        cleanList(Lista);
        writeOnFile(Lista);
  
    }
    
    private static void setPathToFileRead() throws FileNotFoundException, IOException {
        System.out.print("Insert file's path of the file to treat: ");
        pathToFileRead = new Scanner(System.in).nextLine();
    }
    
    private static void setPathToFileWrite() throws FileNotFoundException, IOException{
        System.out.print("Insert path where to save the treated file: ");
        pathToFileWrite = new Scanner(System.in).nextLine()+"/purified.txt";        
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
    
    private static ArrayList<String> importInList() throws IOException, FileNotFoundException {
        BufferedReader input= new BufferedReader(new FileReader(pathToFileRead));
        ArrayList<String> aux = new ArrayList<>();
        String currentLine;
        while((currentLine = input.readLine()) != null){
            aux.add(currentLine);
        }
        
        return aux;
    }
    
    private static String[] importInArray() throws IOException, FileNotFoundException {
        
        BufferedReader input = new BufferedReader(new FileReader(pathToFileRead));
        int dim=0;
        while(input.readLine() != null){
            dim++;
        }
        input.close();
        
        input = new BufferedReader(new FileReader(pathToFileRead));
        String[] a = new String[dim];
        a = new String[dim];
        for (int i = 0; i < dim; i++) {
            a[i] = input.readLine();
        }
        input.close();
        
        return a;
   
    }
    
    private static String[] fromListToArray(ArrayList<String> list){
        
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        return array;
    } 
    
    private static ArrayList<String> fromArrayToList(String[] array){
        ArrayList<String> aux = new ArrayList<>();
        
        for (int i = 0; i < array.length; i++) {
            aux.add(array[i]);
        }
        return aux;
    }
    
    private static void stampaArray(String[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
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
    
    private static void writeOnFile(ArrayList<String> l) throws FileNotFoundException, IOException{
        
        FileWriter outputWriter = new FileWriter(pathToFileWrite);
        for(int i = 0; i<l.size(); i++){
            outputWriter.write( l.get(i) + "\n"); 
        }
        outputWriter.flush();
    }
    
    private static void writeOnFile(String[] s) throws FileNotFoundException, IOException{
        
        FileWriter outputWriter = new FileWriter(pathToFileWrite);
        for(int i = 0; i<s.length; i++){
            outputWriter.write( s.length + "\n"); 
        }
        outputWriter.flush();
    }
    
    private static void sortAccordingMoreColumns(String[] a, int[] indexesOfColumnsToSortInOrderOfPriority){
        int indexColumnSortingNow = 0;
        sortAccordingOneColum(a,0,a.length,indexesOfColumnsToSortInOrderOfPriority[indexColumnSortingNow]);
        
        indexColumnSortingNow++;
        
        int StartIndexes = 0;
        int count = 0;
        int countrow = 0;
        
        for (int i = indexColumnSortingNow; i < indexesOfColumnsToSortInOrderOfPriority.length; i++) {
            while(count<a.length){
            
                String now = a[StartIndexes].split(separator)[indexColumnSortingNow];
                while(a[count].split(separator)[indexColumnSortingNow].equalsIgnoreCase(now)&& count<a.length-1){
                    countrow++;
                    count++;
                }
            
                sortAccordingOneColum(a, StartIndexes, StartIndexes+countrow, indexesOfColumnsToSortInOrderOfPriority[indexColumnSortingNow]);
                StartIndexes = StartIndexes + ++count;
                countrow = 0;
            } 
        }
        
        
    }
   
    private static void sortAccordingOneColum(String[] a,int low,int high,int indexOfColumnToCompare){
        
        int N = a.length;
        for (int i = low +1; i < high; i++) {
            int j = i;
            while (j > 0 && less(a[j], a[j - 1],indexOfColumnToCompare)) {
                exchange(a, j, j - 1);
                j--; 
            }
        }

    }
    
    private static boolean less(String s1,String s2,int indexColumnToCompare){
        String x = s1.split(separator)[indexColumnToCompare];
        String y = s2.split(separator)[indexColumnToCompare];

        for (int i = 0; i < x.length() && i<y.length(); i++) {
            if(Character.valueOf(x.charAt(i)) == Character.valueOf(y.charAt(i))) continue;
            else{ return Character.valueOf(x.charAt(i)) < Character.valueOf(y.charAt(i)); }
        }
        return(x.length()<y.length());
    }
    
    private static void exchange(String[] a,int index1,int index2){
        String aux = a[index1];
        a[index1] = a[index2];
        a[index2] = aux;
    }
}

