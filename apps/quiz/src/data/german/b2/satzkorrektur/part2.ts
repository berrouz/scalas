import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn er fleißiger gewesen wäre, hätte er die Prüfung bestanden.',
      'Wenn er fleißiger gewesen war, hätte er die Prüfung bestanden.',
      'Wenn er fleißiger gewesen wäre, hat er die Prüfung bestanden.',
      'Wenn er fleißiger war, hätte er die Prüfung bestanden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Vergangenheitssatz: gewesen wäre (Konjunktiv II Plusquamperfekt) → hätte bestanden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Tür wurde von dem Hausmeister geschlossen.',
      'Die Tür wurde von dem Hausmeister schließen.',
      'Die Tür wurde von der Hausmeister geschlossen.',
      'Die Tür worden von dem Hausmeister geschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II. "Von" + Dativ: von dem Hausmeister.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kollegin, deren Mann Arzt ist, arbeitet im Marketing.',
      'Die Kollegin, dessen Mann Arzt ist, arbeitet im Marketing.',
      'Die Kollegin, derer Mann Arzt ist, arbeitet im Marketing.',
      'Die Kollegin, wessen Mann Arzt ist, arbeitet im Marketing.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv feminin: deren (die Kollegin → deren Mann).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie versprach, morgen pünktlich kommen.',
      'Sie versprach, morgen pünktlich zu kommen.',
      'Sie versprach, morgen pünktlich zu gekommen.',
      'Sie versprach, morgen pünktlich kommen zu.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitiv mit "zu": zu kommen. "Zu" steht direkt vor dem Infinitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weil er krank ist, kann er nicht kommen.',
      'Weil er ist krank, kann er nicht kommen.',
      'Weil er krank ist, er kann nicht kommen.',
      'Weil krank er ist, kann er nicht kommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Weil" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entweder du kommst mit, oder du bleibst zu Hause.',
      'Entweder du kommst mit, oder bleibst du zu Hause.',
      'Entweder kommst du mit, oder du bleibst zu Hause.',
      'Entweder du mit kommst, oder du zu Hause bleibst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Entweder ... oder": Beide Teilsätze behalten ihre normale Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie dankte ihrem Kollegen für die Hilfe.',
      'Sie dankte ihren Kollegen für die Hilfe.',
      'Sie dankte ihr Kollege für die Hilfe.',
      'Sie dankte ihres Kollegen für die Hilfe.'
    ],
    'correctAnswer': 0,
    'explanation': '"Danken" verlangt den Dativ: ihrem Kollegen (schwache Deklination).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das frisch gestrichene Zimmer roch nach Farbe.',
      'Das frisch streichende Zimmer roch nach Farbe.',
      'Das frisch gestrichen Zimmer roch nach Farbe.',
      'Das frisch gestreichene Zimmer roch nach Farbe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: gestrichene (das gestrichene Zimmer). Partizip II von "streichen" ist "gestrichen" + Endung -e.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er fragte, ob ich ihm helfen kann.',
      'Er fragte, ob ich ihm helfen könnte.',
      'Er fragte, ob ich ihm helfen konnte.',
      'Er fragte, ob ich ihm helfen könne.'
    ],
    'correctAnswer': 3,
    'explanation': 'Indirekte Rede: Konjunktiv I von "können" → könne.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Auto wird repariert werden müssen.',
      'Das Auto wird repariert werden gemusst.',
      'Das Auto wird müssen repariert werden.',
      'Das Auto wird reparieren werden müssen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I Passiv + Modalverb: wird + Partizip II + werden + Infinitiv des Modalverbs.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist etwas, worüber ich mich freue.',
      'Das ist etwas, über das ich mich freue.',
      'Das ist etwas, darüber ich mich freue.',
      'Sowohl A als auch B sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Nach "etwas" kann man "worüber" oder "über das" verwenden. Beide Formen sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er scheint das Problem zu verstehen.',
      'Er scheint das Problem verstehen.',
      'Er scheint das Problem verstanden zu.',
      'Er scheint das Problem zu verstanden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Scheinen" + "zu" + Infinitiv: scheint zu verstehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selten hat er so gut gespielt.',
      'Selten er hat so gut gespielt.',
      'Selten hat so gut er gespielt.',
      'Selten gespielt hat er so gut.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei vorangestelltem "selten" folgt Inversion: hat er (Verb vor Subjekt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem er ankam, aß er zu Mittag.',
      'Nachdem er angekommen war, aß er zu Mittag.',
      'Nachdem er ankommt, aß er zu Mittag.',
      'Nachdem er angekommen ist, aß er zu Mittag.'
    ],
    'correctAnswer': 1,
    'explanation': '"Nachdem" + Plusquamperfekt (war angekommen), wenn Hauptsatz im Präteritum steht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Streng genommen hat er recht.',
      'Streng nehmend hat er recht.',
      'Streng genommt hat er recht.',
      'Streng zu nehmen hat er recht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: streng genommen (Partizip II von "nehmen").',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Könnten Sie mir bitte helfen?',
      'Können Sie mir bitte helfen?',
      'Konnten Sie mir bitte helfen?',
      'Könnten Sie bitte mir helfen?'
    ],
    'correctAnswer': 0,
    'explanation': 'Höfliche Bitte mit Konjunktiv II: Könnten Sie mir bitte helfen?',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Buch wurde von vielen Menschen gelesen.',
      'Das Buch wurde von vielen Menschen lesen.',
      'Das Buch wurde von viele Menschen gelesen.',
      'Das Buch worden von vielen Menschen gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II. "Von" + Dativ Plural: von vielen Menschen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Ort, an dem wir uns treffen, ist ein Café.',
      'Der Ort, an den wir uns treffen, ist ein Café.',
      'Der Ort, an der wir uns treffen, ist ein Café.',
      'Der Ort, an das wir uns treffen, ist ein Café.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wo? → Dativ maskulin: an dem (an dem Ort).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe ihn kommen hören.',
      'Ich habe ihn kommen gehört.',
      'Ich habe ihn gekommen hören.',
      'Ich habe ihn zu kommen hören.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Wahrnehmungsverben wie "hören" steht im Perfekt der Ersatzinfinitiv: hören (nicht "gehört").',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Deshalb er hat die Prüfung nicht bestanden.',
      'Deshalb hat er die Prüfung nicht bestanden.',
      'Deshalb hat die Prüfung er nicht bestanden.',
      'Deshalb hat nicht er die Prüfung bestanden.'
    ],
    'correctAnswer': 1,
    'explanation': '"Deshalb" an Position 1 erfordert Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder hat er angerufen, noch hat er geschrieben.',
      'Weder er hat angerufen, noch er hat geschrieben.',
      'Weder hat er angerufen noch hat er geschrieben.',
      'Weder angerufen er hat, noch geschrieben er hat.'
    ],
    'correctAnswer': 0,
    'explanation': '"Weder ... noch" mit Inversion in beiden Teilen: Weder hat er ... noch hat er ...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er widerspricht seinem Chef selten.',
      'Er widerspricht seinen Chef selten.',
      'Er widerspricht sein Chef selten.',
      'Er widerspricht seines Chefs selten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Widersprechen" verlangt den Dativ: seinem Chef.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abgesehen davon, dass es regnete, war der Ausflug schön.',
      'Abgeseht davon, dass es regnete, war der Ausflug schön.',
      'Absehend davon, dass es regnete, war der Ausflug schön.',
      'Abgesehen davon, dass regnete es, war der Ausflug schön.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Wendung: "abgesehen davon, dass ..." (Partizip II von "absehen").',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich wünschte, ich könnte besser Deutsch sprechen.',
      'Ich wünschte, ich kann besser Deutsch sprechen.',
      'Ich wünsche, ich könnte besser Deutsch sprechen.',
      'Ich wünschte, ich konnte besser Deutsch sprechen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ich wünschte" (Konjunktiv II) + Nebensatz mit Konjunktiv II: könnte.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Studenten, denen ich geholfen habe, haben bestanden.',
      'Die Studenten, die ich geholfen habe, haben bestanden.',
      'Die Studenten, den ich geholfen habe, haben bestanden.',
      'Die Studenten, deren ich geholfen habe, haben bestanden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Helfen" + Dativ Plural: denen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich daran gewöhnt, früh aufzustehen.',
      'Er hat sich daran gewöhnt, früh aufstehen.',
      'Er hat sich daran gewöhnt, früh zu aufstehen.',
      'Er hat sich daran gewöhnt, früh aufgestehen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht "zu" zwischen Vorsilbe und Verbstamm: aufzustehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Am Wochenende möchte ich gern ins Kino gehen.',
      'Am Wochenende ich möchte gern ins Kino gehen.',
      'Am Wochenende möchte gern ich ins Kino gehen.',
      'Am Wochenende gern möchte ich ins Kino gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporale Angabe an Position 1, dann Verb (möchte), dann Subjekt (Inversion).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut des Berichts ist die Lage stabil.',
      'Laut dem Bericht ist die Lage stabil.',
      'Laut den Bericht ist die Lage stabil.',
      'Sowohl A als auch B sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': '"Laut" kann sowohl mit Genitiv (laut des Berichts) als auch mit Dativ (laut dem Bericht) stehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vor Freude strahlend nahm sie das Geschenk an.',
      'Vor Freude gestrahlt nahm sie das Geschenk an.',
      'Vor Freude strahlen nahm sie das Geschenk an.',
      'Vor Freude gestrahlend nahm sie das Geschenk an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als adverbiale Bestimmung (gleichzeitig): strahlend.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie sagte, sie habe keine Zeit.',
      'Sie sagte, sie hat keine Zeit.',
      'Sie sagte, sie hätte keine Zeit.',
      'Sie sagte, sie haben keine Zeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede mit Konjunktiv I: sie habe.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Ergebnis wird morgen bekannt gegeben werden.',
      'Das Ergebnis wird morgen bekannt geben werden.',
      'Das Ergebnis wird morgen bekannt gegeben worden.',
      'Das Ergebnis wird morgen bekannt gegeben wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I Passiv: wird + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie bat ihn, das Fenster zuzumachen.',
      'Sie bat ihn, das Fenster zu zumachen.',
      'Sie bat ihn, das Fenster zumachen.',
      'Sie bat ihn, das Fenster zugemacht zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb "zumachen" + "zu": zuzumachen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nie zuvor hatte er so etwas Schönes gesehen.',
      'Nie zuvor er hatte so etwas Schönes gesehen.',
      'Nie zuvor hatte er gesehen so etwas Schönes.',
      'Nie zuvor so etwas Schönes hatte er gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nie zuvor" an Position 1 bewirkt Inversion: hatte er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Solange du hier bist, fühle ich mich sicher.',
      'Solange du hier bist, ich fühle mich sicher.',
      'Solange bist du hier, fühle ich mich sicher.',
      'Solange du bist hier, fühle ich mich sicher.'
    ],
    'correctAnswer': 0,
    'explanation': '"Solange" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angesichts der aktuellen Lage müssen wir handeln.',
      'Angesichts die aktuelle Lage müssen wir handeln.',
      'Angesichts dem aktuellen Lage müssen wir handeln.',
      'Angesichts den aktuellen Lage müssen wir handeln.'
    ],
    'correctAnswer': 0,
    'explanation': '"Angesichts" verlangt den Genitiv: angesichts der aktuellen Lage.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erschöpft von der Arbeit, legte er sich hin.',
      'Erschöpfend von der Arbeit, legte er sich hin.',
      'Erschöpfen von der Arbeit, legte er sich hin.',
      'Erschöpfet von der Arbeit, legte er sich hin.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung (Zustand): erschöpft.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wäre besser, wenn du früher kämest.',
      'Es wäre besser, wenn du früher kommst.',
      'Es wäre besser, wenn du früher kamst.',
      'Es wäre besser, wenn du früher kommen würdest.'
    ],
    'correctAnswer': 3,
    'explanation': 'In der modernen Sprache bevorzugt man "würde + Infinitiv" statt der veralteten Form "kämest".',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Patient wurde gestern operiert.',
      'Der Patient wurde gestern operieren.',
      'Der Patient worden gestern operiert.',
      'Der Patient wird gestern operiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (operiert).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Firma, für die er arbeitet, ist international bekannt.',
      'Die Firma, für der er arbeitet, ist international bekannt.',
      'Die Firma, für dessen er arbeitet, ist international bekannt.',
      'Die Firma, für den er arbeitet, ist international bekannt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Für" + Akkusativ feminin: für die (die Firma).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Kind pflegt jeden Abend ein Buch zu lesen.',
      'Das Kind pflegt jeden Abend ein Buch lesen.',
      'Das Kind pflegt jeden Abend ein Buch gelesen zu.',
      'Das Kind pflegt jeden Abend ein Buch lesen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Pflegen" + "zu" + Infinitiv drückt eine Gewohnheit aus: pflegt zu lesen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter keinen Umständen darf man hier rauchen.',
      'Unter keinen Umständen man darf hier rauchen.',
      'Unter keinen Umständen darf hier man rauchen.',
      'Unter keinen Umständen hier darf man rauchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Negativer Ausdruck an Position 1 erfordert Inversion: darf man.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bevor du gehst, räum bitte dein Zimmer auf.',
      'Bevor du gehst, aufräum bitte dein Zimmer.',
      'Bevor gehst du, räum bitte dein Zimmer auf.',
      'Bevor du gehst, dein Zimmer räum bitte auf.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bevor" leitet einen Nebensatz ein (Verb am Ende). Im Hauptsatz: Imperativ (räum ... auf).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie interessiert sich für den neuen Film.',
      'Sie interessiert sich für dem neuen Film.',
      'Sie interessiert sich für der neue Film.',
      'Sie interessiert sich für des neuen Films.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich interessieren für" + Akkusativ: für den neuen Film.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die am schnellsten wachsende Stadt Europas ist Istanbul.',
      'Die am schnellsten gewachsene Stadt Europas ist Istanbul.',
      'Die am schnellsten wachsend Stadt Europas ist Istanbul.',
      'Die am schnellsten wachsene Stadt Europas ist Istanbul.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv (aktiv, gleichzeitig): wachsende Stadt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sieht so aus, als würde es gleich regnen.',
      'Es sieht so aus, als es gleich regnet.',
      'Es sieht so aus, als regnet es gleich.',
      'Es sieht so aus, als wird es gleich regnen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Als" (ohne "ob") + Konjunktiv II mit Inversion: als würde es regnen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p2-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Waren werden per Schiff transportiert.',
      'Die Waren werden per Schiff transportieren.',
      'Die Waren wird per Schiff transportiert.',
      'Die Waren werden per Schiff transportieret.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv Plural: werden + Partizip II (transportiert).',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
