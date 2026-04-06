import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b1-passiv-p2-002",
    "level": "b1",
    "category": "Passiv",
    "question": "Wie lautet das Passiv Präteritum von 'Der Arzt operiert den Patienten.'?",
    "options": ["Der Patient wurde vom Arzt operiert.","Der Patient wird vom Arzt operiert.","Der Arzt wurde vom Patienten operiert.","Der Patient ist operiert worden."],
    "correctAnswer": 0,
    "explanation": "Präteritum Passiv: 'Der Patient wurde vom Arzt operiert.'",
    "exampleSentence": "Das Haus wird gebaut.",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Bildung",
    "tags": ["passiv", "vorgangspassiv"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-003",
    "level": "b1",
    "category": "Passiv",
    "question": "Wie lautet das Passiv Perfekt von 'Man hat das Paket geliefert.'?",
    "options": ["Das Paket ist geliefert worden.","Das Paket wurde geliefert.","Das Paket wird geliefert.","Das Paket war geliefert worden."],
    "correctAnswer": 0,
    "explanation": "Perfekt Passiv: 'Das Paket ist geliefert worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-006",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Polizei kontrolliert die Pässe.'",
    "options": ["Die Pässe werden von der Polizei kontrolliert.","Die Pässe wurden kontrolliert.","Die Pässe sind kontrolliert worden.","Die Polizei wird kontrolliert."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Pässe werden von der Polizei kontrolliert.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Plusquamperfekt",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-009",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man hat die Fenster geputzt.'",
    "options": ["Die Fenster sind geputzt worden.","Die Fenster werden geputzt.","Die Fenster wurden geputzt.","Die Fenster waren geputzt worden."],
    "correctAnswer": 0,
    "explanation": "Perfekt Passiv: 'Die Fenster sind geputzt worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-012",
    "level": "b1",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Das Haus ___ gerade renoviert.' (Präsens Passiv)",
    "options": ["ist","hat","wird","wurde"],
    "correctAnswer": 2,
    "explanation": "Präsens Passiv: wird + Partizip II.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-018",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Studenten schreiben die Prüfung.'",
    "options": ["Die Prüfung wird von den Studenten geschrieben.","Die Studenten werden geschrieben.","Die Prüfung ist geschrieben worden.","Die Prüfung wurde geschrieben."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Prüfung wird von den Studenten geschrieben.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-024",
    "level": "b1",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Die Tür war geöffnet worden.'?",
    "options": ["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Plusquamperfekt Passiv"],
    "correctAnswer": 3,
    "explanation": "'war + Partizip II + worden' = Plusquamperfekt Passiv.",
    "grammarRule": "Vorgangspassiv Plusquamperfekt: war/waren + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-027",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man wird das Ergebnis bekannt geben.'",
    "options": ["Das Ergebnis wird bekannt gegeben werden.","Das Ergebnis wird bekannt gegeben.","Das Ergebnis wurde bekannt gegeben.","Das Ergebnis ist bekannt gegeben worden."],
    "correctAnswer": 0,
    "explanation": "Futur I Passiv: 'Das Ergebnis wird bekannt gegeben werden.'",
    "grammarRule": "Vorgangspassiv Futur I: wird + Partizip II + werden",
    "subcategory": "Vorgangspassiv Futur I",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-030",
    "level": "b1",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Briefe ___ gestern abgeschickt ___.' (Perfekt Passiv)",
    "options": ["wurden ... worden","haben ... werden","sind ... worden","werden ... werden"],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: sind + Partizip II + worden.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-031",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Lehrerin benotet die Arbeiten.'",
    "options": ["Die Arbeiten werden von der Lehrerin benotet.","Die Lehrerin wird benotet.","Die Arbeiten sind benotet.","Die Arbeiten wurden benotet."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Arbeiten werden von der Lehrerin benotet.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "zustandspassiv"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-032",
    "level": "b1",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Der Kuchen ___ von der Oma gebacken.' (Präteritum Passiv)",
    "options": [
      "wird",
      "ist",
      "wurde",
      "hat"
    ],
    "correctAnswer": 2,
    "explanation": "Präteritum Passiv: wurde + Partizip II.",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präteritum",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-033",
    "level": "b1",
    "category": "Passiv",
    "question": "Welches Verb kann KEIN persönliches Passiv bilden?",
    "options": [
      "lesen",
      "schreiben",
      "gefallen",
      "waschen"
    ],
    "correctAnswer": 2,
    "explanation": "'gefallen' hat kein Akkusativobjekt und kann daher kein persönliches Passiv bilden.",
    "grammarRule": "Nur transitive Verben bilden ein persönliches Passiv",
    "subcategory": "Passivfähigkeit",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-035",
    "level": "b1",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Das Auto war repariert worden.'?",
    "options": [
      "Perfekt Passiv",
      "Präteritum Passiv",
      "Plusquamperfekt Passiv",
      "Futur I Passiv"
    ],
    "correctAnswer": 2,
    "explanation": "'war + Partizip II + worden' = Plusquamperfekt Passiv.",
    "grammarRule": "Vorgangspassiv Plusquamperfekt: war/waren + Partizip II + worden",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-036",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Präteritum: 'Der Koch bereitete das Frühstück zu.'",
    "options": ["Das Frühstück wird zubereitet.","Das Frühstück wurde vom Koch zubereitet.","Das Frühstück ist zubereitet worden.","Das Frühstück war zubereitet worden."],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Das Frühstück wurde vom Koch zubereitet.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Erkennung",
    "tags": ["passiv", "unterscheidung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-037",
    "level": "b1",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Briefe ___ gestern geschrieben ___.' (Perfekt Passiv)",
    "options": [
      "wurden ... worden",
      "haben ... werden",
      "sind ... worden",
      "waren ... worden"
    ],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv Plural: sind + Partizip II + worden.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-038",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man putzt die Fenster jeden Freitag.'",
    "options": [
      "Die Fenster werden jeden Freitag geputzt.",
      "Die Fenster sind jeden Freitag geputzt.",
      "Die Fenster wurden jeden Freitag geputzt.",
      "Die Fenster waren geputzt worden."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Fenster werden jeden Freitag geputzt.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-039",
    "level": "b1",
    "category": "Passiv",
    "question": "Was beschreibt das Zustandspassiv?",
    "options": [
      "Einen laufenden Vorgang",
      "Eine zukünftige Handlung",
      "Das Ergebnis einer abgeschlossenen Handlung",
      "Eine wiederholte Handlung"
    ],
    "correctAnswer": 2,
    "explanation": "Das Zustandspassiv beschreibt einen Zustand, der das Ergebnis einer Handlung ist.",
    "grammarRule": "Zustandspassiv: sein + Partizip II = Ergebnis/Zustand",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-040",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Präteritum: 'Die Kinder räumten das Zimmer auf.'",
    "options": [
      "Das Zimmer wird von den Kindern aufgeräumt.",
      "Das Zimmer wurde von den Kindern aufgeräumt.",
      "Das Zimmer ist von den Kindern aufgeräumt worden.",
      "Das Zimmer war von den Kindern aufgeräumt worden."
    ],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: wurde + Partizip II.",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präteritum",
    "tags": ["passiv", "praeteritum"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-041",
    "level": "b1",
    "category": "Passiv",
    "question": "Welche Präposition drückt das Mittel/Instrument im Passiv aus?",
    "options": [
      "von",
      "durch",
      "mit",
      "bei"
    ],
    "correctAnswer": 1,
    "explanation": "'durch' drückt das Mittel oder eine unpersönliche Ursache aus: 'durch den Sturm', 'durch eine Maßnahme'.",
    "grammarRule": "Agens: von + Dativ (Person); durch + Akkusativ (Mittel/Ursache)",
    "subcategory": "Agens",
    "tags": ["passiv", "agens"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-042",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Studenten lesen den Text.'",
    "options": [
      "Der Text wird von den Studenten gelesen.",
      "Die Studenten werden gelesen.",
      "Der Text ist gelesen worden.",
      "Der Text wurde gelesen."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Der Text wird von den Studenten gelesen.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-043",
    "level": "b1",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Pakete ___ morgen geliefert ___.' (Futur I Passiv)",
    "options": [
      "werden ... werden",
      "sind ... worden",
      "werden ... worden",
      "wurden ... werden"
    ],
    "correctAnswer": 0,
    "explanation": "Futur I Passiv: werden + Partizip II + werden.",
    "grammarRule": "Vorgangspassiv Futur I: wird/werden + Partizip II + werden",
    "subcategory": "Vorgangspassiv Futur I",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-044",
    "level": "b1",
    "category": "Passiv",
    "question": "Welcher Satz steht im Vorgangspassiv Präsens?",
    "options": [
      "Das Geschäft ist geöffnet.",
      "Das Geschäft wird geöffnet.",
      "Das Geschäft wurde geöffnet.",
      "Das Geschäft war geöffnet."
    ],
    "correctAnswer": 1,
    "explanation": "'wird + Partizip II' = Vorgangspassiv Präsens.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-045",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Koch bereitet das Menü vor.'",
    "options": [
      "Das Menü wird vom Koch vorbereitet.",
      "Der Koch wird vorbereitet.",
      "Das Menü ist vorbereitet.",
      "Das Menü wurde vorbereitet."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Das Menü wird vom Koch vorbereitet.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-046",
    "level": "b1",
    "category": "Passiv",
    "question": "Was passiert mit dem Dativobjekt im Passiv?",
    "options": [
      "Es wird zum Subjekt.",
      "Es bleibt im Dativ.",
      "Es fällt weg.",
      "Es wird zum Akkusativobjekt."
    ],
    "correctAnswer": 1,
    "explanation": "Das Dativobjekt bleibt im Passiv erhalten: 'Ihm wird geholfen.'",
    "grammarRule": "Dativobjekt bleibt im Passiv im Dativ",
    "subcategory": "Bildung",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-047",
    "level": "b1",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Das Licht ___ ausgeschaltet.' (Zustandspassiv Präsens)",
    "options": [
      "wird",
      "wurde",
      "ist",
      "hat"
    ],
    "correctAnswer": 2,
    "explanation": "Zustandspassiv Präsens: ist + Partizip II.",
    "grammarRule": "Zustandspassiv: sein + Partizip II",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-048",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man spricht hier Deutsch.'",
    "options": [
      "Deutsch ist hier gesprochen.",
      "Hier wird Deutsch gesprochen.",
      "Deutsch wurde hier gesprochen.",
      "Deutsch wird hier sprechen."
    ],
    "correctAnswer": 1,
    "explanation": "Präsens Passiv: 'Hier wird Deutsch gesprochen.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-049",
    "level": "b1",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Die Tickets werden verkauft werden.'?",
    "options": [
      "Präsens Passiv",
      "Perfekt Passiv",
      "Futur I Passiv",
      "Präteritum Passiv"
    ],
    "correctAnswer": 2,
    "explanation": "'werden + Partizip II + werden' = Futur I Passiv.",
    "grammarRule": "Vorgangspassiv Futur I: wird/werden + Partizip II + werden",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-050",
    "level": "b1",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Perfekt: 'Man hat den Fehler korrigiert.'",
    "options": [
      "Der Fehler wird korrigiert.",
      "Der Fehler wurde korrigiert.",
      "Der Fehler ist korrigiert worden.",
      "Der Fehler war korrigiert worden."
    ],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: 'Der Fehler ist korrigiert worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "perfekt"]
  },
  {
    "language": "german", "id": "b1-passiv-p2-051",
    "level": "b1",
    "category": "Passiv",
    "question": "Was ist 'worden' im Passiv Perfekt?",
    "options": [
      "Das Partizip II von 'werden' (als Passiv-Hilfsverb)",
      "Das Partizip II von 'sein'",
      "Eine Konjunktivform",
      "Das Partizip II von 'haben'"
    ],
    "correctAnswer": 0,
    "explanation": "'worden' ist die verkürzte Form des Partizip II von 'werden', speziell im Passiv verwendet.",
    "grammarRule": "Passiv Perfekt: ist + P.II + worden (nicht 'geworden')",
    "subcategory": "Bildung",
    "tags": [
      "passiv",
      "bildung"
    ]
  },
  {"language":"german","id":"b1-passiv-p2-052","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Fotograf fotografiert die Familie.'","options":["Die Familie wird vom Fotografen fotografiert.","Der Fotograf wird fotografiert.","Die Familie ist fotografiert.","Die Familie wurde fotografiert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Familie wird vom Fotografen fotografiert.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b1-passiv-p2-053","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Der Antrag ___ gestern eingereicht.' (Präteritum Passiv)","options":["wird","ist","wurde","hat"],"correctAnswer":2,"explanation":"Präteritum Passiv: wurde + Partizip II.","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b1-passiv-p2-054","level":"b1","category":"Passiv","question":"Welcher Satz steht im Vorgangspassiv?","options":["Die Tür ist geschlossen.","Die Tür wird geschlossen.","Die Tür war geschlossen.","Die Tür bleibt geschlossen."],"correctAnswer":1,"explanation":"'wird + Partizip II' = Vorgangspassiv.","grammarRule":"werden + P.II = Vorgangspassiv","subcategory":"Zustandspassiv","tags":["passiv","zustandspassiv"]},
  {"language":"german","id":"b1-passiv-p2-055","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Die Lehrerin korrigiert die Tests.'","options":["Die Tests werden von der Lehrerin korrigiert.","Die Lehrerin wird korrigiert.","Die Tests sind korrigiert.","Die Tests wurden korrigiert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Tests werden von der Lehrerin korrigiert.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b1-passiv-p2-056","level":"b1","category":"Passiv","question":"Welche Zeitform ist: 'Die Pakete waren geliefert worden.'?","options":["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Plusquamperfekt Passiv"],"correctAnswer":3,"explanation":"'waren + Partizip II + worden' = Plusquamperfekt Passiv.","grammarRule":"Vorgangspassiv Plusquamperfekt: war/waren + Partizip II + worden","subcategory":"Erkennung","tags":["passiv","erkennung"]},
  {"language":"german","id":"b1-passiv-p2-057","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Perfekt: 'Die Nachbarn haben das Fest organisiert.'","options":["Das Fest wird von den Nachbarn organisiert.","Das Fest wurde von den Nachbarn organisiert.","Das Fest ist von den Nachbarn organisiert worden.","Das Fest war organisiert worden."],"correctAnswer":2,"explanation":"Perfekt Passiv: 'Das Fest ist von den Nachbarn organisiert worden.'","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","perfekt"]},
  {"language":"german","id":"b1-passiv-p2-058","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Das Museum ___ um 18 Uhr geschlossen.' (Zustandspassiv)","options":["wird","wurde","ist","hat"],"correctAnswer":2,"explanation":"Zustandspassiv: ist + Partizip II. Es beschreibt den Zustand.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Zustandspassiv","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b1-passiv-p2-059","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Man serviert das Frühstück um 8 Uhr.'","options":["Das Frühstück wird um 8 Uhr serviert.","Das Frühstück ist serviert.","Das Frühstück wurde serviert.","Das Frühstück wird servieren."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Das Frühstück wird um 8 Uhr serviert.'","grammarRule":"Aktiv mit 'man' → Passiv ohne Agens","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b1-passiv-p2-060","level":"b1","category":"Passiv","question":"Was bedeutet 'durch' im Passivsatz?","options":["Das direkte Agens (Person)","Ein Mittel oder eine Ursache (nicht belebt)","Den Ort der Handlung","Die Zeitangabe"],"correctAnswer":1,"explanation":"'durch' zeigt das Mittel/Instrument: 'Das Fenster wurde durch den Sturm zerstört.'","grammarRule":"von + Dativ = Agens (Person); durch + Akkusativ = Mittel/Ursache","subcategory":"Passivfähigkeit","tags":["passiv","theorie"]},
  {"language":"german","id":"b1-passiv-p2-061","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Man lieferte die Möbel.'","options":["Die Möbel werden geliefert.","Die Möbel wurden geliefert.","Die Möbel sind geliefert worden.","Die Möbel waren geliefert worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Die Möbel wurden geliefert.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","praeteritum"]},
  {"language":"german","id":"b1-passiv-p2-062","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Heizung ___ repariert ___.' (Perfekt Passiv)","options":["wurde ... worden","hat ... werden","ist ... worden","wird ... werden"],"correctAnswer":2,"explanation":"Perfekt Passiv: ist + Partizip II + worden.","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b1-passiv-p2-063","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Elektriker installiert die Lampe.'","options":["Die Lampe wird vom Elektriker installiert.","Der Elektriker wird installiert.","Die Lampe ist installiert.","Die Lampe wurde installiert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Lampe wird vom Elektriker installiert.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b1-passiv-p2-064","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Kellner serviert das Essen.'","options":["Das Essen wird vom Kellner serviert.","Der Kellner wird serviert.","Das Essen ist serviert.","Das Essen wurde serviert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Das Essen wird vom Kellner serviert.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Erkennung","tags":["passiv","unterscheidung"]},
  {"language":"german","id":"b1-passiv-p2-065","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Die Studenten schreiben eine Prüfung.'","options":["Eine Prüfung wird von den Studenten geschrieben.","Die Studenten werden geschrieben.","Eine Prüfung ist geschrieben.","Eine Prüfung wurde geschrieben."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Eine Prüfung wird von den Studenten geschrieben.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b1-passiv-p2-066","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Tische ___ schon gedeckt.' (Zustandspassiv)","options":["werden","wurden","sind","haben"],"correctAnswer":2,"explanation":"Zustandspassiv Plural: sind + Partizip II.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Zustandspassiv","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b1-passiv-p2-067","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Perfekt: 'Man hat die Straße gesperrt.'","options":["Die Straße wird gesperrt.","Die Straße wurde gesperrt.","Die Straße ist gesperrt worden.","Die Straße war gesperrt worden."],"correctAnswer":2,"explanation":"Perfekt Passiv: 'Die Straße ist gesperrt worden.'","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","perfekt"]},
  {"language":"german","id":"b1-passiv-p2-068","level":"b1","category":"Passiv","question":"Welche Präposition leitet das Mittel/Instrument im Passiv ein?","options":["von","mit","für","aus"],"correctAnswer":0,"explanation":"Das Mittel kann mit 'durch' oder 'mit' angegeben werden, der Urheber mit 'von'. Hier: 'von' für Personen.","grammarRule":"Agens: von + Dativ (Person); durch + Akkusativ (Mittel/Ursache)","subcategory":"Agens","tags":["passiv","agens"]},
  {"language":"german","id":"b1-passiv-p2-069","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Arzt verschreibt dem Patienten Medikamente.'","options":["Medikamente werden dem Patienten vom Arzt verschrieben.","Der Patient wird verschrieben.","Medikamente sind verschrieben.","Dem Patienten werden Medikamente verschrieben."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Medikamente werden dem Patienten vom Arzt verschrieben.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt, Dativobjekt bleibt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b1-passiv-p2-070","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Wohnung ___ letzte Woche renoviert.' (Präteritum Passiv)","options":["wird","ist","wurde","hat"],"correctAnswer":2,"explanation":"Präteritum Passiv: wurde + Partizip II.","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b1-passiv-p2-071","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Man plant ein neues Stadion.'","options":["Ein neues Stadion wird geplant.","Ein neues Stadion ist geplant.","Ein neues Stadion wurde geplant.","Man wird geplant."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Ein neues Stadion wird geplant.'","grammarRule":"Aktiv mit 'man' → Passiv ohne Agens","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  { 'language': 'german', 'id': 'b1-passiv-p2-072', 'level': 'b1', 'category': 'Passiv', 'question': 'Ergänzen Sie: \'Das Paket ___ morgen zugestellt ___.\' (Futur I Passiv)', 'options': ['ist ... worden', 'wird ... werden', 'wurde ... worden', 'hat ... werden'], 'correctAnswer': 1, 'explanation': 'Futur I Passiv: wird + Partizip II + werden.', 'grammarRule': 'Vorgangspassiv Futur I: wird/werden + Partizip II + werden', 'subcategory': 'Vorgangspassiv Futur I', 'tags': ['passiv', 'lueckentext'] }
];

export default questions;
