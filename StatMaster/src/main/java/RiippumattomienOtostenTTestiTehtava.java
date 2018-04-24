
import java.util.ArrayList;

/**
 *
 * @author Oskari Koskinen
 */
public class RiippumattomienOtostenTTestiTehtava extends Tehtava {

    int muuttuja;
    String ryhmienTyyppi;
    String ryhmaXnimi;
    String ryhmaYnimi;
    int ryhmanXmediaani;
    int ryhmanYmediaani;
    String hypoteesi;
    ArrayList<Integer> ryhmanXarvot;
    ArrayList<Integer> ryhmanYarvot;
    StudentinTTestiRiippumattomilleOtoksille t;

    public RiippumattomienOtostenTTestiTehtava() {
        super();
        this.muuttuja = 0;
        this.ryhmienTyyppi = "";
        this.ryhmaXnimi = "";
        this.ryhmaYnimi = "";
        this.ryhmanXmediaani = 0;
        this.ryhmanYmediaani = 0;
        this.hypoteesi = "";
        this.ryhmanXarvot = new ArrayList();
        this.ryhmanYarvot = new ArrayList();
        this.t = new StudentinTTestiRiippumattomilleOtoksille();
    }

    public void luoUusiTehtava() {
        this.setMuuttuja(super.random.nextInt(super.aiheetPerusmuoto().length));
        this.setRyhmienTyyppi(this.arvoRyhmienTyyppi());
        this.setRyhmaXnimi(this.arvoRyhmanXnimi());
        this.setRyhmaYnimi(this.arvoRyhmanYnimi());
        this.setRyhmanXylaraja(this.arvoRyhmanXmediaani());
        this.setRyhmanYylaraja(this.arvoRyhmanYmediaani());
        this.setRyhmanXarvot(super.luoData(this.ryhmanXmediaani, super.random.nextInt(6) + 5));
        this.setRyhmanYarvot(super.luoData(this.ryhmanYmediaani, super.random.nextInt(6) + 5));
        this.setHypoteesi(this.arvoHypoteesi());
        super.setOhje(this.setOhjeistus());
        if (this.hypoteesi.equals("X<Y") || this.hypoteesi.equals("X>Y")) {
            this.t.laske(ryhmanXarvot, ryhmanYarvot, 1);
        } else {
            this.t.laske(ryhmanXarvot, ryhmanYarvot, 2);
        }
        super.testinValintaTehtava("Riippumattomien otosten t-testi");
        this.nollaHypoteesiTehtava();
        this.vaihtoehtoinenHypoteesiTehtava();
        super.laskemisTehtava(this.t.t, 5, "Laske t-testisuureen arvo.");
        this.pArvoTehtava();
    }

    public void setMuuttuja(int muuttuja) {
        this.muuttuja = muuttuja;
    }

    public void setRyhmienTyyppi(String ryhmienTyyppi) {
        this.ryhmienTyyppi = ryhmienTyyppi;
    }

    public void setRyhmaXnimi(String ryhmaXnimi) {
        this.ryhmaXnimi = ryhmaXnimi;
    }

    public void setRyhmaYnimi(String ryhmaYnimi) {
        this.ryhmaYnimi = ryhmaYnimi;
    }

    public void setHypoteesi(String hypoteesi) {
        this.hypoteesi = hypoteesi;
    }

    public void setRyhmanXylaraja(int ryhmanXmediaani) {
        this.ryhmanXmediaani = ryhmanXmediaani;
    }

    public void setRyhmanYylaraja(int ryhmanYmediaani) {
        this.ryhmanYmediaani = ryhmanYmediaani;
    }

    public void setRyhmanXarvot(ArrayList<Integer> ryhmanXarvot) {
        this.ryhmanXarvot = ryhmanXarvot;
    }

    public void setRyhmanYarvot(ArrayList<Integer> ryhmanYarvot) {
        this.ryhmanYarvot = ryhmanYarvot;
    }

