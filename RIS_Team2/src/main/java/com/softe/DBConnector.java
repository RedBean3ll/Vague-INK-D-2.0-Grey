/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softe;

import com.softe.ris_team.TableObject.SystemUserObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.sql.DataSource;

/**
 *
 * @author Matthew C, Cesar Cruz, Kevin Martinez, Brandon Williams, Peter Tran
 */
public class DBConnector {
    
    private Connection connect;
    
    private String url = "jdbc:mysql://localhost:3306/db_ris";
    private String username = "root";
    private String password = "fr@73elle0o?3";
    
    //TMP - TO BE MOVED TO STORING AS TEXT TEXT IN A DOCUMENT
    
    public DBConnector() {
        
        /*
        connect = null;
        
        //Context context = new InitialContext();
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            
            System.out.println("Database connected!");
            
            Statement stmt = connect.createStatement();
            
            
            String cond = "";
            ResultSet rs = stmt.executeQuery("select * from users where email = 'admin@gmail.com';");
            
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(3) + " " + rs.getString(3));
            }
            connect.close();
            
            //state.executeUpdate("create table if not exists tet(ex int)");
            //ResultSet rs = state.executeQuery("select * from users");
            
            //ResultSetMetaData rSMD = rs.getMetaData();
            //setResult(rSMD.getTableName(3));
            //printResult();
            //System.out.println(result);
        } catch(Exception e) {
            //System.out.println(e.getStackTrace());
            setResult("FAILURE");
            e.printStackTrace();
            printResult();
        } */
        
    }
    
    //LOGIN QUERY
    public int queryLoginA(String A, String B) throws SQLException {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            
            String valueA = "'"+A+"'";
            String valueB = "'"+B+"'";
            int number;
            
            System.out.println("Database connected!");
            
            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT user_id FROM users WHERE username = "+valueA+" || email = "+valueA+";");

            rs.next();
            number = rs.getInt(1); //check if value matches username or mail
            
            rs = stmt.executeQuery("SELECT user_id, enabled FROM users WHERE password = "+valueB+";");
            
            rs.next();
            
            boolean usable = rs.getBoolean(2);
            
            if(rs.getInt(1) == number) { //check for fin match
                connect.close();
                if(usable) {
                    return number;
                }
                else {
                    return -3;
                }
            }
            else {
                connect.close();
                return -2; //missmatch
            }
            
        } catch(Exception e) {
            return -1; //Failed connection or query
        }
           
    }
    
    //LOGIN QUERY
    public int queryLoginB(int A) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            
            int valueA = A;
            int number;
            
            System.out.println("Database connected!");
            
            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT role_id FROM users_roles as ur LEFT JOIN users as u ON ur.user_id = u.user_id WHERE ur.user_id = "+A+";");
            
            rs.next();
            number = rs.getInt(1); //check if value matches username or mail
            System.out.println("RESULT");
           
            return number;
        } catch(Exception e) {
            //e.printStackTrace();
            return -1; //Failed connection or query
        }
        
        
    }
    
    //ADMIN QUERY
    protected ObservableList<SystemUserObject> queryAccounts() {
        
        ObservableList<SystemUserObject> data = FXCollections.observableArrayList();
        
        
        return data;
    }
}
