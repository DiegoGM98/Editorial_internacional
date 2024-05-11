package Editorial;

class Comic extends Texto {
    private int numeroVinetas;

    public Comic(Autor autor, String pais, String ciudadOrigen, int copiasImpresas, int numeroVinetas) {
        super(autor, pais, ciudadOrigen, copiasImpresas);
        this.numeroVinetas = numeroVinetas;
    }

    public int getNumeroVinetas() {
        return numeroVinetas;
    }
}

