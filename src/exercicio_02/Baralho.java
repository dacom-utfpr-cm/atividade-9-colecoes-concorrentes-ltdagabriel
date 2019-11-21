package exercicio_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    List<Carta> cartas = new ArrayList<>();


    Baralho() {
        for (int i = 0; i < 52; i++) {
            cartas.add(new Carta(i));
        }
        embaralhar();
    }

    private void embaralhar() {
        Collections.shuffle(cartas);
    }

    boolean vazio() {
        return cartas.size() == 0;

    }


    Carta get() {
        if (vazio()) return null;

        return cartas.remove(0);
    }

}
