import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht zuletzt deshalb, weil die Nachfrage steigt, wurden neue Stellen geschaffen.',
      'Nicht zuletzt deshalb, weil die Nachfrage steigt, neue Stellen wurden geschaffen.',
      'Nicht zuletzt deshalb, weil steigt die Nachfrage, wurden neue Stellen geschaffen.',
      'Nicht zuletzt deshalb, weil die Nachfrage steigt, wurden geschaffen neue Stellen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kausalsatz mit weil: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion nach vorangestelltem Nebensatz.',
    'exampleSentence': 'Nicht zuletzt deshalb, weil die Nachfrage steigt, wurden neue Stellen geschaffen.',
    'grammarRule': 'Satzgefüge: Kausalsatz mit weil',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Erschließung neuer Märkte birgt Risiken und Chancen.',
      'Die Erschließung neuen Märkte birgt Risiken und Chancen.',
      'Die Erschließung neue Märkte birgt Risiken und Chancen.',
      'Die Erschließung neuer Märkte bergen Risiken und Chancen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Erschließung + Genitiv Plural (neuer Märkte). Subjekt Singular → birgt.',
    'exampleSentence': 'Die Erschließung neuer Märkte birgt Risiken und Chancen.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der sorgfältig ausgearbeitete Entwurf wurde genehmigt.',
      'Der sorgfältig ausgearbeiteten Entwurf wurde genehmigt.',
      'Der sorgfältig ausgearbeiteter Entwurf wurde genehmigt.',
      'Der sorgfältig ausarbeitende Entwurf wurde genehmigt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: ausgearbeitete (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der sorgfältig ausgearbeitete Entwurf wurde genehmigt.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Botschafter versicherte, sein Land strebe nach Frieden.',
      'Der Botschafter versicherte, sein Land strebt nach Frieden.',
      'Der Botschafter versicherte, sein Land strebe nach Frieden strebt.',
      'Der Botschafter versicherte, sein Land strebte nach Frieden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: strebe (3. Person Singular von streben).',
    'exampleSentence': 'Der Botschafter versicherte, sein Land strebe nach Frieden.',
    'grammarRule': 'Konjunktiv I: streben → strebe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aus den Daten lässt sich ein klarer Trend ablesen.',
      'Aus den Daten lässt ein klarer Trend sich ablesen.',
      'Aus den Daten lässt sich ein klarer Trend zu ablesen.',
      'Aus den Daten lässt sich ein klarer Trend abgelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lässt sich ablesen (= kann abgelesen werden).',
    'exampleSentence': 'Aus den Daten lässt sich ein klarer Trend ablesen.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Rede hat großen Eindruck hinterlassen.',
      'Die Rede hat großen Eindruck gemacht.',
      'Die Rede hat großen Eindruck genommen.',
      'Die Rede hat großen Eindruck gegeben.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: Eindruck machen (= beeindrucken). Nicht hinterlassen, nehmen oder geben.',
    'exampleSentence': 'Die Rede hat großen Eindruck gemacht.',
    'grammarRule': 'Funktionsverbgefüge: Eindruck machen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstelle eines persönlichen Gesprächs fand eine Videokonferenz statt.',
      'Anstelle einem persönlichen Gespräch fand eine Videokonferenz statt.',
      'Anstelle eines persönlichen Gespräch fand eine Videokonferenz statt.',
      'Anstelle ein persönliches Gespräch fand eine Videokonferenz statt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anstelle verlangt den Genitiv: anstelle eines persönlichen Gesprächs.',
    'exampleSentence': 'Anstelle eines persönlichen Gesprächs fand eine Videokonferenz statt.',
    'grammarRule': 'Präposition anstelle + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestotrotz muss eine Lösung gefunden werden.',
      'Nichtsdestotrotz eine Lösung muss gefunden werden.',
      'Nichtsdestotrotz muss gefunden werden eine Lösung.',
      'Nichtsdestotrotz gefunden werden muss eine Lösung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach nichtsdestotrotz im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Nichtsdestotrotz muss eine Lösung gefunden werden.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Abschaffung veralteter Gesetze ist längst überfällig.',
      'Die Abschaffung veralteten Gesetze ist längst überfällig.',
      'Die Abschaffung veraltete Gesetze ist längst überfällig.',
      'Die Abschaffung veralteter Gesetze sind längst überfällig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Abschaffung + Genitiv Plural (veralteter Gesetze). Subjekt Singular → ist.',
    'exampleSentence': 'Die Abschaffung veralteter Gesetze ist längst überfällig.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die zunehmend an Einfluss gewinnende Bewegung verändert die Politik.',
      'Die zunehmend an Einfluss gewinnenden Bewegung verändert die Politik.',
      'Die zunehmend an Einfluss gewinnender Bewegung verändert die Politik.',
      'Die zunehmend an Einfluss gewonnene Bewegung verändert die Politik.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: gewinnende (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die zunehmend an Einfluss gewinnende Bewegung verändert die Politik.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dem Bericht zufolge seien die Reserven nahezu erschöpft.',
      'Dem Bericht zufolge sind die Reserven nahezu erschöpft.',
      'Dem Bericht zufolge seien die Reserven nahezu erschöpft sind.',
      'Dem Bericht zufolge wären die Reserven nahezu erschöpft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Plural: seien (indirekte Rede, 3. Person Plural von sein).',
    'exampleSentence': 'Dem Bericht zufolge seien die Reserven nahezu erschöpft.',
    'grammarRule': 'Konjunktiv I Plural: sein → seien',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Lösung dieser Aufgabe ist als machbar einzuschätzen.',
      'Die Lösung dieser Aufgabe ist als machbar einschätzen.',
      'Die Lösung dieser Aufgabe ist als machbar zu eingeschätzt.',
      'Die Lösung dieser Aufgabe ist als machbar eingeschätzt zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist einzuschätzen (= kann eingeschätzt werden).',
    'exampleSentence': 'Die Lösung dieser Aufgabe ist als machbar einzuschätzen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sowohl der Preis als auch die Qualität stimmen.',
      'Sowohl der Preis als auch die Qualität stimmt.',
      'Sowohl stimmen der Preis als auch die Qualität.',
      'Sowohl der Preis als die Qualität auch stimmen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Sowohl ... als auch: Bei zwei Subjekten steht das Verb im Plural: stimmen.',
    'exampleSentence': 'Sowohl der Preis als auch die Qualität stimmen.',
    'grammarRule': 'Satzgefüge: sowohl ... als auch + Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat Kritik an dem Vorschlag geübt.',
      'Er hat Kritik an dem Vorschlag gemacht.',
      'Er hat Kritik an dem Vorschlag genommen.',
      'Er hat Kritik an dem Vorschlag gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Kritik üben an + Dativ (= kritisieren).',
    'exampleSentence': 'Er hat Kritik an dem Vorschlag geübt.',
    'grammarRule': 'Funktionsverbgefüge: Kritik üben',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorbehaltlich der Zustimmung des Vorstands wird der Plan umgesetzt.',
      'Vorbehaltlich den Zustimmung des Vorstands wird der Plan umgesetzt.',
      'Vorbehaltlich der Zustimmung des Vorstand wird der Plan umgesetzt.',
      'Vorbehaltlich die Zustimmung des Vorstands wird der Plan umgesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorbehaltlich verlangt den Genitiv: vorbehaltlich der Zustimmung des Vorstands.',
    'exampleSentence': 'Vorbehaltlich der Zustimmung des Vorstands wird der Plan umgesetzt.',
    'grammarRule': 'Präposition vorbehaltlich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zwar ist die Lage ernst, doch gibt es Hoffnung.',
      'Zwar die Lage ist ernst, doch gibt es Hoffnung.',
      'Zwar ist die Lage ernst, doch es gibt Hoffnung.',
      'Zwar ernst ist die Lage, doch gibt es Hoffnung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zwar ... doch: Nach zwar und doch steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Zwar ist die Lage ernst, doch gibt es Hoffnung.',
    'grammarRule': 'Wortstellung: zwar ... doch mit Inversion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter Einbeziehung aller Beteiligten wurde ein Kompromiss erzielt.',
      'Unter Einbeziehung allen Beteiligten wurde ein Kompromiss erzielt.',
      'Unter Einbeziehung alle Beteiligten wurde ein Kompromiss erzielt.',
      'Unter Einbeziehung aller Beteiligten wurden ein Kompromiss erzielt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: unter Einbeziehung + Genitiv Plural (aller Beteiligten). Subjekt Singular → wurde.',
    'exampleSentence': 'Unter Einbeziehung aller Beteiligten wurde ein Kompromiss erzielt.',
    'grammarRule': 'Nominalstil: unter Einbeziehung + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das lang ersehnte Urteil wurde gestern verkündet.',
      'Das lang ersehnten Urteil wurde gestern verkündet.',
      'Das lang ersehntes Urteil wurde gestern verkündet.',
      'Das lang ersehnende Urteil wurde gestern verkündet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: ersehnte (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das lang ersehnte Urteil wurde gestern verkündet.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Trainer betonte, das Team müsse sich noch verbessern.',
      'Der Trainer betonte, das Team muss sich noch verbessern.',
      'Der Trainer betonte, das Team müsse sich noch verbessern muss.',
      'Der Trainer betonte, das Team müsste sich noch verbessern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: müsse (3. Person Singular von müssen).',
    'exampleSentence': 'Der Trainer betonte, das Team müsse sich noch verbessern.',
    'grammarRule': 'Konjunktiv I: müssen → müsse',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Zusammenhang ist leicht nachvollziehbar.',
      'Der Zusammenhang ist leicht nachvollziehbare.',
      'Der Zusammenhang ist leicht zu nachvollziehbar.',
      'Der Zusammenhang ist leicht nachvollziehbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: nachvollziehbar (= kann nachvollzogen werden). Prädikativ.',
    'exampleSentence': 'Der Zusammenhang ist leicht nachvollziehbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zumal er über ausreichend Erfahrung verfügt, eignet er sich für die Stelle.',
      'Zumal er über ausreichend Erfahrung verfügt, er eignet sich für die Stelle.',
      'Zumal er verfügt über ausreichend Erfahrung, eignet er sich für die Stelle.',
      'Zumal er über ausreichend Erfahrung verfügt, eignet für die Stelle er sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kausalsatz mit zumal: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Zumal er über ausreichend Erfahrung verfügt, eignet er sich für die Stelle.',
    'grammarRule': 'Satzgefüge: zumal + Kausalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Frage wurde zur Abstimmung gestellt.',
      'Die Frage wurde zur Abstimmung gebracht.',
      'Die Frage wurde zur Abstimmung genommen.',
      'Die Frage wurde zur Abstimmung gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zur Abstimmung stellen (= abstimmen lassen).',
    'exampleSentence': 'Die Frage wurde zur Abstimmung gestellt.',
    'grammarRule': 'Funktionsverbgefüge: zur Abstimmung stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ausschließlich der Versandkosten beträgt der Preis 50 Euro.',
      'Ausschließlich den Versandkosten beträgt der Preis 50 Euro.',
      'Ausschließlich die Versandkosten beträgt der Preis 50 Euro.',
      'Ausschließlich dem Versandkosten beträgt der Preis 50 Euro.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ausschließlich (= ohne) verlangt den Genitiv: ausschließlich der Versandkosten.',
    'exampleSentence': 'Ausschließlich der Versandkosten beträgt der Preis 50 Euro.',
    'grammarRule': 'Präposition ausschließlich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gleichwohl bleibt die Frage offen, wie man das Problem lösen kann.',
      'Gleichwohl die Frage bleibt offen, wie man das Problem lösen kann.',
      'Gleichwohl bleibt offen die Frage, wie man das Problem lösen kann.',
      'Gleichwohl offen bleibt die Frage, wie man das Problem lösen kann.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach gleichwohl im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Gleichwohl bleibt die Frage offen, wie man das Problem lösen kann.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mit Blick auf die Zukunft sind weitreichende Reformen nötig.',
      'Mit Blick auf der Zukunft sind weitreichende Reformen nötig.',
      'Mit Blick auf die Zukunft ist weitreichende Reformen nötig.',
      'Mit Blick auf den Zukunft sind weitreichende Reformen nötig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mit Blick auf + Akkusativ: die Zukunft. Subjekt Plural → sind.',
    'exampleSentence': 'Mit Blick auf die Zukunft sind weitreichende Reformen nötig.',
    'grammarRule': 'Nominalstil: mit Blick auf + Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der seit Monaten schwelende Konflikt eskalierte schließlich.',
      'Der seit Monaten schwelenden Konflikt eskalierte schließlich.',
      'Der seit Monaten schwelender Konflikt eskalierte schließlich.',
      'Der seit Monaten geschwelte Konflikt eskalierte schließlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: schwelende (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der seit Monaten schwelende Konflikt eskalierte schließlich.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Zeugin sagte aus, sie habe den Unfall genau gesehen.',
      'Die Zeugin sagte aus, sie hat den Unfall genau gesehen.',
      'Die Zeugin sagte aus, sie habe den Unfall genau gesehen hat.',
      'Die Zeugin sagte aus, sie hätte den Unfall genau gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe gesehen (indirekte Rede, 3. Person Singular).',
    'exampleSentence': 'Die Zeugin sagte aus, sie habe den Unfall genau gesehen.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Arbeit ist bis Ende der Woche abzuschließen.',
      'Die Arbeit ist bis Ende der Woche abschließen zu.',
      'Die Arbeit ist bis Ende der Woche zu abgeschlossen.',
      'Die Arbeit ist bis Ende der Woche abschließen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist abzuschließen (= muss abgeschlossen werden).',
    'exampleSentence': 'Die Arbeit ist bis Ende der Woche abzuschließen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sei es, dass er zu spät kommt, sei es, dass er gar nicht erscheint, wir beginnen pünktlich.',
      'Sei es, dass er zu spät kommt, sei es, dass er gar nicht erscheint, pünktlich beginnen wir.',
      'Sei es, dass kommt er zu spät, sei es, dass erscheint er gar nicht, wir beginnen pünktlich.',
      'Sei es, dass er zu spät kommt, sei es, dass er gar nicht erscheint, beginnen wir pünktlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Alternativsatz mit sei es, dass ... sei es, dass: Nebensätze mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Sei es, dass er zu spät kommt, sei es, dass er gar nicht erscheint, wir beginnen pünktlich.',
    'grammarRule': 'Satzgefüge: sei es, dass ... sei es, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorschlag wurde in Erwägung gezogen.',
      'Der Vorschlag wurde in Erwägung gebracht.',
      'Der Vorschlag wurde in Erwägung genommen.',
      'Der Vorschlag wurde in Erwägung gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Erwägung ziehen (= erwägen).',
    'exampleSentence': 'Der Vorschlag wurde in Erwägung gezogen.',
    'grammarRule': 'Funktionsverbgefüge: in Erwägung ziehen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bezüglich des eingereichten Antrags gibt es Neuigkeiten.',
      'Bezüglich dem eingereichten Antrag gibt es Neuigkeiten.',
      'Bezüglich des eingereichten Antrag gibt es Neuigkeiten.',
      'Bezüglich den eingereichten Antrags gibt es Neuigkeiten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bezüglich verlangt den Genitiv: bezüglich des eingereichten Antrags.',
    'exampleSentence': 'Bezüglich des eingereichten Antrags gibt es Neuigkeiten.',
    'grammarRule': 'Präposition bezüglich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst recht muss man in schwierigen Zeiten zusammenhalten.',
      'Erst recht man muss in schwierigen Zeiten zusammenhalten.',
      'Erst recht muss in schwierigen Zeiten zusammenhalten man.',
      'Erst recht in schwierigen Zeiten muss man zusammenhalten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach erst recht im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Erst recht muss man in schwierigen Zeiten zusammenhalten.',
    'grammarRule': 'Inversion nach Adverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Rahmen der Untersuchung wurden zahlreiche Zeugen befragt.',
      'Im Rahmen den Untersuchung wurden zahlreiche Zeugen befragt.',
      'Im Rahmen der Untersuchung wurde zahlreiche Zeugen befragt.',
      'Im Rahmen die Untersuchung wurden zahlreiche Zeugen befragt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Rahmen + Genitiv: im Rahmen der Untersuchung. Subjekt Plural → wurden.',
    'exampleSentence': 'Im Rahmen der Untersuchung wurden zahlreiche Zeugen befragt.',
    'grammarRule': 'Nominalstil: im Rahmen + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die von der Firma entwickelte Software wird weltweit eingesetzt.',
      'Die von der Firma entwickelten Software wird weltweit eingesetzt.',
      'Die von der Firma entwickelter Software wird weltweit eingesetzt.',
      'Die von der Firma entwickelnde Software wird weltweit eingesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: entwickelte (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die von der Firma entwickelte Software wird weltweit eingesetzt.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wurde berichtet, die Delegation sei bereits abgereist.',
      'Es wurde berichtet, die Delegation ist bereits abgereist.',
      'Es wurde berichtet, die Delegation sei bereits abgereist ist.',
      'Es wurde berichtet, die Delegation wäre bereits abgereist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt mit sein: sei abgereist (indirekte Rede).',
    'exampleSentence': 'Es wurde berichtet, die Delegation sei bereits abgereist.',
    'grammarRule': 'Konjunktiv I Perfekt: sei + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gilt, die Chancen zu nutzen.',
      'Es gilt, die Chancen nutzen.',
      'Es gilt, die Chancen zu nutzen zu.',
      'Es gilt, die Chancen genutzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: es gilt + zu + Infinitiv: gilt zu nutzen (= müssen genutzt werden).',
    'exampleSentence': 'Es gilt, die Chancen zu nutzen.',
    'grammarRule': 'Passiversatzform: es gilt + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet der Tatsache, dass es regnet, findet das Fest statt.',
      'Ungeachtet der Tatsache, dass es regnet, das Fest findet statt.',
      'Ungeachtet der Tatsache, dass regnet es, findet das Fest statt.',
      'Ungeachtet der Tatsache, dass es regnet, findet statt das Fest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit ungeachtet der Tatsache, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Ungeachtet der Tatsache, dass es regnet, findet das Fest statt.',
    'grammarRule': 'Satzgefüge: ungeachtet der Tatsache, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat großen Wert auf Pünktlichkeit gelegt.',
      'Sie hat großen Wert auf Pünktlichkeit genommen.',
      'Sie hat großen Wert auf Pünktlichkeit gestellt.',
      'Sie hat großen Wert auf Pünktlichkeit gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Wert legen auf + Akkusativ (= wichtig finden).',
    'exampleSentence': 'Sie hat großen Wert auf Pünktlichkeit gelegt.',
    'grammarRule': 'Funktionsverbgefüge: Wert legen auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zulasten der Steuerzahler wurden enorme Summen ausgegeben.',
      'Zulasten den Steuerzahlern wurden enorme Summen ausgegeben.',
      'Zulasten der Steuerzahlern wurden enorme Summen ausgegeben.',
      'Zulasten die Steuerzahler wurden enorme Summen ausgegeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zulasten verlangt den Genitiv: zulasten der Steuerzahler (Genitiv Plural).',
    'exampleSentence': 'Zulasten der Steuerzahler wurden enorme Summen ausgegeben.',
    'grammarRule': 'Präposition zulasten + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie bereits erwähnt, besteht dringender Handlungsbedarf.',
      'Wie bereits erwähnt, dringender Handlungsbedarf besteht.',
      'Wie bereits erwähnt besteht, dringender Handlungsbedarf.',
      'Wie bereits erwähnt, besteht dringender Handlungsbedarf besteht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der eingeschobenen Wendung wie bereits erwähnt steht das Verb an zweiter Stelle im Hauptsatz.',
    'exampleSentence': 'Wie bereits erwähnt, besteht dringender Handlungsbedarf.',
    'grammarRule': 'Wortstellung nach eingeschobener Wendung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Entlassung zahlreicher Mitarbeiter sorgte für Empörung.',
      'Die Entlassung zahlreichen Mitarbeiter sorgte für Empörung.',
      'Die Entlassung zahlreiche Mitarbeiter sorgte für Empörung.',
      'Die Entlassung zahlreicher Mitarbeiter sorgten für Empörung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Entlassung + Genitiv Plural (zahlreicher Mitarbeiter). Subjekt Singular → sorgte.',
    'exampleSentence': 'Die Entlassung zahlreicher Mitarbeiter sorgte für Empörung.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein kaum zu überblickendes Ausmaß an Schäden wurde festgestellt.',
      'Ein kaum zu überblickenden Ausmaß an Schäden wurde festgestellt.',
      'Ein kaum zu überblickender Ausmaß an Schäden wurde festgestellt.',
      'Ein kaum zu überblickendem Ausmaß an Schäden wurde festgestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu überblickendes (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein kaum zu überblickendes Ausmaß an Schäden wurde festgestellt.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Sprecherin erklärte, die Regierung plane neue Investitionen.',
      'Die Sprecherin erklärte, die Regierung plant neue Investitionen.',
      'Die Sprecherin erklärte, die Regierung plane neue Investitionen plant.',
      'Die Sprecherin erklärte, die Regierung plante neue Investitionen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: plane (3. Person Singular von planen).',
    'exampleSentence': 'Die Sprecherin erklärte, die Regierung plane neue Investitionen.',
    'grammarRule': 'Konjunktiv I: planen → plane',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Methode gilt als bewährt.',
      'Die Methode gilt als bewährte.',
      'Die Methode gilt für bewährt.',
      'Die Methode gilt wie bewährt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gelten als + Adjektiv (prädikativ): gilt als bewährt.',
    'exampleSentence': 'Die Methode gilt als bewährt.',
    'grammarRule': 'Passiversatzform: gelten als + Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insoweit die Voraussetzungen erfüllt sind, wird dem Antrag stattgegeben.',
      'Insoweit die Voraussetzungen erfüllt sind, dem Antrag wird stattgegeben.',
      'Insoweit die Voraussetzungen sind erfüllt, wird dem Antrag stattgegeben.',
      'Insoweit die Voraussetzungen erfüllt sind, wird stattgegeben dem Antrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit insoweit: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Insoweit die Voraussetzungen erfüllt sind, wird dem Antrag stattgegeben.',
    'grammarRule': 'Satzgefüge: insoweit + Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Behörde hat Stellung zu dem Vorfall genommen.',
      'Die Behörde hat Stellung zu dem Vorfall gebracht.',
      'Die Behörde hat Stellung zu dem Vorfall gestellt.',
      'Die Behörde hat Stellung zu dem Vorfall gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Stellung nehmen zu + Dativ (= sich äußern).',
    'exampleSentence': 'Die Behörde hat Stellung zu dem Vorfall genommen.',
    'grammarRule': 'Funktionsverbgefüge: Stellung nehmen zu',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anlässlich des Jubiläums wurde ein Fest veranstaltet.',
      'Anlässlich dem Jubiläum wurde ein Fest veranstaltet.',
      'Anlässlich des Jubiläum wurde ein Fest veranstaltet.',
      'Anlässlich den Jubiläums wurde ein Fest veranstaltet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anlässlich verlangt den Genitiv: anlässlich des Jubiläums.',
    'exampleSentence': 'Anlässlich des Jubiläums wurde ein Fest veranstaltet.',
    'grammarRule': 'Präposition anlässlich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insbesondere in ländlichen Gebieten fehlt es an Ärzten.',
      'Insbesondere in ländlichen Gebieten es fehlt an Ärzten.',
      'Insbesondere fehlt es in ländlichen Gebieten an Ärzten es.',
      'Insbesondere in ländlichen Gebieten fehlt an Ärzten es.'
    ],
    'correctAnswer': 0,
    'explanation': 'Adverbiale Bestimmung im Vorfeld: Verb an zweiter Stelle, dann Subjekt es.',
    'exampleSentence': 'Insbesondere in ländlichen Gebieten fehlt es an Ärzten.',
    'grammarRule': 'Wortstellung: adverbiale Bestimmung im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kürzung der Sozialleistungen betrifft viele Familien.',
      'Die Kürzung den Sozialleistungen betrifft viele Familien.',
      'Die Kürzung der Sozialleistungen betreffen viele Familien.',
      'Die Kürzung die Sozialleistungen betrifft viele Familien.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Kürzung + Genitiv Plural (der Sozialleistungen). Subjekt Singular → betrifft.',
    'exampleSentence': 'Die Kürzung der Sozialleistungen betrifft viele Familien.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p5-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die im vergangenen Jahr erzielten Fortschritte sind beachtlich.',
      'Die im vergangenen Jahr erzielte Fortschritte sind beachtlich.',
      'Die im vergangenen Jahr erzielter Fortschritte sind beachtlich.',
      'Die im vergangenen Jahr erzielende Fortschritte sind beachtlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: erzielten (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die im vergangenen Jahr erzielten Fortschritte sind beachtlich.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  }
];

export default questions;
