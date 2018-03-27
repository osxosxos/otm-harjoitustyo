
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        this.kassa = new Kassapaate();
        this.kortti = new Maksukortti(1000);
    }

    @Test
    public void uusiKassaPaateOnAlustettuOikein() {
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
    }

    @Test
    public void kateisOstoToimiiEdullisenLounaanOsalta() {

        int takaisin = kassa.syoEdullisesti(500);
        assertEquals(takaisin, 260);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100240);

        int takaisin2 = kassa.syoEdullisesti(200);
        assertEquals(takaisin2, 200);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100240);

    }

    @Test
    public void kateisOstoToimiiMaukkaanLounaanOsalta() {

        int takaisin = kassa.syoMaukkaasti(500);
        assertEquals(takaisin, 100);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100400);

        int takaisin2 = kassa.syoMaukkaasti(200);
        assertEquals(takaisin2, 200);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100400);

    }

    @Test
    public void ladatessaKortinSaldoMuuttuu() {

        kassa.lataaRahaaKortille(kortti, 666);
        assertEquals(kortti.saldo(), 1666);

    }

    @Test
    public void ladatessaKassanRahaMaaraKasvaa() {
        kassa.lataaRahaaKortille(kortti, 666);
        assertEquals(kassa.kassassaRahaa(), 100666);
    }

    @Test
    public void negatiivinenArvoEiKasvataKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, -666);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }

    @Test
    public void negatiivinenSummaEiMuutaKortinSaldoa() {

        kassa.lataaRahaaKortille(kortti, -666);
        assertEquals(kortti.saldo(), 1000);

    }

    @Test
    public void kortinSaldoVaheneeOikein() {

        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);

        assertEquals(kortti.saldo(), 360);

    }

    @Test
    public void kortillaEiVoiMaksaaEdullistaJosSaldoEiRiita() {

        kortti.otaRahaa(800);
        boolean edullinen = kassa.syoEdullisesti(kortti);
        assertEquals(kortti.saldo(), 200);
        assertEquals(edullinen, false);

    }

    @Test
    public void kortillaEiVoiMaksaaMaukastaJosSaldoEiRiita() {

        kortti.otaRahaa(800);
        boolean maukas = kassa.syoMaukkaasti(kortti);
        assertEquals(kortti.saldo(), 200);
        assertEquals(maukas, false);

    }

    @Test
    public void kortinSaldoVaheneeOikeinKunOstetaanMaukas() {

        boolean maukas = kassa.syoMaukkaasti(kortti);
        assertEquals(kortti.saldo(), 600);
        assertEquals(maukas, true);

    }

    @Test
    public void kortinSaldoVaheneeOikeinKunOstetaanEdullinen() {

        boolean edullinen = kassa.syoEdullisesti(kortti);
        assertEquals(kortti.saldo(), 760);
        assertEquals(edullinen, true);

    }

    @Test
    public void josKortillaOnTarpeeksiRahaaMyytyjenLounaidenMaaraKasvaa() {

        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);

        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());

    }

    @Test
    public void josKortillaEiOleTarpeeksiRahaaMikaanEiMuutu() {

        kortti.otaRahaa(800);
        boolean edullinen = kassa.syoEdullisesti(kortti);
        boolean maukas = kassa.syoMaukkaasti(kortti);

        assertEquals(edullinen, false);
        assertEquals(maukas, false);

        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
        
        assertEquals(kassa.kassassaRahaa(), 100000);

    }

    @Test
    public void kassassaOlevaRahaMaaraEiMuutuKortillaOstettaessa() {

    }

}
