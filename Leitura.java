import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Leitura
 * Autor: Gabriel Sousa (feito com <3)
 * RA: 1997432
 */
public class Leitura {

    // retorna uma valor do tipo "String"
    public String entDados(String rotulo) {
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader memoria = new BufferedReader(teclado);
        String entrada = "";

        System.out.print(rotulo);
        try {
            entrada = memoria.readLine();
        } catch (IOException ioe) {
            System.out.println("Erro na entrada de dados!");
        }

        return entrada;
    }

    // retorna uma valor do tipo "Inteiro"
    public int entDadosInt(String rotulo) {
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader memoria = new BufferedReader(teclado);
        String entrada = "";

        System.out.print(rotulo);
        try {
            entrada = memoria.readLine();
        } catch (IOException ioe) {
            System.out.println("Erro na entrada de dados!");
        }

        int entradaInt = Integer.parseInt(entrada);
        return entradaInt;
    }
}