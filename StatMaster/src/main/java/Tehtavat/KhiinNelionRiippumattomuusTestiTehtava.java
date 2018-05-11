package Tehtavat;

import TilastollisetTestit.KhiinNelionRiippumattomuusTesti;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Tällä luokalla voi luoda tehtäviä, joilla harjoitellaan khiin neliön
 * riippumattomuustestin laskemista.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusTestiTehtava extends Tehtava {

    /**
     * Tehtävässä tutkitaan kahden ristiintaulukoidun muuttujan yhteyttä. Tämä
     * muuttuja määrittää rivillä olevan aiheen.
     */
    private int riviMuuttujaAihe;
    /**
     * Riveillä olevan muuttujan mista-asteikko.
     */
    private String[] riviAsteikko;
    /**
     * Tehtävässä tutkitaan kahden ristiintaulukoidun muuttujan yhteyttä. Tämä
     * muuttuja määrittää sarakkeilla olevan aiheen.
     */
    private int sarakeMuuttujatAihe;
    /**
     * Sarakkeilla olevan muuttujan mitta-asteikko.
     */
    private String[] sarakeAsteikko;
    /**
     * Taulukko, johon tulee tehtävän aineisto.
     */
    private int[][] dataTaulukko;
    /**
     * Laskutoimitukset tehtävään oikeita vastauksia varten.
     */
    private KhiinNelionRiippumattomuusTesti khii;

    /**
     * Konstruktori asettaa luokan parametrit tyhjiksi. Vasta tehtävän
     * luomiskomenta antaa niille arvot.
     */
    public KhiinNelionRiippumattomuusTestiTehtava() {
        super();
        this.riviMuuttujaAihe = 0;
        this.riviAsteikko = new String[0];
        this.sarakeMuuttujatAihe = 0;
        this.sarakeAsteikko = new String[0];
        this.dataTaulukko = new int[0][0];
        this.khii = new KhiinNelionRiippumattomuusTesti();
    }

    /**
     * Luo uuden tehtävän, jossa määritetään oikea menetelmä, hypoteesit,
     * lasketaaan testisuure ja tulkitaan tuloksen merkitsevyys.
     */
    public final void luoUusiTehtava() {

        this.setRiviMuuttujaAihe(this.arvoRivinAihe());
        this.setSarakeMuuttujatAihe(this.arvoSarakkeenAihe());
        this.setRiviAsteikko(super.arvoAsteikkoVektori1());
        this.setSarakeAsteikko(super.arvoAsteikkoVektori1());
        this.setDataTaulukko(this.arvoDataTaulu());
        this.luoOhjeistus();
        this.khii.laske(this.dataTaulukko);
        super.testinValintaTehtava("Khiin neliön riippumattomuustesti");
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        this.khiinNelioTehtava();
        this.pArvoTehtava();
    }

    /**
     * Palauttaa rivimuuttujan aiheen numeron.
     *
     * @return Palauttaa int -muuttujan.
     */
    public final int getRiviMuuttujaAihe() {
        return riviMuuttujaAihe;
    }

    /**
     * Palauttaa rivimuuttujan aiheen mitta-asteikon.
     *
     * @return Palauttaa int-taulukko -muuttujan.
     */
    public final String[] getRiviAsteikko() {
        return riviAsteikko;
    }

    /**
     * Palauttaa sarakemuuttujan aiheen numeron.
     *
     * @return Palauttaa int -muuttujan.
     */
    public final int getSarakeMuuttujatAihe() {
        return sarakeMuuttujatAihe;
    }

    /**
     * Palauttaa sarakemuuttujan aiheen mitta-asteikon.
     *
     * @return Palauttaa int-taulukko -muuttujan.
     */
    public final String[] getSarakeAsteikko() {
        return sarakeAsteikko;
    }

    /**
     * Palauttaa taulukon, jossa on tehtävän aineisto.
     *
     * @return Palauttaa kaksiulotteisen int-muuttuja taulukon.
     */
    public final int[][] getDataTaulukko() {
        return dataTaulukko;
    }

    /**
     * Palauttaa testin tulokset, eli tehtävän oikeat vastaukset saadaan täältä.
     *
     * @return Palauttaa KhiinNelionRiippumattomuusTesti -objektin.
     */
    public final KhiinNelionRiippumattomuusTesti getKhii() {
        return khii;
    }

    /**
     * Luo tehtävään osatehtävän, jossa määritetään nollahypoteesi.
     */
    public final void nollaHypoteesiTehtava() {
        String vastaus1
                = "A = 1: Luokkien frekvenssit ovat "
                + "toisistaan riippumattomia.";
        String vastaus2
                = "B = 2: Luokkien frekvenssit eivät ole "
                + "toisistaan riippumattomia";
        String vastaus3 = "Luokkien frekvenssit kasvavat lineaarisesti";
        String vastaus4 = "Luokkien frekvenssit vähenevät lineaarisesti";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4;

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävään osatehtävän, jossa määritetään vastahypoteesi.
     */
    public final void vastaHypoteesiTehtava() {
        String vastaus1
                = "A = 1: Luokkien frekvenssit "
                + "ovat toisistaan riippumattomia.";
        String vastaus2
                = "B = 2: Luokkien frekvenssit "
                + "eivät ole toisistaan riippumattomia";
        String vastaus3 = "Luokkien frekvenssit kasvavat lineaarisesti";
        String vastaus4 = "Luokkien frekvenssit vähenevät lineaarisesti";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4;

        OsaTehtava tehtava = new OsaTehtava(2, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävään osatehtävän, jossa lasketaan khiin neliö.
     */
    public final void khiinNelioTehtava() {
        String[] kirjaimet
                = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<Double> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add(this.khii.getKhiinNelio());
        vaihtoEhdot.add(super.getKaavat().pyoristaKahteenDesimaaliin(
                this.khii.getKhiinNelio()
                        - 10 * super.getRandom().nextDouble()));
        vaihtoEhdot.add(super.getKaavat().pyoristaKahteenDesimaaliin(
                this.khii.getKhiinNelio()
                        + 10 * super.getRandom().nextDouble()));
        vaihtoEhdot.add(super.getKaavat().pyoristaKahteenDesimaaliin(
                this.khii.getKhiinNelio()
                        - 10 * super.getRandom().nextDouble()));

        Collections.shuffle(vaihtoEhdot);
        int oikeaVastaus = 1;
        String tehtavanOhje
                = "Valitse annetuista vaihtoehdoista testisuureen arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == this.khii.getKhiinNelio()) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }
        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävään osatehtävän, jossa määritetään testisuureen p-arvo.
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
        String tehtavanOhje
                = "Valitse annetuista vaihtoehdoista testisuureen p-arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + vaihtoEhdot.get(i);
        }

        if (this.khii.getpArvo().equals("ns")) {
            oikeaVastaus = 1;
        } else if (this.khii.getpArvo().equals("p <0.05")) {
            oikeaVastaus = 2;
        } else if (this.khii.getpArvo().equals("p < 0.01")) {
            oikeaVastaus = 3;
        } else {
            oikeaVastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo tehtävälle ohjeistuksen.
     */
    public final void luoOhjeistus() {
        String tehtavanOhje;
        tehtavanOhje = "Tutkija on kiinnostunut "
                + super.aiheetTaivutus2()[this.riviMuuttujaAihe];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "ja "
                + super.aiheetTaivutus2()[this.sarakeMuuttujatAihe];
        tehtavanOhje = tehtavanOhje + " välisestä yhteydestä";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Alla olevassa taulukossa riveillä on ";
        tehtavanOhje = tehtavanOhje
                + super.aiheetTaivutus2()[this.riviMuuttujaAihe] + " arvot,";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "jotka ovat ylhäältä alas: ";
        tehtavanOhje = tehtavanOhje + this.tulostaAsteikko(this.riviAsteikko);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Alla olevassa taulukossa sarakkeissa on ";
        tehtavanOhje = tehtavanOhje
                + super.aiheetTaivutus2()[this.sarakeMuuttujatAihe]
                + " arvot,";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "jotka ovat vasemmalta oikealle: ";
        tehtavanOhje = tehtavanOhje
                + this.tulostaAsteikko(this.sarakeAsteikko);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Havainnot on esitetty seuraavassa taulukossa";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + this.dataTauluMerkkiJonoksi();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Testaa onko tutkittavien "
                + "luokkiin jakautuminen satunnaista.";
        super.setOhje(tehtavanOhje);
    }

    /**
     * Muuttaa datataulun kauniiksi merkkijonoksi.
     *
     * @return Palauttaa Stringin.
     */
    public final String dataTauluMerkkiJonoksi() {
        String data = "";

        for (int i = 0; i < this.riviAsteikko.length; i++) {
            for (int j = 0; j < this.sarakeAsteikko.length; j++) {
                if (this.dataTaulukko[i][j] < 10) {
                    data = data + "   " + dataTaulukko[i][j];
                } else if (this.dataTaulukko[i][j] >= 10
                        && this.dataTaulukko[i][j] < 100) {
                    data = data + "  " + this.dataTaulukko[i][j];
                } else {
                    data = data + " " + this.dataTaulukko[i][j];
                }
            }
            data = data + System.lineSeparator();
        }
        return data;
    }

    /**
     * Luo satunnaisen kaksiulotteisen taulukon tehtävän laskemista varten.
     *
     * @return Palauttaa kaksiulotteisen int -muuttuja taulukon.
     */
    public final int[][] arvoDataTaulu() {
        int[][] taulu
                = new int[this.riviAsteikko.length][this.sarakeAsteikko.length];
        for (int i = 0; i < this.riviAsteikko.length; i++) {
            for (int j = 0; j < this.sarakeAsteikko.length; j++) {
                taulu[i][j] = super.getRandom().nextInt(101);
            }
        }
        return taulu;
    }

    /**
     * Arpoo kokonaisluvun, joka kuvaa rivimuuttujan aihetta.
     *
     * @return Palauttaa int -muuttujan.
     */
    public final int arvoRivinAihe() {
        return super.getRandom().nextInt(super.aiheetPerusmuoto().length);
    }

    /**
     * Arpoo kokonaisluvun, joka kuvaa sarakemuuttujan aihetta.
     *
     * @return Palauttaa int -muuttujan.
     */
    public final int arvoSarakkeenAihe() {
        while (true) {
            int aihe = super.getRandom()
                    .nextInt(super.aiheetPerusmuoto().length);
            if (aihe != this.riviMuuttujaAihe) {
                return aihe;
            }
        }
    }

    /**
     * Asettaa rivimuuttujan aiheen.
     *
     * @param aihe Kokonaisluku.
     */
    public final void setRiviMuuttujaAihe(final int aihe) {
        this.riviMuuttujaAihe = aihe;
    }

    /**
     * Asettaa rivimuuttujan mitta-asteikon.
     *
     * @param asteikko Merkkijono taulukko.
     */
    public final void setRiviAsteikko(final String[] asteikko) {
        this.riviAsteikko = asteikko;
    }

    /**
     * Asettaa sarakemuuttujan aiheen.
     *
     * @param aihe Kokonaisluku.
     */
    public final void setSarakeMuuttujatAihe(final int aihe) {
        this.sarakeMuuttujatAihe = aihe;
    }

    /**
     * Asettaa sarakeMuuttujan mitta-asteikon.
     *
     * @param asteikko Merkkijono taulukko.
     */
    public final void setSarakeAsteikko(final String[] asteikko) {
        this.sarakeAsteikko = asteikko;
    }

    /**
     * Asettaa tehtävän dataksi annetun taulukon.
     *
     * @param taulukko Kaksiulotteinen kokonaislukutaulukko.
     */
    public final void setDataTaulukko(final int[][] taulukko) {
        this.dataTaulukko = taulukko;
    }

}
