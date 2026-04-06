import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-001',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Obwohl regnet es, gehen wir spazieren.',
      'Obwohl es regnet, gehen wir spazieren.',
      'Wir gehen spazieren, obwohl es regnet, wir.',
      'Obwohl es regnet, wir gehen spazieren.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Konzessivsatz mit obwohl steht das Verb am Ende; im Hauptsatz folgt Inversion.',
    'exampleSentence': 'Obwohl es regnet, gehen wir spazieren.',
    'grammarRule': 'Konzessivsatz',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-003',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Über den Lärm er beschwert sich.',
      'Er sich beschwert über den Lärm.',
      'Er beschwert sich über den Lärm.',
      'Er beschwert über den Lärm sich.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Reflexivpronomen steht direkt nach dem konjugierten Verb: Er beschwert sich über den Lärm.',
    'exampleSentence': 'Er beschwert sich über den Lärm.',
    'grammarRule': 'Reflexivverb + Präposition',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-008',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Arzt gibt eine Tablette dem Patienten.',
      'Dem Patienten der Arzt eine Tablette gibt.',
      'Der Arzt dem Patienten gibt eine Tablette.',
      'Der Arzt gibt dem Patienten eine Tablette.'
    ],
    'correctAnswer': 3,
    'explanation': 'Dativ vor Akkusativ bei Nomen-Objekten.',
    'exampleSentence': 'Der Arzt gibt dem Patienten eine Tablette.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-013',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Reduzierung der Emissionen ist das vorrangige Ziel.',
      'Die Reduzierung die Emissionen ist das vorrangige Ziel.',
      'Die Reduzierung der Emissionen das vorrangige Ziel ist.',
      'Die Reduzierung der Emissionen sind das vorrangige Ziel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Reduzierung (Nominalisierung, Singular) + Genitiv (der Emissionen) + ist.',
    'exampleSentence': 'Die Reduzierung der Emissionen ist das vorrangige Ziel.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-014',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die von den Experten empfohlene Methode ist effektiv.',
      'Die von den Experten empfohlenen Methode ist effektiv.',
      'Die von den Experten empfohlen Methode ist effektiv.',
      'Die von den Experten empfehlende Methode ist effektiv.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: empfohlen + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die von den Experten empfohlene Methode ist effektiv.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-015',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Polizei hat Ermittlungen aufgestellt.',
      'Die Polizei hat Ermittlungen aufgenommen.',
      'Die Polizei hat Ermittlungen aufgebracht.',
      'Die Polizei hat Ermittlungen aufgesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Ermittlungen aufnehmen (= beginnen zu ermitteln).',
    'exampleSentence': 'Die Polizei hat Ermittlungen aufgenommen.',
    'grammarRule': 'Funktionsverbgefüge: Ermittlungen aufnehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-016',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Bezüglich Ihrer Anfrage teilen wir Ihnen Folgendes mit.',
      'Bezüglich Ihre Anfrage teilen wir Ihnen Folgendes mit.',
      'Bezüglich Ihrer Anfrage wir teilen Ihnen Folgendes mit.',
      'Bezüglich Ihrer Anfrage teilen Folgendes wir Ihnen mit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bezüglich verlangt den Genitiv: Ihrer Anfrage. Inversion im Hauptsatz.',
    'exampleSentence': 'Bezüglich Ihrer Anfrage teilen wir Ihnen Folgendes mit.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-017',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das zunehmend an Bedeutung gewinnende Thema wird diskutiert.',
      'Das zunehmend an Bedeutung gewinnenden Thema wird diskutiert.',
      'Das zunehmend an Bedeutung gewinnend Thema wird diskutiert.',
      'Das zunehmend an Bedeutung gewonnene Thema wird diskutiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: gewinnend + -e (Singular, Nominativ, Neutrum, bestimmter Artikel).',
    'exampleSentence': 'Das zunehmend an Bedeutung gewinnende Thema wird diskutiert.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-018',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Maschine wurde in Betrieb gesetzt.',
      'Die Maschine wurde in Betrieb gestellt.',
      'Die Maschine wurde in Betrieb gebracht.',
      'Die Maschine wurde in Betrieb genommen.'
    ],
    'correctAnswer': 3,
    'explanation': 'Das Funktionsverbgefüge lautet: in Betrieb nehmen (= starten).',
    'exampleSentence': 'Die Maschine wurde in Betrieb genommen.',
    'grammarRule': 'Funktionsverbgefüge: in Betrieb nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-019',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Im Zuge der Modernisierung wurden alte Gebäude abgerissen.',
      'Im Zuge die Modernisierung wurden alte Gebäude abgerissen.',
      'Im Zuge der Modernisierung alte Gebäude wurden abgerissen.',
      'Im Zuge der Modernisierung wurden abgerissen alte Gebäude.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Zuge + Genitiv: der Modernisierung. Inversion im Hauptsatz.',
    'exampleSentence': 'Im Zuge der Modernisierung wurden alte Gebäude abgerissen.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-020',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein überzeugend vorgetragenes Argument gewann die Debatte.',
      'Ein überzeugend vorgetragener Argument gewann die Debatte.',
      'Ein überzeugend vorgetragen Argument gewann die Debatte.',
      'Ein überzeugend vortragendes Argument gewann die Debatte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: vorgetragen + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).',
    'exampleSentence': 'Ein überzeugend vorgetragenes Argument gewann die Debatte.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-021',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat einen Beitrag zur Lösung gebracht.',
      'Er hat einen Beitrag zur Lösung geleistet.',
      'Er hat einen Beitrag zur Lösung genommen.',
      'Er hat einen Beitrag zur Lösung gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: einen Beitrag leisten (= beitragen).',
    'exampleSentence': 'Er hat einen Beitrag zur Lösung geleistet.',
    'grammarRule': 'Funktionsverbgefüge: einen Beitrag leisten',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-022',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Angesichts der Lage müssen wir schnell handeln.',
      'Angesichts die Lage müssen wir schnell handeln.',
      'Angesichts der Lage wir müssen schnell handeln.',
      'Angesichts der Lage müssen schnell handeln wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Angesichts verlangt den Genitiv: der Lage. Inversion im Hauptsatz.',
    'exampleSentence': 'Angesichts der Lage müssen wir schnell handeln.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-023',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die stark betroffene Region erhielt Hilfe.',
      'Die stark betroffenen Region erhielt Hilfe.',
      'Die stark betroffen Region erhielt Hilfe.',
      'Die stark betreffende Region erhielt Hilfe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: betroffen + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die stark betroffene Region erhielt Hilfe.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-024',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Verhandlungen wurden zum Abschluss genommen.',
      'Die Verhandlungen wurden zum Abschluss gebracht.',
      'Die Verhandlungen wurden zum Abschluss gestellt.',
      'Die Verhandlungen wurden zum Abschluss gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: zum Abschluss bringen (= beenden).',
    'exampleSentence': 'Die Verhandlungen wurden zum Abschluss gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Abschluss bringen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-025',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Überarbeitung des Konzepts nimmt mehrere Wochen in Anspruch.',
      'Die Überarbeitung dem Konzept nimmt mehrere Wochen in Anspruch.',
      'Die Überarbeitung des Konzepts mehrere Wochen in Anspruch nimmt.',
      'Die Überarbeitung des Konzepts nimmt in Anspruch mehrere Wochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Überarbeitung + Genitiv (des Konzepts). Funktionsverbgefüge: in Anspruch nehmen.',
    'exampleSentence': 'Die Überarbeitung des Konzepts nimmt mehrere Wochen in Anspruch.',
    'grammarRule': 'Nominalstil + Funktionsverbgefüge',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-026',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der leise vor sich hin summend Mann ging weiter.',
      'Der leise vor sich hin summende Mann ging weiter.',
      'Der leise vor sich hin gesummte Mann ging weiter.',
      'Der leise vor sich hin summenden Mann ging weiter.'
    ],
    'correctAnswer': 1,
    'explanation': 'Partizip I als Adjektiv: summend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der leise vor sich hin summende Mann ging weiter.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-027',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Firma hat Konkurs gestellt.',
      'Die Firma hat Konkurs angemeldet.',
      'Die Firma hat Konkurs gebracht.',
      'Die Firma hat Konkurs genommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Konkurs anmelden (= Insolvenz erklären).',
    'exampleSentence': 'Die Firma hat Konkurs angemeldet.',
    'grammarRule': 'Funktionsverbgefüge: Konkurs anmelden',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-029',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die im letzten Jahr renovierten Räume sehen modern aus.',
      'Die im letzten Jahr renovierte Räume sehen modern aus.',
      'Die im letzten Jahr renoviert Räume sehen modern aus.',
      'Die im letzten Jahr renovierenden Räume sehen modern aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: renoviert + -en.',
    'exampleSentence': 'Die im letzten Jahr renovierten Räume sehen modern aus.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-030',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Vorschlag fand allgemeine Zustimmung.',
      'Der Vorschlag nahm allgemeine Zustimmung.',
      'Der Vorschlag brachte allgemeine Zustimmung.',
      'Der Vorschlag stellte allgemeine Zustimmung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: Zustimmung finden (= akzeptiert werden).',
    'exampleSentence': 'Der Vorschlag fand allgemeine Zustimmung.',
    'grammarRule': 'Funktionsverbgefüge: Zustimmung finden',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-032',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein hervorragend ausgestattetes Labor steht zur Verfügung.',
      'Ein hervorragend ausgestatteter Labor steht zur Verfügung.',
      'Ein hervorragend ausgestattet Labor steht zur Verfügung.',
      'Ein hervorragend ausstattendes Labor steht zur Verfügung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: ausgestattet + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).',
    'exampleSentence': 'Ein hervorragend ausgestattetes Labor steht zur Verfügung.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-033',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Plan wurde in die Tat gebracht.',
      'Der Plan wurde in die Tat umgesetzt.',
      'Der Plan wurde in die Tat genommen.',
      'Der Plan wurde in die Tat gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: in die Tat umsetzen (= verwirklichen).',
    'exampleSentence': 'Der Plan wurde in die Tat umgesetzt.',
    'grammarRule': 'Funktionsverbgefüge: in die Tat umsetzen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-034',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Förderung des wissenschaftlichen Nachwuchses hat Priorität.',
      'Die Förderung den wissenschaftlichen Nachwuchs hat Priorität.',
      'Die Förderung des wissenschaftlichen Nachwuchses Priorität hat.',
      'Die Förderung des wissenschaftlichen Nachwuchses haben Priorität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Förderung (Singular) + Genitiv (des Nachwuchses) + hat (Singular).',
    'exampleSentence': 'Die Förderung des wissenschaftlichen Nachwuchses hat Priorität.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-035',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die weitreichende Folgen habende Entscheidung wurde kritisiert.',
      'Die weitreichende Folgen habenden Entscheidung wurde kritisiert.',
      'Die weitreichende Folgen habend Entscheidung wurde kritisiert.',
      'Die weitreichende Entscheidung wurde scharf kritisiert.'
    ],
    'correctAnswer': 3,
    'explanation': 'Partizipialattribute mit komplexen Ergänzungen sind stilistisch unüblich. Der einfache Satz ist korrekt.',
    'exampleSentence': 'Die weitreichende Entscheidung wurde scharf kritisiert.',
    'grammarRule': 'Erweitertes Partizipialattribut',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-036',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat Rücksicht auf die Kollegen gestellt.',
      'Sie hat Rücksicht auf die Kollegen gebracht.',
      'Sie hat Rücksicht auf die Kollegen genommen.',
      'Sie hat Rücksicht auf die Kollegen gesetzt.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: Rücksicht nehmen auf (= berücksichtigen).',
    'exampleSentence': 'Sie hat Rücksicht auf die Kollegen genommen.',
    'grammarRule': 'Funktionsverbgefüge: Rücksicht nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-037',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zum Zweck der Überprüfung werden Daten erhoben.',
      'Zum Zweck die Überprüfung werden Daten erhoben.',
      'Zum Zweck der Überprüfung Daten werden erhoben.',
      'Zum Zweck der Überprüfung werden erhoben Daten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zum Zweck + Genitiv: der Überprüfung. Inversion im Hauptsatz.',
    'exampleSentence': 'Zum Zweck der Überprüfung werden Daten erhoben.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-038',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die rasant steigenden Preise beunruhigen die Bevölkerung.',
      'Die rasant steigende Preise beunruhigen die Bevölkerung.',
      'Die rasant steigend Preise beunruhigen die Bevölkerung.',
      'Die rasant gestiegenen Preise beunruhigen die Bevölkerung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv im Plural mit bestimmtem Artikel: steigend + -en.',
    'exampleSentence': 'Die rasant steigenden Preise beunruhigen die Bevölkerung.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-039',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Problem wurde zur Sprache genommen.',
      'Das Problem wurde zur Sprache gebracht.',
      'Das Problem wurde zur Sprache gestellt.',
      'Das Problem wurde zur Sprache gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: zur Sprache bringen (= ansprechen).',
    'exampleSentence': 'Das Problem wurde zur Sprache gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zur Sprache bringen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-040',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Auswertung der Ergebnisse dauert mehrere Tage.',
      'Die Auswertung die Ergebnisse dauert mehrere Tage.',
      'Die Auswertung der Ergebnisse mehrere Tage dauert.',
      'Die Auswertung der Ergebnisse dauern mehrere Tage.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Auswertung (Singular) + Genitiv (der Ergebnisse) + dauert (Singular).',
    'exampleSentence': 'Die Auswertung der Ergebnisse dauert mehrere Tage.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-041',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der in Berlin lebende Künstler stellt seine Werke aus.',
      'Der in Berlin lebenden Künstler stellt seine Werke aus.',
      'Der in Berlin lebend Künstler stellt seine Werke aus.',
      'Der in Berlin gelebte Künstler stellt seine Werke aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: lebend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der in Berlin lebende Künstler stellt seine Werke aus.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-042',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wir haben Abschied von den Kollegen gestellt.',
      'Wir haben Abschied von den Kollegen gebracht.',
      'Wir haben Abschied von den Kollegen genommen.',
      'Wir haben Abschied von den Kollegen gesetzt.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: Abschied nehmen von (= sich verabschieden).',
    'exampleSentence': 'Wir haben Abschied von den Kollegen genommen.',
    'grammarRule': 'Funktionsverbgefüge: Abschied nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-043',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ungeachtet der Proteste wurde das Gesetz verabschiedet.',
      'Ungeachtet die Proteste wurde das Gesetz verabschiedet.',
      'Ungeachtet der Proteste das Gesetz wurde verabschiedet.',
      'Ungeachtet der Proteste wurde verabschiedet das Gesetz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ungeachtet verlangt den Genitiv: der Proteste. Inversion im Hauptsatz.',
    'exampleSentence': 'Ungeachtet der Proteste wurde das Gesetz verabschiedet.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-044',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die streng kontrollierten Grenzen schützen das Land.',
      'Die streng kontrollierte Grenzen schützen das Land.',
      'Die streng kontrolliert Grenzen schützen das Land.',
      'Die streng kontrollierenden Grenzen schützen das Land.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: kontrolliert + -en.',
    'exampleSentence': 'Die streng kontrollierten Grenzen schützen das Land.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-045',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Idee hat Anklang bei den Mitarbeitern gestellt.',
      'Die Idee hat Anklang bei den Mitarbeitern gefunden.',
      'Die Idee hat Anklang bei den Mitarbeitern genommen.',
      'Die Idee hat Anklang bei den Mitarbeitern gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Anklang finden (= positiv aufgenommen werden).',
    'exampleSentence': 'Die Idee hat Anklang bei den Mitarbeitern gefunden.',
    'grammarRule': 'Funktionsverbgefüge: Anklang finden',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-046',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Auf Wunsch des Kunden wurde die Lieferung beschleunigt.',
      'Auf Wunsch dem Kunden wurde die Lieferung beschleunigt.',
      'Auf Wunsch des Kunden die Lieferung wurde beschleunigt.',
      'Auf Wunsch des Kunden wurde beschleunigt die Lieferung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Auf Wunsch + Genitiv: des Kunden. Inversion im Hauptsatz.',
    'exampleSentence': 'Auf Wunsch des Kunden wurde die Lieferung beschleunigt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-047',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein neu eröffnetes Restaurant zieht viele Gäste an.',
      'Ein neu eröffneter Restaurant zieht viele Gäste an.',
      'Ein neu eröffnet Restaurant zieht viele Gäste an.',
      'Ein neu eröffnendes Restaurant zieht viele Gäste an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: eröffnet + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).',
    'exampleSentence': 'Ein neu eröffnetes Restaurant zieht viele Gäste an.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-048',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat Wert auf Pünktlichkeit gestellt.',
      'Sie hat Wert auf Pünktlichkeit gelegt.',
      'Sie hat Wert auf Pünktlichkeit genommen.',
      'Sie hat Wert auf Pünktlichkeit gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Wert legen auf (= wichtig finden).',
    'exampleSentence': 'Sie hat Wert auf Pünktlichkeit gelegt.',
    'grammarRule': 'Funktionsverbgefüge: Wert legen auf',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-050',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die aufmerksam zuhörende Studentin stellte eine Frage.',
      'Die aufmerksam zuhörenden Studentin stellte eine Frage.',
      'Die aufmerksam zuhörend Studentin stellte eine Frage.',
      'Die aufmerksam zugehörte Studentin stellte eine Frage.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: zuhörend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die aufmerksam zuhörende Studentin stellte eine Frage.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-051',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat Rechenschaft über seine Taten abgestellt.',
      'Er hat Rechenschaft über seine Taten abgelegt.',
      'Er hat Rechenschaft über seine Taten abgenommen.',
      'Er hat Rechenschaft über seine Taten abgebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Rechenschaft ablegen (= sich verantworten).',
    'exampleSentence': 'Er hat Rechenschaft über seine Taten abgelegt.',
    'grammarRule': 'Funktionsverbgefüge: Rechenschaft ablegen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-052',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die heftig diskutierte Frage blieb ungelöst.',
      'Die heftig diskutierten Frage blieb ungelöst.',
      'Die heftig diskutiert Frage blieb ungelöst.',
      'Die heftig diskutierende Frage blieb ungelöst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: diskutiert + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die heftig diskutierte Frage blieb ungelöst.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p7-053',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Inanspruchnahme der Leistungen setzt eine Anmeldung voraus.',
      'Die Inanspruchnahme die Leistungen setzt eine Anmeldung voraus.',
      'Die Inanspruchnahme der Leistungen eine Anmeldung voraussetzt.',
      'Die Inanspruchnahme der Leistungen setzen eine Anmeldung voraus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Inanspruchnahme (Singular) + Genitiv (der Leistungen) + setzt ... voraus.',
    'exampleSentence': 'Die Inanspruchnahme der Leistungen setzt eine Anmeldung voraus.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-054', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Regierung hat Stellung zu dem Vorwurf genommen.', 'Die Regierung hat Stellung zu dem Vorwurf gestellt.', 'Die Regierung hat Stellung zu dem Vorwurf gebracht.', 'Die Regierung hat Stellung zu dem Vorwurf gesetzt.'], 'correctAnswer': 0, 'explanation': 'Das Funktionsverbgefüge lautet: Stellung nehmen zu (= sich äußern).', 'exampleSentence': 'Die Regierung hat Stellung zu dem Vorwurf genommen.', 'grammarRule': 'Funktionsverbgefüge: Stellung nehmen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-055', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Das soeben veröffentlichte Gutachten sorgt für Aufsehen.', 'Das soeben veröffentlichten Gutachten sorgt für Aufsehen.', 'Das soeben veröffentlicht Gutachten sorgt für Aufsehen.', 'Das soeben veröffentlichende Gutachten sorgt für Aufsehen.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: veröffentlicht + -e (Singular, Nominativ, Neutrum, bestimmter Artikel).', 'exampleSentence': 'Das soeben veröffentlichte Gutachten sorgt für Aufsehen.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-056', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Vorbehaltlich der Zustimmung des Aufsichtsrats tritt die Änderung in Kraft.', 'Vorbehaltlich die Zustimmung des Aufsichtsrats tritt die Änderung in Kraft.', 'Vorbehaltlich der Zustimmung des Aufsichtsrats die Änderung tritt in Kraft.', 'Vorbehaltlich der Zustimmung des Aufsichtsrats tritt in Kraft die Änderung.'], 'correctAnswer': 0, 'explanation': 'Vorbehaltlich + Genitiv: der Zustimmung des Aufsichtsrats. Inversion im Hauptsatz.', 'exampleSentence': 'Vorbehaltlich der Zustimmung des Aufsichtsrats tritt die Änderung in Kraft.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-057', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Wortstellung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Kaum hatte sie das Haus verlassen, als es zu regnen begann.', 'Kaum sie hatte das Haus verlassen, als es zu regnen begann.', 'Kaum hatte sie das Haus verlassen, als es begann zu regnen.', 'Kaum hatte sie das Haus verlassen, begann es zu regnen als.'], 'correctAnswer': 0, 'explanation': 'Kaum + Inversion (hatte sie), als + Hauptsatz mit normaler Wortstellung.', 'exampleSentence': 'Kaum hatte sie das Haus verlassen, als es zu regnen begann.', 'grammarRule': 'Temporale Konstruktion kaum...als', 'tags': ['satzbildung', 'wortstellung'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-059', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ein kaum zu bewältigender Arbeitsaufwand erwartet uns.', 'Ein kaum zu bewältigenden Arbeitsaufwand erwartet uns.', 'Ein kaum zu bewältigend Arbeitsaufwand erwartet uns.', 'Ein kaum bewältigender Arbeitsaufwand erwartet uns.'], 'correctAnswer': 0, 'explanation': 'Gerundiv (zu + Partizip I) als Adjektiv: zu bewältigend + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).', 'exampleSentence': 'Ein kaum zu bewältigender Arbeitsaufwand erwartet uns.', 'grammarRule': 'Gerundiv als Adjektivattribut', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-060', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Angesichts der aktuellen Lage sind sofortige Maßnahmen erforderlich.', 'Angesichts die aktuelle Lage sind sofortige Maßnahmen erforderlich.', 'Angesichts der aktuellen Lage sofortige Maßnahmen sind erforderlich.', 'Angesichts der aktuellen Lage sind erforderlich sofortige Maßnahmen.'], 'correctAnswer': 0, 'explanation': 'Angesichts + Genitiv: der aktuellen Lage. Normaler Hauptsatz folgt.', 'exampleSentence': 'Angesichts der aktuellen Lage sind sofortige Maßnahmen erforderlich.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-061', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Verhandlungen sind zum Stillstand genommen.', 'Die Verhandlungen sind zum Stillstand gekommen.', 'Die Verhandlungen sind zum Stillstand gestellt.', 'Die Verhandlungen sind zum Stillstand gebracht.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: zum Stillstand kommen (= aufhören, sich zu bewegen).', 'exampleSentence': 'Die Verhandlungen sind zum Stillstand gekommen.', 'grammarRule': 'Funktionsverbgefüge: zum Stillstand kommen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p7-062', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die von Experten empfohlene Vorgehensweise wurde übernommen.', 'Die von Experten empfohlenen Vorgehensweise wurde übernommen.', 'Die von Experten empfohlen Vorgehensweise wurde übernommen.', 'Die von Experten empfehlende Vorgehensweise wurde übernommen.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: empfohlen + -e (Singular, Nominativ, Femininum, bestimmter Artikel).', 'exampleSentence': 'Die von Experten empfohlene Vorgehensweise wurde übernommen.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] }
];

export default questions;
