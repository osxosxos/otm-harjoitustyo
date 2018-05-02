
package Grafiikka;

import Tehtavat.OsaTehtava;
import Tehtavat.RiippumattomienOtostenTTestiTehtava;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Oskari Koskinen
 */
public class RiippumatonTTestiGrafiikka {
    int indeksi;
    RiippumattomienOtostenTTestiTehtava tehtava;

    public RiippumatonTTestiGrafiikka() {
        this.indeksi = 0;
        this.tehtava = new RiippumattomienOtostenTTestiTehtava();
        this.tehtava.luoUusiTehtava();
    }

    public void kasvataIndeksia() {
        if (this.indeksi < this.tehtava.getOsaTehtavat().size()) {
            this.indeksi++;
        }
    }

    public Parent getNakyma() {

        GridPane asettelu = new GridPane();

        Label ohje = new Label(this.tehtava.getOhje());
        Button seuraava = new Button("Siirry seuraavaan osatehtävään");

        asettelu.add(ohje, 0, 0);
        asettelu.add(seuraava, 0, 2);

        ArrayList<OsaTehtava> osaTehtavat = tehtava.getOsaTehtavat();

        OsaTehtavaVastausValikko valikko = new OsaTehtavaVastausValikko(osaTehtavat.get(indeksi));
        Parent nakyma = valikko.getNakyma();
        asettelu.add(nakyma, 0, 1);

        seuraava.setOnAction((event) -> {

            asettelu.getChildren().remove(nakyma);
            this.kasvataIndeksia();
            asettelu.getChildren().clear();
            asettelu.add(ohje, 0, 0);

            OsaTehtavaVastausValikko uusi = new OsaTehtavaVastausValikko(osaTehtavat.get(indeksi));
            asettelu.add(uusi.getNakyma(), 0, 1);

            if (this.indeksi < osaTehtavat.size() - 1) {
                asettelu.add(seuraava, 0, 2);
            }
            event.consume();
        });

        return asettelu;
    }

}
