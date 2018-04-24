
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Yleinen tehtäväluokka. Kaikki erilaiset tehtävät ovat tämän luokan
 * erikoistapauksia. Jokainen tehtävä koostuu useista osatehtävistä, koska
 * tilastollisessa testaamisessa on aina monta vaihetta, kuten hypoteesin
 * määrittäminen ja testisuureen laskeminen.
 *
 * @author Oskari Koskinen
 */
public class Tehtava {

    String ohje;
    Random random;
    Scanner scanner;
    PerusLaskuKaavat kaavat;
    ArrayList<OsaTehtava> osaTehtavat;

    public Tehtava() {
        this.ohje = "";
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.kaavat = new PerusLaskuKaavat();
        this.osaTehtavat = new ArrayList();
    }

    /**
     * Suorittaa tehtävän kaikki osatehtävät.
     *
     * @return Palauttaa desimaaliluvun, joka on oikeiden vastausten määrä
     * jaettuna kaikkien vastausten määrällä.
     */
    public double suorita() {

        System.out.println(this.ohje);
        System.out.println("");

        int summa = 0;

        for (int i = 0; i < osaTehtavat.size(); i++) {
            summa = summa + osaTehtavat.get(i).suorita(this.scanner);
        }

        System.out.println("Tehtävästä oli oikein "
                + 100 * summa / this.osaTehtavat.size() + "%.");
        System.out.println("");

        return summa / this.osaTehtavat.size();
    }

    /**
     * Asettaa tehtävälle ohjeen.
     *
     * @param ohje Erikoistapausluokassa luotu yksilöllinen ohje tehtävälle.
     */
    public void setOhje(String ohje) {
        this.ohje = ohje;
    }

    /**
     * Lisää osatehtävien listaan uuden tehtävän.
     *
     * @param osatehtava Erikoistapausluokassa luotu alatehtävä.
     */
    public void lisaaOsaTehtava(OsaTehtava osatehtava) {
        this.osaTehtavat.add(osatehtava);
    }

