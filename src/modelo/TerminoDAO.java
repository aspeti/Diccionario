/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import comun.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author NETHUNTER
 */
public class TerminoDAO {
    Metodos conectar = new Metodos();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List buscar(String cad){
        List<Termino> datos =  new ArrayList<>();        
        String consulta = "Select * from termino T where T.termino=?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(consulta);
            ps.setString(1, cad);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Termino t = new Termino();
                t.setId(rs.getInt(1));
                t.setPalabra(rs.getString(2));
                t.setTipo(rs.getInt(3));
                t.setDefinicion(rs.getString(4));    
                
                datos.add(t);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en consulta "+e.getMessage());
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al cerrar la conexion "+e.getMessage());
            }
        }
        
        return datos;
        
    }
    
    public List listar(String cad){
        List<Termino> datos =  new ArrayList<>();
        String consulta = "Select * from termino T where T.termino like '%"+cad+"%'";
        //String consulta = "Select * from termino";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(consulta);
            //ps.setString(1,cad);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Termino t = new Termino();
                t.setId(rs.getInt(1));
                t.setPalabra(rs.getString(2));
                t.setTipo(rs.getInt(3));
                t.setDefinicion(rs.getString(4));    
                
                datos.add(t);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al cerrar la conexion tabla "+e.getMessage());
        }
        
        return datos;
        
    }
    
}
