
package purifier;

import java.io.*;

/**
 *
 * @author big
 */
public class Purifier {
    public static void main(String[] args) throws IOException,FileNotFoundException{
        String[] fileToTreat = Importer.fromFileIntoArray();
        Cleaner purifier = new Cleaner(fileToTreat);
        fileToTreat = purifier.cleanArray();
        Exporter.fromArrayIntoFile(fileToTreat, ParamSetter.setPathToFileWrite());
        
    }
}
