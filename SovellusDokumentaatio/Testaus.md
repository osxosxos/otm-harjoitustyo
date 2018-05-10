# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin testein JUnitilla että ohjelmaa käyttämällä. 

## Yksikkötestaus

### Tilastolliset testit

Jokaista erilaista tilastollista menetelmää testattiin yhdellä aineistolla. Testeissä pyrittiin ottamaan huomioon kaikki testaamisen vaiheet hypoteesin asettamisesta merkitsevyystason määrittämiseen.

### Tehtävät

Koska jokainen tehtävä on satunnaisesti luotu, testit etsivät tehtävien osatehtävistä oikeat vastaukset ja antavat ne syötteeksi. Ne tarkistavat, että oikea vaihtoehto löytyy ohjeesta, oikean vastauksen antaminen palauttaa arvon yksi ja väärän vastauksen antaminen palauttaa arvon nolla. Jokainen testien uudelleen ajaminen testaa siis tehtävien toimivuutta uudella tehtävällä, jossa on uniikki aineisto. Testit on ajettu läpi näin noin sata kertaa.

### Testauskattavuus

Graafista Käyttöliittymäpakkausta lukuunottamatta sovelluksen testauksen rivikattavuus on 99% ja haarautumakattavuus 92,5%

## Ohjelman testaaminen käyttämällä

Ohjelmaa testattiin itse käyttämällä. Suoritin itse tehtäviä noin 20. Ohjelman käyttötesteissä kaikki tilastomatematiikan laskutoimitukset on laskettu  [R-ohjelmistolla](https://www.r-project.org/) saman aikaisesti. Tällä on varmistettu, että ohjelmassa olevat oikeat vastaukset ovat oikein laskettuja arvoja ja oikean vastauksen antamisen tunnistaa myös ohjelma oikeaksi vastaukseksi. Lisäksi ohjelmaa on testattu myös antamalla tahallisesti vääriä vastauksi. Oikean vastauksen antamisen seurauksena ohjelma on jokaisella testikerralla ilmoittanut sen oikeaksi, ja väärän jokaisella kerralla vääräksi.
