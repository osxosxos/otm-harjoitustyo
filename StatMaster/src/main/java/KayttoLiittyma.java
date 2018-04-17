
import java.util.Random;
import java.util.Scanner;

/**
 * Ohjelman käyttöliittymä. Tähän tulee sisään kirjautuminen myöhemmin.
 *
 * @author Oskari Koskinen
 */
public class KayttoLiittyma {

    Random random;
    Scanner scanner;

    public KayttoLiittyma() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void kaynnista() {
        while (true) {
            System.out.println("Mitä haluat tehdä?");
            System.out.println("1 = Harjoittele");
            System.out.println("2 = Lopeta");
            System.out.print("Syötä komento tähän:");
            int komento = Integer.parseInt(scanner.nextLine());
            if (komento == 1) {
                this.harjoittele();
            } else {
                break;
            }
        }
    }

    /**
     * Arpoo satunnaisen tehtavän satunnaisesta aiheesta.
     */
    public void harjoittele() {
        int luku = random.nextInt(3);
        if (luku == 0) {
            PearsonKorrelaatioTehtava tehtava = new PearsonKorrelaatioTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita(scanner);
        } else if (luku == 1) {
            RiippumattomienOtostenTTestiTehtava tehtava = new RiippumattomienOtostenTTestiTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita();
        } else {
            ParittaistenOtostenTTestiTehtava tehtava = new ParittaistenOtostenTTestiTehtava();
            tehtava.luoUusiTehtava();
            tehtava.suorita(scanner);
        }
    }

}
