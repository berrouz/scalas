import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-003',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wir am Wochenende fahren in die Berge.',
      'Am Wochenende fahren wir in die Berge.',
      'In die Berge am Wochenende wir fahren.',
      'Am Wochenende wir fahren in die Berge.'
    ],
    'correctAnswer': 1,
    'explanation': 'Inversion: Am Wochenende (Position 1) + fahren (Verb) + wir (Subjekt).',
    'exampleSentence': 'Am Wochenende fahren wir in die Berge.',
    'grammarRule': 'Inversion',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-005',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er bleibt zu Hause, weil er ist krank.',
      'Er bleibt zu Hause, weil er krank ist.',
      'Er bleibt weil er krank ist zu Hause.',
      'Weil er krank ist, er bleibt zu Hause.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz mit weil steht das konjugierte Verb am Ende.',
    'exampleSentence': 'Er bleibt zu Hause, weil er krank ist.',
    'grammarRule': 'Nebensatz: Verb am Ende',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-006',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Morgen ich fahre mit dem Zug nach München.',
      'Morgen fahre ich mit dem Zug nach München.',
      'Ich morgen mit dem Zug nach München fahre.',
      'Morgen fahre mit dem Zug ich nach München.'
    ],
    'correctAnswer': 1,
    'explanation': 'Inversion + TeKaMoLo: Morgen (temporal) + fahre + ich + mit dem Zug (modal) + nach München (lokal).',
    'exampleSentence': 'Morgen fahre ich mit dem Zug nach München.',
    'grammarRule': 'Inversion + TeKaMoLo',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-007',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Kind spielt im Park Fußball.',
      'Das Kind spielt Fußball im Park.',
      'Im Park das Kind Fußball spielt.',
      'Das Kind Fußball spielt im Park.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Hauptsatz: Subjekt + Verb + Lokalangabe + Akkusativobjekt.',
    'exampleSentence': 'Das Kind spielt im Park Fußball.',
    'grammarRule': 'SVO + Lokalangabe',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-008',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich bereite auf die Prüfung mich vor.',
      'Ich vorbereite mich auf die Prüfung.',
      'Ich bereite mich auf die Prüfung vor.',
      'Mich bereite ich auf die Prüfung vor.'
    ],
    'correctAnswer': 2,
    'explanation': 'Bei trennbaren Verben steht das Reflexivpronomen nach dem konjugierten Verbteil: Ich bereite mich ... vor.',
    'exampleSentence': 'Ich bereite mich auf die Prüfung vor.',
    'grammarRule': 'Trennbares Verb + Reflexivpronomen',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-012',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Mutter erzählt Geschichten den Kindern.',
      'Die Mutter den Kindern Geschichten erzählt.',
      'Die Mutter erzählt den Kindern Geschichten.',
      'Den Kindern die Mutter erzählt Geschichten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Dativ vor Akkusativ: Die Mutter erzählt den Kindern (Dat.) Geschichten (Akk.).',
    'exampleSentence': 'Die Mutter erzählt den Kindern Geschichten.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-013',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Durchführung des Experiments erfolgte unter strengen Bedingungen.',
      'Die Durchführung des Experiments erfolgen unter strengen Bedingungen.',
      'Die Durchführung dem Experiment erfolgte unter strengen Bedingungen.',
      'Die Durchführung des Experiments unter strengen Bedingungen erfolgte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Durchführung (Nominalisierung) + Genitiv (des Experiments) + konjugiertes Verb.',
    'exampleSentence': 'Die Durchführung des Experiments erfolgte unter strengen Bedingungen.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-014',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Aufgrund der steigenden Kosten wurde das Projekt eingestellt.',
      'Aufgrund die steigenden Kosten wurde das Projekt eingestellt.',
      'Aufgrund der steigenden Kosten das Projekt wurde eingestellt.',
      'Aufgrund der steigenden Kosten wurde eingestellt das Projekt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aufgrund verlangt den Genitiv: aufgrund der steigenden Kosten. Im Hauptsatz folgt Inversion nach dem Nebensatzglied.',
    'exampleSentence': 'Aufgrund der steigenden Kosten wurde das Projekt eingestellt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-015',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die am Projekt beteiligten Mitarbeiter wurden informiert.',
      'Die am Projekt beteiligte Mitarbeiter wurden informiert.',
      'Die am Projekt beteiligten Mitarbeiter wurden informieren.',
      'Die am Projekt beteiligt Mitarbeiter wurden informiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: beteiligt + Adjektivendung -en (Plural, Nominativ, bestimmter Artikel).',
    'exampleSentence': 'Die am Projekt beteiligten Mitarbeiter wurden informiert.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-016',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der laut schreiend Junge wurde beruhigt.',
      'Der laut schreiende Junge wurde beruhigt.',
      'Der laut geschreiende Junge wurde beruhigt.',
      'Der laut schreiendes Junge wurde beruhigt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Partizip I als Adjektiv: schreiend + Adjektivendung -e (Singular, Nominativ, bestimmter Artikel).',
    'exampleSentence': 'Der laut schreiende Junge wurde beruhigt.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-017',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Antrag wurde in Betracht gezogen.',
      'Der Antrag wurde in Betracht genommen.',
      'Der Antrag wurde in Betracht gegeben.',
      'Der Antrag wurde in Betracht gehalten.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: in Betracht nehmen / in Betracht genommen werden.',
    'exampleSentence': 'Der Antrag wurde in Betracht genommen.',
    'grammarRule': 'Funktionsverbgefüge: in Betracht nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-018',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Regierung hat eine Entscheidung gebracht.',
      'Die Regierung hat eine Entscheidung gemacht.',
      'Die Regierung hat eine Entscheidung getroffen.',
      'Die Regierung hat eine Entscheidung genommen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das korrekte Funktionsverbgefüge lautet: eine Entscheidung treffen.',
    'exampleSentence': 'Die Regierung hat eine Entscheidung getroffen.',
    'grammarRule': 'Funktionsverbgefüge: eine Entscheidung treffen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-019',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unter Berücksichtigung aller Faktoren wurde der Plan geändert.',
      'Unter Berücksichtigung alle Faktoren wurde der Plan geändert.',
      'Unter Berücksichtigung aller Faktoren der Plan wurde geändert.',
      'Unter Berücksichtigung aller Faktoren wurde geändert der Plan.'
    ],
    'correctAnswer': 0,
    'explanation': 'Berücksichtigung verlangt den Genitiv: aller Faktoren. Inversion im Hauptsatz nach vorangestellter Präpositionalphrase.',
    'exampleSentence': 'Unter Berücksichtigung aller Faktoren wurde der Plan geändert.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-020',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat den Vorschlag zur Diskussion gebracht.',
      'Er hat den Vorschlag zur Diskussion gestellt.',
      'Er hat den Vorschlag zur Diskussion genommen.',
      'Er hat den Vorschlag zur Diskussion gegeben.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: zur Diskussion stellen.',
    'exampleSentence': 'Er hat den Vorschlag zur Diskussion gestellt.',
    'grammarRule': 'Funktionsverbgefüge: zur Diskussion stellen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-021',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das von der Firma hergestellte Produkt ist hochwertig.',
      'Das von der Firma herstellende Produkt ist hochwertig.',
      'Das von der Firma hergestelltes Produkt ist hochwertig.',
      'Das von der Firma hergestellt Produkt ist hochwertig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: hergestellt + -e (Singular, Nominativ, Neutrum, bestimmter Artikel).',
    'exampleSentence': 'Das von der Firma hergestellte Produkt ist hochwertig.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-022',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Verbesserung der Infrastruktur ist dringend notwendig.',
      'Die Verbesserung die Infrastruktur ist dringend notwendig.',
      'Die Verbesserung der Infrastruktur dringend notwendig ist.',
      'Die Verbesserung der Infrastruktur sind dringend notwendig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verbesserung (Nominalisierung, Singular) + Genitiv (der Infrastruktur) + ist (Singular).',
    'exampleSentence': 'Die Verbesserung der Infrastruktur ist dringend notwendig.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-023',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man muss die Risiken in Kauf geben.',
      'Man muss die Risiken in Kauf stellen.',
      'Man muss die Risiken in Kauf nehmen.',
      'Man muss die Risiken in Kauf bringen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: etwas in Kauf nehmen (= akzeptieren).',
    'exampleSentence': 'Man muss die Risiken in Kauf nehmen.',
    'grammarRule': 'Funktionsverbgefüge: in Kauf nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-024',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die seit Jahren andauernde Krise hat viele Folgen.',
      'Die seit Jahren andauernden Krise hat viele Folgen.',
      'Die seit Jahren andauernd Krise hat viele Folgen.',
      'Die seit Jahren angedauerte Krise hat viele Folgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: andauernd + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die seit Jahren andauernde Krise hat viele Folgen.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-025',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Infolge des Unfalls kam es zu Verzögerungen.',
      'Infolge dem Unfall kam es zu Verzögerungen.',
      'Infolge des Unfalls es kam zu Verzögerungen.',
      'Infolge des Unfalls kam zu Verzögerungen es.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infolge verlangt den Genitiv: infolge des Unfalls. Es folgt Inversion im Hauptsatz.',
    'exampleSentence': 'Infolge des Unfalls kam es zu Verzögerungen.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-026',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das neue Gesetz tritt am 1. Januar in Kraft.',
      'Das neue Gesetz tritt am 1. Januar in Macht.',
      'Das neue Gesetz tritt am 1. Januar in Stärke.',
      'Das neue Gesetz tritt am 1. Januar in Geltung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: in Kraft treten (= wirksam werden).',
    'exampleSentence': 'Das neue Gesetz tritt am 1. Januar in Kraft.',
    'grammarRule': 'Funktionsverbgefüge: in Kraft treten',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-027',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die gut ausgebildete Fachkräfte sind gefragt.',
      'Die gut ausgebildeten Fachkräfte sind gefragt.',
      'Die gut ausgebildet Fachkräfte sind gefragt.',
      'Die gut ausbildenden Fachkräfte sind gefragt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: ausgebildet + -en.',
    'exampleSentence': 'Die gut ausgebildeten Fachkräfte sind gefragt.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-028',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Einhaltung der Vorschriften ist verpflichtend.',
      'Die Einhaltung den Vorschriften ist verpflichtend.',
      'Die Einhaltung der Vorschriften verpflichtend ist.',
      'Die Einhaltung der Vorschriften sind verpflichtend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Einhaltung (Nominalisierung, Singular) + Genitiv (der Vorschriften) + ist.',
    'exampleSentence': 'Die Einhaltung der Vorschriften ist verpflichtend.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-029',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Vertrag wurde außer Kraft genommen.',
      'Der Vertrag wurde außer Kraft gestellt.',
      'Der Vertrag wurde außer Kraft gesetzt.',
      'Der Vertrag wurde außer Kraft gebracht.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: außer Kraft setzen (= ungültig machen).',
    'exampleSentence': 'Der Vertrag wurde außer Kraft gesetzt.',
    'grammarRule': 'Funktionsverbgefüge: außer Kraft setzen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-030',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein in der Zeitung veröffentlichter Artikel sorgte für Aufsehen.',
      'Ein in der Zeitung veröffentlicht Artikel sorgte für Aufsehen.',
      'Ein in der Zeitung veröffentlichtes Artikel sorgte für Aufsehen.',
      'Ein in der Zeitung veröffentlichende Artikel sorgte für Aufsehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: veröffentlicht + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).',
    'exampleSentence': 'Ein in der Zeitung veröffentlichter Artikel sorgte für Aufsehen.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-031',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zwecks Überprüfung des Antrags bitten wir um Geduld.',
      'Zwecks Überprüfung dem Antrag bitten wir um Geduld.',
      'Zwecks Überprüfung des Antrags wir bitten um Geduld.',
      'Zwecks Überprüfung des Antrags bitten um Geduld wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zwecks verlangt den Genitiv. Inversion im Hauptsatz nach vorangestellter Präpositionalphrase.',
    'exampleSentence': 'Zwecks Überprüfung des Antrags bitten wir um Geduld.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-032',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat großen Einfluss auf die Entscheidung gebracht.',
      'Sie hat großen Einfluss auf die Entscheidung genommen.',
      'Sie hat großen Einfluss auf die Entscheidung gestellt.',
      'Sie hat großen Einfluss auf die Entscheidung gegeben.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Einfluss nehmen auf (= beeinflussen).',
    'exampleSentence': 'Sie hat großen Einfluss auf die Entscheidung genommen.',
    'grammarRule': 'Funktionsverbgefüge: Einfluss nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-033',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die schnell wachsende Bevölkerung stellt eine Herausforderung dar.',
      'Die schnell wachsenden Bevölkerung stellt eine Herausforderung dar.',
      'Die schnell gewachsene Bevölkerung stellt eine Herausforderung dar.',
      'Die schnell wachsend Bevölkerung stellt eine Herausforderung dar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: wachsend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die schnell wachsende Bevölkerung stellt eine Herausforderung dar.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-034',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Anlässlich des Jubiläums findet ein Festakt statt.',
      'Anlässlich dem Jubiläum findet ein Festakt statt.',
      'Anlässlich des Jubiläums ein Festakt findet statt.',
      'Anlässlich des Jubiläums statt findet ein Festakt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anlässlich verlangt den Genitiv: anlässlich des Jubiläums. Inversion im Hauptsatz.',
    'exampleSentence': 'Anlässlich des Jubiläums findet ein Festakt statt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-035',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wir müssen Maßnahmen zur Verbesserung nehmen.',
      'Wir müssen Maßnahmen zur Verbesserung ergreifen.',
      'Wir müssen Maßnahmen zur Verbesserung bringen.',
      'Wir müssen Maßnahmen zur Verbesserung geben.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Maßnahmen ergreifen (= handeln).',
    'exampleSentence': 'Wir müssen Maßnahmen zur Verbesserung ergreifen.',
    'grammarRule': 'Funktionsverbgefüge: Maßnahmen ergreifen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-036',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der kürzlich ernannte Direktor hielt eine Rede.',
      'Der kürzlich ernannt Direktor hielt eine Rede.',
      'Der kürzlich ernannter Direktor hielt eine Rede.',
      'Der kürzlich ernennende Direktor hielt eine Rede.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: ernannt + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel) = ernannte.',
    'exampleSentence': 'Der kürzlich ernannte Direktor hielt eine Rede.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-037',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Trotz der Schwierigkeiten wurde das Ziel erreicht.',
      'Trotz die Schwierigkeiten wurde das Ziel erreicht.',
      'Trotz der Schwierigkeiten das Ziel wurde erreicht.',
      'Trotz der Schwierigkeiten wurde erreicht das Ziel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trotz verlangt den Genitiv: trotz der Schwierigkeiten. Inversion im Hauptsatz.',
    'exampleSentence': 'Trotz der Schwierigkeiten wurde das Ziel erreicht.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-038',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat die Arbeit in Angriff gestellt.',
      'Er hat die Arbeit in Angriff genommen.',
      'Er hat die Arbeit in Angriff gebracht.',
      'Er hat die Arbeit in Angriff gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: etwas in Angriff nehmen (= beginnen).',
    'exampleSentence': 'Er hat die Arbeit in Angriff genommen.',
    'grammarRule': 'Funktionsverbgefüge: in Angriff nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-039',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das ständig klingelnde Telefon störte die Besprechung.',
      'Das ständig klingelnden Telefon störte die Besprechung.',
      'Das ständig klingeln Telefon störte die Besprechung.',
      'Das ständig geklingelte Telefon störte die Besprechung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: klingelnd + -e (Singular, Nominativ, Neutrum, bestimmter Artikel).',
    'exampleSentence': 'Das ständig klingelnde Telefon störte die Besprechung.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-040',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Hinsichtlich des Budgets müssen wir sparen.',
      'Hinsichtlich dem Budget müssen wir sparen.',
      'Hinsichtlich des Budgets wir müssen sparen.',
      'Hinsichtlich des Budgets müssen sparen wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Hinsichtlich verlangt den Genitiv: hinsichtlich des Budgets. Inversion im Hauptsatz.',
    'exampleSentence': 'Hinsichtlich des Budgets müssen wir sparen.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-041',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Firma hat Stellung zum Problem gebracht.',
      'Die Firma hat Stellung zum Problem genommen.',
      'Die Firma hat Stellung zum Problem gesetzt.',
      'Die Firma hat Stellung zum Problem gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Stellung nehmen zu (= sich äußern).',
    'exampleSentence': 'Die Firma hat Stellung zum Problem genommen.',
    'grammarRule': 'Funktionsverbgefüge: Stellung nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-042',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die frisch gebackene Brot duftet wunderbar.',
      'Das frisch gebackenes Brot duftet wunderbar.',
      'Das frisch gebackene Brot duftet wunderbar.',
      'Das frisch gebacken Brot duftet wunderbar.'
    ],
    'correctAnswer': 2,
    'explanation': 'Partizip II als Adjektiv: gebacken + -e (Singular, Nominativ, Neutrum, bestimmter Artikel).',
    'exampleSentence': 'Das frisch gebackene Brot duftet wunderbar.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-043',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mittels einer genauen Analyse konnte das Problem gelöst werden.',
      'Mittels eine genaue Analyse konnte das Problem gelöst werden.',
      'Mittels einer genauen Analyse das Problem konnte gelöst werden.',
      'Mittels einer genauen Analyse konnte gelöst werden das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mittels verlangt den Genitiv: mittels einer genauen Analyse. Inversion im Hauptsatz.',
    'exampleSentence': 'Mittels einer genauen Analyse konnte das Problem gelöst werden.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-044',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Ergebnis wurde in Frage genommen.',
      'Das Ergebnis wurde in Frage gebracht.',
      'Das Ergebnis wurde in Frage gestellt.',
      'Das Ergebnis wurde in Frage gesetzt.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: in Frage stellen (= bezweifeln).',
    'exampleSentence': 'Das Ergebnis wurde in Frage gestellt.',
    'grammarRule': 'Funktionsverbgefüge: in Frage stellen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-045',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der an der Universität lehrenden Professor ist bekannt.',
      'Der an der Universität lehrende Professor ist bekannt.',
      'Der an der Universität lehrend Professor ist bekannt.',
      'Der an der Universität gelehrte Professor ist bekannt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Partizip I als Adjektiv: lehrend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der an der Universität lehrende Professor ist bekannt.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-046',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Im Hinblick auf die Zukunft der Firma müssen Reformen erfolgen.',
      'Im Hinblick auf der Zukunft der Firma müssen Reformen erfolgen.',
      'Im Hinblick auf die Zukunft der Firma Reformen müssen erfolgen.',
      'Im Hinblick auf die Zukunft der Firma müssen erfolgen Reformen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Hinblick auf + Akkusativ: die Zukunft. Inversion im Hauptsatz nach vorangestellter Phrase.',
    'exampleSentence': 'Im Hinblick auf die Zukunft der Firma müssen Reformen erfolgen.',
    'grammarRule': 'Nominalstil: komplexe Präpositionalphrase',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-047',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Bericht hat Kritik auf sich genommen.',
      'Der Bericht hat Kritik auf sich gezogen.',
      'Der Bericht hat Kritik auf sich gebracht.',
      'Der Bericht hat Kritik auf sich gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Kritik auf sich ziehen (= kritisiert werden).',
    'exampleSentence': 'Der Bericht hat Kritik auf sich gezogen.',
    'grammarRule': 'Funktionsverbgefüge: Kritik auf sich ziehen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-048',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die sorgfältig geplante Veranstaltung war ein Erfolg.',
      'Die sorgfältig geplanten Veranstaltung war ein Erfolg.',
      'Die sorgfältig geplant Veranstaltung war ein Erfolg.',
      'Die sorgfältig planende Veranstaltung war ein Erfolg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: geplant + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die sorgfältig geplante Veranstaltung war ein Erfolg.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-049',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man muss die Konsequenzen in Rechnung bringen.',
      'Man muss die Konsequenzen in Rechnung stellen.',
      'Man muss die Konsequenzen in Rechnung nehmen.',
      'Man muss die Konsequenzen in Rechnung setzen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: jemandem etwas in Rechnung stellen (= berechnen).',
    'exampleSentence': 'Man muss die Konsequenzen in Rechnung stellen.',
    'grammarRule': 'Funktionsverbgefüge: in Rechnung stellen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-050',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein vielversprechender Ansatz wurde entwickelt.',
      'Ein vielversprechendes Ansatz wurde entwickelt.',
      'Ein vielversprechend Ansatz wurde entwickelt.',
      'Ein vielversprechenden Ansatz wurde entwickelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: vielversprechend + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).',
    'exampleSentence': 'Ein vielversprechender Ansatz wurde entwickelt.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-051',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Maßnahme hat Wirkung genommen.',
      'Die Maßnahme hat Wirkung entfaltet.',
      'Die Maßnahme hat Wirkung gestellt.',
      'Die Maßnahme hat Wirkung gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Wirkung entfalten (= wirksam werden).',
    'exampleSentence': 'Die Maßnahme hat Wirkung entfaltet.',
    'grammarRule': 'Funktionsverbgefüge: Wirkung entfalten',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p6-052',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dank der Unterstützung aller Beteiligten gelang das Projekt.',
      'Dank die Unterstützung aller Beteiligten gelang das Projekt.',
      'Dank der Unterstützung aller Beteiligten das Projekt gelang.',
      'Dank der Unterstützung aller Beteiligten gelang das Projekt an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dank + Genitiv: der Unterstützung aller Beteiligten. Inversion im Hauptsatz.',
    'exampleSentence': 'Dank der Unterstützung aller Beteiligten gelang das Projekt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  { 'language': 'german', 'id': 'c1-satzbildung-p6-053', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die zunehmend beunruhigenden Berichte alarmieren die Behörden.', 'Die zunehmend beunruhigende Berichte alarmieren die Behörden.', 'Die zunehmend beunruhigend Berichte alarmieren die Behörden.', 'Die zunehmend beunruhigten Berichte alarmieren die Behörden.'], 'correctAnswer': 0, 'explanation': 'Partizip I als Adjektiv im Plural mit bestimmtem Artikel: beunruhigend + -en.', 'exampleSentence': 'Die zunehmend beunruhigenden Berichte alarmieren die Behörden.', 'grammarRule': 'Partizipialattribut mit Partizip I (Plural)', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p6-054', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Firma hat Konkurs angemeldet.', 'Die Firma hat Konkurs angestellt.', 'Die Firma hat Konkurs angenommen.', 'Die Firma hat Konkurs angebracht.'], 'correctAnswer': 0, 'explanation': 'Das Funktionsverbgefüge lautet: Konkurs anmelden (= Insolvenz erklären).', 'exampleSentence': 'Die Firma hat Konkurs angemeldet.', 'grammarRule': 'Funktionsverbgefüge: Konkurs anmelden', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p6-056', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Wortstellung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nicht nur hat er den Preis gewonnen, sondern er wurde auch befördert.', 'Nicht nur er hat den Preis gewonnen, sondern auch er wurde befördert.', 'Nicht nur den Preis hat er gewonnen, sondern wurde er auch befördert.', 'Nicht nur hat gewonnen er den Preis, sondern er wurde auch befördert.'], 'correctAnswer': 0, 'explanation': 'Nicht nur + Inversion im ersten Teil, sondern + normaler Hauptsatz im zweiten Teil.', 'exampleSentence': 'Nicht nur hat er den Preis gewonnen, sondern er wurde auch befördert.', 'grammarRule': 'Nicht nur...sondern auch mit Inversion', 'tags': ['satzbildung', 'wortstellung'] }
];

export default questions;
