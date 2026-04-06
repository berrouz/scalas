import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-001',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gestern bin ich ins Kino gegangen.',
      'Gestern ich bin ins Kino gegangen.',
      'Ich gestern ins Kino bin gegangen.',
      'Ins Kino gestern ich bin gegangen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Zeitangabe am Satzanfang folgt Inversion: Zeitangabe + Verb + Subjekt.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-002',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Meine Schwester jeden Tag Sport macht.',
      'Jeden Tag meine Schwester macht Sport.',
      'Sport macht meine Schwester jeden Tag.',
      'Meine Schwester macht jeden Tag Sport.'
    ],
    'correctAnswer': 3,
    'explanation': 'Im Hauptsatz steht das konjugierte Verb an zweiter Position (SVO-Reihenfolge).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-003',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'In die Berge am Wochenende wir fahren.',
      'Am Wochenende fahren wir in die Berge.',
      'Am Wochenende wir fahren in die Berge.',
      'Wir am Wochenende fahren in die Berge.'
    ],
    'correctAnswer': 1,
    'explanation': 'Inversion: Wenn eine Zeitangabe am Anfang steht, kommt das Verb direkt danach.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-004',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dem Patienten der Arzt eine Tablette gibt.',
      'Der Arzt gibt dem Patienten eine Tablette.',
      'Der Arzt gibt eine Tablette dem Patienten.',
      'Der Arzt dem Patienten gibt eine Tablette.'
    ],
    'correctAnswer': 1,
    'explanation': 'Dativ vor Akkusativ: Der Arzt gibt dem Patienten (Dativ) eine Tablette (Akkusativ).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-005',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er bleibt weil er krank ist zu Hause.',
      'Er bleibt zu Hause, weil er ist krank.',
      'Er bleibt zu Hause, weil er krank ist.',
      'Weil er krank ist, er bleibt zu Hause.'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz mit \'weil\' steht das konjugierte Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-006',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich morgen mit dem Zug nach München fahre.',
      'Morgen fahre ich mit dem Zug nach München.',
      'Morgen ich fahre mit dem Zug nach München.',
      'Morgen fahre mit dem Zug ich nach München.'
    ],
    'correctAnswer': 1,
    'explanation': 'Inversion bei vorangestellter Zeitangabe + TeKaMoLo (temporal, kausal, modal, lokal).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-007',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Im Park das Kind Fußball spielt.',
      'Das Kind spielt Fußball im Park.',
      'Das Kind Fußball spielt im Park.',
      'Das Kind spielt im Park Fußball.'
    ],
    'correctAnswer': 3,
    'explanation': 'Lokalangabe vor dem Akkusativobjekt: Das Kind spielt im Park (lokal) Fußball (Akk.).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-008',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mich bereite ich auf die Prüfung vor.',
      'Ich vorbereite mich auf die Prüfung.',
      'Ich bereite mich auf die Prüfung vor.',
      'Ich bereite auf die Prüfung mich vor.'
    ],
    'correctAnswer': 2,
    'explanation': 'Trennbares Verb: \'sich vorbereiten\' wird getrennt; Reflexivpronomen steht nach dem Verb.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-009',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Obwohl es regnet, gehen wir spazieren.',
      'Obwohl es regnet, wir gehen spazieren.',
      'Obwohl regnet es, gehen wir spazieren.',
      'Wir gehen spazieren, obwohl es regnet, wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Konzessivsatz mit \'obwohl\' steht das Verb am Ende; im Hauptsatz folgt Inversion.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-010',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er ging spazieren, nachdem er gegessen hat.',
      'Nachdem er gegessen hatte, ging er spazieren.',
      'Nachdem er aß, ging er spazieren.',
      'Nachdem er gegessen hat, ging er spazieren.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nach \'nachdem\' steht Plusquamperfekt, wenn der Hauptsatz im Präteritum ist.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-011',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich gehe morgen in die Schule.',
      'Ich gehe morgen in der Schule.',
      'Ich gehe morgen in den Schule.',
      'Ich gehe morgen in dem Schule.'
    ],
    'correctAnswer': 0,
    'explanation': '\'in die Schule\' — Akkusativ nach \'in\' bei Richtungsangabe (wohin?).',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-012',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er beschwert sich über den Lärm.',
      'Er sich beschwert über den Lärm.',
      'Über den Lärm er beschwert sich.',
      'Er beschwert über den Lärm sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Reflexivverb: \'sich beschweren über\' — das Reflexivpronomen folgt dem Verb.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-013',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe einen neuen Auto gekauft.',
      'Ich habe ein neues Auto gekauft.',
      'Ich habe ein neuer Auto gekauft.',
      'Ich habe eines neuen Auto gekauft.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Auto\' ist Neutrum (das Auto) — Akkusativ: ein neues Auto.',
    'subcategory': 'Artikel',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-014',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wir fahren mit dem Bus zur Arbeit.',
      'Wir fahren mit den Bus zur Arbeit.',
      'Wir fahren mit der Bus zur Arbeit.',
      'Wir fahren mit des Bus zur Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'mit\' verlangt Dativ: der Bus -> dem Bus.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-015',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat mir das Buch gegeben.',
      'Er hat mich das Buch gegeben.',
      'Er hat mir den Buch gegeben.',
      'Er hat ich das Buch gegeben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'geben\' verlangt Dativ (mir) und Akkusativ (das Buch).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-016',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn ich Zeit habe, gehe ich ins Kino.',
      'Wenn ich Zeit habe, ich gehe ins Kino.',
      'Wenn ich habe Zeit, gehe ich ins Kino.',
      'Wenn ich Zeit habe ich gehe ins Kino.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'wenn\'-Nebensatz steht das Verb am Ende; im Hauptsatz folgt Inversion.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-017',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie geht in den Supermarkt einkaufen.',
      'Sie geht in dem Supermarkt einkaufen.',
      'Sie geht in der Supermarkt einkaufen.',
      'Sie geht ins Supermarkt einkaufen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'in den Supermarkt\' — Akkusativ bei Richtung (wohin?). \'Supermarkt\' ist maskulin.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-018',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich weiß nicht, ob er kommen.',
      'Ich weiß nicht, ob er kommt.',
      'Ich weiß nicht, ob kommt er.',
      'Ich weiß nicht, ob er kommen tut.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im \'ob\'-Nebensatz steht das konjugierte Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-019',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Buch, das ich lese, ist spannend.',
      'Das Buch, das ich lese ist spannend.',
      'Das Buch das ich lese, ist spannend.',
      'Das Buch, das lese ich, ist spannend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Relativsatz steht das Verb am Ende; der Relativsatz wird durch Kommas abgetrennt.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-020',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Kinder spielen gern in dem Garten.',
      'Die Kinder spielen gern in den Garten.',
      'Die Kinder spielen gern in der Garten.',
      'Die Kinder spielen gern in des Gartens.'
    ],
    'correctAnswer': 0,
    'explanation': '\'in dem Garten\' — Dativ bei Ortsangabe (wo?). \'Garten\' ist maskulin.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-021',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat gestern ein langen Brief geschrieben.',
      'Er hat gestern einen langen Brief geschrieben.',
      'Er hat gestern einer langen Brief geschrieben.',
      'Er hat gestern einem langen Brief geschrieben.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Brief\' ist maskulin — Akkusativ: einen langen Brief.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-022',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich interessiere mich für deutsche Kultur.',
      'Ich interessiere mich auf deutsche Kultur.',
      'Ich interessiere sich für deutsche Kultur.',
      'Ich interessiere mich über deutsche Kultur.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich interessieren für\' — feste Präposition \'für\' mit Akkusativ.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-023',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich möchte wissen, wann der Zug abfährt.',
      'Ich möchte wissen, wann fährt der Zug ab.',
      'Ich möchte wissen, wann abfährt der Zug.',
      'Ich möchte wissen, wann der Zug abfahren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im indirekten Fragesatz steht das konjugierte Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-024',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wartet auf den Bus seit einer Stunde.',
      'Er wartet seit einer Stunde auf den Bus.',
      'Er wartet seit eine Stunde auf den Bus.',
      'Er wartet seit einem Stunde auf den Bus.'
    ],
    'correctAnswer': 1,
    'explanation': '\'seit\' verlangt Dativ: einer Stunde. Temporale Angabe steht vor der lokalen.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-025',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Kannst du mir helfen, bitte?',
      'Kannst du mich helfen, bitte?',
      'Kannst du mir zu helfen, bitte?',
      'Kannst du ich helfen, bitte?'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt den Dativ: mir (nicht mich).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-026',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Frau, deren Mann Arzt ist, wohnt nebenan.',
      'Die Frau, dessen Mann Arzt ist, wohnt nebenan.',
      'Die Frau, derer Mann Arzt ist, wohnt nebenan.',
      'Die Frau, die Mann Arzt ist, wohnt nebenan.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen im Genitiv: \'deren\' für feminine Bezugswörter.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-027',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Trotz des schlechten Wetters gehen wir wandern.',
      'Trotz dem schlechten Wetter gehen wir wandern.',
      'Trotz des schlechtes Wetters gehen wir wandern.',
      'Trotz den schlechten Wetter gehen wir wandern.'
    ],
    'correctAnswer': 0,
    'explanation': '\'trotz\' verlangt den Genitiv: des schlechten Wetters.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-028',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn ich reich wäre, kaufte ich ein Haus.',
      'Wenn ich reich wäre, würde ich ein Haus kaufen.',
      'Wenn ich reich wäre, ich würde ein Haus kaufen.',
      'Wenn ich reich bin, würde ich ein Haus kaufen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Konjunktiv II: \'wenn + Konjunktiv II, würde + Infinitiv\'. Inversion im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-029',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich freue mich auf den Urlaub.',
      'Ich freue mich über den Urlaub.',
      'Ich freue mich für den Urlaub.',
      'Ich freue mich an den Urlaub.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich freuen auf\' = Vorfreude auf etwas Zukünftiges (Akkusativ).',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-030',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat mich gefragt, wo wohne ich.',
      'Er hat mich gefragt, wo ich wohne.',
      'Er hat mich gefragt, wo wohne ich?',
      'Er hat mich gefragt, wo ich wohne?'
    ],
    'correctAnswer': 1,
    'explanation': 'Im indirekten Fragesatz steht das Verb am Ende, ohne Fragezeichen.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-031',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie stellte die Vase auf dem Tisch.',
      'Sie stellte die Vase auf den Tisch.',
      'Sie stellte die Vase auf der Tisch.',
      'Sie stellte die Vase auf des Tisches.'
    ],
    'correctAnswer': 1,
    'explanation': '\'stellen\' = Richtung (wohin?) -> Akkusativ: auf den Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-032',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er ist größer wie sein Bruder.',
      'Er ist größer als sein Bruder.',
      'Er ist mehr groß als sein Bruder.',
      'Er ist großer als sein Bruder.'
    ],
    'correctAnswer': 1,
    'explanation': 'Beim Komparativ verwendet man \'als\' (nicht \'wie\'): größer als.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-033',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das ist der Mann, dem ich geholfen habe.',
      'Das ist der Mann, den ich geholfen habe.',
      'Das ist der Mann, der ich geholfen habe.',
      'Das ist der Mann, dessen ich geholfen habe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt Dativ — Relativpronomen im Dativ: dem.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-034',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe keine Lust, ins Kino gehen.',
      'Ich habe keine Lust, ins Kino zu gehen.',
      'Ich habe keine Lust, zu ins Kino gehen.',
      'Ich habe keine Lust, gehen ins Kino zu.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz mit \'zu\': \'zu\' steht direkt vor dem Infinitiv am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-035',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Während des Unterrichts darf man nicht sprechen.',
      'Während dem Unterricht darf man nicht sprechen.',
      'Während den Unterricht darf man nicht sprechen.',
      'Während der Unterricht darf man nicht sprechen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'während\' als Präposition verlangt den Genitiv: während des Unterrichts.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-036',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Vase steht auf dem Tisch.',
      'Die Vase steht auf den Tisch.',
      'Die Vase steht auf der Tisch.',
      'Die Vase steht auf des Tisches.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stehen\' = Ort (wo?) -> Dativ: auf dem Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-037',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich bin sicher, dass er pünktlich kommt.',
      'Ich bin sicher, dass er kommt pünktlich.',
      'Ich bin sicher, dass pünktlich er kommt.',
      'Ich bin sicher, dass er pünktlich kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'dass\'-Nebensatz steht das konjugierte Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-038',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat seiner Freundin einen Ring geschenkt.',
      'Er hat seine Freundin einen Ring geschenkt.',
      'Er hat seiner Freundin einem Ring geschenkt.',
      'Er hat seine Freundin einem Ring geschenkt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'schenken\' verlangt Dativ (seiner Freundin) + Akkusativ (einen Ring).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-039',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er fährt jeden Tag mit die U-Bahn.',
      'Er fährt jeden Tag mit der U-Bahn.',
      'Er fährt jeden Tag mit den U-Bahn.',
      'Er fährt jeden Tag mit dem U-Bahn.'
    ],
    'correctAnswer': 1,
    'explanation': '\'mit\' verlangt Dativ: die U-Bahn -> der U-Bahn.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-040',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nicht nur ist er intelligent, sondern auch fleißig.',
      'Er ist nicht nur intelligent, sondern auch fleißig.',
      'Er ist nicht nur intelligent, aber auch fleißig.',
      'Er ist nur nicht intelligent, sondern auch fleißig.'
    ],
    'correctAnswer': 1,
    'explanation': '\'nicht nur ... sondern auch\' — zweiteilige Konjunktion, Verb bleibt an Position 2.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-041',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Stadt, in die ich wohne, ist schön.',
      'Die Stadt, in der ich wohne, ist schön.',
      'Die Stadt, in dem ich wohne, ist schön.',
      'Die Stadt, in den ich wohne, ist schön.'
    ],
    'correctAnswer': 1,
    'explanation': '\'wohnen in\' verlangt Dativ (wo?); \'Stadt\' ist feminin -> in der.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-042',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'An deiner Stelle würde ich mehr lernen.',
      'An deiner Stelle ich würde mehr lernen.',
      'An deiner Stelle würde ich mehr zu lernen.',
      'An deiner Stelle lernen würde ich mehr.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II mit \'würde\': An deiner Stelle + würde + Subjekt + Infinitiv am Ende.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-043',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat den ganzen Tag nichts gegessen.',
      'Er hat den ganzen Tag nichts geessen.',
      'Er hat den ganzen Tag nicht gegessen.',
      'Er hat den ganzen Tag nichts essen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'nichts gegessen\' — \'nichts\' verneint das Objekt; Partizip II von \'essen\' ist \'gegessen\'.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-044',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wegen dem Regen bleiben wir zu Hause.',
      'Wegen des Regens bleiben wir zu Hause.',
      'Wegen den Regen bleiben wir zu Hause.',
      'Wegen der Regen bleiben wir zu Hause.'
    ],
    'correctAnswer': 1,
    'explanation': '\'wegen\' verlangt den Genitiv: wegen des Regens.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-045',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Lehrerin erklärt den Schülern die Aufgabe.',
      'Die Lehrerin erklärt die Schüler die Aufgabe.',
      'Die Lehrerin erklärt den Schülern der Aufgabe.',
      'Die Lehrerin erklärt die Schülern die Aufgabe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'erklären\' verlangt Dativ (den Schülern) + Akkusativ (die Aufgabe).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-046',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat versprochen, mir zu helfen.',
      'Er hat versprochen, mir helfen.',
      'Er hat versprochen, zu mir helfen.',
      'Er hat versprochen, helfen mir zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz: \'zu\' steht direkt vor dem Infinitiv am Satzende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-047',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Bild hängt an der Wand.',
      'Das Bild hängt an die Wand.',
      'Das Bild hängt an den Wand.',
      'Das Bild hängt an dem Wand.'
    ],
    'correctAnswer': 0,
    'explanation': '\'hängen\' (intransitiv) = Ort (wo?) -> Dativ: an der Wand.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-048',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn ich du wäre, würde ich das nicht tun.',
      'Wenn ich du wäre, ich würde das nicht tun.',
      'Wenn ich du bin, würde ich das nicht tun.',
      'Wenn ich du wäre, das würde ich nicht tun.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'Wenn ich du wäre\' + Hauptsatz mit \'würde\' und Inversion.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-049',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich denke an meinem Freund.',
      'Ich denke auf meinen Freund.',
      'Ich denke an meinen Freund.',
      'Ich denke über meinen Freund.'
    ],
    'correctAnswer': 2,
    'explanation': '\'denken an\' verlangt Akkusativ: an meinen Freund.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p1-050',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Seitdem er hier arbeitet, geht es ihm besser.',
      'Seitdem er hier arbeitet, es geht ihm besser.',
      'Seitdem er arbeitet hier, geht es ihm besser.',
      'Seitdem er hier arbeitet, ihm geht es besser.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Nebensatz mit \'seitdem\' folgt im Hauptsatz Inversion (Verb vor Subjekt).',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  }
];

export default questions;
