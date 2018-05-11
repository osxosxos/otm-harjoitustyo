package tehtavaTestit;

import Tehtavat.OsaTehtava;
import Tehtavat.PearsonKorrelaatioTehtava;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari Koskinen
 */
public class PearsonKorrelaatioTehtavaTest {

    PearsonKorrelaatioTehtava tehtava;

    @Before
    public void setUp() {
        this.tehtava = new PearsonKorrelaatioTehtava();
        this.tehtava.luoUusiTehtava();
    }

    @Test
    public void muuttujatXjaYeivatOleSamat() {
        boolean arvo = false;
        int muuttujaX = this.tehtava.getMuuttujaX();
        int muuttujaY = this.tehtava.getMuuttujaY();
        if (muuttujaX != muuttujaY) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void muuttujallaXonArvojaEnemmanKuinNolla() {
        boolean arvo = false;
        int listaXkoko = this.tehtava.getMuuttujanXarvot().size();
        if (listaXkoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void muuttujallaYonArvojaEnemmanKuinNolla() {
        boolean arvo = false;
        int listaYkoko = this.tehtava.getMuuttujanYarvot().size();
        if (listaYkoko > 0) {
            arvo = true;
        }
        assertEquals(true, arvo);
    }

    @Test
    public void muuttujillaOnSamaMaaraHavaintoja() {
        int listaXkoko = this.tehtava.getMuuttujanXarvot().size();
        int listaYkoko = this.tehtava.getMuuttujanYarvot().size();
        assertEquals(listaXkoko, listaYkoko);
    }

    @Test
    public void testinValintaTehtavaSisaltaaOikeanTestin() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        assertEquals(ohje.contains("Pearsonin korrelaatio"), true);
    }

    @Test
    public void testinValintaTehtavaanOikeinVastausPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        int vastaus = 0;

        if (ohje.contains("A = 1: Pearsonin korrelaatio")) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: Pearsonin korrelaatio")) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: Pearsonin korrelaatio")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);

    }

    @Test
    public void testinValintaTehtavaanVaarinVastausPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(0);
        String ohje = valinta.getOhjeistus();
        int vastaus = 0;

        if (ohje.contains("A = 1: Pearsonin korrelaatio")) {
            vastaus = 2;
        } else if (ohje.contains("B = 2: Pearsonin korrelaatio")) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: Pearsonin korrelaatio")) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void korrelaationLaskemisTehtavaSisaltaaOikeanVaihtoehdon() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        String ohje = valinta.getOhjeistus();
        double cor = this.tehtava.getR().getCor();
        String corString = "" + cor;
        assertEquals(ohje.contains(corString), true);
    }

    @Test
    public void korrelaatioTehtavaanOikeinVastaaminenPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        String ohje = valinta.getOhjeistus();
        double cor = this.tehtava.getR().getCor();
        String corString = "" + cor;

        int vastaus = 0;

        if (ohje.contains("A = 1: " + corString)) {
            vastaus = 1;
        } else if (ohje.contains("B = 2: " + corString)) {
            vastaus = 2;
        } else if (ohje.contains("C = 3: " + corString)) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void korrelaatioTehtavaanVaarinVastaaminenPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(1);
        String ohje = valinta.getOhjeistus();
        double cor = this.tehtava.getR().getCor();
        String corString = "" + cor;

        int vastaus = 0;

        if (ohje.contains("A = 1: " + corString)) {
            vastaus = 4;
        } else if (ohje.contains("B = 2: " + corString)) {
            vastaus = 1;
        } else if (ohje.contains("C = 3: " + corString)) {
            vastaus = 2;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);
    }

    @Test
    public void nollaHypoteesiTehtavaSisaltaaOikeanVaihtoEhdon() {
        OsaTehtava nolla = this.tehtava.getOsaTehtavat().get(2);
        String ohje = nolla.getOhjeistus();
        assertEquals(ohje.contains("Muuttujien "
                + "välillä ei ole lineaarista yhteyttä."), true);
    }

    @Test
    public void nollaHypoteesiTehtavaanOikeinVastaaminenPalauttaaArvonYksi() {
        OsaTehtava nolla = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = nolla.suorita(1);
        assertEquals(suoritus, 1);
    }

    @Test
    public void nollaHypoteesiTehtavaanVaarinVastaaminenPalauttaaArvonNolla() {
        OsaTehtava nolla = this.tehtava.getOsaTehtavat().get(2);
        int suoritus = nolla.suorita(4);
        assertEquals(suoritus, 0);
    }

    @Test
    public void vastaHypoteesiTehtavaSisaltaaOikeanVaihtoEhdon() {
        OsaTehtava nolla = this.tehtava.getOsaTehtavat().get(3);
        String ohje = nolla.getOhjeistus();
        assertEquals(ohje.contains("Muuttujien "
                + "välillä on lineaarinen yhteys."), true);
    }

    @Test
    public void vastaHypoteesiTehtavaanOikeinVastaaminenPalauttaaArvonYksi() {
        OsaTehtava nolla = this.tehtava.getOsaTehtavat().get(3);
        int suoritus = nolla.suorita(2);
        assertEquals(suoritus, 1);
    }

    @Test
    public void vastaHypoteesiTehtavaanVaarinVastaaminenPalauttaaArvonNolla() {
        OsaTehtava nolla = this.tehtava.getOsaTehtavat().get(3);
        int suoritus = nolla.suorita(1);
        assertEquals(suoritus, 0);
    }

    @Test
    public void tArvoTehtavaSisaltaaOikeanVaihtoEhdon() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String ohje = valinta.getOhjeistus();
        double t = this.tehtava.getR().getT();
        String tString = "" + t;
        assertEquals(ohje.contains(tString), true);
    }

    @Test
    public void tArvoTehtavaanOikeinVastaaminenPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String ohje = valinta.getOhjeistus();
        double t = this.tehtava.getR().getT();
        String tString = "" + t;

        int vastaus = 0;

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
    public void tArvoTehtavaanVaarinVastaaminenPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(4);
        String ohje = valinta.getOhjeistus();
        double t = this.tehtava.getR().getT();
        String tString = "" + t;

        int vastaus = 0;

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
    public void pArvoTehtavaanOikeinVastaaminenPalauttaaArvonYksi() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String pArvo = this.tehtava.getR().getpArvo();

        int vastaus = 0;

        if (pArvo.equals("ns")) {
            vastaus = 1;
        } else if (pArvo.equals("p <0.05")) {
            vastaus = 2;
        } else if (pArvo.equals("p <0.01")) {
            vastaus = 3;
        } else {
            vastaus = 4;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 1);
    }

    @Test
    public void pArvoTehtavaanVaarinVastaaminenPalauttaaArvonNolla() {
        OsaTehtava valinta = this.tehtava.getOsaTehtavat().get(5);
        String pArvo = this.tehtava.getR().getpArvo();

        int vastaus = 0;

        if (pArvo.equals("ns")) {
            vastaus = 2;
        } else if (pArvo.equals("p <0.05")) {
            vastaus = 1;
        } else if (pArvo.equals("p <0.01")) {
            vastaus = 4;
        } else {
            vastaus = 3;
        }

        int suoritus = valinta.suorita(vastaus);
        assertEquals(suoritus, 0);

    }

}
