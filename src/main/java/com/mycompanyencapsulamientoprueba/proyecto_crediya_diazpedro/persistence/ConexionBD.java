/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyencapsulamientoprueba.proyecto_crediya_diazpedro.persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PEDRO ANTONIO DÍAZ V
 */
public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3306/crediya_db";
    private static String user = "root";
    private static String password = "Pedrodiaz22334!";
    public static Connection con = null;

    public static Connection MysConnection() throws SQLException{
        url = "jdbc:mysql://localhost:3306/crediya_db";
        user = "root";
        password = "Pedrodiaz22334!";
        return getConnection(url, user, password);
    }

    private static Connection getConnection(String url, String user,String password){
        try {
            con = DriverManager.getConnection(url, user, password);
            if(con!=null){
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Base de datos conectada "+ meta.getDriverName());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
