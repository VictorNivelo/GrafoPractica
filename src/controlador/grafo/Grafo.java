/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import contolador.listas.ListaEnlazada;

/**
 *
 * @author Victor
 */
public abstract class Grafo {

    /**
     * Es el numero de vertices del grafo
     *
     * @return
     */
    public abstract Integer numVertices();

    public abstract Integer numAristas();

    public abstract Boolean existeArista(Integer o, Integer d) throws Exception;

    public abstract Double pesoArista(Integer o, Integer d);

    public abstract void insertarArista(Integer o, Integer d) throws Exception;

    public abstract void insertarArista(Integer o, Integer d, Double peso) throws Exception;

    public abstract ListaEnlazada<Adycencia> adycentes(Integer v);

    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for (int i = 1; i <= numVertices(); i++) {
                grafo.append("Vertice " + String.valueOf(i));
                ListaEnlazada<Adycencia> lista = adycentes(i);
                for (int j = 0; j < lista.getSize(); j++) {
                    Adycencia a = lista.obtener(j);

                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- Vertice destino " + a.getDestino() + "  -- SP");
                    } else {
                        grafo.append("-- Vertice destino " + a.getDestino() + "  -- Peso " + a.getPeso());
                    }
                }
                grafo.append("\n");
            }
        } catch (Exception e) {
            grafo.append(e.getMessage());
        }
        return grafo.toString();
    }

    public ListaEnlazada caminiMinimo(Integer origen, Integer destino) throws Exception {
        ListaEnlazada camino = new ListaEnlazada();
        if (estaConectado()) {
            ListaEnlazada pesos = new ListaEnlazada();
            Boolean finalizar = false;
            Integer inicial = origen;
            camino.insertar(inicial);
            
            while (!finalizar) {
                ListaEnlazada<Adycencia> adycencias = adycentes(inicial);
                Double peso = 10000000.0;
                int T = -1;
                for (int i = 0; i < adycencias.getSize(); i++) {
                    Adycencia ad = adycencias.obtener(i);
                    if(!estaEnCamino(camino, destino)) {
                        Double pesoArista = ad.getPeso();
                        if(destino.intValue() == ad.getDestino().intValue()) {
                            T = ad.getDestino();
                            peso = pesoArista;
                            break;
                        } 
                        else if(pesoArista < peso) {
                            T = ad.getDestino();
                            peso = pesoArista;
                        }
                    }
                }
                pesos.insertar(peso);
                camino.insertar(T);
                inicial = T;
                if(destino.intValue() == inicial.intValue()) {
                    finalizar = true;
                }
            }
        } 
        else {
            throw new Exception("Gafo no conectado");
        }
        return camino;
    }

    public Boolean estaConectado() {
        Boolean band = true;
        for (int i = 1; i <= numVertices(); i++) {
            ListaEnlazada<Adycencia> lista = adycentes(i);
            if (lista.estaVacia() || lista.getSize() == 0) {
                band = false;
                break;
            }
        }
        return band;
    }
    
    public Boolean estaEnCamino(ListaEnlazada<Integer> lista, Integer vertice) throws Exception {
        Boolean band = false;
        for(int i = 0; i < lista.getSize(); i++) {
            if(lista.obtener(i).intValue() == vertice.intValue()) {
                band = true;
                break;
            }
        }
        return band;        
    }
}
