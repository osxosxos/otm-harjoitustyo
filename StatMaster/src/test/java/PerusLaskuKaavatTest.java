
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Peruslaskukaavojen testit.
 *
 * @author Oskari Koskinen
 */
public class PerusLaskuKaavatTest {

    PerusLaskuKaavat kaavat;

    @Before
    public void setUp() {
        this.kaavat = new PerusLaskuKaavat();
    }

    @Test
    public void pyoristaKahteenDesimaaliin() {
        double tulos = kaavat.pyoristaKahteenDesimaaliin(0.435349789);
        assertEquals(tulos, 0.44, 0.001);
    }

    @Test
    public void summa() {

        ArrayList<Integer> arvot = new ArrayList();

        arvot.add(1);
        arvot.add(2);
        arvot.add(3);

        assertEquals(6, kaavat.summa(arvot));

    }

    @Test
    public void keskiarvo() {

        ArrayList<Integer> arvot = new ArrayList();

        arvot.add(1);
        arvot.add(2);
        arvot.add(3);

        assertEquals(kaavat.keskiarvo(arvot), 2.0, 0.01);

    }

    @Test
    public void nelioSumma() {

        ArrayList<Integer> arvot = new ArrayList();

        arvot.add(2);
        arvot.add(4);
        arvot.add(6);

        assertEquals(kaavat.nelioSumma(arvot), 8, 0.001);

    }

    @Test
    public void otosKeskiHajonta() {

        ArrayList<Integer> arvot = new ArrayList();

        arvot.add(2);
        arvot.add(4);
        arvot.add(6);

        assertEquals(kaavat.otosKeskihajonta(arvot), 2, 0.001);

    }

}
