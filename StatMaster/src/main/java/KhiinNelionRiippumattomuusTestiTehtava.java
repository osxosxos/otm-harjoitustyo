
import java.util.ArrayList;
import java.util.Collections;

/**
 * Tällä luokalla voi luoda tehtäviä, joilla harjoitellaan khiin neliön
 * riippumattomuustestin laskemista.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusTestiTehtava extends Tehtava {

    int riviMuuttujaAihe;
    String[] riviAsteikko;
    int sarakeMuuttujatAihe;
    String[] sarakeAsteikko;
    int[][] dataTaulukko;
    KhiinNelionRiippumattomuusTesti khii;

    public KhiinNelionRiippumattomuusTestiTehtava() {
        super();
        this.riviMuuttujaAihe = 0;
        this.riviAsteikko = new String[0];
        this.sarakeMuuttujatAihe = 0;
        this.sarakeAsteikko = new String[0];
        this.dataTaulukko = new int[0][0];
        this.khii = new KhiinNelionRiippumattomuusTesti();
    }

    public void luoUusiTehtava() {
        
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

    public void nollaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Luokkien frekvenssit ovat toisistaan riippumattomia.";
        String vastaus2 = "B = 2: Luokkien frekvenssit eivät ole toisistaan riippumattomia";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void vastaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Luokkien frekvenssit ovat toisistaan riippumattomia.";
        String vastaus2 = "B = 2: Luokkien frekvenssit eivät ole toisistaan riippumattomia";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(2, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void khiinNelioTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<Double> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add(this.khii.khiinNelio);
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.khii.khiinNelio - 10 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.khii.khiinNelio + 10 * random.nextDouble()));
        vaihtoEhdot.add(kaavat.pyoristaKahteenDesimaaliin(this.khii.khiinNelio - 10 * random.nextDouble()));

        Collections.shuffle(vaihtoEhdot);
        int oikeaVastaus = 1;
        String tehtavanOhje = "Valitse annetuista vaihtoehdoista testisuureen arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + vaihtoEhdot.get(i);
            if (vaihtoEhdot.get(i) == this.khii.khiinNelio) {
                oikeaVastaus = oikeaVastaus + i;
            }
        }
        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void pArvoTehtava() {
        String[] kirjaimet = new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
        ArrayList<String> vaihtoEhdot = new ArrayList();

        vaihtoEhdot.add("Tulos ei ole tilastollisesti merkitsevä");
        vaihtoEhdot.add("p <0.05");
        vaihtoEhdot.add("p <0.01");
        vaihtoEhdot.add("p <0.001");

        int oikeaVastaus;
        String tehtavanOhje = "Valitse annetuista vaihtoehdoista testisuureen p-arvo: ";

        for (int i = 0; i < vaihtoEhdot.size(); i++) {
            tehtavanOhje = tehtavanOhje + System.lineSeparator();
            tehtavanOhje = tehtavanOhje + kirjaimet[i] + vaihtoEhdot.get(i);
        }

        if (this.khii.pArvo.equals("ns")) {
            oikeaVastaus = 1;
        } else if (this.khii.pArvo.equals("p <0.05")) {
            oikeaVastaus = 2;
        } else if (this.khii.pArvo.equals("p < 0.01")) {
            oikeaVastaus = 3;
        } else {
            oikeaVastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void luoOhjeistus() {
        String tehtavanOhje;
        tehtavanOhje = "Tutkija on kiinnostunut " + super.aiheetTaivutus2()[this.riviMuuttujaAihe];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "ja " + super.aiheetTaivutus2()[this.sarakeMuuttujatAihe];
        tehtavanOhje = tehtavanOhje + " välisestä yhteydestä";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Alla olevassa taulukossa riveillä on ";
        tehtavanOhje = tehtavanOhje + super.aiheetTaivutus2()[this.riviMuuttujaAihe] + " arvot,";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "jotka ovat ylhäältä alas: ";
        tehtavanOhje = tehtavanOhje + this.tulostaAsteikko(this.riviAsteikko);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Alla olevassa taulukossa sarakkeissa on ";
        tehtavanOhje = tehtavanOhje + super.aiheetTaivutus2()[this.sarakeMuuttujatAihe] + " arvot,";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "jotka ovat vasemmalta oikealle: ";
        tehtavanOhje = tehtavanOhje + this.tulostaAsteikko(this.sarakeAsteikko);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Havainnot on esitetty seuraavassa taulukossa";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + this.dataTauluMerkkiJonoksi();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Testaa onko tutkittavien luokkiin jakautuminen satunnaista.";
        super.ohje = tehtavanOhje;
    }

    /**
     * Muuttaa datataulun kauniiksi merkkijonoksi.
     *
     * @return Palauttaa Stringin.
     */
    public String dataTauluMerkkiJonoksi() {
        String data = "";
        
        for (int i = 0; i < this.riviAsteikko.length; i++) {
            for (int j = 0; j < this.sarakeAsteikko.length; j++) {
                if (this.dataTaulukko[i][j] < 10) {
                    data = data + "   " + dataTaulukko[i][j];
                } else if (this.dataTaulukko[i][j] >= 10 && this.dataTaulukko[i][j] < 100) {
                    data = data + "  " + this.dataTaulukko[i][j];
                } else {
                    data = data + " " + this.dataTaulukko[i][j];
                }
            }
            data = data + System.lineSeparator();
        }
        return data;
    }

    public int[][] arvoDataTaulu() {
        int[][] taulu = new int[this.riviAsteikko.length][this.sarakeAsteikko.length];
        for (int i = 0; i < this.riviAsteikko.length; i++) {
            for (int j = 0; j < this.sarakeAsteikko.length; j++) {
                taulu[i][j] = random.nextInt(101);
            }
        }
        return taulu;
    }

    public int arvoRivinAihe() {
        return super.random.nextInt(super.aiheetPerusmuoto().length);
    }

    public int arvoSarakkeenAihe() { 
        while (true) {
            int aihe = super.random.nextInt(super.aiheetPerusmuoto().length);
            if (aihe != this.riviMuuttujaAihe) {
                return aihe;
            }
        }
    }

    public void setRiviMuuttujaAihe(int riviMuuttujaAihe) {
        this.riviMuuttujaAihe = riviMuuttujaAihe;
    }

    public void setRiviAsteikko(String[] riviAsteikko) {
        this.riviAsteikko = riviAsteikko;
    }

    public void setSarakeMuuttujatAihe(int sarakeMuuttujatAihe) {
        this.sarakeMuuttujatAihe = sarakeMuuttujatAihe;
    }

    public void setSarakeAsteikko(String[] sarakeAsteikko) {
        this.sarakeAsteikko = sarakeAsteikko;
    }

    public void setDataTaulukko(int[][] dataTaulukko) {
        this.dataTaulukko = dataTaulukko;
    }

}
