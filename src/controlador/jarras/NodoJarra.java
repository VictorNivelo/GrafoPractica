/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.jarras;

import contolador.listas.ListaEnlazada;
import modelo.jarra.Jarra;

/**
 *
 * @author Victor
 */
public class NodoJarra {
    private Jarra jg;
    private Jarra jp;
    private NodoJarra padre;
    private ListaEnlazada<NodoJarra> sucesores = new ListaEnlazada<>();

    public NodoJarra getPadre() {
        return padre;
    }

    public void setPadre(NodoJarra padre) {
        this.padre = padre;
    }
    
    
    public NodoJarra() {
        jg = new Jarra();
        jp = new Jarra();
        jg.setCapacidad(4);
        jp.setCapacidad(3);
        jg.setCapacidad_actual(0);
        jp.setCapacidad_actual(0);
    }
    
    public NodoJarra(Integer cjg, Integer cjp) {
        this();
        jg.setCapacidad_actual(cjg);
        jp.setCapacidad_actual(cjp);
    }
    

    public Jarra getJg() {
        return jg;
    }

    public void setJg(Jarra jg) {
        this.jg = jg;
    }

    public Jarra getJp() {
        return jp;
    }

    public void setJp(Jarra jp) {
        this.jp = jp;
    }
    
    public static Boolean comparar(NodoJarra i, NodoJarra f) {
        if (i != null && f != null) {
            if (i.getJg().getCapacidad_actual().intValue() == f.getJg().getCapacidad_actual().intValue()
                    && i.getJp().getCapacidad_actual().intValue() == f.getJp().getCapacidad_actual().intValue()) {
                return true;
            }
        }
        return false;
    }

    public void aplicarReglas(ListaEnlazada<NodoJarra> reglas) {
        sucesores = new ListaEnlazada<>();
        if (reglas.getSize() > 0) {
            NodoJarra[] reglasArreglo = reglas.toArray();
            for (int i = 0; i < reglasArreglo.length; i++) {
                NodoJarra aux = reglasArreglo[i];
                aux.setPadre(this);
                sucesores.insertarCabecera(aux);
            }
        }
    }

    @Override
    public String toString() {
        return "("+jg+" - "+jp+")";
    }
    
    public void crearJarras(Integer cjg, Integer cjp) {
        jg.setCapacidad(cjg);
        jp.setCapacidad(cjp);
    }
    
    public void fijarEstadoJarras(Integer cjg, Integer cjp) {
        jg.setCapacidad_actual(cjg);
        jp.setCapacidad_actual(cjp);
    }
}
