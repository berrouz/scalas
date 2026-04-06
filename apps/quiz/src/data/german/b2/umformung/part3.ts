import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-umformung-p3-001",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv (Plusquamperfekt): 'Die Ärzte hatten den Patienten bereits untersucht.'",
    "options": [
      "Der Patient war von den Ärzten bereits untersucht worden.",
      "Der Patient wurde von den Ärzten bereits untersucht.",
      "Der Patient ist von den Ärzten bereits untersucht worden.",
      "Der Patient hatte von den Ärzten bereits untersucht."
    ],
    "correctAnswer": 0,
    "explanation": "Plusquamperfekt Passiv: 'war + P.II + worden'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-002",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv mit Modalverb im Perfekt: 'Man hat den Bericht überarbeiten müssen.'",
    "options": [
      "Der Bericht hat überarbeitet werden müssen.",
      "Der Bericht musste überarbeitet werden.",
      "Der Bericht ist überarbeitet werden gemusst.",
      "Der Bericht wurde überarbeitet müssen."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt + Modalverb + Passiv: 'hat + P.II + werden + müssen' (Ersatzinfinitiv).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-003",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv → 'sein + zu + Infinitiv' (Möglichkeit): 'Der Fleck kann nicht entfernt werden.'",
    "options": [
      "Der Fleck ist nicht zu entfernen.",
      "Der Fleck hat nicht zu entfernen.",
      "Der Fleck ist nicht entfernt zu werden.",
      "Der Fleck zu entfernen ist nicht."
    ],
    "correctAnswer": 0,
    "explanation": "'kann nicht + P.II + werden' → 'ist nicht zu + Infinitiv'. Hier: Unmöglichkeit.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-004",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "'-bar'-Adjektiv bilden: 'Die Theorie kann nicht widerlegt werden.'",
    "options": [
      "Die Theorie ist unwiderlegbar.",
      "Die Theorie ist nicht widerlegbar.",
      "Die Theorie ist unwiderlegt.",
      "Die Theorie ist widerlegungslos."
    ],
    "correctAnswer": 0,
    "explanation": "'kann nicht widerlegt werden' → 'unwiderlegbar' (Präfix 'un-' + Stamm + '-bar').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-005",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "'sich lassen' → Passiv: 'Das Fenster ließ sich nicht öffnen.'",
    "options": [
      "Das Fenster konnte nicht geöffnet werden.",
      "Das Fenster musste nicht geöffnet werden.",
      "Das Fenster wurde nicht geöffnet.",
      "Das Fenster ist nicht geöffnet worden."
    ],
    "correctAnswer": 0,
    "explanation": "'ließ sich nicht + Inf.' (Präteritum) → 'konnte nicht + P.II + werden'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-006",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Der Experte erklärte: 'Die Situation hat sich verschlechtert.''",
    "options": [
      "Der Experte erklärte, die Situation habe sich verschlechtert.",
      "Der Experte erklärte, die Situation hat sich verschlechtert.",
      "Der Experte erklärte, die Situation hätte sich verschlechtert.",
      "Der Experte erklärte, dass die Situation sich verschlechtert hat."
    ],
    "correctAnswer": 0,
    "explanation": "Konj. I Perfekt: 'habe sich verschlechtert'. Reflexivpronomen bleibt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-007",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Sie sagte: 'Ich werde mich morgen bewerben.''",
    "options": [
      "Sie sagte, sie werde sich morgen bewerben.",
      "Sie sagte, sie wird sich morgen bewerben.",
      "Sie sagte, sie würde sich morgen bewerben.",
      "Sie sagte, dass sie sich morgen bewerben werde."
    ],
    "correctAnswer": 0,
    "explanation": "Futur I: Konj. I von 'werden' = 'werde' + reflexiv 'sich' + Infinitiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-008",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Die Nachbarn behaupteten: 'Wir haben keinen Lärm gemacht.''",
    "options": [
      "Die Nachbarn behaupteten, sie hätten keinen Lärm gemacht.",
      "Die Nachbarn behaupteten, sie haben keinen Lärm gemacht.",
      "Die Nachbarn behaupteten, wir hätten keinen Lärm gemacht.",
      "Die Nachbarn behaupteten, sie habe keinen Lärm gemacht."
    ],
    "correctAnswer": 0,
    "explanation": "'wir' → 'sie'. Konj. I Plural = Indikativ, daher Konj. II: 'hätten gemacht'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-009",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Irrealer Bedingungssatz (Gegenwart): 'Wenn ich Millionär wäre, würde ich eine Stiftung gründen.'",
    "options": [
      "Wäre ich Millionär, würde ich eine Stiftung gründen.",
      "Ich wäre Millionär, würde ich eine Stiftung gründen.",
      "Millionär wäre ich, gründen würde ich eine Stiftung.",
      "Wäre ich Millionär, gründe ich eine Stiftung."
    ],
    "correctAnswer": 0,
    "explanation": "Ohne 'wenn': Verb an Position 1 → 'Wäre ich ..., würde ich ...'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-010",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Irrealer Vergleich (Vergangenheit): 'Es sieht so aus, als ob er nichts gewusst hätte.'",
    "options": [
      "Es sieht so aus, als hätte er nichts gewusst.",
      "Es sieht so aus, als wüsste er nichts.",
      "Es sieht so aus, als habe er nichts gewusst.",
      "Es sieht so aus, als ob er nichts weiß."
    ],
    "correctAnswer": 0,
    "explanation": "'als ob' + Konj. II Plusquamperfekt → 'als' + Inversion: 'als hätte er nichts gewusst'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-011",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Weil die Löhne gestiegen sind, haben die Preise angezogen.'",
    "options": [
      "Aufgrund der gestiegenen Löhne haben die Preise angezogen.",
      "Aufgrund die gestiegenen Löhne haben die Preise angezogen.",
      "Wegen gestiegene Löhne haben die Preise angezogen.",
      "Aufgrund der Löhne gestiegen haben die Preise angezogen."
    ],
    "correctAnswer": 0,
    "explanation": "'weil' → 'aufgrund' + Genitiv. 'gestiegen sind' → Partizip II als Adjektiv: 'der gestiegenen Löhne'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-012",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Verbalisierung: 'Trotz der erfolgreichen Durchführung gab es Kritik.'",
    "options": [
      "Obwohl die Durchführung erfolgreich war, gab es Kritik.",
      "Trotz man erfolgreich durchführte, gab es Kritik.",
      "Obwohl der erfolgreichen Durchführung gab es Kritik.",
      "Trotzdem die Durchführung erfolgreich war, gab es Kritik."
    ],
    "correctAnswer": 0,
    "explanation": "'trotz + Genitiv' → 'obwohl + Nebensatz'. 'die Durchführung' → Subjekt + Prädikativ.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-013",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Damit man das Problem lösen kann, braucht man mehr Geld.'",
    "options": [
      "Zur Lösung des Problems braucht man mehr Geld.",
      "Für die Lösung des Problems braucht man mehr Geld.",
      "Zur Lösung dem Problem braucht man mehr Geld.",
      "Damit der Lösung des Problems braucht man mehr Geld."
    ],
    "correctAnswer": 0,
    "explanation": "'damit + Verb' (final) → 'zur + Nomen'. 'lösen' → 'die Lösung'. Genitiv: 'des Problems'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-014",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip I: 'Die Flüchtlinge, die aus dem Kriegsgebiet fliehen, brauchen Hilfe.'",
    "options": [
      "Die aus dem Kriegsgebiet fliehenden Flüchtlinge brauchen Hilfe.",
      "Die aus dem Kriegsgebiet geflohenen Flüchtlinge brauchen Hilfe.",
      "Die fliehend aus dem Kriegsgebiet Flüchtlinge brauchen Hilfe.",
      "Die Flüchtlinge fliehend aus dem Kriegsgebiet brauchen Hilfe."
    ],
    "correctAnswer": 0,
    "explanation": "Aktiver Prozess → P.I: 'fliehend' + Endung. Präpositionale Angabe steht davor.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-015",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip II: 'Die Methode, die von dem Forscher entwickelt wurde, ist revolutionär.'",
    "options": [
      "Die von dem Forscher entwickelte Methode ist revolutionär.",
      "Die von dem Forscher entwickelnde Methode ist revolutionär.",
      "Die entwickelte von dem Forscher Methode ist revolutionär.",
      "Die Methode entwickelt von dem Forscher ist revolutionär."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv → P.II-Attribut: 'entwickelt' + Endung. Agens + P.II stehen vor dem Nomen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-016",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Partizipialgruppe → Relativsatz: 'Der kürzlich veröffentlichte Bericht sorgte für Aufsehen.'",
    "options": [
      "Der Bericht, der kürzlich veröffentlicht wurde, sorgte für Aufsehen.",
      "Der Bericht, der kürzlich veröffentlicht worden ist, sorgte für Aufsehen.",
      "Der Bericht veröffentlicht kürzlich sorgte für Aufsehen.",
      "Der kürzlich veröffentlichende Bericht sorgte für Aufsehen."
    ],
    "correctAnswer": 0,
    "explanation": "P.II-Attribut → Passiv-Relativsatz: 'der veröffentlicht wurde'. Gleiche Zeitstufe.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-017",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz mit 'was': 'Er kam pünktlich an. Das hatte niemand erwartet.'",
    "options": [
      "Er kam pünktlich an, was niemand erwartet hatte.",
      "Er kam pünktlich an, das niemand erwartet hatte.",
      "Er kam pünktlich an, die niemand erwartet hatte.",
      "Er kam pünktlich an, welches niemand erwartet hatte."
    ],
    "correctAnswer": 0,
    "explanation": "Bezug auf den ganzen Satz → 'was' als Relativpronomen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-018",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz: 'Die Firma expandiert nach Asien. Ihre Produkte sind dort sehr gefragt.'",
    "options": [
      "Die Firma, deren Produkte in Asien sehr gefragt sind, expandiert dorthin.",
      "Die Firma, derer Produkte in Asien sehr gefragt sind, expandiert dorthin.",
      "Die Firma, die Produkte in Asien sehr gefragt sind, expandiert dorthin.",
      "Die Firma, dessen Produkte in Asien sehr gefragt sind, expandiert dorthin."
    ],
    "correctAnswer": 0,
    "explanation": "'Ihre' (Firma = feminin) → Genitiv: 'deren'. Besitzverhältnis im Relativsatz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-019",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Je höher die Inflation steigt, desto mehr verliert das Geld an Wert.'",
    "options": [
      "Die Inflation steigt. Dementsprechend verliert das Geld an Wert.",
      "Die Inflation steigt. Deshalb verliert das Geld an Wert.",
      "Die Inflation steigt. Trotzdem verliert das Geld an Wert.",
      "Die Inflation steigt, je verliert das Geld an Wert."
    ],
    "correctAnswer": 0,
    "explanation": "'je ... desto' (proportional) → 'dementsprechend'. Proportionale Entwicklung.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-020",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Sofern Sie Fragen haben, wenden Sie sich an den Kundendienst.'",
    "options": [
      "Sie haben vielleicht Fragen. In dem Fall wenden Sie sich an den Kundendienst.",
      "Sie haben Fragen. Deshalb wenden Sie sich an den Kundendienst.",
      "Sie haben Fragen, sofern wenden Sie sich an den Kundendienst.",
      "Sie haben Fragen. Trotzdem wenden Sie sich an den Kundendienst."
    ],
    "correctAnswer": 0,
    "explanation": "'sofern' (konditional) → 'in dem Fall'. Bedingung als Hauptsatz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-021",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Anstatt dass die Regierung handelt, wartet sie ab.'",
    "options": [
      "Die Regierung sollte handeln. Stattdessen wartet sie ab.",
      "Die Regierung handelt. Deshalb wartet sie ab.",
      "Die Regierung handelt nicht. Trotzdem wartet sie ab.",
      "Die Regierung handelt, anstatt wartet sie ab."
    ],
    "correctAnswer": 0,
    "explanation": "'anstatt dass' → 'stattdessen'. Gegensatz: erwartetes vs. tatsächliches Handeln.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-022",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Insofern die Daten korrekt sind, stimmt die Prognose.'",
    "options": [
      "Die Daten sind korrekt. Insofern stimmt die Prognose.",
      "Die Daten sind korrekt. Deshalb stimmt die Prognose.",
      "Die Daten sind korrekt. Trotzdem stimmt die Prognose.",
      "Die Daten sind korrekt, insofern stimmt die Prognose."
    ],
    "correctAnswer": 0,
    "explanation": "'insofern' als Konjunktion → als Satzadverb. Einschränkende Bedingung.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-023",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Jury muss die Kandidaten bewerten.' (Modalverb)",
    "options": [
      "Die Kandidaten müssen von der Jury bewertet werden.",
      "Die Kandidaten werden von der Jury bewertet müssen.",
      "Die Kandidaten sind von der Jury bewertet worden müssen.",
      "Die Kandidaten bewerten von der Jury werden gemusst."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv mit Modalverb: 'müssen + P.II + werden'. Agens: 'von der Jury'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-024",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Dem Patienten wurde von dem Arzt ein Medikament verschrieben.'",
    "options": [
      "Der Arzt verschrieb dem Patienten ein Medikament.",
      "Dem Patienten verschrieb der Arzt ein Medikament.",
      "Der Arzt hat dem Patienten ein Medikament verschrieben.",
      "Ein Medikament verschrieb der Arzt dem Patienten."
    ],
    "correctAnswer": 0,
    "explanation": "Dativ bleibt: 'dem Patienten'. 'von dem Arzt' → Subjekt. Präteritum: 'verschrieb'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-025",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konjunktiv II: Fast-Realisierung: 'Beinahe hätte ich den Termin vergessen.'",
    "options": [
      "Ich hätte den Termin fast vergessen, aber ich habe rechtzeitig daran gedacht.",
      "Ich habe den Termin vergessen.",
      "Ich würde den Termin fast vergessen.",
      "Ich hätte den Termin vergessen, wenn ich nicht daran gedacht hätte."
    ],
    "correctAnswer": 0,
    "explanation": "'beinahe hätte ich vergessen' = Fast-Realisierung. Es ist nicht passiert: ich habe daran gedacht.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-026",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konjunktiv II Passiv (Gegenwart): 'Wenn das Gesetz geändert würde, gäbe es weniger Probleme.'",
    "options": [
      "Würde das Gesetz geändert, gäbe es weniger Probleme.",
      "Wird das Gesetz geändert, gibt es weniger Probleme.",
      "Wurde das Gesetz geändert, gab es weniger Probleme.",
      "Hätte das Gesetz geändert, gäbe es weniger Probleme."
    ],
    "correctAnswer": 0,
    "explanation": "Konj. II Passiv Gegenwart ohne 'wenn': 'Würde ... geändert, gäbe es ...'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-027",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Während die Teilnehmer diskutierten, wurde ein Kompromiss gefunden.'",
    "options": [
      "Während der Diskussion der Teilnehmer wurde ein Kompromiss gefunden.",
      "Während den Diskussionen der Teilnehmer wurde ein Kompromiss gefunden.",
      "Während die Diskussion der Teilnehmer wurde ein Kompromiss gefunden.",
      "Während dem Diskutieren der Teilnehmer wurde ein Kompromiss gefunden."
    ],
    "correctAnswer": 0,
    "explanation": "'während + Nebensatz' → 'während + Genitiv'. 'diskutieren' → 'die Diskussion'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-028",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Verbalisierung: 'Bei Nichteinhaltung der Frist entfällt der Anspruch.'",
    "options": [
      "Wenn die Frist nicht eingehalten wird, entfällt der Anspruch.",
      "Bei man die Frist nicht einhält, entfällt der Anspruch.",
      "Wenn die Nichteinhaltung der Frist, entfällt der Anspruch.",
      "Falls die Frist Nichteinhaltung, entfällt der Anspruch."
    ],
    "correctAnswer": 0,
    "explanation": "'bei + Nomen' (konditional) → 'wenn + Nebensatz'. 'Nichteinhaltung' → 'nicht eingehalten wird'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-029",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Er versicherte: 'Ich werde pünktlich sein.''",
    "options": [
      "Er versicherte, er werde pünktlich sein.",
      "Er versicherte, er wird pünktlich sein.",
      "Er versicherte, er würde pünktlich sein.",
      "Er versicherte, dass er pünktlich sein werde."
    ],
    "correctAnswer": 0,
    "explanation": "Futur I in indirekter Rede: Konj. I von 'werden' = 'werde' + Infinitiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-030",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Die Demonstranten riefen: 'Wir wollen Gerechtigkeit!''",
    "options": [
      "Die Demonstranten riefen, sie wollten Gerechtigkeit.",
      "Die Demonstranten riefen, sie wollen Gerechtigkeit.",
      "Die Demonstranten riefen, wir wollten Gerechtigkeit.",
      "Die Demonstranten riefen, sie wolle Gerechtigkeit."
    ],
    "correctAnswer": 0,
    "explanation": "'wir' → 'sie'. Konj. I Plural von 'wollen' = Indikativ, daher Konj. II: 'wollten'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-031",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz: 'Der Vertrag enthält eine Klausel. Auf sie muss besonders geachtet werden.'",
    "options": [
      "Der Vertrag enthält eine Klausel, auf die besonders geachtet werden muss.",
      "Der Vertrag enthält eine Klausel, worauf besonders geachtet werden muss.",
      "Der Vertrag enthält eine Klausel, auf der besonders geachtet werden muss.",
      "Der Vertrag enthält eine Klausel, darauf besonders geachtet werden muss."
    ],
    "correctAnswer": 0,
    "explanation": "'auf sie' → Präp. 'auf' + Akk. feminin → 'auf die'. Bezug auf konkretes Nomen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-032",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip I: 'Die Studie, die sich mit dem Klimawandel befasst, ist brisant.'",
    "options": [
      "Die sich mit dem Klimawandel befassende Studie ist brisant.",
      "Die sich mit dem Klimawandel befasste Studie ist brisant.",
      "Die befassende sich mit dem Klimawandel Studie ist brisant.",
      "Die Studie befassend sich mit dem Klimawandel ist brisant."
    ],
    "correctAnswer": 0,
    "explanation": "Reflexives Verb: 'sich befassend' → 'die sich befassende Studie'. Reflexivpronomen steht am Anfang.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-033",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Partizipialgruppe → Relativsatz: 'Die von der Konkurrenz übernommene Firma wurde umstrukturiert.'",
    "options": [
      "Die Firma, die von der Konkurrenz übernommen wurde, wurde umstrukturiert.",
      "Die Firma, die von der Konkurrenz übernommen worden ist, wurde umstrukturiert.",
      "Die Firma übernommen von der Konkurrenz wurde umstrukturiert.",
      "Die von der Konkurrenz übernehmende Firma wurde umstrukturiert."
    ],
    "correctAnswer": 0,
    "explanation": "P.II-Attribut → Passiv-Relativsatz: 'die übernommen wurde'. Gleiche Zeitstufe.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-034",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Obgleich die Risiken bekannt waren, wurde investiert.'",
    "options": [
      "Die Risiken waren bekannt. Nichtsdestotrotz wurde investiert.",
      "Die Risiken waren bekannt. Deshalb wurde investiert.",
      "Die Risiken waren bekannt, obgleich wurde investiert.",
      "Die Risiken waren bekannt. Denn wurde investiert."
    ],
    "correctAnswer": 0,
    "explanation": "'obgleich' (konzessiv, gehoben) → 'nichtsdestotrotz'. Gehobener konzessiver Ausdruck.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-035",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Ohne dass es jemand bemerkt hat, hat sich ein Fehler eingeschlichen.'",
    "options": [
      "Niemand hat es bemerkt. Dabei hat sich ein Fehler eingeschlichen.",
      "Niemand hat es bemerkt. Deshalb hat sich ein Fehler eingeschlichen.",
      "Niemand hat es bemerkt, ohne hat sich ein Fehler eingeschlichen.",
      "Niemand hat es bemerkt. Denn hat sich ein Fehler eingeschlichen."
    ],
    "correctAnswer": 0,
    "explanation": "'ohne dass' → 'dabei'. Unbemerkt geschehener Umstand.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-036",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → subjektloses Passiv: 'Man hat in der Sitzung heftig diskutiert.'",
    "options": [
      "In der Sitzung ist heftig diskutiert worden.",
      "Es wurde in der Sitzung heftig diskutiert.",
      "In der Sitzung wurde heftig diskutiert.",
      "Man hat diskutiert werden in der Sitzung."
    ],
    "correctAnswer": 0,
    "explanation": "Subjektloses Passiv Perfekt: 'ist diskutiert worden'. Kein 'es' nötig bei vorangestellter Angabe.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-037",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv → 'sich lassen' (Vergangenheit): 'Das Rätsel konnte schnell gelöst werden.'",
    "options": [
      "Das Rätsel ließ sich schnell lösen.",
      "Das Rätsel hat sich schnell lösen lassen.",
      "Das Rätsel löste sich schnell.",
      "Das Rätsel lässt sich schnell lösen."
    ],
    "correctAnswer": 0,
    "explanation": "'konnte + P.II + werden' (Prät.) → 'ließ sich + Infinitiv' (Prät. von 'sich lassen').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-038",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konj. II: höfliche Nachfrage: 'Können Sie mir sagen, wo der Bahnhof ist?'",
    "options": [
      "Könnten Sie mir sagen, wo der Bahnhof ist?",
      "Würden Sie mir sagen können, wo der Bahnhof ist?",
      "Können Sie mir sagen, wo der Bahnhof wäre?",
      "Wüssten Sie, wo der Bahnhof sein könnte?"
    ],
    "correctAnswer": 0,
    "explanation": "Höfliche Nachfrage: 'Könnten Sie' (Konj. II) statt 'Können Sie' (Indikativ).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-039",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Indem man erneuerbare Energien nutzt, schützt man die Umwelt.'",
    "options": [
      "Durch die Nutzung erneuerbarer Energien schützt man die Umwelt.",
      "Durch das Nutzen erneuerbarer Energien schützt man die Umwelt.",
      "Durch die Nutzung erneuerbare Energien schützt man die Umwelt.",
      "Indem der Nutzung erneuerbarer Energien schützt man die Umwelt."
    ],
    "correctAnswer": 0,
    "explanation": "'indem + Verb' → 'durch + Nomen'. 'nutzen' → 'die Nutzung'. 'erneuerbarer' = Genitiv Plural.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-040",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Sie berichtete: 'Die Verhandlungen sind erfolgreich verlaufen.''",
    "options": [
      "Sie berichtete, die Verhandlungen seien erfolgreich verlaufen.",
      "Sie berichtete, die Verhandlungen sind erfolgreich verlaufen.",
      "Sie berichtete, die Verhandlungen wären erfolgreich verlaufen.",
      "Sie berichtete, dass die Verhandlungen erfolgreich verlaufen seien."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt mit 'sein': Konj. I 'seien' (Plural) + P.II 'verlaufen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-041",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz: 'Das Projekt wurde eingestellt. Darauf hatte er jahrelang hingearbeitet.'",
    "options": [
      "Das Projekt, auf das er jahrelang hingearbeitet hatte, wurde eingestellt.",
      "Das Projekt, worauf er jahrelang hingearbeitet hatte, wurde eingestellt.",
      "Das Projekt, darauf er jahrelang hingearbeitet hatte, wurde eingestellt.",
      "Das Projekt, auf dem er jahrelang hingearbeitet hatte, wurde eingestellt."
    ],
    "correctAnswer": 0,
    "explanation": "'darauf' (auf das Projekt) → 'auf das' (Akk. neutrum). Konkreter Bezug auf Nomen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-042",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Gemischter Bedingungssatz: 'Wenn sie damals studiert hätte, hätte sie jetzt bessere Chancen.'",
    "options": [
      "Hätte sie damals studiert, hätte sie jetzt bessere Chancen.",
      "Wenn sie damals studiert, hat sie jetzt bessere Chancen.",
      "Studierte sie damals, hätte sie jetzt bessere Chancen.",
      "Hätte sie damals studiert, hat sie jetzt bessere Chancen."
    ],
    "correctAnswer": 0,
    "explanation": "Gemischter Konditional ohne 'wenn': Vergangenheit + Gegenwart in einem Satz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-043",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv mit Dativverb: 'Man gratulierte dem Gewinner.'",
    "options": [
      "Dem Gewinner wurde gratuliert.",
      "Der Gewinner wurde gratuliert.",
      "Dem Gewinner wird gratuliert.",
      "Der Gewinner ist gratuliert worden."
    ],
    "correctAnswer": 0,
    "explanation": "Dativverb 'gratulieren': Dativ bleibt. Subjektloses Passiv: 'Dem Gewinner wurde gratuliert.'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-044",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Verbalisierung: 'Zwecks Überprüfung der Unterlagen bitten wir um einen Termin.'",
    "options": [
      "Um die Unterlagen zu überprüfen, bitten wir um einen Termin.",
      "Zwecks man die Unterlagen überprüft, bitten wir um einen Termin.",
      "Um die Überprüfung der Unterlagen bitten wir um einen Termin.",
      "Damit die Unterlagen Überprüfung, bitten wir um einen Termin."
    ],
    "correctAnswer": 0,
    "explanation": "'zwecks + Genitiv' (final) → 'um ... zu + Infinitiv'. 'die Überprüfung' → 'überprüfen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-045",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "'sein + zu + Infinitiv' bilden: 'Diese Aufgabe kann leicht erledigt werden.'",
    "options": [
      "Diese Aufgabe ist leicht zu erledigen.",
      "Diese Aufgabe hat leicht zu erledigen.",
      "Diese Aufgabe ist leicht erledigt zu werden.",
      "Diese Aufgabe zu erledigen ist leicht."
    ],
    "correctAnswer": 0,
    "explanation": "'kann + P.II + werden' → 'ist zu + Infinitiv'. Hier: Möglichkeit.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-046",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip II: 'Die Maßnahmen, die von der Regierung beschlossenen wurden, treten in Kraft.'",
    "options": [
      "Die von der Regierung beschlossenen Maßnahmen treten in Kraft.",
      "Die von der Regierung beschließenden Maßnahmen treten in Kraft.",
      "Die beschlossenen von der Regierung Maßnahmen treten in Kraft.",
      "Die Maßnahmen beschlossen von der Regierung treten in Kraft."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv → P.II-Attribut. Agens + P.II stehen zwischen Artikel und Nomen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-047",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Der Angeklagte beteuerte: 'Ich bin unschuldig.''",
    "options": [
      "Der Angeklagte beteuerte, er sei unschuldig.",
      "Der Angeklagte beteuerte, er ist unschuldig.",
      "Der Angeklagte beteuerte, er wäre unschuldig.",
      "Der Angeklagte beteuerte, dass er unschuldig sei."
    ],
    "correctAnswer": 0,
    "explanation": "Konj. I von 'sein': 'sei'. Einfache Wiedergabe im Konjunktiv I.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-048",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Wohingegen die Exporte gestiegen sind, sind die Importe gefallen.'",
    "options": [
      "Die Exporte sind gestiegen. Die Importe hingegen sind gefallen.",
      "Die Exporte sind gestiegen. Deshalb sind die Importe gefallen.",
      "Die Exporte sind gestiegen, wohingegen die Importe gefallen.",
      "Die Exporte sind gestiegen. Die Importe dagegen sind gestiegen."
    ],
    "correctAnswer": 0,
    "explanation": "'wohingegen' (adversativ) → 'hingegen'. Gegensätzliche Entwicklung.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-049",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konj. II: Vermutung: 'Das dürfte der Grund sein.'",
    "options": [
      "Das ist vermutlich der Grund.",
      "Das ist sicher der Grund.",
      "Das muss der Grund sein.",
      "Das könnte der Grund gewesen sein."
    ],
    "correctAnswer": 0,
    "explanation": "'dürfte sein' = gemäßigte Vermutung → 'vermutlich' drückt dasselbe aus.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p3-050",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Verallgemeinernder Relativsatz: 'Alles, was er sagt, stimmt nicht.'",
    "options": [
      "Was er auch sagt, es stimmt nicht.",
      "Das, was er sagt, stimmt nicht.",
      "Er sagt alles, aber es stimmt nicht.",
      "Wer er auch sagt, es stimmt nicht."
    ],
    "correctAnswer": 0,
    "explanation": "'Alles, was ...' → 'Was ... auch ...' (verallgemeinernder Relativsatz mit 'auch').",
    "tags": ["umformung", "grammatik"]
  }
];

export default questions;
