package Tehtavat;

import ApuFunktiot.PerusLaskuKaavat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Yleinen tehtävän luontiluokka. Kaikki erilaiset tehtävät ovat tämän luokan
 * erikoistapauksia. Jokainen tehtävä koostuu useista osatehtävistä, koska
 * tilastollisessa testaamisessa on aina monta vaihetta, kuten hypoteesin
 * määrittäminen ja testisuureen laskeminen.
 *
 * @author Oskari Koskinen
 */
public class Tehtava {

    /**
     * Merkkijono, jossa on tehtävän ohje, eli mitä yleensä pitää selvittää.
     */
    private String ohje;
    /**
     * Satunnaislukujen luomista varten Random -objekti.
     */
    private Random random;
    /**
     * Objekti, jolla lasketaan useita tehtävissä tarvittavia peruslaskuja.
     */
    private PerusLaskuKaavat kaavat;
    /**
     * Lista, jossa on tehtävän osatehtävät.
     */
    private ArrayList<OsaTehtava> osaTehtavat;

    /**
     * Konstruktori luo tyhjän pohjan tehtävälle. Vasta luokan erikoistapaukset
     * määrittävät mikä tehtävän muoto tulee lopulta olemaan.
     */
    public Tehtava() {
        this.ohje = "";
        this.random = new Random();
        this.kaavat = new PerusLaskuKaavat();
        this.osaTehtavat = new ArrayList();
    }

    /**
     * Palauttaa tehtävän ohjeen merkkijonona.
     *
     * @return Merkkijono.
     */
    public final String getOhje() {
        return this.ohje;
    }

    /**
     * Palauttaa tehtävän osaTehtavat.
     *
     * @return ArrayList, jossa on osaTehtavaObjekteja.
     */
    public final ArrayList<OsaTehtava> getOsaTehtavat() {
        return this.osaTehtavat;
    }

    /**
     * Randomi.
     *
     * @return Palauttaa Random -objektin.
     */
    public final Random getRandom() {
        return random;
    }

    /**
     * Kaavat.
     *
     * @return Palauttaa PerusLaskuKaavat -objektin.
     */
    public final PerusLaskuKaavat getKaavat() {
        return kaavat;
    }

    /**
     * Asettaa tehtävälle ohjeen.
     *
     * @param tehtavanOhje Erikoistapausluokassa luotu yksilöllinen ohje
     * tehtävälle.
     */
    public final void setOhje(final String tehtavanOhje) {
        this.ohje = tehtavanOhje;
    }

    /**
     * Lisää osatehtävien listaan uuden tehtävän.
     *
     * @param osatehtava Erikoistapausluokassa luotu alatehtävä.
     */
    public final void lisaaOsaTehtava(final OsaTehtava osatehtava) {
        this.osaTehtavat.add(osatehtava);
    }

    /**
     * Lisää tehtävään osatehtävän, jossa lasketaan jokin desimaaliluku.
     *
     * @param vastaus Tehtävän vastaus desimaalilukuna.
     * @param kerroin Kerroin, jolla määritetään väärien vaihtoehtojen arvot.
     * @param tehtavanOhje Ohje, joka kertoo mitä pitää laskea.
     */
    public final void laskemisTehtava(final double vastaus, final int kerroin,
            final String tehtavanOhje) {

        String kopio = tehtavanOhje;
        String[] kirjaimet
                = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
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
            kopio = kopio + System.lineSeparator();
            kopio = kopio + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == vastaus) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, kopio);
        osaTehtavat.add(tehtava);
    }

    /**
     * Lisää tehtävään osatehtävän, jossa määritetään mitä testisuuretta tulee
     * käyttää tehtävän ratkaisemiseksi.
     *
     * @param oikeaTesti Tilastollinen testi, jolla tehtävä ratkaistaan.
     */
    public final void testinValintaTehtava(final String oikeaTesti) {
        String[] kirjaimet
                = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<String> testit = new ArrayList();

        String[] testeja = new String[]{"Riippumattomien otosten t-testi",
            "Verrannollisten parien t-testi",
            "Khiin neliön riippumattomuustesti",
            "Pearsonin korrelaatio", "Spearmanin korrelaatio",
            "Yhden otoksen t-testi",
            "Khiin neliön yhteensopivuustesti", "Binomijakauma",
            "Poissonjakauma",
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
     * @return Palauttaa satunnaisen aiheen, esim. "arjenhallinnan ongelmat".
     */
    public final String[] aiheetPerusmuoto() {
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

    /**
     * Satunnaisia aiheita tehtävien luontia varten.
     *
     * @return Palauttaa satunnaisen aiheen, esim. "arjenhallinnan ongelmiin".
     */
    public final String[] aiheetTaivutus1() {
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

    /**
     * Satunnaisia aiheita tehtävien luontia varten.
     *
     * @return Palauttaa satunnaisen aiheen, esim. "arjenhallinnan ongelmien".
     */
    public final String[] aiheetTaivutus2() {
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
    public final String[] arvoAsteikkoVektori1() {
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
    public final String tulostaAsteikko(final String[] arvot) {
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
    public final String tulostaArvot(final int[] arvot) {
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
    public final String vektoriMerkkiJonoksi(final ArrayList<Integer> vektori) {
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
    public final ArrayList luoData(final int keskikohta, final int koko) {
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

    /**
     * Palauttaa merkkijonotaulukon, jossa on eri ikäryhmiä.
     *
     * @return Merkkijonotaulukko.
     */
    public final String[] ikaRyhmia() {
        String[] ikaRyhmia = new String[]{"6-14 vuotiaat", "15-29 vuotiaat",
            "30-42 vuotiaat", "43-54 vuotiaat", "55-68 vuotiaat",
            "68-99 vuotiaat"};
        return ikaRyhmia;
    }

    /**
     * Palauttaa merkkijonotaulukon, jossa on eri ammatteja.
     *
     * @return Merkkijonotaulukko.
     */
    public final String[] ammatteja() {
        String[] ammatteja = new String[]{"psykologit", "diplomi-insinöörit",
            "lääkärit", "sosiaalityöntekijät", "ekonomit", "hitsaajat",
            "talonrakentajat", "asuntovälittäjät", "pörssivälittäjät",
            "kansanedustajat"};
        return ammatteja;
    }

    /**
     * Palauttaa taulukon, jossa on sukupuolet.
     *
     * @return Merkkijonotaulu.
     */
    public final String[] sukupuolet() {
        String[] sukupuolia = new String[]{"miehet", "naiset"};
        return sukupuolia;
    }

}
