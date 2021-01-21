import static java.lang.Math.pow;

public class RBTree {

    public Node Raiz;
    public static final boolean ROJO   = true;
    public static final boolean NEGRO = false;

    public boolean esRojo(Node x){
        if(x==null)
            return false;
        return x.color==ROJO;
    }


    public boolean isEmpty(){
        return Raiz==null;
    }

    public void Insertar(String str,Melodia z){
        if(str==null){
            return;
        }
        float key = GeneraLLave(str);
        Raiz=insert(Raiz,key,str,z);
        Raiz.color=NEGRO;        
    }

    public float GeneraLLave(String str)
    {
        float key = 0;
        char[] arr = str.toCharArray();
        for(int i=0; i<str.length();i++)
        {
            key += arr[i]/pow(10,2*i);
        }
        return key;
    } 

    public Node insert(Node h, float key,String str ,Melodia z){
        if(h==null)
            return new Node(key,str,z,ROJO);

        int cmp= h.compareTo(key);

        if(cmp<0)
            h.left=insert(h.left,key,str,z);
        else if(cmp>0)
            h.right = insert(h.right, key, str,z);
        else
            h.Dato=str; 
        if(esRojo(h.right)&&!esRojo(h.left)){
            h=RotaIzquierda(h);
        }
        if(esRojo(h.left)&&esRojo(h.left.left)){
            h=RotaDerecha(h);
        }
        if(esRojo(h.left)&&esRojo(h.right)){
            flipColors(h);
        }
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    public Node RotaIzquierda(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=x.left.color;
        x.left.color=ROJO;
        x.size=h.size;
        h.size=size(h.left)+size(h.right) + 1;
        return x;
    }

    public Node RotaDerecha(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=x.right.color;
        x.right.color=ROJO;
        x.size=h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void flipColors(Node h){
        h.color=!h.color;
        h.left.color=!h.left.color;
        h.right.color=!h.right.color;
    }

    public Melodia Buscar(String nombre){
        if(nombre==null){
            return null;       
        }
        float key=GeneraLLave(nombre);
        Melodia buscada=BuscaLlave(Raiz,key);
        return buscada;
    }

    private Melodia BuscaLlave(Node x,float key){
        while(x!=null){
            int cmp = x.compareTo(key);
            if(cmp<0){
                x=x.left;
            }
            else if(cmp>0){
                x=x.right;
            }
            else{
                return x.getMelody();
            }
        }
        return null;
    }

    public Node MueveIzquierda(Node h){
        flipColors(h);
        if(esRojo(h.right.left)){
            h.right=RotaDerecha(h.right);
            h=RotaIzquierda(h);
            flipColors(h);
        }
        return h;
    }

    public int size(Node x){
        if(x==null)
            return 0;
        return x.size;
    }

    public Node MueveDerecha(Node h){
        flipColors(h);
        if(esRojo(h.left.left)){
            h=RotaDerecha(h);
            flipColors(h);
        }
        return h;
    }

    public void InOrder(Node h){
        if(isEmpty())
            System.out.println("Arbol vacio");
        else
            Imprime(h);
    }

    private void Imprime(Node x){
        if( x != null){
            Imprime(x.left);
            if(x.color == false){
                System.out.printf("\n%-5s %-50s",x.Dato,": negro");
            }
            else
                System.out.printf("\n%-5s %5s",x.Dato,": rojo");
            Imprime(x.right); 
        }
    }
}