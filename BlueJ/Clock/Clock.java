
/*
 * Name: Denny, John
 * Project: PA-2 (Page Replacement Algorithm)
 * File: Clock.java
 * Instructor: Feng Chen
 * Class: cs4103-sp21
 * LogonID: cs410326
 */

import java.util.*;
import java.io.*;

public class Clock
{
    //inputs
    public int memSize;
    public File in;
    public Scanner inFile;
    public int accessTime;
    public int swapInTime;
    public int swapOutTime;
    public File out;
    public PrintWriter outFile;
    
    //clock
    public int clockHand = 0;
    public ArrayList<Page> mem = new ArrayList<Page>();
    public Page[] simMemory = new Page[100];
    
    //other outputs
    public int numPageRef = 0;
    public int numReadFault = 0;
    public int numWriteFault = 0;
    public int totalAccessTime = 0;
    public int totalSwapInTime = 0;
    public int totalSwapOutTime = 0;
    
    public static void main(String[] args)throws FileNotFoundException{
        Clock pageReplace = new Clock(args);
        
        while(pageReplace.inFile.hasNextLine()){
            String line = pageReplace.inFile.nextLine();
            String[] breakdown = line.split(" ");
            
            String instruction = breakdown[0];
            int pageNum = Integer.parseInt(breakdown[1]);
            
            //I understand this wastes space
            if(pageReplace.mem.get(pageNum) == null){
                pageReplace.mem.set(pageNum, new Page(pageNum));
            }
            
            //since numPageRef effectively equals numLines
            pageReplace.numPageRef++;
            
            if(pageReplace.pageHit(pageReplace.mem.get(pageNum), instruction)){
                pageReplace.outFile.println(String.format("%s %d H -1 %d 0 0", instruction, pageNum, pageReplace.accessTime));
                pageReplace.totalAccessTime += pageReplace.accessTime;
            }
            else{
                pageReplace.pageFault(pageReplace.mem.get(pageNum), instruction);
            }
        }
        pageReplace.inFile.close();
        pageReplace.outFile.close();
        System.out.println(pageReplace.toString());
        
    }
    
    public Clock(String[] args) throws FileNotFoundException{
        memSize = Integer.parseInt(args[0]);
        in = new File(args[1]);
        inFile = new Scanner(in);
        accessTime = Integer.parseInt(args[2]);
        swapInTime = Integer.parseInt(args[3]);
        swapOutTime = Integer.parseInt(args[4]);
        out = new File(args[5]);
        outFile = new PrintWriter(out);
        
        //did this to avoid null pointer errors
        for(int i = 0; i < 100; i++)
            mem.add(null);
        for(int i = 0; i < memSize; i++)
            simMemory[i] = new Page(-1);
            
    }
    
    //sees if page is in simulated cache
    public boolean pageHit(Page hit, String instruct){
        int i = clockHand;
        
        do{
            i++;
            if(i >= memSize)
                i = 0;           
            else if(mem.get(hit.getPageNum()) == simMemory[i]){//represents a page hit
                clockHand = i + 1;
                return true;
            }
            
        }while(!(i == memSize -1 && clockHand == memSize) && i != clockHand);//edge case when clockHand == memSize there is an infinite loop
        clockHand = i + 1;
        return false;
    }
    
    //If we know there isn't a hit, there has to be a fault and now to see what page to swap, if any
    public void pageFault(Page toSwap, String instruct){
        int tracker = clockHand;
        for(int i = 0; i < 3; i++){
            do{
                tracker++;
                if(tracker >= memSize)
                    tracker = 0;
                
                if(simMemory[tracker].getPageNum() == -1){//represents open page
                    swapIn(toSwap, tracker, instruct);
                    clockHand = tracker + 1;
                    outFile.println(String.format("%s %d F -1 %d %d 0", instruct, toSwap.getPageNum(), accessTime, swapInTime));
                    totalAccessTime += accessTime;
                    return;
                }
                
                if(simMemory[tracker].getReference())//simulates resource not used
                    simMemory[tracker].setReference(false);
                    
                else{
                    //although run same instructions, unmodified has priority to be swapped out
                    if(i > 0 && !simMemory[tracker].getModify()){//second run ensures there are no empty pages
                        swapOut(toSwap, simMemory[tracker], tracker, instruct);
                        clockHand = tracker + 1;
                        outFile.println(String.format("%s %d F %d %d %d %d", instruct, toSwap.getPageNum(), simMemory[tracker].getPageNum(),accessTime, swapInTime, swapOutTime));
                        totalAccessTime += accessTime;
                        return;
                    }
                    else if(i > 1){//have to see if any unmodified first, meaning cant do this on first or second runthrough
                        swapOut(toSwap, simMemory[tracker],tracker, instruct);
                        clockHand = tracker + 1;
                        outFile.println(String.format("%s %d F %d %d %d %d", instruct, toSwap.getPageNum(), simMemory[tracker].getPageNum(), accessTime, swapInTime, swapOutTime));
                        totalAccessTime += accessTime;
                        return;
                    }
                }
            }while(!(tracker == memSize -1 && clockHand == memSize) &&tracker != clockHand);//edge case when clockHand == memSize there is an infinite loop
        }
    }
    
    public void swapIn(Page page, int index, String instruct){
        page.setReference(true);
        if(instruct.equals("W")){
            page.setModify(true);
            numWriteFault++;
        }
        else if(instruct.equals("R"))
            numReadFault++;
        simMemory[index] = page;
        totalSwapInTime += swapInTime;
    }
    
    public void swapOut(Page in, Page victim, int index, String instruct){
        victim.setModify(false);//not guaranteed to be unmodified
        
        swapIn(in, index, instruct);
        totalSwapOutTime += swapOutTime;
    }
    
    public String toString(){
        return String.format("numPageRef: %d\nnumReadFault: %d\nnumWriteFault: %d\ntotalAccessTime: %d\ntotalSwapInTime: %d\ntotalSwapOutTime: %d\n", numPageRef, numReadFault, numWriteFault, totalAccessTime, totalSwapInTime, totalSwapOutTime);
    }
}
