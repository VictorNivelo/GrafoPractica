/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.jarra;

/**
 *
 * @author Victor
 */
public class Jarra {
    private Integer capacidad;
    private Integer capacidad_actual;

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCapacidad_actual() {
        return capacidad_actual;
    }

    public void setCapacidad_actual(Integer capacidad_actual) {
        this.capacidad_actual = capacidad_actual;
    }

    @Override
    public String toString() {
        return "J["+capacidad+"L] = "+capacidad_actual+"L";
    } 
}