
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Tämä luokka kuvaa tehtävää, jonka tarkoitus on laskea Pearsonin korrelaatio
 * kerroin. Tehtävä koostuu useista osatehtävistä.
 *
 * @author Oskari Koskinen
 */
public class PearsonKorrelaatioTehtava {

    String muuttujaX;
    String muuttujaY;
    String ohjeistus;
    ArrayList<Integer> muuttujanXarvot;
    ArrayList<Integer> muuttujanYarvot;
    ArrayList<OsaTehtava> osaTehtavat;
    PearsonKorrelaatio r;

    public PearsonKorrelaatioTehtava() {
        this.muuttujaX = "";
        this.muuttujaY = "";
        this.ohjeistus = "";
        this.muuttujanXarvot = new ArrayList();
        this.muuttujanYarvot = new ArrayList();
        this.osaTehtavat = new ArrayList();
        this.r = new PearsonKorrelaatio();
    }

    public void luoUusiTehtava() {
        this.arvoMuuttujanXNimi();
        this.arvoMuuttujanYNimi();
        this.luoVektorit();
        this.setOhjeistus();
        this.r.laske(muuttujanXarvot, muuttujanYarvot);
        this.testiSuureenValinta();
        this.korrelaationLaskeminen();
        this.tSuureenLaskeminen();
        this.pArvonLaskeminen();
    }

    public void suorita(Scanner scanner) {
        
        System.out.println(this.ohjeistus); 
        System.out.println("");
        
        for (int i = 0; i < osaTehtavat.size(); i++) {
            osaTehtavat.get(i).suorita();
        }
        
        System.out.println("");
        System.out.println("Tehtävä on nyt ratkaistu!");
        System.out.println("");
        
    }
    
    public void luoVektorit() {

        Random random = new Random();

        int ylarajaX = (random.nextInt(10) + 1) * 10;
        int ylarajaY = (random.nextInt(10) + 1) * 10;

        int aineistonKoko = random.nextInt(21);
        
        while (aineistonKoko < 5) {
            aineistonKoko = random.nextInt(21);
        }

        ArrayList<Integer> vektoriX = new ArrayList();
        ArrayList<Integer> vektoriY = new ArrayList();

        for (int j = 0; j < aineistonKoko; j++) {
            int arvo1 = random.nextInt(ylarajaX);
            int arvo2 = random.nextInt(ylarajaY);
            vektoriX.add(arvo1);
            vektoriY.add(arvo2);
        }

        this.muuttujanXarvot = vektoriX;
        this.muuttujanYarvot = vektoriY;

    }

    public void arvoMuuttujanXNimi() {

        String[] muuttujat = new String[]{"masennus",
            "ahdistus", "ADHD", "arkisujuvuus", "toverisuosio",
            "kiintymyssuhteen turvallisuus", "neuroottisuus", "sovinnollisuus",
            "avoimuus uusille kokemuksille", "tunnollisuus",
            "autoritaarinen persoonallisuus", "luotettavuus",
            "työstressi", "älykkyysosamäärä", "työmuisti"};

        Random random = new Random();
        int x = random.nextInt(muuttujat.length);
        this.muuttujaX = muuttujat[x];
    }

    public void arvoMuuttujanYNimi() {

        String[] muuttujat = new String[]{"masennus",
            "ahdistus", "ADHD", "arkisujuvuus", "toverisuosio",
            "kiintymyssuhteen turvallisuus", "neuroottisuus", "sovinnollisuus",
            "avoimuus uusille kokemuksille", "tunnollisuus",
            "autoritaarinen persoonallisuus", "luotettavuus",
            "työstressi", "älykkyysosamäärä", "työmuisti"};

        while (true) {
            Random random = new Random();
            int x = random.nextInt(muuttujat.length);
            String y = muuttujat[x];
            if (!y.equals(this.muuttujaX)) {
                this.muuttujaY = y;
                break;
            }
        }

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

    public void setOhjeistus() {

        String ohje1 = "Selvitä kahden muuttujan välisen lineaarisen yhteyden vahvuus.";
        String ohje2 = "Muuttujat ovat " + this.muuttujaX + " ja " + this.muuttujaY + ".";

        String ohje3 = "Voit olettaa, että molemmat muuttujat ovat vähintään "
                + System.lineSeparator()
                + "välimatka-asteikollisia ja noudattavat likimain normaalijakaumaa.";

        String ohje4 = "Muuttujalla " + this.muuttujaX + " on seuraavat arvot:"
                + System.lineSeparator() + this.vektoriMerkkiJonoksi(muuttujanXarvot);

        String ohje5 = "Muuttujalla " + this.muuttujaY + " on seuraavat arvot:"
                + System.lineSeparator() + this.vektoriMerkkiJonoksi(muuttujanYarvot);

        String ohje = ohje1 + System.lineSeparator()
                + ohje2 + System.lineSeparator()
                + ohje3 + System.lineSeparator()
                + ohje4 + System.lineSeparator()
                + ohje5 + System.lineSeparator();

        this.ohjeistus = ohje;

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
            if (testit.get(i).equals("Pearsonin korrelaatio")) {
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

    /**
     * Lineaarisen yhteyden vahvuuden laskeminen kahden muuttujan välille.
     */
    public void korrelaationLaskeminen() {
        String ohje = "Laske lineaarisen yhteyden voimakkuus.";
        OsaTehtava tehtava = new OsaTehtava(this.r.cor, ohje);
        this.osaTehtavat.add(tehtava);
    }

    /**
     * Korrelaation tilastollisen merkitsevyyden testaaminen.
     */
    public void tSuureenLaskeminen() {
        String ohje = "Laske korrelaatiolle t-arvo.";
        OsaTehtava tehtava = new OsaTehtava(this.r.t, ohje);
        this.osaTehtavat.add(tehtava);
    }

    /**
     * Riskitason määrittäminen
     */
    public void pArvonLaskeminen() {
        String ohje = "Määritä testisuureen p-arvo" + System.lineSeparator()
                + "1. Tulos ei ole tilastollisesti merkisevä" + System.lineSeparator()
                + "2. p <0.05" + System.lineSeparator()
                + "3. p <0.01" + System.lineSeparator()
                + "4. p <0.001" + System.lineSeparator();

        int vastaus = 0;
        
        if (this.r.pArvo.equals("ns")) {
            vastaus = 1;
        } else if (this.r.pArvo.equals("p <0.05")) {
            vastaus = 2;
        } else if (this.r.pArvo.equals("p <0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }
        
        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        this.osaTehtavat.add(tehtava);
    }

}
