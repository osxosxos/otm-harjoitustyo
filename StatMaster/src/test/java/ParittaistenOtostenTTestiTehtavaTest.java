
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testit parittaisten otosten t-testi tehtävägeneraattorille.
 * 
 * @author Oskari Koskinen
 */
public class ParittaistenOtostenTTestiTehtavaTest {
    
    StudentinTTestiParittaisilleOtoksille testi;
    ParittaistenOtostenTTestiTehtava tehtava;
    
    @Before
    public void setUp() {
        this.testi = new StudentinTTestiParittaisilleOtoksille();
        this.tehtava = new ParittaistenOtostenTTestiTehtava();        
    }
    

}
