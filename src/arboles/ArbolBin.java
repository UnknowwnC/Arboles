package arboles;

import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ArbolBin {

    public Nodo raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public void IngresarArbol() {

        String cadena = JOptionPane.showInputDialog("Ingrese las letras:");
        char vc[] = cadena.toCharArray();

        for (int i = 0; i < vc.length; i++) {

            Nodo nuevo = new Nodo(vc[i]);

            if (raiz == null) {
                raiz = nuevo;
            } else {

                Nodo actual = raiz;
                Nodo p = null;

                while (actual != null) {
                    p = actual;

                    if (vc[i] < actual.getDato()) {
                        actual = actual.getLI();
                    } else {
                        actual = actual.getLD();
                    }
                }

                if (vc[i] < p.getDato()) {
                    p.setLI(nuevo);
                } else {
                    p.setLD(nuevo);
                }
            }
            //AVL();

        }

    }

    /* private void AVL(){
        FactorBalance();
        
        int R = ValidarRot();
        switch (R) {
            case 1: // rotac.derecha
                
                break;
                
                case 2:// rotaiz
                
                break;
                
                case 3:// rotadbobledere
                
                break;
                
                case 4: // rotadobleizquier
                
                break;
            default:
                throw new AssertionError();
        }
    }*/
    public void mostrar(Nodo raiz, int nivel) {
        Nodo siguienteDer = raiz.getLD();
        Nodo siguienteIzq = raiz.getLI();
        System.out.println("    " + raiz.getDato() + "    ");

        if (raiz != null) {
            while (siguienteDer != null && siguienteIzq != null) {
                if (siguienteIzq.getDato() < raiz.getDato()) {

                    siguienteIzq = siguienteIzq.getLI();
                }
                if (siguienteDer.getDato() > raiz.getDato()) {
                    System.out.print("    " + siguienteDer.getDato());

                    siguienteDer = siguienteDer.getLD();

                }
                nivel++;
            }
        } else {
            System.out.println("El arbol esta vacio...");
        }

    }

    /*Nodo siguiente = raiz.getLD();
        if (siguiente != null) {
            
            System.out.println(raiz.getDato());

            while (siguiente.getLD() != null) {
                while (siguiente.getLI() != null) {
                    raiz = raiz.getLD();
                    if (raiz.getDato() < siguiente.getDato()) {

                        System.out.println("\n " + siguiente.getDato());
                        siguiente = siguiente.getLD();

                    }
                    if (raiz.getDato() > siguiente.getDato()) {
                        System.out.println("\n" + siguiente.getDato());
                        siguiente = siguiente.getLD();
                    }
                }
            }
        }*/
    public void preorden(Nodo r) {
        if (r != null) {
            System.out.print(r.getDato() + " "); // raiz
            preorden(r.getLI()); // izq
            preorden(r.getLD()); // der
        }
    }

    public void inorden(Nodo r) {
        if (r != null) {
            inorden(r.getLI()); //izq
            System.out.print(r.getDato() + " "); //raiz
            inorden(r.getLD()); //der
        }
    }

    public void posorden(Nodo r) {
        if (r != null) {
            posorden(r.getLI()); //izq
            posorden(r.getLD()); // der
            System.out.print(r.getDato() + " "); //rai 
        }
    }

    public int contarHojas(Nodo r) {
        if (r == null) {
            return 0;
        }

        if (r.getLI() == null && r.getLD() == null) {
            return 1;
        }

        return contarHojas(r.getLI()) + contarHojas(r.getLD());
    }

    public int contarPadres(Nodo r) {
        if (r == null) {
            return 0;
        }
        int contador = 0;
        if (r.getLI() != null || r.getLD() != null) {
            contador += 1;
        }

        return contador + contarPadres(r.getLI()) + contarPadres(r.getLD());
    }

  
    public void mybrother(Nodo r, char dat) {

        if (r == null) {
            return;
        }

        if (r.getLD() != null && r.getLD().getDato() == dat) {

            if (r.getLI() != null) {
                System.out.println("Hermano: " + r.getLI().getDato());

            } else {
                System.out.println("No tiene hermano");
            }

        }
        if (r.getLI() != null && r.getLI().getDato() == dat) {

            if (r.getLD() != null) {
                System.out.println("Hermano: " + r.getLD().getDato());
            } else {
                System.out.println("No tiene hermano");
            }
        }

        mybrother(r.getLI(), dat);
        mybrother(r.getLD(), dat);
    }

    public int nivel(Nodo r, char dato, int nivel) {

        if (r == null) {
            return -1;
        }

        if (r.getDato() == dato) {
            return nivel;
        }
        if (r.getDato() > dato) {
            return nivel(r.getLI(), dato, nivel + 1);
        } else {
            return nivel(r.getLD(), dato, nivel + 1);
        }

    }

    //MFBHTRZ
    public int altura(Nodo r) {

        if (r == null) {
            return -1;
        }

        return 1 + Math.max(
                altura(r.getLI()),
                altura(r.getLD())
        );
    }
    
    public void insertar(Nodo r, char dat1) {
    if (r == null) {
        r = new Nodo(dat1);
        return;
    }
    if(r.getDato()==dat1){
        System.out.println("Ya existe ese dato");
        return;
    }

    if (dat1 < r.getDato() && r.getDato() != dat1) {
        if (r.getLI() == null && r.getDato() != dat1)
            r.setLI(new Nodo(dat1));
        else
            insertar(r.getLI(), dat1);
    } else {
        if (r.getLD() == null && r.getDato() != dat1)
            r.setLD(new Nodo(dat1));
        else
            insertar(r.getLD(), dat1);
    }
}

}