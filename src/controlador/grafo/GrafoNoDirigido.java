/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import controlador.grafo.excepciones.VerticeOfSizeException;

/**
 *
 * @author Victor
 */
public class GrafoNoDirigido extends GrafoDirigido {

    public GrafoNoDirigido(Integer numV) {
        super(numV);
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) throws Exception {
        if (o.intValue() <= getNumVertices() && d.intValue() <= getNumVertices()) {
            if (!existeArista(o, d)) {
                setNumAristas(getNumAristas() + 1);
                //numAristas++;
                getListaAdycente()[o].insertar(new Adycencia(d, peso));
                getListaAdycente()[d].insertar(new Adycencia(o, peso));
            }
        } 
        else {
            throw new VerticeOfSizeException();
        }
    }
}
