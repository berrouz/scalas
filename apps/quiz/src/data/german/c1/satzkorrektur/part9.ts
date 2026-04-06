import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorstandsvorsitzende erklärte, die Bilanz sei positiv ausgefallen.',
      'Der Vorstandsvorsitzende erklärte, die Bilanz ist positiv ausgefallen.',
      'Der Vorstandsvorsitzende erklärte, die Bilanz sei positiv ausgefallen ist.',
      'Der Vorstandsvorsitzende erklärte, die Bilanz wäre positiv ausgefallen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt mit sein: sei ausgefallen (indirekte Rede).',
    'exampleSentence': 'Der Vorstandsvorsitzende erklärte, die Bilanz sei positiv ausgefallen.',
    'grammarRule': 'Konjunktiv I Perfekt: sei + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Gewährung des Kredits hängt von der Bonität ab.',
      'Die Gewährung dem Kredit hängt von der Bonität ab.',
      'Die Gewährung des Kredits hängen von der Bonität ab.',
      'Die Gewährung den Kredits hängt von der Bonität ab.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Gewährung + Genitiv (des Kredits). Subjekt Singular → hängt.',
    'exampleSentence': 'Die Gewährung des Kredits hängt von der Bonität ab.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das am häufigsten verwendete Material ist Aluminium.',
      'Das am häufigsten verwendeten Material ist Aluminium.',
      'Das am häufigsten verwendetes Material ist Aluminium.',
      'Das am häufigsten verwendende Material ist Aluminium.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Attribut: verwendete (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das am häufigsten verwendete Material ist Aluminium.',
    'grammarRule': 'Partizip II als Attribut mit Superlativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Theorie ist experimentell überprüfbar.',
      'Die Theorie ist experimentell überprüfbare.',
      'Die Theorie ist experimentell zu überprüfbar.',
      'Die Theorie ist experimentell überprüfbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: überprüfbar (= kann überprüft werden). Prädikativ.',
    'exampleSentence': 'Die Theorie ist experimentell überprüfbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausgesetzt, man hält sich an die Regeln, steht dem Erfolg nichts im Wege.',
      'Vorausgesetzt, man hält sich an die Regeln, dem Erfolg steht nichts im Wege.',
      'Vorausgesetzt, man sich hält an die Regeln, steht dem Erfolg nichts im Wege.',
      'Vorausgesetzt, man hält sich an die Regeln, steht nichts im Wege dem Erfolg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit vorausgesetzt: Hauptsatzwortstellung im Nebensatz, Inversion im Hauptsatz.',
    'exampleSentence': 'Vorausgesetzt, man hält sich an die Regeln, steht dem Erfolg nichts im Wege.',
    'grammarRule': 'Satzgefüge: vorausgesetzt + Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Behörde hat Schritte in die Wege geleitet.',
      'Die Behörde hat Schritte in die Wege gemacht.',
      'Die Behörde hat Schritte in die Wege genommen.',
      'Die Behörde hat Schritte in die Wege gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in die Wege leiten (= initiieren).',
    'exampleSentence': 'Die Behörde hat Schritte in die Wege geleitet.',
    'grammarRule': 'Funktionsverbgefüge: in die Wege leiten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet seiner Bedenken stimmte er dem Vorschlag zu.',
      'Ungeachtet seinen Bedenken stimmte er dem Vorschlag zu.',
      'Ungeachtet seine Bedenken stimmte er dem Vorschlag zu.',
      'Ungeachtet seinem Bedenken stimmte er dem Vorschlag zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ungeachtet verlangt den Genitiv: ungeachtet seiner Bedenken.',
    'exampleSentence': 'Ungeachtet seiner Bedenken stimmte er dem Vorschlag zu.',
    'grammarRule': 'Präposition ungeachtet + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hingegen vertritt die Opposition eine andere Auffassung.',
      'Hingegen die Opposition vertritt eine andere Auffassung.',
      'Hingegen vertritt eine andere Auffassung die Opposition.',
      'Hingegen eine andere Auffassung vertritt die Opposition.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach hingegen im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Hingegen vertritt die Opposition eine andere Auffassung.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bewältigung der Herausforderungen erfordert Zusammenarbeit.',
      'Die Bewältigung den Herausforderungen erfordert Zusammenarbeit.',
      'Die Bewältigung der Herausforderungen erfordern Zusammenarbeit.',
      'Die Bewältigung die Herausforderungen erfordert Zusammenarbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bewältigung + Genitiv Plural (der Herausforderungen). Subjekt Singular → erfordert.',
    'exampleSentence': 'Die Bewältigung der Herausforderungen erfordert Zusammenarbeit.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die fortschreitende Globalisierung bringt neue Herausforderungen.',
      'Die fortschreitenden Globalisierung bringt neue Herausforderungen.',
      'Die fortschreitender Globalisierung bringt neue Herausforderungen.',
      'Die fortgeschrittene Globalisierung bringt neue Herausforderungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Attribut: fortschreitende (Nominativ feminin Singular mit bestimmtem Artikel: -e). Partizip I drückt Gleichzeitigkeit/Andauern aus.',
    'exampleSentence': 'Die fortschreitende Globalisierung bringt neue Herausforderungen.',
    'grammarRule': 'Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Gutachter stellte fest, die Konstruktion weise keine Mängel auf.',
      'Der Gutachter stellte fest, die Konstruktion weist keine Mängel auf.',
      'Der Gutachter stellte fest, die Konstruktion weise keine Mängel auf weist.',
      'Der Gutachter stellte fest, die Konstruktion wiese keine Mängel auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: weise ... auf (3. Person Singular von aufweisen).',
    'exampleSentence': 'Der Gutachter stellte fest, die Konstruktion weise keine Mängel auf.',
    'grammarRule': 'Konjunktiv I: aufweisen → weise auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bleibt abzuwarten, wie sich die Dinge entwickeln.',
      'Es bleibt abwarten, wie sich die Dinge entwickeln.',
      'Es bleibt abzuwarten zu, wie sich die Dinge entwickeln.',
      'Es bleibt abgewartet, wie sich die Dinge entwickeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: bleiben + zu + Infinitiv: bleibt abzuwarten.',
    'exampleSentence': 'Es bleibt abzuwarten, wie sich die Dinge entwickeln.',
    'grammarRule': 'Passiversatzform: bleiben + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Würde man genauer hinsehen, fände man zahlreiche Fehler.',
      'Würde man genauer hinsehen, man fände zahlreiche Fehler.',
      'Würde man genauer hinsehen, fände zahlreiche Fehler man.',
      'Würde genauer man hinsehen, fände man zahlreiche Fehler.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: Verb am Anfang im Nebensatz, Inversion im Hauptsatz.',
    'exampleSentence': 'Würde man genauer hinsehen, fände man zahlreiche Fehler.',
    'grammarRule': 'Irrealer Konditionalsatz ohne wenn',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorfall hat Empörung ausgelöst.',
      'Der Vorfall hat Empörung gemacht.',
      'Der Vorfall hat Empörung genommen.',
      'Der Vorfall hat Empörung gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Empörung auslösen (= empören).',
    'exampleSentence': 'Der Vorfall hat Empörung ausgelöst.',
    'grammarRule': 'Funktionsverbgefüge: Empörung auslösen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Innerhalb kürzester Zeit hat sich die Lage verändert.',
      'Innerhalb kürzester Zeit haben sich die Lage verändert.',
      'Innerhalb kürzesten Zeit hat sich die Lage verändert.',
      'Innerhalb kürzeste Zeit hat sich die Lage verändert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Innerhalb + Genitiv: innerhalb kürzester Zeit (Genitiv feminin). Subjekt Singular → hat.',
    'exampleSentence': 'Innerhalb kürzester Zeit hat sich die Lage verändert.',
    'grammarRule': 'Präposition innerhalb + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Indessen hat sich an der grundsätzlichen Problematik nichts geändert.',
      'Indessen an der grundsätzlichen Problematik hat sich nichts geändert.',
      'Indessen hat an der grundsätzlichen Problematik nichts sich geändert.',
      'Indessen nichts hat sich an der grundsätzlichen Problematik geändert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach indessen im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Indessen hat sich an der grundsätzlichen Problematik nichts geändert.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Offenlegung der Finanzdaten ist gesetzlich vorgeschrieben.',
      'Die Offenlegung den Finanzdaten ist gesetzlich vorgeschrieben.',
      'Die Offenlegung der Finanzdaten sind gesetzlich vorgeschrieben.',
      'Die Offenlegung die Finanzdaten ist gesetzlich vorgeschrieben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Offenlegung + Genitiv Plural (der Finanzdaten). Subjekt Singular → ist.',
    'exampleSentence': 'Die Offenlegung der Finanzdaten ist gesetzlich vorgeschrieben.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die im Ausland produzierte Ware muss verzollt werden.',
      'Die im Ausland produzierten Ware muss verzollt werden.',
      'Die im Ausland produzierter Ware muss verzollt werden.',
      'Die im Ausland produzierende Ware muss verzollt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: produzierte (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die im Ausland produzierte Ware muss verzollt werden.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man munkelt, der Konzern stehe vor dem Aus.',
      'Man munkelt, der Konzern steht vor dem Aus.',
      'Man munkelt, der Konzern stehe vor dem Aus steht.',
      'Man munkelt, der Konzern stünde vor dem Aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: stehe (3. Person Singular von stehen).',
    'exampleSentence': 'Man munkelt, der Konzern stehe vor dem Aus.',
    'grammarRule': 'Konjunktiv I: stehen → stehe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Geräte sind vor Gebrauch zu überprüfen.',
      'Die Geräte sind vor Gebrauch überprüfen zu.',
      'Die Geräte sind vor Gebrauch zu überprüft.',
      'Die Geräte sind vor Gebrauch überprüfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind zu überprüfen (= müssen überprüft werden).',
    'exampleSentence': 'Die Geräte sind vor Gebrauch zu überprüfen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So paradox es auch klingen mag, die Maßnahme hat Wirkung gezeigt.',
      'So paradox es auch klingen mag, Wirkung hat die Maßnahme gezeigt.',
      'So paradox es klingen auch mag, die Maßnahme hat Wirkung gezeigt.',
      'So paradox es auch mag klingen, die Maßnahme hat Wirkung gezeigt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz: so + Adjektiv + auch + Verb (mag am Ende). Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'So paradox es auch klingen mag, die Maßnahme hat Wirkung gezeigt.',
    'grammarRule': 'Konzessivsatz: so + Adjektiv ... auch',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat seine Zustimmung zum Ausdruck gebracht.',
      'Er hat seine Zustimmung zum Ausdruck genommen.',
      'Er hat seine Zustimmung zum Ausdruck gestellt.',
      'Er hat seine Zustimmung zum Ausdruck gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zum Ausdruck bringen (= ausdrücken).',
    'exampleSentence': 'Er hat seine Zustimmung zum Ausdruck gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Ausdruck bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wegen des starken Regens wurde das Spiel abgebrochen.',
      'Wegen dem starken Regen wurde das Spiel abgebrochen.',
      'Wegen des starken Regen wurde das Spiel abgebrochen.',
      'Wegen den starken Regens wurde das Spiel abgebrochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wegen verlangt standardsprachlich den Genitiv: wegen des starken Regens.',
    'exampleSentence': 'Wegen des starken Regens wurde das Spiel abgebrochen.',
    'grammarRule': 'Präposition wegen + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dessen ungeachtet bleibt die Strategie unverändert.',
      'Dessen ungeachtet die Strategie bleibt unverändert.',
      'Dessen ungeachtet bleibt unverändert die Strategie.',
      'Dessen ungeachtet unverändert bleibt die Strategie.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dessen ungeachtet im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Dessen ungeachtet bleibt die Strategie unverändert.',
    'grammarRule': 'Wortstellung nach Pronominaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bekämpfung der Armut bleibt eine zentrale Aufgabe.',
      'Die Bekämpfung den Armut bleibt eine zentrale Aufgabe.',
      'Die Bekämpfung der Armut bleiben eine zentrale Aufgabe.',
      'Die Bekämpfung die Armut bleibt eine zentrale Aufgabe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bekämpfung + Genitiv (der Armut). Subjekt Singular → bleibt.',
    'exampleSentence': 'Die Bekämpfung der Armut bleibt eine zentrale Aufgabe.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die weit über die Grenzen hinaus bekannte Universität zieht viele Studenten an.',
      'Die weit über die Grenzen hinaus bekannten Universität zieht viele Studenten an.',
      'Die weit über die Grenzen hinaus bekannter Universität zieht viele Studenten an.',
      'Die weit über die Grenzen hinaus bekanntende Universität zieht viele Studenten an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: bekannte (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die weit über die Grenzen hinaus bekannte Universität zieht viele Studenten an.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wurde behauptet, die Firma habe Steuern hinterzogen.',
      'Es wurde behauptet, die Firma hat Steuern hinterzogen.',
      'Es wurde behauptet, die Firma habe Steuern hinterzogen hat.',
      'Es wurde behauptet, die Firma hätte Steuern hinterzogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe hinterzogen (indirekte Rede).',
    'exampleSentence': 'Es wurde behauptet, die Firma habe Steuern hinterzogen.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Sicherheitsvorkehrungen lassen sich verbessern.',
      'Die Sicherheitsvorkehrungen lassen verbessern sich.',
      'Die Sicherheitsvorkehrungen lassen sich verbessern zu.',
      'Die Sicherheitsvorkehrungen lassen sich verbessert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lassen sich verbessern (= können verbessert werden).',
    'exampleSentence': 'Die Sicherheitsvorkehrungen lassen sich verbessern.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wiewohl die Chancen gering standen, wagte er den Versuch.',
      'Wiewohl die Chancen gering standen, er wagte den Versuch.',
      'Wiewohl die Chancen standen gering, wagte er den Versuch.',
      'Wiewohl die Chancen gering standen, wagte den Versuch er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit wiewohl: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Wiewohl die Chancen gering standen, wagte er den Versuch.',
    'grammarRule': 'Satzgefüge: wiewohl + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Regierung hat Rechenschaft über ihre Ausgaben abgelegt.',
      'Die Regierung hat Rechenschaft über ihre Ausgaben gemacht.',
      'Die Regierung hat Rechenschaft über ihre Ausgaben genommen.',
      'Die Regierung hat Rechenschaft über ihre Ausgaben gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Rechenschaft ablegen über + Akkusativ (= sich verantworten).',
    'exampleSentence': 'Die Regierung hat Rechenschaft über ihre Ausgaben abgelegt.',
    'grammarRule': 'Funktionsverbgefüge: Rechenschaft ablegen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Um des lieben Friedens willen stimmte sie zu.',
      'Um dem lieben Frieden willen stimmte sie zu.',
      'Um den lieben Friedens willen stimmte sie zu.',
      'Um die liebe Frieden willen stimmte sie zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Um ... willen verlangt den Genitiv: um des lieben Friedens willen.',
    'exampleSentence': 'Um des lieben Friedens willen stimmte sie zu.',
    'grammarRule': 'Präposition um ... willen + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aus diesem Grund erscheint eine Neubewertung sinnvoll.',
      'Aus diesem Grund eine Neubewertung erscheint sinnvoll.',
      'Aus diesem Grund erscheint sinnvoll eine Neubewertung.',
      'Aus diesem Grund sinnvoll erscheint eine Neubewertung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Adverbiale Bestimmung im Vorfeld: Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Aus diesem Grund erscheint eine Neubewertung sinnvoll.',
    'grammarRule': 'Wortstellung: kausale Bestimmung im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Unterbringung der Flüchtlinge stellt eine Herausforderung dar.',
      'Die Unterbringung den Flüchtlingen stellt eine Herausforderung dar.',
      'Die Unterbringung der Flüchtlinge stellen eine Herausforderung dar.',
      'Die Unterbringung die Flüchtlinge stellt eine Herausforderung dar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Unterbringung + Genitiv Plural (der Flüchtlinge). Subjekt Singular → stellt.',
    'exampleSentence': 'Die Unterbringung der Flüchtlinge stellt eine Herausforderung dar.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein dringend zu lösendes Problem steht im Vordergrund.',
      'Ein dringend zu lösenden Problem steht im Vordergrund.',
      'Ein dringend zu lösender Problem steht im Vordergrund.',
      'Ein dringend zu lösendem Problem steht im Vordergrund.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu lösendes (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein dringend zu lösendes Problem steht im Vordergrund.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er versicherte, er werde sich um die Angelegenheit kümmern.',
      'Er versicherte, er wird sich um die Angelegenheit kümmern.',
      'Er versicherte, er werde sich um die Angelegenheit kümmern wird.',
      'Er versicherte, er würde sich um die Angelegenheit kümmern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Futur: werde + Infinitiv (indirekte Rede).',
    'exampleSentence': 'Er versicherte, er werde sich um die Angelegenheit kümmern.',
    'grammarRule': 'Konjunktiv I Futur: werde + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gilt, die Weichen für die Zukunft zu stellen.',
      'Es gilt, die Weichen für die Zukunft stellen.',
      'Es gilt, die Weichen für die Zukunft zu stellen zu.',
      'Es gilt, die Weichen für die Zukunft gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: es gilt + zu + Infinitiv: gilt zu stellen.',
    'exampleSentence': 'Es gilt, die Weichen für die Zukunft zu stellen.',
    'grammarRule': 'Passiversatzform: es gilt + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mag sein, dass er recht hat, aber sein Ton war unangemessen.',
      'Mag sein, dass er recht hat, aber unangemessen war sein Ton.',
      'Mag sein, dass recht hat er, aber sein Ton war unangemessen.',
      'Mag sein, dass er hat recht, aber sein Ton war unangemessen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessiver Ausdruck mit mag sein, dass: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Mag sein, dass er recht hat, aber sein Ton war unangemessen.',
    'grammarRule': 'Satzgefüge: mag sein, dass + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verhandlungen sind ins Stocken geraten.',
      'Die Verhandlungen sind ins Stocken gekommen.',
      'Die Verhandlungen sind ins Stocken gemacht.',
      'Die Verhandlungen sind ins Stocken gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: ins Stocken geraten (= stocken, stagnieren).',
    'exampleSentence': 'Die Verhandlungen sind ins Stocken geraten.',
    'grammarRule': 'Funktionsverbgefüge: ins Stocken geraten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entgegen aller Erwartungen hat das Team gewonnen.',
      'Entgegen alle Erwartungen hat das Team gewonnen.',
      'Entgegen allen Erwartung hat das Team gewonnen.',
      'Entgegen der Erwartungen hat das Team gewonnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Entgegen kann mit Genitiv Plural stehen: entgegen aller Erwartungen (gehobener Stil).',
    'exampleSentence': 'Entgegen aller Erwartungen hat das Team gewonnen.',
    'grammarRule': 'Präposition entgegen + Genitiv (gehoben)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obendrein hat er auch noch gelogen.',
      'Obendrein er hat auch noch gelogen.',
      'Obendrein hat auch noch gelogen er.',
      'Obendrein auch noch hat er gelogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach obendrein im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Obendrein hat er auch noch gelogen.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Festlegung der Prioritäten erfolgt in der nächsten Sitzung.',
      'Die Festlegung den Prioritäten erfolgt in der nächsten Sitzung.',
      'Die Festlegung der Prioritäten erfolgen in der nächsten Sitzung.',
      'Die Festlegung die Prioritäten erfolgt in der nächsten Sitzung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Festlegung + Genitiv Plural (der Prioritäten). Subjekt Singular → erfolgt.',
    'exampleSentence': 'Die Festlegung der Prioritäten erfolgt in der nächsten Sitzung.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die eng miteinander verknüpften Themen müssen gemeinsam betrachtet werden.',
      'Die eng miteinander verknüpfte Themen müssen gemeinsam betrachtet werden.',
      'Die eng miteinander verknüpfter Themen müssen gemeinsam betrachtet werden.',
      'Die eng miteinander verknüpfenden Themen müssen gemeinsam betrachtet werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: verknüpften (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die eng miteinander verknüpften Themen müssen gemeinsam betrachtet werden.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut Pressemeldung sei der Vertrag bereits unterzeichnet worden.',
      'Laut Pressemeldung ist der Vertrag bereits unterzeichnet worden.',
      'Laut Pressemeldung sei der Vertrag bereits unterzeichnet worden ist.',
      'Laut Pressemeldung wäre der Vertrag bereits unterzeichnet worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt Passiv: sei unterzeichnet worden (indirekte Rede).',
    'exampleSentence': 'Laut Pressemeldung sei der Vertrag bereits unterzeichnet worden.',
    'grammarRule': 'Konjunktiv I Perfekt Passiv: sei + Partizip II + worden',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Sachverhalt ist als komplex einzuordnen.',
      'Der Sachverhalt ist als komplex einordnen.',
      'Der Sachverhalt ist als komplex zu eingeordnet.',
      'Der Sachverhalt ist als komplex eingeordnet zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist einzuordnen (= muss eingeordnet werden).',
    'exampleSentence': 'Der Sachverhalt ist als komplex einzuordnen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Geschweige denn, dass er sich entschuldigte, zeigte er auch keinerlei Reue.',
      'Geschweige denn, dass er sich entschuldigte, er zeigte auch keinerlei Reue.',
      'Geschweige denn, dass entschuldigte er sich, zeigte er auch keinerlei Reue.',
      'Geschweige denn, dass er sich entschuldigte, zeigte auch er keinerlei Reue.'
    ],
    'correctAnswer': 0,
    'explanation': 'Steigerungssatz mit geschweige denn, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Geschweige denn, dass er sich entschuldigte, zeigte er auch keinerlei Reue.',
    'grammarRule': 'Satzgefüge: geschweige denn, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Äußerung hat Anstoß erregt.',
      'Die Äußerung hat Anstoß gemacht.',
      'Die Äußerung hat Anstoß genommen.',
      'Die Äußerung hat Anstoß gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Anstoß erregen (= provozieren, anstoßig sein).',
    'exampleSentence': 'Die Äußerung hat Anstoß erregt.',
    'grammarRule': 'Funktionsverbgefüge: Anstoß erregen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während des gesamten Verfahrens schwieg der Angeklagte.',
      'Während dem gesamten Verfahren schwieg der Angeklagte.',
      'Während des gesamten Verfahren schwieg der Angeklagte.',
      'Während den gesamten Verfahrens schwieg der Angeklagte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Während verlangt den Genitiv: während des gesamten Verfahrens.',
    'exampleSentence': 'Während des gesamten Verfahrens schwieg der Angeklagte.',
    'grammarRule': 'Präposition während + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gerade deshalb ist eine gründliche Analyse unerlässlich.',
      'Gerade deshalb eine gründliche Analyse ist unerlässlich.',
      'Gerade deshalb ist unerlässlich eine gründliche Analyse.',
      'Gerade deshalb unerlässlich ist eine gründliche Analyse.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach gerade deshalb im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Gerade deshalb ist eine gründliche Analyse unerlässlich.',
    'grammarRule': 'Wortstellung nach Kausaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Überwindung der Krise erfordert gemeinsame Anstrengungen.',
      'Die Überwindung den Krise erfordert gemeinsame Anstrengungen.',
      'Die Überwindung der Krise erfordern gemeinsame Anstrengungen.',
      'Die Überwindung die Krise erfordert gemeinsame Anstrengungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Überwindung + Genitiv (der Krise). Subjekt Singular → erfordert.',
    'exampleSentence': 'Die Überwindung der Krise erfordert gemeinsame Anstrengungen.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p9-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das noch ausstehende Ergebnis wird morgen bekannt gegeben.',
      'Das noch ausstehenden Ergebnis wird morgen bekannt gegeben.',
      'Das noch ausstehendes Ergebnis wird morgen bekannt gegeben.',
      'Das noch ausgestandene Ergebnis wird morgen bekannt gegeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Attribut: ausstehende (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das noch ausstehende Ergebnis wird morgen bekannt gegeben.',
    'grammarRule': 'Partizip I als Attribut',
    'tags': ['satzkorrektur']
  }
];

export default questions;
