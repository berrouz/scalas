import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich wollte, ich wäre jünger.',
      'Ich wollte, ich bin jünger.',
      'Ich wollte, ich sei jünger.',
      'Ich wollte, ich war jünger.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wunschsatz: "Ich wollte" (Konjunktiv II) + Konjunktiv II im Nebensatz: wäre.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vertrag wurde gestern unterschrieben.',
      'Der Vertrag wurde gestern unterschreiben.',
      'Der Vertrag worden gestern unterschrieben.',
      'Der Vertrag wurde gestern unterschriebt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (unterschrieben).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist das Beste, was mir je passiert ist.',
      'Das ist das Beste, das mir je passiert ist.',
      'Das ist das Beste, dass mir je passiert ist.',
      'Das ist das Beste, welches mir je passiert ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Superlativ (das Beste) steht das Relativpronomen "was".',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Auto reparieren lassen.',
      'Er hat das Auto repariert lassen.',
      'Er hat das Auto reparieren gelassen.',
      'Er hat das Auto zu reparieren lassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Lassen" im Perfekt mit Ersatzinfinitiv: hat reparieren lassen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hätte er doch nur besser aufgepasst!',
      'Hätte doch er nur besser aufgepasst!',
      'Hätte er doch nur aufgepasst besser!',
      'Er hätte doch nur besser aufgepasst!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunschsatz ohne "wenn": Verb an Position 1 + "doch nur": Hätte er doch nur ...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je länger man wartet, desto schwieriger wird es.',
      'Je länger man wartet, desto schwieriger es wird.',
      'Je länger wartet man, desto schwieriger wird es.',
      'Je man länger wartet, desto schwieriger wird es.'
    ],
    'correctAnswer': 0,
    'explanation': '"Je ... desto": Im je-Satz Verb am Ende, im desto-Satz Verb nach dem Komparativ.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie begegnete ihrem ehemaligen Professor.',
      'Sie begegnete ihren ehemaligen Professor.',
      'Sie begegnete ihr ehemaliger Professor.',
      'Sie begegnete ihres ehemaligen Professors.'
    ],
    'correctAnswer': 0,
    'explanation': '"Begegnen" verlangt den Dativ: ihrem ehemaligen Professor.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die neu eingestellten Mitarbeiter müssen geschult werden.',
      'Die neu einstellende Mitarbeiter müssen geschult werden.',
      'Die neu eingestellt Mitarbeiter müssen geschult werden.',
      'Die neu eingestellte Mitarbeiter müssen geschult werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II Plural als Adjektiv: eingestellten (die eingestellten Mitarbeiter).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er meinte, er wisse nicht, worum es gehe.',
      'Er meinte, er weiß nicht, worum es geht.',
      'Er meinte, er wüsste nicht, worum es ginge.',
      'Er meinte, er wissen nicht, worum es gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I: er wisse, es gehe.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bäume werden im Herbst gefällt.',
      'Die Bäume werden im Herbst fällen.',
      'Die Bäume wird im Herbst gefällt.',
      'Die Bäume werden im Herbst gefället.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv Plural: werden + Partizip II (gefällt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Arzt, bei dem ich war, hat mir Tabletten verschrieben.',
      'Der Arzt, bei den ich war, hat mir Tabletten verschrieben.',
      'Der Arzt, bei der ich war, hat mir Tabletten verschrieben.',
      'Der Arzt, bei wem ich war, hat mir Tabletten verschrieben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bei" + Dativ maskulin: bei dem (bei dem Arzt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat den ganzen Tag nichts gegessen gehabt.',
      'Sie hatte den ganzen Tag nichts gegessen.',
      'Sie hat den ganzen Tag nichts gegesst.',
      'Sie hatte den ganzen Tag nichts essen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Plusquamperfekt: hatte + Partizip II (gegessen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auch wenn er müde ist, arbeitet er weiter.',
      'Auch wenn er müde ist, er arbeitet weiter.',
      'Auch wenn müde er ist, arbeitet er weiter.',
      'Auch wenn er ist müde, arbeitet er weiter.'
    ],
    'correctAnswer': 0,
    'explanation': '"Auch wenn" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sei es, dass er krank ist, sei es, dass er keine Lust hat.',
      'Sei es, dass er krank ist, sei es, er keine Lust hat.',
      'Sei es, dass er ist krank, sei es, dass er hat keine Lust.',
      'Sei es, dass krank er ist, sei es, dass keine Lust er hat.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sei es, dass ... sei es, dass ...": Konjunktiv I + Nebensatz (Verb am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist sich seiner Fehler bewusst.',
      'Er ist sich seine Fehler bewusst.',
      'Er ist sich seinen Fehlern bewusst.',
      'Er ist sich sein Fehler bewusst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich bewusst sein" + Genitiv: seiner Fehler.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die zu erledigenden Aufgaben sind auf der Liste.',
      'Die zu erledigte Aufgaben sind auf der Liste.',
      'Die erledigenden Aufgaben sind auf der Liste.',
      'Die zu erledigen Aufgaben sind auf der Liste.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu + Partizip I + Endung: die zu erledigenden Aufgaben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wäre schön, wenn du mich besuchen würdest.',
      'Es wäre schön, wenn du mich besuchen wirst.',
      'Es wäre schön, wenn du mich besuchst.',
      'Es wäre schön, wenn du mich besuchen wurdest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunschsatz: wäre + wenn + Konjunktiv II: würdest besuchen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Kuchen ist schon gebacken.',
      'Der Kuchen ist schon gebacken worden.',
      'Der Kuchen wurde schon gebacken.',
      'Sowohl B als auch C sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Perfekt Passiv (ist gebacken worden) und Präteritum Passiv (wurde gebacken) sind beide korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Gründe, aus denen er gekündigt hat, sind unklar.',
      'Die Gründe, aus die er gekündigt hat, sind unklar.',
      'Die Gründe, aus dessen er gekündigt hat, sind unklar.',
      'Die Gründe, aus den er gekündigt hat, sind unklar.'
    ],
    'correctAnswer': 0,
    'explanation': '"Aus" + Dativ Plural: aus denen (die Gründe → aus denen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dieses Buch ist lesenswert.',
      'Dieses Buch ist zu lesen wert.',
      'Dieses Buch ist lesenwert.',
      'Dieses Buch ist zu lesenswert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zusammengesetztes Adjektiv: lesenswert (lesen + s + wert).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So schnell er auch lief, er konnte den Bus nicht mehr erreichen.',
      'So schnell er auch lief, konnte er den Bus nicht mehr erreichen.',
      'So schnell auch lief er, konnte er den Bus nicht mehr erreichen.',
      'So schnell er lief auch, konnte er den Bus nicht mehr erreichen.'
    ],
    'correctAnswer': 0,
    'explanation': '"So ... auch" als konzessiver Nebensatz. Der Hauptsatz behält die normale Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstatt zu lernen, spielte er Computerspiele.',
      'Anstatt lernen, spielte er Computerspiele.',
      'Anstatt zu lernen, er spielte Computerspiele.',
      'Anstatt gelernt, spielte er Computerspiele.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anstatt" + "zu" + Infinitiv: anstatt zu lernen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man beschuldigt ihn des Diebstahls.',
      'Man beschuldigt ihm des Diebstahls.',
      'Man beschuldigt ihn den Diebstahl.',
      'Man beschuldigt ihn dem Diebstahl.'
    ],
    'correctAnswer': 0,
    'explanation': '"Beschuldigen" + Akkusativ (Person) + Genitiv (Sache): ihn des Diebstahls.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entsprechend vorbereitet ging sie in die Prüfung.',
      'Entsprechend vorbereitend ging sie in die Prüfung.',
      'Entsprechend vorbereiten ging sie in die Prüfung.',
      'Entsprechend vorbereitete ging sie in die Prüfung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung: entsprechend vorbereitet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie tat so, als hätte sie mich nicht gesehen.',
      'Sie tat so, als hat sie mich nicht gesehen.',
      'Sie tat so, als sie mich nicht gesehen hätte.',
      'Sie tat so, als hatte sie mich nicht gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Als" (ohne "ob") + Konjunktiv II mit Inversion: als hätte sie ... gesehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es muss noch viel getan werden.',
      'Es muss noch viel getan wird.',
      'Es muss noch viel tun werden.',
      'Es muss noch viel getan geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: muss + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Film, den wir gesehen haben, war langweilig.',
      'Der Film, der wir gesehen haben, war langweilig.',
      'Der Film, dem wir gesehen haben, war langweilig.',
      'Der Film, das wir gesehen haben, war langweilig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sehen" + Akkusativ maskulin: den (den Film sehen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er pflegt sonntags lange zu schlafen.',
      'Er pflegt sonntags lange schlafen.',
      'Er pflegt sonntags lange geschlafen zu.',
      'Er pflegt sonntags lange zu geschlafen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Pflegen" + "zu" + Infinitiv: pflegt zu schlafen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausgesetzt, dass alle kommen, beginnen wir pünktlich.',
      'Vorausgesetzt, dass alle kommen, wir beginnen pünktlich.',
      'Vorausgesetzt, dass kommen alle, beginnen wir pünktlich.',
      'Vorausgesetzt, alle dass kommen, beginnen wir pünktlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vorausgesetzt, dass" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aufgrund des starken Verkehrs verspätete sich der Bus.',
      'Aufgrund dem starken Verkehr verspätete sich der Bus.',
      'Aufgrund den starken Verkehr verspätete sich der Bus.',
      'Aufgrund der starke Verkehr verspätete sich der Bus.'
    ],
    'correctAnswer': 0,
    'explanation': '"Aufgrund" verlangt den Genitiv: aufgrund des starken Verkehrs.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die seit Monaten leer stehende Wohnung wurde endlich vermietet.',
      'Die seit Monaten leer gestandene Wohnung wurde endlich vermietet.',
      'Die seit Monaten leer stehend Wohnung wurde endlich vermietet.',
      'Die seit Monaten leer gestanden Wohnung wurde endlich vermietet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv (gleichzeitig, aktiv): leer stehende Wohnung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich du wäre, würde ich den Job annehmen.',
      'Wenn ich du bin, würde ich den Job annehmen.',
      'Wenn ich du wäre, werde ich den Job annehmen.',
      'Wenn ich du sei, würde ich den Job annehmen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: wäre + würde + Infinitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Essen wird gerade zubereitet.',
      'Das Essen wird gerade zubereiten.',
      'Das Essen werden gerade zubereitet.',
      'Das Essen wird gerade zubereitend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II (zubereitet).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie behauptet, die ganze Nacht durchgearbeitet zu haben.',
      'Sie behauptet, die ganze Nacht durchzuarbeiten haben.',
      'Sie behauptet, die ganze Nacht durchgearbeitet haben.',
      'Sie behauptet, die ganze Nacht zu durchgearbeitet haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitiv Perfekt: Partizip II + zu haben: durchgearbeitet zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Niemals hätte ich das gedacht.',
      'Niemals ich hätte das gedacht.',
      'Niemals hätte das ich gedacht.',
      'Niemals gedacht hätte ich das.'
    ],
    'correctAnswer': 0,
    'explanation': '"Niemals" an Position 1 erfordert Inversion: hätte ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insofern er recht hat, sollten wir ihm zuhören.',
      'Insofern hat er recht, sollten wir ihm zuhören.',
      'Insofern er hat recht, sollten wir ihm zuhören.',
      'Insofern recht er hat, sollten wir ihm zuhören.'
    ],
    'correctAnswer': 0,
    'explanation': '"Insofern" als Konjunktion leitet einen Nebensatz ein (Verb am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mithilfe eines erfahrenen Beraters lösten sie das Problem.',
      'Mithilfe einem erfahrenen Berater lösten sie das Problem.',
      'Mithilfe einen erfahrenen Berater lösten sie das Problem.',
      'Mithilfe ein erfahrener Berater lösten sie das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mithilfe" verlangt den Genitiv: mithilfe eines erfahrenen Beraters.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausgesetzt, dass alles klappt, reisen wir morgen ab.',
      'Vorausgesehen, dass alles klappt, reisen wir morgen ab.',
      'Voraussetzend, dass alles klappt, reisen wir morgen ab.',
      'Vorausgesetzen, dass alles klappt, reisen wir morgen ab.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: vorausgesetzt (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man sagt, die Firma habe Insolvenz angemeldet.',
      'Man sagt, die Firma hat Insolvenz angemeldet.',
      'Man sagt, die Firma hatte Insolvenz angemeldet.',
      'Man sagt, die Firma hätte Insolvenz angemeldet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Perfekt: habe ... angemeldet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Den Verletzten wurde sofort geholfen.',
      'Die Verletzten wurden sofort geholfen.',
      'Den Verletzten wurde sofort helfen.',
      'Den Verletzten worden sofort geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Helfen" + Dativ → Passiv mit Dativ: Den Verletzten wurde geholfen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe nichts, worauf ich mich freuen kann.',
      'Ich habe nichts, auf das ich mich freuen kann.',
      'Ich habe nichts, darauf ich mich freuen kann.',
      'Sowohl A als auch B sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Nach "nichts" kann man "worauf" oder "auf das" verwenden. Beide sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich das Bein gebrochen.',
      'Er hat sich das Bein gebrocht.',
      'Er ist sich das Bein gebrochen.',
      'Er hat sich das Bein brechen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt von "sich das Bein brechen": hat + sich + Partizip II (gebrochen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich fragte ihn, warum er so spät gekommen sei.',
      'Ich fragte ihn, warum sei er so spät gekommen.',
      'Ich fragte ihn, warum er so spät sei gekommen.',
      'Ich fragte ihn, warum er sei so spät gekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekter Fragesatz: Verb am Ende: warum er so spät gekommen sei.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht dass ich wüsste!',
      'Nicht dass ich weiß!',
      'Nicht das ich wüsste!',
      'Nicht dass wüsste ich!'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Wendung: "Nicht dass ich wüsste" (Konjunktiv II, Verb am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einmal angefangen, konnte er nicht mehr aufhören.',
      'Einmal anfangend, konnte er nicht mehr aufhören.',
      'Einmal angefangt, konnte er nicht mehr aufhören.',
      'Einmal angefangen, er konnte nicht mehr aufhören.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung: einmal angefangen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Beinahe hätte ich den Zug verpasst.',
      'Beinahe habe ich den Zug verpasst.',
      'Beinahe hätte ich den Zug verpassen.',
      'Beinahe würde ich den Zug verpasst haben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Beinahe" + Konjunktiv II Plusquamperfekt: hätte ... verpasst (etwas, das fast passiert wäre).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p4-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Regeln sollten eingehalten werden.',
      'Die Regeln sollten eingehalten wird.',
      'Die Regeln sollten einhalten werden.',
      'Die Regeln sollten eingehalten geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb Konjunktiv II + Passiv: sollten + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
