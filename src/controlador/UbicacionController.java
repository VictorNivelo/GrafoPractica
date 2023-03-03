/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador1;

import com.google.gson.Gson;
import contolador.listas.ListaEnlazada;
import controlador.grafo.Adycencia;
import controlador.grafo.GrafoNoDirijidoEtiquetado;
import java.util.HashMap;
import modelo.Arbol;
import modelo.Orientacion;
import modelo.Ubicacion;


/**
 *
 * @author Victor
 */
public class UbicacionController {

    private Ubicacion ubicacion;
    private GrafoNoDirijidoEtiquetado<Ubicacion> grafo;
    
    private void crearGrafoLista() throws Exception {
        ListaEnlazada<Ubicacion> lista = listar();
        grafo = new GrafoNoDirijidoEtiquetado<>(lista.getSize(), Ubicacion.class);
        for(int i = 0; i < lista.getSize(); i++) {
            grafo.etiquetarVertice((i+1), lista.obtener(i));
        }
    }

    public GrafoNoDirijidoEtiquetado<Ubicacion> getGrafo() throws Exception {
        if(grafo == null)
            crearGrafoLista();
        return grafo;
    }

    public void setGrafo(GrafoNoDirijidoEtiquetado<Ubicacion> grafo) {
        this.grafo = grafo;
    }
    
    public Ubicacion getUbicacion() {
        if (ubicacion == null) {
            ubicacion = new Ubicacion();
        }
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public Double calcularDistancia(Integer or, Integer de) throws Exception {
        Ubicacion o = getGrafo().obtenerEtiqueta(or);
        Ubicacion d = getGrafo().obtenerEtiqueta(de);
        return controlador.utilidades.Utilidades.carcularDistancia(o.getLatitud(), d.getLatitud(), o.getLongitud(), d.getLongitud());
    }
    
    
    
    public void guardarGrafo() throws Exception {
        Gson gson = new Gson();            
        ListaEnlazada<HashMap> verticesE = new ListaEnlazada<>();
        HashMap<Integer, ObjetoGrafo> mapa = new HashMap<>();
        for(int i = 1; i <= getGrafo().getNumVertices(); i++) {            
            ObjetoGrafo obj = new ObjetoGrafo();
            obj.setId_clase(getGrafo().obtenerEtiqueta(i).getId());
            obj.setClase(getGrafo().obtenerEtiqueta(i).getClass().toString());
            obj.setListaAdycencias(getGrafo().adycentes(i));
            mapa.put(i, obj);
        }
        verticesE.insertar(mapa);
        controlador.utilidades.Utilidades.guardarArchivo(gson.toJson(verticesE), "datos/grafo.json");        
    }

    class ObjetoGrafo{
        String clase;
        Integer id_clase;
        ListaEnlazada<Adycencia>listaAdycencias = new ListaEnlazada<>();

        public String getClase() {
            return clase;
        }

        public void setClase(String clase) {
            this.clase = clase;
        }

        public Integer getId_clase() {
            return id_clase;
        }

        public void setId_clase(Integer id_clase) {
            this.id_clase = id_clase;
        }

        public ListaEnlazada<Adycencia> getListaAdycencias() {
            return listaAdycencias;
        }

        public void setListaAdycencias(ListaEnlazada<Adycencia> listaAdycencias) {
            this.listaAdycencias = listaAdycencias;
        }
    }
    
    public ListaEnlazada<Ubicacion> listar() {
        ListaEnlazada<Ubicacion> lista = new ListaEnlazada<>();
        ListaEnlazada<Arbol> listaArbol = new ArbolController().listar();
        try {
            getUbicacion().setId(1);
            getUbicacion().setLatitud(-76.9);
            getUbicacion().setLongitud(-3.24);
            getUbicacion().setOrientacion(Orientacion.OESTE);
            getUbicacion().setArbol(listaArbol.obtener(2));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(2);
            getUbicacion().setLatitud(-79.09);
            getUbicacion().setLongitud(-4.24);
            getUbicacion().setOrientacion(Orientacion.SURESTO);
            getUbicacion().setArbol(listaArbol.obtener(1));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(3);
            getUbicacion().setLatitud(-79.00);
            getUbicacion().setLongitud(-4.01);
            getUbicacion().setOrientacion(Orientacion.NORESTE);
            getUbicacion().setArbol(listaArbol.obtener(3));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(4);
            getUbicacion().setLatitud(-79.78);
            getUbicacion().setLongitud(-3.01);
            getUbicacion().setOrientacion(Orientacion.NORTE);
            getUbicacion().setArbol(listaArbol.obtener(0));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(5);
            getUbicacion().setLatitud(-79.124);
            getUbicacion().setLongitud(-3.99);
            getUbicacion().setOrientacion(Orientacion.SUR);
            getUbicacion().setArbol(listaArbol.obtener(0));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(6);
            getUbicacion().setLatitud(-78.09);
            getUbicacion().setLongitud(-3.24);
            getUbicacion().setOrientacion(Orientacion.SUROESTE);
            getUbicacion().setArbol(listaArbol.obtener(1));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(7);
            getUbicacion().setLatitud(-79.34);
            getUbicacion().setLongitud(-4.29);
            getUbicacion().setOrientacion(Orientacion.NOROESTE);
            getUbicacion().setArbol(listaArbol.obtener(3));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(8);
            getUbicacion().setLatitud(-79.43);
            getUbicacion().setLongitud(-3.43);
            getUbicacion().setOrientacion(Orientacion.SUR);
            getUbicacion().setArbol(listaArbol.obtener(2));
            lista.insertar(getUbicacion());
            setUbicacion(null);
            getUbicacion().setId(9);
            getUbicacion().setLatitud(-79.23);
            getUbicacion().setLongitud(-3.23);
            getUbicacion().setOrientacion(Orientacion.SURESTO);
            getUbicacion().setArbol(listaArbol.obtener(1));
            lista.insertar(getUbicacion());
            setUbicacion(null);
        } 
        catch (Exception e) {
            System.out.println("");
        }

        return lista;
    }
}
