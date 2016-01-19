# Uzorci dizajna zadaca 4

Naziv: upravljanje parkiralištem


Naziv projekta: {LDAP_korisničko_ime}_zadaca_4


Ishodišni direktorij projekta:{LDAP_korisničko_ime}_zadaca_4


Prije predavanja projekta potrebno je napraviti Clean na projektu. Zatim cijeli projekt sažeti u .zip (NE .rar) format s nazivom {LDAP_korisničko_ime}_zadaca_4.zip i predati u Moodle. Uključiti izvorni kod, primjere datoteke podataka, popunjenu datoteku dokumentacije i popunjen obrazac za zadaću (obje datoteke u ishodišnom direktoriju projekta). 


Naziv rješenja:{LDAP_korisničko_ime}_zadaca_4.zip


 


Program se MORA izvršavati s komandne linije pri čemu vrijedi sljedeći format:


java -jar C:\UzDiz\dkermek_zadaca_4.jar brojAutomobila brojZona kapacitetZone maksParkiranje vremenskaJedinica intervalDolaska intervalOdlaska cijenaJedinice intervalKontrole kaznaParkiranja 


ili 


C:\UzDiz\dkermek_zadaca_4.exe brojAutomobila brojZona kapacitetZone maksParkiranje vremenskaJedinica intervalDolaska intervalOdlaska cijenaJedinice intervalKontrole kaznaParkiranja 


 


Vrijednosti argumenata mogu biti u sljedećim intervalima:


brojAutomobila = 10 - 100
brojZona = 1 - 4
kapacitetZone = 1 - 100
maksParkiranje = 1 - 10
vremenskaJedinica = 1 - 10 sek
intervalDolaska = 1 - 10
intervalOdlaska = 1 - 10
cijenaJedinice = 1 - 10 kn
intervalKontrole = 1 - 10
kaznaParkiranja = 10 - 100


 

Parkiralište je podijeljeno u n zona (argument brojZona). Kapacitet u zoni izračunava se po formuli (i * kapacitetZone), i je broj zone. 
Vrijeme parkiranja u zoni izračunava se po formuli (i * maksParkiranje * vremenskaJedinica), i je broj zone. 
Svaki automobil ima svoj identifikator (redni broj).
Automobili ulaze u parkiralište s određenim vremenom razmaka po formuli ((vremenskaJedinica / intervalDolaska) * generiranaVrijednost1). 
Automobil odabire zonu na temelju formule (brojZona * generiranaVrijednost2) tako da sve zone imaju istu vjerojatnost odabira.
Ako ima slobodno mjesto u traženoj zoni automobil se parkira i plaća parkiranje po jedinici vremena u zoni koja se izračunava po formuli ((brojZona + 1 - i) * cijenaJedinice), i je broj zone. 
Ako nema izlazi iz parkirališta i ne plaća parkiranje.
Za svaki obrađeni automobil ispisuju se podaci o ulazu u parkiralište (vrijeme, zona, iznos, status,...).

Vlasnici automobila u parkiralištu dolaze do svojih automobila po formuli ((vremenskaJedinica / intervalOdlaska) * generiranaVrijednost3). 
Vlasnik može obaviti jednu od akcija: 0 - ništa, 1 - izaći, 2 - produljiti parkiranje, koja se dobije po formuli na bazi generiranaVrijednost4  
tako da vrijednost 0 ima 25%, 1 ima 50% i 2 ima 25%. Maksimalni broj produljenja parkiranja po zoni dobije se po formuli (i - 1), i je broj zone.
Ukoliko je ranije iskorišten maksimalni broj produljenja tada će novo biti odbijeno.
Za svaki automobil generiraju se nove vrijednosti kod svake generiranaVrijednost i u intervalu (0,000-1,000).

Automobil koji je napustio parkiralište ponovno ulazi u skup automobila koji mogu ući u parkiralište.

Konrolor parkiranja obilazi parkiralište u određenom intervalu koji se izračunava po formuli (vremenskaJedinica / intervalKontrole). 
Za automobil koji nema važeće parkiranje naplaćuje kaznu prema formuli ((brojZona + 1 - i) * cijenaJedinice * kaznaParkiranja), a pauk odvozi automobil na deponij. 
Time je parkirno mjesto oslobođeno.

Nakon pokretanja programa (prethodni opis) mogu se izvršiti komande:
-1 - zatvaranje parkirališta za nove ulaze automobila
-2 - otvaranje parkirališta za nove ulaze automobila
-3 - ispis zarada od parkiranja po zonama
-4 - ispis zarada od kazni po zonama
-5 - ispis broja automobila koji nisu mogli parkirati po zonama
-6 - ispis broja automobila koji je pauk odveo na deponij po zonama
-7 - ispis 5 automobila s najviše parkiranja
-8 - stanje parkirnih mjesta po zonama (% zauzetih)
-Q - prekid rada programa.


Treba pronaći prikladne GOF, POSA 1 i POSA 3 uzorke dizajna za opisane probleme.

 


U ishodišnom direktoriju projekta treba priložiti datoteku dokumentacije{LDAP_korisničko_ime}_zadaca_4.{doc|pdf} u kojoj se na 1. stranici nalazi objašnjenje razloga odabira pojedinog uzorka dizajna (max 1 str A4, font min 10) a na 2. stranici dijagram rješenja (max 1 str A4, font min 10) s označavanjem pripadnosti klase pojedinom uzorku dizajna. 
U ishodišnom direktoriju projekta treba priložiti datoteku {LDAP_korisničko_ime}_obrazac_za_zadacu_4.{doc|pdf} u kojoj se nalazi popunjen obrazac za zadaću.
Napomena: Ne smiju se koristiti ugrađene osobine odabranog programskog jezika za realizaciju funkcionalnosti pojedinih uzoraka dizajna.
 
Jezici implementacije: C#, Java. Isti koji je odabran u anketi za programski jezik za zadaće.
Razvojni alati: NetBeans (8.*), Visual Studio 201* (preporučuje se 2013) 
