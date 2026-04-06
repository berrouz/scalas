import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Sprecher teilte mit, die Verhandlungen liefen planmäßig.',
      'Der Sprecher teilte mit, die Verhandlungen laufen planmäßig.',
      'Der Sprecher teilte mit, die Verhandlungen liefen planmäßig laufen.',
      'Der Sprecher teilte mit, die Verhandlungen laufe planmäßig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II als Ersatz für Konjunktiv I (3. Person Plural): liefen (da laufen identisch mit Indikativ wäre).',
    'exampleSentence': 'Der Sprecher teilte mit, die Verhandlungen liefen planmäßig.',
    'grammarRule': 'Konjunktiv II als Ersatzform in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Gewährleistung der Sicherheit liegt in unserer Verantwortung.',
      'Die Gewährleistung den Sicherheit liegt in unserer Verantwortung.',
      'Die Gewährleistung der Sicherheit liegen in unserer Verantwortung.',
      'Die Gewährleistung die Sicherheit liegt in unserer Verantwortung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Gewährleistung + Genitiv (der Sicherheit). Subjekt Singular → liegt.',
    'exampleSentence': 'Die Gewährleistung der Sicherheit liegt in unserer Verantwortung.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die mit großem Aufwand restaurierte Kirche wurde wiedereröffnet.',
      'Die mit großem Aufwand restaurierten Kirche wurde wiedereröffnet.',
      'Die mit großem Aufwand restaurierter Kirche wurde wiedereröffnet.',
      'Die mit großem Aufwand restaurierende Kirche wurde wiedereröffnet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: restaurierte (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die mit großem Aufwand restaurierte Kirche wurde wiedereröffnet.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dieser Vorgang ist als bedenklich einzustufen.',
      'Dieser Vorgang ist als bedenklich einstufen.',
      'Dieser Vorgang ist als bedenklich zu eingestuft.',
      'Dieser Vorgang ist als bedenklich eingestuft zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist einzustufen (= muss eingestuft werden).',
    'exampleSentence': 'Dieser Vorgang ist als bedenklich einzustufen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Soweit ich informiert bin, findet die Sitzung morgen statt.',
      'Soweit ich informiert bin, die Sitzung findet morgen statt.',
      'Soweit ich bin informiert, findet die Sitzung morgen statt.',
      'Soweit ich informiert bin, findet morgen statt die Sitzung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Einschränkungssatz mit soweit: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Soweit ich informiert bin, findet die Sitzung morgen statt.',
    'grammarRule': 'Satzgefüge: soweit + Einschränkungssatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat die Forderung zur Sprache gebracht.',
      'Er hat die Forderung zur Sprache genommen.',
      'Er hat die Forderung zur Sprache gestellt.',
      'Er hat die Forderung zur Sprache gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zur Sprache bringen (= ansprechen).',
    'exampleSentence': 'Er hat die Forderung zur Sprache gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zur Sprache bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jenseits aller Erwartungen war das Ergebnis hervorragend.',
      'Jenseits allen Erwartungen war das Ergebnis hervorragend.',
      'Jenseits alle Erwartungen war das Ergebnis hervorragend.',
      'Jenseits allen Erwartung war das Ergebnis hervorragend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Jenseits verlangt den Genitiv: jenseits aller Erwartungen (Genitiv Plural).',
    'exampleSentence': 'Jenseits aller Erwartungen war das Ergebnis hervorragend.',
    'grammarRule': 'Präposition jenseits + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht einmal die Experten konnten eine Lösung finden.',
      'Nicht einmal konnten die Experten eine Lösung finden.',
      'Nicht einmal die Experten eine Lösung konnten finden.',
      'Nicht einmal eine Lösung die Experten konnten finden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nicht einmal + Subjekt im Vorfeld: Das Verb steht an zweiter Stelle nach dem gesamten Vorfeld.',
    'exampleSentence': 'Nicht einmal die Experten konnten eine Lösung finden.',
    'grammarRule': 'Wortstellung: nicht einmal + Subjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Wahrnehmung gesellschaftlicher Veränderungen ist subjektiv.',
      'Die Wahrnehmung gesellschaftlichen Veränderungen ist subjektiv.',
      'Die Wahrnehmung gesellschaftliche Veränderungen ist subjektiv.',
      'Die Wahrnehmung gesellschaftlicher Veränderungen sind subjektiv.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Wahrnehmung + Genitiv Plural (gesellschaftlicher Veränderungen). Subjekt Singular → ist.',
    'exampleSentence': 'Die Wahrnehmung gesellschaftlicher Veränderungen ist subjektiv.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die vor Kurzem eingestellten Mitarbeiter müssen geschult werden.',
      'Die vor Kurzem eingestellte Mitarbeiter müssen geschult werden.',
      'Die vor Kurzem eingestellter Mitarbeiter müssen geschult werden.',
      'Die vor Kurzem einstellenden Mitarbeiter müssen geschult werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: eingestellten (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die vor Kurzem eingestellten Mitarbeiter müssen geschult werden.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Wissenschaftlerin erklärte, sie habe eine neue Methode entwickelt.',
      'Die Wissenschaftlerin erklärte, sie hat eine neue Methode entwickelt.',
      'Die Wissenschaftlerin erklärte, sie habe eine neue Methode entwickelt hat.',
      'Die Wissenschaftlerin erklärte, sie haben eine neue Methode entwickelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe entwickelt (indirekte Rede, 3. Person Singular).',
    'exampleSentence': 'Die Wissenschaftlerin erklärte, sie habe eine neue Methode entwickelt.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Schaden lässt sich nicht beziffern.',
      'Der Schaden lässt nicht sich beziffern.',
      'Der Schaden lässt sich nicht zu beziffern.',
      'Der Schaden lässt sich nicht beziffert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lässt sich beziffern (= kann beziffert werden).',
    'exampleSentence': 'Der Schaden lässt sich nicht beziffern.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn auch die Kosten hoch sind, lohnt sich die Investition.',
      'Wenn auch die Kosten hoch sind, sich lohnt die Investition.',
      'Wenn auch die Kosten sind hoch, lohnt sich die Investition.',
      'Wenn auch die Kosten hoch sind, die Investition lohnt sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit wenn auch: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Wenn auch die Kosten hoch sind, lohnt sich die Investition.',
    'grammarRule': 'Satzgefüge: wenn auch + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Projekt wurde in Angriff genommen.',
      'Das Projekt wurde in Angriff gebracht.',
      'Das Projekt wurde in Angriff gestellt.',
      'Das Projekt wurde in Angriff gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Angriff nehmen (= beginnen). Passiv: wurde in Angriff genommen.',
    'exampleSentence': 'Das Projekt wurde in Angriff genommen.',
    'grammarRule': 'Funktionsverbgefüge: in Angriff nehmen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kraft seines Amtes hat er die Vollmacht zu handeln.',
      'Kraft seinem Amt hat er die Vollmacht zu handeln.',
      'Kraft seinen Amtes hat er die Vollmacht zu handeln.',
      'Kraft sein Amt hat er die Vollmacht zu handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kraft (= aufgrund) verlangt den Genitiv: kraft seines Amtes.',
    'exampleSentence': 'Kraft seines Amtes hat er die Vollmacht zu handeln.',
    'grammarRule': 'Präposition kraft + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Deshalb wurde beschlossen, das Projekt zu verschieben.',
      'Deshalb wurde beschlossen, zu verschieben das Projekt.',
      'Deshalb beschlossen wurde, das Projekt zu verschieben.',
      'Deshalb wurde beschlossen, das Projekt verschieben zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach deshalb im Vorfeld steht das finite Verb an zweiter Stelle. Infinitivsatz: zu + Infinitiv am Ende.',
    'exampleSentence': 'Deshalb wurde beschlossen, das Projekt zu verschieben.',
    'grammarRule': 'Wortstellung: Kausaladverb + Infinitivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zum Zwecke der Qualitätssicherung werden regelmäßige Kontrollen durchgeführt.',
      'Zum Zwecke den Qualitätssicherung werden regelmäßige Kontrollen durchgeführt.',
      'Zum Zwecke der Qualitätssicherung wird regelmäßige Kontrollen durchgeführt.',
      'Zum Zweck die Qualitätssicherung werden regelmäßige Kontrollen durchgeführt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: zum Zwecke + Genitiv (der Qualitätssicherung). Subjekt Plural → werden.',
    'exampleSentence': 'Zum Zwecke der Qualitätssicherung werden regelmäßige Kontrollen durchgeführt.',
    'grammarRule': 'Nominalstil: zum Zwecke + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein nicht zu unterschätzendes Risiko besteht weiterhin.',
      'Ein nicht zu unterschätzenden Risiko besteht weiterhin.',
      'Ein nicht zu unterschätzender Risiko besteht weiterhin.',
      'Ein nicht zu unterschätzendem Risiko besteht weiterhin.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv (zu + Partizip I): unterschätzendes (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein nicht zu unterschätzendes Risiko besteht weiterhin.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es heißt, man dürfe die Situation nicht unterschätzen.',
      'Es heißt, man darf die Situation nicht unterschätzen.',
      'Es heißt, man dürfe die Situation nicht unterschätzen darf.',
      'Es heißt, man dürfte die Situation nicht unterschätzen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: dürfe (3. Person Singular von dürfen).',
    'exampleSentence': 'Es heißt, man dürfe die Situation nicht unterschätzen.',
    'grammarRule': 'Konjunktiv I: dürfen → dürfe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Datei ist nicht mehr auffindbar.',
      'Die Datei ist nicht mehr auffindbare.',
      'Die Datei ist nicht mehr zu auffindbar.',
      'Die Datei ist nicht mehr auffindbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: auffindbar (= kann aufgefunden werden). Prädikativ, nicht dekliniert.',
    'exampleSentence': 'Die Datei ist nicht mehr auffindbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gleichviel ob man zustimmt oder nicht, die Entscheidung steht fest.',
      'Gleichviel ob man zustimmt oder nicht, steht die Entscheidung fest.',
      'Gleichviel ob zustimmt man oder nicht, die Entscheidung steht fest.',
      'Gleichviel ob man zustimmt oder nicht, fest steht die Entscheidung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit gleichviel ob: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Gleichviel ob man zustimmt oder nicht, die Entscheidung steht fest.',
    'grammarRule': 'Satzgefüge: gleichviel ob',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bitte wurde ihm zur Kenntnis gebracht.',
      'Die Bitte wurde ihm zur Kenntnis genommen.',
      'Die Bitte wurde ihm zur Kenntnis gestellt.',
      'Die Bitte wurde ihm zur Kenntnis gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: jemandem etwas zur Kenntnis bringen (= informieren). Passiv: wurde zur Kenntnis gebracht.',
    'exampleSentence': 'Die Bitte wurde ihm zur Kenntnis gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zur Kenntnis bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vermöge seiner Erfahrung konnte er das Problem lösen.',
      'Vermöge seinem Erfahrung konnte er das Problem lösen.',
      'Vermöge seinen Erfahrung konnte er das Problem lösen.',
      'Vermöge seine Erfahrung konnte er das Problem lösen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vermöge verlangt den Genitiv: vermöge seiner Erfahrung.',
    'exampleSentence': 'Vermöge seiner Erfahrung konnte er das Problem lösen.',
    'grammarRule': 'Präposition vermöge + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Noch nie zuvor hatte die Stadt einen solchen Ansturm erlebt.',
      'Noch nie zuvor die Stadt hatte einen solchen Ansturm erlebt.',
      'Noch nie zuvor hatte die Stadt erlebt einen solchen Ansturm.',
      'Noch nie zuvor einen solchen Ansturm hatte die Stadt erlebt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach noch nie zuvor im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Noch nie zuvor hatte die Stadt einen solchen Ansturm erlebt.',
    'grammarRule': 'Inversion nach temporalem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aufhebung der Sanktionen wurde begrüßt.',
      'Die Aufhebung den Sanktionen wurde begrüßt.',
      'Die Aufhebung der Sanktionen wurden begrüßt.',
      'Die Aufhebung die Sanktionen wurde begrüßt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Aufhebung + Genitiv Plural (der Sanktionen). Subjekt Singular → wurde.',
    'exampleSentence': 'Die Aufhebung der Sanktionen wurde begrüßt.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der an Bedeutung gewinnende Sektor wächst rasant.',
      'Der an Bedeutung gewinnenden Sektor wächst rasant.',
      'Der an Bedeutung gewinnender Sektor wächst rasant.',
      'Der an Bedeutung gewonnene Sektor wächst rasant.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: gewinnende (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der an Bedeutung gewinnende Sektor wächst rasant.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Politiker versicherte, er wisse um die Probleme der Bürger.',
      'Der Politiker versicherte, er weiß um die Probleme der Bürger.',
      'Der Politiker versicherte, er wisse um die Probleme der Bürger weiß.',
      'Der Politiker versicherte, er wüsste um die Probleme der Bürger.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: wisse (3. Person Singular von wissen).',
    'exampleSentence': 'Der Politiker versicherte, er wisse um die Probleme der Bürger.',
    'grammarRule': 'Konjunktiv I: wissen → wisse',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bleibt zu hoffen, dass sich die Situation verbessert.',
      'Es bleibt hoffen, dass sich die Situation verbessert.',
      'Es bleibt zu hoffen zu, dass sich die Situation verbessert.',
      'Es bleibt gehofft, dass sich die Situation verbessert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: bleiben + zu + Infinitiv: bleibt zu hoffen (= muss gehofft werden).',
    'exampleSentence': 'Es bleibt zu hoffen, dass sich die Situation verbessert.',
    'grammarRule': 'Passiversatzform: bleiben + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie sehr er sich auch anstrengte, das Ergebnis blieb unbefriedigend.',
      'Wie sehr er sich auch anstrengte, blieb das Ergebnis unbefriedigend.',
      'Wie sehr er anstrengte sich auch, das Ergebnis blieb unbefriedigend.',
      'Wie sehr er sich auch anstrengte, unbefriedigend blieb das Ergebnis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit wie sehr ... auch: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Wie sehr er sich auch anstrengte, das Ergebnis blieb unbefriedigend.',
    'grammarRule': 'Satzgefüge: wie sehr ... auch',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verhandlungen kamen zum Stillstand.',
      'Die Verhandlungen kamen zum Stillstand gebracht.',
      'Die Verhandlungen kamen in Stillstand.',
      'Die Verhandlungen kamen auf Stillstand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: zum Stillstand kommen (= stehen bleiben, aufhören).',
    'exampleSentence': 'Die Verhandlungen kamen zum Stillstand.',
    'grammarRule': 'Funktionsverbgefüge: zum Stillstand kommen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unbeschadet der geltenden Vorschriften kann eine Ausnahme gemacht werden.',
      'Unbeschadet den geltenden Vorschriften kann eine Ausnahme gemacht werden.',
      'Unbeschadet der geltenden Vorschrift kann eine Ausnahme gemacht werden.',
      'Unbeschadet die geltenden Vorschriften kann eine Ausnahme gemacht werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unbeschadet verlangt den Genitiv: unbeschadet der geltenden Vorschriften.',
    'exampleSentence': 'Unbeschadet der geltenden Vorschriften kann eine Ausnahme gemacht werden.',
    'grammarRule': 'Präposition unbeschadet + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ebenso wenig wie er konnte sie das Problem lösen.',
      'Ebenso wenig wie er sie konnte das Problem lösen.',
      'Ebenso wenig wie er konnte das Problem sie lösen.',
      'Ebenso wenig wie er konnte sie lösen das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach ebenso wenig wie + Vergleich im Vorfeld steht das Verb an zweiter Stelle mit Inversion des Subjekts.',
    'exampleSentence': 'Ebenso wenig wie er konnte sie das Problem lösen.',
    'grammarRule': 'Wortstellung: ebenso wenig wie + Inversion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'In Anbetracht der Umstände war die Reaktion angemessen.',
      'In Anbetracht den Umständen war die Reaktion angemessen.',
      'In Anbetracht der Umständen war die Reaktion angemessen.',
      'In Anbetracht die Umstände war die Reaktion angemessen.'
    ],
    'correctAnswer': 0,
    'explanation': 'In Anbetracht + Genitiv: in Anbetracht der Umstände (Genitiv Plural).',
    'exampleSentence': 'In Anbetracht der Umstände war die Reaktion angemessen.',
    'grammarRule': 'Nominalstil: in Anbetracht + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die zu erwartenden Kosten übersteigen das Budget.',
      'Die zu erwartende Kosten übersteigen das Budget.',
      'Die zu erwartender Kosten übersteigen das Budget.',
      'Die zu erwarteten Kosten übersteigen das Budget.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv Plural: zu erwartenden (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die zu erwartenden Kosten übersteigen das Budget.',
    'grammarRule': 'Gerundiv: zu + Partizip I Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Angeklagte beteuerte, er sei unschuldig.',
      'Der Angeklagte beteuerte, er ist unschuldig.',
      'Der Angeklagte beteuerte, er sei unschuldig ist.',
      'Der Angeklagte beteuerte, er wäre unschuldig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: sei (3. Person Singular von sein).',
    'exampleSentence': 'Der Angeklagte beteuerte, er sei unschuldig.',
    'grammarRule': 'Konjunktiv I: sein → sei',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ursache der Störung gilt es noch herauszufinden.',
      'Die Ursache der Störung gilt es noch herausfinden.',
      'Die Ursache der Störung gilt es noch zu herausgefunden.',
      'Die Ursache der Störung gilt es noch herausgefunden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: es gilt + zu + Infinitiv: gilt es herauszufinden (= muss herausgefunden werden).',
    'exampleSentence': 'Die Ursache der Störung gilt es noch herauszufinden.',
    'grammarRule': 'Passiversatzform: es gilt + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei denn, er entschuldigt sich, werde ich ihm nicht verzeihen.',
      'Es sei denn, er sich entschuldigt, werde ich ihm nicht verzeihen.',
      'Es sei denn, er entschuldigt sich, ich werde ihm nicht verzeihen.',
      'Es sei denn, entschuldigt er sich, werde ich ihm nicht verzeihen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit es sei denn: Hauptsatzwortstellung im Nebensatz (Verb an zweiter Stelle).',
    'exampleSentence': 'Es sei denn, er entschuldigt sich, werde ich ihm nicht verzeihen.',
    'grammarRule': 'Satzgefüge: es sei denn',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ergebnisse wurden in Zweifel gezogen.',
      'Die Ergebnisse wurden in Zweifel gestellt.',
      'Die Ergebnisse wurden in Zweifel gebracht.',
      'Die Ergebnisse wurden in Zweifel genommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Zweifel ziehen (= bezweifeln). Passiv: wurden in Zweifel gezogen.',
    'exampleSentence': 'Die Ergebnisse wurden in Zweifel gezogen.',
    'grammarRule': 'Funktionsverbgefüge: in Zweifel ziehen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zwecks besserer Verständigung wurde ein Dolmetscher hinzugezogen.',
      'Zwecks besseren Verständigung wurde ein Dolmetscher hinzugezogen.',
      'Zwecks bessere Verständigung wurde ein Dolmetscher hinzugezogen.',
      'Zwecks besserem Verständigung wurde ein Dolmetscher hinzugezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zwecks verlangt den Genitiv: zwecks besserer Verständigung (Genitiv feminin).',
    'exampleSentence': 'Zwecks besserer Verständigung wurde ein Dolmetscher hinzugezogen.',
    'grammarRule': 'Präposition zwecks + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst als alle Bedingungen erfüllt waren, wurde der Vertrag unterzeichnet.',
      'Erst als alle Bedingungen erfüllt waren, der Vertrag wurde unterzeichnet.',
      'Erst als alle Bedingungen waren erfüllt, wurde der Vertrag unterzeichnet.',
      'Erst als erfüllt waren alle Bedingungen, wurde der Vertrag unterzeichnet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporalsatz mit als: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Erst als alle Bedingungen erfüllt waren, wurde der Vertrag unterzeichnet.',
    'grammarRule': 'Wortstellung: Temporalsatz mit erst als',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Sicherstellung der Versorgung hat Priorität.',
      'Die Sicherstellung den Versorgung hat Priorität.',
      'Die Sicherstellung der Versorgung haben Priorität.',
      'Die Sicherstellung die Versorgung hat Priorität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Sicherstellung + Genitiv (der Versorgung). Subjekt Singular → hat.',
    'exampleSentence': 'Die Sicherstellung der Versorgung hat Priorität.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der im Ausland lebende Schriftsteller veröffentlichte ein neues Buch.',
      'Der im Ausland lebenden Schriftsteller veröffentlichte ein neues Buch.',
      'Der im Ausland lebender Schriftsteller veröffentlichte ein neues Buch.',
      'Der im Ausland gelebte Schriftsteller veröffentlichte ein neues Buch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: lebende (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der im Ausland lebende Schriftsteller veröffentlichte ein neues Buch.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachrichtenagentur meldete, es gebe neue Entwicklungen.',
      'Die Nachrichtenagentur meldete, es gibt neue Entwicklungen.',
      'Die Nachrichtenagentur meldete, es gebe neue Entwicklungen gibt.',
      'Die Nachrichtenagentur meldete, es gäbe neue Entwicklungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: gebe (3. Person Singular von geben).',
    'exampleSentence': 'Die Nachrichtenagentur meldete, es gebe neue Entwicklungen.',
    'grammarRule': 'Konjunktiv I: geben → gebe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Folgen sind noch nicht absehbar.',
      'Die Folgen sind noch nicht absehbare.',
      'Die Folgen sind noch nicht zu absehbar.',
      'Die Folgen sind noch nicht absehbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: absehbar (= kann abgesehen werden). Prädikativ.',
    'exampleSentence': 'Die Folgen sind noch nicht absehbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mag die Kritik auch berechtigt sein, so bleibt der Entwurf dennoch gültig.',
      'Mag die Kritik auch berechtigt sein, der Entwurf bleibt so dennoch gültig.',
      'Mag auch die Kritik berechtigt sein, so bleibt dennoch der Entwurf gültig.',
      'Mag die Kritik berechtigt auch sein, so bleibt der Entwurf dennoch gültig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit mag ... auch: Verb am Anfang, auch nach dem Subjekt. Hauptsatz mit so eingeleitet.',
    'exampleSentence': 'Mag die Kritik auch berechtigt sein, so bleibt der Entwurf dennoch gültig.',
    'grammarRule': 'Satzgefüge: mag ... auch + so',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorschlag wurde zur Diskussion gestellt.',
      'Der Vorschlag wurde zur Diskussion gebracht.',
      'Der Vorschlag wurde zur Diskussion genommen.',
      'Der Vorschlag wurde zur Diskussion gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zur Diskussion stellen (= vorschlagen). Passiv: wurde zur Diskussion gestellt.',
    'exampleSentence': 'Der Vorschlag wurde zur Diskussion gestellt.',
    'grammarRule': 'Funktionsverbgefüge: zur Diskussion stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anhand der vorliegenden Daten lässt sich ein Trend erkennen.',
      'Anhand den vorliegenden Daten lässt sich ein Trend erkennen.',
      'Anhand der vorliegenden Daten lassen sich ein Trend erkennen.',
      'Anhand die vorliegenden Daten lässt sich ein Trend erkennen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anhand verlangt den Genitiv: anhand der vorliegenden Daten.',
    'exampleSentence': 'Anhand der vorliegenden Daten lässt sich ein Trend erkennen.',
    'grammarRule': 'Präposition anhand + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zumal die Zeit drängt, sollten wir sofort handeln.',
      'Zumal die Zeit drängt, wir sollten sofort handeln.',
      'Zumal drängt die Zeit, sollten wir sofort handeln.',
      'Zumal die Zeit drängt, sollten sofort wir handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kausalsatz mit zumal: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Zumal die Zeit drängt, sollten wir sofort handeln.',
    'grammarRule': 'Wortstellung: Kausalsatz mit zumal',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Förderung erneuerbarer Energien ist ein wichtiges Ziel.',
      'Die Förderung erneuerbaren Energien ist ein wichtiges Ziel.',
      'Die Förderung erneuerbare Energien ist ein wichtiges Ziel.',
      'Die Förderung erneuerbarer Energien sind ein wichtiges Ziel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Förderung + Genitiv Plural (erneuerbarer Energien). Subjekt Singular → ist.',
    'exampleSentence': 'Die Förderung erneuerbarer Energien ist ein wichtiges Ziel.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p3-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Eine sorgfältig durchgeführte Analyse ergab neue Erkenntnisse.',
      'Eine sorgfältig durchgeführten Analyse ergab neue Erkenntnisse.',
      'Eine sorgfältig durchgeführter Analyse ergab neue Erkenntnisse.',
      'Eine sorgfältig durchführende Analyse ergab neue Erkenntnisse.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: durchgeführte (Nominativ feminin Singular mit unbestimmtem Artikel: -e).',
    'exampleSentence': 'Eine sorgfältig durchgeführte Analyse ergab neue Erkenntnisse.',
    'grammarRule': 'Erweitertes Partizip II mit unbestimmtem Artikel',
    'tags': ['satzkorrektur']
  }
];

export default questions;
