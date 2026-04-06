import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er verließ das Haus, ohne sich umzudrehen.',
      'Er verließ das Haus ohne sich umzudrehen.',
      'Er verließ das Haus, ohne sich, umzudrehen.',
      'Er verließ das Haus ohne sich, umzudrehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "ohne ... zu" steht ein Komma, da es eine Infinitivgruppe einleitet.',
    'exampleSentence': 'Er verließ das Haus, ohne sich umzudrehen.',
    'grammarRule': 'Kommasetzung bei Infinitivgruppen mit "ohne ... zu"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wurde des Landes verwiesen.',
      'Sie wurde dem Land verwiesen.',
      'Sie wurde das Land verwiesen.',
      'Sie wurde den Landes verwiesen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Landes verweisen" ist eine gehobene Konstruktion mit Genitiv (jemanden des Landes verweisen).',
    'exampleSentence': 'Sie wurde des Landes verwiesen.',
    'grammarRule': 'Genitivrektion bei "verweisen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Pensum wurde in Rekordzeit bewältigt.',
      'Der Pensum wurde in Rekordzeit bewältigt.',
      'Die Pensum wurde in Rekordzeit bewältigt.',
      'Das Pensum wurde in Rekordzeit bewältigte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Pensum" ist Neutrum: das Pensum.',
    'exampleSentence': 'Das Pensum wurde in Rekordzeit bewältigt.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Mehrzahl der Studenten hat die Prüfung bestanden.',
      'Die Mehrzahl der Studenten haben die Prüfung bestanden.',
      'Die Mehrzahl der Studenten hat die Prüfung bestand.',
      'Die Mehrzahl der Studente hat die Prüfung bestanden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "die Mehrzahl" als Subjektkern steht das Verb im Singular: "hat bestanden".',
    'exampleSentence': 'Die Mehrzahl der Studenten hat die Prüfung bestanden.',
    'grammarRule': 'Kongruenz bei kollektiven Mengenangaben',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dem sei, wie ihm wolle, wir müssen handeln.',
      'Dem sei, wie er wolle, wir müssen handeln.',
      'Dem sei, wie ihm will, wir müssen handeln.',
      'Den sei, wie ihm wolle, wir müssen handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die gehobene Formel "dem sei, wie ihm wolle" (wie auch immer es sei) verwendet Konjunktiv I und Dativpronomen.',
    'exampleSentence': 'Dem sei, wie ihm wolle, wir müssen handeln.',
    'grammarRule': 'Archaische Konzessivformel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seines Zeichens war er Uhrmacher.',
      'Seinen Zeichens war er Uhrmacher.',
      'Seines Zeichen war er Uhrmacher.',
      'Seinem Zeichen war er Uhrmacher.'
    ],
    'correctAnswer': 0,
    'explanation': '"Seines Zeichens" ist eine gehobene Genitivkonstruktion zur Berufsbezeichnung.',
    'exampleSentence': 'Seines Zeichens war er Uhrmacher.',
    'grammarRule': 'Gehobener Genitiv der Berufsbezeichnung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nie zuvor hatte er eine solche Demütigung erfahren.',
      'Nie zuvor er hatte eine solche Demütigung erfahren.',
      'Nie zuvor hatte eine solche Demütigung er erfahren.',
      'Er nie zuvor hatte eine solche Demütigung erfahren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem negierten Temporaladverb "nie zuvor" steht das Verb vor dem Subjekt (Inversion).',
    'exampleSentence': 'Nie zuvor hatte er eine solche Demütigung erfahren.',
    'grammarRule': 'Inversion nach negiertem Adverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie gab ihm den Laufpass.',
      'Sie gab ihm einen Laufpass.',
      'Sie gab ihn den Laufpass.',
      'Sie gab ihm dem Laufpass.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die feste Wendung lautet "jemandem den Laufpass geben" (mit bestimmtem Artikel).',
    'exampleSentence': 'Sie gab ihm den Laufpass.',
    'grammarRule': 'Idiomatische Wendung mit bestimmtem Artikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sein Ziel, nämlich die Beförderung, hatte er erreicht.',
      'Sein Ziel nämlich die Beförderung hatte er erreicht.',
      'Sein Ziel, nämlich die Beförderung hatte er erreicht.',
      'Sein Ziel nämlich, die Beförderung, hatte er erreicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Apposition "nämlich die Beförderung" wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Sein Ziel, nämlich die Beförderung, hatte er erreicht.',
    'grammarRule': 'Kommasetzung bei nachgestellter Apposition',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde des Hochverrats angeklagt.',
      'Er wurde den Hochverrat angeklagt.',
      'Er wurde dem Hochverrat angeklagt.',
      'Er wurde des Hochverrates anklagen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anklagen" im juristischen Kontext regiert den Genitiv der Sache: des Hochverrats angeklagt.',
    'exampleSentence': 'Er wurde des Hochverrats angeklagt.',
    'grammarRule': 'Genitivrektion bei "anklagen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Habitus des Gelehrten war bemerkenswert.',
      'Das Habitus des Gelehrten war bemerkenswert.',
      'Die Habitus des Gelehrten war bemerkenswert.',
      'Der Habitus dem Gelehrten war bemerkenswert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Habitus" ist Maskulinum: der Habitus. "Des Gelehrten" steht im Genitiv.',
    'exampleSentence': 'Der Habitus des Gelehrten war bemerkenswert.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jeder der Anwesenden musste seinen Ausweis vorzeigen.',
      'Jeder der Anwesenden musste sein Ausweis vorzeigen.',
      'Jeder der Anwesenden mussten seinen Ausweis vorzeigen.',
      'Jeder den Anwesenden musste seinen Ausweis vorzeigen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jeder" als Subjektkern verlangt Singular. "Seinen Ausweis" kongruiert mit dem maskulinen "jeder".',
    'exampleSentence': 'Jeder der Anwesenden musste seinen Ausweis vorzeigen.',
    'grammarRule': 'Kongruenz bei "jeder" mit partitivem Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hieß ihn willkommen und bat ihn herein.',
      'Er hießte ihn willkommen und bat ihn herein.',
      'Er hieß ihm willkommen und bat ihn herein.',
      'Er hieß ihn willkommen und bitte ihn herein.'
    ],
    'correctAnswer': 0,
    'explanation': '"Heißen" im Sinne von "begrüßen" hat das Präteritum "hieß" und regiert den Akkusativ: "ihn".',
    'exampleSentence': 'Er hieß ihn willkommen und bat ihn herein.',
    'grammarRule': 'Starke Konjugation und Akkusativrektion bei "heißen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Infolge des anhaltenden Regens trat der Fluss über die Ufer.',
      'Infolge dem anhaltenden Regen trat der Fluss über die Ufer.',
      'Infolge des anhaltenden Regens trat der Fluss über den Ufer.',
      'Infolge des anhaltende Regens trat der Fluss über die Ufer.'
    ],
    'correctAnswer': 0,
    'explanation': '"Infolge" regiert den Genitiv: "des anhaltenden Regens". "Über die Ufer" steht im Akkusativ.',
    'exampleSentence': 'Infolge des anhaltenden Regens trat der Fluss über die Ufer.',
    'grammarRule': 'Kausale Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Derart erschüttert war sie, dass sie kein Wort hervorbrachte.',
      'Derart erschüttert sie war, dass sie kein Wort hervorbrachte.',
      'Derart war sie erschüttert, dass sie kein Wort hervorbrachte.',
      'Sie derart erschüttert war, dass sie kein Wort hervorbrachte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei vorangestelltem "derart erschüttert" erfolgt Inversion: Verb vor Subjekt im Hauptsatz.',
    'exampleSentence': 'Derart erschüttert war sie, dass sie kein Wort hervorbrachte.',
    'grammarRule': 'Inversion nach vorangestelltem Prädikativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich ins eigene Fleisch geschnitten.',
      'Er hat sich in eigenes Fleisch geschnitten.',
      'Er hat sich ins eigenen Fleisch geschnitten.',
      'Er hat sich im eigenen Fleisch geschnitten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Redewendung lautet "sich ins eigene Fleisch schneiden" (Akkusativ: Richtung).',
    'exampleSentence': 'Er hat sich ins eigene Fleisch geschnitten.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie beschloss, statt in Urlaub zu fahren, zu Hause zu bleiben.',
      'Sie beschloss statt in Urlaub zu fahren zu Hause zu bleiben.',
      'Sie beschloss, statt in Urlaub zu fahren zu Hause zu bleiben.',
      'Sie beschloss statt in Urlaub zu fahren, zu Hause zu bleiben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die eingeschobene Infinitivgruppe mit "statt ... zu" wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Sie beschloss, statt in Urlaub zu fahren, zu Hause zu bleiben.',
    'grammarRule': 'Kommasetzung bei eingeschobener Infinitivgruppe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist sich ihrer Verantwortung bewusst.',
      'Sie ist sich ihre Verantwortung bewusst.',
      'Sie ist sich ihrem Verantwortung bewusst.',
      'Sie ist sich ihrer Verantwortung bewusste.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache bewusst sein" verlangt den Genitiv: ihrer Verantwortung.',
    'exampleSentence': 'Sie ist sich ihrer Verantwortung bewusst.',
    'grammarRule': 'Genitivrektion bei "bewusst sein"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Mandat wurde dem Abgeordneten entzogen.',
      'Der Mandat wurde dem Abgeordneten entzogen.',
      'Die Mandat wurde dem Abgeordneten entzogen.',
      'Das Mandat wurde den Abgeordneten entzog.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mandat" ist Neutrum: das Mandat. "Dem Abgeordneten" steht im Dativ.',
    'exampleSentence': 'Das Mandat wurde dem Abgeordneten entzogen.',
    'grammarRule': 'Genus bei politischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es waren einmal ein König und eine Königin.',
      'Es war einmal ein König und eine Königin.',
      'Es waren einmal einen König und eine Königin.',
      'Es war einmal einer König und eine Königin.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei zwei Subjekten im Nachfeld richtet sich das Verb nach dem Gesamtsubjekt: Plural "waren".',
    'exampleSentence': 'Es waren einmal ein König und eine Königin.',
    'grammarRule': 'Kongruenz bei nachgestelltem Doppelsubjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So Gott will, werden wir uns wiedersehen.',
      'So Gott wollt, werden wir uns wiedersehen.',
      'So Gott wollen, werden wir uns wiedersehen.',
      'So Gott willt, werden wir uns wiedersehen.'
    ],
    'correctAnswer': 0,
    'explanation': '"So Gott will" ist eine archaische Formel mit Indikativ Präsens von "wollen".',
    'exampleSentence': 'So Gott will, werden wir uns wiedersehen.',
    'grammarRule': 'Archaische Kondizionalformel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zufolge seiner Aussage habe er nichts bemerkt.',
      'Zufolge seine Aussage habe er nichts bemerkt.',
      'Zufolge seinen Aussage habe er nichts bemerkt.',
      'Zufolge seiner Aussage hat er nichts bemerkt haben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zufolge" kann vorangestellt den Genitiv regieren. "Habe" steht im Konjunktiv I (indirekte Rede).',
    'exampleSentence': 'Zufolge seiner Aussage habe er nichts bemerkt.',
    'grammarRule': 'Vorangestelltes "zufolge" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter keinen Umständen darf dies geschehen.',
      'Unter keinen Umständen dies darf geschehen.',
      'Dies unter keinen Umständen geschehen darf.',
      'Unter keinen Umständen dies geschehen darf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem negierten Adverbial im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Unter keinen Umständen darf dies geschehen.',
    'grammarRule': 'Verbzweitstellung nach negiertem Adverbial',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er trieb es auf die Spitze.',
      'Er trieb es auf der Spitze.',
      'Er trieb es an die Spitze.',
      'Er trieb es auf den Spitze.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Redewendung lautet "es auf die Spitze treiben" (Akkusativ: Richtung).',
    'exampleSentence': 'Er trieb es auf die Spitze.',
    'grammarRule': 'Idiomatik mit Wechselpräposition',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er fragte, ob sie komme, und wartete geduldig.',
      'Er fragte ob sie komme und wartete geduldig.',
      'Er fragte, ob sie komme und wartete geduldig.',
      'Er fragte ob sie komme, und wartete geduldig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der Nebensatz mit "ob" wird durch Komma abgetrennt, ebenso endet er vor "und" des neuen Hauptsatzes.',
    'exampleSentence': 'Er fragte, ob sie komme, und wartete geduldig.',
    'grammarRule': 'Kommasetzung bei Nebensatz zwischen Hauptsätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie konnte sich des Eindrucks nicht erwehren.',
      'Sie konnte sich den Eindruck nicht erwehren.',
      'Sie konnte sich dem Eindruck nicht erwehren.',
      'Sie konnte sich des Eindruckes nicht erwähren.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache erwehren" regiert den Genitiv: des Eindrucks.',
    'exampleSentence': 'Sie konnte sich des Eindrucks nicht erwehren.',
    'grammarRule': 'Genitivrektion bei "sich erwehren"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Exodus der Bevölkerung hielt an.',
      'Das Exodus der Bevölkerung hielt an.',
      'Die Exodus der Bevölkerung hielt an.',
      'Der Exodus die Bevölkerung hielt an.'
    ],
    'correctAnswer': 0,
    'explanation': '"Exodus" ist Maskulinum: der Exodus.',
    'exampleSentence': 'Der Exodus der Bevölkerung hielt an.',
    'grammarRule': 'Genus bei griechischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist einer derjenigen, die sich dagegen ausgesprochen haben.',
      'Er ist einer derjenigen, der sich dagegen ausgesprochen hat.',
      'Er ist einer derjenigen, die sich dagegen ausgesprochen hat.',
      'Er ist einer denjenigen, die sich dagegen ausgesprochen haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der Relativsatz bezieht sich auf "derjenigen" (Plural), daher "die ... haben".',
    'exampleSentence': 'Er ist einer derjenigen, die sich dagegen ausgesprochen haben.',
    'grammarRule': 'Kongruenz im Relativsatz nach partitivem Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sprach: Es werde Licht!',
      'Er sprach: Es wird Licht!',
      'Er sprach: Es würde Licht!',
      'Er sprach: Es warden Licht!'
    ],
    'correctAnswer': 0,
    'explanation': 'Die biblische Formel verwendet den Konjunktiv I (Jussiv): "es werde Licht".',
    'exampleSentence': 'Er sprach: Es werde Licht!',
    'grammarRule': 'Jussiver Konjunktiv I in biblischer Sprache',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angesichts der drohenden Gefahr evakuierte man das Gebäude.',
      'Angesichts den drohenden Gefahr evakuierte man das Gebäude.',
      'Angesichts der drohende Gefahr evakuierte man das Gebäude.',
      'Angesichts der drohenden Gefahr evakuierte man dem Gebäude.'
    ],
    'correctAnswer': 0,
    'explanation': '"Angesichts" regiert den Genitiv: "der drohenden Gefahr". "Das Gebäude" steht im Akkusativ.',
    'exampleSentence': 'Angesichts der drohenden Gefahr evakuierte man das Gebäude.',
    'grammarRule': 'Gehobene Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So groß war seine Freude, dass er vor Glück weinte.',
      'So groß seine Freude war, dass er vor Glück weinte.',
      'So groß war seine Freude, dass vor Glück er weinte.',
      'Seine Freude so groß war, dass er vor Glück weinte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das vorangestellte Prädikativ "so groß" löst Inversion aus: "war seine Freude".',
    'exampleSentence': 'So groß war seine Freude, dass er vor Glück weinte.',
    'grammarRule': 'Inversion bei vorangestelltem Gradpartikel-Prädikativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Nagel auf den Kopf getroffen.',
      'Er hat den Nagel auf dem Kopf getroffen.',
      'Er hat den Nagel an den Kopf getroffen.',
      'Er hat dem Nagel auf den Kopf getroffen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Redewendung lautet "den Nagel auf den Kopf treffen" (den Kern der Sache treffen).',
    'exampleSentence': 'Er hat den Nagel auf den Kopf getroffen.',
    'grammarRule': 'Idiomatische Wendung mit doppeltem Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie bereits erwähnt, bedarf es keiner weiteren Erörterung.',
      'Wie bereits erwähnt bedarf es keiner weiteren Erörterung.',
      'Wie bereits, erwähnt bedarf es keiner weiteren Erörterung.',
      'Wie, bereits erwähnt, bedarf es keiner weiteren Erörterung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der verkürzende Nebensatz "wie bereits erwähnt" wird durch Komma vom Hauptsatz getrennt.',
    'exampleSentence': 'Wie bereits erwähnt, bedarf es keiner weiteren Erörterung.',
    'grammarRule': 'Kommasetzung nach vergleichendem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie harrte der Dinge, die da kommen sollten.',
      'Sie harrte den Dingen, die da kommen sollten.',
      'Sie harrte die Dinge, die da kommen sollten.',
      'Sie harrte dem Dingen, die da kommen sollten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Harren" ist ein gehobenes Verb mit Genitivrektion: einer Sache harren.',
    'exampleSentence': 'Sie harrte der Dinge, die da kommen sollten.',
    'grammarRule': 'Genitivrektion bei "harren"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Paradoxon ließ sich nicht auflösen.',
      'Der Paradoxon ließ sich nicht auflösen.',
      'Die Paradoxon ließ sich nicht auflösen.',
      'Das Paradoxon ließ sich nicht aufzulösen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Paradoxon" ist Neutrum: das Paradoxon.',
    'exampleSentence': 'Das Paradoxon ließ sich nicht auflösen.',
    'grammarRule': 'Genus bei griechischen Fremdwörtern auf -on',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mich dünkt, er habe nicht die Wahrheit gesprochen.',
      'Mir dünkt, er habe nicht die Wahrheit gesprochen.',
      'Mich dünkt, er hat nicht die Wahrheit gesprochen.',
      'Mich denkt, er habe nicht die Wahrheit gesprochen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mich dünkt" ist die archaische unpersönliche Konstruktion (Akkusativ der Person). Der Nebensatz steht im Konjunktiv I.',
    'exampleSentence': 'Mich dünkt, er habe nicht die Wahrheit gesprochen.',
    'grammarRule': 'Archaisches unpersönliches Verb mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mittels eines raffinierten Plans gelang die Flucht.',
      'Mittels einem raffinierten Plan gelang die Flucht.',
      'Mittels eines raffiniertes Plans gelang die Flucht.',
      'Mittels einer raffinierten Plans gelang die Flucht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mittels" regiert den Genitiv: "eines raffinierten Plans".',
    'exampleSentence': 'Mittels eines raffinierten Plans gelang die Flucht.',
    'grammarRule': 'Amtssprachliche Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder konnte er lesen noch konnte er schreiben.',
      'Weder er konnte lesen noch er konnte schreiben.',
      'Weder konnte lesen er noch konnte schreiben er.',
      'Er weder konnte lesen noch konnte schreiben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "weder ... noch" mit je eigenen Verben steht das Verb jeweils an zweiter Stelle nach dem Konjunktionsteil.',
    'exampleSentence': 'Weder konnte er lesen noch konnte er schreiben.',
    'grammarRule': 'Verbstellung bei "weder ... noch" mit getrennten Prädikaten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm reinen Wein eingeschenkt.',
      'Sie hat ihm reinem Wein eingeschenkt.',
      'Sie hat ihm reinen Wein eingeschänkt.',
      'Sie hat ihn reinen Wein eingeschenkt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem reinen Wein einschenken" (Dativ der Person, Akkusativ der Sache).',
    'exampleSentence': 'Sie hat ihm reinen Wein eingeschenkt.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Gegensatz zu seinem Bruder, der eher zurückhaltend war, zeigte er sich offen.',
      'Im Gegensatz zu seinem Bruder der eher zurückhaltend war, zeigte er sich offen.',
      'Im Gegensatz zu seinem Bruder, der eher zurückhaltend war zeigte er sich offen.',
      'Im Gegensatz, zu seinem Bruder der eher zurückhaltend war, zeigte er sich offen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene Relativsatz wird durch paarige Kommas vom Rest getrennt.',
    'exampleSentence': 'Im Gegensatz zu seinem Bruder, der eher zurückhaltend war, zeigte er sich offen.',
    'grammarRule': 'Paarige Kommas bei eingeschobenem Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Des Amtes enthoben, verließ er den Saal.',
      'Dem Amt enthoben, verließ er den Saal.',
      'Das Amt enthoben, verließ er den Saal.',
      'Des Amtes enthobt, verließ er den Saal.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden des Amtes entheben" regiert den Genitiv der Sache.',
    'exampleSentence': 'Des Amtes enthoben, verließ er den Saal.',
    'grammarRule': 'Genitivrektion bei "entheben"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Klientel des Anwalts war international.',
      'Der Klientel des Anwalts war international.',
      'Die Klientel des Anwalts war international.',
      'Das Klientel dem Anwalts war international.'
    ],
    'correctAnswer': 2,
    'explanation': '"Klientel" ist Femininum: die Klientel.',
    'exampleSentence': 'Die Klientel des Anwalts war international.',
    'grammarRule': 'Genus bei Fremdwörtern auf -el',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Manch einer hat sich dabei verrechnet.',
      'Manch eine haben sich dabei verrechnet.',
      'Manch einer haben sich dabei verrechnet.',
      'Manch ein hat sich dabei verrechnet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Manch einer" ist Singular und verlangt "hat".',
    'exampleSentence': 'Manch einer hat sich dabei verrechnet.',
    'grammarRule': 'Kongruenz bei Indefinitpronomen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er nahm es auf seine Kappe.',
      'Er nahm es auf sein Kappe.',
      'Er nahm es auf seiner Kappe.',
      'Er nahm es auf seine Kappen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Redewendung lautet "etwas auf seine Kappe nehmen" (die Verantwortung übernehmen). Akkusativ: "auf seine Kappe".',
    'exampleSentence': 'Er nahm es auf seine Kappe.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unbeschadet seiner Rechte bleibt der Vertrag gültig.',
      'Unbeschadet seinen Rechten bleibt der Vertrag gültig.',
      'Unbeschadet seine Rechte bleibt der Vertrag gültig.',
      'Unbeschadet seiner Rechte bleibt den Vertrag gültig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Unbeschadet" ist eine gehobene Präposition mit Genitiv: "seiner Rechte".',
    'exampleSentence': 'Unbeschadet seiner Rechte bleibt der Vertrag gültig.',
    'grammarRule': 'Juristische Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Noch nie war er so glücklich gewesen wie an diesem Tag.',
      'Noch nie er war so glücklich gewesen wie an diesem Tag.',
      'Noch nie war so glücklich er gewesen wie an diesem Tag.',
      'Er noch nie war so glücklich gewesen wie an diesem Tag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "noch nie" im Vorfeld steht das finite Verb vor dem Subjekt.',
    'exampleSentence': 'Noch nie war er so glücklich gewesen wie an diesem Tag.',
    'grammarRule': 'Inversion nach negiertem Temporaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat kein Blatt vor den Mund genommen.',
      'Sie hat kein Blatt vor dem Mund genommen.',
      'Sie hat keinen Blatt vor den Mund genommen.',
      'Sie hat kein Blatt vor den Mund nehmen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kein Blatt vor den Mund nehmen" (offen sprechen) steht mit Akkusativ: "vor den Mund".',
    'exampleSentence': 'Sie hat kein Blatt vor den Mund genommen.',
    'grammarRule': 'Idiomatik mit Wechselpräposition (Akkusativ)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht dass ich wüsste, hat er jemals gelogen.',
      'Nicht, dass ich wüsste hat er jemals gelogen.',
      'Nicht dass ich wüsste hat er jemals gelogen.',
      'Nicht, dass ich wüsste, hat er jemals gelogen.'
    ],
    'correctAnswer': 3,
    'explanation': '"Nicht, dass ich wüsste" wird durch Kommas abgetrennt, da der eingeschobene Satz parenthetisch ist.',
    'exampleSentence': 'Nicht, dass ich wüsste, hat er jemals gelogen.',
    'grammarRule': 'Kommasetzung bei parenthetischem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p2-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde seiner Pflichten entbunden.',
      'Er wurde seine Pflichten entbunden.',
      'Er wurde seinen Pflichten entbunden.',
      'Er wurde seines Pflichten entbunden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden einer Sache entbinden" regiert den Genitiv der Sache: "seiner Pflichten".',
    'exampleSentence': 'Er wurde seiner Pflichten entbunden.',
    'grammarRule': 'Genitivrektion bei "entbinden"',
    'tags': ['satzkorrektur']
  }
];

export default questions;
