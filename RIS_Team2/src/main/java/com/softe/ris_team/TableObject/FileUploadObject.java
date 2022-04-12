/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe.ris_team.TableObject;

/**
 *
 * @author Matthew C
 */
public class FileUploadObject {
    
    private int UPLOAD_ID;
    private String FILE_NAME;
    private String FILE_TYPE;
    private int ORDER_ID;
    //ADD ITEM TO RETRIEVE FILE

    public FileUploadObject(int UPLOAD_ID, String FILE_NAME, String FILE_TYPE, int ORDER_ID) {
        this.UPLOAD_ID = UPLOAD_ID;
        this.FILE_NAME = FILE_NAME;
        this.FILE_TYPE = FILE_TYPE;
        this.ORDER_ID = ORDER_ID;
    }
    
    public int getUPLOAD_ID() {
        return UPLOAD_ID;
    }

    public void setUPLOAD_ID(int UPLOAD_ID) {
        this.UPLOAD_ID = UPLOAD_ID;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }

    public String getFILE_TYPE() {
        return FILE_TYPE;
    }

    public void setFILE_TYPE(String FILE_TYPE) {
        this.FILE_TYPE = FILE_TYPE;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }
    
    
}
