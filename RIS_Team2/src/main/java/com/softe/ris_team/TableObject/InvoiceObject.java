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
public class InvoiceObject {
    
    private double COST;
    private String MODALITY;
    private Timestamp DATETIME;
    private String RADIOLOGIST;
    private String TECHNICIAN;
    private String PATIENT;

    public InvoiceObject() {
        COST = 1.01;
        MODALITY = "modality";
        DATETIME = Timestamp.from(Instant.now());
        RADIOLOGIST = "radiologist";
        TECHNICIAN = "tech";
        PATIENT = "A B";
    }
    
    public double getCOST() {
        return COST;
    }

    public void setCOST(double COST) {
        this.COST = COST;
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

    public void setDATETIME(Timestamp DATETIME) {
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

    public String getPATIENT() {
        return PATIENT;
    }

    public void setPATIENT(String PATIENT) {
        this.PATIENT = PATIENT;
    }
    
    
}
