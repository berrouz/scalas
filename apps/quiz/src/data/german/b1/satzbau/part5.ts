import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbau-p5-002',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Wortstellung?',
    'options': [
      'Gestern hat das Buch er gelesen.',
      'Gestern hat er das Buch gelesen.',
      'Hat gestern er das Buch gelesen.',
      'Gestern er hat das Buch gelesen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Inversion bleibt das Verb auf Position 2, das Subjekt rueckt nach Position 3.',
    'grammarRule': 'Inversion: Adverb/Angabe + Verb + Subjekt + ...',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-003',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt der Regel TeKaMoLo?',
    'options': [
      'Er hat ein Buch gestern in Berlin gekauft.',
      'Er gestern hat in Berlin ein Buch gekauft.',
      'Er hat gestern in Berlin ein Buch gekauft.',
      'Er hat gekauft gestern in Berlin ein Buch.'
    ],
    'correctAnswer': 2,
    'explanation': 'TeKaMoLo = Temporal, Kausal, Modal, Lokal.',
    'grammarRule': 'TeKaMoLo: Temporal -> Kausal -> Modal -> Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-004',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht der trennbare Verbteil (Praefix) im Hauptsatz Praesens?',
    'options': ['vor dem Subjekt', 'am Ende des Satzes', 'auf Position 1', 'auf Position 2'],
    'correctAnswer': 1,
    'explanation': 'Bei trennbaren Verben wandert das Praefix ans Satzende.',
    'exampleSentence': 'Er ruft seine Mutter an.',
    'grammarRule': 'Satzklammer: Verb (Pos. 2) ... Verbzusatz (Satzende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-005',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'dass\' ist korrekt?',
    'options': [
      'Ich denke, dass er ist nett.',
      'Ich denke, dass er nett ist.',
      'Ich denke, dass ist er nett.',
      'Ich denke, dass nett er ist.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Dass\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit dass: dass + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-006',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Ja/Nein-Fragesatz ist korrekt?',
    'options': [
      'Du hast das Buch gelesen?',
      'Hast du das Buch gelesen?',
      'Das Buch hast du gelesen?',
      'Gelesen hast du das Buch?'
    ],
    'correctAnswer': 1,
    'explanation': 'Ja/Nein-Frage: Verb auf Position 1.',
    'grammarRule': 'Entscheidungsfrage: Verb (Pos. 1) + Subjekt + ...',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-007',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wenn\' ist korrekt?',
    'options': [
      'Wenn du willst, kannst du mitkommen.',
      'Wenn du willst, du kannst mitkommen.',
      'Wenn willst du, kannst du mitkommen.',
      'Wenn du willst, mitkommen kannst du.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wenn-Nebensatz + Hauptsatz mit Inversion.',
    'grammarRule': 'Wenn-Nebensatz (Verb am Ende) + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-008',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Satzklammer im Perfekt?',
    'options': [
      'Wir haben gestern Fussball gespielt.',
      'Wir haben gespielt gestern Fussball.',
      'Wir gestern haben Fussball gespielt.',
      'Wir haben gestern gespielt Fussball.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt: \'haben\' (Pos. 2) + Mittelfeld + Partizip II (Ende).',
    'grammarRule': 'Perfekt-Satzklammer: haben (Pos. 2) + ... + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-009',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Konjunktion schickt das Verb ans Ende?',
    'options': [
      'und',
      'aber',
      'wenn',
      'denn'
    ],
    'correctAnswer': 2,
    'explanation': '\'Wenn\' ist eine subordinierende Konjunktion; das Verb steht am Ende.',
    'grammarRule': 'Subordinierende Konjunktionen: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-010',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'trotzdem\' zeigt korrekte Inversion?',
    'options': [
      'Er hat Kopfschmerzen. Trotzdem er geht zur Arbeit.',
      'Er hat Kopfschmerzen. Trotzdem geht er zur Arbeit.',
      'Er hat Kopfschmerzen. Trotzdem zur Arbeit er geht.',
      'Er hat Kopfschmerzen. Er trotzdem geht zur Arbeit.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Trotzdem\' im Vorfeld: Verb + Subjekt (Inversion).',
    'grammarRule': 'Trotzdem (Vorfeld): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-011',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'nicht\' bei \'Er ist ___ krank\'?',
    'options': [
      'Er ist krank nicht.',
      'Er nicht ist krank.',
      'Er ist nicht krank.',
      'Nicht er ist krank.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Nicht\' steht vor dem praedikativen Adjektiv.',
    'grammarRule': 'Negation: nicht vor Praedikativ (Adjektiv)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-012',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb ist korrekt?',
    'options': [
      'Sie darf heute nicht ausgehen.',
      'Sie darf nicht heute ausgehen.',
      'Sie darf heute ausgehen nicht.',
      'Sie nicht darf heute ausgehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb (Pos. 2) + Mittelfeld + Negation + Infinitiv (Ende).',
    'grammarRule': 'Satzklammer mit Negation: nicht vor dem Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-013',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Relativsatz ist korrekt?',
    'options': [
      'Die Stadt, in der ich wohne, ist gross.',
      'Die Stadt, in der wohne ich, ist gross.',
      'Die Stadt, ich in der wohne, ist gross.',
      'Die Stadt, wohne ich in der, ist gross.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativsatz: Praeposition + Relativpronomen + ... + Verb (Ende).',
    'grammarRule': 'Relativsatz: Relativpronomen + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-014',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Dativ-Pronomen und Akkusativ-Nomen ist korrekt?',
    'options': [
      'Er gibt ihr das Buch.',
      'Er gibt das Buch ihr.',
      'Er ihr gibt das Buch.',
      'Er das Buch ihr gibt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dativ-Pronomen vor Akkusativ-Nomen.',
    'grammarRule': 'Pronomen-Dativ vor Nomen-Akkusativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-015',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist die korrekte Reihenfolge bei zwei Pronomen-Objekten?',
    'options': [
      'Dativ vor Akkusativ',
      'Akkusativ vor Dativ',
      'Beliebig',
      'Beide am Satzende'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei zwei Pronomen: Akkusativ vor Dativ.',
    'exampleSentence': 'Er gibt es ihr.',
    'grammarRule': 'Zwei Pronomen: Akkusativ vor Dativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-016',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'obwohl\' im Vorfeld ist korrekt?',
    'options': [
      'Obwohl er krank ist, er geht zur Schule.',
      'Obwohl er krank ist, geht er zur Schule.',
      'Obwohl er ist krank, geht er zur Schule.',
      'Obwohl krank er ist, geht er zur Schule.'
    ],
    'correctAnswer': 1,
    'explanation': 'Obwohl-Nebensatz (Verb am Ende) + Hauptsatz (Inversion).',
    'grammarRule': 'Obwohl-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-017',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit TeKaMoLo (drei Angaben) ist korrekt?',
    'options': [
      'Er faehrt in die Stadt wegen der Arbeit morgen.',
      'Er faehrt morgen wegen der Arbeit in die Stadt.',
      'Er faehrt wegen der Arbeit morgen in die Stadt.',
      'Er faehrt in die Stadt morgen wegen der Arbeit.'
    ],
    'correctAnswer': 1,
    'explanation': 'Morgen (T) + wegen der Arbeit (K) + in die Stadt (L) = TeKaLokal.',
    'grammarRule': 'TeKaMoLo: T + K + L',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-018',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'um ... zu\' ist korrekt?',
    'options': [
      'Sie geht ins Fitnessstudio, um fit zu bleiben.',
      'Sie geht ins Fitnessstudio, um zu bleiben fit.',
      'Sie geht ins Fitnessstudio, um fit bleiben zu.',
      'Sie geht ins Fitnessstudio, zu um fit bleiben.'
    ],
    'correctAnswer': 0,
    'explanation': 'um ... zu: um + Ergaenzung + zu + Infinitiv.',
    'grammarRule': 'Infinitivsatz: um + ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-019',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv im Nebensatz ist korrekt?',
    'options': [
      '...weil das Haus wird renoviert.',
      '...weil das Haus renoviert wird.',
      '...weil wird das Haus renoviert.',
      '...weil renoviert das Haus wird.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz + Passiv: Partizip II + \'wird\' am Ende.',
    'grammarRule': 'Nebensatz + Passiv: ... + Partizip II + werden (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-021',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Futur I ist korrekt?',
    'options': [
      'Sie wird naechste Woche umziehen.',
      'Sie wird umziehen naechste Woche.',
      'Sie naechste Woche wird umziehen.',
      'Sie wird naechste Woche umziehen wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: \'wird\' (Pos. 2) + Mittelfeld + Infinitiv (Ende).',
    'grammarRule': 'Futur I: werden (Pos. 2) + ... + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-022',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'denn\' ist korrekt?',
    'options': [
      'Er kauft Blumen, denn morgen ist Valentinstag.',
      'Er kauft Blumen, denn ist morgen Valentinstag.',
      'Er kauft Blumen, denn morgen Valentinstag ist.',
      'Er kauft Blumen, denn Valentinstag morgen ist.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Denn\' ist koordinierend; normale Hauptsatz-Wortstellung folgt.',
    'grammarRule': 'Denn: koordinierende Konjunktion, keine Stellungsaenderung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-024',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'als\' (temporal) ist korrekt?',
    'options': [
      'Als er war jung, spielte er Fussball.',
      'Als er jung war, spielte er Fussball.',
      'Als war er jung, spielte er Fussball.',
      'Als jung er war, spielte er Fussball.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Als\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit als: als + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-025',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Negation mit \'kein\'?',
    'options': [
      'Er hat nicht Auto.',
      'Er hat kein Auto.',
      'Er kein hat Auto.',
      'Kein er hat Auto.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Kein\' verneint Nomen mit unbestimmtem Artikel; steht vor dem Nomen.',
    'grammarRule': 'Negation: kein vor dem Nomen (statt nicht + unbestimmter Artikel)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-026',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'nachdem\' im Vorfeld ist korrekt?',
    'options': [
      'Nachdem er gefruestueckt hatte, ging er zur Arbeit.',
      'Nachdem er hatte gefruestueckt, ging er zur Arbeit.',
      'Nachdem hatte er gefruestueckt, ging er zur Arbeit.',
      'Nachdem gefruestueckt er hatte, ging er zur Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nachdem-Nebensatz: Partizip + Hilfsverb am Ende; Hauptsatz mit Inversion.',
    'grammarRule': 'Nachdem-Nebensatz + Hauptsatz mit Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-027',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb im Nebensatz ist korrekt?',
    'options': [
      '...weil sie will morgen kommen.',
      '...weil sie morgen will kommen.',
      '...weil sie morgen kommen will.',
      '...weil will sie morgen kommen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Nebensatz + Modalverb: Infinitiv + Modalverb am Ende.',
    'grammarRule': 'Nebensatz: ... + Infinitiv + Modalverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-028',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung mit \'meistens\'?',
    'options': [
      'Meistens er faehrt mit dem Bus.',
      'Er meistens faehrt mit dem Bus.',
      'Er faehrt mit dem Bus meistens.',
      'Er faehrt meistens mit dem Bus.'
    ],
    'correctAnswer': 3,
    'explanation': '\'Meistens\' als Frequenzadverb steht im Mittelfeld.',
    'grammarRule': 'Frequenzadverb: im Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-030',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Wortstellung mit Konjunktiv II?',
    'options': [
      'Ich wuerde gern ins Kino gehen.',
      'Ich wuerde gehen gern ins Kino.',
      'Ich gern wuerde ins Kino gehen.',
      'Ich wuerde ins Kino gehen gern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'wuerde\' (Pos. 2) + Mittelfeld + Infinitiv (Ende).',
    'grammarRule': 'Konjunktiv II: wuerde (Pos. 2) + ... + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-031',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'gerade\' im Satz \'Er ___ telefoniert ___\'?',
    'options': [
      'Er telefoniert gerade.',
      'Er gerade telefoniert.',
      'Gerade er telefoniert.',
      'Telefoniert er gerade.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gerade\' steht im Mittelfeld oder am Ende des einfachen Satzes.',
    'grammarRule': '\'Gerade\': im Mittelfeld oder am Satzende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-032',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'bis\' ist korrekt?',
    'options': [
      'Ich warte hier, bis du bist fertig.',
      'Ich warte hier, bis du fertig bist.',
      'Ich warte hier, bis bist du fertig.',
      'Ich warte hier, bis fertig du bist.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Bis\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit bis: bis + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-033',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Imperativ (wir-Form) ist korrekt?',
    'options': [
      'Wir gehen jetzt!',
      'Gehen wir jetzt!',
      'Jetzt gehen wir!',
      'Gehen jetzt wir!'
    ],
    'correctAnswer': 1,
    'explanation': 'Imperativ (wir-Form): Verb auf Pos. 1, dann \'wir\'.',
    'grammarRule': 'Imperativ wir-Form: Verb (Pos. 1) + wir + Rest',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'imperativ']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-034',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'waehrend\' ist korrekt?',
    'options': [
      'Waehrend ich koche, er raeumt auf.',
      'Waehrend ich koche, raeumt er auf.',
      'Waehrend koche ich, raeumt er auf.',
      'Waehrend ich koche, auf raeumt er.'
    ],
    'correctAnswer': 1,
    'explanation': 'Waehrend-Nebensatz + Hauptsatz mit Inversion.',
    'grammarRule': 'Waehrend-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-035',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist das Nachfeld?',
    'options': [
      'Der Bereich vor dem Verb',
      'Der Bereich zwischen den Verbteilen',
      'Der Bereich nach dem letzten Verbteil',
      'Das Subjekt'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Nachfeld ist der Bereich nach der rechten Satzklammer.',
    'grammarRule': 'Nachfeld: nach dem zweiten Verbteil (Vergleiche, Nebensaetze, ...)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-036',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'weder ... noch\' ist korrekt?',
    'options': [
      'Er spricht weder Deutsch noch Englisch.',
      'Weder er spricht Deutsch noch Englisch.',
      'Er weder spricht Deutsch noch Englisch.',
      'Er spricht Deutsch weder noch Englisch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Weder ... noch\' verbindet parallele Satzglieder im Mittelfeld.',
    'grammarRule': 'Weder ... noch: parallele Elemente',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-037',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'auch\' im Nebensatz?',
    'options': [
      'Vor der Konjunktion',
      'Am Ende nach dem Verb',
      'Im Mittelfeld, nach dem Subjekt',
      'Direkt nach der Konjunktion'
    ],
    'correctAnswer': 2,
    'explanation': '\'Auch\' steht im Mittelfeld des Nebensatzes.',
    'exampleSentence': '...weil er auch Deutsch spricht.',
    'grammarRule': '\'Auch\' im Nebensatz: im Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-038',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'sobald\' ist korrekt?',
    'options': [
      'Sobald es hoert auf zu regnen, gehen wir raus.',
      'Sobald es aufhoert zu regnen, gehen wir raus.',
      'Sobald aufhoert es zu regnen, gehen wir raus.',
      'Sobald es zu regnen aufhoert, gehen wir raus.'
    ],
    'correctAnswer': 3,
    'explanation': 'Sobald-Nebensatz: zu + Infinitiv + finites Verb am Ende.',
    'grammarRule': 'Nebensatz mit sobald: ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-039',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung im Passiv mit Modalverb?',
    'options': [
      'Das Haus muss renoviert werden.',
      'Das Haus muss werden renoviert.',
      'Das Haus renoviert muss werden.',
      'Das Haus werden muss renoviert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv + Modalverb: Modalverb (Pos. 2) + Partizip II + werden (Ende).',
    'grammarRule': 'Passiv + Modalverb: muss/kann/... + ... + Partizip II + werden',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-040',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'seitdem\' ist korrekt?',
    'options': [
      'Seitdem er hat angefangen zu arbeiten, hat er wenig Zeit.',
      'Seitdem er angefangen hat zu arbeiten, hat er wenig Zeit.',
      'Seitdem hat er angefangen zu arbeiten, hat er wenig Zeit.',
      'Seitdem er zu arbeiten angefangen hat, hat er wenig Zeit.'
    ],
    'correctAnswer': 3,
    'explanation': 'Seitdem-Nebensatz: zu + Infinitiv + Partizip + Hilfsverb am Ende.',
    'grammarRule': 'Nebensatz mit seitdem: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-041',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert mit der Wortstellung nach \'jedoch\'?',
    'options': [
      'Verb am Ende',
      'Keine Aenderung',
      'Inversion (wenn im Vorfeld)',
      'Verb faellt weg'
    ],
    'correctAnswer': 2,
    'explanation': '\'Jedoch\' als Konjunktionaladverb im Vorfeld erfordert Inversion.',
    'exampleSentence': 'Er ist jung. Jedoch hat er viel Erfahrung.',
    'grammarRule': 'Jedoch (Vorfeld): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-042',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit trennbarem Verb im Perfekt ist korrekt?',
    'options': [
      'Er hat gestern an gerufen.',
      'Er hat gestern angerufen.',
      'Er hat angerufen gestern.',
      'Er angerufen hat gestern.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Perfekt: Partizip II des trennbaren Verbs zusammen am Ende.',
    'grammarRule': 'Perfekt + trennbares Verb: an-ge-rufen am Ende',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-043',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'entweder ... oder\' ist korrekt?',
    'options': [
      'Entweder kommst du mit, oder du bleibst hier.',
      'Entweder du kommst mit, oder du bleibst hier.',
      'Entweder kommst du mit, oder bleibst du hier.',
      'Du entweder kommst mit, oder du bleibst hier.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Entweder\' im Vorfeld: Inversion. \'Oder\': normale Hauptsatz-Stellung.',
    'grammarRule': 'Entweder (Inversion) ... oder (Hauptsatz)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-045',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz (zu + Infinitiv) ist korrekt?',
    'options': [
      'Es ist wichtig, zu kommen puenktlich.',
      'Es ist wichtig, puenktlich zu kommen.',
      'Es ist wichtig, puenktlich kommen zu.',
      'Es ist wichtig, zu puenktlich kommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz: Ergaenzung + zu + Infinitiv am Ende.',
    'grammarRule': 'Infinitivsatz: ... + zu + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-046',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'indem\' ist korrekt?',
    'options': [
      'Man lernt Deutsch, indem man spricht viel.',
      'Man lernt Deutsch, indem man viel spricht.',
      'Man lernt Deutsch, indem spricht man viel.',
      'Man lernt Deutsch, indem viel man spricht.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Indem\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit indem: indem + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-047',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung von \'schon\' im Perfekt?',
    'options': [
      'Er hat das Buch schon gelesen.',
      'Er hat schon das Buch gelesen.',
      'Er schon hat das Buch gelesen.',
      'Schon er hat das Buch gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schon\' steht im Mittelfeld, oft vor dem Partizip.',
    'grammarRule': '\'Schon\': im Mittelfeld der Satzklammer',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-048',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Vergleich ist korrekt?',
    'options': [
      'Er laeuft schneller als ich.',
      'Er laeuft als ich schneller.',
      'Schneller als ich er laeuft.',
      'Er als ich laeuft schneller.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vergleich: Komparativ + als + Vergleichselement im Nachfeld.',
    'grammarRule': 'Vergleich im Nachfeld: Komparativ + als + Element',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-049',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche W-Frage ist korrekt?',
    'options': [
      'Wem du hast das Buch gegeben?',
      'Wem hast du das Buch gegeben?',
      'Du hast wem das Buch gegeben?',
      'Hast wem du das Buch gegeben?'
    ],
    'correctAnswer': 1,
    'explanation': 'W-Frage: W-Wort (Pos. 1) + Verb (Pos. 2) + Subjekt + ...',
    'grammarRule': 'W-Frage: Fragewort + Verb + Subjekt',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p5-050',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung mit \'zuerst\' im Vorfeld?',
    'options': [
      'Zuerst er macht seine Hausaufgaben.',
      'Zuerst macht er seine Hausaufgaben.',
      'Er zuerst macht seine Hausaufgaben.',
      'Macht zuerst er seine Hausaufgaben.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Zuerst\' im Vorfeld: Inversion (Verb + Subjekt).',
    'grammarRule': 'Temporaladverb (Vorfeld) + Verb + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  }
];

export default questions;
