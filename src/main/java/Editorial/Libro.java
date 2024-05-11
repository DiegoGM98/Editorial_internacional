package Editorial;

class Libro extends Texto {
    private Editorial editorAprobado;

    public Libro(Autor autor, String pais, String ciudadOrigen, int copiasImpresas, Editorial editorAprobado) {
        super(autor, pais, ciudadOrigen, copiasImpresas);
        this.editorAprobado = editorAprobado;
    }

    public Editorial getEditorAprobado() {
        return editorAprobado;
    }
}

