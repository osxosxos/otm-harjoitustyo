package tehtavaTestit;

import Tehtavat.OsaTehtava;
import Tehtavat.ParittaistenOtostenTTestiTehtava;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testit parittaisten otosten t-testi tehtävägeneraattorille.
 *
 * @author Oskari Koskinen
 */
public class ParittaistenOtostenTTestiTehtavaTest {

    ParittaistenOtostenTTestiTehtava tehtava;

    @Before
    public void setUp() {
        this.tehtava = new ParittaistenOtostenTTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    @Test
    public void manipulaatiollaOnArvo() {
        boolean arvo = false;
        String manipulaatio = this.tehtava.getRyhmaManipulaatio();
        if (!manipulaatio.equals("")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void otoksenKokoOnSuurempiKuinNolla() {
        boolean arvo = false;
        int koko = this.tehtava.getKoko();
        if (koko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void hypoteesiEiOleTyhjaMerkkiJono() {
        boolean arvo = false;
        String manipulaatio = this.tehtava.getHypoteesi();
        if (!manipulaatio.equals("")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ennenMediaaniEiOleNolla() {
        boolean arvo = false;
        int mediaani = this.tehtava.getEnnenMediaani();
        if (mediaani != 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void jalkeenMediaaniEiOleNolla() {
        boolean arvo = false;
        int mediaani = this.tehtava.getJalkeenMediaani();
        if (mediaani != 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void mediaanitEivatOleSamat() {
        boolean arvo = false;
        int mediaaniEnnen = this.tehtava.getEnnenMediaani();
        int mediaaniJalkeen = this.tehtava.getJalkeenMediaani();
        if (mediaaniEnnen != mediaaniJalkeen) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ennenArvotEiOleTyhjaLista() {
        boolean arvo = false;
        int koko = this.tehtava.getEnnenArvot().size();
        if (koko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void jalkeenArvotEivatOleTyhjaLista() {
        boolean arvo = false;
        int koko = this.tehtava.getJalkeenArvot().size();
        if (koko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void testinValintaTehtavaSisaltaaOikeanTestinVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        boolean arvo = false;

        if (ohje.contains("A = 1: Verrannollisten parien t-testi")
                && !ohje.contains("B = 2: Verrannollisten parien t-testi")
                && !ohje.contains("C = 3: Verrannollisten parien t-testi")
                && !ohje.contains("D = 4: Verrannollisten parien t-testi")) {
            arvo = true;
        } else if (ohje.contains("B = 2: Verrannollisten parien t-testi")
                && !ohje.contains("A = 1: Verrannollisten parien t-testi")
                && !ohje.contains("C = 3: Verrannollisten parien t-testi")
                && !ohje.contains("D = 4: Verrannollisten parien t-testi")) {
            arvo = true;
        } else if (ohje.contains("C = 3: Verrannollisten parien t-testi")
                && !ohje.contains("A = 1: Verrannollisten parien t-testi")
                && !ohje.contains("B = 2: Verrannollisten parien t-testi")
                && !ohje.contains("D = 4: Verrannollisten parien t-testi")) {
            arvo = true;
        } else if (ohje.contains("D = 4: Verrannollisten parien t-testi")
                && !ohje.contains("A = 1: Verrannollisten parien t-testi")
                && !ohje.contains("B = 2: Verrannollisten parien t-testi")
                && !ohje.contains("C = 3: Verrannollisten parien t-testi")) {
            arvo = true;
        }

        assertEquals(arvo, true);
    }

    @Test
    public void testinValintaTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        int vastaus;

        if (ohje.contains("A = 1: Verrannollisten parien t-testi")) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: Verrannollisten parien t-testi")) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: Verrannollisten parien t-testi")) {
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
        int vastaus;

        if (ohje.contains("A = 1: Verrannollisten parien t-testi")) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: Verrannollisten parien t-testi")) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: Verrannollisten parien t-testi")) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void nollaHypoteesiTehtavaSisaltaaOikeanVaihtoehdonVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        String ohje = valinta.getOhjeistus();
        boolean arvo = false;

        if (ohje.contains("A = 1: Mittauksien välillä ei ole eroa.")
                && !ohje.contains("B = 2: Mittauksien välillä ei ole eroa.")
                && !ohje.contains("C = 3: Mittauksien välillä ei ole eroa.")
                && !ohje.contains("D = 4: Mittauksien välillä ei ole eroa.")) {
            arvo = true;
        }

        assertEquals(arvo, true);
    }

    @Test
    public void nollaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        int suoritus = valinta.suorita(1);
        assertEquals(suoritus, 1);
    }

    @Test
    public void nollaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        int suoritus = valinta.suorita(3);
        assertEquals(suoritus, 0);
    }

    @Test
    public void vastaHypoteesiTehtavaSisaltaaOikeanVastauksenVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        String ohje = valinta.getOhjeistus();
        String vastaus1 = "A = 1: Mittauksien välillä ei ole eroa.";
        String vastaus2 = "B = 2: Arvot ovat kasvaneet mittauksien välillä";
        String vastaus3 = "C = 3: Arvot ovat pienentyneet mittauksien välillä";
        String vastaus4 = "D = 4: Arvot eivät ole samat eri mittauksissa";
        assertEquals(ohje.contains(vastaus1) && ohje.contains(vastaus2)
                && ohje.contains(vastaus3) && ohje.contains(vastaus4), true);
    }

    @Test
    public void vastaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        String hypoteesi = this.tehtava.getHypoteesi();
        int vastaus = 0;

        if (hypoteesi.equals("X<Y")) {
            vastaus = 2;
        } else if (hypoteesi.equals("X>Y")) {
            vastaus = 3;
        } else if (hypoteesi.equals("X=/=Y")) {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void vastaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);

        String hypoteesi = this.tehtava.getHypoteesi();
        int vastaus = 0;

        if (hypoteesi.equals("X<Y")) {
            vastaus = 1;
        } else if (hypoteesi.equals("X>Y")) {
            vastaus = 4;
        } else if (hypoteesi.equals("X=/=Y")) {
            vastaus = 2;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);

    }

    @Test
    public void erotustenKATehtavaSisaltaaOikeanVastauksenVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        String ohje = valinta.getOhjeistus();
        double ka = this.tehtava.getT().getErotustenKa();
        String kaString = "" + ka;

        boolean arvo = false;

        if (ohje.contains("A = 1: " + kaString)
                && !ohje.contains("B = 2: " + kaString)
                && !ohje.contains("C = 3: " + kaString)
                && !ohje.contains("D = 4: " + kaString)) {
            arvo = true;
        } else if (ohje.contains("B = 2: " + kaString)
                && !ohje.contains("A = 1: " + kaString)
                && !ohje.contains("C = 3: " + kaString)
                && !ohje.contains("D = 4: " + kaString)) {
            arvo = true;
        } else if (ohje.contains("C = 3: " + kaString)
                && !ohje.contains("A = 1: " + kaString)
                && !ohje.contains("B = 2: " + kaString)
                && !ohje.contains("D = 4: " + kaString)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + kaString)
                && !ohje.contains("A = 1: " + kaString)
                && !ohje.contains("B = 2: " + kaString)
                && !ohje.contains("C = 3: " + kaString)) {
            arvo = true;
        }
    }

    @Test
    public void erotustenKATehtavanOikeaVastausPalautaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        String ohje = valinta.getOhjeistus();
        double ka = this.tehtava.getT().getErotustenKa();
        String kaString = "" + ka;

        int vastaus;

        if (ohje.contains("A = 1: " + kaString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + kaString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + kaString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);

    }

    @Test
    public void erotustenKATehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        String ohje = valinta.getOhjeistus();
        double ka = this.tehtava.getT().getErotustenKa();
        String kaString = "" + ka;

        int vastaus;

        if (ohje.contains("A = 1: " + kaString)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + kaString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + kaString)) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void erotustenKHTehtavaSisaltaaOikeanVastauksenVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String ohje = valinta.getOhjeistus();
        double kh = this.tehtava.getT().getErotustenOtosKh();
        String khString = "" + kh;

        boolean arvo = false;

        if (ohje.contains("A = 1: " + khString)
                && !ohje.contains("B = 2: " + khString)
                && !ohje.contains("C = 3: " + khString)
                && !ohje.contains("D = 4: " + khString)) {
            arvo = true;
        } else if (ohje.contains("B = 2: " + khString)
                && !ohje.contains("A = 1: " + khString)
                && !ohje.contains("C = 3: " + khString)
                && !ohje.contains("D = 4: " + khString)) {
            arvo = true;
        } else if (ohje.contains("C = 3: " + khString)
                && !ohje.contains("A = 1: " + khString)
                && !ohje.contains("B = 2: " + khString)
                && !ohje.contains("D = 4: " + khString)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + khString)
                && !ohje.contains("A = 1: " + khString)
                && !ohje.contains("B = 2: " + khString)
                && !ohje.contains("C = 3: " + khString)) {
            arvo = true;
        }

        assertEquals(arvo, true);
    }

    @Test
    public void erotustenKHTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String ohje = valinta.getOhjeistus();
        double kh = this.tehtava.getT().getErotustenOtosKh();
        String khString = "" + kh;

        int vastaus;

        if (ohje.contains("A = 1: " + khString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + khString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + khString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void erotustenKHTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String ohje = valinta.getOhjeistus();
        double kh = this.tehtava.getT().getErotustenOtosKh();
        String khString = "" + kh;

        int vastaus;

        if (ohje.contains("A = 1: " + khString)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + khString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + khString)) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void tTestiTehtavaSisaltaaOikeanVaihtoEhdonVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String ohje = valinta.getOhjeistus();
        double t = this.tehtava.getT().getT();
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
                && !ohje.contains("A = 1: " + tString)
                && !ohje.contains("B = 2: " + tString)
                && !ohje.contains("D = 4: " + tString)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + tString)
                && !ohje.contains("A = 1: " + tString)
                && !ohje.contains("B = 2: " + tString)
                && !ohje.contains("C = 3: " + tString)) {
            arvo = true;
        }

        assertEquals(arvo, true);
    }

