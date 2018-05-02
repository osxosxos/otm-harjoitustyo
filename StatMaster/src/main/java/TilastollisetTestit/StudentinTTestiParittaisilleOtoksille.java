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

    PerusLaskuKaavat kaavat;
    ArrayList<Integer> dataTilanne1;
    ArrayList<Integer> dataTilanne2;
    public double erotustenKa;
    public double erotustenOtosKh;
    public double t;
    public int df;
    public int suunta;
    public String pArvo;

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

    public void laske(ArrayList<Integer> tilanne1, ArrayList<Integer> tilanne2, int suunta) {
        this.suunta = suunta;
        this.dataTilanne1 = tilanne1;
        this.dataTilanne2 = tilanne2;
        this.df = this.dataTilanne1.size() - 1;
        this.erotustenKeskiarvo();
        this.erotustenOtosKeskihajonta();
        this.tSuure();
        this.pArvo();
    }

    public void erotustenKeskiarvo() {

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

    public void erotustenOtosKeskihajonta() {

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

    public void tSuure() {
        double tArvo = this.erotustenKa / (this.erotustenOtosKh / Math.sqrt(this.dataTilanne1.size()));
        this.t = kaavat.pyoristaKahteenDesimaaliin(tArvo);
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
