
/**
 * Luokka Khiin neliön yhteensopivuustestin laskemiseksi.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionYhteenSopivuusTesti {

    PerusLaskuKaavat kaavat;
    int[] havaitutFrekvenssit;
    int[] teoreettisetFrekvenssit;
    double khiinNelio;
    String pArvo;

    public KhiinNelionYhteenSopivuusTesti() {
        this.kaavat = new PerusLaskuKaavat();
        this.havaitutFrekvenssit = new int[0];
        this.teoreettisetFrekvenssit = new int[0];
        this.khiinNelio = 0;
        this.pArvo = "";
    }

    public void laske(int[] havaitutFrekvenssit, int[] teoreettisetFrekvenssit) {
        this.havaitutFrekvenssit = havaitutFrekvenssit;
        this.teoreettisetFrekvenssit = teoreettisetFrekvenssit;
        this.khiinNelio();
        this.pArvo();
    }

    public void khiinNelio() {

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

    public void pArvo() {
        KhiinNelionJakauma khii = new KhiinNelionJakauma();
        int df = (this.havaitutFrekvenssit.length - 1);
        this.pArvo = khii.merkitsevyysTaso(df, this.khiinNelio);
    }
}
