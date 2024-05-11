package Editorial;
import java.util.ArrayList;
import java.util.List;

class Editorial {
    private List<Texto> textosEnEspera;

    public Editorial() {
        this.textosEnEspera = new ArrayList<>();
    }

    public List<Texto> getTextosEnEspera() {
        return textosEnEspera;
    }

    public void solicitarAprobacion(Texto texto) {
        textosEnEspera.add(texto);
    }

    public void aceptarOferta(AgenciaLibreria agencia, Tienda tienda, Texto texto) {
        tienda.agregarStockDisponible(texto);
    }

    public void verImpresionesYVentas(Texto texto) {
        System.out.println("Impresiones realizadas: " + texto.getImpresiones());
    }
}


