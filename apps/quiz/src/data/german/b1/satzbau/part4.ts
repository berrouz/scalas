import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbau-p4-001',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das konjugierte Verb im deutschen Hauptsatz?',
    'options': ['Position 2', 'Position 1', 'am Ende', 'Position 3'],
    'correctAnswer': 0,
    'explanation': 'Im deutschen Hauptsatz steht das konjugierte Verb immer an Position 2 (V2-Regel).',
    'exampleSentence': 'Morgen fahre ich nach Berlin.',
    'grammarRule': 'Hauptsatz: Verb auf Position 2 (Verbzweitstellung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-005',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'weil\' ist korrekt?',
    'options': [
      'Er bleibt zu Hause, weil er ist krank.',
      'Er bleibt zu Hause, weil er krank ist.',
      'Er bleibt zu Hause, weil ist er krank.',
      'Er bleibt zu Hause, weil krank er ist.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Weil\' leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz mit weil: weil + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-006',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Verbstellung in einer W-Frage?',
    'options': [
      'Warum du kommst nicht?',
      'Warum kommst du nicht?',
      'Du warum kommst nicht?',
      'Kommst warum du nicht?'
    ],
    'correctAnswer': 1,
    'explanation': 'W-Frage: Fragewort (Pos. 1) + Verb (Pos. 2) + Subjekt.',
    'grammarRule': 'W-Frage: W-Wort + Verb + Subjekt + ...',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'fragesatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-007',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert im Hauptsatz nach einem weil-Nebensatz im Vorfeld?',
    'options': [
      'Normale Wortstellung',
      'Verb am Ende',
      'Inversion: Verb + Subjekt',
      'Kein Hauptsatz noetig'
    ],
    'correctAnswer': 2,
    'explanation': 'Nebensatz im Vorfeld: Der Hauptsatz beginnt mit dem Verb (Inversion).',
    'exampleSentence': 'Weil er krank ist, bleibt er zu Hause.',
    'grammarRule': 'Nebensatz im Vorfeld + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-008',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Satzklammer mit Perfekt?',
    'options': [
      'Sie hat gestern einen Kuchen gebacken.',
      'Sie hat gebacken gestern einen Kuchen.',
      'Sie gestern hat einen Kuchen gebacken.',
      'Sie einen Kuchen hat gestern gebacken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt-Satzklammer: \'hat\' (Pos. 2) + Mittelfeld + \'gebacken\' (Ende).',
    'grammarRule': 'Perfekt: haben/sein (Pos. 2) + ... + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-009',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Konjunktion aendert die Wortstellung NICHT?',
    'options': [
      'dass',
      'obwohl',
      'und',
      'damit'
    ],
    'correctAnswer': 2,
    'explanation': '\'Und\' ist koordinierend und aendert die Wortstellung nicht.',
    'grammarRule': 'Koordinierende Konjunktionen: und, oder, aber, denn, sondern',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-010',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Relativsatz ist korrekt?',
    'options': [
      'Der Lehrer, der unterrichtet Deutsch, ist nett.',
      'Der Lehrer, der Deutsch unterrichtet, ist nett.',
      'Der Lehrer, unterrichtet der Deutsch, ist nett.',
      'Der Lehrer, Deutsch der unterrichtet, ist nett.'
    ],
    'correctAnswer': 1,
    'explanation': 'Relativsatz = Nebensatz; das Verb steht am Ende.',
    'grammarRule': 'Relativsatz: Relativpronomen + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-011',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'nicht\' im Satz \'Er faehrt ___ nach Berlin\'?',
    'options': [
      'Er faehrt nach Berlin nicht.',
      'Er nicht faehrt nach Berlin.',
      'Er faehrt nicht nach Berlin.',
      'Nicht er faehrt nach Berlin.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Nicht\' steht vor der Richtungsangabe (Satznegation).',
    'grammarRule': 'Satznegation: nicht vor Richtungsangabe/Praedikativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-012',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt TeKaMoLo korrekt?',
    'options': [
      'Sie geht mit der Freundin morgen ins Kino.',
      'Sie geht morgen mit der Freundin ins Kino.',
      'Sie geht ins Kino morgen mit der Freundin.',
      'Sie geht ins Kino mit der Freundin morgen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Morgen (T) + mit der Freundin (M) + ins Kino (L) = TeKaMoLo.',
    'grammarRule': 'TeKaMoLo: Temporal + Modal + Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-013',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'deshalb\' zeigt korrekte Inversion?',
    'options': [
      'Er ist muede. Deshalb er geht ins Bett.',
      'Er ist muede. Deshalb ins Bett er geht.',
      'Er ist muede. Deshalb geht er ins Bett.',
      'Er ist muede. Er deshalb geht ins Bett.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Deshalb\' im Vorfeld: Verb auf Pos. 2, Subjekt auf Pos. 3.',
    'grammarRule': 'Deshalb (Vorfeld): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-014',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher indirekte Fragesatz ist korrekt?',
    'options': [
      'Weisst du, wo wohnt er?',
      'Weisst du, wo er wohnt?',
      'Weisst du, er wo wohnt?',
      'Weisst du, wohnt wo er?'
    ],
    'correctAnswer': 1,
    'explanation': 'Indirekter Fragesatz: W-Wort + Subjekt + ... + Verb (Ende).',
    'grammarRule': 'Indirekter Fragesatz = Nebensatz: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-015',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb und Satzklammer ist korrekt?',
    'options': [
      'Er will morgen frueh aufstehen.',
      'Er will aufstehen morgen frueh.',
      'Er morgen will frueh aufstehen.',
      'Er will morgen aufstehen frueh.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb (Pos. 2) + Mittelfeld + Infinitiv (Ende).',
    'grammarRule': 'Satzklammer: Modalverb (Pos. 2) + ... + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-016',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht im Vorfeld eines Hauptsatzes?',
    'options': [
      'Nur das Subjekt',
      'Nur Adverbien',
      'Genau ein Satzglied (beliebig)',
      'Immer das Verb'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Vorfeld steht genau ein Satzglied: Subjekt, Objekt, Adverbial oder Nebensatz.',
    'grammarRule': 'Vorfeld: genau ein Satzglied',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'vorfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-017',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'ob\' ist korrekt?',
    'options': [
      'Ich weiss nicht, ob er kommt morgen.',
      'Ich weiss nicht, ob kommt er morgen.',
      'Ich weiss nicht, ob er morgen kommt.',
      'Ich weiss nicht, ob morgen er kommt.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Ob\' leitet indirekten Fragesatz ein; Verb am Ende.',
    'grammarRule': 'Indirekter Fragesatz mit ob: ob + Subjekt + ... + Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-018',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Reflexivpronomen im Hauptsatz?',
    'options': [
      'Am Satzende',
      'Vor dem Verb',
      'Nach dem Subjekt, nah am Verb',
      'Auf Position 1'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Reflexivpronomen steht moeglichst nah am Verb, nach dem Subjekt.',
    'exampleSentence': 'Er waescht sich die Haende.',
    'grammarRule': 'Reflexivpronomen: nach dem Subjekt',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-019',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'um ... zu\' ist korrekt?',
    'options': [
      'Er lernt Deutsch, um in Deutschland zu arbeiten.',
      'Er lernt Deutsch, um zu arbeiten in Deutschland.',
      'Er lernt Deutsch, um in Deutschland arbeiten zu.',
      'Er lernt Deutsch, zu um in Deutschland arbeiten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz: um + Mittelfeld + zu + Infinitiv (Ende).',
    'grammarRule': 'um ... zu: um + ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-020',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv ist korrekt?',
    'options': [
      'Das Haus wird von Arbeitern gebaut.',
      'Das Haus wird gebaut von Arbeitern.',
      'Das Haus gebaut wird von Arbeitern.',
      'Von Arbeitern das Haus wird gebaut.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv: \'wird\' (Pos. 2) + Mittelfeld + Partizip II (Ende).',
    'grammarRule': 'Passiv-Satzklammer: werden (Pos. 2) + ... + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-022',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'als\' (Vergleich) ist korrekt?',
    'options': [
      'Er ist als sein Bruder groesser.',
      'Er ist groesser als sein Bruder.',
      'Groesser als sein Bruder er ist.',
      'Er groesser ist als sein Bruder.'
    ],
    'correctAnswer': 1,
    'explanation': 'Vergleich mit \'als\' steht im Nachfeld: Adjektiv + als + Vergleichselement.',
    'grammarRule': 'Vergleich: Komparativ + als + Element (Nachfeld)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-023',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit trennbarem Verb im Nebensatz ist korrekt?',
    'options': [
      '...weil er jeden Tag um 6 Uhr steht auf.',
      '...weil er jeden Tag um 6 Uhr auf steht.',
      '...weil er jeden Tag um 6 Uhr aufsteht.',
      '...weil auf er jeden Tag um 6 Uhr steht.'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz wird das trennbare Verb wieder zusammengeschrieben am Ende.',
    'grammarRule': 'Trennbares Verb im Nebensatz: zusammen am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-024',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Dativ und Akkusativ ist korrekt?',
    'options': [
      'Er zeigt den Weg dem Touristen.',
      'Er zeigt dem Touristen den Weg.',
      'Er dem Touristen zeigt den Weg.',
      'Er den Weg dem Touristen zeigt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei zwei Nomen: Dativ vor Akkusativ.',
    'grammarRule': 'Nomen-Objekte: Dativ vor Akkusativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-025',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Futur I ist korrekt?',
    'options': [
      'Wir werden naechstes Jahr nach Spanien fliegen.',
      'Wir werden fliegen naechstes Jahr nach Spanien.',
      'Wir naechstes Jahr werden nach Spanien fliegen.',
      'Wir werden naechstes Jahr fliegen nach Spanien.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: \'werden\' (Pos. 2) + Mittelfeld + Infinitiv (Ende).',
    'grammarRule': 'Futur-I-Satzklammer: werden (Pos. 2) + ... + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-026',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist \'TeKaMoLo\'?',
    'options': [
      'Eine Verbkonjugation',
      'Die Reihenfolge der Angaben im Mittelfeld',
      'Eine Konjunktion',
      'Ein Satztyp'
    ],
    'correctAnswer': 1,
    'explanation': 'TeKaMoLo beschreibt die Reihenfolge: Temporal, Kausal, Modal, Lokal im Mittelfeld.',
    'grammarRule': 'TeKaMoLo = Temporal + Kausal + Modal + Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-027',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'obwohl\' hat korrekte Wortstellung?',
    'options': [
      'Er geht spazieren, obwohl es stark regnet.',
      'Er geht spazieren, obwohl es regnet stark.',
      'Er geht spazieren, obwohl regnet es stark.',
      'Er geht spazieren, obwohl stark es regnet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Obwohl-Nebensatz: Subjekt + Mittelfeld + Verb am Ende.',
    'grammarRule': 'Nebensatz mit obwohl: obwohl + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-029',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'falls\' ist korrekt?',
    'options': [
      'Falls es morgen regnet, wir bleiben zu Hause.',
      'Falls es morgen regnet, bleiben wir zu Hause.',
      'Falls regnet es morgen, bleiben wir zu Hause.',
      'Falls es morgen regnet, zu Hause bleiben wir.'
    ],
    'correctAnswer': 1,
    'explanation': 'Falls-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'grammarRule': 'Falls-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-031',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'seit\' (Konjunktion) ist korrekt?',
    'options': [
      'Seit er wohnt in Berlin, spricht er besser Deutsch.',
      'Seit er in Berlin wohnt, spricht er besser Deutsch.',
      'Seit wohnt er in Berlin, spricht er besser Deutsch.',
      'Seit in Berlin er wohnt, spricht er besser Deutsch.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Seit\' leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz mit seit: seit + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-032',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Imperativsatz (Sie-Form) ist korrekt?',
    'options': [
      'Sie kommen bitte herein!',
      'Kommen Sie bitte herein!',
      'Bitte Sie kommen herein!',
      'Herein kommen Sie bitte!'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Imperativ (Sie-Form): Verb auf Pos. 1, dann \'Sie\'.',
    'grammarRule': 'Imperativ Sie-Form: Verb (Pos. 1) + Sie + Rest',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'imperativ']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-033',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'ohne ... zu\' ist korrekt?',
    'options': [
      'Er ging, ohne zu sagen etwas.',
      'Er ging, ohne etwas zu sagen.',
      'Er ging, ohne etwas sagen zu.',
      'Er ging, zu ohne etwas sagen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz: ohne + Objekt + zu + Infinitiv.',
    'grammarRule': 'ohne ... zu: ohne + ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-034',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'damit\' und Nebensatz ist korrekt?',
    'options': [
      'Er spricht langsam, damit sie kann ihn verstehen.',
      'Er spricht langsam, damit sie ihn verstehen kann.',
      'Er spricht langsam, damit kann sie ihn verstehen.',
      'Er spricht langsam, damit ihn sie verstehen kann.'
    ],
    'correctAnswer': 1,
    'explanation': 'Damit-Nebensatz: Infinitiv + Modalverb am Ende.',
    'grammarRule': 'Nebensatz mit damit: ... + Infinitiv + Modalverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-035',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht die Praepositionalergaenzung \'auf den Bus\' im Satz?',
    'options': [
      'Vor dem Verb',
      'Im Mittelfeld',
      'Vor dem Subjekt',
      'Am Satzanfang (obligatorisch)'
    ],
    'correctAnswer': 1,
    'explanation': 'Praepositionalergaenzungen stehen im Mittelfeld.',
    'exampleSentence': 'Er wartet auf den Bus.',
    'grammarRule': 'Praepositionalergaenzung: im Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-036',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung mit \'zwar ... aber\'?',
    'options': [
      'Er ist zwar muede, aber er arbeitet weiter.',
      'Zwar er ist muede, aber er arbeitet weiter.',
      'Er ist muede zwar, aber er arbeitet weiter.',
      'Er zwar ist muede, aber er arbeitet weiter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Zwar\' steht im Mittelfeld; \'aber\' leitet koordinierend den zweiten Hauptsatz ein.',
    'grammarRule': 'Zwar ... aber: zwar im Mittelfeld, aber koordinierend',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-037',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'weder ... noch\' ist korrekt?',
    'options': [
      'Er trinkt weder Kaffee noch Tee.',
      'Weder er trinkt Kaffee noch Tee.',
      'Er weder trinkt Kaffee noch Tee.',
      'Er trinkt Kaffee weder noch Tee.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Weder ... noch\' verbindet parallele Satzglieder.',
    'grammarRule': 'Weder ... noch: parallele Struktur',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-038',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Plusquamperfekt im Nebensatz ist korrekt?',
    'options': [
      '...weil er hatte das Buch schon gelesen.',
      '...weil er das Buch schon gelesen hatte.',
      '...weil er das Buch schon hatte gelesen.',
      '...weil hatte er das Buch schon gelesen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nebensatz + Plusquamperfekt: Partizip II + Hilfsverb \'hatte\' am Ende.',
    'grammarRule': 'Nebensatz + Plusquamperfekt: ... + Partizip II + hatte/war (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-039',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Inversion mit Ortsangabe?',
    'options': [
      'Im Garten die Kinder spielen.',
      'Im Garten spielen die Kinder.',
      'Spielen im Garten die Kinder.',
      'Die Kinder im Garten spielen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Ortsangabe im Vorfeld: Verb (Pos. 2) + Subjekt (Pos. 3).',
    'grammarRule': 'Ortsangabe (Vorfeld) + Verb + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-041',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'bevor\' ist korrekt?',
    'options': [
      'Bevor er geht schlafen, liest er ein Buch.',
      'Bevor er schlafen geht, liest er ein Buch.',
      'Bevor geht er schlafen, liest er ein Buch.',
      'Bevor schlafen er geht, liest er ein Buch.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bevor-Nebensatz: Infinitiv + finites Verb am Ende.',
    'grammarRule': 'Nebensatz mit bevor: ... + Infinitiv + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-042',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung von \'nur\' als Fokuspartikel?',
    'options': [
      'Er hat nur drei Buecher gelesen.',
      'Er hat drei Buecher nur gelesen.',
      'Nur er hat drei Buecher gelesen.',
      'Er nur hat drei Buecher gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Nur\' steht vor dem Element, das es fokussiert: hier \'drei Buecher\'.',
    'grammarRule': 'Fokuspartikel \'nur\': vor dem fokussierten Element',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-043',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz (zu + Infinitiv) ist korrekt?',
    'options': [
      'Er versucht, zu lernen Deutsch.',
      'Er versucht, Deutsch zu lernen.',
      'Er versucht, Deutsch lernen zu.',
      'Er versucht, zu Deutsch lernen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz: Objekt + zu + Infinitiv am Ende.',
    'grammarRule': 'Infinitivsatz: ... + zu + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-044',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'solange\' ist korrekt?',
    'options': [
      'Solange du bist hier, helfe ich dir.',
      'Solange du hier bist, helfe ich dir.',
      'Solange bist du hier, helfe ich dir.',
      'Solange hier du bist, helfe ich dir.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Solange\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit solange: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-045',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht im Mittelfeld zwischen den Verbteilen?',
    'options': [
      'Nur das Subjekt',
      'Nichts',
      'Objekte, Angaben, Ergaenzungen',
      'Nur Adverbien'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Mittelfeld stehen Objekte, Angaben (temporal, kausal, modal, lokal) und Ergaenzungen.',
    'grammarRule': 'Mittelfeld: Pronomen + Angaben + Objekte + Ergaenzungen',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-046',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'je ... desto\' ist korrekt?',
    'options': [
      'Je mehr du uebst, desto besser wirst du.',
      'Je du mehr uebst, desto besser wirst du.',
      'Je mehr du uebst, desto du wirst besser.',
      'Je mehr uebst du, desto besser wirst du.'
    ],
    'correctAnswer': 0,
    'explanation': 'Je-Satz (Verb am Ende) + desto + Komparativ + Verb + Subjekt.',
    'grammarRule': 'Je ... desto: Nebensatz + Hauptsatz mit Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-047',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'indem\' ist korrekt?',
    'options': [
      'Er lernt Deutsch, indem er liest viele Buecher.',
      'Er lernt Deutsch, indem er viele Buecher liest.',
      'Er lernt Deutsch, indem liest er viele Buecher.',
      'Er lernt Deutsch, indem viele Buecher er liest.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Indem\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit indem: indem + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-049',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Konjunktiv II hat die richtige Satzklammer?',
    'options': [
      'Er wuerde gern nach Paris fliegen.',
      'Er wuerde fliegen gern nach Paris.',
      'Er gern wuerde nach Paris fliegen.',
      'Er wuerde nach Paris fliegen gern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II mit wuerde: \'wuerde\' (Pos. 2) + Mittelfeld + Infinitiv (Ende).',
    'grammarRule': 'Konjunktiv II: wuerde (Pos. 2) + ... + Infinitiv (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-050',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'so ... dass\' ist korrekt?',
    'options': [
      'Er war so muede, dass er sofort einschlief.',
      'Er war so muede, dass er einschlief sofort.',
      'Er war so muede, dass sofort er einschlief.',
      'Er war so muede, dass einschlief er sofort.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Dass\' leitet Nebensatz ein; Verb am Ende. Trennbares Verb zusammen am Ende.',
    'grammarRule': 'Nebensatz mit dass: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p4-003',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt der Regel TeKaMoLo?',
    'options': [
      'Er hat in der Bibliothek gestern fleissig gelernt.',
      'Er hat gestern fleissig in der Bibliothek gelernt.',
      'Er hat fleissig gestern in der Bibliothek gelernt.',
      'Er hat in der Bibliothek fleissig gestern gelernt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Gestern (Temporal) + fleissig (Modal) + in der Bibliothek (Lokal) = TeKaMoLo.',
    'grammarRule': 'TeKaMoLo: Temporal -> Modal -> Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  }
];

export default questions;
