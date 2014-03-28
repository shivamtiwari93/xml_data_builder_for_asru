/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import XMLGenerator.MakeXML;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Shivam Tiwari
 */
public class GenerateData extends Application {
    String targetFolder;
    long sizeOfData;
    long currSize;
    int minSwitch;
    int maxSwitch;
    
    long fileNumber;
    String fileAddress;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, UnsupportedEncodingException{
        
        primaryStage.setTitle("XML Data-Builder for ASRU");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Text scenetitle = new Text("Creating data...");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        ProgressBar pb = new ProgressBar();
        pb.setMinWidth(400);
        pb.setMinHeight(20);
        grid.add(pb, 0, 1);
        
        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        
        Button btn = new Button("Abort");
        btn.setCancelButton(true);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 5);
        
        btn.setOnAction((ActionEvent e) -> {
            FinishPage fp = new FinishPage(false);
            fp.start(primaryStage);
        });
        
        MakeXML generator;
        
        while(currSize < sizeOfData){
            
            fileNumber++;
            fileAddress = targetFolder + "/" + String.valueOf(fileNumber) + ".xml";
            generator = new MakeXML(minSwitch,maxSwitch,fileAddress,fileNumber);
            currSize = currSize + generator.makeFile();
            pb.setProgress((float)currSize/(float)sizeOfData);
            primaryStage.show();
            
        }
        
        pb.setProgress(1);
        
        if(pb.getProgress() == 1){
            FinishPage fp = new FinishPage(true);
            fp.start(primaryStage);
        }
        
        primaryStage.show();
    }
    
    public GenerateData(String x, long y,int a, int b){
        this.targetFolder = x;
        this.sizeOfData = y;
        this.minSwitch = a;
        this.maxSwitch = b;
        this.fileNumber = 0;
        this.currSize = 0;
    }
}
