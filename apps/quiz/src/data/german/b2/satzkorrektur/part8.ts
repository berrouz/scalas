import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-001',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich an seiner Stelle wäre, würde ich kündigen.',
      'Wenn ich an seiner Stelle bin, würde ich kündigen.',
      'Wenn ich an seiner Stelle wäre, kündige ich.',
      'Wenn ich an seiner Stelle sei, würde ich kündigen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: wäre (Konjunktiv II) + würde kündigen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bewerbung wurde fristgerecht eingereicht.',
      'Die Bewerbung wurde fristgerecht einreichen.',
      'Die Bewerbung worden fristgerecht eingereicht.',
      'Die Bewerbung wurde fristgerecht eingereichten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (eingereicht).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Mitarbeiterin, der man die Aufgabe übertragen hat, ist sehr kompetent.',
      'Die Mitarbeiterin, die man die Aufgabe übertragen hat, ist sehr kompetent.',
      'Die Mitarbeiterin, den man die Aufgabe übertragen hat, ist sehr kompetent.',
      'Die Mitarbeiterin, dessen man die Aufgabe übertragen hat, ist sehr kompetent.'
    ],
    'correctAnswer': 0,
    'explanation': '"Übertragen" + Dativ (Person) + Akkusativ (Sache): der (Dativ feminin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich entschlossen, nach Kanada auszuwandern.',
      'Er hat sich entschlossen, nach Kanada auswandern.',
      'Er hat sich entschlossen, nach Kanada zu auswandern.',
      'Er hat sich entschlossen, nach Kanada ausgewandert zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": auszuwandern.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestotrotz hat er das Projekt erfolgreich abgeschlossen.',
      'Nichtsdestotrotz er hat das Projekt erfolgreich abgeschlossen.',
      'Nichtsdestotrotz hat das Projekt er erfolgreich abgeschlossen.',
      'Nichtsdestotrotz erfolgreich hat er das Projekt abgeschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nichtsdestotrotz" an Position 1 erfordert Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie auch immer die Entscheidung ausfällt, wir akzeptieren sie.',
      'Wie auch immer die Entscheidung ausfällt, wir sie akzeptieren.',
      'Wie auch immer ausfällt die Entscheidung, wir akzeptieren sie.',
      'Wie auch immer die Entscheidung fällt aus, wir akzeptieren sie.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wie auch immer" leitet einen Nebensatz ein (Verb am Ende). Der Hauptsatz folgt mit normaler Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie enthielt sich jeder Stellungnahme.',
      'Sie enthielt sich jede Stellungnahme.',
      'Sie enthielt sich jeder Stellungnahmen.',
      'Sie enthielt sich jedem Stellungnahme.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich enthalten" + Genitiv: jeder Stellungnahme.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die soeben eingetroffene Lieferung muss überprüft werden.',
      'Die soeben eintreffende Lieferung muss überprüft werden.',
      'Die soeben eingetroffen Lieferung muss überprüft werden.',
      'Die soeben eingetroffener Lieferung muss überprüft werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: eingetroffene (die eingetroffene Lieferung).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Lehrerin sagte, die Schüler sollten mehr lesen.',
      'Die Lehrerin sagte, die Schüler sollen mehr lesen.',
      'Die Lehrerin sagte, die Schüler sollten mehr gelesen.',
      'Die Lehrerin sagte, die Schüler sollen mehr gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv II als Ersatz (da Konjunktiv I = Indikativ): sollten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Tür lässt sich nicht öffnen.',
      'Die Tür lässt sich nicht geöffnet.',
      'Die Tür lässt sich nicht zu öffnen.',
      'Die Tür lässt sich nicht öffnen werden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich lassen" + Infinitiv drückt passive Möglichkeit aus: lässt sich öffnen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Leute, bei denen wir wohnen, sind sehr freundlich.',
      'Die Leute, bei die wir wohnen, sind sehr freundlich.',
      'Die Leute, bei den wir wohnen, sind sehr freundlich.',
      'Die Leute, bei deren wir wohnen, sind sehr freundlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bei" + Dativ Plural: bei denen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich bemüht, den Konflikt beizulegen.',
      'Er hat sich bemüht, den Konflikt beilegen.',
      'Er hat sich bemüht, den Konflikt zu beilegen.',
      'Er hat sich bemüht, den Konflikt beigelegt zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": beizulegen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allerdings muss man bedenken, dass ...',
      'Allerdings man muss bedenken, dass ...',
      'Allerdings muss bedenken man, dass ...',
      'Allerdings bedenken muss man, dass ...'
    ],
    'correctAnswer': 0,
    'explanation': '"Allerdings" an Position 1 erfordert Inversion: muss man.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Inwieweit das stimmt, kann ich nicht beurteilen.',
      'Inwieweit das stimmt, ich kann nicht beurteilen.',
      'Inwieweit stimmt das, kann ich nicht beurteilen.',
      'Inwieweit das stimmt, beurteilen kann ich nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Inwieweit" leitet einen indirekten Fragesatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einschließlich der Versandkosten beträgt der Preis 50 Euro.',
      'Einschließlich die Versandkosten beträgt der Preis 50 Euro.',
      'Einschließlich den Versandkosten beträgt der Preis 50 Euro.',
      'Einschließlich dem Versandkosten beträgt der Preis 50 Euro.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einschließlich" verlangt den Genitiv: einschließlich der Versandkosten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausschauend geplant, verlief das Projekt reibungslos.',
      'Vorausschauend geplant, das Projekt verlief reibungslos.',
      'Vorausschauend planend, verlief das Projekt reibungslos.',
      'Vorausschauend geplantet, verlief das Projekt reibungslos.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizipialgruppe als adverbiale Bestimmung: vorausschauend geplant.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Würden Sie so freundlich sein, mir die Tür aufzuhalten?',
      'Werden Sie so freundlich sein, mir die Tür aufzuhalten?',
      'Waren Sie so freundlich sein, mir die Tür aufzuhalten?',
      'Würden Sie so freundlich sein, mir die Tür aufhalten?'
    ],
    'correctAnswer': 0,
    'explanation': 'Höfliche Bitte: Würden Sie + Infinitiv. Mit "so freundlich sein" + "zu" + Infinitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Haus ist vor zehn Jahren gebaut worden.',
      'Das Haus ist vor zehn Jahren gebaut geworden.',
      'Das Haus hat vor zehn Jahren gebaut worden.',
      'Das Haus ist vor zehn Jahren bauen worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt Passiv: ist + Partizip II + worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Unternehmen, für das er arbeitet, expandiert.',
      'Das Unternehmen, für den er arbeitet, expandiert.',
      'Das Unternehmen, für der er arbeitet, expandiert.',
      'Das Unternehmen, für dem er arbeitet, expandiert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Für" + Akkusativ neutrum: für das (das Unternehmen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie scheint sich über das Geschenk gefreut zu haben.',
      'Sie scheint sich über das Geschenk gefreut haben.',
      'Sie scheint sich über das Geschenk zu gefreut haben.',
      'Sie scheint sich über das Geschenk gefreut zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Scheinen" + Infinitiv Perfekt: gefreut zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ausgerechnet heute hat er verschlafen.',
      'Ausgerechnet heute er hat verschlafen.',
      'Ausgerechnet heute hat verschlafen er.',
      'Ausgerechnet hat heute er verschlafen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ausgerechnet heute" an Position 1 erfordert Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausgesetzt, er kommt pünktlich, können wir anfangen.',
      'Vorausgesetzt, er kommt pünktlich, wir können anfangen.',
      'Vorausgesetzt, kommt er pünktlich, können wir anfangen.',
      'Vorausgesetzt, er pünktlich kommt, können wir anfangen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vorausgesetzt" + Hauptsatzstellung im Bedingungssatz. Dann Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er rühmt sich seiner Erfolge.',
      'Er rühmt sich seine Erfolge.',
      'Er rühmt sich seinen Erfolgen.',
      'Er rühmt sich sein Erfolge.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich rühmen" + Genitiv: seiner Erfolge.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Grob geschätzt sind es etwa hundert Teilnehmer.',
      'Grob schätzend sind es etwa hundert Teilnehmer.',
      'Grob geschätzen sind es etwa hundert Teilnehmer.',
      'Grob schätzen sind es etwa hundert Teilnehmer.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: grob geschätzt (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn es nur nicht so kalt wäre!',
      'Wenn es nur nicht so kalt ist!',
      'Wenn es nur nicht so kalt war!',
      'Wenn es nur nicht so kalt sei!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunschsatz: Wenn ... nur + Konjunktiv II: wäre!',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Zeugen werden morgen vernommen werden.',
      'Die Zeugen werden morgen vernehmen werden.',
      'Die Zeugen werden morgen vernommen worden.',
      'Die Zeugen werden morgen vernommen wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I Passiv: werden + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gibt vieles, woran ich mich erinnere.',
      'Es gibt vieles, an das ich mich erinnere.',
      'Es gibt vieles, daran ich mich erinnere.',
      'Sowohl A als auch B sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Nach "vieles" kann man "woran" oder "an das" verwenden. Beide sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich dazu bereit erklärt, uns zu helfen.',
      'Er hat sich dazu bereit erklärt, uns helfen.',
      'Er hat sich dazu bereit erklärt, uns zu geholfen.',
      'Er hat sich dazu bereit erklärt, uns helfen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich bereit erklären" + "zu" + Infinitiv: zu helfen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Glücklicherweise hat niemand etwas bemerkt.',
      'Glücklicherweise niemand hat etwas bemerkt.',
      'Glücklicherweise hat etwas niemand bemerkt.',
      'Glücklicherweise bemerkt hat niemand etwas.'
    ],
    'correctAnswer': 0,
    'explanation': '"Glücklicherweise" an Position 1 erfordert Inversion: hat niemand.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, es klappt nicht, was machen wir dann?',
      'Angenommen, es klappt nicht, was dann machen wir?',
      'Angenommen, klappt es nicht, was machen wir dann?',
      'Angenommen, es nicht klappt, was machen wir dann?'
    ],
    'correctAnswer': 0,
    'explanation': '"Angenommen" + Hauptsatzstellung. Fragesatz: was machen wir dann?',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ausschließlich des Trinkgeldes kostet das Menü 30 Euro.',
      'Ausschließlich dem Trinkgeld kostet das Menü 30 Euro.',
      'Ausschließlich das Trinkgeld kostet das Menü 30 Euro.',
      'Zuzüglich des Trinkgeldes kostet das Menü 30 Euro.'
    ],
    'correctAnswer': 3,
    'explanation': '"Zuzüglich" + Genitiv: zuzüglich des Trinkgeldes. "Ausschließlich" bedeutet "ohne".',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die schnell wachsende Bevölkerung stellt eine Herausforderung dar.',
      'Die schnell gewachsene Bevölkerung stellt eine Herausforderung dar.',
      'Die schnell wachsend Bevölkerung stellt eine Herausforderung dar.',
      'Die schnell wachsenes Bevölkerung stellt eine Herausforderung dar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv (gleichzeitig, aktiv): wachsende Bevölkerung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man berichtete, der Präsident werde morgen eine Rede halten.',
      'Man berichtete, der Präsident wird morgen eine Rede halten.',
      'Man berichtete, der Präsident würde morgen eine Rede halten.',
      'Man berichtete, der Präsident werden morgen eine Rede halten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Futur: werde halten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Formular muss in zweifacher Ausfertigung eingereicht werden.',
      'Das Formular muss in zweifacher Ausfertigung eingereicht wird.',
      'Das Formular muss in zweifacher Ausfertigung einreichen werden.',
      'Das Formular muss in zweifacher Ausfertigung eingereicht geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: muss + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Schlüssel stecken lassen.',
      'Er hat den Schlüssel stecken gelassen.',
      'Er hat den Schlüssel gesteckt lassen.',
      'Er hat den Schlüssel zu stecken lassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Lassen" im Perfekt mit Ersatzinfinitiv: hat stecken lassen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dennoch bleibt die Frage offen.',
      'Dennoch die Frage bleibt offen.',
      'Dennoch bleibt offen die Frage.',
      'Dennoch offen bleibt die Frage.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dennoch" an Position 1 erfordert Inversion: bleibt die Frage.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je nachdem, wie das Wetter wird, fahren wir an den See oder bleiben zu Hause.',
      'Je nachdem, wie das Wetter wird, wir fahren an den See oder bleiben zu Hause.',
      'Je nachdem, wie wird das Wetter, fahren wir an den See oder bleiben zu Hause.',
      'Je nachdem, wie das Wetter wird, an den See fahren wir oder zu Hause bleiben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Je nachdem, wie ..." leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Um des lieben Friedens willen gab er nach.',
      'Um dem lieben Frieden willen gab er nach.',
      'Um den lieben Frieden willen gab er nach.',
      'Um der liebe Frieden willen gab er nach.'
    ],
    'correctAnswer': 0,
    'explanation': '"Um ... willen" + Genitiv: um des lieben Friedens willen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ausgehend von den aktuellen Zahlen, ist die Prognose positiv.',
      'Ausgegangen von den aktuellen Zahlen, ist die Prognose positiv.',
      'Ausgehender von den aktuellen Zahlen, ist die Prognose positiv.',
      'Ausgehen von den aktuellen Zahlen, ist die Prognose positiv.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als adverbiale Bestimmung: ausgehend von.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ohne seine Hilfe hätte ich das nicht geschafft.',
      'Ohne seine Hilfe habe ich das nicht geschafft.',
      'Ohne seine Hilfe hätte ich das nicht schaffen.',
      'Ohne seine Hilfe würde ich das nicht geschafft haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Vergangenheitssatz: hätte + Partizip II: hätte geschafft.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Darüber wird noch zu reden sein.',
      'Darüber wird noch geredet werden sein.',
      'Darüber werden noch zu reden sein.',
      'Darüber wird noch reden zu sein.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wird + zu + Infinitiv + sein" drückt Notwendigkeit aus: wird zu reden sein.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Wohnung, deren Miete sehr hoch ist, liegt im Zentrum.',
      'Die Wohnung, dessen Miete sehr hoch ist, liegt im Zentrum.',
      'Die Wohnung, der Miete sehr hoch ist, liegt im Zentrum.',
      'Die Wohnung, die Miete sehr hoch ist, liegt im Zentrum.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv feminin: deren (die Wohnung → deren Miete).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich daran gewöhnt, allein zu leben.',
      'Er hat sich daran gewöhnt, allein leben.',
      'Er hat sich daran gewöhnt, allein zu gelebt.',
      'Er hat sich daran gewöhnt, allein leben zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich gewöhnen an" + "zu" + Infinitiv: zu leben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Schließlich hat er doch noch zugestimmt.',
      'Schließlich er hat doch noch zugestimmt.',
      'Schließlich hat doch noch er zugestimmt.',
      'Schließlich zugestimmt hat er doch noch.'
    ],
    'correctAnswer': 0,
    'explanation': '"Schließlich" an Position 1 erfordert Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur hat er gelogen, sondern er hat auch gestohlen.',
      'Nicht nur er hat gelogen, sondern auch hat er gestohlen.',
      'Nicht nur gelogen hat er, sondern auch gestohlen hat er.',
      'Nicht nur hat gelogen er, sondern auch gestohlen hat er.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nicht nur" an Position 1 mit Inversion: hat er. "Sondern" + normaler Hauptsatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vermöge seiner Intelligenz löste er das Problem.',
      'Vermöge seinem Intelligenz löste er das Problem.',
      'Vermöge seine Intelligenz löste er das Problem.',
      'Vermöge seinen Intelligenz löste er das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vermöge" (gehobene Sprache) + Genitiv: vermöge seiner Intelligenz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die dringend benötigten Ersatzteile sind eingetroffen.',
      'Die dringend benötigende Ersatzteile sind eingetroffen.',
      'Die dringend benötigt Ersatzteile sind eingetroffen.',
      'Die dringend benötigte Ersatzteile sind eingetroffen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II Plural als Adjektiv: benötigten (die benötigten Ersatzteile).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptete, er sei unschuldig.',
      'Er behauptete, er ist unschuldig.',
      'Er behauptete, er war unschuldig.',
      'Er behauptete, er wäre unschuldig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I: er sei.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Den Gästen wird ein Getränk angeboten.',
      'Die Gäste werden ein Getränk angeboten.',
      'Den Gästen wird ein Getränk anbieten.',
      'Den Gästen worden ein Getränk angeboten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anbieten" + Dativ (Person) + Akkusativ (Sache): Den Gästen wird angeboten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p8-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es hat aufgehört zu regnen.',
      'Es hat aufgehört regnen.',
      'Es hat aufgehört zu geregnet.',
      'Es hat aufgehört regnen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Aufhören" + "zu" + Infinitiv: aufgehört zu regnen.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
