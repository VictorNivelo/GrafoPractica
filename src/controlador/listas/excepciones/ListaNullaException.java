/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.excepciones;

/**
 *
 * @author Victor
 */
public class ListaNullaException extends Exception {
    public ListaNullaException(String msg) {
        super(msg);
    }

    public ListaNullaException() {
        super("No se puede operar, lista vacia");
    }
}
