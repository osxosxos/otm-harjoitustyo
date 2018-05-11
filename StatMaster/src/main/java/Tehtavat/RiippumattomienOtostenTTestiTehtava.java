package Tehtavat;

import TilastollisetTestit.StudentinTTestiRiippumattomilleOtoksille;
import java.util.ArrayList;

/**
 * Luokka, jolla luodaan riippumattomien otosten t-testi tehtävä.
 *
 * @author Oskari Koskinen
 */
public class RiippumattomienOtostenTTestiTehtava extends Tehtava {

    /**
     * Muuttujan numerotunniste, jolla voidaan palauttaa muuttujan merkkijono
     * selite taulukosta.
     */
    private int muuttuja;
    /**
     * Vertailtavien ryhmien tyyppi, esim. ammattiryhmä.
     */
    private String ryhmienTyyppi;
    /**
     * Ryhmän X nimi, esim. poliisit.
     */
    private String ryhmaXnimi;
    /**
     * Ryhmän Y nimi, esim. roistot.
     */
    private String ryhmaYnimi;
    /**
     * Ryhmän X arvojen keskikohta.
     */
    private int ryhmanXmediaani;
    /**
     * Ryhmän Y arvojen keskikohta.
     */
    private int ryhmanYmediaani;
    /**
     * Tehtävän hypoteesi.
     */
    private String hypoteesi;
    /**
     * Ryhman X arvot kokonaislukuina.
     */
    private ArrayList<Integer> ryhmanXarvot;
    /**
     * Ryhman Y arvot kokonaislukuina.
     */
    private ArrayList<Integer> ryhmanYarvot;
    /**
     * T-testi, josta löytyy tehtävän oikeat vastaukset.
     */
    private StudentinTTestiRiippumattomilleOtoksille t;

    /**
     * Konstruktori, joka asettaa tehtavan arvot tyhjäksi ennen uuden tehtävän
     * luonnin kutsumista.
     */
    public RiippumattomienOtostenTTestiTehtava() {
        super();
        this.muuttuja = 0;
        this.ryhmienTyyppi = "";
        this.ryhmaXnimi = "";
        this.ryhmaYnimi = "";
        this.ryhmanXmediaani = 0;
        this.ryhmanYmediaani = 0;
        this.hypoteesi = "";
        this.ryhmanXarvot = new ArrayList();
        this.ryhmanYarvot = new ArrayList();
        this.t = new StudentinTTestiRiippumattomilleOtoksille();
    }

    /**
     * Luo uuden tehtävän.
     */
    public final void luoUusiTehtava() {
        this.setMuuttuja(super.getRandom()
                .nextInt(super.aiheetPerusmuoto().length));
        this.setRyhmienTyyppi(this.arvoRyhmienTyyppi());
        this.setRyhmaXnimi(this.arvoRyhmanXnimi());
        this.setRyhmaYnimi(this.arvoRyhmanYnimi());
        this.setRyhmaXmediaani(this.arvoRyhmanXmediaani());
        this.setRyhmaYmediaani(this.arvoRyhmanYmediaani());
        this.setRyhmanXarvot(super.luoData(this.ryhmanXmediaani,
                super.getRandom().nextInt(6) + 5));
        this.setRyhmanYarvot(super.luoData(this.ryhmanYmediaani,
                super.getRandom().nextInt(6) + 5));
        this.setHypoteesi(this.arvoHypoteesi());
        super.setOhje(this.setOhjeistus());
        if (this.hypoteesi.equals("X<Y") || this.hypoteesi.equals("X>Y")) {
            this.t.laske(ryhmanXarvot, ryhmanYarvot, 1);
        } else {
            this.t.laske(ryhmanXarvot, ryhmanYarvot, 2);
        }
        super.testinValintaTehtava("Riippumattomien otosten t-testi");
        this.nollaHypoteesiTehtava();
        this.vaihtoehtoinenHypoteesiTehtava();
        super.laskemisTehtava(this.t.getT(), 5, "Laske t-testisuureen arvo.");
        this.pArvoTehtava();
    }

