package arboles;

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class arboles {

    public static int Menu() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog(
                "----- MENU ARBOL -----\n"
                + "1. Recorrido Inorden \n"
                + "2. Recorrido Preorden \n"
                + "3. Recorrido Posorden \n"
                + "4. Eliminar un nodo \n"
                + "5. Mostrar arbol \n"
                + "6. contar hojas \n"
                + "7. contar padres \n"
                + "8. insertar datos \n"
                + "9. mostrtar el hermano de un dato \n"
                + "10. mostrtar el nivel de un dato \n"
                + "0. Salir \n\n"
                + "Seleccione una opcion:"
        ));

        return opc;
    }

    public static void main(String[] args) {

        ArbolBin arbol = new ArbolBin();

        arbol.IngresarArbol();

        int opc;

        do {
            opc = Menu();

            switch (opc) {
                case 1:
                    System.out.println("Inorden: ");
                    arbol.inorden(arbol.raiz);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Preorden: ");
                    arbol.preorden(arbol.raiz);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Posorden: ");
                    arbol.posorden(arbol.raiz);
                    System.out.println();
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Eliminar ");
                    break;

                case 5:
                    System.out.println("Arbol: ");
                    arbol.mostrar(arbol.raiz, 0);
                    break;

                case 6:
                    int hojas = arbol.contarHojas(arbol.raiz);
                    System.out.println("Cantidad de hojas: " + hojas);
                    break;

                case 7:
                    int padres = arbol.contarPadres(arbol.raiz);
                    System.out.println("Cantidad de padres: " + padres);
                    break;
                    
                case 8:
                      String dat1 = JOptionPane.showInputDialog("Ingrese la letra que desea ingresar:");
                    char datirri = dat1.charAt(0);
                    arbol.insertar(arbol.raiz, datirri);
                    break;

                case 9:
                    String dat = JOptionPane.showInputDialog("Ingrese la letra a la que le buscaremos su hermano:");
                    char dato = dat.charAt(0);
                    arbol.mybrother(arbol.raiz, dato);

                    break;

                case 10:
                    String da = JOptionPane.showInputDialog("Ingrese la letra a la que le buscaremos su nivel:");
                    char dati = da.charAt(0);
                    int nivel = 1;
                    int nivelito = arbol.nivel(arbol.raiz, dati, nivel);

                    if (nivelito == -1) {
                        System.out.println("eso no existe parcero");
                    } else {
                        System.out.println("el nivel es: " + nivelito);
                    }
                    break;

                case 11:

                    String d = JOptionPane.showInputDialog("Ingrese la letra a la que le buscaremos su altura:"
);
                    char dt = d.charAt(0);
                    int nivelNodo = arbol.nivel(arbol.raiz, dt, 0);
                    if (nivelNodo == -1) {
                        System.out.println("eso no existe parcero");
                    } else {
                        int alturaTotal = arbol.altura(arbol.raiz);
                        int alturaNodo = alturaTotal - nivelNodo;
                        System.out.println("La altura es: " + alturaNodo);
                    }

                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        } while (opc != 0);
    }
}