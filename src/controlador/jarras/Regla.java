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
public class Regla {

    public static ListaEnlazada<NodoJarra> reglas(Jarra jg, Jarra jp) {
        Integer x = jg.getCapacidad_actual();
        Integer y = jp.getCapacidad_actual();
        ListaEnlazada<NodoJarra> lista = new ListaEnlazada<>();
        //R1 Llenar la jarra de 4 litros con la bomba.
        if(x < jg.getCapacidad()) {
            lista.insertar(new NodoJarra(jg.getCapacidad(), y));
        }
        //R2 Llenar la jarra de 3 litros con la bomba.
        if(y < jp.getCapacidad()) {
            lista.insertar(new NodoJarra(x, jp.getCapacidad()));
        }
        //R3 Vaciar la jarra de 4 litros en el suelo.
        if(x > 0) {
            lista.insertar(new NodoJarra(0, y));
        }
        //R4 Vaciar la jarra de 3 litros en el suelo.
        if(y > 0) {
            lista.insertar(new NodoJarra(x, 0));
        }
        //R5 Llenar la jarra de 4 litros con la jarra de 3 litros.
        //Jg 2L    Jp 3L
        //JG 4L    (3 - (4 - 2))  1L
        if(((x+y) >= jg.getCapacidad()) && (x < jg.getCapacidad() && y > 0)) {
            lista.insertar(new NodoJarra(jg.getCapacidad(), y - (jg.getCapacidad() - x)));
        }
        //R6 Llenar la jarra de 3 litros con la jarra de 4 litros.
        //Jg 2L    Jp 2L
        //JG 1L        3L
        if(((x+y) >= jp.getCapacidad()) && (y < jp.getCapacidad() && y > 0)) {
            lista.insertar(new NodoJarra(x - (jp.getCapacidad() - y), jp.getCapacidad()));
        }
        //R7 Vaciar la jarra de 3 litros en la jarra de 4 litros.
        //Jg 2L    Jp 2L
        //JG 4L        0L
        if(((x+y) <= jg.getCapacidad()) && y > 0) {
            lista.insertar(new NodoJarra((x+y), 0));
        }
        //R8 Vaciar la jarra de 4 litros en la jarra de 3 litros
        //Jg 1L    Jp 1L
        //JG 0L        2L
        if(((x+y) <= jp.getCapacidad()) && x > 0) {
            lista.insertar(new NodoJarra(0, (x+y)));
        }
        return lista;
    }
}
