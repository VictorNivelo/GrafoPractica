/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contolador.listas;

/**
 *
 * @author Victor
 */
public class NodoLista <E> {
    private E dato;
    private NodoLista<E> siguiente;

    public NodoLista (E dato, NodoLista<E> sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public NodoLista () {
        this.dato = null;
        this.siguiente = null;
    }
    
    public E getDato() {
        return this.dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
    
    public NodoLista<E> getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoLista<E> siguiente) {
        this.siguiente = siguiente;
    }
}
