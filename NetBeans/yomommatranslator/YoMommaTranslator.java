//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Yo momma translator (collections)
//Submission Time: 5:45

package yomommatranslator;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author jdenny3
 */
public class YoMommaTranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        
        Map<String, String> translator = new HashMap<>();
        
        File inFile = new File("acronyms.txt");
        Scanner in = new Scanner(inFile);
       
        while(in.hasNextLine())
        {
            String line = in.nextLine();
            String[] split = line.split("\\t");
            translator.put(split[0].toLowerCase(), split[1]);
        }
        
        System.out.println("Welcome to the Yo Momma Translator! To stop translation, enter \"end\" as your sentence.");
        
        Scanner userInput = new Scanner(System.in).useDelimiter("\\n");
        String user = "";
        
        while(!(user.toLowerCase().equals("end")))
        {
            String translated = "";
            System.out.println("Enter a phrase to be translated!");
            user = userInput.next();
            String[] split = user.split("\\s+");
            
            for(String word : split)
            {
                if(translator.containsKey(word.toLowerCase()))
                    translated += " " + translator.get(word.toLowerCase());
                else
                    translated += " " + word;
            }
            translated += ".";
            if(!(user.equals("end")))
                System.out.println("Your translated phrase is : " + translated + "\n");
        }
    }
    
}
