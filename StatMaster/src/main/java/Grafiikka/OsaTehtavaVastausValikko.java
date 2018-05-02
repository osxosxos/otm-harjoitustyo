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

    OsaTehtava osaTehtava;

    public OsaTehtavaVastausValikko(OsaTehtava osaTehtava) {
        this.osaTehtava = osaTehtava;
    }

    public Parent getNakyma() {

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
        
        yksi.setOnAction((event) -> {
            int vastaus = osaTehtava.suorita(1);
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
            int vastaus = osaTehtava.suorita(2);
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
            int vastaus = osaTehtava.suorita(3);
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
            int vastaus = osaTehtava.suorita(4);
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
