/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador1;

import contolador.listas.ListaEnlazada;
import modelo.Arbol;


/**
 *
 * @author Victor
 */
public class ArbolController {
    private Arbol arbol;

    public Arbol getArbol() {
        if(arbol == null)
            arbol = new Arbol();
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    
    public ListaEnlazada<Arbol> listar() {
        ListaEnlazada<Arbol> lista = new ListaEnlazada<>();
        getArbol().setDescripcion("Arbol de eucalipto");
        getArbol().setId(1);
        getArbol().setNombre("Eucalito");
        getArbol().setNombreCientifico("Eucaliptus");
        lista.insertar(arbol);
        setArbol(null);
        getArbol().setDescripcion("Arbol de pino");
        getArbol().setId(2);
        getArbol().setNombre("Pino");
        getArbol().setNombreCientifico("Pinuatus");
        lista.insertar(arbol);
        setArbol(null);
        getArbol().setDescripcion("Arbol de sauces");
        getArbol().setId(3);
        getArbol().setNombre("Sauce");
        getArbol().setNombreCientifico("Lloron");
        lista.insertar(arbol);
        setArbol(null);
        getArbol().setDescripcion("Arbol de faique");
        getArbol().setId(1);
        getArbol().setNombre("Faique");
        getArbol().setNombreCientifico("espinudo");
        lista.insertar(arbol);
        setArbol(null);
        return lista;
    }
}
