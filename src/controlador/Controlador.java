/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.frmPrincipal;
import java.awt.event.ActionListener;
import comun.*;
import modelo.*;
import vista.frmLogin;

/**
 *
 * @author NETHUNTER
 */
public class Controlador implements ActionListener {
    TerminoDAO dao = new TerminoDAO();
    Termino t  =  new Termino();  
    frmPrincipal vista = new frmPrincipal();
    DefaultTableModel modelo = new DefaultTableModel();    
    
    public Controlador(frmPrincipal vista)
    {
        this.vista = vista;    
        ocultarColumnas(vista.tabla);
        this.vista.btnSearch.addActionListener(this);
        
    }
    
    public void listar(JTable tabla, String cad)
    {
        modelo = (DefaultTableModel)tabla.getModel();        
        List<Termino> lista = dao.listar(cad);
        //List<Termino> listaFound = dao.listar();
        Object[] object = new Object[4];
        for(int i =0; i<lista.size();i++){
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getPalabra();
            object[2] = lista.get(i).getTipo();
            object[3] = lista.get(i).getDefinicion(); 
            
            modelo.addRow(object);
        }  
        vista.tabla.setModel(modelo); 
    }
    
    public void MostrarResultadoDeBusqueda(String cad)    {               
        
        List<Termino> listaFound = dao.buscar(cad);
        String term ="";
        String tipo = "";
        String def = "";
        
        if (listaFound.size()!=0) {
            term = listaFound.get(0).getPalabra();
            tipo = Integer.toString(listaFound.get(0).getTipo());
            def = listaFound.get(0).getDefinicion();
        }        
        
        vista.txtTerm.setText(term);
        vista.txtType.setText(tipo);
        vista.txtDefinition.setText(def);    
    }
//    public String resultadoLista(String cad)    {               
//        
//        List<Termino> listaFound = dao.listar(cad);
//        String res ="";
//        if(listaFound.size()!=0)
//        {
//            res =  listaFound.get(0).getPalabra()+"-"+
//                    listaFound.get(0).getTipo()+"-"+
//                    listaFound.get(0).getDefinicion();                    
//        }
//        
//        return res;
//    }
    
    private void limpiar ()
    {
        vista.txtDefinition.setText("");
        vista.txtTerm.setText("");
        vista.txtType.setText("");
    }
    
    private void ocultarColumnas(JTable tabla)
    {
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setMinWidth(0);        
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()== vista.btnSearch)
        {
            //listar(vista.tabla, vista.txtSearch.getText());
             listar(vista.tabla,vista.txtSearch.getText());
            //vista.txaDefinition.setText(vista.formatearCadena(resultadoLista(vista.txtSearch.getText())));
            MostrarResultadoDeBusqueda(vista.txtSearch.getText());
        }        
        
    }
    
  
    
}
