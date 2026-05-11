
package arboles;


public class Nodo {
    private  Nodo LI, LD;
private char Dato;

    public Nodo( char Dato) {
        this.LI = null;
        this.LD = null;
        this.Dato = Dato;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }

    public Nodo getLI() {
        return LI;
    }

    public Nodo getLD() {
        return LD;
    }

    public char getDato() {
        return Dato;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

    public void setDato(char Dato) {
        this.Dato = Dato;
    }


}