import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-passiv-p3-001",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man hat das Projekt abgeschlossen.'",
    "options": ["Das Projekt ist abgeschlossen worden.","Das Projekt wird abgeschlossen.","Das Projekt wurde abgeschlossen.","Das Projekt war abgeschlossen worden."],
    "correctAnswer": 0,
    "explanation": "Perfekt Passiv: 'Das Projekt ist abgeschlossen worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-002",
    "level": "b2",
    "category": "Passiv",
    "question": "Wie lautet Passiv Präteritum von 'Der Arzt verschrieb das Medikament.'?",
    "options": ["Das Medikament wird verschrieben.","Das Medikament wurde vom Arzt verschrieben.","Das Medikament ist verschrieben worden.","Das Medikament war verschrieben worden."],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Das Medikament wurde vom Arzt verschrieben.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde + Partizip II",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-003",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Das Auto ___ gerade gewaschen.' (Präsens Passiv)",
    "options": ["ist","hat","wird","wurde"],
    "correctAnswer": 2,
    "explanation": "Präsens Passiv: wird + Partizip II.",
    "exampleSentence": "Das Haus wird gebaut.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Bildung",
    "tags": ["passiv", "vorgangspassiv"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-004",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Köchin backt den Kuchen.'",
    "options": ["Der Kuchen wird von der Köchin gebacken.","Die Köchin wird gebacken.","Der Kuchen ist gebacken.","Der Kuchen wurde gebacken."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Der Kuchen wird von der Köchin gebacken.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-007",
    "level": "b2",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Die Aufgaben sind verteilt worden.'?",
    "options": ["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Plusquamperfekt Passiv"],
    "correctAnswer": 1,
    "explanation": "'sind + Partizip II + worden' = Perfekt Passiv.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Futur I",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-013",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man renoviert das Schwimmbad.'",
    "options": ["Das Schwimmbad wird renoviert.","Das Schwimmbad ist renoviert.","Das Schwimmbad wurde renoviert.","Das Schwimmbad war renoviert worden."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Das Schwimmbad wird renoviert.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-016",
    "level": "b2",
    "category": "Passiv",
    "question": "Welcher Satz zeigt unpersönliches Passiv?",
    "options": ["Das Buch wird gelesen.","Es wird hier nicht telefoniert.","Die Tür wird geschlossen.","Das Problem wird gelöst."],
    "correctAnswer": 1,
    "explanation": "'Es wird hier nicht telefoniert' = unpersönliches Passiv ohne logisches Subjekt.",
    "grammarRule": "Unpersönliches Passiv: es + wird + Partizip II",
    "subcategory": "Vorgangspassiv Plusquamperfekt",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-019",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Der Verletzte ___ ins Krankenhaus gebracht ___.' (Perfekt Passiv)",
    "options": ["wurde ... worden","hat ... werden","ist ... worden","war ... worden"],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: ist + Partizip II + worden.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-022",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man schließt die Bibliothek um 20 Uhr.'",
    "options": ["Die Bibliothek wird um 20 Uhr geschlossen.","Die Bibliothek ist um 20 Uhr geschlossen.","Die Bibliothek wurde geschlossen.","Man wird geschlossen."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Bibliothek wird um 20 Uhr geschlossen.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-025",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man streicht die Wände.'",
    "options": ["Die Wände werden gestrichen.","Die Wände sind gestrichen.","Die Wände wurden gestrichen.","Man wird gestrichen."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Wände werden gestrichen.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-031",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Suppe ___ gerade gekocht.' (Präsens Passiv)",
    "options": [
      "ist",
      "wird",
      "wurde",
      "hat"
    ],
    "correctAnswer": 1,
    "explanation": "Präsens Passiv: wird + Partizip II.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-032",
    "level": "b2",
    "category": "Passiv",
    "question": "Welcher Satz steht im Zustandspassiv Präteritum?",
    "options": [
      "Die Tür wurde geöffnet.",
      "Die Tür war geöffnet.",
      "Die Tür ist geöffnet worden.",
      "Die Tür wird geöffnet."
    ],
    "correctAnswer": 1,
    "explanation": "'war + Partizip II' (ohne 'worden') = Zustandspassiv Präteritum.",
    "grammarRule": "Zustandspassiv Präteritum: war/waren + Partizip II",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "zustandspassiv"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-033",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Postbote bringt die Briefe.'",
    "options": [
      "Die Briefe werden vom Postboten gebracht.",
      "Der Postbote wird gebracht.",
      "Die Briefe sind gebracht.",
      "Die Briefe wurden gebracht."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Briefe werden vom Postboten gebracht.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-034",
    "level": "b2",
    "category": "Passiv",
    "question": "Wie kann man das Agens im Passivsatz weglassen?",
    "options": ["Nur bei bekanntem Täter","Immer wenn es nicht relevant ist","Nur im Präteritum","Nie – das Agens muss immer angegeben werden"],
    "correctAnswer": 1,
    "explanation": "Das Agens kann im Passivsatz weggelassen werden, wenn es nicht relevant oder unbekannt ist.",
    "grammarRule": "Passiv ohne Agens: wenn Täter unbekannt oder unwichtig",
    "subcategory": "Erkennung",
    "tags": ["passiv", "unterscheidung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-035",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Präteritum: 'Man informierte die Teilnehmer.'",
    "options": [
      "Die Teilnehmer werden informiert.",
      "Die Teilnehmer wurden informiert.",
      "Die Teilnehmer sind informiert worden.",
      "Die Teilnehmer waren informiert worden."
    ],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Die Teilnehmer wurden informiert.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präteritum",
    "tags": ["passiv", "praeteritum"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-036",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Der Hund ___ jeden Tag gefüttert.' (Präsens Passiv)",
    "options": [
      "ist",
      "hat",
      "wurde",
      "wird"
    ],
    "correctAnswer": 3,
    "explanation": "Präsens Passiv: wird + Partizip II.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-037",
    "level": "b2",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Die Rechnung war bezahlt worden.'?",
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
    "language": "german", "id": "b2-passiv-p3-040",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man trinkt hier keinen Alkohol.'",
    "options": [
      "Hier wird kein Alkohol getrunken.",
      "Hier ist kein Alkohol getrunken.",
      "Hier wurde kein Alkohol getrunken.",
      "Hier war kein Alkohol getrunken."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Hier wird kein Alkohol getrunken.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-041",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Fenster ___ gestern geputzt ___.' (Perfekt Passiv)",
    "options": [
      "wurden ... worden",
      "haben ... werden",
      "sind ... worden",
      "waren ... worden"
    ],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: sind + Partizip II + worden.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-042",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Busfahrer fährt die Kinder zur Schule.'",
    "options": ["Die Kinder werden vom Busfahrer zur Schule gefahren.","Der Busfahrer wird gefahren.","Die Kinder sind gefahren.","Die Kinder wurden gefahren."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Kinder werden vom Busfahrer zur Schule gefahren.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-043",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Maler streicht die Wand.'",
    "options": [
      "Die Wand wird vom Maler gestrichen.",
      "Der Maler wird gestrichen.",
      "Die Wand ist gestrichen.",
      "Die Wand wurde gestrichen."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Wand wird vom Maler gestrichen.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-044",
    "level": "b2",
    "category": "Passiv",
    "question": "Welches Hilfsverb steht im Zustandspassiv?",
    "options": [
      "werden",
      "haben",
      "sein",
      "möchten"
    ],
    "correctAnswer": 2,
    "explanation": "Das Zustandspassiv wird mit 'sein' gebildet: 'Die Tür ist geöffnet.'",
    "grammarRule": "Zustandspassiv: sein + Partizip II",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-045",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Perfekt: 'Die Polizei hat den Verbrecher verhaftet.'",
    "options": [
      "Der Verbrecher wird verhaftet.",
      "Der Verbrecher ist von der Polizei verhaftet worden.",
      "Der Verbrecher wurde verhaftet.",
      "Der Verbrecher war verhaftet worden."
    ],
    "correctAnswer": 1,
    "explanation": "Perfekt Passiv: 'Der Verbrecher ist von der Polizei verhaftet worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "perfekt"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-047",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man hat die Wohnung vermietet.'",
    "options": ["Die Wohnung ist vermietet worden.","Die Wohnung wird vermietet.","Die Wohnung wurde vermietet.","Die Wohnung war vermietet worden."],
    "correctAnswer": 0,
    "explanation": "Perfekt Passiv: 'Die Wohnung ist vermietet worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Erkennung",
    "tags": ["passiv", "unterscheidung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-048",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man verkauft hier Obst.'",
    "options": [
      "Hier wird Obst verkauft.",
      "Hier ist Obst verkauft.",
      "Hier wurde Obst verkauft.",
      "Obst wird hier verkaufen."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Hier wird Obst verkauft.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-049",
    "level": "b2",
    "category": "Passiv",
    "question": "Wie unterscheidet man 'geworden' und 'worden'?",
    "options": [
      "Kein Unterschied",
      "'geworden' = Vollverb werden, 'worden' = Passiv-Hilfsverb",
      "'worden' = Vollverb werden, 'geworden' = Passiv",
      "Beide sind Passivformen"
    ],
    "correctAnswer": 1,
    "explanation": "'Er ist Arzt geworden' (Vollverb). 'Er ist operiert worden' (Passiv-Hilfsverb).",
    "grammarRule": "geworden = Vollverb; worden = Passiv-Hilfsverb im Perfekt",
    "subcategory": "Bildung",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b2-passiv-p3-050",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Präteritum: 'Der Chef unterschrieb den Vertrag.'",
    "options": [
      "Der Vertrag wird vom Chef unterschrieben.",
      "Der Vertrag wurde vom Chef unterschrieben.",
      "Der Vertrag ist vom Chef unterschrieben worden.",
      "Der Vertrag war vom Chef unterschrieben worden."
    ],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Der Vertrag wurde vom Chef unterschrieben.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präteritum",
    "tags": ["passiv", "praeteritum"]
  },
  {"language":"german","id":"b2-passiv-p3-051","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Maler streicht die Wände.'","options":["Die Wände werden vom Maler gestrichen.","Der Maler wird gestrichen.","Die Wände sind gestrichen.","Die Wände wurden gestrichen."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Wände werden vom Maler gestrichen.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p3-052","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Das Konzert ___ abgesagt ___.' (Perfekt Passiv)","options":["wurde ... worden","hat ... werden","ist ... worden","wird ... werden"],"correctAnswer":2,"explanation":"Perfekt Passiv: ist + Partizip II + worden.","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p3-053","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Das Paket ___ noch nicht abgeholt.' (Zustandspassiv, Verneinung)","options":["wird","wurde","ist","hat"],"correctAnswer":2,"explanation":"Zustandspassiv: ist + (noch nicht) + Partizip II.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Zustandspassiv","tags":["passiv","zustandspassiv"]},
  {"language":"german","id":"b2-passiv-p3-054","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Man überweist das Geld.'","options":["Das Geld wird überwiesen.","Das Geld ist überwiesen.","Das Geld wurde überwiesen.","Man wird überwiesen."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Das Geld wird überwiesen.'","grammarRule":"Aktiv mit 'man' → Passiv ohne Agens","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p3-055","level":"b1","category":"Passiv","question":"Welche Zeitform ist: 'Die Brücke wird gebaut werden.'?","options":["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Futur I Passiv"],"correctAnswer":3,"explanation":"'wird + Partizip II + werden' = Futur I Passiv.","grammarRule":"Vorgangspassiv Futur I: wird/werden + Partizip II + werden","subcategory":"Erkennung","tags":["passiv","erkennung"]},
  {"language":"german","id":"b2-passiv-p3-056","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Der Koch bereitete das Menü vor.'","options":["Das Menü wird vom Koch vorbereitet.","Das Menü wurde vom Koch vorbereitet.","Das Menü ist vorbereitet worden.","Das Menü war vorbereitet worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Das Menü wurde vom Koch vorbereitet.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","praeteritum"]},
  {"language":"german","id":"b2-passiv-p3-057","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Wäsche ___ schon gewaschen.' (Zustandspassiv)","options":["wird","wurde","ist","hat"],"correctAnswer":2,"explanation":"Zustandspassiv: ist + Partizip II.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Zustandspassiv","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p3-058","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Die Krankenschwester misst den Blutdruck.'","options":["Der Blutdruck wird von der Krankenschwester gemessen.","Die Krankenschwester wird gemessen.","Der Blutdruck ist gemessen.","Der Blutdruck wurde gemessen."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Der Blutdruck wird von der Krankenschwester gemessen.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p3-059","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Perfekt: 'Man hat die Tickets reserviert.'","options":["Die Tickets werden reserviert.","Die Tickets wurden reserviert.","Die Tickets sind reserviert worden.","Die Tickets waren reserviert worden."],"correctAnswer":2,"explanation":"Perfekt Passiv: 'Die Tickets sind reserviert worden.'","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Passivfähigkeit","tags":["passiv","theorie"]},
  {"language":"german","id":"b2-passiv-p3-060","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Perfekt: 'Man hat den Termin verschoben.'","options":["Der Termin wird verschoben.","Der Termin wurde verschoben.","Der Termin ist verschoben worden.","Der Termin war verschoben worden."],"correctAnswer":2,"explanation":"Perfekt Passiv: 'Der Termin ist verschoben worden.'","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","perfekt"]},
  {"language":"german","id":"b2-passiv-p3-061","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Tickets ___ online verkauft.' (Präsens Passiv)","options":["sind","haben","werden","wurden"],"correctAnswer":2,"explanation":"Präsens Passiv Plural: werden + Partizip II.","grammarRule":"Vorgangspassiv Präsens: wird/werden + Partizip II","subcategory":"Vorgangspassiv Präsens","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p3-062","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Briefträger liefert die Post.'","options":["Die Post wird vom Briefträger geliefert.","Der Briefträger wird geliefert.","Die Post ist geliefert.","Die Post wurde geliefert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Post wird vom Briefträger geliefert.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p3-063","level":"b1","category":"Passiv","question":"Welcher Satz steht im Passiv Perfekt?","options":["Das Bild wurde gemalt.","Das Bild ist gemalt.","Das Bild ist gemalt worden.","Das Bild wird gemalt."],"correctAnswer":2,"explanation":"'ist + Partizip II + worden' = Perfekt Passiv.","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Erkennung","tags":["passiv","unterscheidung"]},
  {"language":"german","id":"b2-passiv-p3-064","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Man druckte die Einladungen.'","options":["Die Einladungen werden gedruckt.","Die Einladungen wurden gedruckt.","Die Einladungen sind gedruckt worden.","Die Einladungen waren gedruckt worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Die Einladungen wurden gedruckt.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","praeteritum"]},
  {"language":"german","id":"b2-passiv-p3-065","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Der Computer ___ schon eingeschaltet.' (Zustandspassiv)","options":["wird","wurde","ist","hat"],"correctAnswer":2,"explanation":"Zustandspassiv: ist + Partizip II.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Zustandspassiv","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p3-066","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Die Firma stellt neue Produkte her.'","options":["Neue Produkte werden von der Firma hergestellt.","Die Firma wird hergestellt.","Neue Produkte sind hergestellt.","Neue Produkte wurden hergestellt."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Neue Produkte werden von der Firma hergestellt.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p3-067","level":"b1","category":"Passiv","question":"Welche Aussage ist richtig?","options":["Im Zustandspassiv verwendet man 'werden'.","Im Vorgangspassiv verwendet man 'sein'.","'durch' leitet eine unpersönliche Ursache ein.","Reflexive Verben können immer Passiv bilden."],"correctAnswer":2,"explanation":"'durch + Akkusativ' leitet eine unpersönliche Ursache ein: 'durch den Sturm zerstört'.","grammarRule":"von + Dativ (Person/Agens); durch + Akkusativ (Ursache/Mittel)","subcategory":"Agens","tags":["passiv","agens"]},
  {"language":"german","id":"b2-passiv-p3-068","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Perfekt: 'Der Techniker hat den Drucker repariert.'","options":["Der Drucker wird vom Techniker repariert.","Der Drucker wurde vom Techniker repariert.","Der Drucker ist vom Techniker repariert worden.","Der Drucker war repariert worden."],"correctAnswer":2,"explanation":"Perfekt Passiv: 'Der Drucker ist vom Techniker repariert worden.'","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","perfekt"]},
  {"language":"german","id":"b2-passiv-p3-069","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Waren ___ morgen geliefert ___.' (Futur I Passiv)","options":["sind ... worden","werden ... werden","wurden ... worden","werden ... worden"],"correctAnswer":1,"explanation":"Futur I Passiv: werden + Partizip II + werden.","grammarRule":"Vorgangspassiv Futur I: wird/werden + Partizip II + werden","subcategory":"Vorgangspassiv Futur I","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p3-070","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Man bezahlt die Rechnung sofort.'","options":["Die Rechnung wird sofort bezahlt.","Die Rechnung ist sofort bezahlt.","Die Rechnung wurde sofort bezahlt.","Man wird sofort bezahlt."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Rechnung wird sofort bezahlt.'","grammarRule":"Aktiv mit 'man' → Passiv ohne Agens","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p3-071","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Die Ärztin untersuchte das Kind.'","options":["Das Kind wird von der Ärztin untersucht.","Das Kind wurde von der Ärztin untersucht.","Das Kind ist untersucht worden.","Das Kind war untersucht worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Das Kind wurde von der Ärztin untersucht.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Erkennung","tags":["passiv","erkennung"]},
  { 'language': 'german', 'id': 'b1-passiv-p3-072', 'level': 'b1', 'category': 'Passiv', 'question': 'Formulieren Sie im Passiv: \'Man kontrolliert die Pässe am Flughafen.\'', 'options': ['Die Pässe werden am Flughafen kontrolliert.', 'Die Pässe sind kontrolliert.', 'Die Pässe wurden kontrolliert.', 'Man wird kontrolliert.'], 'correctAnswer': 0, 'explanation': 'Präsens Passiv: \'Die Pässe werden am Flughafen kontrolliert.\'', 'grammarRule': 'Aktiv mit \'man\' -> Passiv ohne Agens', 'subcategory': 'Vorgangspassiv Präsens', 'tags': ['passiv', 'umformung'] },
  { 'language': 'german', 'id': 'b1-passiv-p3-073', 'level': 'b1', 'category': 'Passiv', 'question': 'Ergänzen Sie: \'Die Hausaufgaben ___ gemacht ___.\' (Passiv mit Modalverb)', 'options': ['werden ... müssen', 'müssen ... gemacht', 'müssen ... werden', 'sind ... worden'], 'correctAnswer': 2, 'explanation': 'Passiv mit Modalverb: Modalverb + Partizip II + werden.', 'grammarRule': 'Passiv mit Modalverb: Modalverb + Partizip II + werden', 'subcategory': 'Passiv mit Modalverb', 'tags': ['passiv', 'modalverben'] }
];

export default questions;