    /**
     * Lisää tehtävään osatehtävän, jossa lasketaan jokin desimaaliluku.
     *
     * @param vastaus Tehtävän vastaus desimaalilukuna.
     * @param kerroin Kerroin, jolla määritetään väärien vaihtoehtojen arvot.
     * @param tehtavanOhje Ohje, joka kertoo mitä pitää laskea.
     */
    public void laskemisTehtava(double vastaus, int kerroin, String tehtavanOhje) {

        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<Double> vaihtoEhdot = new ArrayList();

        double vaara1 = vastaus + kerroin * random.nextDouble();
        double vaara2 = vastaus - kerroin * random.nextDouble();
        double vaara3 = vastaus + kerroin * random.nextDouble();

        double vaara1Round = this.kaavat.pyoristaKahteenDesimaaliin(vaara1);
        double vaara2Round = this.kaavat.pyoristaKahteenDesimaaliin(vaara2);
        double vaara3Round = this.kaavat.pyoristaKahteenDesimaaliin(vaara3);

        vaihtoEhdot.add(vastaus);
        vaihtoEhdot.add(vaara1Round);
        vaihtoEhdot.add(vaara2Round);
        vaihtoEhdot.add(vaara3Round);

        Collections.shuffle(vaihtoEhdot);

        int oikeaVastaus = 1;

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == vastaus) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        osaTehtavat.add(tehtava);
    }

    /**
     * Lisää tehtävään osatehtävän, jossa määritetään mitä testisuuretta tulee
     * käyttää tehtävän ratkaisemiseksi.
     *
     * @param oikeaTesti Tilastollinen testi, jolla tehtävä ratkaistaan.
     */
    public void testinValintaTehtava(String oikeaTesti) {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<String> testit = new ArrayList();

        String[] testeja = new String[]{"Riippumattomien otosten t-testi",
            "Verrannolisten parien t-testi", "Khiin neliön riippumattomuustesti",
            "Pearsonin korrelaatio", "Spearmanin korrelaatio", "Yhden otoksen t-testi",
            "Khiin neliön yhteensopivuustesti", "Binomijakauma", "Poissonjakauma",
            "Kahden muuttujan lineaarinen regressioanalyysi"};

        Collections.addAll(testit, testeja);
        Collections.shuffle(testit);

        String tehtavanOhje = "Valitse sopiva menetelmä.";
        int oikeaVastaus = 1;

        int k = 0;

        while (testit.size() > 4) {
            if (testit.get(k).equals(oikeaTesti)) {
                k++;
            } else {
                testit.remove(k);
                k = 0;
            }
        }

        for (int i = 0; i < testit.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + testit.get(i);
            if (testit.get(i).equals(oikeaTesti)) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        this.osaTehtavat.add(tehtava);
    }

    /**
     * Satunnaisia aiheita tehtävien luontia varten.
     *
     * @return Palauttaa satunnaisen aiheen, esim. "arjenhallinnan ongelmiin".
     */
    public String[] aiheetPerusmuoto() {
        String[] aiheita = new String[]{"masennuksen oireet",
            "yleistyneen ahdistuneisuushäiriön oireet",
            "aktiivisuuden ja tarkkaavaisuuden häiriön oireet",
            "arjenhallinnan ongelmat", "toverisuosio",
            "kiintymyssuhteen turvallisuus",
            "pakko-oireisen häiriön oireet",
            "työstressin vakavuus", "älykkyysosamäärä",
            "työmuistin tehokkuus", "neuroottisuus", "tunnollisuus",
            "uusille kokemuksille avoimuus", "salaliittouskomukset",
            "intuitiivisen ajattelutyyli", "analyyttisen ajattelutyyli"};
        return aiheita;
    }

    public String[] aiheetTaivutus1() {
        String[] aiheita = new String[]{"vakavan masennuksen oireisiin",
            "yleistyneen ahdistuneisuushäiriön oireisiin",
            "aktiivisuuden ja tarkkaavaisuuden häiriön oireisiin",
            "arjenhallinnan ongelmiin", "toverisuosioon",
            "kiintymyssuhteen turvallisuuteen",
            "pakko-oireisen häiriön oireisiin",
            "työstressin vakavuuteen", "älykkyysosamäärään",
            "työmuistin tehokkuuteen", "neuroottisuuteen", "tunnollisuuteen",
            "uusille kokemuksille avoimuuteen", "salaliittouskomustiin",
            "intuitiivisen ajattelutyyliin", "analyyttisen ajattelutyyliin"};
        return aiheita;
    }

    public String[] aiheetTaivutus2() {
        String[] aiheita = new String[]{"vakavan masennuksen oireiden",
            "yleistyneen ahdistuneisuushäiriön oireiden",
            "aktiivisuuden ja tarkkaavaisuuden häiriön oireiden",
            "arjenhallinnan ongelmien", "toverisuosion",
            "kiintymyssuhteen turvallisuuden",
            "pakko-oireisen häiriön oireiden",
            "työstressin vakavuuden", "älykkyysosamäärän",
            "työmuistin tehokkuuden", "neuroottisuuden", "tunnollisuuden",
            "uusille kokemuksille avoimuuden", "salaliittouskomusten",
            "intuitiivisen ajattelutyylin", "analyyttisen ajattelutyylin"};
        return aiheita;
    }

    /**
     * Luo satunnaisen kokoisen luokitteluasteikon.
     *
     * @return Palauttaa merkkijonotaulu, jossa on luokitteluasteikko.
     */
    public String[] arvoAsteikkoVektori1() {
        int x = random.nextInt(4);

        if (x == 0) {
            return new String[]{"matala", "korkea"};
        } else if (x == 1) {
            return new String[]{"matala", "keskiverto", "korkea"};
        } else if (x == 2) {
            return new String[]{"erittäin matala", "matala", "korkea",
                "erittäin korkea"};
        } else {
            return new String[]{"erittäin matala", "matala", "keskiverto",
                "korkea", "erittäin korkea"};
        }
    }

    /**
     * Muuttaa yksiulotteisen merkkijonotaulun merkkijonoksi.
     *
     * @param arvot Syötteenä annettu merkkijonotaulu.
     * @return Palauttaa taulun merkkijonoesityksenä.
     */
    public String tulostaAsteikko(String[] arvot) {
        String jono = "";
        for (int i = 0; i < arvot.length; i++) {
            if (i == arvot.length - 1) {
                jono = jono + arvot[i];
            } else {
                jono = jono + arvot[i] + ", ";
            }
        }
        return jono;
    }

    /**
     * Tulostaa kokonaislukutaulun siistinä merkkijonona.
     *
     * @param arvot Syötteenä annettu taulukko.
     * @return Palauttaa kokonaislukutaulun.
     */
    public String tulostaArvot(int[] arvot) {
        String jono = "";
        for (int i = 0; i < arvot.length; i++) {
            if (i == arvot.length - 1) {
                jono = jono + arvot[i];
            } else {
                jono = jono + arvot[i] + ", ";
            }
        }
        return jono;
    }

    /**
     * Tulostaa kokonaislukulistan luvut merkkijonoksi.
     *
     * @param vektori Kokonaislukulista.
     * @return Palauttaa kokonaislukulistan merkkijonona.
     */
    public String vektoriMerkkiJonoksi(ArrayList<Integer> vektori) {
        String jono = "";
        for (int i = 0; i < vektori.size(); i++) {
            if (i < vektori.size() - 1) {
                jono = jono + vektori.get(i) + ", ";
            } else {
                jono = jono + vektori.get(i);
            }
        }
        return jono;
    }

    /**
     * Luo vähintään välimatka-asteikollisia datoja, jotka noudattavat likimain
     * normaalijakaumaa.
     *
     * @param keskikohta Jakauman keskikohta, jonka ympärille arvot sijoittuvat.
     * @param koko Palautettavan listan koko.
     * @return Palauttaa datan kokonaislukulistana.
     */
    public ArrayList luoData(int keskikohta, int koko) {
        ArrayList<Integer> data = new ArrayList();

        for (int i = 0; i < koko; i++) {
            int x = random.nextInt(101);
            int a = random.nextInt(2);
            int b = random.nextInt(6) + 5;
            if (x <= 70) {
                if (a == 0) {
                    data.add(keskikohta - b);
                } else if (a == 1) {
                    data.add(keskikohta + b);
                }
            } else if (x > 70 && x <= 95) {
                if (a == 0) {
                    data.add(keskikohta - 2 * b);
                } else if (a == 1) {
                    data.add(keskikohta + 2 * b);
                }
            } else if (x > 95) {
                if (a == 0) {
                    data.add(keskikohta - 3 * b);
                } else if (a == 1) {
                    data.add(keskikohta + 3 * b);
                }
            }
        }
        return data;
    }

    public String[] ikaRyhmia() {
        String[] ikaRyhmia = new String[]{"6-14 vuotiaat", "15-29 vuotiaat",
            "30-42 vuotiaat", "43-54 vuotiaat", "55-68 vuotiaat", "68-99 vuotiaat"};
        return ikaRyhmia;
    }

    public String[] ammatteja() {
        String[] ammatteja = new String[]{"psykologit", "diplomi-insinöörit",
            "lääkärit", "sosiaalityöntekijät", "ekonomit", "hitsaajat",
            "talonrakentajat", "asuntovälittäjät", "pörssivälittäjät", "kansanedustajat"};
        return ammatteja;
    }

    public String[] sukupuolet() {
        String[] sukupuolia = new String[]{"miehet", "naiset"};
        return sukupuolia;
    }

}
