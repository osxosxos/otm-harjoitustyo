package Tehtavat;

import TilastollisetTestit.PearsonKorrelaatio;
import java.util.ArrayList;

/**
 * Tämä luokka kuvaa tehtävää, jonka tarkoitus on laskea Pearsonin korrelaatio
 * kerroin. Tehtävä koostuu useista osatehtävistä. Luokka on luokan tehtävä
 * erikoistapaus.
 *
 * @author Oskari Koskinen
 */
public class PearsonKorrelaatioTehtava extends Tehtava {

    /**
     * Muuttujan X selitteen sijainti merkkijonotaulukossa.
     */
    private int muuttujaX;
    /**
     * Muuttujan Y selitteen sijainti merkkijonotaulukossa.
     */
    private int muuttujaY;
    /**
     * Muuttujan X arvot kokonaislukuina.
     */
    private ArrayList<Integer> muuttujanXarvot;
    /**
     * Muuttujan Y arvot kokonaislukuina.
     */
    private ArrayList<Integer> muuttujanYarvot;
    /**
     * Muuttujien X ja Y välinen pearsonin korrelaatio.
     */
    private PearsonKorrelaatio r;

    /**
     * Konstruktori luo tyhjän tehtävän. Tehtävä saa arvot uuden tehtävän luomis
     * metodia kutsuttaessa.
     */
    public PearsonKorrelaatioTehtava() {
        super();
        this.muuttujaX = 0;
        this.muuttujaY = 0;
        this.muuttujanXarvot = new ArrayList();
        this.muuttujanYarvot = new ArrayList();
        this.r = new PearsonKorrelaatio();
    }

    /**
     * Luo uuden tehtävän, jonka aiheena on pearsonin korrelaation laskeminen.
     */
    public final void luoUusiTehtava() {
        this.setMuuttujaX(this.arvoMuuttujaX());
        this.setMuuttujaY(this.arvoMuuttujaY());
        this.setMuuttujanXarvot(this.luoAineisto());
        this.setMuuttujanYarvot(this.luoAineisto());
        super.setOhje(this.luoOhjeistus());
        this.r.laske(muuttujanXarvot, muuttujanYarvot);
        String ohje1 = "Laske Pearsonin korrelaatiokertoimen arvo.";
        String ohje2 = "Laske Pearsonin korrelaatiokertoimelle t-arvo.";
        super.testinValintaTehtava("Pearsonin korrelaatio");
        super.laskemisTehtava(this.r.getCor(), 2, ohje1);
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        super.laskemisTehtava(this.r.getT(), 5, ohje2);
        this.pArvonLaskeminen();
    }

    /**
     * Palauttaa muuttujan X selitteen numerotunnuksen.
     *
     * @return Kokonaisluku.
     */
    public final int getMuuttujaX() {
        return muuttujaX;
    }

    /**
     * Palauttaa muuttujan Y selitteen numerotunnuksen.
     *
     * @return Kokonaisluku.
     */
    public final int getMuuttujaY() {
        return muuttujaY;
    }

    /**
     * Palauttaa muuttujan X arvot listana.
     *
     * @return Kokonaisluku ArrayList.
     */
    public final ArrayList<Integer> getMuuttujanXarvot() {
        return muuttujanXarvot;
    }

    /**
     * Palauttaa muuttujan Y arvot listana.
     *
     * @return KokonaisLukuArrayList.
     */
    public final ArrayList<Integer> getMuuttujanYarvot() {
        return muuttujanYarvot;
    }

    /**
     * Palauttaa Pearsonin korrelaatio -objektin, jossa on tehtavan vastaukset.
     *
     * @return PearsonKorrelaatio -objekti.
     */
    public final PearsonKorrelaatio getR() {
        return r;
    }

    /**
     * Asettaa muuttujalle X numerotunnisteen, jolla merkkijonoselite löytyy
     * taulukosta.
     *
     * @param x Kokonaisluku.
     */
    public final void setMuuttujaX(final int x) {
        this.muuttujaX = x;
    }

    /**
     * Asettaa muuttujalle Y numerotunnisteen, jolla merkkijonoselite löytyy
     * taulukosta.
     *
     * @param y Kokonaisluku.
     */
    public final void setMuuttujaY(final int y) {
        this.muuttujaY = y;
    }

