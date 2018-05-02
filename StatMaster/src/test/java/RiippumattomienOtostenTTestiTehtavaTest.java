
import Tehtavat.RiippumattomienOtostenTTestiTehtava;
import java.util.ArrayList;
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

}
