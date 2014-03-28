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
public class FinishPage extends Application {
    boolean type;
    
    @Override
    public void start(Stage primaryStage){
        
        primaryStage.setTitle("XML Data-Builder for ASRU");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Text scenetitle;
        
        if(type == true){
            scenetitle = new Text("Procedure successful.");
        }
        else{
            scenetitle = new Text("Procedure was cancelled.");
        }
         
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button btn = new Button("Finish");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
        
        btn.setOnAction((ActionEvent e) -> {
            
            primaryStage.close();
        });
        
        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public FinishPage(boolean x){
        this.type = x;
    }
}
