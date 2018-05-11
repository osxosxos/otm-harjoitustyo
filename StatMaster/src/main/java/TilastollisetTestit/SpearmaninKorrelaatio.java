package TilastollisetTestit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka Charles Spearmanin kehittämän järjestyskorrelaation laskemiseksi.
 * Kaava on sama kuin Pearsonin korrelaatiossa, mutta arvot ovat
 * järjestysasteikollisia.
 *
 * @author Oskari Koskinen
 */
public class SpearmaninKorrelaatio extends PearsonKorrelaatio {

    /**
     * Luokka, jolla lasketaan spearmanin korrelaatio, joka on sama asia kuin
     * pearsonin korrelaatio järjestysasteikollisille muuttujille.
     */
    public SpearmaninKorrelaatio() {
        super();
    }

    /**
     * Laskee muuttujien välisen spearmanin korrelaation. Datan ei tarvitse olla
     * järjestysasteikollista, koska ohjelma muuttaa datan
     * järjestysasteikolliseksi.
     *
     * @param x Muuttujan X arvot ArrayListinä, jossa kokonaislukuja.
     * @param y Muuttujan Y arvot ArrayListinä, jossa kokonaislukuja.
     */
    public final void laskeSpearman(final ArrayList<Integer> x,
            final ArrayList<Integer> y) {
        ArrayList<Integer> xJarjestys = jarjestys(x);
        ArrayList<Integer> yJarjestys = jarjestys(y);
        super.laske(xJarjestys, yJarjestys);
    }

    /**
     * Muuttaa listan numeroarvot järjestysasteikollisiksi.
     *
     * @param arvot ArrayList, jossa on muuttujan arvot kokonaislukuina.
     * @return Palauttaa ArrayListin, jossa on kokonaislukuja.
     */
    public final ArrayList<Integer> jarjestys(final ArrayList<Integer> arvot) {

        int[] uusi = new int[arvot.size()];

        ArrayList<Integer> arvotKopio = new ArrayList();
        arvotKopio.addAll(arvot);
        Collections.sort(arvotKopio);

        for (int i = 0; i < arvotKopio.size(); i++) {
            int seuraava = arvotKopio.get(i);
            for (int j = 0; j < arvot.size(); j++) {
                if (arvot.get(j) == seuraava) {
                    uusi[j] = i + 1;
                }
            }
        }

        ArrayList<Integer> uusiLista = new ArrayList();

        for (int i = 0; i < arvot.size(); i++) {
            uusiLista.add(uusi[i]);
        }

        return uusiLista;
    }

}
