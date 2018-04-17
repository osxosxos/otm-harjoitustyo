
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Oskari Koskinen
 */
public class RiippumattomienOtostenTTestiTehtava {

    String muuttujanNimi;
    String ryhmienTyyppi;
    String ryhmaXnimi;
    String ryhmaYnimi;
    int ryhmanXmediaani;
    int ryhmanYmediaani;
    String hypoteesi;
    String ohjeistus;
    String[] ikaRyhmia;
    String[] ammatteja;
    String[] sukupuolia;
    ArrayList<Integer> ryhmanXarvot;
    ArrayList<Integer> ryhmanYarvot;
    ArrayList<OsaTehtava> osaTehtavat;
    StudentinTTestiRiippumattomilleOtoksille t;
    Random random;

    public RiippumattomienOtostenTTestiTehtava() {
        this.muuttujanNimi = "";
        this.ryhmienTyyppi = "";
        this.ryhmaXnimi = "";
        this.ryhmaYnimi = "";
        this.ryhmanXmediaani = 0;
        this.ryhmanYmediaani = 0;
        this.hypoteesi = "";
        this.ohjeistus = "";
        this.ikaRyhmia = new String[]{"6-14 vuotiaat", "15-29 vuotiaat",
            "30-42 vuotiaat", "43-54 vuotiaat", "55-68 vuotiaat", "68-99 vuotiaat"};
        this.ammatteja = new String[]{"psykologit", "diplomi-insinöörit",
            "lääkärit", "sosiaalityöntekijät", "ekonomit", "hitsaajat",
            "talonrakentajat", "asuntovälittäjät", "pörssivälittäjät", "kansanedustajat"};
        this.sukupuolia = new String[]{"miehet", "naiset"};
        this.ryhmanXarvot = new ArrayList();
        this.ryhmanYarvot = new ArrayList();
        this.osaTehtavat = new ArrayList();
        this.t = new StudentinTTestiRiippumattomilleOtoksille();
        this.random = new Random();
    }

    public void luoUusiTehtava() {
        this.setMuuttujanNimi(this.arvoMuuttujanNimi());
        this.setRyhmienTyyppi(this.arvoRyhmienTyyppi());
        this.setRyhmaXnimi(this.arvoRyhmanXnimi());
        this.setRyhmaYnimi(this.arvoRyhmanYnimi());
        this.setRyhmanXylaraja(this.arvoRyhmanXmediaani());
        this.setRyhmanYylaraja(this.arvoRyhmanYmediaani());
        this.setRyhmanXarvot(this.luoData(this.ryhmanXmediaani));
        this.setRyhmanYarvot(this.luoData(this.ryhmanYmediaani));
        this.setHypoteesi(this.arvoHypoteesi());
        this.setOhjeistus();
        if (this.hypoteesi.equals("X<Y") || this.hypoteesi.equals("X>Y")) {
            this.t.laske(ryhmanXarvot, ryhmanYarvot, 1);
        } else {
            this.t.laske(ryhmanXarvot, ryhmanYarvot, 2);
        }
        this.testiSuureenValinta();
        this.nollaHypoteesiTehtava();
        this.vaihtoehtoinenHypoteesiTehtava();
        this.ryhmanXKeskiarvoTehtava();
        this.ryhmanYKeskiarvoTehtava();
        this.ryhmanXKeskihajontaTehtava();
        this.ryhmanYKeskihajontaTehtava();
        this.yhteisHajontaTehtava();
        this.tTestiSuureTehtava();
        this.pArvoTehtava();
    }

    public void suorita() {
        System.out.println(this.ohjeistus);
        System.out.println("");

        for (int i = 0; i < osaTehtavat.size(); i++) {
            osaTehtavat.get(i).suorita();
        }

        System.out.println("Tehtävä on nyt ratkaistu!");
        System.out.println("");
    }

    public void setMuuttujanNimi(String muuttujanNimi) {
        this.muuttujanNimi = muuttujanNimi;
    }

    public void setRyhmienTyyppi(String ryhmienTyyppi) {
        this.ryhmienTyyppi = ryhmienTyyppi;
    }

    public void setRyhmaXnimi(String ryhmaXnimi) {
        this.ryhmaXnimi = ryhmaXnimi;
    }

    public void setRyhmaYnimi(String ryhmaYnimi) {
        this.ryhmaYnimi = ryhmaYnimi;
    }

    public void setHypoteesi(String hypoteesi) {
        this.hypoteesi = hypoteesi;
    }

    public void setRyhmanXylaraja(int ryhmanXmediaani) {
        this.ryhmanXmediaani = ryhmanXmediaani;
    }

    public void setRyhmanYylaraja(int ryhmanYmediaani) {
        this.ryhmanYmediaani = ryhmanYmediaani;
    }

    public void setRyhmanXarvot(ArrayList<Integer> ryhmanXarvot) {
        this.ryhmanXarvot = ryhmanXarvot;
    }

    public void setRyhmanYarvot(ArrayList<Integer> ryhmanYarvot) {
        this.ryhmanYarvot = ryhmanYarvot;
    }