    @Test
    public void tTestiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String ohje = valinta.getOhjeistus();
        double t = this.tehtava.getT().getT();
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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String ohje = valinta.getOhjeistus();
        double t = this.tehtava.getT().getT();
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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(6);
        double t = this.tehtava.getT().getT();
        String hypoteesi = this.tehtava.getHypoteesi();
        String pArvo = this.tehtava.getT().getpArvo();
        int vastaus;

        if (hypoteesi.equals("X<Y") && t <= 0) {
            vastaus = 1;
        } else if (hypoteesi.equals("X>Y") && t >= 0) {
            vastaus = 1;
        } else {
            if (pArvo.equals("ns")) {
                vastaus = 1;
            } else if (pArvo.equals("p <0.05")) {
                vastaus = 2;
            } else if (pArvo.equals("p < 0.01")) {
                vastaus = 3;
            } else {
                vastaus = 4;
            }
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void pArvoTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(6);
        double t = this.tehtava.getT().getT();
        String hypoteesi = this.tehtava.getHypoteesi();
        String pArvo = this.tehtava.getT().getpArvo();
        int vastaus;

        if (hypoteesi.equals("X<Y") && t <= 0) {
            vastaus = 2;
        } else if (hypoteesi.equals("X>Y") && t >= 0) {
            vastaus = 4;
        } else {
            if (pArvo.equals("ns")) {
                vastaus = 2;
            } else if (pArvo.equals("p <0.05")) {
                vastaus = 1;
            } else if (pArvo.equals("p < 0.01")) {
                vastaus = 4;
            } else {
                vastaus = 3;
            }
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

}
