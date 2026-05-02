/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ArbolBin {

    private  Nodo Raiz;

    public ArbolBin() {
        Raiz = null;
    }

    public  void Creararbol() {
        String cadena = JOptionPane.showInputDialog("Ingrese los caracteres del arbol");
        char Vc[] = cadena.toCharArray();
        for (int i = 0; i < Vc.length; i++) {
           Raiz= Arboles.insertar(Raiz, Vc[i]);
        }
    }
      public Nodo getRaiz() {        
        return Raiz;
    }
    public void preorden(Nodo raiz){
      if(raiz!=null){
          System.out.println(raiz.getDato()+" ");
          preorden(raiz.getLI());
          preorden(raiz.getLD());
      }
    }
    public void Inorden(Nodo raiz){
      if(raiz!=null){
          
          preorden(raiz.getLI());
          System.out.println(raiz.getDato()+" ");
          preorden(raiz.getLD());
      }
    }
    public void posorden(Nodo raiz){
      if(raiz!=null){
          preorden(raiz.getLI());
          preorden(raiz.getLD());
           System.out.println(raiz.getDato()+" ");

      }
    }
    
    
}