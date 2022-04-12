/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

/**
 *
 * @author Matthew C
 */
public class PatientAlertObject {
    
    private int PATIENT_ALERT_ID;
    private String PATIENT_ALERT;

    public PatientAlertObject() {
        PATIENT_ALERT_ID = 0;
        PATIENT_ALERT = "alert";
    }
    
    public int getPATIENT_ALERT_ID() {
        return PATIENT_ALERT_ID;
    }

    public void setPATIENT_ALERT_ID(int PATIENT_ALERT_ID) {
        this.PATIENT_ALERT_ID = PATIENT_ALERT_ID;
    }

    public String getPATIENT_ALERT() {
        return PATIENT_ALERT;
    }

    public void setPATIENT_ALERT(String PATIENT_ALERT) {
        this.PATIENT_ALERT = PATIENT_ALERT;
    }
    
    
    
}
