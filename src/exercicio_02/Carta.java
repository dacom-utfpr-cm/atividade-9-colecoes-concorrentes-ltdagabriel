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
public class Carta implements Comparable {
    private static String[] naipes = {"Ouros", "Espadas", "Copas", "Paus"};
    private int numero;
    private String simbolo;
    private int naipe;
    private int id;

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

    @Override
    public int compareTo(Object o) {
        Carta c = (Carta) o;

//        // comparação original, menor para maior
//        int menor = -1;
//        int maior = 1;

        // Inverter comparação para exercicio
        int menor = 1;
        int maior = -1;


        if (this.numero < c.numero) {
            return menor;
        } else if (this.numero > c.numero) {
            return maior;
        }
        if (this.naipe > c.naipe) return maior;
        return menor;
    }
}
