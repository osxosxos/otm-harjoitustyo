
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Oskari Koskinen
 */
public class StudentinTTestiParittaisilleOtoksilleTest {

    StudentinTTestiParittaisilleOtoksille testi1;

    @Before
    public void setUp() {
        this.testi1 = new StudentinTTestiParittaisilleOtoksille();

        ArrayList<Integer> dataEnnen = new ArrayList();
        dataEnnen.add(5);
        dataEnnen.add(6);
        dataEnnen.add(5);
        dataEnnen.add(7);
        dataEnnen.add(4);

        ArrayList<Integer> dataJalkeen = new ArrayList();
        dataJalkeen.add(15);
        dataJalkeen.add(16);
        dataJalkeen.add(12);
        dataJalkeen.add(17);
        dataJalkeen.add(12);

        testi1.laske(dataEnnen, dataJalkeen, 1);
    }

    @Test
    public void vapausAsteet1() {
        assertEquals(this.testi1.df, 4);
    }
    
    @Test
    public void erotustenKeskiArvo1() {
        assertEquals(this.testi1.erotustenKa, 9.00, 0.01);
    }

    @Test
    public void erotustenOtosKeskiHajonta1() {
        assertEquals(this.testi1.erotustenOtosKh, 1.41, 0.01);
    }

    @Test
    public void tArvoTesti1() {
        assertEquals(this.testi1.t, 14.27, 0.01);
    }

    @Test
    public void pArvo1() {
        assertEquals(this.testi1.pArvo, "p <0.001");
    }
    
}
