/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Matthew C
 */
public class PatientObject {
    
    private int PATIENT_ID;
    private LocalDate DATEOFBIRTH;
    private String FIRST_NAME;
    private String LAST_NAME;

    public PatientObject() {
        //DATEOFBIRTH = LocalDate.of(PATIENT_ID, Month.MARCH, PATIENT_ID);
    }

    public PatientObject(int YEAR_NUM, int MONTH_NUM, int DAY_NUM, String FIRST_NAME, String LAST_NAME) {
        this.DATEOFBIRTH = LocalDate.of(YEAR_NUM, MONTH_NUM, DAY_NUM);
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
    }

    public PatientObject(int PATIENT_ID, int YEAR_NUM, int MONTH_NUM, int DAY_NUM, String FIRST_NAME, String LAST_NAME) {
        this.PATIENT_ID = PATIENT_ID;
        this.DATEOFBIRTH = LocalDate.of(YEAR_NUM, MONTH_NUM, DAY_NUM);
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
    }
    
    public int getPATIENT_ID() {
        return PATIENT_ID;
    }

    public void setPATIENT_ID(int PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }

    public String getDATEOFBIRTH() {
        return DATEOFBIRTH.toString();
    }

    public void setDATEOFBIRTH(int YEAR_NUM, int MONTH_NUM, int DAY_NUM) {
        this.DATEOFBIRTH = LocalDate.of(YEAR_NUM, MONTH_NUM, DAY_NUM);
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }
    
}
