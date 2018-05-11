package Tehtavat;

import TilastollisetTestit.StudentinTTestiParittaisilleOtoksille;
import java.util.ArrayList;

/**
 * Luokka, jolla luodaan parittaisten otosten t-testi tehtävä.
 *
 * @author Oskari Koskinen
 */
public class ParittaistenOtostenTTestiTehtava extends Tehtava {

    /**
     * Muuttuja, jonka arvojen muutoksesta ollaan kiinnostuneita.Numero kertoo
     * missä kohtaa muuttuja taulukkoa halutun muuttujan nimi on.
     */
    private int muuttuja;
    /**
     * Mitä mittausten välillä tapahtuu.
     */
    private String ryhmaManipulaatio;
    /**
     * Miten mittaukset vaikuttavat keskiarvoihin.
     */
    private String hypoteesi;
    /**
     * Otoksen koko.
     */
    private int koko;
    /**
     * Mielivaltainen arvottu luku, joka kuvaa aineiston keskikohtaa ennen.
     */
    private int ennenMediaani;
    /**
     * Mielivaltainen arvottu luku, joka kuvaa aineiston keskikohtaa jälkeen.
     */
    private int jalkeenMediaani;
    /**
     * Arvot ennen käsittelyä kokonaislukulistana.
     */
    private ArrayList<Integer> ennenArvot;
    /**
     * Arvot käsittelyn jälkeen kokonaislukulistana.
     */
    private ArrayList<Integer> jalkeenArvot;
    /**
     * Testisuure, joka määrittää tehtävän oikeat vastaukset.
     */
    private StudentinTTestiParittaisilleOtoksille t;

    /**
     * Konstruktori asettaa kaiken aluksi tyhjäksi. Tehtävän luonti funktio
     * antaa muuttujille arvot.
     */
    public ParittaistenOtostenTTestiTehtava() {
        super();
        this.muuttuja = 0;
        this.ryhmaManipulaatio = "";
        this.hypoteesi = "";
        this.koko = 0;
        this.ennenMediaani = 0;
        this.jalkeenMediaani = 0;
        this.ennenArvot = new ArrayList();
        this.jalkeenArvot = new ArrayList();
        this.t = new StudentinTTestiParittaisilleOtoksille();
    }

    /**
     * Luo uuden, satunnaisesti generoidun tehtävän, jonka aihe on parittaisten
     * otosten t-testi.
     */
    public final void luoUusiTehtava() {
        this.setMuuttuja(super.getRandom()
                .nextInt(super.aiheetPerusmuoto().length));
        this.setRyhmaManipulaatio(this.arvoRyhmaManipulaatio());
        this.setEnnenMediaani(this.arvoEnnenMediaani());
        this.setJalkeenMediaani(this.arvoJalkeenMediaani());
        this.setKoko(this.arvoKoko());
        this.setEnnenArvot(super.luoData(this.ennenMediaani, this.koko));
        this.setJalkeenArvot(super.luoData(this.jalkeenMediaani, this.koko));
        this.setHypoteesi(this.arvoHypoteesi());
        super.setOhje(this.luoOhjeistus());
        if (this.hypoteesi.equals("X<Y") || this.hypoteesi.equals("X>Y")) {
            this.t.laske(this.ennenArvot, this.jalkeenArvot, 1);
        } else {
            this.t.laske(this.ennenArvot, this.jalkeenArvot, 2);
        }
        super.testinValintaTehtava("Verrannollisten parien t-testi");
        this.nollaHypoteesiTehtava();
        this.vaihtoehtoinenHypoteesiTehtava();
        String ohje1 = "Valitse annetuista vaihtoehdoista "
                + "erotusten keskiarvo: ";
        String ohje2 = "Valitse annetuista vaihtoehdoista "
                + "erotusten otoskeskihajonta: ";
        String ohje3 = "Valitse annetuista vaihtoehdoista "
                + "testisuureen arvo: ";
        super.laskemisTehtava(this.t.getErotustenKa(), 5, ohje1);
        super.laskemisTehtava(this.t.getErotustenOtosKh(), 5, ohje2);
        super.laskemisTehtava(this.t.getT(), 5, ohje3);
        this.pArvoTehtava();
    }

    /**
     * Palauttaa merkkijono muuttujan sijainnin muuttuja taulukossa.
     *
     * @return Palauttaa kokonaisluvun.
     */
    public final int getMuuttuja() {
        return this.muuttuja;
    }

