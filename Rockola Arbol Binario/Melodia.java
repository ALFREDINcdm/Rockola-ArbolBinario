
public class Melodia
{
    private String nombre ,grupo,integrante, duracion ;

    public Melodia(String n,String g, String cantante,String time){
        nombre = n;
        grupo = g;
        integrante = cantante;
        duracion = time;

    }

    public String getNombre(){return nombre;}

    @Override
    public String toString(){
        return String.format("\n|%-20s| %20s| %20s| %20s \n",nombre,grupo,integrante,duracion);
    }
}
