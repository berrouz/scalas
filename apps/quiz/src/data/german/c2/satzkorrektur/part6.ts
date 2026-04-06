import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dessen eingedenk beschloss er, seinen Kurs zu ändern.',
      'Dem eingedenk beschloss er, seinen Kurs zu ändern.',
      'Dessen eingedenk beschloss er, sein Kurs zu ändern.',
      'Desses eingedenk beschloss er, seinen Kurs zu ändern.'
    ],
    'correctAnswer': 0,
    'explanation': '"Eingedenk" als nachgestellte Präposition regiert den Genitiv: "dessen eingedenk".',
    'exampleSentence': 'Dessen eingedenk beschloss er, seinen Kurs zu ändern.',
    'grammarRule': 'Gehobene Konstruktion mit "eingedenk" und Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem ist, kurz gesagt, unlösbar.',
      'Das Problem ist kurz gesagt unlösbar.',
      'Das Problem ist, kurz gesagt unlösbar.',
      'Das Problem ist kurz, gesagt, unlösbar.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kurz gesagt" als parenthetischer Einschub wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Das Problem ist, kurz gesagt, unlösbar.',
    'grammarRule': 'Paarige Kommas bei parenthetischem Partizipialeinschub',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie war aller Sorgen ledig.',
      'Sie war alle Sorgen ledig.',
      'Sie war allen Sorgen ledig.',
      'Sie war aller Sorgen ledige.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache ledig sein" regiert den Genitiv: "aller Sorgen".',
    'exampleSentence': 'Sie war aller Sorgen ledig.',
    'grammarRule': 'Genitivrektion bei prädikativem Adjektiv "ledig"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Desiderat der Forschung wurde benannt.',
      'Der Desiderat der Forschung wurde benannt.',
      'Die Desiderat der Forschung wurde benannt.',
      'Das Desiderat die Forschung wurde benannt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Desiderat" ist Neutrum: das Desiderat.',
    'exampleSentence': 'Das Desiderat der Forschung wurde benannt.',
    'grammarRule': 'Genus bei lateinischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Was immer er auch unternimmt, scheitert kläglich.',
      'Was immer er auch unternimmt, scheitern kläglich.',
      'Was immer er auch unternehmt, scheitert kläglich.',
      'Was immer er auch unternimmt, scheiterte kläglich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Was" als Singular-Subjekt verlangt "scheitert". "Unternimmt" kongruiert mit "er".',
    'exampleSentence': 'Was immer er auch unternimmt, scheitert kläglich.',
    'grammarRule': 'Kongruenz bei konzessivem "was immer"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gedachte der Verstorbenen in stiller Andacht.',
      'Er gedachte den Verstorbenen in stiller Andacht.',
      'Er gedachte die Verstorbenen in stiller Andacht.',
      'Er gedenkte der Verstorbenen in stiller Andacht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gedenken" regiert den Genitiv: "der Verstorbenen". Präteritum: "gedachte" (nicht "gedenkte").',
    'exampleSentence': 'Er gedachte der Verstorbenen in stiller Andacht.',
    'grammarRule': 'Starke Konjugation und Genitivrektion bei "gedenken"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dem Vernehmen nach soll er zurückgetreten sein.',
      'Dem Vernehmen nach er soll zurückgetreten sein.',
      'Nach dem Vernehmen soll er zurückgetreten sein.',
      'Dem Vernehmen nach soll zurückgetreten er sein.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dem Vernehmen nach" als Vorfeld verlangt Inversion: "soll er".',
    'exampleSentence': 'Dem Vernehmen nach soll er zurückgetreten sein.',
    'grammarRule': 'Inversion nach adverbialer Phrase im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr den Wind aus den Segeln genommen.',
      'Er hat ihr den Wind aus die Segeln genommen.',
      'Er hat sie den Wind aus den Segeln genommen.',
      'Er hat ihr dem Wind aus den Segeln genommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem den Wind aus den Segeln nehmen". Dativ: "ihr", "aus den Segeln".',
    'exampleSentence': 'Er hat ihr den Wind aus den Segeln genommen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ging fort, teils aus Enttäuschung, teils aus Stolz.',
      'Er ging fort teils aus Enttäuschung teils aus Stolz.',
      'Er ging fort, teils aus Enttäuschung teils aus Stolz.',
      'Er ging fort teils aus Enttäuschung, teils aus Stolz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "teils ... teils" steht ein Komma nach dem Hauptsatz, und zwischen den Gliedern ebenfalls.',
    'exampleSentence': 'Er ging fort, teils aus Enttäuschung, teils aus Stolz.',
    'grammarRule': 'Kommasetzung bei "teils ... teils"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war sich keiner Schuld bewusst.',
      'Er war sich keine Schuld bewusst.',
      'Er war sich keinem Schuld bewusst.',
      'Er war sich keiner Schuld bewusste.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache bewusst sein" regiert den Genitiv: "keiner Schuld".',
    'exampleSentence': 'Er war sich keiner Schuld bewusst.',
    'grammarRule': 'Genitivrektion bei "bewusst sein" mit Negation',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Interregnum dauerte drei Jahre.',
      'Der Interregnum dauerte drei Jahre.',
      'Die Interregnum dauerte drei Jahre.',
      'Das Interregnum dauerten drei Jahre.'
    ],
    'correctAnswer': 0,
    'explanation': '"Interregnum" ist Neutrum: das Interregnum.',
    'exampleSentence': 'Das Interregnum dauerte drei Jahre.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entweder du oder ich muss nachgeben.',
      'Entweder du oder ich müssen nachgeben.',
      'Entweder du oder ich musst nachgeben.',
      'Entweder du oder mich muss nachgeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "entweder ... oder" richtet sich das Verb nach dem nächststehenden Subjektteil: "ich" (1. Person Singular) verlangt "muss".',
    'exampleSentence': 'Entweder du oder ich muss nachgeben.',
    'grammarRule': 'Kongruenz bei disjunktivem Subjekt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schwur einen heiligen Eid.',
      'Er schwörte einen heiligen Eid.',
      'Er schwur ein heiligen Eid.',
      'Er schwor einem heiligen Eid.'
    ],
    'correctAnswer': 0,
    'explanation': '"Schwur" ist die archaische Präteritumform von "schwören" (neben "schwor"). "Einen Eid" im Akkusativ.',
    'exampleSentence': 'Er schwur einen heiligen Eid.',
    'grammarRule': 'Archaische starke Verbform',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Fernab jeglicher Zivilisation errichtete er seine Hütte.',
      'Fernab jegliche Zivilisation errichtete er seine Hütte.',
      'Fernab jeglichen Zivilisation errichtete er seine Hütte.',
      'Fernab jeglicher Zivilisation errichtete er sein Hütte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Fernab" regiert den Genitiv: "jeglicher Zivilisation".',
    'exampleSentence': 'Fernab jeglicher Zivilisation errichtete er seine Hütte.',
    'grammarRule': 'Präposition "fernab" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Recht besehen, handelt es sich um ein Missverständnis.',
      'Recht besehen handelt es sich um ein Missverständnis.',
      'Besehen recht, handelt es sich um ein Missverständnis.',
      'Recht besehen, es handelt sich um ein Missverständnis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die partizipiale Fügung "recht besehen" wird durch Komma abgetrennt, danach folgt Inversion.',
    'exampleSentence': 'Recht besehen, handelt es sich um ein Missverständnis.',
    'grammarRule': 'Partizipiale Vorfeldkonstruktion mit Inversion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Kriegsbeil begraben.',
      'Er hat das Kriegsbeil begrub.',
      'Er hat dem Kriegsbeil begraben.',
      'Er hat den Kriegsbeil begraben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Das Kriegsbeil begraben" (Frieden schließen). Akkusativ: "das Kriegsbeil".',
    'exampleSentence': 'Er hat das Kriegsbeil begraben.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Genauer gesagt, handelt es sich um eine Hypothese.',
      'Genauer gesagt handelt es sich um eine Hypothese.',
      'Genauer, gesagt handelt es sich um eine Hypothese.',
      'Genauer gesagt handelt, es sich um eine Hypothese.'
    ],
    'correctAnswer': 0,
    'explanation': '"Genauer gesagt" als einleitende Partizipialkonstruktion wird durch Komma abgetrennt.',
    'exampleSentence': 'Genauer gesagt, handelt es sich um eine Hypothese.',
    'grammarRule': 'Kommasetzung nach einleitender Partizipialkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde seiner Würde beraubt.',
      'Er wurde seine Würde beraubt.',
      'Er wurde seinem Würde beraubt.',
      'Er wurde seiner Würde berauben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden einer Sache berauben" regiert den Genitiv: "seiner Würde".',
    'exampleSentence': 'Er wurde seiner Würde beraubt.',
    'grammarRule': 'Genitivrektion bei "berauben"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Usus an dieser Universität ist anders.',
      'Das Usus an dieser Universität ist anders.',
      'Die Usus an dieser Universität ist anders.',
      'Der Usus an diesem Universität ist anders.'
    ],
    'correctAnswer': 0,
    'explanation': '"Usus" ist Maskulinum: der Usus.',
    'exampleSentence': 'Der Usus an dieser Universität ist anders.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -us',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zehn Kilogramm Mehl reicht für das Rezept.',
      'Zehn Kilogramm Mehl reichen für das Rezept.',
      'Zehn Kilogramm Mehle reichen für das Rezept.',
      'Zehn Kilogramm Mehl reicht für dem Rezept.'
    ],
    'correctAnswer': 1,
    'explanation': '"Zehn Kilogramm" als Mengenangabe im Plural verlangt "reichen".',
    'exampleSentence': 'Zehn Kilogramm Mehl reichen für das Rezept.',
    'grammarRule': 'Kongruenz bei Maßangaben im Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man lasse ihn gewähren!',
      'Man lass ihn gewähren!',
      'Man lasse ihn gewährt!',
      'Man lasse ihm gewähren!'
    ],
    'correctAnswer': 0,
    'explanation': '"Man lasse" ist Konjunktiv I (Jussiv). "Gewähren lassen" mit Akkusativ: "ihn".',
    'exampleSentence': 'Man lasse ihn gewähren!',
    'grammarRule': 'Jussiver Konjunktiv I mit Infinitivkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Was auch immer geschehen mag, wir halten zusammen.',
      'Was auch immer geschehen mag, zusammen wir halten.',
      'Was auch geschehen immer mag, wir halten zusammen.',
      'Was auch immer mag geschehen, wir halten zusammen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im konzessiven Nebensatz "was auch immer geschehen mag" steht das Verb am Ende. Der Hauptsatz hat reguläre Verbzweitstellung.',
    'exampleSentence': 'Was auch immer geschehen mag, wir halten zusammen.',
    'grammarRule': 'Verbstellung bei konzessivem Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Rubikon überschritten.',
      'Er hat den Rubikon überschrittet.',
      'Er hat dem Rubikon überschritten.',
      'Er hat den Rubikon überschreiten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Den Rubikon überschreiten" (einen entscheidenden Schritt tun). Partizip II: "überschritten".',
    'exampleSentence': 'Er hat den Rubikon überschritten.',
    'grammarRule': 'Idiomatische Wendung mit historischem Bezug',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er handelte, sei es bewusst oder unbewusst, gegen die Regeln.',
      'Er handelte sei es bewusst oder unbewusst gegen die Regeln.',
      'Er handelte, sei es bewusst oder unbewusst gegen die Regeln.',
      'Er handelte sei es bewusst oder unbewusst, gegen die Regeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die Parenthese "sei es bewusst oder unbewusst" wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Er handelte, sei es bewusst oder unbewusst, gegen die Regeln.',
    'grammarRule': 'Paarige Kommas bei konzessiver Parenthese',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie war der Tränen nicht mächtig.',
      'Sie war die Tränen nicht mächtig.',
      'Sie war den Tränen nicht mächtig.',
      'Sie war der Tränen nicht mächtige.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache (nicht) mächtig sein" regiert den Genitiv: "der Tränen".',
    'exampleSentence': 'Sie war der Tränen nicht mächtig.',
    'grammarRule': 'Genitivrektion bei "mächtig" im gehobenen Stil',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aporie des Philosophen wurde deutlich.',
      'Der Aporie des Philosophen wurde deutlich.',
      'Das Aporie des Philosophen wurde deutlich.',
      'Die Aporie dem Philosophen wurde deutlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Aporie" ist Femininum: die Aporie.',
    'exampleSentence': 'Die Aporie des Philosophen wurde deutlich.',
    'grammarRule': 'Genus bei griechischen Fachbegriffen auf -ie',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es ist nicht Gold alles, was glänzt.',
      'Es ist nicht Gold alles, was glänzen.',
      'Es sind nicht Gold alles, was glänzt.',
      'Es ist nicht Gold alles, das glänzt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es ist nicht Gold alles, was glänzt" - gehobene Version des Sprichworts. "Was" nach "alles".',
    'exampleSentence': 'Es ist nicht Gold alles, was glänzt.',
    'grammarRule': 'Gehobenes Sprichwort mit korrekter Kongruenz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Getrost möge er seinen Weg gehen.',
      'Getrost mag er seinen Weg gehen.',
      'Getrost möge er sein Weg gehen.',
      'Getröstet möge er seinen Weg gehen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Möge" im Konjunktiv I als Wunsch. "Getrost" als gehobenes Adverb.',
    'exampleSentence': 'Getrost möge er seinen Weg gehen.',
    'grammarRule': 'Optativischer Konjunktiv I mit gehobener Lexik',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jenseits aller Erwartungen übertraf das Ergebnis die Prognosen.',
      'Jenseits allen Erwartungen übertraf das Ergebnis die Prognosen.',
      'Jenseits alle Erwartungen übertraf das Ergebnis die Prognosen.',
      'Jenseits aller Erwartungen übertraf das Ergebnis den Prognosen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jenseits" regiert den Genitiv: "aller Erwartungen". "Die Prognosen" im Akkusativ.',
    'exampleSentence': 'Jenseits aller Erwartungen übertraf das Ergebnis die Prognosen.',
    'grammarRule': 'Präposition "jenseits" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So wenig wie er nachgab, so wenig ließ sie nach.',
      'So wenig wie er nachgab, so wenig sie ließ nach.',
      'So wenig wie nachgab er, so wenig ließ sie nach.',
      'Wie so wenig er nachgab, so wenig ließ sie nach.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die korrelative Konstruktion "so wenig wie ... so wenig" verlangt je Verbzweitstellung in beiden Teilsätzen.',
    'exampleSentence': 'So wenig wie er nachgab, so wenig ließ sie nach.',
    'grammarRule': 'Korrelative Konstruktion mit Verbzweitstellung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Tischtuch zwischen ihnen zerschnitten.',
      'Er hat das Tischtuch zwischen sie zerschnitten.',
      'Er hat dem Tischtuch zwischen ihnen zerschnitten.',
      'Er hat das Tischtuch zwischen ihnen zerschneiden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Das Tischtuch zerschneiden" (die Beziehung beenden). "Zwischen ihnen" mit Dativ.',
    'exampleSentence': 'Er hat das Tischtuch zwischen ihnen zerschnitten.',
    'grammarRule': 'Idiomatische Wendung mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet der Tatsache, dass es regnete, ging er spazieren.',
      'Ungeachtet der Tatsache dass es regnete ging er spazieren.',
      'Ungeachtet der Tatsache, dass es regnete ging er spazieren.',
      'Ungeachtet, der Tatsache dass es regnete, ging er spazieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "dass" und nach dem Nebensatz stehen Kommas.',
    'exampleSentence': 'Ungeachtet der Tatsache, dass es regnete, ging er spazieren.',
    'grammarRule': 'Kommasetzung bei Genitivpräposition mit Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man zeiht ihn des Verrats.',
      'Man zeiht ihn den Verrat.',
      'Man zeiht ihm des Verrats.',
      'Man zeiht ihn dem Verrat.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zeihen" (beschuldigen) regiert Akkusativ der Person und Genitiv der Sache: "ihn des Verrats".',
    'exampleSentence': 'Man zeiht ihn des Verrats.',
    'grammarRule': 'Doppelte Rektion bei "zeihen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Moratorium wurde um ein Jahr verlängert.',
      'Der Moratorium wurde um ein Jahr verlängert.',
      'Die Moratorium wurde um ein Jahr verlängert.',
      'Das Moratorium wurde um einen Jahr verlängert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Moratorium" ist Neutrum: das Moratorium. "Um ein Jahr" im Akkusativ.',
    'exampleSentence': 'Das Moratorium wurde um ein Jahr verlängert.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-036',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jeder Einzelne ist aufgerufen, seinen Beitrag zu leisten.',
      'Jeder Einzelne sind aufgerufen, seinen Beitrag zu leisten.',
      'Jeder Einzelne ist aufgerufen, sein Beitrag zu leisten.',
      'Jede Einzelne ist aufgerufen, seinen Beitrag zu leisten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jeder Einzelne" (maskulin, Singular) verlangt "ist" und "seinen".',
    'exampleSentence': 'Jeder Einzelne ist aufgerufen, seinen Beitrag zu leisten.',
    'grammarRule': 'Kongruenz bei "jeder" mit substantiviertem Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er erkor sie zu seiner Braut.',
      'Er erkürte sie zu seiner Braut.',
      'Er erkor sie zu seine Braut.',
      'Er erkor ihr zu seiner Braut.'
    ],
    'correctAnswer': 0,
    'explanation': '"Erkor" ist die archaische Präteritumform von "erkiesen/erküren" (erwählen). Akkusativ: "sie".',
    'exampleSentence': 'Er erkor sie zu seiner Braut.',
    'grammarRule': 'Archaische starke Verbform mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Namens und im Auftrag des Klienten erhebe ich Einspruch.',
      'Namens und im Auftrag dem Klienten erhebe ich Einspruch.',
      'Namens und in Auftrag des Klienten erhebe ich Einspruch.',
      'Namen und im Auftrag des Klienten erhebe ich Einspruch.'
    ],
    'correctAnswer': 0,
    'explanation': '"Namens und im Auftrag" ist eine juristische Formel. "Des Klienten" steht im Genitiv.',
    'exampleSentence': 'Namens und im Auftrag des Klienten erhebe ich Einspruch.',
    'grammarRule': 'Juristische Formel mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mag sein, dass er Recht hat.',
      'Mag sein, dass Recht hat er.',
      'Sein mag, dass er Recht hat.',
      'Mag sein, dass er hat Recht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mag sein" mit Verb-Erst-Stellung als konzessive Formel. Im "dass"-Satz steht das Verb am Ende.',
    'exampleSentence': 'Mag sein, dass er Recht hat.',
    'grammarRule': 'Konzessive Formel mit Verb-Erst-Stellung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm auf die Sprünge geholfen.',
      'Sie hat ihn auf die Sprünge geholfen.',
      'Sie hat ihm auf den Sprüngen geholfen.',
      'Sie hat ihm auf die Sprünge gehilft.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem auf die Sprünge helfen" (jemandem nachhelfen). Dativ: "ihm". Partizip II: "geholfen".',
    'exampleSentence': 'Sie hat ihm auf die Sprünge geholfen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gleichgültig, was passiert, er bleibt gelassen.',
      'Gleichgültig was passiert er bleibt gelassen.',
      'Gleichgültig, was passiert er bleibt gelassen.',
      'Gleichgültig was passiert, er bleibt gelassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "gleichgültig" und nach dem eingeschobenen Nebensatz stehen Kommas.',
    'exampleSentence': 'Gleichgültig, was passiert, er bleibt gelassen.',
    'grammarRule': 'Kommasetzung bei konzessiver Einleitung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde des Dienstes enthoben.',
      'Er wurde den Dienst enthoben.',
      'Er wurde dem Dienst enthoben.',
      'Er wurde des Dienstes enthobt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden des Dienstes entheben" regiert den Genitiv.',
    'exampleSentence': 'Er wurde des Dienstes enthoben.',
    'grammarRule': 'Genitivrektion bei "entheben"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Turnus der Sitzungen beträgt zwei Wochen.',
      'Das Turnus der Sitzungen beträgt zwei Wochen.',
      'Die Turnus der Sitzungen beträgt zwei Wochen.',
      'Der Turnus die Sitzungen beträgt zwei Wochen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Turnus" ist Maskulinum: der Turnus.',
    'exampleSentence': 'Der Turnus der Sitzungen beträgt zwei Wochen.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -us',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das, was zählt, sind die Ergebnisse.',
      'Das, was zählt, ist die Ergebnisse.',
      'Das, was zählen, sind die Ergebnisse.',
      'Das, das zählt, sind die Ergebnisse.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sind" kongruiert mit dem Prädikativum "die Ergebnisse" (Plural). "Was" steht nach "das".',
    'exampleSentence': 'Das, was zählt, sind die Ergebnisse.',
    'grammarRule': 'Kongruenz bei kopulativem Satz mit Prädikativum',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hob an zu reden und sprach mit fester Stimme.',
      'Er hub an zu reden und sprach mit fester Stimme.',
      'Er hob an reden und sprach mit fester Stimme.',
      'Er hobt an zu reden und sprach mit fester Stimme.'
    ],
    'correctAnswer': 0,
    'explanation': '"Hob an" ist Präteritum von "anheben" (beginnen). Die modernere Form "hob" ist neben "hub" korrekt.',
    'exampleSentence': 'Er hob an zu reden und sprach mit fester Stimme.',
    'grammarRule': 'Gehobenes Verb "anheben" im Präteritum',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vonseiten der Opposition wurde Kritik laut.',
      'Vonseiten die Opposition wurde Kritik laut.',
      'Von Seiten der Opposition wurde Kritik laut werden.',
      'Vonseiten dem Opposition wurde Kritik laut.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vonseiten" (zusammengeschrieben) regiert den Genitiv: "der Opposition".',
    'exampleSentence': 'Vonseiten der Opposition wurde Kritik laut.',
    'grammarRule': 'Gehobene Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dergestalt änderten sich die Verhältnisse, dass niemand es vorausgesehen hatte.',
      'Dergestalt die Verhältnisse sich änderten, dass niemand es vorausgesehen hatte.',
      'Dergestalt änderten die Verhältnisse sich, dass niemand es vorausgesehen hatte.',
      'Die Verhältnisse dergestalt änderten sich, dass niemand es vorausgesehen hatte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dergestalt" im Vorfeld verlangt Inversion. "Sich" steht nach dem Subjekt.',
    'exampleSentence': 'Dergestalt änderten sich die Verhältnisse, dass niemand es vorausgesehen hatte.',
    'grammarRule': 'Inversion nach gehobener Konjunktion "dergestalt"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr das Wort im Munde umgedreht.',
      'Er hat ihr das Wort in Munde umgedreht.',
      'Er hat sie das Wort im Munde umgedreht.',
      'Er hat ihr dem Wort im Munde umgedreht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem das Wort im Munde umdrehen" (verdrehen, was jemand gesagt hat). Dativ: "ihr".',
    'exampleSentence': 'Er hat ihr das Wort im Munde umgedreht.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und erweiterter Dativform',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zudem, und das ist entscheidend, fehlt jeglicher Beweis.',
      'Zudem und das ist entscheidend fehlt jeglicher Beweis.',
      'Zudem, und das ist entscheidend fehlt jeglicher Beweis.',
      'Zudem und, das ist entscheidend, fehlt jeglicher Beweis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der parenthetische Einschub "und das ist entscheidend" wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Zudem, und das ist entscheidend, fehlt jeglicher Beweis.',
    'grammarRule': 'Paarige Kommas bei parenthetischem Hauptsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p6-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde seines Ranges entkleidet.',
      'Er wurde seinen Rang entkleidet.',
      'Er wurde seinem Rang entkleidet.',
      'Er wurde seines Ranges entkleiden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemanden seines Ranges entkleiden" (im gehobenen Stil) regiert den Genitiv.',
    'exampleSentence': 'Er wurde seines Ranges entkleidet.',
    'grammarRule': 'Genitivrektion bei "entkleiden" im übertragenen Sinne',
    'tags': ['satzkorrektur']
  }
];

export default questions;
