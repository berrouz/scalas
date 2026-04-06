import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b1-umformung-p1-001",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Der Lehrer korrigiert die Tests.'",
    "options": [
      "Die Tests werden vom Lehrer korrigiert.",
      "Vom Lehrer die Tests korrigiert werden.",
      "Die Tests sind vom Lehrer korrigiert.",
      "Die Tests korrigieren den Lehrer."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Aktiv → Präsens Passiv: werden + Partizip II. 'vom Lehrer' (von + Dativ).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-002",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Man baut ein neues Haus.'",
    "options": [
      "Ein neues Haus hat gebaut.",
      "Gebaut wird ein neues Haus man.",
      "Ein neues Haus wird gebaut.",
      "Ein neues Haus ist gebaut."
    ],
    "correctAnswer": 2,
    "explanation": "Bei 'man' als Subjekt fällt das Agens im Passiv weg: 'Ein neues Haus wird gebaut.'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-003",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Mutter backt einen Kuchen.'",
    "options": [
      "Einen Kuchen backt die Mutter.",
      "Die Mutter wird einen Kuchen backen.",
      "Ein Kuchen wird von der Mutter gebacken.",
      "Ein Kuchen ist von der Mutter gebacken."
    ],
    "correctAnswer": 2,
    "explanation": "Das Akkusativobjekt wird zum Subjekt im Nominativ. Vorgangspassiv Präsens: wird + gebacken.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-004",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Er sagt: 'Ich bin müde.''",
    "options": [
      "Er sagt, er wäre müde.",
      "Er sagt: er sei müde.",
      "Er sagt, er sei müde.",
      "Er sagt, er ist müde."
    ],
    "correctAnswer": 2,
    "explanation": "Indirekte Rede mit Konjunktiv I: 'bin' → 'sei'. Komma nach dem Hauptsatz, kein Doppelpunkt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-005",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Sie fragt: 'Kommst du morgen?''",
    "options": [
      "Sie fragt, dass ich morgen komme.",
      "Sie fragt, ob ich morgen komme.",
      "Sie fragt, wenn ich morgen komme.",
      "Sie fragt, komme ich morgen."
    ],
    "correctAnswer": 1,
    "explanation": "Ja/Nein-Fragen werden in der indirekten Rede mit 'ob' eingeleitet. Verb am Ende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-006",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Weil er krank ist, bleibt er zu Hause.'",
    "options": [
      "Er ist krank, weil bleibt er zu Hause.",
      "Er ist krank. Deshalb bleibt er zu Hause.",
      "Er ist krank. Trotzdem bleibt er zu Hause.",
      "Er ist krank, denn bleibt er zu Hause."
    ],
    "correctAnswer": 1,
    "explanation": "'weil' (kausal) wird zu 'deshalb' (Satzadverb). Zwei Hauptsätze mit Inversion nach 'deshalb'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-007",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Obwohl es regnet, geht er spazieren.'",
    "options": [
      "Es regnet. Deshalb geht er spazieren.",
      "Es regnet. Trotzdem geht er spazieren.",
      "Es regnet, aber geht er spazieren.",
      "Es regnet. Obwohl geht er spazieren."
    ],
    "correctAnswer": 1,
    "explanation": "'obwohl' (konzessiv) wird zu 'trotzdem' (Satzadverb). Inversion nach 'trotzdem'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-008",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Berlin ist groß. München ist groß.' → Vergleich mit Berlin",
    "options": [
      "Berlin ist am größten als München.",
      "Berlin ist mehr groß als München.",
      "Berlin ist großer als München.",
      "Berlin ist größer als München."
    ],
    "correctAnswer": 3,
    "explanation": "Komparativ von 'groß' → 'größer' (mit Umlaut). Vergleich mit 'als'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-009",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Es ist wichtig, pünktlich zu sein.'",
    "options": [
      "Pünktlichkeit ist wichtig.",
      "Pünktlich sein ist wichtig.",
      "Das pünktlich ist wichtig.",
      "Die Pünktlich ist wichtig."
    ],
    "correctAnswer": 0,
    "explanation": "Adjektiv 'pünktlich' → Nomen 'Pünktlichkeit' (Suffix -keit).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-010",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Der Mann steht dort. Ich kenne ihn.'",
    "options": [
      "Der Mann, dem ich kenne, steht dort.",
      "Der Mann, den ich kenne, steht dort.",
      "Der Mann steht dort, den ich kenne.",
      "Der Mann, der ich kenne, steht dort."
    ],
    "correctAnswer": 1,
    "explanation": "'ihn' = Akkusativ maskulin → Relativpronomen 'den'. Der Relativsatz steht direkt nach dem Bezugswort.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-011",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Das Buch wird von den Schülern gelesen.'",
    "options": [
      "Das Buch wird die Schüler gelesen.",
      "Die Schüler werden das Buch lesen.",
      "Die Schüler lesen das Buch.",
      "Das Buch liest die Schüler."
    ],
    "correctAnswer": 2,
    "explanation": "'von den Schülern' (Agens) wird zum Subjekt. Das Passivsubjekt wird zum Akkusativobjekt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-012",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Ich habe kein Geld. Ich kann nicht reisen.'",
    "options": [
      "Wenn ich Geld hätte, würde ich reisen können.",
      "Wenn ich Geld hätte, könnte ich reisen.",
      "Wenn ich Geld hätte, kann ich reisen.",
      "Wenn ich Geld habe, könnte ich reisen."
    ],
    "correctAnswer": 1,
    "explanation": "Irrealer Konditionalsatz: 'wenn + hätte' im Nebensatz, 'könnte' (Konjunktiv II von können) im Hauptsatz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-013",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Kinder malen ein Bild.'",
    "options": [
      "Ein Bild wird von den Kindern gemalt.",
      "Ein Bild ist von den Kindern gemalt.",
      "Ein Bild malt von den Kindern.",
      "Von den Kindern ein Bild gemalt wird."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'wird' + Partizip II ('gemalt'). Agens: 'von den Kindern'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-014",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Der Arzt untersucht den Patienten.'",
    "options": [
      "Der Patient wird vom Arzt untersucht.",
      "Der Patient ist vom Arzt untersucht.",
      "Den Patienten wird vom Arzt untersucht.",
      "Der Arzt wird vom Patienten untersucht."
    ],
    "correctAnswer": 0,
    "explanation": "'den Patienten' (Akk.) → 'Der Patient' (Nom.) wird Passivsubjekt. 'wird untersucht' = Vorgangspassiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-015",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Man spricht hier Deutsch.'",
    "options": [
      "Hier wird Deutsch gesprochen.",
      "Deutsch ist hier gesprochen.",
      "Hier Deutsch gesprochen wird.",
      "Hier hat man Deutsch gesprochen."
    ],
    "correctAnswer": 0,
    "explanation": "'man' entfällt im Passiv. 'Hier wird Deutsch gesprochen.' = Passiv ohne Agens.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-016",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Der Brief wird von der Sekretärin geschrieben.'",
    "options": [
      "Die Sekretärin schreibt den Brief.",
      "Der Brief schreibt die Sekretärin.",
      "Die Sekretärin wird den Brief schreiben.",
      "Den Brief schreibt von der Sekretärin."
    ],
    "correctAnswer": 0,
    "explanation": "'von der Sekretärin' → Subjekt. 'Der Brief' → Akkusativobjekt. 'geschrieben' → Präsens 'schreibt'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-017",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Das Essen wird von der Köchin zubereitet.'",
    "options": [
      "Die Köchin bereitet das Essen zu.",
      "Das Essen bereitet die Köchin zu.",
      "Die Köchin wird das Essen zubereiten.",
      "Das Essen zubereitet die Köchin."
    ],
    "correctAnswer": 0,
    "explanation": "Agens 'von der Köchin' wird zum Subjekt. Trennbares Verb: 'zubereiten' → 'bereitet ... zu'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-018",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Er fragt: 'Wo wohnst du?''",
    "options": [
      "Er fragt, wo ich wohne.",
      "Er fragt, ob ich wo wohne.",
      "Er fragt, wo wohne ich.",
      "Er fragt, dass ich wo wohne."
    ],
    "correctAnswer": 0,
    "explanation": "W-Fragen behalten das Fragewort in der indirekten Rede. Verb am Satzende: 'wo ich wohne'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-019",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Sie sagt: 'Ich habe Hunger.''",
    "options": [
      "Sie sagt, sie habe Hunger.",
      "Sie sagt, sie hat Hunger.",
      "Sie sagt, dass sie hätte Hunger.",
      "Sie sagt: sie habe Hunger."
    ],
    "correctAnswer": 0,
    "explanation": "Konjunktiv I von 'haben': 'habe'. Komma nach dem Hauptsatz, kein Doppelpunkt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-020",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Der Chef sagt: 'Kommen Sie bitte sofort!''",
    "options": [
      "Der Chef sagt, ich solle bitte sofort kommen.",
      "Der Chef sagt, dass kommen Sie bitte sofort.",
      "Der Chef sagt, kommen Sie bitte sofort.",
      "Der Chef sagt, ich soll bitte sofort kommen."
    ],
    "correctAnswer": 0,
    "explanation": "Imperativ in indirekter Rede → Konjunktiv I mit 'sollen': 'solle ... kommen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-021",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Bevor er frühstückt, duscht er.'",
    "options": [
      "Er duscht zuerst. Dann frühstückt er.",
      "Er frühstückt zuerst. Dann duscht er.",
      "Er duscht, bevor frühstückt er.",
      "Er duscht zuerst. Bevor frühstückt er."
    ],
    "correctAnswer": 0,
    "explanation": "'bevor' (temporal) → 'zuerst ... dann' als zwei Hauptsätze. Duschen kommt vor dem Frühstück.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-022",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Nachdem er gegessen hat, geht er spazieren.'",
    "options": [
      "Er hat gegessen. Danach geht er spazieren.",
      "Er geht spazieren. Danach hat er gegessen.",
      "Er hat gegessen, danach geht er spazieren.",
      "Er hat gegessen. Nachdem geht er spazieren."
    ],
    "correctAnswer": 0,
    "explanation": "'nachdem' → 'danach'. Zwei Hauptsätze: 'Er hat gegessen. Danach geht er spazieren.'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-023",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Wenn es kalt ist, bleibe ich zu Hause.'",
    "options": [
      "Es ist kalt. Dann bleibe ich zu Hause.",
      "Es ist kalt. Deshalb bleibe ich zu Hause.",
      "Es ist kalt. Trotzdem bleibe ich zu Hause.",
      "Es ist kalt. Wenn bleibe ich zu Hause."
    ],
    "correctAnswer": 0,
    "explanation": "'wenn' (konditional) → 'dann'. Zwei Hauptsätze mit logischer Folge.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-024",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Er ist nicht hier. Er kann uns nicht helfen.'",
    "options": [
      "Wenn er hier wäre, könnte er uns helfen.",
      "Wenn er hier ist, könnte er uns helfen.",
      "Wenn er hier wäre, kann er uns helfen.",
      "Wenn er hier wäre, würde er uns helfen gekonnt."
    ],
    "correctAnswer": 0,
    "explanation": "'wäre' (Konjunktiv II von 'sein') + 'könnte' (Konjunktiv II von 'können').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-025",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Ich spreche kein Französisch. Ich fahre nicht nach Paris.'",
    "options": [
      "Wenn ich Französisch spräche, würde ich nach Paris fahren.",
      "Wenn ich Französisch spreche, fahre ich nach Paris.",
      "Wenn ich Französisch spräche, fahre ich nach Paris.",
      "Wenn ich Französisch sprechen würde, fahre ich nach Paris."
    ],
    "correctAnswer": 0,
    "explanation": "'spräche' (Konj. II von 'sprechen') oder 'sprechen würde'. Hauptsatz: 'würde ... fahren'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-026",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Die Frau ist nett. Ich habe ihr geholfen.'",
    "options": [
      "Die Frau, die ich geholfen habe, ist nett.",
      "Die Frau, der ich geholfen habe, ist nett.",
      "Die Frau, deren ich geholfen habe, ist nett.",
      "Die Frau, welche ich geholfen habe, ist nett."
    ],
    "correctAnswer": 1,
    "explanation": "'ihr' = Dativ feminin → Relativpronomen 'der'. 'helfen' verlangt den Dativ.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-027",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Das Kind spielt im Garten. Es lacht laut.'",
    "options": [
      "Das Kind, das im Garten spielt, lacht laut.",
      "Das Kind, den im Garten spielt, lacht laut.",
      "Das Kind, welches im Garten spielt, lacht laut.",
      "Das Kind spielt im Garten, das lacht laut."
    ],
    "correctAnswer": 0,
    "explanation": "'Es' bezieht sich auf 'das Kind' (Nominativ neutrum) → Relativpronomen 'das'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-028",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Er entschied sich schnell.' → Nomen",
    "options": [
      "Seine schnelle Entscheidung.",
      "Sein schnelles Entscheiden.",
      "Seine schnelle Entscheide.",
      "Sein schnell Entscheidung."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'entscheiden' → Nomen 'die Entscheidung'. Adjektiv 'schnell' → 'schnelle' (fem. Nom.).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-029",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Man muss sich anmelden.' → Nomen",
    "options": [
      "Die Anmeldung ist notwendig.",
      "Das Anmelden ist notwendig.",
      "Die Anmelde ist notwendig.",
      "Der Anmeldung ist notwendig."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'sich anmelden' → Nomen 'die Anmeldung'. Feminin mit Suffix -ung.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-030",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Superlativ bilden: 'Maria ist schnell. Anna ist schneller. Lisa ist ...'",
    "options": [
      "Lisa ist am schnellsten.",
      "Lisa ist die schnellste.",
      "Lisa ist schnellst.",
      "Lisa ist mehr schnell als alle."
    ],
    "correctAnswer": 0,
    "explanation": "Superlativ prädikativ: 'am schnellsten'. Keine Umlautveränderung bei 'schnell'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-031",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Mein Auto ist alt. Dein Auto ist neuer.' → Vergleich",
    "options": [
      "Mein Auto ist älter als dein Auto.",
      "Mein Auto ist alter als dein Auto.",
      "Mein Auto ist mehr alt als dein Auto.",
      "Mein Auto ist am ältesten als dein Auto."
    ],
    "correctAnswer": 0,
    "explanation": "Komparativ von 'alt' → 'älter' (mit Umlaut). Vergleich mit 'als'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-032",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Polizei hat den Dieb gefangen.'",
    "options": [
      "Der Dieb ist von der Polizei gefangen worden.",
      "Der Dieb wurde von der Polizei gefangen.",
      "Der Dieb wird von der Polizei gefangen.",
      "Der Dieb hat von der Polizei gefangen."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt Aktiv → Perfekt Passiv: 'ist ... gefangen worden'. Hilfsverb 'sein' + P.II + 'worden'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-033",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Der Mechaniker reparierte das Auto.'",
    "options": [
      "Das Auto wurde vom Mechaniker repariert.",
      "Das Auto wird vom Mechaniker repariert.",
      "Das Auto ist vom Mechaniker repariert.",
      "Das Auto reparierte vom Mechaniker."
    ],
    "correctAnswer": 0,
    "explanation": "Präteritum Aktiv → Präteritum Passiv: 'wurde' + Partizip II ('repariert').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-034",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Die Tür wurde vom Hausmeister geöffnet.'",
    "options": [
      "Der Hausmeister öffnete die Tür.",
      "Die Tür öffnete den Hausmeister.",
      "Der Hausmeister wurde die Tür öffnen.",
      "Die Tür hat der Hausmeister geöffnet."
    ],
    "correctAnswer": 0,
    "explanation": "Präteritum Passiv → Präteritum Aktiv: 'wurde geöffnet' → 'öffnete'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-035",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "dass-Satz → Infinitivsatz",
    "question": "dass-Satz → Infinitivsatz: 'Ich hoffe, dass ich dich bald sehe.'",
    "options": [
      "Ich hoffe, dich bald zu sehen.",
      "Ich hoffe, dich bald sehen.",
      "Ich hoffe, zu dich bald sehen.",
      "Ich hoffe, dich bald zu sehe."
    ],
    "correctAnswer": 0,
    "explanation": "Wenn Haupt- und Nebensatz dasselbe Subjekt haben, kann man einen Infinitivsatz mit 'zu' bilden.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-036",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "dass-Satz → Infinitivsatz",
    "question": "dass-Satz → Infinitivsatz: 'Er versucht, dass er die Prüfung besteht.'",
    "options": [
      "Er versucht, die Prüfung zu bestehen.",
      "Er versucht, die Prüfung bestehen.",
      "Er versucht, zu die Prüfung bestehen.",
      "Er versucht, die Prüfung zu besteht."
    ],
    "correctAnswer": 0,
    "explanation": "Gleiches Subjekt → Infinitivsatz möglich. 'zu' steht vor dem Infinitiv: 'zu bestehen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-037",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Da sie müde war, ging sie früh ins Bett.'",
    "options": [
      "Sie war müde. Deswegen ging sie früh ins Bett.",
      "Sie war müde. Trotzdem ging sie früh ins Bett.",
      "Sie war müde, da ging sie früh ins Bett.",
      "Sie war müde. Da ging sie früh ins Bett."
    ],
    "correctAnswer": 0,
    "explanation": "'da' (kausal) → 'deswegen' als Satzadverb. Zwei Hauptsätze mit Inversion.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-038",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Damit er fit bleibt, joggt er jeden Morgen.'",
    "options": [
      "Er will fit bleiben. Deshalb joggt er jeden Morgen.",
      "Er joggt jeden Morgen. Trotzdem bleibt er fit.",
      "Er joggt jeden Morgen, damit bleibt er fit.",
      "Er bleibt fit. Denn joggt er jeden Morgen."
    ],
    "correctAnswer": 0,
    "explanation": "'damit' (final) → Umschreibung mit 'will/möchte ... deshalb'. Zweck wird zum Wunsch.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-039",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Sie hat kein Auto. Sie fährt mit dem Bus.'",
    "options": [
      "Wenn sie ein Auto hätte, würde sie nicht mit dem Bus fahren.",
      "Wenn sie ein Auto hat, fährt sie nicht mit dem Bus.",
      "Wenn sie ein Auto hätte, fährt sie nicht mit dem Bus.",
      "Wenn sie ein Auto hätte, fuhr sie nicht mit dem Bus."
    ],
    "correctAnswer": 0,
    "explanation": "Irrealer Konditionalsatz: 'hätte' + 'würde ... fahren' (Konjunktiv II mit 'würde').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-040",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II: 'Ich bin nicht reich.' → Wunschsatz",
    "options": [
      "Wenn ich doch reich wäre!",
      "Wenn ich doch reich bin!",
      "Wenn ich doch reich sei!",
      "Wenn ich doch reich wurde!"
    ],
    "correctAnswer": 0,
    "explanation": "Irrealer Wunschsatz: 'Wenn ... doch + Konjunktiv II!' → 'wäre' (von 'sein').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-041",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Ich lese ein Buch. Es ist sehr spannend.'",
    "options": [
      "Das Buch, das ich lese, ist sehr spannend.",
      "Das Buch, den ich lese, ist sehr spannend.",
      "Das Buch, die ich lese, ist sehr spannend.",
      "Das Buch, was ich lese, ist sehr spannend."
    ],
    "correctAnswer": 0,
    "explanation": "'ein Buch' = Neutrum → Relativpronomen 'das' (Akkusativ/Nominativ neutrum).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-042",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Die Stadt ist schön. Wir fahren in die Stadt.'",
    "options": [
      "Die Stadt, in die wir fahren, ist schön.",
      "Die Stadt, in der wir fahren, ist schön.",
      "Die Stadt, wo wir fahren, ist schön.",
      "Die Stadt, wohin wir fahren, ist schön."
    ],
    "correctAnswer": 0,
    "explanation": "'in die Stadt' (Akkusativ, Richtung) → Relativpronomen mit Präposition: 'in die'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-043",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Wir hoffen, dass der Frieden kommt.' → Nomen",
    "options": [
      "Unsere Hoffnung auf Frieden.",
      "Unser Hoffen auf den Frieden.",
      "Unsere Hoffnung für Frieden.",
      "Unser Hoffen für den Frieden."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'hoffen' → Nomen 'die Hoffnung'. Präposition: 'Hoffnung auf' + Akkusativ.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-044",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Er ist sehr freundlich.' → Nomen",
    "options": [
      "Seine Freundlichkeit.",
      "Sein Freundlich.",
      "Seine Freundschaft.",
      "Seine Freundliche."
    ],
    "correctAnswer": 0,
    "explanation": "Adjektiv 'freundlich' → Nomen 'die Freundlichkeit' (Suffix -keit).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-045",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Der Zug ist schnell. Das Flugzeug ist ...'",
    "options": [
      "Das Flugzeug ist schneller als der Zug.",
      "Das Flugzeug ist mehr schnell als der Zug.",
      "Das Flugzeug ist schnell als der Zug.",
      "Das Flugzeug ist am schnellsten als der Zug."
    ],
    "correctAnswer": 0,
    "explanation": "Komparativ von 'schnell' → 'schneller' (regelmäßig, kein Umlaut). Vergleich mit 'als'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-046",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Das Buch ist gut. Der Film ist ...'",
    "options": [
      "Der Film ist besser als das Buch.",
      "Der Film ist guter als das Buch.",
      "Der Film ist mehr gut als das Buch.",
      "Der Film ist gut als das Buch."
    ],
    "correctAnswer": 0,
    "explanation": "Unregelmäßiger Komparativ: 'gut' → 'besser'. Vergleich mit 'als'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-047",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Firma stellt neue Mitarbeiter ein.'",
    "options": [
      "Neue Mitarbeiter werden von der Firma eingestellt.",
      "Neue Mitarbeiter sind von der Firma eingestellt.",
      "Neue Mitarbeiter stellen von der Firma ein.",
      "Von der Firma neue Mitarbeiter eingestellt werden."
    ],
    "correctAnswer": 0,
    "explanation": "Trennbares Verb 'einstellen': Partizip II = 'eingestellt'. Passiv: 'werden eingestellt'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-048",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Sie sagt: 'Ich werde morgen kommen.''",
    "options": [
      "Sie sagt, sie werde morgen kommen.",
      "Sie sagt, sie wird morgen kommen.",
      "Sie sagt, sie würde morgen kommen.",
      "Sie sagt, dass sie morgen kommen werde."
    ],
    "correctAnswer": 0,
    "explanation": "Futur I in indirekter Rede: 'werde' (Konj. I von 'werden') + Infinitiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-049",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Die Hausaufgaben werden von den Schülern gemacht.'",
    "options": [
      "Die Schüler machen die Hausaufgaben.",
      "Die Hausaufgaben machen die Schüler.",
      "Die Schüler werden die Hausaufgaben machen.",
      "Von den Schülern machen die Hausaufgaben."
    ],
    "correctAnswer": 0,
    "explanation": "'von den Schülern' → Subjekt im Aktiv. 'Die Hausaufgaben' → Akkusativobjekt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p1-050",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "dass-Satz → Infinitivsatz",
    "question": "dass-Satz → Infinitivsatz: 'Ich freue mich, dass ich dich treffe.'",
    "options": [
      "Ich freue mich, dich zu treffen.",
      "Ich freue mich, dich treffen.",
      "Ich freue mich, zu dich treffen.",
      "Ich freue mich, dich zu treffe."
    ],
    "correctAnswer": 0,
    "explanation": "Gleiches Subjekt → Infinitivsatz: 'zu' + Infinitiv am Ende: 'dich zu treffen'.",
    "tags": ["umformung", "grammatik"]
  }
];

export default questions;
