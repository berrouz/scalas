import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbau-p1-001',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das konjugierte Verb im deutschen Hauptsatz?',
    'options': [
      'am Ende',
      'Position 1',
      'Position 2',
      'Position 3'
    ],
    'correctAnswer': 2,
    'explanation': 'Im deutschen Hauptsatz steht das konjugierte Verb immer an Position 2 (V2-Regel).',
    'exampleSentence': 'Morgen fahre ich nach Berlin.',
    'grammarRule': 'Hauptsatz: Verb auf Position 2 (Verbzweitstellung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-002',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Wortstellung?',
    'options': [
      'Gestern er hat das Buch gelesen.',
      'Gestern hat er das Buch gelesen.',
      'Gestern hat das Buch er gelesen.',
      'Hat gestern er das Buch gelesen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Inversion (Zeitangabe am Anfang) bleibt das Verb auf Position 2, das Subjekt rückt nach Position 3.',
    'grammarRule': 'Inversion: Adverb/Angabe + Verb + Subjekt + ...',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-003',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt der Regel TeKaMoLo?',
    'options': [
      'Er hat gekauft gestern in Berlin ein Buch.',
      'Er gestern hat in Berlin ein Buch gekauft.',
      'Er hat ein Buch gestern in Berlin gekauft.',
      'Er hat gestern in Berlin ein Buch gekauft.'
    ],
    'correctAnswer': 3,
    'explanation': 'TeKaMoLo = Temporal, Kausal, Modal, Lokal — die uebliche Reihenfolge der Angaben im Mittelfeld.',
    'grammarRule': 'TeKaMoLo: Temporal -> Kausal -> Modal -> Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-004',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht der trennbare Verbteil (Praefix) im Hauptsatz Praesens?',
    'options': [
      'am Ende des Satzes',
      'auf Position 1',
      'auf Position 2',
      'vor dem Subjekt'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben wandert das Praefix ans Satzende: \'Ich stehe um 7 Uhr auf.\'',
    'exampleSentence': 'Er ruft seine Mutter an.',
    'grammarRule': 'Satzklammer: Verb (Pos. 2) ... Verbzusatz/Partizip/Infinitiv (Satzende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-005',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Verbendstellung im Nebensatz?',
    'options': [
      'Ich weiss, dass er kommt morgen.',
      'Ich weiss, dass er morgen kommt.',
      'Ich weiss, dass kommt er morgen.',
      'Ich weiss, dass morgen er kommt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz (eingeleitet durch Konjunktion wie dass) steht das Verb am Ende.',
    'grammarRule': 'Nebensatz: Konjunktion + Subjekt + ... + Verb (am Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-006',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert mit dem Verb im Nebensatz mit \'weil\'?',
    'options': [
      'Es steht auf Position 2.',
      'Es steht auf Position 1.',
      'Es steht am Ende des Nebensatzes.',
      'Es faellt weg.'
    ],
    'correctAnswer': 2,
    'explanation': 'Nach subordinierenden Konjunktionen wie \'weil\' steht das Verb am Ende des Nebensatzes.',
    'exampleSentence': 'Er bleibt zu Hause, weil er krank ist.',
    'grammarRule': 'Nebensatz mit weil/dass/ob/wenn: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-007',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Wortstellung ist im Ja/Nein-Fragesatz korrekt?',
    'options': [
      'Subjekt + Verb + Rest',
      'Verb + Subjekt + Rest',
      'Verb + Rest + Subjekt',
      'Rest + Verb + Subjekt'
    ],
    'correctAnswer': 1,
    'explanation': 'In Ja/Nein-Fragen steht das Verb auf Position 1 (Verberststellung).',
    'exampleSentence': 'Kommst du morgen?',
    'grammarRule': 'Ja/Nein-Frage: Verb auf Position 1',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-008',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz ist eine korrekte W-Frage?',
    'options': [
      'Du wohnst wo?',
      'Wo du wohnst?',
      'Wo wohnst du?',
      'Wohnst wo du?'
    ],
    'correctAnswer': 2,
    'explanation': 'In W-Fragen steht das Fragewort auf Position 1, das Verb auf Position 2.',
    'grammarRule': 'W-Frage: W-Wort (Pos. 1) + Verb (Pos. 2) + Subjekt + ...',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-009',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht im Hauptsatz auf Position 1 (Vorfeld)?',
    'options': [
      'Immer das Subjekt',
      'Immer das Verb',
      'Ein beliebiges Satzglied',
      'Immer eine Zeitangabe'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Vorfeld (Position 1) kann ein beliebiges Satzglied stehen: Subjekt, Objekt, Adverbial usw.',
    'exampleSentence': 'Das Buch lese ich morgen.',
    'grammarRule': 'Vorfeld: Ein Satzglied vor dem Verb (nicht nur Subjekt)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'vorfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-010',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Satzklammer mit Modalverb?',
    'options': [
      'Ich kann morgen nicht kommen.',
      'Ich kann nicht morgen kommen.',
      'Ich morgen kann nicht kommen.',
      'Ich nicht kann morgen kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Satzklammer: Modalverb auf Position 2, Infinitiv am Ende. Angaben stehen dazwischen.',
    'grammarRule': 'Satzklammer: Modalverb (Pos. 2) + Mittelfeld + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-011',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wie verbindet man zwei Hauptsaetze mit \'und\'?',
    'options': [
      'Das Verb rueckt ans Ende.',
      'Die Wortstellung aendert sich nicht.',
      'Das Subjekt faellt weg.',
      'Das Verb steht auf Position 1.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nach koordinierenden Konjunktionen (und, oder, aber, denn) bleibt die Hauptsatz-Wortstellung.',
    'exampleSentence': 'Er liest ein Buch und sie hoert Musik.',
    'grammarRule': 'Koordinierende Konjunktionen: keine Aenderung der Wortstellung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-012',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert nach \'deshalb\' mit der Wortstellung?',
    'options': [
      'Das Verb steht am Ende.',
      'Es kommt Inversion (Verb auf Pos. 2, Subjekt auf Pos. 3).',
      'Die Wortstellung bleibt gleich wie im Hauptsatz.',
      'Das Subjekt steht auf Position 1.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Deshalb\' ist ein Konjunktionaladverb und steht im Vorfeld, daher Inversion.',
    'exampleSentence': 'Er ist krank. Deshalb bleibt er zu Hause.',
    'grammarRule': 'Konjunktionaladverbien (deshalb, trotzdem, ...): Inversion im Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-013',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Stellung der Negation \'nicht\'?',
    'options': [
      'Er nicht kommt morgen.',
      'Er kommt nicht morgen.',
      'Er kommt morgen nicht.',
      'Nicht er kommt morgen.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Nicht\' steht am Ende, wenn es den ganzen Satz verneint (Satznegation), oder vor dem Wort, das verneint wird.',
    'grammarRule': 'Satznegation: nicht moeglichst weit rechts (vor dem zweiten Verbteil)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-014',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'nicht\' bei einem Satz mit Satzklammer?',
    'options': [
      'Nach dem Infinitiv/Partizip',
      'Vor dem Infinitiv/Partizip',
      'Auf Position 1',
      'Direkt nach dem Subjekt'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nicht\' steht vor dem zweiten Verbteil (Infinitiv oder Partizip) in der Satzklammer.',
    'exampleSentence': 'Er hat das Buch nicht gelesen.',
    'grammarRule': 'Negation + Satzklammer: nicht vor dem zweiten Verbteil',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-015',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist die Satzklammer?',
    'options': [
      'Subjekt und Objekt umrahmen das Verb.',
      'Zwei Verbteile umrahmen das Mittelfeld.',
      'Konjunktionen am Anfang und Ende.',
      'Zwei Nebensaetze rahmen den Hauptsatz ein.'
    ],
    'correctAnswer': 1,
    'explanation': 'Die Satzklammer besteht aus dem finiten Verb (Pos. 2) und dem infiniten Verbteil (Ende).',
    'exampleSentence': 'Er hat gestern ein Buch gelesen.',
    'grammarRule': 'Satzklammer = finites Verb (Pos. 2) + Mittelfeld + infiniter Verbteil (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-016',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt richtige Inversion nach einer Ortsangabe?',
    'options': [
      'In Berlin ich wohne.',
      'In Berlin wohne ich.',
      'Ich in Berlin wohne.',
      'Wohne in Berlin ich.'
    ],
    'correctAnswer': 1,
    'explanation': 'Wenn eine Ortsangabe im Vorfeld steht, folgt Inversion: Verb auf Pos. 2, Subjekt auf Pos. 3.',
    'grammarRule': 'Inversion: Angabe (Pos. 1) + Verb (Pos. 2) + Subjekt (Pos. 3)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-017',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Konjunktion aendert die Wortstellung NICHT?',
    'options': [
      'weil',
      'dass',
      'aber',
      'obwohl'
    ],
    'correctAnswer': 2,
    'explanation': '\'Aber\' ist eine koordinierende Konjunktion und aendert die Wortstellung nicht.',
    'grammarRule': 'Koordinierende Konj. (und, oder, aber, denn, sondern): Hauptsatz-Wortstellung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-018',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Verb im Nebensatz mit \'wenn\'?',
    'options': [
      'auf Position 1',
      'auf Position 2',
      'am Ende',
      'nach dem Subjekt'
    ],
    'correctAnswer': 2,
    'explanation': '\'Wenn\' ist eine subordinierende Konjunktion; das Verb steht am Ende des Nebensatzes.',
    'exampleSentence': 'Wenn es regnet, bleibe ich zu Hause.',
    'grammarRule': 'Nebensatz: wenn/weil/dass/ob/... + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-019',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht im Hauptsatz nach einem vorangestellten Nebensatz?',
    'options': [
      'Das Subjekt',
      'Das Verb',
      'Ein Adverb',
      'Ein Objekt'
    ],
    'correctAnswer': 1,
    'explanation': 'Der Nebensatz nimmt Position 1 ein, daher folgt das Verb direkt auf Position 2.',
    'exampleSentence': 'Wenn es regnet, bleibe ich zu Hause.',
    'grammarRule': 'Nebensatz im Vorfeld: Nebensatz + Verb + Subjekt + ...',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-020',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Stellung von Dativ- und Akkusativobjekt?',
    'options': [
      'Er gibt das Buch dem Lehrer.',
      'Er gibt dem Lehrer das Buch.',
      'Er das Buch dem Lehrer gibt.',
      'Er dem Lehrer gibt das Buch.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei zwei Nomen-Objekten: Dativ vor Akkusativ.',
    'grammarRule': 'Objektstellung: Dativ vor Akkusativ (bei Nomen)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-021',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert mit der Objektreihenfolge, wenn das Akkusativobjekt ein Pronomen ist?',
    'options': [
      'Dativ vor Akkusativ bleibt.',
      'Akkusativ-Pronomen vor Dativ.',
      'Beide Objekte fallen weg.',
      'Die Reihenfolge ist beliebig.'
    ],
    'correctAnswer': 1,
    'explanation': 'Wenn das Akkusativobjekt ein Pronomen ist, steht es vor dem Dativ: \'Er gibt es dem Lehrer.\'',
    'exampleSentence': 'Er gibt es dem Lehrer.',
    'grammarRule': 'Pronomen-Akkusativ vor Nomen-Dativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-022',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Wortstellung im Perfekt?',
    'options': [
      'Er hat gelesen gestern ein Buch.',
      'Er gestern hat ein Buch gelesen.',
      'Er hat gestern ein Buch gelesen.',
      'Er ein Buch hat gestern gelesen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Perfekt bildet \'hat\' (Pos. 2) und \'gelesen\' (Ende) die Satzklammer.',
    'grammarRule': 'Perfekt-Satzklammer: haben/sein (Pos. 2) + Mittelfeld + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-023',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Reflexivpronomen \'sich\' im Hauptsatz?',
    'options': [
      'Am Ende des Satzes',
      'Moeglichst nah am Verb (nach dem Subjekt)',
      'Vor dem Verb',
      'An Position 1'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Reflexivpronomen steht moeglichst nah am finiten Verb, typisch nach dem Subjekt.',
    'exampleSentence': 'Er freut sich auf den Urlaub.',
    'grammarRule': 'Reflexivpronomen: nach dem Subjekt, nah am Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-024',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Inversion mit Reflexivpronomen?',
    'options': [
      'Gestern sich er hat gefreut.',
      'Gestern hat er sich gefreut.',
      'Gestern hat sich er gefreut.',
      'Gestern er sich hat gefreut.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Inversion: Angabe + Verb + Subjekt + Reflexivpronomen.',
    'grammarRule': 'Inversion + Reflexiv: Angabe + Verb + Subjekt + sich + ...',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-025',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was bedeutet \'Verbzweitstellung\'?',
    'options': [
      'Das Verb hat zwei Teile.',
      'Das Verb steht an Position 2 im Hauptsatz.',
      'Zwei Verben stehen nebeneinander.',
      'Das Verb wird zweimal konjugiert.'
    ],
    'correctAnswer': 1,
    'explanation': 'Verbzweitstellung (V2) ist das Grundprinzip des deutschen Hauptsatzes.',
    'grammarRule': 'V2-Regel: Im Hauptsatz steht das finite Verb immer an Position 2',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-026',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz ist korrekt mit \'obwohl\'?',
    'options': [
      'Obwohl er ist krank, geht er zur Arbeit.',
      'Obwohl er krank ist, geht er zur Arbeit.',
      'Obwohl ist er krank, geht er zur Arbeit.',
      'Obwohl krank er ist, geht er zur Arbeit.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Obwohl\' leitet einen Nebensatz ein; das Verb steht am Ende des Nebensatzes.',
    'grammarRule': 'Nebensatz mit obwohl: obwohl + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-027',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Verb nach \'denn\'?',
    'options': [
      'Am Ende des Satzes',
      'Auf Position 2 (wie im Hauptsatz)',
      'Auf Position 1',
      'Direkt nach denn'
    ],
    'correctAnswer': 1,
    'explanation': '\'Denn\' ist eine koordinierende Konjunktion; die Hauptsatz-Wortstellung bleibt.',
    'exampleSentence': 'Er bleibt zu Hause, denn er ist krank.',
    'grammarRule': 'Nach denn: normale Hauptsatz-Wortstellung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-028',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Stellung von \'gern\' (Modalangabe)?',
    'options': [
      'Er liest gern Buecher.',
      'Gern er liest Buecher.',
      'Er gern liest Buecher.',
      'Er liest Buecher gern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalangaben wie \'gern\' stehen im Mittelfeld, typisch nach dem Verb.',
    'grammarRule': 'Modalangaben im Mittelfeld nach dem finiten Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-029',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Wortstellung hat ein indirekter Fragesatz?',
    'options': [
      'Verb auf Position 1',
      'Verb auf Position 2',
      'Verb am Ende',
      'Wie eine direkte Frage'
    ],
    'correctAnswer': 2,
    'explanation': 'Indirekte Fragen sind Nebensaetze; das Verb steht am Ende.',
    'exampleSentence': 'Ich weiss nicht, wo er wohnt.',
    'grammarRule': 'Indirekter Fragesatz: Fragewort/ob + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-030',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die korrekte Stellung mit \'ob\'?',
    'options': [
      'Ich frage, ob er kommt morgen.',
      'Ich frage, ob kommt er morgen.',
      'Ich frage, ob er morgen kommt.',
      'Ich frage, ob morgen kommt er.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Ob\' leitet einen indirekten Fragesatz ein; das Verb steht am Ende.',
    'grammarRule': 'Indirekter Fragesatz mit ob: ob + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-031',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist das Mittelfeld im deutschen Satz?',
    'options': [
      'Der Bereich vor dem Verb',
      'Der Bereich zwischen den beiden Verbteilen der Satzklammer',
      'Der letzte Teil des Satzes',
      'Das Vorfeld und Nachfeld zusammen'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Mittelfeld liegt zwischen dem finiten Verb und dem Satzende (zweiter Verbteil).',
    'grammarRule': 'Mittelfeld = Bereich zwischen Verb (Pos. 2) und Satzende',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-032',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Wortstellung mit zwei Infinitiven?',
    'options': [
      'Er hat muessen gestern arbeiten.',
      'Er hat gestern arbeiten muessen.',
      'Er gestern hat arbeiten muessen.',
      'Er hat gestern muessen arbeiten.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Modalverb im Perfekt: doppelter Infinitiv am Ende (Ersatzinfinitiv).',
    'grammarRule': 'Ersatzinfinitiv: hat/ist + ... + Infinitiv + Modalverb-Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-033',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Angabe gehoert zur Kategorie \'Temporal\' in TeKaMoLo?',
    'options': [
      'mit dem Bus',
      'gestern',
      'wegen des Regens',
      'in Berlin'
    ],
    'correctAnswer': 1,
    'explanation': '\'Gestern\' ist eine Zeitangabe (Temporal) und steht in TeKaMoLo an erster Stelle.',
    'grammarRule': 'TeKaMoLo: Temporal = Wann? (gestern, morgen, oft, ...)',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-034',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Angabe gehoert zur Kategorie \'Kausal\' in TeKaMoLo?',
    'options': [
      'morgen',
      'in Berlin',
      'wegen der Pruefung',
      'schnell'
    ],
    'correctAnswer': 2,
    'explanation': '\'Wegen der Pruefung\' ist eine Kausalangabe (Warum?) und steht nach Temporal.',
    'grammarRule': 'TeKaMoLo: Kausal = Warum? (wegen, aus Angst, ...)',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-035',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Angabe gehoert zur Kategorie \'Modal\' in TeKaMoLo?',
    'options': [
      'am Montag',
      'aus Freude',
      'mit dem Zug',
      'nach Hamburg'
    ],
    'correctAnswer': 2,
    'explanation': '\'Mit dem Zug\' ist eine Modalangabe (Wie?) und steht nach Kausal.',
    'grammarRule': 'TeKaMoLo: Modal = Wie? (mit dem Auto, gern, schnell, ...)',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-036',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Angabe gehoert zur Kategorie \'Lokal\' in TeKaMoLo?',
    'options': [
      'jeden Tag',
      'trotz des Wetters',
      'sehr schnell',
      'im Park'
    ],
    'correctAnswer': 3,
    'explanation': '\'Im Park\' ist eine Lokalangabe (Wo?) und steht in TeKaMoLo an letzter Stelle.',
    'grammarRule': 'TeKaMoLo: Lokal = Wo/Wohin? (in Berlin, im Park, nach Hause, ...)',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-037',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Reihenfolge nach TeKaMoLo?',
    'options': [
      'Sie faehrt in die Stadt morgen mit dem Bus.',
      'Sie faehrt mit dem Bus morgen in die Stadt.',
      'Sie faehrt morgen mit dem Bus in die Stadt.',
      'Sie faehrt morgen in die Stadt mit dem Bus.'
    ],
    'correctAnswer': 2,
    'explanation': 'Morgen (Temporal) + mit dem Bus (Modal) + in die Stadt (Lokal) = TeKaMoLo.',
    'grammarRule': 'TeKaMoLo: T vor M vor L',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-038',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Partizip II im Nebensatz?',
    'options': [
      'Direkt nach der Konjunktion',
      'Vor dem Hilfsverb am Ende',
      'An Position 2',
      'Am Anfang des Nebensatzes'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz steht das Partizip II vor dem Hilfsverb am Ende.',
    'exampleSentence': '...weil er das Buch gelesen hat.',
    'grammarRule': 'Nebensatz-Perfekt: ... + Partizip II + Hilfsverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-039',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz ist korrekt?',
    'options': [
      'Ich habe gestern meinem Freund geholfen.',
      'Ich habe geholfen gestern meinem Freund.',
      'Ich gestern habe meinem Freund geholfen.',
      'Ich habe meinem Freund gestern geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Zeitangabe \'gestern\' steht vor dem Dativobjekt; Partizip am Ende.',
    'grammarRule': 'Mittelfeld: Zeitangabe vor Objekten, Partizip am Ende',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-040',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Nebensatz mit \'damit\' ist korrekt?',
    'options': [
      'Er lernt, damit er besteht die Pruefung.',
      'Er lernt, damit er die Pruefung besteht.',
      'Er lernt, damit besteht er die Pruefung.',
      'Er lernt, damit die Pruefung er besteht.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Damit\' leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz mit damit: damit + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-041',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht im Nachfeld des Satzes?',
    'options': [
      'Das finite Verb',
      'Vergleiche, Nebensaetze oder lange Praepositionalgruppen',
      'Das Subjekt',
      'Die Negation'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nachfeld (nach der rechten Satzklammer) stehen oft Vergleiche, Nebensaetze oder lange Ergaenzungen.',
    'exampleSentence': 'Er ist groesser als sein Bruder.',
    'grammarRule': 'Nachfeld: nach dem letzten Verbteil (Vergleiche, Nebensaetze, ...)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-042',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'trotzdem\' hat die richtige Wortstellung?',
    'options': [
      'Er ist muede. Trotzdem er geht zur Arbeit.',
      'Er ist muede. Trotzdem geht er zur Arbeit.',
      'Er ist muede. Trotzdem zur Arbeit geht er.',
      'Er ist muede. Er trotzdem geht zur Arbeit.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Trotzdem\' ist ein Konjunktionaladverb im Vorfeld; es folgt Inversion.',
    'grammarRule': 'Trotzdem (Vorfeld): Inversion mit Verb auf Pos. 2',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-043',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wie lautet die korrekte Wortstellung mit \'als\' (temporal)?',
    'options': [
      'Als ich war Kind, spielte ich viel.',
      'Als ich Kind war, spielte ich viel.',
      'Als war ich Kind, spielte ich viel.',
      'Als Kind ich war, spielte ich viel.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Als\' (temporal) leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz mit als: als + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-044',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Imperativsatz ist korrekt?',
    'options': [
      'Du komm bitte her!',
      'Komm bitte her!',
      'Bitte komm her du!',
      'Her komm bitte!'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Imperativ steht das Verb auf Position 1. Das Subjekt \'du\' wird meist weggelassen.',
    'grammarRule': 'Imperativ: Verb auf Position 1 (Verberststellung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'imperativ']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-045',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'auch\' typischerweise im Satz?',
    'options': [
      'Am Satzende',
      'Vor dem Element, das es betont, oder nach dem Verb',
      'Immer auf Position 1',
      'Vor dem Verb'
    ],
    'correctAnswer': 1,
    'explanation': '\'Auch\' steht typischerweise vor dem Satzglied, das es hervorhebt, oder im Mittelfeld.',
    'exampleSentence': 'Er hat auch ein Buch gekauft.',
    'grammarRule': 'Fokuspartikel \'auch\': vor dem betonten Satzglied',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-046',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'nachdem\' hat die richtige Wortstellung?',
    'options': [
      'Nachdem er hat gegessen, ging er spazieren.',
      'Nachdem er gegessen hat, ging er spazieren.',
      'Nachdem hat er gegessen, ging er spazieren.',
      'Nachdem gegessen er hat, ging er spazieren.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nachdem\' leitet einen Nebensatz ein; Partizip + Hilfsverb am Ende.',
    'grammarRule': 'Nebensatz mit nachdem: Partizip II + Hilfsverb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-047',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Relativsatz hat die richtige Wortstellung?',
    'options': [
      'Der Mann, der wohnt in Berlin, ist nett.',
      'Der Mann, der in Berlin wohnt, ist nett.',
      'Der Mann, wohnt der in Berlin, ist nett.',
      'Der Mann, in Berlin der wohnt, ist nett.'
    ],
    'correctAnswer': 1,
    'explanation': 'Relativsaetze sind Nebensaetze; das Verb steht am Ende.',
    'grammarRule': 'Relativsatz: Relativpronomen + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-048',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Futur I hat die richtige Satzklammer?',
    'options': [
      'Er morgen wird ein Buch lesen.',
      'Er wird morgen lesen ein Buch.',
      'Er wird morgen ein Buch lesen.',
      'Er wird ein Buch morgen lesen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Futur I: \'wird\' auf Pos. 2 bildet mit dem Infinitiv am Ende die Satzklammer.',
    'grammarRule': 'Futur-I-Satzklammer: werden (Pos. 2) + Mittelfeld + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-049',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'nicht\' bei einem praedikativen Adjektiv?',
    'options': [
      'Nach dem Adjektiv',
      'Vor dem Adjektiv',
      'Am Satzanfang',
      'Am Satzende'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nicht\' steht vor dem praedikativen Adjektiv: \'Er ist nicht muede.\'',
    'exampleSentence': 'Er ist nicht muede.',
    'grammarRule': 'Negation mit praed. Adjektiv: nicht + Adjektiv',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p1-050',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'sowohl ... als auch\' ist korrekt?',
    'options': [
      'Sowohl er liest Buecher als auch hoert er Musik.',
      'Er liest sowohl Buecher als auch hoert Musik.',
      'Er liest sowohl Buecher als auch er hoert Musik.',
      'Sowohl liest er Buecher als auch hoert Musik.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Sowohl ... als auch\' verbindet gleichrangige Satzglieder; hier zwei Objekte.',
    'grammarRule': 'Sowohl ... als auch: verbindet parallele Satzglieder',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  }
];

export default questions;
