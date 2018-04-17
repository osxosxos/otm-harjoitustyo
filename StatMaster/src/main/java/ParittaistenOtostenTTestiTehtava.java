
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oskari Koskinen
 */
public class ParittaistenOtostenTTestiTehtava {

    PerusLaskuKaavat kaavat;
    String muuttujanNimi;
    String ryhmaManipulaatio;
    String hypoteesi;
    String ohjeistus;
    int koko;
    int ennenMediaani;
    int jalkeenMediaani;
    ArrayList<Integer> ennenArvot;
    ArrayList<Integer> jalkeenArvot;
    ArrayList<OsaTehtava> osaTehtavat;
    StudentinTTestiParittaisilleOtoksille t;
    Random random;

    public ParittaistenOtostenTTestiTehtava() {
        this.kaavat = new PerusLaskuKaavat();
        this.muuttujanNimi = "";
        this.ryhmaManipulaatio = "";
        this.hypoteesi = "";
        this.ohjeistus = "";
        this.koko = 0;
        this.ennenMediaani = 0;
        this.jalkeenMediaani = 0;
        this.ennenArvot = new ArrayList();
        this.jalkeenArvot = new ArrayList();
        this.osaTehtavat = new ArrayList();
        this.t = new StudentinTTestiParittaisilleOtoksille();
        this.random = new Random();
    }

    public void luoUusiTehtava() {
        this.setMuuttujanNimi(this.arvoMuuttujanNimi());
        this.setRyhmaManipulaatio(this.arvoRyhmaManipulaatio());
        this.setEnnenMediaani(this.arvoEnnenMediaani());
        this.setJalkeenMediaani(this.arvoJalkeenMediaani());
        this.setKoko(this.arvoKoko());
        this.setEnnenArvot(this.luoData(this.ennenMediaani));
        this.setJalkeenArvot(this.luoData(this.jalkeenMediaani));
        this.setHypoteesi(this.arvoHypoteesi());
        this.setOhjeistus();
        if (this.hypoteesi.equals("X<Y") || this.hypoteesi.equals("X>Y")) {
            this.t.laske(this.ennenArvot, this.jalkeenArvot, 1);
        } else {
            this.t.laske(this.ennenArvot, this.jalkeenArvot, 2);
        }
        this.testiSuureenValintaTehtava();
        this.nollaHypoteesiTehtava();
        this.vaihtoehtoinenHypoteesiTehtava();
        this.erotustenKeskiArvoTehtava();
        this.erotustenOtosKeskiHajontaTehtava();
        this.tArvoTehtava();
        this.pArvoTehtava();
    }

    public boolean suorita(Scanner scanner) {
        System.out.println(this.ohjeistus);
        System.lineSeparator();

        for (int i = 0; i < osaTehtavat.size(); i++) {
            osaTehtavat.get(i).suorita();
        }

        System.out.println("Tehtävä on nyt ratkaistu!");
        System.lineSeparator();
        return true;
    }

