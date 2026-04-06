import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kraft seiner Autorität setzte er die Maßnahme durch.',
      'Kraft seine Autorität setzte er die Maßnahme durch.',
      'Kraft seiner Autorität setzte er der Maßnahme durch.',
      'Kraft seinem Autorität setzte er die Maßnahme durch.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kraft" als Präposition regiert den Genitiv: "seiner Autorität".',
    'exampleSentence': 'Kraft seiner Autorität setzte er die Maßnahme durch.',
    'grammarRule': 'Amtssprachliche Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Entscheidung, so schwer sie auch fiel, war richtig.',
      'Die Entscheidung so schwer sie auch fiel war richtig.',
      'Die Entscheidung, so schwer sie auch fiel war richtig.',
      'Die Entscheidung so schwer sie auch fiel, war richtig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der konzessive Einschub "so schwer sie auch fiel" wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Die Entscheidung, so schwer sie auch fiel, war richtig.',
    'grammarRule': 'Paarige Kommas bei konzessivem Einschub',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde des Amtsmissbrauchs für schuldig befunden.',
      'Er wurde den Amtsmissbrauch für schuldig befunden.',
      'Er wurde dem Amtsmissbrauch für schuldig befunden.',
      'Er wurde des Amtsmissbrauches für schuldig befand.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden einer Sache für schuldig befinden" regiert den Genitiv.',
    'exampleSentence': 'Er wurde des Amtsmissbrauchs für schuldig befunden.',
    'grammarRule': 'Genitivrektion bei juristischer Wendung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Postulat wurde von allen akzeptiert.',
      'Der Postulat wurde von allen akzeptiert.',
      'Die Postulat wurde von allen akzeptiert.',
      'Das Postulat wurde von allem akzeptiert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Postulat" ist Neutrum: das Postulat.',
    'exampleSentence': 'Das Postulat wurde von allen akzeptiert.',
    'grammarRule': 'Genus bei lateinischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin es, der dich gewarnt hat.',
      'Ich bin es, der dich gewarnt habe.',
      'Ich bin es, die dich gewarnt hat.',
      'Ich bin es, der dich gewarnt hast.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es" als Bezugswort des Relativsatzes verlangt 3. Person: "der ... hat".',
    'exampleSentence': 'Ich bin es, der dich gewarnt hat.',
    'grammarRule': 'Kongruenz im Relativsatz nach pronominalem Bezugswort',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Behüte Gott, dass dies geschehe!',
      'Behüte Gott, dass dies geschieht!',
      'Behüte Gott, das dies geschehe!',
      'Behüt Gott, dass dies geschehe!'
    ],
    'correctAnswer': 0,
    'explanation': '"Behüte Gott" ist eine archaische Ausrufformel. "Geschehe" steht im Konjunktiv I.',
    'exampleSentence': 'Behüte Gott, dass dies geschehe!',
    'grammarRule': 'Archaische Ausrufformel mit Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allenfalls könnte man dies als Versehen betrachten.',
      'Allenfalls man könnte dies als Versehen betrachten.',
      'Allenfalls könnte dies als Versehen man betrachten.',
      'Man allenfalls könnte dies als Versehen betrachten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Allenfalls" im Vorfeld verlangt Inversion: "könnte man".',
    'exampleSentence': 'Allenfalls könnte man dies als Versehen betrachten.',
    'grammarRule': 'Inversion nach Modaladverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Mantel des Schweigens über die Angelegenheit gebreitet.',
      'Er hat den Mantel des Schweigens über der Angelegenheit gebreitet.',
      'Er hat dem Mantel des Schweigens über die Angelegenheit gebreitet.',
      'Er hat den Mantel des Schweigens über die Angelegenheit gebreit.'
    ],
    'correctAnswer': 0,
    'explanation': '"Den Mantel des Schweigens über etwas breiten" (verschweigen). Akkusativ: "über die Angelegenheit".',
    'exampleSentence': 'Er hat den Mantel des Schweigens über die Angelegenheit gebreitet.',
    'grammarRule': 'Idiomatische Wendung mit Genitiv und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist, wenn man so will, ein Idealist.',
      'Er ist wenn man so will ein Idealist.',
      'Er ist, wenn man so will ein Idealist.',
      'Er ist wenn man so will, ein Idealist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene Konditionalsatz "wenn man so will" wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Er ist, wenn man so will, ein Idealist.',
    'grammarRule': 'Paarige Kommas bei eingeschobenem Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist der Auffassung, dass Änderungen nötig seien.',
      'Sie ist die Auffassung, dass Änderungen nötig seien.',
      'Sie ist dem Auffassung, dass Änderungen nötig seien.',
      'Sie ist der Auffassung, dass Änderungen nötig sind.'
    ],
    'correctAnswer': 0,
    'explanation': '"Der Auffassung sein" mit Genitiv. "Seien" im Konjunktiv I (indirekte Rede).',
    'exampleSentence': 'Sie ist der Auffassung, dass Änderungen nötig seien.',
    'grammarRule': 'Genitivkonstruktion mit Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Konsensus wurde mühsam erarbeitet.',
      'Das Konsensus wurde mühsam erarbeitet.',
      'Die Konsensus wurde mühsam erarbeitet.',
      'Der Konsensus wurden mühsam erarbeitet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Konsensus" ist Maskulinum: der Konsensus.',
    'exampleSentence': 'Der Konsensus wurde mühsam erarbeitet.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -us',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Eine Anzahl von Fehlern wurde entdeckt.',
      'Eine Anzahl von Fehlern wurden entdeckt.',
      'Eine Anzahl von Fehler wurde entdeckt.',
      'Eine Anzahl von Fehlern wurde entdeckten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Eine Anzahl" als Subjektkern verlangt Singular: "wurde entdeckt".',
    'exampleSentence': 'Eine Anzahl von Fehlern wurde entdeckt.',
    'grammarRule': 'Kongruenz bei Mengenangabe mit partitivem Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er erachtete es als seine Pflicht, zu sprechen.',
      'Er erachtete es als sein Pflicht, zu sprechen.',
      'Er erachtete es als seiner Pflicht, zu sprechen.',
      'Er erachtete es als seine Pflicht zu sprechen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Erachten als" mit Akkusativ: "seine Pflicht". Komma vor der Infinitivgruppe.',
    'exampleSentence': 'Er erachtete es als seine Pflicht, zu sprechen.',
    'grammarRule': 'Gehobenes Verb mit "als" und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einhergehend mit dieser Entwicklung stieg die Arbeitslosigkeit.',
      'Einhergehend mit dieser Entwicklung stiegte die Arbeitslosigkeit.',
      'Einhergehend mit diese Entwicklung stieg die Arbeitslosigkeit.',
      'Einher gehend mit dieser Entwicklung stieg die Arbeitslosigkeit.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einhergehend mit" als Partizipialkonstruktion. "Mit dieser Entwicklung" im Dativ.',
    'exampleSentence': 'Einhergehend mit dieser Entwicklung stieg die Arbeitslosigkeit.',
    'grammarRule': 'Partizipiale Vorfeldkonstruktion mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestotrotz besteht er auf seiner Forderung.',
      'Nichtsdestotrotz er besteht auf seiner Forderung.',
      'Nichtsdestotrotz besteht auf seiner Forderung er.',
      'Er nichtsdestotrotz besteht auf seiner Forderung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nichtsdestotrotz" im Vorfeld verlangt Inversion: "besteht er".',
    'exampleSentence': 'Nichtsdestotrotz besteht er auf seiner Forderung.',
    'grammarRule': 'Inversion nach konzessivem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihm das Handwerk gelegt.',
      'Er hat ihn das Handwerk gelegt.',
      'Er hat ihm dem Handwerk gelegt.',
      'Er hat ihm das Handwerk geleget.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem das Handwerk legen" (jemanden an etwas Unerlaubtem hindern). Dativ: "ihm".',
    'exampleSentence': 'Er hat ihm das Handwerk gelegt.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Desto schlimmer, als er es hätte wissen müssen.',
      'Desto schlimmer als er es hätte wissen müssen.',
      'Desto, schlimmer als er es hätte wissen müssen.',
      'Desto schlimmer, als er es hätte, wissen müssen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "als" im Komparativsatz steht ein Komma.',
    'exampleSentence': 'Desto schlimmer, als er es hätte wissen müssen.',
    'grammarRule': 'Kommasetzung vor "als" im Komparativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie war der festen Überzeugung, recht zu haben.',
      'Sie war die feste Überzeugung, recht zu haben.',
      'Sie war dem festen Überzeugung, recht zu haben.',
      'Sie war der fester Überzeugung, recht zu haben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Der Überzeugung sein" mit Genitiv. "Der festen Überzeugung" korrekt dekliniert.',
    'exampleSentence': 'Sie war der festen Überzeugung, recht zu haben.',
    'grammarRule': 'Genitivkonstruktion bei Meinungsangabe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Kontinuum der Geschichte wurde durchbrochen.',
      'Der Kontinuum der Geschichte wurde durchbrochen.',
      'Die Kontinuum der Geschichte wurde durchbrochen.',
      'Das Kontinuum die Geschichte wurde durchbrochen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kontinuum" ist Neutrum: das Kontinuum.',
    'exampleSentence': 'Das Kontinuum der Geschichte wurde durchbrochen.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sind die Umstände, die ihn dazu zwingen.',
      'Es ist die Umstände, die ihn dazu zwingen.',
      'Es sind die Umstände, die ihn dazu zwingt.',
      'Es sind den Umständen, die ihn dazu zwingen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sind" kongruiert mit "die Umstände" (Plural). Im Relativsatz "die ... zwingen" (Plural).',
    'exampleSentence': 'Es sind die Umstände, die ihn dazu zwingen.',
    'grammarRule': 'Kongruenz bei identifizierendem Satz mit Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ihm ward angst und bange.',
      'Ihm wurde angst und bange.',
      'Ihn ward angst und bange.',
      'Ihm ward Angst und Bange.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ward" ist archaisches Präteritum von "werden". "Angst und bange" sind prädikative Adjektive (klein geschrieben).',
    'exampleSentence': 'Ihm ward angst und bange.',
    'grammarRule': 'Archaisches Passiv mit prädikativem Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Betreffs Ihres Schreibens vom 5. März nehme ich Stellung.',
      'Betreffs Ihrem Schreiben vom 5. März nehme ich Stellung.',
      'Betreffs Ihre Schreiben vom 5. März nehme ich Stellung.',
      'Betreff Ihres Schreibens vom 5. März nehme ich Stellung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Betreffs" ist eine amtssprachliche Präposition mit Genitiv: "Ihres Schreibens".',
    'exampleSentence': 'Betreffs Ihres Schreibens vom 5. März nehme ich Stellung.',
    'grammarRule': 'Amtssprachliche Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Indessen mehrten sich die Zweifel an seiner Kompetenz.',
      'Indessen die Zweifel mehrten sich an seiner Kompetenz.',
      'Indessen sich mehrten die Zweifel an seiner Kompetenz.',
      'Die Zweifel indessen sich mehrten an seiner Kompetenz.'
    ],
    'correctAnswer': 0,
    'explanation': '"Indessen" als Konjunktionaladverb im Vorfeld verlangt Inversion.',
    'exampleSentence': 'Indessen mehrten sich die Zweifel an seiner Kompetenz.',
    'grammarRule': 'Inversion nach "indessen" als Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr einen Korb gegeben.',
      'Er hat sie einen Korb gegeben.',
      'Er hat ihr einem Korb gegeben.',
      'Er hat ihr einen Korb gegebt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem einen Korb geben" (jemanden abweisen). Dativ: "ihr", Akkusativ: "einen Korb".',
    'exampleSentence': 'Er hat ihr einen Korb gegeben.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sollte dies zutreffen, so müssten wir unsere Pläne ändern.',
      'Sollte dies zutreffen so müssten wir unsere Pläne ändern.',
      'Sollte dies zutreffen, so müssten wir, unsere Pläne ändern.',
      'Sollte, dies zutreffen, so müssten wir unsere Pläne ändern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem konditionalen Verb-Erst-Satz steht ein Komma vor dem Hauptsatz mit "so".',
    'exampleSentence': 'Sollte dies zutreffen, so müssten wir unsere Pläne ändern.',
    'grammarRule': 'Kommasetzung nach konditionalem Verb-Erst-Satz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er nahm sich der Waisen an.',
      'Er nahm sich die Waisen an.',
      'Er nahm sich den Waisen an.',
      'Er nahm sich der Waisen auf.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich jemandes/einer Sache annehmen" regiert den Genitiv: "der Waisen".',
    'exampleSentence': 'Er nahm sich der Waisen an.',
    'grammarRule': 'Genitivrektion bei "sich annehmen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Impuls für die Veränderung kam von außen.',
      'Das Impuls für die Veränderung kam von außen.',
      'Die Impuls für die Veränderung kam von außen.',
      'Der Impuls für der Veränderung kam von außen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Impuls" ist Maskulinum: der Impuls. "Für die Veränderung" im Akkusativ.',
    'exampleSentence': 'Der Impuls für die Veränderung kam von außen.',
    'grammarRule': 'Genus bei Fremdwörtern aus dem Lateinischen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht du bist gemeint, sondern er.',
      'Nicht du ist gemeint, sondern er.',
      'Nicht du bist gemeint, sondern ihn.',
      'Nicht dir bist gemeint, sondern er.'
    ],
    'correctAnswer': 0,
    'explanation': '"Du" als Subjekt verlangt "bist". "Er" steht als Subjekt im Nominativ.',
    'exampleSentence': 'Nicht du bist gemeint, sondern er.',
    'grammarRule': 'Kongruenz bei korrigierendem "nicht ... sondern"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er trug des Lebens Last mit Würde.',
      'Er trug dem Lebens Last mit Würde.',
      'Er trug des Leben Last mit Würde.',
      'Er trug des Lebens Lasten mit Würde.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Lebens Last" ist ein vorangestellter Genitiv im literarischen Stil.',
    'exampleSentence': 'Er trug des Lebens Last mit Würde.',
    'grammarRule': 'Vorangestellter Genitiv im literarischen Stil',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Übrigen sei auf den Anhang verwiesen.',
      'Im übrigen sei auf den Anhang verwiesen.',
      'Im Übrigen sei auf dem Anhang verwiesen.',
      'In Übrigen sei auf den Anhang verwiesen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Im Übrigen" wird als Substantivierung groß geschrieben. "Auf den Anhang" im Akkusativ.',
    'exampleSentence': 'Im Übrigen sei auf den Anhang verwiesen.',
    'grammarRule': 'Amtssprachliche Wendung mit Substantivierung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nur wenn er einwilligt, kann der Vertrag geschlossen werden.',
      'Nur wenn er einwilligt, der Vertrag kann geschlossen werden.',
      'Nur wenn einwilligt er, kann der Vertrag geschlossen werden.',
      'Wenn nur er einwilligt, kann der Vertrag geschlossen werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "wenn" steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'exampleSentence': 'Nur wenn er einwilligt, kann der Vertrag geschlossen werden.',
    'grammarRule': 'Verbstellung bei einschränkendem Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich ins Zeug gelegt.',
      'Er hat sich im Zeug gelegt.',
      'Er hat sich ins Zeug geleget.',
      'Er hat sich in Zeug gelegt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich ins Zeug legen" (sich sehr anstrengen). "Ins" = in das (Akkusativ).',
    'exampleSentence': 'Er hat sich ins Zeug gelegt.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wollte wissen, wann, wo und wie das Treffen stattfinden solle.',
      'Er wollte wissen wann wo und wie das Treffen stattfinden solle.',
      'Er wollte wissen, wann wo und wie, das Treffen stattfinden solle.',
      'Er wollte, wissen wann, wo und wie das Treffen stattfinden solle.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor dem Nebensatz steht ein Komma. Die koordinierten Fragewörter werden durch Kommas getrennt.',
    'exampleSentence': 'Er wollte wissen, wann, wo und wie das Treffen stattfinden solle.',
    'grammarRule': 'Kommasetzung bei koordinierten Fragewörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war des Glaubens, alles werde sich fügen.',
      'Er war den Glauben, alles werde sich fügen.',
      'Er war dem Glauben, alles werde sich fügen.',
      'Er war des Glauben, alles werde sich fügen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Glaubens sein" mit Genitiv. "Werde" im Konjunktiv I (indirekte Rede).',
    'exampleSentence': 'Er war des Glaubens, alles werde sich fügen.',
    'grammarRule': 'Genitivkonstruktion mit Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Addendum wurde dem Vertrag beigefügt.',
      'Der Addendum wurde dem Vertrag beigefügt.',
      'Die Addendum wurde dem Vertrag beigefügt.',
      'Das Addendum wurde den Vertrag beigefügt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Addendum" ist Neutrum: das Addendum. "Dem Vertrag" im Dativ.',
    'exampleSentence': 'Das Addendum wurde dem Vertrag beigefügt.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seien wir einander zugetan!',
      'Sind wir einander zugetan!',
      'Seien wir einander zugetane!',
      'Seien wir einander zugetat!'
    ],
    'correctAnswer': 0,
    'explanation': '"Seien wir" ist Konjunktiv I (Kohortativ). "Einander zugetan" ist korrekte Partizipialkonstruktion.',
    'exampleSentence': 'Seien wir einander zugetan!',
    'grammarRule': 'Kohortativ im Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Anschluss an die Verhandlung wurde ein Protokoll verfasst.',
      'Im Anschluss an der Verhandlung wurde ein Protokoll verfasst.',
      'Im Anschluss an die Verhandlung wurde einen Protokoll verfasst.',
      'In Anschluss an die Verhandlung wurde ein Protokoll verfasst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Im Anschluss an" regiert den Akkusativ: "die Verhandlung".',
    'exampleSentence': 'Im Anschluss an die Verhandlung wurde ein Protokoll verfasst.',
    'grammarRule': 'Präpositionalphrase mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob er Recht hat oder nicht, steht noch nicht fest.',
      'Ob er Recht hat oder nicht, fest steht noch nicht.',
      'Ob hat er Recht oder nicht, steht noch nicht fest.',
      'Ob er Recht hat oder nicht steht noch nicht fest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im indirekten Fragesatz mit "ob" steht das Verb am Ende. Der Hauptsatz beginnt mit dem finiten Verb.',
    'exampleSentence': 'Ob er Recht hat oder nicht, steht noch nicht fest.',
    'grammarRule': 'Verbstellung bei vorangestelltem indirekten Fragesatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm die Stirn geboten.',
      'Sie hat ihn die Stirn geboten.',
      'Sie hat ihm der Stirn geboten.',
      'Sie hat ihm die Stirn gebietet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem die Stirn bieten" (sich widersetzen). Dativ: "ihm". Partizip II: "geboten".',
    'exampleSentence': 'Sie hat ihm die Stirn geboten.',
    'grammarRule': 'Idiomatische Wendung mit starkem Partizip',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Streng genommen, ist dies nicht korrekt.',
      'Streng genommen ist dies nicht korrekt.',
      'Streng, genommen ist dies nicht korrekt.',
      'Streng genommen, ist dies nicht, korrekt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Streng genommen" als satzeinleitende Partizipialkonstruktion wird durch Komma abgetrennt.',
    'exampleSentence': 'Streng genommen, ist dies nicht korrekt.',
    'grammarRule': 'Kommasetzung nach einleitender Partizipialkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich der Gefahr ausgesetzt.',
      'Er hat sich die Gefahr ausgesetzt.',
      'Er hat sich dem Gefahr ausgesetzt.',
      'Er hat sich der Gefahr ausgesetztet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache aussetzen" regiert den Dativ: "der Gefahr".',
    'exampleSentence': 'Er hat sich der Gefahr ausgesetzt.',
    'grammarRule': 'Dativrektion bei "sich aussetzen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Fundus an Wissen ist beträchtlich.',
      'Das Fundus an Wissen ist beträchtlich.',
      'Die Fundus an Wissen ist beträchtlich.',
      'Der Fundus an Wissen sind beträchtlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Fundus" ist Maskulinum: der Fundus.',
    'exampleSentence': 'Der Fundus an Wissen ist beträchtlich.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -us',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Erste, was ihm auffiel, war die Stille.',
      'Das Erste, was ihm auffiel, waren die Stille.',
      'Das Erste, das ihm auffiel, war die Stille.',
      'Den Ersten, was ihm auffiel, war die Stille.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "das Erste" folgt "was" als Relativpronomen. "War" kongruiert mit "das Erste" (Singular).',
    'exampleSentence': 'Das Erste, was ihm auffiel, war die Stille.',
    'grammarRule': 'Relativpronomen nach substantiviertem Superlativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war sinnes, die Stadt zu verlassen.',
      'Er war Sinnes, die Stadt zu verlassen.',
      'Er war sinnes, der Stadt zu verlassen.',
      'Er war sinns, die Stadt zu verlassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sinnes sein" (vorhaben) ist eine archaische Genitivkonstruktion mit klein geschriebenem "sinnes".',
    'exampleSentence': 'Er war sinnes, die Stadt zu verlassen.',
    'grammarRule': 'Archaische Genitivkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gemäß den Bestimmungen des Vertrags ist dies zulässig.',
      'Gemäß der Bestimmungen des Vertrags ist dies zulässig.',
      'Gemäß die Bestimmungen des Vertrags ist dies zulässig.',
      'Gemäß den Bestimmungen dem Vertrags ist dies zulässig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gemäß" regiert den Dativ: "den Bestimmungen". "Des Vertrags" im Genitiv.',
    'exampleSentence': 'Gemäß den Bestimmungen des Vertrags ist dies zulässig.',
    'grammarRule': 'Präposition "gemäß" mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wohin er sich auch wandte, stieß er auf Widerstand.',
      'Wohin er sich auch wandte stieß er auf Widerstand.',
      'Wohin auch er sich wandte, stieß er auf Widerstand.',
      'Wohin er sich auch wandte, er stieß auf Widerstand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im konzessiven Relativsatz steht das Verb am Ende. Der Hauptsatz beginnt mit dem finiten Verb.',
    'exampleSentence': 'Wohin er sich auch wandte, stieß er auf Widerstand.',
    'grammarRule': 'Verbstellung bei konzessivem Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihn über den Tisch gezogen.',
      'Sie hat ihm über den Tisch gezogen.',
      'Sie hat ihn über dem Tisch gezogen.',
      'Sie hat ihn über den Tisch gezieht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden über den Tisch ziehen" (jemanden übervorteilen). Akkusativ: "ihn", "über den Tisch".',
    'exampleSentence': 'Sie hat ihn über den Tisch gezogen.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er kam nicht, obwohl er es versprochen hatte.',
      'Er kam nicht obwohl er es versprochen hatte.',
      'Er kam nicht, obwohl er es versprochen, hatte.',
      'Er kam, nicht obwohl er es versprochen hatte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor dem konzessiven Nebensatz mit "obwohl" steht ein Komma.',
    'exampleSentence': 'Er kam nicht, obwohl er es versprochen hatte.',
    'grammarRule': 'Kommasetzung vor konzessivem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p9-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist des Irrtums überführt worden.',
      'Er ist den Irrtum überführt worden.',
      'Er ist dem Irrtum überführt worden.',
      'Er ist des Irrtumes übergeführt worden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden einer Sache überführen" regiert den Genitiv: "des Irrtums".',
    'exampleSentence': 'Er ist des Irrtums überführt worden.',
    'grammarRule': 'Genitivrektion bei "überführen" im gehobenen Stil',
    'tags': ['satzkorrektur']
  }
];

export default questions;
