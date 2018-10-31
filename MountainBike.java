/**
 * MountainBike
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public final class MountainBike extends Bicicleta implements OperarBicicleta {

    private String correiaExtra;

    MountainBike() {
        this.correiaExtra = "Nao";
    }

    public String getCorreiaExtra() {
        return correiaExtra;
    }

    public void setCorreiaExtra(String novoValor) {
        this.correiaExtra = novoValor;
    }

    // Sobrescrita do metodo geraModelo
    public void geraModelo(String modelo) {
        // previnir que gere um modelo com multiplos MO no inicio
        if (modelo.charAt(0) == 'M' && modelo.charAt(1) == 'O') {
            setModelo(modelo);
        } else {
            // MO = MOuntain bike
            modelo = "MO" + modelo;
            setModelo(modelo);
        }
    }

    // Implementacao da Interface "OperarBicicleta"
    public void mudarCadencia(int novoValor) {
        if (novoValor >= 0 && novoValor <= 120) {
            setCadencia(novoValor);
        } else {
            System.out.println("Erro: Cadencia precisa estar entre 0 e 120");
        }
    }

    public void mudarMarcha(int novoValor) {
        if (novoValor >= 1 && novoValor <= 15) {
            setMarcha(novoValor);
        } else {
            System.out.println("Erro: Marcha precisa estar entre 1 e 15");
        }
    }

    public void acelerar(int incremento) {
        // verificar se o usuario passou um incremento valido
        if (incremento >= 0) {
            setVelocidade(getVelocidade() + incremento);
        } else {
            System.out.println("Erro: Incremento nao pode ser menor que 0.");
        }
    }

    public void aplicarFreios(int decremento) {
        if (decremento > 0) {
            // diminuir velocidade
            setVelocidade(decremento - getVelocidade());
        }
        else {
            System.out.println("Erro: Decremento nao pode ser menor que 0");
        }
    }
}