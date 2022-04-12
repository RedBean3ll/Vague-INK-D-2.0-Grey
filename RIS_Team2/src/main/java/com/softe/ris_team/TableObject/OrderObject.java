/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

/**
 *
 * @author Matthew C, Cesar Cruz, Kevin Martinez, Brandon Williams, Peter Tran
 */
public class OrderObject {
    
    private int ORDER_ID;
    private String PATIENT_NAME;
    private String REFERRAL_MD;
    private String MODALITY;
    private String NOTES;
    private String STATUS;

    public OrderObject() {
        PATIENT_NAME = "A  B";
        MODALITY = "MODALITY A";
        NOTES = "This is a sample note. Sample order is of _ _. Thank you for this test ";
        STATUS = "TEST";
    }
    
    public OrderObject(String FIRST_NAME, String LAST_NAME, String MODALITY, String NOTES, String STATUS) {
        this.PATIENT_NAME = FIRST_NAME + " " + LAST_NAME;
        this.MODALITY = MODALITY;
        this.NOTES = NOTES;
        this.STATUS = STATUS;
    }
    
    public OrderObject(int ORDER_ID, String FIRST_NAME, String LAST_NAME, String REFERRAL_MD, String MODALITY, String NOTES, String STATUS) {
        this.ORDER_ID = ORDER_ID;
        this.PATIENT_NAME = FIRST_NAME + " " + LAST_NAME;
        this.REFERRAL_MD = REFERRAL_MD;
        this.MODALITY = MODALITY;
        this.NOTES = NOTES;
        this.STATUS = STATUS;
        
    } 
    
    public int getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public String getREFERRAL_MD() {
        return REFERRAL_MD;
    }

    public void setREFERRAL_MD(String REFERRAL_MD) {
        this.REFERRAL_MD = REFERRAL_MD;
    }
    
    public String getPATIENT_NAME() {
        return PATIENT_NAME;
    }

    public void setPATIENT_NAME(String FIRST_NAME, String LAST_NAME) {
        this.PATIENT_NAME = FIRST_NAME + " " + LAST_NAME;
    }

    public String getMODALITY() {
        return MODALITY;
    }

    public void setMODALITY(String MODALITY) {
        this.MODALITY = MODALITY;
    }

    public String getNOTES() {
        return NOTES;
    }

    public void setNOTES(String NOTES) {
        this.NOTES = NOTES;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String setSTATUS(String STATUS) {
        return this.STATUS = STATUS;
    }
    
    
    
}
