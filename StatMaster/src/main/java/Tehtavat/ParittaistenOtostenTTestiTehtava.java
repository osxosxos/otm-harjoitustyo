package Tehtavat;


import TilastollisetTestit.StudentinTTestiParittaisilleOtoksille;
import java.util.ArrayList;

/**
 *
 * @author Oskari Koskinen
 */
public class ParittaistenOtostenTTestiTehtava extends Tehtava {

    int muuttuja;
    String ryhmaManipulaatio;
    String hypoteesi;
    int koko;
    int ennenMediaani;
    int jalkeenMediaani;
    ArrayList<Integer> ennenArvot;
    ArrayList<Integer> jalkeenArvot;
    StudentinTTestiParittaisilleOtoksille t;

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

    public void luoUusiTehtava() {
        this.setMuuttuja(super.random.nextInt(super.aiheetPerusmuoto().length));
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
        super.testinValintaTehtava("Verrannolisten parien t-testi");
        this.nollaHypoteesiTehtava();
        this.vaihtoehtoinenHypoteesiTehtava();
        String ohje1 = "Valitse annetuista vaihtoehdoista "
                + "erotusten keskiarvo: ";
        String ohje2 = "Valitse annetuista vaihtoehdoista "
                + "erotusten otoskeskihajonta: ";
        String ohje3 = "Valitse annetuista vaihtoehdoista "
                + "testisuureen arvo: ";
        super.laskemisTehtava(this.t.erotustenKa, 2, ohje1);
        super.laskemisTehtava(this.t.erotustenOtosKh, 2, ohje2);
        super.laskemisTehtava(this.t.t, 2, ohje3);
        this.pArvoTehtava();
    }

    public int getMuuttuja() {
        return this.muuttuja;
    }

    public String getRyhmaManipulaatio() {
        return ryhmaManipulaatio;
    }

    public String getHypoteesi() {
        return hypoteesi;
    }

    public int getKoko() {
        return koko;
    }

    public int getEnnenMediaani() {
        return ennenMediaani;
    }

    public int getJalkeenMediaani() {
        return jalkeenMediaani;
    }

    public ArrayList<Integer> getEnnenArvot() {
        return ennenArvot;
    }

    public ArrayList<Integer> getJalkeenArvot() {
        return jalkeenArvot;
    }
      
    /**
     * Luo osatehtävän, jossa määritetään testisuureen p-arvo.
     */
    public void pArvoTehtava() {
        String[] kirjaimet = 
                new String[]{"A = 1: ", "B = 2: ", "C = 3: ", "D = 4: "};
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

        OsaTehtava tehtava = new OsaTehtava(oikeaVastaus, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    /**
     * Luo tehtavan, jossa määritetään testin nollahypoteesi.
     */
    public void nollaHypoteesiTehtava() {
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
        super.osaTehtavat.add(tehtava);
    }

    public void vaihtoehtoinenHypoteesiTehtava() {

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
        super.osaTehtavat.add(tehtava);
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
            if (Math.abs(this.ennenMediaani - x) <= 20 
                    && x != this.ennenMediaani) {
                return x;
            }
        }
    }

    public void setKoko(int koko) {
        this.koko = koko;
    }

    public void setMuuttuja(int muuttuja) {
        this.muuttuja = muuttuja;
    }

    public void setRyhmaManipulaatio(String ryhmaManipulaatio) {
        this.ryhmaManipulaatio = ryhmaManipulaatio;
    }

    public void setHypoteesi(String hypoteesi) {
        this.hypoteesi = hypoteesi;
    }

    public String luoOhjeistus() {
        int x = random.nextInt(25) + 5;
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
                + "Voit olettaa, että molemmat mittaukset noudattavat normaalijakaumaa "
                + System.lineSeparator() + "ja ovat vähintään välimatka-asteikollisia."
                + System.lineSeparator();
        return ohjeistus;
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

}
