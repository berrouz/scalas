import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbau-p2-001',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das konjugierte Verb im deutschen Hauptsatz?',
    'options': ['Position 1', 'am Ende', 'Position 2', 'Position 3'],
    'correctAnswer': 2,
    'explanation': 'Im deutschen Hauptsatz steht das konjugierte Verb immer an Position 2 (V2-Regel).',
    'exampleSentence': 'Morgen fahre ich nach Berlin.',
    'grammarRule': 'Hauptsatz: Verb auf Position 2 (Verbzweitstellung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-002',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Wortstellung?',
    'options': [
      'Gestern hat er das Buch gelesen.',
      'Hat gestern er das Buch gelesen.',
      'Gestern er hat das Buch gelesen.',
      'Gestern hat das Buch er gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Inversion (Zeitangabe am Anfang) bleibt das Verb auf Position 2, das Subjekt rueckt nach Position 3.',
    'grammarRule': 'Inversion: Adverb/Angabe + Verb + Subjekt + ...',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-005',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Nebensatz mit \'dass\' ist korrekt?',
    'options': [
      'Ich hoffe, dass er kommt bald.',
      'Ich hoffe, dass er bald kommt.',
      'Ich hoffe, dass bald er kommt.',
      'Ich hoffe, dass kommt er bald.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im dass-Nebensatz steht das Verb am Ende.',
    'grammarRule': 'Nebensatz mit dass: dass + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-006',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert mit der Verbposition nach \'weil\'?',
    'options': [
      'Das Verb bleibt auf Position 2.',
      'Das Verb steht auf Position 1.',
      'Das Verb steht am Ende.',
      'Das Verb faellt weg.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Weil\' ist eine subordinierende Konjunktion; das Verb geht ans Ende des Nebensatzes.',
    'exampleSentence': 'Er fehlt, weil er krank ist.',
    'grammarRule': 'Nebensatz mit weil: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-007',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Wortstellung hat eine Ja/Nein-Frage?',
    'options': [
      'Subjekt + Verb + Rest',
      'Verb + Subjekt + Rest',
      'Rest + Verb + Subjekt',
      'Subjekt + Rest + Verb'
    ],
    'correctAnswer': 1,
    'explanation': 'In Ja/Nein-Fragen steht das Verb auf Position 1 (Verberststellung).',
    'exampleSentence': 'Hast du das Buch gelesen?',
    'grammarRule': 'Entscheidungsfrage: Verb auf Position 1',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-008',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Inversion mit Objekt im Vorfeld?',
    'options': [
      'Das Buch ich habe gelesen.',
      'Das Buch habe ich gelesen.',
      'Habe das Buch ich gelesen.',
      'Ich das Buch habe gelesen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Auch ein Objekt kann im Vorfeld stehen; dann folgt Inversion.',
    'grammarRule': 'Vorfeld: beliebiges Satzglied + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-009',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Perfekt und Satzklammer ist korrekt?',
    'options': [
      'Er hat das Buch gestern gelesen.',
      'Er hat gelesen das Buch gestern.',
      'Er gestern hat das Buch gelesen.',
      'Er das Buch hat gestern gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Satzklammer im Perfekt: \'hat\' auf Pos. 2, \'gelesen\' am Ende.',
    'grammarRule': 'Perfekt: haben/sein (Pos. 2) + Mittelfeld + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-010',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht nach einem vorangestellten wenn-Satz?',
    'options': [
      'Das Subjekt',
      'Das Verb des Hauptsatzes',
      'Eine Konjunktion',
      'Ein Adverb'
    ],
    'correctAnswer': 1,
    'explanation': 'Der Nebensatz nimmt Pos. 1 ein, danach kommt direkt das Verb auf Pos. 2.',
    'exampleSentence': 'Wenn es schneit, bleiben wir zu Hause.',
    'grammarRule': 'Nebensatz im Vorfeld + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-011',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Stellung von \'nicht\' bei Satznegation?',
    'options': [
      'Er nicht geht heute ins Kino.',
      'Er geht nicht heute ins Kino.',
      'Er geht heute nicht ins Kino.',
      'Nicht er geht heute ins Kino.'
    ],
    'correctAnswer': 2,
    'explanation': 'Bei Satznegation steht \'nicht\' moeglichst weit rechts, hier vor der Richtungsangabe.',
    'grammarRule': 'Satznegation: nicht vor der lokalen/direktionalen Angabe',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-012',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'nicht\' im Satz mit Satzklammer (Perfekt)?',
    'options': [
      'Nach dem Partizip II',
      'Vor dem Partizip II',
      'Vor dem Hilfsverb',
      'Am Satzanfang'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nicht\' steht vor dem Partizip II: \'Er hat das Buch nicht gelesen.\'',
    'exampleSentence': 'Sie hat den Brief nicht geschrieben.',
    'grammarRule': 'Negation + Satzklammer: nicht vor dem Partizip/Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-013',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Konjunktion veraendert die Wortstellung NICHT?',
    'options': [
      'obwohl',
      'wenn',
      'oder',
      'damit'
    ],
    'correctAnswer': 2,
    'explanation': '\'Oder\' ist koordinierend und aendert die Wortstellung nicht.',
    'grammarRule': 'Koordinierende Konjunktionen (und, oder, aber, denn, sondern): Hauptsatz-Stellung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-014',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'denn\' ist korrekt?',
    'options': [
      'Er bleibt zu Hause, denn er krank ist.',
      'Er bleibt zu Hause, denn ist er krank.',
      'Er bleibt zu Hause, denn er ist krank.',
      'Er bleibt zu Hause, denn krank er ist.'
    ],
    'correctAnswer': 2,
    'explanation': 'Nach \'denn\' folgt normale Hauptsatz-Wortstellung.',
    'grammarRule': 'Denn: koordinierende Konjunktion, keine Wortstellungsaenderung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-015',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Modalverb im Nebensatz?',
    'options': [
      'Auf Position 2',
      'Vor dem Infinitiv am Ende',
      'Am Anfang des Nebensatzes',
      'Nach dem Infinitiv am Ende'
    ],
    'correctAnswer': 3,
    'explanation': 'Im Nebensatz steht der Infinitiv vor dem Modalverb am Ende.',
    'exampleSentence': '...weil er morgen arbeiten muss.',
    'grammarRule': 'Nebensatz + Modalverb: ... + Infinitiv + Modalverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-016',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die korrekte Reihenfolge Dativ vor Akkusativ?',
    'options': [
      'Er schenkt das Buch seiner Mutter.',
      'Er schenkt seiner Mutter das Buch.',
      'Er seiner Mutter schenkt das Buch.',
      'Er das Buch seiner Mutter schenkt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei zwei Nomen-Objekten: Dativ (seiner Mutter) vor Akkusativ (das Buch).',
    'grammarRule': 'Dativ vor Akkusativ (bei Nomen)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-017',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wie ist die Reihenfolge bei zwei Pronomen-Objekten?',
    'options': [
      'Dativ vor Akkusativ',
      'Akkusativ vor Dativ',
      'Beliebig',
      'Beide fallen weg'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei zwei Pronomen: Akkusativ vor Dativ: \'Er gibt es ihm.\'',
    'exampleSentence': 'Er gibt es ihr.',
    'grammarRule': 'Zwei Pronomen: Akkusativ vor Dativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-018',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit TeKaMoLo ist korrekt?',
    'options': [
      'Er faehrt in die Schule morgen mit dem Bus.',
      'Er faehrt morgen mit dem Bus in die Schule.',
      'Er faehrt mit dem Bus in die Schule morgen.',
      'Er faehrt in die Schule mit dem Bus morgen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Morgen (T) + mit dem Bus (M) + in die Schule (L) folgt TeKaMoLo.',
    'grammarRule': 'TeKaMoLo: Temporal + Modal + Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-019',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'waehrend\' hat die richtige Wortstellung?',
    'options': [
      'Waehrend er schlaeft, sie liest ein Buch.',
      'Waehrend er schlaeft, liest sie ein Buch.',
      'Waehrend schlaeft er, liest sie ein Buch.',
      'Waehrend er schlaeft, ein Buch sie liest.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Waehrend\' leitet einen Nebensatz ein (Verb am Ende); der Hauptsatz danach hat Inversion.',
    'grammarRule': 'Waehrend-Nebensatz + Hauptsatz mit Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-020',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Reflexivpronomen bei Inversion?',
    'options': [
      'Vor dem Verb',
      'Am Satzende',
      'Nach dem Subjekt',
      'Vor dem Subjekt, direkt nach dem Verb'
    ],
    'correctAnswer': 2,
    'explanation': 'Bei Inversion: Angabe + Verb + Subjekt + sich. Das Reflexivpronomen folgt dem Subjekt.',
    'exampleSentence': 'Heute freut er sich auf den Urlaub.',
    'grammarRule': 'Inversion + Reflexiv: Verb + Subjekt + sich',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-021',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Relativsatz ist korrekt?',
    'options': [
      'Die Frau, die kauft ein Buch, ist meine Nachbarin.',
      'Die Frau, die ein Buch kauft, ist meine Nachbarin.',
      'Die Frau, kauft die ein Buch, ist meine Nachbarin.',
      'Die Frau, ein Buch die kauft, ist meine Nachbarin.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Relativsatz steht das Verb am Ende.',
    'grammarRule': 'Relativsatz: Relativpronomen + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-022',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist eine korrekte W-Frage?',
    'options': [
      'Wohin du faehrst morgen?',
      'Wohin faehrst du morgen?',
      'Du faehrst wohin morgen?',
      'Faehrst wohin du morgen?'
    ],
    'correctAnswer': 1,
    'explanation': 'W-Frage: W-Wort (Pos. 1) + Verb (Pos. 2) + Subjekt + ...',
    'grammarRule': 'W-Frage: Fragewort + Verb + Subjekt',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-023',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Futur I ist korrekt?',
    'options': [
      'Ich werde morgen frueh aufstehen.',
      'Ich werde aufstehen morgen frueh.',
      'Ich morgen werde frueh aufstehen.',
      'Ich werde morgen aufstehen frueh.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: \'werde\' (Pos. 2), Infinitiv (\'aufstehen\') am Ende.',
    'grammarRule': 'Futur-I-Satzklammer: werden (Pos. 2) + Mittelfeld + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-024',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'bevor\' ist korrekt?',
    'options': [
      'Bevor er geht, er raeumt auf.',
      'Bevor er geht, raeumt er auf.',
      'Bevor geht er, raeumt er auf.',
      'Bevor er geht, auf raeumt er.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Bevor\' leitet Nebensatz ein (Verb am Ende); Hauptsatz danach hat Inversion.',
    'grammarRule': 'Bevor-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-025',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb und Satzklammer ist korrekt?',
    'options': [
      'Sie muss heute laenger im Buero arbeiten.',
      'Sie muss arbeiten heute laenger im Buero.',
      'Sie heute muss laenger im Buero arbeiten.',
      'Sie muss heute im Buero arbeiten laenger.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb (Pos. 2) + Mittelfeld + Infinitiv (Ende).',
    'grammarRule': 'Modalverb-Satzklammer: Modalverb (Pos. 2) + ... + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-026',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert nach \'deswegen\' mit der Wortstellung?',
    'options': [
      'Verb am Ende',
      'Keine Aenderung',
      'Inversion (Verb auf Pos. 2, Subjekt Pos. 3)',
      'Verb auf Position 1'
    ],
    'correctAnswer': 2,
    'explanation': '\'Deswegen\' ist ein Konjunktionaladverb und erzwingt Inversion.',
    'exampleSentence': 'Er war muede. Deswegen ging er frueh ins Bett.',
    'grammarRule': 'Konjunktionaladverbien: Inversion im Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-027',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'sondern\' ist korrekt?',
    'options': [
      'Er trinkt nicht Kaffee, sondern er Tee trinkt.',
      'Er trinkt nicht Kaffee, sondern trinkt er Tee.',
      'Er trinkt nicht Kaffee, sondern Tee.',
      'Er trinkt nicht Kaffee, sondern Tee er trinkt.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Sondern\' ist koordinierend; bei gleichem Verb kann der Rest parallel stehen.',
    'grammarRule': 'Sondern: koordinierende Konjunktion, Hauptsatz-Stellung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-028',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'gern\' im Satz mit Satzklammer?',
    'options': [
      'Am Satzende nach dem Infinitiv',
      'Im Mittelfeld zwischen Verb und Infinitiv',
      'Vor dem Verb auf Position 2',
      'Direkt nach dem Subjekt'
    ],
    'correctAnswer': 1,
    'explanation': '\'Gern\' als Modalangabe steht im Mittelfeld der Satzklammer.',
    'exampleSentence': 'Er moechte gern ein Buch lesen.',
    'grammarRule': 'Angaben im Mittelfeld der Satzklammer',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-029',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'als\' (temporal) ist korrekt?',
    'options': [
      'Als er ankam, wir gingen nach Hause.',
      'Als er ankam, gingen wir nach Hause.',
      'Als ankam er, gingen wir nach Hause.',
      'Als er ankam, nach Hause gingen wir.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Als\'-Nebensatz im Vorfeld + Hauptsatz mit Inversion.',
    'grammarRule': 'Als-Nebensatz + Verb + Subjekt im Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-030',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Imperativsatz ist korrekt (ihr-Form)?',
    'options': [
      'Ihr geht bitte nach Hause!',
      'Geht bitte nach Hause!',
      'Bitte ihr geht nach Hause!',
      'Nach Hause geht bitte!'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Imperativ (ihr-Form) steht das Verb auf Position 1; \'ihr\' wird weggelassen.',
    'grammarRule': 'Imperativ ihr-Form: Verb (Pos. 1) + Rest',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'imperativ']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-032',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit indirekter Frage ist korrekt?',
    'options': [
      'Ich weiss nicht, wann kommt der Zug.',
      'Ich weiss nicht, wann der Zug kommt.',
      'Ich weiss nicht, der Zug wann kommt.',
      'Ich weiss nicht, kommt wann der Zug.'
    ],
    'correctAnswer': 1,
    'explanation': 'Indirekte Fragen sind Nebensaetze: Fragewort + ... + Verb (Ende).',
    'grammarRule': 'Indirekte Frage: W-Wort + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-033',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'um ... zu\' ist korrekt?',
    'options': [
      'Er lernt Deutsch, um zu finden einen Job.',
      'Er lernt Deutsch, um einen Job zu finden.',
      'Er lernt Deutsch, um einen Job finden zu.',
      'Er lernt Deutsch, zu um einen Job finden.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz mit um...zu: um + Mittelfeld + zu + Infinitiv (Ende).',
    'grammarRule': 'Infinitivsatz: um + ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-034',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'nachdem\' hat die richtige Wortstellung?',
    'options': [
      'Nachdem er gegessen hatte, ging er spazieren.',
      'Nachdem er hatte gegessen, ging er spazieren.',
      'Nachdem hatte er gegessen, ging er spazieren.',
      'Nachdem gegessen er hatte, ging er spazieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im nachdem-Nebensatz: Partizip + Hilfsverb am Ende.',
    'grammarRule': 'Nebensatz mit nachdem: ... + Partizip II + Hilfsverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-035',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung mit \'immer\'?',
    'options': [
      'Immer er kommt zu spaet.',
      'Er immer kommt zu spaet.',
      'Er kommt immer zu spaet.',
      'Er kommt zu spaet immer.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Immer\' als Temporaladverb steht typisch im Mittelfeld nach dem Verb.',
    'grammarRule': 'Haeufigkeitsadverbien: im Mittelfeld nach dem finiten Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-036',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert bei Inversion, wenn das Subjekt ein Pronomen ist?',
    'options': [
      'Das Pronomen steht am Ende.',
      'Das Pronomen steht direkt nach dem Verb.',
      'Das Pronomen faellt weg.',
      'Das Pronomen steht vor dem Verb.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Inversion rueckt das Subjekt-Pronomen direkt hinter das Verb auf Pos. 3.',
    'exampleSentence': 'Morgen fahre ich nach Berlin.',
    'grammarRule': 'Inversion: Angabe + Verb + Pronomen-Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-037',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'obwohl\' ist korrekt?',
    'options': [
      'Obwohl es regnet, er geht spazieren.',
      'Obwohl regnet es, geht er spazieren.',
      'Obwohl es regnet, geht er spazieren.',
      'Obwohl es regnet, spazieren geht er.'
    ],
    'correctAnswer': 2,
    'explanation': 'Obwohl-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'grammarRule': 'Obwohl-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-038',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die korrekte Stellung des Pronomens \'es\' als Akkusativobjekt?',
    'options': [
      'Er hat seiner Mutter es geschenkt.',
      'Er hat es seiner Mutter geschenkt.',
      'Er hat geschenkt es seiner Mutter.',
      'Er es hat seiner Mutter geschenkt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Pronomen-Akkusativ steht vor Nomen-Dativ: es vor seiner Mutter.',
    'grammarRule': 'Pronomen-Akk. vor Nomen-Dativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-039',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Nebensatz mit \'bis\' ist korrekt?',
    'options': [
      'Warte, bis er kommt.',
      'Warte, bis kommt er.',
      'Warte, bis er kommt hier.',
      'Warte, bis kommt hier er.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bis\' leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz mit bis: bis + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-040',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist das Vorfeld?',
    'options': [
      'Der Bereich nach dem Verb',
      'Der Bereich vor dem finiten Verb (Position 1)',
      'Der letzte Platz im Satz',
      'Der Bereich zwischen zwei Verben'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Vorfeld ist Position 1 im Hauptsatz, vor dem finiten Verb.',
    'grammarRule': 'Vorfeld = Position 1 (vor dem Verb)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'vorfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-041',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'dass\' und Perfekt ist korrekt?',
    'options': [
      'Ich glaube, dass er hat das Buch gelesen.',
      'Ich glaube, dass er das Buch gelesen hat.',
      'Ich glaube, dass hat er das Buch gelesen.',
      'Ich glaube, dass er das Buch hat gelesen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im dass-Nebensatz: Partizip II + Hilfsverb ganz am Ende.',
    'grammarRule': 'Nebensatz + Perfekt: ... + Partizip II + Hilfsverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-042',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit zwei Angaben folgt TeKaMoLo korrekt?',
    'options': [
      'Er arbeitet im Buero jeden Tag.',
      'Er arbeitet jeden Tag im Buero.',
      'Im Buero jeden Tag arbeitet er.',
      'Jeden Tag er arbeitet im Buero.'
    ],
    'correctAnswer': 1,
    'explanation': 'Jeden Tag (Temporal) vor im Buero (Lokal) = T vor L.',
    'grammarRule': 'TeKaMoLo: Temporal vor Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-043',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit trennbarem Verb im Nebensatz ist korrekt?',
    'options': [
      '...weil er morgen an ruft.',
      '...weil er morgen ruft an.',
      '...weil er morgen anruft.',
      '...weil er an morgen ruft.'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz wird das trennbare Verb wieder zusammengeschrieben und steht am Ende.',
    'grammarRule': 'Trennbares Verb im Nebensatz: zusammen am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-044',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'nur\' als Fokuspartikel?',
    'options': [
      'Immer am Satzende',
      'Immer am Satzanfang',
      'Vor dem Wort, das es betont',
      'Nach dem Partizip II'
    ],
    'correctAnswer': 2,
    'explanation': '\'Nur\' steht vor dem Satzglied, das es fokussiert: \'Er liest nur Romane.\'',
    'exampleSentence': 'Er trinkt nur Wasser.',
    'grammarRule': 'Fokuspartikel vor dem fokussierten Element',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-045',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wie ist die Wortstellung mit \'entweder ... oder\'?',
    'options': [
      'Beide Teile haben Nebensatz-Stellung.',
      'Entweder steht im Vorfeld (Inversion), oder leitet Hauptsatz ein.',
      'Das Verb steht immer am Ende.',
      'Beide Teile haben Verb auf Position 1.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Entweder\' kann im Vorfeld stehen (Inversion); \'oder\' leitet einen normalen Hauptsatz ein.',
    'exampleSentence': 'Entweder kommst du mit, oder du bleibst hier.',
    'grammarRule': 'Entweder (Vorfeld, Inversion) ... oder (Hauptsatz)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-046',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv hat die richtige Satzklammer?',
    'options': [
      'Das Buch gelesen wird von vielen Leuten.',
      'Das Buch wird gelesen von vielen Leuten.',
      'Das Buch wird von vielen Leuten gelesen.',
      'Von vielen Leuten das Buch wird gelesen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Passiv-Satzklammer: \'wird\' (Pos. 2) + Mittelfeld + Partizip II (Ende).',
    'grammarRule': 'Passiv: werden (Pos. 2) + ... + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-047',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'seitdem\' ist korrekt?',
    'options': [
      'Seitdem er ist in Berlin, lernt er Deutsch.',
      'Seitdem er in Berlin ist, lernt er Deutsch.',
      'Seitdem ist er in Berlin, lernt er Deutsch.',
      'Seitdem in Berlin er ist, lernt er Deutsch.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Seitdem\' leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz mit seitdem: seitdem + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-048',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die richtige Stellung von \'oft\'?',
    'options': [
      'Oft er geht ins Kino.',
      'Er oft geht ins Kino.',
      'Er geht ins Kino oft.',
      'Er geht oft ins Kino.'
    ],
    'correctAnswer': 3,
    'explanation': '\'Oft\' als Temporaladverb steht im Mittelfeld (vor der Richtungsangabe).',
    'grammarRule': 'Haeufigkeitsadverb \'oft\': im Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-049',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was kommt zuerst im Mittelfeld: Pronomen oder Nomen?',
    'options': [
      'Nomen vor Pronomen',
      'Pronomen vor Nomen',
      'Beliebige Reihenfolge',
      'Pronomen am Ende'
    ],
    'correctAnswer': 1,
    'explanation': 'Pronomen stehen im Mittelfeld vor Nomen.',
    'exampleSentence': 'Er hat es gestern seinem Freund gegeben.',
    'grammarRule': 'Mittelfeld: Pronomen vor Nomen',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-050',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Adjektiv als Praedikativ?',
    'options': [
      'Vor dem Verb',
      'Am Ende des Satzes (nach dem Verb sein/werden)',
      'Vor dem Subjekt',
      'Im Vorfeld'
    ],
    'correctAnswer': 1,
    'explanation': 'Das praedikative Adjektiv steht nach sein/werden am Satzende: \'Er ist muede.\'',
    'exampleSentence': 'Das Wetter ist schoen.',
    'grammarRule': 'Praedikatives Adjektiv: am Satzende nach sein/werden/bleiben',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'praedikativ']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-003',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt der Regel TeKaMoLo?',
    'options': [
      'Er faehrt in die Stadt morgen mit dem Rad.',
      'Er faehrt mit dem Rad morgen in die Stadt.',
      'Er faehrt morgen mit dem Rad in die Stadt.',
      'Er faehrt morgen in die Stadt mit dem Rad.'
    ],
    'correctAnswer': 2,
    'explanation': 'Morgen (Temporal) + mit dem Rad (Modal) + in die Stadt (Lokal) = TeKaMoLo.',
    'grammarRule': 'TeKaMoLo: Temporal -> Modal -> Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-149',
    'level': 'b1',
    'category': 'Satzbau',
    'subcategory': 'Verbposition',
    'question': 'Wo steht das Verb im deutschen Hauptsatz?',
    'options': ['Position 1', 'Position 2', 'Am Ende', 'Position 3'],
    'correctAnswer': 1,
    'explanation': 'Im Hauptsatz steht das konjugierte Verb auf Position 2.',
    'tags': ['satzbau']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p2-150',
    'level': 'b1',
    'category': 'Satzbau',
    'subcategory': 'Nebensatz',
    'question': 'Wo steht das Verb im Nebensatz?',
    'options': ['Position 1', 'Position 2', 'Am Ende', 'Position 3'],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz steht das konjugierte Verb am Ende.',
    'tags': ['satzbau']
  }
];

export default questions;
