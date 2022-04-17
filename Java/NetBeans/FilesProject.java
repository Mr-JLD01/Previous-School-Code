/*
Student Name: John Luke Denny
LSU ID: 896463927
Lab Section: 001
Assignment: Files and IO
Submission Time: 6:03 PM
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesproject;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class FilesProject {
    

    //asks for a number of files and size of the files, and runs two methods with the numbers entered
    public static void main(String[] args)throws FileNotFoundException 
    {
        System.out.println("Please enter the number of files: ");
        Scanner in = new Scanner(System.in);
        int numFiles = in.nextInt();
        
        System.out.println("Please enter the number for the size of the files: ");
        int fileSize = in.nextInt();
        
        populateFiles(numFiles, fileSize);
        calculateStat(numFiles, fileSize);
    }
    
    //fills the files with random numbers between 1 and 10
    public static void populateFiles(int n, int s) throws FileNotFoundException 
    {
        for(int i = 1; i <= n; i++){
            PrintWriter outfile = new PrintWriter("numbers_" + i + ".txt");
            Random rand = new Random();
            
            for(int j = 0; j < s; j++){
                outfile.println(rand.nextInt(9) + 1);
            }
            
            outfile.close();
        }
    }
    
    //takes the information on the files and claculates the mean and sum of the random numbers
    public static void calculateStat(int n, int s) throws FileNotFoundException
    {
        PrintWriter stat = new PrintWriter("stats.txt");
        
        for(int i = 1; i <= n; i++){
            File numFile = new File("numbers_" + i + ".txt");
            Scanner inNum = new Scanner(numFile);
            int sum = 0;
            
            while(inNum.hasNextInt()){
                sum += inNum.nextInt();
            }
            float mean = sum / s;
            stat.printf("%s\t%d\t%.3f\n", "numbers_" + i + ".txt", sum, mean);
        }
        
        stat.close();
    }
}
