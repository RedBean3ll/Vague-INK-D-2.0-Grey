/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
        
        
/**
 *
 * @author Matthew C
 */
public class Developer extends Stage {


        
    protected Developer() {
        
        VBox verticalBox = new VBox();
        Scene scen = new Scene(verticalBox);
        
        scen.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cDev.css");
        //this.setScene(;new Scene(new VBox());
        super.setScene(scen);
        
        Button btn = new Button("USER MENU");
        btn.setId("button");
        
        Button btn1 = new Button("Billing");
        btn1.setId("button");
        
        btn1.setOnAction((ActionEvent e) -> { //TEMPORARILLY MOVE TO START BUT EVENTUALLY MOVE TO CONTROLLER CLASS
            this.close();
            new Billing();
        });
        
        Button btn2 = new Button("Front Desk");
        btn2.setId("button");
        
        btn2.setOnAction((ActionEvent e) -> { //TEMPORARILLY MOVE TO START BUT EVENTUALLY MOVE TO CONTROLLER CLASS
            this.close();
            new Desk();
        });
        
        Button btn3 = new Button("Doctor");
        btn3.setId("button");
        
        btn3.setOnAction((ActionEvent e) -> { //TEMPORARILLY MOVE TO START BUT EVENTUALLY MOVE TO CONTROLLER CLASS
            this.close();
            new Doctor();
        });        
        
        Button btn4 = new Button("Technician");
        btn4.setId("button");       
        
        Button btn5 = new Button("Radiologist");
        btn5.setId("button");
        
        btn5.setOnAction((ActionEvent e) -> { //TEMPORARILLY MOVE TO START BUT EVENTUALLY MOVE TO CONTROLLER CLASS
            this.close();
            new Radiologist();
        });        
        
        Button btn6 = new Button("Admin");
        btn6.setId("button");
        
        btn6.setOnAction((ActionEvent e) -> { //TEMPORARILLY MOVE TO START BUT EVENTUALLY MOVE TO CONTROLLER CLASS
            this.close();
            new Admin();
        });        
        
        Button btn7 = new Button("Return");
        btn7.setId("button");
        
      
        
        verticalBox.getChildren().addAll(btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7);
        
        btn.setOnAction((ActionEvent e) -> {
            //stage.setScene(dev());
            //this = new Developer();
            //textBox.clear();
            this.close();
            new User();
        });
        
        btn4.setOnAction((ActionEvent e) -> {
            //stage.setScene(dev());
            //this = new Developer();
            //textBox.clear();
            this.close();
            new Technician();
        });
        
        btn7.setOnAction((ActionEvent e) -> {
            //stage.setScene(dev());
            //this = new Developer();
            //textBox.clear();
            this.close();
            new Login();
        });
        
        
        this.setHeight(800);
        this.setWidth(200);
        this.setMaximized(true);
        this.show();
        
        
    }
}