import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-005',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich gestern ins Kino bin gegangen.',
      'Ins Kino gestern ich bin gegangen.',
      'Gestern bin ich ins Kino gegangen.',
      'Gestern ich bin ins Kino gegangen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Inversion: Zeitangabe (Position 1) + Verb + Subjekt.',
    'exampleSentence': 'Gestern bin ich ins Kino gegangen.',
    'grammarRule': 'Inversion: Zeitangabe + Verb + Subjekt',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-013',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nicht nur, dass er log, er bereute es nicht einmal.',
      'Nicht nur, dass er log, bereute er es nicht einmal.',
      'Nicht nur er log, dass er es nicht einmal bereute.',
      'Nicht nur dass er log, nicht einmal er es bereute.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Struktur: Nicht nur, dass + Nebensatz, + Hauptsatz ohne Inversion.',
    'exampleSentence': 'Nicht nur, dass er log, er bereute es nicht einmal.',
    'grammarRule': 'Nicht nur, dass... (gehobener Ausdruck)',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-014',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Behüte Gott, dass so etwas geschieht!',
      'Gott behüte, dass so etwas geschieht!',
      'Behüte Gott, dass so etwas geschehe!',
      'Dass so etwas geschieht, Gott behüte!'
    ],
    'correctAnswer': 1,
    'explanation': 'Feste Wendung: Gott behüte (Konjunktiv I als Wunsch), dass + Nebensatz.',
    'exampleSentence': 'Gott behüte, dass so etwas geschieht!',
    'grammarRule': 'Archaische Ausrufsformel',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-015',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nichtsdestotrotz beharrte er auf seiner Meinung.',
      'Nichtsdestotrotz er beharrte auf seiner Meinung.',
      'Nichtsdestotrotz beharrte auf seiner Meinung er.',
      'Er beharrte nichtsdestotrotz seiner Meinung auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nichtsdestotrotz (= trotzdem) + Inversion: beharrte + er.',
    'exampleSentence': 'Nichtsdestotrotz beharrte er auf seiner Meinung.',
    'grammarRule': 'Gehobenes Adverb mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-016',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Vorausgesetzt, dass alle zustimmen, kann das Projekt starten.',
      'Vorausgesetzt, dass alle zustimmen, das Projekt kann starten.',
      'Vorausgesetzt, alle stimmen zu, dass das Projekt starten kann.',
      'Vorausgesetzt alle zustimmen, dass kann das Projekt starten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Kondition: Vorausgesetzt, dass + Nebensatz, + Hauptsatz mit Inversion.',
    'exampleSentence': 'Vorausgesetzt, dass alle zustimmen, kann das Projekt starten.',
    'grammarRule': 'Konditionalsatz mit vorausgesetzt',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-017',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es werde Licht!',
      'Es wird Licht!',
      'Licht es werde!',
      'Werde es Licht!'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als Wunschausdruck (biblisch): Es werde (3. Pers. Sg. Konj. I von werden).',
    'exampleSentence': 'Es werde Licht!',
    'grammarRule': 'Konjunktiv I in biblischen Wendungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-018',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zu keinem Zeitpunkt hat er die Wahrheit gesagt.',
      'Zu keinem Zeitpunkt er hat die Wahrheit gesagt.',
      'Zu keinem Zeitpunkt hat die Wahrheit er gesagt.',
      'Hat er zu keinem Zeitpunkt die Wahrheit gesagt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Voranstellung von zu keinem Zeitpunkt folgt Inversion: hat + er.',
    'exampleSentence': 'Zu keinem Zeitpunkt hat er die Wahrheit gesagt.',
    'grammarRule': 'Inversion nach negierter Zeitangabe',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-019',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gesetzt den Fall, er käme zu spät, müssten wir ohne ihn anfangen.',
      'Gesetzt den Fall, er kommt zu spät, müssten wir ohne ihn anfangen.',
      'Gesetzt den Fall, käme er zu spät, müssten wir ohne ihn anfangen.',
      'Gesetzt den Fall, er käme zu spät, wir müssten ohne ihn anfangen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobener Konditionalsatz: Gesetzt den Fall + Konjunktiv II, + Hauptsatz mit Konjunktiv II.',
    'exampleSentence': 'Gesetzt den Fall, er käme zu spät, müssten wir ohne ihn anfangen.',
    'grammarRule': 'Konditionalsatz mit gesetzt den Fall',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-020',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mögen Sie in Frieden reisen.',
      'Mögen in Frieden Sie reisen.',
      'Mögen Sie reisen in Frieden.',
      'Sie mögen in Frieden reisen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als Wunsch: Mögen + Subjekt + Adverbialbestimmung + Infinitiv.',
    'exampleSentence': 'Mögen Sie in Frieden reisen.',
    'grammarRule': 'Konjunktiv I in gehobenen Wünschen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-021',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unter keinen Umständen darf dieses Geheimnis preisgegeben werden.',
      'Unter keinen Umständen dieses Geheimnis darf preisgegeben werden.',
      'Unter keinen Umständen darf preisgegeben werden dieses Geheimnis.',
      'Dieses Geheimnis unter keinen Umständen darf preisgegeben werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Voranstellung von unter keinen Umständen folgt Inversion: darf + Subjekt.',
    'exampleSentence': 'Unter keinen Umständen darf dieses Geheimnis preisgegeben werden.',
    'grammarRule': 'Inversion nach negierter Adverbialbestimmung',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-022',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Was auch immer geschieht, wir halten zusammen.',
      'Was geschieht auch immer, wir halten zusammen.',
      'Was auch immer geschieht, zusammen halten wir.',
      'Auch immer was geschieht, wir halten zusammen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessive Relativkonstruktion: Was auch immer + Verb am Ende, + Hauptsatz.',
    'exampleSentence': 'Was auch immer geschieht, wir halten zusammen.',
    'grammarRule': 'Konzessiver Relativsatz mit was auch immer',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-023',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es obliegt dem Richter, ein gerechtes Urteil zu fällen.',
      'Es obliegt den Richter, ein gerechtes Urteil zu fällen.',
      'Dem Richter obliegt es, ein gerechtes Urteil fällen.',
      'Es obliegt dem Richter, ein gerechtes Urteil fällen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Verb obliegen + Dativ: dem Richter. Infinitiv mit zu am Ende.',
    'exampleSentence': 'Es obliegt dem Richter, ein gerechtes Urteil zu fällen.',
    'grammarRule': 'Gehobenes Verb obliegen + Dativ',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-024',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nur zu gut wusste er, welche Konsequenzen ihn erwarteten.',
      'Nur zu gut er wusste, welche Konsequenzen ihn erwarteten.',
      'Nur zu gut wusste er, welche Konsequenzen erwarteten ihn.',
      'Er wusste nur zu gut, welche Konsequenzen erwarteten ihn.'
    ],
    'correctAnswer': 0,
    'explanation': 'Voranstellung von nur zu gut + Inversion: wusste + er + Nebensatz.',
    'exampleSentence': 'Nur zu gut wusste er, welche Konsequenzen ihn erwarteten.',
    'grammarRule': 'Inversion nach vorangestellter Adverbialphrase',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-025',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wie sehr er sich auch mühte, der Erfolg blieb aus.',
      'Wie sehr er sich auch mühte, blieb der Erfolg aus.',
      'Wie sehr mühte er sich auch, der Erfolg blieb aus.',
      'Wie sich er sehr auch mühte, der Erfolg blieb aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessiver Nebensatz: Wie sehr + Subjekt + sich + Verb am Ende, dann Hauptsatz.',
    'exampleSentence': 'Wie sehr er sich auch mühte, der Erfolg blieb aus.',
    'grammarRule': 'Konzessivsatz mit wie sehr...auch',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-026',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wohlan, so lasst uns beginnen!',
      'Wohlan, so uns lasst beginnen!',
      'Wohlan, lasst so uns beginnen!',
      'So wohlan, lasst uns beginnen!'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaischer Aufruf: Wohlan + so + Imperativ (lasst uns + Infinitiv).',
    'exampleSentence': 'Wohlan, so lasst uns beginnen!',
    'grammarRule': 'Archaische Aufforderungsformel',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-027',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Allein die Tatsache, dass er anwesend war, genügte.',
      'Allein die Tatsache, dass er anwesend war, genügten.',
      'Allein, dass er anwesend war die Tatsache, genügte.',
      'Allein die Tatsache, dass war er anwesend, genügte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Allein (= schon/bereits) + Nominativ + Relativsatz + Verb (Singular: genügte).',
    'exampleSentence': 'Allein die Tatsache, dass er anwesend war, genügte.',
    'grammarRule': 'Gehobener Ausdruck mit allein',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-028',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenngleich die Kritik berechtigt war, änderte sich nichts.',
      'Wenngleich die Kritik berechtigt war, sich änderte nichts.',
      'Wenngleich war die Kritik berechtigt, änderte sich nichts.',
      'Wenngleich die Kritik berechtigt war, nichts änderte sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wenngleich (= obwohl) + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'Wenngleich die Kritik berechtigt war, änderte sich nichts.',
    'grammarRule': 'Konzessivsatz mit wenngleich',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-029',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Fern sei es von mir, ihn zu kritisieren.',
      'Fern es sei von mir, ihn zu kritisieren.',
      'Von mir sei es fern, ihn zu kritisieren.',
      'Es sei fern von mir, kritisieren ihn zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Wendung: Fern sei es von mir (Konjunktiv I) + Infinitiv mit zu.',
    'exampleSentence': 'Fern sei es von mir, ihn zu kritisieren.',
    'grammarRule': 'Archaische Bescheidenheitsformel',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-030',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Noch nie war er so entschlossen gewesen.',
      'Noch nie er war so entschlossen gewesen.',
      'Noch nie war so entschlossen er gewesen.',
      'War er noch nie so entschlossen gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach noch nie folgt Inversion: war + er + Partizip II.',
    'exampleSentence': 'Noch nie war er so entschlossen gewesen.',
    'grammarRule': 'Inversion nach negiertem Temporaladverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-031',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Insofern die Bedingungen erfüllt sind, steht einer Genehmigung nichts im Wege.',
      'Insofern die Bedingungen sind erfüllt, steht einer Genehmigung nichts im Wege.',
      'Insofern die Bedingungen erfüllt sind, einer Genehmigung nichts im Wege steht.',
      'Insofern erfüllt sind die Bedingungen, steht einer Genehmigung nichts im Wege.'
    ],
    'correctAnswer': 0,
    'explanation': 'Insofern (= sofern) + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'Insofern die Bedingungen erfüllt sind, steht einer Genehmigung nichts im Wege.',
    'grammarRule': 'Konditionalsatz mit insofern',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-032',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Beileibe nicht darf man ihn unterschätzen.',
      'Beileibe nicht man darf ihn unterschätzen.',
      'Beileibe darf man nicht ihn unterschätzen.',
      'Man darf beileibe ihn nicht unterschätzen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaisches Adverb beileibe nicht (= keinesfalls) + Inversion: darf + man.',
    'exampleSentence': 'Beileibe nicht darf man ihn unterschätzen.',
    'grammarRule': 'Archaisches Adverb mit Inversion',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-033',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Erst recht nicht ließ er sich von den Widrigkeiten entmutigen.',
      'Erst recht nicht er ließ sich von den Widrigkeiten entmutigen.',
      'Erst recht nicht ließ sich er von den Widrigkeiten entmutigen.',
      'Er ließ erst recht nicht von den Widrigkeiten sich entmutigen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach vorangestelltem erst recht nicht folgt Inversion: ließ + er + sich.',
    'exampleSentence': 'Erst recht nicht ließ er sich von den Widrigkeiten entmutigen.',
    'grammarRule': 'Inversion nach verstärkter Negation',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-034',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Inwieweit diese Theorie haltbar ist, bleibt abzuwarten.',
      'Inwieweit ist diese Theorie haltbar, bleibt abzuwarten.',
      'Inwieweit diese Theorie haltbar ist, abzuwarten bleibt.',
      'Inwieweit haltbar diese Theorie ist, bleibt abzuwarten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inwieweit + indirekter Fragesatz (Verb am Ende), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'Inwieweit diese Theorie haltbar ist, bleibt abzuwarten.',
    'grammarRule': 'Indirekter Fragesatz mit inwieweit',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-035',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es bleibt zu hoffen, dass sich die Lage bessert.',
      'Es zu hoffen bleibt, dass sich die Lage bessert.',
      'Es bleibt hoffen zu, dass sich die Lage bessert.',
      'Zu hoffen bleibt es, dass die Lage sich bessert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es bleibt zu hoffen (Infinitiv mit zu nach bleiben).',
    'exampleSentence': 'Es bleibt zu hoffen, dass sich die Lage bessert.',
    'grammarRule': 'Gehobene Wendung mit bleiben + zu + Infinitiv',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-036',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Kaum war der Vorhang gefallen, da brach tosender Applaus aus.',
      'Kaum der Vorhang war gefallen, da brach tosender Applaus aus.',
      'Kaum war der Vorhang gefallen, da tosender Applaus ausbrach.',
      'Kaum war gefallen der Vorhang, da brach tosender Applaus aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kaum + Inversion (war + Subjekt), da + Inversion (brach + Subjekt + aus).',
    'exampleSentence': 'Kaum war der Vorhang gefallen, da brach tosender Applaus aus.',
    'grammarRule': 'Stilistisch gehobene Satzverknüpfung mit kaum...da',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-037',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Je gründlicher die Vorbereitung, desto reibungsloser der Ablauf.',
      'Je die Vorbereitung gründlicher, desto reibungsloser der Ablauf.',
      'Je gründlicher die Vorbereitung, der Ablauf desto reibungsloser.',
      'Desto reibungsloser der Ablauf, je gründlicher die Vorbereitung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Verkürzte Je...desto-Konstruktion ohne Verben (gehobener Stil).',
    'exampleSentence': 'Je gründlicher die Vorbereitung, desto reibungsloser der Ablauf.',
    'grammarRule': 'Verkürzte Je...desto-Konstruktion',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p2-050',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wohl dem, der einen treuen Freund hat.',
      'Wohl dem, der hat einen treuen Freund.',
      'Dem wohl, der einen treuen Freund hat.',
      'Wohl dem, einen treuen Freund der hat.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene/archaische Wendung: Wohl dem, der... (= Glücklich ist, wer...) + Relativsatz.',
    'exampleSentence': 'Wohl dem, der einen treuen Freund hat.',
    'grammarRule': 'Archaische Glückwunschformel',
    'tags': ['satzbildung', 'archaisch']
  },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-038', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zudem gilt es, die Rahmenbedingungen zu klären.', 'Zudem es gilt, die Rahmenbedingungen zu klären.', 'Zudem gilt es, die Rahmenbedingungen klären zu.', 'Es gilt zudem, zu klären die Rahmenbedingungen.'], 'correctAnswer': 0, 'explanation': 'Zudem + Inversion: gilt + es + Infinitiv mit zu.', 'exampleSentence': 'Zudem gilt es, die Rahmenbedingungen zu klären.', 'grammarRule': 'Gehobener Ausdruck mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-039', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man bedenke, dass der Weg das Ziel ist.', 'Man bedenkt, dass der Weg das Ziel ist.', 'Man bedenke, dass ist der Weg das Ziel.', 'Bedenke man, dass der Weg das Ziel ist.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I als gehobene Aufforderung: Man bedenke + dass-Nebensatz.', 'exampleSentence': 'Man bedenke, dass der Weg das Ziel ist.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-040', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Eilends verließ er das Gebäude.', 'Eilends er verließ das Gebäude.', 'Eilends verließ das Gebäude er.', 'Er eilends verließ das Gebäude.'], 'correctAnswer': 0, 'explanation': 'Eilends (= schnell, gehoben) + Inversion: verließ + er.', 'exampleSentence': 'Eilends verließ er das Gebäude.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-041', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es bleibt festzuhalten, dass die Reform Wirkung gezeigt hat.', 'Es bleibt festzuhalten, dass gezeigt hat die Reform Wirkung.', 'Festzuhalten bleibt es, dass die Reform Wirkung gezeigt hat.', 'Es bleibt festhalten zu, dass die Reform Wirkung gezeigt hat.'], 'correctAnswer': 0, 'explanation': 'Gehobene Wendung: Es bleibt festzuhalten + dass-Nebensatz.', 'exampleSentence': 'Es bleibt festzuhalten, dass die Reform Wirkung gezeigt hat.', 'grammarRule': 'Gehobene Wendung: bleiben + zu + Infinitiv', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-042', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei klargestellt, dass kein Fehlverhalten vorliegt.', 'Es sei klarstellen, dass kein Fehlverhalten vorliegt.', 'Klargestellt sei es, dass kein Fehlverhalten vorliegt.', 'Es sei klargestellt, dass vorliegt kein Fehlverhalten.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Es sei klargestellt + dass-Nebensatz.', 'exampleSentence': 'Es sei klargestellt, dass kein Fehlverhalten vorliegt.', 'grammarRule': 'Konjunktiv I in formellen Klarstellungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-043', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Gleichermaßen betroffen waren die angrenzenden Gebiete.', 'Gleichermaßen betroffen die angrenzenden Gebiete waren.', 'Gleichermaßen waren betroffen die angrenzenden Gebiete.', 'Die angrenzenden Gebiete gleichermaßen betroffen waren.'], 'correctAnswer': 0, 'explanation': 'Gleichermaßen betroffen + Inversion: waren + Subjekt.', 'exampleSentence': 'Gleichermaßen betroffen waren die angrenzenden Gebiete.', 'grammarRule': 'Vorangestelltes Adjektiv mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-044', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unbeschadet dessen bleibt die Kritik bestehen.', 'Unbeschadet dessen die Kritik bleibt bestehen.', 'Unbeschadet dessen bleibt bestehen die Kritik.', 'Dessen unbeschadet die Kritik bestehen bleibt.'], 'correctAnswer': 0, 'explanation': 'Unbeschadet dessen (= trotzdem) + Inversion: bleibt + Subjekt.', 'exampleSentence': 'Unbeschadet dessen bleibt die Kritik bestehen.', 'grammarRule': 'Gehobene Konzessivkonstruktion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-045', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es bedarf einer eingehenden Prüfung.', 'Es bedarf eine eingehende Prüfung.', 'Einer eingehenden Prüfung es bedarf.', 'Es bedarf einer eingehender Prüfung.'], 'correctAnswer': 0, 'explanation': 'Gehobenes bedürfen + Genitiv: einer eingehenden Prüfung.', 'exampleSentence': 'Es bedarf einer eingehenden Prüfung.', 'grammarRule': 'Gehobenes Verb bedürfen + Genitiv', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-046', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Gleichwohl vermochte er nicht, seine Fassung zu bewahren.', 'Gleichwohl er vermochte nicht, seine Fassung zu bewahren.', 'Gleichwohl vermochte nicht er, seine Fassung zu bewahren.', 'Vermochte er gleichwohl nicht, seine Fassung zu bewahren.'], 'correctAnswer': 0, 'explanation': 'Gleichwohl (= trotzdem) + Inversion: vermochte + er.', 'exampleSentence': 'Gleichwohl vermochte er nicht, seine Fassung zu bewahren.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-047', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unstreitig hat die Digitalisierung die Arbeitswelt verändert.', 'Unstreitig die Digitalisierung hat die Arbeitswelt verändert.', 'Unstreitig hat die Arbeitswelt die Digitalisierung verändert.', 'Hat unstreitig die Digitalisierung die Arbeitswelt verändert.'], 'correctAnswer': 0, 'explanation': 'Unstreitig (= unbestreitbar) + Inversion: hat + Subjekt.', 'exampleSentence': 'Unstreitig hat die Digitalisierung die Arbeitswelt verändert.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-048', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es möge gestattet sein, einen Einwand zu erheben.', 'Es möge gestattet sein, einen Einwand erheben zu.', 'Gestattet möge es sein, einen Einwand zu erheben.', 'Es möge gestattet ist, einen Einwand zu erheben.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: möge + gestattet sein + Infinitiv mit zu.', 'exampleSentence': 'Es möge gestattet sein, einen Einwand zu erheben.', 'grammarRule': 'Konjunktiv I in höflichen Bitten', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-049', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fernerhin wurde jede Abweichung dokumentiert.', 'Fernerhin jede Abweichung wurde dokumentiert.', 'Fernerhin wurde dokumentiert jede Abweichung.', 'Jede Abweichung fernerhin wurde dokumentiert.'], 'correctAnswer': 0, 'explanation': 'Fernerhin (= außerdem/weiterhin, gehoben) + Inversion: wurde + Subjekt.', 'exampleSentence': 'Fernerhin wurde jede Abweichung dokumentiert.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-050', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nichtsdestoweniger bleibt die Frage offen.', 'Nichtsdestoweniger die Frage bleibt offen.', 'Nichtsdestoweniger bleibt offen die Frage.', 'Die Frage nichtsdestoweniger bleibt offen.'], 'correctAnswer': 0, 'explanation': 'Nichtsdestoweniger (= trotzdem) + Inversion: bleibt + Subjekt.', 'exampleSentence': 'Nichtsdestoweniger bleibt die Frage offen.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-051', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei nachdrücklich darauf verwiesen, dass Pünktlichkeit erwartet wird.', 'Es sei nachdrücklich darauf verweisen, dass Pünktlichkeit erwartet wird.', 'Nachdrücklich sei es darauf verwiesen, dass Pünktlichkeit erwartet wird.', 'Es sei nachdrücklich darauf verwiesen, dass erwartet wird Pünktlichkeit.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es sei verwiesen + dass-Nebensatz.', 'exampleSentence': 'Es sei nachdrücklich darauf verwiesen, dass Pünktlichkeit erwartet wird.', 'grammarRule': 'Konjunktiv I Passiv in formeller Sprache', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-052', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Allenthalben war Aufbruchsstimmung zu spüren.', 'Allenthalben Aufbruchsstimmung war zu spüren.', 'Allenthalben war zu spüren Aufbruchsstimmung.', 'Aufbruchsstimmung allenthalben war zu spüren.'], 'correctAnswer': 0, 'explanation': 'Allenthalben (= überall, archaisch) + Inversion: war + Subjekt.', 'exampleSentence': 'Allenthalben war Aufbruchsstimmung zu spüren.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-053', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zumal die Zeit drängt, sollten wir sofort handeln.', 'Zumal die Zeit drängt, wir sollten sofort handeln.', 'Zumal drängt die Zeit, sollten wir sofort handeln.', 'Zumal die Zeit drängt, sollten sofort handeln wir.'], 'correctAnswer': 0, 'explanation': 'Zumal + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Zumal die Zeit drängt, sollten wir sofort handeln.', 'grammarRule': 'Kausalsatz mit zumal', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-054', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge verzeihen, wenn ich widerspreche.', 'Man verzeiht möge, wenn ich widerspreche.', 'Man möge verzeihen, wenn widerspreche ich.', 'Möge man verzeihen, wenn ich widerspreche.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man möge verzeihen + Nebensatz.', 'exampleSentence': 'Man möge verzeihen, wenn ich widerspreche.', 'grammarRule': 'Konjunktiv I in gehobenen Bitten', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-055', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ungeachtet der Warnungen wagte er den Versuch.', 'Ungeachtet die Warnungen wagte er den Versuch.', 'Ungeachtet der Warnungen er wagte den Versuch.', 'Ungeachtet der Warnungen wagte den Versuch er.'], 'correctAnswer': 0, 'explanation': 'Ungeachtet + Genitiv: der Warnungen. Inversion im Hauptsatz.', 'exampleSentence': 'Ungeachtet der Warnungen wagte er den Versuch.', 'grammarRule': 'Gehobene Konzessivkonstruktion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-056', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Insofern als die Mittel begrenzt sind, müssen Prioritäten gesetzt werden.', 'Insofern als die Mittel begrenzt sind, Prioritäten müssen gesetzt werden.', 'Insofern als begrenzt sind die Mittel, müssen Prioritäten gesetzt werden.', 'Insofern als die Mittel sind begrenzt, müssen Prioritäten gesetzt werden.'], 'correctAnswer': 0, 'explanation': 'Insofern als + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Insofern als die Mittel begrenzt sind, müssen Prioritäten gesetzt werden.', 'grammarRule': 'Gehobene Konditionalkonstruktion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-057', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es werde hiermit verfügt, dass die Maßnahme sofort greift.', 'Es wird hiermit verfügt, dass die Maßnahme sofort greife.', 'Verfügt werde es hiermit, dass die Maßnahme sofort greift.', 'Es werde hiermit verfügen, dass die Maßnahme sofort greift.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es werde verfügt + dass-Nebensatz.', 'exampleSentence': 'Es werde hiermit verfügt, dass die Maßnahme sofort greift.', 'grammarRule': 'Konjunktiv I Passiv in Verfügungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-058', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fürderhin ist mit Verzögerungen zu rechnen.', 'Fürderhin mit Verzögerungen ist zu rechnen.', 'Fürderhin ist zu rechnen mit Verzögerungen.', 'Mit Verzögerungen fürderhin ist zu rechnen.'], 'correctAnswer': 0, 'explanation': 'Fürderhin (= künftig, archaisch) + Inversion: ist + mit + zu + Infinitiv.', 'exampleSentence': 'Fürderhin ist mit Verzögerungen zu rechnen.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-059', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unbestritten ist, dass der Klimawandel eine globale Herausforderung darstellt.', 'Unbestritten, dass der Klimawandel eine globale Herausforderung darstellt, ist.', 'Ist unbestritten, dass der Klimawandel eine globale Herausforderung darstellt.', 'Unbestritten ist, dass eine globale Herausforderung darstellt der Klimawandel.'], 'correctAnswer': 0, 'explanation': 'Vorangestelltes Adjektiv: Unbestritten + ist + dass-Nebensatz.', 'exampleSentence': 'Unbestritten ist, dass der Klimawandel eine globale Herausforderung darstellt.', 'grammarRule': 'Vorangestelltes Adjektiv + ist + dass', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p2-060', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Allenthalben zeigte sich Aufbruchsstimmung.', 'Allenthalben Aufbruchsstimmung zeigte sich.', 'Allenthalben zeigte Aufbruchsstimmung sich.', 'Aufbruchsstimmung allenthalben zeigte sich.'], 'correctAnswer': 0, 'explanation': 'Allenthalben (= überall) + Inversion: zeigte + sich + Subjekt.', 'exampleSentence': 'Allenthalben zeigte sich Aufbruchsstimmung.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] }
];

export default questions;
