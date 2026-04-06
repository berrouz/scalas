import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Lied wunderbar gesungen.',
      'Er hat das Lied wunderbar gesingt.',
      'Er hat das Lied wunderbar singte.',
      'Er hat das Lied wunderbar singen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II von \'singen\' ist \'gesungen\' (starkes Verb mit Vokalwechsel i-a-u).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich gratuliere dir zum Geburtstag.',
      'Ich gratuliere dich zum Geburtstag.',
      'Ich gratuliere dir bei Geburtstag.',
      'Ich gratuliere dich bei dem Geburtstag.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gratulieren\' verlangt den Dativ: dir. Die Präposition ist \'zu\' + Dativ: zum Geburtstag.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich möchte wissen, wo das Museum ist.',
      'Ich möchte wissen, wo ist das Museum.',
      'Ich möchte wissen, wo das Museum sein.',
      'Ich möchte wissen, wo ist Museum das.'
    ],
    'correctAnswer': 0,
    'explanation': 'In einer indirekten Frage steht das Verb am Ende des Nebensatzes: wo das Museum ist.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Arzt hat dem Patienten eine Tablette verschrieben.',
      'Der Arzt hat den Patienten eine Tablette verschrieben.',
      'Der Arzt hat dem Patient eine Tablette verschrieben.',
      'Der Arzt hat des Patienten eine Tablette verschrieben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Verschreiben\' verlangt Dativ (Person) + Akkusativ (Sache). \'Patient\' ist N-Deklination: dem Patienten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie träumt von einer Reise nach Japan.',
      'Sie träumt über eine Reise nach Japan.',
      'Sie träumt für eine Reise nach Japan.',
      'Sie träumt an einer Reise nach Japan.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Träumen von\' + Dativ ist die korrekte Verbindung: von einer Reise.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seitdem er in Berlin wohnt, fährt er oft Fahrrad.',
      'Seitdem er in Berlin wohnt, er fährt oft Fahrrad.',
      'Seitdem er wohnt in Berlin, fährt er oft Fahrrad.',
      'Seitdem in Berlin er wohnt, fährt er oft Fahrrad.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'seitdem\' steht das Verb am Ende. Im Hauptsatz danach steht das Verb auf Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Alle netten Kollegen waren auf der Feier.',
      'Alle nette Kollegen waren auf der Feier.',
      'Alle netter Kollegen waren auf der Feier.',
      'Allen netten Kollegen waren auf der Feier.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'alle\' im Nominativ Plural endet das Adjektiv auf -en: alle netten Kollegen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich werde nächstes Jahr in Spanien studieren.',
      'Ich werde nächstes Jahr in Spanien studiert.',
      'Ich werde nächstes Jahr in Spanien studierte.',
      'Ich wurde nächstes Jahr in Spanien studieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: werden + Infinitiv. \'Werden\' im Präsens: werde (für Zukunft).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich sehr über das Geschenk gefreut.',
      'Sie hat sich sehr über das Geschenk gefreuet.',
      'Sie hat sich sehr über das Geschenk freuen.',
      'Sie hat sich sehr über das Geschenk gefreuen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II von \'freuen\' ist \'gefreut\'. Reflexivpronomen \'sich\' bleibt erhalten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das gehört meiner Schwester.',
      'Das gehört meine Schwester.',
      'Das gehört meinen Schwester.',
      'Das gehört meines Schwester.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gehören\' verlangt den Dativ: meiner Schwester (feminin Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Heute habe ich leider keine Zeit.',
      'Heute ich habe leider keine Zeit.',
      'Heute habe leider ich keine Zeit.',
      'Heute keine Zeit habe ich leider.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Inversion (Zeitangabe am Anfang) steht das Verb auf Position 2: Heute habe ich...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe den langen Brief endlich gelesen.',
      'Ich habe der lange Brief endlich gelesen.',
      'Ich habe dem langen Brief endlich gelesen.',
      'Ich habe den langer Brief endlich gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Brief\' ist maskulin. Im Akkusativ mit bestimmtem Artikel: den langen Brief.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich an das Klima gewöhnt.',
      'Er hat sich auf das Klima gewöhnt.',
      'Er hat sich über das Klima gewöhnt.',
      'Er hat sich für das Klima gewöhnt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich gewöhnen an\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Damit er besser schläft, trinkt er abends Tee.',
      'Damit er besser schläft, er trinkt abends Tee.',
      'Damit er schläft besser, trinkt er abends Tee.',
      'Damit besser er schläft, trinkt er abends Tee.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'damit\' steht das Verb am Ende: damit er besser schläft. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat viele gute Freunde.',
      'Er hat viele guter Freunde.',
      'Er hat vielen guten Freunde.',
      'Er hat viele guten Freunde.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'viele\' im Akkusativ Plural folgt starke Deklination: viele gute Freunde.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hatte die Tür abgeschlossen, bevor er wegging.',
      'Er hat die Tür abgeschlossen, bevor er wegging.',
      'Er hatte die Tür abschloss, bevor er wegging.',
      'Er hätte die Tür abgeschlossen, bevor er wegging.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt (hatte + Partizip II) drückt eine Handlung vor einer anderen vergangenen Handlung aus.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Tür muss repariert werden.',
      'Die Tür muss repariert wird.',
      'Die Tür muss werden repariert.',
      'Die Tür muss reparieren werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv mit Modalverb: muss + Partizip II + werden. \'Werden\' steht am Ende als Infinitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wegen des starken Regens blieben wir zu Hause.',
      'Wegen dem starken Regen blieben wir zu Hause.',
      'Wegen der starke Regen blieben wir zu Hause.',
      'Wegen den starken Regen blieben wir zu Hause.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wegen\' verlangt den Genitiv: wegen des starken Regens.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich denke oft über meine Zukunft nach.',
      'Ich denke oft auf meine Zukunft nach.',
      'Ich denke oft für meine Zukunft nach.',
      'Ich denke oft von meine Zukunft nach.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Nachdenken über\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er kann leider heute nicht kommen, weil er arbeiten muss.',
      'Er kann leider heute nicht kommen, weil er muss arbeiten.',
      'Er kann leider heute nicht kommen, weil muss er arbeiten.',
      'Er kann leider heute kommen nicht, weil er arbeiten muss.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'weil\' steht das konjugierte Verb am Ende: weil er arbeiten muss.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie geht in die neue Bäckerei.',
      'Sie geht in der neuen Bäckerei.',
      'Sie geht in das neue Bäckerei.',
      'Sie geht in den neuen Bäckerei.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bäckerei\' ist feminin. \'In\' + Akkusativ bei Richtung (Wohin?): in die neue Bäckerei.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entweder fahren wir ans Meer oder wir bleiben zu Hause.',
      'Entweder fahren wir ans Meer oder bleiben wir zu Hause.',
      'Entweder wir fahren ans Meer oder wir bleiben zu Hause.',
      'Entweder fahren wir ans Meer oder zu Hause wir bleiben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Entweder ... oder\': Nach \'entweder\' kann Inversion stehen. \'Oder\' verbindet zwei Hauptsätze mit normaler Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist eine intelligente junge Frau.',
      'Sie ist eine intelligente junger Frau.',
      'Sie ist eine intelligenter junge Frau.',
      'Sie ist eine intelligenten junge Frau.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach unbestimmtem Artikel Nominativ feminin: eine intelligente junge Frau. Beide Adjektive enden auf -e.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Morgen um diese Zeit werde ich bereits im Flugzeug sitzen.',
      'Morgen um diese Zeit werde ich bereits im Flugzeug gesessen.',
      'Morgen um diese Zeit werde ich bereits im Flugzeug sitze.',
      'Morgen um diese Zeit wurde ich bereits im Flugzeug sitzen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I drückt eine zukünftige Handlung aus: werde + Infinitiv (sitzen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe vergessen, das Fenster zuzumachen.',
      'Ich habe vergessen, das Fenster zu zumachen.',
      'Ich habe vergessen, das Fenster zumachen.',
      'Ich habe vergessen, das Fenster zugemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: zuzumachen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich begegne oft meinem alten Lehrer im Park.',
      'Ich begegne oft meinen alten Lehrer im Park.',
      'Ich begegne oft mein alter Lehrer im Park.',
      'Ich begegne oft meines alten Lehrers im Park.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Begegnen\' verlangt den Dativ: meinem alten Lehrer.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie beschäftigt sich mit einem neuen Projekt.',
      'Sie beschäftigt sich an einem neuen Projekt.',
      'Sie beschäftigt sich über einem neuen Projekt.',
      'Sie beschäftigt sich für ein neues Projekt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich beschäftigen mit\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selten habe ich so ein schönes Bild gesehen.',
      'Selten ich habe so ein schönes Bild gesehen.',
      'Selten habe so ein schönes Bild ich gesehen.',
      'Selten ich so ein schönes Bild habe gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Adverb \'selten\' am Satzanfang folgt Inversion: habe ich...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hast du das rote Auto gesehen?',
      'Hast du der rote Auto gesehen?',
      'Hast du den roten Auto gesehen?',
      'Hast du die rote Auto gesehen?'
    ],
    'correctAnswer': 0,
    'explanation': '\'Auto\' ist Neutrum (das Auto). Im Akkusativ: das rote Auto.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem sie angekommen war, rief sie ihre Mutter an.',
      'Nachdem sie angekommen war, sie rief ihre Mutter an.',
      'Nachdem war sie angekommen, rief sie ihre Mutter an.',
      'Nachdem sie angekommen war, anrief sie ihre Mutter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'nachdem\' steht das Verb am Ende (Plusquamperfekt). Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist das Haus meiner verstorbenen Großmutter.',
      'Das ist das Haus meiner verstorbener Großmutter.',
      'Das ist das Haus meines verstorbenen Großmutter.',
      'Das ist das Haus meine verstorbene Großmutter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv feminin: meiner verstorbenen Großmutter. Nach Possessivartikel im Genitiv endet das Adjektiv auf -en.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe drei Jahre lang Deutsch gelernt.',
      'Ich habe drei Jahre lang Deutsch lernte.',
      'Ich bin drei Jahre lang Deutsch gelernt.',
      'Ich habe drei Jahre lang Deutsch gelearnt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Lernen\' bildet Perfekt mit \'haben\': habe gelernt. Partizip II: ge- + lernt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin heute früh aufgestanden.',
      'Ich habe heute früh aufgestanden.',
      'Ich bin heute früh aufgesteht.',
      'Ich bin heute früh aufstanden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Aufstehen\' bildet Perfekt mit \'sein\' (Zustandsänderung). Partizip II: aufgestanden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er widerspricht seinem Vater nie.',
      'Er widerspricht seinen Vater nie.',
      'Er widerspricht sein Vater nie.',
      'Er widerspricht seines Vaters nie.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Widersprechen\' verlangt den Dativ: seinem Vater.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin stolz auf meine Tochter.',
      'Ich bin stolz über meine Tochter.',
      'Ich bin stolz für meine Tochter.',
      'Ich bin stolz von meiner Tochter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Stolz auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Am Wochenende gehen wir oft ins Restaurant.',
      'Am Wochenende wir gehen oft ins Restaurant.',
      'Am Wochenende gehen oft wir ins Restaurant.',
      'Am Wochenende oft gehen wir ins Restaurant.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporale Angabe am Anfang: Verb auf Position 2, dann Subjekt: Am Wochenende gehen wir...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat mir einen guten Rat gegeben.',
      'Er hat mir ein guten Rat gegeben.',
      'Er hat mir einem guten Rat gegeben.',
      'Er hat mir einer guter Rat gegeben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Rat\' ist maskulin. \'Geben\' + Dativ (mir) + Akkusativ: einen guten Rat.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl er müde war, arbeitete er bis Mitternacht.',
      'Obwohl er müde war, er arbeitete bis Mitternacht.',
      'Obwohl war er müde, arbeitete er bis Mitternacht.',
      'Obwohl er war müde, arbeitete er bis Mitternacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'obwohl\' steht das Verb am Ende. Im Hauptsatz danach steht das Verb auf Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er kaufte frisches Obst auf dem Markt.',
      'Er kaufte frischer Obst auf dem Markt.',
      'Er kaufte frischem Obst auf dem Markt.',
      'Er kaufte frischen Obst auf dem Markt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Obst\' ist Neutrum. Akkusativ ohne Artikel (starke Deklination): frisches Obst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bevor er kam, hatten wir schon gegessen.',
      'Bevor er kam, haben wir schon gegessen.',
      'Bevor er kam, wir hatten schon gegessen.',
      'Bevor er kam, hatten wir schon essen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt (hatten gegessen) für die Vorzeitigkeit vor einer vergangenen Handlung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Kuchen wird von meiner Mutter gebacken.',
      'Der Kuchen wird von meiner Mutter backen.',
      'Der Kuchen wird von meiner Mutter gebackt.',
      'Der Kuchen ist von meiner Mutter gebacken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorgangspassiv Präsens: wird + Partizip II. Partizip II von \'backen\' ist \'gebacken\'.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Innerhalb eines Monats hat er Deutsch gelernt.',
      'Innerhalb einem Monat hat er Deutsch gelernt.',
      'Innerhalb ein Monat hat er Deutsch gelernt.',
      'Innerhalb den Monat hat er Deutsch gelernt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Innerhalb\' verlangt den Genitiv: innerhalb eines Monats.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ärgert sich über die laute Musik.',
      'Sie ärgert sich auf die laute Musik.',
      'Sie ärgert sich für die laute Musik.',
      'Sie ärgert sich an die laute Musik.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich ärgern über\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kannst du mir bitte sagen, wie spät es ist?',
      'Kannst du mir bitte sagen, wie spät ist es?',
      'Kannst du mir bitte sagen, wie es spät ist?',
      'Kannst du bitte mir sagen, wie spät es ist?'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Frage steht das Verb am Ende: wie spät es ist.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Farbe des alten Hauses gefällt mir.',
      'Die Farbe des alten Haus gefällt mir.',
      'Die Farbe dem alten Hauses gefällt mir.',
      'Die Farbe der alten Hauses gefällt mir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv Neutrum: des alten Hauses. \'Haus\' bekommt im Genitiv ein -es.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Falls du Hilfe brauchst, ruf mich an.',
      'Falls du Hilfe brauchst, mich ruf an.',
      'Falls brauchst du Hilfe, ruf mich an.',
      'Falls du brauchst Hilfe, ruf mich an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'falls\' steht das Verb am Ende: falls du Hilfe brauchst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schenkte seiner lieben Mutter rote Rosen.',
      'Er schenkte seine liebe Mutter rote Rosen.',
      'Er schenkte seiner lieber Mutter rote Rosen.',
      'Er schenkte seinen lieben Mutter rote Rosen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schenken\' + Dativ (Person). Feminin Dativ: seiner lieben Mutter.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Als er jung war, wollte er Pilot werden.',
      'Als er jung war, will er Pilot werden.',
      'Als er jung war, wollte er Pilot zu werden.',
      'Als er jung war, wollte er Pilot geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb im Präteritum: wollte. Nach Modalverben steht der Infinitiv ohne \'zu\': werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er empfiehlt uns, das neue Restaurant auszuprobieren.',
      'Er empfiehlt uns, das neue Restaurant ausprobieren.',
      'Er empfiehlt uns, das neue Restaurant zu ausprobieren.',
      'Er empfiehlt uns, das neue Restaurant ausprobiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: auszuprobieren.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p2-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich um die Stelle beworben.',
      'Er hat sich für die Stelle beworben.',
      'Er hat sich auf die Stelle beworben.',
      'Er hat sich über die Stelle beworben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich bewerben um\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
