import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-001',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wir gehen spazieren, obwohl es regnet, wir.',
      'Obwohl es regnet, wir gehen spazieren.',
      'Obwohl es regnet, gehen wir spazieren.',
      'Obwohl regnet es, gehen wir spazieren.'
    ],
    'correctAnswer': 2,
    'explanation': 'Konzessivsatz: obwohl + Verb am Ende. Inversion im Hauptsatz.',
    'exampleSentence': 'Obwohl es regnet, gehen wir spazieren.',
    'grammarRule': 'Konzessivsatz',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-002',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nachdem er gegessen hatte, ging er spazieren.',
      'Nachdem er gegessen hat, ging er spazieren.',
      'Nachdem er aß, ging er spazieren.',
      'Er ging spazieren, nachdem er gegessen hat.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach nachdem im Vergangenheitskontext steht Plusquamperfekt im Nebensatz.',
    'exampleSentence': 'Nachdem er gegessen hatte, ging er spazieren.',
    'grammarRule': 'nachdem + Plusquamperfekt',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-003',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er sich beschwert über den Lärm.',
      'Über den Lärm er beschwert sich.',
      'Er beschwert über den Lärm sich.',
      'Er beschwert sich über den Lärm.'
    ],
    'correctAnswer': 3,
    'explanation': 'Reflexivpronomen steht direkt nach dem konjugierten Verb.',
    'exampleSentence': 'Er beschwert sich über den Lärm.',
    'grammarRule': 'Reflexivverb + Präposition',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-004',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Mutter den Kindern Geschichten erzählt.',
      'Die Mutter erzählt Geschichten den Kindern.',
      'Die Mutter erzählt den Kindern Geschichten.',
      'Den Kindern die Mutter erzählt Geschichten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Dativ vor Akkusativ bei Nomen-Objekten.',
    'exampleSentence': 'Die Mutter erzählt den Kindern Geschichten.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-005',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gestern ich bin ins Kino gegangen.',
      'Gestern bin ich ins Kino gegangen.',
      'Ins Kino gestern ich bin gegangen.',
      'Ich gestern ins Kino bin gegangen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Inversion: Zeitangabe (Position 1) + Verb + Subjekt.',
    'exampleSentence': 'Gestern bin ich ins Kino gegangen.',
    'grammarRule': 'Inversion: Zeitangabe + Verb + Subjekt',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-006',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Jeden Tag meine Schwester macht Sport.',
      'Sport macht meine Schwester jeden Tag.',
      'Meine Schwester jeden Tag Sport macht.',
      'Meine Schwester macht jeden Tag Sport.'
    ],
    'correctAnswer': 3,
    'explanation': 'SVO-Reihenfolge: Subjekt + Verb + Objekt.',
    'exampleSentence': 'Meine Schwester macht jeden Tag Sport.',
    'grammarRule': 'SVO-Reihenfolge',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-008',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Arzt dem Patienten gibt eine Tablette.',
      'Dem Patienten der Arzt eine Tablette gibt.',
      'Der Arzt gibt dem Patienten eine Tablette.',
      'Der Arzt gibt eine Tablette dem Patienten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Dativ vor Akkusativ bei Nomen-Objekten.',
    'exampleSentence': 'Der Arzt gibt dem Patienten eine Tablette.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-010',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Morgen fahre ich mit dem Zug nach München.',
      'Morgen ich fahre mit dem Zug nach München.',
      'Morgen fahre mit dem Zug ich nach München.',
      'Ich morgen mit dem Zug nach München fahre.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion + TeKaMoLo: Morgen + fahre + ich + mit dem Zug + nach München.',
    'exampleSentence': 'Morgen fahre ich mit dem Zug nach München.',
    'grammarRule': 'Inversion + TeKaMoLo',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-011',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Kind Fußball spielt im Park.',
      'Das Kind spielt im Park Fußball.',
      'Im Park das Kind Fußball spielt.',
      'Das Kind spielt Fußball im Park.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Hauptsatz: Subjekt + Verb + Lokalangabe + Akkusativobjekt.',
    'exampleSentence': 'Das Kind spielt im Park Fußball.',
    'grammarRule': 'SVO + Lokalangabe',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-012',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich bereite mich auf die Prüfung vor.',
      'Ich bereite auf die Prüfung mich vor.',
      'Ich vorbereite mich auf die Prüfung.',
      'Mich bereite ich auf die Prüfung vor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb: Ich bereite ... vor. Reflexivpronomen steht nach dem Verbteil.',
    'exampleSentence': 'Ich bereite mich auf die Prüfung vor.',
    'grammarRule': 'Trennbares Verb + Reflexivpronomen',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-013',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Ausweitung des Handels fördert das Wirtschaftswachstum.',
      'Die Ausweitung den Handel fördert das Wirtschaftswachstum.',
      'Die Ausweitung des Handels das Wirtschaftswachstum fördert.',
      'Die Ausweitung des Handels fördern das Wirtschaftswachstum.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Ausweitung (Singular) + Genitiv (des Handels) + fördert (Singular).',
    'exampleSentence': 'Die Ausweitung des Handels fördert das Wirtschaftswachstum.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-014',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die bereits abgeschlossene Untersuchung ergab keine Auffälligkeiten.',
      'Die bereits abgeschlossenen Untersuchung ergab keine Auffälligkeiten.',
      'Die bereits abgeschlossen Untersuchung ergab keine Auffälligkeiten.',
      'Die bereits abschließende Untersuchung ergab keine Auffälligkeiten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: abgeschlossen + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die bereits abgeschlossene Untersuchung ergab keine Auffälligkeiten.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-015',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat dem Team Hilfe genommen.',
      'Er hat dem Team Hilfe geleistet.',
      'Er hat dem Team Hilfe gestellt.',
      'Er hat dem Team Hilfe gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Hilfe leisten (= helfen).',
    'exampleSentence': 'Er hat dem Team Hilfe geleistet.',
    'grammarRule': 'Funktionsverbgefüge: Hilfe leisten',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-016',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unbeschadet der Einwände wurde der Plan umgesetzt.',
      'Unbeschadet die Einwände wurde der Plan umgesetzt.',
      'Unbeschadet der Einwände der Plan wurde umgesetzt.',
      'Unbeschadet der Einwände wurde umgesetzt der Plan.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unbeschadet + Genitiv: der Einwände. Inversion im Hauptsatz.',
    'exampleSentence': 'Unbeschadet der Einwände wurde der Plan umgesetzt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-017',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der überraschend schnell reagierende Torhüter verhinderte das Tor.',
      'Der überraschend schnell reagierenden Torhüter verhinderte das Tor.',
      'Der überraschend schnell reagierend Torhüter verhinderte das Tor.',
      'Der überraschend schnell reagierte Torhüter verhinderte das Tor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: reagierend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der überraschend schnell reagierende Torhüter verhinderte das Tor.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-018',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Firma hat einen Gewinn von 10 Prozent verzeichnet.',
      'Die Firma hat einen Gewinn von 10 Prozent gebracht.',
      'Die Firma hat einen Gewinn von 10 Prozent gestellt.',
      'Die Firma hat einen Gewinn von 10 Prozent genommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: einen Gewinn verzeichnen (= Gewinn haben).',
    'exampleSentence': 'Die Firma hat einen Gewinn von 10 Prozent verzeichnet.',
    'grammarRule': 'Funktionsverbgefüge: einen Gewinn verzeichnen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-019',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zum Schutz der Umwelt werden strenge Regeln eingeführt.',
      'Zum Schutz die Umwelt werden strenge Regeln eingeführt.',
      'Zum Schutz der Umwelt strenge Regeln werden eingeführt.',
      'Zum Schutz der Umwelt werden eingeführt strenge Regeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zum Schutz + Genitiv: der Umwelt. Inversion im Hauptsatz.',
    'exampleSentence': 'Zum Schutz der Umwelt werden strenge Regeln eingeführt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-020',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die grundlegend veränderte Situation erfordert neue Strategien.',
      'Die grundlegend veränderten Situation erfordert neue Strategien.',
      'Die grundlegend verändert Situation erfordert neue Strategien.',
      'Die grundlegend verändernde Situation erfordert neue Strategien.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: verändert + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die grundlegend veränderte Situation erfordert neue Strategien.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-021',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Thema hat Interesse bei den Teilnehmern gebracht.',
      'Das Thema hat Interesse bei den Teilnehmern geweckt.',
      'Das Thema hat Interesse bei den Teilnehmern genommen.',
      'Das Thema hat Interesse bei den Teilnehmern gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Interesse wecken (= interessieren).',
    'exampleSentence': 'Das Thema hat Interesse bei den Teilnehmern geweckt.',
    'grammarRule': 'Funktionsverbgefüge: Interesse wecken',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-022',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Verringerung der Bürokratie spart Zeit und Geld.',
      'Die Verringerung die Bürokratie spart Zeit und Geld.',
      'Die Verringerung der Bürokratie Zeit und Geld spart.',
      'Die Verringerung der Bürokratie sparen Zeit und Geld.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verringerung (Singular) + Genitiv (der Bürokratie) + spart (Singular).',
    'exampleSentence': 'Die Verringerung der Bürokratie spart Zeit und Geld.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-023',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die weithin sichtbaren Türme prägen die Skyline.',
      'Die weithin sichtbare Türme prägen die Skyline.',
      'Die weithin sichtbar Türme prägen die Skyline.',
      'Die weithin gesehenen Türme prägen die Skyline.'
    ],
    'correctAnswer': 0,
    'explanation': 'Adjektiv im Plural mit bestimmtem Artikel: sichtbar + -en (wie bei Partizipialattributen).',
    'exampleSentence': 'Die weithin sichtbaren Türme prägen die Skyline.',
    'grammarRule': 'Erweitertes Adjektivattribut',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-024',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Studenten haben einen Protest zum Ausdruck genommen.',
      'Die Studenten haben einen Protest zum Ausdruck gebracht.',
      'Die Studenten haben einen Protest zum Ausdruck gestellt.',
      'Die Studenten haben einen Protest zum Ausdruck gesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: zum Ausdruck bringen (= ausdrücken).',
    'exampleSentence': 'Die Studenten haben einen Protest zum Ausdruck gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Ausdruck bringen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-025',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Infolge des Klimawandels nehmen Naturkatastrophen zu.',
      'Infolge dem Klimawandel nehmen Naturkatastrophen zu.',
      'Infolge des Klimawandels Naturkatastrophen nehmen zu.',
      'Infolge des Klimawandels nehmen zu Naturkatastrophen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infolge + Genitiv: des Klimawandels. Inversion im Hauptsatz.',
    'exampleSentence': 'Infolge des Klimawandels nehmen Naturkatastrophen zu.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-026',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der sorgfältig durchdachte Plan wurde umgesetzt.',
      'Der sorgfältig durchdachten Plan wurde umgesetzt.',
      'Der sorgfältig durchdacht Plan wurde umgesetzt.',
      'Der sorgfältig durchdenkende Plan wurde umgesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: durchdacht + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der sorgfältig durchdachte Plan wurde umgesetzt.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-027',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Vertrag wurde in Kraft genommen.',
      'Der Vertrag wurde in Kraft gesetzt.',
      'Der Vertrag wurde in Kraft gestellt.',
      'Der Vertrag wurde in Kraft gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: in Kraft setzen (= gültig machen).',
    'exampleSentence': 'Der Vertrag wurde in Kraft gesetzt.',
    'grammarRule': 'Funktionsverbgefüge: in Kraft setzen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-028',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Erhaltung der biologischen Vielfalt betrifft uns alle.',
      'Die Erhaltung die biologische Vielfalt betrifft uns alle.',
      'Die Erhaltung der biologischen Vielfalt uns alle betrifft.',
      'Die Erhaltung der biologischen Vielfalt betreffen uns alle.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Erhaltung (Singular) + Genitiv (der biologischen Vielfalt) + betrifft (Singular).',
    'exampleSentence': 'Die Erhaltung der biologischen Vielfalt betrifft uns alle.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-029',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die auffallend gut organisierte Konferenz fand großen Anklang.',
      'Die auffallend gut organisierte Konferenz fanden großen Anklang.',
      'Die auffallend gut organisiert Konferenz fand großen Anklang.',
      'Die auffallend gut organisierende Konferenz fand großen Anklang.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: organisiert + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die auffallend gut organisierte Konferenz fand großen Anklang.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-030',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Verhandlungen kamen zum Erliegen.',
      'Die Verhandlungen gingen zum Erliegen.',
      'Die Verhandlungen nahmen zum Erliegen.',
      'Die Verhandlungen stellten zum Erliegen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: zum Erliegen kommen (= zum Stillstand kommen).',
    'exampleSentence': 'Die Verhandlungen kamen zum Erliegen.',
    'grammarRule': 'Funktionsverbgefüge: zum Erliegen kommen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-031',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unter Ausschluss der Öffentlichkeit fand die Verhandlung statt.',
      'Unter Ausschluss die Öffentlichkeit fand die Verhandlung statt.',
      'Unter Ausschluss der Öffentlichkeit die Verhandlung fand statt.',
      'Unter Ausschluss der Öffentlichkeit fand statt die Verhandlung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unter Ausschluss + Genitiv: der Öffentlichkeit. Inversion im Hauptsatz.',
    'exampleSentence': 'Unter Ausschluss der Öffentlichkeit fand die Verhandlung statt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-032',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die rasch zunehmende Verschmutzung gefährdet die Gewässer.',
      'Die rasch zunehmenden Verschmutzung gefährdet die Gewässer.',
      'Die rasch zunehmend Verschmutzung gefährdet die Gewässer.',
      'Die rasch zugenommene Verschmutzung gefährdet die Gewässer.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: zunehmend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die rasch zunehmende Verschmutzung gefährdet die Gewässer.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-033',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Mitarbeiter haben Beschwerde über die Zustände eingestellt.',
      'Die Mitarbeiter haben Beschwerde über die Zustände eingelegt.',
      'Die Mitarbeiter haben Beschwerde über die Zustände eingenommen.',
      'Die Mitarbeiter haben Beschwerde über die Zustände eingebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Beschwerde einlegen (= sich beschweren).',
    'exampleSentence': 'Die Mitarbeiter haben Beschwerde über die Zustände eingelegt.',
    'grammarRule': 'Funktionsverbgefüge: Beschwerde einlegen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-034',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Entlastung der Steuerzahler steht zur Debatte.',
      'Die Entlastung die Steuerzahler steht zur Debatte.',
      'Die Entlastung der Steuerzahler zur Debatte steht.',
      'Die Entlastung der Steuerzahler stehen zur Debatte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Entlastung (Singular) + Genitiv (der Steuerzahler) + steht (Singular).',
    'exampleSentence': 'Die Entlastung der Steuerzahler steht zur Debatte.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-035',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein vollständig renoviertes Schloss dient als Museum.',
      'Ein vollständig renovierter Schloss dient als Museum.',
      'Ein vollständig renoviert Schloss dient als Museum.',
      'Ein vollständig renovierendes Schloss dient als Museum.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: renoviert + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).',
    'exampleSentence': 'Ein vollständig renoviertes Schloss dient als Museum.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-036',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wir haben Fortschritte bei der Umsetzung erzielt.',
      'Wir haben Fortschritte bei der Umsetzung gebracht.',
      'Wir haben Fortschritte bei der Umsetzung gestellt.',
      'Wir haben Fortschritte bei der Umsetzung genommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: Fortschritte erzielen (= vorankommen).',
    'exampleSentence': 'Wir haben Fortschritte bei der Umsetzung erzielt.',
    'grammarRule': 'Funktionsverbgefüge: Fortschritte erzielen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-037',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Im Anschluss an die Konferenz findet ein Empfang statt.',
      'Im Anschluss an der Konferenz findet ein Empfang statt.',
      'Im Anschluss an die Konferenz ein Empfang findet statt.',
      'Im Anschluss an die Konferenz statt findet ein Empfang.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Anschluss an + Akkusativ: die Konferenz. Inversion im Hauptsatz.',
    'exampleSentence': 'Im Anschluss an die Konferenz findet ein Empfang statt.',
    'grammarRule': 'Nominalstil: komplexe Präpositionalphrase',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-038',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die bedrohlich wirkenden Wolken verdunkelten den Himmel.',
      'Die bedrohlich wirkende Wolken verdunkelten den Himmel.',
      'Die bedrohlich wirkend Wolken verdunkelten den Himmel.',
      'Die bedrohlich gewirkten Wolken verdunkelten den Himmel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv im Plural mit bestimmtem Artikel: wirkend + -en.',
    'exampleSentence': 'Die bedrohlich wirkenden Wolken verdunkelten den Himmel.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-039',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat einen Vorschlag zur Verbesserung gemacht.',
      'Er hat einen Vorschlag zur Verbesserung gestellt.',
      'Er hat einen Vorschlag zur Verbesserung genommen.',
      'Er hat einen Vorschlag zur Verbesserung gebracht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: einen Vorschlag machen (= vorschlagen).',
    'exampleSentence': 'Er hat einen Vorschlag zur Verbesserung gemacht.',
    'grammarRule': 'Funktionsverbgefüge: einen Vorschlag machen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p10-050',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Wiederherstellung der öffentlichen Ordnung hat höchste Priorität.',
      'Die Wiederherstellung die öffentliche Ordnung hat höchste Priorität.',
      'Die Wiederherstellung der öffentlichen Ordnung höchste Priorität hat.',
      'Die Wiederherstellung der öffentlichen Ordnung haben höchste Priorität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Wiederherstellung (Singular) + Genitiv (der öffentlichen Ordnung) + hat (Singular).',
    'exampleSentence': 'Die Wiederherstellung der öffentlichen Ordnung hat höchste Priorität.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-040', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die unerwartet aufgetretenen Probleme verzögerten das Projekt.', 'Die unerwartet aufgetretene Probleme verzögerten das Projekt.', 'Die unerwartet aufgetreten Probleme verzögerten das Projekt.', 'Die unerwartet auftretenden Probleme verzögerten das Projekt.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: aufgetreten + -en.', 'exampleSentence': 'Die unerwartet aufgetretenen Probleme verzögerten das Projekt.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-041', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Maßnahme hat ihre Wirkung genommen.', 'Die Maßnahme hat ihre Wirkung verfehlt.', 'Die Maßnahme hat ihre Wirkung gestellt.', 'Die Maßnahme hat ihre Wirkung gebracht.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: die Wirkung verfehlen (= nicht wirken).', 'exampleSentence': 'Die Maßnahme hat ihre Wirkung verfehlt.', 'grammarRule': 'Funktionsverbgefüge: die Wirkung verfehlen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-042', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Gemäß den Bestimmungen des Vertrags ist eine Kündigung möglich.', 'Gemäß die Bestimmungen des Vertrags ist eine Kündigung möglich.', 'Gemäß den Bestimmungen des Vertrags eine Kündigung ist möglich.', 'Gemäß den Bestimmungen des Vertrags ist möglich eine Kündigung.'], 'correctAnswer': 0, 'explanation': 'Gemäß + Dativ: den Bestimmungen. Inversion im Hauptsatz.', 'exampleSentence': 'Gemäß den Bestimmungen des Vertrags ist eine Kündigung möglich.', 'grammarRule': 'Nominalstil: Präposition + Dativ', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-043', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Der kontinuierlich sinkende Wasserstand bereitet Sorgen.', 'Der kontinuierlich sinkenden Wasserstand bereitet Sorgen.', 'Der kontinuierlich sinkend Wasserstand bereitet Sorgen.', 'Der kontinuierlich gesunkene Wasserstand bereiten Sorgen.'], 'correctAnswer': 0, 'explanation': 'Partizip I als Adjektiv: sinkend + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).', 'exampleSentence': 'Der kontinuierlich sinkende Wasserstand bereitet Sorgen.', 'grammarRule': 'Partizipialattribut mit Partizip I', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-044', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Er hat einen Eid auf die Verfassung gestellt.', 'Er hat einen Eid auf die Verfassung abgelegt.', 'Er hat einen Eid auf die Verfassung genommen.', 'Er hat einen Eid auf die Verfassung gebracht.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: einen Eid ablegen (= schwören).', 'exampleSentence': 'Er hat einen Eid auf die Verfassung abgelegt.', 'grammarRule': 'Funktionsverbgefüge: einen Eid ablegen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-045', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Verlagerung des Schwerpunkts auf erneuerbare Energien ist notwendig.', 'Die Verlagerung den Schwerpunkt auf erneuerbare Energien ist notwendig.', 'Die Verlagerung des Schwerpunkts auf erneuerbare Energien notwendig ist.', 'Die Verlagerung des Schwerpunkts auf erneuerbare Energien sind notwendig.'], 'correctAnswer': 0, 'explanation': 'Nominalstil: Verlagerung (Singular) + Genitiv (des Schwerpunkts) + ist.', 'exampleSentence': 'Die Verlagerung des Schwerpunkts auf erneuerbare Energien ist notwendig.', 'grammarRule': 'Nominalstil mit Genitivattribut', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-046', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ein sorgfältig ausgearbeiteter Vertrag schützt beide Seiten.', 'Ein sorgfältig ausgearbeitetes Vertrag schützt beide Seiten.', 'Ein sorgfältig ausgearbeitet Vertrag schützt beide Seiten.', 'Ein sorgfältig ausarbeitender Vertrag schützt beide Seiten.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: ausgearbeitet + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).', 'exampleSentence': 'Ein sorgfältig ausgearbeiteter Vertrag schützt beide Seiten.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-047', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Das Projekt wurde in Angriff gestellt.', 'Das Projekt wurde in Angriff gebracht.', 'Das Projekt wurde in Angriff genommen.', 'Das Projekt wurde in Angriff gesetzt.'], 'correctAnswer': 2, 'explanation': 'Das Funktionsverbgefüge lautet: in Angriff nehmen (= beginnen).', 'exampleSentence': 'Das Projekt wurde in Angriff genommen.', 'grammarRule': 'Funktionsverbgefüge: in Angriff nehmen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-048', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Während der Dauer des Verfahrens gilt eine Sperrfrist.', 'Während die Dauer des Verfahrens gilt eine Sperrfrist.', 'Während der Dauer des Verfahrens eine Sperrfrist gilt.', 'Während der Dauer des Verfahrens gilt eine Sperrfrist an.'], 'correctAnswer': 0, 'explanation': 'Während + Genitiv: der Dauer des Verfahrens. Inversion im Hauptsatz.', 'exampleSentence': 'Während der Dauer des Verfahrens gilt eine Sperrfrist.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-049', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die lebhaft diskutierende Gruppe kam zu keinem Ergebnis.', 'Die lebhaft diskutierenden Gruppe kam zu keinem Ergebnis.', 'Die lebhaft diskutierend Gruppe kam zu keinem Ergebnis.', 'Die lebhaft diskutierte Gruppe kam zu keinem Ergebnis.'], 'correctAnswer': 0, 'explanation': 'Partizip I als Adjektiv: diskutierend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).', 'exampleSentence': 'Die lebhaft diskutierende Gruppe kam zu keinem Ergebnis.', 'grammarRule': 'Partizipialattribut mit Partizip I', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-051', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Firma hat Gewinn verbucht.', 'Die Firma hat Gewinn gestellt.', 'Die Firma hat Gewinn gebracht.', 'Die Firma hat Gewinn genommen.'], 'correctAnswer': 0, 'explanation': 'Das Funktionsverbgefüge lautet: Gewinn verbuchen (= Gewinn registrieren).', 'exampleSentence': 'Die Firma hat Gewinn verbucht.', 'grammarRule': 'Funktionsverbgefüge: Gewinn verbuchen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p10-052', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ein kaum zu unterschätzender Vorteil ergibt sich daraus.', 'Ein kaum zu unterschätzenden Vorteil ergibt sich daraus.', 'Ein kaum zu unterschätzend Vorteil ergibt sich daraus.', 'Ein kaum unterschätzender Vorteil ergibt sich daraus.'], 'correctAnswer': 0, 'explanation': 'Gerundiv (zu + Partizip I) als Adjektiv: zu unterschätzend + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).', 'exampleSentence': 'Ein kaum zu unterschätzender Vorteil ergibt sich daraus.', 'grammarRule': 'Gerundiv als Adjektivattribut', 'tags': ['satzbildung', 'partizipialgruppen'] }
];

export default questions;
