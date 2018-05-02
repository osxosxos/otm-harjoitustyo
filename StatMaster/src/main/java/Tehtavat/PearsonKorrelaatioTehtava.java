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

    int muuttujaX;
    int muuttujaY;
    ArrayList<Integer> muuttujanXarvot;
    ArrayList<Integer> muuttujanYarvot;
    PearsonKorrelaatio r;

    public PearsonKorrelaatioTehtava() {
        super();
        this.muuttujaX = 0;
        this.muuttujaY = 0;
        this.muuttujanXarvot = new ArrayList();
        this.muuttujanYarvot = new ArrayList();
        this.r = new PearsonKorrelaatio();
    }

    public void luoUusiTehtava() {
        this.setMuuttujaX(this.arvoMuuttujaX());
        this.setMuuttujaY(this.arvoMuuttujaY());
        this.setMuuttujanXarvot(this.luoAineisto());
        this.setMuuttujanYarvot(this.luoAineisto());
        super.setOhje(this.luoOhjeistus());
        this.r.laske(muuttujanXarvot, muuttujanYarvot);
        String ohje1 = "Laske Pearsonin korrelaatiokertoimen arvo.";
        String ohje2 = "Laske Pearsonin korrelaatiokertoimelle t-arvo.";
        super.testinValintaTehtava("Pearsonin korrelaatio");
        super.laskemisTehtava(this.r.cor, 1, ohje1);
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        super.laskemisTehtava(this.r.t, 1, ohje2);
        this.pArvonLaskeminen();
    }

    public int getMuuttujaX() {
        return muuttujaX;
    }

    public int getMuuttujaY() {
        return muuttujaY;
    }

    public ArrayList<Integer> getMuuttujanXarvot() {
        return muuttujanXarvot;
    }

    public ArrayList<Integer> getMuuttujanYarvot() {
        return muuttujanYarvot;
    }
    
    public void setMuuttujaX(int muuttujaX) {
        this.muuttujaX = muuttujaX;
    }

    public void setMuuttujaY(int muuttujaY) {
        this.muuttujaY = muuttujaY;
    }

    public void setMuuttujanXarvot(ArrayList<Integer> muuttujanXarvot) {
        this.muuttujanXarvot = muuttujanXarvot;
    }

    public void setMuuttujanYarvot(ArrayList<Integer> muuttujanYarvot) {
        this.muuttujanYarvot = muuttujanYarvot;
    }

    public ArrayList luoAineisto() {
        int mediaani = (super.random.nextInt(10) + 1) * 10;
        int koko;

        if (this.muuttujanXarvot.size() != 0) {
            koko = this.muuttujanXarvot.size();
        } else {
            koko = super.random.nextInt(21);
        }

        while (koko < 5) {
            koko = random.nextInt(21);
        }

        ArrayList<Integer> vektori = super.luoData(mediaani, koko);
        return vektori;
    }

    public int arvoMuuttujaX() {
        int x = super.random.nextInt(super.aiheetPerusmuoto().length);
        return x;
    }

    public int arvoMuuttujaY() {
        int y = super.random.nextInt(super.aiheetPerusmuoto().length);
        while (true) {
            y = super.random.nextInt(super.aiheetPerusmuoto().length);
            if (y != this.muuttujaX) {
                break;
            }
        }
        return y;
    }

    /**
     * Luo ohjeen korrelaation laskemistehtävälle.
     *
     * @return
     */
    public String luoOhjeistus() {

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

    public void nollaHypoteesiTehtava() {
        String vastaus1 = 
                "A = 1: Muuttujien välillä ei ole lineaarista yhteyttä.";
        String vastaus2 = 
                "B = 2: Muuttujien välillä on lineaarinen yhteys.";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void vastaHypoteesiTehtava() {
        String vastaus1 = 
                "A = 1: Muuttujien välillä ei ole lineaarista yhteyttä.";
        String vastaus2 = 
                "B = 2: Muuttujien välillä on lineaarinen yhteys.";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(2, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    /**
     * Riskitason määrittäminen korrelaatiosta lasketulle p-arvolle.
     */
    public void pArvonLaskeminen() {
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

        if (this.r.pArvo.equals("ns")) {
            vastaus = 1;
        } else if (this.r.pArvo.equals("p <0.05")) {
            vastaus = 2;
        } else if (this.r.pArvo.equals("p <0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

}
