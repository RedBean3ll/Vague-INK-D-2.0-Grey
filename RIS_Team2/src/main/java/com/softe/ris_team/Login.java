/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team;

import com.softe.DBConnector;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import com.softe.DBConnector;

/**
 *
 * @author Matthew C, Cesar Cruz, Kevin Martinez, Brandon Williams, Peter Tran
 */
public class Login extends Stage{
        
        private BorderPane root = new BorderPane();
        private Scene scene = new Scene(root, 350, 350);
    
        protected Login() {
            super.setScene(scene);
            scene.getStylesheets().add("file:../RIS_Team2/src/main/java/com/softe/resources/cLogin.css");
            
            this.setHeight(350);
            this.setWidth(350);
            this.setMaxHeight(350);
            this.setMaxWidth(350);
            this.setTitle("R. I. S. - " + SystemInfo.programVersion());
            
            //Login header
            Label text = new Label("Login");
            text.setId("loginHeader");
        
            //Credential fields - FIXME: NEEDS User and Pass text cap
            TextField user = new TextField();
            user.setPromptText("Username");
            user.setMaxWidth(175);
            user.setMinWidth(175);
            user.setId("credentialBox");
            
            PasswordField pass = new PasswordField();
            pass.setPromptText("Password");
            pass.setId("credentialBox");
            pass.setMaxWidth(175);
            pass.setMinWidth(175);
        
            VBox.setMargin(user, new Insets(10, 0, 10, 0));
            VBox.setMargin(pass, new Insets(10, 0, 0, 0));
        
            //Hyperlink
            Hyperlink hyperLog = new Hyperlink("Forgot password?");
            //hyperLog.setText("Forgot password?");
            VBox.setMargin(hyperLog, new Insets(2, 0, 0, 76));
            
                    //Set on action - TBA
        
            Button button = new Button("LOGIN");
            button.setId("button");
            VBox.setMargin(button, new Insets(14, 0, 50, 0));
            button.contentDisplayProperty();
            
            //Credential mismatch
            Label mismatchLog = new Label("Credentials are incorrect");
            mismatchLog.setId("textRed");
            mismatchLog.setVisible(false);
            
            //TMP Button Event to move onto next
        
            VBox vertical = new VBox(text, user, pass, hyperLog, button, mismatchLog);
        
        vertical.setMaxHeight(340);
        vertical.setMaxWidth(380);
        vertical.setId("block");
        vertical.setAlignment(Pos.CENTER);
        //root.setCenter(vertical);
        root.setCenter(vertical);
        
        button.setOnAction((ActionEvent e) -> {
                try {
                    loginButtonEvent(user.getText(), pass.getText(), mismatchLog, e);
                } catch (SQLException ex) {}
        });
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent key) -> {
            if(key.getCode().equals(KeyCode.ENTER)) {
                button.fire();
            }
        });
        
        this.show();
        }
        
        
        
        protected void loginButtonEvent(String uName, String uPass, Label label, ActionEvent a) throws SQLException {
            try {
                    //Check for valid id
                    int ID = new DBConnector().queryLoginA(uName, uPass);
                    
                    System.out.println("CURRENT ID IS :"+ID);
            
                    if(ID > 0) {
                        int ROLE = new DBConnector().queryLoginB(ID);
                        switch(ROLE) {
                            case 7: 
                                this.close();
                                new Admin(ID);
                                break;
                            case 8: 
                                this.close();
                                new Doctor(ID);
                                break;
                            case 9: 
                                this.close();
                                new Technician(ID);
                                break;
                            case 10: 
                                this.close();
                                new Radiologist(ID);
                                break;
                            case 11: 
                                this.close();
                                new Desk(ID);
                                break;
                            case 12: 
                                this.close();
                                new User(ID);
                                break;
                            case 13: 
                                this.close();
                                new Billing(ID);
                                break;
                            default:
                                System.out.println("LOGIN FAILED AFTER FULL MATCH!!");
                                break;
                        }
                        
                        System.out.println("CURRENT ROLE IS: "+ROLE);
                    } else {
                        label.setVisible(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(); //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
}
