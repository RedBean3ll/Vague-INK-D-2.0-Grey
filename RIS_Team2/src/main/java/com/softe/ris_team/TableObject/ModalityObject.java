/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

/**
 *
 * @author Matthew C
 */
public class ModalityObject {
    
    private int MODALITY_ID;
    private String MODALITY_NAME;
    private double COST;
    
    public ModalityObject() {
        MODALITY_ID = 0;
        MODALITY_NAME = "modality";
        COST = 0;
    }
    
    public int getMODALITY_ID() {
        return MODALITY_ID;
    }

    public void setMODALITY_ID(int MODALITY_ID) {
        this.MODALITY_ID = MODALITY_ID;
    }

    public String getMODALITY_NAME() {
        return MODALITY_NAME;
    }

    public void setMODALITY_NAME(String MODALITY_NAME) {
        this.MODALITY_NAME = MODALITY_NAME;
    }

    public double getCOST() {
        return COST;
    }

    public void setCOST(double COST) {
        this.COST = COST;
    }
    
    
}
