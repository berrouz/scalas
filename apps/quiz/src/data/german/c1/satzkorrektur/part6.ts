import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dank des schnellen Eingreifens konnte Schlimmeres verhindert werden.',
      'Dank dem schnellen Eingreifen konnte Schlimmeres verhindert werden.',
      'Dank des schnellen Eingreifens konnte Schlimmeres verhindern werden.',
      'Dank den schnellen Eingreifens konnte Schlimmeres verhindert werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dank kann sowohl mit Genitiv als auch mit Dativ stehen. Gehobener Stil: dank des schnellen Eingreifens (Genitiv).',
    'exampleSentence': 'Dank des schnellen Eingreifens konnte Schlimmeres verhindert werden.',
    'grammarRule': 'Präposition dank + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verabschiedung des Gesetzes wurde verschoben.',
      'Die Verabschiedung dem Gesetz wurde verschoben.',
      'Die Verabschiedung des Gesetzes wurden verschoben.',
      'Die Verabschiedung das Gesetz wurde verschoben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verabschiedung + Genitiv (des Gesetzes). Subjekt Singular → wurde.',
    'exampleSentence': 'Die Verabschiedung des Gesetzes wurde verschoben.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der für morgen geplante Ausflug muss leider ausfallen.',
      'Der für morgen geplanten Ausflug muss leider ausfallen.',
      'Der für morgen geplanter Ausflug muss leider ausfallen.',
      'Der für morgen planende Ausflug muss leider ausfallen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: geplante (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der für morgen geplante Ausflug muss leider ausfallen.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Autor schreibt, das Phänomen verdiene mehr Aufmerksamkeit.',
      'Der Autor schreibt, das Phänomen verdient mehr Aufmerksamkeit.',
      'Der Autor schreibt, das Phänomen verdiene mehr Aufmerksamkeit verdient.',
      'Der Autor schreibt, das Phänomen verdiente mehr Aufmerksamkeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: verdiene (3. Person Singular von verdienen).',
    'exampleSentence': 'Der Autor schreibt, das Phänomen verdiene mehr Aufmerksamkeit.',
    'grammarRule': 'Konjunktiv I: verdienen → verdiene',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Text lässt sich auf verschiedene Weisen interpretieren.',
      'Der Text lässt auf verschiedene Weisen sich interpretieren.',
      'Der Text lässt sich auf verschiedene Weisen zu interpretieren.',
      'Der Text lässt sich auf verschiedene Weisen interpretiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lässt sich interpretieren (= kann interpretiert werden).',
    'exampleSentence': 'Der Text lässt sich auf verschiedene Weisen interpretieren.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während die einen protestierten, blieben die anderen gelassen.',
      'Während die einen protestierten, die anderen blieben gelassen.',
      'Während protestierten die einen, blieben die anderen gelassen.',
      'Während die einen protestierten, blieben gelassen die anderen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporalsatz mit während (adversativ): Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Während die einen protestierten, blieben die anderen gelassen.',
    'grammarRule': 'Satzgefüge: während (adversativ)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ergebnisse wurden zur Verfügung gestellt.',
      'Die Ergebnisse wurden zur Verfügung gebracht.',
      'Die Ergebnisse wurden zur Verfügung genommen.',
      'Die Ergebnisse wurden zur Verfügung gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zur Verfügung stellen (= bereitstellen).',
    'exampleSentence': 'Die Ergebnisse wurden zur Verfügung gestellt.',
    'grammarRule': 'Funktionsverbgefüge: zur Verfügung stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Fernab jeglichen Lärms fand er endlich Ruhe.',
      'Fernab jeglichem Lärm fand er endlich Ruhe.',
      'Fernab jeglicher Lärm fand er endlich Ruhe.',
      'Fernab jeglichen Lärm fand er endlich Ruhe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Fernab verlangt den Genitiv: fernab jeglichen Lärms.',
    'exampleSentence': 'Fernab jeglichen Lärms fand er endlich Ruhe.',
    'grammarRule': 'Präposition fernab + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dennoch darf man die Risiken nicht außer Acht lassen.',
      'Dennoch man darf die Risiken nicht außer Acht lassen.',
      'Dennoch darf die Risiken man nicht außer Acht lassen.',
      'Dennoch die Risiken darf man nicht außer Acht lassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dennoch im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Dennoch darf man die Risiken nicht außer Acht lassen.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Zusammenlegung der Abteilungen spart Kosten.',
      'Die Zusammenlegung den Abteilungen spart Kosten.',
      'Die Zusammenlegung der Abteilungen sparen Kosten.',
      'Die Zusammenlegung die Abteilungen spart Kosten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Zusammenlegung + Genitiv Plural (der Abteilungen). Subjekt Singular → spart.',
    'exampleSentence': 'Die Zusammenlegung der Abteilungen spart Kosten.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die stark zunehmende Digitalisierung verändert viele Branchen.',
      'Die stark zunehmenden Digitalisierung verändert viele Branchen.',
      'Die stark zunehmender Digitalisierung verändert viele Branchen.',
      'Die stark zugenommene Digitalisierung verändert viele Branchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: zunehmende (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die stark zunehmende Digitalisierung verändert viele Branchen.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Sachverständige erklärte, die Brücke weise erhebliche Mängel auf.',
      'Der Sachverständige erklärte, die Brücke weist erhebliche Mängel auf.',
      'Der Sachverständige erklärte, die Brücke weise erhebliche Mängel auf weist.',
      'Der Sachverständige erklärte, die Brücke wiese erhebliche Mängel auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: weise ... auf (3. Person Singular von aufweisen).',
    'exampleSentence': 'Der Sachverständige erklärte, die Brücke weise erhebliche Mängel auf.',
    'grammarRule': 'Konjunktiv I: aufweisen → weise auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aussage ist nicht widerlegbar.',
      'Die Aussage ist nicht widerlegbare.',
      'Die Aussage ist nicht zu widerlegbar.',
      'Die Aussage ist nicht widerlegbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: widerlegbar (= kann widerlegt werden). Prädikativ.',
    'exampleSentence': 'Die Aussage ist nicht widerlegbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Als ob er nichts wüsste, stellte er sich unwissend.',
      'Als ob er nichts wüsste, er stellte sich unwissend.',
      'Als ob er wüsste nichts, stellte er sich unwissend.',
      'Als ob er nichts wüsste, stellte unwissend sich er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalsatz mit als ob: Nebensatz mit Konjunktiv II und Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Als ob er nichts wüsste, stellte er sich unwissend.',
    'grammarRule': 'Satzgefüge: als ob + Konjunktiv II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Firma hat Einfluss auf die Entscheidung genommen.',
      'Die Firma hat Einfluss auf die Entscheidung gemacht.',
      'Die Firma hat Einfluss auf die Entscheidung gestellt.',
      'Die Firma hat Einfluss auf die Entscheidung gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Einfluss nehmen auf + Akkusativ (= beeinflussen).',
    'exampleSentence': 'Die Firma hat Einfluss auf die Entscheidung genommen.',
    'grammarRule': 'Funktionsverbgefüge: Einfluss nehmen auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mittels eines speziellen Verfahrens wurde das Problem gelöst.',
      'Mittels einem speziellen Verfahren wurde das Problem gelöst.',
      'Mittels eines speziellen Verfahren wurde das Problem gelöst.',
      'Mittels ein spezielles Verfahren wurde das Problem gelöst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mittels verlangt den Genitiv: mittels eines speziellen Verfahrens.',
    'exampleSentence': 'Mittels eines speziellen Verfahrens wurde das Problem gelöst.',
    'grammarRule': 'Präposition mittels + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Folglich muss die gesamte Planung überarbeitet werden.',
      'Folglich die gesamte Planung muss überarbeitet werden.',
      'Folglich muss überarbeitet werden die gesamte Planung.',
      'Folglich die gesamte Planung überarbeitet werden muss.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach folglich im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Folglich muss die gesamte Planung überarbeitet werden.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Erweiterung des Flughafens stößt auf Widerstand.',
      'Die Erweiterung dem Flughafen stößt auf Widerstand.',
      'Die Erweiterung des Flughafen stößt auf Widerstand.',
      'Die Erweiterung des Flughafens stoßen auf Widerstand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Erweiterung + Genitiv (des Flughafens). Subjekt Singular → stößt.',
    'exampleSentence': 'Die Erweiterung des Flughafens stößt auf Widerstand.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die in der Sitzung getroffenen Vereinbarungen sind bindend.',
      'Die in der Sitzung getroffene Vereinbarungen sind bindend.',
      'Die in der Sitzung getroffener Vereinbarungen sind bindend.',
      'Die in der Sitzung treffenden Vereinbarungen sind bindend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: getroffenen (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die in der Sitzung getroffenen Vereinbarungen sind bindend.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man vermutet, der Täter halte sich im Ausland auf.',
      'Man vermutet, der Täter hält sich im Ausland auf.',
      'Man vermutet, der Täter halte sich im Ausland auf hält.',
      'Man vermutet, der Täter hielte sich im Ausland auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: halte ... auf (3. Person Singular von sich aufhalten).',
    'exampleSentence': 'Man vermutet, der Täter halte sich im Ausland auf.',
    'grammarRule': 'Konjunktiv I: sich aufhalten → halte sich auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bleibt festzustellen, ob die Maßnahme wirksam war.',
      'Es bleibt feststellen, ob die Maßnahme wirksam war.',
      'Es bleibt festzustellen zu, ob die Maßnahme wirksam war.',
      'Es bleibt festgestellt, ob die Maßnahme wirksam war.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: bleiben + zu + Infinitiv: bleibt festzustellen (= muss noch festgestellt werden).',
    'exampleSentence': 'Es bleibt festzustellen, ob die Maßnahme wirksam war.',
    'grammarRule': 'Passiversatzform: bleiben + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selbst wenn man alles berücksichtigt, bleibt ein Restrisiko.',
      'Selbst wenn man alles berücksichtigt, ein Restrisiko bleibt.',
      'Selbst wenn man berücksichtigt alles, bleibt ein Restrisiko.',
      'Selbst wenn man alles berücksichtigt, bleibt ein Restrisiko bleibt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit selbst wenn: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Selbst wenn man alles berücksichtigt, bleibt ein Restrisiko.',
    'grammarRule': 'Satzgefüge: selbst wenn + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Bericht hat Aufsehen erregt.',
      'Der Bericht hat Aufsehen gemacht.',
      'Der Bericht hat Aufsehen genommen.',
      'Der Bericht hat Aufsehen gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Aufsehen erregen (= Aufmerksamkeit erwecken).',
    'exampleSentence': 'Der Bericht hat Aufsehen erregt.',
    'grammarRule': 'Funktionsverbgefüge: Aufsehen erregen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unweit des Stadtzentrums befindet sich ein großer Park.',
      'Unweit dem Stadtzentrum befindet sich ein großer Park.',
      'Unweit des Stadtzentrum befindet sich ein großer Park.',
      'Unweit den Stadtzentrums befindet sich ein großer Park.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unweit verlangt den Genitiv: unweit des Stadtzentrums.',
    'exampleSentence': 'Unweit des Stadtzentrums befindet sich ein großer Park.',
    'grammarRule': 'Präposition unweit + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Schwerlich wird man eine bessere Lösung finden können.',
      'Schwerlich man wird eine bessere Lösung finden können.',
      'Schwerlich wird eine bessere Lösung finden können man.',
      'Schwerlich eine bessere Lösung wird man finden können.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach schwerlich im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Schwerlich wird man eine bessere Lösung finden können.',
    'grammarRule': 'Inversion nach einschränkendem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Angleichung der Gehälter ist ein langwieriger Prozess.',
      'Die Angleichung den Gehältern ist ein langwieriger Prozess.',
      'Die Angleichung der Gehälter sind ein langwieriger Prozess.',
      'Die Angleichung die Gehälter ist ein langwieriger Prozess.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Angleichung + Genitiv Plural (der Gehälter). Subjekt Singular → ist.',
    'exampleSentence': 'Die Angleichung der Gehälter ist ein langwieriger Prozess.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein nur schwer zu erklärendes Phänomen wurde beobachtet.',
      'Ein nur schwer zu erklärenden Phänomen wurde beobachtet.',
      'Ein nur schwer zu erklärender Phänomen wurde beobachtet.',
      'Ein nur schwer zu erklärendem Phänomen wurde beobachtet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu erklärendes (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein nur schwer zu erklärendes Phänomen wurde beobachtet.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gerüchten zufolge stehe eine Fusion unmittelbar bevor.',
      'Gerüchten zufolge steht eine Fusion unmittelbar bevor.',
      'Gerüchten zufolge stehe eine Fusion unmittelbar bevor steht.',
      'Gerüchten zufolge stünde eine Fusion unmittelbar bevor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: stehe ... bevor (3. Person Singular von bevorstehen).',
    'exampleSentence': 'Gerüchten zufolge stehe eine Fusion unmittelbar bevor.',
    'grammarRule': 'Konjunktiv I: bevorstehen → stehe bevor',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Diese Entwicklung ist als besorgniserregend zu bewerten.',
      'Diese Entwicklung ist als besorgniserregend bewerten.',
      'Diese Entwicklung ist als besorgniserregend zu bewertet.',
      'Diese Entwicklung ist als besorgniserregend bewertet zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist zu bewerten (= muss bewertet werden).',
    'exampleSentence': 'Diese Entwicklung ist als besorgniserregend zu bewerten.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So sehr man sich auch bemüht, perfekte Ergebnisse sind selten.',
      'So sehr man sich auch bemüht, selten sind perfekte Ergebnisse.',
      'So sehr man bemüht sich auch, perfekte Ergebnisse sind selten.',
      'So sehr man sich bemüht auch, perfekte Ergebnisse sind selten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz: so sehr + Subjekt + Reflexivpronomen + auch + Verb am Ende. Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'So sehr man sich auch bemüht, perfekte Ergebnisse sind selten.',
    'grammarRule': 'Konzessivsatz: so sehr ... auch',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Polizei hat Ermittlungen aufgenommen.',
      'Die Polizei hat Ermittlungen gemacht.',
      'Die Polizei hat Ermittlungen gestellt.',
      'Die Polizei hat Ermittlungen gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Ermittlungen aufnehmen (= zu ermitteln beginnen).',
    'exampleSentence': 'Die Polizei hat Ermittlungen aufgenommen.',
    'grammarRule': 'Funktionsverbgefüge: Ermittlungen aufnehmen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zufolge eines Presseberichts plant die Stadt den Umbau.',
      'Zufolge einem Pressebericht plant die Stadt den Umbau.',
      'Einem Pressebericht zufolge plant die Stadt den Umbau.',
      'Eines Presseberichts zufolge plant die Stadt den Umbau.'
    ],
    'correctAnswer': 2,
    'explanation': 'Zufolge steht nachgestellt mit Dativ: einem Pressebericht zufolge.',
    'exampleSentence': 'Einem Pressebericht zufolge plant die Stadt den Umbau.',
    'grammarRule': 'Nachgestellte Präposition zufolge + Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allenfalls kann man von einem Teilerfolg sprechen.',
      'Allenfalls man kann von einem Teilerfolg sprechen.',
      'Allenfalls kann von einem Teilerfolg sprechen man.',
      'Allenfalls von einem Teilerfolg kann man sprechen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach allenfalls im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Allenfalls kann man von einem Teilerfolg sprechen.',
    'grammarRule': 'Inversion nach einschränkendem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Beschleunigung des Verfahrens liegt im Interesse aller.',
      'Die Beschleunigung dem Verfahren liegt im Interesse aller.',
      'Die Beschleunigung des Verfahrens liegen im Interesse aller.',
      'Die Beschleunigung das Verfahren liegt im Interesse aller.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Beschleunigung + Genitiv (des Verfahrens). Subjekt Singular → liegt.',
    'exampleSentence': 'Die Beschleunigung des Verfahrens liegt im Interesse aller.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der auf internationaler Ebene agierende Konzern expandiert.',
      'Der auf internationaler Ebene agierenden Konzern expandiert.',
      'Der auf internationaler Ebene agierender Konzern expandiert.',
      'Der auf internationaler Ebene agierte Konzern expandiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: agierende (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der auf internationaler Ebene agierende Konzern expandiert.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Diplomat betonte, beide Seiten strebten eine friedliche Lösung an.',
      'Der Diplomat betonte, beide Seiten streben eine friedliche Lösung an.',
      'Der Diplomat betonte, beide Seiten strebten eine friedliche Lösung an streben.',
      'Der Diplomat betonte, beide Seiten strebe eine friedliche Lösung an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II als Ersatz (da Konjunktiv I streben mit Indikativ identisch): strebten ... an.',
    'exampleSentence': 'Der Diplomat betonte, beide Seiten strebten eine friedliche Lösung an.',
    'grammarRule': 'Konjunktiv II als Ersatz in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Medikament ist nur auf Rezept erhältlich.',
      'Das Medikament ist nur auf Rezept erhältliche.',
      'Das Medikament ist nur auf Rezept zu erhältlich.',
      'Das Medikament ist nur auf Rezept erhältlichem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -lich: erhältlich (= kann erhalten werden). Prädikativ.',
    'exampleSentence': 'Das Medikament ist nur auf Rezept erhältlich.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -lich',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sowohl in der Theorie als auch in der Praxis hat sich der Ansatz bewährt.',
      'Sowohl in der Theorie als auch in der Praxis hat der Ansatz sich bewährt.',
      'Sowohl in der Theorie als in der Praxis auch hat sich der Ansatz bewährt.',
      'Sowohl in der Theorie als auch in der Praxis haben sich der Ansatz bewährt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Sowohl ... als auch mit Präpositionalphrasen im Vorfeld: Verb an zweiter Stelle, Subjekt Singular → hat.',
    'exampleSentence': 'Sowohl in der Theorie als auch in der Praxis hat sich der Ansatz bewährt.',
    'grammarRule': 'Satzgefüge: sowohl ... als auch im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verhandlungen wurden zum Abbruch gebracht.',
      'Die Verhandlungen wurden zum Abbruch genommen.',
      'Die Verhandlungen wurden zum Abbruch gestellt.',
      'Die Verhandlungen wurden zum Abbruch gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zum Abbruch bringen (= abbrechen lassen).',
    'exampleSentence': 'Die Verhandlungen wurden zum Abbruch gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Abbruch bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bedauerlicherweise ist es zu einem Missverständnis gekommen.',
      'Bedauerlicherweise es ist zu einem Missverständnis gekommen.',
      'Bedauerlicherweise ist zu einem Missverständnis es gekommen.',
      'Bedauerlicherweise gekommen ist es zu einem Missverständnis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach einem Kommentaradverb im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Bedauerlicherweise ist es zu einem Missverständnis gekommen.',
    'grammarRule': 'Wortstellung nach Kommentaradverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verschärfung der Grenzkontrollen ist umstritten.',
      'Die Verschärfung den Grenzkontrollen ist umstritten.',
      'Die Verschärfung der Grenzkontrollen sind umstritten.',
      'Die Verschärfung die Grenzkontrollen ist umstritten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verschärfung + Genitiv Plural (der Grenzkontrollen). Subjekt Singular → ist.',
    'exampleSentence': 'Die Verschärfung der Grenzkontrollen ist umstritten.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die unter großem Zeitdruck erstellte Studie weist Lücken auf.',
      'Die unter großem Zeitdruck erstellten Studie weist Lücken auf.',
      'Die unter großem Zeitdruck erstellter Studie weist Lücken auf.',
      'Die unter großem Zeitdruck erstellende Studie weist Lücken auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: erstellte (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die unter großem Zeitdruck erstellte Studie weist Lücken auf.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Direktorin erklärte, sie wolle die Schule modernisieren.',
      'Die Direktorin erklärte, sie will die Schule modernisieren.',
      'Die Direktorin erklärte, sie wolle die Schule modernisieren will.',
      'Die Direktorin erklärte, sie wollte die Schule modernisieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: wolle (3. Person Singular von wollen).',
    'exampleSentence': 'Die Direktorin erklärte, sie wolle die Schule modernisieren.',
    'grammarRule': 'Konjunktiv I: wollen → wolle',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Zusammenhang ist empirisch nachweisbar.',
      'Der Zusammenhang ist empirisch nachweisbare.',
      'Der Zusammenhang ist empirisch zu nachweisbar.',
      'Der Zusammenhang ist empirisch nachweisbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: nachweisbar (= kann nachgewiesen werden). Prädikativ.',
    'exampleSentence': 'Der Zusammenhang ist empirisch nachweisbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ganz gleich, was passiert, wir stehen zusammen.',
      'Ganz gleich, was passiert, zusammen stehen wir.',
      'Ganz gleich, was passiert es, wir stehen zusammen.',
      'Ganz gleich, was passiert, stehen wir zusammen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit ganz gleich, was: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Ganz gleich, was passiert, wir stehen zusammen.',
    'grammarRule': 'Satzgefüge: ganz gleich + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Antrag wurde in Bearbeitung genommen.',
      'Der Antrag wurde in Bearbeitung gestellt.',
      'Der Antrag wurde in Bearbeitung gebracht.',
      'Der Antrag wurde in Bearbeitung gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Bearbeitung nehmen (= beginnen zu bearbeiten).',
    'exampleSentence': 'Der Antrag wurde in Bearbeitung genommen.',
    'grammarRule': 'Funktionsverbgefüge: in Bearbeitung nehmen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Längs des Flussufers erstreckt sich ein Wanderweg.',
      'Längs dem Flussufer erstreckt sich ein Wanderweg.',
      'Längs des Flussufer erstreckt sich ein Wanderweg.',
      'Längs den Flussufers erstreckt sich ein Wanderweg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Längs verlangt den Genitiv: längs des Flussufers.',
    'exampleSentence': 'Längs des Flussufers erstreckt sich ein Wanderweg.',
    'grammarRule': 'Präposition längs + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zugegebenermaßen war die Planung mangelhaft.',
      'Zugegebenermaßen die Planung war mangelhaft.',
      'Zugegebenermaßen war mangelhaft die Planung.',
      'Zugegebenermaßen mangelhaft war die Planung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach einem Kommentaradverb im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Zugegebenermaßen war die Planung mangelhaft.',
    'grammarRule': 'Wortstellung nach Kommentaradverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Überarbeitung des Lehrplans ist dringend notwendig.',
      'Die Überarbeitung dem Lehrplan ist dringend notwendig.',
      'Die Überarbeitung des Lehrplans sind dringend notwendig.',
      'Die Überarbeitung den Lehrplans ist dringend notwendig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Überarbeitung + Genitiv (des Lehrplans). Subjekt Singular → ist.',
    'exampleSentence': 'Die Überarbeitung des Lehrplans ist dringend notwendig.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p6-150',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Trotz + Genitiv',
    'question': 'Welcher Satz ist korrekt?',
    'options': ['Trotz des schlechten Wetters gingen wir spazieren.', 'Trotz dem schlechten Wetter gingen wir spazieren.', 'Trotz schlechtem Wetter gingen wir spazieren.', 'Trotz des schlechtes Wetters gingen wir spazieren.'],
    'correctAnswer': 0,
    'explanation': '\'Trotz\' + Genitiv (standardsprachlich).',
    'tags': ['satzkorrektur']
  }
];

export default questions;
