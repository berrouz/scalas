import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-001',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich bin muede.\'',
    'options': [
      'Er sagt, er sei muede.',
      'Er sagt, er habe das Buch gelesen.',
      'Sie sagt, sie habe Hunger.',
      'Er sagt, er werde kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede: sein -> sei (Konjunktiv I).',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-002',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Welchen Modus verwendet man hauptsaechlich in der indirekten Rede (formell)?',
    'options': [
      'Indikativ',
      'Konjunktiv I',
      'Konjunktiv II',
      'Imperativ'
    ],
    'correctAnswer': 1,
    'explanation': 'In der formellen indirekten Rede verwendet man den Konjunktiv I.',
    'grammarRule': 'Formelle indirekte Rede = Konjunktiv I; umgangssprachlich oft Indikativ',
    'subcategory': 'Modus',
    'tags': ['indirekte-rede', 'modus']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-003',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich gehe nach Hause.\'',
    'options': [
      'Er sagt, er gehe nach Hause.',
      'Er sagt, er sei muede.',
      'Er sagt, er werde kommen.',
      'Sie sagt, sie koenne kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede: gehen -> gehe (Konjunktiv I).',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-005',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich werde kommen.\'',
    'options': [
      'Er sagt, er werde kommen.',
      'Er sagt, er habe das Buch gelesen.',
      'Er fragt, wo sie wohne.',
      'Er sagt, er gehe nach Hause.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede: werden -> werde (Konjunktiv I).',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-009',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wo wohnst du?\'',
    'options': [
      'Er sagt, er gehe nach Hause.',
      'Er fragt, wo sie wohne.',
      'Sie sagt, sie koenne kommen.',
      'Er bittet, man moege ihm helfen.'
    ],
    'correctAnswer': 1,
    'explanation': 'In der indirekten Rede: W-Frage -> W-Wort + K.I.',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-010',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich kann schwimmen.\'',
    'options': [
      'Sie sagt, sie koenne schwimmen.',
      'Sie sagt, sie wolle schwimmen.',
      'Sie sagt, sie muesse schwimmen.',
      'Sie sagt, sie solle schwimmen.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede: kann -> koenne (Konjunktiv I von koennen).',
    'grammarRule': 'Modalverben im Konjunktiv I: koennen -> koenne, wollen -> wolle, muessen -> muesse.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-011',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Welches Einleitungswort benutzt man fuer Ja/Nein-Fragen in der indirekten Rede?',
    'options': [
      'dass',
      'ob',
      'weil',
      'wenn'
    ],
    'correctAnswer': 1,
    'explanation': 'Ja/Nein-Fragen werden in der indirekten Rede mit ob eingeleitet.',
    'grammarRule': 'Direkte Ja/Nein-Frage -> indirekte Frage mit ob + Verb am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-012',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Kommst du morgen?\'',
    'options': [
      'Er fragt, ob sie morgen komme.',
      'Er fragt, dass sie morgen komme.',
      'Er fragt, wann sie morgen komme.',
      'Er fragt, warum sie morgen komme.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ja/Nein-Fragen werden mit ob eingeleitet: Kommst du -> ob sie komme.',
    'grammarRule': 'Direkte Ja/Nein-Frage -> indirekte Frage mit ob + Konjunktiv I.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-013',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich habe Hunger.\'',
    'options': [
      'Sie sagt, sie sei hungrig.',
      'Sie sagt, sie habe Hunger.',
      'Sie sagt, sie hatte Hunger.',
      'Sie sagt, sie werde Hunger haben.'
    ],
    'correctAnswer': 1,
    'explanation': 'In der indirekten Rede: habe -> habe (Konjunktiv I = Indikativ bei ich, daher bleibt habe).',
    'grammarRule': 'haben im Konjunktiv I: ich habe, du habest, er habe, wir haben, ihr habet, sie haben.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-014',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie aendert sich das Pronomen in der indirekten Rede: Er sagt: \'Ich bin krank.\'?',
    'options': [
      'ich -> er',
      'ich -> sie',
      'ich -> wir',
      'ich bleibt ich'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Pronomen wird angepasst: ich -> er, weil der Sprecher maennlich ist.',
    'grammarRule': 'Pronomen in der indirekten Rede werden der Perspektive angepasst.',
    'subcategory': 'Pronomen',
    'tags': ['indirekte-rede', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-015',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Die Kinder sagen: \'Wir sind fertig.\'',
    'options': [
      'Die Kinder sagen, sie seien fertig.',
      'Die Kinder sagen, sie waeren fertig.',
      'Die Kinder sagen, sie sind fertig.',
      'Die Kinder sagen, wir seien fertig.'
    ],
    'correctAnswer': 0,
    'explanation': 'wir sind -> sie seien (Konjunktiv I, 3. Person Plural).',
    'grammarRule': 'sein im Konjunktiv I: ich sei, du seist, er sei, wir seien, ihr seiet, sie seien.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-016',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich muss arbeiten.\'',
    'options': [
      'Er sagt, er muesse arbeiten.',
      'Er sagt, er musste arbeiten.',
      'Er sagt, er muss arbeiten.',
      'Er sagt, er sollte arbeiten.'
    ],
    'correctAnswer': 0,
    'explanation': 'muss -> muesse (Konjunktiv I von muessen).',
    'grammarRule': 'Modalverben im Konjunktiv I: muessen -> muesse, sollen -> solle.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-017',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Was steht am Ende des Nebensatzes in der indirekten Rede mit dass?',
    'options': [
      'das Subjekt',
      'das Objekt',
      'das konjugierte Verb',
      'das Adverb'
    ],
    'correctAnswer': 2,
    'explanation': 'In Nebensaetzen mit dass steht das konjugierte Verb am Ende.',
    'grammarRule': 'Indirekte Rede mit dass: Nebensatzstellung, Verb am Ende.',
    'subcategory': 'Wortstellung',
    'tags': ['indirekte-rede', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-018',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Wann faehrt der Zug?\'',
    'options': [
      'Sie fragt, wann der Zug fahre.',
      'Sie fragt, ob der Zug faehrt.',
      'Sie fragt, dass der Zug fahre.',
      'Sie fragt, weil der Zug fahre.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Fragen behalten das Fragewort: wann + Konjunktiv I (fahre).',
    'grammarRule': 'W-Fragen in der indirekten Rede: W-Wort bleibt, Verb im Konjunktiv I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-019',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich will nach Berlin fahren.\'',
    'options': [
      'Er sagt, er wolle nach Berlin fahren.',
      'Er sagt, er will nach Berlin fahren.',
      'Er sagt, er wollte nach Berlin fahren.',
      'Er sagt, er wuerde nach Berlin fahren.'
    ],
    'correctAnswer': 0,
    'explanation': 'will -> wolle (Konjunktiv I von wollen).',
    'grammarRule': 'Modalverben im Konjunktiv I: wollen -> wolle.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-020',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Kann man die indirekte Rede auch ohne dass bilden?',
    'options': [
      'Nein, dass ist immer noetig.',
      'Ja, dann steht das Verb an zweiter Stelle.',
      'Ja, dann steht das Verb am Ende.',
      'Nein, nur mit ob.'
    ],
    'correctAnswer': 1,
    'explanation': 'Ohne dass steht das Verb an zweiter Stelle: Er sagt, er sei muede.',
    'grammarRule': 'Indirekte Rede ohne dass: Hauptsatzstellung (Verb an Position 2).',
    'subcategory': 'Wortstellung',
    'tags': ['indirekte-rede', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-021',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich lese gern.\'',
    'options': [
      'Sie sagt, sie lese gern.',
      'Sie sagt, sie liest gern.',
      'Sie sagt, sie laese gern.',
      'Sie sagt, sie lesen gern.'
    ],
    'correctAnswer': 0,
    'explanation': 'lese ist Konjunktiv I von lesen (3. Person Singular).',
    'grammarRule': 'Konjunktiv I: Stamm + e. lesen -> les- + e = lese.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-022',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich habe keine Zeit.\'',
    'options': [
      'Er sagt, er habe keine Zeit.',
      'Er sagt, er hat keine Zeit.',
      'Er sagt, er haette keine Zeit.',
      'Er sagt, er hatte keine Zeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe -> habe (Konjunktiv I von haben, 3. Person).',
    'grammarRule': 'haben im Konjunktiv I: er/sie/es habe.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-023',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Hast du Zeit?\'',
    'options': [
      'Sie fragt, ob er Zeit habe.',
      'Sie fragt, dass er Zeit habe.',
      'Sie fragt, wann er Zeit habe.',
      'Sie fragt, er habe Zeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ja/Nein-Frage: Hast du -> ob er ... habe.',
    'grammarRule': 'Ja/Nein-Fragen werden mit ob eingeleitet, Verb am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-024',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich fahre morgen ab.\'',
    'options': [
      'Er sagt, er fahre morgen ab.',
      'Er sagt, er fuhr morgen ab.',
      'Er sagt, er faehrt morgen ab.',
      'Er sagt, er fuehre morgen ab.'
    ],
    'correctAnswer': 0,
    'explanation': 'fahre ist Konjunktiv I von fahren (er fahre).',
    'grammarRule': 'Trennbare Verben bleiben in der indirekten Rede trennbar: er fahre ... ab.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-025',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich bin gestern angekommen.\'',
    'options': [
      'Sie sagt, sie sei gestern angekommen.',
      'Sie sagt, sie war gestern angekommen.',
      'Sie sagt, sie ist gestern angekommen.',
      'Sie sagt, sie waere gestern angekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'bin angekommen -> sei angekommen (Konjunktiv I Perfekt mit sein).',
    'grammarRule': 'Perfekt in der indirekten Rede: habe/sei + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-026',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er bittet: \'Hilf mir bitte!\'',
    'options': [
      'Er bittet, man moege ihm helfen.',
      'Er bittet, man soll ihm helfen.',
      'Er bittet, hilf mir bitte.',
      'Er bittet, dass man ihm hilft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aufforderungen werden mit moegen (Konjunktiv I) wiedergegeben.',
    'grammarRule': 'Imperativ in indirekter Rede: moegen im Konjunktiv I (moege/moegen).',
    'subcategory': 'Indirekte Aufforderungen',
    'tags': ['indirekte-rede', 'indirekte-aufforderungen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-027',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich wohne in Muenchen.\'',
    'options': [
      'Er sagt, er wohne in Muenchen.',
      'Er sagt, er wohnt in Muenchen.',
      'Er sagt, er wohnte in Muenchen.',
      'Er sagt, er wuerde in Muenchen wohnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'wohne ist Konjunktiv I von wohnen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. wohnen -> wohn- + e = wohne.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-028',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Warum bist du traurig?\'',
    'options': [
      'Sie fragt, warum er traurig sei.',
      'Sie fragt, ob er traurig sei.',
      'Sie fragt, dass er traurig sei.',
      'Sie fragt, weil er traurig sei.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage mit warum: Das Fragewort bleibt erhalten.',
    'grammarRule': 'W-Fragen behalten das Fragewort, Verb im Konjunktiv I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-029',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich soll den Arzt anrufen.\'',
    'options': [
      'Er sagt, er solle den Arzt anrufen.',
      'Er sagt, er soll den Arzt anrufen.',
      'Er sagt, er sollte den Arzt anrufen.',
      'Er sagt, er muesse den Arzt anrufen.'
    ],
    'correctAnswer': 0,
    'explanation': 'soll -> solle (Konjunktiv I von sollen).',
    'grammarRule': 'Modalverben im Konjunktiv I: sollen -> solle.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-030',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich werde morgen kommen.\'',
    'options': [
      'Sie sagt, sie werde morgen kommen.',
      'Sie sagt, sie wird morgen kommen.',
      'Sie sagt, sie wuerde morgen kommen.',
      'Sie sagt, sie kam morgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'werde ist Konjunktiv I von werden (3. Person Singular).',
    'grammarRule': 'Futur in der indirekten Rede: werde + Infinitiv.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'futur']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-031',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich esse kein Fleisch.\'',
    'options': [
      'Er sagt, er esse kein Fleisch.',
      'Er sagt, er isst kein Fleisch.',
      'Er sagt, er ass kein Fleisch.',
      'Er sagt, er aesse kein Fleisch.'
    ],
    'correctAnswer': 0,
    'explanation': 'esse ist Konjunktiv I von essen (3. Person: er esse).',
    'grammarRule': 'Konjunktiv I: Stamm + e. essen -> ess- + e = esse.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-032',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Welche Konjunktion leitet die indirekte Rede haeufig ein?',
    'options': [
      'dass',
      'weil',
      'obwohl',
      'wenn'
    ],
    'correctAnswer': 0,
    'explanation': 'Die indirekte Rede wird haeufig mit dass eingeleitet.',
    'grammarRule': 'Indirekte Rede kann mit dass + Nebensatz oder ohne dass + Hauptsatz gebildet werden.',
    'subcategory': 'Wortstellung',
    'tags': ['indirekte-rede', 'konjunktionen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-033',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wie alt bist du?\'',
    'options': [
      'Er fragt, wie alt sie sei.',
      'Er fragt, ob sie alt sei.',
      'Er fragt, dass sie alt sei.',
      'Er fragt, wie alt sie ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: wie alt + Konjunktiv I (sei).',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort bleibt, Verb im K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-034',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich darf nicht rauchen.\'',
    'options': [
      'Sie sagt, sie duerfe nicht rauchen.',
      'Sie sagt, sie darf nicht rauchen.',
      'Sie sagt, sie durfte nicht rauchen.',
      'Sie sagt, sie koenne nicht rauchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'darf -> duerfe (Konjunktiv I von duerfen).',
    'grammarRule': 'Modalverben im Konjunktiv I: duerfen -> duerfe.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-035',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Mein Bruder ist Arzt.\'',
    'options': [
      'Er sagt, sein Bruder sei Arzt.',
      'Er sagt, mein Bruder sei Arzt.',
      'Er sagt, sein Bruder ist Arzt.',
      'Er sagt, sein Bruder waere Arzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'mein -> sein (Possessivpronomen wird angepasst), ist -> sei.',
    'grammarRule': 'Possessivpronomen werden in der indirekten Rede angepasst.',
    'subcategory': 'Pronomen',
    'tags': ['indirekte-rede', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-036',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich habe gestern gearbeitet.\'',
    'options': [
      'Er sagt, er habe gestern gearbeitet.',
      'Er sagt, er hat gestern gearbeitet.',
      'Er sagt, er hatte gestern gearbeitet.',
      'Er sagt, er arbeitete gestern.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe gearbeitet -> habe gearbeitet (Konjunktiv I Perfekt).',
    'grammarRule': 'Perfekt in der indirekten Rede: habe/sei + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-037',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich kenne ihn nicht.\'',
    'options': [
      'Sie sagt, sie kenne ihn nicht.',
      'Sie sagt, sie kennt ihn nicht.',
      'Sie sagt, sie kannte ihn nicht.',
      'Sie sagt, sie kennte ihn nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'kenne ist Konjunktiv I von kennen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. kennen -> kenn- + e = kenne.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-038',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede mit dass: Er sagt: \'Ich bin krank.\'',
    'options': [
      'Er sagt, dass er krank sei.',
      'Er sagt, dass er krank ist.',
      'Er sagt, dass er sei krank.',
      'Er sagt, er dass krank sei.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mit dass: dass + Subjekt + ... + Verb (Konjunktiv I) am Ende.',
    'grammarRule': 'Indirekte Rede mit dass: Nebensatzstellung, Verb am Ende im K.I.',
    'subcategory': 'Wortstellung',
    'tags': ['indirekte-rede', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-039',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Was machst du heute?\'',
    'options': [
      'Er fragt, was sie heute mache.',
      'Er fragt, ob sie heute mache.',
      'Er fragt, was sie heute macht.',
      'Er fragt, dass sie heute mache.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: was bleibt, mache ist Konjunktiv I.',
    'grammarRule': 'W-Fragen behalten das Fragewort, Verb im Konjunktiv I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-040',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich spreche Deutsch.\'',
    'options': [
      'Sie sagt, sie spreche Deutsch.',
      'Sie sagt, sie spricht Deutsch.',
      'Sie sagt, sie spraeche Deutsch.',
      'Sie sagt, sie gesprochen Deutsch.'
    ],
    'correctAnswer': 0,
    'explanation': 'spreche ist Konjunktiv I von sprechen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. sprechen -> sprech- + e = spreche.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-041',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich weiss es nicht.\'',
    'options': [
      'Er sagt, er wisse es nicht.',
      'Er sagt, er weiss es nicht.',
      'Er sagt, er wusste es nicht.',
      'Er sagt, er wueste es nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'weiss -> wisse (Konjunktiv I von wissen).',
    'grammarRule': 'wissen im Konjunktiv I: ich wisse, du wissest, er wisse.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-042',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Lehrer sagt: \'Macht eure Hausaufgaben!\'',
    'options': [
      'Der Lehrer sagt, sie sollten ihre Hausaufgaben machen.',
      'Der Lehrer sagt, macht eure Hausaufgaben.',
      'Der Lehrer sagt, sie machen Hausaufgaben.',
      'Der Lehrer sagt, dass macht Hausaufgaben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Imperativ wird in der indirekten Rede mit sollen/moegen + Infinitiv wiedergegeben.',
    'grammarRule': 'Aufforderungen in indirekter Rede: sollen/moegen im K.I oder K.II + Infinitiv.',
    'subcategory': 'Indirekte Aufforderungen',
    'tags': ['indirekte-rede', 'indirekte-aufforderungen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-043',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich bin noch nie in Japan gewesen.\'',
    'options': [
      'Sie sagt, sie sei noch nie in Japan gewesen.',
      'Sie sagt, sie ist noch nie in Japan gewesen.',
      'Sie sagt, sie war noch nie in Japan gewesen.',
      'Sie sagt, sie waere noch nie in Japan gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'bin gewesen -> sei gewesen (Konjunktiv I Perfekt mit sein).',
    'grammarRule': 'Perfekt in indirekter Rede: sei/habe + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-044',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich trinke keinen Kaffee.\'',
    'options': [
      'Er sagt, er trinke keinen Kaffee.',
      'Er sagt, er trinkt keinen Kaffee.',
      'Er sagt, er traenke keinen Kaffee.',
      'Er sagt, er trank keinen Kaffee.'
    ],
    'correctAnswer': 0,
    'explanation': 'trinke ist Konjunktiv I von trinken (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. trinken -> trink- + e = trinke.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-045',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie aendert sich hier in der indirekten Rede: Er sagt: \'Ich komme morgen hierher.\'',
    'options': [
      'hierher -> dorthin',
      'hierher -> hierhin',
      'hierher bleibt hierher',
      'hierher -> dahin'
    ],
    'correctAnswer': 0,
    'explanation': 'Ortsangaben werden angepasst: hierher -> dorthin.',
    'grammarRule': 'Orts- und Zeitangaben werden in der indirekten Rede der Perspektive angepasst.',
    'subcategory': 'Pronomen',
    'tags': ['indirekte-rede', 'perspektive']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-046',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Wo ist die naechste Apotheke?\'',
    'options': [
      'Sie fragt, wo die naechste Apotheke sei.',
      'Sie fragt, ob die naechste Apotheke sei.',
      'Sie fragt, dass die naechste Apotheke sei.',
      'Sie fragt, wo ist die naechste Apotheke.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: wo bleibt erhalten, Verb (sei) am Ende.',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort + Nebensatzstellung.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-047',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich arbeite bei Siemens.\'',
    'options': [
      'Er sagt, er arbeite bei Siemens.',
      'Er sagt, er arbeitet bei Siemens.',
      'Er sagt, er arbeitete bei Siemens.',
      'Er sagt, er wuerde bei Siemens arbeiten.'
    ],
    'correctAnswer': 0,
    'explanation': 'arbeite ist Konjunktiv I von arbeiten (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. arbeiten -> arbeit- + e = arbeite.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-048',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie aendert sich heute in der indirekten Rede (am naechsten Tag erzaehlt)?',
    'options': [
      'heute -> an dem/jenem Tag',
      'heute bleibt heute',
      'heute -> gestern',
      'heute -> morgen'
    ],
    'correctAnswer': 0,
    'explanation': 'Zeitangaben werden angepasst: heute -> an dem/jenem Tag (wenn spaeter berichtet).',
    'grammarRule': 'Zeitangaben in der indirekten Rede: heute -> an dem Tag, morgen -> am naechsten Tag.',
    'subcategory': 'Pronomen',
    'tags': ['indirekte-rede', 'perspektive']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-049',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich nehme den Bus.\'',
    'options': [
      'Sie sagt, sie nehme den Bus.',
      'Sie sagt, sie nimmt den Bus.',
      'Sie sagt, sie naehme den Bus.',
      'Sie sagt, sie genommen den Bus.'
    ],
    'correctAnswer': 0,
    'explanation': 'nehme ist Konjunktiv I von nehmen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. nehmen -> nehm- + e = nehme.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-050',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich bin mit dem Ergebnis zufrieden.\'',
    'options': [
      'Er sagt, er sei mit dem Ergebnis zufrieden.',
      'Er sagt, er ist mit dem Ergebnis zufrieden.',
      'Er sagt, er war mit dem Ergebnis zufrieden.',
      'Er sagt, er waere mit dem Ergebnis zufrieden.'
    ],
    'correctAnswer': 0,
    'explanation': 'bin -> sei (Konjunktiv I von sein, 3. Person).',
    'grammarRule': 'sein im Konjunktiv I: er/sie/es sei.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-051',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich schreibe dir einen Brief.\'',
    'options': [
      'Er sagt, er schreibe ihr einen Brief.',
      'Er sagt, er schreibt ihr einen Brief.',
      'Er sagt, er schriebe ihr einen Brief.',
      'Er sagt, er schreibe dir einen Brief.'
    ],
    'correctAnswer': 0,
    'explanation': 'schreibe ist K.I; dir -> ihr.',
    'grammarRule': 'Konjunktiv I und Pronomenanpassung.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-052',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Wann kommst du zurueck?\'',
    'options': [
      'Sie fragt, wann er zurueckkomme.',
      'Sie fragt, ob er zurueckkomme.',
      'Sie fragt, wann er zurueckkommt.',
      'Sie fragt, dass er zurueckkomme.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: wann bleibt; kommst -> komme (K.I); du -> er.',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-053',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich habe mich verspätet.\'',
    'options': [
      'Er sagt, er habe sich verspaetet.',
      'Er sagt, er hat sich verspaetet.',
      'Er sagt, er haette sich verspaetet.',
      'Er sagt, er habe mich verspaetet.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe verspaetet (K.I Perfekt); mich -> sich.',
    'grammarRule': 'Reflexivpronomen und Perfekt im K.I.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p1-054',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich brauche mehr Zeit.\'',
    'options': [
      'Er sagt, er brauche mehr Zeit.',
      'Er sagt, er braucht mehr Zeit.',
      'Er sagt, er brauchte mehr Zeit.',
      'Er sagt, er wuerde mehr Zeit brauchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'brauche ist Konjunktiv I von brauchen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. brauchen -> brauch- + e = brauche.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  }
];

export default questions;
