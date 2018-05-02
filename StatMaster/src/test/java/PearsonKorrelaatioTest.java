
import TilastollisetTestit.PearsonKorrelaatio;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka Pearsonin korrelaatiokertoimen testaamiseen.
 *
 * @author Oskari Koskinen
 */
public class PearsonKorrelaatioTest {

    PearsonKorrelaatio r = new PearsonKorrelaatio();

    @Before
    public void setUp() {

        ArrayList<Integer> dataX = new ArrayList<>();
        ArrayList<Integer> dataY = new ArrayList<>();
        dataX.add(5);
        dataX.add(20);
        dataX.add(40);
        dataX.add(80);
        dataX.add(100);
        dataY.add(10);
        dataY.add(24);
        dataY.add(33);
        dataY.add(54);
        dataY.add(10);

        r.laske(dataX, dataY);

    }

    @Test
    public void kovarianssi() {
        assertEquals(187.75, r.cov, 0.01);
    }

    @Test
    public void korrelaatio() {
        assertEquals(0.2552, r.cor, 0.01);
    }

    @Test
    public void pArvo() {
        assertEquals("ns", r.pArvo);
    }

}
