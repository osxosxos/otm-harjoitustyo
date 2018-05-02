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

    PerusLaskuKaavat kaavat;
    ArrayList<Integer> dataRyhmaX;
    ArrayList<Integer> dataRyhmaY;
    public double kaRyhmaX;
    public double kaRyhmaY;
    public double khRyhmaX;
    public double khRyhmaY;
    public int ryhmienKoonSumma;
    public int df;
    public double keskiArvojenErotus;
    public double yhteisHajontaXY;
    public double t;
    public int suunta;
    public String pArvo;
    public String tulkinta;

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
        this.tulkinta = "";
    }

    public void laske(ArrayList<Integer> dataRyhmaX, ArrayList<Integer> dataRyhmaY, int suunta) {
        this.dataRyhmaX = dataRyhmaX;
        this.dataRyhmaY = dataRyhmaY;
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

    public void keskiArvojenErotus() {
        double erotus = this.kaRyhmaX - this.kaRyhmaY;
        this.keskiArvojenErotus = erotus;
    }

    public void ryhmienKoonSumma() {
        int summa = this.dataRyhmaX.size() + this.dataRyhmaY.size();
        this.ryhmienKoonSumma = summa;
    }

    public void yhteisHajonta() {
        double vXnX = Math.pow(this.khRyhmaX, 2) * (this.dataRyhmaX.size() - 1);
        double vYnY = Math.pow(this.khRyhmaY, 2) * (this.dataRyhmaY.size() - 1);
        double valiTulos = (vXnX + vYnY) / (this.ryhmienKoonSumma - 2);
        double tulos = Math.sqrt(valiTulos);
        this.yhteisHajontaXY = kaavat.pyoristaKahteenDesimaaliin(tulos);
    }

    public void tTestiSuure() {
        double jakaja = 1.0 / this.dataRyhmaX.size() + 1.0 / this.dataRyhmaY.size();
        double jakajaJuuri = Math.sqrt(jakaja);
        double jakajaYhteisHajonta = jakajaJuuri * this.yhteisHajontaXY;
        double t = this.keskiArvojenErotus / jakajaYhteisHajonta;
        this.t = kaavat.pyoristaKahteenDesimaaliin(t);
    }

    public void pArvo() {

        StudentinTJakauma tJakauma = new StudentinTJakauma();

        if (this.suunta == 1) {
            this.pArvo = tJakauma.yksiSuuntainen(this.df, this.t);
        } else {
            this.pArvo = tJakauma.yksiSuuntainen(this.df, this.t);
        }
    }

}
