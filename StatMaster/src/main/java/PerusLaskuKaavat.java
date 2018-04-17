
import java.util.ArrayList;

/**
 * Tässä luokassa on peruskaavoja, joita tarvitaan useissa eri laskuissa.
 *
 * @author Löllö
 */
public class PerusLaskuKaavat {

    public double pyoristaKahteenDesimaaliin(double arvo) {
        arvo = arvo * 100;
        arvo = Math.round(arvo);
        arvo = arvo / 100;
        return arvo;
    }

    public int summa(ArrayList<Integer> arvot) {

        int summa = 0;

        for (int i = 0; i < arvot.size(); i++) {
            summa = summa + arvot.get(i);
        }

        return summa;
    }

    public double keskiarvo(ArrayList<Integer> arvot) {
        double summa = summa(arvot);
        return pyoristaKahteenDesimaaliin(summa / arvot.size());
    }

    public double nelioSumma(ArrayList<Integer> arvot) {

        double keskiarvo = keskiarvo(arvot);
        double summa = 0;

        for (int i = 0; i < arvot.size(); i++) {
            summa = summa + Math.pow(arvot.get(i) - keskiarvo, 2);
        }

        return pyoristaKahteenDesimaaliin(summa);

    }

    public double otosKeskihajonta(ArrayList<Integer> arvot) {
        double summa = nelioSumma(arvot);
        summa = summa/(arvot.size()-1);
        return pyoristaKahteenDesimaaliin(Math.sqrt(summa));
    }

}
