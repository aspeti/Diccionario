/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author NETHUNTER
 */
public class Metodos {
    
    Connection con;
    public Connection getConection()
    {
       final String driver = "com.mysql.jdbc.Driver";
       final String url = "jdbc:mysql://localhost:3306/diccionario";
       final String user = "root";
       final String pass ="";
       
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexion "+e.getMessage());
        }
        return con;    
    }
    
}
