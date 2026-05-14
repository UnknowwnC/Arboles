
package arboles;


public class Nodo {
    private  Nodo LI, LD;
private char Dato;
int fb;

    public Nodo( char Dato) {
        this.LI = null;
        this.LD = null;
        this.Dato = Dato;
        this.fb =0;
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

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }


}