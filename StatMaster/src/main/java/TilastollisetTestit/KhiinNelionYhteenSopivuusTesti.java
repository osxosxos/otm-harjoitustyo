package TilastollisetTestit;

import ApuFunktiot.PerusLaskuKaavat;
import Jakaumat.KhiinNelionJakauma;

/**
 * Luokka Khiin neliön yhteensopivuustestin laskemiseksi.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionYhteenSopivuusTesti {

    /**
     * Kaavat joita käytetään luokan laskuissa.
     */
    private PerusLaskuKaavat kaavat;
    /**
     * Havaittu aineisto.
     */
    private int[] havaitutFrekvenssit;
    /**
     * Teoreettisten ennusteiden mukainen aineisto.
     */
    private int[] teoreettisetFrekvenssit;
    /**
     * Testin tulos.
     */
    private double khiinNelio;
    /**
     * Testin tuloksen tilastollinen merkitsevyys.
     */
    private String pArvo;

    /**
     * Konstruktori luo uuden testiluokan, jonka arvot ovat tyhjät. Vasta
     * havaittujen ja teoreettisten frekvenssien syöttäminen laske -funktiolle
     * antaa näille arvot.
     */
    public KhiinNelionYhteenSopivuusTesti() {
        this.kaavat = new PerusLaskuKaavat();
        this.havaitutFrekvenssit = new int[0];
        this.teoreettisetFrekvenssit = new int[0];
        this.khiinNelio = 0;
        this.pArvo = "";
    }

    /**
     * Laskee khiin neliön yhteensopivuustestin ja määrittää sille p-arvon.
     *
     * @param hFrekvenssit Havaittu aineisto kokonaislukutauluna.
     * @param tFrekvenssit Teoreettinen aineisto myös kokonaisluku tauluna.
     */
    public final void laske(final int[] hFrekvenssit,
            final int[] tFrekvenssit) {
        this.havaitutFrekvenssit = hFrekvenssit;
        this.teoreettisetFrekvenssit = tFrekvenssit;
        this.khiinNelio();
        this.pArvo();
    }

    /**
     * Palauttaa testin havaitut frekvenssit.
     *
     * @return Kokonaislukutaulukko.
     */
    public final int[] getHavaitutFrekvenssit() {
        return havaitutFrekvenssit;
    }

    /**
     * Palauttaa testin teoreettiset frekvenssit.
     *
     * @return Kokonaislukutaulukko.
     */
    public final int[] getTeoreettisetFrekvenssit() {
        return teoreettisetFrekvenssit;
    }

    /**
     * Palauttaa testin khiin neliö suureen.
     *
     * @return double -muuttuja.
     */
    public final double getKhiinNelio() {
        return khiinNelio;
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
     * Laskee khiin neliön annetulle taulukolle.
     */
    public final void khiinNelio() {

        double khii = 0;

        for (int i = 0; i < havaitutFrekvenssit.length; i++) {
            int teoreettinen = this.teoreettisetFrekvenssit[i];
            int havaittu = this.havaitutFrekvenssit[i];
            int erotus = havaittu - teoreettinen;
            double nelio = Math.pow(erotus, 2);
            double tulos = nelio / teoreettinen;
            khii = khii + tulos;
        }

        this.khiinNelio = kaavat.pyoristaKahteenDesimaaliin(khii);
    }

    /**
     * Määrittää testisuureen p-Arvon.
     */
    public final void pArvo() {
        KhiinNelionJakauma khii = new KhiinNelionJakauma();
        int df = (this.havaitutFrekvenssit.length - 1);
        this.pArvo = khii.merkitsevyysTaso(df, this.khiinNelio);
    }
}
