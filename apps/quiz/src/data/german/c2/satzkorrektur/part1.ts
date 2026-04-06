import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er versprach, ihr zu helfen, sobald er Zeit habe.',
      'Er versprach ihr zu helfen sobald er Zeit habe.',
      'Er versprach, ihr zu helfen sobald er Zeit habe.',
      'Er versprach ihr, zu helfen, sobald er Zeit habe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Komma steht vor dem erweiterten Infinitiv mit "zu" und vor dem Nebensatz mit "sobald".',
    'exampleSentence': 'Er versprach, ihr zu helfen, sobald er Zeit habe.',
    'grammarRule': 'Kommasetzung bei Infinitivgruppen und Nebensätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Virus hat sich rasant verbreitet.',
      'Der Virus hat sich rasant verbreitet.',
      'Die Virus hat sich rasant verbreitet.',
      'Das Virus hat sich rasant verbreitete.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Wort "Virus" ist im fachsprachlichen Gebrauch Neutrum: das Virus.',
    'exampleSentence': 'Das Virus hat sich rasant verbreitet.',
    'grammarRule': 'Genus bei Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er erinnerte sich des Vorfalls.',
      'Er erinnerte sich den Vorfall.',
      'Er erinnerte sich dem Vorfall.',
      'Er erinnerte sich des Vorfalles an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Verb "sich erinnern" regiert im gehobenen Stil den Genitiv: sich einer Sache erinnern.',
    'exampleSentence': 'Er erinnerte sich des Vorfalls.',
    'grammarRule': 'Genitivrektion bei reflexiven Verben',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Eine Reihe von Problemen wurde besprochen.',
      'Eine Reihe von Problemen wurden besprochen.',
      'Eine Reihe von Probleme wurde besprochen.',
      'Eine Reihe von Probleme wurden besprochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Konstruktionen mit "eine Reihe von" richtet sich das Verb nach dem Subjektkern "Reihe" (Singular).',
    'exampleSentence': 'Eine Reihe von Problemen wurde besprochen.',
    'grammarRule': 'Subjekt-Verb-Kongruenz bei Mengenangaben',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wes Brot ich ess, des Lied ich sing.',
      'Wessen Brot ich esse, dessen Lied ich singe.',
      'Wes Brot ich esse, des Lied ich singe.',
      'Wessen Brot ich ess, des Lied ich sing.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die archaische Form des Sprichworts lautet: "Wes Brot ich ess, des Lied ich sing." mit verkürzten Genitivformen.',
    'exampleSentence': 'Wes Brot ich ess, des Lied ich sing.',
    'grammarRule': 'Archaische Genitivformen in Sprichwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Des Nachts wandelte er durch die stillen Gassen.',
      'Des Nachts wandelte er durch die stille Gassen.',
      'Der Nachts wandelte er durch die stillen Gassen.',
      'Des Nacht wandelte er durch die stillen Gassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Nachts" ist ein adverbialer Genitiv im gehobenen Stil. "Stillen" ist korrekt dekliniert (Akkusativ Plural mit Adjektiv nach Artikel).',
    'exampleSentence': 'Des Nachts wandelte er durch die stillen Gassen.',
    'grammarRule': 'Adverbialer Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hätte er es gewusst, so wäre er nicht gekommen.',
      'Hätte er es gewusst, so er wäre nicht gekommen.',
      'Hätte er es gewusst, er so wäre nicht gekommen.',
      'Er hätte es gewusst, so wäre er nicht gekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im irrealen Konditionalsatz ohne "wenn" steht das Verb an erster Stelle, im Hauptsatz nach "so" an zweiter.',
    'exampleSentence': 'Hätte er es gewusst, so wäre er nicht gekommen.',
    'grammarRule': 'Verb-Erst-Stellung im irrealen Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Kind mit dem Bade ausgeschüttet.',
      'Er hat das Kind mit dem Bad ausgeschüttet.',
      'Er hat das Kind mit der Bade ausgeschüttet.',
      'Er hat das Kind mit den Bade ausgeschüttet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die idiomatische Wendung lautet "das Kind mit dem Bade ausschütten". "Bade" ist die ältere Dativform von "Bad".',
    'exampleSentence': 'Er hat das Kind mit dem Bade ausgeschüttet.',
    'grammarRule': 'Idiomatische Wendung mit archaischer Dativform',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie bat ihn, das Fenster zu öffnen, was er auch sogleich tat.',
      'Sie bat ihn das Fenster zu öffnen, was er auch sogleich tat.',
      'Sie bat ihn, das Fenster zu öffnen was er auch sogleich tat.',
      'Sie bat ihn das Fenster zu öffnen was er auch sogleich tat.'
    ],
    'correctAnswer': 0,
    'explanation': 'Komma vor dem erweiterten Infinitiv mit "zu" und vor dem weiterführenden Relativsatz mit "was".',
    'exampleSentence': 'Sie bat ihn, das Fenster zu öffnen, was er auch sogleich tat.',
    'grammarRule': 'Kommasetzung bei Infinitivgruppen und weiterführenden Relativsätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dessen ungeachtet fuhr er mit seiner Arbeit fort.',
      'Dem ungeachtet fuhr er mit seiner Arbeit fort.',
      'Des ungeachtet fuhr er mit seiner Arbeit fort.',
      'Dessen ungeachtet fuhr er mit seine Arbeit fort.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dessen ungeachtet" ist eine gehobene Wendung mit Demonstrativpronomen im Genitiv.',
    'exampleSentence': 'Dessen ungeachtet fuhr er mit seiner Arbeit fort.',
    'grammarRule': 'Genitivkonstruktionen mit Partizipien',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Elaborat wurde von der Kommission geprüft.',
      'Der Elaborat wurde von der Kommission geprüft.',
      'Die Elaborat wurde von der Kommission geprüft.',
      'Das Elaborat wurde von die Kommission geprüft.'
    ],
    'correctAnswer': 0,
    'explanation': '"Elaborat" ist ein Neutrum: das Elaborat. "Von der Kommission" steht im Dativ.',
    'exampleSentence': 'Das Elaborat wurde von der Kommission geprüft.',
    'grammarRule': 'Genus bei gehobenen Substantiven',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder der Minister noch seine Berater waren anwesend.',
      'Weder der Minister noch seine Berater war anwesend.',
      'Weder der Minister noch seine Berater wart anwesend.',
      'Weder der Minister noch seine Berater ist anwesend gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "weder ... noch" richtet sich das Verb nach dem nächststehenden Subjektteil: "Berater" (Plural) verlangt "waren".',
    'exampleSentence': 'Weder der Minister noch seine Berater waren anwesend.',
    'grammarRule': 'Kongruenz bei mehrteiligen Subjekten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er pflegte des Morgens einen Spaziergang zu unternehmen.',
      'Er pflegte des Morgen einen Spaziergang zu unternehmen.',
      'Er pflegte der Morgens einen Spaziergang zu unternehmen.',
      'Er pflegte des Morgens ein Spaziergang zu unternehmen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Morgens" ist ein adverbialer Genitiv. "Einen Spaziergang" steht im Akkusativ als Objekt von "unternehmen".',
    'exampleSentence': 'Er pflegte des Morgens einen Spaziergang zu unternehmen.',
    'grammarRule': 'Adverbialer Genitiv und Akkusativobjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur war er müde, sondern auch völlig erschöpft.',
      'Nicht nur er war müde, sondern auch völlig erschöpft.',
      'Nicht nur war müde er, sondern auch völlig erschöpft.',
      'Er nicht nur war müde, sondern auch völlig erschöpft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei vorangestelltem "nicht nur" erfolgt Inversion: Verb vor Subjekt.',
    'exampleSentence': 'Nicht nur war er müde, sondern auch völlig erschöpft.',
    'grammarRule': 'Inversion nach vorangestelltem Adverbial',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ging mit ihm ins Gericht.',
      'Er ging mit ihm in Gericht.',
      'Er ging mit ihm im Gericht.',
      'Er ging mit ihn ins Gericht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Redewendung lautet "mit jemandem ins Gericht gehen" (jemanden streng beurteilen). "Mit ihm" steht im Dativ.',
    'exampleSentence': 'Er ging mit ihm ins Gericht.',
    'grammarRule': 'Idiomatische Wendung mit Präpositionalphrase',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Plan, den sie entworfen hatte, erwies sich als undurchführbar.',
      'Der Plan den sie entworfen hatte, erwies sich als undurchführbar.',
      'Der Plan, den sie entworfen hatte erwies sich als undurchführbar.',
      'Der Plan den sie entworfen hatte erwies sich als undurchführbar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ein eingeschobener Relativsatz muss durch paarige Kommas vom Hauptsatz getrennt werden.',
    'exampleSentence': 'Der Plan, den sie entworfen hatte, erwies sich als undurchführbar.',
    'grammarRule': 'Paarige Kommas bei eingeschobenen Relativsätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie bedarf keiner weiteren Erklärung.',
      'Sie bedarf keine weiteren Erklärung.',
      'Sie bedarf keinem weiteren Erklärung.',
      'Sie bedarf keiner weiterer Erklärung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bedürfen" regiert den Genitiv: keiner weiteren Erklärung.',
    'exampleSentence': 'Sie bedarf keiner weiteren Erklärung.',
    'grammarRule': 'Genitivrektion bei "bedürfen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Bonmot des Kanzlers ging durch die Presse.',
      'Der Bonmot des Kanzlers ging durch die Presse.',
      'Die Bonmot des Kanzlers ging durch die Presse.',
      'Das Bonmot des Kanzlers ging durch der Presse.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bonmot" ist Neutrum: das Bonmot. "Durch die Presse" steht im Akkusativ.',
    'exampleSentence': 'Das Bonmot des Kanzlers ging durch die Presse.',
    'grammarRule': 'Genus bei französischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein Drittel der Abgeordneten stimmte dagegen.',
      'Ein Drittel der Abgeordneten stimmten dagegen.',
      'Ein Drittel der Abgeordnete stimmte dagegen.',
      'Ein Drittel der Abgeordnete stimmten dagegen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Bruchzahlkonstruktionen richtet sich das Verb formal nach dem Subjektkern "Drittel" (Singular).',
    'exampleSentence': 'Ein Drittel der Abgeordneten stimmte dagegen.',
    'grammarRule': 'Kongruenz bei Bruchzahlkonstruktionen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ward des Betruges überführt.',
      'Er wurd des Betruges überführt.',
      'Er ward des Betrugs übergeführt.',
      'Er ward dem Betrug überführt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ward" ist die archaische Präteritumform von "werden". "Des Betruges überführen" erfordert den Genitiv.',
    'exampleSentence': 'Er ward des Betruges überführt.',
    'grammarRule': 'Archaische Verbform und Genitivrektion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Eingedenk seiner Verdienste wurde er befördert.',
      'Eingedenk seinen Verdiensten wurde er befördert.',
      'Eingedenk seiner Verdiensten wurde er befördert.',
      'Eingedenk seine Verdienste wurde er befördert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Eingedenk" ist eine gehobene Präposition, die den Genitiv regiert: eingedenk seiner Verdienste.',
    'exampleSentence': 'Eingedenk seiner Verdienste wurde er befördert.',
    'grammarRule': 'Gehobenene Präpositionen mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kaum hatte er das Haus verlassen, da begann es zu regnen.',
      'Kaum er hatte das Haus verlassen, da begann es zu regnen.',
      'Kaum hatte er das Haus verlassen, da es begann zu regnen.',
      'Kaum hatte das Haus er verlassen, da begann es zu regnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "kaum" steht das Verb in Erststellung (Inversion). Im Nachsatz mit "da" folgt reguläre Verbzweitstellung.',
    'exampleSentence': 'Kaum hatte er das Haus verlassen, da begann es zu regnen.',
    'grammarRule': 'Inversion nach temporalem "kaum"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ließ nicht locker, bis er ihr Rede und Antwort stand.',
      'Sie ließ nicht locker, bis er ihr Rede und Antwort gestanden hat.',
      'Sie ließ nicht locker, bis er ihr Rede und Antwort stellte.',
      'Sie ließ nicht locker, bis er ihre Rede und Antwort stand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die feste Wendung lautet "jemandem Rede und Antwort stehen" (Präteritum: stand).',
    'exampleSentence': 'Sie ließ nicht locker, bis er ihr Rede und Antwort stand.',
    'grammarRule': 'Idiomatische Wendung mit festem Verb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er kam, sah und siegte.',
      'Er kam sah und siegte.',
      'Er kam, sah, und siegte.',
      'Er, kam sah und siegte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei drei gleichrangigen Satzgliedern ohne Konjunktion steht ein Komma; vor "und" steht kein Komma bei Aufzählungen.',
    'exampleSentence': 'Er kam, sah und siegte.',
    'grammarRule': 'Kommasetzung bei Aufzählungen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man beschuldigte ihn des Diebstahls.',
      'Man beschuldigte ihn den Diebstahl.',
      'Man beschuldigte ihm des Diebstahls.',
      'Man beschuldigte ihn dem Diebstahl.'
    ],
    'correctAnswer': 0,
    'explanation': '"Beschuldigen" regiert den Akkusativ der Person und den Genitiv der Sache: jemanden einer Sache beschuldigen.',
    'exampleSentence': 'Man beschuldigte ihn des Diebstahls.',
    'grammarRule': 'Doppelte Rektion: Akkusativ + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Kompott schmeckte vorzüglich.',
      'Der Kompott schmeckte vorzüglich.',
      'Die Kompott schmeckte vorzüglich.',
      'Das Kompott schmeckt vorzüglich gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kompott" ist Neutrum: das Kompott.',
    'exampleSentence': 'Das Kompott schmeckte vorzüglich.',
    'grammarRule': 'Genus bei Lebensmittelbezeichnungen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Du bist es, der mir geholfen hat.',
      'Du bist es, der mir geholfen hast.',
      'Du bist es, die mir geholfen hat.',
      'Du bist es, der mir geholfen haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Relativsatz bezieht sich "der" auf "es" und steht in der 3. Person Singular: "hat".',
    'exampleSentence': 'Du bist es, der mir geholfen hat.',
    'grammarRule': 'Kongruenz im Relativsatz nach Pronominalsubjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er trug des Kaisers neue Kleider.',
      'Er trug dem Kaisers neue Kleider.',
      'Er trug des Kaiser neue Kleider.',
      'Er trug des Kaisers neuen Kleider.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Kaisers" ist ein vorangestellter Genitiv (Genitivattribut). "Neue Kleider" im Akkusativ Plural ohne Artikel.',
    'exampleSentence': 'Er trug des Kaisers neue Kleider.',
    'grammarRule': 'Vorangestellter Genitiv im literarischen Stil',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob er nun komme oder nicht, die Feier finde statt.',
      'Ob er nun kommt oder nicht, die Feier finde statt.',
      'Ob er nun komme oder nicht, die Feier findet statt.',
      'Ob er nun komme oder nicht, die Feier fände statt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im gehobenen Stil wird die indirekte Rede durchgehend im Konjunktiv I geführt: "komme", "finde statt".',
    'exampleSentence': 'Ob er nun komme oder nicht, die Feier finde statt.',
    'grammarRule': 'Durchgängiger Konjunktiv I in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selten hat man ein solches Schauspiel erlebt.',
      'Selten man hat ein solches Schauspiel erlebt.',
      'Selten hat ein solches Schauspiel man erlebt.',
      'Selten ein solches Schauspiel hat man erlebt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem vorangestellten Adverb "selten" folgt Inversion: finites Verb vor dem Subjekt.',
    'exampleSentence': 'Selten hat man ein solches Schauspiel erlebt.',
    'grammarRule': 'Inversion nach satzeinleitendem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er machte aus seinem Herzen keine Mördergrube.',
      'Er machte aus sein Herz keine Mördergrube.',
      'Er machte aus seinem Herzen keine Mördergruben.',
      'Er machte aus seinem Herz keinen Mördergrube.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die feste Wendung lautet "aus seinem Herzen keine Mördergrube machen". "Herzen" ist die Dativform.',
    'exampleSentence': 'Er machte aus seinem Herzen keine Mördergrube.',
    'grammarRule': 'Idiomatik mit Dativform',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, er käme rechtzeitig, könnten wir noch den Zug erreichen.',
      'Angenommen er käme rechtzeitig, könnten wir noch den Zug erreichen.',
      'Angenommen, er käme rechtzeitig könnten wir noch den Zug erreichen.',
      'Angenommen er käme rechtzeitig könnten wir noch den Zug erreichen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "angenommen" steht ein Komma, ebenso zwischen dem Konditionalsatz und dem Hauptsatz.',
    'exampleSentence': 'Angenommen, er käme rechtzeitig, könnten wir noch den Zug erreichen.',
    'grammarRule': 'Kommasetzung nach satzeinleitendem Partizip',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Modus Operandi wurde analysiert.',
      'Die Modus Operandi wurde analysiert.',
      'Das Modus Operandi wurde analysiert.',
      'Der Modus Operandi wurden analysiert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Modus" ist Maskulinum: der Modus. "Wurde" steht im Singular.',
    'exampleSentence': 'Der Modus Operandi wurde analysiert.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist eines der Bücher, die mich am meisten beeindruckt haben.',
      'Das ist eines der Bücher, das mich am meisten beeindruckt hat.',
      'Das ist eines der Bücher, die mich am meisten beeindruckt hat.',
      'Das ist eines der Bücher, das mich am meisten beeindruckt haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der Relativsatz bezieht sich auf "Bücher" (Plural), daher "die ... haben".',
    'exampleSentence': 'Das ist eines der Bücher, die mich am meisten beeindruckt haben.',
    'grammarRule': 'Kongruenz im Relativsatz bei partitiver Konstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-036',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf dass der Friede walte, beteten sie inbrünstig.',
      'Auf das der Friede walte, beteten sie inbrünstig.',
      'Auf dass der Frieden waltet, beteten sie inbrünstig.',
      'Auf dass dem Friede walte, beteten sie inbrünstig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Auf dass" (Finalsatz, gehoben) verlangt Konjunktiv I: "walte". "Der Friede" ist die gehobene Form.',
    'exampleSentence': 'Auf dass der Friede walte, beteten sie inbrünstig.',
    'grammarRule': 'Finalsatz mit "auf dass" und Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet der widrigen Umstände beharrte sie auf ihrem Vorhaben.',
      'Ungeachtet den widrigen Umständen beharrte sie auf ihrem Vorhaben.',
      'Ungeachtet der widrigen Umstände beharrte sie auf ihr Vorhaben.',
      'Ungeachtet die widrigen Umstände beharrte sie auf ihrem Vorhaben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ungeachtet" regiert den Genitiv. "Beharren auf" regiert den Dativ: "auf ihrem Vorhaben".',
    'exampleSentence': 'Ungeachtet der widrigen Umstände beharrte sie auf ihrem Vorhaben.',
    'grammarRule': 'Gehobene Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Umso erstaunlicher war es, dass niemand protestierte.',
      'Umso erstaunlicher es war, dass niemand protestierte.',
      'Umso war es erstaunlicher, dass niemand protestierte.',
      'Es war umso erstaunlicher, dass niemand protestierte nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Umso erstaunlicher" als Prädikativ im Vorfeld verlangt Inversion: "war es".',
    'exampleSentence': 'Umso erstaunlicher war es, dass niemand protestierte.',
    'grammarRule': 'Inversion nach prädikativem Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er legte den Finger in die Wunde.',
      'Er legte den Finger in der Wunde.',
      'Er legte der Finger in die Wunde.',
      'Er legte den Finger in die Wunden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Redewendung lautet "den Finger in die Wunde legen" (Akkusativ: Richtung).',
    'exampleSentence': 'Er legte den Finger in die Wunde.',
    'grammarRule': 'Idiomatik mit Wechselpräposition (Akkusativ)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je länger er wartete, desto ungeduldiger wurde er.',
      'Je länger er wartete desto ungeduldiger wurde er.',
      'Je länger, er wartete, desto ungeduldiger wurde er.',
      'Je länger er wartete, desto ungeduldiger er wurde.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zwischen dem "je"-Satz und dem "desto"-Satz steht ein Komma. Im "desto"-Satz steht das Verb an zweiter Stelle.',
    'exampleSentence': 'Je länger er wartete, desto ungeduldiger wurde er.',
    'grammarRule': 'Kommasetzung und Wortstellung bei je ... desto',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er enthielt sich jeglicher Stellungnahme.',
      'Er enthielt sich jegliche Stellungnahme.',
      'Er enthielt sich jeglichem Stellungnahme.',
      'Er enthielt sich jeglichen Stellungnahme.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich enthalten" regiert den Genitiv: sich jeglicher Stellungnahme enthalten.',
    'exampleSentence': 'Er enthielt sich jeglicher Stellungnahme.',
    'grammarRule': 'Genitivrektion bei "sich enthalten"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Debakel war nicht mehr abzuwenden.',
      'Der Debakel war nicht mehr abzuwenden.',
      'Die Debakel war nicht mehr abzuwenden.',
      'Das Debakel waren nicht mehr abzuwenden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Debakel" ist Neutrum: das Debakel.',
    'exampleSentence': 'Das Debakel war nicht mehr abzuwenden.',
    'grammarRule': 'Genus bei Fremdwörtern auf -el',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sowohl der Direktor als auch die Lehrerin war eingeladen.',
      'Sowohl der Direktor als auch die Lehrerin waren eingeladen.',
      'Sowohl der Direktor als auch die Lehrerin wurde eingeladen.',
      'Sowohl dem Direktor als auch die Lehrerin war eingeladen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei "sowohl ... als auch" mit zwei Subjekten steht das Verb im Plural: "waren eingeladen".',
    'exampleSentence': 'Sowohl der Direktor als auch die Lehrerin waren eingeladen.',
    'grammarRule': 'Kongruenz bei additivem Subjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei denn, er ändere seine Meinung.',
      'Es sei denn, er ändert seine Meinung.',
      'Es sei denn, er ändere sein Meinung.',
      'Es sei den, er ändere seine Meinung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es sei denn" verlangt im gehobenen Stil den Konjunktiv I: "ändere".',
    'exampleSentence': 'Es sei denn, er ändere seine Meinung.',
    'grammarRule': 'Konjunktiv I nach "es sei denn"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kraft seines Amtes verfügte er die Schließung.',
      'Kraft seinem Amt verfügte er die Schließung.',
      'Kraft seines Amtes verfügte er der Schließung.',
      'Kraft sein Amt verfügte er die Schließung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kraft" als gehobene Präposition regiert den Genitiv: kraft seines Amtes.',
    'exampleSentence': 'Kraft seines Amtes verfügte er die Schließung.',
    'grammarRule': 'Amtssprachliche Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst wenn alle zugestimmt haben, wird der Vertrag unterzeichnet.',
      'Erst wenn alle zugestimmt haben, der Vertrag wird unterzeichnet.',
      'Erst wenn zugestimmt alle haben, wird der Vertrag unterzeichnet.',
      'Wenn erst alle zugestimmt haben, unterzeichnet der Vertrag wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz steht das Verb am Ende, im Hauptsatz nach dem Nebensatz an zweiter Stelle (Inversion).',
    'exampleSentence': 'Erst wenn alle zugestimmt haben, wird der Vertrag unterzeichnet.',
    'grammarRule': 'Verbstellung in Nebensatz-Hauptsatz-Folge',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat alle Hebel in Bewegung gesetzt.',
      'Er hat alle Hebel in Bewegung gebracht.',
      'Er hat allen Hebeln in Bewegung gesetzt.',
      'Er hat alle Hebel in die Bewegung gesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die feste Wendung lautet "alle Hebel in Bewegung setzen" (alle Mittel einsetzen).',
    'exampleSentence': 'Er hat alle Hebel in Bewegung gesetzt.',
    'grammarRule': 'Feste Verbindung mit Funktionsverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Buch, das er geschrieben hat, wurde ein Bestseller.',
      'Das Buch das er geschrieben hat, wurde ein Bestseller.',
      'Das Buch, das er geschrieben hat wurde ein Bestseller.',
      'Das Buch das er geschrieben hat wurde ein Bestseller.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene Relativsatz wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Das Buch, das er geschrieben hat, wurde ein Bestseller.',
    'grammarRule': 'Paarige Kommas bei eingeschobenem Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war sich dessen bewusst.',
      'Er war sich dem bewusst.',
      'Er war sich das bewusst.',
      'Er war sich desses bewusst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache bewusst sein" verlangt den Genitiv: "dessen" (Demonstrativpronomen im Genitiv).',
    'exampleSentence': 'Er war sich dessen bewusst.',
    'grammarRule': 'Genitivrektion bei prädikativem Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p1-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vermöge seiner Beredsamkeit überzeugte er die Versammlung.',
      'Vermöge seiner Beredsamkeit überzeugte er der Versammlung.',
      'Vermöge seinem Beredsamkeit überzeugte er die Versammlung.',
      'Vermöge seine Beredsamkeit überzeugte er die Versammlung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vermöge" ist eine gehobene Präposition mit Genitiv. "Die Versammlung" steht im Akkusativ als Objekt.',
    'exampleSentence': 'Vermöge seiner Beredsamkeit überzeugte er die Versammlung.',
    'grammarRule': 'Gehobene Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  }
];

export default questions;
