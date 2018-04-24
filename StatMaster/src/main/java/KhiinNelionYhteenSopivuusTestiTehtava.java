
import java.util.ArrayList;
import java.util.Collections;

/**
 * Khiin nelion yhteensopivuustestiin liittyvän tehtävän rakentava luokka, joka
 * on Tehtava -luokan erikoistapaus.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionYhteenSopivuusTestiTehtava extends Tehtava {

    int n;
    int[] havaitutFrekvenssit;
    int[] teoreettisetFrekvenssit;
    int riippumatonMuuttuja;
    String asteikko[];
    KhiinNelionYhteenSopivuusTesti khii;

    public KhiinNelionYhteenSopivuusTestiTehtava() {
        super();
        this.n = 0;
        this.havaitutFrekvenssit = new int[0];
        this.teoreettisetFrekvenssit = new int[0];
        this.riippumatonMuuttuja = 0;
        this.asteikko = new String[0];
        this.khii = new KhiinNelionYhteenSopivuusTesti();
    }

    public void luoUusiTehtava() {
        this.setAsteikko(super.arvoAsteikkoVektori1());
        this.setN(this.arvoOtoksenKoko());
        this.setHavaitutFrekvenssit(this.luoData());
        this.setTeoreettisetFrekvenssit(this.luoData());
        this.setRiippumatonMuuttuja(super.random.nextInt(super.aiheetPerusmuoto().length));
        this.khii.laske(havaitutFrekvenssit, teoreettisetFrekvenssit);
        this.setOhjeistus();
        super.testinValintaTehtava("Khiin neliön yhteensopivuustesti");
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        this.khiinNelioTehtava();
        this.pArvoTehtava();
    }

    public void setOhjeistus() {
        String tehtavanOhje = "Tutkija oli kiinnostunut " + super.aiheetTaivutus2()[this.riippumatonMuuttuja];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "erisuuruisten arvojen jakautumisesta perusjoukossa.";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Aikaisemmassa tutkimuksessa " + super.aiheetTaivutus2()[this.riippumatonMuuttuja];
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "arvoja mitattiin seuraavista arvoista koostuvalla asteikolla";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + super.tulostaAsteikko(this.asteikko);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Aikaisemmassa tutkimuksessa havainnot jakautuivat yllä "
                + "esitettyihn luokkiin seuraavasti: ";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + super.tulostaArvot(this.teoreettisetFrekvenssit);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Uudessa tutkimuksessa käytettiin samaa luokittelua ja saatiin seuraava tulos:";
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + super.tulostaArvot(this.havaitutFrekvenssit);
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + System.lineSeparator();
        tehtavanOhje = tehtavanOhje + "Tutki poikkeavatko uudessa tutkimuksessa havaitut frekvenssit "
                + "aikaisemmin havaituista.";
        super.setOhje(tehtavanOhje);
    }

    /**
     * Luo osatehtävän, jossa määritetään testin nollahypoteesi.
     */
    public void nollaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Havaitut ja odotetut frekvenssit eivät poikkea toisistaan.";
        String vastaus2 = "B = 2: Havaitut ja odotetut frekvenssit poikkeavat toisistaan";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    /**
     * Luo osatehtävän, jossa määritetään testin vastahypoteesi.
     */
    public void vastaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Havaitut ja odotetut frekvenssit eivät poikkea toisistaan.";
        String vastaus2 = "B = 2: Havaitut ja odotetut frekvenssit poikkeavat toisistaan";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(2, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    /**
     * Luo osatehtävän, jossa lasketaan khiin neliö.
     */
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

    /**
     * Luo osatehtävän, jossa määritetään khiin neliön testin p-arvo.
     */
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

    public void setRiippumatonMuuttuja(int riippumatonMuuttuja) {
        this.riippumatonMuuttuja = riippumatonMuuttuja;
    }

    public void setHavaitutFrekvenssit(int[] havaitutFrekvenssit) {
        this.havaitutFrekvenssit = havaitutFrekvenssit;
    }

    public void setTeoreettisetFrekvenssit(int[] teoreettisetFrekvenssit) {
        this.teoreettisetFrekvenssit = teoreettisetFrekvenssit;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setAsteikko(String[] asteikko) {
        this.asteikko = asteikko;
    }

    /**
     * Arpoo satunnaisen luvun väliltä 500-5000.
     *
     * @return Palauttaa kokonaislukumuuttujan.
     */
    public int arvoOtoksenKoko() {
        int otosKoko = 500 + random.nextInt(4501);
        return otosKoko;
    }

    /**
     * Luo satunnaisen datan, joka noudattaa jotain satunnaista jakaumaa.
     *
     * @return palauttaa kokonaislukutaulukon.
     */
    public int[] luoData() {
        int x = random.nextInt(2);

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
    public int[] luoSatunnainenData() {
        int[] uusiData = new int[this.asteikko.length];

        while (true) {
            int summa = 0;
            for (int i = 0; i < uusiData.length; i++) {
                summa = summa + uusiData[i];
            }
            if (summa == this.n) {
                break;
            } else {
                int x = random.nextInt(uusiData.length);
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
    public int[] luoSatunnainenNormaaliJakautunutData() {
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
                    int x = random.nextInt(2);
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
                    int x = random.nextInt(5);
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
                    int x = random.nextInt(6);
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
                    int x = random.nextInt(10);
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
