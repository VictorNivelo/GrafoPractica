/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Victor
 */
public class Ubicacion {
    private Integer id;
    private Double longitud;
    private Double latitud;
    private Orientacion orientacion;
    private Arbol arbol;

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    @Override
    public String toString() {
        
        return arbol.getNombre()+"[ln:" + longitud+", lt:"+latitud+"]";
    }
}
