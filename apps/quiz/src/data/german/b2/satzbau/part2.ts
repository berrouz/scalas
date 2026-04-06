import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzbau-p2-001',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht das konjugierte Verb im deutschen Hauptsatz?',
    'options': ['Position 3', 'Position 2', 'Position 1', 'am Ende'],
    'correctAnswer': 1,
    'explanation': 'Im deutschen Hauptsatz steht das konjugierte Verb immer an Position 2.',
    'grammarRule': 'Hauptsatz: Verb auf Position 2 (Verbzweitstellung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-004',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht der trennbare Verbteil im Hauptsatz?',
    'options': ['auf Position 1', 'am Ende des Satzes', 'vor dem Subjekt', 'auf Position 2'],
    'correctAnswer': 1,
    'explanation': 'Der trennbare Verbteil steht am Satzende (Satzklammer).',
    'grammarRule': 'Satzklammer: Verb (Pos. 2) ... Praefix (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-005',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit komplexem Vorfeld ist korrekt?',
    'options': [
      'Dass er kommt hat mich ueberrascht.',
      'Dass er kommt, hat mich ueberrascht.',
      'Hat mich ueberrascht, dass er kommt.',
      'Mich hat ueberrascht, dass er kommt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Ein Nebensatz kann das Vorfeld besetzen; danach Verb auf Pos. 2.',
    'grammarRule': 'Nebensatz im Vorfeld + Verb (Pos. 2)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-006',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizipialgruppe ist korrekt?',
    'options': [
      'Von der Reise erschoepft, legte er sich sofort hin.',
      'Erschoepft von der Reise legte er sich sofort hin.',
      'Er legte sich sofort hin, von der Reise erschoepft.',
      'Legte er sich sofort hin, von der Reise erschoepft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizipialgruppe im Vorfeld, durch Komma getrennt; Hauptsatz mit Inversion.',
    'grammarRule': 'Partizipialgruppe (Vorfeld) + Komma + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'partizipialgruppe']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-007',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'umso + Komparativ, als\' ist korrekt?',
    'options': [
      'Das Ergebnis war umso ueberraschender, als niemand damit gerechnet hatte.',
      'Das Ergebnis war umso ueberraschender, als niemand damit hatte gerechnet.',
      'Das Ergebnis war umso ueberraschender, als hatte niemand damit gerechnet.',
      'Umso ueberraschender das Ergebnis war, als niemand damit gerechnet hatte.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Umso + Komparativ, als\': der als-Satz ist ein Nebensatz (Verb am Ende).',
    'grammarRule': 'Umso + Komparativ + als-Nebensatz (Verb am Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-008',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist Scrambling im deutschen Mittelfeld?',
    'options': [
      'Umstellung von Satzgliedern im Mittelfeld zur Fokussierung',
      'Auslassung des Verbs',
      'Verschiebung des Verbs ans Ende',
      'Wiederholung des Subjekts'
    ],
    'correctAnswer': 0,
    'explanation': 'Scrambling: Umstellung der normalen Reihenfolge im Mittelfeld fuer Fokus/Topik-Zwecke.',
    'grammarRule': 'Scrambling: freie Umstellung im Mittelfeld (pragmatisch motiviert)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-009',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'falls\' und Konjunktiv ist korrekt?',
    'options': [
      'Falls er kaeme, wuerden wir uns freuen.',
      'Falls er kaeme, wir wuerden uns freuen.',
      'Falls kaeme er, wuerden wir uns freuen.',
      'Falls er kaeme, uns wuerden wir freuen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Falls-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'grammarRule': 'Falls-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-010',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit dreifachem Verbkomplex im Nebensatz ist korrekt?',
    'options': [
      '...weil das Haus haette renoviert werden muessen.',
      '...weil das Haus renoviert worden sein muss.',
      '...weil das Haus muss renoviert worden sein.',
      '...weil renoviert das Haus worden sein muss.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz: Partizip + worden + sein + Modalverb am Ende.',
    'grammarRule': 'Komplexer Verbkomplex im Nebensatz: alle Verbteile am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-011',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Attributsatz (dass-Satz als Attribut) ist korrekt?',
    'options': [
      'Die Tatsache, dass er kommt, freut mich.',
      'Die Tatsache, dass kommt er, freut mich.',
      'Die Tatsache, dass er kommt freut mich.',
      'Dass er kommt die Tatsache freut mich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Attributiver dass-Satz steht nach dem Bezugsnomen; Verb am Ende.',
    'grammarRule': 'Attributsatz: Nomen + , dass + ... + Verb (Ende) + ,',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-012',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der V1-Stellung in Erzaehlungen?',
    'options': [
      'Das Verb steht immer am Ende.',
      'Das Verb steht auf Position 1 ohne Fragecharakter (narrativer Stil).',
      'Das Verb faellt weg.',
      'Zwei Verben stehen auf Position 1.'
    ],
    'correctAnswer': 1,
    'explanation': 'In Erzaehlungen kann V1-Stellung narrativ verwendet werden (ohne Frageintention).',
    'exampleSentence': 'Kommt da ploetzlich ein Mann um die Ecke.',
    'grammarRule': 'Narrative V1-Stellung: Verb (Pos. 1) + Erzaehlcharakter',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'v1-stellung']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-013',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wohingegen\' ist korrekt?',
    'options': [
      'Er arbeitet gern, wohingegen sie lieber liest.',
      'Er arbeitet gern, wohingegen sie liest lieber.',
      'Er arbeitet gern, wohingegen liest sie lieber.',
      'Er arbeitet gern, wohingegen lieber sie liest.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wohingegen\' leitet einen Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Wohingegen-Nebensatz: wohingegen + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-014',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'sei es ... sei es\' ist korrekt?',
    'options': [
      'Sei es Regen, sei es Sonnenschein, wir gehen wandern.',
      'Es sei Regen, es sei Sonnenschein, wir gehen wandern.',
      'Sei Regen es, sei Sonnenschein es, wir gehen wandern.',
      'Sei es Regen, Sonnenschein sei es, wir gehen wandern.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sei es ... sei es\' steht mit Verb (sei) auf Pos. 1 in beiden Teilen.',
    'grammarRule': 'Sei es ... sei es: Verb auf Pos. 1 (konzessive Bedeutung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-016',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Doppelkonjunktion \'sowohl ... als auch\' ist korrekt?',
    'options': [
      'Er spricht sowohl Deutsch als auch Englisch fliessend.',
      'Sowohl er spricht Deutsch als auch Englisch fliessend.',
      'Er sowohl spricht Deutsch als auch Englisch fliessend.',
      'Er spricht Deutsch sowohl als auch Englisch fliessend.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sowohl ... als auch\' verbindet parallele Satzglieder.',
    'grammarRule': 'Sowohl ... als auch: parallele Elemente',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-017',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit freiem Relativsatz (ohne Bezugswort) ist korrekt?',
    'options': [
      'Wer nicht hoeren will, muss fuehlen.',
      'Wer will nicht hoeren, muss fuehlen.',
      'Wer nicht hoeren will, fuehlen muss.',
      'Will wer nicht hoeren, muss fuehlen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Freier Relativsatz: Wer/Was + ... + Verb (Ende), + Hauptsatz mit Inversion.',
    'grammarRule': 'Freier Relativsatz: Wer/Was-Satz (Verb am Ende) + Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-018',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'infolgedessen\' ist korrekt?',
    'options': [
      'Es regnete stark. Infolgedessen der Fluss stieg.',
      'Es regnete stark. Infolgedessen stieg der Fluss.',
      'Es regnete stark. Der Fluss infolgedessen stieg.',
      'Es regnete stark. Stieg infolgedessen der Fluss.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Infolgedessen\' im Vorfeld: Inversion (Verb + Subjekt).',
    'grammarRule': 'Infolgedessen (Vorfeld): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-019',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Futur II hat die richtige Satzklammer?',
    'options': [
      'Er wird das Buch bis morgen gelesen haben.',
      'Er wird gelesen haben das Buch bis morgen.',
      'Er wird das Buch bis morgen haben gelesen.',
      'Er das Buch wird bis morgen gelesen haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur II: \'wird\' (Pos. 2) + Mittelfeld + Partizip II + haben/sein.',
    'grammarRule': 'Futur II: werden + ... + Partizip II + haben/sein (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-020',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'sofern\' ist korrekt?',
    'options': [
      'Sofern er kommt, koennen wir anfangen.',
      'Sofern er kommt, wir koennen anfangen.',
      'Sofern kommt er, koennen wir anfangen.',
      'Sofern er kommt, anfangen koennen wir.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sofern\' leitet Nebensatz ein (Verb am Ende); Hauptsatz mit Inversion.',
    'grammarRule': 'Sofern-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-021',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist ein Satzgefuege?',
    'options': [
      'Zwei koordinierte Hauptsaetze',
      'Ein Hauptsatz mit einem oder mehreren Nebensaetzen',
      'Ein Satz ohne Verb',
      'Ein Imperativsatz'
    ],
    'correctAnswer': 1,
    'explanation': 'Ein Satzgefuege besteht aus einem Hauptsatz und mindestens einem Nebensatz.',
    'grammarRule': 'Satzgefuege = Hauptsatz + Nebensatz(e)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-022',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'angenommen\' (Konjunktion) ist korrekt?',
    'options': [
      'Angenommen, er kommt nicht, was machen wir dann?',
      'Angenommen, nicht er kommt, was machen wir dann?',
      'Angenommen, kommt er nicht, was machen wir dann?',
      'Angenommen, er nicht kommt, was machen wir dann?'
    ],
    'correctAnswer': 0,
    'explanation': '\'Angenommen\' als Konjunktion mit Hauptsatz-Wortstellung im Bedingungssatz.',
    'grammarRule': 'Angenommen + Hauptsatz-Stellung (Subjekt + Verb Pos. 2)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-023',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit praepositionalem Relativsatz ist korrekt?',
    'options': [
      'Das Thema, ueber das wir gesprochen haben, ist wichtig.',
      'Das Thema, ueber das haben wir gesprochen, ist wichtig.',
      'Das Thema, das ueber wir gesprochen haben, ist wichtig.',
      'Das Thema, ueber wir das gesprochen haben, ist wichtig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Praeposition + Relativpronomen leiten den Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Praep. Relativsatz: Praeposition + Relativpronomen + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-024',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'nichtsdestotrotz\' ist korrekt?',
    'options': [
      'Es regnete. Nichtsdestotrotz er ging spazieren.',
      'Es regnete. Nichtsdestotrotz ging er spazieren.',
      'Es regnete. Er nichtsdestotrotz ging spazieren.',
      'Es regnete. Ging nichtsdestotrotz er spazieren.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nichtsdestotrotz\' im Vorfeld: Inversion.',
    'grammarRule': 'Nichtsdestotrotz (Vorfeld): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-025',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'es\' als Korrelat fuer Infinitivsatz ist korrekt?',
    'options': [
      'Er findet es schwierig, Deutsch zu lernen.',
      'Er findet schwierig es, Deutsch zu lernen.',
      'Er es findet schwierig, Deutsch zu lernen.',
      'Es er findet schwierig, Deutsch zu lernen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Es\' als Korrelat steht nach dem Verb; Infinitivsatz im Nachfeld.',
    'grammarRule': 'Korrelat \'es\' + Praedikativ + , + Infinitivsatz',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-026',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv Plusquamperfekt ist korrekt?',
    'options': [
      'Das Haus war schon renoviert worden, bevor sie einzogen.',
      'Das Haus war schon worden renoviert, bevor sie einzogen.',
      'Das Haus schon renoviert war worden, bevor sie einzogen.',
      'Das Haus war renoviert schon worden, bevor sie einzogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Plusquamperfekt: war + Partizip II + worden.',
    'grammarRule': 'Passiv PQP: war + ... + Partizip II + worden',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-027',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Vorfeld und Thema?',
    'options': [
      'Es gibt keinen Unterschied.',
      'Das Vorfeld ist eine syntaktische Position; das Thema ist eine informationsstrukturelle Kategorie.',
      'Das Vorfeld steht am Ende.',
      'Das Thema steht immer am Ende.'
    ],
    'correctAnswer': 1,
    'explanation': 'Vorfeld = syntaktische Pos. 1. Thema = bekannte Information (oft, aber nicht immer im Vorfeld).',
    'grammarRule': 'Vorfeld (Syntax) vs. Thema (Informationsstruktur)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-028',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wie\' (modal) im Nebensatz ist korrekt?',
    'options': [
      'Er erzaehlte, wie er den Berg bestiegen hatte.',
      'Er erzaehlte, wie er hatte den Berg bestiegen.',
      'Er erzaehlte, wie hatte er den Berg bestiegen.',
      'Er erzaehlte, wie den Berg er bestiegen hatte.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wie\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Wie-Nebensatz: wie + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-029',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Konjunktiv I (indirekte Rede) hat die richtige Satzklammer?',
    'options': [
      'Er sagte, er habe das Buch gelesen.',
      'Er sagte, er habe gelesen das Buch.',
      'Er sagte, gelesen habe er das Buch.',
      'Er sagte, er das Buch gelesen habe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede (Hauptsatz-Stellung): habe (Pos. 2) + Mittelfeld + Partizip (Ende).',
    'grammarRule': 'Indirekte Rede ohne dass: Hauptsatz-Wortstellung mit Konjunktiv I',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-030',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'abgesehen davon, dass\' ist korrekt?',
    'options': [
      'Abgesehen davon, dass es regnet, ist das Wetter schoen.',
      'Abgesehen davon, dass regnet es, ist das Wetter schoen.',
      'Abgesehen davon, dass es regnet ist das Wetter schoen.',
      'Davon abgesehen, dass es regnet, schoen ist das Wetter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Abgesehen davon + dass-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'grammarRule': 'Abgesehen davon, dass + Nebensatz + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-032',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'je nachdem\' ist korrekt?',
    'options': [
      'Je nachdem, wie das Wetter ist, gehen wir wandern oder nicht.',
      'Je nachdem, wie ist das Wetter, gehen wir wandern oder nicht.',
      'Je nachdem, wie das Wetter ist gehen wir wandern oder nicht.',
      'Nachdem je, wie das Wetter ist, gehen wir wandern oder nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Je nachdem\' + Nebensatz (Verb am Ende) + Hauptsatz.',
    'grammarRule': 'Je nachdem + W-Frage/ob-Nebensatz (Verb am Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-033',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist ein Satzband (Satzreihe)?',
    'options': [
      'Ein Hauptsatz mit Nebensatz',
      'Zwei oder mehr Hauptsaetze, koordinierend verbunden',
      'Ein Nebensatz allein',
      'Ein Imperativsatz'
    ],
    'correctAnswer': 1,
    'explanation': 'Eine Satzreihe (Satzband) besteht aus koordinierten Hauptsaetzen.',
    'grammarRule': 'Satzreihe = Hauptsatz + und/oder/aber/... + Hauptsatz',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'satzreihe']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-034',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'was fuer ein\' als Ausruf ist korrekt?',
    'options': [
      'Was fuer ein schoener Tag ist das!',
      'Was fuer ein Tag schoener ist das!',
      'Was ist fuer ein schoener Tag das!',
      'Fuer was ein schoener Tag ist das!'
    ],
    'correctAnswer': 0,
    'explanation': 'Ausruf: \'Was fuer ein\' + Adjektiv + Nomen + Verb (Pos. 2).',
    'grammarRule': 'Ausrufsatz: Was fuer ein + Adj. + Nomen + Verb (Pos. 2)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'ausruf']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-035',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'statt dass\' ist korrekt?',
    'options': [
      'Statt dass er hilft, sitzt er nur herum.',
      'Statt dass hilft er, sitzt er nur herum.',
      'Statt dass er hilft sitzt er nur herum.',
      'Dass statt er hilft, sitzt er nur herum.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Statt dass\' leitet Nebensatz ein (Verb am Ende); Hauptsatz mit Inversion.',
    'grammarRule': 'Statt dass + Nebensatz + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-036',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Komparativsatz (\'als + Nebensatz\') ist korrekt?',
    'options': [
      'Er ist klueger, als ich dachte.',
      'Er ist klueger, als dachte ich.',
      'Er ist klueger, als ich es dachte.',
      'Er ist klueger, als dachte es ich.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als\' leitet hier einen Vergleichs-Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Komparativsatz: Komparativ + als + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-037',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'naemlich\' im Satz?',
    'options': [
      'Im Vorfeld',
      'Im Mittelfeld (nie im Vorfeld)',
      'Am Satzende',
      'Vor dem Verb'
    ],
    'correctAnswer': 1,
    'explanation': '\'Naemlich\' steht immer im Mittelfeld, nie im Vorfeld.',
    'exampleSentence': 'Er konnte naemlich nicht kommen.',
    'grammarRule': '\'Naemlich\': nur im Mittelfeld (nicht vorfeldsfaehig)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-038',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Relativsatz mit \'wo\' (lokal) ist korrekt?',
    'options': [
      'Die Stadt, wo er wohnt, ist gross.',
      'Die Stadt, wo wohnt er, ist gross.',
      'Die Stadt, wo er wohnt ist gross.',
      'Wo er wohnt die Stadt, ist gross.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wo\' als Relativadverb leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Relativsatz mit wo: wo + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-039',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz nach Adjektiv ist korrekt?',
    'options': [
      'Es ist leicht, diese Aufgabe zu loesen.',
      'Es ist leicht, zu loesen diese Aufgabe.',
      'Es ist leicht, diese Aufgabe loesen zu.',
      'Es ist leicht, zu diese Aufgabe loesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz: Objekt + zu + Infinitiv am Ende.',
    'grammarRule': 'Infinitivsatz nach Adjektiv: ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-040',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist ein weiterführender Nebensatz?',
    'options': [
      'Ein Nebensatz, der die Hauptaussage einschraenkt',
      'Ein Nebensatz, der sich auf den ganzen vorherigen Satz bezieht',
      'Ein Nebensatz am Satzanfang',
      'Ein Nebensatz ohne Verb'
    ],
    'correctAnswer': 1,
    'explanation': 'Weiterfuehrende Nebensaetze (mit was, wobei, weshalb) beziehen sich auf den ganzen Hauptsatz.',
    'exampleSentence': 'Er gewann die Wahl, was niemand erwartet hatte.',
    'grammarRule': 'Weiterfuehrender NS: bezieht sich auf den ganzen Hauptsatz',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-041',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'desto + Komparativ\' im Hauptsatz ist korrekt?',
    'options': [
      'Je mehr ich lerne, desto besser verstehe ich es.',
      'Je mehr ich lerne, desto ich es besser verstehe.',
      'Je mehr ich lerne, desto verstehe besser ich es.',
      'Je ich mehr lerne, desto besser verstehe ich es.'
    ],
    'correctAnswer': 0,
    'explanation': 'Desto-Hauptsatz: desto + Komparativ + Verb + Subjekt (Inversion).',
    'grammarRule': 'Desto + Komparativ + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-042',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'vorausgesetzt, dass\' ist korrekt?',
    'options': [
      'Vorausgesetzt, dass er kommt, koennen wir anfangen.',
      'Vorausgesetzt, dass kommt er, koennen wir anfangen.',
      'Vorausgesetzt, dass er kommt koennen wir anfangen.',
      'Dass vorausgesetzt er kommt, koennen wir anfangen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Vorausgesetzt, dass\' leitet Bedingungssatz ein; Verb am Ende.',
    'grammarRule': 'Vorausgesetzt, dass + Nebensatz + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-043',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'dagegen\' als Konjunktionaladverb?',
    'options': [
      'Im Vorfeld (Inversion) oder im Mittelfeld',
      'Nur am Satzende',
      'Nur vor der Konjunktion',
      'Immer nach dem Partizip'
    ],
    'correctAnswer': 0,
    'explanation': '\'Dagegen\' als Konjunktionaladverb: Vorfeld (Inversion) oder Mittelfeld.',
    'exampleSentence': 'Er mag Kaffee. Sie dagegen trinkt lieber Tee.',
    'grammarRule': '\'Dagegen\': Vorfeld (Inversion) oder Mittelfeld',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-044',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'dessen ungeachtet\' ist korrekt?',
    'options': [
      'Es regnete stark. Dessen ungeachtet er ging spazieren.',
      'Es regnete stark. Dessen ungeachtet ging er spazieren.',
      'Es regnete stark. Er dessen ungeachtet ging spazieren.',
      'Dessen ungeachtet es regnete stark, ging er spazieren.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Dessen ungeachtet\' im Vorfeld: Inversion.',
    'grammarRule': 'Dessen ungeachtet (Vorfeld): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-045',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Subjektsatz als Nachfeld ist korrekt?',
    'options': [
      'Es ueberrascht mich, dass er gekommen ist.',
      'Es ueberrascht mich, dass er ist gekommen.',
      'Es ueberrascht mich, dass ist er gekommen.',
      'Dass er gekommen ist ueberrascht es mich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Korrelat \'es\' im Vorfeld + dass-Subjektsatz im Nachfeld (Verb am Ende).',
    'grammarRule': 'Es + Verb + Objekt + , dass-Subjektsatz (Verb am Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-046',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'ohne dass\' ist korrekt?',
    'options': [
      'Er ging, ohne dass er sich verabschiedet hatte.',
      'Er ging, ohne dass er hatte sich verabschiedet.',
      'Er ging, ohne dass hatte er sich verabschiedet.',
      'Er ging, ohne dass sich er verabschiedet hatte.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Ohne dass\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Ohne dass + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-047',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'es\' als expletivem Subjekt ist korrekt?',
    'options': [
      'Es wird hier viel gearbeitet.',
      'Hier wird es viel gearbeitet.',
      'Viel es wird hier gearbeitet.',
      'Gearbeitet wird es hier viel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Expletives \'es\' steht im Vorfeld als Platzhalter; faellt bei Inversion weg.',
    'grammarRule': 'Expletives es: Vorfeld-Platzhalter (faellt bei Inversion weg)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-048',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'selbst wenn\' ist korrekt?',
    'options': [
      'Selbst wenn es regnet, gehen wir wandern.',
      'Selbst wenn regnet es, gehen wir wandern.',
      'Selbst wenn es regnet gehen wir wandern.',
      'Wenn selbst es regnet, gehen wir wandern.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Selbst wenn\' leitet konzessiven Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Selbst wenn + Nebensatz (Verb am Ende) + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-049',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizip-II-Gruppe im Vorfeld ist korrekt?',
    'options': [
      'Ueberrascht von der Nachricht, rief er sofort an.',
      'Ueberrascht von der Nachricht rief er sofort an.',
      'Rief er sofort an, ueberrascht von der Nachricht.',
      'Er ueberrascht von der Nachricht rief sofort an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip-II-Gruppe im Vorfeld + Komma + Hauptsatz mit Inversion.',
    'grammarRule': 'Partizip-II-Gruppe (Vorfeld) + Komma + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'partizipialgruppe']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-050',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist der Fokus im deutschen Satz?',
    'options': [
      'Das erste Wort im Satz',
      'Die neue, wichtige Information, die oft durch Betonung hervorgehoben wird',
      'Das Verb',
      'Der Nebensatz'
    ],
    'correctAnswer': 1,
    'explanation': 'Der Fokus ist die neue/wichtige Information; im Deutschen oft durch Stellung und Betonung markiert.',
    'grammarRule': 'Fokus = neue/wichtige Info (Betonung, Stellung im Mittelfeld/Vorfeld)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-051',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welche Wortstellung ist im Satz mit \'kaum ... da\' korrekt?',
    'options': [
      'Kaum hatte er das Haus verlassen, da fing es an zu regnen.',
      'Kaum er hatte das Haus verlassen, da fing es an zu regnen.',
      'Kaum das Haus hatte er verlassen, da fing es an zu regnen.',
      'Kaum hatte er das Haus verlassen, da es fing an zu regnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaum\' mit Inversion im ersten Teil (Verb vor Subjekt), \'da\' leitet den Hauptsatz ein.',
    'grammarRule': 'Kaum + Inversion, da + Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'temporal']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-052',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Reflexivpronomen im Hauptsatz nach Inversion?',
    'options': [
      'Gestern hat er sich verletzt.',
      'Gestern hat sich er verletzt.',
      'Gestern sich hat er verletzt.',
      'Gestern hat er verletzt sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Inversion folgt das Reflexivpronomen direkt nach dem Subjekt: \'hat er sich\'.',
    'grammarRule': 'Reflexivpronomen: nach Subjekt im invertierten Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-053',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welche Stellung hat das Verb in einem mit \'je ... desto\' eingeleiteten Satz?',
    'options': [
      'je-Teil: Verb am Ende; desto-Teil: Verb auf Position 2',
      'je-Teil: Verb auf Position 2; desto-Teil: Verb am Ende',
      'beide Teile: Verb am Ende',
      'beide Teile: Verb auf Position 2'
    ],
    'correctAnswer': 0,
    'explanation': 'Im je-Teil steht das Verb am Ende (Nebensatzstellung), im desto-Teil auf Position 2 (Hauptsatzstellung).',
    'grammarRule': 'je + Nebensatz (VE), desto + Hauptsatz (V2)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'proportionalsatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p2-054',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die korrekte Ausklammerung?',
    'options': [
      'Er hat mehr gearbeitet als je zuvor.',
      'Er hat als je zuvor mehr gearbeitet.',
      'Er mehr hat gearbeitet als je zuvor.',
      'Er hat gearbeitet mehr als je zuvor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vergleiche mit \'als\' koennen hinter die Satzklammer treten (Ausklammerung).',
    'grammarRule': 'Ausklammerung: Vergleichsgruppe nach der rechten Satzklammer',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'ausklammerung']
  }
];

export default questions;
