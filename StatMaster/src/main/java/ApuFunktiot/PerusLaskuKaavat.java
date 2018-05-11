package ApuFunktiot;

import java.util.ArrayList;

/**
 * Tässä luokassa on peruskaavoja, joita tarvitaan useissa eri laskuissa.
 *
 * @author Oskari Koskinen
 */
public class PerusLaskuKaavat {

    /**
     * Pyöristää desimaaliluvun kahden desimaalin tarkkuuteen.
     *
     * @param arvo Pyöristettävä arvo double -muuttujana.
     * @return Palauttaa syötetyn arvon kahden desimaalin tarkkuudella double
     * -muuttujana.
     */
    public final double pyoristaKahteenDesimaaliin(final double arvo) {
        final int kerroin = 100;
        double kopio = arvo;
        kopio = kopio * kerroin;
        kopio = Math.round(kopio);
        kopio = kopio / kerroin;
        return kopio;
    }

    /**
     * Laskee kokonaisluku listan lukujen summan.
     *
     * @param arvot ArrayList, jossa Integer -tyypin muuttujia.
     * @return Palauttaa listan lukujen summan int -muuttujana.
     */
    public final int summa(final ArrayList<Integer> arvot) {

        int summa = 0;

        for (int i = 0; i < arvot.size(); i++) {
            summa = summa + arvot.get(i);
        }

        return summa;
    }

    /**
     * Laskee kokonaislukulistan lukujen keskiarvon.
     *
     * @param arvot ArrayList, jossa Integer -tyypin muuttujia.
     * @return Palauttaa listan lukujen summa double muuttujana, joka on
     * pyöristetty kahden desimaalin tarkkuuteen.
     */
    public final double keskiarvo(final ArrayList<Integer> arvot) {
        double summa = summa(arvot);
        return pyoristaKahteenDesimaaliin(summa / arvot.size());
    }

    /**
     * Laskee kokonaislukulistan lukujen neliösumman.
     *
     * @param arvot ArrayList, jossa Integer -tyypin muuttujia.
     * @return Palauttaa listan lukujen neliosumman double -muuttujana, joka on
     * pyöristetty kahdeen desimaaliin.
     */
    public final double nelioSumma(final ArrayList<Integer> arvot) {

        double keskiarvo = keskiarvo(arvot);
        double summa = 0;

        for (int i = 0; i < arvot.size(); i++) {
            summa = summa + Math.pow(arvot.get(i) - keskiarvo, 2);
        }

        return pyoristaKahteenDesimaaliin(summa);

    }

    /**
     * Laskee kokonaislukulistan lukujen keskihajonnan.
     *
     * @param arvot ArrayList, jossa Integer -tyypin muuttujia.
     * @return Palauttaa listan lukujen otoskeskihajonnan double -muuttujana,
     * joka on pyöristetty kahdeen desimaaliin.
     */
    public final double otosKeskihajonta(final ArrayList<Integer> arvot) {
        double summa = nelioSumma(arvot);
        summa = summa / (arvot.size() - 1);
        return pyoristaKahteenDesimaaliin(Math.sqrt(summa));
    }

}
