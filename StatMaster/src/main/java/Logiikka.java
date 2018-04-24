
import java.util.Random;

/**
 *
 * @author Oskari Koskinen
 */
public class Logiikka {

    Random random;

    public Logiikka() {
        this.random = new Random();
    }

    public void harjoittele() {
        int luku = random.nextInt(5);
        if (luku == 0) {
            PearsonKorrelaatioTehtava tehtava = new PearsonKorrelaatioTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita();
        } else if (luku == 1) {
            RiippumattomienOtostenTTestiTehtava tehtava = new RiippumattomienOtostenTTestiTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita();
        } else if (luku == 2) {
            ParittaistenOtostenTTestiTehtava tehtava = new ParittaistenOtostenTTestiTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita();
        } else if (luku == 3) {
            KhiinNelionYhteenSopivuusTestiTehtava tehtava = new KhiinNelionYhteenSopivuusTestiTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita();
        } else {
            KhiinNelionRiippumattomuusTestiTehtava tehtava = new KhiinNelionRiippumattomuusTestiTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita();
        }
    }
}
