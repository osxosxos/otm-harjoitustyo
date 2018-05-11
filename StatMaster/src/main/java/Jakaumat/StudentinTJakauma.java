package Jakaumat;

/**
 * Luokka t-jakauman arvojen p-arvojen laskemiseen.
 *
 * @author Oskari Koskinen
 */
public class StudentinTJakauma {

    /**
     * Taulukko, jossa on jakauman vapausasteet.
     */
    private final int[] vapausAsteet;
    /**
     * Taulukko, jossa on jakauman kriittiset arvot.
     */
    private final double[][] jakaumataulu;

    /**
     * Uudella t-jakaumalla voi olla korkeintaan 20 vapausastetta. Taulukko
     * sisältää kriittiset arvot p-arvoille luvusta 0.10 eteenpäin. Seuraavat
     * p-arvot ovat taulukossa: 0.10, 0.05, 0.025, 0.01, 0.002 ja 0.001.
     */
    public StudentinTJakauma() {
        final int vapausAsteidenMaara = 20;
        this.vapausAsteet = new int[vapausAsteidenMaara];
        for (int i = 1; i <= vapausAsteidenMaara; i++) {
            this.vapausAsteet[i - 1] = i;
        }
        this.jakaumataulu = new double[][]{
            {6.314, 12.706, 31.820, 63.657, 127.321, 318.309, 636.619},
            {2.920, 4.303, 6.965, 9.925, 14.089, 22.327, 31.599},
            {2.353, 3.182, 4.541, 5.841, 7.453, 10.215, 12.924},
            {2.132, 2.776, 3.747, 4.604, 5.598, 7.173, 8.610},
            {2.015, 2.571, 3.365, 4.032, 4.773, 5.893, 6.869},
            {1.943, 2.447, 3.143, 3.707, 4.317, 5.208, 5.959},
            {1.895, 2.365, 2.998, 3.499, 4.029, 4.785, 5.408},
            {1.860, 2.306, 2.897, 3.355, 3.833, 4.501, 5.041},
            {1.833, 2.262, 2.821, 3.250, 3.690, 4.297, 4.781},
            {1.812, 2.228, 2.764, 3.169, 3.581, 4.144, 4.587},
            {1.796, 2.201, 2.718, 3.106, 3.497, 4.025, 4.437},
            {1.782, 2.179, 2.681, 3.055, 3.428, 3.930, 4.318},
            {1.771, 2.160, 2.650, 3.012, 3.372, 3.852, 4.221},
            {1.761, 2.145, 2.625, 2.977, 3.326, 3.787, 4.140},
            {1.753, 2.131, 2.602, 2.947, 3.286, 3.733, 4.073},
            {1.746, 2.120, 2.584, 2.921, 3.252, 3.686, 4.015},
            {1.740, 2.110, 2.567, 2.898, 3.222, 3.646, 3.965},
            {1.734, 2.101, 2.552, 2.878, 3.197, 3.610, 3.922},
            {1.729, 2.093, 2.539, 2.861, 3.174, 3.579, 3.883},
            {1.725, 2.086, 2.528, 2.845, 3.153, 3.552, 3.850}
        };
    }

    /**
     * Palauttaa p-arvon yksisuuntaiselle testille.
     *
     * @param df Testin vapausasteet.
     * @param t Testin t-arvo.
     * @return Palauttaa p-arvon String -muuttujana.
     */
    public final String yksiSuuntainen(final int df, final double t) {

        final int kriittinenNS = 0;
        final int kriittinen005 = 2;
        final int kriittinen001 = 5;

        if (Math.abs(t) < jakaumataulu[df][kriittinenNS]) {
            return "ns";
        } else if (Math.abs(t) >= jakaumataulu[df][kriittinenNS]
                && Math.abs(t) < jakaumataulu[df][kriittinen005]) {
            return "p <0.05";
        } else if (Math.abs(t) >= jakaumataulu[df][kriittinen005]
                && Math.abs(t) < jakaumataulu[df][kriittinen001]) {
            return "p <0.01";
        }
        return "p <0.001";
    }

    /**
     * Palauttaa p-arvon kaksisuuntaiselle testille.
     *
     * @param df Testin vapausasteet.
     * @param t Testin t-arvo.
     * @return Palauttaa p-arvon String -muuttujana.
     */
    public final String kaksiSuuntainen(final int df, final double t) {

        final int kriittinenNS = 1;
        final int kriittinen005 = 3;
        final int kriittinen001 = 6;

        if (Math.abs(t) < jakaumataulu[df][kriittinenNS]) {
            return "ns";
        } else if (Math.abs(t) >= jakaumataulu[df][kriittinenNS]
                && Math.abs(t) < jakaumataulu[df][kriittinen005]) {
            return "p <0.05";
        } else if (Math.abs(t) >= jakaumataulu[df][kriittinen005]
                && Math.abs(t) < jakaumataulu[df][kriittinen001]) {
            return "p <0.01";
        }
        return "p <0.001";
    }

}
