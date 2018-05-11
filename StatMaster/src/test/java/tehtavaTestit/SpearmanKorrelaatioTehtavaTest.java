package tehtavaTestit;

import Tehtavat.OsaTehtava;
import Tehtavat.SpearmanKorrelaatioTehtava;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari Koskinen
 */
public class SpearmanKorrelaatioTehtavaTest {

    SpearmanKorrelaatioTehtava tehtava;

    @Before
    public void setUp() {
        this.tehtava = new SpearmanKorrelaatioTehtava();
        this.tehtava.luoUusiTehtava();
    }

    @Test
    public void muuttujatEivatOleSamat() {
        int muuttujaX = this.tehtava.getMuuttujaX();
        int muuttujaY = this.tehtava.getMuuttujaY();
        boolean arvo = false;
        if (muuttujaX != muuttujaY) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void xArvojaEnemmanKuinNolla() {
        int xArvotKoko = this.tehtava.getMuuttujanXarvot().size();
        boolean arvo = false;
        if (xArvotKoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void yArvojaEnemmanKuinNolla() {
        int yArvotKoko = this.tehtava.getMuuttujanYarvot().size();
        boolean arvo = false;
        if (yArvotKoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void testinValintaTehtavassaOikeaTestiVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        String testi = "Spearmanin korrelaatio";
        boolean arvo = false;

        if (ohje.contains("A = 1: " + testi)
                && !ohje.contains("B = 2: " + testi)
                && !ohje.contains("C = 3: " + testi)
                && !ohje.contains("D = 4: " + testi)) {
            arvo = true;
        } else if (ohje.contains("B = 2: " + testi)
                && !ohje.contains("A = 1: " + testi)
                && !ohje.contains("C = 3: " + testi)
                && !ohje.contains("D = 4: " + testi)) {
            arvo = true;
        } else if (ohje.contains("C = 3: " + testi)
                && !ohje.contains("B = 2: " + testi)
                && !ohje.contains("A = 1: " + testi)
                && !ohje.contains("D = 4: " + testi)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + testi)
                && !ohje.contains("B = 2: " + testi)
                && !ohje.contains("C = 3: " + testi)
                && !ohje.contains("A = 1: " + testi)) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void testinValintaTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        String testi = "Spearmanin korrelaatio";
        int vastaus;

        if (ohje.contains("A = 1: " + testi)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + testi)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + testi)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void testinValintaTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        String testi = "Spearmanin korrelaatio";
        int vastaus;

        if (ohje.contains("A = 1: " + testi)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + testi)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + testi)) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void korrelaatioTehtavassaOikeaVaihtoehtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        double rho = this.tehtava.getRho().getCor();
        String ohje = valinta.getOhjeistus();
        String rhoString = "" + rho;
        boolean arvo = false;

        if (ohje.contains("A = 1: " + rhoString)
                && !ohje.contains("B = 2: " + rhoString)
                && !ohje.contains("C = 3: " + rhoString)
                && !ohje.contains("D = 4: " + rhoString)) {
            arvo = true;
        } else if (ohje.contains("B = 2: " + rhoString)
                && !ohje.contains("A = 1: " + rhoString)
                && !ohje.contains("C = 3: " + rhoString)
                && !ohje.contains("D = 4: " + rhoString)) {
            arvo = true;
        } else if (ohje.contains("C = 3: " + rhoString)
                && !ohje.contains("B = 2: " + rhoString)
                && !ohje.contains("A = 1: " + rhoString)
                && !ohje.contains("D = 4: " + rhoString)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + rhoString)
                && !ohje.contains("B = 2: " + rhoString)
                && !ohje.contains("C = 3: " + rhoString)
                && !ohje.contains("A = 1: " + rhoString)) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void korrelaatioTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        double rho = this.tehtava.getRho().getCor();
        String ohje = valinta.getOhjeistus();
        String rhoString = "" + rho;

        int vastaus;

