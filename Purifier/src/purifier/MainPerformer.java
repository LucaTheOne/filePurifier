
package purifier;

import java.io.*;

/**
 *
 * @author big
 */
public class MainPerformer {
    public static void main(String[] args) throws IOException,FileNotFoundException{
        String inputPath = Purifier.pathToFileRead;
        String outputPath = Purifier.pathToFileWrite;
        String separator = Purifier.separator;
        //ArrayList<String> list = Purifier.importInList(inputPath);
        //Purifier.stampaLista(list);
        //Purifier.cleanList(list);
        String[] vettore = Purifier.importInArray(inputPath);
        HeapSorter.heapSort(vettore, separator, 2);
        //Purifier.stampaArray(lista);
        Purifier.writeOnFile(vettore,outputPath);
        
    }
}