    public void erotustenKeskiArvoTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<Double> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add(this.t.erotustenKa);
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.erotustenKa - 2 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.erotustenKa + 2 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.erotustenKa - 2 * random.nextDouble()));

        Collections.shuffle(vaihtoEhdot);
        double oikeaVastaus = 1;
        String ohje = "Valitse annetuista vaihtoehdoista erotusten keskiarvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            ohje = ohje + System.lineSeparator();
            ohje = ohje + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == this.t.erotustenKa) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }
        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, ohje);
        osaTehtavat.add(tehtava);
    }

    public void erotustenOtosKeskiHajontaTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<Double> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add(this.t.erotustenOtosKh);
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.erotustenOtosKh - 2 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.erotustenOtosKh + 2 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.erotustenOtosKh - 2 * random.nextDouble()));

        Collections.shuffle(vaihtoEhdot);
        double oikeaVastaus = 1;
        String ohje = "Valitse annetuista vaihtoehdoista erotusten otoskeskihajonta: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            ohje = ohje + System.lineSeparator();
            ohje = ohje + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == this.t.erotustenOtosKh) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }
        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, ohje);
        osaTehtavat.add(tehtava);
    }

    public void tArvoTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<Double> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add(this.t.t);
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.t - 2 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.t + 2 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.t.t - 2 * random.nextDouble()));

        Collections.shuffle(vaihtoEhdot);
        double oikeaVastaus = 1;
        String ohje = "Valitse annetuista vaihtoehdoista testisuureen arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            ohje = ohje + System.lineSeparator();
            ohje = ohje + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == this.t.t) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }
        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, ohje);
        osaTehtavat.add(tehtava);
    }

    public void pArvoTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<String> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add("Tulos ei ole tilastollisesti merkitsevä");
        vaihtoEhdot.add("p <0.05");
        vaihtoEhdot.add("p <0.01");
        vaihtoEhdot.add("p <0.001");

        double oikeaVastaus = 1;
        String ohje = "Valitse annetuista vaihtoehdoista testisuureen p-arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            ohje = ohje + System.lineSeparator();
            ohje = ohje + kirjaimet[i] + vaihtoEhdot.get(i);
        }

        if (this.hypoteesi.equals("X<Y") && this.t.t <= 0) {
            oikeaVastaus = 1;
        } else if (this.hypoteesi.equals("X>Y") && this.t.t >= 0) {
            oikeaVastaus = 1;
        } else {
            if (this.t.pArvo.equals("ns")) {
                oikeaVastaus = 1;
            } else if (this.t.pArvo.equals("p <0.05")) {
                oikeaVastaus = 2;
            } else if (this.t.pArvo.equals("p < 0.01")) {
                oikeaVastaus = 3;
            } else {
                oikeaVastaus = 4;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, ohje);
        osaTehtavat.add(tehtava);
    }

    public void nollaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Mittauksien välillä ei ole eroa.";
        String vastaus2 = "B = 2: Arvot ovat kasvaneet mittauksien välillä";
        String vastaus3 = "C = 3: Arvot ovat pienentyneet mittauksien välillä";
        String vastaus4 = "D = 4: Arvot eivät ole samat eri mittauksissa";

        String ohje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, ohje);
        this.osaTehtavat.add(tehtava);
    }

    public void vaihtoehtoinenHypoteesiTehtava() {

        String vastaus1 = "A = 1: Mittauksien välillä ei ole eroa.";
        String vastaus2 = "B = 2: Arvot ovat kasvaneet mittauksien välillä";
        String vastaus3 = "C = 3: Arvot ovat pienentyneet mittauksien välillä";
        String vastaus4 = "D = 4: Arvot eivät ole samat eri mittauksissa";

        String ohje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        int vastaus = 0;

        if (this.hypoteesi.equals("X<Y")) {
            vastaus = 2;
        } else if (this.hypoteesi.equals("X>Y")) {
            vastaus = 3;
        } else if (this.hypoteesi.equals("X=/=Y")) {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        this.osaTehtavat.add(tehtava);
    }

    public void testiSuureenValintaTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<String> testit = new ArrayList();

        String[] testeja = new String[]{"Riippumattomien otosten t-testi",
            "Verrannolisten parien t-testi", "Khiin neliön riippumattomuustesti",
            "Pearsonin korrelaatio", "Spearmanin korrelaatio", "Yhden otoksen t-testi",
            "Khiin neliön yhteensopivuustesti", "Binomijakauma", "Poissonjakauma"};

        Collections.addAll(testit, testeja);
        Collections.shuffle(testit);

        String ohje = "Valitse testisuure:" + System.lineSeparator();
        int oikeaVastaus = 1;

        int k = 0;

        while (testit.size() > 4) {
            if (testit.get(k).equals("Verrannolisten parien t-testi")) {
                k++;
            } else {
                testit.remove(k);
                k = 0;
            }
        }

        for (int i = 0; i < testit.size(); i++) {
            ohje = ohje + System.lineSeparator();
            ohje = ohje + kirjaimet[i] + testit.get(i);
            if (testit.get(i).equals("Verrannolisten parien t-testi")) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, ohje);
        this.osaTehtavat.add(tehtava);

    }

    public String arvoHypoteesi() {

        String h1 = "X<Y";
        String h2 = "X>Y";
        String h3 = "X=/=Y";

        int x = random.nextInt(3);

        if (x == 0) {
            this.hypoteesi = h1;
        } else if (x == 1) {
            this.hypoteesi = h2;
        } else {
            this.hypoteesi = h3;
        }

        return hypoteesi;

    }

    public String arvoMuuttujanNimi() {
        String[] muuttujat = new String[]{"vakavan masennuksen oireisiin",
            "yleistyneen ahdistuneisuushäiriön oireisiin",
            "aktiivisuuden ja tarkkaavaisuuden häiriön oireisiin",
            "arjenhallinnan ongelmiin", "toverisuosioon",
            "kiintymyssuhteen turvallisuuteen",
            "pakko-oireisen häiriön oireisiin",
            "työstressiin", "älykkyysosamäärään",
            "alzheimerin tautia sairastavien potilaiden työmuistiin"};
        int x = random.nextInt(muuttujat.length);
        return muuttujat[x];
    }

    public String arvoRyhmaManipulaatio() {
        String[] manipulaatiot = new String[]{"taideterapian",
            "neuropsykologisen kuntoutuksen", "kognitiivisen psykoterapian",
            "psykodynaamisen psykoterapian",
            "lääkityksen", "säännöllisen liikunnan", "nettiterapian",
            "humanistisen kuvataideterapian", "kristalliterapian",
            "hopeaveden juonnin", "reikihoidon", "energiahoidon",
            "homeopaattisten valmisteiden"};
        int x = random.nextInt(manipulaatiot.length);
        return manipulaatiot[x];
    }

    public int arvoKoko() {
        int x = random.nextInt(16) + 5;
        return x;
    }

    public int arvoEnnenMediaani() {
        int x = (random.nextInt(10) + 1) * 5 + 50;
        return x;
    }

    public int arvoJalkeenMediaani() {
        int x = 0;
        while (true) {
            x = random.nextInt(random.nextInt(10) + 1) * 5 + 50;
            if (Math.abs(this.ennenMediaani - x) <= 20) {
                return x;
            }
        }
    }

    /**
     * Luo datoja tehtavaa varten, jotka noudattavat likimain normaalijakaumaa.
     *
     * @param mediaani Jakauman keskikohta, jonka ympärille arvot sijoittuvat.
     * @return Palauttaa datan kokonaislukulistana.
     */
    public ArrayList luoData(int mediaani) {
        ArrayList<Integer> data = new ArrayList();

        for (int i = 0; i < this.koko; i++) {
            int x = random.nextInt(101);
            int a = random.nextInt(2);
            int b = random.nextInt(6) + 5;
            if (x <= 70) {
                if (a == 0) {
                    data.add(mediaani - b);
                } else if (a == 1) {
                    data.add(mediaani + b);
                }
            } else if (x > 70 && x <= 95) {
                if (a == 0) {
                    data.add(mediaani - 2 * b);
                } else if (a == 1) {
                    data.add(mediaani + 2 * b);
                }
            } else if (x > 95) {
                if (a == 0) {
                    data.add(mediaani - 3 * b);
                } else if (a == 1) {
                    data.add(mediaani + 3 * b);
                }
            }
        }
        return data;
    }

    public void setKoko(int koko) {
        this.koko = koko;
    }

    public void setMuuttujanNimi(String muuttujanNimi) {
        this.muuttujanNimi = muuttujanNimi;
    }

    public void setRyhmaManipulaatio(String ryhmaManipulaatio) {
        this.ryhmaManipulaatio = ryhmaManipulaatio;
    }

    public void setHypoteesi(String hypoteesi) {
        this.hypoteesi = hypoteesi;
    }

    public void setOhjeistus() {
        int x = random.nextInt(25) + 5;
        this.ohjeistus = "Tutkija on kiinnostunut ";
        this.ohjeistus = this.ohjeistus + this.ryhmaManipulaatio;
        this.ohjeistus = this.ohjeistus + " vaikutuksesta ";
        this.ohjeistus = this.ohjeistus + this.muuttujanNimi + ".";
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + "Tutkittavat henkilöt mitattiin ennen tutkimusta ja ";
        this.ohjeistus = this.ohjeistus + x + " viikkoa intervention aloittamisen jälkeen.";
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + "Alla on esitetty arvot ennen intervention aloittamista ja sen jälkeen.";
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + "Ennen aloittamista tutkittavien arvot olivat seuraavat:";
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + this.vektoriMerkkiJonoksi(this.ennenArvot);
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + "Ja kokeen jälkeen arvot olivat seuraavat:";
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + this.vektoriMerkkiJonoksi(this.jalkeenArvot);
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        this.ohjeistus = this.ohjeistus + System.lineSeparator();
        if (this.hypoteesi.equals("X<Y")) {
            this.ohjeistus = this.ohjeistus + "Tutki ovatko arvot kasvaneet";
        } else if (this.hypoteesi.equals("X>Y")) {
            this.ohjeistus = this.ohjeistus + "Tutki ovatko arvot pienentyneet";
        } else if (this.hypoteesi.equals("X=/=Y")) {
            this.ohjeistus = this.ohjeistus + "Tutki ovatko arvot yhtäsuuret";
        }
        this.ohjeistus = this.ohjeistus  + System.lineSeparator() 
                + "Voit olettaa, että molemmat mittaukset noudattavat normaalijakaumaa "
                + System.lineSeparator() + "ja ovat vähintään välimatka-asteikollisia."
                + System.lineSeparator();
    }

    public void setEnnenMediaani(int ennenMediaani) {
        this.ennenMediaani = ennenMediaani;
    }

    public void setJalkeenMediaani(int jalkeenMediaani) {
        this.jalkeenMediaani = jalkeenMediaani;
    }

    public void setEnnenArvot(ArrayList<Integer> ennenArvot) {
        this.ennenArvot = ennenArvot;
    }

    public void setJalkeenArvot(ArrayList<Integer> jalkeenArvot) {
        this.jalkeenArvot = jalkeenArvot;
    }

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

}
