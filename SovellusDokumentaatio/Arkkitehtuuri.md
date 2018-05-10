# Arkkitehtuurikuvaus
## Rakenne
Ohjelman oleellista toiminnallisuutta ovat tehtävät, joita käyttäjä ratkaisee. Tehtava -luokka on yleinen luokka, ja eri aiheisiin liittyvät tehtävät ovat tämän luokan erikoistapauksia. Jokainen tehtävä koostuu osatehtävistä, joilla jokaisella on uniikki ohjeistus ja vastaus.

Jokaiseen tehtävään liittyy uniikki tilastotieteen ongelma ja ratkaisu. Tehtävän aihe voi olla esimerkiksi Pearsonin korrelaation laskeminen kahden muuttujan arvojen välille. Tällöin Tehtävä Koostuu useasta OsaTehtävä -luokan objektista ja PearsonKorrelaatio -objektista, jossa on oikeat vastaukset ongelmaan. Alla kuvaus tehtävästä jonka aiheena on Pearsonin korrelaation laskeminen.

![alt text](https://yuml.me/4689fa04.jpg)

## Käyttöliittymä

Ohjelman käyttöliittymä on toteutettu yhtenä Scene -objektina, jossa on GripPane -objekti, johon lisätään - ja myös poistetaan - tehtäviä ja osatehtäviä käyttäjän käskyjen mukaan. Ohjelman perusnäkymässä on Lopetus ja uuden tehtävän luonti napit. Lopeta -napin painaminen sulkee sovelluksen. Uusi Tehtävä -napin painaminen luo uuden tilastotieteen tehtävän satunnaisesta aiheesta, joka liitetään Scene -objektille parametrina annettuun GridPane -objektiin. Uusi tehtävä -napin painaminen poistaa GridPanesta myös vanhan tehtävän, jos sellainen on. Uuden tehtävän luonnin yhteydessä GridPaneen liitetään myös uuden tehtävän ensimmäinen osatehtävä.

Kun ohjelma avataan, ratkaistavaa tehtävää ei vielä ole. Kun Uusi tehtävä nappia painetaan ensimmäisen kerran, uusi tehtävä ilmestyy. Kun uusi tehtävä on luotu, ilmestyy sen ohjeen alle valikko ensimmäisen osatehtävän ratkaisemiseksi, sekä nappi, jolla tehtävässä voi siirtyä eteenpäin. Jokaiseen osatehtävään voi vastava vain kerran yhden vaihtoehdoista (1,2,3 ja 4), jonka jälkeen sovellus ilmoittaa onko vastaus oikein vai väärin. Siirry seuraavaan osatehtävään -napin painaminen pyyhkii vanhan osatehtävän pois GridPanesta ja liittää tehtävän seuraavan osatehtävän sen tilalle.

## Sovelluslogiikka

Sovelluksen tarkoitus on luoda tilastotieteen tehtäviä eri aiheista.

### Tehtävä

Luokalla tehtävä on seuraavat attribuutit: 
*String ohje
*ArrayList<OsaTehtava> osaTehtava
  
Jokainen tehtävä koostuu siis useasta osatehtävästä, jotka ovat tilastotieteen ongelmien kohdalla usein seuraavat:
*Oikean menetelmän valinta
*Nollahypoteesin valinta
*Vastahypoteesin valinta
*Testisuureen laskeminen
*Tilostollisen merkitsevyyden määrittäminen

### OsaTehtävä

Luokalla osatehtävä on seuraavat attribuutit:
*String ohje
*Integer vastaus

Osatehtävä kuvaa yksittäistä tilastollisen testaamisen ongelmaa, esim. vastaypoteesin asettamista tai testisuureen laskemista. Osatehtävässä on ohje ja neljä vastausvaihtoehtoa, jotka on numeroitu 1,2,3 ja 4. Vaihtoehdot on sisällytetty ohjeeseen. Vastaus -attribuutti on näistä vaihtoehdoista oikea vastaus. Jokaisella osatehtävällä on suoritusmetodi, joka palauttaa arvon yksi, jos annettu vastaus vastaa vastaus -attribuuttia, muulloin nolla. 

### Tehtävän suorittaminen

Tehtävä suoritetaan vastaamalla jokaiseen osatehtävään ennaltamäärätyssä järjestyksessä.

## Ohjelman Rakenteeseen jääneet heikkoudet

Erilaisissa Tehtävä -luokan erikoistapauksissa saattaa olla vielä liikaa lähes päällekäisiä metodeja, kuten esimerkiksi jokaisella eri tilastollista testiä käsittelevällä luokalla on erilliset osatehtävä generaattorit hypoteesienvalinta osatehtäville. Tehtävä -luokassa on myös jonkin verran apumetodeja, jotka olisi ehkä parempi sijoittaa muualle rakenteen selventämiseksi.
