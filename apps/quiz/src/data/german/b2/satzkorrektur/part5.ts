import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich ihn gefragt hätte, hätte er mir geholfen.',
      'Wenn ich ihn gefragt habe, hätte er mir geholfen.',
      'Wenn ich ihn gefragt hätte, hat er mir geholfen.',
      'Wenn ich ihn fragte, hätte er mir geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Vergangenheitssatz: hätte gefragt → hätte geholfen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kollegin, auf deren Hilfe ich zähle, ist im Urlaub.',
      'Die Kollegin, auf dessen Hilfe ich zähle, ist im Urlaub.',
      'Die Kollegin, auf derer Hilfe ich zähle, ist im Urlaub.',
      'Die Kollegin, auf die Hilfe ich zähle, ist im Urlaub.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv feminin: deren (die Kollegin → deren Hilfe).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er versuchte, sie zu überzeugen.',
      'Er versuchte, sie überzeugen.',
      'Er versuchte, sie zu überzeugend.',
      'Er versuchte, sie überzeugt zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitiv mit "zu" bei nicht-trennbaren Verben: zu überzeugen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst als er aufstand, bemerkte er den Fehler.',
      'Erst als er aufstand, er bemerkte den Fehler.',
      'Erst als aufstand er, bemerkte er den Fehler.',
      'Erst als er stand auf, bemerkte er den Fehler.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz steht das Verb am Ende (trennbare Verben zusammen). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sofern nichts dazwischenkommt, treffen wir uns um acht.',
      'Sofern nichts dazwischenkommt, wir treffen uns um acht.',
      'Sofern dazwischenkommt nichts, treffen wir uns um acht.',
      'Sofern nichts kommt dazwischen, treffen wir uns um acht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sofern" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie schmeichelt ihrem Mann mit netten Worten.',
      'Sie schmeichelt ihren Mann mit netten Worten.',
      'Sie schmeichelt ihr Mann mit netten Worten.',
      'Sie schmeichelt ihres Mannes mit netten Worten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Schmeicheln" verlangt den Dativ: ihrem Mann.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die sorgfältig ausgewählten Materialien sind hochwertig.',
      'Die sorgfältig auswählende Materialien sind hochwertig.',
      'Die sorgfältig ausgewählt Materialien sind hochwertig.',
      'Die sorgfältig ausgewählte Materialien sind hochwertig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II Plural als Adjektiv: ausgewählten (die ausgewählten Materialien).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Sprecher betonte, dies sei eine wichtige Entscheidung.',
      'Der Sprecher betonte, dies ist eine wichtige Entscheidung.',
      'Der Sprecher betonte, dies war eine wichtige Entscheidung.',
      'Der Sprecher betonte, dies wäre eine wichtige Entscheidung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I: dies sei.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Projekt soll bis Ende des Monats abgeschlossen werden.',
      'Das Projekt soll bis Ende des Monats abgeschlossen wird.',
      'Das Projekt soll bis Ende des Monats abschließen werden.',
      'Das Projekt soll bis Ende des Monats abgeschlossen geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: soll + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Autor, dessen Bücher weltweit bekannt sind, lebt in Berlin.',
      'Der Autor, deren Bücher weltweit bekannt sind, lebt in Berlin.',
      'Der Autor, dem Bücher weltweit bekannt sind, lebt in Berlin.',
      'Der Autor, wessen Bücher weltweit bekannt sind, lebt in Berlin.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv maskulin: dessen (der Autor → dessen Bücher).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gibt vor, alles zu wissen.',
      'Er gibt vor, alles wissen.',
      'Er gibt vor, alles gewusst zu.',
      'Er gibt vor, alles zu gewusst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vorgeben" + "zu" + Infinitiv: gibt vor, zu wissen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Keineswegs bin ich damit einverstanden.',
      'Keineswegs ich bin damit einverstanden.',
      'Keineswegs bin damit ich einverstanden.',
      'Keineswegs damit bin ich einverstanden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Keineswegs" an Position 1 erfordert Inversion: bin ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gleichgültig, ob er kommt oder nicht, die Feier findet statt.',
      'Gleichgültig, ob er kommt oder nicht, findet die Feier statt.',
      'Gleichgültig ob er kommt oder nicht die Feier findet statt.',
      'Gleichgültig, ob kommt er oder nicht, die Feier findet statt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gleichgültig, ob ..." als eingeschobener Ausdruck. Der Hauptsatz behält seine Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zugunsten der Umwelt sollten wir weniger Auto fahren.',
      'Zugunsten die Umwelt sollten wir weniger Auto fahren.',
      'Zugunsten dem Umwelt sollten wir weniger Auto fahren.',
      'Zugunsten den Umwelt sollten wir weniger Auto fahren.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zugunsten" verlangt den Genitiv: zugunsten der Umwelt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gut gelaunt betrat er das Büro.',
      'Gut gelaunend betrat er das Büro.',
      'Gut gelaunen betrat er das Büro.',
      'Gut gelaunt er betrat das Büro.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung: gut gelaunt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, du hättest eine Million Euro, was würdest du tun?',
      'Angenommen, du hast eine Million Euro, was würdest du tun?',
      'Angenommen, du hättest eine Million Euro, was tust du?',
      'Angenommen, du hattest eine Million Euro, was würdest du tun?'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: hättest (Konjunktiv II) + würdest tun.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Über dieses Thema wird viel diskutiert.',
      'Über dieses Thema werden viel diskutiert.',
      'Über dieses Thema wird viel diskutieren.',
      'Über dieses Thema wird viel diskutieret.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unpersönliches Passiv mit Präpositionalergänzung: wird diskutiert.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Länder, in denen Deutsch gesprochen wird, liegen in Mitteleuropa.',
      'Die Länder, in die Deutsch gesprochen wird, liegen in Mitteleuropa.',
      'Die Länder, in den Deutsch gesprochen wird, liegen in Mitteleuropa.',
      'Die Länder, in dessen Deutsch gesprochen wird, liegen in Mitteleuropa.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wo? → Dativ Plural: in denen (in den Ländern).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es ist wichtig, regelmäßig Sport zu treiben.',
      'Es ist wichtig, regelmäßig Sport treiben.',
      'Es ist wichtig, regelmäßig Sport zu getrieben.',
      'Es ist wichtig, regelmäßig Sport treiben zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es ist wichtig" + Infinitiv mit "zu": zu treiben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So sehr er sich auch bemühte, es gelang ihm nicht.',
      'So sehr er sich auch bemühte, gelang es ihm nicht.',
      'So sehr auch bemühte er sich, es gelang ihm nicht.',
      'So sehr sich er auch bemühte, es gelang ihm nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"So sehr ... auch" als konzessiver Nebensatz. Der Hauptsatz behält die Grundstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kaum dass er angekommen war, klingelte das Telefon.',
      'Kaum dass er angekommen war, das Telefon klingelte.',
      'Kaum dass angekommen er war, klingelte das Telefon.',
      'Kaum dass er war angekommen, klingelte das Telefon.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kaum dass" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hinsichtlich der Kosten müssen wir noch verhandeln.',
      'Hinsichtlich die Kosten müssen wir noch verhandeln.',
      'Hinsichtlich den Kosten müssen wir noch verhandeln.',
      'Hinsichtlich dem Kosten müssen wir noch verhandeln.'
    ],
    'correctAnswer': 0,
    'explanation': '"Hinsichtlich" verlangt den Genitiv: hinsichtlich der Kosten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die von allen geliebte Lehrerin ging in Rente.',
      'Die von allen liebende Lehrerin ging in Rente.',
      'Die von allen geliebt Lehrerin ging in Rente.',
      'Die von allen geliebende Lehrerin ging in Rente.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv (passiv): geliebte (die geliebte Lehrerin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wäre mir lieb, wenn Sie mir Bescheid geben könnten.',
      'Es wäre mir lieb, wenn Sie mir Bescheid geben können.',
      'Es wäre mir lieb, wenn Sie mir Bescheid geben konnten.',
      'Es ist mir lieb, wenn Sie mir Bescheid geben könnten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Höfliche Bitte: wäre + wenn + Konjunktiv II: könnten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Entscheidung wird von der Geschäftsleitung getroffen.',
      'Die Entscheidung wird von die Geschäftsleitung getroffen.',
      'Die Entscheidung wird von der Geschäftsleitung treffen.',
      'Die Entscheidung werden von der Geschäftsleitung getroffen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II. "Von" + Dativ: von der Geschäftsleitung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Art und Weise, wie er spricht, gefällt mir.',
      'Die Art und Weise, welche er spricht, gefällt mir.',
      'Die Art und Weise, die er spricht, gefällt mir.',
      'Die Art und Weise, dass er spricht, gefällt mir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "Art und Weise" steht das Relativadverb "wie".',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Fehler ist leicht zu beheben.',
      'Der Fehler ist leicht zu behoben.',
      'Der Fehler ist leicht beheben.',
      'Der Fehler ist leicht behoben zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sein" + "zu" + Infinitiv drückt eine passive Möglichkeit aus: ist zu beheben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nur selten besucht sie ihre Großeltern.',
      'Nur selten sie besucht ihre Großeltern.',
      'Nur selten besucht ihre Großeltern sie.',
      'Nur selten ihre Großeltern besucht sie.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nur selten" an Position 1 erfordert Inversion: besucht sie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ehe du gehst, solltest du dich verabschieden.',
      'Ehe du gehst, du solltest dich verabschieden.',
      'Ehe gehst du, solltest du dich verabschieden.',
      'Ehe du gehst, verabschieden du solltest dich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ehe" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bezüglich Ihres Antrags möchte ich Sie informieren.',
      'Bezüglich Ihren Antrag möchte ich Sie informieren.',
      'Bezüglich Ihrem Antrag möchte ich Sie informieren.',
      'Bezüglich Ihr Antrag möchte ich Sie informieren.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bezüglich" verlangt den Genitiv: bezüglich Ihres Antrags.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der dringend zu reparierende Wasserhahn tropft seit Tagen.',
      'Der dringend zu reparierte Wasserhahn tropft seit Tagen.',
      'Der dringend reparierende Wasserhahn tropft seit Tagen.',
      'Der dringend zu reparieren Wasserhahn tropft seit Tagen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu + Partizip I + Endung: der zu reparierende Wasserhahn.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie wäre es, wenn wir zusammen essen gingen?',
      'Wie wäre es, wenn wir zusammen essen gehen?',
      'Wie ist es, wenn wir zusammen essen gingen?',
      'Wie wäre es, wenn wir zusammen essen gehen würden?'
    ],
    'correctAnswer': 0,
    'explanation': 'Höflicher Vorschlag: Wie wäre es, wenn + Konjunktiv II: gingen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Antrag konnte leider nicht genehmigt werden.',
      'Der Antrag konnte leider nicht genehmigt wird.',
      'Der Antrag konnte leider nicht genehmigen werden.',
      'Der Antrag konnte leider nicht genehmigt geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb Präteritum + Passiv: konnte + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es vermieden, darüber zu sprechen.',
      'Er hat es vermieden, darüber sprechen.',
      'Er hat es vermieden, darüber gesprochen zu.',
      'Er hat es vermieden, darüber zu gesprochen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vermeiden" + Infinitiv mit "zu": zu sprechen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Umso wichtiger ist es, dass wir zusammenarbeiten.',
      'Umso wichtiger es ist, dass wir zusammenarbeiten.',
      'Umso wichtiger ist dass es, wir zusammenarbeiten.',
      'Umso es wichtiger ist, dass wir zusammenarbeiten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Umso wichtiger" an Position 1 erfordert Inversion: ist es.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob er kommt oder nicht, wissen wir noch nicht.',
      'Ob er kommt oder nicht, wir wissen noch nicht.',
      'Ob kommt er oder nicht, wissen wir noch nicht.',
      'Ob er oder nicht kommt, wissen wir noch nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ob" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet der Schwierigkeiten setzte er seine Arbeit fort.',
      'Ungeachtet die Schwierigkeiten setzte er seine Arbeit fort.',
      'Ungeachtet den Schwierigkeiten setzte er seine Arbeit fort.',
      'Ungeachtet dem Schwierigkeiten setzte er seine Arbeit fort.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ungeachtet" verlangt den Genitiv: ungeachtet der Schwierigkeiten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Tief bewegt dankte er seinen Unterstützern.',
      'Tief bewegend dankte er seinen Unterstützern.',
      'Tief bewegen dankte er seinen Unterstützern.',
      'Tief bewegte dankte er seinen Unterstützern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung (Zustand): tief bewegt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie sieht aus, als ob sie die ganze Nacht nicht geschlafen hätte.',
      'Sie sieht aus, als ob sie die ganze Nacht nicht geschlafen hat.',
      'Sie sieht aus, als ob sie die ganze Nacht nicht schlafen hätte.',
      'Sie sieht aus, als ob sie die ganze Nacht nicht geschlafen hatte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Als ob" + Konjunktiv II Vergangenheit: hätte geschlafen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dieses Lied wird oft im Radio gespielt.',
      'Dieses Lied wird oft im Radio spielen.',
      'Dieses Lied werden oft im Radio gespielt.',
      'Dieses Lied wird oft im Radio gespielen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II (gespielt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kolleginnen, mit denen ich zusammenarbeite, sind sehr nett.',
      'Die Kolleginnen, mit die ich zusammenarbeite, sind sehr nett.',
      'Die Kolleginnen, mit den ich zusammenarbeite, sind sehr nett.',
      'Die Kolleginnen, mit deren ich zusammenarbeite, sind sehr nett.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mit" + Dativ Plural: mit denen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er scheint die Wahrheit gesagt zu haben.',
      'Er scheint die Wahrheit gesagt haben.',
      'Er scheint die Wahrheit zu gesagt haben.',
      'Er scheint die Wahrheit gesagt zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Scheinen" + Infinitiv Perfekt: gesagt zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Daran, dass er lügt, habe ich keinen Zweifel.',
      'Daran, dass er lügt, ich habe keinen Zweifel.',
      'Daran, dass lügt er, habe ich keinen Zweifel.',
      'Daran dass er lügt habe ich keinen Zweifel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nebensatz mit "dass" (Verb am Ende). Hauptsatz: Verb an Position 1 nach dem Nebensatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abgesehen davon, dass er zu spät kam, war alles in Ordnung.',
      'Abgesehen davon, dass er zu spät kam, alles war in Ordnung.',
      'Abgesehen davon, dass er kam zu spät, war alles in Ordnung.',
      'Abgesehen davon, dass zu spät er kam, war alles in Ordnung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Abgesehen davon, dass" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mangels ausreichender Beweise wurde er freigesprochen.',
      'Mangels ausreichende Beweise wurde er freigesprochen.',
      'Mangels ausreichenden Beweisen wurde er freigesprochen.',
      'Mangels ausreichend Beweise wurde er freigesprochen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mangels" verlangt den Genitiv: mangels ausreichender Beweise.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Offen gesagt, finde ich die Idee nicht gut.',
      'Offen sagend, finde ich die Idee nicht gut.',
      'Offen gesagen, finde ich die Idee nicht gut.',
      'Offen zu sagen, finde ich die Idee nicht gut.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: offen gesagt (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn es nach mir ginge, würden wir sofort abreisen.',
      'Wenn es nach mir geht, würden wir sofort abreisen.',
      'Wenn es nach mir ginge, werden wir sofort abreisen.',
      'Wenn es nach mir ging, würden wir sofort abreisen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: ginge (Konjunktiv II) + würden abreisen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p5-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Prüfung hätte besser vorbereitet werden müssen.',
      'Die Prüfung hätte besser vorbereitet werden gemusst.',
      'Die Prüfung hätte besser vorbereitet geworden müssen.',
      'Die Prüfung hätte besser vorbereiten werden müssen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit Passiv + Modalverb: hätte + Partizip II + werden + Infinitiv Modalverb.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
