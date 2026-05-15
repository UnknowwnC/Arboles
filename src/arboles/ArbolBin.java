package arboles;

import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author me
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

        if (raiz == null) {
            raiz = new Nodo(vc[i]);  
        } else {
            insertar(raiz, vc[i]);   
        }

        AVL(null, raiz, false); 
    }
}
private void AVL(Nodo padre, Nodo r, boolean esIzq) {
    if (r == null) return;
    AVL(r, r.getLI(), true);
    AVL(r, r.getLD(), false);
    int R = ValidarRot(r);
    Nodo nuevaRaiz = null;
    switch (R) {
        case 1:
            Nodo p = r.getLI();
            Nodo q = p.getLD();
            p.setLD(r);
            r.setLI(q);
            nuevaRaiz = p;
            break;
        case 2:
            Nodo p1 = r.getLD();
            Nodo q1 = p1.getLI();
            p1.setLI(r);
            r.setLD(q1);
            nuevaRaiz = p1;
            break;
        case 3:
            if (r.getLI() == null || r.getLI().getLD() == null) break;
           Nodo p4 = r.getLI();        
    Nodo q4 = p4.getLD();        
    p4.setLI(q4.getLI());      
    q4.setLD(p4);                

    r.setLD(q4.getLD());        
    q4.setLI(r);              
    nuevaRaiz = q4;              
            break;
        case 4:
              System.out.println("Entrando case4 r=" + r.getDato());
    if (r.getLD() == null || r.getLD().getLI() == null) {
        System.out.println("Proteccion activada getLD=" + r.getLD() + " getLI=" + (r.getLD()==null?"null":r.getLD().getLI()));
        break;
    }
    if (r.getLD() == null || r.getLD().getLI() == null) break;
    Nodo p3 = r.getLD();        
    Nodo q3 = p3.getLI();        
    p3.setLI(q3.getLD());      
    q3.setLD(p3);                

    r.setLD(q3.getLI());        
    q3.setLI(r);              
    nuevaRaiz = q3;              
    break;

    }
    System.out.println("R=" + R + " nuevaRaiz=" + (nuevaRaiz==null?"null":nuevaRaiz.getDato()));
    if (nuevaRaiz != null) {

        if (padre == null) {
            raiz = nuevaRaiz;
        } else if (esIzq) {
            padre.setLI(nuevaRaiz);
        } else {
            padre.setLD(nuevaRaiz);
        }
    }
}  

    public int FatorBalance(Nodo r) {
        if (r == null) {
            return 0;
        }

        return altura(r.getLI()) - altura(r.getLD());
    }

   public int ValidarRot(Nodo r) {
    int fb = FatorBalance(r);
    System.out.println("Nodo: " + r.getDato() + " fb=" + fb);
    
    if (fb >= -1 && fb <= 1) return 0;
    if (fb > 1 && FatorBalance(r.getLI()) >= 0) { System.out.println("caso 1"); return 1; }
    if (fb < -1 && FatorBalance(r.getLD()) <= 0) { System.out.println("caso 2"); return 2; }
    if (fb > 1 && FatorBalance(r.getLI()) < 0) { System.out.println("caso 3"); return 3; }
    if (fb < -1 && FatorBalance(r.getLD()) > 0) { System.out.println("caso 4"); return 4; }
    return 0;
}

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

    /* public void insertarDato(Nodo r){
        char dato =  Integer.JOptionPane.showInputDialog("Ingrese la letra a insertar:");
        
        
        Nodo p = new Nodo(dato);
        
        while(r!=null){
        if(dato)
            
        }
    }
    } */
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
        if (r.getDato() == dat1) {
            System.out.println("Ya existe ese dato");
            return;
        }

        if (dat1 < r.getDato()) {
            if (r.getLI() == null) {
                r.setLI(new Nodo(dat1));
            } else {
                insertar(r.getLI(), dat1);
            }

        } else {
            if (r.getLD() == null) {
                r.setLD(new Nodo(dat1));
            } else {
                insertar(r.getLD(), dat1);
            }

        }
    }

    public Nodo eliminar(Nodo r, char dato) {

        if (r == null) {
            return null;
        }

        if (dato < r.getDato()) {

            r.setLI(eliminar(r.getLI(), dato));

        } else if (dato > r.getDato()) {
            r.setLD(eliminar(r.getLD(), dato));
        } else {

            if (r.getLI() == null && r.getLD() == null) {
                return null;
            }

            if (r.getLI() == null) {
                return r.getLD();
            }

            if (r.getLD() == null) {
                return r.getLI();
            }

            Nodo sucesor = menor(r.getLD());

            r.setDato(sucesor.getDato());
            r.setLD(eliminar(r.getLD(), sucesor.getDato()));
        }

        return r;
    }

    public Nodo menor(Nodo r) {
        while (r.getLI() != null) {
            r = r.getLI();
        }
        return r;
    }

    public boolean padre(Nodo r, char buscado) {

        if (r == null) {
            return false;

        }
        if (r.getLI() != null && r.getLI().getDato() == buscado) {
            return true;
        }
        if (r.getLD() != null && r.getLD().getDato() == buscado) {
            return true;
        }
        return padre(r.getLI(), buscado) || padre(r.getLD(), buscado);
    }

    Nodo resultado = null;

    public void primoshermanos(Nodo r, char buscado) {
        padre(r, buscado);

        if (padre(r.getLI(), buscado)) {
            resultado = r.getLD();
            return;
        }
        if (padre(r.getLD(), buscado)) {
            resultado = r.getLI();
            return;
        }

        primoshermanos(r.getLD(), buscado);
        primoshermanos(r.getLI(), buscado);

    }

    public boolean mostrarancestros(Nodo r, char ances) {
        if (r == null) {
            return false;

        }
        if (r.getDato() == ances) {
            return true;
        }

        if (mostrarancestros(r.getLI(), ances) || mostrarancestros(r.getLD(), ances)) {

            System.out.println(r.getDato());
            return true;
        }

        return false;
    }

public void cymd(Nodo r, char descendiente){
if (r == null) {
            return false;

if (r.getDato() == descendiente) {
            return false;
        }

        if (cymd(r.getLI(), descendiente) || cymd(r.getLD(), ances)) {

            System.out.println(r.getDato());
            return false;
        }

        return true;
    }






}
}
