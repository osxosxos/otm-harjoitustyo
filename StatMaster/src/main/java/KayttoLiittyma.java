
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
    Logiikka logiikka;

    public KayttoLiittyma() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.logiikka = new Logiikka();
    }

    public void kaynnista() {
        while (true) {
            System.out.println("Mitä haluat tehdä?");
            System.out.println("1 = Harjoittele");
            System.out.println("2 = Lopeta");
            System.out.print("Syötä komento tähän:");
            int komento = Integer.parseInt(scanner.nextLine());
            if (komento == 1) {
                this.logiikka.harjoittele();
            } else {
                break;
            }
        }
    }

}
