package Tehtavat;

import TilastollisetTestit.KhiinNelionYhteenSopivuusTesti;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Khiin nelion yhteensopivuustestiin liittyvän tehtävän rakentava luokka, joka
 * on Tehtava -luokan erikoistapaus.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionYhteenSopivuusTestiTehtava extends Tehtava {

    /**
     * Tehtävän aineiston koko.
     */
    private int n;
    /**
     * Havaittu data.
     */
    private int[] havaitutFrekvenssit;
    /**
     * Teoreettinen data, johon havaittua dataa verrataan.
     */
    private int[] teoreettisetFrekvenssit;
    /**
     * Muuttuja tai ilmiö, jonka arvoista ollaan kiinnostuneita.
     */
    private int riippumatonMuuttuja;
    /**
     * Muuttujan arvojen mitta-asteikko.
     */
    private String[] asteikko;
    /**
     * Testi, josta löytyy tehtävän oikeat ratkaisut.
     */
    private KhiinNelionYhteenSopivuusTesti khii;

    /**
     * Konstruktori asettaa tehtävän arvot aluksi tyhjiksi. Tehtävän
     * luomismetodi antaa niille arvot.
     */
    public KhiinNelionYhteenSopivuusTestiTehtava() {
        super();
        this.n = 0;
        this.havaitutFrekvenssit = new int[0];
        this.teoreettisetFrekvenssit = new int[0];
        this.riippumatonMuuttuja = 0;
        this.asteikko = new String[0];
        this.khii = new KhiinNelionYhteenSopivuusTesti();
    }

    /**
     * Luo uuden tehtävän - jonka aiheena on khiin neliön yhteensopivuustesti -
     * ja sen osatehtävät.
     */
    public final void luoUusiTehtava() {
        this.setAsteikko(super.arvoAsteikkoVektori1());
        this.setN(this.arvoOtoksenKoko());
        this.setHavaitutFrekvenssit(this.luoData());
        this.setTeoreettisetFrekvenssit(this.luoData());
        final int pituus = super.aiheetPerusmuoto().length;
        this.setRiippumatonMuuttuja(super.getRandom().nextInt(pituus));
        this.khii.laske(havaitutFrekvenssit, teoreettisetFrekvenssit);
        this.setOhjeistus();
        super.testinValintaTehtava("Khiin neliön yhteensopivuustesti");
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        this.khiinNelioTehtava();
        this.pArvoTehtava();
    }

    /**
     * Palauttaa aineiston koon.
     *
     * @return Kokonaisluku.
     */
    public final int getN() {
        return n;
    }

    /**
     * Palauttaa havaitun aineiston.
     *
     * @return Kokonaisluku taulukko.
     */
    public final int[] getHavaitutFrekvenssit() {
        return havaitutFrekvenssit;
    }

    /**
     * Palauttaa teoreettisen aineiston, johon havaittua aineistoa verrataan.
     *
     * @return Kokonaisluku taulukko.
     */
    public final int[] getTeoreettisetFrekvenssit() {
        return teoreettisetFrekvenssit;
    }

    /**
     * Palautaa riippumattoman muuttujan, eli muuttujan jonka arvoista ollaan
     * kiinnostuneita.
     *
     * @return Kokonaisluku.
     */
    public final int getRiippumatonMuuttuja() {
        return riippumatonMuuttuja;
    }

    /**
     * Palauttaa riippumattoman muuttujan mitta-asteikon.
     *
     * @return Merkkijono taulukko.
     */
    public final String[] getAsteikko() {
        return asteikko;
    }

    /**
     * Palauttaa lasketun testin, josta löytyy tehtävän vastaukset.
     *
     * @return KhiinNelionYhteenSopivuusTesti.
     */
    public final KhiinNelionYhteenSopivuusTesti getKhii() {
        return khii;
    }

    /**
     * Asettaa tehtävälle ohjeistuksen, muuten sitä ei voi ratkaista.
     */
    public final void setOhjeistus() {
        String tehtavanOhje = "Tutkija oli kiinnostunut "
                + super.aiheetTaivutus2()[this.riippumatonMuuttuja];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "erisuuruisten arvojen jakautumisesta perusjoukossa.";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Aikaisemmassa tutkimuksessa "
                + super.aiheetTaivutus2()[this.riippumatonMuuttuja];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "arvoja mitattiin seuraavista "
                + "arvoista koostuvalla asteikolla";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + super.tulostaAsteikko(this.asteikko);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Aikaisemmassa tutkimuksessa havainnot jakautuivat yllä "
                + "esitettyihn luokkiin seuraavasti: ";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + super.tulostaArvot(this.teoreettisetFrekvenssit);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Uudessa tutkimuksessa käytettiin "
                + "samaa luokittelua ja saatiin seuraava tulos:";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + super.tulostaArvot(this.havaitutFrekvenssit);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje
                + "Tutki poikkeavatko uudessa tutkimuksessa "
                + "havaitut frekvenssit aikaisemmin havaituista.";
        super.setOhje(tehtavanOhje);
    }

    /**
     * Luo osatehtävän, jossa määritetään testin nollahypoteesi.
     */
    public final void nollaHypoteesiTehtava() {
        String vastaus1
                = "A = 1: Havaitut ja odotetut frekvenssit "
                + "eivät poikkea toisistaan.";
        String vastaus2 = "B = 2: Havaitut ja odotetut frekvenssit"
                + " poikkeavat toisistaan";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo osatehtävän, jossa määritetään testin vastahypoteesi.
     */
    public final void vastaHypoteesiTehtava() {
        String vastaus1
                = "A = 1: Havaitut ja odotetut frekvenssit "
                + "eivät poikkea toisistaan.";
        String vastaus2
                = "B = 2: Havaitut ja odotetut frekvenssit "
                + "poikkeavat toisistaan";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(2, tehtavanOhje);
        super.getOsaTehtavat().add(tehtava);
    }

    /**
     * Luo osatehtävän, jossa lasketaan khiin neliö.
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
                this.khii.getKhiinNelio())
                        + 10 * super.getRandom().nextDouble());
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
     * Luo osatehtävän, jossa määritetään khiin neliön testin p-arvo.
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
     * Asettaa arvon riippumattomalle muuttujalle.
     *
     * @param muuttuja Kokonaisluku.
     */
    public final void setRiippumatonMuuttuja(final int muuttuja) {
        this.riippumatonMuuttuja = muuttuja;
    }

    /**
     * Asettaa arvot havaituille frekvensseille.
     *
     * @param frekvenssit Kokonaislukutaulukko.
     */
    public final void setHavaitutFrekvenssit(final int[] frekvenssit) {
        this.havaitutFrekvenssit = frekvenssit;
    }

    /**
     * Asettaa arvot teoreettisille frekvensseille.
     *
     * @param frekvenssit Kokonaislukutaulukko.
     */
    public final void setTeoreettisetFrekvenssit(final int[] frekvenssit) {
        this.teoreettisetFrekvenssit = frekvenssit;
    }

    /**
     * Asettaa arvon otoksen koolle.
     *
     * @param koko Kokonaisluku.
     */
    public final void setN(final int koko) {
        this.n = koko;
    }

    /**
     * Asettaa tehtävän mitta-asteikon.
     *
     * @param mittaAsteikko Merkkijonotaulukko.
     */
    public final void setAsteikko(final String[] mittaAsteikko) {
        this.asteikko = mittaAsteikko;
    }

    /**
     * Arpoo satunnaisen luvun väliltä 500-5000.
     *
     * @return Palauttaa kokonaislukumuuttujan.
     */
    public final int arvoOtoksenKoko() {
        int otosKoko = 500 + super.getRandom().nextInt(4501);
        return otosKoko;
    }

    /**
     * Luo satunnaisen datan, joka noudattaa jotain satunnaista jakaumaa.
     *
     * @return palauttaa kokonaislukutaulukon.
     */
    public final int[] luoData() {
        int x = super.getRandom().nextInt(2);

        if (x == 0) {
            return this.luoSatunnainenNormaaliJakautunutData();
        } else {
            return this.luoSatunnainenData();
        }
    }

    /**
     * Luo pseudosatunnaisen tasaista jakaumaa noudattavan datan.
     *
     * @return Palauttaa datan kokonaislukutauluna.
     */
    public final int[] luoSatunnainenData() {
        int[] uusiData = new int[this.asteikko.length];

        while (true) {
            int summa = 0;
            for (int i = 0; i < uusiData.length; i++) {
                summa = summa + uusiData[i];
            }
            if (summa == this.n) {
                break;
            } else {
                int x = super.getRandom().nextInt(uusiData.length);
                uusiData[x]++;
            }
        }
        return uusiData;
    }

    /**
     * Luo pseudonormaalijakautuneen frekvenssidatan.
     *
     * @return Palauttaa kokonaislukutaulukon.
     */
    public final int[] luoSatunnainenNormaaliJakautunutData() {
        int[] uusiData = new int[this.asteikko.length];

        if (this.asteikko.length == 2) {
            while (true) {
                int summa = 0;
                for (int i = 0; i < uusiData.length; i++) {
                    summa = summa + uusiData[i];
                }
                if (summa == this.n) {
                    break;
                } else {
                    int x = super.getRandom().nextInt(2);
                    uusiData[x]++;
                }
            }
        } else if (this.asteikko.length == 3) {
            while (true) {
                int summa = 0;
                for (int i = 0; i < uusiData.length; i++) {
                    summa = summa + uusiData[i];
                }
                if (summa == this.n) {
                    break;
                } else {
                    int x = super.getRandom().nextInt(5);
                    if (x == 0) {
                        uusiData[0]++;
                    } else if (x == 4) {
                        uusiData[2]++;
                    } else {
                        uusiData[1]++;
                    }

                }
            }
        } else if (this.asteikko.length == 4) {
            while (true) {
                int summa = 0;
                for (int i = 0; i < uusiData.length; i++) {
                    summa = summa + uusiData[i];
                }
                if (summa == this.n) {
                    break;
                } else {
                    int x = super.getRandom().nextInt(6);
                    if (x == 0) {
                        uusiData[0]++;
                    } else if (x == 1 || x == 2) {
                        uusiData[1]++;
                    } else if (x == 3 || x == 4) {
                        uusiData[2]++;
                    } else {
                        uusiData[3]++;
                    }
                }
            }
        } else if (this.asteikko.length == 5) {
            while (true) {
                int summa = 0;
                for (int i = 0; i < uusiData.length; i++) {
                    summa = summa + uusiData[i];
                }
                if (summa == this.n) {
                    break;
                } else {
                    int x = super.getRandom().nextInt(10);
                    if (x == 0) {
                        uusiData[0]++;
                    } else if (x == 1 || x == 2) {
                        uusiData[1]++;
                    } else if (x == 3 || x == 4 || x == 5 || x == 6) {
                        uusiData[2]++;
                    } else if (x == 7 || x == 8) {
                        uusiData[3]++;
                    } else if (x == 9) {
                        uusiData[4]++;
                    }
                }
            }
        }
        return uusiData;
    }

}
