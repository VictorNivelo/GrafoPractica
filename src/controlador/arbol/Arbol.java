/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.arbol;

import contolador.listas.ListaEnlazada;

/**
 *
 * @author Victor
 */
public class Arbol {

    private NodoArbol raiz;
    private ListaEnlazada<ListaEnlazada<NodoArbol>> niveles;
    private ListaEnlazada<NodoArbol> orden;
    private Integer altura;
    private Integer nro_nodos;

    public Arbol() {
        raiz = null;
        altura = 0;
        nro_nodos = 0;
        niveles = new ListaEnlazada<>();
        orden = new ListaEnlazada<>();
    }

    private Integer calcularAltura(NodoArbol arbol) throws Exception {
        if (arbol == null) {
            return 0;
        } else {
            Integer izquierda = calcularAltura(arbol.getIzquierda());
            Integer derecha = calcularAltura(arbol.getDerecha());
            if (izquierda > derecha) {
                return izquierda + 1;
            } else {
                return derecha + 1;
            }
        }

    }

    private void calcularNivel(NodoArbol arbol, Integer nivel) throws Exception {
        if (arbol != null) {
            niveles.obtener(nivel).insertar(arbol);
            nivel++;
            calcularNivel(arbol.getIzquierda(), nivel);
            calcularNivel(arbol.getDerecha(), nivel);
        } else if (nivel.intValue() != getAltura().intValue()) {
            niveles.obtener(nivel).insertar(null);
            nivel++;
            calcularNivel(null, nivel);
            calcularNivel(null, nivel);
        }
    }

    public Integer getAltura() throws Exception {
        //altura = calcularAltura(raiz);
        return altura;
    }

    public ListaEnlazada<ListaEnlazada<NodoArbol>> getNiveles() {
        return niveles;
    }

    public Integer getNro_nodos() {
        return nro_nodos;
    }

    private void nivel() throws Exception {
        niveles = new ListaEnlazada<>();
        this.altura = calcularAltura(raiz);
        for (int i = 0; i <= this.altura; i++) {
            niveles.insertar(new ListaEnlazada<>());
        }
        calcularNivel(raiz, 0);
        try {
            niveles.eliminar(niveles.getSize() - 1);
        } catch (Exception e) {
        }
    }

