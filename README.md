### E-Biznes

**Zadanie 1** Docker

:white_check_mark: 3.0 obraz ubuntu:24.04 z Pythonem w wersji 3.10

:x: 3.5 obraz ubuntu:24.04 z Javą w wersji 8 oraz Kotlinem

:x: 4.0 do powyższego należy dodać najnowszego Gradle’a oraz paczkę JDBC SQLite w ramach projektu na Gradle (build.gradle)

:x: 4.5 stworzyć przykład typu HelloWorld oraz uruchomienie aplikacji przez CMD oraz gradle

:x: 5.0 dodać konfigurację docker-compose

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-1


**Zadanie 2:** Scala

:white_check_mark: 3.0 Należy stworzyć kontroler do Produktów

:white_check_mark: 3.5 Do kontrolera należy stworzyć endpointy zgodnie z CRUD - dane pobierane z listy

:x: 4.0 Należy stworzyć kontrolery do Kategorii oraz Koszyka + endpointy zgodnie z CRUD

:x: 4.5 Należy aplikację uruchomić na dockerze (stworzyć obraz) oraz dodać skrypt uruchamiający aplikację via ngrok (nie podawać tokena ngroka w gotowym rozwiązaniu)

:x: 5.0 Należy dodać konfigurację CORS dla dwóch hostów dla metod CRUD

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-2


**Zadanie 3:** Kotlin

:white_check_mark: 3.0 Należy stworzyć aplikację kliencką w Kotlinie we frameworku Ktor, która pozwala na przesyłanie wiadomości na platformę Discord

:x: 3.5 Aplikacja jest w stanie odbierać wiadomości użytkowników z platformy Discord skierowane do aplikacji (bota)

:x: 4.0 Zwróci listę kategorii na określone żądanie użytkownika

:x: 4.5 Zwróci listę produktów wg żądanej kategorii

:x: 5.0 Aplikacja obsłuży dodatkowo jedną z platform: Slack, Messenger, Webex

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-3


**Zadanie 4:** Go

:white_check_mark: 3.0 Należy stworzyć aplikację we frameworki echo w j. Go, która będzie
miała kontroler Produktów zgodny z CRUD

:white_check_mark: 3.5 Należy stworzyć model Produktów wykorzystując gorm oraz
wykorzystać model do obsługi produktów (CRUD) w kontrolerze (zamiast
listy)

:x: 4.0 Należy dodać model Koszyka oraz dodać odpowiedni endpoint

:x: 4.5 Należy stworzyć model kategorii i dodać relację między kategorią,
a produktem

:x: 5.0 pogrupować zapytania w gorm’owe scope'y

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-4


**Zadanie 5:** Frontend

:white_check_mark: 3.0 W ramach projektu należy stworzyć dwa komponenty: Produkty oraz
Płatności; Płatności powinny wysyłać do aplikacji serwerowej dane, a w
Produktach powinniśmy pobierać dane o produktach z aplikacji
serwerowej;

:x: 3.5 Należy dodać Koszyk wraz z widokiem; należy wykorzystać routing

:x: 4.0 Dane pomiędzy wszystkimi komponentami powinny być przesyłane za
pomocą React hooks

:x: 4.5 Należy dodać skrypt uruchamiający aplikację serwerową oraz
kliencką na dockerze via docker-compose

:x: 5.0 Należy wykorzystać axios’a oraz dodać nagłówki pod CORS

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-5


**Zadanie 6:** Testy

:white_check_mark: 3.0 Należy stworzyć 20 przypadków testowych w CypressJS lub Selenium
(Kotlin, Python, Java, JS, Go, Scala)

:x: 3.5 Należy rozszerzyć testy funkcjonalne, aby zawierały minimum 50
asercji

:x: 4.0 Należy stworzyć testy jednostkowe do wybranego wcześniejszego
projektu z minimum 50 asercjami

:x: 4.5 Należy dodać testy API, należy pokryć wszystkie endpointy z
minimum jednym scenariuszem negatywnym per endpoint

:x: 5.0 Należy uruchomić testy funkcjonalne na Browserstacku

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-6


**Zadanie 7:** Sonar

Należy dodać projekt aplikacji klienckiej oraz serwerowej (jeden
branch, dwa repozytoria) do Sonara w wersji chmurowej
(https://sonarcloud.io/). Należy poprawić aplikacje uzyskując 0 bugów,
0 zapaszków, 0 podatności, 0 błędów bezpieczeństwa. Dodatkowo należy
dodać widżety sonarowe do README w repozytorium dane projektu z
wynikami.

:white_check_mark: 3.0 Należy dodać litera do odpowiedniego kodu aplikacji serwerowej w
hookach gita

:white_check_mark: 3.5 Należy wyeliminować wszystkie bugi w kodzie w Sonarze (kod
aplikacji serwerowej)

:white_check_mark: 4.0 Należy wyeliminować wszystkie zapaszki w kodzie w Sonarze (kod
aplikacji serwerowej)

:white_check_mark: 4.5 Należy wyeliminować wszystkie podatności oraz błędy bezpieczeństwa
w kodzie w Sonarze (kod aplikacji serwerowej)

:white_check_mark: 5.0 Należy wyeliminować wszystkie błędy oraz zapaszki w kodzie
aplikacji klienckiej

Kod: https://github.com/BloodyShrimp/Ebiznes25/tree/main/zadanie-7