        if (ohje.contains("A = 1: " + rhoString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + rhoString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + rhoString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void korrelaatioTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        double rho = this.tehtava.getRho().getCor();
        String ohje = valinta.getOhjeistus();
        String rhoString = "" + rho;

        int vastaus;

        if (ohje.contains("A = 1: " + rhoString)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + rhoString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + rhoString)) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void nollaHypoteesiTehtavassaOikeaVaihtoehtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        String ohje = valinta.getOhjeistus();
        String nollaHypoteesi = "Muuttujien välillä ei ole yhteyttä.";
        boolean arvo = false;

        if (ohje.contains("A = 1: " + nollaHypoteesi)
                && !ohje.contains("B = 2: " + nollaHypoteesi)
                && !ohje.contains("C = 3: " + nollaHypoteesi)
                && !ohje.contains("D = 4: " + nollaHypoteesi)) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void nollaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = valinta.suorita(1);
        assertEquals(suoritus, 1);
    }

    @Test
    public void nollaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = valinta.suorita(4);
        assertEquals(suoritus, 0);
    }

    @Test
    public void vastaHypoteesiTehtavassaOikeaVaihtoehtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        String ohje = valinta.getOhjeistus();
        String vastaHypoteesi = "Muuttujien välillä on yhteys.";
        boolean arvo = false;

        if (ohje.contains("B = 2: " + vastaHypoteesi)
                && !ohje.contains("A = 1: " + vastaHypoteesi)
                && !ohje.contains("C = 3: " + vastaHypoteesi)
                && !ohje.contains("D = 4: " + vastaHypoteesi)) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void vastaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        int suoritus = valinta.suorita(2);
        assertEquals(suoritus, 1);
    }

    @Test
    public void vastaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        int suoritus = valinta.suorita(1);
        assertEquals(suoritus, 0);
    }

    @Test
    public void tTestiTehtavassaOikeaVaihtoehtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        double t = this.tehtava.getRho().getT();
        String ohje = valinta.getOhjeistus();
        String tString = "" + t;
        boolean arvo = false;

        if (ohje.contains("A = 1: " + tString)
                && !ohje.contains("B = 2: " + tString)
                && !ohje.contains("C = 3: " + tString)
                && !ohje.contains("D = 4: " + tString)) {
            arvo = true;
        } else if (ohje.contains("B = 2: " + tString)
                && !ohje.contains("A = 1: " + tString)
                && !ohje.contains("C = 3: " + tString)
                && !ohje.contains("D = 4: " + tString)) {
            arvo = true;
        } else if (ohje.contains("C = 3: " + tString)
                && !ohje.contains("B = 2: " + tString)
                && !ohje.contains("A = 1: " + tString)
                && !ohje.contains("D = 4: " + tString)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + tString)
                && !ohje.contains("B = 2: " + tString)
                && !ohje.contains("C = 3: " + tString)
                && !ohje.contains("A = 1: " + tString)) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void tTestiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        double t = this.tehtava.getRho().getT();
        String ohje = valinta.getOhjeistus();
        String tString = "" + t;

        int vastaus;

        if (ohje.contains("A = 1: " + tString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + tString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + tString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void tTestiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        double t = this.tehtava.getRho().getT();
        String ohje = valinta.getOhjeistus();
        String tString = "" + t;

        int vastaus;

        if (ohje.contains("A = 1: " + tString)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + tString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + tString)) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void pArvoTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String pArvo = this.tehtava.getRho().getpArvo();

        int vastaus;

        if (pArvo.equals("ns")) {
            vastaus = 1;
        } else if (pArvo.equals("p <0.05")) {
            vastaus = 2;
        } else if (pArvo.equals("p < 0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void pArvoTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String pArvo = this.tehtava.getRho().getpArvo();

        int vastaus;

        if (pArvo.equals("ns")) {
            vastaus = 2;
        } else if (pArvo.equals("p <0.05")) {
            vastaus = 1;
        } else if (pArvo.equals("p < 0.01")) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

}
