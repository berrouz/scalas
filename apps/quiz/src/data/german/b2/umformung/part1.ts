import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-umformung-p1-001",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv (Präteritum): 'Die Wissenschaftler entdeckten einen neuen Planeten.'",
    "options": [
      "Ein neuer Planet wurde von den Wissenschaftlern entdeckt.",
      "Ein neuer Planet wird von den Wissenschaftlern entdeckt.",
      "Ein neuer Planet ist von den Wissenschaftlern entdeckt worden.",
      "Ein neuer Planet war von den Wissenschaftlern entdeckt."
    ],
    "correctAnswer": 0,
    "explanation": "Präteritum Aktiv → Präteritum Passiv: 'wurde entdeckt'. Akkusativobjekt wird Passivsubjekt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-002",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv mit Modalverb: 'Man muss die Ergebnisse überprüfen.'",
    "options": [
      "Die Ergebnisse müssen überprüft werden.",
      "Die Ergebnisse werden überprüft müssen.",
      "Die Ergebnisse sind überprüft worden müssen.",
      "Die Ergebnisse überprüfen werden gemusst."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv mit Modalverb: Modalverb bleibt konjugiert + P.II + 'werden' am Ende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-003",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Zustandspassiv: 'Der Mechaniker hat das Auto repariert.' → Ergebnis beschreiben",
    "options": [
      "Das Auto ist repariert.",
      "Das Auto wird repariert.",
      "Das Auto ist repariert worden.",
      "Das Auto wurde repariert."
    ],
    "correctAnswer": 0,
    "explanation": "Zustandspassiv (sein + P.II) beschreibt das Ergebnis einer Handlung: 'Das Auto ist repariert.'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-004",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Der Antrag ist von der Behörde genehmigt worden.'",
    "options": [
      "Die Behörde hat den Antrag genehmigt.",
      "Den Antrag hat die Behörde genehmigt.",
      "Die Behörde genehmigte den Antrag.",
      "Der Antrag genehmigt die Behörde."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt Passiv → Perfekt Aktiv: 'ist genehmigt worden' → 'hat genehmigt'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-005",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede (Konjunktiv I): 'Der Minister sagt: 'Wir werden die Steuern senken.''",
    "options": [
      "Der Minister sagt, sie würden die Steuern senken.",
      "Der Minister sagt, sie werden die Steuern senken.",
      "Der Minister sagt, wir würden die Steuern senken.",
      "Der Minister sagt, sie werden die Steuern gesenkt."
    ],
    "correctAnswer": 0,
    "explanation": "'wir' → 'sie'. Konj. I Plural = Indikativ, daher Konj. II: 'würden senken'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-006",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Die Ärztin sagte: 'Der Patient muss sofort operiert werden.''",
    "options": [
      "Die Ärztin sagte, der Patient müsse sofort operiert werden.",
      "Die Ärztin sagte, der Patient muss sofort operiert werden.",
      "Die Ärztin sagte, der Patient musste sofort operiert werden.",
      "Die Ärztin sagte, dass der Patient sofort operiert werden muss."
    ],
    "correctAnswer": 0,
    "explanation": "Konj. I von 'müssen': 'müsse'. Passiv bleibt: 'operiert werden'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-007",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konjunktiv II Vergangenheit: 'Er hat den Zug verpasst.' → irrealer Wunsch",
    "options": [
      "Wenn er den Zug doch nicht verpasst hätte!",
      "Wenn er den Zug doch nicht verpasst hat!",
      "Wenn er den Zug doch nicht verpasste!",
      "Hätte er den Zug doch nicht verpasst wenn!"
    ],
    "correctAnswer": 0,
    "explanation": "Irrealer Wunsch (Vergangenheit): 'Wenn ... doch + Konj. II Plusquamperfekt!' → 'hätte verpasst'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-008",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Irrealer Bedingungssatz (Vergangenheit): 'Sie hat nicht gelernt. Sie hat die Prüfung nicht bestanden.'",
    "options": [
      "Wenn sie gelernt hätte, hätte sie die Prüfung bestanden.",
      "Wenn sie lernen würde, würde sie die Prüfung bestehen.",
      "Wenn sie gelernt hat, hat sie die Prüfung bestanden.",
      "Wenn sie gelernt hätte, bestand sie die Prüfung."
    ],
    "correctAnswer": 0,
    "explanation": "Irrealer Bedingungssatz Vergangenheit: 'hätte gelernt' + 'hätte bestanden' (beides Konj. II Plusquamperfekt).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-009",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Die Bevölkerung wächst schnell.' → nominaler Ausdruck",
    "options": [
      "Das schnelle Wachstum der Bevölkerung.",
      "Das schnelle Wachsen der Bevölkerung.",
      "Die schnelle Wachsung der Bevölkerung.",
      "Der schnelle Wuchs der Bevölkerung."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'wachsen' → Nomen 'das Wachstum'. Adverb → Adjektiv: 'schnelle' (Neutrum).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-010",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Verbalisierung: 'Die Durchführung des Experiments.' → verbaler Ausdruck",
    "options": [
      "Das Experiment wird durchgeführt.",
      "Man durchführt das Experiment.",
      "Das Experiment durchführt man.",
      "Die Durchführung experimentiert."
    ],
    "correctAnswer": 0,
    "explanation": "Nomen 'die Durchführung' → Verb 'durchführen'. Passiv: 'wird durchgeführt'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-011",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Obwohl die Firma Verluste gemacht hat, werden keine Mitarbeiter entlassen.'",
    "options": [
      "Die Firma hat Verluste gemacht. Dennoch werden keine Mitarbeiter entlassen.",
      "Die Firma hat Verluste gemacht. Deshalb werden keine Mitarbeiter entlassen.",
      "Die Firma hat Verluste gemacht. Denn werden keine Mitarbeiter entlassen.",
      "Die Firma hat Verluste gemacht, obwohl werden keine Mitarbeiter entlassen."
    ],
    "correctAnswer": 0,
    "explanation": "'obwohl' (konzessiv) → 'dennoch'. Widerspruch: Verluste, aber keine Entlassungen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-012",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Indem die Firma in neue Technologien investiert, steigert sie ihren Umsatz.'",
    "options": [
      "Die Firma investiert in neue Technologien. Dadurch steigert sie ihren Umsatz.",
      "Die Firma investiert in neue Technologien. Deshalb steigert sie ihren Umsatz.",
      "Die Firma investiert in neue Technologien. Trotzdem steigert sie ihren Umsatz.",
      "Die Firma investiert in neue Technologien, indem steigert sie ihren Umsatz."
    ],
    "correctAnswer": 0,
    "explanation": "'indem' (instrumental) → 'dadurch'. Mittel → Ergebnis.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-013",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Der Wissenschaftler erhielt den Nobelpreis. Auf seine Forschung baut die moderne Medizin auf.'",
    "options": [
      "Der Wissenschaftler, auf dessen Forschung die moderne Medizin aufbaut, erhielt den Nobelpreis.",
      "Der Wissenschaftler, auf deren Forschung die moderne Medizin aufbaut, erhielt den Nobelpreis.",
      "Der Wissenschaftler, auf dem Forschung die moderne Medizin aufbaut, erhielt den Nobelpreis.",
      "Der Wissenschaftler, worauf die moderne Medizin aufbaut, erhielt den Nobelpreis."
    ],
    "correctAnswer": 0,
    "explanation": "'seine Forschung' → Genitiv maskulin: 'dessen'. Präposition 'auf' bleibt vor dem Relativpronomen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-014",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip I: 'Die Studenten, die an dem Projekt arbeiten, sind motiviert.'",
    "options": [
      "Die an dem Projekt arbeitenden Studenten sind motiviert.",
      "Die an dem Projekt gearbeiteten Studenten sind motiviert.",
      "Die arbeitend an dem Projekt Studenten sind motiviert.",
      "Die Studenten arbeitend an dem Projekt sind motiviert."
    ],
    "correctAnswer": 0,
    "explanation": "Aktive Handlung → Partizip I (arbeitend) + Deklinationsendung: 'die arbeitenden Studenten'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-015",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip II: 'Das Buch, das von Millionen gelesen wurde, ist ein Bestseller.'",
    "options": [
      "Das von Millionen gelesene Buch ist ein Bestseller.",
      "Das von Millionen lesende Buch ist ein Bestseller.",
      "Das gelesen von Millionen Buch ist ein Bestseller.",
      "Das Buch gelesen von Millionen ist ein Bestseller."
    ],
    "correctAnswer": 0,
    "explanation": "Passive Handlung → Partizip II (gelesen) + Deklinationsendung: 'das gelesene Buch'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-016",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Er behauptet: 'Ich habe das nicht gewusst.''",
    "options": [
      "Er behauptet, er habe das nicht gewusst.",
      "Er behauptet, er hat das nicht gewusst.",
      "Er behauptet, er hätte das nicht gewusst.",
      "Er behauptet, dass er das nicht gewusst hat."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt in indirekter Rede: Konj. I von 'haben' = 'habe' + P.II 'gewusst'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-017",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Die Zeugen sagten: 'Wir haben nichts gesehen.''",
    "options": [
      "Die Zeugen sagten, sie hätten nichts gesehen.",
      "Die Zeugen sagten, sie haben nichts gesehen.",
      "Die Zeugen sagten, wir hätten nichts gesehen.",
      "Die Zeugen sagten, sie habe nichts gesehen."
    ],
    "correctAnswer": 0,
    "explanation": "'wir' → 'sie'. Konj. I Plural (haben) = Indikativ, daher Konj. II: 'hätten gesehen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-018",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv → 'sich lassen': 'Das Problem kann gelöst werden.'",
    "options": [
      "Das Problem lässt sich lösen.",
      "Das Problem löst sich lassen.",
      "Das Problem sich lösen lässt.",
      "Das Problem wird sich lösen lassen."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv mit 'können' → 'sich lassen' + Infinitiv: 'lässt sich lösen' = kann gelöst werden.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-019",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv → 'sein + zu + Infinitiv': 'Die Aufgabe muss bis morgen erledigt werden.'",
    "options": [
      "Die Aufgabe ist bis morgen zu erledigen.",
      "Die Aufgabe hat bis morgen zu erledigen.",
      "Die Aufgabe sein bis morgen zu erledigen.",
      "Die Aufgabe zu erledigen ist bis morgen."
    ],
    "correctAnswer": 0,
    "explanation": "'muss ... werden' → 'ist zu + Infinitiv'. Drückt Notwendigkeit/Pflicht aus.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-020",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv → '-bar'-Adjektiv: 'Das Wasser kann getrunken werden.'",
    "options": [
      "Das Wasser ist trinkbar.",
      "Das Wasser ist getrunkenbar.",
      "Das Wasser ist trunkbar.",
      "Das Wasser ist zu trinken."
    ],
    "correctAnswer": 0,
    "explanation": "'kann + P.II + werden' → Adjektiv mit '-bar': 'trinkbar' (Stamm des Verbs + -bar).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-021",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Die Regierung hat beschlossen, die Steuern zu erhöhen.' → nominaler Stil",
    "options": [
      "Der Beschluss der Regierung zur Steuererhöhung.",
      "Die Beschließung der Regierung zur Steuererhöhung.",
      "Das Beschließen der Regierung die Steuern erhöhen.",
      "Der Beschluss der Regierung, die Steuern erhöht."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'beschließen' → 'der Beschluss'. 'Steuern erhöhen' → 'Steuererhöhung' (Kompositum).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-022",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Verbalisierung: 'Die Reduzierung der Kosten ist notwendig.' → verbaler Ausdruck",
    "options": [
      "Es ist notwendig, die Kosten zu reduzieren.",
      "Die Kosten ist notwendig zu reduzieren.",
      "Man reduziert notwendig die Kosten.",
      "Die Kosten reduziert notwendig sind."
    ],
    "correctAnswer": 0,
    "explanation": "Nomen 'die Reduzierung' → Infinitivsatz: 'die Kosten zu reduzieren'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-023",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Irrealer Bedingungssatz (Gegenwart): 'Sie ist keine Ärztin. Sie kann ihm nicht helfen.'",
    "options": [
      "Wäre sie Ärztin, könnte sie ihm helfen.",
      "Wenn sie Ärztin ist, kann sie ihm helfen.",
      "Wäre sie Ärztin, kann sie ihm helfen.",
      "Wenn sie Ärztin wäre, hilft sie ihm."
    ],
    "correctAnswer": 0,
    "explanation": "Kurzform ohne 'wenn': Verb am Satzanfang. 'Wäre sie ..., könnte sie ...'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-024",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Irrealer Vergleich: 'Er gibt das Geld aus, als ob es kein Morgen gäbe.'",
    "options": [
      "Er gibt das Geld aus, als gäbe es kein Morgen.",
      "Er gibt das Geld aus, als es kein Morgen gibt.",
      "Er gibt das Geld aus, als gebe es kein Morgen.",
      "Er gibt das Geld aus, als ob es kein Morgen gibt."
    ],
    "correctAnswer": 0,
    "explanation": "'als ob' + Verb am Ende → 'als' + Verb direkt danach (Inversion): 'als gäbe es ...'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-025",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Während die Nachfrage steigt, sinkt das Angebot.'",
    "options": [
      "Die Nachfrage steigt. Gleichzeitig sinkt das Angebot.",
      "Die Nachfrage steigt. Danach sinkt das Angebot.",
      "Die Nachfrage steigt. Deshalb sinkt das Angebot.",
      "Die Nachfrage steigt, während sinkt das Angebot."
    ],
    "correctAnswer": 0,
    "explanation": "'während' (adversativ/gleichzeitig) → 'gleichzeitig'. Parallele, gegensätzliche Entwicklungen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-026",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Sofern keine Einwände bestehen, wird der Vertrag unterschrieben.'",
    "options": [
      "Es bestehen keine Einwände. In diesem Fall wird der Vertrag unterschrieben.",
      "Es bestehen keine Einwände. Deshalb wird der Vertrag unterschrieben.",
      "Es bestehen keine Einwände, sofern wird der Vertrag unterschrieben.",
      "Es bestehen keine Einwände. Trotzdem wird der Vertrag unterschrieben."
    ],
    "correctAnswer": 0,
    "explanation": "'sofern' (konditional) → 'in diesem Fall'. Bedingung wird zum Hauptsatz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-027",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv (Plusquamperfekt): 'Der Chirurg hatte den Patienten operiert.'",
    "options": [
      "Der Patient war vom Chirurgen operiert worden.",
      "Der Patient wurde vom Chirurgen operiert worden.",
      "Der Patient ist vom Chirurgen operiert worden.",
      "Der Patient hatte vom Chirurgen operiert."
    ],
    "correctAnswer": 0,
    "explanation": "Plusquamperfekt Passiv: 'war + P.II + worden'. N-Deklination: 'Chirurg' → 'Chirurgen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-028",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv (Futur I): 'Die Firma wird das Produkt nächstes Jahr einführen.'",
    "options": [
      "Das Produkt wird nächstes Jahr von der Firma eingeführt werden.",
      "Das Produkt wird nächstes Jahr von der Firma eingeführt.",
      "Das Produkt ist nächstes Jahr von der Firma eingeführt worden.",
      "Das Produkt wurde nächstes Jahr von der Firma eingeführt."
    ],
    "correctAnswer": 0,
    "explanation": "Futur I Passiv: 'wird + P.II + werden'. Zwei 'werden': Futur + Passiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-029",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz mit 'was': 'Er hat die Prüfung bestanden. Das hat alle überrascht.'",
    "options": [
      "Er hat die Prüfung bestanden, was alle überrascht hat.",
      "Er hat die Prüfung bestanden, das alle überrascht hat.",
      "Er hat die Prüfung bestanden, die alle überrascht hat.",
      "Er hat die Prüfung bestanden, welches alle überrascht hat."
    ],
    "correctAnswer": 0,
    "explanation": "Wenn sich der Relativsatz auf den gesamten vorherigen Satz bezieht, verwendet man 'was'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-030",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz mit 'wo': 'Die Stadt ist schön. Er hat dort studiert.'",
    "options": [
      "Die Stadt, wo er studiert hat, ist schön.",
      "Die Stadt, in der er studiert hat, ist schön.",
      "Die Stadt, worin er studiert hat, ist schön.",
      "Die Stadt, darin er studiert hat, ist schön."
    ],
    "correctAnswer": 1,
    "explanation": "'dort' → Präposition 'in' + Dativ feminin: 'in der'. 'wo' ist umgangssprachlich, 'in der' ist korrekt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-031",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Der Sprecher erklärte: 'Die Verhandlungen sind gescheitert.''",
    "options": [
      "Der Sprecher erklärte, die Verhandlungen seien gescheitert.",
      "Der Sprecher erklärte, die Verhandlungen sind gescheitert.",
      "Der Sprecher erklärte, die Verhandlungen wären gescheitert.",
      "Der Sprecher erklärte, dass die Verhandlungen gescheitert seien."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt mit 'sein': Konj. I 'seien' (Plural) + P.II 'gescheitert'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-032",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Sie betonte: 'Ich habe den Vertrag nicht unterschrieben.''",
    "options": [
      "Sie betonte, sie habe den Vertrag nicht unterschrieben.",
      "Sie betonte, sie hat den Vertrag nicht unterschrieben.",
      "Sie betonte, sie hätte den Vertrag nicht unterschrieben.",
      "Sie betonte, dass sie den Vertrag nicht unterschrieben hat."
    ],
    "correctAnswer": 0,
    "explanation": "Konj. I Perfekt: 'habe unterschrieben'. Negation 'nicht' bleibt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-033",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Man hat die Mitarbeiter entlassen, weil die Kosten gestiegen sind.'",
    "options": [
      "Die Entlassung der Mitarbeiter aufgrund der gestiegenen Kosten.",
      "Das Entlassen der Mitarbeiter wegen gestiegener Kosten.",
      "Die Entlassung der Mitarbeiter weil gestiegene Kosten.",
      "Die Entlasserei der Mitarbeiter aufgrund der gestiegenen Kosten."
    ],
    "correctAnswer": 0,
    "explanation": "'entlassen' → 'die Entlassung'. 'weil ... gestiegen sind' → 'aufgrund der gestiegenen Kosten'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-034",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Partizipialgruppe → Relativsatz: 'Die vom Sturm beschädigten Häuser müssen renoviert werden.'",
    "options": [
      "Die Häuser, die vom Sturm beschädigt wurden, müssen renoviert werden.",
      "Die Häuser, die vom Sturm beschädigend wurden, müssen renoviert werden.",
      "Die Häuser beschädigt vom Sturm müssen renoviert werden.",
      "Die vom Sturm beschädigten Häuser renoviert werden müssen."
    ],
    "correctAnswer": 0,
    "explanation": "Partizip II-Attribut → Passiv-Relativsatz: 'die beschädigt wurden' (Vorgangspassiv).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-035",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Partizipialgruppe → Relativsatz: 'Der laut bellende Hund erschreckte die Kinder.'",
    "options": [
      "Der Hund, der laut bellte, erschreckte die Kinder.",
      "Der Hund, der laut gebellt hat, erschreckte die Kinder.",
      "Der Hund, laut bellend, erschreckte die Kinder.",
      "Der Hund bellend laut erschreckte die Kinder."
    ],
    "correctAnswer": 0,
    "explanation": "Partizip I-Attribut → Aktiv-Relativsatz. Gleichzeitigkeit: 'der bellte' (Präteritum wie Hauptsatz).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-036",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konjunktiv II: Fast-Realisierung: 'Er wäre fast gefallen.'",
    "options": [
      "Er ist beinahe gefallen, hat aber das Gleichgewicht gehalten.",
      "Er ist gefallen.",
      "Er würde fast fallen.",
      "Er wäre gefallen, wenn er nicht aufgepasst hätte."
    ],
    "correctAnswer": 0,
    "explanation": "'wäre fast gefallen' = Beinahe-Realisierung in der Vergangenheit. Es ist nicht passiert.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-037",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv-Ersatz mit 'sich lassen': 'Die Tür kann nicht geöffnet werden.'",
    "options": [
      "Die Tür lässt sich nicht öffnen.",
      "Die Tür öffnet sich nicht lassen.",
      "Die Tür sich nicht öffnen lässt.",
      "Die Tür wird sich nicht öffnen lassen."
    ],
    "correctAnswer": 0,
    "explanation": "'kann nicht geöffnet werden' → 'lässt sich nicht öffnen'. Passiv-Ersatzform.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-038",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv-Ersatz: 'Die Rechnung muss bezahlt werden.' → 'sein + zu + Infinitiv'",
    "options": [
      "Die Rechnung ist zu bezahlen.",
      "Die Rechnung hat zu bezahlen.",
      "Die Rechnung ist bezahlt zu werden.",
      "Die Rechnung zu bezahlen ist."
    ],
    "correctAnswer": 0,
    "explanation": "'muss bezahlt werden' → 'ist zu bezahlen'. Drückt Pflicht/Notwendigkeit aus.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-039",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Je mehr er lernt, desto besser werden seine Noten.'",
    "options": [
      "Er lernt mehr. Entsprechend verbessern sich seine Noten.",
      "Er lernt mehr. Deshalb verbessern sich seine Noten.",
      "Er lernt mehr. Trotzdem verbessern sich seine Noten.",
      "Er lernt mehr, je verbessern sich seine Noten."
    ],
    "correctAnswer": 0,
    "explanation": "'je ... desto' (proportional) → 'entsprechend'. Parallele Steigerung.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-040",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Anstatt dass er arbeitet, spielt er Computerspiele.'",
    "options": [
      "Er sollte arbeiten. Stattdessen spielt er Computerspiele.",
      "Er arbeitet. Deshalb spielt er Computerspiele.",
      "Er arbeitet nicht. Trotzdem spielt er Computerspiele.",
      "Er arbeitet, anstatt spielt er Computerspiele."
    ],
    "correctAnswer": 0,
    "explanation": "'anstatt dass' → 'stattdessen'. Gegensatz zwischen Sollen und Tun.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-041",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Subjektloses Passiv: 'Man tanzte die ganze Nacht.'",
    "options": [
      "Es wurde die ganze Nacht getanzt.",
      "Die ganze Nacht wurde getanzt.",
      "Die ganze Nacht ist getanzt worden.",
      "Man hat die ganze Nacht getanzt werden."
    ],
    "correctAnswer": 0,
    "explanation": "Subjektloses Passiv mit 'es' am Satzanfang. Auch möglich: 'Die ganze Nacht wurde getanzt.'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-042",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv I",
    "question": "direkte → indirekte Rede: 'Der Richter ordnete an: 'Führen Sie den Angeklagten vor!''",
    "options": [
      "Der Richter ordnete an, man solle den Angeklagten vorführen.",
      "Der Richter ordnete an, man soll den Angeklagten vorführen.",
      "Der Richter ordnete an, führen Sie den Angeklagten vor.",
      "Der Richter ordnete an, dass man den Angeklagten vorführt."
    ],
    "correctAnswer": 0,
    "explanation": "Imperativ → 'sollen' im Konj. I: 'solle vorführen'. 'Sie' → 'man'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-043",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Obwohl er sich bemüht hat, hat er die Stelle nicht bekommen.'",
    "options": [
      "Trotz seiner Bemühungen hat er die Stelle nicht bekommen.",
      "Trotz seinen Bemühungen hat er die Stelle nicht bekommen.",
      "Trotz seinem Bemühen hat er die Stelle nicht bekommen.",
      "Trotz der Bemühung hat er die Stelle nicht bekommen."
    ],
    "correctAnswer": 0,
    "explanation": "'obwohl' → 'trotz' + Genitiv. 'sich bemühen' → 'die Bemühungen' (Plural). 'seiner' = Genitiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-044",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Verbalisierung: 'Wegen der Verspätung des Zuges verpasste er den Anschluss.'",
    "options": [
      "Weil der Zug Verspätung hatte, verpasste er den Anschluss.",
      "Der Zug hatte Verspätung wegen er den Anschluss verpasste.",
      "Weil der Zug verspätet hat, verpasste er den Anschluss.",
      "Da die Verspätung des Zuges, verpasste er den Anschluss."
    ],
    "correctAnswer": 0,
    "explanation": "'wegen + Genitiv' → 'weil + Nebensatz'. 'die Verspätung' → 'Verspätung haben'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-045",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konjunktiv II: Irrealer Bedingungssatz ohne 'wenn': 'Wenn ich mehr Zeit hätte, würde ich Sport machen.'",
    "options": [
      "Hätte ich mehr Zeit, würde ich Sport machen.",
      "Ich hätte mehr Zeit, würde ich Sport machen.",
      "Mehr Zeit hätte ich, Sport machen würde ich.",
      "Hätte ich mehr Zeit, mache ich Sport."
    ],
    "correctAnswer": 0,
    "explanation": "Ohne 'wenn': Verb an Position 1 → 'Hätte ich ..., würde ich ...'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-046",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz mit Präposition: 'Das Thema ist aktuell. Die Diskussion dreht sich um das Thema.'",
    "options": [
      "Das Thema, um das sich die Diskussion dreht, ist aktuell.",
      "Das Thema, worum sich die Diskussion dreht, ist aktuell.",
      "Das Thema, um dem sich die Diskussion dreht, ist aktuell.",
      "Das Thema, darüber sich die Diskussion dreht, ist aktuell."
    ],
    "correctAnswer": 0,
    "explanation": "'um das Thema' → Präp. 'um' + Akk. neutrum → 'um das'. Standardsprachlich korrekt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-047",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Partizipialkonstruktion",
    "question": "Relativsatz → Partizip I: 'Die Kosten, die ständig steigen, belasten das Budget.'",
    "options": [
      "Die ständig steigenden Kosten belasten das Budget.",
      "Die ständig gestiegenen Kosten belasten das Budget.",
      "Die steigend ständig Kosten belasten das Budget.",
      "Die Kosten steigend ständig belasten das Budget."
    ],
    "correctAnswer": 0,
    "explanation": "Aktiver Prozess → Partizip I: 'steigend' + Deklinationsendung: 'die steigenden Kosten'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-048",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Passiv-Ersatzformen",
    "question": "Passiv-Ersatz: 'Diese Aufgabe kann nicht gelöst werden.' → '-bar'-Adjektiv (verneint)",
    "options": [
      "Diese Aufgabe ist unlösbar.",
      "Diese Aufgabe ist nicht lösbar.",
      "Diese Aufgabe ist ungelöst.",
      "Diese Aufgabe ist lösenbar nicht."
    ],
    "correctAnswer": 0,
    "explanation": "'kann nicht gelöst werden' → 'unlösbar' (Präfix 'un-' + Stamm + '-bar').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-049",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Konjunktiv II",
    "question": "Konjunktiv II Passiv: 'Wenn man ihn gefragt hätte, hätte er helfen können.'",
    "options": [
      "Wäre er gefragt worden, hätte er helfen können.",
      "Wenn er gefragt würde, könnte er helfen.",
      "Hätte er gefragt worden, hätte er helfen können.",
      "Würde er gefragt worden sein, könnte er helfen."
    ],
    "correctAnswer": 0,
    "explanation": "Konj. II Passiv Vergangenheit: 'wäre gefragt worden'. Ohne 'wenn': Verb an Position 1.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b2-umformung-p1-050",
    "level": "b2",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Ohne dass er es bemerkt hat, wurde sein Portemonnaie gestohlen.'",
    "options": [
      "Er hat es nicht bemerkt. Dabei wurde sein Portemonnaie gestohlen.",
      "Er hat es nicht bemerkt. Deshalb wurde sein Portemonnaie gestohlen.",
      "Er hat es bemerkt. Trotzdem wurde sein Portemonnaie gestohlen.",
      "Er hat es nicht bemerkt, ohne wurde sein Portemonnaie gestohlen."
    ],
    "correctAnswer": 0,
    "explanation": "'ohne dass' → 'dabei' (begleitender Umstand). Er bemerkte den Diebstahl nicht.",
    "tags": ["umformung", "grammatik"]
  }
];

export default questions;
