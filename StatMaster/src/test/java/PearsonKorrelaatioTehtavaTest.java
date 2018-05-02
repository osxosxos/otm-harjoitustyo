
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

}
