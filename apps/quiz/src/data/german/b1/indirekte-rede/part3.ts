import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-002',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Welchen Modus verwendet man hauptsaechlich in der indirekten Rede (formell)?',
    'options': [
      'Konjunktiv I',
      'Imperativ',
      'Konjunktiv II',
      'Indikativ'
    ],
    'correctAnswer': 0,
    'explanation': 'In der formellen indirekten Rede verwendet man den Konjunktiv I.',
    'grammarRule': 'Formelle indirekte Rede = Konjunktiv I; umgangssprachlich oft Indikativ',
    'subcategory': 'Modus',
    'tags': ['indirekte-rede', 'modus']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-003',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich gehe nach Hause.\'',
    'options': [
      'Sie sagt, sie koenne kommen.',
      'Sie sagt, sie habe Hunger.',
      'Die Kinder sagen, sie seien fertig.',
      'Er sagt, er gehe nach Hause.'
    ],
    'correctAnswer': 3,
    'explanation': 'In der indirekten Rede: gehen -> gehe (Konjunktiv I).',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-009',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wo wohnst du?\'',
    'options': [
      'Er sagt, er werde kommen.',
      'Er bittet, man moege ihm helfen.',
      'Er fragt, wo sie wohne.',
      'Die Kinder sagen, sie seien fertig.'
    ],
    'correctAnswer': 2,
    'explanation': 'In der indirekten Rede: W-Frage -> W-Wort + K.I.',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-010',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich suche eine Wohnung.\'',
    'options': [
      'Er sagt, er suche eine Wohnung.',
      'Er sagt, er sucht eine Wohnung.',
      'Er sagt, er suchte eine Wohnung.',
      'Er sagt, er wuerde eine Wohnung suchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'suche ist Konjunktiv I von suchen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. suchen -> such- + e = suche.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-011',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich habe mich erkealtet.\'',
    'options': [
      'Sie sagt, sie habe sich erkaeltet.',
      'Sie sagt, sie hat sich erkaeltet.',
      'Sie sagt, sie haette sich erkaeltet.',
      'Sie sagt, sie erkaeltete sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe erkaeltet -> habe erkaeltet (K.I Perfekt); mich -> sich.',
    'grammarRule': 'Reflexivpronomen werden in der indirekten Rede angepasst: mich -> sich.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-012',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wie geht es dir?\'',
    'options': [
      'Er fragt, wie es ihr gehe.',
      'Er fragt, ob es ihr gehe.',
      'Er fragt, wie es dir geht.',
      'Er fragt, dass es ihr gehe.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage mit wie; dir -> ihr; geht -> gehe (K.I).',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-013',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich liebe meinen Hund.\'',
    'options': [
      'Sie sagt, sie liebe ihren Hund.',
      'Sie sagt, sie liebt ihren Hund.',
      'Sie sagt, sie liebte ihren Hund.',
      'Sie sagt, sie liebe meinen Hund.'
    ],
    'correctAnswer': 0,
    'explanation': 'liebe ist K.I; meinen -> ihren (Possessivpronomen angepasst).',
    'grammarRule': 'Possessivpronomen werden in der indirekten Rede angepasst.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-014',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich war gestern im Kino.\'',
    'options': [
      'Er sagt, er sei gestern im Kino gewesen.',
      'Er sagt, er war gestern im Kino.',
      'Er sagt, er waere gestern im Kino gewesen.',
      'Er sagt, er ist gestern im Kino gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Praeteritum (war) wird in der ind. Rede zum K.I Perfekt: sei ... gewesen.',
    'grammarRule': 'Praeteritum -> Konjunktiv I Perfekt in der indirekten Rede.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-015',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich besuche meine Eltern.\'',
    'options': [
      'Sie sagt, sie besuche ihre Eltern.',
      'Sie sagt, sie besucht ihre Eltern.',
      'Sie sagt, sie besuchte ihre Eltern.',
      'Sie sagt, sie besuche meine Eltern.'
    ],
    'correctAnswer': 0,
    'explanation': 'besuche ist K.I; meine -> ihre.',
    'grammarRule': 'Konjunktiv I und Possessivpronomen werden angepasst.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-016',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Sprichst du Englisch?\'',
    'options': [
      'Er fragt, ob sie Englisch spreche.',
      'Er fragt, dass sie Englisch spreche.',
      'Er fragt, ob sie Englisch spricht.',
      'Er fragt, warum sie Englisch spreche.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ja/Nein-Frage: ob + K.I (spreche).',
    'grammarRule': 'Ja/Nein-Fragen -> ob + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-017',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich verdiene gut.\'',
    'options': [
      'Er sagt, er verdiene gut.',
      'Er sagt, er verdient gut.',
      'Er sagt, er verdiente gut.',
      'Er sagt, er wuerde gut verdienen.'
    ],
    'correctAnswer': 0,
    'explanation': 'verdiene ist Konjunktiv I von verdienen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. verdienen -> verdien- + e = verdiene.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-018',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich habe den Brief geschrieben.\'',
    'options': [
      'Sie sagt, sie habe den Brief geschrieben.',
      'Sie sagt, sie hat den Brief geschrieben.',
      'Sie sagt, sie schrieb den Brief.',
      'Sie sagt, sie haette den Brief geschrieben.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe geschrieben -> habe geschrieben (K.I Perfekt).',
    'grammarRule': 'Perfekt in der indirekten Rede: habe + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-019',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist Konjunktiv I von fahren (3. Person Singular)?',
    'options': [
      'fahre',
      'faehrt',
      'fuehre',
      'fuhr'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I: Stamm fahr- + e = fahre (kein Umlaut!).',
    'grammarRule': 'Konjunktiv I hat keinen Umlaut, anders als Konjunktiv II.',
    'subcategory': 'Modus',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-020',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich treffe mich mit Freunden.\'',
    'options': [
      'Er sagt, er treffe sich mit Freunden.',
      'Er sagt, er trifft sich mit Freunden.',
      'Er sagt, er traefe sich mit Freunden.',
      'Er sagt, er treffe mich mit Freunden.'
    ],
    'correctAnswer': 0,
    'explanation': 'treffe ist K.I von treffen; mich -> sich.',
    'grammarRule': 'Reflexivpronomen werden angepasst: mich -> sich.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-021',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich muss zum Arzt gehen.\'',
    'options': [
      'Sie sagt, sie muesse zum Arzt gehen.',
      'Sie sagt, sie muss zum Arzt gehen.',
      'Sie sagt, sie musste zum Arzt gehen.',
      'Sie sagt, sie sollte zum Arzt gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'muss -> muesse (Konjunktiv I von muessen).',
    'grammarRule': 'Modalverben im Konjunktiv I: muessen -> muesse.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-022',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Arzt sagt: \'Nehmen Sie die Tabletten!\'',
    'options': [
      'Der Arzt sagt, man solle die Tabletten nehmen.',
      'Der Arzt sagt, nehmen Sie die Tabletten.',
      'Der Arzt sagt, man nimmt die Tabletten.',
      'Der Arzt sagt, dass nehmen die Tabletten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Imperativ (Sie-Form) -> sollen im K.I + Infinitiv.',
    'grammarRule': 'Aufforderungen in indirekter Rede: sollen/moegen + Infinitiv.',
    'subcategory': 'Indirekte Aufforderungen',
    'tags': ['indirekte-rede', 'indirekte-aufforderungen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-023',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Warum kommst du so spaet?\'',
    'options': [
      'Er fragt, warum sie so spaet komme.',
      'Er fragt, ob sie so spaet komme.',
      'Er fragt, warum sie so spaet kommt.',
      'Er fragt, dass sie so spaet komme.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: warum bleibt, kommst -> komme (K.I).',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-024',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich ziehe naechste Woche um.\'',
    'options': [
      'Sie sagt, sie ziehe naechste Woche um.',
      'Sie sagt, sie zieht naechste Woche um.',
      'Sie sagt, sie zoege naechste Woche um.',
      'Sie sagt, sie zog naechste Woche um.'
    ],
    'correctAnswer': 0,
    'explanation': 'ziehe...um ist K.I von umziehen (trennbar).',
    'grammarRule': 'Trennbare Verben im K.I: sie ziehe ... um.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-025',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich habe nichts gehoert.\'',
    'options': [
      'Er sagt, er habe nichts gehoert.',
      'Er sagt, er hat nichts gehoert.',
      'Er sagt, er hoerte nichts.',
      'Er sagt, er haette nichts gehoert.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe gehoert -> habe gehoert (K.I Perfekt).',
    'grammarRule': 'Perfekt in der indirekten Rede: habe + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-026',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich koche heute Abend.\'',
    'options': [
      'Sie sagt, sie koche heute Abend.',
      'Sie sagt, sie kocht heute Abend.',
      'Sie sagt, sie kochte heute Abend.',
      'Sie sagt, sie wuerde heute Abend kochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'koche ist Konjunktiv I von kochen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. kochen -> koch- + e = koche.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-027',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wann faengt der Film an?\'',
    'options': [
      'Er fragt, wann der Film anfange.',
      'Er fragt, ob der Film anfange.',
      'Er fragt, wann der Film anfaengt.',
      'Er fragt, dass der Film anfange.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: wann bleibt; faengt an -> anfange (K.I, trennbar).',
    'grammarRule': 'Trennbare Verben in Nebensaetzen: Verb am Ende, zusammengeschrieben.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-028',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich kann gut singen.\'',
    'options': [
      'Sie sagt, sie koenne gut singen.',
      'Sie sagt, sie kann gut singen.',
      'Sie sagt, sie konnte gut singen.',
      'Sie sagt, sie wuerde gut singen.'
    ],
    'correctAnswer': 0,
    'explanation': 'kann -> koenne (Konjunktiv I von koennen).',
    'grammarRule': 'Modalverben im Konjunktiv I: koennen -> koenne.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-029',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich putze mir die Zaehne.\'',
    'options': [
      'Er sagt, er putze sich die Zaehne.',
      'Er sagt, er putzt sich die Zaehne.',
      'Er sagt, er putzte sich die Zaehne.',
      'Er sagt, er putze mir die Zaehne.'
    ],
    'correctAnswer': 0,
    'explanation': 'putze ist K.I; mir -> sich (Reflexivpronomen angepasst).',
    'grammarRule': 'Reflexivpronomen werden in der indirekten Rede angepasst.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-030',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich bin mit dem Bus gefahren.\'',
    'options': [
      'Sie sagt, sie sei mit dem Bus gefahren.',
      'Sie sagt, sie ist mit dem Bus gefahren.',
      'Sie sagt, sie fuhr mit dem Bus.',
      'Sie sagt, sie waere mit dem Bus gefahren.'
    ],
    'correctAnswer': 0,
    'explanation': 'bin gefahren -> sei gefahren (K.I Perfekt mit sein).',
    'grammarRule': 'Perfekt mit sein in der indirekten Rede: sei + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-031',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich hoere gern Musik.\'',
    'options': [
      'Er sagt, er hoere gern Musik.',
      'Er sagt, er hoert gern Musik.',
      'Er sagt, er hoerte gern Musik.',
      'Er sagt, er wuerde gern Musik hoeren.'
    ],
    'correctAnswer': 0,
    'explanation': 'hoere ist Konjunktiv I von hoeren (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. hoeren -> hoer- + e = hoere.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-032',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Magst du Tiere?\'',
    'options': [
      'Sie fragt, ob er Tiere moege.',
      'Sie fragt, dass er Tiere moege.',
      'Sie fragt, ob er Tiere mag.',
      'Sie fragt, warum er Tiere moege.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ja/Nein-Frage: ob; magst -> moege (K.I).',
    'grammarRule': 'Ja/Nein-Fragen in der indirekten Rede: ob + K.I.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-033',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich laufe gern im Park.\'',
    'options': [
      'Er sagt, er laufe gern im Park.',
      'Er sagt, er laeuft gern im Park.',
      'Er sagt, er liefe gern im Park.',
      'Er sagt, er lief gern im Park.'
    ],
    'correctAnswer': 0,
    'explanation': 'laufe ist Konjunktiv I von laufen (kein Umlaut im K.I).',
    'grammarRule': 'Konjunktiv I hat keinen Umlaut: laufen -> laufe (nicht laeufe).',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-034',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich werde naechstes Jahr heiraten.\'',
    'options': [
      'Sie sagt, sie werde naechstes Jahr heiraten.',
      'Sie sagt, sie wird naechstes Jahr heiraten.',
      'Sie sagt, sie wuerde naechstes Jahr heiraten.',
      'Sie sagt, sie heiratete naechstes Jahr.'
    ],
    'correctAnswer': 0,
    'explanation': 'werde ist K.I von werden + Infinitiv (Futur).',
    'grammarRule': 'Futur in der indirekten Rede: werde + Infinitiv.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'futur']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-035',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Was passiert mit dem Fragezeichen in der indirekten Rede?',
    'options': [
      'Es wird durch einen Punkt ersetzt.',
      'Es bleibt ein Fragezeichen.',
      'Es wird durch ein Ausrufezeichen ersetzt.',
      'Es faellt ganz weg.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede wird die Frage zu einem Aussagesatz; Punkt am Ende.',
    'grammarRule': 'Indirekte Fragen sind Aussagesaetze und enden mit einem Punkt.',
    'subcategory': 'Wortstellung',
    'tags': ['indirekte-rede', 'interpunktion']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-036',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich mache mir Sorgen.\'',
    'options': [
      'Er sagt, er mache sich Sorgen.',
      'Er sagt, er macht sich Sorgen.',
      'Er sagt, er machte sich Sorgen.',
      'Er sagt, er mache mir Sorgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'mache ist K.I; mir -> sich (Reflexivpronomen).',
    'grammarRule': 'Reflexivpronomen: mir -> sich in der indirekten Rede.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-037',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Wem gehoert das Buch?\'',
    'options': [
      'Sie fragt, wem das Buch gehoere.',
      'Sie fragt, ob das Buch gehoere.',
      'Sie fragt, wem das Buch gehoert.',
      'Sie fragt, dass das Buch gehoere.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: wem bleibt, gehoert -> gehoere (K.I).',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-038',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich wohne seit drei Jahren hier.\'',
    'options': [
      'Er sagt, er wohne seit drei Jahren dort.',
      'Er sagt, er wohnt seit drei Jahren dort.',
      'Er sagt, er wohne seit drei Jahren hier.',
      'Er sagt, er wohnte seit drei Jahren dort.'
    ],
    'correctAnswer': 0,
    'explanation': 'wohne ist K.I; hier -> dort (Ortsangabe angepasst).',
    'grammarRule': 'Ortsangaben in der indirekten Rede: hier -> dort.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perspektive']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-039',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich habe ein Geschenk fuer dich.\'',
    'options': [
      'Sie sagt, sie habe ein Geschenk fuer ihn.',
      'Sie sagt, sie hat ein Geschenk fuer ihn.',
      'Sie sagt, sie habe ein Geschenk fuer dich.',
      'Sie sagt, sie haette ein Geschenk fuer ihn.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe ist K.I; fuer dich -> fuer ihn.',
    'grammarRule': 'Pronomen werden in der indirekten Rede der Perspektive angepasst.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-040',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich bin ein guter Schwimmer.\'',
    'options': [
      'Er sagt, er sei ein guter Schwimmer.',
      'Er sagt, er ist ein guter Schwimmer.',
      'Er sagt, er waere ein guter Schwimmer.',
      'Er sagt, er war ein guter Schwimmer.'
    ],
    'correctAnswer': 0,
    'explanation': 'bin -> sei (K.I von sein).',
    'grammarRule': 'sein im Konjunktiv I: er sei.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-041',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Welches Verb leitet die indirekte Rede NICHT typisch ein?',
    'options': [
      'laufen',
      'sagen',
      'meinen',
      'behaupten'
    ],
    'correctAnswer': 0,
    'explanation': 'laufen ist kein Redeverb. Typische Einleitungsverben: sagen, meinen, behaupten.',
    'grammarRule': 'Indirekte Rede wird mit Redeverben eingeleitet: sagen, fragen, meinen, erklaeren.',
    'subcategory': 'Modus',
    'tags': ['indirekte-rede', 'redeverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-042',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich fahre mit dem Zug.\'',
    'options': [
      'Sie sagt, sie fahre mit dem Zug.',
      'Sie sagt, sie faehrt mit dem Zug.',
      'Sie sagt, sie fuehre mit dem Zug.',
      'Sie sagt, sie fuhr mit dem Zug.'
    ],
    'correctAnswer': 0,
    'explanation': 'fahre ist K.I von fahren (kein Umlaut im K.I).',
    'grammarRule': 'Konjunktiv I hat keinen Umlaut: fahren -> fahre.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-043',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Hast du den Schluessel?\'',
    'options': [
      'Er fragt, ob sie den Schluessel habe.',
      'Er fragt, dass sie den Schluessel habe.',
      'Er fragt, ob sie den Schluessel hat.',
      'Er fragt, wo sie den Schluessel habe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ja/Nein-Frage: ob + K.I (habe).',
    'grammarRule': 'Ja/Nein-Fragen -> ob + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-044',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich will ein Eis essen.\'',
    'options': [
      'Sie sagt, sie wolle ein Eis essen.',
      'Sie sagt, sie will ein Eis essen.',
      'Sie sagt, sie wollte ein Eis essen.',
      'Sie sagt, sie moechte ein Eis essen.'
    ],
    'correctAnswer': 0,
    'explanation': 'will -> wolle (K.I von wollen).',
    'grammarRule': 'Modalverben im Konjunktiv I: wollen -> wolle.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-045',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich bin in der Schule.\'',
    'options': [
      'Er sagt, er sei in der Schule.',
      'Er sagt, er ist in der Schule.',
      'Er sagt, er waere in der Schule.',
      'Er sagt, er war in der Schule.'
    ],
    'correctAnswer': 0,
    'explanation': 'bin -> sei (K.I von sein).',
    'grammarRule': 'sein im Konjunktiv I: er sei.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-046',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich interessiere mich fuer Kunst.\'',
    'options': [
      'Sie sagt, sie interessiere sich fuer Kunst.',
      'Sie sagt, sie interessiert sich fuer Kunst.',
      'Sie sagt, sie interessierte sich fuer Kunst.',
      'Sie sagt, sie interessiere mich fuer Kunst.'
    ],
    'correctAnswer': 0,
    'explanation': 'interessiere ist K.I; mich -> sich.',
    'grammarRule': 'Reflexivpronomen: mich -> sich in der indirekten Rede.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-047',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich habe das Auto repariert.\'',
    'options': [
      'Er sagt, er habe das Auto repariert.',
      'Er sagt, er hat das Auto repariert.',
      'Er sagt, er haette das Auto repariert.',
      'Er sagt, er reparierte das Auto.'
    ],
    'correctAnswer': 0,
    'explanation': 'habe repariert -> habe repariert (K.I Perfekt).',
    'grammarRule': 'Perfekt in der indirekten Rede: habe + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-048',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie fragt: \'Woher kommst du?\'',
    'options': [
      'Sie fragt, woher er komme.',
      'Sie fragt, ob er komme.',
      'Sie fragt, woher er kommt.',
      'Sie fragt, dass er komme.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: woher bleibt, kommst -> komme (K.I).',
    'grammarRule': 'W-Fragen in der indirekten Rede: Fragewort + K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-049',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich glaube dir nicht.\'',
    'options': [
      'Er sagt, er glaube ihr nicht.',
      'Er sagt, er glaubt ihr nicht.',
      'Er sagt, er glaubte ihr nicht.',
      'Er sagt, er glaube dir nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'glaube ist K.I; dir -> ihr.',
    'grammarRule': 'Konjunktiv I und Pronomenanpassung.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'pronomen']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-050',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich tanze gern.\'',
    'options': [
      'Sie sagt, sie tanze gern.',
      'Sie sagt, sie tanzt gern.',
      'Sie sagt, sie tanzte gern.',
      'Sie sagt, sie wuerde gern tanzen.'
    ],
    'correctAnswer': 0,
    'explanation': 'tanze ist Konjunktiv I von tanzen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. tanzen -> tanz- + e = tanze.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  { 'language': 'german', 'id': 'b1-indirekte-rede-p3-051', 'level': 'b1', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich zahle die Rechnung.\'', 'options': ['Er sagt, er zahle die Rechnung.', 'Er sagt, er zahlt die Rechnung.', 'Er sagt, er zahlte die Rechnung.', 'Er sagt, er wuerde die Rechnung zahlen.'], 'correctAnswer': 0, 'explanation': 'zahle ist Konjunktiv I von zahlen (3. Person).', 'grammarRule': 'Konjunktiv I: Stamm + e.', 'subcategory': 'Umformung', 'tags': ['indirekte-rede', 'konjunktiv-i'] },
  { 'language': 'german', 'id': 'b1-indirekte-rede-p3-052', 'level': 'b1', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich habe meinen Pass verloren.\'', 'options': ['Sie sagt, sie habe ihren Pass verloren.', 'Sie sagt, sie hat ihren Pass verloren.', 'Sie sagt, sie habe meinen Pass verloren.', 'Sie sagt, sie haette ihren Pass verloren.'], 'correctAnswer': 0, 'explanation': 'habe verloren (K.I Perfekt); meinen -> ihren.', 'grammarRule': 'Possessivpronomen und Perfekt im K.I.', 'subcategory': 'Umformung', 'tags': ['indirekte-rede', 'konjunktiv-i', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-indirekte-rede-p3-053', 'level': 'b1', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wie lange bleibst du?\'', 'options': ['Er fragt, wie lange sie bleibe.', 'Er fragt, ob sie bleibe.', 'Er fragt, wie lange sie bleibt.', 'Er fragt, dass sie bleibe.'], 'correctAnswer': 0, 'explanation': 'W-Frage: wie lange bleibt; bleibst -> bleibe (K.I).', 'grammarRule': 'W-Fragen in der indirekten Rede.', 'subcategory': 'Indirekte Fragen', 'tags': ['indirekte-rede', 'indirekte-fragen'] },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-054',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich verstehe das Problem.\'',
    'options': [
      'Er sagt, er verstehe das Problem.',
      'Er sagt, er versteht das Problem.',
      'Er sagt, er verstuende das Problem.',
      'Er sagt, er verstand das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': 'verstehe ist Konjunktiv I von verstehen (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. verstehen -> versteh- + e = verstehe.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-055',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie sagt: \'Ich warte seit einer Stunde.\'',
    'options': [
      'Sie sagt, sie warte seit einer Stunde.',
      'Sie sagt, sie wartet seit einer Stunde.',
      'Sie sagt, sie wartete seit einer Stunde.',
      'Sie sagt, sie wuerde seit einer Stunde warten.'
    ],
    'correctAnswer': 0,
    'explanation': 'warte ist Konjunktiv I von warten (3. Person).',
    'grammarRule': 'Konjunktiv I: Stamm + e. warten -> wart- + e = warte.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b1-indirekte-rede-p3-056',
    'level': 'b1',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wohin faehrst du in den Urlaub?\'',
    'options': [
      'Er fragt, wohin sie in den Urlaub fahre.',
      'Er fragt, ob sie in den Urlaub fahre.',
      'Er fragt, wohin sie in den Urlaub faehrt.',
      'Er fragt, dass sie in den Urlaub fahre.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: wohin bleibt; faehrst -> fahre (K.I).',
    'grammarRule': 'W-Fragen behalten das Fragewort, Verb im K.I am Ende.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  }
];

export default questions;
