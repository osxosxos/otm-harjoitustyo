# Arkkitehtuurikuvaus
## Rakenne
Ohjelman oleellista toiminnallisuutta ovat tehtävät, joita käyttäjä ratkaisee. Tehtava -luokka on yleinen luokka, ja eri aiheisiin liittyvät tehtävät ovat tämän luokan erikoistapauksia. Jokainen tehtävä koostuu osatehtävistä, joilla jokaisella on uniikki ohjeistus ja vastaus.

Jokaiseen tehtävään liittyy uniikki tilastotieteen ongelma ja ratkaisu. Tehtävän aihe voi olla esimerkiksi Pearsonin korrelaation laskeminen kahden muuttujan arvojen välille. Tällöin Tehtävä Koostuu useasta OsaTehtävä -luokan objektista ja PearsonKorrelaatio -objektista, jossa on oikeat vastaukset ongelmaan. Alla kuvaus tehtävästä jonka aiheena on Pearsonin korrelaation laskeminen.

![alt text](https://yuml.me/4689fa04.jpg)

## Käyttöliittymä
## Sovelluslogiikka
## Ohjelman Rakenteeseen jääneet heikkoudet
