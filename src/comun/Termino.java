/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

/**
 *
 * @author NETHUNTER
 */
public class Termino {
    
    int id;
    String palabra;
    int tipo;
    String definicion;  
    
    public Termino(){
        
    }
    public Termino (int id, String palabra, int tipo, String definicion){
        this.id = id;
        this.palabra = palabra;
        this.tipo = tipo;
        this.definicion = definicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
