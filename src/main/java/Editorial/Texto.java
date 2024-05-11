package Editorial;
import java.util.ArrayList;
import java.util.List;

class Texto {
    private Autor autor;
    private String pais;
    private String ciudadOrigen;
    private int impresiones;
    private List<Edicion> ediciones; // Lista de ediciones

    public Texto(Autor autor, String pais, String ciudadOrigen, int impresiones) {
        this.autor = autor;
        this.pais = pais;
        this.ciudadOrigen = ciudadOrigen;
        this.impresiones = impresiones;
        this.ediciones = new ArrayList<>(); // Inicializar lista de ediciones
    }

    public Autor getAutor() {
        return autor;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public int getImpresiones() {
        return impresiones;
    }

    // Método para agregar una edición
    public void agregarEdicion(Edicion edicion) {
        ediciones.add(edicion);
    }

    // Método para obtener las ediciones
    public List<Edicion> getEdiciones() {
        return ediciones;
    }
}
