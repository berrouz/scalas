import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich ein Vogel bin, fliege ich nach Süden.',
      'Wenn ich ein Vogel wäre, flöge ich nach Süden.',
      'Wenn ich ein Vogel war, würde ich nach Süden fliegen.',
      'Wenn ich ein Vogel sei, fliege ich nach Süden.'
    ],
    'correctAnswer': 1,
    'explanation': 'Irrealer Konditionalsatz: wäre + Konjunktiv II (flöge). Auch "würde fliegen" wäre möglich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aufgabe konnte nicht gelöst werden.',
      'Die Aufgabe konnte nicht gelöst wird.',
      'Die Aufgabe konnte nicht lösen werden.',
      'Die Aufgabe konnte nicht gelöst geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv + Modalverb: konnte + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder, deren Eltern beide arbeiten, gehen in den Hort.',
      'Die Kinder, dessen Eltern beide arbeiten, gehen in den Hort.',
      'Die Kinder, denen Eltern beide arbeiten, gehen in den Hort.',
      'Die Kinder, die Eltern beide arbeiten, gehen in den Hort.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv Plural: deren (die Kinder → deren Eltern).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat vergessen, die Tür abschließen.',
      'Er hat vergessen, die Tür abzuschließen.',
      'Er hat vergessen, die Tür zu abschließen.',
      'Er hat vergessen, die Tür abgeschlossen zu.'
    ],
    'correctAnswer': 1,
    'explanation': 'Trennbares Verb + "zu": "zu" steht zwischen Vorsilbe und Stamm: abzuschließen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Morgen früh muss ich zum Arzt gehen.',
      'Morgen früh ich muss zum Arzt gehen.',
      'Morgen früh muss zum Arzt ich gehen.',
      'Morgen früh zum Arzt muss ich gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporale Angabe an Position 1, dann Verb, dann Subjekt (Inversion).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während sie kochte, las er die Zeitung.',
      'Während sie kochte, er las die Zeitung.',
      'Während kochte sie, las er die Zeitung.',
      'Während sie kochte, die Zeitung las er.'
    ],
    'correctAnswer': 0,
    'explanation': '"Während" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der in der Zeitung veröffentlichte Artikel sorgte für Aufregung.',
      'Der in der Zeitung veröffentlichende Artikel sorgte für Aufregung.',
      'Der in der Zeitung veröffentlicht Artikel sorgte für Aufregung.',
      'Der in der Zeitung veröffentlichter Artikel sorgte für Aufregung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: veröffentlichte (der veröffentlichte Artikel).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptet, er habe das Geld nicht genommen.',
      'Er behauptet, er hat das Geld nicht genommen.',
      'Er behauptet, er hätte das Geld nicht genommen.',
      'Er behauptet, er hatte das Geld nicht genommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Perfekt: habe ... genommen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Gebäude wird seit Jahren nicht renoviert.',
      'Das Gebäude wird seit Jahren nicht renovieren.',
      'Das Gebäude werden seit Jahren nicht renoviert.',
      'Das Gebäude wird seit Jahren nicht renovieret.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II (renoviert).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Haus, in das wir einziehen, ist neu.',
      'Das Haus, in dem wir einziehen, ist neu.',
      'Das Haus, in die wir einziehen, ist neu.',
      'Das Haus, in den wir einziehen, ist neu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wohin? → Akkusativ neutrum: in das (in das Haus einziehen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Blumen drohen zu vertrocknen.',
      'Die Blumen drohen vertrocknen.',
      'Die Blumen drohen vertrocknet zu.',
      'Die Blumen drohen zu vertrocknet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Drohen" + "zu" + Infinitiv: drohen zu vertrocknen (etwas steht kurz bevor).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst nachdem er alles erledigt hatte, konnte er sich entspannen.',
      'Erst nachdem er alles erledigt hatte, er konnte sich entspannen.',
      'Erst nachdem er hatte alles erledigt, konnte er sich entspannen.',
      'Erst nachdem alles er erledigt hatte, konnte er sich entspannen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz steht das Verb am Ende. Im Hauptsatz Verb an Position 1 nach dem Nebensatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er arbeitet, um Geld zu verdienen.',
      'Er arbeitet, um Geld verdienen.',
      'Er arbeitet, um zu Geld verdienen.',
      'Er arbeitet, um Geld verdienen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Um ... zu" + Infinitiv: um Geld zu verdienen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Außerhalb der Geschäftszeiten ist das Büro geschlossen.',
      'Außerhalb die Geschäftszeiten ist das Büro geschlossen.',
      'Außerhalb den Geschäftszeiten ist das Büro geschlossen.',
      'Außerhalb dem Geschäftszeiten ist das Büro geschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Außerhalb" verlangt den Genitiv: außerhalb der Geschäftszeiten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angekommen am Bahnhof, rief sie ein Taxi.',
      'Ankommend am Bahnhof, rief sie ein Taxi.',
      'Ankommen am Bahnhof, rief sie ein Taxi.',
      'Angekommt am Bahnhof, rief sie ein Taxi.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung (vorzeitig): angekommen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn er doch nur pünktlich wäre!',
      'Wenn er doch nur pünktlich ist!',
      'Wenn er doch nur pünktlich war!',
      'Wenn er doch nur pünktlich sei!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunschsatz mit "wenn ... doch nur" + Konjunktiv II: wäre.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dem Patienten wurde ein neues Medikament verschrieben.',
      'Der Patient wurde ein neues Medikament verschrieben.',
      'Dem Patienten wurde ein neues Medikament verschreiben.',
      'Dem Patienten worden ein neues Medikament verschrieben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv mit Dativobjekt: Dem Patienten wurde ... verschrieben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Thema, worüber wir gesprochen haben, ist wichtig.',
      'Das Thema, darüber wir gesprochen haben, ist wichtig.',
      'Das Thema, über das wir gesprochen haben, ist wichtig.',
      'Sowohl A als auch C sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Man kann "worüber" oder "über das" verwenden. Beide Formen sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf keinen Fall dürfen Sie den Notausgang blockieren.',
      'Auf keinen Fall Sie dürfen den Notausgang blockieren.',
      'Auf keinen Fall dürfen den Notausgang Sie blockieren.',
      'Auf keinen Fall blockieren dürfen Sie den Notausgang.'
    ],
    'correctAnswer': 0,
    'explanation': 'Negativer Ausdruck an Position 1 bewirkt Inversion: dürfen Sie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Indem er regelmäßig übt, verbessert er sein Deutsch.',
      'Indem er regelmäßig übt, er verbessert sein Deutsch.',
      'Indem regelmäßig er übt, verbessert er sein Deutsch.',
      'Indem er übt regelmäßig, verbessert er sein Deutsch.'
    ],
    'correctAnswer': 0,
    'explanation': '"Indem" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie klagt über starke Kopfschmerzen.',
      'Sie klagt über starken Kopfschmerzen.',
      'Sie klagt über starker Kopfschmerzen.',
      'Sie klagt über starkem Kopfschmerzen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Klagen über" + Akkusativ Plural ohne Artikel: starke Kopfschmerzen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die heruntergefallenen Blätter bedeckten den Boden.',
      'Die herunterfallende Blätter bedeckten den Boden.',
      'Die heruntergefallt Blätter bedeckten den Boden.',
      'Die heruntergefallene Blätter bedeckten den Boden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II Plural als Adjektiv: heruntergefallenen (die heruntergefallenen Blätter).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man könnte meinen, er sei ein Experte.',
      'Man könnte meinen, er ist ein Experte.',
      'Man kann meinen, er sei ein Experte.',
      'Man könnte meinen, er war ein Experte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Man könnte meinen" (Konjunktiv II) + Konjunktiv I in der indirekten Rede: er sei.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wird gebeten, nicht zu rauchen.',
      'Es wird gebeten, nicht rauchen.',
      'Es wird beten, nicht zu rauchen.',
      'Es worden gebeten, nicht zu rauchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unpersönliches Passiv: Es wird gebeten + Infinitiv mit "zu".',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachbarin, von der ich dir erzählt habe, ist umgezogen.',
      'Die Nachbarin, von die ich dir erzählt habe, ist umgezogen.',
      'Die Nachbarin, von dem ich dir erzählt habe, ist umgezogen.',
      'Die Nachbarin, von den ich dir erzählt habe, ist umgezogen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Von" + Dativ feminin: von der (die Nachbarin → von der).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich entschieden, das Studium abbrechen.',
      'Er hat sich entschieden, das Studium abzubrechen.',
      'Er hat sich entschieden, das Studium zu abbrechen.',
      'Er hat sich entschieden, das Studium abgebrochen zu.'
    ],
    'correctAnswer': 1,
    'explanation': 'Trennbares Verb + "zu": abzubrechen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotzdem hat sie die Prüfung bestanden.',
      'Trotzdem sie hat die Prüfung bestanden.',
      'Trotzdem hat sie bestanden die Prüfung.',
      'Trotzdem bestanden hat sie die Prüfung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Trotzdem" als Adverb an Position 1 erfordert Inversion: hat sie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sobald er nach Hause kommt, ruft er mich an.',
      'Sobald er nach Hause kommt, er ruft mich an.',
      'Sobald kommt er nach Hause, ruft er mich an.',
      'Sobald er kommt nach Hause, ruft er mich an.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sobald" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Statt des Kuchens brachte er Blumen mit.',
      'Statt dem Kuchen brachte er Blumen mit.',
      'Statt den Kuchen brachte er Blumen mit.',
      'Statt der Kuchen brachte er Blumen mit.'
    ],
    'correctAnswer': 0,
    'explanation': '"Statt" verlangt den Genitiv: statt des Kuchens.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Den Kopf schüttelnd verließ er das Zimmer.',
      'Den Kopf geschüttelt verließ er das Zimmer.',
      'Den Kopf schütteln verließ er das Zimmer.',
      'Den Kopf geschüttelnd verließ er das Zimmer.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als adverbiale Bestimmung (gleichzeitig): schüttelnd.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Arzt empfahl, er solle mehr Sport treiben.',
      'Der Arzt empfahl, er soll mehr Sport treiben.',
      'Der Arzt empfahl, er sollte mehr Sport treiben.',
      'Der Arzt empfahl, er sollen mehr Sport treiben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede mit Konjunktiv I: er solle.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Straße ist wegen Bauarbeiten gesperrt worden.',
      'Die Straße ist wegen Bauarbeiten gesperrt geworden.',
      'Die Straße hat wegen Bauarbeiten gesperrt worden.',
      'Die Straße ist wegen Bauarbeiten sperren worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt Passiv: ist + Partizip II + worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben das Problem besprochen müssen.',
      'Wir haben das Problem besprechen müssen.',
      'Wir haben das Problem zu besprechen müssen.',
      'Wir haben das Problem besprechen gemusst.'
    ],
    'correctAnswer': 1,
    'explanation': 'Perfekt mit Modalverb: haben + Infinitiv + Infinitiv des Modalverbs (Ersatzinfinitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wusste nicht, wann der Zug abfährt.',
      'Er wusste nicht, wann der Zug fährt ab.',
      'Er wusste nicht, wann abfährt der Zug.',
      'Er wusste nicht, wann fährt der Zug ab.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im indirekten Fragesatz steht das Verb am Ende: wann der Zug abfährt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ohne dass er es bemerkte, verließ sie das Haus.',
      'Ohne dass er es bemerkte, sie verließ das Haus.',
      'Ohne dass bemerkte er es, verließ sie das Haus.',
      'Ohne er es bemerkte dass, verließ sie das Haus.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ohne dass" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, es regnet morgen, was machen wir dann?',
      'Annehmend, es regnet morgen, was machen wir dann?',
      'Angenehmt, es regnet morgen, was machen wir dann?',
      'Zu annehmen, es regnet morgen, was machen wir dann?'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: angenommen (Partizip II von "annehmen").',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn das Wetter besser gewesen wäre, hätten wir ein Picknick gemacht.',
      'Wenn das Wetter besser gewesen ist, hätten wir ein Picknick gemacht.',
      'Wenn das Wetter besser gewesen wäre, haben wir ein Picknick gemacht.',
      'Wenn das Wetter besser war, hätten wir ein Picknick gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Vergangenheitssatz: gewesen wäre → hätten ... gemacht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ihm wurde zum Geburtstag gratuliert.',
      'Er wurde zum Geburtstag gratuliert.',
      'Ihm wurde zum Geburtstag gratulieren.',
      'Ihm worden zum Geburtstag gratuliert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gratulieren" + Dativ → Passiv mit Dativ: Ihm wurde gratuliert.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist der beste Lehrer, den ich je hatte.',
      'Er ist der beste Lehrer, der ich je hatte.',
      'Er ist der beste Lehrer, dem ich je hatte.',
      'Er ist der beste Lehrer, dessen ich je hatte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Haben" + Akkusativ maskulin: den (den Lehrer haben).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er weiß das Angebot zu schätzen.',
      'Er weiß das Angebot schätzen.',
      'Er weiß das Angebot geschätzt zu.',
      'Er weiß das Angebot zu geschätzt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wissen" + "zu" + Infinitiv drückt Fähigkeit aus: weiß zu schätzen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Besonders gut hat mir das Dessert geschmeckt.',
      'Besonders gut mir hat das Dessert geschmeckt.',
      'Besonders gut hat das Dessert mir geschmeckt.',
      'Sowohl A als auch C sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Bei Inversion nach einem Adverb ist die Stellung von Dativobjekt und Subjekt im Mittelfeld flexibel.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zumal er krank war, konnte er nicht teilnehmen.',
      'Zumal er krank war, er konnte nicht teilnehmen.',
      'Zumal war er krank, konnte er nicht teilnehmen.',
      'Zumal er war krank, konnte er nicht teilnehmen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zumal" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dank seiner Hilfe haben wir es geschafft.',
      'Dank seine Hilfe haben wir es geschafft.',
      'Dank seinen Hilfe haben wir es geschafft.',
      'Dank seinem Hilfe haben wir es geschafft.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dank" + Genitiv: dank seiner Hilfe (Genitiv feminin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das nicht zu unterschätzende Problem muss gelöst werden.',
      'Das nicht zu unterschätzte Problem muss gelöst werden.',
      'Das nicht unterschätzende Problem muss gelöst werden.',
      'Das nicht zu unterschätzen Problem muss gelöst werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu + Partizip I + Endung: das nicht zu unterschätzende Problem.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er verhielt sich, als wäre nichts geschehen.',
      'Er verhielt sich, als ist nichts geschehen.',
      'Er verhielt sich, als nichts geschehen wäre.',
      'Er verhielt sich, als war nichts geschehen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Als" (ohne "ob") + Konjunktiv II mit Inversion: als wäre nichts geschehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p3-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Arbeit hätte früher erledigt werden sollen.',
      'Die Arbeit hätte früher erledigt werden gesollt.',
      'Die Arbeit hätte früher erledigt geworden sollen.',
      'Die Arbeit hätte früher erledigen werden sollen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Passiv + Modalverb: hätte + Partizip II + werden + Infinitiv Modalverb.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
