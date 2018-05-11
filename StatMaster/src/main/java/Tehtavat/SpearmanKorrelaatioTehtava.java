package Tehtavat;

import TilastollisetTestit.SpearmaninKorrelaatio;
import java.util.ArrayList;

/**
 *
 * @author Oskari Koskinen
 */
public class SpearmanKorrelaatioTehtava extends Tehtava {

    /**
     * Muuttujan X numerotunniste, jolla voidaan palauttaa merkkijono selite.
     */
    private int muuttujaX;
    /**
     * Muuttujan Y numerotunniste, jolla voidaan palauttaa merkkijono selite.
     */
    private int muuttujaY;
    /**
     * Muuttujan X yksittäistet arvot kokonaisluku ArrayListinä.
     */
    private ArrayList<Integer> muuttujanXarvot;
    /**
     * Muuttujan Y yksittäistet arvot kokonaisluku ArrayListinä.
     */
    private ArrayList<Integer> muuttujanYarvot;
    /**
     * Spearmanin korrelaatio -objekti, jossa on tehtävän vastaukset.
     */
    private SpearmaninKorrelaatio rho;

    /**
     * Konstruktori luo uuden tyhjän tehtävän, jolle luoUuusiTehtävä -funktio
     * antaa arvot.
     */
    public SpearmanKorrelaatioTehtava() {
        super();
        this.muuttujaX = 0;
        this.muuttujaY = 0;
        this.muuttujanXarvot = new ArrayList();
        this.muuttujanYarvot = new ArrayList();
        this.rho = new SpearmaninKorrelaatio();
    }

    /**
     * Luo uuden tehtävän, jonka aiheena on spearmanin korrelaation laskeminen.
     */
    public final void luoUusiTehtava() {
        this.setMuuttujaX(this.arvoMuuttujaX());
        this.setMuuttujaY(this.arvoMuuttujaY());
        this.setMuuttujanXarvot(this.luoAineisto());
        this.setMuuttujanYarvot(this.luoAineisto());
        super.setOhje(this.luoOhjeistus());
        this.rho.laskeSpearman(muuttujanXarvot, muuttujanYarvot);
        String ohje1 = "Laske Spearmanin korrelaatiokertoimen arvo.";
        String ohje2 = "Laske Spearmanin korrelaatiokertoimelle t-arvo.";
        super.testinValintaTehtava("Spearmanin korrelaatio");
        super.laskemisTehtava(this.rho.getCor(), 2, ohje1);
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        super.laskemisTehtava(this.rho.getT(), 5, ohje2);
        this.pArvonLaskeminen();
    }

    /**
     * Muuttujan X numerotunniste.
     *
     * @return Kokonaisluku.
     */
    public final int getMuuttujaX() {
        return muuttujaX;
    }

    /**
     * Muuttujan Y numerotunniste.
     *
     * @return Kokonaisluku.
     */
    public final int getMuuttujaY() {
        return muuttujaY;
    }

    /**
     * Muuttujan X arvot kokonaislukulistana.
     *
     * @return ArrayList, jossa kokonaislukuja.
     */
    public final ArrayList<Integer> getMuuttujanXarvot() {
        return muuttujanXarvot;
    }

    /**
     * Muuttujan Y arvot kokonaislukulistana.
     *
     * @return ArrayList, jossa kokonaislukuja.
     */
    public final ArrayList<Integer> getMuuttujanYarvot() {
        return muuttujanYarvot;
    }

    /**
     * Spearmanin korrelaatio, josta löytyy tehtävän oikeat vastaukset.
     *
     * @return SpearmanKorrelaatio -objekti.
     */
    public final SpearmaninKorrelaatio getRho() {
        return rho;
    }

    /**
     * Asettaa muuttujan X numerotunnisteen.
     *
     * @param x Kokonaisluku.
     */
    public final void setMuuttujaX(final int x) {
        this.muuttujaX = x;
    }

    /**
     * Asettaa muuttujan Y numerotunnisteen.
     *
     * @param y Kokonaisluku.
     */
    public final void setMuuttujaY(final int y) {
        this.muuttujaY = y;
    }

    /**
     * Asettaa muuttujan X arvot. Muuttujalla X on oltava sama määrä arvoja kuin
     * muuttujalla Y.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setMuuttujanXarvot(final ArrayList<Integer> arvot) {
        this.muuttujanXarvot = arvot;
    }

    /**
     * Asettaa muuttujan Y arvot. Muuttujalla Y on oltava sama määrä arvoja kuin
     * muuttujalla X.
     *
     * @param arvot ArrayList, jossa kokonaislukuja.
     */
    public final void setMuuttujanYarvot(final ArrayList<Integer> arvot) {
        this.muuttujanYarvot = arvot;
    }

    /**
     * Luo satunnaisen aineiston tehtävää varten.
     *
     * @return Palauttaa aineiston ArrayListinä, jossa on kokonaislukuja.
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
     * Arpoo numerotunnisteen muuttujalle X.
     *
     * @return Kokonaisluku.
     */
    public final int arvoMuuttujaX() {
        int x = super.getRandom().nextInt(super.aiheetPerusmuoto().length);
        return x;
    }

    /**
     * Arpoo numerotunnisteen muuttujalle Y. Ehtona on, että tunniste ei ole
     * sama kuin muuttujan X tunniste.
     *
     * @return Kokonaisluvun.
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
     * @return Merkkijono.
     */
    public final String luoOhjeistus() {

        String tehtavanOhje = "Tutkija on kiinnostunut ";
        tehtavanOhje = tehtavanOhje + super.aiheetTaivutus2()[this.muuttujaX];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "ja ";
        tehtavanOhje = tehtavanOhje + super.aiheetTaivutus2()[this.muuttujaY];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "välisen yhteyden voimakkuudesta.";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Muuttujalla "
                + super.aiheetPerusmuoto()[this.muuttujaX];
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
        tehtavanOhje = tehtavanOhje
                + "Oleta, että muuttujien välinen yhteys ei ole lineaarinen";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Tutki yhteyden vahvuutta.";

        return tehtavanOhje;
    }

    /**
     * Luo osatehtävän, jossa määritetään tehtävän nollahypoteesi.
     */
    public final void nollaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Muuttujien välillä ei ole yhteyttä.";
        String vastaus2 = "B = 2: Muuttujien välillä on yhteys.";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo osatehtävän, jossa määritetään tehtävän vastahypoteesi.
     */
    public final void vastaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Muuttujien välillä ei ole yhteyttä.";
        String vastaus2 = "B = 2: Muuttujien välillä on yhteys.";

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

        int vastaus;

        if (this.rho.getpArvo().equals("ns")) {
            vastaus = 1;
        } else if (this.rho.getpArvo().equals("p <0.05")) {
            vastaus = 2;
        } else if (this.rho.getpArvo().equals("p <0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

}
