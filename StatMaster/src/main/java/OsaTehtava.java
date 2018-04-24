
import java.util.Scanner;

/**
 * Koska tilastollinen testaaminen ja todennäköisyyslaskenta sisältävät useita
 * eri vaiheita, on järkevää jakaa jokainen tehtävä useampaan eri osatehtävään.
 * Tehtävä on suoritettu vasta sitten, kun sen jokainen osatehtävä on
 * suoritettu. Jokainen osatehtävä on yhden pisteen arvoinen. Yrityksiä on 
 * yksi, jos se menee väärin, ohjelma antaa oikean vastauksen.
 *
 * @author Oskari Koskinen
 */
public class OsaTehtava {

    int vastaus;
    String ohjeistus;

    public OsaTehtava(int vastaus, String ohjeistus) {
        this.vastaus = vastaus;
        this.ohjeistus = ohjeistus;
    }

    /**
     * Suoritetaan osatehtävä, jos vastaus on oikein, palautetaan yksi piste,
     * jos vastaus on väärin, palautetaan nolla pistettä. 
     *
     * @param scanner Skanneri vastausten lukemiseksi.
     * @return Palauttaa arvon yksi, jos tehtävä on oikein, muulloin nollan.
     */
    public int suorita(Scanner scanner) {

        System.out.println(ohjeistus);
        System.out.print("Anna vastaus tähän:");
        
        int annettuVastaus = Integer.parseInt(scanner.nextLine().trim());
        
        if (annettuVastaus == this.vastaus) {
            System.out.println("Vastaus on oikein!");
            System.out.println("");
            return 1;
        } else {
            System.out.println("Vastaus on väärin!");
            System.out.println("Oikea vastausvaihtoehto oli: " + this.vastaus);
            System.out.println("");
            return 0;
        }
    }

}
