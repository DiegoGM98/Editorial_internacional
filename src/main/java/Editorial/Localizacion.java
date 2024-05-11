package Editorial;

class Localizacion {
    private String pais;
    private boolean censurado;
    private boolean interpretado;

    public Localizacion(String pais, boolean censurado, boolean interpretado) {
        this.pais = pais;
        this.censurado = censurado;
        this.interpretado = interpretado;
    }

    public String getPais() {
        return pais;
    }

    public boolean isCensurado() {
        return censurado;
    }

    public boolean isInterpretado() {
        return interpretado;
    }
}
