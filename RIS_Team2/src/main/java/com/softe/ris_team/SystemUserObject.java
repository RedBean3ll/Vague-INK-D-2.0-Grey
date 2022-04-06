/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Matthew C
 */
public class SystemUserObject {

    private SimpleIntegerProperty ACCOUNT_IDENTIFIER;
    private SimpleStringProperty ACCOUNT_USERNAME;
    private SimpleStringProperty USER_FIRST_NAME;
    private SimpleStringProperty USER_MIDDLE_NAME;
    private SimpleStringProperty USER_LAST_NAME;
    private SimpleStringProperty USER_EMAIL;
    private SimpleStringProperty USER_ROLE;
    private CheckBox ACCOUNT_ACTIVE;
    
    public SystemUserObject() {
        ACCOUNT_IDENTIFIER = new SimpleIntegerProperty(1);
        ACCOUNT_USERNAME = new SimpleStringProperty("dummy username");
        USER_FIRST_NAME = new SimpleStringProperty("Matthew Ebony");
        USER_MIDDLE_NAME = new SimpleStringProperty("S");
        USER_LAST_NAME = new SimpleStringProperty("Clark");
        USER_EMAIL = new SimpleStringProperty("email@radiology.net");
        USER_ROLE = new SimpleStringProperty("TEST ROLE");
        ACCOUNT_ACTIVE = new CheckBox();
        ACCOUNT_ACTIVE.setDisable(true);
        
    }
    
    public SystemUserObject(int ACCOUNT_IDENTIFIER, String ACCOUNT_USERNAME, String USER_FIRST_NAME, String USER_MIDDLE_NAME, String USER_LAST_NAME, String USER_EMAIL, String USER_ROLE) {
        this.ACCOUNT_IDENTIFIER = new SimpleIntegerProperty(ACCOUNT_IDENTIFIER);
        this.ACCOUNT_USERNAME = new SimpleStringProperty(ACCOUNT_USERNAME);
        this.USER_FIRST_NAME = new SimpleStringProperty(USER_FIRST_NAME);
        this.USER_MIDDLE_NAME = new SimpleStringProperty(USER_MIDDLE_NAME);
        this.USER_LAST_NAME = new SimpleStringProperty(USER_LAST_NAME);
        this.USER_EMAIL = new SimpleStringProperty(USER_EMAIL);
        this.USER_ROLE = new SimpleStringProperty(USER_ROLE);
        this.ACCOUNT_ACTIVE = new CheckBox();
        this.ACCOUNT_ACTIVE.setDisable(true);
    }
    
    public int getACCOUNT_IDENTIFIER() {
        return ACCOUNT_IDENTIFIER.getValue();
    }

    public String getACCOUNT_USERNAME() {
        return ACCOUNT_USERNAME.getValue();
    }

    public String getUSER_FIRST_NAME() {
        return USER_FIRST_NAME.getValue();
    }
    
    public String getUSER_MIDDLE_NAME() {
        return USER_MIDDLE_NAME.getValue();
    }

    public String getUSER_LAST_NAME() {
        return USER_LAST_NAME.getValue();
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL.getValue();
    }

    public String getUSER_ROLE() {
        return USER_ROLE.getValue();
    }
    
    public CheckBox getACCOUNT_ACTIVE() {
        return ACCOUNT_ACTIVE;
    } 

    public void setACCOUNT_IDENTIFIER(int ACCOUNT_IDENTIFIER) {
        this.ACCOUNT_IDENTIFIER.set(ACCOUNT_IDENTIFIER);
    }

    public void setACCOUNT_USERNAME(String ACCOUNT_USERNAME) {
        this.ACCOUNT_USERNAME.set(ACCOUNT_USERNAME);
    }

    public void setUSER_FIRST_NAME(String USER_FIRST_NAME) {
        this.USER_FIRST_NAME.set(USER_FIRST_NAME);
    }
    
    public void setUSER_MIDDLE_NAME(String USER_MIDDLE_NAME) {
        this.USER_MIDDLE_NAME.set(USER_MIDDLE_NAME);
    }

    public void setUSER_LAST_NAME(String USER_LAST_NAME) {
        this.USER_LAST_NAME.set(USER_LAST_NAME);
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL.set(USER_EMAIL);
    }

    public void setUSER_ROLE(String USER_ROLE) {
        this.USER_ROLE.set(USER_ROLE);
    }

    public void setACCOUNT_ACTIVE(boolean VALUE) {
        //this.ACCOUNT_ACTIVE
    }


}
