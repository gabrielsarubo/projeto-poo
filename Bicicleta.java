/**
 * Bicicleta
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public abstract class Bicicleta {

    private int cadencia;
    private int velocidade;
    private int marcha;
    private String modelo;
    private Fabricacao fabricacao;

    Bicicleta() {
        this.cadencia = 0;
        this.velocidade = 0;
        this.marcha = 1;
        this.modelo = "";
        this.fabricacao = new Fabricacao();
    }

    public Fabricacao getFabricacao() {
        return fabricacao;
    }

    public int getCadencia() {
        return cadencia;
    }

    public void setCadencia(int novoValor) {
        this.cadencia = novoValor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int novoValor) {
        this.velocidade = novoValor;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int novoValor) {
        this.marcha = novoValor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void geraModelo(String modelo) {
        // BK = geral, bike, bicicleta
        this.modelo = modelo + "BK";
    }
}