
import TilastollisetTestit.KhiinNelionRiippumattomuusTesti;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testiluokka khiin neliön riippumattomuustestille.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusTestiTest {

    KhiinNelionRiippumattomuusTesti khii1;

    @Before
    public void setUp() {
        this.khii1 = new KhiinNelionRiippumattomuusTesti();

        int[][] data = new int[][]{
            {5, 10},
            {10, 15},
            {5, 20}
        };

        khii1.laske(data);

    }

    @Test
    public void setN1() {
        assertEquals(khii1.n, 65);
    }

    @Test
    public void rivit1() {
        assertEquals(khii1.rivit, 3);
    }

    @Test
    public void sarakkeet1() {
        assertEquals(khii1.sarakkeet, 2);
    }

    @Test
    public void riviFrekvenssit1() {
        int[] odotus = new int[]{15, 25, 25};
        Assert.assertArrayEquals(odotus, khii1.riviFrekvenssit);
    }

    @Test
    public void sarakeFrekvenssit1() {
        int[] odotus = new int[]{20, 45};
        Assert.assertArrayEquals(odotus, khii1.sarakeFrekvenssit);
    }

    @Test
    public void odotetutFrekvenssit1() {

        boolean ylittyyko = false;

        double[][] odotus = new double[][]{
            {4.62, 10.38},
            {7.69, 17.31},
            {7.69, 17.31}
        };

        for (int i = 0; i < odotus.length; i++) {
            for (int j = 0; j < odotus[0].length; j++) {
                double erotus = odotus[i][j] - khii1.odotetutFrekvenssit[i][j];
                double itseisarvo = Math.abs(erotus);
                if (itseisarvo > 0.1) {
                    ylittyyko = true;
                }
            }
        }

        assertEquals(false, ylittyyko);
    }

    @Test
    public void khiinNelioArvo1() {
        assertEquals(2.41, khii1.khiinNelio, 0.01);
    }
    
    @Test 
    public void pArvo() {
        assertEquals("ns",khii1.pArvo);
    }
         
}
