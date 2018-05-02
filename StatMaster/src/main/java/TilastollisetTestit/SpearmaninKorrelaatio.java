
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

    public SpearmaninKorrelaatio() {
        super();
    }

    @Override
    public void laske(ArrayList<Integer> arvotX, ArrayList<Integer> arvotY) {
        ArrayList<Integer>xJarjestys = muunnaArvotJarjestysLuvuiksi(arvotX);
        ArrayList<Integer>yJarjestys = muunnaArvotJarjestysLuvuiksi(arvotY);
        super.laske(xJarjestys, yJarjestys);
    }

    public ArrayList<Integer> muunnaArvotJarjestysLuvuiksi(ArrayList<Integer> arvot) {

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
