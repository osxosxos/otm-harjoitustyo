package Jakaumat;

/**
 * Luokka khiin neliön jakaumasta p-arvojen laskemiseen.
 *
 * @author Oskari Koskinen
 */
public class KhiinNelionJakauma {

    /**
     * Taulukko, jossa on jakauman vapausasteet.
     */
    private final int[] vapausAsteet;
    /**
     * Taulukko, jossa on khiin neliön jakauman kriittisia arvoja.
     */
    private final double[][] jakaumataulu;

    /**
     * Uudella khiin neliön jakaumalla on maksimissaan 20 vapausastetta.
     * Kriittiset arvot löytyvät p-Arvoille 0.05, 0.01 ja 0.001. Taulukon luvut
     * eivät ole maagisia lukuja, vaikka checkstyle niin väittääkin. Kaikki
     * luvut ovat khiin neluön jakauman kriittisiä arvoja, joiden kaikkien
     * määrittäminen vakioksi olisi turhaa.
     */
    public KhiinNelionJakauma() {
        final int vapausAsteidenMaara = 20;
        this.vapausAsteet = new int[vapausAsteidenMaara];
        for (int i = 1; i <= vapausAsteidenMaara; i++) {
            this.vapausAsteet[i - 1] = i;
        }
        this.jakaumataulu = new double[][]{
            {3.841, 6.635, 10.828},
            {5.991, 9.210, 13.816},
            {7.815, 11.345, 16.266},
            {9.488, 13.277, 18.467},
            {11.070, 15.086, 20.515},
            {12.592, 16.812, 22.458},
            {14.067, 18.475, 24.322},
            {15.507, 20.090, 26.124},
            {16.919, 21.666, 27.877},
            {18.307, 23.209, 29.588},
            {19.675, 24.725, 31.264},
            {21.026, 26.217, 32.909},
            {22.362, 27.688, 34.528},
            {23.685, 29.141, 36.123},
            {24.996, 30.578, 37.697},
            {26.296, 32.000, 39.252},
            {27.587, 33.409, 40.790},
            {28.869, 34.805, 42.312},
            {30.144, 36.191, 43.820},
            {31.410, 37.566, 45.315}
        };
    }

    /**
     * Palauttaa p-arvon khiin neliön testin tulokselle.
     *
     * @param df Testin vapausasteet.
     * @param khii Testin khiin neliön arvo.
     * @return Palauttaa testin tulokselle p-arvon String -muuttujana.
     */
    public final String merkitsevyysTaso(final int df, final double khii) {
        if (khii < jakaumataulu[df][0]) {
            return "ns";
        } else if (khii >= jakaumataulu[df][0] && khii < jakaumataulu[df][1]) {
            return "p <0.05";
        } else if (khii >= jakaumataulu[df][1] && khii < jakaumataulu[df][2]) {
            return "p <0.01";
        }
        return "p <0.001";
    }

}
