package tehtavaTestit;

import Tehtavat.KhiinNelionYhteenSopivuusTestiTehtava;
import Tehtavat.OsaTehtava;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionYhteenSopivuusTestiTehtavaTest {

    KhiinNelionYhteenSopivuusTestiTehtava tehtava;

    @Before
    public void setUp() {
        this.tehtava = new KhiinNelionYhteenSopivuusTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    @Test
    public void otosKokoSuurempiKuinNolla() {
        int otosKoko = this.tehtava.getN();
        boolean arvo = false;
        if (otosKoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void havaituissaFrekvensseissaLuokkiaEnemmanKuinNolla() {
        int havaitut = this.tehtava.getHavaitutFrekvenssit().length;
        boolean arvo = false;
        if (havaitut > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void teoreettisissaFrekvensseissaLuokkiaEnemmanKuinNolla() {
        int teoreettiset = this.tehtava.getTeoreettisetFrekvenssit().length;
        boolean arvo = false;
        if (teoreettiset > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void asteikonPituusSuurempiKuinNolla() {
        int asteikko = this.tehtava.getAsteikko().length;
        boolean arvo = false;
        if (asteikko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void taulukkojenPituudetVastaavatToisiaan() {
        int havaitut = this.tehtava.getHavaitutFrekvenssit().length;
        int teoreettiset = this.tehtava.getTeoreettisetFrekvenssit().length;
        int asteikko = this.tehtava.getAsteikko().length;
        boolean arvo = false;
        if (havaitut == teoreettiset
                && havaitut == asteikko
                && teoreettiset == asteikko) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void testinValintaTehtavassaOikeaVaihtoEhtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        String testi = "Khiin neliön yhteensopivuustesti";
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
        String testi = "Khiin neliön yhteensopivuustesti";
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
        String testi = "Khiin neliön yhteensopivuustesti";
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
    public void nollaHypoteesiTehtavassaOikeaVaihtoEhtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        String ohje = valinta.getOhjeistus();
        String nollaHypoteesi
                = "Havaitut ja odotetut frekvenssit eivät poikkea toisistaan.";
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
    public void vastaHypoteesiTehtavassaOikeaVaihtoEhtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        String ohje = valinta.getOhjeistus();
        String vastaHypoteesi
                = "Havaitut ja odotetut frekvenssit poikkeavat toisistaan";
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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = valinta.suorita(2);
        assertEquals(suoritus, 1);
    }

    @Test
    public void vastaHypoteesiTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = valinta.suorita(1);
        assertEquals(suoritus, 0);
    }

    @Test
    public void khiinNelioTehtavassaOikeaVaihtoEhtoVainKerran() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        String ohje = valinta.getOhjeistus();
        double khii = this.tehtava.getKhii().getKhiinNelio();
        String khiiString = "" + khii;

        boolean arvo = false;

        if (ohje.contains("A = 1: " + khiiString)
                && !ohje.contains("B = 2: " + khiiString)
                && !ohje.contains("C = 3: " + khiiString)
                && !ohje.contains("D = 4: " + khiiString)) {
            arvo = true;
        } else if (ohje.contains("B = 2: " + khiiString)
                && !ohje.contains("A = 1: " + khiiString)
                && !ohje.contains("C = 3: " + khiiString)
                && !ohje.contains("D = 4: " + khiiString)) {
            arvo = true;
        } else if (ohje.contains("C = 3: " + khiiString)
                && !ohje.contains("B = 2: " + khiiString)
                && !ohje.contains("A = 1: " + khiiString)
                && !ohje.contains("D = 4: " + khiiString)) {
            arvo = true;
        } else if (ohje.contains("D = 4: " + khiiString)
                && !ohje.contains("B = 2: " + khiiString)
                && !ohje.contains("C = 3: " + khiiString)
                && !ohje.contains("A = 1: " + khiiString)) {
            arvo = true;
        }
        assertEquals(arvo, true);
    }

    @Test
    public void khiinNelioTehtavanOikeaVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        double khii = this.tehtava.getKhii().getKhiinNelio();
        String ohje = valinta.getOhjeistus();
        String khiiString = "" + khii;

        int vastaus;

        if (ohje.contains("A = 1: " + khiiString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + khiiString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + khiiString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void khiinNelioTehtavanVaaraVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(3);
        double khii = this.tehtava.getKhii().getKhiinNelio();
        String ohje = valinta.getOhjeistus();
        String khiiString = "" + khii;

        int vastaus;

        if (ohje.contains("A = 1: " + khiiString)) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: " + khiiString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + khiiString)) {
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
        String pArvo = this.tehtava.getKhii().getpArvo();

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
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String pArvo = this.tehtava.getKhii().getpArvo();

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
