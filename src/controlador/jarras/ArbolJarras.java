/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.jarras;

import contolador.listas.ListaEnlazada;

/**
 *
 * @author Victor
 */
public class ArbolJarras {
    private NodoJarra estado_inicial;
    private NodoJarra estado_final;
    private ListaEnlazada<NodoJarra> nodos;
    private ListaEnlazada<NodoJarra> lista_nodos;

    public ArbolJarras(NodoJarra estado_inicial, NodoJarra estado_final) {
        this.estado_inicial = estado_inicial;
        this.estado_final = estado_final;
        nodos = new ListaEnlazada<>();
        lista_nodos = new ListaEnlazada<>();
    }
    
    public NodoJarra busqueda_anchura() throws Exception {
        if (estado_inicial != null && estado_final != null) {
            if (NodoJarra.comparar(estado_inicial, estado_final)) {
                nodos = new ListaEnlazada<>();
                nodos.insertarCabecera(estado_final);
                return estado_final;
            } 
            else {
                nodos = new ListaEnlazada<>();
                lista_nodos = new ListaEnlazada<>();
                lista_nodos.insertar(estado_inicial);
                nodos.insertar(estado_inicial);
                while (lista_nodos.getSize() > 0) {
                    NodoJarra actual = lista_nodos.eliminar(0);
                    if (NodoJarra.comparar(actual, estado_final)) {
                        return actual;
                    } 
                    else {
                        ListaEnlazada<NodoJarra> reglas = Regla.reglas(actual.getJg(), actual.getJp());                        
                        reglas = this.eliminarReglasRepetidas(reglas);                        
                        actual.aplicarReglas(reglas);
                        for(int i = 0; i < reglas.getSize(); i++) {
                            NodoJarra auxR = reglas.obtener(i);
                            nodos.insertar(auxR);
                            lista_nodos.insertar(auxR);
                            if(NodoJarra.comparar(auxR, estado_final)) {
                                return auxR;
                            }
                        }
                    }
                }
            }
        }
        return null;
    } 
    
    private ListaEnlazada<NodoJarra> eliminarReglasRepetidas(ListaEnlazada<NodoJarra> reglas) throws Exception {
        ListaEnlazada<NodoJarra> lista_res = new ListaEnlazada<>();
        if (reglas.getSize() > 0) {
            NodoJarra[] reglasA = reglas.toArray();
            for (int i = 0; i < reglasA.length; i++) {
                NodoJarra auxRegla = reglasA[i];
                Boolean band = true;
                for (int j = 0; j < nodos.getSize(); j++) {
                    NodoJarra aux = nodos.obtener(j);
                    if (NodoJarra.comparar(auxRegla, aux)) {
                        band = false;
                        break;
                    }
                }
                if (band) {
                    lista_res.insertarCabecera(auxRegla);
                }
            }
        }
        return lista_res;
    }
    
    public ListaEnlazada<NodoJarra> camino(NodoJarra nodo) throws Exception {
        ListaEnlazada<NodoJarra>camino = new ListaEnlazada<>();
        NodoJarra n = nodo;
        while (n != null) {            
            camino.insertarCabecera(n);
            n = n.getPadre();
        }
        return camino;
    }
    
    public static void main(String[] args) {
        NodoJarra inicial = new NodoJarra(0,0);
        NodoJarra finall = new NodoJarra(4,2);
        ArbolJarras arbolJarras = new ArbolJarras(inicial, finall);
        try {
            NodoJarra busqueda = arbolJarras.busqueda_anchura();
            if(busqueda != null) {
                System.out.println("EL CAMINO ES");
                arbolJarras.camino(busqueda).imprimir();
            } 
            else {
                System.out.println("NO HAY CAMINO");
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en busqueda "+ e);
        }
    }
}
