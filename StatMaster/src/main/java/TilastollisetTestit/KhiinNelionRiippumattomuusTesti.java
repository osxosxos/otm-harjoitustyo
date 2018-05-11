package TilastollisetTestit;

import ApuFunktiot.PerusLaskuKaavat;
import Jakaumat.KhiinNelionJakauma;

/**
 * Khiin neliön riippumattomuustestin laskeva luokka.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusTesti {

    /**
     * Peruskaavat, joita tarvitaan joihinkin testin vaiheisiin.
     */
    private PerusLaskuKaavat kaavat;
    /**
     * Ristiintaulukon havaintojen yhteenlaskettu määrä.
     */
    private int n;
    /**
     * Ristiintaulukon rivien määrä.
     */
    private int rivit;
    /**
     * Ristiintaulukon sarakkeiden määrä.
     */
    private int sarakkeet;
    /**
     * Riveillä olevien havaintojen summat.
     */
    private int[] riviFrekvenssit;
    /**
     * Sarakkeissa olevien havaintojen summat.
     */
    private int[] sarakeFrekvenssit;
    /**
     * Ristiintaulukossa olevat havainnot.
     */
    private int[][] havaitutFrekvenssit;
    /**
     * Teoreettiset havainnot, eli miten havainnot jakautuisivat, jos kaikissa
     * luokissa olisi suhteellisesti sama määrä havaintoja.
     */
    private double[][] odotetutFrekvenssit;
    /**
     * Tesin tulos.
     */
    private double khiinNelio;
    /**
     * Testin tuloksen tilastollinen merkitsevyys.
     */
    private String pArvo;

    /**
     * Testiluokan parametrit ovat aluksi tyhjiä, vasta kaksiulotteisen
     * kokonaislukutaulukon syöttäminen luokan funktiolle laske, antaa
     * muuttujille arvot.
     */
    public KhiinNelionRiippumattomuusTesti() {
        this.kaavat = new PerusLaskuKaavat();
        this.n = 0;
        this.rivit = 0;
        this.sarakkeet = 0;
        this.riviFrekvenssit = new int[0];
        this.sarakeFrekvenssit = new int[0];
        this.havaitutFrekvenssit = new int[0][0];
        this.odotetutFrekvenssit = new double[0][0];
        this.khiinNelio = 0;
        this.pArvo = "ns";
    }

    /**
     * Laskee khiin neliönn riippumattomuustestin ja sille p-arvon.
     *
     * @param taulu Kokonaislukutaulu, jossa on havaittu data.
     */
    public final void laske(final int[][] taulu) {
        this.havaitutFrekvenssit = taulu;
        this.setN();
        this.rivit = this.havaitutFrekvenssit.length;
        this.sarakkeet = this.havaitutFrekvenssit[0].length;
        this.riviFrekvenssit = new int[rivit];
        this.setRiviFrekvenssit();
        this.sarakeFrekvenssit = new int[sarakkeet];
        this.setSarakeFrekvenssit();
        this.odotetutFrekvenssit = new double[rivit][sarakkeet];
        this.setOdotetutFrekvenssit();
        this.khiinNelio();
        this.pArvo();
    }

    /**
     * Palauttaa testin taulukon havaintojen määrän.
     *
     * @return Kokonaisluku.
     */
    public final int getN() {
        return n;
    }

    /**
     * Palauttaa testin taulukon rivien määrän.
     *
     * @return Kokonaisluku.
     */
    public final int getRivit() {
        return rivit;
    }

    /**
     * Palauttaa testin taulukon sarakkeiden määrän.
     *
     * @return Kokonaisluku.
     */
    public final int getSarakkeet() {
        return sarakkeet;
    }

    /**
     * Palauttaa testin riveillä olevien havaintojen määrät.
     *
     * @return Yksiulotteinen kokonaislukutaulukko.
     */
    public final int[] getRiviFrekvenssit() {
        return riviFrekvenssit;
    }

    /**
     * Palauttaa testin sarakkeilla olevien havaintojen summat.
     *
     * @return Yksiulottinenen kokonaislukutaulukko.
     */
    public final int[] getSarakeFrekvenssit() {
        return sarakeFrekvenssit;
    }

    /**
     * Palauttaa kaksiulotteisen taulun, jossa on havaitut frekvenssit.
     *
     * @return Kaksiulotteinen kokonaislukutaulukko.
     */
    public final int[][] getHavaitutFrekvenssit() {
        return havaitutFrekvenssit;
    }

    /**
     * Palauttaa testin odotetut frekvenssit.
     *
     * @return Kaksiulotteinen kokonaislukutaulukko, jossa testin odotetut
     * frekvenssit.
     */
    public final double[][] getOdotetutFrekvenssit() {
        return odotetutFrekvenssit;
    }

    /**
     * Palauttaa testisuureen p-arvon.
     *
     * @return P-arvo merkkijonona.
     */
    public final String getpArvo() {
        return pArvo;
    }

    /**
     * Palauttaa tesin khiin neliön arvon.
     *
     * @return Khiin neliö double -muuttujana.
     */
    public final double getKhiinNelio() {
        return khiinNelio;
    }

    /**
     * Laskee aineiston havaintojen määrän.
     */
    public final void setN() {
        int summa = 0;

        for (int i = 0; i < havaitutFrekvenssit.length; i++) {
            for (int j = 0; j < havaitutFrekvenssit[0].length; j++) {
                summa = summa + havaitutFrekvenssit[i][j];
            }
        }

        this.n = summa;

    }

    /**
     * Laskee rivien summat.
     */
    public final void setRiviFrekvenssit() {

        for (int i = 0; i < rivit; i++) {
            int summa = 0;
            for (int j = 0; j < sarakkeet; j++) {
                summa = summa + this.havaitutFrekvenssit[i][j];
            }
            this.riviFrekvenssit[i] = summa;
        }

    }

    /**
     * Laskee sarakkeiden summat.
     */
    public final void setSarakeFrekvenssit() {
        for (int i = 0; i < sarakkeet; i++) {
            int summa = 0;
            for (int j = 0; j < rivit; j++) {
                summa = summa + this.havaitutFrekvenssit[j][i];
            }
            this.sarakeFrekvenssit[i] = summa;
        }
    }

    /**
     * Laskee annetulle ristiintaululle odotetut frekvenssit.
     */
    public final void setOdotetutFrekvenssit() {

        for (int i = 0; i < rivit; i++) {
            for (int j = 0; j < sarakkeet; j++) {
                double tulos = this.riviFrekvenssit[i]
                        * this.sarakeFrekvenssit[j];
                double odotus = tulos / this.n;
                double pyoristys = kaavat.pyoristaKahteenDesimaaliin(odotus);
                this.odotetutFrekvenssit[i][j] = pyoristys;
            }
        }
    }

    /**
     * Laskee annetulle taulukolle khiin neliön.
     */
    public final void khiinNelio() {

        double khii = 0;

        for (int i = 0; i < rivit; i++) {
            for (int j = 0; j < sarakkeet; j++) {
                int havaittu = this.havaitutFrekvenssit[i][j];
                double odotettu = this.odotetutFrekvenssit[i][j];
                double erotus = havaittu - odotettu;
                double nelio = Math.pow(erotus, 2);
                double tulos = nelio / odotettu;
                khii = khii + tulos;
            }
        }

        this.khiinNelio = kaavat.pyoristaKahteenDesimaaliin(khii);

    }

    /**
     * Määrittää testisuureen p-arvon.
     */
    public final void pArvo() {
        KhiinNelionJakauma khii = new KhiinNelionJakauma();
        int df = (rivit - 1) * (sarakkeet - 1);
        this.pArvo = khii.merkitsevyysTaso(df, this.khiinNelio);
    }

}
