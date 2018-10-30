/**
 * Fabricacao
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public final class Fabricacao {

    private int codFab;
    private String marca;

    Fabricacao() {
        this.codFab = 0;
        this.marca = "";
    }

    public int getCodFab() {
        return codFab;
    }

    public void setCodFab(int novoValor) {
        this.codFab = novoValor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String novoValor) {
        this.marca = novoValor;
    }
}