    /**
     * Palauttaa ryhmien tyypin selityksen.
     *
     * @return Merkkijono.
     */
    public final String getRyhmienTyyppi() {
        return ryhmienTyyppi;
    }

    /**
     * Palauttaa ryhman X selitteen.
     *
     * @return Merkkijono.
     */
    public final String getRyhmaXnimi() {
        return ryhmaXnimi;
    }

    /**
     * Palauttaa ryhman Y selitteen.
     *
     * @return Merkkijono.
     */
    public final String getRyhmaYnimi() {
        return ryhmaYnimi;
    }

    /**
     * Palauttaa ryhman X arvojen keskikohdan.
     *
     * @return Kokonaisluku.
     */
    public final int getRyhmanXmediaani() {
        return ryhmanXmediaani;
    }

    /**
     * Palauttaa ryhman Y arvojen keskikohdan.
     *
     * @return Kokonaisluku.
     */
    public final int getRyhmanYmediaani() {
        return ryhmanYmediaani;
    }

    /**
     * Palauttaa tehtävän hypoteesin.
     *
     * @return Merkkijono.
     */
    public final String getHypoteesi() {
        return hypoteesi;
    }

    /**
     * Palauttaa ryhmän X arvot.
     *
     * @return ArrayList kokonaislukulista.
     */
    public final ArrayList<Integer> getRyhmanXarvot() {
        return ryhmanXarvot;
    }

    /**
     * Palauttaa ryhmän Y arvot.
     *
     * @return ArrayList kokonaislukulista.
     */
    public final ArrayList<Integer> getRyhmanYarvot() {
        return ryhmanYarvot;
    }

    /**
     * Palauttaa t-testin, jossa on tehtävän oikeat vastaukset.
     *
     * @return StudentinTTestiRiippumattomilleOtoksille - objekti.
     */
    public final StudentinTTestiRiippumattomilleOtoksille getT() {
        return t;
    }

    /**
     * Asettaa arvon muuttujan numerotunnisteelle.
     *
     * @param x Kokonaisluku.
     */
    public final void setMuuttuja(final int x) {
        this.muuttuja = x;
    }

    /**
     * Asettaa ryhmien tyypiin, esim. ammattiryhmat tai eri hoitoa saaneet
     * potilaat.
     *
     * @param tyyppi Merkkijono.
     */
    public final void setRyhmienTyyppi(final String tyyppi) {
        this.ryhmienTyyppi = tyyppi;
    }

    /**
     * Asettaa ryhmälle X selitteen, esim. poliisit.
     *
     * @param nimi Merkkijono.
     */
    public final void setRyhmaXnimi(final String nimi) {
        this.ryhmaXnimi = nimi;
    }

    /**
     * Asettaa ryhmälle Y selitteen, esim. Suomi ensin -ryhmäläiset.
     *
     * @param nimi Merkkijono.
     */
    public final void setRyhmaYnimi(final String nimi) {
        this.ryhmaYnimi = nimi;
    }

    /**
     * Asettaa tehtävälle hypoteesi.
     *
     * @param hypoteesimme merkkijono
     */
    public final void setHypoteesi(final String hypoteesimme) {
        this.hypoteesi = hypoteesimme;
    }

    /**
     * Asettaa ryhman X arvoilelle keskikohdan.
     *
     * @param mediaani Kokonaisluku.
     */
    public final void setRyhmaXmediaani(final int mediaani) {
        this.ryhmanXmediaani = mediaani;
    }

    /**
     * Asettaa ryhman X arvoilelle keskikohdan.
     *
     * @param mediaani Kokonaisluku.
     */
    public final void setRyhmaYmediaani(final int mediaani) {
        this.ryhmanYmediaani = mediaani;
    }

