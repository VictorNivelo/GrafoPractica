/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.excepciones;

/**
 *
 * @author Victor
 */
public class PosicionNoEncontradaException extends Exception {
    public PosicionNoEncontradaException(String msg) {
        super(msg);
    }
    public PosicionNoEncontradaException() {
        super("La posicion dada esta fuera de los limites de la lista");
    }
}
