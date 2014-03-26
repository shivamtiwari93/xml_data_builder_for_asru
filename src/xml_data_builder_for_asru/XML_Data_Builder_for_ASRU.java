/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xml_data_builder_for_asru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
public class XML_Data_Builder_for_ASRU extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("XML Data-Builder for ASRU");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Text scenetitle = new Text("Login to generate data");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        btn.setOnAction((ActionEvent e) -> {
            try {
                actiontarget.setFill(Color.FIREBRICK);
                
                /*
                Stuff goes here
                */
                Class.forName("com.mysql.jdbc.Driver");
                String connectionURL = "jdbc:mysql://localhost:3306/xml_data_builder_db";
                Connection conn = DriverManager.getConnection (connectionURL,"root","");
                Statement stmt = conn.createStatement();
                ResultSet rs;
                
                rs = stmt.executeQuery("select username from login where username='"+userTextField.getText()+"' and password='"+pwBox.getText()+"'");
                if(rs.next()){
                    actiontarget.setText("Pass validated for " + userTextField.getText());
                }
                else{
                    actiontarget.setText("Pass validation failed. Please retry.");
                }
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(XML_Data_Builder_for_ASRU.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
