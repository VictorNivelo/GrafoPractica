/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import contolador.listas.ListaEnlazada;
import controlador.grafo.excepciones.VerticeOfSizeException;

/**
 *
 * @author Victor
 */
public class GrafoDirigido extends Grafo {
    private Integer numVertices;
    private Integer numAristas;
    private ListaEnlazada<Adycencia> listaAdycente[];

    public GrafoDirigido(Integer numVertices) {
        this.numVertices = numVertices;
        numAristas = 0;
        listaAdycente = new ListaEnlazada[numVertices + 1];
        for(int i = 1; i <= this.numVertices; i++) {
            listaAdycente[i] = new ListaEnlazada<>();
        }
    }

    @Override
    public Integer numVertices() {
        return numVertices;
    }

    @Override
    public Integer numAristas() {
        return numAristas;
    }

    @Override
    public Boolean existeArista(Integer o, Integer d) throws Exception {
        Boolean existe = false;
        if(o.intValue() <= numVertices && d.intValue() <= numVertices) {
            ListaEnlazada<Adycencia> lista = listaAdycente[o];
            for(int i = 0; i < lista.getSize(); i++) {
                Adycencia a = lista.obtener(i);
                if(a.getDestino().intValue() == d.intValue()) {
                    existe = true;
                    break;
                }
            }
        } 
        else{
            throw new VerticeOfSizeException();
        }
        return existe;
    }

    @Override
    public Double pesoArista(Integer o, Integer d) {
        Double peso = Double.NaN;
        try {
            if(existeArista(o, d)) {
                ListaEnlazada<Adycencia> adycentes = listaAdycente[o];
                for(int i = 0; i < adycentes.getSize(); i++) {
                    Adycencia a = adycentes.obtener(i);
                    if(a.getDestino().intValue() == d.intValue()) {
                        peso = a.getPeso();
                        break;
                    }
                }
            }
        } 
        catch (Exception e) {
            
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) throws Exception {
       
            if(o.intValue() <= numVertices && d.intValue() <= numVertices) {
                if(!existeArista(o, d)) {
                    numAristas++;
                    listaAdycente[o].insertar(new Adycencia(d, peso));
                }
            } 
            else {
                throw new VerticeOfSizeException();
            }
       
    }

    @Override
    public void insertarArista(Integer o, Integer d) throws Exception {
        insertarArista(o, d, Double.NaN);
    }
    
    

    @Override
    public ListaEnlazada<Adycencia> adycentes(Integer v) {
        return listaAdycente[v];
    }

    public Integer getNumVertices() {
        return numVertices;
    }
    
    public Integer getNumAristas() {
        return numAristas;
    }

    public void setNumAristas(Integer numAristas) {
        this.numAristas = numAristas;
    }
    
    public ListaEnlazada<Adycencia>[] getListaAdycente() {
        return listaAdycente;
    }
}
