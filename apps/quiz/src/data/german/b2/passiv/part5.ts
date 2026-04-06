import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-passiv-p5-002",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Optiker prüft die Augen.'",
    "options": ["Die Augen werden vom Optiker geprüft.","Der Optiker wird geprüft.","Die Augen sind geprüft.","Die Augen wurden geprüft."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Augen werden vom Optiker geprüft.'",
    "exampleSentence": "Das Haus wird gebaut.",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Bildung",
    "tags": ["passiv", "vorgangspassiv"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-006",
    "level": "b2",
    "category": "Passiv",
    "question": "Was zeigt das Agens im Passivsatz mit 'von'?",
    "options": ["Das Mittel oder Instrument","Den verantwortlichen Akteur (Person/Institution)","Den Ort der Handlung","Die Zeit der Handlung"],
    "correctAnswer": 1,
    "explanation": "'von + Dativ' zeigt den verantwortlichen Akteur: 'von der Polizei'.",
    "grammarRule": "Agens mit von + Dativ = Akteur",
    "subcategory": "Vorgangspassiv Plusquamperfekt",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-009",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Das Gebäude ___ gerade renoviert ___.' (Futur I Passiv)",
    "options": ["ist ... worden","wird ... werden","wurde ... worden","hat ... werden"],
    "correctAnswer": 1,
    "explanation": "Futur I Passiv: wird + Partizip II + werden.",
    "grammarRule": "Vorgangspassiv Futur I: wird/werden + Partizip II + werden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-012",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man hat den Dieb verhaftet.'",
    "options": ["Der Dieb wird verhaftet.","Der Dieb wurde verhaftet.","Der Dieb ist verhaftet worden.","Der Dieb war verhaftet worden."],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: 'Der Dieb ist verhaftet worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-015",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Der Verletzte ___ operiert ___.' (Perfekt Passiv)",
    "options": ["wurde ... worden","hat ... werden","ist ... worden","war ... worden"],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: ist + Partizip II + worden.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-018",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Perfekt: 'Man hat die Ergebnisse veröffentlicht.'",
    "options": ["Die Ergebnisse werden veröffentlicht.","Die Ergebnisse wurden veröffentlicht.","Die Ergebnisse sind veröffentlicht worden.","Die Ergebnisse waren veröffentlicht worden."],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: 'Die Ergebnisse sind veröffentlicht worden.'",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-021",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Zahnarzt zog den Zahn.'",
    "options": ["Der Zahn wird vom Zahnarzt gezogen.","Der Zahn wurde vom Zahnarzt gezogen.","Der Zahn ist gezogen worden.","Der Zahn war gezogen worden."],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Der Zahn wurde vom Zahnarzt gezogen.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-031",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Zeitung ___ jeden Morgen gelesen.' (Präsens Passiv)",
    "options": [
      "ist",
      "wird",
      "hat",
      "wurde"
    ],
    "correctAnswer": 1,
    "explanation": "Präsens Passiv: wird + Partizip II.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-032",
    "level": "b2",
    "category": "Passiv",
    "question": "Welcher Satz steht im Vorgangspassiv Perfekt?",
    "options": ["Das Buch ist interessant.","Das Buch wurde gedruckt.","Das Buch ist gedruckt worden.","Das Buch wird gedruckt."],
    "correctAnswer": 2,
    "explanation": "'ist + Partizip II + worden' = Vorgangspassiv Perfekt.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "zustandspassiv"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-033",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Der Techniker repariert den Drucker.'",
    "options": [
      "Der Drucker wird vom Techniker repariert.",
      "Der Techniker wird repariert.",
      "Der Drucker ist repariert.",
      "Der Drucker wurde repariert."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Der Drucker wird vom Techniker repariert.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-034",
    "level": "b2",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Die Prüfung wird morgen abgelegt werden.'?",
    "options": ["Präsens Passiv","Perfekt Passiv","Futur I Passiv","Plusquamperfekt Passiv"],
    "correctAnswer": 2,
    "explanation": "'wird + Partizip II + werden' = Futur I Passiv.",
    "grammarRule": "Vorgangspassiv Futur I",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-035",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Pianistin spielt das Konzert.'",
    "options": ["Das Konzert wird von der Pianistin gespielt.","Die Pianistin wird gespielt.","Das Konzert ist gespielt.","Das Konzert wurde gespielt."],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Das Konzert wird von der Pianistin gespielt.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Erkennung",
    "tags": ["passiv", "unterscheidung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-036",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Präteritum: 'Der Pilot landete das Flugzeug.'",
    "options": [
      "Das Flugzeug wird vom Piloten gelandet.",
      "Das Flugzeug wurde vom Piloten gelandet.",
      "Das Flugzeug ist gelandet worden.",
      "Das Flugzeug war gelandet worden."
    ],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Das Flugzeug wurde vom Piloten gelandet.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präteritum",
    "tags": ["passiv", "praeteritum"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-037",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Prüfungen ___ nächste Woche geschrieben ___.' (Futur I Passiv)",
    "options": [
      "werden ... werden",
      "sind ... worden",
      "wurden ... werden",
      "werden ... worden"
    ],
    "correctAnswer": 0,
    "explanation": "Futur I Passiv: werden + Partizip II + werden.",
    "grammarRule": "Vorgangspassiv Futur I: wird/werden + Partizip II + werden",
    "subcategory": "Vorgangspassiv Futur I",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-038",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man singt Lieder auf dem Fest.'",
    "options": [
      "Lieder werden auf dem Fest gesungen.",
      "Lieder sind auf dem Fest gesungen.",
      "Lieder wurden auf dem Fest gesungen.",
      "Lieder waren gesungen worden."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Lieder werden auf dem Fest gesungen.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-039",
    "level": "b2",
    "category": "Passiv",
    "question": "Welcher Satz zeigt ein unpersönliches Passiv?",
    "options": [
      "Das Buch wird gelesen.",
      "Der Kuchen wird gebacken.",
      "Es wird hier nicht geraucht.",
      "Die Tür wird geschlossen."
    ],
    "correctAnswer": 2,
    "explanation": "'Es wird hier nicht geraucht' ist ein unpersönliches Passiv (kein Subjekt außer 'es').",
    "grammarRule": "Unpersönliches Passiv: es wird + Partizip II (kein logisches Subjekt)",
    "subcategory": "Bildung",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-040",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Die Krankenschwester verbindet die Wunde.'",
    "options": [
      "Die Wunde wird von der Krankenschwester verbunden.",
      "Die Krankenschwester wird verbunden.",
      "Die Wunde ist verbunden.",
      "Die Wunde wurde verbunden."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Wunde wird von der Krankenschwester verbunden.'",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-041",
    "level": "b2",
    "category": "Passiv",
    "question": "Welche Zeitform ist: 'Das Formular wird ausgefüllt.'?",
    "options": [
      "Präsens Passiv",
      "Präteritum Passiv",
      "Perfekt Passiv",
      "Zustandspassiv"
    ],
    "correctAnswer": 0,
    "explanation": "'wird + Partizip II' = Präsens Passiv (Vorgangspassiv).",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-042",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Die Nachrichten ___ um 20 Uhr gesendet.' (Präsens Passiv)",
    "options": [
      "sind",
      "werden",
      "haben",
      "wurden"
    ],
    "correctAnswer": 1,
    "explanation": "Präsens Passiv Plural: werden + Partizip II.",
    "grammarRule": "Vorgangspassiv Präsens: wird/werden + Partizip II",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-043",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Das Licht ___ nach Hause schon ausgemacht.' (Zustandspassiv)",
    "options": ["wird","wurde","ist","hat"],
    "correctAnswer": 2,
    "explanation": "Zustandspassiv: ist + Partizip II.",
    "grammarRule": "Zustandspassiv: sein + Partizip II",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "perfekt"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-044",
    "level": "b2",
    "category": "Passiv",
    "question": "Welches Wort zeigt, dass ein Satz im Zustandspassiv steht?",
    "options": [
      "werden",
      "haben",
      "sein",
      "worden"
    ],
    "correctAnswer": 2,
    "explanation": "'sein' + Partizip II = Zustandspassiv: 'Die Tür ist geschlossen.'",
    "grammarRule": "Zustandspassiv: sein + Partizip II",
    "subcategory": "Zustandspassiv",
    "tags": ["passiv", "theorie"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-046",
    "level": "b2",
    "category": "Passiv",
    "question": "Welcher Satz steht im Passiv Präteritum?",
    "options": [
      "Das Konzert wird aufgeführt.",
      "Das Konzert wurde aufgeführt.",
      "Das Konzert ist aufgeführt worden.",
      "Das Konzert ist aufgeführt."
    ],
    "correctAnswer": 1,
    "explanation": "'wurde + Partizip II' = Präteritum Passiv.",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Erkennung",
    "tags": ["passiv", "erkennung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-047",
    "level": "b2",
    "category": "Passiv",
    "question": "Ergänzen Sie: 'Der Patient ___ vom Arzt operiert ___.' (Perfekt Passiv)",
    "options": [
      "wurde ... worden",
      "hat ... werden",
      "ist ... worden",
      "war ... worden"
    ],
    "correctAnswer": 2,
    "explanation": "Perfekt Passiv: ist + Partizip II + worden.",
    "grammarRule": "Vorgangspassiv Perfekt: ist/sind + Partizip II + worden",
    "subcategory": "Vorgangspassiv Perfekt",
    "tags": ["passiv", "lueckentext"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-048",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv: 'Man kontrolliert die Pässe an der Grenze.'",
    "options": [
      "Die Pässe werden an der Grenze kontrolliert.",
      "Die Pässe sind an der Grenze kontrolliert.",
      "Die Pässe wurden an der Grenze kontrolliert.",
      "Die Pässe waren kontrolliert worden."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'Die Pässe werden an der Grenze kontrolliert.'",
    "grammarRule": "Aktiv mit 'man' → Passiv ohne Agens",
    "subcategory": "Vorgangspassiv Präsens",
    "tags": ["passiv", "umformung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-049",
    "level": "b2",
    "category": "Passiv",
    "question": "Was ist der Unterschied zwischen 'Die Tür wird geöffnet' und 'Die Tür ist geöffnet'?",
    "options": [
      "Kein Unterschied",
      "Erstes = jemand öffnet gerade; Zweites = die Tür ist schon offen",
      "Erstes = Zustand; Zweites = Vorgang",
      "Beide beschreiben die Zukunft"
    ],
    "correctAnswer": 1,
    "explanation": "'wird geöffnet' = Vorgang (jemand öffnet). 'ist geöffnet' = Zustand (schon offen).",
    "grammarRule": "Vorgangspassiv (werden) vs. Zustandspassiv (sein)",
    "subcategory": "Erkennung",
    "tags": ["passiv", "unterscheidung"]
  },
  {
    "language": "german", "id": "b2-passiv-p5-050",
    "level": "b2",
    "category": "Passiv",
    "question": "Formulieren Sie im Passiv Präteritum: 'Die Nachbarin fütterte die Katze.'",
    "options": [
      "Die Katze wird von der Nachbarin gefüttert.",
      "Die Katze wurde von der Nachbarin gefüttert.",
      "Die Katze ist von der Nachbarin gefüttert worden.",
      "Die Katze war gefüttert worden."
    ],
    "correctAnswer": 1,
    "explanation": "Präteritum Passiv: 'Die Katze wurde von der Nachbarin gefüttert.'",
    "grammarRule": "Vorgangspassiv Präteritum: wurde/wurden + Partizip II",
    "subcategory": "Vorgangspassiv Präteritum",
    "tags": ["passiv", "praeteritum"]
  },
  {"language":"german","id":"b2-passiv-p5-051","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Man sanierte die alte Fabrik.'","options":["Die Fabrik wird saniert.","Die Fabrik wurde saniert.","Die Fabrik ist saniert worden.","Die Fabrik war saniert worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Die Fabrik wurde saniert.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p5-052","level":"b1","category":"Passiv","question":"Was bedeutet 'Zustandspassiv'?","options":["Eine Handlung, die gerade stattfindet","Das Ergebnis einer abgeschlossenen Handlung","Eine zukünftige Handlung","Eine verneinte Handlung"],"correctAnswer":1,"explanation":"Zustandspassiv beschreibt den Ergebnis-Zustand: 'Die Tür ist geschlossen' = sie ist jetzt zu.","grammarRule":"Zustandspassiv = Ergebnis; Vorgangspassiv = Prozess","subcategory":"Zustandspassiv","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p5-053","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Koch kocht die Suppe.'","options":["Die Suppe wird vom Koch gekocht.","Der Koch wird gekocht.","Die Suppe ist gekocht.","Die Suppe wurde gekocht."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Suppe wird vom Koch gekocht.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Erkennung","tags":["passiv","unterscheidung"]},
  {"language":"german","id":"b2-passiv-p5-054","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Der Bericht ___ fertiggestellt ___.' (Perfekt Passiv)","options":["wurde ... worden","hat ... werden","ist ... worden","wird ... werden"],"correctAnswer":2,"explanation":"Perfekt Passiv: ist + Partizip II + worden.","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p5-055","level":"b1","category":"Passiv","question":"Welche Zeitform ist: 'Der Kuchen war gebacken worden.'?","options":["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Plusquamperfekt Passiv"],"correctAnswer":3,"explanation":"'war + Partizip II + worden' = Plusquamperfekt Passiv.","grammarRule":"Vorgangspassiv Plusquamperfekt: war/waren + Partizip II + worden","subcategory":"Erkennung","tags":["passiv","erkennung"]},
  {"language":"german","id":"b2-passiv-p5-056","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Man beantwortet die Fragen.'","options":["Die Fragen werden beantwortet.","Die Fragen sind beantwortet.","Die Fragen wurden beantwortet.","Man wird beantwortet."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Fragen werden beantwortet.'","grammarRule":"Aktiv mit 'man' → Passiv ohne Agens","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","perfekt"]},
  {"language":"german","id":"b2-passiv-p5-057","level":"b1","category":"Passiv","question":"Welches Verb bildet kein Vorgangspassiv?","options":["waschen","kaufen","existieren","bezahlen"],"correctAnswer":2,"explanation":"'existieren' ist intransitiv und bildet kein persönliches Passiv.","grammarRule":"Nur transitive Verben bilden ein persönliches Passiv","subcategory":"Vorgangspassiv Präsens","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p5-058","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Die Angestellten sortieren die Akten.'","options":["Die Akten werden von den Angestellten sortiert.","Die Angestellten werden sortiert.","Die Akten sind sortiert.","Die Akten wurden sortiert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Akten werden von den Angestellten sortiert.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p5-059","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Futur I: 'Man wird das Konzert absagen.'","options":["Das Konzert wird abgesagt.","Das Konzert wird abgesagt werden.","Das Konzert wurde abgesagt.","Das Konzert ist abgesagt worden."],"correctAnswer":1,"explanation":"Futur I Passiv: 'Das Konzert wird abgesagt werden.'","grammarRule":"Vorgangspassiv Futur I: wird/werden + Partizip II + werden","subcategory":"Passivfähigkeit","tags":["passiv","theorie"]},
  {"language":"german","id":"b2-passiv-p5-060","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Der Zahnarzt zog den Zahn.'","options":["Der Zahn wird vom Zahnarzt gezogen.","Der Zahn wurde vom Zahnarzt gezogen.","Der Zahn ist gezogen worden.","Der Zahn war gezogen worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Der Zahn wurde vom Zahnarzt gezogen.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","praeteritum"]},
  {"language":"german","id":"b2-passiv-p5-061","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Ergebnisse ___ veröffentlicht ___.' (Perfekt Passiv)","options":["wurden ... worden","haben ... werden","sind ... worden","werden ... werden"],"correctAnswer":2,"explanation":"Perfekt Passiv: sind + Partizip II + worden.","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p5-062","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Zeitung ___ täglich gelesen.' (Präsens Passiv)","options":["ist","hat","wird","wurde"],"correctAnswer":2,"explanation":"Präsens Passiv: wird + Partizip II.","grammarRule":"Vorgangspassiv Präsens: wird/werden + Partizip II","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p5-063","level":"b1","category":"Passiv","question":"Welche Zeitform ist: 'Das Gebäude wurde abgerissen.'?","options":["Präsens Passiv","Präteritum Passiv","Perfekt Passiv","Futur I Passiv"],"correctAnswer":1,"explanation":"'wurde + Partizip II' = Präteritum Passiv.","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Erkennung","tags":["passiv","erkennung"]},
  {"language":"german","id":"b2-passiv-p5-064","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Die Studenten lösen die Aufgaben.'","options":["Die Aufgaben werden von den Studenten gelöst.","Die Studenten werden gelöst.","Die Aufgaben sind gelöst.","Die Aufgaben wurden gelöst."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Die Aufgaben werden von den Studenten gelöst.'","grammarRule":"Aktiv → Passiv","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p5-065","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Tür ___ abgeschlossen.' (Zustandspassiv)","options":["wird","wurde","ist","hat"],"correctAnswer":2,"explanation":"Zustandspassiv: ist + Partizip II.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Zustandspassiv","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p5-066","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Hausaufgaben ___ kontrolliert.' (Zustandspassiv)","options":["werden","wurden","sind","hat"],"correctAnswer":2,"explanation":"Zustandspassiv: sind + Partizip II.","grammarRule":"Zustandspassiv: sein + Partizip II","subcategory":"Vorgangspassiv Perfekt","tags":["passiv","perfekt"]},
  {"language":"german","id":"b2-passiv-p5-067","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Techniker installiert den Computer.'","options":["Der Computer wird vom Techniker installiert.","Der Techniker wird installiert.","Der Computer ist installiert.","Der Computer wurde installiert."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Der Computer wird vom Techniker installiert.'","grammarRule":"Aktiv → Passiv","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  {"language":"german","id":"b2-passiv-p5-068","level":"b1","category":"Passiv","question":"Welche Präposition zeigt das Agens bei Personen?","options":["durch","mit","von","für"],"correctAnswer":2,"explanation":"Bei Personen: 'von + Dativ' (von der Lehrerin, vom Arzt).","grammarRule":"Agens Person: von + Dativ","subcategory":"Erkennung","tags":["passiv","erkennung"]},
  {"language":"german","id":"b2-passiv-p5-069","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv Präteritum: 'Man bestellte die Ware online.'","options":["Die Ware wird online bestellt.","Die Ware wurde online bestellt.","Die Ware ist online bestellt worden.","Die Ware war bestellt worden."],"correctAnswer":1,"explanation":"Präteritum Passiv: 'Die Ware wurde online bestellt.'","grammarRule":"Vorgangspassiv Präteritum: wurde/wurden + Partizip II","subcategory":"Vorgangspassiv Präteritum","tags":["passiv","praeteritum"]},
  {"language":"german","id":"b2-passiv-p5-070","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Arbeit ___ bis morgen erledigt ___.' (Futur I Passiv)","options":["ist ... worden","wird ... werden","wurde ... worden","hat ... werden"],"correctAnswer":1,"explanation":"Futur I Passiv: wird + Partizip II + werden.","grammarRule":"Vorgangspassiv Futur I: wird/werden + Partizip II + werden","subcategory":"Vorgangspassiv Futur I","tags":["passiv","lueckentext"]},
  {"language":"german","id":"b2-passiv-p5-072","level":"b1","category":"Passiv","question":"Formulieren Sie im Passiv: 'Der Gärtner pflanzt die Rosen.'","options":["Die Rosen werden vom Gärtner gepflanzt.","Der Gärtner wird gepflanzt.","Die Rosen sind gepflanzt.","Die Rosen wurden gepflanzt."],"correctAnswer":0,"explanation":"Präsens Passiv: 'Der Vertrag wird vom Direktor unterschrieben.'","grammarRule":"Aktiv → Passiv: Akkusativobjekt wird Subjekt","subcategory":"Erkennung","tags":["passiv","unterscheidung"]},
  {"language":"german","id":"b2-passiv-p5-073","level":"b1","category":"Passiv","question":"Ergänzen Sie: 'Die Fehler ___ korrigiert ___.' (Perfekt Passiv)","options":["wurde ... worden","hat ... werden","ist ... worden","wird ... werden"],"correctAnswer":2,"explanation":"Perfekt Passiv: ist + Partizip II + worden.","grammarRule":"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden","subcategory":"Vorgangspassiv Präsens","tags":["passiv","umformung"]},
  { 'language': 'german', 'id': 'b1-passiv-p5-075', 'level': 'b1', 'category': 'Passiv', 'question': 'Formulieren Sie im Passiv Präteritum: \'Der Koch bereitete das Essen zu.\'', 'options': ['Das Essen wird zubereitet.', 'Das Essen wurde vom Koch zubereitet.', 'Das Essen ist zubereitet worden.', 'Das Essen war zubereitet.'], 'correctAnswer': 1, 'explanation': 'Präteritum Passiv: \'Das Essen wurde vom Koch zubereitet.\'', 'grammarRule': 'Vorgangspassiv Präteritum: wurde/wurden + Partizip II', 'subcategory': 'Vorgangspassiv Präteritum', 'tags': ['passiv', 'praeteritum'] }
];

export default questions;
