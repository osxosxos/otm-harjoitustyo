package tehtavaTestit;

import Tehtavat.KhiinNelionRiippumattomuusTestiTehtava;
import Tehtavat.OsaTehtava;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka testaa khiin neliön riippumaattomuustestiin liittyvän tehtäväluokan
 * toiminnallisuutta.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusTestiTehtavaTest {

    KhiinNelionRiippumattomuusTestiTehtava tehtava;

    @Before
    public void setUp() {
        this.tehtava = new KhiinNelionRiippumattomuusTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    @Test
    public void riviJaSarakeAiheEiOleSama() {
        boolean arvo = false;
        int riviMuuttuja = this.tehtava.getRiviMuuttujaAihe();
        int sarakeMuuttuja = this.tehtava.getSarakeMuuttujatAihe();
        if (riviMuuttuja != sarakeMuuttuja) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void riviAsteikkonPituusEiOleNolla() {
        boolean arvo = false;
        int rivienMaara = this.tehtava.getRiviAsteikko().length;
        if (rivienMaara != 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void sarakeAsteikonPituusEiOleNolla() {
        boolean arvo = false;
        int sarakkeidenMaara = this.tehtava.getSarakeAsteikko().length;
        if (sarakkeidenMaara != 0) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void taulukkoEiOleTyhja() {
        boolean arvo = false;
        int rivit = this.tehtava.getDataTaulukko().length;
        int sarakkeet = this.tehtava.getDataTaulukko()[0].length;
        if (rivit != 0 && sarakkeet != 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void taulukonRivienMaaraVastaaRiviAsteikonPituutta() {
        int rivienMaara = this.tehtava.getRiviAsteikko().length;
        int rivit = this.tehtava.getDataTaulukko().length;
        assertEquals(rivienMaara, rivit);
    }

    @Test
    public void taulukonSarakkeidenMaaraVastaaSarakeAsteikonPituutta() {
        int sarakkeidenMaara = this.tehtava.getSarakeAsteikko().length;
        int sarakkeet = this.tehtava.getDataTaulukko()[0].length;
        assertEquals(sarakkeidenMaara, sarakkeet);
    }

    @Test
    public void testinValintaTehtavanOhjeSisältääOikeanVaihtoEhdon() {
        boolean arvo = false;
        OsaTehtava testinValinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = testinValinta.getOhjeistus();
        if (ohje.contains("Khiin neliön riippumattomuustesti")) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void testinValintaTehtavaanOikeinVastausPalauttaaArvonYksi() {
        int vastaus;
        OsaTehtava testinValinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = testinValinta.getOhjeistus();

        if (ohje.contains("A = 1: Khiin neliön riippumattomuustesti")) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: Khiin neliön riippumattomuustesti")) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: Khiin neliön riippumattomuustesti")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = testinValinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void testinValintaTehtavaanVaarinVastausPalauttaaArvonNolla() {
        int vastaus;
        OsaTehtava testinValinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = testinValinta.getOhjeistus();

        if (ohje.contains("A = 1: Khiin neliön riippumattomuustesti")) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: Khiin neliön riippumattomuustesti")) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: Khiin neliön riippumattomuustesti")) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = testinValinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void nollaHypoteesiTehtavaSisaltaaOikeanVaihtoehdon() {
        boolean arvo = false;
        OsaTehtava nollaHypoteesi = this.tehtava.getOsaTehtavat().get(1);
        String ohje = nollaHypoteesi.getOhjeistus();

        if (ohje.contains("A = 1: Luokkien "
                + "frekvenssit ovat toisistaan riippumattomia.")) {
            arvo = true;
        }

        assertEquals(true, arvo);
    }

    @Test
    public void nollaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava nollaHypoteesi = this.tehtava.getOsaTehtavat().get(1);
        int suoritus = nollaHypoteesi.suorita(1);
        assertEquals(suoritus, 1);
    }

    @Test
    public void nollaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava nollaHypoteesi = this.tehtava.getOsaTehtavat().get(1);
        int suoritus = nollaHypoteesi.suorita(3);
        assertEquals(suoritus, 0);
    }

    @Test
    public void vastaHypoteesiTehtavaSisaltaaOikeanVaihtoEhdon() {
        OsaTehtava vastaHypoteesi = this.tehtava.getOsaTehtavat().get(2);
        String ohje = vastaHypoteesi.getOhjeistus();
        assertEquals(ohje.contains("B = 2: Luokkien frekvenssit "
                + "eivät ole toisistaan riippumattomia"), true);
    }

    @Test
    public void vastaHypoteesiTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava vastaHypoteesi = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = vastaHypoteesi.suorita(2);
        assertEquals(suoritus, 1);
    }

    @Test
    public void vastaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava vastaHypoteesi = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = vastaHypoteesi.suorita(1);
        assertEquals(suoritus, 0);
    }

    @Test
    public void khiinNelioTehtavaSisaltaaOikeanVaihtoEhdon() {
        OsaTehtava khiinNelio = this.tehtava.getOsaTehtavat().get(3);
        Double khii = this.tehtava.getKhii().getKhiinNelio();
        String khiiString = "" + khii;
        assertEquals(khiinNelio.getOhjeistus().contains(khiiString), true);
    }

    @Test
    public void khiinNelioTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava khiiNelio = this.tehtava.getOsaTehtavat().get(3);
        int vastaus;

        Double khii = this.tehtava.getKhii().getKhiinNelio();
        String khiiString = "" + khii;
        String ohje = khiiNelio.getOhjeistus();

        if (ohje.contains("A = 1: " + khiiString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + khiiString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + khiiString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = khiiNelio.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void khiinNelioTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava khiiNelio = this.tehtava.getOsaTehtavat().get(3);
        int vastaus;

        Double khii = this.tehtava.getKhii().getKhiinNelio();
        String khiiString = "" + khii;
        String ohje = khiiNelio.getOhjeistus();

        if (ohje.contains("A = 1: " + khiiString)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + khiiString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + khiiString)) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = khiiNelio.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void pArvoTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava pArvoTehtava = this.tehtava.getOsaTehtavat().get(4);
        String pArvo = this.tehtava.getKhii().getpArvo();
        String ohje = pArvoTehtava.getOhjeistus();
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

        int suoritus = pArvoTehtava.suorita(vastaus);
        assertEquals(suoritus, 1);

    }

    @Test
    public void pArvoTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava pArvoTehtava = this.tehtava.getOsaTehtavat().get(4);
        String pArvo = this.tehtava.getKhii().getpArvo();
        String ohje = pArvoTehtava.getOhjeistus();
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

        int suoritus = pArvoTehtava.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

}