    public String setOhjeistus() {

        String ohje1 = "Tutkimuksen kohteena olivat "
                + this.ryhmaXnimi + " ja " + this.ryhmaYnimi + "."
                + System.lineSeparator()
                + "Molemmista ryhmistä kerättiin edustavat otokset.";

        String ohje2 = "Tutkija oli kiinnostunut ryhmien välisestä erosta "
                + "muuttujan " + super.aiheetPerusmuoto()[this.muuttuja] + " arvoissa."
                + System.lineSeparator();

        String ohje3 = "Voit olettaa, että molempien ryhmien havainnot ovat vähintään "
                + System.lineSeparator()
                + "välimatka-asteikollisia, hajonnat ovat molemmissa ryhmissä yhtäsuuret"
                + System.lineSeparator()
                + "ja havainnot noudattavat likimain normaalijakaumaa."
                + System.lineSeparator();

        String ohje4 = "Muuttujalla " + super.aiheetPerusmuoto()[this.muuttuja]
                + " on seuraavat arvot ryhmässä " + this.ryhmaXnimi + "."
                + System.lineSeparator() + this.vektoriMerkkiJonoksi(this.ryhmanXarvot)
                + System.lineSeparator();

        String ohje5 = "Muuttujalla  " + super.aiheetPerusmuoto()[this.muuttuja]
                + " on seuraavat arvot ryhmässä " + this.ryhmaYnimi + "."
                + System.lineSeparator() + this.vektoriMerkkiJonoksi(this.ryhmanYarvot)
                + System.lineSeparator();

        String ohje6 = "";

        if (this.hypoteesi.equals("X<Y")) {
            ohje6 = "Tutki onko ryhmän " + this.ryhmaXnimi
                    + " keskiarvo pienempi kuin ryhmän " + this.ryhmaYnimi + ".";
        } else if (this.hypoteesi.equals("X>Y")) {
            ohje6 = "Tutki onko ryhmän " + this.ryhmaXnimi
                    + " keskiarvo suurempi kuin ryhmän " + this.ryhmaYnimi + ".";
        } else if (this.hypoteesi.equals("X=/=Y")) {
            ohje6 = "Tutki eroaako ryhmän " + this.ryhmaXnimi
                    + " keskiarvo ryhmän " + this.ryhmaYnimi + " keskiarvosta.";
        }

        String tehtavanOhje = ohje1 + System.lineSeparator()
                + ohje2 + System.lineSeparator()
                + ohje3 + System.lineSeparator()
                + ohje4 + System.lineSeparator()
                + ohje5 + System.lineSeparator()
                + ohje6;

        return tehtavanOhje;

    }

    public String arvoRyhmienTyyppi() {
        int x = random.nextInt(3);
        if (x == 0) {
            return "ika";
        } else if (x == 1) {
            return "ammatti";
        } else if (x == 2) {
            return "supu";
        }
        return "";
    }

    public String arvoRyhmanXnimi() {
        if (this.ryhmienTyyppi.equals("ika")) {
            int x = random.nextInt(super.ikaRyhmia().length);
            return super.ikaRyhmia()[x];
        } else if (this.ryhmienTyyppi.equals("ammatti")) {
            int x = random.nextInt(super.ammatteja().length);
            return super.ammatteja()[x];
        } else if (this.ryhmienTyyppi.equals("supu")) {
            int x = random.nextInt(super.sukupuolet().length);
            return super.sukupuolet()[x];
        }
        return "";
    }

