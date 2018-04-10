
import java.util.Scanner;

/**
 * Koska tilastollinen testaaminen ja todennäköisyyslaskut sisältävät useita eri
 * vaiheita, on järkevää jakaa jokainen tehtävä useampaan eri osatehtävään.
 * Tehtävä on suoritettu vasta sitten, kun sen jokainen osatehtävä on
 * suoritettu.
 *
 * @author Oskari Koskinen
 */
public class OsaTehtava {

    boolean suoritettu;
    double vastaus;
    String ohjeistus;

    public OsaTehtava(double vastaus, String ohjeistus) {
        this.suoritettu = false;
        this.vastaus = vastaus;
        this.ohjeistus = ohjeistus;
    }

    /**
     * Suoritetaan osatehtävä, jos menee oikein, suoritettu saa arvon true ja
     * tehtävää ei enää esitetä käyttäjälle.
     */
    public void suorita() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(ohjeistus);

        while (true) {
            System.out.print("Anna vastaus tähän:");
            Double annettuVastaus = Double.parseDouble(scanner.nextLine().trim());
            if (annettuVastaus == this.vastaus) {
                System.out.println("Vastaus on oikein!");
                System.out.println("");
                break;                
            } else {
                System.out.println("Vastaus on väärin!");
                System.out.println("Yritä uudelleen!");
                System.out.println("");
            }
        }

    }

}
