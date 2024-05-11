package Editorial;
import java.util.ArrayList;
import java.util.List;

class Edicion {
    private Texto texto;
    private List<Localizacion> localizaciones;

    public Edicion(Texto texto) {
        this.texto = texto;
        this.localizaciones = new ArrayList<>();
    }

    public void agregarLocalizacion(Localizacion localizacion) {
        localizaciones.add(localizacion);
    }

    public List<Localizacion> getLocalizaciones() {
        return localizaciones;
    }
}