    public String arvoRyhmanYnimi() {
        if (this.ryhmienTyyppi.equals("ika")) {
            while (true) {
                int y = random.nextInt(super.ikaRyhmia().length);
                if (!super.ikaRyhmia()[y].equals(this.ryhmaXnimi)) {
                    return super.ikaRyhmia()[y];
                }
            }
        } else if (this.ryhmienTyyppi.equals("ammatti")) {
            while (true) {
                int y = random.nextInt(super.ammatteja().length);
                if (!super.ammatteja()[y].equals(this.ryhmaXnimi)) {
                    return super.ammatteja()[y];
                }
            }
        } else if (this.ryhmienTyyppi.equals("supu")) {
            while (true) {
                int y = random.nextInt(super.sukupuolet().length);
                if (!super.sukupuolet()[y].equals(this.ryhmaXnimi)) {
                    return super.sukupuolet()[y];
                }
            }
        }
        return "";
    }

    public int arvoRyhmanXmediaani() {
        int x = (random.nextInt(10) + 1) * 5 + 50;
        return x;
    }

    public int arvoRyhmanYmediaani() {
        int x = 0;
        while (true) {
            x = random.nextInt(random.nextInt(10) + 1) * 5 + 50;
            if (Math.abs(this.ryhmanXmediaani - x) <= 20) {
                return x;
            }
        }
    }

    public String arvoHypoteesi() {

        String h1 = "X<Y";
        String h2 = "X>Y";
        String h3 = "X=/=Y";

        int x = random.nextInt(3);

        if (x == 0) {
            this.hypoteesi = h1;
        } else if (x == 1) {
            this.hypoteesi = h2;
        } else {
            this.hypoteesi = h3;
        }

        return hypoteesi;

    }

    public void nollaHypoteesiTehtava() {
        String vastaus1 = "1. Ryhmien keskiarvot eivät eroa toisistaan";
        String vastaus2 = "2. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on suurempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus3 = "3. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on pienempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus4 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        String tehtavanOhje = "Määritä tämän tehtävän nollahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        OsaTehtava tehtava = new OsaTehtava(1, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void vaihtoehtoinenHypoteesiTehtava() {

        String vastaus1 = "1. Ryhmien keskiarvot eivät eroa toisistaan";
        String vastaus2 = "2. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on suurempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus3 = "3. Ryhmän " + this.ryhmaXnimi
                + " keskiarvo on pienempi kuin ryhmän " + this.ryhmaYnimi;
        String vastaus4 = "4. Ryhmien keskiarvot eivät ole yhtäsuuret";

        String tehtavanOhje = "Määritä tämän tehtävän vastahypoteesi."
                + System.lineSeparator()
                + vastaus1 + System.lineSeparator()
                + vastaus2 + System.lineSeparator()
                + vastaus3 + System.lineSeparator()
                + vastaus4 + System.lineSeparator();

        int vastaus = 0;

        if (this.hypoteesi.equals("X>Y")) {
            vastaus = 2;
        } else if (this.hypoteesi.equals("X<Y")) {
            vastaus = 3;
        } else if (this.hypoteesi.equals("X=/=Y")) {
            vastaus = 4;
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, tehtavanOhje);
        super.osaTehtavat.add(tehtava);
    }

    public void pArvoTehtava() {
        String ohje = "Määritä testisuureen p-arvo" + System.lineSeparator()
                + "1. Tulos ei ole tilastollisesti merkisevä" + System.lineSeparator()
                + "2. p <0.05" + System.lineSeparator()
                + "3. p <0.01" + System.lineSeparator()
                + "4. p <0.001" + System.lineSeparator();

        int vastaus = 0;

        if (this.hypoteesi.equals("X<Y") && this.t.t >= 0) {
            vastaus = 1;
        } else if (this.hypoteesi.equals("X>Y") && this.t.t <= 0) {
            vastaus = 1;
        } else {
            if (this.t.pArvo.equals("ns")) {
                vastaus = 1;
            } else if (this.t.pArvo.equals("p <0.05")) {
                vastaus = 2;
            } else if (this.t.pArvo.equals("p < 0.01")) {
                vastaus = 3;
            } else {
                vastaus = 4;
            }
        }

        OsaTehtava tehtava = new OsaTehtava(vastaus, ohje);
        super.osaTehtavat.add(tehtava);

    }

}
