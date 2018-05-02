
package Tehtavat;

import TilastollisetTestit.SpearmaninKorrelaatio;
import java.util.ArrayList;

/**
 *
 * @author Oskari Koskinen
 */
public class SpearmanKorrelaatioTehtava extends Tehtava {
    int muuttujaX;
    int muuttujaY;
    ArrayList<Integer> muuttujanXarvot;
    ArrayList<Integer> muuttujanYarvot;
    SpearmaninKorrelaatio rho;

    public SpearmanKorrelaatioTehtava() {
        super();
        this.muuttujaX = 0;
        this.muuttujaY = 0;
        this.muuttujanXarvot = new ArrayList();
        this.muuttujanYarvot = new ArrayList();
        this.rho = new SpearmaninKorrelaatio();
    }

    public void luoUusiTehtava() {
        this.setMuuttujaX(this.arvoMuuttujaX());
        this.setMuuttujaY(this.arvoMuuttujaY());
        this.setMuuttujanXarvot(this.luoAineisto());
        this.setMuuttujanYarvot(this.luoAineisto());
        super.setOhje(this.luoOhjeistus());
        this.rho.laske(muuttujanXarvot, muuttujanYarvot);
        String ohje1 = "Laske Spearmanin korrelaatiokertoimen arvo.";
        String ohje2 = "Laske Spearmanin korrelaatiokertoimelle t-arvo.";
        super.testinValintaTehtava("Spearmanin korrelaatio");
        super.laskemisTehtava(this.rho.cor, 1, ohje1);
        this.nollaHypoteesiTehtava();
        this.vastaHypoteesiTehtava();
        super.laskemisTehtava(this.rho.t, 1, ohje2);
        this.pArvonLaskeminen();
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

    public void nollaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Muuttujien välillä ei ole yhteyttä.";
        String vastaus2 = "B = 2: Muuttujien välillä on yhteys.";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void vastaHypoteesiTehtava() {
        String vastaus1 = "A = 1: Muuttujien välillä ei ole yhteyttä.";
        String vastaus2 = "B = 2: Muuttujien välillä on yhteys.";

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
        String tehtavanOhje = "Määritä testisuureen p-arvo" + System.lineSeparator()
                + "1. Tulos ei ole tilastollisesti merkisevä" + System.lineSeparator()
                + "2. p <0.05" + System.lineSeparator()
                + "3. p <0.01" + System.lineSeparator()
                + "4. p <0.001" + System.lineSeparator();

        int vastaus = 0;

        if (this.rho.pArvo.equals("ns")) {
            vastaus = 1;
        } else if (this.rho.pArvo.equals("p <0.05")) {
            vastaus = 2;
        } else if (this.rho.pArvo.equals("p <0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

}
