/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.grafos;

import controlador.grafo.GrafoNoDirijidoEtiquetado;
import vista.FrmGrafo;

/**
 *
 * @author Victor
 */
public class Grafos20223 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
//        GrafoDirigido gd = new GrafoDirigido(4);
//        System.out.println(gd);
//        System.out.println("-------------------------");
//        try {
//            gd.insertarArista(4, 2);
//            gd.insertarArista(4, 1);
//            gd.insertarArista(4, 3);
//           // gd.insertarArista(2, 3);
//            System.out.println(gd);
//        } catch (Exception e) {
//            System.out.println("Error "+e.getMessage());
//        }
//        System.out.println("GRAFO NO DIRIGIDO");
//        GrafoNoDirigido gnd = new GrafoNoDirigido(4);
//        System.out.println(gnd);
//        System.out.println("-------------------------");
//        try {
//            gnd.insertarArista(1, 3);
//            gnd.insertarArista(1, 4);
//            gnd.insertarArista(2, 3);
//         //   new FrmGrafo(null, true, gnd).setVisible(true);
//            //gd.insertarArista(2, 3);
//            System.out.println(gnd);
//        } catch (Exception e) {
//            System.out.println("Error "+e.getMessage());
//        }
//        
//        HashMap<Integer, String> mapa = new HashMap<>();
//        mapa.put(5, "casa");
//        System.out.println(mapa.get(1));
        GrafoNoDirijidoEtiquetado grafoDirigiodoEtiquetado = new GrafoNoDirijidoEtiquetado(7, String.class);
//        String vertice = JOptionPane.showInputDialog("ingrese la etiqueta");
        grafoDirigiodoEtiquetado.etiquetarVertice(1, "1");
        grafoDirigiodoEtiquetado.etiquetarVertice(2, "2");
        grafoDirigiodoEtiquetado.etiquetarVertice(3, "3");
        grafoDirigiodoEtiquetado.etiquetarVertice(4, "4");
        grafoDirigiodoEtiquetado.etiquetarVertice(5, "5");
        grafoDirigiodoEtiquetado.etiquetarVertice(6, "6");
        grafoDirigiodoEtiquetado.etiquetarVertice(7, "7");
       
        try {
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(1), grafoDirigiodoEtiquetado.obtenerEtiqueta(2), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(2), grafoDirigiodoEtiquetado.obtenerEtiqueta(3), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(3), grafoDirigiodoEtiquetado.obtenerEtiqueta(4), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(4), grafoDirigiodoEtiquetado.obtenerEtiqueta(5), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(5), grafoDirigiodoEtiquetado.obtenerEtiqueta(6), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(2), grafoDirigiodoEtiquetado.obtenerEtiqueta(6), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(1), grafoDirigiodoEtiquetado.obtenerEtiqueta(7), 30.0);
            grafoDirigiodoEtiquetado.insertarAristaE(grafoDirigiodoEtiquetado.obtenerEtiqueta(3), grafoDirigiodoEtiquetado.obtenerEtiqueta(7), 30.0);
//            gde.insertarAristaE(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(4), 1000.0);
            //System.out.println(gde.caminiMinimo(1, 4));
            grafoDirigiodoEtiquetado.caminiMinimo(6, 3).imprimir();
            grafoDirigiodoEtiquetado.caminiMinimo(3, 7).imprimir();
//            gde.DijkstracaminoMinimo(1).imprimir();
            //System.out.println(gde.toString());
            new FrmGrafo(null, true, grafoDirigiodoEtiquetado, 1).setVisible(true);
            //new UbicacionController().listar().imprimir();
        } 
        catch (Exception e) {
            
        }
    }
    
}
