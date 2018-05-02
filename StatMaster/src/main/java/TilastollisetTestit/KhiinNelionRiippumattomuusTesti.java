package TilastollisetTestit;

import ApuFunktiot.PerusLaskuKaavat;
import Jakaumat.KhiinNelionJakauma;

/**
 * Khiin neliön riippumattomuustestin laskeva luokka.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusTesti {

    PerusLaskuKaavat kaavat;
    public int n;
    public int rivit;
    public int sarakkeet;
    public int[] riviFrekvenssit;
    public int[] sarakeFrekvenssit;
    public int[][] havaitutFrekvenssit;
    public double[][] odotetutFrekvenssit;
    public double khiinNelio;
    public String pArvo;

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

    public void laske(int[][] taulu) {
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

    public void setN() {
        int summa = 0;

        for (int i = 0; i < havaitutFrekvenssit.length; i++) {
            for (int j = 0; j < havaitutFrekvenssit[0].length; j++) {
                summa = summa + havaitutFrekvenssit[i][j];
            }
        }

        this.n = summa;

    }

    public void setRiviFrekvenssit() {

        for (int i = 0; i < rivit; i++) {
            int summa = 0;
            for (int j = 0; j < sarakkeet; j++) {
                summa = summa + this.havaitutFrekvenssit[i][j];
            }
            this.riviFrekvenssit[i] = summa;
        }

    }

    public void setSarakeFrekvenssit() {
        for (int i = 0; i < sarakkeet; i++) {
            int summa = 0;
            for (int j = 0; j < rivit; j++) {
                summa = summa + this.havaitutFrekvenssit[j][i];
            }
            this.sarakeFrekvenssit[i] = summa;
        }
    }

    public void setOdotetutFrekvenssit() {

        for (int i = 0; i < rivit; i++) {
            for (int j = 0; j < sarakkeet; j++) {
                double tulos = this.riviFrekvenssit[i] * this.sarakeFrekvenssit[j];
                double odotus = tulos / this.n;
                double pyoristys = kaavat.pyoristaKahteenDesimaaliin(odotus);
                this.odotetutFrekvenssit[i][j] = pyoristys;
            }
        }
    }

    public void khiinNelio() {

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

    public void pArvo() {
        KhiinNelionJakauma khii = new KhiinNelionJakauma();
        int df = (rivit - 1) * (sarakkeet - 1);
        this.pArvo = khii.merkitsevyysTaso(df, this.khiinNelio);
    }

}
