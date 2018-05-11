package menetelmienTestit;


import TilastollisetTestit.KhiinNelionYhteenSopivuusTesti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Löllö
 */
public class KhiinNelionYhteenSopivuusTestiTest {

    KhiinNelionYhteenSopivuusTesti testi1;
        
    @Before
    public void setUp() {
        this.testi1 = new KhiinNelionYhteenSopivuusTesti();
        
        int[]havaitut = new int[]{10,15,20,25,30};
        int[]teoreettiset = new int[]{20,20,20,20,20};
        testi1.laske(havaitut, teoreettiset);
    }
    
    @Test
    public void khiinNelio1() {
        assertEquals(12.5, testi1.getKhiinNelio(), 0.01);
    }
    
    @Test
    public void khiinNelio2() {
        assertEquals("p <0.05",testi1.getpArvo());
    }
    
}
