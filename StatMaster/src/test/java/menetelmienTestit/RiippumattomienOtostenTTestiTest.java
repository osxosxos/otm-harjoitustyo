package menetelmienTestit;


import TilastollisetTestit.StudentinTTestiRiippumattomilleOtoksille;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari Koskinen
 */
public class RiippumattomienOtostenTTestiTest {
    StudentinTTestiRiippumattomilleOtoksille t;
        
    @Before
    public void setUp() {
        
        ArrayList<Integer>dataX = new ArrayList();
        ArrayList<Integer>dataY = new ArrayList();
        
        dataX.add(10);
        dataX.add(9);
        dataX.add(7);
        dataX.add(3);
        dataX.add(5);
        
        dataY.add(3);
        dataY.add(2);
        dataY.add(4);
        dataY.add(2);
        dataY.add(6);
        
        this.t = new StudentinTTestiRiippumattomilleOtoksille();
        this.t.laske(dataX, dataY, 1);        
    }
    
    @Test
    public void tArvo() {
        assertEquals(this.t.getT(), 2.29,0.01);
    }
    
    @Test
    public void pArvo() {
        assertEquals(this.t.getpArvo(), "p <0.05");
    }
    
}