    /**
     * Asettaa ryhmälle X arvoiksi kokonaislukulistan.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setRyhmanXarvot(final ArrayList<Integer> arvot) {
        this.ryhmanXarvot = arvot;
    }

    /**
     * Asettaa ryhmälle Y arvoiksi kokonaislukulistan.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setRyhmanYarvot(final ArrayList<Integer> arvot) {
        this.ryhmanYarvot = arvot;
    }

    /**
     * Asettaa tehtävälle ohjeistuksen.
     *
     * @return Tehtävän Ohjeistus Merkkijonona.
     */
    public final String setOhjeistus() {

        String ohje1 = "Tutkimuksen kohteena olivat "
                + this.ryhmaXnimi + " ja " + this.ryhmaYnimi + "."
                + System.lineSeparator()
                + "Molemmista ryhmistä kerättiin edustavat otokset.";

        String ohje2 = "Tutkija oli kiinnostunut ryhmien välisestä erosta "
                + "muuttujan " + super.aiheetPerusmuoto()[this.muuttuja]
                + " arvoissa."
                + System.lineSeparator();

        String ohje3 = "Voit olettaa, että molempien ryhmien "
                + "havainnot ovat vähintään "
                + System.lineSeparator()
                + "välimatka-asteikollisia, hajonnat ovat molemmissa "
                + "ryhmissä yhtäsuuret"
                + System.lineSeparator()
                + "ja havainnot noudattavat likimain normaalijakaumaa."
                + System.lineSeparator();

        String ohje4 = "Muuttujalla " + super.aiheetPerusmuoto()[this.muuttuja]
                + " on seuraavat arvot ryhmässä " + this.ryhmaXnimi + "."
                + System.lineSeparator()
                + this.vektoriMerkkiJonoksi(this.ryhmanXarvot)
                + System.lineSeparator();

        String ohje5 = "Muuttujalla  "
                + super.aiheetPerusmuoto()[this.muuttuja]
                + " on seuraavat arvot ryhmässä " + this.ryhmaYnimi + "."
                + System.lineSeparator()
                + this.vektoriMerkkiJonoksi(this.ryhmanYarvot)
                + System.lineSeparator();

        String ohje6 = "";

        if (this.hypoteesi.equals("X<Y")) {
            ohje6 = "Tutki onko ryhmän " + this.ryhmaXnimi
                    + " keskiarvo pienempi kuin ryhmän "
                    + this.ryhmaYnimi + ".";
        } else if (this.hypoteesi.equals("X>Y")) {
            ohje6 = "Tutki onko ryhmän " + this.ryhmaXnimi
                    + " keskiarvo suurempi kuin ryhmän "
                    + this.ryhmaYnimi + ".";
        } else if (this.hypoteesi.equals("X=/=Y")) {
            ohje6 = "Tutki eroaako ryhmän " + this.ryhmaXnimi
                    + " keskiarvo ryhmän " + this.ryhmaYnimi
                    + " keskiarvosta.";
        }

        String tehtavanOhje = ohje1 + System.lineSeparator()
                + ohje2 + System.lineSeparator()
                + ohje3 + System.lineSeparator()
                + ohje4 + System.lineSeparator()
                + ohje5 + System.lineSeparator()
                + ohje6;

        return tehtavanOhje;

    }

    /**
     * Arpoo ryhmien tyypiksi merkkijonon.
     *
     * @return Merkkijono.
     */
    public final String arvoRyhmienTyyppi() {
        int x = super.getRandom().nextInt(3);
        if (x == 0) {
            return "ika";
        } else if (x == 1) {
            return "ammatti";
        } else if (x == 2) {
            return "supu";
        }
        return "";
    }

    /**
     * Arpoo ryhmalle x merkkijono selitteen, esim. kommunistit.
     *
     * @return Merkkijono.
     */
    public final String arvoRyhmanXnimi() {
        if (this.ryhmienTyyppi.equals("ika")) {
            int x = super.getRandom().nextInt(super.ikaRyhmia().length);
            return super.ikaRyhmia()[x];
        } else if (this.ryhmienTyyppi.equals("ammatti")) {
            int x = super.getRandom().nextInt(super.ammatteja().length);
            return super.ammatteja()[x];
        } else if (this.ryhmienTyyppi.equals("supu")) {
            int x = super.getRandom().nextInt(super.sukupuolet().length);
            return super.sukupuolet()[x];
        }
        return "";
    }

