import java.util.*;
import java.io.*;

/**
 * this program is used to implement Burrow-Wheeler transform
 * for data compression and compresses the data using a command line argument for a text file
 * 
 * @author John Luke Denny
 *
 */
public class BurrowsWheeler {
    
    public static void main(String[] args) throws FileNotFoundException{
        //text file input
        File in = new File(args[0]);
        Scanner input = new Scanner(in);
        
        String inString = "";
        //assumes the character size of the input file is less than 2147483641(six less than max integer)
        while(input.hasNextLine()){
            inString += input.nextLine();
        }
        
        PrintWriter outFile = new PrintWriter("compressed.txt");
        
        String transformed = encode(inString);
        String comped = compressed(transformed);
        
        outFile.print(comped);
        outFile.close();
    }
    
    //creates a string altered by the Burrows-Wheeler transform
    private static String encode(String uncoded){
        String encoded = "";
        String[] suff = suffix(uncoded);
        int length = uncoded.length();
        //does Burrows-Wheeler transform
        for(int i = 0; i < suff.length; i++){
            //converts a hex string into an integer
            int initialPos = (int) Long.parseLong(suff[i].substring(suff[i].length()- 6), 16);
            if(initialPos == 0){
                int EOFPos = i;//stores the position of the final character of the initial string
                String hex = Integer.toHexString(EOFPos);
                while(hex.length() < 6){//stores final character position as a six character hex
                    hex = "0" + hex;
                }
                encoded = hex + encoded;
            }
            encoded += uncoded.charAt((initialPos - 1 + length) % length);
        }
        
        return encoded;
    }

    //creates a suffix array with the original position stored
    private static String[] suffix(String full){
        String[] suff = new String[full.length()];
        
        for(int i = 0; i < full.length(); i++){
            String hex = Integer.toHexString(i);
            while(hex.length() < 6){
                hex = "0" + hex;
            }
            suff[i] = full.substring(i) + hex;//makes last six characters the original position
        }
        Arrays.sort(suff);
        return suff;
    }
    
    private static String compressed(String transformed){
        String comp = transformed.substring(0,6);//maintain the hex position
        int start, end;
        for(start = 6; start < transformed.length(); start = end){//has start character after hex position, and updating start to end
            int count = -1;// reset repeated character count 0 means one repeated character but not extra
            end = start + 1;
            //keeps total repeated characters to two hex letters
            while(end < transformed.length() && transformed.charAt(start) == transformed.charAt(end) && count < 256){
                count++;
                end++;
            }
            
            if(count > -1){//meaning more than two of the same character in a row
                String hex = Integer.toHexString(count);
                while(hex.length() < 2){
                    hex = "0" + hex;
                }
                //hex tells of how many more after the two sequential to identify
                comp += "" + transformed.charAt(start) + "" + transformed.charAt(start) + "/" + hex;
            }
            else{
                comp += transformed.charAt(start);
            }
            
        }

        return comp;
    }
}