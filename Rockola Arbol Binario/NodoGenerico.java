
public class NodoGenerico
{
    private String dato;
    private Melodia melody;

    private NodoGenerico left ,right;

    public NodoGenerico(String dato, Melodia melody){
        this.dato = dato;
        this.melody = melody ;
        NodoGenerico left , right = null;
    }

    public void imprimirDato() {
        System.out.printf("\n%s",dato);
    }

    public String getDato(){
        return this.dato;
    }

    public Melodia getMelody(){
        return this.melody;
    }

    public NodoGenerico getLeft(){
        return this.left;
    }

    public void setLeft(NodoGenerico left){
        this.left = left;
    }

    public NodoGenerico getRight(){
        return this.right;
    }

    public void setRight(NodoGenerico right){
        this.right = right;
    }

}
