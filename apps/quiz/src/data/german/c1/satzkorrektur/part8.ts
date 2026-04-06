import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Entsendung qualifizierter Fachkräfte wurde beschlossen.',
      'Die Entsendung qualifizierten Fachkräfte wurde beschlossen.',
      'Die Entsendung qualifizierte Fachkräfte wurde beschlossen.',
      'Die Entsendung qualifizierter Fachkräfte wurden beschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Entsendung + Genitiv Plural (qualifizierter Fachkräfte). Subjekt Singular → wurde.',
    'exampleSentence': 'Die Entsendung qualifizierter Fachkräfte wurde beschlossen.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der seit Langem erwartete Durchbruch ist gelungen.',
      'Der seit Langem erwarteten Durchbruch ist gelungen.',
      'Der seit Langem erwarteter Durchbruch ist gelungen.',
      'Der seit Langem erwartende Durchbruch ist gelungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: erwartete (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der seit Langem erwartete Durchbruch ist gelungen.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Anwalt erklärte, sein Mandant habe in Notwehr gehandelt.',
      'Der Anwalt erklärte, sein Mandant hat in Notwehr gehandelt.',
      'Der Anwalt erklärte, sein Mandant habe in Notwehr gehandelt hat.',
      'Der Anwalt erklärte, sein Mandant hätte in Notwehr gehandelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe gehandelt (indirekte Rede).',
    'exampleSentence': 'Der Anwalt erklärte, sein Mandant habe in Notwehr gehandelt.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Behauptung ist nicht haltbar.',
      'Die Behauptung ist nicht haltbare.',
      'Die Behauptung ist nicht zu haltbar.',
      'Die Behauptung ist nicht haltbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: haltbar (= kann gehalten/aufrechterhalten werden). Prädikativ.',
    'exampleSentence': 'Die Behauptung ist nicht haltbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sosehr man es sich auch wünschte, eine schnelle Lösung gab es nicht.',
      'Sosehr man es sich auch wünschte, gab es eine schnelle Lösung nicht.',
      'Sosehr man es wünschte sich auch, eine schnelle Lösung gab es nicht.',
      'Sosehr man es sich auch wünschte, eine schnelle Lösung es gab nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit sosehr: Verb am Ende des Nebensatzes, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Sosehr man es sich auch wünschte, eine schnelle Lösung gab es nicht.',
    'grammarRule': 'Satzgefüge: sosehr + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Gesetz wurde außer Kraft gesetzt.',
      'Das Gesetz wurde außer Kraft genommen.',
      'Das Gesetz wurde außer Kraft gebracht.',
      'Das Gesetz wurde außer Kraft gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas außer Kraft setzen (= ungültig machen).',
    'exampleSentence': 'Das Gesetz wurde außer Kraft gesetzt.',
    'grammarRule': 'Funktionsverbgefüge: außer Kraft setzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angesichts der drohenden Gefahr wurden Vorkehrungen getroffen.',
      'Angesichts den drohenden Gefahr wurden Vorkehrungen getroffen.',
      'Angesichts der drohenden Gefahr wurde Vorkehrungen getroffen.',
      'Angesichts die drohende Gefahr wurden Vorkehrungen getroffen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Angesichts verlangt den Genitiv: angesichts der drohenden Gefahr. Subjekt Plural → wurden.',
    'exampleSentence': 'Angesichts der drohenden Gefahr wurden Vorkehrungen getroffen.',
    'grammarRule': 'Präposition angesichts + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Umgekehrt gilt dasselbe für die andere Seite.',
      'Umgekehrt dasselbe gilt für die andere Seite.',
      'Umgekehrt gilt für die andere Seite dasselbe gilt.',
      'Umgekehrt für die andere Seite gilt dasselbe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach umgekehrt im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Umgekehrt gilt dasselbe für die andere Seite.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Geltendmachung der Ansprüche erfolgt durch den Anwalt.',
      'Die Geltendmachung den Ansprüchen erfolgt durch den Anwalt.',
      'Die Geltendmachung der Ansprüche erfolgen durch den Anwalt.',
      'Die Geltendmachung die Ansprüche erfolgt durch den Anwalt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Geltendmachung + Genitiv Plural (der Ansprüche). Subjekt Singular → erfolgt.',
    'exampleSentence': 'Die Geltendmachung der Ansprüche erfolgt durch den Anwalt.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die sich abzeichnende Tendenz gibt Anlass zur Sorge.',
      'Die sich abzeichnenden Tendenz gibt Anlass zur Sorge.',
      'Die sich abzeichnender Tendenz gibt Anlass zur Sorge.',
      'Die sich abgezeichnete Tendenz gibt Anlass zur Sorge.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: abzeichnende (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die sich abzeichnende Tendenz gibt Anlass zur Sorge.',
    'grammarRule': 'Erweitertes Partizip I mit Reflexivpronomen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut Experten sei die Lage ernst, aber nicht hoffnungslos.',
      'Laut Experten ist die Lage ernst, aber nicht hoffnungslos.',
      'Laut Experten sei die Lage ernst, aber nicht hoffnungslos ist.',
      'Laut Experten wäre die Lage ernst, aber nicht hoffnungslos.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: sei (3. Person Singular von sein).',
    'exampleSentence': 'Laut Experten sei die Lage ernst, aber nicht hoffnungslos.',
    'grammarRule': 'Konjunktiv I: sein → sei',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Regeln sind streng zu befolgen.',
      'Die Regeln sind streng befolgen zu.',
      'Die Regeln sind streng zu befolgt.',
      'Die Regeln sind streng befolgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind zu befolgen (= müssen befolgt werden).',
    'exampleSentence': 'Die Regeln sind streng zu befolgen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob man es nun gutheißt oder nicht, die Entwicklung lässt sich nicht aufhalten.',
      'Ob man es nun gutheißt oder nicht, lässt sich die Entwicklung nicht aufhalten.',
      'Ob man es nun gutheißt oder nicht, sich die Entwicklung nicht aufhalten lässt.',
      'Ob man es gutheißt nun oder nicht, die Entwicklung lässt sich nicht aufhalten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit ob ... oder nicht: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Ob man es nun gutheißt oder nicht, die Entwicklung lässt sich nicht aufhalten.',
    'grammarRule': 'Satzgefüge: ob ... oder nicht (konzessiv)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat großen Widerstand geleistet.',
      'Er hat großen Widerstand gemacht.',
      'Er hat großen Widerstand genommen.',
      'Er hat großen Widerstand gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Widerstand leisten (= sich widersetzen).',
    'exampleSentence': 'Er hat großen Widerstand geleistet.',
    'grammarRule': 'Funktionsverbgefüge: Widerstand leisten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kraft des ihm verliehenen Amtes handelte er entschlossen.',
      'Kraft dem ihm verliehenen Amt handelte er entschlossen.',
      'Kraft des ihm verliehenen Amt handelte er entschlossen.',
      'Kraft den ihm verliehenen Amtes handelte er entschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kraft verlangt den Genitiv: kraft des ihm verliehenen Amtes.',
    'exampleSentence': 'Kraft des ihm verliehenen Amtes handelte er entschlossen.',
    'grammarRule': 'Präposition kraft + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestoweniger bleibt die Grundaussage gültig.',
      'Nichtsdestoweniger die Grundaussage bleibt gültig.',
      'Nichtsdestoweniger bleibt gültig die Grundaussage.',
      'Nichtsdestoweniger gültig bleibt die Grundaussage.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach nichtsdestoweniger im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Nichtsdestoweniger bleibt die Grundaussage gültig.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Durchsetzung strengerer Regeln ist erforderlich.',
      'Die Durchsetzung strengere Regeln ist erforderlich.',
      'Die Durchsetzung strengeren Regeln ist erforderlich.',
      'Die Durchsetzung strengerer Regeln sind erforderlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Durchsetzung + Genitiv Plural (strengerer Regeln). Subjekt Singular → ist.',
    'exampleSentence': 'Die Durchsetzung strengerer Regeln ist erforderlich.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die im Nachhinein als fehlerhaft erkannten Daten wurden korrigiert.',
      'Die im Nachhinein als fehlerhaft erkannte Daten wurden korrigiert.',
      'Die im Nachhinein als fehlerhaft erkannter Daten wurden korrigiert.',
      'Die im Nachhinein als fehlerhaft erkennenden Daten wurden korrigiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: erkannten (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die im Nachhinein als fehlerhaft erkannten Daten wurden korrigiert.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er beteuerte, er habe die E-Mail nie erhalten.',
      'Er beteuerte, er hat die E-Mail nie erhalten.',
      'Er beteuerte, er habe die E-Mail nie erhalten hat.',
      'Er beteuerte, er hätte die E-Mail nie erhalten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe erhalten (indirekte Rede).',
    'exampleSentence': 'Er beteuerte, er habe die E-Mail nie erhalten.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ursache gilt es noch zu klären.',
      'Die Ursache gilt es noch klären.',
      'Die Ursache gilt es noch zu geklärt.',
      'Die Ursache gilt es noch geklärt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: es gilt + zu + Infinitiv: gilt es zu klären (= muss geklärt werden).',
    'exampleSentence': 'Die Ursache gilt es noch zu klären.',
    'grammarRule': 'Passiversatzform: es gilt + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mal abgesehen davon, dass er zu spät kam, war seine Arbeit gut.',
      'Mal abgesehen davon, dass er zu spät kam, seine Arbeit war gut.',
      'Mal abgesehen davon, dass er kam zu spät, war seine Arbeit gut.',
      'Mal abgesehen davon, dass er zu spät kam, war gut seine Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Einschränkungssatz mit mal abgesehen davon, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Mal abgesehen davon, dass er zu spät kam, war seine Arbeit gut.',
    'grammarRule': 'Satzgefüge: mal abgesehen davon, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Überlegungen wurden zum Ausdruck gebracht.',
      'Die Überlegungen wurden zum Ausdruck genommen.',
      'Die Überlegungen wurden zum Ausdruck gestellt.',
      'Die Überlegungen wurden zum Ausdruck gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zum Ausdruck bringen (= ausdrücken).',
    'exampleSentence': 'Die Überlegungen wurden zum Ausdruck gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Ausdruck bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abzüglich der bereits geleisteten Zahlungen verbleibt ein Restbetrag.',
      'Abzüglich den bereits geleisteten Zahlungen verbleibt ein Restbetrag.',
      'Abzüglich der bereits geleisteten Zahlung verbleibt ein Restbetrag.',
      'Abzüglich die bereits geleisteten Zahlungen verbleibt ein Restbetrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Abzüglich verlangt den Genitiv: abzüglich der bereits geleisteten Zahlungen.',
    'exampleSentence': 'Abzüglich der bereits geleisteten Zahlungen verbleibt ein Restbetrag.',
    'grammarRule': 'Präposition abzüglich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst wenn alle Voraussetzungen erfüllt sind, kann der Antrag bearbeitet werden.',
      'Erst wenn alle Voraussetzungen erfüllt sind, der Antrag kann bearbeitet werden.',
      'Erst wenn alle Voraussetzungen sind erfüllt, kann der Antrag bearbeitet werden.',
      'Erst wenn alle Voraussetzungen erfüllt sind, kann bearbeitet werden der Antrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporalsatz mit erst wenn: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Erst wenn alle Voraussetzungen erfüllt sind, kann der Antrag bearbeitet werden.',
    'grammarRule': 'Wortstellung: erst wenn + Temporalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Auswertung der gesammelten Daten dauert noch an.',
      'Die Auswertung den gesammelten Daten dauert noch an.',
      'Die Auswertung der gesammelten Daten dauern noch an.',
      'Die Auswertung die gesammelten Daten dauert noch an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Auswertung + Genitiv Plural (der gesammelten Daten). Subjekt Singular → dauert.',
    'exampleSentence': 'Die Auswertung der gesammelten Daten dauert noch an.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein nicht vorhersehbares Ereignis hat den Plan durchkreuzt.',
      'Ein nicht vorhersehbaren Ereignis hat den Plan durchkreuzt.',
      'Ein nicht vorhersehbarer Ereignis hat den Plan durchkreuzt.',
      'Ein nicht vorhersehbarem Ereignis hat den Plan durchkreuzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Adjektiv auf -bar: vorhersehbares (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein nicht vorhersehbares Ereignis hat den Plan durchkreuzt.',
    'grammarRule': 'Adjektiv auf -bar als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachrichtenagentur meldet, der Präsident habe seinen Rücktritt erklärt.',
      'Die Nachrichtenagentur meldet, der Präsident hat seinen Rücktritt erklärt.',
      'Die Nachrichtenagentur meldet, der Präsident habe seinen Rücktritt erklärt hat.',
      'Die Nachrichtenagentur meldet, der Präsident hätte seinen Rücktritt erklärt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe erklärt (indirekte Rede).',
    'exampleSentence': 'Die Nachrichtenagentur meldet, der Präsident habe seinen Rücktritt erklärt.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Antrag lässt sich online einreichen.',
      'Der Antrag lässt online sich einreichen.',
      'Der Antrag lässt sich online zu einreichen.',
      'Der Antrag lässt sich online eingereicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lässt sich einreichen (= kann eingereicht werden).',
    'exampleSentence': 'Der Antrag lässt sich online einreichen.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unabhängig davon, ob er kommt oder nicht, beginnen wir pünktlich.',
      'Unabhängig davon, ob er kommt oder nicht, pünktlich beginnen wir.',
      'Unabhängig davon, ob kommt er oder nicht, beginnen wir pünktlich.',
      'Unabhängig davon, ob er kommt oder nicht, beginnen pünktlich wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit unabhängig davon, ob: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Unabhängig davon, ob er kommt oder nicht, beginnen wir pünktlich.',
    'grammarRule': 'Satzgefüge: unabhängig davon, ob',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Angeklagte hat ein Geständnis abgelegt.',
      'Der Angeklagte hat ein Geständnis gemacht.',
      'Der Angeklagte hat ein Geständnis genommen.',
      'Der Angeklagte hat ein Geständnis gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: ein Geständnis ablegen (= gestehen).',
    'exampleSentence': 'Der Angeklagte hat ein Geständnis abgelegt.',
    'grammarRule': 'Funktionsverbgefüge: ein Geständnis ablegen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zuzüglich der Mehrwertsteuer beläuft sich der Betrag auf 500 Euro.',
      'Zuzüglich den Mehrwertsteuer beläuft sich der Betrag auf 500 Euro.',
      'Zuzüglich der Mehrwertsteuer belaufen sich der Betrag auf 500 Euro.',
      'Zuzüglich die Mehrwertsteuer beläuft sich der Betrag auf 500 Euro.'
    ],
 'correctAnswer': 0,
    'explanation': 'Zuzüglich verlangt den Genitiv: zuzüglich der Mehrwertsteuer.',
    'exampleSentence': 'Zuzüglich der Mehrwertsteuer beläuft sich der Betrag auf 500 Euro.',
    'grammarRule': 'Präposition zuzüglich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allerdings muss man dabei die Risiken beachten.',
      'Allerdings man muss dabei die Risiken beachten.',
      'Allerdings muss dabei die Risiken man beachten.',
      'Allerdings die Risiken muss man dabei beachten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach allerdings im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Allerdings muss man dabei die Risiken beachten.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verringerung des Energieverbrauchs ist ein wichtiges Ziel.',
      'Die Verringerung dem Energieverbrauch ist ein wichtiges Ziel.',
      'Die Verringerung des Energieverbrauchs sind ein wichtiges Ziel.',
      'Die Verringerung den Energieverbrauchs ist ein wichtiges Ziel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verringerung + Genitiv (des Energieverbrauchs). Subjekt Singular → ist.',
    'exampleSentence': 'Die Verringerung des Energieverbrauchs ist ein wichtiges Ziel.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der gut informierte Bürger trifft bessere Entscheidungen.',
      'Der gut informierten Bürger trifft bessere Entscheidungen.',
      'Der gut informierter Bürger trifft bessere Entscheidungen.',
      'Der gut informierende Bürger trifft bessere Entscheidungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Attribut: informierte (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der gut informierte Bürger trifft bessere Entscheidungen.',
    'grammarRule': 'Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorsitzende erklärte, die Sitzung werde vertagt.',
      'Der Vorsitzende erklärte, die Sitzung wird vertagt.',
      'Der Vorsitzende erklärte, die Sitzung werde vertagt wird.',
      'Der Vorsitzende erklärte, die Sitzung würde vertagt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Passiv: werde vertagt (indirekte Rede).',
    'exampleSentence': 'Der Vorsitzende erklärte, die Sitzung werde vertagt.',
    'grammarRule': 'Konjunktiv I Passiv: werde + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Strategie gilt als erfolgversprechend.',
      'Die Strategie gilt als erfolgversprechende.',
      'Die Strategie gilt für erfolgversprechend.',
      'Die Strategie gilt wie erfolgversprechend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gelten als + Adjektiv (prädikativ): gilt als erfolgversprechend.',
    'exampleSentence': 'Die Strategie gilt als erfolgversprechend.',
    'grammarRule': 'Gelten als + Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie auch immer man die Sache betrachtet, es gibt keine einfache Lösung.',
      'Wie auch immer man die Sache betrachtet, keine einfache Lösung es gibt.',
      'Wie auch immer man betrachtet die Sache, es gibt keine einfache Lösung.',
      'Wie auch immer man die Sache betrachtet, gibt es keine einfache Lösung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit wie auch immer: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Wie auch immer man die Sache betrachtet, es gibt keine einfache Lösung.',
    'grammarRule': 'Satzgefüge: wie auch immer + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Unternehmen hat Konkurs angemeldet.',
      'Das Unternehmen hat Konkurs gemacht.',
      'Das Unternehmen hat Konkurs genommen.',
      'Das Unternehmen hat Konkurs gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Konkurs anmelden (= Insolvenz erklären).',
    'exampleSentence': 'Das Unternehmen hat Konkurs angemeldet.',
    'grammarRule': 'Funktionsverbgefüge: Konkurs anmelden',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Infolge des Erdbebens mussten Tausende evakuiert werden.',
      'Infolge dem Erdbeben mussten Tausende evakuiert werden.',
      'Infolge des Erdbeben mussten Tausende evakuiert werden.',
      'Infolge den Erdbebens mussten Tausende evakuiert werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infolge verlangt den Genitiv: infolge des Erdbebens.',
    'exampleSentence': 'Infolge des Erdbebens mussten Tausende evakuiert werden.',
    'grammarRule': 'Präposition infolge + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Stattdessen wurde ein Alternativplan vorgelegt.',
      'Stattdessen ein Alternativplan wurde vorgelegt.',
      'Stattdessen wurde vorgelegt ein Alternativplan.',
      'Stattdessen vorgelegt wurde ein Alternativplan.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach stattdessen im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Stattdessen wurde ein Alternativplan vorgelegt.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Wahrung der Menschenrechte ist oberstes Gebot.',
      'Die Wahrung den Menschenrechten ist oberstes Gebot.',
      'Die Wahrung der Menschenrechte sind oberstes Gebot.',
      'Die Wahrung die Menschenrechte ist oberstes Gebot.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Wahrung + Genitiv Plural (der Menschenrechte). Subjekt Singular → ist.',
    'exampleSentence': 'Die Wahrung der Menschenrechte ist oberstes Gebot.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die vom Parlament verabschiedeten Gesetze treten in Kraft.',
      'Die vom Parlament verabschiedete Gesetze treten in Kraft.',
      'Die vom Parlament verabschiedeter Gesetze treten in Kraft.',
      'Die vom Parlament verabschiedenden Gesetze treten in Kraft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: verabschiedeten (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die vom Parlament verabschiedeten Gesetze treten in Kraft.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Journalist schrieb, der Skandal gefährde die Stabilität.',
      'Der Journalist schrieb, der Skandal gefährdet die Stabilität.',
      'Der Journalist schrieb, der Skandal gefährde die Stabilität gefährdet.',
      'Der Journalist schrieb, der Skandal gefährdete die Stabilität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: gefährde (3. Person Singular von gefährden).',
    'exampleSentence': 'Der Journalist schrieb, der Skandal gefährde die Stabilität.',
    'grammarRule': 'Konjunktiv I: gefährden → gefährde',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verbesserungsmöglichkeiten sind noch auszuloten.',
      'Die Verbesserungsmöglichkeiten sind noch ausloten zu.',
      'Die Verbesserungsmöglichkeiten sind noch zu ausgelotet.',
      'Die Verbesserungsmöglichkeiten sind noch ausloten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind auszuloten (= müssen ausgelotet werden).',
    'exampleSentence': 'Die Verbesserungsmöglichkeiten sind noch auszuloten.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obgleich der Aufwand beträchtlich war, hat sich das Projekt gelohnt.',
      'Obgleich der Aufwand beträchtlich war, das Projekt hat sich gelohnt.',
      'Obgleich der Aufwand war beträchtlich, hat sich das Projekt gelohnt.',
      'Obgleich der Aufwand beträchtlich war, hat das Projekt sich gelohnt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit obgleich: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Obgleich der Aufwand beträchtlich war, hat sich das Projekt gelohnt.',
    'grammarRule': 'Satzgefüge: obgleich + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bemühungen haben Früchte getragen.',
      'Die Bemühungen haben Früchte gemacht.',
      'Die Bemühungen haben Früchte genommen.',
      'Die Bemühungen haben Früchte gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Früchte tragen (= Ergebnisse zeigen).',
    'exampleSentence': 'Die Bemühungen haben Früchte getragen.',
    'grammarRule': 'Funktionsverbgefüge: Früchte tragen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aufgrund widriger Umstände musste die Veranstaltung abgesagt werden.',
      'Aufgrund widrigen Umständen musste die Veranstaltung abgesagt werden.',
      'Aufgrund widrige Umstände musste die Veranstaltung abgesagt werden.',
      'Aufgrund widrigem Umstand musste die Veranstaltung abgesagt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aufgrund verlangt den Genitiv: aufgrund widriger Umstände (Genitiv Plural ohne Artikel).',
    'exampleSentence': 'Aufgrund widriger Umstände musste die Veranstaltung abgesagt werden.',
    'grammarRule': 'Präposition aufgrund + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Demzufolge ergibt sich eine völlig neue Situation.',
      'Demzufolge eine völlig neue Situation ergibt sich.',
      'Demzufolge ergibt eine völlig neue Situation sich.',
      'Demzufolge sich ergibt eine völlig neue Situation.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach demzufolge im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Demzufolge ergibt sich eine völlig neue Situation.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Beseitigung der Mängel hat oberste Priorität.',
      'Die Beseitigung den Mängeln hat oberste Priorität.',
      'Die Beseitigung der Mängel haben oberste Priorität.',
      'Die Beseitigung die Mängel hat oberste Priorität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Beseitigung + Genitiv Plural (der Mängel). Subjekt Singular → hat.',
    'exampleSentence': 'Die Beseitigung der Mängel hat oberste Priorität.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p8-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die in den letzten Jahren gewachsene Nachfrage übertrifft das Angebot.',
      'Die in den letzten Jahren gewachsenen Nachfrage übertrifft das Angebot.',
      'Die in den letzten Jahren gewachsener Nachfrage übertrifft das Angebot.',
      'Die in den letzten Jahren wachsende Nachfrage übertrifft das Angebot.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: gewachsene (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die in den letzten Jahren gewachsene Nachfrage übertrifft das Angebot.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  }
];

export default questions;
