package Grafiikka;

import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Oskari Koskinen
 */
public class KayttoLiittymaGrafiikka extends Application {

    @Override
    public void start(Stage ikkuna) {

        ikkuna.setTitle("StatMaster 1.0");
        ikkuna.show();
        ikkuna.setMinWidth(600);
        ikkuna.setMinHeight(600);

        GridPane asettelu = new GridPane();
        asettelu.setPadding(new Insets(20));

        Label tervetuloa = new Label("Tervetuloa käyttämään StatMasteria");
        Label aloitus = new Label("Uusi tehtävä luo uuden tehtävän");
        Label lopetus = new Label("Lopeta sammuttaa sovelluksen");

        asettelu.add(tervetuloa, 0, 0);
        asettelu.add(aloitus, 0, 1);
        asettelu.add(lopetus, 0, 2);

        Button uusi = new Button("Uusi Tehtävä");
        Button lopeta = new Button("Lopeta");

        HBox komponenttiryhma = new HBox();

        komponenttiryhma.getChildren().add(uusi);
        komponenttiryhma.getChildren().add(lopeta);

        asettelu.add(komponenttiryhma, 0, 3);

        ScrollPane scrollPane = new ScrollPane(asettelu);
        scrollPane.setFitToHeight(true);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();

        uusi.setOnAction((event) -> {

            asettelu.getChildren().clear();

            asettelu.add(tervetuloa, 0, 0);
            asettelu.add(aloitus, 0, 1);
            asettelu.add(lopetus, 0, 2);
            asettelu.add(komponenttiryhma, 0, 3);

            Random random = new Random();

            int tehtava = random.nextInt(6);
            if (tehtava == 0) {
                PearsonTehtavaGrafiikka pearson = new PearsonTehtavaGrafiikka();
                Parent valikko = pearson.getNakyma();
                asettelu.add(valikko, 0, 4);
                event.consume();
            } else if (tehtava == 1) {
                KhiinNelionRiippumattomuusGrafiikka khii
                        = new KhiinNelionRiippumattomuusGrafiikka();
                Parent valikko = khii.getNakyma();
                asettelu.add(valikko, 0, 4);
                event.consume();
            } else if (tehtava == 2) {
                KhiinNelionYhteenSopivuusGrafiikka khii
                        = new KhiinNelionYhteenSopivuusGrafiikka();
                Parent valikko = khii.getNakyma();
                asettelu.add(valikko, 0, 4);
                event.consume();
            } else if (tehtava == 3) {
                ParittainenTTestiGrafiikka t = new ParittainenTTestiGrafiikka();
                Parent valikko = t.getNakyma();
                asettelu.add(valikko, 0, 4);
                event.consume();
            } else if (tehtava == 4) {
                RiippumatonTTestiGrafiikka t = new RiippumatonTTestiGrafiikka();
                Parent valikko = t.getNakyma();
                asettelu.add(valikko, 0, 4);
                event.consume();
            } else if (tehtava == 5) {
                SpearmanTehtavaGrafiikka r = new SpearmanTehtavaGrafiikka();
                Parent valikko = r.getNakyma();
                asettelu.add(valikko, 0, 4);
                event.consume();
            }

        });

        lopeta.setOnAction((event) -> {
            event.consume();
            ikkuna.close();
        });

    }

    public static void main(Stage ikkuna) {
        launch(KayttoLiittymaGrafiikka.class);
    }
}
