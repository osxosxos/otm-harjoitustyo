package TilastollisetTestit;

import ApuFunktiot.PerusLaskuKaavat;
import Jakaumat.StudentinTJakauma;
import java.util.ArrayList;

/**
 * Luokka, jolla lasketaan riippumattomien otosten t-testi. Menetelmän on
 * kehittänyt Willian "student" Gosset.
 *
 * @author Oskari Koskinen
 */
public class StudentinTTestiRiippumattomilleOtoksille {

    /**
     * Peruskaavat, joita käytetään joihin laskuihin testissä.
     */
    private PerusLaskuKaavat kaavat;
    /**
     * Ryhmän X arvot.
     */
    private ArrayList<Integer> dataRyhmaX;
    /**
     * Ryhmän Y arvot.
     */
    private ArrayList<Integer> dataRyhmaY;
    /**
     * Ryhman X keskiarvo.
     */
    private double kaRyhmaX;
    /**
     * Ryhman Y keskiarvo.
     */
    private double kaRyhmaY;
    /**
     * Ryhman X otoskeskihajonta.
     */
    private double khRyhmaX;
    /**
     * Ryhman Y otoskeskihajonta.
     */
    private double khRyhmaY;
    /**
     * Ryhmien koon summa.
     */
    private int ryhmienKoonSumma;
    /**
     * Testin vapausasteet.
     */
    private int df;
    /**
     * Ryhmien keskiarvon erotus.
     */
    private double keskiArvojenErotus;
    /**
     * Molempien ryhmien havaintojen yhtenäinen keskihajonta.
     */
    private double yhteisHajontaXY;
    /**
     * T-testisuure.
     */
    private double t;
    /**
     * Testin suunta.
     */
    private int suunta;
    /**
     * T-testisuureen p-Arvo.
     */
    private String pArvo;

    /**
     * Aluksi luokka määrittää muuttujien arvot tyhjiksi. Laske -funktion
     * kutsuminen kahdella aineistolla antaa näille muuttujille arvot.
     */
    public StudentinTTestiRiippumattomilleOtoksille() {
        this.kaavat = new PerusLaskuKaavat();
        this.dataRyhmaX = new ArrayList();
        this.dataRyhmaY = new ArrayList();
        this.kaRyhmaX = 0;
        this.kaRyhmaY = 0;
        this.khRyhmaX = 0;
        this.khRyhmaY = 0;
        this.ryhmienKoonSumma = 0;
        this.keskiArvojenErotus = 0;
        this.yhteisHajontaXY = 0;
        this.t = 0;
        this.df = 0;
        this.suunta = 0;
        this.pArvo = "";
    }

    /**
     * Laskee riippumattomien otosten t-testin kahdelle aineistolle.
     *
     * @param dataX Ryhmän X aineisto.
     * @param dataY Ryhmän Y aineisto.
     * @param testinSuunta Testin suunta.
     */
    public final void laske(final ArrayList<Integer> dataX,
            final ArrayList<Integer> dataY, final int testinSuunta) {
        this.suunta = testinSuunta;
        this.dataRyhmaX = dataX;
        this.dataRyhmaY = dataY;
        this.kaRyhmaX = kaavat.keskiarvo(this.dataRyhmaX);
        this.kaRyhmaY = kaavat.keskiarvo(this.dataRyhmaY);
        this.khRyhmaX = kaavat.otosKeskihajonta(this.dataRyhmaX);
        this.khRyhmaY = kaavat.otosKeskihajonta(this.dataRyhmaY);
        this.ryhmienKoonSumma();
        this.df = this.dataRyhmaX.size() + this.dataRyhmaY.size() - 2;
        this.keskiArvojenErotus();
        this.yhteisHajonta();
        this.tTestiSuure();
        this.pArvo();
    }

    /**
     * Palauttaa testin t-arvon.
     *
     * @return Double.
     */
    public final double getT() {
        return t;
    }

    /**
     * Palauttaa testin t-suureen pArvon.
     *
     * @return Merkkijono.
     */
    public final String getpArvo() {
        return pArvo;
    }

    /**
     * Laskee keskiarvojen erotuksen ja tallentaa sen.
     */
    public final void keskiArvojenErotus() {
        double erotus = this.kaRyhmaX - this.kaRyhmaY;
        this.keskiArvojenErotus = erotus;
    }

    /**
     * Laskee ryhmien koon summan ja tallentaa sen.
     */
    public final void ryhmienKoonSumma() {
        int summa = this.dataRyhmaX.size() + this.dataRyhmaY.size();
        this.ryhmienKoonSumma = summa;
    }

    /**
     * Laskee ryhmien otosten yhteishajonnan ja tallentaa sen.
     */
    public final void yhteisHajonta() {
        double vXnX = Math.pow(this.khRyhmaX, 2) * (this.dataRyhmaX.size() - 1);
        double vYnY = Math.pow(this.khRyhmaY, 2) * (this.dataRyhmaY.size() - 1);
        double valiTulos = (vXnX + vYnY) / (this.ryhmienKoonSumma - 2);
        double tulos = Math.sqrt(valiTulos);
        this.yhteisHajontaXY = kaavat.pyoristaKahteenDesimaaliin(tulos);
    }

    /**
     * Laskee ja tallentaa t-testisuureen arvon.
     */
    public final void tTestiSuure() {
        double jakaja = 1.0 / this.dataRyhmaX.size()
                + 1.0 / this.dataRyhmaY.size();
        double jakajaJuuri = Math.sqrt(jakaja);
        double jakajaYhteisHajonta = jakajaJuuri * this.yhteisHajontaXY;
        double tee = this.keskiArvojenErotus / jakajaYhteisHajonta;
        this.t = kaavat.pyoristaKahteenDesimaaliin(tee);
    }

    /**
     * Laskee testisuureen p-arvon ja tallentaa sen.
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
