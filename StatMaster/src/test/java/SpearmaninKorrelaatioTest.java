
import TilastollisetTestit.SpearmaninKorrelaatio;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Löllö
 */
public class SpearmaninKorrelaatioTest {

    SpearmaninKorrelaatio rho;

    @Before
    public void setUp() {
        this.rho = new SpearmaninKorrelaatio();
    }

    @Test
    public void jarjestysAsteikko1() {
        ArrayList<Integer> uusi = new ArrayList();
        uusi.add(42);
        uusi.add(54);
        uusi.add(23);
        ArrayList<Integer> uusiJarjestys = rho.muunnaArvotJarjestysLuvuiksi(uusi);
        int kaksi = uusiJarjestys.get(0);
        int kolme = uusiJarjestys.get(1);
        int yksi = uusiJarjestys.get(2);
        assertEquals(kaksi, 2);
        assertEquals(kolme, 3);
        assertEquals(yksi, 1);
    }

    @Test
    public void laske() {
        ArrayList<Integer> dataX = new ArrayList();
        dataX.add(34);
        dataX.add(45);
        dataX.add(34);
        dataX.add(56);
        dataX.add(65);

        ArrayList<Integer> dataY = new ArrayList();
        dataY.add(65);
        dataY.add(56);
        dataY.add(34);
        dataY.add(23);
        dataY.add(22);
        
        rho.laske(dataX, dataY);
        assertEquals(rho.cor, -0.850,0.001);

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
