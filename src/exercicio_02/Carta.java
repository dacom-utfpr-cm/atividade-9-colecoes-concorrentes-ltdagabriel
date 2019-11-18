package exercicio_02;

/**
 * Copas: 0000 0011 --> 3
 * <p>
 * Ouros: 0000 0100 --> 4
 * <p>
 * Paus: 0000 0101 --> 5
 * <p>
 * Espadas: 0000 0110 -->6
 */
public class Carta {
    private int numero;
    private String simbolo;
    private int naipe;
    private int id;
    private static String[] naipes = {"Ouros", "Copas", "Espadas", "Paus"};

    Carta(int id) {
        this.id = id;
        numero = id % 13 + 1;
        naipe = id / 13;
        if (numero > 10) {
            String[] simbolos = {"Q", "J", "K"};
            simbolo = simbolos[numero % 10 - 1];
        }
        if (numero == 1) {
            simbolo = "A";
        }
    }

    public void print() {
        if (simbolo != null)
            System.out.println("[" + simbolo + "] de " + naipes[naipe]);
        else
            System.out.println("[" + numero + "] de " + naipes[naipe]);
    }
}
