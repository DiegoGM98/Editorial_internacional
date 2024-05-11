package Editorial;
import java.util.List;

abstract class Autor {
    private String nombre;

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract List<String> getSeudonimos();
}