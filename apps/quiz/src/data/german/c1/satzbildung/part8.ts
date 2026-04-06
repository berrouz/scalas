import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-001',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er bleibt zu Hause, weil er krank ist.',
      'Er bleibt weil er krank ist zu Hause.',
      'Weil er krank ist, er bleibt zu Hause.',
      'Er bleibt zu Hause, weil er ist krank.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit weil steht das konjugierte Verb am Ende.',
    'exampleSentence': 'Er bleibt zu Hause, weil er krank ist.',
    'grammarRule': 'Nebensatz: Verb am Ende',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-006',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nachdem er aß, ging er spazieren.',
      'Nachdem er gegessen hatte, ging er spazieren.',
      'Nachdem er gegessen hat, ging er spazieren.',
      'Er ging spazieren, nachdem er gegessen hat.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nach nachdem im Vergangenheitskontext steht Plusquamperfekt im Nebensatz, Präteritum im Hauptsatz.',
    'exampleSentence': 'Nachdem er gegessen hatte, ging er spazieren.',
    'grammarRule': 'nachdem + Plusquamperfekt',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-013',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Sicherstellung der Qualität erfordert ständige Kontrollen.',
      'Die Sicherstellung die Qualität erfordert ständige Kontrollen.',
      'Die Sicherstellung der Qualität ständige Kontrollen erfordert.',
      'Die Sicherstellung der Qualität erfordern ständige Kontrollen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Sicherstellung (Singular) + Genitiv (der Qualität) + erfordert (Singular).',
    'exampleSentence': 'Die Sicherstellung der Qualität erfordert ständige Kontrollen.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-014',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die im Ausland erworbene Qualifikation wurde anerkannt.',
      'Die im Ausland erworbenen Qualifikation wurde anerkannt.',
      'Die im Ausland erworben Qualifikation wurde anerkannt.',
      'Die im Ausland erwerbende Qualifikation wurde anerkannt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: erworben + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die im Ausland erworbene Qualifikation wurde anerkannt.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-015',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat Bezug auf den Artikel gestellt.',
      'Er hat Bezug auf den Artikel genommen.',
      'Er hat Bezug auf den Artikel gebracht.',
      'Er hat Bezug auf den Artikel gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Bezug nehmen auf (= sich beziehen auf).',
    'exampleSentence': 'Er hat Bezug auf den Artikel genommen.',
    'grammarRule': 'Funktionsverbgefüge: Bezug nehmen auf',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-016',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Laut eines Berichts stieg die Arbeitslosigkeit.',
      'Laut einem Berichts stieg die Arbeitslosigkeit.',
      'Laut eines Berichts die Arbeitslosigkeit stieg.',
      'Laut eines Berichts stieg die Arbeitslosigkeit an.'
    ],
    'correctAnswer': 3,
    'explanation': 'Laut + Genitiv: eines Berichts. Das Verb ansteigen ist trennbar: stieg ... an.',
    'exampleSentence': 'Laut eines Berichts stieg die Arbeitslosigkeit an.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-017',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der heftig tobende Sturm richtete Schäden an.',
      'Der heftig tobenden Sturm richtete Schäden an.',
      'Der heftig tobend Sturm richtete Schäden an.',
      'Der heftig getobte Sturm richtete Schäden an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: tobend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der heftig tobende Sturm richtete Schäden an.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-018',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Unternehmen hat Gewinn gebracht.',
      'Das Unternehmen hat Gewinn erzielt.',
      'Das Unternehmen hat Gewinn gestellt.',
      'Das Unternehmen hat Gewinn genommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Gewinn erzielen (= Profit machen).',
    'exampleSentence': 'Das Unternehmen hat Gewinn erzielt.',
    'grammarRule': 'Funktionsverbgefüge: Gewinn erzielen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-019',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mithilfe moderner Technologien wurde das Problem gelöst.',
      'Mithilfe moderne Technologien wurde das Problem gelöst.',
      'Mithilfe moderner Technologien das Problem wurde gelöst.',
      'Mithilfe moderner Technologien wurde gelöst das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mithilfe + Genitiv: moderner Technologien. Inversion im Hauptsatz.',
    'exampleSentence': 'Mithilfe moderner Technologien wurde das Problem gelöst.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-020',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die dringend benötigten Fachkräfte fehlen auf dem Markt.',
      'Die dringend benötigte Fachkräfte fehlen auf dem Markt.',
      'Die dringend benötigt Fachkräfte fehlen auf dem Markt.',
      'Die dringend benötigenden Fachkräfte fehlen auf dem Markt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: benötigt + -en.',
    'exampleSentence': 'Die dringend benötigten Fachkräfte fehlen auf dem Markt.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-021',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat Anklage gegen den Verdächtigen gestellt.',
      'Sie hat Anklage gegen den Verdächtigen erhoben.',
      'Sie hat Anklage gegen den Verdächtigen genommen.',
      'Sie hat Anklage gegen den Verdächtigen gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Anklage erheben (= anklagen).',
    'exampleSentence': 'Sie hat Anklage gegen den Verdächtigen erhoben.',
    'grammarRule': 'Funktionsverbgefüge: Anklage erheben',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-023',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein vielversprechendes Forschungsergebnis wurde veröffentlicht.',
      'Ein vielversprechender Forschungsergebnis wurde veröffentlicht.',
      'Ein vielversprechend Forschungsergebnis wurde veröffentlicht.',
      'Ein vielversprechendem Forschungsergebnis wurde veröffentlicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: vielversprechend + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).',
    'exampleSentence': 'Ein vielversprechendes Forschungsergebnis wurde veröffentlicht.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-024',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Vorschlag kam zur Abstimmung.',
      'Der Vorschlag ging zur Abstimmung.',
      'Der Vorschlag brachte zur Abstimmung.',
      'Der Vorschlag stellte zur Abstimmung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: zur Abstimmung kommen (= abgestimmt werden).',
    'exampleSentence': 'Der Vorschlag kam zur Abstimmung.',
    'grammarRule': 'Funktionsverbgefüge: zur Abstimmung kommen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-025',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Gewährleistung der Sicherheit hat oberste Priorität.',
      'Die Gewährleistung die Sicherheit hat oberste Priorität.',
      'Die Gewährleistung der Sicherheit oberste Priorität hat.',
      'Die Gewährleistung der Sicherheit haben oberste Priorität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Gewährleistung (Singular) + Genitiv (der Sicherheit) + hat (Singular).',
    'exampleSentence': 'Die Gewährleistung der Sicherheit hat oberste Priorität.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-026',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die vom Sturm beschädigten Häuser werden repariert.',
      'Die vom Sturm beschädigte Häuser werden repariert.',
      'Die vom Sturm beschädigt Häuser werden repariert.',
      'Die vom Sturm beschädigenden Häuser werden repariert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: beschädigt + -en.',
    'exampleSentence': 'Die vom Sturm beschädigten Häuser werden repariert.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-027',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sein Versprechen in Erfüllung gebracht.',
      'Er hat sein Versprechen in Erfüllung genommen.',
      'Sein Versprechen ist in Erfüllung gegangen.',
      'Sein Versprechen ist in Erfüllung gestellt.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: in Erfüllung gehen (= sich erfüllen).',
    'exampleSentence': 'Sein Versprechen ist in Erfüllung gegangen.',
    'grammarRule': 'Funktionsverbgefüge: in Erfüllung gehen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-029',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Eine zufriedenstellende Lösung wurde gefunden.',
      'Eine zufriedenstellenden Lösung wurde gefunden.',
      'Eine zufriedenstellend Lösung wurde gefunden.',
      'Eine zufriedengestellte Lösung wurde gefunden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: zufriedenstellend + -e (Singular, Nominativ, Femininum, unbestimmter Artikel).',
    'exampleSentence': 'Eine zufriedenstellende Lösung wurde gefunden.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-030',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Firma hat Klage gegen den Lieferanten gebracht.',
      'Die Firma hat Klage gegen den Lieferanten erhoben.',
      'Die Firma hat Klage gegen den Lieferanten genommen.',
      'Die Firma hat Klage gegen den Lieferanten gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Klage erheben (= klagen).',
    'exampleSentence': 'Die Firma hat Klage gegen den Lieferanten erhoben.',
    'grammarRule': 'Funktionsverbgefüge: Klage erheben',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-031',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zwecks Vermeidung von Missverständnissen bitten wir um klare Kommunikation.',
      'Zwecks Vermeidung von Missverständnisse bitten wir um klare Kommunikation.',
      'Zwecks Vermeidung von Missverständnissen wir bitten um klare Kommunikation.',
      'Zwecks Vermeidung von Missverständnissen bitten um klare Kommunikation wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zwecks + Genitiv/von: Vermeidung von Missverständnissen. Inversion im Hauptsatz.',
    'exampleSentence': 'Zwecks Vermeidung von Missverständnissen bitten wir um klare Kommunikation.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-032',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der neu eingestellte Mitarbeiter beginnt morgen.',
      'Der neu eingestellten Mitarbeiter beginnt morgen.',
      'Der neu eingestellt Mitarbeiter beginnt morgen.',
      'Der neu einstellende Mitarbeiter beginnt morgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: eingestellt + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der neu eingestellte Mitarbeiter beginnt morgen.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-033',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Nachricht hat Aufsehen gebracht.',
      'Die Nachricht hat Aufsehen erregt.',
      'Die Nachricht hat Aufsehen genommen.',
      'Die Nachricht hat Aufsehen gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Aufsehen erregen (= Aufmerksamkeit erregen).',
    'exampleSentence': 'Die Nachricht hat Aufsehen erregt.',
    'grammarRule': 'Funktionsverbgefüge: Aufsehen erregen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-034',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Umsetzung der neuen Richtlinien beginnt nächste Woche.',
      'Die Umsetzung die neuen Richtlinien beginnt nächste Woche.',
      'Die Umsetzung der neuen Richtlinien nächste Woche beginnt.',
      'Die Umsetzung der neuen Richtlinien beginnen nächste Woche.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Umsetzung (Singular) + Genitiv (der neuen Richtlinien) + beginnt (Singular).',
    'exampleSentence': 'Die Umsetzung der neuen Richtlinien beginnt nächste Woche.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-035',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der deutlich steigende Meeresspiegel bedroht Küstenstädte.',
      'Der deutlich steigenden Meeresspiegel bedroht Küstenstädte.',
      'Der deutlich steigend Meeresspiegel bedroht Küstenstädte.',
      'Der deutlich gestiegene Meeresspiegel bedrohen Küstenstädte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: steigend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der deutlich steigende Meeresspiegel bedroht Küstenstädte.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-036',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat den Wunsch zum Ausdruck genommen.',
      'Er hat den Wunsch zum Ausdruck gebracht.',
      'Er hat den Wunsch zum Ausdruck gestellt.',
      'Er hat den Wunsch zum Ausdruck gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: zum Ausdruck bringen (= ausdrücken).',
    'exampleSentence': 'Er hat den Wunsch zum Ausdruck gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Ausdruck bringen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-037',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Im Rahmen des Projekts wurden neue Methoden getestet.',
      'Im Rahmen dem Projekt wurden neue Methoden getestet.',
      'Im Rahmen des Projekts neue Methoden wurden getestet.',
      'Im Rahmen des Projekts wurden getestet neue Methoden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Rahmen + Genitiv: des Projekts. Inversion im Hauptsatz.',
    'exampleSentence': 'Im Rahmen des Projekts wurden neue Methoden getestet.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-038',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die hart arbeitenden Angestellten verdienen Anerkennung.',
      'Die hart arbeitende Angestellten verdienen Anerkennung.',
      'Die hart arbeitend Angestellten verdienen Anerkennung.',
      'Die hart gearbeiteten Angestellten verdienen Anerkennung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv im Plural mit bestimmtem Artikel: arbeitend + -en.',
    'exampleSentence': 'Die hart arbeitenden Angestellten verdienen Anerkennung.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-039',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Änderungen traten am 1. März in Kraft.',
      'Die Änderungen kamen am 1. März in Kraft.',
      'Die Änderungen gingen am 1. März in Kraft.',
      'Die Änderungen setzten am 1. März in Kraft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: in Kraft treten (= wirksam werden).',
    'exampleSentence': 'Die Änderungen traten am 1. März in Kraft.',
    'grammarRule': 'Funktionsverbgefüge: in Kraft treten',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-040',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Aufgrund der Knappheit der Ressourcen müssen wir umdenken.',
      'Aufgrund die Knappheit der Ressourcen müssen wir umdenken.',
      'Aufgrund der Knappheit der Ressourcen wir müssen umdenken.',
      'Aufgrund der Knappheit der Ressourcen müssen umdenken wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aufgrund + Genitiv: der Knappheit der Ressourcen. Inversion im Hauptsatz.',
    'exampleSentence': 'Aufgrund der Knappheit der Ressourcen müssen wir umdenken.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-041',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das soeben veröffentlichte Buch wurde ein Bestseller.',
      'Das soeben veröffentlichten Buch wurde ein Bestseller.',
      'Das soeben veröffentlicht Buch wurde ein Bestseller.',
      'Das soeben veröffentlichende Buch wurde ein Bestseller.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: veröffentlicht + -e (Singular, Nominativ, Neutrum, bestimmter Artikel).',
    'exampleSentence': 'Das soeben veröffentlichte Buch wurde ein Bestseller.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-042',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat einen Antrag auf Förderung gebracht.',
      'Er hat einen Antrag auf Förderung gestellt.',
      'Er hat einen Antrag auf Förderung genommen.',
      'Er hat einen Antrag auf Förderung gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: einen Antrag stellen (= beantragen).',
    'exampleSentence': 'Er hat einen Antrag auf Förderung gestellt.',
    'grammarRule': 'Funktionsverbgefüge: einen Antrag stellen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-043',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Infolge der Dürre fielen die Ernten gering aus.',
      'Infolge die Dürre fielen die Ernten gering aus.',
      'Infolge der Dürre die Ernten fielen gering aus.',
      'Infolge der Dürre fielen gering aus die Ernten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infolge + Genitiv: der Dürre. Inversion im Hauptsatz.',
    'exampleSentence': 'Infolge der Dürre fielen die Ernten gering aus.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-044',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein lang ersehnter Urlaub stand bevor.',
      'Ein lang ersehnte Urlaub stand bevor.',
      'Ein lang ersehnt Urlaub stand bevor.',
      'Ein lang ersehnenden Urlaub stand bevor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: ersehnt + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).',
    'exampleSentence': 'Ein lang ersehnter Urlaub stand bevor.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-045',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Skandal hat Schlagzeilen gebracht.',
      'Der Skandal hat Schlagzeilen gemacht.',
      'Der Skandal hat Schlagzeilen genommen.',
      'Der Skandal hat Schlagzeilen gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Schlagzeilen machen (= in die Medien kommen).',
    'exampleSentence': 'Der Skandal hat Schlagzeilen gemacht.',
    'grammarRule': 'Funktionsverbgefüge: Schlagzeilen machen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-046',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Bewältigung der Krise erfordert Zusammenarbeit.',
      'Die Bewältigung die Krise erfordert Zusammenarbeit.',
      'Die Bewältigung der Krise Zusammenarbeit erfordert.',
      'Die Bewältigung der Krise erfordern Zusammenarbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bewältigung (Singular) + Genitiv (der Krise) + erfordert (Singular).',
    'exampleSentence': 'Die Bewältigung der Krise erfordert Zusammenarbeit.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-047',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die immer lauter werdenden Rufe nach Reform nehmen zu.',
      'Die immer lauter werdende Rufe nach Reform nehmen zu.',
      'Die immer lauter werdend Rufe nach Reform nehmen zu.',
      'Die immer lauter gewordenen Rufe nach Reform nehmen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv im Plural mit bestimmtem Artikel: werdend + -en.',
    'exampleSentence': 'Die immer lauter werdenden Rufe nach Reform nehmen zu.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-048',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Forscher hat eine Entdeckung genommen.',
      'Der Forscher hat eine Entdeckung gebracht.',
      'Der Forscher hat eine Entdeckung gemacht.',
      'Der Forscher hat eine Entdeckung gestellt.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: eine Entdeckung machen (= entdecken).',
    'exampleSentence': 'Der Forscher hat eine Entdeckung gemacht.',
    'grammarRule': 'Funktionsverbgefüge: eine Entdeckung machen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-049',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unter Einbeziehung aller Beteiligten wurde ein Kompromiss erzielt.',
      'Unter Einbeziehung alle Beteiligten wurde ein Kompromiss erzielt.',
      'Unter Einbeziehung aller Beteiligten ein Kompromiss wurde erzielt.',
      'Unter Einbeziehung aller Beteiligten wurde erzielt ein Kompromiss.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unter Einbeziehung + Genitiv: aller Beteiligten. Inversion im Hauptsatz.',
    'exampleSentence': 'Unter Einbeziehung aller Beteiligten wurde ein Kompromiss erzielt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-050',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die erschöpften Wanderer kehrten ins Lager zurück.',
      'Die erschöpfte Wanderer kehrten ins Lager zurück.',
      'Die erschöpft Wanderer kehrten ins Lager zurück.',
      'Die erschöpfenden Wanderer kehrten ins Lager zurück.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: erschöpft + -en.',
    'exampleSentence': 'Die erschöpften Wanderer kehrten ins Lager zurück.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-051',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sein Amt zur Verfügung genommen.',
      'Er hat sein Amt zur Verfügung gestellt.',
      'Er hat sein Amt zur Verfügung gebracht.',
      'Er hat sein Amt zur Verfügung gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: zur Verfügung stellen (= anbieten).',
    'exampleSentence': 'Er hat sein Amt zur Verfügung gestellt.',
    'grammarRule': 'Funktionsverbgefüge: zur Verfügung stellen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-052',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die täglich erscheinende Zeitung berichtet darüber.',
      'Die täglich erscheinenden Zeitung berichtet darüber.',
      'Die täglich erscheinend Zeitung berichtet darüber.',
      'Die täglich erschienene Zeitung berichtet darüber.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: erscheinend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die täglich erscheinende Zeitung berichtet darüber.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-053',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Bekanntgabe der Ergebnisse erfolgt morgen.',
      'Die Bekanntgabe die Ergebnisse erfolgt morgen.',
      'Die Bekanntgabe der Ergebnisse morgen erfolgt.',
      'Die Bekanntgabe der Ergebnisse erfolgen morgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bekanntgabe (Singular) + Genitiv (der Ergebnisse) + erfolgt (Singular).',
    'exampleSentence': 'Die Bekanntgabe der Ergebnisse erfolgt morgen.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p8-054',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Idee wurde in Erwägung genommen.',
      'Die Idee wurde in Erwägung gezogen.',
      'Die Idee wurde in Erwägung gebracht.',
      'Die Idee wurde in Erwägung gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: in Erwägung ziehen (= erwägen).',
    'exampleSentence': 'Die Idee wurde in Erwägung gezogen.',
    'grammarRule': 'Funktionsverbgefüge: in Erwägung ziehen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-055', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die fortschreitende Digitalisierung verändert die Arbeitswelt.', 'Die fortschreitenden Digitalisierung verändert die Arbeitswelt.', 'Die fortschreitend Digitalisierung verändert die Arbeitswelt.', 'Die fortgeschrittene Digitalisierung verändert die Arbeitswelt.'], 'correctAnswer': 0, 'explanation': 'Partizip I als Adjektiv: fortschreitend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).', 'exampleSentence': 'Die fortschreitende Digitalisierung verändert die Arbeitswelt.', 'grammarRule': 'Partizipialattribut mit Partizip I', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-056', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Im Falle eines Verstoßes drohen empfindliche Strafen.', 'Im Falle ein Verstoß drohen empfindliche Strafen.', 'Im Falle eines Verstoßes empfindliche Strafen drohen.', 'Im Falle eines Verstoßes drohen empfindliche Strafen an.'], 'correctAnswer': 0, 'explanation': 'Im Falle + Genitiv: eines Verstoßes. Inversion im Hauptsatz.', 'exampleSentence': 'Im Falle eines Verstoßes drohen empfindliche Strafen.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-057', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Der Verdächtige wurde unter Anklage genommen.', 'Der Verdächtige wurde unter Anklage gestellt.', 'Der Verdächtige wurde unter Anklage gebracht.', 'Der Verdächtige wurde unter Anklage gesetzt.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: unter Anklage stellen (= anklagen).', 'exampleSentence': 'Der Verdächtige wurde unter Anklage gestellt.', 'grammarRule': 'Funktionsverbgefüge: unter Anklage stellen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-058', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Wortstellung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Weder konnte er sich konzentrieren, noch vermochte er zu arbeiten.', 'Weder er konnte sich konzentrieren, noch er vermochte zu arbeiten.', 'Weder konnte sich er konzentrieren, noch vermochte er zu arbeiten.', 'Weder konnte er sich konzentrieren, noch er vermochte zu arbeiten.'], 'correctAnswer': 0, 'explanation': 'Weder...noch: In beiden Teilen steht das Verb an zweiter Position mit Inversion.', 'exampleSentence': 'Weder konnte er sich konzentrieren, noch vermochte er zu arbeiten.', 'grammarRule': 'Weder...noch mit Inversion', 'tags': ['satzbildung', 'wortstellung'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-059', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ein nicht zu unterschätzender Faktor ist die Motivation.', 'Ein nicht zu unterschätzenden Faktor ist die Motivation.', 'Ein nicht zu unterschätzend Faktor ist die Motivation.', 'Ein nicht unterschätzender Faktor ist die Motivation.'], 'correctAnswer': 0, 'explanation': 'Gerundiv als Adjektiv: zu unterschätzend + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).', 'exampleSentence': 'Ein nicht zu unterschätzender Faktor ist die Motivation.', 'grammarRule': 'Gerundiv als Adjektivattribut', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-060', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Kraft seines Amtes hat er die Befugnis dazu.', 'Kraft seinem Amt hat er die Befugnis dazu.', 'Kraft seines Amtes er hat die Befugnis dazu.', 'Kraft seines Amtes hat die Befugnis er dazu.'], 'correctAnswer': 0, 'explanation': 'Kraft + Genitiv: seines Amtes. Gehobene Nominalstilkonstruktion.', 'exampleSentence': 'Kraft seines Amtes hat er die Befugnis dazu.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-061', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Er hat den Beweis für seine Unschuld angestellt.', 'Er hat den Beweis für seine Unschuld angetreten.', 'Er hat den Beweis für seine Unschuld angenommen.', 'Er hat den Beweis für seine Unschuld angebracht.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: den Beweis antreten (= beweisen).', 'exampleSentence': 'Er hat den Beweis für seine Unschuld angetreten.', 'grammarRule': 'Funktionsverbgefüge: den Beweis antreten', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p8-062', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die streng vertraulich behandelten Dokumente wurden verschlossen.', 'Die streng vertraulich behandelte Dokumente wurden verschlossen.', 'Die streng vertraulich behandelt Dokumente wurden verschlossen.', 'Die streng vertraulich behandelnden Dokumente wurden verschlossen.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: behandelt + -en.', 'exampleSentence': 'Die streng vertraulich behandelten Dokumente wurden verschlossen.', 'grammarRule': 'Partizipialattribut mit Partizip II (Plural)', 'tags': ['satzbildung', 'partizipialgruppen'] }
];

export default questions;