    /**
     * Arpoo ryhmälle y merkkijono selitteen, joka ei ole sama kuin ryhmän x
     * selite, esim. jos ryhma x kommunistit, ryhmä y on jotain muuta, esim.
     * kapitalistit.
     *
     * @return Merkkijono.
     */
    public final String arvoRyhmanYnimi() {
        if (this.ryhmienTyyppi.equals("ika")) {
            while (true) {
                int y = super.getRandom().nextInt(super.ikaRyhmia().length);
                if (!super.ikaRyhmia()[y].equals(this.ryhmaXnimi)) {
                    return super.ikaRyhmia()[y];
                }
            }
        } else if (this.ryhmienTyyppi.equals("ammatti")) {
            while (true) {
                int y = super.getRandom().nextInt(super.ammatteja().length);
                if (!super.ammatteja()[y].equals(this.ryhmaXnimi)) {
                    return super.ammatteja()[y];
                }
            }
        } else if (this.ryhmienTyyppi.equals("supu")) {
            while (true) {
                int y = super.getRandom().nextInt(super.sukupuolet().length);
                if (!super.sukupuolet()[y].equals(this.ryhmaXnimi)) {
                    return super.sukupuolet()[y];
                }
            }
        }
        return "";
    }

    /**
     * Arpoo ryhman X arvoille keskikohdan.
     *
     * @return Kokonaisluku.
     */
    public final int arvoRyhmanXmediaani() {
        int x = (super.getRandom().nextInt(10) + 1) * 5 + 50;
        return x;
    }

    /**
     * Arpoo ryhman Y arvoille keskikohdan.
     *
     * @return Kokonaisluku.
     */
    public final int arvoRyhmanYmediaani() {
        int x = 0;
        while (true) {
            x = super.getRandom().nextInt(super.getRandom().nextInt(10)
                    + 1) * 5 + 50;
            if (Math.abs(this.ryhmanXmediaani - x) <= 20
                    && x != this.ryhmanXmediaani) {
                return x;
            }
        }
    }

    /**
     * Arpoo tehtävälle hypoteesin.
     *
     * @return merkkijono.
     */
    public final String arvoHypoteesi() {

        String h1 = "X<Y";
        String h2 = "X>Y";
        String h3 = "X=/=Y";

        int x = super.getRandom().nextInt(3);

        if (x == 0) {
            this.hypoteesi = h1;
        } else if (x == 1) {
            this.hypoteesi = h2;
        } else {
            this.hypoteesi = h3;
        }

        return hypoteesi;

    }

    /**
     * Luo tehtävälle osatehtävän, jossa valitaan nollahypoteesi.
     */
    public final void nollaHypoteesiTehtava() {
        String vastaus1 = "1. Ryhmien keskiarvot eivät eroa toisistaan";
        String vastaus2 = "2. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on suurempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus3 = "3. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on pienempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus4 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävälle osatehtävän, jossa valitaan vastahypoteesi.
     */
    public final void vaihtoehtoinenHypoteesiTehtava() {

        String vastaus1 = "1. Ryhmien keskiarvot eivät eroa toisistaan";
        String vastaus2 = "2. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on suurempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus3 = "3. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on pienempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus4 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
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

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävälle osatehtävän, jossa määritetään testisuureen p-arvo.
     */
    public final void pArvoTehtava() {
        String ohje = "Määritä testisuureen p-arvo"
                + System.lineSeparator()
                + "1. Tulos ei ole tilastollisesti merkisevä"
                + System.lineSeparator()
                + "2. p <0.05"
                + System.lineSeparator()
                + "3. p <0.01"
                + System.lineSeparator()
                + "4. p <0.001"
                + System.lineSeparator();

        int vastaus = 0;

        if (this.hypoteesi.equals("X<Y") && this.t.getT() >= 0) {
            vastaus = 1;
        } else if (this.hypoteesi.equals("X>Y") && this.t.getT() <= 0) {
            vastaus = 1;
        } else {
            if (this.t.getpArvo().equals("ns")) {
                vastaus = 1;
            } else if (this.t.getpArvo().equals("p <0.05")) {
                vastaus = 2;
            } else if (this.t.getpArvo().equals("p < 0.01")) {
                vastaus = 3;
            } else {
                vastaus = 4;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        super.getOsaTehtavat().add(tehtava);

    }

}
