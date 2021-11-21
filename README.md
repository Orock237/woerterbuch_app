# Wörterbuch App
Erstellung eines Wöterbuchs, das die Sprache Ngemba in anderen Sprachen übersetzt.

## Funktionalität
- Offline Wörterbuch
- Forum zur Diskussion von Termini
- Nur registrierte Nutzer können das Forum nutzen.
- Im Forum können die Nutzer austauschen und im Offline Modus sind die bereits zugestellte Nachrichten zu sehen.
- Navigationsziele für NavigationDrawer: App teilen, App bewerten, Kommentare schreiben, Grammatik, markierte Suchanfragen und Info
- Navigationshierarchien für jedes Wort: Grammatik<Akkusativ, Dativ.., Info<Nutzungsbedingungen, Datenschutz, Impressum
- Das Vorhandensein eines Up-Buttons.
- Optional: Es besteht die Möglichkeit, Sprachen zu wechseln.
- Schnelle Navigation (unter der App): Suche, Forum, Favoriten (Stern) und Home

## Infrastruktur
- App DB für offline Wörterbuch (Room DB)
- Authentifizierung für Forum - Firebase
- Firestore als Backend für Forum
