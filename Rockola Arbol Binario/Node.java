public class Node implements Comparable{
    Node left,right;
    String Dato ;
    private Melodia melody;
    boolean color;
    int size;
    float key;

    private static final boolean ROJO   = true;
    private static final boolean NEGRO = false;

    public Node (float key,String val,Melodia melody,boolean color){
        this.key=key;
        this.Dato=val;
        this.melody = melody;
        this.color=color;
    }

    @Override
    public int compareTo(Object t) {
        float key = (float)t;
        if(key == this.key)
            return 0;
        else if(key > this.key)
            return 1;
        else 
            return -1;
    }

    
    public Melodia getMelody(){
        return this.melody;
    }


}