    public void setOhjeistus() {

        String ohje1 = "Tutkimuksen kohteena olivat "
                + this.ryhmaXnimi + " ja " + this.ryhmaYnimi + "."
                + System.lineSeparator()
                + "Molemmista ryhmistä kerättiin edustavat otokset.";

        String ohje2 = "Tutkija oli kiinnostunut ryhmien välisestä erosta "
                + "muuttujan " + this.muuttujanNimi + " arvoissa."
                + System.lineSeparator();

        String ohje3 = "Voit olettaa, että molempien ryhmien havainnot ovat vähintään "
                + System.lineSeparator()
                + "välimatka-asteikollisia, hajonnat ovat molemmissa ryhmissä yhtäsuuret"
                + System.lineSeparator()
                + "ja havainnot noudattavat likimain normaalijakaumaa."
                + System.lineSeparator();

        String ohje4 = "Muuttujalla " + this.muuttujanNimi
                + " on seuraavat arvot ryhmässä " + this.ryhmaXnimi + "."
                + System.lineSeparator() + this.vektoriMerkkiJonoksi(this.ryhmanXarvot)
                + System.lineSeparator();

        String ohje5 = "Muuttujalla  " + this.muuttujanNimi
                + " on seuraavat arvot ryhmässä " + this.ryhmaYnimi + "."
                + System.lineSeparator() + this.vektoriMerkkiJonoksi(this.ryhmanYarvot)
                + System.lineSeparator();

        String ohje6 = "";

        if (this.hypoteesi.equals("X<Y")) {
            ohje6 = "Tutki onko ryhmän " + this.ryhmaXnimi
                    + " keskiarvo pienempi kuin ryhmän " + this.ryhmaYnimi + ".";
        } else if (this.hypoteesi.equals("X>Y")) {
            ohje6 = "Tutki onko ryhmän " + this.ryhmaXnimi
                    + " keskiarvo suurempi kuin ryhmän " + this.ryhmaYnimi + ".";
        } else if (this.hypoteesi.equals("X=/=Y")) {
            ohje6 = "Tutki eroaako ryhmän " + this.ryhmaXnimi
                    + " keskiarvo ryhmän " + this.ryhmaYnimi + " keskiarvosta.";
        }

        String ohje = ohje1 + System.lineSeparator()
                + ohje2 + System.lineSeparator()
                + ohje3 + System.lineSeparator()
                + ohje4 + System.lineSeparator()
                + ohje5 + System.lineSeparator()
                + ohje6;

        this.ohjeistus = ohje;

    }

    public String arvoMuuttujanNimi() {
        String[] muuttujat = new String[]{"masennus",
            "ahdistus", "ADHD", "arkisujuvuus", "toverisuosio",
            "kiintymyssuhteen turvallisuus", "neuroottisuus", "sovinnollisuus",
            "avoimuus uusille kokemuksille", "tunnollisuus",
            "autoritaarinen persoonallisuus", "luotettavuus",
            "työstressi", "älykkyysosamäärä", "työmuisti"};
        int x = random.nextInt(muuttujat.length);
        return muuttujat[x];
    }

    public String arvoRyhmienTyyppi() {
        int x = random.nextInt(3);
        if (x == 0) {
            return "ika";
        } else if (x == 1) {
            return "ammatti";
        } else if (x == 2) {
            return "supu";
        }
        return "";
    }

    public String arvoRyhmanXnimi() {
        if (this.ryhmienTyyppi.equals("ika")) {
            int x = random.nextInt(this.ikaRyhmia.length);
            return this.ikaRyhmia[x];
        } else if (this.ryhmienTyyppi.equals("ammatti")) {
            int x = random.nextInt(this.ammatteja.length);
            return this.ammatteja[x];
        } else if (this.ryhmienTyyppi.equals("supu")) {
            int x = random.nextInt(this.sukupuolia.length);
            return this.sukupuolia[x];
        }
        return "";
    }

    public String arvoRyhmanYnimi() {
        if (this.ryhmienTyyppi.equals("ika")) {
            while (true) {
                int y = random.nextInt(this.ikaRyhmia.length);
                if (!ikaRyhmia[y].equals(this.ryhmaXnimi)) {
                    return this.ikaRyhmia[y];
                }
            }
        } else if (this.ryhmienTyyppi.equals("ammatti")) {
            while (true) {
                int y = random.nextInt(this.ammatteja.length);
                if (!this.ammatteja[y].equals(this.ryhmaXnimi)) {
                    return this.ammatteja[y];
                }
            }
        } else if (this.ryhmienTyyppi.equals("supu")) {
            while (true) {
                int y = random.nextInt(this.sukupuolia.length);
                if (!this.sukupuolia[y].equals(this.ryhmaXnimi)) {
                    return this.sukupuolia[y];
                }
            }
        }
        return "";
    }

    public int arvoRyhmanXmediaani() {
        int x = (random.nextInt(10) + 1) * 5 + 50;
        return x;
    }

    public int arvoRyhmanYmediaani() {
        int x = 0;
        while (true) {
            x = random.nextInt(random.nextInt(10) + 1) * 5 + 50;
            if (Math.abs(this.ryhmanXmediaani - x) <= 20) {
                return x;
            }
        }
    }

