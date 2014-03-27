/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Shivam Tiwari
 */

public class Page1 extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("XML Data-Builder for ASRU");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Text scenetitle = new Text("Enter details");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label dataSize = new Label("Total size in bytes:");
        grid.add(dataSize, 0, 1);
        TextField sizeTextField = new TextField();
        grid.add(sizeTextField, 1, 1);
        
        Label minSwitch = new Label("Minimum number of switches:");
        grid.add(minSwitch, 0, 2);
        TextField minSwitchTextField = new TextField();
        grid.add(minSwitchTextField, 1, 2);
        
        Label maxSwitch = new Label("Maximum number of switches:");
        grid.add(maxSwitch, 0, 3);
        TextField maxSwitchTextField = new TextField();
        grid.add(maxSwitchTextField, 1, 3);
        
        Label targetFolder = new Label("Target folder:");
        grid.add(targetFolder, 0, 4);
        TextField targetFolderTextField = new TextField();
        grid.add(targetFolderTextField, 1, 4);
        
        Button btn = new Button("Confirm");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 6);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 7);
        
        btn.setOnAction((ActionEvent e) -> {
            actiontarget.setFill(Color.FIREBRICK);
            
            if("".equals(sizeTextField.getText()) || "".equals(minSwitchTextField.getText()) || "".equals(maxSwitchTextField.getText()) || "".equals(targetFolderTextField.getText())){
                
                actiontarget.setText("Field(s) is(are) left blank.");
            }
            else{
                actiontarget.setText("Confirmed");
            
                /*
                Stuff goes here
                Call constructor of page2 with required data.
                */
            }
        });
        
        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
}
