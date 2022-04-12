/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

/**
 *
 * @author Matthew C
 */
public class ReportObject {
    
    private int DIAGNOSTIC_REPORT_ID;
    private String RADIOLOGIST;
    private String ORDER;
    private int ORDER_ID;
    private String REPORT;

    public ReportObject() {
        DIAGNOSTIC_REPORT_ID = 0;
        RADIOLOGIST = "rad";
        ORDER = "ORDER";
        ORDER_ID = 0;
        REPORT = "This is a report.";
    }
    
    public ReportObject(int DIAGNOSTIC_REPORT_ID, String RADIOLOGIST, String ORDER, int ORDER_ID, String REPORT) {
        this.DIAGNOSTIC_REPORT_ID = DIAGNOSTIC_REPORT_ID;
        this.RADIOLOGIST = RADIOLOGIST;
        this.ORDER = ORDER;
        this.ORDER_ID = ORDER_ID;
        this.REPORT = REPORT;
    }

    
    
    public int getDIAGNOSTIC_REPORT_ID() {
        return DIAGNOSTIC_REPORT_ID;
    }

    public void setDIAGNOSTIC_REPORT_ID(int DIAGNOSTIC_REPORT_ID) {
        this.DIAGNOSTIC_REPORT_ID = DIAGNOSTIC_REPORT_ID;
    }

    public String getRADIOLOGIST() {
        return RADIOLOGIST;
    }

    public void setRADIOLOGIST(String RADIOLOGIST) {
        this.RADIOLOGIST = RADIOLOGIST;
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

    public String getREPORT() {
        return REPORT;
    }

    public void setREPORT(String REPORT) {
        this.REPORT = REPORT;
    }
    
    
}