    /**
     * Luo likimain normaalijakaumaa noudattavan datan.
     *
     * @param mediaani Jakauman mielivaltainen keskikohta.
     * @return Palauttaa likimain normaalijakautuneiden lukujen listan.
     */
    public ArrayList luoData(int mediaani) {
        ArrayList<Integer> data = new ArrayList();
        int koko = random.nextInt(6) + 5;

        for (int i = 0; i < koko; i++) {
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

    public void nollaHypoteesiTehtava() {
        String vastaus1 = "1. Ryhmien keskiarvot eivät eroa toisistaan";
        String vastaus2 = "2. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on suurempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus3 = "3. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on pienempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus4 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        String ohje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, ohje);
        osaTehtavat.add(tehtava);
    }

    public void vaihtoehtoinenHypoteesiTehtava() {

        String vastaus1 = "1. Ryhmien keskiarvot eivät eroa toisistaan";
        String vastaus2 = "2. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on suurempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus3 = "3. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on pienempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus4 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        String ohje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        int vastaus = 0;

        if (this.hypoteesi.equals("X>Y")) {
            vastaus = 2;
        } else if (this.hypoteesi.equals("X<Y")) {
            vastaus = 3;
        } else if (this.hypoteesi.equals("X=/=Y")) {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        osaTehtavat.add(tehtava);
    }

    public void testiSuureenValinta() {

        ArrayList<String> testit = new ArrayList();

        String[] testeja = new String[]{"Riippumattomien otosten t-testi",
            "Verrannolisten parien t-testi", "Khiin neliön riippumattomuustesti",
            "Pearsonin korrelaatio", "Spearmanin korrelaatio", "Yhden otoksen t-testi",
            "Khiin neliön yhteensopivuustesti"};

        Collections.addAll(testit, testeja);
        Collections.shuffle(testit);

        int vastaus = 1;

        for (int i = 0; i < testit.size(); i++) {
            if (testit.get(i).equals("Riippumattomien otosten t-testi")) {
                vastaus = vastaus + i;
            }
        }

        String ohje = "Valitse testisuure:" + System.lineSeparator();

        for (int i = 0; i < testit.size(); i++) {
            ohje = ohje + (i + 1) + ". " + testit.get(i) + System.lineSeparator();
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        this.osaTehtavat.add(tehtava);

    }
    
    public void ryhmanXKeskiarvoTehtava() {
        String ohje = "Laske ryhmän " + this.ryhmaXnimi + " keskiarvo.";
        OsaTehtava tehtava = new OsaTehtava(this.t.kaRyhmaX, ohje);
        osaTehtavat.add(tehtava);
    }

    public void ryhmanYKeskiarvoTehtava() {
        String ohje = "Laske ryhmän " + this.ryhmaYnimi + " keskiarvo.";
        OsaTehtava tehtava = new OsaTehtava(this.t.kaRyhmaY, ohje);
        osaTehtavat.add(tehtava);
    }

    public void ryhmanXKeskihajontaTehtava() {
        String ohje = "Laske ryhmän " + this.ryhmaXnimi + " otoskeskihajonta.";
        OsaTehtava tehtava = new OsaTehtava(this.t.khRyhmaX, ohje);
        osaTehtavat.add(tehtava);
    }

    public void ryhmanYKeskihajontaTehtava() {
        String ohje = "Laske ryhmän " + this.ryhmaYnimi + " otoskeskihajonta.";
        OsaTehtava tehtava = new OsaTehtava(this.t.khRyhmaY, ohje);
        osaTehtavat.add(tehtava);
    }

    public void yhteisHajontaTehtava() {
        String ohje = "Laske yhteishajonta "
                + "(vihje: luku on ryhmien otoskeskihajontojen välillä).";
        OsaTehtava tehtava = new OsaTehtava(this.t.yhteisHajontaXY, ohje);
        osaTehtavat.add(tehtava);
    }

    public void tTestiSuureTehtava() {
        String ohje = "Laske keskiarvojen erotuksen t-arvo.";
        OsaTehtava tehtava = new OsaTehtava(this.t.t, ohje);
        osaTehtavat.add(tehtava);
    }

    public void pArvoTehtava() {
        String ohje = "Määritä testisuureen p-arvo" + System.lineSeparator()
                + "1. Tulos ei ole tilastollisesti merkisevä" + System.lineSeparator()
                + "2. p <0.05" + System.lineSeparator()
                + "3. p <0.01" + System.lineSeparator()
                + "4. p <0.001" + System.lineSeparator();

        int vastaus = 0;

        if (this.hypoteesi.equals("X<Y") && this.t.t >= 0) {
            vastaus = 1;
        } else if (this.hypoteesi.equals("X>Y") && this.t.t <= 0) {
            vastaus = 1;
        } else {
            if (this.t.pArvo.equals("ns")) {
                vastaus = 1;
            } else if (this.t.pArvo.equals("p <0.05")) {
                vastaus = 2;
            } else if (this.t.pArvo.equals("p < 0.01")) {
                vastaus = 3;
            } else {
                vastaus = 4;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        osaTehtavat.add(tehtava);

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
