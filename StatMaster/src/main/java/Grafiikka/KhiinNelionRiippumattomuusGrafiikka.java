package Grafiikka;

import Tehtavat.KhiinNelionRiippumattomuusTestiTehtava;
import Tehtavat.OsaTehtava;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Graafinen käyttöliittyma, jolla suoritetaan satunnaisesti luotu Pearsonin
 * korrelaation laskemistehtävä.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionRiippumattomuusGrafiikka {

    /**
     * Indeksi kuvaa tehtävän osatehtävien numeroita.
     */
    private int indeksi;
    /**
     * Tehtava kuvaa tehtävän aihetta, eli suoritettavaa tilastollista testiä.
     */
    private KhiinNelionRiippumattomuusTestiTehtava tehtava;

    /**
     * Luokan konstruktori asettaa indeksin nollaksi, eli tehtävän suorittaminen
     * alkaa ensimmäisestä osatehtävästä. Konstruktori luo automaattisesti
     * kutsuttaessa uuden tehtävän.
     */
    public KhiinNelionRiippumattomuusGrafiikka() {
        this.indeksi = 0;
        this.tehtava = new KhiinNelionRiippumattomuusTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    /**
     * Kasvattaa indeksiä. Indeksin kasvattamisen ansiosta käyttöliittymässä
     * seuraava osatehtävä tulee näkyviin ja edellinen menee piiloon.
     */
    public final void kasvataIndeksia() {
        if (this.indeksi < this.tehtava.getOsaTehtavat().size()) {
            this.indeksi++;
        }
    }

    /**
     * Valikko, jolla tehtävän osatehtävä ratkaistaan.
     *
     * @return Palauttaa GridPane -objektin.
     */
    public final Parent getNakyma() {

        GridPane asettelu = new GridPane();

        Label ohje = new Label(this.tehtava.getOhje());
        Button seuraava = new Button("Siirry seuraavaan osatehtävään");

        asettelu.add(ohje, 0, 0);
        asettelu.add(seuraava, 0, 2);

        ArrayList<OsaTehtava> osaTehtavat = tehtava.getOsaTehtavat();

        OsaTehtavaVastausValikko valikko
                = new OsaTehtavaVastausValikko(osaTehtavat.get(indeksi));
        Parent nakyma = valikko.getNakyma();
        asettelu.add(nakyma, 0, 1);

        seuraava.setOnAction((event) -> {

            asettelu.getChildren().remove(nakyma);
            this.kasvataIndeksia();
            asettelu.getChildren().clear();
            asettelu.add(ohje, 0, 0);

            OsaTehtavaVastausValikko uusi
                    = new OsaTehtavaVastausValikko(osaTehtavat.get(indeksi));
            asettelu.add(uusi.getNakyma(), 0, 1);

            if (this.indeksi < osaTehtavat.size() - 1) {
                asettelu.add(seuraava, 0, 2);
            }
            event.consume();
        });

        return asettelu;
    }

}
