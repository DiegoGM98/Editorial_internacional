package Editorial;
import java.util.List;

class AutorLibro extends Autor {
    private String editorial; // Atributo editorial para el autor de libro

    public AutorLibro(String nombre, String editorial) {
        super(nombre);
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public List<String> getSeudonimos() {
        // Implementación de seudónimos para autor de libro
        return null;
    }
}