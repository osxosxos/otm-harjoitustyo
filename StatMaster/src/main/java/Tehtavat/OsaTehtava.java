
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

    /**
     * Osatehtävän vastaus kokonaislukuna.
     */
    private int vastaus;
    /**
     * Osatehtävän ohjeistus merkkijonona.
     */
    private String ohjeistus;

    /**
     * Jokainen sovelluksen tehtävä koostuu useista osatehtävistä. Osatehtävillä
     * on kaikilla uniikki ohjeistus ja yksi oikea vastaus. Vastaus on
     * kokonaisluku, joka kuvaa oikean vaihtoehdon numeroa.
     *
     * @param oikeaVastaus Osatehtävän oikea vastaus kokonaislukuna.
     * @param tehtavanOhjeistus Ohje osatehtävän suorittamiseen, joka sisältää
     * vastausvaihtoehdot ja niiden numerot yhtenä merkkijonona.
     */
    public OsaTehtava(final int oikeaVastaus, final String tehtavanOhjeistus) {
        this.vastaus = oikeaVastaus;
        this.ohjeistus = tehtavanOhjeistus;
    }

    /**
     * Palauttaa osatehtävän ohjeen.
     *
     * @return Palauttaa merkkijonon.
     */
    public final String getOhjeistus() {
        return ohjeistus;
    }

    /**
     * Suoritetaan osatehtävä, jos vastaus on oikein, palautetaan yksi piste,
     * jos vastaus on väärin, palautetaan nolla pistettä.
     *
     * @param annettuVastaus Tehtävän vastausvaihtoehto kokonaislukuna.
     * @return Palauttaa arvon yksi, jos tehtävä on oikein, muulloin nollan.
     */
    public final int suorita(final int annettuVastaus) {
        if (annettuVastaus == this.vastaus) {
            return 1;
        } else {
            return 0;
        }
    }

}
