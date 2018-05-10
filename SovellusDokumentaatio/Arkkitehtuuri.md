# Arkkitehtuurikuvaus
## Rakenne
Ohjelman oleellista toiminnallisuutta ovat tehtävät, joita käyttäjä ratkaisee. Tehtava -luokka on yleinen luokka, ja eri aiheisiin liittyvät tehtävät ovat tämän luokan erikoistapauksia. Jokainen tehtävä koostuu osatehtävistä, joilla jokaisella on uniikki ohjeistus ja vastaus.

Jokaiseen tehtävään liittyy uniikki tilastotieteen ongelma ja ratkaisu. Tehtävän aihe voi olla esimerkiksi Pearsonin korrelaation laskeminen kahden muuttujan arvojen välille. Tällöin Tehtävä Koostuu useasta OsaTehtävä -luokan objektista ja PearsonKorrelaatio -objektista, jossa on oikeat vastaukset ongelmaan. Alla kuvaus tehtävästä jonka aiheena on Pearsonin korrelaation laskeminen.

![alt text](https://yuml.me/4689fa04.jpg)

## Käyttöliittymä

Käyttöliittymä koostuu Lopetus ja uuden tehtävän luonti napeista. Lopeta -napin painaminen sulkee sovelluksen. Uusi Tehtävä -napin painaminen luo uuden tilastotieteen tehtävän satunnaisesta aiheesta. Kun ohjelma avataan, ratkaistavaa tehtävää ei vielä ole. Kun Uusi tehtävä nappia painetaan ensimmäisen kerran, uusi tehtävä ilmestyy. Kun uusi tehtävä on luotu, ilmestyy sen ohjeen alle valikko ensimmäisen osatehtävän ratkaisemiseksi, sekä nappi, jolla tehtävässä voi siirtyä eteenpäin. Jokaiseen osatehtävään voi vastava vain kerran yhden vaihtoehdoista (1,2,3 ja 4), jonka jälkeen sovellus ilmoittaa onko vastaus oikein vai väärin. Siirry seuraavaan osatehtävään -napin painaminen siirtyy seuraavaan osatehtävään ja pyyhkii vanhan osatehtävän pois.  

## Sovelluslogiikka
## Ohjelman Rakenteeseen jääneet heikkoudet
