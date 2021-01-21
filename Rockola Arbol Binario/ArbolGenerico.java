public class ArbolGenerico <T extends Comparable<T>>{
    private NodoGenerico raiz;

    public ArbolGenerico(){}

    public void Insertar(String dato, Melodia melody){
        if(isEmpty()){
            raiz = new NodoGenerico(dato,melody);
        }
        else Add(raiz,dato,melody);
    }

    private void Add(NodoGenerico padre,String dato, Melodia M){ 
        if(dato.compareTo(padre.getDato()) > 0){
            if(padre.getRight() == null){
                padre.setRight(new NodoGenerico(dato,M));
            }
            else{
                Add(padre.getRight(), dato, M);

            }
        }
        else{
            if( padre.getLeft() == null ){
                padre.setLeft(new NodoGenerico(dato,M));
            }
            else{
                Add(padre.getLeft(),dato,M);
            }
        }
    }

    private Melodia Find(NodoGenerico x, String dato){
        if(x == null ) return null;

        if(x.getDato().equals(dato)) {return x.getMelody();}

        else if ( dato.compareTo(x.getDato()) < 0){
            return Find(x.getLeft(), dato);
        }
        else{
            return Find(x.getRight(), dato);
        }
    }

    private void InOrder(NodoGenerico x){
        if( x!= null){
            InOrder(x.getLeft());
            x.imprimirDato();
            InOrder(x.getRight());
        }
    }

    public void InOrder(){
        InOrder(raiz);
    }

    public Melodia ObtenerObjeto(String dato){
        return Find(raiz,dato);
    }

    private void PostOrden(NodoGenerico x){
        if(x != null) {
            PostOrden(x.getLeft());
            PostOrden(x.getRight());
            x.imprimirDato();
        }
    }

    public void PostOrden(){
        PostOrden(raiz);
    }

    public boolean isEmpty(){
        return raiz == null;
    }

}
