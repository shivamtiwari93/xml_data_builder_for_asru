/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package XMLGenerator;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Shivam Tiwari
 */
public class BuildXML {
    
    String targetFolder;
    long sizeOfData;
    long currSize;
    int minSwitch;
    int maxSwitch;
    
    long fileNumber;
    String fileAddress;
    
    MakeXML generator;
    
    public void buildFiles() throws FileNotFoundException, UnsupportedEncodingException{
        
        while(currSize < sizeOfData){
                
            fileNumber++;
            fileAddress = targetFolder + "/" + String.valueOf(fileNumber) + ".xml";
            generator = new MakeXML(minSwitch,maxSwitch,fileAddress,fileNumber);
            currSize = currSize + generator.makeFile();
        }
    }
    
    public BuildXML(String x, long y,int a, int b){
        
        this.targetFolder = x;
        this.sizeOfData = y;
        this.minSwitch = a;
        this.maxSwitch = b;
        this.fileNumber = 0;
        this.currSize = 0;
    }
}