    public Boolean insertar(Integer valor) throws Exception {
        if (raiz == null) {
            raiz = new NodoArbol(valor);
            nro_nodos++;
            nivel();
            return true;
        } else {
            NodoArbol nuevo = new NodoArbol(valor);
            NodoArbol actual = raiz;
            NodoArbol padre;
            while (true) {
                padre = actual;
                if (valor.intValue() == actual.getDato().intValue()) {
                    return false;
                } else if (valor.intValue() < actual.getDato().intValue()) {
                    actual = actual.getIzquierda();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setIzquierda(nuevo);
                        nro_nodos++;
                        nivel();
                        return true;
                    }
                } else {
                    actual = actual.getDerecha();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setDerecha(nuevo);
                        nro_nodos++;
                        nivel();
                        return true;
                    }
                }
            }
            //return true;
        }
    }

    public ListaEnlazada<NodoArbol> pre_orden() throws Exception {
        orden = new ListaEnlazada<>();
        pre_orden(raiz);
        return orden;
    }

    private void pre_orden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            orden.insertar(arbol);
            pre_orden(arbol.getIzquierda());
            pre_orden(arbol.getDerecha());
        }
    }

    public ListaEnlazada<NodoArbol> post_orden() throws Exception {
        orden = new ListaEnlazada<>();
        post_orden(raiz);
        return orden;
    }

    private void post_orden(NodoArbol arbol) throws Exception {
        if (arbol != null) {

            post_orden(arbol.getIzquierda());
            post_orden(arbol.getDerecha());
            orden.insertar(arbol);
        }
    }

    public ListaEnlazada<NodoArbol> in_orden() throws Exception {
        orden = new ListaEnlazada<>();
        in_orden(raiz);
        return orden;
    }

    private void in_orden(NodoArbol arbol) throws Exception {
        if (arbol != null) {

            in_orden(arbol.getIzquierda());
            orden.insertar(arbol);
            in_orden(arbol.getDerecha());
        }
    }
    
    public NodoArbol buscarNodo (int dato){
        NodoArbol auxArbol = raiz;
        while(auxArbol.getDato() != dato){
            if(dato<auxArbol.getDato()){
                auxArbol = auxArbol.getIzquierda();
            }
            else{
                auxArbol = auxArbol.getDerecha();
            }
            if(auxArbol == null){
                return null;
            }
        }
        return auxArbol;
    }
    
    public boolean eliminar(int dato){
        NodoArbol auxArbol = raiz;
        NodoArbol padre = raiz;
        boolean EsIzquierdo = true;
        while(auxArbol.getDato() != dato){
            padre = auxArbol;
            if(dato < auxArbol.getDato()){
                EsIzquierdo = true;
                auxArbol = auxArbol.getIzquierda();
            }
            else{
                EsIzquierdo = false;
                auxArbol = auxArbol.getDerecha();
            }
            if(auxArbol==null){
                return false;
            }
        }
        if(auxArbol.getIzquierda() == null && auxArbol.getDerecha()==null){
            if(auxArbol == raiz){
                raiz = null;
            }
            else if(EsIzquierdo){
                padre.setIzquierda(null);
            }
            else{
                padre.setDerecha(null);
            }
        }
        else if(auxArbol.getDerecha() == null){
            if(auxArbol==raiz){
                raiz=auxArbol.getIzquierda();
            }
            else if(EsIzquierdo){
                padre.setIzquierda(auxArbol.getIzquierda());
            }
            else{
                padre.setDerecha(auxArbol.getIzquierda());
            }
        }
        else if(auxArbol.getIzquierda() == null){
            if(auxArbol==raiz){
                raiz=auxArbol.getDerecha();
            }
            else if(EsIzquierdo){
                padre.setIzquierda(auxArbol.getDerecha());
            }
            else{
                padre.setDerecha(auxArbol.getIzquierda());
            }
        }
        else{
            NodoArbol remplazo = obtenerNodoRemplazo(auxArbol);
            if(auxArbol==raiz){
                raiz=remplazo;
            }
            else if(EsIzquierdo){
                padre.setIzquierda(remplazo);
            }
            else{
                padre.setDerecha(remplazo);
            }
            remplazo.setIzquierda(auxArbol.getIzquierda());
        }
        return true;
    }
    
    public NodoArbol obtenerNodoRemplazo(NodoArbol nodoRemplazo){
        NodoArbol remplazarPadre = nodoRemplazo;
        NodoArbol remplazo = nodoRemplazo;
        NodoArbol auxiliar = nodoRemplazo.getDerecha();
        while(auxiliar!=null){
            remplazarPadre=remplazo;
            remplazo = auxiliar;
            auxiliar = auxiliar.getIzquierda();
        }
        if(remplazo != nodoRemplazo.getDerecha()){
            remplazarPadre.setIzquierda(remplazo.getDerecha());
            remplazo.setDerecha(nodoRemplazo.getDerecha());
        }
        return remplazo;
    }

    public static void main(String[] args) {

        try {
            Arbol a = new Arbol();
            a.insertar(50);
            a.insertar(40);
            a.insertar(90);
            a.insertar(30);
            a.insertar(45);
            a.insertar(60);
            a.insertar(100);
            a.insertar(25);
            a.insertar(35);

            /*a.insertar(56);
            a.insertar(34);
            a.insertar(78);
            a.insertar(24);
            a.insertar(35);
            a.insertar(60);
            a.insertar(90);*/
            System.out.println("Nro nodos " + a.nro_nodos);
            System.out.println("Altura " + a.getAltura());
            System.out.println("Niveles " + a.getNiveles().obtener(2).getSize());
            a.getNiveles().obtener(2).imprimir();
            System.out.println("Pre orden ");
            a.pre_orden().imprimir();
            System.out.println("Post orden ");
            a.post_orden().imprimir();
            System.out.println("In orden ");
            a.in_orden().imprimir();
            
            String[][] matriz = new String[a.getAltura()][a.getNro_nodos()];
            
            //Integer posicion = 5 * a.getNro_nodos();
            //Integer tamanio_columna = 5;
            Integer col = 0;
            Integer salto = 1;
            Integer cont = 1;
            System.out.println("------------- ");
            for(int i = a.getNiveles().getSize()-2; i >=0; i--) {
                
                ListaEnlazada<NodoArbol> aux = a.getNiveles().obtener(i);
                System.out.println("////////////////////");
                for (int j = 0; j < aux.getSize(); j++) {

                    matriz[i][col] = String.valueOf(aux.obtener(j));
                    if (i == a.getNiveles().getSize() - 2) {
                        col = col + 2;
                    } 
                    else {
                        col = col + salto;
                    }
                }
                cont++;
                if(i != 0) {
                    col = salto;
                    salto =  (int)(Math.pow(2, Double.parseDouble(cont.toString())));
                } 
                else 
                    salto = salto -1;
                System.out.println("col "+col+" sal "+salto+" cont "+cont);
                //System.out.println("");
            }
            System.out.println("*******************88");
            for(int i = 0; i<matriz.length; i++) {
                for(int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j]+"     ");
                }
                System.out.println("");
            }
            
            /*for (int i = 0; i < a.getNiveles().getSize() -1; i++) {   
                ListaEnlazada<NodoArbol> aux = a.getNiveles().obtener(i);
                Integer posA = posicion / aux.getSize();                
                String cadena = a.psociones(posA);
                System.out.println("");                
                Integer espacios = posA;
                for(int j = 0; j < aux.getSize(); j++) {                    
                    if(aux.obtener(j) != null) {
                        System.out.print(cadena+aux.obtener(j)+"\t");                        
                    } else {
                        System.out.print(cadena);
                    }
                    espacios += espacios;
                    cadena = a.psociones(espacios);
                }
                System.out.println("");
            }*/
        } 
        catch (Exception e) {
            System.out.println("Error " + e);
            e.printStackTrace();
        }
    }
    
    public String psociones(Integer aux) {
        StringBuilder cadena = new StringBuilder();
        for(int i = 0; i < aux; i++) {
            cadena.append("  ");
        }
        return cadena.toString();
    }
    
    
}
