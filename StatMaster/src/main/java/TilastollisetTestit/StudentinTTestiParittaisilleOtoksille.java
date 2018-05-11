package TilastollisetTestit;

import ApuFunktiot.PerusLaskuKaavat;
import Jakaumat.StudentinTJakauma;
import java.util.ArrayList;

/**
 * Luokka, jolla lasketaan parittaisten otosten t-testi. Menetelmää voidaan
 * käyttää esimerkiksi silloin, kun tutkitaan lääkkeiden vaikutusta ennen ja
 * jälkeen lääkkeen käytön aloituksen. Menetelmän on kehittänyt Willian
 * "student" Gosset.
 *
 * @author Oskari Koskinen
 */
public class StudentinTTestiParittaisilleOtoksille {

    /**
     * Laskukaavat, joita käytetään useissa eri testin vaiheissa.
     */
    private PerusLaskuKaavat kaavat;
    /**
     * ArrayList, jossa on arvot ennen kokeellista manipulaatiota.
     */
    private ArrayList<Integer> dataTilanne1;
    /**
     * ArrayList, jossa on arvot kokeellisen manipulaation jälkeen.
     */
    private ArrayList<Integer> dataTilanne2;
    /**
     * Erotusten keskiarvo.
     */
    private double erotustenKa;
    /**
     * Erotusten otoskeskihajonta.
     */
    private double erotustenOtosKh;
    /**
     * Erotusten keskiarvon t-arvo.
     */
    private double t;
    /**
     * Testin df-arvoa.
     */
    private int df;
    /**
     * Testin suunta.
     */
    private int suunta;
    /**
     * Testisuureen p-arvo.
     */
    private String pArvo;

    /**
     * Luo uuden luokan, jolla voidaan laskea parittaisten otosten t-testi.
     * Aluksi luokka on tyhjä, luokan arvot muuttuvat laske -funktion kutsun
     * seurauksena.
     */
    public StudentinTTestiParittaisilleOtoksille() {
        this.kaavat = new PerusLaskuKaavat();
        this.dataTilanne1 = new ArrayList();
        this.dataTilanne2 = new ArrayList();
        this.erotustenKa = 0;
        this.erotustenOtosKh = 0;
        this.t = 0;
        this.df = 0;
        this.suunta = 0;
        this.pArvo = "";
    }

    /**
     * Laskee parittaisten otosten t-testin kahdelle parittaiselle otokselle.
     *
     * @param tilanne1 ArrayList, jossa arvot ennen tilanteesta.
     * @param tilanne2 ArrayList, jossa arvot jälkeen tilanteesta.
     * @param s Testin suunta.
     */
    public final void laske(final ArrayList<Integer> tilanne1,
            final ArrayList<Integer> tilanne2, final int s) {
        this.suunta = s;
        this.dataTilanne1 = tilanne1;
        this.dataTilanne2 = tilanne2;
        this.df = this.dataTilanne1.size() - 1;
        this.erotustenKeskiarvo();
        this.erotustenOtosKeskihajonta();
        this.tSuure();
        this.pArvo();
    }

    /**
     * Palauttaa testin vapausasteet.
     *
     * @return Kokonaisluku.
     */
    public final int getDf() {
        return df;
    }

    /**
     * Palauttaa erotusten keskiarvon.
     *
     * @return Double.
     */
    public final double getErotustenKa() {
        return erotustenKa;
    }

    /**
     * Palauttaa erotusten otoskeskihajonnan.
     *
     * @return Double.
     */
    public final double getErotustenOtosKh() {
        return erotustenOtosKh;
    }

    /**
     * Palauttaa testisuureen t-arvon.
     *
     * @return Double.
     */
    public final double getT() {
        return t;
    }

    /**
     * Palauttaa testin p-arvon.
     *
     * @return Merkkijono.
     */
    public final String getpArvo() {
        return pArvo;
    }

    /**
     * Laskee erotusten keskiarvon.
     */
    public final void erotustenKeskiarvo() {

        int summa = 0;

        for (int i = 0; i < dataTilanne1.size(); i++) {
            int arvo2 = this.dataTilanne2.get(i);
            int arvo1 = this.dataTilanne1.get(i);
            int erotus = arvo2 - arvo1;
            summa = summa + erotus;
        }

        double keskiarvo = summa / this.dataTilanne1.size();
        this.erotustenKa = kaavat.pyoristaKahteenDesimaaliin(keskiarvo);

    }

    /**
     * Laskee erotusten otoskeskihajonnan.
     */
    public final void erotustenOtosKeskihajonta() {

        double summa = 0;

        for (int i = 0; i < dataTilanne1.size(); i++) {
            int arvo2 = this.dataTilanne2.get(i);
            int arvo1 = this.dataTilanne1.get(i);
            double erotus = (arvo2 - arvo1) - this.erotustenKa;
            double nelio = Math.pow(erotus, 2);
            summa = summa + nelio;
        }

        double kh = summa / this.df;
        this.erotustenOtosKh = kaavat.pyoristaKahteenDesimaaliin(Math.sqrt(kh));

    }

    /**
     * Laskee t-testisuureen.
     */
    public final void tSuure() {
        double tArvo
                = this.erotustenKa
                / (this.erotustenOtosKh / Math.sqrt(this.dataTilanne1.size()));
        this.t = kaavat.pyoristaKahteenDesimaaliin(tArvo);
    }

    /**
     * Määrittää testin p-arvon.
     */
    public final void pArvo() {

        StudentinTJakauma tJakauma = new StudentinTJakauma();

        if (this.suunta == 1) {
            this.pArvo = tJakauma.yksiSuuntainen(this.df, this.t);
        } else {
            this.pArvo = tJakauma.yksiSuuntainen(this.df, this.t);
        }
    }

}
