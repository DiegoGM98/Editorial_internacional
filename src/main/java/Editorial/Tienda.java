package Editorial;
import java.util.ArrayList;
import java.util.List;

class Tienda {
    private String nombre;
    private List<Texto> stockDisponible;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.stockDisponible = new ArrayList<>();
    }

    public void agregarStockDisponible(Texto texto) {
        stockDisponible.add(texto);
    }
}
