package tehtavaTestit;


import Tehtavat.OsaTehtava;
import Tehtavat.RiippumattomienOtostenTTestiTehtava;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari Koskinen
 */
public class RiippumattomienOtostenTTestiTehtavaTest {

    RiippumattomienOtostenTTestiTehtava tehtava;

    @Before
    public void setUp() {
        this.tehtava = new RiippumattomienOtostenTTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    @Test
    public void ryhmienTyyppiEiOleTyhjaMerkkiJono() {
        boolean arvo = false;
        String tyyppi = this.tehtava.getRyhmienTyyppi();
        if (!tyyppi.equals("")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ryhmanXnimiEiOleTyhjaMerkkiJono() {
        boolean arvo = false;
        String ryhmaXnimi = this.tehtava.getRyhmaXnimi();
        if (!ryhmaXnimi.equals("")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ryhmanYnimiEiOleTyhjaMerkkiJono() {
        boolean arvo = false;
        String ryhmaYnimi = this.tehtava.getRyhmaYnimi();
        if (!ryhmaYnimi.equals("")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ryhmienNimetEivatOleSamat() {
        boolean arvo = false;
        String ryhmaXnimi = this.tehtava.getRyhmaXnimi();
        String ryhmaYnimi = this.tehtava.getRyhmaYnimi();
        if (!ryhmaXnimi.equals(ryhmaYnimi)) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void hypoteestiOnOlemassa() {
        boolean arvo = false;
        String hypoteesi = this.tehtava.getHypoteesi();
        if (!hypoteesi.equals("")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ryhmaXdataSuurempiKuinNolla() {
        boolean arvo = false;
        int dataXkoko = this.tehtava.getRyhmanXarvot().size();
        if (dataXkoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ryhmaYdataSuurempiKuinNolla() {
        boolean arvo = false;
        int dataYkoko = this.tehtava.getRyhmanYarvot().size();
        if (dataYkoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void ryhmienMediaanitEivatOleSamat() {
        boolean arvo = false;
        int ryhmaXmediaani = this.tehtava.getRyhmanXmediaani();
        int ryhmaYmediaani = this.tehtava.getRyhmanYmediaani();
        if (ryhmaXmediaani != ryhmaYmediaani) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void testinValintaTehtavaSisaltaaOikeanTestin() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        assertEquals(valinta.getOhjeistus().contains(
                "Riippumattomien otosten t-testi"), true);
    }

    @Test
    public void testinValintaTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();

        int vastaus;

        if (ohje.contains("A = 1: Riippumattomien otosten t-testi")) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: Riippumattomien otosten t-testi")) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: Riippumattomien otosten t-testi")) {
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

        if (ohje.contains("A = 1: Riippumattomien otosten t-testi")) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: Riippumattomien otosten t-testi")) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: Riippumattomien otosten t-testi")) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void nollaHypoteesiTehtavaSisaltaaOikeanVaihtoehdon() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        assertEquals(valinta.getOhjeistus().contains(
                "Ryhmien keskiarvot eivät eroa toisistaan"), true);
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
        int suoritus = valinta.suorita(2);
        assertEquals(suoritus, 0);
    }

    @Test
    public void vastaHypoteesiTehtavaSisaltaaKaikkiVaihtoehdot() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        String ohje = valinta.getOhjeistus();

        String hypoteesi1 = "2. Ryhmän " + this.tehtava.getRyhmaXnimi()
                + " keskiarvo on suurempi kuin ryhmän "
                + this.tehtava.getRyhmaYnimi();
        String hypoteesi2 = "3. Ryhmän " + this.tehtava.getRyhmaXnimi()
                + " keskiarvo on pienempi kuin ryhmän "
                + this.tehtava.getRyhmaYnimi();
        String hypoteesi3 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        assertEquals(ohje.contains(hypoteesi1), true);
        assertEquals(ohje.contains(hypoteesi2), true);
        assertEquals(ohje.contains(hypoteesi3), true);
    }

    @Test
    public void vastaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        String hypoteesi = tehtava.getHypoteesi();
        int vastaus = 0;

        if (hypoteesi.equals("X>Y")) {
            vastaus = 2;
        } else if (hypoteesi.equals("X<Y")) {
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
        String hypoteesi = tehtava.getHypoteesi();
        int vastaus = 0;

        if (hypoteesi.equals("X>Y")) {
            vastaus = 3;
        } else if (hypoteesi.equals("X<Y")) {
            vastaus = 4;
        } else if (hypoteesi.equals("X=/=Y")) {
            vastaus = 2;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void tTestiTehtavaSisaltaaOikeanVaihtoehdon() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        double t = this.tehtava.getT().getT();
        String tString = "" + t;
        String ohje = valinta.getOhjeistus();
        assertEquals(ohje.contains(tString), true);
    }

    @Test
    public void tTestiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        double t = this.tehtava.getT().getT();
        String tString = "" + t;
        String ohje = valinta.getOhjeistus();

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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        double t = this.tehtava.getT().getT();
        String tString = "" + t;
        String ohje = valinta.getOhjeistus();

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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String hypoteesi = this.tehtava.getHypoteesi();
        double t = this.tehtava.getT().getT();
        String pArvo = this.tehtava.getT().getpArvo();
        int vastaus;

        if (hypoteesi.equals("X<Y") && t >= 0) {
            vastaus = 1;
        } else if (hypoteesi.equals("X>Y") && t <= 0) {
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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String hypoteesi = this.tehtava.getHypoteesi();
        double t = this.tehtava.getT().getT();
        String pArvo = this.tehtava.getT().getpArvo();
        int vastaus = 0;

        if (hypoteesi.equals("X<Y") && t >= 0) {
            vastaus = 3;
        } else if (hypoteesi.equals("X>Y") && t <= 0) {
            vastaus = 3;
        } else {
            if (pArvo.equals("ns")) {
                vastaus = 3;
            } else if (pArvo.equals("p <0.05")) {
                vastaus = 4;
            } else if (pArvo.equals("p < 0.01")) {
                vastaus = 2;
            } else {
                vastaus = 1;
            }
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

}
