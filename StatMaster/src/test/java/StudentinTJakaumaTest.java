
import Jakaumat.StudentinTJakauma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari Koskinen
 */
public class StudentinTJakaumaTest {

    StudentinTJakauma t;

    @Before
    public void setUp() {
        this.t = new StudentinTJakauma();
    }
    
    @Test
    public void yksiSuuntainenPArvo1() {
        assertEquals(t.yksiSuuntainen(5, 1), "ns");
        assertEquals(t.yksiSuuntainen(5, 2.3), "p <0.05");
        assertEquals(t.yksiSuuntainen(5, 3.2), "p <0.01");
        assertEquals(t.yksiSuuntainen(5, 5.7), "p <0.001");
        assertEquals(t.yksiSuuntainen(5, 4545.45), "p <0.001");
    }
        
    @Test
    public void kaksiSuuntainenPArvo1() {
        assertEquals(t.kaksiSuuntainen(10, 1.0), "ns");
        assertEquals(t.kaksiSuuntainen(10, 2.3), "p <0.05");
        assertEquals(t.kaksiSuuntainen(10, 3.2), "p <0.01");
        assertEquals(t.kaksiSuuntainen(10, 6.0), "p <0.001");
        assertEquals(t.kaksiSuuntainen(10, 4242.43), "p <0.001");
    }
}
