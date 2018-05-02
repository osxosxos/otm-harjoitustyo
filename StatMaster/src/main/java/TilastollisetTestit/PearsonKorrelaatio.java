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

    PerusLaskuKaavat kaavat;
    ArrayList<Integer> dataX;
    ArrayList<Integer> dataY;
    public double kaX;
    public double kaY;
    public double khX;
    public double khY;
    public double cov;
    public double cor;
    public double t;
    public String pArvo;

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
     * @param dataX Vektori, jossa on muuttujan X arvot.
     * @param dataY Vektori, jossa on muuttujan Y arvot.
     */
    public void laske(ArrayList<Integer> dataX, ArrayList<Integer> dataY) {
        this.dataX = dataX;
        this.dataY = dataY;
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
     * Laskee muuttujan x ja y välisen otoskovarianssin.
     */
    public void otosKovarianssi() {

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
    public void korrelaatio() {
        double corXY = this.cov / (this.khX * this.khY);
        this.cor = kaavat.pyoristaKahteenDesimaaliin(corXY);
    }

    /**
     * Laskee korrelaation t-arvon tilastollisen merkitsevyyden ratkaisuun.
     */
    public void tArvo() {

        int df = this.dataX.size() - 2;
        double selitys = Math.pow(this.cor, 2);
        double jakaja = Math.sqrt(1 - selitys);
        double jaettava = this.cor * Math.sqrt(df - 2);
        this.t = kaavat.pyoristaKahteenDesimaaliin(jaettava / jakaja);

    }

    /**
     * Laskee korrelaation p-arvon.
     */
    public void pArvo() {
        StudentinTJakauma t = new StudentinTJakauma();
        this.pArvo = t.kaksiSuuntainen(this.dataX.size() - 2, this.t);
    }

}
