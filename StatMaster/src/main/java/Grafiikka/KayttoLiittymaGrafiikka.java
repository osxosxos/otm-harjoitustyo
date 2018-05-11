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
    public final void start(final Stage ikkuna) {

        final double ikkunanLeveys = 600;
        final double ikkunanKorkeus = 600;

        final int kolmeSijoitus = 3;
        final int neljaSijoitus = 4;

        ikkuna.setTitle("StatMaster 1.0");
        ikkuna.show();
        ikkuna.setMinWidth(ikkunanLeveys);
        ikkuna.setMinHeight(ikkunanKorkeus);

        GridPane asettelu = new GridPane();
        final double sisennys = 20;
        asettelu.setPadding(new Insets(sisennys));

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

        asettelu.add(komponenttiryhma, 0, kolmeSijoitus);

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
            asettelu.add(komponenttiryhma, 0, kolmeSijoitus);

            Random random = new Random();


            final int tehtava = random.nextInt(6);
            final int pearsonKorrelaatio = 0;
            final int khiiRiippumattomuus = 1;
            final int khiiYhteensopivuus = 2;
            final int parittainenT = 3;
            final int riippumatonT = 4;
            final int spearmanKorrelaatio = 5;

            if (tehtava == pearsonKorrelaatio) {
                PearsonTehtavaGrafiikka pearson = new PearsonTehtavaGrafiikka();
                Parent valikko = pearson.getNakyma();
                asettelu.add(valikko, 0, neljaSijoitus);
                event.consume();
            } else if (tehtava == khiiRiippumattomuus) {
                KhiinNelionRiippumattomuusGrafiikka khii
                        = new KhiinNelionRiippumattomuusGrafiikka();
                Parent valikko = khii.getNakyma();
                asettelu.add(valikko, 0, neljaSijoitus);
                event.consume();
            } else if (tehtava == khiiYhteensopivuus) {
                KhiinNelionYhteenSopivuusGrafiikka khii
                        = new KhiinNelionYhteenSopivuusGrafiikka();
                Parent valikko = khii.getNakyma();
                asettelu.add(valikko, 0, neljaSijoitus);
                event.consume();
            } else if (tehtava == parittainenT) {
                ParittainenTTestiGrafiikka t = new ParittainenTTestiGrafiikka();
                Parent valikko = t.getNakyma();
                asettelu.add(valikko, 0, neljaSijoitus);
                event.consume();
            } else if (tehtava == riippumatonT) {
                RiippumatonTTestiGrafiikka t = new RiippumatonTTestiGrafiikka();
                Parent valikko = t.getNakyma();
                asettelu.add(valikko, 0, neljaSijoitus);
                event.consume();
            } else if (tehtava == spearmanKorrelaatio) {
                SpearmanTehtavaGrafiikka r = new SpearmanTehtavaGrafiikka();
                Parent valikko = r.getNakyma();
                asettelu.add(valikko, 0, neljaSijoitus);
                event.consume();
            }

        });

        lopeta.setOnAction((event) -> {
            event.consume();
            ikkuna.close();
        });

    }

    /**
     * Käynnistää sovelluksen.
     * @param ikkuna Stage -olio, johon sovellus aukeaa.
     */
    public static void main(final Stage ikkuna) {
        launch(KayttoLiittymaGrafiikka.class);
    }
}
