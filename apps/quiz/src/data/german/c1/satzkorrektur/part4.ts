import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verhandlungen wurden zum Ausdruck gebracht.',
      'Die Bedenken wurden zum Ausdruck gebracht.',
      'Die Bedenken wurden zum Ausdruck genommen.',
      'Die Bedenken wurden zum Ausdruck gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: etwas zum Ausdruck bringen (= ausdrücken). Man bringt Bedenken, nicht Verhandlungen zum Ausdruck.',
    'exampleSentence': 'Die Bedenken wurden zum Ausdruck gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Ausdruck bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aufrechterhaltung der öffentlichen Ordnung obliegt der Polizei.',
      'Die Aufrechterhaltung den öffentlichen Ordnung obliegt der Polizei.',
      'Die Aufrechterhaltung der öffentlichen Ordnung obliegen der Polizei.',
      'Die Aufrechterhaltung die öffentliche Ordnung obliegt der Polizei.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Aufrechterhaltung + Genitiv (der öffentlichen Ordnung). Subjekt Singular → obliegt.',
    'exampleSentence': 'Die Aufrechterhaltung der öffentlichen Ordnung obliegt der Polizei.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der über Jahre hinweg vernachlässigte Stadtteil soll saniert werden.',
      'Der über Jahre hinweg vernachlässigten Stadtteil soll saniert werden.',
      'Der über Jahre hinweg vernachlässigter Stadtteil soll saniert werden.',
      'Der über Jahre hinweg vernachlässigende Stadtteil soll saniert werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: vernachlässigte (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der über Jahre hinweg vernachlässigte Stadtteil soll saniert werden.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Experte erläuterte, das Verfahren biete viele Vorteile.',
      'Der Experte erläuterte, das Verfahren bietet viele Vorteile.',
      'Der Experte erläuterte, das Verfahren biete viele Vorteile bietet.',
      'Der Experte erläuterte, das Verfahren böte viele Vorteile.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: biete (3. Person Singular von bieten).',
    'exampleSentence': 'Der Experte erläuterte, das Verfahren biete viele Vorteile.',
    'grammarRule': 'Konjunktiv I: bieten → biete',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Tür ist von innen nicht zu öffnen.',
      'Die Tür ist von innen nicht öffnen zu.',
      'Die Tür ist von innen nicht zu geöffnet.',
      'Die Tür ist von innen nicht öffnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist zu öffnen (= kann geöffnet werden).',
    'exampleSentence': 'Die Tür ist von innen nicht zu öffnen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ohne dass er es bemerkte, hatte sich die Situation verändert.',
      'Ohne dass er es bemerkte, sich die Situation hatte verändert.',
      'Ohne dass er bemerkte es, hatte sich die Situation verändert.',
      'Ohne dass er es bemerkte, hatte die Situation sich verändert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalsatz mit ohne dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Ohne dass er es bemerkte, hatte sich die Situation verändert.',
    'grammarRule': 'Satzgefüge: ohne dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abseits des üblichen Trubels fand er Ruhe.',
      'Abseits dem üblichen Trubel fand er Ruhe.',
      'Abseits des üblichen Trubel fand er Ruhe.',
      'Abseits den üblichen Trubels fand er Ruhe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Abseits verlangt den Genitiv: abseits des üblichen Trubels.',
    'exampleSentence': 'Abseits des üblichen Trubels fand er Ruhe.',
    'grammarRule': 'Präposition abseits + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Besonders hervorzuheben ist die Qualität der Zusammenarbeit.',
      'Besonders hervorzuheben die Qualität der Zusammenarbeit ist.',
      'Besonders ist hervorzuheben die Qualität der Zusammenarbeit.',
      'Besonders hervorzuheben ist der Zusammenarbeit die Qualität.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei vorangestelltem Infinitiv mit zu steht das finite Verb an zweiter Stelle: ist.',
    'exampleSentence': 'Besonders hervorzuheben ist die Qualität der Zusammenarbeit.',
    'grammarRule': 'Wortstellung: Infinitiv im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bereitstellung finanzieller Mittel ist dringend erforderlich.',
      'Die Bereitstellung finanzielle Mittel ist dringend erforderlich.',
      'Die Bereitstellung finanzieller Mittel sind dringend erforderlich.',
      'Die Bereitstellung finanziellen Mitteln ist dringend erforderlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bereitstellung + Genitiv Plural (finanzieller Mittel). Subjekt Singular → ist.',
    'exampleSentence': 'Die Bereitstellung finanzieller Mittel ist dringend erforderlich.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die rasant steigende Inflationsrate beunruhigt die Bevölkerung.',
      'Die rasant steigenden Inflationsrate beunruhigt die Bevölkerung.',
      'Die rasant steigender Inflationsrate beunruhigt die Bevölkerung.',
      'Die rasant gestiegene Inflationsrate beunruhigt die Bevölkerung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: steigende (Nominativ feminin Singular mit bestimmtem Artikel: -e). Partizip I drückt Gleichzeitigkeit aus.',
    'exampleSentence': 'Die rasant steigende Inflationsrate beunruhigt die Bevölkerung.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Pressesprecher teilte mit, man arbeite an einer Lösung.',
      'Der Pressesprecher teilte mit, man arbeitet an einer Lösung.',
      'Der Pressesprecher teilte mit, man arbeite an einer Lösung arbeitet.',
      'Der Pressesprecher teilte mit, man arbeitete an einer Lösung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: arbeite (3. Person Singular von arbeiten).',
    'exampleSentence': 'Der Pressesprecher teilte mit, man arbeite an einer Lösung.',
    'grammarRule': 'Konjunktiv I: arbeiten → arbeite',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dieser Ansatz verdient es, weiterverfolgt zu werden.',
      'Dieser Ansatz verdient, weiterverfolgt zu werden es.',
      'Dieser Ansatz verdient es, weiterverfolgen zu werden.',
      'Dieser Ansatz verdient es, zu weiterverfolgt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz: verdient es, + Partizip II + zu werden (Passiv-Infinitiv).',
    'exampleSentence': 'Dieser Ansatz verdient es, weiterverfolgt zu werden.',
    'grammarRule': 'Passiv-Infinitivsatz: Partizip II + zu werden',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je nachdem, wie sich die Lage entwickelt, werden wir reagieren.',
      'Je nachdem, wie sich die Lage entwickelt, wir werden reagieren.',
      'Je nachdem, wie sich entwickelt die Lage, werden wir reagieren.',
      'Je nachdem, wie sich die Lage entwickelt, werden reagieren wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit je nachdem: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Je nachdem, wie sich die Lage entwickelt, werden wir reagieren.',
    'grammarRule': 'Satzgefüge: je nachdem',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Sachverhalt unter Beweis gestellt.',
      'Er hat den Sachverhalt unter Beweis gebracht.',
      'Er hat den Sachverhalt unter Beweis genommen.',
      'Er hat den Sachverhalt unter Beweis gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas unter Beweis stellen (= beweisen).',
    'exampleSentence': 'Er hat den Sachverhalt unter Beweis gestellt.',
    'grammarRule': 'Funktionsverbgefüge: unter Beweis stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Oberhalb des Dorfes liegt ein altes Kloster.',
      'Oberhalb dem Dorf liegt ein altes Kloster.',
      'Oberhalb des Dorf liegt ein altes Kloster.',
      'Oberhalb den Dorfes liegt ein altes Kloster.'
    ],
    'correctAnswer': 0,
    'explanation': 'Oberhalb verlangt den Genitiv: oberhalb des Dorfes.',
    'exampleSentence': 'Oberhalb des Dorfes liegt ein altes Kloster.',
    'grammarRule': 'Präposition oberhalb + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Inwieweit diese Maßnahme wirksam ist, bleibt abzuwarten.',
      'Inwieweit diese Maßnahme wirksam ist, abzuwarten bleibt.',
      'Inwieweit ist diese Maßnahme wirksam, bleibt abzuwarten.',
      'Inwieweit diese Maßnahme ist wirksam, bleibt abzuwarten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekter Fragesatz mit inwieweit: Verb am Ende des Nebensatzes, Hauptsatz mit normalem Verbzweit.',
    'exampleSentence': 'Inwieweit diese Maßnahme wirksam ist, bleibt abzuwarten.',
    'grammarRule': 'Wortstellung: indirekter Fragesatz mit inwieweit',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf Veranlassung des Bürgermeisters wurde eine Sondersitzung einberufen.',
      'Auf Veranlassung dem Bürgermeister wurde eine Sondersitzung einberufen.',
      'Auf Veranlassung des Bürgermeisters wurden eine Sondersitzung einberufen.',
      'Auf Veranlassung den Bürgermeisters wurde eine Sondersitzung einberufen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: auf Veranlassung + Genitiv (des Bürgermeisters). Subjekt Singular → wurde.',
    'exampleSentence': 'Auf Veranlassung des Bürgermeisters wurde eine Sondersitzung einberufen.',
    'grammarRule': 'Nominalstil: auf Veranlassung + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das in Fachkreisen hoch geschätzte Werk wurde neu aufgelegt.',
      'Das in Fachkreisen hoch geschätzten Werk wurde neu aufgelegt.',
      'Das in Fachkreisen hoch geschätztes Werk wurde neu aufgelegt.',
      'Das in Fachkreisen hoch schätzende Werk wurde neu aufgelegt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: geschätzte (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das in Fachkreisen hoch geschätzte Werk wurde neu aufgelegt.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Behörde erklärte, es bestehe kein Grund zur Sorge.',
      'Die Behörde erklärte, es besteht kein Grund zur Sorge.',
      'Die Behörde erklärte, es bestehe kein Grund zur Sorge besteht.',
      'Die Behörde erklärte, es bestünde kein Grund zur Sorge.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: bestehe (3. Person Singular von bestehen).',
    'exampleSentence': 'Die Behörde erklärte, es bestehe kein Grund zur Sorge.',
    'grammarRule': 'Konjunktiv I: bestehen → bestehe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Risiko ist nicht zu unterschätzen.',
      'Das Risiko ist nicht unterschätzen zu.',
      'Das Risiko ist nicht zu unterschätzt.',
      'Das Risiko ist nicht unterschätzen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist zu unterschätzen (= darf nicht unterschätzt werden).',
    'exampleSentence': 'Das Risiko ist nicht zu unterschätzen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unbeschadet dessen, dass Fehler gemacht wurden, war das Projekt ein Erfolg.',
      'Unbeschadet dessen, dass Fehler gemacht wurden, das Projekt war ein Erfolg.',
      'Unbeschadet dessen, dass Fehler wurden gemacht, war das Projekt ein Erfolg.',
      'Unbeschadet dessen, dass Fehler gemacht wurden, war ein Erfolg das Projekt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit unbeschadet dessen, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Unbeschadet dessen, dass Fehler gemacht wurden, war das Projekt ein Erfolg.',
    'grammarRule': 'Satzgefüge: unbeschadet dessen, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Reform hat Veränderungen in Gang gesetzt.',
      'Die Reform hat Veränderungen in Gang gebracht.',
      'Die Reform hat Veränderungen in Gang genommen.',
      'Die Reform hat Veränderungen in Gang gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Gang setzen (= starten, initiieren).',
    'exampleSentence': 'Die Reform hat Veränderungen in Gang gesetzt.',
    'grammarRule': 'Funktionsverbgefüge: in Gang setzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Diesseits der Grenze gelten andere Bestimmungen.',
      'Diesseits dem Grenze gelten andere Bestimmungen.',
      'Diesseits den Grenze gelten andere Bestimmungen.',
      'Diesseits die Grenze gelten andere Bestimmungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Diesseits verlangt den Genitiv: diesseits der Grenze.',
    'exampleSentence': 'Diesseits der Grenze gelten andere Bestimmungen.',
    'grammarRule': 'Präposition diesseits + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dementsprechend wurde die Strategie angepasst.',
      'Dementsprechend die Strategie wurde angepasst.',
      'Dementsprechend wurde angepasst die Strategie.',
      'Dementsprechend angepasst wurde die Strategie.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach einem Konjunktionaladverb im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Dementsprechend wurde die Strategie angepasst.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Zuge der Digitalisierung verändert sich die Arbeitswelt grundlegend.',
      'Im Zuge den Digitalisierung verändert sich die Arbeitswelt grundlegend.',
      'Im Zuge der Digitalisierung verändern sich die Arbeitswelt grundlegend.',
      'Im Zuge die Digitalisierung verändert sich die Arbeitswelt grundlegend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Zuge + Genitiv: im Zuge der Digitalisierung. Subjekt Singular → verändert sich.',
    'exampleSentence': 'Im Zuge der Digitalisierung verändert sich die Arbeitswelt grundlegend.',
    'grammarRule': 'Nominalstil: im Zuge + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Eine in mehreren Studien bestätigte Hypothese wurde veröffentlicht.',
      'Eine in mehreren Studien bestätigten Hypothese wurde veröffentlicht.',
      'Eine in mehreren Studien bestätigter Hypothese wurde veröffentlicht.',
      'Eine in mehreren Studien bestätigende Hypothese wurde veröffentlicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: bestätigte (Nominativ feminin Singular mit unbestimmtem Artikel: -e).',
    'exampleSentence': 'Eine in mehreren Studien bestätigte Hypothese wurde veröffentlicht.',
    'grammarRule': 'Erweitertes Partizip II mit unbestimmtem Artikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Zeuge gab an, er habe den Vorfall genau beobachtet.',
      'Der Zeuge gab an, er hat den Vorfall genau beobachtet.',
      'Der Zeuge gab an, er habe den Vorfall genau beobachtet hat.',
      'Der Zeuge gab an, er hätte den Vorfall genau beobachtet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe beobachtet (indirekte Rede).',
    'exampleSentence': 'Der Zeuge gab an, er habe den Vorfall genau beobachtet.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Unterlagen sind bis morgen einzureichen.',
      'Die Unterlagen sind bis morgen zu eingereicht.',
      'Die Unterlagen sind bis morgen einreichen.',
      'Die Unterlagen sind bis morgen eingereicht zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind einzureichen (= müssen eingereicht werden).',
    'exampleSentence': 'Die Unterlagen sind bis morgen einzureichen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei denn, die Umstände ändern sich, bleibt alles beim Alten.',
      'Es sei denn, sich ändern die Umstände, bleibt alles beim Alten.',
      'Es sei denn, die Umstände ändern sich, beim Alten bleibt alles.',
      'Es sei denn, die Umstände sich ändern, bleibt alles beim Alten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit es sei denn: Hauptsatzwortstellung (Verb an zweiter Stelle).',
    'exampleSentence': 'Es sei denn, die Umstände ändern sich, bleibt alles beim Alten.',
    'grammarRule': 'Satzgefüge: es sei denn',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachricht hat große Bestürzung hervorgerufen.',
      'Die Nachricht hat große Bestürzung hervorgebracht.',
      'Die Nachricht hat große Bestürzung hervorgenommen.',
      'Die Nachricht hat große Bestürzung hervorgestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Bestürzung hervorrufen (= verursachen).',
    'exampleSentence': 'Die Nachricht hat große Bestürzung hervorgerufen.',
    'grammarRule': 'Funktionsverbgefüge: Bestürzung hervorrufen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Inmitten der Krise bewahrte sie einen kühlen Kopf.',
      'Inmitten dem Krise bewahrte sie einen kühlen Kopf.',
      'Inmitten den Krise bewahrte sie einen kühlen Kopf.',
      'Inmitten die Krise bewahrte sie einen kühlen Kopf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inmitten verlangt den Genitiv: inmitten der Krise.',
    'exampleSentence': 'Inmitten der Krise bewahrte sie einen kühlen Kopf.',
    'grammarRule': 'Präposition inmitten + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur die Kosten, sondern auch der Zeitaufwand ist erheblich.',
      'Nicht nur die Kosten, sondern auch der Zeitaufwand erheblich ist.',
      'Nicht nur die Kosten, sondern der Zeitaufwand auch ist erheblich.',
      'Nicht nur die Kosten, sondern auch ist der Zeitaufwand erheblich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nicht nur ... sondern auch: Bei Aufzählung von Subjektteilen steht das Verb nach dem zweiten Teil.',
    'exampleSentence': 'Nicht nur die Kosten, sondern auch der Zeitaufwand ist erheblich.',
    'grammarRule': 'Wortstellung: nicht nur ... sondern auch bei Subjekten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Inbetriebnahme des neuen Kraftwerks ist für Mai geplant.',
      'Die Inbetriebnahme dem neuen Kraftwerk ist für Mai geplant.',
      'Die Inbetriebnahme des neuen Kraftwerk ist für Mai geplant.',
      'Die Inbetriebnahme des neuen Kraftwerks sind für Mai geplant.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Inbetriebnahme + Genitiv (des neuen Kraftwerks). Subjekt Singular → ist.',
    'exampleSentence': 'Die Inbetriebnahme des neuen Kraftwerks ist für Mai geplant.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die vom Gericht angeordnete Untersuchung dauert noch an.',
      'Die vom Gericht angeordneten Untersuchung dauert noch an.',
      'Die vom Gericht angeordneter Untersuchung dauert noch an.',
      'Die vom Gericht anordnende Untersuchung dauert noch an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: angeordnete (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die vom Gericht angeordnete Untersuchung dauert noch an.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Quelle berichtet, es handle sich um ein Missverständnis.',
      'Die Quelle berichtet, es handelt sich um ein Missverständnis.',
      'Die Quelle berichtet, es handle sich um ein Missverständnis handelt.',
      'Die Quelle berichtet, es handelte sich um ein Missverständnis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: handle (3. Person Singular von handeln). Sich handeln um = betreffen.',
    'exampleSentence': 'Die Quelle berichtet, es handle sich um ein Missverständnis.',
    'grammarRule': 'Konjunktiv I: handeln → handle',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ergebnisse lassen keine andere Interpretation zu.',
      'Die Ergebnisse lassen keine andere Interpretation zu lassen.',
      'Die Ergebnisse zulassen keine andere Interpretation.',
      'Die Ergebnisse lassen keine andere Interpretation zugelassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zulassen als trennbares Verb: lassen ... zu. Hier nicht Passiversatzform, sondern aktive Konstruktion mit trennbarem Verb.',
    'exampleSentence': 'Die Ergebnisse lassen keine andere Interpretation zu.',
    'grammarRule': 'Trennbares Verb: zulassen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Statt dass man die Probleme löst, werden neue geschaffen.',
      'Statt dass man die Probleme löst, neue werden geschaffen.',
      'Statt dass man löst die Probleme, werden neue geschaffen.',
      'Statt dass man die Probleme löst, werden geschaffen neue.'
    ],
    'correctAnswer': 0,
    'explanation': 'Substitutivsatz mit statt dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Statt dass man die Probleme löst, werden neue geschaffen.',
    'grammarRule': 'Satzgefüge: statt dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man muss Maßnahmen zur Verbesserung ergreifen.',
      'Man muss Maßnahmen zur Verbesserung nehmen.',
      'Man muss Maßnahmen zur Verbesserung machen.',
      'Man muss Maßnahmen zur Verbesserung stellen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Maßnahmen ergreifen (= handeln).',
    'exampleSentence': 'Man muss Maßnahmen zur Verbesserung ergreifen.',
    'grammarRule': 'Funktionsverbgefüge: Maßnahmen ergreifen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einschließlich der Nebenkosten beträgt die Miete 1200 Euro.',
      'Einschließlich den Nebenkosten beträgt die Miete 1200 Euro.',
      'Einschließlich der Nebenkostenbeträgt die Miete 1200 Euro.',
      'Einschließlich die Nebenkosten beträgt die Miete 1200 Euro.'
    ],
    'correctAnswer': 0,
    'explanation': 'Einschließlich verlangt den Genitiv: einschließlich der Nebenkosten.',
    'exampleSentence': 'Einschließlich der Nebenkosten beträgt die Miete 1200 Euro.',
    'grammarRule': 'Präposition einschließlich + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Darüber hinaus sollte man die langfristigen Folgen bedenken.',
      'Darüber hinaus man sollte die langfristigen Folgen bedenken.',
      'Darüber hinaus sollte die langfristigen Folgen man bedenken.',
      'Darüber hinaus die langfristigen Folgen sollte man bedenken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach darüber hinaus im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Darüber hinaus sollte man die langfristigen Folgen bedenken.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Wiederherstellung der Daten erfordert Geduld.',
      'Die Wiederherstellung den Daten erfordert Geduld.',
      'Die Wiederherstellung der Daten erfordern Geduld.',
      'Die Wiederherstellung die Daten erfordert Geduld.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Wiederherstellung + Genitiv Plural (der Daten). Subjekt Singular → erfordert.',
    'exampleSentence': 'Die Wiederherstellung der Daten erfordert Geduld.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der streng vertraulich zu behandelnde Bericht liegt vor.',
      'Der streng vertraulich zu behandelnden Bericht liegt vor.',
      'Der streng vertraulich zu behandelnder Bericht liegt vor.',
      'Der streng vertraulich behandelte Bericht liegt vor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu behandelnde (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der streng vertraulich zu behandelnde Bericht liegt vor.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut Pressemitteilung habe der Konzern seinen Umsatz gesteigert.',
      'Laut Pressemitteilung hat der Konzern seinen Umsatz gesteigert.',
      'Laut Pressemitteilung habe der Konzern seinen Umsatz gesteigert hat.',
      'Laut Pressemitteilung hätte der Konzern seinen Umsatz gesteigert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt in indirekter Rede: habe gesteigert.',
    'exampleSentence': 'Laut Pressemitteilung habe der Konzern seinen Umsatz gesteigert.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ware ist innerhalb von drei Tagen zu liefern.',
      'Die Ware ist innerhalb von drei Tagen liefern zu.',
      'Die Ware ist innerhalb von drei Tagen zu geliefert.',
      'Die Ware ist innerhalb von drei Tagen liefern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist zu liefern (= muss geliefert werden).',
    'exampleSentence': 'Die Ware ist innerhalb von drei Tagen zu liefern.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abgesehen davon, dass die Kosten hoch sind, gibt es weitere Probleme.',
      'Abgesehen davon, dass die Kosten hoch sind, es gibt weitere Probleme.',
      'Abgesehen davon, dass die Kosten sind hoch, gibt es weitere Probleme.',
      'Abgesehen davon, dass die Kosten hoch sind, gibt weitere Probleme es.'
    ],
    'correctAnswer': 0,
    'explanation': 'Einschränkungssatz mit abgesehen davon, dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Abgesehen davon, dass die Kosten hoch sind, gibt es weitere Probleme.',
    'grammarRule': 'Satzgefüge: abgesehen davon, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seine Kompetenz stellte er eindrucksvoll unter Beweis.',
      'Seine Kompetenz stellte er eindrucksvoll unter Beweis gestellt.',
      'Seine Kompetenz brachte er eindrucksvoll unter Beweis.',
      'Seine Kompetenz nahm er eindrucksvoll unter Beweis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas unter Beweis stellen (= beweisen). Trennbar im Hauptsatz: stellte ... unter Beweis.',
    'exampleSentence': 'Seine Kompetenz stellte er eindrucksvoll unter Beweis.',
    'grammarRule': 'Funktionsverbgefüge: unter Beweis stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Statt eines formellen Schreibens genügt eine E-Mail.',
      'Statt einem formellen Schreiben genügt eine E-Mail.',
      'Statt eines formellen Schreiben genügt eine E-Mail.',
      'Statt ein formelles Schreiben genügt eine E-Mail.'
    ],
    'correctAnswer': 0,
    'explanation': 'Statt (anstelle) verlangt den Genitiv: statt eines formellen Schreibens.',
    'exampleSentence': 'Statt eines formellen Schreibens genügt eine E-Mail.',
    'grammarRule': 'Präposition statt + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einerseits fehlen die Mittel, andererseits mangelt es an Personal.',
      'Einerseits die Mittel fehlen, andererseits es mangelt an Personal.',
      'Einerseits fehlen die Mittel, andererseits an Personal mangelt es.',
      'Einerseits die Mittel fehlen, andererseits mangelt es an Personal.'
    ],
    'correctAnswer': 0,
    'explanation': 'Einerseits ... andererseits: Nach beiden Adverbien im Vorfeld steht das Verb an zweiter Stelle.',
    'exampleSentence': 'Einerseits fehlen die Mittel, andererseits mangelt es an Personal.',
    'grammarRule': 'Wortstellung: einerseits ... andererseits',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Umsetzung der beschlossenen Maßnahmen steht unmittelbar bevor.',
      'Die Umsetzung den beschlossenen Maßnahmen steht unmittelbar bevor.',
      'Die Umsetzung der beschlossenen Maßnahmen stehen unmittelbar bevor.',
      'Die Umsetzung die beschlossenen Maßnahmen steht unmittelbar bevor.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Umsetzung + Genitiv Plural (der beschlossenen Maßnahmen). Subjekt Singular → steht.',
    'exampleSentence': 'Die Umsetzung der beschlossenen Maßnahmen steht unmittelbar bevor.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p4-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die aus dem Experiment gewonnenen Daten werden analysiert.',
      'Die aus dem Experiment gewonnene Daten werden analysiert.',
      'Die aus dem Experiment gewonnener Daten werden analysiert.',
      'Die aus dem Experiment gewinnenden Daten werden analysiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: gewonnenen (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die aus dem Experiment gewonnenen Daten werden analysiert.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  }
];

export default questions;
