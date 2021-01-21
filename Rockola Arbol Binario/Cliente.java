
public class Cliente
{

    private final String Nombre;

    public Cliente(String N){
        Nombre = N;
    }

    public void MuestrainOrder(Rockola jukebox){
        jukebox.MuestraInOrder();
    }

    public void BuscarMelodia( Rockola jukebox,String ... nombre){
        jukebox.ColaMelodia(nombre);
    }
}
