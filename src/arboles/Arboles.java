package arboles;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Arboles {
      
    
    public static void menu() {
        
    int opc;
     ArbolBin arbol = new ArbolBin();
  

    do {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Qué quieres hacer con el árbol?\n"
                + "1. Crear árbol\n"
                + "2. Mostrar árbol (preorden)\n"
                + "3. Mostrar en inorden\n"
                + "4. Mostrar en posorden\n"
                + "5. Eliminar nodo\n"
                + "0. Salir"
        ));

        switch (opc) {

            case 1:
                  arbol.Creararbol();

          
                break;
                

            case 2:
       arbol.preorden(arbol.getRaiz());
                break;

            case 3:
               arbol.Inorden(arbol.getRaiz());
                break;

            case 4:
                arbol.posorden(arbol.getRaiz());
                
                break;

            case 5:
              
                break;

            case 0:
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }

    } while (opc != 0);
}
     
    public static void main(String[] args) {
               menu();
     
    }
    
    public static void Preorden(Nodo raiz){
        if(raiz!=null){
            System.out.println(raiz.getDato()+" ");  
        }
    }
    public static Nodo insertar(Nodo Raiz, char Dato) {

    Nodo nuevo = new Nodo(Dato);

    // árbol vacío
    if (Raiz == null) {
        return nuevo;
    }

    Nodo actual = Raiz;
    Nodo padre = null;

    // buscar posición
    while (actual != null) {
        padre = actual;

        if (Dato < actual.getDato()) {
            actual = actual.getLI();
        } else if (Dato > actual.getDato()) {
            actual = actual.getLD();
        } else {
            // dato repetido
            return Raiz;
        }
    }

    // insertar
    if (Dato < padre.getDato()) {
        padre.setLI(nuevo);
    } else {
        padre.setLD(nuevo);
    }

    return Raiz;
}}