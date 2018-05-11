# StatMaster

StatMaster - on työnimi - ohjelmalle, joka pyrkii simuloimaan Helsingin, Turun ja Tampereen yliopiston psykologian pääsykoetta. Ohjelman tehokas käyttö edellyttää pääsykoekirjan asioiden kohtuullista osaamista. Ohjelmalla käyttäjä pystyy harjoittelemaan pääsykokeessa vaadittua tilastomatematiikkaa satunnaisesti generoiduilla tehtävillä, jotka ratkaistaan vaihe kerrallaan, kuten pääsykokeessa. Ohjelma - toisin kuin oikea pääsykoe - antaa vastaukset kuitenkin heti, eikä heinäkuun ensimmäinen päivä. 

Olen tehnyt sovellusta windons koneella, enkä saanut komentoja mvn test ja mvn test jacoco:report toimimaan. 
Jacoco raportin pystyy kuitenkin generoimaan run maven - valikon kautta, jossa on valmiiksi määritelty testikattavuus käsky. 

Huomautus 24.4: Releasea ei ole tehty, koska ohjelma valitettavasti ei ole vielä valmis. Osa määrittelydokumentin toiminnallisuudesta puuttuu edelleen. 

## Releaset
[Viikko 6](https://github.com/osxosxos/otm-harjoitustyo/releases/tag/viikko5)

[Lopullinen](https://github.com/osxosxos/otm-harjoitustyo/releases/tag/Lopullinen)

## Dokumentaatio

[Käyttöohje](https://github.com/osxosxos/otm-harjoitustyo/blob/master/SovellusDokumentaatio/K%C3%A4ytt%C3%B6ohje.md)

[Arkkitehtuurikuvaus](https://github.com/osxosxos/otm-harjoitustyo/blob/master/SovellusDokumentaatio/Arkkitehtuuri.md)

[Vaatimusmäärittely](https://github.com/osxosxos/otm-harjoitustyo/blob/master/SovellusDokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/osxosxos/otm-harjoitustyo/blob/master/SovellusDokumentaatio/Ty%C3%B6aikakirjanpito.md)

[Testausdokumentti](https://github.com/osxosxos/otm-harjoitustyo/blob/master/SovellusDokumentaatio/Testaus.md)

## Komentorivitoiminnot

### Testaus

Ohjelman yksikkötestit suoritetaan komennolla

```
mvn test
```

Jacoco-testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

### Jar -tiedoston generointi

Suoritettava jar -tiedosto generoidaan komennolla

```
mvn package
```

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

### Checkstyle

CheckStyle generoidaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
