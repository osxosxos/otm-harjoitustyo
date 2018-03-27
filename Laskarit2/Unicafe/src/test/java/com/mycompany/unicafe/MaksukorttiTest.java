package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(kortti.saldo(), 10);
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(90);
        assertEquals(kortti.saldo(), 100);
    }

    @Test
    public void saldoVaheneeOikeinKunRahaaTarpeeksi() {
        kortti.otaRahaa(5);
        assertEquals(kortti.saldo(), 5);
    }

    @Test 
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi() {
        kortti.otaRahaa(20);
        assertEquals(kortti.saldo(), 10);
    }
    
    @Test
    public void metodiPalauttaaTrueJosRahatRiittavat() {
        assertEquals(kortti.otaRahaa(5),true);
    }
    
    @Test
    public void metodiPalauttaaFalseJosRahatEivatRiita() {
        assertEquals(kortti.otaRahaa(50), false);
    }
    
    @Test
    public void testaaToString() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
}
