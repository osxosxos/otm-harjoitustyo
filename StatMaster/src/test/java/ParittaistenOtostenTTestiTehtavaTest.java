
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

}
