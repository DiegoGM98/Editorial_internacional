package Editorial;

class Poemario extends Texto {
    private int numeroVersosPorPagina;
    private int totalPaginas;

    public Poemario(Autor autor, String pais, String ciudadOrigen, int copiasImpresas, int numeroVersosPorPagina, int totalPaginas) {
        super(autor, pais, ciudadOrigen, copiasImpresas);
        this.numeroVersosPorPagina = numeroVersosPorPagina;
        this.totalPaginas = totalPaginas;
    }

    public int getNumeroVersosPorPagina() {
        return numeroVersosPorPagina;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }
}
