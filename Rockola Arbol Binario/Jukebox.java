import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
public class Jukebox
{

    private RBTree binary;

    public Jukebox(){
        binary = new RBTree();
    }

    public void llenaArbol(){
        try{
            File f = new File("melodias.txt");

            if(f.exists()){
                FileReader  lectorArchivo=new FileReader(f);
                BufferedReader buf = new BufferedReader(lectorArchivo);
                String cadena; 

                while( (cadena = buf.readLine()) != null ){
                    String  [] melodia = cadena.split("&");
                    String dato = melodia[0];
                    Melodia song = new Melodia(melodia[0],melodia[1],
                            melodia[2],melodia[3]);
                    binary.Insertar(dato,song);                            
                }
                buf.close();
            }

        }catch(IOException e){
            System.err.print(e.getMessage());
        }
    }

    public void MostrarMelodia(String name){
        if(binary.Buscar(name) != null){
            System.out.print(binary.Buscar(name));
            Reproduciendo();
        }
        else  System.out.println("\nMelodia No Existe");
    }

    public void ColaMelodia(String ... melodia){
        Queue <Melodia> canciones = new <Melodia> Queue();
        for (int i = 0; i< melodia.length; i++){
            if(binary.Buscar(melodia[i]) == null){
                System.out.println("\n"+melodia [i]+" No Existe");
            }
            else
                canciones.enqueue(binary.Buscar(melodia[i]));
        }

        if( ! canciones.isEmpty()){
            System.out.println("\nReproduciendo cola de melodias");

            for(Melodia e: canciones){
                System.out.print(e);
                Reproduciendo();
            }
        }
    }

    
    public void MuestraInOrder(){
        binary.InOrder(binary.Raiz);
    }

    private void Reproduciendo(){
        for(int i = 0; i<=41;i++){
            System.out.print("♬♫");
            try{
                Thread.sleep(100);
            }catch(InterruptedException c){}
        }
    }
}
