/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

import javafx.scene.control.CheckBox;

/**
 *
 * @author Matthew C
 */
public class SystemUserObject {

    private int ACCOUNT_IDENTIFIER;
    private String ACCOUNT_USERNAME;
    private String USER_FIRST_NAME;
    private String USER_LAST_NAME;
    private String SCREEN_NAME;
    private String USER_EMAIL;
    private String USER_ROLE;
    private CheckBox ACCOUNT_ACTIVE;
    private boolean ACTIVE_VALUE;
    
    public SystemUserObject() {
        ACCOUNT_IDENTIFIER = 1;
        ACCOUNT_USERNAME = "dummy username";
        USER_FIRST_NAME = "Matthew Ebony";
        USER_LAST_NAME = "Clark";
        SCREEN_NAME = USER_FIRST_NAME + " " + USER_LAST_NAME;
        USER_EMAIL = "email@radiology.net";
        USER_ROLE = "TEST ROLE";
        ACTIVE_VALUE = true;
        ACCOUNT_ACTIVE = new CheckBox();
        ACCOUNT_ACTIVE.setSelected(true);
        ACCOUNT_ACTIVE.setDisable(true);
        
    }
    
    public SystemUserObject(int ACCOUNT_IDENTIFIER, String ACCOUNT_USERNAME, String USER_FIRST_NAME, String USER_MIDDLE_NAME, String USER_LAST_NAME, String USER_EMAIL, String USER_ROLE, boolean ACTIVE_VALUE) {
        this.ACCOUNT_IDENTIFIER = ACCOUNT_IDENTIFIER;
        this.ACCOUNT_USERNAME = ACCOUNT_USERNAME;
        this.USER_FIRST_NAME = USER_FIRST_NAME;
        this.USER_LAST_NAME = USER_LAST_NAME;
        this.SCREEN_NAME = USER_FIRST_NAME + " " + USER_LAST_NAME;
        this.USER_EMAIL = USER_EMAIL;
        this.USER_ROLE = USER_ROLE;
        this.ACTIVE_VALUE = ACTIVE_VALUE;
        this.ACCOUNT_ACTIVE = new CheckBox();
        this.ACCOUNT_ACTIVE.setSelected(ACTIVE_VALUE);
        this.ACCOUNT_ACTIVE.setDisable(true);
    }
    
    public int getACCOUNT_IDENTIFIER() {
        return ACCOUNT_IDENTIFIER;
    }

    public String getACCOUNT_USERNAME() {
        return ACCOUNT_USERNAME;
    }

    public String getUSER_FIRST_NAME() {
        return USER_FIRST_NAME;
    }

    public String getUSER_LAST_NAME() {
        return USER_LAST_NAME;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public String getUSER_ROLE() {
        return USER_ROLE;
    }
    
    public CheckBox getACCOUNT_ACTIVE() {
        return ACCOUNT_ACTIVE;
    }
    
    public boolean getACTIVE_VALUE() {
        return ACTIVE_VALUE;
    } 

    public void setACCOUNT_IDENTIFIER(int ACCOUNT_IDENTIFIER) {
        this.ACCOUNT_IDENTIFIER = ACCOUNT_IDENTIFIER;
    }

    public void setACCOUNT_USERNAME(String ACCOUNT_USERNAME) {
        this.ACCOUNT_USERNAME = ACCOUNT_USERNAME;
    }

    public void setUSER_FIRST_NAME(String USER_FIRST_NAME) {
        this.USER_FIRST_NAME = USER_FIRST_NAME;
    }

    public void setUSER_LAST_NAME(String USER_LAST_NAME) {
        this.USER_LAST_NAME = USER_LAST_NAME;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public void setUSER_ROLE(String USER_ROLE) {
        this.USER_ROLE = USER_ROLE;
    }
    
    public void updateACTIVE(boolean ACTIVE_VALUE) {
        this.ACTIVE_VALUE = ACTIVE_VALUE;
        this.ACCOUNT_ACTIVE.setSelected(ACTIVE_VALUE);
    }


}
