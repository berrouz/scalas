import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mitnichten war er bereit, nachzugeben.',
      'Mitnichten er war bereit, nachzugeben.',
      'Mitnichten war bereit er, nachzugeben.',
      'Er mitnichten war bereit, nachzugeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "mitnichten" im Vorfeld steht das Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Mitnichten war er bereit, nachzugeben.',
    'grammarRule': 'Inversion nach gehobener Negationspartikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob arm, ob reich, vor dem Gesetz sind alle gleich.',
      'Ob arm ob reich vor dem Gesetz sind alle gleich.',
      'Ob arm, ob reich vor dem Gesetz sind alle gleich.',
      'Ob arm ob reich, vor dem Gesetz sind alle gleich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei der Doppelformel "ob ... ob" stehen Kommas zwischen den Gliedern und vor dem Hauptsatz.',
    'exampleSentence': 'Ob arm, ob reich, vor dem Gesetz sind alle gleich.',
    'grammarRule': 'Kommasetzung bei konzessiver Doppelformel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er entzog sich jeglicher Kontrolle.',
      'Er entzog sich jegliche Kontrolle.',
      'Er entzog sich jeglichem Kontrolle.',
      'Er entzog sich jeglicher Kontrollierung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache entziehen" regiert den Dativ: "jeglicher Kontrolle".',
    'exampleSentence': 'Er entzog sich jeglicher Kontrolle.',
    'grammarRule': 'Dativrektion bei "sich entziehen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Dekorum wurde streng eingehalten.',
      'Der Dekorum wurde streng eingehalten.',
      'Die Dekorum wurde streng eingehalten.',
      'Das Dekorum wurden streng eingehalten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dekorum" ist Neutrum: das Dekorum.',
    'exampleSentence': 'Das Dekorum wurde streng eingehalten.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Derjenige, der die Wahrheit spricht, braucht ein schnelles Pferd.',
      'Derjenige, der die Wahrheit spricht, brauchen ein schnelles Pferd.',
      'Derjenige, die die Wahrheit spricht, braucht ein schnelles Pferd.',
      'Derjenige, der die Wahrheit spricht, braucht einen schnellen Pferd.'
    ],
    'correctAnswer': 0,
    'explanation': '"Derjenige" (maskulin, Singular) verlangt "der" im Relativsatz und "braucht" im Hauptsatz.',
    'exampleSentence': 'Derjenige, der die Wahrheit spricht, braucht ein schnelles Pferd.',
    'grammarRule': 'Kongruenz bei Demonstrativpronomen mit Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei ferne von mir, dies zu behaupten.',
      'Es sei fern von mir, dies zu behaupten.',
      'Es ist ferne von mir, dies zu behaupten.',
      'Es sei ferne von mich, dies zu behaupten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es sei ferne von mir" ist eine archaische Beteuerungsformel mit Konjunktiv I und der alten Form "ferne".',
    'exampleSentence': 'Es sei ferne von mir, dies zu behaupten.',
    'grammarRule': 'Archaische Beteuerungsformel mit Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Halber Verrichtung kehrte er um.',
      'Halber Verrichtungen kehrte er um.',
      'Halber die Verrichtung kehrte er um.',
      'Halbe Verrichtung kehrte er um.'
    ],
    'correctAnswer': 0,
    'explanation': '"Halber" als nachgestellte Genitivpräposition kann auch vorangestellt werden: "halber Verrichtung" (unverrichteter Dinge).',
    'exampleSentence': 'Unverrichteter Dinge kehrte er um.',
    'grammarRule': 'Gehobene Genitivpräposition "halber"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allein die Tatsache, dass er kam, überraschte alle.',
      'Allein die Tatsache dass er kam, überraschte alle.',
      'Allein die Tatsache, dass er kam überraschte alle.',
      'Allein die Tatsache, dass kam er, überraschte alle.'
    ],
    'correctAnswer': 0,
    'explanation': '"Allein die Tatsache" im Vorfeld, gefolgt von einem Relativsatz mit Kommas. Im "dass"-Satz steht das Verb am Ende.',
    'exampleSentence': 'Allein die Tatsache, dass er kam, überraschte alle.',
    'grammarRule': 'Vorfeldbesetzung mit erweitertem Subjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat die Flinte ins Korn geworfen.',
      'Er hat die Flinte im Korn geworfen.',
      'Er hat die Flinte ins Korn geworft.',
      'Er hat dem Flinte ins Korn geworfen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Die Flinte ins Korn werfen" (aufgeben). "Ins" = in das (Akkusativ). Partizip II: "geworfen".',
    'exampleSentence': 'Er hat die Flinte ins Korn geworfen.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er kam, wie er es angekündigt hatte, pünktlich um acht.',
      'Er kam wie er es angekündigt hatte pünktlich um acht.',
      'Er kam, wie er es angekündigt hatte pünktlich um acht.',
      'Er kam wie er es angekündigt hatte, pünktlich um acht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene Vergleichssatz wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Er kam, wie er es angekündigt hatte, pünktlich um acht.',
    'grammarRule': 'Paarige Kommas bei eingeschobenem Vergleichssatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist ihrer Aufgabe überdrüssig.',
      'Sie ist ihre Aufgabe überdrüssig.',
      'Sie ist ihrem Aufgabe überdrüssig.',
      'Sie ist ihrer Aufgabe überdrüssige.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache überdrüssig sein" regiert den Genitiv: "ihrer Aufgabe".',
    'exampleSentence': 'Sie ist ihrer Aufgabe überdrüssig.',
    'grammarRule': 'Genitivrektion bei "überdrüssig"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Konsens wurde rasch erzielt.',
      'Das Konsens wurde rasch erzielt.',
      'Die Konsens wurde rasch erzielt.',
      'Der Konsens wurden rasch erzielt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Konsens" ist Maskulinum: der Konsens.',
    'exampleSentence': 'Der Konsens wurde rasch erzielt.',
    'grammarRule': 'Genus bei Fremdwörtern aus dem Lateinischen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ihm als dem Ältesten gebührt der Vortritt.',
      'Ihm als der Älteste gebührt der Vortritt.',
      'Ihn als dem Ältesten gebührt der Vortritt.',
      'Ihm als den Ältesten gebührt der Vortritt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ihm" im Dativ, die Apposition "als dem Ältesten" kongruiert im Kasus (Dativ).',
    'exampleSentence': 'Ihm als dem Ältesten gebührt der Vortritt.',
    'grammarRule': 'Kasuskongruenz bei Apposition mit "als"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wähnte sich in Sicherheit.',
      'Er wähnte sich in Sicherheit sein.',
      'Er wähnte ihm in Sicherheit.',
      'Er wähnete sich in Sicherheit.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich in Sicherheit wähnen" (sich fälschlich sicher fühlen). Reflexivpronomen im Akkusativ: "sich".',
    'exampleSentence': 'Er wähnte sich in Sicherheit.',
    'grammarRule': 'Gehobenes Verb "wähnen" mit reflexivem Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Hinblick auf die bevorstehenden Wahlen ist Vorsicht geboten.',
      'In Hinblick auf den bevorstehenden Wahlen ist Vorsicht geboten.',
      'Im Hinblick auf die bevorstehende Wahlen ist Vorsicht geboten.',
      'Im Hinblick auf der bevorstehenden Wahlen ist Vorsicht geboten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Im Hinblick auf" regiert den Akkusativ: "die bevorstehenden Wahlen".',
    'exampleSentence': 'Im Hinblick auf die bevorstehenden Wahlen ist Vorsicht geboten.',
    'grammarRule': 'Gehobene Präpositionalphrase mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Keineswegs war er damit einverstanden.',
      'Keineswegs er war damit einverstanden.',
      'Keineswegs war damit er einverstanden.',
      'Er keineswegs war damit einverstanden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der Negationspartikel "keineswegs" im Vorfeld folgt Inversion.',
    'exampleSentence': 'Keineswegs war er damit einverstanden.',
    'grammarRule': 'Inversion nach Negationspartikel im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich auf dünnes Eis begeben.',
      'Er hat sich auf dünnem Eis begeben.',
      'Er hat sich auf dünnes Eis begaben.',
      'Er hat sich auf dem dünnen Eis begeben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich auf dünnes Eis begeben" (ein Risiko eingehen). Akkusativ: "auf dünnes Eis" (Richtung).',
    'exampleSentence': 'Er hat sich auf dünnes Eis begeben.',
    'grammarRule': 'Idiomatische Wendung mit Wechselpräposition (Akkusativ)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist, soviel ich weiß, bereits abgereist.',
      'Er ist soviel ich weiß bereits abgereist.',
      'Er ist, soviel ich weiß bereits abgereist.',
      'Er ist soviel ich weiß, bereits abgereist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene Nebensatz "soviel ich weiß" wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Er ist, soviel ich weiß, bereits abgereist.',
    'grammarRule': 'Paarige Kommas bei parenthetischem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich des Betrugs schuldig gemacht.',
      'Er hat sich den Betrug schuldig gemacht.',
      'Er hat sich dem Betrug schuldig gemacht.',
      'Er hat sich des Betruges schuldig gemachen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache schuldig machen" regiert den Genitiv: "des Betrugs".',
    'exampleSentence': 'Er hat sich des Betrugs schuldig gemacht.',
    'grammarRule': 'Genitivrektion bei "schuldig machen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kontroverse entfachte eine heftige Debatte.',
      'Der Kontroverse entfachte eine heftige Debatte.',
      'Das Kontroverse entfachte eine heftige Debatte.',
      'Die Kontroverse entfachte einen heftigen Debatte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kontroverse" ist Femininum: die Kontroverse. "Eine heftige Debatte" im Akkusativ.',
    'exampleSentence': 'Die Kontroverse entfachte eine heftige Debatte.',
    'grammarRule': 'Genus bei Fremdwörtern auf -e',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es waren nicht wenige, die sich dagegen aussprachen.',
      'Es war nicht wenige, die sich dagegen aussprachen.',
      'Es waren nicht wenige, die sich dagegen aussprach.',
      'Es waren nicht wenigen, die sich dagegen aussprachen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nicht wenige" (Plural) verlangt "waren". Im Relativsatz: "die ... aussprachen" (Plural).',
    'exampleSentence': 'Es waren nicht wenige, die sich dagegen aussprachen.',
    'grammarRule': 'Kongruenz bei litotischer Pluralkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er zürnte denen, die ihm Unrecht getan hatten.',
      'Er zürnte die, die ihm Unrecht getan hatten.',
      'Er zürnete denen, die ihm Unrecht getan hatten.',
      'Er zürnte denen, die ihn Unrecht getan hatten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zürnen" (gehoben: zornig sein) regiert den Dativ: "denen". "Ihm Unrecht tun" mit Dativ.',
    'exampleSentence': 'Er zürnte denen, die ihm Unrecht getan hatten.',
    'grammarRule': 'Gehobenes Verb mit Dativrektion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ausweislich der Akten ist der Sachverhalt eindeutig.',
      'Ausweislich den Akten ist der Sachverhalt eindeutig.',
      'Ausweislich die Akten ist der Sachverhalt eindeutig.',
      'Ausweislich der Akten ist den Sachverhalt eindeutig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ausweislich" ist eine amtssprachliche Präposition mit Genitiv: "der Akten".',
    'exampleSentence': 'Ausweislich der Akten ist der Sachverhalt eindeutig.',
    'grammarRule': 'Amtssprachliche Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem er gesprochen hatte, trat er ab.',
      'Nachdem er gesprochen hatte, er trat ab.',
      'Nachdem gesprochen er hatte, trat er ab.',
      'Nachdem er hatte gesprochen, trat er ab.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "nachdem" steht das Hilfsverb am Ende. Im Hauptsatz folgt Inversion.',
    'exampleSentence': 'Nachdem er gesprochen hatte, trat er ab.',
    'grammarRule': 'Verbstellung in temporalem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr Steine in den Weg gelegt.',
      'Er hat ihr Steine in dem Weg gelegt.',
      'Er hat sie Steine in den Weg gelegt.',
      'Er hat ihr Steinen in den Weg gelegt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem Steine in den Weg legen" (Hindernisse schaffen). Dativ: "ihr", Akkusativ: "in den Weg".',
    'exampleSentence': 'Er hat ihr Steine in den Weg gelegt.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestoweniger, und das betone ich ausdrücklich, bleibe ich bei meiner Meinung.',
      'Nichtsdestoweniger und das betone ich ausdrücklich bleibe ich bei meiner Meinung.',
      'Nichtsdestoweniger, und das betone ich ausdrücklich bleibe ich bei meiner Meinung.',
      'Nichtsdestoweniger und das betone ich ausdrücklich, bleibe ich bei meiner Meinung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der parenthetische Einschub "und das betone ich ausdrücklich" wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Nichtsdestoweniger, und das betone ich ausdrücklich, bleibe ich bei meiner Meinung.',
    'grammarRule': 'Paarige Kommas bei parenthetischem Einschub',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie war der Hilfe bedürftig.',
      'Sie war die Hilfe bedürftig.',
      'Sie war dem Hilfe bedürftig.',
      'Sie war der Hilfe bedürftige.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache bedürftig sein" regiert den Genitiv: "der Hilfe".',
    'exampleSentence': 'Sie war der Hilfe bedürftig.',
    'grammarRule': 'Genitivrektion bei "bedürftig"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Privileg wurde ihm entzogen.',
      'Der Privileg wurde ihm entzogen.',
      'Die Privileg wurde ihm entzogen.',
      'Das Privileg wurde ihn entzogen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Privileg" ist Neutrum: das Privileg. "Ihm" im Dativ.',
    'exampleSentence': 'Das Privileg wurde ihm entzogen.',
    'grammarRule': 'Genus bei Fremdwörtern aus dem Lateinischen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man hat ihn als den besten Kandidaten ausgewählt.',
      'Man hat ihn als der beste Kandidat ausgewählt.',
      'Man hat ihm als den besten Kandidaten ausgewählt.',
      'Man hat ihn als dem besten Kandidaten ausgewählt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ihn" steht im Akkusativ, die Apposition "als den besten Kandidaten" kongruiert im Kasus.',
    'exampleSentence': 'Man hat ihn als den besten Kandidaten ausgewählt.',
    'grammarRule': 'Kasuskongruenz bei Apposition mit "als"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er pflegte allabendlich einen Spaziergang zu machen.',
      'Er pflegte allabendlich ein Spaziergang zu machen.',
      'Er pflog allabendlich einen Spaziergang zu machen.',
      'Er pflegte allabends einen Spaziergang zu machen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Pflegte" (gewohnheitsmäßig tun) mit Infinitiv. "Allabendlich" ist ein gehobenes Adverb.',
    'exampleSentence': 'Er pflegte allabendlich einen Spaziergang zu machen.',
    'grammarRule': 'Gehobene Gewohnheitsangabe mit "pflegen" + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'In Anbetracht der Umstände erscheint dies gerechtfertigt.',
      'In Anbetracht den Umständen erscheint dies gerechtfertigt.',
      'In Anbetracht die Umstände erscheint dies gerechtfertigt.',
      'In Anbetracht der Umstände erscheint dies gerechtfertige.'
    ],
    'correctAnswer': 0,
    'explanation': '"In Anbetracht" regiert den Genitiv: "der Umstände".',
    'exampleSentence': 'In Anbetracht der Umstände erscheint dies gerechtfertigt.',
    'grammarRule': 'Gehobene Präpositionalphrase mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zumal es dunkel war, beschlossen sie umzukehren.',
      'Zumal es dunkel war beschlossen sie umzukehren.',
      'Zumal dunkel es war, beschlossen sie umzukehren.',
      'Zumal es dunkel war, sie beschlossen umzukehren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "zumal" steht das Verb am Ende. Der Hauptsatz beginnt mit dem finiten Verb (Inversion).',
    'exampleSentence': 'Zumal es dunkel war, beschlossen sie umzukehren.',
    'grammarRule': 'Verbstellung bei "zumal" mit Inversion im Hauptsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm einen Bären aufgebunden.',
      'Sie hat ihn einen Bären aufgebunden.',
      'Sie hat ihm einen Bär aufgebunden.',
      'Sie hat ihm einen Bären aufgebinden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem einen Bären aufbinden" (jemanden belügen). Dativ: "ihm". Partizip II: "aufgebunden".',
    'exampleSentence': 'Sie hat ihm einen Bären aufgebunden.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und schwacher Deklination',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dies ist, wie gesagt, nur eine vorläufige Einschätzung.',
      'Dies ist wie gesagt nur eine vorläufige Einschätzung.',
      'Dies ist, wie gesagt nur eine vorläufige Einschätzung.',
      'Dies ist wie gesagt, nur eine vorläufige Einschätzung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wie gesagt" als parenthetischer Einschub wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Dies ist, wie gesagt, nur eine vorläufige Einschätzung.',
    'grammarRule': 'Paarige Kommas bei verkürztem Vergleichssatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie erfreute sich bester Gesundheit.',
      'Sie erfreute sich beste Gesundheit.',
      'Sie erfreute sich bestem Gesundheit.',
      'Sie erfreute sich bester Gesundheiten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache erfreuen" regiert den Genitiv: "bester Gesundheit".',
    'exampleSentence': 'Sie erfreute sich bester Gesundheit.',
    'grammarRule': 'Genitivrektion bei "sich erfreuen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-036',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Curriculum wurde überarbeitet.',
      'Der Curriculum wurde überarbeitet.',
      'Die Curriculum wurde überarbeitet.',
      'Das Curriculum wurden überarbeitet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Curriculum" ist Neutrum: das Curriculum.',
    'exampleSentence': 'Das Curriculum wurde überarbeitet.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Alle, die eingeladen waren, kamen pünktlich.',
      'Alle, die eingeladen war, kamen pünktlich.',
      'Alle, die eingeladen waren, kam pünktlich.',
      'Allen, die eingeladen waren, kamen pünktlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Alle" (Plural) verlangt "kamen". Im Relativsatz: "waren" (Plural).',
    'exampleSentence': 'Alle, die eingeladen waren, kamen pünktlich.',
    'grammarRule': 'Durchgängige Pluralkongruenz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es obliegt ihm, die Entscheidung zu treffen.',
      'Es obliegt ihn, die Entscheidung zu treffen.',
      'Es obliegt er, die Entscheidung zu treffen.',
      'Es oblieget ihm, die Entscheidung zu treffen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Obliegen" (gehoben: jemandes Pflicht sein) regiert den Dativ: "ihm".',
    'exampleSentence': 'Es obliegt ihm, die Entscheidung zu treffen.',
    'grammarRule': 'Gehobenes Verb mit Dativrektion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter Zugrundelegung der vorliegenden Daten ergibt sich Folgendes.',
      'Unter Zugrundelegung den vorliegenden Daten ergibt sich Folgendes.',
      'Unter Zugrundelegung der vorliegende Daten ergibt sich Folgendes.',
      'Unter Zugrundelegung der vorliegenden Daten ergibt sich folgendes.'
    ],
    'correctAnswer': 0,
    'explanation': '"Unter Zugrundelegung" regiert den Genitiv: "der vorliegenden Daten". "Folgendes" als Substantivierung groß.',
    'exampleSentence': 'Unter Zugrundelegung der vorliegenden Daten ergibt sich Folgendes.',
    'grammarRule': 'Amtssprachliche Nominalphrase mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dessen ungeachtet beharrte er auf seinem Standpunkt.',
      'Dessen ungeachtet er beharrte auf seinem Standpunkt.',
      'Ungeachtet dessen er beharrte auf seinem Standpunkt.',
      'Dessen ungeachtet beharrte er auf seinen Standpunkt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dessen ungeachtet" im Vorfeld verlangt Inversion. "Auf seinem Standpunkt" im Dativ.',
    'exampleSentence': 'Dessen ungeachtet beharrte er auf seinem Standpunkt.',
    'grammarRule': 'Inversion nach gehobener Genitivkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm den Spiegel vorgehalten.',
      'Sie hat ihn den Spiegel vorgehalten.',
      'Sie hat ihm dem Spiegel vorgehalten.',
      'Sie hat ihm den Spiegel vorgehaltet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem den Spiegel vorhalten" (Fehler aufzeigen). Dativ: "ihm". Partizip II: "vorgehalten".',
    'exampleSentence': 'Sie hat ihm den Spiegel vorgehalten.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und starkem Partizip',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Darüber, wie es weitergehen soll, herrscht Uneinigkeit.',
      'Darüber wie es weitergehen soll herrscht Uneinigkeit.',
      'Darüber, wie es weitergehen soll herrscht Uneinigkeit.',
      'Darüber wie es weitergehen soll, herrscht Uneinigkeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Korrelat "darüber" steht ein Komma vor dem Nebensatz, und nach dem Nebensatz ebenfalls.',
    'exampleSentence': 'Darüber, wie es weitergehen soll, herrscht Uneinigkeit.',
    'grammarRule': 'Kommasetzung bei Korrelat mit Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist jeder Anstrengung wert.',
      'Er ist jede Anstrengung wert.',
      'Er ist jedem Anstrengung wert.',
      'Er ist jeder Anstrengung wertes.'
    ],
    'correctAnswer': 1,
    'explanation': '"Etwas wert sein" regiert den Akkusativ: "jede Anstrengung".',
    'exampleSentence': 'Er ist jede Anstrengung wert.',
    'grammarRule': 'Akkusativrektion bei "wert sein"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Tenor seiner Rede war versöhnlich.',
      'Das Tenor seiner Rede war versöhnlich.',
      'Die Tenor seiner Rede war versöhnlich.',
      'Der Tenor sein Rede war versöhnlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Tenor" (im Sinne von Grundhaltung, Sinn) ist Maskulinum: der Tenor.',
    'exampleSentence': 'Der Tenor seiner Rede war versöhnlich.',
    'grammarRule': 'Genus bei Homonymen mit verschiedener Bedeutung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sowohl das Buch als auch der Film sind empfehlenswert.',
      'Sowohl das Buch als auch der Film ist empfehlenswert.',
      'Sowohl das Buch als auch den Film sind empfehlenswert.',
      'Sowohl dem Buch als auch der Film sind empfehlenswert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "sowohl ... als auch" mit zwei Subjekten steht das Verb im Plural.',
    'exampleSentence': 'Sowohl das Buch als auch der Film sind empfehlenswert.',
    'grammarRule': 'Kongruenz bei additivem Subjekt mit "sowohl ... als auch"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wohlgemerkt, dies ist nur ein Entwurf.',
      'Wohl gemerkt, dies ist nur ein Entwurf.',
      'Wohlgemerkt dies ist nur ein Entwurf.',
      'Wohlgemerkt, dies ist nur einen Entwurf.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wohlgemerkt" (zusammengeschrieben) als Satzadverb wird durch Komma abgetrennt.',
    'exampleSentence': 'Wohlgemerkt, dies ist nur ein Entwurf.',
    'grammarRule': 'Gehobenes Satzadverb mit Komma',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mithilfe des neuen Verfahrens konnte das Problem gelöst werden.',
      'Mithilfe dem neuen Verfahren konnte das Problem gelöst werden.',
      'Mit Hilfe des neuen Verfahrens konnte das Problem gelöst werden.',
      'Mithilfe den neuen Verfahrens konnte das Problem gelöst werden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mithilfe" (zusammengeschrieben) regiert den Genitiv: "des neuen Verfahrens".',
    'exampleSentence': 'Mithilfe des neuen Verfahrens konnte das Problem gelöst werden.',
    'grammarRule': 'Präposition "mithilfe" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sosehr er sich auch anstrengte, das Ergebnis blieb unbefriedigend.',
      'Sosehr er sich auch anstrengte das Ergebnis blieb unbefriedigend.',
      'Sosehr er auch sich anstrengte, das Ergebnis blieb unbefriedigend.',
      'Sosehr auch er sich anstrengte, das Ergebnis blieb unbefriedigend.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sosehr" leitet einen konzessiven Nebensatz ein. Im Hauptsatz steht das Subjekt an erster Stelle.',
    'exampleSentence': 'Sosehr er sich auch anstrengte, das Ergebnis blieb unbefriedigend.',
    'grammarRule': 'Konzessiver Nebensatz mit "sosehr"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihm den Rang abgelaufen.',
      'Er hat ihn den Rang abgelaufen.',
      'Er hat ihm dem Rang abgelaufen.',
      'Er hat ihm den Rang abgelauft.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem den Rang ablaufen" (jemanden übertreffen). Dativ: "ihm". Partizip II: "abgelaufen".',
    'exampleSentence': 'Er hat ihm den Rang abgelaufen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und starkem Partizip',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p7-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Frage, ob dies rechtens sei, bleibt offen.',
      'Die Frage ob dies rechtens sei bleibt offen.',
      'Die Frage, ob dies rechtens sei bleibt offen.',
      'Die Frage ob dies rechtens sei, bleibt offen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene indirekte Fragesatz wird durch paarige Kommas vom Hauptsatz getrennt.',
    'exampleSentence': 'Die Frage, ob dies rechtens sei, bleibt offen.',
    'grammarRule': 'Paarige Kommas bei eingeschobenem indirekten Fragesatz',
    'tags': ['satzkorrektur']
  }
];

export default questions;
