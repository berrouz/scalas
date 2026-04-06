import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-001',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich bin es gewohnt, früh aufzustehen.',
      'Ich bin es gewohnt, früh aufstehen.',
      'Ich bin es gewohnt, früh zu aufstehen.',
      'Ich bin es gewohnt, aufzustehen früh.'
    ],
    'correctAnswer': 0,
    'explanation': '\'zu\' steht zwischen Präfix und Verb bei trennbaren Verben: aufzustehen.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-002',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat seiner Mutter beim Kochen geholfen.',
      'Er hat seine Mutter beim Kochen geholfen.',
      'Er hat seiner Mutter bei dem Kochen geholfen.',
      'Er hat seinen Mutter beim Kochen geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt Dativ (seiner Mutter); \'beim\' = bei dem.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-003',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er schiebt den Schrank an die Wand.',
      'Er schiebt den Schrank an der Wand.',
      'Er schiebt den Schrank an dem Wand.',
      'Er schiebt der Schrank an die Wand.'
    ],
    'correctAnswer': 0,
    'explanation': '\'schieben an\' = Richtung (wohin?) -> Akkusativ: an die Wand.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-004',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er träumt von einer Reise nach Afrika.',
      'Er träumt über eine Reise nach Afrika.',
      'Er träumt für eine Reise nach Afrika.',
      'Er träumt an einer Reise nach Afrika.'
    ],
    'correctAnswer': 0,
    'explanation': '\'träumen von\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-005',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Obgleich er arm war, war er glücklich.',
      'Obgleich er arm war, er war glücklich.',
      'Obgleich er war arm, war er glücklich.',
      'Obgleich arm er war, war er glücklich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'obgleich\'-Nebensatz steht das Verb am Ende; Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-006',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Arzt, zu dem ich gehe, ist sehr erfahren.',
      'Der Arzt, zu den ich gehe, ist sehr erfahren.',
      'Der Arzt, zu der ich gehe, ist sehr erfahren.',
      'Der Arzt, zu die ich gehe, ist sehr erfahren.'
    ],
    'correctAnswer': 0,
    'explanation': '\'zu\' verlangt Dativ; \'Arzt\' ist maskulin -> zu dem.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-007',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gestern Abend hat er lange ferngesehen.',
      'Gestern Abend er hat lange ferngesehen.',
      'Gestern Abend hat er lange fernsehen.',
      'Gestern Abend hat lange er ferngesehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion nach Zeitangabe; Partizip II von \'fernsehen\': ferngesehen.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-008',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn es nach mir ginge, würden wir sofort losfahren.',
      'Wenn es nach mir ginge, wir würden sofort losfahren.',
      'Wenn es nach mir geht, würden wir sofort losfahren.',
      'Wenn es nach mir ginge, würden wir sofort zu losfahren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'ginge\' im Nebensatz, \'würden + Infinitiv\' im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-009',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Tasse steht neben dem Teller.',
      'Die Tasse steht neben den Teller.',
      'Die Tasse steht neben der Teller.',
      'Die Tasse steht neben des Tellers.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stehen neben\' = Ort (wo?) -> Dativ: neben dem Teller.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-010',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie bedankt sich bei dem Lehrer für die Hilfe.',
      'Sie bedankt sich bei den Lehrer für die Hilfe.',
      'Sie bedankt sich an dem Lehrer für die Hilfe.',
      'Sie bedankt sich bei dem Lehrer über die Hilfe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich bedanken bei\' + Dativ, \'für\' + Akkusativ.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-011',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich glaube, dass er die Wahrheit sagt.',
      'Ich glaube, dass er sagt die Wahrheit.',
      'Ich glaube, dass die Wahrheit er sagt.',
      'Ich glaube, dass er die Wahrheit sagen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'dass\'-Nebensatz steht das konjugierte Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-012',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat dem Kellner ein großes Trinkgeld gegeben.',
      'Er hat den Kellner ein großes Trinkgeld gegeben.',
      'Er hat dem Kellner einen großen Trinkgeld gegeben.',
      'Er hat der Kellner ein großes Trinkgeld gegeben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'geben\' verlangt Dativ (dem Kellner) + Akkusativ (ein Trinkgeld, Neutrum).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-013',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Park, durch den wir spazieren, ist wunderschön.',
      'Der Park, durch dem wir spazieren, ist wunderschön.',
      'Der Park, durch der wir spazieren, ist wunderschön.',
      'Der Park, durch die wir spazieren, ist wunderschön.'
    ],
    'correctAnswer': 0,
    'explanation': '\'durch\' verlangt Akkusativ; \'Park\' ist maskulin -> durch den.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-014',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wirft den Ball über den Zaun.',
      'Er wirft den Ball über dem Zaun.',
      'Er wirft den Ball über der Zaun.',
      'Er wirft der Ball über den Zaun.'
    ],
    'correctAnswer': 0,
    'explanation': '\'werfen über\' = Richtung (wohin?) -> Akkusativ: über den Zaun.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-015',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat angefangen, Spanisch zu lernen.',
      'Er hat angefangen, Spanisch lernen.',
      'Er hat angefangen, zu Spanisch lernen.',
      'Er hat angefangen, Spanisch lernen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '\'anfangen\' + Infinitivsatz mit \'zu\' vor dem Infinitiv.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-016',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er konzentriert sich auf seine Arbeit.',
      'Er konzentriert sich über seine Arbeit.',
      'Er konzentriert sich an seine Arbeit.',
      'Er konzentriert sich für seine Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich konzentrieren auf\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-017',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn er doch nur hier wäre!',
      'Wenn er doch nur hier ist!',
      'Wenn er doch nur wäre hier!',
      'Wenn doch nur er hier wäre!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunsch mit \'wenn ... doch nur\' + Konjunktiv II; Verb am Ende.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-018',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie verspricht ihrem Kind, ihm ein Geschenk zu kaufen.',
      'Sie verspricht ihr Kind, ihm ein Geschenk zu kaufen.',
      'Sie verspricht ihrem Kind, ihm ein Geschenk kaufen.',
      'Sie verspricht ihrem Kind, zu ihm ein Geschenk kaufen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'versprechen\' + Dativ (ihrem Kind); Infinitivsatz mit \'zu\' am Ende.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-019',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er fährt morgen gern mit dem Auto zur Arbeit.',
      'Er fährt morgen gern mit das Auto zur Arbeit.',
      'Morgen fährt er gern mit dem Auto zur Arbeit.',
      'Morgen er fährt gern mit dem Auto zur Arbeit.'
    ],
    'correctAnswer': 2,
    'explanation': 'Inversion bei Zeitangabe am Anfang; \'mit\' + Dativ (dem Auto).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-020',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Schuhe stehen unter der Bank.',
      'Die Schuhe stehen unter die Bank.',
      'Die Schuhe stehen unter den Bank.',
      'Die Schuhe stehen unter des Bank.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stehen unter\' = Ort (wo?) -> Dativ: unter der Bank. \'Bank\' ist feminin.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-021',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Obwohl sie krank war, ging sie zur Arbeit.',
      'Obwohl sie krank war, sie ging zur Arbeit.',
      'Obwohl war sie krank, ging sie zur Arbeit.',
      'Obwohl sie krank war ging sie zur Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'obwohl\'-Nebensatz: Verb am Ende; Komma + Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-022',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er verzichtet auf das Dessert.',
      'Er verzichtet über das Dessert.',
      'Er verzichtet für das Dessert.',
      'Er verzichtet von dem Dessert.'
    ],
    'correctAnswer': 0,
    'explanation': '\'verzichten auf\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-023',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Bibliothek, in die wir gehen, hat viele Bücher.',
      'Die Bibliothek, in der wir gehen, hat viele Bücher.',
      'Die Bibliothek, in dem wir gehen, hat viele Bücher.',
      'Die Bibliothek, in den wir gehen, hat viele Bücher.'
    ],
    'correctAnswer': 0,
    'explanation': '\'gehen in\' = Richtung (wohin?) -> Akkusativ; \'Bibliothek\' feminin -> in die.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-024',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Hätte sie besser aufgepasst, wäre der Unfall nicht passiert.',
      'Hätte sie besser aufgepasst, der Unfall wäre nicht passiert.',
      'Hat sie besser aufgepasst, wäre der Unfall nicht passiert.',
      'Hätte sie besser aufgepasst, wäre der Unfall nicht passieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit ohne \'wenn\': Verb am Anfang; Inversion im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-025',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie wirft die Zeitung in den Papierkorb.',
      'Sie wirft die Zeitung in dem Papierkorb.',
      'Sie wirft die Zeitung in der Papierkorb.',
      'Sie wirft der Zeitung in den Papierkorb.'
    ],
    'correctAnswer': 0,
    'explanation': '\'werfen in\' = Richtung (wohin?) -> Akkusativ: in den Papierkorb.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-026',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat dem Gast ein Zimmer reserviert.',
      'Er hat den Gast ein Zimmer reserviert.',
      'Er hat dem Gast einen Zimmer reserviert.',
      'Er hat dem Gast ein Zimmer reservieren.'
    ],
    'correctAnswer': 0,
    'explanation': '\'reservieren\' mit Dativ (dem Gast) + Akkusativ (ein Zimmer, Neutrum).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-027',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat es nicht geschafft, rechtzeitig anzukommen.',
      'Er hat es nicht geschafft, rechtzeitig ankommen.',
      'Er hat es nicht geschafft, zu rechtzeitig ankommen.',
      'Er hat es nicht geschafft, rechtzeitig an zu kommen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'zu\' zwischen Präfix und Verb: anzukommen.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-028',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er erkundigt sich nach dem Weg.',
      'Er erkundigt sich über den Weg.',
      'Er erkundigt sich für den Weg.',
      'Er erkundigt sich an dem Weg.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich erkundigen nach\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-029',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er macht nie das Licht aus, wenn er das Zimmer verlässt.',
      'Er macht nie das Licht aus, wenn er verlässt das Zimmer.',
      'Er nie macht das Licht aus, wenn er das Zimmer verlässt.',
      'Er macht nie das Licht aus, wenn das Zimmer er verlässt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'wenn\'-Nebensatz steht das Verb am Ende. Hauptsatz: Verb an Pos. 2.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-030',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Brücke, über die wir gehen, ist sehr alt.',
      'Die Brücke, über der wir gehen, ist sehr alt.',
      'Die Brücke, über den wir gehen, ist sehr alt.',
      'Die Brücke, über dem wir gehen, ist sehr alt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'gehen über\' = Richtung -> Akkusativ; \'Brücke\' feminin -> über die.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-031',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Heute Morgen hat er verschlafen.',
      'Heute Morgen er hat verschlafen.',
      'Heute Morgen hat er verschlafen sich.',
      'Heute Morgen er verschlafen hat.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion nach Zeitangabe; Partizip II am Ende: verschlafen.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-032',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er legt die Zeitung auf das Regal.',
      'Er legt die Zeitung auf dem Regal.',
      'Er legt die Zeitung auf der Regal.',
      'Er legt der Zeitung auf das Regal.'
    ],
    'correctAnswer': 0,
    'explanation': '\'legen auf\' = Richtung (wohin?) -> Akkusativ: auf das Regal.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-033',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er leidet unter starken Kopfschmerzen.',
      'Er leidet an starken Kopfschmerzen.',
      'Er leidet über starke Kopfschmerzen.',
      'Er leidet für starke Kopfschmerzen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'leiden unter\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-034',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat ihm geraten, einen Arzt aufzusuchen.',
      'Sie hat ihn geraten, einen Arzt aufzusuchen.',
      'Sie hat ihm geraten, einen Arzt aufsuchen.',
      'Sie hat ihm geraten, einen Arzt zu aufsuchen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'raten\' verlangt Dativ (ihm); \'zu\' zwischen Präfix und Verb: aufzusuchen.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-035',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wäre gern Pilot geworden.',
      'Er wäre gern Pilot werden.',
      'Er würde gern Pilot geworden.',
      'Er wäre gern Pilot gewesen geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit: \'wäre + Partizip II (geworden)\'.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-036',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Während er lernte, hörte er Musik.',
      'Während er lernte, er hörte Musik.',
      'Während er lernte hörte er Musik.',
      'Während lernte er, hörte er Musik.'
    ],
    'correctAnswer': 0,
    'explanation': '\'während\'-Nebensatz: Verb am Ende; Komma + Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-037',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Geschäft, an das ich mich erinnere, gibt es nicht mehr.',
      'Das Geschäft, an dem ich mich erinnere, gibt es nicht mehr.',
      'Das Geschäft, an den ich mich erinnere, gibt es nicht mehr.',
      'Das Geschäft, an der ich mich erinnere, gibt es nicht mehr.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich erinnern an\' + Akkusativ; \'Geschäft\' ist Neutrum -> an das.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-038',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Poster hängt über dem Schreibtisch.',
      'Das Poster hängt über den Schreibtisch.',
      'Das Poster hängt über der Schreibtisch.',
      'Das Poster hängt über des Schreibtisches.'
    ],
    'correctAnswer': 0,
    'explanation': '\'hängen\' (intransitiv) = Ort (wo?) -> Dativ: über dem Schreibtisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-039',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat seinem Kollegen das Werkzeug geliehen.',
      'Er hat seinen Kollegen das Werkzeug geliehen.',
      'Er hat seinem Kollegen den Werkzeug geliehen.',
      'Er hat seinem Kollege das Werkzeug geliehen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'leihen\' verlangt Dativ (seinem Kollegen) + Akkusativ (das Werkzeug, Neutrum).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-040',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er zweifelt daran, ob das richtig ist.',
      'Er zweifelt daran, ob ist das richtig.',
      'Er zweifelt daran, ob das richtig sein.',
      'Er zweifelt an daran, ob das richtig ist.'
    ],
    'correctAnswer': 0,
    'explanation': '\'zweifeln daran, ob\' — im Nebensatz steht das Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-041',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er stellt den Eimer unter den Tisch.',
      'Er stellt den Eimer unter dem Tisch.',
      'Er stellt den Eimer unter der Tisch.',
      'Er stellt der Eimer unter den Tisch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stellen unter\' = Richtung (wohin?) -> Akkusativ: unter den Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-042',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er rechnet mit einer Gehaltserhöhung.',
      'Er rechnet auf eine Gehaltserhöhung.',
      'Er rechnet über eine Gehaltserhöhung.',
      'Er rechnet für eine Gehaltserhöhung.'
    ],
    'correctAnswer': 0,
    'explanation': '\'rechnen mit\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-043',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Ärzte, von denen er behandelt wurde, waren kompetent.',
      'Die Ärzte, von die er behandelt wurde, waren kompetent.',
      'Die Ärzte, von den er behandelt wurde, waren kompetent.',
      'Die Ärzte, von dem er behandelt wurde, waren kompetent.'
    ],
    'correctAnswer': 0,
    'explanation': '\'von\' verlangt Dativ; Plural -> Relativpronomen: denen.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-044',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn er nur fleißiger gelernt hätte!',
      'Wenn er nur fleißiger lernt!',
      'Wenn er nur fleißiger gelernt hat!',
      'Wenn er nur hätte fleißiger gelernt!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunsch in der Vergangenheit: \'wenn ... nur + hätte + Partizip II\'.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-045',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat es ihr versprochen.',
      'Er hat es sie versprochen.',
      'Er hat es ihrem versprochen.',
      'Er hat sie es versprochen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'versprechen\' verlangt Dativ (ihr) + Akkusativ (es). Pronomen: Akk. vor Dat.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-046',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ohne zu zögern sprang er ins Wasser.',
      'Ohne zögern sprang er ins Wasser.',
      'Ohne zu zögern er sprang ins Wasser.',
      'Ohne zögern zu sprang er ins Wasser.'
    ],
    'correctAnswer': 0,
    'explanation': '\'ohne zu\' + Infinitiv; Inversion im Hauptsatz nach vorangestelltem Infinitivsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-047',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Lampe hängt über dem Esstisch.',
      'Die Lampe hängt über den Esstisch.',
      'Die Lampe hängt über der Esstisch.',
      'Die Lampe hängt über des Esstisches.'
    ],
    'correctAnswer': 0,
    'explanation': '\'hängen\' (intransitiv) = Ort (wo?) -> Dativ: über dem Esstisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-048',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er zweifelt an seiner Entscheidung.',
      'Er zweifelt über seine Entscheidung.',
      'Er zweifelt für seine Entscheidung.',
      'Er zweifelt auf seine Entscheidung.'
    ],
    'correctAnswer': 0,
    'explanation': '\'zweifeln an\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-049',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat gestern den ganzen Tag im Büro gearbeitet.',
      'Er hat gestern den ganzen Tag im Büro arbeiten.',
      'Gestern hat er den ganzen Tag im Büro gearbeitet.',
      'Gestern er hat den ganzen Tag im Büro gearbeitet.'
    ],
    'correctAnswer': 2,
    'explanation': 'Inversion: Zeitangabe am Anfang -> Verb vor Subjekt. Partizip II am Ende.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p5-050',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wäre fast zu spät gekommen.',
      'Er wäre fast zu spät kommen.',
      'Er würde fast zu spät gekommen.',
      'Er ist fast zu spät gekommen wäre.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit: \'wäre + Partizip II (gekommen)\'.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  }
];

export default questions;
