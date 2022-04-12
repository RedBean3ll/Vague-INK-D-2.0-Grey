

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

import java.sql.Timestamp;
import java.time.Instant;
/**
 *
 * @author Matthew C
 */
public class AppointmentObject {
    
    private int APPOINTMENT_ID;
    private String PATIENT_NAME;
    private String MODALITY;
    private String ORDER;
    private int ORDER_ID;
    private Timestamp DATETIME;
    private String RADIOLOGIST;
    private String TECHNICIAN;

    public AppointmentObject() {
        PATIENT_NAME = "A B";
        MODALITY = "modality";
        DATETIME = Timestamp.from(Instant.now());
        RADIOLOGIST = "rad";
        TECHNICIAN = "hello";
    } 

    public AppointmentObject(int APPOINTMENT_ID, String PATIENT_NAME, String ORDER, int ORDER_ID, Timestamp DATETIME, String RADIOLOGIST, String TECHNICIAN) {
        this.APPOINTMENT_ID = APPOINTMENT_ID;
        this.PATIENT_NAME = PATIENT_NAME;
        this.ORDER = ORDER;
        this.ORDER_ID = ORDER_ID;
        this.DATETIME = DATETIME; //WILL NEED WORK ON
        this.RADIOLOGIST = RADIOLOGIST;
        this.TECHNICIAN = TECHNICIAN;
    }
    

    public String getPATIENT_NAME() {
        return PATIENT_NAME;
    }

    public void setPATIENT_NAME(String A, String B) {
        this.PATIENT_NAME = A + " " + B;
    }

    public String getMODALITY() {
        return MODALITY;
    }

    public void setMODALITY(String MODALITY) {
        this.MODALITY = MODALITY;
    }

    public Timestamp getDATETIME() {
        return DATETIME;
    }

    public void setDATETIME(Timestamp DATETIME) { //WILL NEED TINKERING WITH!!
        this.DATETIME = Timestamp.valueOf("MM/dd/yyyy HH:mm:ss");
    }

    public String getRADIOLOGIST() {
        return RADIOLOGIST;
    }

    public void setRADIOLOGIST(String RADIOLOGIST) {
        this.RADIOLOGIST = RADIOLOGIST;
    }

    public String getTECHNICIAN() {
        return TECHNICIAN;
    }

    public void setTECHNICIAN(String TECHNICIAN) {
        this.TECHNICIAN = TECHNICIAN;
    }
    
    public int getAPPOINTMENT_ID() {
        return APPOINTMENT_ID;
    }

    public void setAPPOINTMENT_ID(int APPOINTMENT_ID) {
        this.APPOINTMENT_ID = APPOINTMENT_ID;
    }

    public String getORDER() {
        return ORDER;
    }

    public void setORDER(String ORDER) {
        this.ORDER = ORDER;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }
    
}
