import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-002',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sport macht meine Schwester jeden Tag.',
      'Meine Schwester macht jeden Tag Sport.',
      'Meine Schwester jeden Tag Sport macht.',
      'Jeden Tag meine Schwester macht Sport.'
    ],
    'correctAnswer': 1,
    'explanation': 'SVO-Reihenfolge: Subjekt + Verb + Objekt.',
    'exampleSentence': 'Meine Schwester macht jeden Tag Sport.',
    'grammarRule': 'SVO-Reihenfolge',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-005',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Weil er krank ist, er bleibt zu Hause.',
      'Er bleibt weil er krank ist zu Hause.',
      'Er bleibt zu Hause, weil er krank ist.',
      'Er bleibt zu Hause, weil er ist krank.'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz mit weil steht das konjugierte Verb am Ende.',
    'exampleSentence': 'Er bleibt zu Hause, weil er krank ist.',
    'grammarRule': 'Nebensatz: Verb am Ende',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-006',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Morgen fahre mit dem Zug ich nach München.',
      'Morgen ich fahre mit dem Zug nach München.',
      'Ich morgen mit dem Zug nach München fahre.',
      'Morgen fahre ich mit dem Zug nach München.'
    ],
    'correctAnswer': 3,
    'explanation': 'Inversion + TeKaMoLo: Morgen + fahre + ich + mit dem Zug + nach München.',
    'exampleSentence': 'Morgen fahre ich mit dem Zug nach München.',
    'grammarRule': 'Inversion + TeKaMoLo',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-011',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er beschwert über den Lärm sich.',
      'Er beschwert sich über den Lärm.',
      'Er sich beschwert über den Lärm.',
      'Über den Lärm er beschwert sich.'
    ],
    'correctAnswer': 1,
    'explanation': 'Reflexivpronomen steht direkt nach dem konjugierten Verb.',
    'exampleSentence': 'Er beschwert sich über den Lärm.',
    'grammarRule': 'Reflexivverb + Präposition',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-013',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Kaum hatte er das Haus verlassen, da begann es zu regnen.',
      'Kaum er hatte das Haus verlassen, da begann es zu regnen.',
      'Kaum hatte er das Haus verlassen, da es begann zu regnen.',
      'Kaum hatte das Haus er verlassen, da begann es zu regnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobener Stil: kaum + Inversion (hatte er), dann Hauptsatz mit da + Inversion.',
    'exampleSentence': 'Kaum hatte er das Haus verlassen, da begann es zu regnen.',
    'grammarRule': 'Stilistisch gehobene Satzverknüpfung mit kaum...da',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-014',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'So wahr mir Gott helfe, ich spreche die Wahrheit.',
      'So wahr Gott mir helfe, ich spreche die Wahrheit.',
      'So wahr mir Gott helfen, ich spreche die Wahrheit.',
      'So wahr mir Gott hilft, ich spreche die Wahrheit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaische Schwurformel: So wahr mir Gott helfe (Konjunktiv I in fester Wendung).',
    'exampleSentence': 'So wahr mir Gott helfe, ich spreche die Wahrheit.',
    'grammarRule': 'Archaische Schwurformel mit Konjunktiv I',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-015',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nicht wusste er, was ihn noch erwarten sollte.',
      'Nicht er wusste, was ihn noch erwarten sollte.',
      'Er wusste nicht, was ihn noch erwarten sollte.',
      'Was ihn noch erwarten sollte, nicht wusste er.'
    ],
    'correctAnswer': 2,
    'explanation': 'Der grammatisch korrekte Satz stellt die Negation nach dem Verb: Er wusste nicht.',
    'exampleSentence': 'Er wusste nicht, was ihn noch erwarten sollte.',
    'grammarRule': 'Negation im Hauptsatz',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-016',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wäre es nicht gewesen für seine Hilfe, hätten wir verloren.',
      'Wäre es nicht für seine Hilfe gewesen, hätten wir verloren.',
      'Ohne seine Hilfe hätten wir verloren.',
      'Hätten wir verloren ohne seine Hilfe.'
    ],
    'correctAnswer': 2,
    'explanation': 'Gehobener Stil: Ohne + Akkusativ + Konjunktiv II im Hauptsatz (irrealer Konditionalsatz).',
    'exampleSentence': 'Ohne seine Hilfe hätten wir verloren.',
    'grammarRule': 'Irrealer Konditionalsatz mit ohne',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-017',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es möge ihm vergönnt sein, in Frieden zu ruhen.',
      'Es möge ihm vergönnt ist, in Frieden zu ruhen.',
      'Es mag ihm vergönnt sein, in Frieden zu ruhen.',
      'Es möge ihm vergönnt werden, in Frieden zu ruhen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: möge (Konjunktiv I) + vergönnt sein (feststehender Ausdruck).',
    'exampleSentence': 'Es möge ihm vergönnt sein, in Frieden zu ruhen.',
    'grammarRule': 'Konjunktiv I in gehobenen Wunschformeln',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-018',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sei dem auch wie es wolle, wir müssen handeln.',
      'Sei dem wie es wolle, wir müssen handeln.',
      'Wie dem auch sei, wir müssen handeln.',
      'Dem sei wie auch wolle, wir müssen handeln.'
    ],
    'correctAnswer': 2,
    'explanation': 'Die feste Wendung lautet: Wie dem auch sei (= wie auch immer die Lage ist).',
    'exampleSentence': 'Wie dem auch sei, wir müssen handeln.',
    'grammarRule': 'Feste Wendung mit Konjunktiv I',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-019',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Je länger der Konflikt andauert, umso schwieriger wird eine Lösung.',
      'Je länger der Konflikt dauert an, umso schwieriger wird eine Lösung.',
      'Je der Konflikt länger andauert, umso schwieriger wird eine Lösung.',
      'Je länger der Konflikt andauert, umso eine schwierigere Lösung wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Je + Komparativ + Nebensatz, desto/umso + Komparativ + Hauptsatz mit Inversion.',
    'exampleSentence': 'Je länger der Konflikt andauert, umso schwieriger wird eine Lösung.',
    'grammarRule': 'Je...umso/desto-Konstruktion',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-020',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man nehme zwei Eier und verrühre sie sorgfältig.',
      'Man nimmt zwei Eier und verrührt sie sorgfältig.',
      'Man nehme zwei Eier und verrührt sie sorgfältig.',
      'Man nimmt zwei Eier und verrühre sie sorgfältig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der Konjunktiv I als stilistisch gehobene Anweisung: man nehme... und verrühre.',
    'exampleSentence': 'Man nehme zwei Eier und verrühre sie sorgfältig.',
    'grammarRule': 'Konjunktiv I in gehobenen Anweisungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-021',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Hätte er geschwiegen, wäre er ein Philosoph geblieben.',
      'Hätte er geschwiegen, er wäre ein Philosoph geblieben.',
      'Wenn er geschwiegen hätte, ein Philosoph wäre er geblieben.',
      'Geschwiegen hätte er, ein Philosoph wäre geblieben er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz ohne wenn: Hätte er + Partizip II, dann Inversion im Hauptsatz.',
    'exampleSentence': 'Hätte er geschwiegen, wäre er ein Philosoph geblieben.',
    'grammarRule': 'Irrealer Konditionalsatz ohne wenn',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-022',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'So sehr er sich auch bemühte, gelang ihm der Durchbruch nicht.',
      'So sehr er sich auch bemühte, ihm gelang der Durchbruch nicht.',
      'So sehr er sich auch bemühte, der Durchbruch gelang ihm nicht.',
      'So sehr sich er auch bemühte, gelang ihm der Durchbruch nicht.'
    ],
    'correctAnswer': 2,
    'explanation': 'Konzessiver Nebensatz: So sehr + Subjekt + sich + Verb (am Ende), dann Hauptsatz.',
    'exampleSentence': 'So sehr er sich auch bemühte, der Durchbruch gelang ihm nicht.',
    'grammarRule': 'Konzessivsatz mit so sehr...auch',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-023',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es lebe der König!',
      'Es lebt der König!',
      'Es leben der König!',
      'Lebe es der König!'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als Wunschformel: Es lebe (3. Pers. Sg. Konjunktiv I von leben).',
    'exampleSentence': 'Es lebe der König!',
    'grammarRule': 'Konjunktiv I in Wunschformeln',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-024',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nicht nur sprach er fließend Deutsch, sondern auch beherrschte er Französisch.',
      'Nicht nur sprach er fließend Deutsch, sondern er beherrschte auch Französisch.',
      'Nicht nur er sprach fließend Deutsch, sondern beherrschte er auch Französisch.',
      'Nicht nur sprach er fließend Deutsch, sondern beherrschte auch er Französisch.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nicht nur...sondern auch: Im zweiten Teil steht das Subjekt vor dem Verb, auch folgt nach dem Verb.',
    'exampleSentence': 'Nicht nur sprach er fließend Deutsch, sondern er beherrschte auch Französisch.',
    'grammarRule': 'Nicht nur...sondern auch (gehoben)',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-025',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Erst nachdem alle Beweise gesichtet worden waren, konnte das Urteil gesprochen werden.',
      'Erst nachdem alle Beweise gesichtet worden waren, das Urteil konnte gesprochen werden.',
      'Erst nachdem alle Beweise waren gesichtet worden, konnte das Urteil gesprochen werden.',
      'Erst nachdem alle Beweise gesichtet worden waren, konnte gesprochen werden das Urteil.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nachdem + Plusquamperfekt Passiv im Nebensatz (waren am Ende), Inversion im Hauptsatz.',
    'exampleSentence': 'Erst nachdem alle Beweise gesichtet worden waren, konnte das Urteil gesprochen werden.',
    'grammarRule': 'Komplexer Temporalsatz mit Passiv',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-026',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Möge das Schicksal es gut mit uns meinen.',
      'Möge das Schicksal es gut mit uns meint.',
      'Möge das Schicksal gut es mit uns meinen.',
      'Das Schicksal möge es meinen gut mit uns.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I: möge (Position 1) + Subjekt + Objekt + Infinitiv am Ende.',
    'exampleSentence': 'Möge das Schicksal es gut mit uns meinen.',
    'grammarRule': 'Konjunktiv I in gehobenen Wunschsätzen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-027',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Weder konnte er fliehen, noch vermochte er sich zu verteidigen.',
      'Weder er konnte fliehen, noch er vermochte sich zu verteidigen.',
      'Weder konnte fliehen er, noch vermochte sich er zu verteidigen.',
      'Weder er fliehen konnte, noch er sich zu verteidigen vermochte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Weder...noch mit Inversion in beiden Satzteilen: Verb vor Subjekt.',
    'exampleSentence': 'Weder konnte er fliehen, noch vermochte er sich zu verteidigen.',
    'grammarRule': 'Weder...noch mit Inversion (gehoben)',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-028',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sosehr sie sich auch anstrengte, das Ziel blieb unerreichbar.',
      'Sosehr sie auch sich anstrengte, das Ziel blieb unerreichbar.',
      'Sosehr anstrengte sie sich auch, das Ziel blieb unerreichbar.',
      'Sosehr sie sich auch anstrengte, blieb das Ziel unerreichbar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessiver Nebensatz mit sosehr: Subjekt + sich + Verb am Ende. Hauptsatz ohne Inversion.',
    'exampleSentence': 'Sosehr sie sich auch anstrengte, das Ziel blieb unerreichbar.',
    'grammarRule': 'Konzessivsatz mit sosehr',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-029',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gott sei Dank ist alles gut ausgegangen.',
      'Gott ist Dank sei alles gut ausgegangen.',
      'Gott sei Dank alles ist gut ausgegangen.',
      'Sei Gott Dank ist alles gut ausgegangen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Wendung: Gott sei Dank (Konjunktiv I). Danach folgt ein normaler Hauptsatz.',
    'exampleSentence': 'Gott sei Dank ist alles gut ausgegangen.',
    'grammarRule': 'Feste Wendung mit Konjunktiv I',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-030',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Umso verwunderlicher mutet es an, dass niemand protestierte.',
      'Umso verwunderlicher es anmutet, dass niemand protestierte.',
      'Umso verwunderlicher mutet an es, dass niemand protestierte.',
      'Es mutet umso verwunderlicher an, dass niemand protestierte.'
    ],
    'correctAnswer': 3,
    'explanation': 'Die korrekte Konstruktion: Es mutet ... an (trennbares Verb anmuten), dass-Nebensatz.',
    'exampleSentence': 'Es mutet umso verwunderlicher an, dass niemand protestierte.',
    'grammarRule': 'Gehobener Ausdruck mit anmuten',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-031',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Angenommen, er käme rechtzeitig, so könnten wir beginnen.',
      'Angenommen, er kommt rechtzeitig, so könnten wir beginnen.',
      'Angenommen, käme er rechtzeitig, so könnten wir beginnen.',
      'Angenommen, er käme rechtzeitig, so wir könnten beginnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Konditionalstruktur: Angenommen + Konjunktiv II, so + Konjunktiv II mit Inversion.',
    'exampleSentence': 'Angenommen, er käme rechtzeitig, so könnten wir beginnen.',
    'grammarRule': 'Gehobener Konditionalsatz mit angenommen',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-032',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Seien Sie versichert, dass wir alles tun werden.',
      'Seien Sie versichern, dass wir alles tun werden.',
      'Sein Sie versichert, dass wir alles tun werden.',
      'Versichert seien Sie, dass wir alles tun werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Versicherungsformel: Seien Sie versichert (Konjunktiv I von sein + Partizip II).',
    'exampleSentence': 'Seien Sie versichert, dass wir alles tun werden.',
    'grammarRule': 'Konjunktiv I in gehobenen Formeln',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-033',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Selten zuvor hatte ein Ereignis so tiefe Spuren hinterlassen.',
      'Selten zuvor ein Ereignis hatte so tiefe Spuren hinterlassen.',
      'Selten zuvor hatte ein Ereignis hinterlassen so tiefe Spuren.',
      'Zuvor selten hatte ein Ereignis so tiefe Spuren hinterlassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Voranstellung von selten zuvor folgt Inversion: hatte + Subjekt.',
    'exampleSentence': 'Selten zuvor hatte ein Ereignis so tiefe Spuren hinterlassen.',
    'grammarRule': 'Inversion nach vorangestelltem Adverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-034',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nicht zuletzt aufgrund seines Engagements gelang die Reform.',
      'Nicht zuletzt aufgrund seinem Engagement gelang die Reform.',
      'Nicht zuletzt aufgrund seines Engagements die Reform gelang.',
      'Nicht zuletzt aufgrund seines Engagements gelang die Reform an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aufgrund + Genitiv: seines Engagements. Inversion nach vorangestellter Phrase.',
    'exampleSentence': 'Nicht zuletzt aufgrund seines Engagements gelang die Reform.',
    'grammarRule': 'Gehobener Stil mit nicht zuletzt',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-035',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dem sei, wie ihm wolle.',
      'Dem sei, wie es wolle.',
      'Es sei, dem wie es wolle.',
      'Wie dem wolle, sei es.'
    ],
    'correctAnswer': 1,
    'explanation': 'Feste gehobene Wendung: Dem sei, wie es wolle (= wie auch immer es sein mag).',
    'exampleSentence': 'Dem sei, wie es wolle.',
    'grammarRule': 'Archaische Konzessivformel',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-036',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dessen ungeachtet setzte er seinen Weg fort.',
      'Dessen ungeachtet setzte seinen Weg er fort.',
      'Ungeachtet dessen er setzte seinen Weg fort.',
      'Dessen ungeachtet fort setzte er seinen Weg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dessen ungeachtet (= trotzdem) + Inversion: setzte + er + Objekt + Verbpartikel.',
    'exampleSentence': 'Dessen ungeachtet setzte er seinen Weg fort.',
    'grammarRule': 'Gehobene Konzessivkonstruktion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-037',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sei es aus Überzeugung, sei es aus Pflichtgefühl, er handelte entschlossen.',
      'Sei es aus Überzeugung, sei aus Pflichtgefühl es, er handelte entschlossen.',
      'Sei es aus Überzeugung, sei es aus Pflichtgefühl, handelte er entschlossen.',
      'Es sei aus Überzeugung, es sei aus Pflichtgefühl, er handelte entschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Alternativkonstruktion: Sei es...sei es... (Konjunktiv I), Hauptsatz ohne Inversion.',
    'exampleSentence': 'Sei es aus Überzeugung, sei es aus Pflichtgefühl, er handelte entschlossen.',
    'grammarRule': 'Sei es...sei es... (Alternativkonstruktion)',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-038',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mitnichten war er bereit, das Angebot anzunehmen.',
      'Mitnichten er war bereit, das Angebot anzunehmen.',
      'Mitnichten war er das Angebot bereit anzunehmen.',
      'Er war mitnichten bereit das Angebot anzunehmen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaisches Adverb mitnichten (= keineswegs) + Inversion im Hauptsatz.',
    'exampleSentence': 'Mitnichten war er bereit, das Angebot anzunehmen.',
    'grammarRule': 'Archaisches Adverb mit Inversion',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p1-050',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gleichwohl er die Gefahr kannte, wagte er den Aufstieg.',
      'Gleichwohl kannte er die Gefahr, wagte er den Aufstieg.',
      'Gleichwohl wagte er den Aufstieg, obwohl er die Gefahr kannte.',
      'Er kannte gleichwohl die Gefahr, wagte er den Aufstieg.'
    ],
    'correctAnswer': 2,
    'explanation': 'Gleichwohl (= dennoch/trotzdem) wird als Adverb im Hauptsatz verwendet, nicht als Konjunktion.',
    'exampleSentence': 'Gleichwohl wagte er den Aufstieg, obwohl er die Gefahr kannte.',
    'grammarRule': 'Gehobener Konzessivausdruck mit gleichwohl',
    'tags': ['satzbildung', 'literarisch']
  },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-039', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Darüber hinaus bedarf es weiterer Investitionen.', 'Darüber hinaus es bedarf weiterer Investitionen.', 'Darüber hinaus bedarf weiterer Investitionen es.', 'Bedarf es darüber hinaus weiterer Investitionen.'], 'correctAnswer': 0, 'explanation': 'Darüber hinaus + Inversion: bedarf + es + Genitiv.', 'exampleSentence': 'Darüber hinaus bedarf es weiterer Investitionen.', 'grammarRule': 'Gehobene Wendung mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-040', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei hiermit festgestellt, dass der Vertrag gültig ist.', 'Es sei hiermit feststellen, dass der Vertrag gültig ist.', 'Festgestellt sei es hiermit, dass der Vertrag gültig ist.', 'Es sei hiermit festgestellt, dass gültig ist der Vertrag.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I in formeller Feststellung: Es sei hiermit festgestellt + dass-Nebensatz.', 'exampleSentence': 'Es sei hiermit festgestellt, dass der Vertrag gültig ist.', 'grammarRule': 'Konjunktiv I in formellen Feststellungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-041', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Indessen blieb die erhoffte Wende aus.', 'Indessen die erhoffte Wende blieb aus.', 'Indessen blieb aus die erhoffte Wende.', 'Die erhoffte Wende indessen blieb aus.'], 'correctAnswer': 0, 'explanation': 'Indessen (= inzwischen, gehoben) + Inversion: blieb + Subjekt + aus.', 'exampleSentence': 'Indessen blieb die erhoffte Wende aus.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-042', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unter der Voraussetzung, dass alle einverstanden sind, können wir fortfahren.', 'Unter der Voraussetzung, dass alle einverstanden sind, wir können fortfahren.', 'Unter der Voraussetzung, dass einverstanden alle sind, können wir fortfahren.', 'Unter die Voraussetzung, dass alle einverstanden sind, können wir fortfahren.'], 'correctAnswer': 0, 'explanation': 'Unter der Voraussetzung + dass-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.', 'exampleSentence': 'Unter der Voraussetzung, dass alle einverstanden sind, können wir fortfahren.', 'grammarRule': 'Konditionalsatz mit unter der Voraussetzung', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-043', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man vergesse nicht, dass auch kleine Schritte zählen.', 'Man vergisst nicht, dass auch kleine Schritte zählen.', 'Man vergesse nicht, dass auch kleine Schritte zählt.', 'Vergesse man nicht, dass auch kleine Schritte zählen.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I als gehobene Ermahnung: Man vergesse nicht + dass-Nebensatz.', 'exampleSentence': 'Man vergesse nicht, dass auch kleine Schritte zählen.', 'grammarRule': 'Konjunktiv I in gehobenen Ermahnungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-044', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unversehens stand er vor einer unlösbaren Aufgabe.', 'Unversehens er stand vor einer unlösbaren Aufgabe.', 'Unversehens stand vor einer unlösbaren Aufgabe er.', 'Er unversehens stand vor einer unlösbaren Aufgabe.'], 'correctAnswer': 0, 'explanation': 'Unversehens (= plötzlich, gehoben) + Inversion: stand + er.', 'exampleSentence': 'Unversehens stand er vor einer unlösbaren Aufgabe.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-045', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Letzten Endes kommt es auf die Qualität an.', 'Letzten Endes es kommt auf die Qualität an.', 'Letzten Endes kommt auf die Qualität es an.', 'Es kommt letzten Endes an auf die Qualität.'], 'correctAnswer': 0, 'explanation': 'Letzten Endes + Inversion: kommt + es + auf ... an.', 'exampleSentence': 'Letzten Endes kommt es auf die Qualität an.', 'grammarRule': 'Gehobene Wendung mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-046', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es ist mit Nachdruck darauf hinzuweisen, dass Eile geboten ist.', 'Es ist mit Nachdruck darauf hinzuweisen, dass geboten ist Eile.', 'Mit Nachdruck ist es darauf hinzuweisen, dass Eile geboten ist.', 'Es ist mit Nachdruck darauf hinweisen zu, dass Eile geboten ist.'], 'correctAnswer': 0, 'explanation': 'Gehobene Wendung: Es ist darauf hinzuweisen + dass-Nebensatz.', 'exampleSentence': 'Es ist mit Nachdruck darauf hinzuweisen, dass Eile geboten ist.', 'grammarRule': 'Gehobene Wendung: sein + zu + Infinitiv', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-047', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Hernach ergab sich eine unerwartete Gelegenheit.', 'Hernach sich ergab eine unerwartete Gelegenheit.', 'Hernach ergab eine unerwartete Gelegenheit sich.', 'Eine unerwartete Gelegenheit hernach ergab sich.'], 'correctAnswer': 0, 'explanation': 'Hernach (= danach, archaisch) + Inversion: ergab + sich + Subjekt.', 'exampleSentence': 'Hernach ergab sich eine unerwartete Gelegenheit.', 'grammarRule': 'Archaisches Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-048', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Umso dringlicher stellt sich die Frage nach den Ursachen.', 'Umso dringlicher die Frage stellt sich nach den Ursachen.', 'Umso dringlicher stellt die Frage sich nach den Ursachen.', 'Stellt sich umso dringlicher die Frage nach den Ursachen.'], 'correctAnswer': 0, 'explanation': 'Umso + Komparativ + Inversion: stellt + sich + Subjekt.', 'exampleSentence': 'Umso dringlicher stellt sich die Frage nach den Ursachen.', 'grammarRule': 'Gehobener Ausdruck mit umso + Komparativ', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-049', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es vermag niemand zu sagen, wie die Zukunft aussieht.', 'Es vermag niemand sagen zu, wie die Zukunft aussieht.', 'Niemand vermag es sagen zu, wie die Zukunft aussieht.', 'Es vermag niemand zu sagen, wie aussieht die Zukunft.'], 'correctAnswer': 0, 'explanation': 'Gehobenes vermögen (= können) + Infinitiv mit zu.', 'exampleSentence': 'Es vermag niemand zu sagen, wie die Zukunft aussieht.', 'grammarRule': 'Gehobenes Verb vermögen + zu + Infinitiv', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-051', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nichtsdestoweniger bleibt die Forderung bestehen.', 'Nichtsdestoweniger die Forderung bleibt bestehen.', 'Nichtsdestoweniger bleibt bestehen die Forderung.', 'Die Forderung nichtsdestoweniger bleibt bestehen.'], 'correctAnswer': 0, 'explanation': 'Nichtsdestoweniger (= trotzdem, gehoben) + Inversion: bleibt + Subjekt.', 'exampleSentence': 'Nichtsdestoweniger bleibt die Forderung bestehen.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-052', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge bedenken, dass jede Handlung Konsequenzen hat.', 'Man bedenkt möge, dass jede Handlung Konsequenzen hat.', 'Man möge bedenken, dass Konsequenzen hat jede Handlung.', 'Bedenken möge man, dass jede Handlung Konsequenzen hat.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man möge bedenken + dass-Nebensatz.', 'exampleSentence': 'Man möge bedenken, dass jede Handlung Konsequenzen hat.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-053', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Allenthalben herrschte große Verunsicherung.', 'Allenthalben große Verunsicherung herrschte.', 'Allenthalben herrschte große Verunsicherung her.', 'Große Verunsicherung allenthalben herrschte.'], 'correctAnswer': 0, 'explanation': 'Allenthalben (= überall, archaisch) + Inversion: herrschte + Subjekt.', 'exampleSentence': 'Allenthalben herrschte große Verunsicherung.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-054', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zumal die Beweislage erdrückend ist, kann er nicht freigesprochen werden.', 'Zumal die Beweislage erdrückend ist, er kann nicht freigesprochen werden.', 'Zumal erdrückend ist die Beweislage, kann er nicht freigesprochen werden.', 'Zumal die Beweislage ist erdrückend, kann er nicht freigesprochen werden.'], 'correctAnswer': 0, 'explanation': 'Zumal + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Zumal die Beweislage erdrückend ist, kann er nicht freigesprochen werden.', 'grammarRule': 'Kausalsatz mit zumal', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-055', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei betont, dass diese Regelung Ausnahmen zulässt.', 'Es sei betonen, dass diese Regelung Ausnahmen zulässt.', 'Betont sei es, dass diese Regelung Ausnahmen zulässt.', 'Es sei betont, dass Ausnahmen zulässt diese Regelung.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es sei betont + dass-Nebensatz.', 'exampleSentence': 'Es sei betont, dass diese Regelung Ausnahmen zulässt.', 'grammarRule': 'Konjunktiv I Passiv in formeller Sprache', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-056', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ungeachtet aller Widerstände setzte sie ihr Vorhaben durch.', 'Ungeachtet alle Widerstände setzte sie ihr Vorhaben durch.', 'Ungeachtet aller Widerstände sie setzte ihr Vorhaben durch.', 'Ungeachtet aller Widerstände setzte durch sie ihr Vorhaben.'], 'correctAnswer': 0, 'explanation': 'Ungeachtet + Genitiv: aller Widerstände. Inversion im Hauptsatz.', 'exampleSentence': 'Ungeachtet aller Widerstände setzte sie ihr Vorhaben durch.', 'grammarRule': 'Gehobene Konzessivkonstruktion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-057', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Insofern als die Bedingungen erfüllt sind, steht der Genehmigung nichts im Wege.', 'Insofern als die Bedingungen erfüllt sind, der Genehmigung steht nichts im Wege.', 'Insofern als erfüllt sind die Bedingungen, steht der Genehmigung nichts im Wege.', 'Insofern als die Bedingungen sind erfüllt, steht der Genehmigung nichts im Wege.'], 'correctAnswer': 0, 'explanation': 'Insofern als + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Insofern als die Bedingungen erfüllt sind, steht der Genehmigung nichts im Wege.', 'grammarRule': 'Gehobene Konditionalkonstruktion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p1-058', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es werde hiermit bekannt gegeben, dass die Sitzung vertagt wird.', 'Es wird hiermit bekannt gegeben, dass die Sitzung vertagt werde.', 'Hiermit werde es bekannt gegeben, dass die Sitzung vertagt wird.', 'Es werde hiermit bekannt geben, dass die Sitzung vertagt wird.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es werde bekannt gegeben + dass-Nebensatz.', 'exampleSentence': 'Es werde hiermit bekannt gegeben, dass die Sitzung vertagt wird.', 'grammarRule': 'Konjunktiv I Passiv in Bekanntmachungen', 'tags': ['satzbildung', 'archaisch'] }
];

export default questions;
