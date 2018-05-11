package TilastollisetTestit;

import ApuFunktiot.PerusLaskuKaavat;
import Jakaumat.StudentinTJakauma;
import java.util.ArrayList;

/**
 * Tässä luokassa on pearsonin korrelaatiossa tarvittavat laskutoimitukset.
 * Kaavan on kehittänyt Karl Pearson.
 *
 * @author Oskari Koskinen
 */
public class PearsonKorrelaatio {

    /**
     * Kaavat, joita tarvitaan korrelaation laskemiseen.
     */
    private PerusLaskuKaavat kaavat;
    /**
     * Muuttujan X arvot, jotka ovat ArrayList -muodossa.
     */
    private ArrayList<Integer> dataX;
    /**
     * Muuttujan Y arvot, jotka ovat ArrayList -muodossa.
     */
    private ArrayList<Integer> dataY;
    /**
     * Muuttujan X keskiarvo.
     */
    private double kaX;
    /**
     * Muuttujan Y keskiarvo.
     */
    private double kaY;
    /**
     * Muuttujan X otoskeskihajonta.
     */
    private double khX;
    /**
     * Muuttujan Y otoskeskihajonta.
     */
    private double khY;
    /**
     * Muuttujien X ja Y välinen kovarianssi.
     */
    private double cov;
    /**
     * Muuttujien X ja Y välinen korrelaatio.
     */
    private double cor;
    /**
     * Korrelaation muuttujien välinen t-arvo.
     */
    private double t;
    /**
     * T-arvon p-arvo.
     */
    private String pArvo;

    /**
     * Konstruktori asettaa kaikki arvot aluksi tyhjiksi. Vasta funktion laske
     * kutsuminen antaa arvot näille muuttujille.
     */
    public PearsonKorrelaatio() {
        this.kaavat = new PerusLaskuKaavat();
        this.dataX = new ArrayList();
        this.dataY = new ArrayList();
        this.cov = 0;
        this.cor = 0;
        this.kaX = 0;
        this.kaY = 0;
        this.khX = 0;
        this.khY = 0;
        this.t = 0;
        this.pArvo = "ns";
    }

    /**
     * Laskee kaikki tarvittavat tunnusluvut, jotka luokassa on määritelty.
     *
     * @param x Vektori, jossa on muuttujan X arvot.
     * @param y Vektori, jossa on muuttujan Y arvot.
     */
    public final void laske(final ArrayList<Integer> x,
            final ArrayList<Integer> y) {
        this.dataX = x;
        this.dataY = y;
        this.kaX = kaavat.keskiarvo(this.dataX);
        this.kaY = kaavat.keskiarvo(this.dataY);
        this.khX = kaavat.otosKeskihajonta(this.dataX);
        this.khY = kaavat.otosKeskihajonta(this.dataY);
        this.otosKovarianssi();
        this.korrelaatio();
        this.tArvo();
        this.pArvo();
    }

    /**
     * Palauttaa muuttujien välisen kovarianssin.
     *
     * @return Double.
     */
    public final double getCov() {
        return cov;
    }

    /**
     * Palauttaa muuttujien välisen korrelaation.
     *
     * @return Double.
     */
    public final double getCor() {
        return cor;
    }

    /**
     * Palauttaa korrelaation t-arvon.
     *
     * @return Double.
     */
    public final double getT() {
        return t;
    }

    /**
     * Palauttaa t-arvon p-arvon.
     *
     * @return Merkkijono.
     */
    public final String getpArvo() {
        return pArvo;
    }

    /**
     * Laskee muuttujan x ja y välisen otoskovarianssin.
     */
    public final void otosKovarianssi() {

        int jakaja = this.dataX.size() - 1;
        double summa = 0;

        for (int i = 0; i < dataX.size(); i++) {
            double x = dataX.get(i);
            double y = dataY.get(i);
            double tulo = (x - this.kaX) * (y - this.kaY);
            summa = summa + tulo;
        }

        double covXY = summa / jakaja;
        this.cov = kaavat.pyoristaKahteenDesimaaliin(covXY);

    }

    /**
     * Normittaa kovarianssin keskihajonnoilla.
     */
    public final void korrelaatio() {
        double corXY = this.cov / (this.khX * this.khY);
        this.cor = kaavat.pyoristaKahteenDesimaaliin(corXY);
    }

    /**
     * Laskee korrelaation t-arvon tilastollisen merkitsevyyden ratkaisuun.
     */
    public final void tArvo() {

        int df = this.dataX.size() - 2;
        double selitys = Math.pow(this.cor, 2);
        double jakaja = Math.sqrt(1 - selitys);
        double jaettava = this.cor * Math.sqrt(df - 2);
        this.t = kaavat.pyoristaKahteenDesimaaliin(jaettava / jakaja);

    }

    /**
     * Laskee korrelaation p-arvon.
     */
    public final void pArvo() {
        StudentinTJakauma tee = new StudentinTJakauma();
        this.pArvo = tee.kaksiSuuntainen(this.dataX.size() - 2, this.t);
    }

}
