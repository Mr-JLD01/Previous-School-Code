
/*
 * Name: Denny, John
 * Project: PA-2 (Page Replacement Algorithm)
 * File: Page.java
 * Instructor: Feng Chen
 * Class: cs4103-sp21
 * LogonID: cs410326
 */

public class Page
{
    private int pageNum;
    private boolean modify, reference;

    //constructor for pages. Boolean variables always start false
    public Page(int num){
        pageNum = num;
        modify = false;
        reference = false;        
    }

    //mutator methods    
    public void setModify(boolean mod){
        modify = mod;
    }
    
    public void setReference(boolean ref){
        reference = ref;
    }
    
    //getter methods
    public int getPageNum(){
        return pageNum;
    }
    
    public boolean getModify(){
        return modify;
    }
    
    public boolean getReference(){
        return reference;
    }
}
