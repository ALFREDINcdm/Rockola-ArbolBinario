import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Test
{
    public static void main(String[] args) {

        // La rockola recupera las melodias desde un txt
        Rockola juke = new  Rockola();
        juke.llenaArbol();

        // El cliente chavelo imprime el arbol en InOrder "orden alfabetico"
        Cliente p1 = new Cliente("Chavelo");
        p1.MuestrainOrder(juke);

        // se crea un nuvo cliente que pedira canciones para reproducir
        Cliente p2 = new Cliente("Kakashi");
        System.out.println();
        p2.BuscarMelodia(juke,"PARADISE CITY","LA CUMBIA DE CALAMARDO","UN BESO","HELL BELLS","EL PASO DEL GIGANTE","KNOCKING ON HEAVENS DOOR");

        System.out.printf("\n%70s","<----------------------------------------------->\n");
    }

}
