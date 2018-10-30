/**
 * EBike
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public final class EBike extends Bicicleta implements OperarBicicleta {

    private int bateria;

    EBike() {
        this.bateria = 0;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int novoValor) {
        this.bateria = novoValor;
    }

    // Sobrescrita do metodo geraModelo
    public void geraModelo(String modelo) {
        // EB = E-bike
        modelo = "EB" + modelo;
        setModelo(modelo);
    }

    // Implementacao da Interface "OperarBicicleta"
    public void mudarCadencia(int novoValor) {
        if (novoValor >= 0 && novoValor <= 100) {
            setCadencia(novoValor);
        } else {
            System.out.println("Erro: Cadencia precisa estar entre 0 e 100");
        }
    }

    public void mudarMarcha(int novoValor) {
        if (novoValor >= 1 && novoValor <= 10) {
            setMarcha(novoValor);
        } else {
            System.out.println("Erro: Marcha precisa estar entre 1 e 10");
        }
    }

    public void acelerar(int incremento) {
        // verificar se o usuario passou um incremento valido
        if (incremento >= 0) {
            // mandar aviso de bateria baixa se estiver menor que 5 kw/h
            if (getBateria() < 5) {
                System.out.println("Cuidado: bateria baixa.");
                // aumentar velocidade
                setVelocidade(getVelocidade() + incremento);
            }
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