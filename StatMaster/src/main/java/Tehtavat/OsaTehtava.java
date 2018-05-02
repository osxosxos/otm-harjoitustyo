
package Tehtavat;

/**
 * Koska tilastollinen testaaminen ja todennäköisyyslaskenta sisältävät useita
 * eri vaiheita, on järkevää jakaa jokainen tehtävä useampaan eri osatehtävään.
 * Tehtävä on suoritettu vasta sitten, kun sen jokainen osatehtävä on
 * suoritettu. Jokainen osatehtävä on yhden pisteen arvoinen. Yrityksiä on yksi,
 * jos se menee väärin, ohjelma antaa oikean vastauksen.
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

    public String getOhjeistus() {
        return ohjeistus;
    }
    
    /**
     * Suoritetaan osatehtävä, jos vastaus on oikein, palautetaan yksi piste,
     * jos vastaus on väärin, palautetaan nolla pistettä.
     *
     * @param annettuVastaus Tehtävän vastausvaihtoehto kokonaislukuna.
     * @return Palauttaa arvon yksi, jos tehtävä on oikein, muulloin nollan.
     */
    public int suorita(int annettuVastaus) {
        if (annettuVastaus == this.vastaus) {
            return 1;
        } else {
            return 0;
        }
    }

}