    /**
     * Palauttaa kokeellisen manipulaation selityksen merkkijonona.
     *
     * @return Palauttaa merkkijonon.
     */
    public final String getRyhmaManipulaatio() {
        return ryhmaManipulaatio;
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
     * Palauttaa otoksen koon.
     *
     * @return Kokonaisluku.
     */
    public final int getKoko() {
        return koko;
    }

    /**
     * Palauttaa arvojen keskikohdan ennen kokeellista manipulaatiota.
     *
     * @return Kokonaisluku.
     */
    public final int getEnnenMediaani() {
        return ennenMediaani;
    }

    /**
     * Palauttaa arvojen keskikohdan kokeellisen manipulaation jälkeen.
     *
     * @return Kokonaisluku.
     */
    public final int getJalkeenMediaani() {
        return jalkeenMediaani;
    }

    /**
     * Koehenkilöiden arvot ennen kokeellista manipulaatiota.
     *
     * @return ArrayList, jossa kokonaislukuja.
     */
    public final ArrayList<Integer> getEnnenArvot() {
        return ennenArvot;
    }

    /**
     * Koehenkilöiden arvot kokeellisten manipulaation jälkeen.
     *
     * @return ArrayList, jossa kokonaislukuja.
     */
    public final ArrayList<Integer> getJalkeenArvot() {
        return jalkeenArvot;
    }

    /**
     * Tehtävän pohjana oleva tilastollinen testi -objekti, joka sisältää
     * tehtävän oikeat vastaukset.
     *
     * @return StudentinTTestiParittaisilleOtoksille -objekti.
     */
    public final StudentinTTestiParittaisilleOtoksille getT() {
        return t;
    }

    /**
     * Luo osatehtävän, jossa määritetään testisuureen p-arvo.
     */
    public final void pArvoTehtava() {
        String[] kirjaimet
                = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<String> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add("Tulos ei ole tilastollisesti merkitsevä");
        vaihtoEhdot.add("p <0.05");
        vaihtoEhdot.add("p <0.01");
        vaihtoEhdot.add("p <0.001");

        int oikeaVastaus;
        String tehtavanOhje = "Valitse annetuista vaihtoehdoista "
                + "testisuureen p-arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + vaihtoEhdot.get(i);
        }

        if (this.hypoteesi.equals("X<Y") && this.t.getT() <= 0) {
            oikeaVastaus = 1;
        } else if (this.hypoteesi.equals("X>Y") && this.t.getT() >= 0) {
            oikeaVastaus = 1;
        } else {
            if (this.t.getpArvo().equals("ns")) {
                oikeaVastaus = 1;
            } else if (this.t.getpArvo().equals("p <0.05")) {
                oikeaVastaus = 2;
            } else if (this.t.getpArvo().equals("p < 0.01")) {
                oikeaVastaus = 3;
            } else {
                oikeaVastaus = 4;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtavan, jossa määritetään testin nollahypoteesi.
     */
    public final void nollaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Mittauksien välillä ei ole eroa.";
        String vastaus2 = "B = 2: Arvot ovat kasvaneet mittauksien välillä";
        String vastaus3 = "C = 3: Arvot ovat pienentyneet mittauksien välillä";
        String vastaus4 = "D = 4: Arvot eivät ole samat eri mittauksissa";

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
     * Luo tehtavan, jossa määritetään testin vastahypoteesi.
     */
    public final void vaihtoehtoinenHypoteesiTehtava() {

        String vastaus1 = "A = 1: Mittauksien välillä ei ole eroa.";
        String vastaus2 = "B = 2: Arvot ovat kasvaneet mittauksien välillä";
        String vastaus3 = "C = 3: Arvot ovat pienentyneet mittauksien välillä";
        String vastaus4 = "D = 4: Arvot eivät ole samat eri mittauksissa";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
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

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Arpoo tehtävälle hypoteesin: arvot joko kasvavat, pienevät, tai muuttuvat
     * suuntaan jota ei ole etukäteen määritelty.
     *
     * @return Merkkijono.
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
     * Palauttaa satunnaisen kokeellisen manipulaation.
     *
     * @return Merkkijono.
     */
    public final String arvoRyhmaManipulaatio() {
        String[] manipulaatiot = new String[]{"taideterapian",
            "neuropsykologisen kuntoutuksen", "kognitiivisen psykoterapian",
            "psykodynaamisen psykoterapian",
            "lääkityksen", "säännöllisen liikunnan", "nettiterapian",
            "humanistisen kuvataideterapian", "kristalliterapian",
            "hopeaveden juonnin", "reikihoidon", "energiahoidon",
            "homeopaattisten valmisteiden"};
        int x = super.getRandom().nextInt(manipulaatiot.length);
        return manipulaatiot[x];
    }

    /**
     * Arpoo aineiston koon.
     *
     * @return Kokonaisluku.
     */
    public final int arvoKoko() {
        int x = super.getRandom().nextInt(16) + 5;
        return x;
    }

    /**
     * Arpoo aineistolle keskikohdan ennen kokeellista manipulaatiota.
     *
     * @return Kokonaisluku.
     */
    public final int arvoEnnenMediaani() {
        int x = (super.getRandom().nextInt(10) + 1) * 5 + 50;
        return x;
    }

    /**
     * Arpoo aineistolle keskikohdan kokeellisen manipulaation jälkeen, ehtona
     * on, että se ei ole liian kaukana ennen arvojen keskikohdasta.
     *
     * @return Kokonaisluku.
     */
    public final int arvoJalkeenMediaani() {
        int x = 0;
        while (true) {
            x = super.getRandom().nextInt(super.getRandom().nextInt(10) + 1)
                    * 5 + 50;
            if (Math.abs(this.ennenMediaani - x) <= 20
                    && x != this.ennenMediaani) {
                return x;
            }
        }
    }

    /**
     * Asettaa koon otokselle.
     *
     * @param n Kokonaisluku.
     */
    public final void setKoko(final int n) {
        this.koko = n;
    }

    /**
     * Asettaa arvon manipulaation kohteena olevalle muuttujalle.
     *
     * @param x Kokonaisluku.
     */
    public final void setMuuttuja(final int x) {
        this.muuttuja = x;
    }

    /**
     * Asettaa arvon ryhmälle suoritetulle kokeelliselle manipulaatiolle.
     *
     * @param manipulaatio Merkkijono.
     */
    public final void setRyhmaManipulaatio(final String manipulaatio) {
        this.ryhmaManipulaatio = manipulaatio;
    }

    /**
     * Asettaa kokeelle hypoteesin, eli mitä manipulaation tulisi tehdä ryhmän
     * arvoille.
     *
     * @param hypoteesimme Merkkijonona.
     */
    public final void setHypoteesi(final String hypoteesimme) {
        this.hypoteesi = hypoteesimme;
    }

    /**
     * Luo tehtävälle ohjeistuksen.
     *
     * @return Merkkijono.
     */
    public final String luoOhjeistus() {
        int x = super.getRandom().nextInt(25) + 5;
        String ohjeistus = "Tutkija on kiinnostunut ";
        ohjeistus = ohjeistus + this.ryhmaManipulaatio;
        ohjeistus = ohjeistus + " vaikutuksesta ";
        ohjeistus = ohjeistus + super.aiheetTaivutus1()[this.muuttuja];
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + "Tutkittavat henkilöt mitattiin ennen "
                + "tutkimusta ja ";
        ohjeistus = ohjeistus + x + " viikkoa intervention "
                + "aloittamisen jälkeen.";
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + "Alla on esitetty arvot ennen intervention "
                + "aloittamista ja sen jälkeen.";
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + "Ennen aloittamista tutkittavien arvot "
                + "olivat seuraavat:";
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + this.vektoriMerkkiJonoksi(this.ennenArvot);
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + "Ja kokeen jälkeen arvot olivat seuraavat:";
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + this.vektoriMerkkiJonoksi(this.jalkeenArvot);
        ohjeistus = ohjeistus + System.lineSeparator();
        ohjeistus = ohjeistus + System.lineSeparator();
        if (this.hypoteesi.equals("X<Y")) {
            ohjeistus = ohjeistus + "Tutki ovatko arvot kasvaneet";
        } else if (this.hypoteesi.equals("X>Y")) {
            ohjeistus = ohjeistus + "Tutki ovatko arvot pienentyneet";
        } else if (this.hypoteesi.equals("X=/=Y")) {
            ohjeistus = ohjeistus + "Tutki ovatko arvot yhtäsuuret";
        }
        ohjeistus = ohjeistus + System.lineSeparator()
                + "Voit olettaa, että molemmat "
                + "mittaukset noudattavat normaalijakaumaa "
                + System.lineSeparator()
                + "ja ovat vähintään välimatka-asteikollisia."
                + System.lineSeparator();
        return ohjeistus;
    }

    /**
     * Asettaa aineistolle keskikohdan ennen kokeellista manipulaatiota.
     *
     * @param mediaani Kokonaisluku.
     */
    public final void setEnnenMediaani(final int mediaani) {
        this.ennenMediaani = mediaani;
    }

    /**
     * Asettaa aineistolle keskikohdan kokeellisen manipulaation jälkeen.
     *
     * @param mediaani Kokonaisluku.
     */
    public final void setJalkeenMediaani(final int mediaani) {
        this.jalkeenMediaani = mediaani;
    }

    /**
     * Asettaa aineistolle arvot ennen kokeellista manipulaatiota.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setEnnenArvot(final ArrayList<Integer> arvot) {
        this.ennenArvot = arvot;
    }

    /**
     * Asettaa aineistolle arvot kokeellisten manipulaation jälkeen.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setJalkeenArvot(final ArrayList<Integer> arvot) {
        this.jalkeenArvot = arvot;
    }

}
