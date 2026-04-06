import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nur selten begegnet man einem so talentierten Musiker.',
      'Nur selten man begegnet einem so talentierten Musiker.',
      'Nur selten begegnet einem so talentierten Musiker man.',
      'Nur selten einem so talentierten Musiker begegnet man.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach nur selten im Vorfeld folgt Inversion: Verb vor Subjekt.',
    'exampleSentence': 'Nur selten begegnet man einem so talentierten Musiker.',
    'grammarRule': 'Inversion nach restriktivem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bekanntgabe der Ergebnisse erfolgt am Freitag.',
      'Die Bekanntgabe den Ergebnissen erfolgt am Freitag.',
      'Die Bekanntgabe der Ergebnissen erfolgt am Freitag.',
      'Die Bekanntgabe die Ergebnisse erfolgt am Freitag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bekanntgabe + Genitiv Plural (der Ergebnisse).',
    'exampleSentence': 'Die Bekanntgabe der Ergebnisse erfolgt am Freitag.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die vom Ausschuss beschlossene Maßnahme tritt sofort in Kraft.',
      'Die vom Ausschuss beschlossenen Maßnahme tritt sofort in Kraft.',
      'Die vom Ausschuss beschlossener Maßnahme tritt sofort in Kraft.',
      'Die vom Ausschuss beschließende Maßnahme tritt sofort in Kraft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: beschlossene (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die vom Ausschuss beschlossene Maßnahme tritt sofort in Kraft.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Forscher erklärte, das Ergebnis bestätige seine Theorie.',
      'Der Forscher erklärte, das Ergebnis bestätigt seine Theorie.',
      'Der Forscher erklärte, das Ergebnis bestätige seine Theorie bestätigt.',
      'Der Forscher erklärte, das Ergebnis bestätigen seine Theorie.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: bestätige (3. Person Singular von bestätigen).',
    'exampleSentence': 'Der Forscher erklärte, das Ergebnis bestätige seine Theorie.',
    'grammarRule': 'Konjunktiv I in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ergebnisse lassen sich nicht verallgemeinern.',
      'Die Ergebnisse lassen nicht sich verallgemeinern.',
      'Die Ergebnisse lassen sich nicht zu verallgemeinern.',
      'Die Ergebnisse lassen sich nicht verallgemeinert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv. Die Negation nicht steht vor dem Infinitiv.',
    'exampleSentence': 'Die Ergebnisse lassen sich nicht verallgemeinern.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sofern keine Einwände bestehen, wird der Plan umgesetzt.',
      'Sofern keine Einwände bestehen, der Plan wird umgesetzt.',
      'Sofern bestehen keine Einwände, wird der Plan umgesetzt.',
      'Sofern keine Einwände bestehen, wird umgesetzt der Plan.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit sofern: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Sofern keine Einwände bestehen, wird der Plan umgesetzt.',
    'grammarRule': 'Satzgefüge: sofern + Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Plan wurde in die Tat umgesetzt.',
      'Der Plan wurde in die Tat gebracht.',
      'Der Plan wurde in die Tat genommen.',
      'Der Plan wurde in die Tat gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in die Tat umsetzen (= verwirklichen).',
    'exampleSentence': 'Der Plan wurde in die Tat umgesetzt.',
    'grammarRule': 'Funktionsverbgefüge: in die Tat umsetzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mangels ausreichender Beweise wurde das Verfahren eingestellt.',
      'Mangels ausreichenden Beweisen wurde das Verfahren eingestellt.',
      'Mangels ausreichende Beweise wurde das Verfahren eingestellt.',
      'Mangels ausreichendem Beweis wurde das Verfahren eingestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mangels verlangt den Genitiv: mangels ausreichender Beweise (Genitiv Plural).',
    'exampleSentence': 'Mangels ausreichender Beweise wurde das Verfahren eingestellt.',
    'grammarRule': 'Präposition mangels + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Keineswegs ist die Aufgabe als einfach zu bezeichnen.',
      'Keineswegs die Aufgabe ist als einfach zu bezeichnen.',
      'Keineswegs ist die Aufgabe als einfach bezeichnen zu.',
      'Keineswegs als einfach ist die Aufgabe zu bezeichnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach keineswegs im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Keineswegs ist die Aufgabe als einfach zu bezeichnen.',
    'grammarRule': 'Inversion nach negativem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Erhöhung der Steuern stößt auf Widerstand.',
      'Die Erhöhung den Steuern stößt auf Widerstand.',
      'Die Erhöhung der Steuern stoßen auf Widerstand.',
      'Die Erhöhung die Steuern stößt auf Widerstand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Erhöhung + Genitiv Plural (der Steuern). Subjekt Singular → stößt.',
    'exampleSentence': 'Die Erhöhung der Steuern stößt auf Widerstand.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein gut durchdachter Plan führt zum Erfolg.',
      'Ein gut durchdachten Plan führt zum Erfolg.',
      'Ein gut durchgedachter Plan führt zum Erfolg.',
      'Ein gut durchdachtem Plan führt zum Erfolg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Attribut: durchdachter (Nominativ maskulin Singular mit unbestimmtem Artikel: -er).',
    'exampleSentence': 'Ein gut durchdachter Plan führt zum Erfolg.',
    'grammarRule': 'Partizip II als Attribut mit unbestimmtem Artikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es hieß, die Firma werde Stellen abbauen.',
      'Es hieß, die Firma wird Stellen abbauen.',
      'Es hieß, die Firma werde Stellen abbauen wird.',
      'Es hieß, die Firma werden Stellen abbauen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Futur in indirekter Rede: werde + Infinitiv.',
    'exampleSentence': 'Es hieß, die Firma werde Stellen abbauen.',
    'grammarRule': 'Konjunktiv I Futur: werde + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Vorschriften sind unbedingt einzuhalten.',
      'Die Vorschriften sind unbedingt zu eingehalten.',
      'Die Vorschriften sind unbedingt eingehalten zu.',
      'Die Vorschriften sind unbedingt einhalten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv mit modale Bedeutung: sind einzuhalten (= müssen eingehalten werden).',
    'exampleSentence': 'Die Vorschriften sind unbedingt einzuhalten.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dadurch, dass er fleißig übte, verbesserte er seine Leistung.',
      'Dadurch, dass er fleißig übte, er verbesserte seine Leistung.',
      'Dadurch, dass er übte fleißig, verbesserte er seine Leistung.',
      'Dadurch dass, er fleißig übte, verbesserte er seine Leistung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kausalsatz mit dadurch, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Dadurch, dass er fleißig übte, verbesserte er seine Leistung.',
    'grammarRule': 'Satzgefüge: dadurch, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Antrag in Anspruch genommen.',
      'Er hat Anspruch auf Unterstützung erhoben.',
      'Er hat Anspruch auf Unterstützung gemacht.',
      'Er hat Anspruch auf Unterstützung genommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: Anspruch erheben auf + Akkusativ (= beanspruchen).',
    'exampleSentence': 'Er hat Anspruch auf Unterstützung erhoben.',
    'grammarRule': 'Funktionsverbgefüge: Anspruch erheben',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut eines Berichts der Regierung sind die Zahlen gestiegen.',
      'Laut einem Bericht der Regierung sind die Zahlen gestiegen.',
      'Laut einen Bericht der Regierung sind die Zahlen gestiegen.',
      'Laut ein Bericht der Regierung sind die Zahlen gestiegen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Laut wird standardsprachlich mit Dativ verwendet: laut einem Bericht.',
    'exampleSentence': 'Laut einem Bericht der Regierung sind die Zahlen gestiegen.',
    'grammarRule': 'Präposition laut + Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nirgendwo anders findet man eine solche Vielfalt.',
      'Nirgendwo anders man findet eine solche Vielfalt.',
      'Nirgendwo anders eine solche Vielfalt findet man.',
      'Nirgendwo anders findet eine solche Vielfalt man.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach nirgendwo anders im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Nirgendwo anders findet man eine solche Vielfalt.',
    'grammarRule': 'Inversion nach Ortsadverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Anerkennung ausländischer Abschlüsse ist ein komplizierter Prozess.',
      'Die Anerkennung ausländischen Abschlüsse ist ein komplizierter Prozess.',
      'Die Anerkennung ausländische Abschlüsse ist ein komplizierter Prozess.',
      'Die Anerkennung ausländischer Abschlüsse sind ein komplizierter Prozess.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Anerkennung + Genitiv Plural (ausländischer Abschlüsse). Subjekt Singular → ist.',
    'exampleSentence': 'Die Anerkennung ausländischer Abschlüsse ist ein komplizierter Prozess.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die an der Studie teilnehmenden Personen wurden informiert.',
      'Die an der Studie teilnehmende Personen wurden informiert.',
      'Die an der Studie teilnehmender Personen wurden informiert.',
      'Die an der Studie teilgenommenen Personen wurden informiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I Plural: teilnehmenden (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die an der Studie teilnehmenden Personen wurden informiert.',
    'grammarRule': 'Erweitertes Partizip I Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Lehrerin sagte, alle Schüler sollten die Hausaufgaben machen.',
      'Die Lehrerin sagte, alle Schüler sollen die Hausaufgaben machen.',
      'Die Lehrerin sagte, alle Schüler sollten die Hausaufgaben machen sollen.',
      'Die Lehrerin sagte, alle Schüler solltet die Hausaufgaben machen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Da Konjunktiv I (sollen) mit dem Indikativ identisch wäre, wird Konjunktiv II (sollten) als Ersatzform verwendet.',
    'exampleSentence': 'Die Lehrerin sagte, alle Schüler sollten die Hausaufgaben machen.',
    'grammarRule': 'Konjunktiv II als Ersatz für Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem ist kaum zu überschätzen.',
      'Das Problem ist kaum überschätzen zu.',
      'Das Problem ist kaum zu überschätzt.',
      'Das Problem ist kaum überschätzbar zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist zu überschätzen (= kann überschätzt werden).',
    'exampleSentence': 'Das Problem ist kaum zu überschätzen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausgesetzt, dass die Finanzierung steht, kann das Projekt starten.',
      'Vorausgesetzt, dass die Finanzierung steht, das Projekt kann starten.',
      'Vorausgesetzt, dass steht die Finanzierung, kann das Projekt starten.',
      'Vorausgesetzt, dass die Finanzierung steht, kann starten das Projekt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit vorausgesetzt, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Vorausgesetzt, dass die Finanzierung steht, kann das Projekt starten.',
    'grammarRule': 'Satzgefüge: vorausgesetzt, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man sollte diese Tatsache in Rechnung ziehen.',
      'Man sollte diese Tatsache in Rechnung stellen.',
      'Man sollte diese Tatsache in Rechnung nehmen.',
      'Man sollte diese Tatsache in Rechnung bringen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: etwas in Rechnung stellen (= berechnen, berücksichtigen).',
    'exampleSentence': 'Man sollte diese Tatsache in Rechnung stellen.',
    'grammarRule': 'Funktionsverbgefüge: in Rechnung stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mithilfe eines neuen Verfahrens konnte das Problem gelöst werden.',
      'Mithilfe einem neuen Verfahren konnte das Problem gelöst werden.',
      'Mithilfe eines neuen Verfahren konnte das Problem gelöst werden.',
      'Mithilfe einen neuen Verfahrens konnte das Problem gelöst werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mithilfe verlangt den Genitiv: mithilfe eines neuen Verfahrens.',
    'exampleSentence': 'Mithilfe eines neuen Verfahrens konnte das Problem gelöst werden.',
    'grammarRule': 'Präposition mithilfe + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf keinen Fall dürfen die Daten an Dritte weitergegeben werden.',
      'Auf keinen Fall die Daten dürfen an Dritte weitergegeben werden.',
      'Auf keinen Fall dürfen an Dritte weitergegeben werden die Daten.',
      'Auf keinen Fall die Daten an Dritte weitergegeben werden dürfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach auf keinen Fall im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Auf keinen Fall dürfen die Daten an Dritte weitergegeben werden.',
    'grammarRule': 'Inversion nach negativer Phrase im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Hinblick auf die bevorstehenden Wahlen wurde eine Umfrage durchgeführt.',
      'Im Hinblick auf den bevorstehenden Wahlen wurde eine Umfrage durchgeführt.',
      'Im Hinblick auf die bevorstehende Wahlen wurde eine Umfrage durchgeführt.',
      'In Hinblick auf die bevorstehenden Wahlen wurde eine Umfrage durchgeführt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Hinblick auf + Akkusativ: die bevorstehenden Wahlen (Akkusativ Plural).',
    'exampleSentence': 'Im Hinblick auf die bevorstehenden Wahlen wurde eine Umfrage durchgeführt.',
    'grammarRule': 'Nominalstil: im Hinblick auf + Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das von allen Seiten kritisierte Gesetz wurde zurückgezogen.',
      'Das von allen Seiten kritisierten Gesetz wurde zurückgezogen.',
      'Das von allen Seiten kritisiertes Gesetz wurde zurückgezogen.',
      'Das von allen Seiten kritisierende Gesetz wurde zurückgezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: kritisierte (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das von allen Seiten kritisierte Gesetz wurde zurückgezogen.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Richter ordnete an, der Angeklagte werde freigelassen.',
      'Der Richter ordnete an, der Angeklagte wird freigelassen.',
      'Der Richter ordnete an, der Angeklagte werde freigelassen wird.',
      'Der Richter ordnete an, der Angeklagte werden freigelassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Futur Passiv: werde freigelassen (in indirekter Rede).',
    'exampleSentence': 'Der Richter ordnete an, der Angeklagte werde freigelassen.',
    'grammarRule': 'Konjunktiv I: werden → werde',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Brücke ist begehbar.',
      'Die Brücke ist begehbare.',
      'Die Brücke ist zu begehbar.',
      'Die Brücke ist begehbaren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: begehbar (= kann begangen werden). Prädikativ, nicht dekliniert.',
    'exampleSentence': 'Die Brücke ist begehbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Indem man regelmäßig übt, kann man seine Fähigkeiten verbessern.',
      'Indem man regelmäßig übt, man kann seine Fähigkeiten verbessern.',
      'Indem man übt regelmäßig, kann man seine Fähigkeiten verbessern.',
      'Indem man regelmäßig übt, kann seine Fähigkeiten man verbessern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalsatz mit indem: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Indem man regelmäßig übt, kann man seine Fähigkeiten verbessern.',
    'grammarRule': 'Satzgefüge: indem + Modalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir müssen Rücksicht auf die Umwelt nehmen.',
      'Wir müssen Rücksicht auf die Umwelt geben.',
      'Wir müssen Rücksicht auf die Umwelt machen.',
      'Wir müssen Rücksicht auf die Umwelt stellen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Rücksicht nehmen auf + Akkusativ (= berücksichtigen).',
    'exampleSentence': 'Wir müssen Rücksicht auf die Umwelt nehmen.',
    'grammarRule': 'Funktionsverbgefüge: Rücksicht nehmen auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hinsichtlich der geplanten Änderungen gibt es noch Klärungsbedarf.',
      'Hinsichtlich den geplanten Änderungen gibt es noch Klärungsbedarf.',
      'Hinsichtlich der geplanten Änderung gibt es noch Klärungsbedarf.',
      'Hinsichtlich die geplanten Änderungen gibt es noch Klärungsbedarf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Hinsichtlich verlangt den Genitiv: hinsichtlich der geplanten Änderungen.',
    'exampleSentence': 'Hinsichtlich der geplanten Änderungen gibt es noch Klärungsbedarf.',
    'grammarRule': 'Präposition hinsichtlich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder kann er singen noch kann er tanzen.',
      'Weder er kann singen noch er kann tanzen.',
      'Weder kann singen er noch kann tanzen er.',
      'Weder er singen kann noch er tanzen kann.'
    ],
    'correctAnswer': 0,
    'explanation': 'Weder ... noch: Nach weder steht das Verb vor dem Subjekt (Inversion), ebenso nach noch.',
    'exampleSentence': 'Weder kann er singen noch kann er tanzen.',
    'grammarRule': 'Wortstellung: weder ... noch mit Inversion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verbesserung der Infrastruktur hat oberste Priorität.',
      'Die Verbesserung den Infrastruktur hat oberste Priorität.',
      'Die Verbesserung der Infrastruktur haben oberste Priorität.',
      'Die Verbesserung die Infrastruktur hat oberste Priorität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verbesserung + Genitiv (der Infrastruktur). Subjekt Singular → hat.',
    'exampleSentence': 'Die Verbesserung der Infrastruktur hat oberste Priorität.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der den Preis verdienende Wissenschaftler hielt eine Rede.',
      'Der den Preis verdienter Wissenschaftler hielt eine Rede.',
      'Der den Preis verdienenden Wissenschaftler hielt eine Rede.',
      'Der den Preis verdiente Wissenschaftler hielt eine Rede.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: verdienende (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der den Preis verdienende Wissenschaftler hielt eine Rede.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man berichtet, das Unternehmen habe Verluste gemacht.',
      'Man berichtet, das Unternehmen hat Verluste gemacht.',
      'Man berichtet, das Unternehmen habe Verluste gemacht hat.',
      'Man berichtet, das Unternehmen haben Verluste gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt in indirekter Rede: habe gemacht.',
    'exampleSentence': 'Man berichtet, das Unternehmen habe Verluste gemacht.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Fehler lässt sich nicht mehr rückgängig machen.',
      'Der Fehler lässt sich nicht mehr rückgängig zu machen.',
      'Der Fehler lässt nicht sich mehr rückgängig machen.',
      'Der Fehler lässt sich nicht mehr rückgängig gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv (rückgängig machen).',
    'exampleSentence': 'Der Fehler lässt sich nicht mehr rückgängig machen.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gesetzt den Fall, dass der Vertrag scheitert, müssen wir einen Plan B haben.',
      'Gesetzt den Fall, dass der Vertrag scheitert, wir müssen einen Plan B haben.',
      'Gesetzt den Fall, dass scheitert der Vertrag, müssen wir einen Plan B haben.',
      'Gesetzt den Fall, dass der Vertrag scheitert, müssen einen Plan B wir haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit gesetzt den Fall, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Gesetzt den Fall, dass der Vertrag scheitert, müssen wir einen Plan B haben.',
    'grammarRule': 'Satzgefüge: gesetzt den Fall, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Verdächtige wurde unter Druck gesetzt.',
      'Der Verdächtige wurde unter Druck genommen.',
      'Der Verdächtige wurde unter Druck gemacht.',
      'Der Verdächtige wurde unter Druck gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: jemanden unter Druck setzen. Passiv: wurde unter Druck gesetzt.',
    'exampleSentence': 'Der Verdächtige wurde unter Druck gesetzt.',
    'grammarRule': 'Funktionsverbgefüge: unter Druck setzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seitens der Behörden wurde keine Stellungnahme abgegeben.',
      'Seitens den Behörden wurde keine Stellungnahme abgegeben.',
      'Seitens der Behörde wurde keine Stellungnahme abgegeben.',
      'Seitens die Behörden wurde keine Stellungnahme abgegeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Seitens verlangt den Genitiv: seitens der Behörden (Genitiv Plural).',
    'exampleSentence': 'Seitens der Behörden wurde keine Stellungnahme abgegeben.',
    'grammarRule': 'Präposition seitens + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So schwierig die Lage auch sein mag, wir dürfen nicht aufgeben.',
      'So schwierig die Lage auch sein mag, dürfen wir nicht aufgeben.',
      'So schwierig auch die Lage sein mag, wir dürfen nicht aufgeben.',
      'So schwierig die Lage sein auch mag, wir dürfen nicht aufgeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz: So + Adjektiv + Subjekt + auch + Verb. Der Hauptsatz behält normale Wortstellung.',
    'exampleSentence': 'So schwierig die Lage auch sein mag, wir dürfen nicht aufgeben.',
    'grammarRule': 'Konzessivsatz: so + Adjektiv ... auch',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Herabsetzung des Rentenalters wird kontrovers diskutiert.',
      'Die Herabsetzung dem Rentenalter wird kontrovers diskutiert.',
      'Die Herabsetzung des Rentenalter wird kontrovers diskutiert.',
      'Die Herabsetzung des Rentenalters werden kontrovers diskutiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Herabsetzung + Genitiv (des Rentenalters). Subjekt Singular → wird.',
    'exampleSentence': 'Die Herabsetzung des Rentenalters wird kontrovers diskutiert.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Eine seit Langem erwartete Entscheidung wurde endlich verkündet.',
      'Eine seit Langem erwarteten Entscheidung wurde endlich verkündet.',
      'Eine seit Langem erwarteter Entscheidung wurde endlich verkündet.',
      'Eine seit Langem erwartende Entscheidung wurde endlich verkündet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: erwartete (Nominativ feminin Singular mit unbestimmtem Artikel: -e).',
    'exampleSentence': 'Eine seit Langem erwartete Entscheidung wurde endlich verkündet.',
    'grammarRule': 'Erweitertes Partizip II mit unbestimmtem Artikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gab an, er sei den ganzen Tag zu Hause gewesen.',
      'Er gab an, er ist den ganzen Tag zu Hause gewesen.',
      'Er gab an, er sei den ganzen Tag zu Hause gewesen ist.',
      'Er gab an, er wäre den ganzen Tag zu Hause gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt mit sein: sei gewesen (indirekte Rede).',
    'exampleSentence': 'Er gab an, er sei den ganzen Tag zu Hause gewesen.',
    'grammarRule': 'Konjunktiv I Perfekt: sei + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gilt zu bedenken, dass die Ressourcen begrenzt sind.',
      'Es gilt bedenken, dass die Ressourcen begrenzt sind.',
      'Es gilt zu bedenken zu, dass die Ressourcen begrenzt sind.',
      'Es gilt bedacht, dass die Ressourcen begrenzt sind.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: es gilt + zu + Infinitiv: gilt zu bedenken (= muss bedacht werden).',
    'exampleSentence': 'Es gilt zu bedenken, dass die Ressourcen begrenzt sind.',
    'grammarRule': 'Passiversatzform: es gilt + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstatt dass er selbst kam, schickte er einen Vertreter.',
      'Anstatt dass er selbst kam, er schickte einen Vertreter.',
      'Anstatt dass er kam selbst, schickte er einen Vertreter.',
      'Anstatt dass er selbst kam, schickte einen Vertreter er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Substitutivsatz mit anstatt dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Anstatt dass er selbst kam, schickte er einen Vertreter.',
    'grammarRule': 'Satzgefüge: anstatt dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Maßnahme wurde zum Abschluss gebracht.',
      'Die Maßnahme wurde zum Abschluss genommen.',
      'Die Maßnahme wurde zum Abschluss gezogen.',
      'Die Maßnahme wurde zum Abschluss gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zum Abschluss bringen (= abschließen). Passiv: wurde zum Abschluss gebracht.',
    'exampleSentence': 'Die Maßnahme wurde zum Abschluss gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Abschluss bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet der Warnungen setzte er seine Reise fort.',
      'Ungeachtet den Warnungen setzte er seine Reise fort.',
      'Ungeachtet der Warnung setzte er seine Reise fort.',
      'Ungeachtet die Warnungen setzte er seine Reise fort.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ungeachtet verlangt den Genitiv: ungeachtet der Warnungen (Genitiv Plural).',
    'exampleSentence': 'Ungeachtet der Warnungen setzte er seine Reise fort.',
    'grammarRule': 'Präposition ungeachtet + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Umso wichtiger ist es, rechtzeitig Maßnahmen zu ergreifen.',
      'Umso wichtiger es ist, rechtzeitig Maßnahmen zu ergreifen.',
      'Umso wichtiger ist, es rechtzeitig Maßnahmen zu ergreifen.',
      'Umso es ist wichtiger, rechtzeitig Maßnahmen zu ergreifen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach umso + Komparativ im Vorfeld steht das Verb an zweiter Stelle: ist es.',
    'exampleSentence': 'Umso wichtiger ist es, rechtzeitig Maßnahmen zu ergreifen.',
    'grammarRule': 'Wortstellung: umso + Komparativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p2-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ausweitung des Handels hat positive Auswirkungen.',
      'Die Ausweitung dem Handel hat positive Auswirkungen.',
      'Die Ausweitung des Handels haben positive Auswirkungen.',
      'Die Ausweitung den Handels hat positive Auswirkungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Ausweitung + Genitiv (des Handels). Subjekt Singular → hat.',
    'exampleSentence': 'Die Ausweitung des Handels hat positive Auswirkungen.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  }
];

export default questions;
