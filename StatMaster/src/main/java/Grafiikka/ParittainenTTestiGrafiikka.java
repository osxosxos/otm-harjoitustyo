package Grafiikka;

import Tehtavat.OsaTehtava;
import Tehtavat.ParittaistenOtostenTTestiTehtava;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Oskari Koskinen
 */
public class ParittainenTTestiGrafiikka {

    /**
     * Indeksi kuvaa tehtävän osatehtävien numeroita.
     */
    private int indeksi;
    /**
     * Tehtävän tyyppi.
     */
    private ParittaistenOtostenTTestiTehtava tehtava;

    /**
     * Konstruktori asettaa indeksin alkaamaan nollasta, eli tehtävän
     * ratkaiseminen alkaa ensimmäisestä osatehtävästä. Konstruktori tuo uuden
     * tehtävän kutsuttaessa.
     */
    public ParittainenTTestiGrafiikka() {
        this.indeksi = 0;
        this.tehtava = new ParittaistenOtostenTTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    /**
     * Kasvattaa indeksiä, eli siirtyy seuraavaan osatehtävään.
     */
    public final void kasvataIndeksia() {
        if (this.indeksi < this.tehtava.getOsaTehtavat().size()) {
            this.indeksi++;
        }
    }

    /**
     * Graafinen käyttöliittymän pala osatehtävän ratkaisemiseksi.
     *
     * @return Palautaa GridPane -objektin.
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
