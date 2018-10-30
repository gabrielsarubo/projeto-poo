/**
 * OperarBicicleta
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public interface OperarBicicleta {

    // rotacao por minuto das rodas
    void mudarCadencia(int novoValor);

    void mudarMarcha(int novoValor);

    void acelerar(int incremento);

    void aplicarFreios(int decremento);
}