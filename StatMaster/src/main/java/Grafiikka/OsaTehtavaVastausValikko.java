package Grafiikka;

import Tehtavat.OsaTehtava;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Oskari Koskinen
 */
public class OsaTehtavaVastausValikko {

    /**
     * Osatehtävä, jota valikossa suoritetaan.
     */
    private OsaTehtava osaTehtava;

    /**
     * Konstruktori saa syötteenä osatehtävän, jota valikolla ratkaistaan.
     *
     * @param tehtava Osatehtävä, jolle valikko luodaan.
     */
    public OsaTehtavaVastausValikko(final OsaTehtava tehtava) {
        this.osaTehtava = tehtava;
    }

    /**
     * Geneerinen valikko osatehtävän ratkaisemikseksi. Sisältää tehtävän
     * ohjeen, vastausnapit ja ilmoituksen siitä onko tehtävän vastaus oikein
     * vai väärin.
     *
     * @return Palauttaa GridPane -objektin.
     */
    public final Parent getNakyma() {

        GridPane asettelu = new GridPane();

        Label ohje = new Label(this.osaTehtava.getOhjeistus());

        HBox komponenttiryhma = new HBox();

        Button yksi = new Button("1");
        Button kaksi = new Button("2");
        Button kolme = new Button("3");
        Button nelja = new Button("4");

        komponenttiryhma.getChildren().add(yksi);
        komponenttiryhma.getChildren().add(kaksi);
        komponenttiryhma.getChildren().add(kolme);
        komponenttiryhma.getChildren().add(nelja);

        asettelu.add(ohje, 0, 0);
        asettelu.add(komponenttiryhma, 0, 1);

        Label vaarin = new Label("Vastaus on väärin!");
        Label oikein = new Label("Vastaus on oikein!");

        final int vastausYksi = 1;
        final int vastausKaksi = 2;
        final int vastausKolme = 3;
        final int vastausNelja = 4;

        yksi.setOnAction((event) -> {
            int vastaus = osaTehtava.suorita(vastausYksi);
            if (vastaus == 0) {
                asettelu.add(vaarin, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            } else {
                asettelu.add(oikein, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            }
            event.consume();
        });

        kaksi.setOnAction((event) -> {
            int vastaus = osaTehtava.suorita(vastausKaksi);
            if (vastaus == 0) {
                asettelu.add(vaarin, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            } else {
                asettelu.add(oikein, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            }
            event.consume();
        });

        kolme.setOnAction((event) -> {
            int vastaus = osaTehtava.suorita(vastausKolme);
            if (vastaus == 0) {
                asettelu.add(vaarin, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            } else {
                asettelu.add(oikein, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            }
            event.consume();
        });

        nelja.setOnAction((event) -> {
            int vastaus = osaTehtava.suorita(vastausNelja);
            if (vastaus == 0) {
                asettelu.add(vaarin, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            } else {
                asettelu.add(oikein, 0, 1);
                asettelu.getChildren().remove(komponenttiryhma);
            }
            event.consume();
        });

        return asettelu;

    }

}