    /**
     * Asettaa muuttujalle X listan numeroarvoja.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setMuuttujanXarvot(final ArrayList<Integer> arvot) {
        this.muuttujanXarvot = arvot;
    }

    /**
     * Asettaa muuttujalle Y listan numeroarvoja.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setMuuttujanYarvot(final ArrayList<Integer> arvot) {
        this.muuttujanYarvot = arvot;
    }

    /**
     * Luo tehtävälle satunnaisen aineiston.
     *
     * @return Palauttaa ArrayListin, jossa on kokonaislukuja.
     */
    public final ArrayList luoAineisto() {
        int mediaani = (super.getRandom().nextInt(10) + 1) * 10;
        int koko;

        if (this.muuttujanXarvot.size() != 0) {
            koko = this.muuttujanXarvot.size();
        } else {
            koko = super.getRandom().nextInt(21);
        }

        while (koko < 5) {
            koko = super.getRandom().nextInt(21);
        }

        ArrayList<Integer> vektori = super.luoData(mediaani, koko);
        return vektori;
    }

    /**
     * Arpoo muuttujalle x numerotunnisteen, jolla muuttujan merkkijono selite
     * saadaan taulukosta.
     *
     * @return Kokonaisluku.
     */
    public final int arvoMuuttujaX() {
        int x = super.getRandom().nextInt(super.aiheetPerusmuoto().length);
        return x;
    }

    /**
     * Arpoo muuttujalle Y numerotunnisteen, joka ei ole sama kuin muuttujan X
     * numerotunniste.
     *
     * @return Kokonaisluku.
     */
    public final int arvoMuuttujaY() {
        int y = super.getRandom().nextInt(super.aiheetPerusmuoto().length);
        while (true) {
            y = super.getRandom().nextInt(super.aiheetPerusmuoto().length);
            if (y != this.muuttujaX) {
                break;
            }
        }
        return y;
    }

    /**
     * Luo ohjeen korrelaation laskemistehtävälle.
     *
     * @return Kokonaisluku.
     */
    public final String luoOhjeistus() {

        String tehtavanOhje = "Tutkija on kiinnostunut ";
        tehtavanOhje = tehtavanOhje + super.aiheetTaivutus2()[this.muuttujaX];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "ja ";
        tehtavanOhje = tehtavanOhje + super.aiheetTaivutus2()[this.muuttujaY];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "välisen lineaarisen yhteyden voimakkuudesta.";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Muuttujalla " + super.aiheetPerusmuoto()[this.muuttujaX];
        tehtavanOhje = tehtavanOhje + " on seuraavat arvot:";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + super.vektoriMerkkiJonoksi(this.muuttujanXarvot);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Muuttujalla " + super.aiheetPerusmuoto()[this.muuttujaY];
        tehtavanOhje = tehtavanOhje + " on seuraavat arvot:";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + super.vektoriMerkkiJonoksi(this.muuttujanYarvot);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Tutki lineaarisen yhteyden vahvuutta.";

        return tehtavanOhje;
    }

    /**
     * Luo tehtävälle osatehtävän, jossa määritetään nollahypoteesi.
     */
    public final void nollaHypoteesiTehtava() {
        String vastaus1
                = "A = 1: Muuttujien välillä ei ole lineaarista yhteyttä.";
        String vastaus2
                = "B = 2: Muuttujien välillä on lineaarinen yhteys.";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävälle osatehtavan, jossa määritetään tehtävälle vastahypoteesi.
     */
    public final void vastaHypoteesiTehtava() {
        String vastaus1
                = "A = 1: Muuttujien välillä ei ole lineaarista yhteyttä.";
        String vastaus2
                = "B = 2: Muuttujien välillä on lineaarinen yhteys.";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(2, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Riskitason määrittäminen korrelaatiosta lasketulle p-arvolle.
     */
    public final void pArvonLaskeminen() {
        String tehtavanOhje = "Määritä testisuureen p-arvo"
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

        if (this.r.getpArvo().equals("ns")) {
            vastaus = 1;
        } else if (this.r.getpArvo().equals("p <0.05")) {
            vastaus = 2;
        } else if (this.r.getpArvo().equals("p <0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

}
