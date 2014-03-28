/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package XMLGenerator;

/**
 *
 * @author Shivam Tiwari
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
        
public class MakeXML{

    int minSwitch;
    int maxSwitch;
    int numOfSwitch;
    String file;
    long sizeOfFile;
    long fileNum;
    
    Random randObj = new Random();
    
    public long makeFile() throws FileNotFoundException, UnsupportedEncodingException{
        numOfSwitch = minSwitch + randObj.nextInt(maxSwitch - minSwitch);
        
        try (PrintWriter writer = new PrintWriter(file, "UTF-8")) {
            writer.println("<?xml version=\"1.0\"?>");
            writer.println();
            writer.println("<BaseID:" + fileNum + ">");
            
            for(int i=1;i<=numOfSwitch;i++){
                writer.println("<Switch" + i + ">");
                
                writer.println(randObj.nextInt(20));
                
                writer.println("</Switch" + i + ">");
            }
            
            writer.println("</BaseID:" + fileNum + ">");
        }
        
        File fileObj = new File(file);
        sizeOfFile = (long)fileObj.length();
            
        return sizeOfFile;
    }
    
    public MakeXML(int a, int b, String x, long y){
        this.maxSwitch = b;
        this.minSwitch = a;
        this.file = x;
        this.sizeOfFile = 0;
        this.fileNum = y;
    }
}