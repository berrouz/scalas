import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob des unerwarteten Erfolges war er sprachlos.',
      'Ob dem unerwarteten Erfolg war er sprachlos.',
      'Ob des unerwartete Erfolges war er sprachlos.',
      'Ob den unerwarteten Erfolg war er sprachlos.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ob" als gehobene kausale Präposition (wegen) regiert den Genitiv: "des unerwarteten Erfolges".',
    'exampleSentence': 'Ob des unerwarteten Erfolges war er sprachlos.',
    'grammarRule': 'Gehobene Kausalp räposition "ob" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er tat so, als wüsste er von nichts.',
      'Er tat so als wüsste er von nichts.',
      'Er tat, so als wüsste er von nichts.',
      'Er tat so, als wüsste er, von nichts.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "als" (Vergleichspartikel mit Konjunktiv) steht ein Komma.',
    'exampleSentence': 'Er tat so, als wüsste er von nichts.',
    'grammarRule': 'Kommasetzung vor "als" im irrealen Vergleich',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er rühmte sich seiner Erfolge.',
      'Er rühmte sich seine Erfolge.',
      'Er rühmte sich seinen Erfolgen.',
      'Er rühmte sich seines Erfolge.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache rühmen" regiert den Genitiv: "seiner Erfolge".',
    'exampleSentence': 'Er rühmte sich seiner Erfolge.',
    'grammarRule': 'Genitivrektion bei "sich rühmen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Dilemma ließ sich nicht lösen.',
      'Der Dilemma ließ sich nicht lösen.',
      'Die Dilemma ließ sich nicht lösen.',
      'Das Dilemma ließen sich nicht lösen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dilemma" ist Neutrum: das Dilemma.',
    'exampleSentence': 'Das Dilemma ließ sich nicht lösen.',
    'grammarRule': 'Genus bei griechischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Hälfte der Teilnehmer war bereits angereist.',
      'Die Hälfte der Teilnehmer waren bereits angereist.',
      'Die Hälfte der Teilnehmer war bereits angereisten.',
      'Die Hälfte den Teilnehmern war bereits angereist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "die Hälfte" als Subjektkern steht das Verb formal im Singular.',
    'exampleSentence': 'Die Hälfte der Teilnehmer war bereits angereist.',
    'grammarRule': 'Kongruenz bei Bruchzahlkonstruktionen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hub an zu sprechen und verstummte alsbald.',
      'Er hubt an zu sprechen und verstummte alsbald.',
      'Er hub an zu sprechen und verstummte als bald.',
      'Er hub an sprechen und verstummte alsbald.'
    ],
    'correctAnswer': 0,
    'explanation': '"Hub an" ist die archaische Präteritumform von "anheben" (beginnen). "Alsbald" ist ein gehobenes Adverb.',
    'exampleSentence': 'Er hub an zu sprechen und verstummte alsbald.',
    'grammarRule': 'Archaische Verbform und gehobenes Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst als er aufstand, bemerkte er den Schmerz.',
      'Erst als er aufstand bemerkte er den Schmerz.',
      'Erst als aufstand er, bemerkte er den Schmerz.',
      'Erst als er aufstand, er bemerkte den Schmerz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "als" steht das Verb am Ende. Nach dem Komma folgt Inversion im Hauptsatz.',
    'exampleSentence': 'Erst als er aufstand, bemerkte er den Schmerz.',
    'grammarRule': 'Verbstellung in Nebensatz-Hauptsatz-Folge',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er stand auf des Messers Schneide.',
      'Er stand auf dem Messers Schneide.',
      'Er stand auf des Messer Schneide.',
      'Er stand auf den Messers Schneide.'
    ],
    'correctAnswer': 0,
    'explanation': '"Auf des Messers Schneide stehen" verwendet den vorangestellten Genitiv im literarischen Stil.',
    'exampleSentence': 'Es stand auf des Messers Schneide.',
    'grammarRule': 'Idiomatik mit vorangestelltem Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Werk, vollendet nach jahrelanger Arbeit, wurde gefeiert.',
      'Das Werk vollendet nach jahrelanger Arbeit wurde gefeiert.',
      'Das Werk, vollendet nach jahrelanger Arbeit wurde gefeiert.',
      'Das Werk vollendet, nach jahrelanger Arbeit, wurde gefeiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die partizipiale Apposition wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Das Werk, vollendet nach jahrelanger Arbeit, wurde gefeiert.',
    'grammarRule': 'Kommasetzung bei partizipialer Apposition',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er vermochte des Rätsels Lösung nicht zu finden.',
      'Er vermochte dem Rätsels Lösung nicht zu finden.',
      'Er vermochte den Rätsels Lösung nicht zu finden.',
      'Er vermochte des Rätsel Lösung nicht zu finden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Rätsels Lösung" ist ein vorangestellter Genitiv im gehobenen Stil.',
    'exampleSentence': 'Er vermochte des Rätsels Lösung nicht zu finden.',
    'grammarRule': 'Vorangestellter Genitiv im literarischen Stil',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Placebo zeigte keinerlei Wirkung.',
      'Der Placebo zeigte keinerlei Wirkung.',
      'Die Placebo zeigte keinerlei Wirkung.',
      'Das Placebo zeigten keinerlei Wirkung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Placebo" ist Neutrum: das Placebo.',
    'exampleSentence': 'Das Placebo zeigte keinerlei Wirkung.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Keiner der Beteiligten wollte sich äußern.',
      'Keiner der Beteiligten wollten sich äußern.',
      'Keiner den Beteiligten wollte sich äußern.',
      'Keines der Beteiligten wollte sich äußern.'
    ],
    'correctAnswer': 0,
    'explanation': '"Keiner" als Subjektkern verlangt das Verb im Singular: "wollte".',
    'exampleSentence': 'Keiner der Beteiligten wollte sich äußern.',
    'grammarRule': 'Kongruenz bei negiertem Indefinitpronomen mit partitivem Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Und ob er gleich wandelt im finstern Tal, fürchtet er kein Unglück.',
      'Und ob er gleich wandelt im finsteren Tal, fürchtet er kein Unglück.',
      'Und ob er gleich wandelte im finstern Tal, fürchtet er kein Unglück.',
      'Und ob er gleich wandeln im finstern Tal, fürchtet er kein Unglück.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die biblische Sprache verwendet "ob ... gleich" (obwohl) mit Indikativ und die poetische Form "finstern".',
    'exampleSentence': 'Und ob er gleich wandelt im finstern Tal, fürchtet er kein Unglück.',
    'grammarRule': 'Biblisch-archaische Konzessivkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut des Berichts sei die Lage ernst.',
      'Laut dem Bericht sei die Lage ernst.',
      'Laut des Berichtes sei die Lage ernster.',
      'Laut den Bericht sei die Lage ernst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Laut" kann im gehobenen Stil den Genitiv regieren: "laut des Berichts". Konjunktiv I für indirekte Rede.',
    'exampleSentence': 'Laut des Berichts sei die Lage ernst.',
    'grammarRule': '"Laut" mit Genitiv im gehobenen Stil',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat das Handtuch geworfen.',
      'Sie hat das Handtuch geschmissen.',
      'Sie hat den Handtuch geworfen.',
      'Sie hat dem Handtuch geworfen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Das Handtuch werfen" (aufgeben) ist die korrekte idiomatische Wendung mit "werfen" (nicht "schmeißen").',
    'exampleSentence': 'Sie hat das Handtuch geworfen.',
    'grammarRule': 'Idiomatische Wendung mit festem Verb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wusste nicht, ob er lachen oder weinen sollte.',
      'Er wusste nicht ob er lachen oder weinen sollte.',
      'Er wusste nicht, ob er lachen, oder weinen sollte.',
      'Er wusste, nicht ob er lachen oder weinen sollte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor dem Nebensatz mit "ob" steht ein Komma. Innerhalb des Nebensatzes steht kein Komma vor "oder".',
    'exampleSentence': 'Er wusste nicht, ob er lachen oder weinen sollte.',
    'grammarRule': 'Kommasetzung vor indirektem Fragesatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wurde der Lüge überführt.',
      'Sie wurde die Lüge überführt.',
      'Sie wurde dem Lüge überführt.',
      'Sie wurde der Lüge übergeführt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden einer Sache überführen" regiert den Genitiv: "der Lüge".',
    'exampleSentence': 'Sie wurde der Lüge überführt.',
    'grammarRule': 'Genitivrektion bei "überführen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Topos der Vergänglichkeit durchzieht die Literatur.',
      'Das Topos der Vergänglichkeit durchzieht die Literatur.',
      'Die Topos der Vergänglichkeit durchzieht die Literatur.',
      'Der Topos die Vergänglichkeit durchzieht die Literatur.'
    ],
    'correctAnswer': 0,
    'explanation': '"Topos" ist Maskulinum: der Topos.',
    'exampleSentence': 'Der Topos der Vergänglichkeit durchzieht die Literatur.',
    'grammarRule': 'Genus bei griechischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht er, sondern seine Kollegen waren verantwortlich.',
      'Nicht er, sondern seine Kollegen war verantwortlich.',
      'Nicht er, sondern seine Kollegen waren verantwortlichen.',
      'Nicht er, sondern seinen Kollegen waren verantwortlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "nicht ... sondern" richtet sich das Verb nach dem zweiten Subjektteil: "Kollegen" (Plural).',
    'exampleSentence': 'Nicht er, sondern seine Kollegen waren verantwortlich.',
    'grammarRule': 'Kongruenz bei korrektivem Subjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sprach, auf dass man ihn höre.',
      'Er sprach, auf dass man ihn hört.',
      'Er sprach, auf das man ihn höre.',
      'Er sprach, auf dass man ihm höre.'
    ],
    'correctAnswer': 0,
    'explanation': '"Auf dass" (Finalsatz) verlangt Konjunktiv I: "höre". "Hören" regiert den Akkusativ: "ihn".',
    'exampleSentence': 'Er sprach, auf dass man ihn höre.',
    'grammarRule': 'Finalsatz mit "auf dass" und Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zwecks Überprüfung des Sachverhalts wurde ein Gutachten erstellt.',
      'Zwecks Überprüfung dem Sachverhalt wurde ein Gutachten erstellt.',
      'Zwecks Überprüfung des Sachverhaltes wurde einen Gutachten erstellt.',
      'Zweck Überprüfung des Sachverhalts wurde ein Gutachten erstellt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zwecks" ist eine amtssprachliche Präposition mit Genitiv: "zwecks Überprüfung".',
    'exampleSentence': 'Zwecks Überprüfung des Sachverhalts wurde ein Gutachten erstellt.',
    'grammarRule': 'Amtssprachliche Präposition "zwecks"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Möge er in Frieden ruhen.',
      'Er möge in Frieden ruhen.',
      'Möge in Frieden er ruhen.',
      'In Frieden möge ruhen er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Wunschsatz mit Konjunktiv I steht das Verb an erster Stelle: "Möge er ...".',
    'exampleSentence': 'Möge er in Frieden ruhen.',
    'grammarRule': 'Verb-Erst-Stellung im Optativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Soweit ich weiß, ist er bereits abgereist.',
      'Soweit ich weiß ist er bereits abgereist.',
      'Soweit, ich weiß, ist er bereits abgereist.',
      'Soweit ich weiß ist, er bereits abgereist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der vorangestellte Nebensatz mit "soweit" wird durch Komma vom Hauptsatz getrennt.',
    'exampleSentence': 'Soweit ich weiß, ist er bereits abgereist.',
    'grammarRule': 'Kommasetzung nach einleitendem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie schämte sich ihrer Herkunft.',
      'Sie schämte sich ihre Herkunft.',
      'Sie schämte sich ihrem Herkunft.',
      'Sie schämte sich ihrer Herkünfte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache schämen" regiert im gehobenen Stil den Genitiv: "ihrer Herkunft".',
    'exampleSentence': 'Sie schämte sich ihrer Herkunft.',
    'grammarRule': 'Genitivrektion bei "sich schämen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Korpus der gesammelten Texte ist beeindruckend.',
      'Das Korpus der gesammelten Texte ist beeindruckend.',
      'Die Korpus der gesammelten Texte ist beeindruckend.',
      'Der Korpus den gesammelten Texte ist beeindruckend.'
    ],
    'correctAnswer': 0,
    'explanation': '"Korpus" im Sinne von Textsammlung ist Maskulinum: der Korpus.',
    'exampleSentence': 'Der Korpus der gesammelten Texte ist beeindruckend.',
    'grammarRule': 'Genus bei lateinischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gibt vieles, was noch zu klären ist.',
      'Es gibt vieles, das noch zu klären ist.',
      'Es gibt vieles, was noch zu klären sind.',
      'Es gibt vielem, was noch zu klären ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "vieles" steht "was" als Relativpronomen (nicht "das"). "Ist" kongruiert mit dem Singular.',
    'exampleSentence': 'Es gibt vieles, was noch zu klären ist.',
    'grammarRule': 'Relativpronomen nach substantiviertem Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allzumal waren sie des Lobes voll.',
      'Allzumal waren sie dem Lobe voll.',
      'Allzumal waren sie des Lobs voll.',
      'Allzumale waren sie des Lobes voll.'
    ],
    'correctAnswer': 0,
    'explanation': '"Allzumal" (allesamt) ist ein archaisches Adverb. "Des Lobes voll" ist eine gehobene Genitivkonstruktion.',
    'exampleSentence': 'Allzumal waren sie des Lobes voll.',
    'grammarRule': 'Archaisches Adverb mit Genitivkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hinsichtlich der neuen Regelung bestehen noch Zweifel.',
      'Hinsichtlich den neuen Regelung bestehen noch Zweifel.',
      'Hinsichtlich der neuen Regelung besteht noch Zweifel.',
      'Hinsichtlich die neue Regelung bestehen noch Zweifel.'
    ],
    'correctAnswer': 0,
    'explanation': '"Hinsichtlich" regiert den Genitiv. "Zweifel" im Plural verlangt "bestehen".',
    'exampleSentence': 'Hinsichtlich der neuen Regelung bestehen noch Zweifel.',
    'grammarRule': 'Gehobene Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sein Fett wegbekommen.',
      'Er hat sein Fett weggebekommen.',
      'Er hat seinem Fett wegbekommen.',
      'Er hat seinen Fett wegbekommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sein Fett wegbekommen" (seine Strafe erhalten) ist eine feste idiomatische Wendung.',
    'exampleSentence': 'Er hat sein Fett wegbekommen.',
    'grammarRule': 'Idiomatische Wendung mit trennbarem Verb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gleichwohl er müde war, arbeitete er weiter.',
      'Gleichwohl er müde war arbeitete er weiter.',
      'Gleichwohl, er müde war, arbeitete er weiter.',
      'Gleichwohl er müde, war arbeitete er weiter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der Nebensatz mit "gleichwohl" wird durch Komma vom Hauptsatz getrennt.',
    'exampleSentence': 'Gleichwohl er müde war, arbeitete er weiter.',
    'grammarRule': 'Kommasetzung nach konzessivem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er bemächtigte sich des gesamten Vermögens.',
      'Er bemächtigte sich das gesamte Vermögen.',
      'Er bemächtigte sich dem gesamten Vermögen.',
      'Er bemächtigte sich des gesamten Vermögen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache bemächtigen" regiert den Genitiv: "des gesamten Vermögens".',
    'exampleSentence': 'Er bemächtigte sich des gesamten Vermögens.',
    'grammarRule': 'Genitivrektion bei "sich bemächtigen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Epitheton ist ein häufiges Stilmittel.',
      'Der Epitheton ist ein häufiges Stilmittel.',
      'Die Epitheton ist ein häufiges Stilmittel.',
      'Das Epitheton ist ein häufiger Stilmittel.'
    ],
    'correctAnswer': 0,
    'explanation': '"Epitheton" ist Neutrum: das Epitheton.',
    'exampleSentence': 'Das Epitheton ist ein häufiges Stilmittel.',
    'grammarRule': 'Genus bei griechischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-036',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wer von euch ohne Sünde ist, werfe den ersten Stein.',
      'Wer von euch ohne Sünde ist, wirft den ersten Stein.',
      'Wer von euch ohne Sünde sind, werfe den ersten Stein.',
      'Wer von euch ohne Sünde ist, werfe dem ersten Stein.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wer" als Subjekt verlangt Singular. "Werfe" steht im Konjunktiv I (Jussiv/Aufforderung).',
    'exampleSentence': 'Wer von euch ohne Sünde ist, werfe den ersten Stein.',
    'grammarRule': 'Jussiver Konjunktiv I bei indirekter Aufforderung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Fürwahr, er hat Großes geleistet.',
      'Fürwahr, er hat großes geleistet.',
      'Fürwahr er hat Großes geleistet.',
      'Für wahr, er hat Großes geleistet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Fürwahr" (in der Tat) ist ein archaisches Adverb, gefolgt von einem Komma. "Großes" ist substantiviert (groß geschrieben).',
    'exampleSentence': 'Fürwahr, er hat Großes geleistet.',
    'grammarRule': 'Archaisches Adverb mit Komma',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorbehaltlich seiner Zustimmung gilt der Vertrag.',
      'Vorbehaltlich seiner Zustimmung geltet der Vertrag.',
      'Vorbehaltlich seine Zustimmung gilt der Vertrag.',
      'Vorbehaltlich seinem Zustimmung gilt der Vertrag.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vorbehaltlich" regiert den Genitiv: "seiner Zustimmung".',
    'exampleSentence': 'Vorbehaltlich seiner Zustimmung gilt der Vertrag.',
    'grammarRule': 'Juristische Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Lange schon hatte er diesen Moment herbeigesehnt.',
      'Lange schon er hatte diesen Moment herbeigesehnt.',
      'Lange schon hatte diesen Moment er herbeigesehnt.',
      'Er lange schon hatte diesen Moment herbeigesehnt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Temporaladverb "lange schon" im Vorfeld folgt Inversion: Verb vor Subjekt.',
    'exampleSentence': 'Lange schon hatte er diesen Moment herbeigesehnt.',
    'grammarRule': 'Inversion nach Temporaladverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat die Katze aus dem Sack gelassen.',
      'Er hat die Katze aus den Sack gelassen.',
      'Er hat der Katze aus dem Sack gelassen.',
      'Er hat die Katze aus dem Sack lassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Die Katze aus dem Sack lassen" (ein Geheimnis verraten). "Aus dem Sack" steht im Dativ.',
    'exampleSentence': 'Er hat die Katze aus dem Sack gelassen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei darauf hingewiesen, dass dies nicht zutrifft.',
      'Es sei darauf hingewiesen dass dies nicht zutrifft.',
      'Es sei darauf, hingewiesen, dass dies nicht zutrifft.',
      'Es sei darauf hingewiesen, das dies nicht zutrifft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor dem Nebensatz mit "dass" steht ein Komma. Konjunktion "dass" (nicht "das").',
    'exampleSentence': 'Es sei darauf hingewiesen, dass dies nicht zutrifft.',
    'grammarRule': 'Kommasetzung vor "dass"-Satz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er entsann sich der alten Zeiten.',
      'Er entsann sich die alten Zeiten.',
      'Er entsann sich den alten Zeiten.',
      'Er entsann sich der alten Zeit an.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache entsinnen" regiert den Genitiv: "der alten Zeiten".',
    'exampleSentence': 'Er entsann sich der alten Zeiten.',
    'grammarRule': 'Genitivrektion bei "sich entsinnen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Dogma wurde infrage gestellt.',
      'Der Dogma wurde infrage gestellt.',
      'Die Dogma wurde infrage gestellt.',
      'Das Dogma wurden infrage gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dogma" ist Neutrum: das Dogma.',
    'exampleSentence': 'Das Dogma wurde infrage gestellt.',
    'grammarRule': 'Genus bei griechischen Fremdwörtern auf -ma',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Polizei hat die Verdächtigen festgenommen.',
      'Die Polizei haben die Verdächtigen festgenommen.',
      'Die Polizei hat die Verdächtige festgenommen.',
      'Die Polizei hat den Verdächtigen festgenommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Die Polizei" als Kollektivum steht im Singular: "hat". "Die Verdächtigen" im Akkusativ Plural.',
    'exampleSentence': 'Die Polizei hat die Verdächtigen festgenommen.',
    'grammarRule': 'Kongruenz bei Kollektivnomen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es geschehe nach deinem Willen.',
      'Es geschehe nach deinen Willen.',
      'Es geschieht nach deinem Willen.',
      'Es geschehe nach dein Willen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es geschehe" ist Konjunktiv I (Jussiv). "Nach deinem Willen" steht im Dativ.',
    'exampleSentence': 'Es geschehe nach deinem Willen.',
    'grammarRule': 'Jussiver Konjunktiv I in biblischer Sprache',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gesetzt den Fall, er stimme zu, wäre das Problem gelöst.',
      'Gesetzt den Fall er stimme zu, wäre das Problem gelöst.',
      'Gesetzt den Fall, er stimmt zu, wäre das Problem gelöst.',
      'Gesetzt dem Fall, er stimme zu, wäre das Problem gelöst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gesetzt den Fall" mit Komma, gefolgt von Konjunktiv I ("stimme zu") im gehobenen Stil.',
    'exampleSentence': 'Gesetzt den Fall, er stimme zu, wäre das Problem gelöst.',
    'grammarRule': 'Gehobene Konditionalkonstruktion mit Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr das Wasser reichen können.',
      'Er hat ihr das Wasser gereicht können.',
      'Er hat ihr dem Wasser reichen können.',
      'Er hat sie das Wasser reichen können.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem das Wasser reichen können" (mit jemandem konkurrieren können). Dativ: "ihr".',
    'exampleSentence': 'Niemand konnte ihr das Wasser reichen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenngleich er Recht hatte, überzeugte sein Argument niemanden.',
      'Wenngleich er Recht hatte überzeugte sein Argument niemanden.',
      'Wenngleich, er Recht hatte, überzeugte sein Argument niemanden.',
      'Wenngleich er Recht hatte, überzeugte sein Argument niemand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der konzessive Nebensatz mit "wenngleich" wird durch Komma vom Hauptsatz getrennt. "Niemanden" im Akkusativ.',
    'exampleSentence': 'Wenngleich er Recht hatte, überzeugte sein Argument niemanden.',
    'grammarRule': 'Kommasetzung nach konzessivem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wurde des Plagiats bezichtigt.',
      'Sie wurde das Plagiat bezichtigt.',
      'Sie wurde dem Plagiat bezichtigt.',
      'Sie wurde des Plagiates bezichtet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden einer Sache bezichtigen" regiert den Genitiv: "des Plagiats".',
    'exampleSentence': 'Sie wurde des Plagiats bezichtigt.',
    'grammarRule': 'Genitivrektion bei "bezichtigen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p3-149',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Praepositionen + Genitiv',
    'question': 'Welcher Satz ist korrekt?',
    'options': ['Anhand der vorliegenden Daten laesst sich ein Trend erkennen.', 'Anhand den vorliegenden Daten laesst sich ein Trend erkennen.', 'Anhand die vorliegenden Daten laesst sich ein Trend erkennen.', 'Anhand dem vorliegenden Daten laesst sich ein Trend erkennen.'],
    'correctAnswer': 0,
    'explanation': '\'Anhand\' + Genitiv.',
    'tags': ['satzkorrektur']
  }
];

export default questions;
