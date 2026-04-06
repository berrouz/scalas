import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie versicherte sich seiner Unterstützung.',
      'Sie versicherte sich seine Unterstützung.',
      'Sie versicherte sich seinem Unterstützung.',
      'Sie versicherte sich seiner Unterstützungen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache versichern" regiert den Genitiv: "seiner Unterstützung".',
    'exampleSentence': 'Sie versicherte sich seiner Unterstützung.',
    'grammarRule': 'Genitivrektion bei "sich versichern"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Umso mehr, als er krank war, verdient seine Leistung Anerkennung.',
      'Umso mehr als er krank war verdient seine Leistung Anerkennung.',
      'Umso mehr als er krank war, verdient seine Leistung Anerkennung.',
      'Umso mehr, als er krank war verdient seine Leistung Anerkennung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "als" und nach dem Nebensatz stehen Kommas.',
    'exampleSentence': 'Umso mehr, als er krank war, verdient seine Leistung Anerkennung.',
    'grammarRule': 'Kommasetzung bei "umso mehr, als"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Pandämonium brach über sie herein.',
      'Der Pandämonium brach über sie herein.',
      'Die Pandämonium brach über sie herein.',
      'Das Pandämonium brach über ihr herein.'
    ],
    'correctAnswer': 0,
    'explanation': '"Pandämonium" ist Neutrum: das Pandämonium. "Über sie" im Akkusativ.',
    'exampleSentence': 'Das Pandämonium brach über sie herein.',
    'grammarRule': 'Genus bei griechischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Was ihn betrifft, so ist er bereits informiert.',
      'Was ihn betrifft, so sind er bereits informiert.',
      'Was ihm betrifft, so ist er bereits informiert.',
      'Was ihn betrifft, so ist er bereits informierte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Was ihn betrifft" mit Akkusativ. "Ist" kongruiert mit "er" (Singular).',
    'exampleSentence': 'Was ihn betrifft, so ist er bereits informiert.',
    'grammarRule': 'Kongruenz in thematisierender Konstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gebricht ihm an Mut.',
      'Es gebricht ihn an Mut.',
      'Es gebrach ihm an Mut.',
      'Es gebrichtet ihm an Mut.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gebrechen" (es gebricht jemandem an etwas) ist ein archaisches unpersönliches Verb mit Dativ.',
    'exampleSentence': 'Es gebricht ihm an Mut.',
    'grammarRule': 'Archaisches unpersönliches Verb mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Vorfeld der Verhandlungen wurden Zugeständnisse gemacht.',
      'Im Vorfeld den Verhandlungen wurden Zugeständnisse gemacht.',
      'Im Vorfeld der Verhandlungen wurde Zugeständnisse gemacht.',
      'In Vorfeld der Verhandlungen wurden Zugeständnisse gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Im Vorfeld" regiert den Genitiv: "der Verhandlungen". "Zugeständnisse" (Plural) verlangt "wurden".',
    'exampleSentence': 'Im Vorfeld der Verhandlungen wurden Zugeständnisse gemacht.',
    'grammarRule': 'Gehobene Präpositionalphrase mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nimmermehr hätte er dies erwartet.',
      'Nimmermehr er hätte dies erwartet.',
      'Nimmermehr hätte dies er erwartet.',
      'Er nimmermehr hätte dies erwartet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "nimmermehr" im Vorfeld folgt Inversion: finites Verb vor Subjekt.',
    'exampleSentence': 'Nimmermehr hätte er dies erwartet.',
    'grammarRule': 'Inversion nach gehobener Negationspartikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr goldene Berge versprochen.',
      'Er hat sie goldene Berge versprochen.',
      'Er hat ihr goldenen Berge versprochen.',
      'Er hat ihr goldene Bergen versprochen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem goldene Berge versprechen" (unrealistische Versprechungen machen). Dativ: "ihr".',
    'exampleSentence': 'Er hat ihr goldene Berge versprochen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es liegt nahe, anzunehmen, dass dies kein Zufall ist.',
      'Es liegt nahe anzunehmen dass dies kein Zufall ist.',
      'Es liegt nahe, anzunehmen dass dies kein Zufall ist.',
      'Es liegt nahe anzunehmen, dass dies kein Zufall ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor dem Infinitiv mit "zu" und vor dem "dass"-Satz stehen jeweils Kommas.',
    'exampleSentence': 'Es liegt nahe, anzunehmen, dass dies kein Zufall ist.',
    'grammarRule': 'Kommasetzung bei geschachtelten Infinitiv- und Nebensätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war der Ansicht, man solle abwarten.',
      'Er war die Ansicht, man solle abwarten.',
      'Er war dem Ansicht, man solle abwarten.',
      'Er war der Ansicht, man soll abwarten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Der Ansicht sein" mit Genitiv. Im Nebensatz steht Konjunktiv I: "solle".',
    'exampleSentence': 'Er war der Ansicht, man solle abwarten.',
    'grammarRule': 'Genitivkonstruktion mit Konjunktiv I in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Diskurs über die Menschenrechte ist wichtig.',
      'Das Diskurs über die Menschenrechte ist wichtig.',
      'Die Diskurs über die Menschenrechte ist wichtig.',
      'Der Diskurs über den Menschenrechte ist wichtig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Diskurs" ist Maskulinum: der Diskurs.',
    'exampleSentence': 'Der Diskurs über die Menschenrechte ist wichtig.',
    'grammarRule': 'Genus bei Fremdwörtern aus dem Französischen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Manches, was er sagte, klang überzeugend.',
      'Manches, was er sagte, klangen überzeugend.',
      'Manches, das er sagte, klang überzeugend.',
      'Manchem, was er sagte, klang überzeugend.'
    ],
    'correctAnswer': 0,
    'explanation': '"Manches" (Singular) verlangt "klang". Nach "manches" folgt "was" als Relativpronomen.',
    'exampleSentence': 'Manches, was er sagte, klang überzeugend.',
    'grammarRule': 'Relativpronomen und Kongruenz nach "manches"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er verharrte in stummer Andacht.',
      'Er verharrte in stumme Andacht.',
      'Er verharrte in stummem Andacht.',
      'Er verharrte in stummer Andachten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Verharren in" regiert den Dativ: "in stummer Andacht".',
    'exampleSentence': 'Er verharrte in stummer Andacht.',
    'grammarRule': 'Gehobenes Verb mit Dativrektion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob seiner Verdienste wurde er geehrt.',
      'Ob seine Verdienste wurde er geehrt.',
      'Ob seinen Verdiensten wurde er geehrt.',
      'Ob seiner Verdiensten wurde er geehrt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ob" als gehobene Kausalpräposition regiert den Genitiv: "seiner Verdienste".',
    'exampleSentence': 'Ob seiner Verdienste wurde er geehrt.',
    'grammarRule': 'Gehobene Kausalpräposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie sehr er sich auch bemühte, es gelang ihm nicht.',
      'Wie sehr er sich auch bemühte, es ihm gelang nicht.',
      'Wie sehr sich er auch bemühte, es gelang ihm nicht.',
      'Wie sehr er auch sich bemühte, es gelang ihm nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "wie sehr" steht das Verb am Ende. Im Hauptsatz reguläre Verbzweitstellung.',
    'exampleSentence': 'Wie sehr er sich auch bemühte, es gelang ihm nicht.',
    'grammarRule': 'Verbstellung im konzessiven Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm den Kopf verdreht.',
      'Sie hat ihn den Kopf verdreht.',
      'Sie hat ihm dem Kopf verdreht.',
      'Sie hat ihm den Kopf verdrehet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem den Kopf verdrehen" (jemanden betören). Dativ: "ihm", Akkusativ: "den Kopf".',
    'exampleSentence': 'Sie hat ihm den Kopf verdreht.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter der Voraussetzung, dass alle zustimmen, tritt die Regelung in Kraft.',
      'Unter der Voraussetzung dass alle zustimmen tritt die Regelung in Kraft.',
      'Unter der Voraussetzung, dass alle zustimmen tritt die Regelung in Kraft.',
      'Unter der Voraussetzung dass alle zustimmen, tritt die Regelung in Kraft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "dass" und nach dem Nebensatz stehen Kommas.',
    'exampleSentence': 'Unter der Voraussetzung, dass alle zustimmen, tritt die Regelung in Kraft.',
    'grammarRule': 'Kommasetzung bei konditionaler Nominalphrase mit Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war sich der Tragweite seiner Entscheidung nicht bewusst.',
      'Er war sich die Tragweite seiner Entscheidung nicht bewusst.',
      'Er war sich dem Tragweite seiner Entscheidung nicht bewusst.',
      'Er war sich der Tragweite sein Entscheidung nicht bewusst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache bewusst sein" mit Genitiv: "der Tragweite seiner Entscheidung".',
    'exampleSentence': 'Er war sich der Tragweite seiner Entscheidung nicht bewusst.',
    'grammarRule': 'Genitivrektion bei "bewusst sein" mit erweitertem Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Exposee wurde eingereicht.',
      'Der Exposee wurde eingereicht.',
      'Das Expose wurde eingereicht.',
      'Das Exposee wurden eingereicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Exposee" ist Neutrum: das Exposee.',
    'exampleSentence': 'Das Exposee wurde eingereicht.',
    'grammarRule': 'Genus bei französischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einiges, was er vorbrachte, war stichhaltig.',
      'Einiges, was er vorbrachte, waren stichhaltig.',
      'Einiges, das er vorbrachte, war stichhaltig.',
      'Einigem, was er vorbrachte, war stichhaltig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einiges" (Singular) verlangt "war". Nach "einiges" folgt "was" als Relativpronomen.',
    'exampleSentence': 'Einiges, was er vorbrachte, war stichhaltig.',
    'grammarRule': 'Relativpronomen und Kongruenz nach "einiges"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ermangelte jeglicher Einsicht.',
      'Er ermangelte jegliche Einsicht.',
      'Er ermangelte jeglichem Einsicht.',
      'Er ermangelt jeglicher Einsicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ermangeln" ist ein gehobenes Verb mit Genitiv: "jeglicher Einsicht".',
    'exampleSentence': 'Er ermangelte jeglicher Einsicht.',
    'grammarRule': 'Gehobenes Verb mit Genitivrektion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anhand der vorliegenden Unterlagen lässt sich dies belegen.',
      'Anhand den vorliegenden Unterlagen lässt sich dies belegen.',
      'Anhand der vorliegende Unterlagen lässt sich dies belegen.',
      'Anhand der vorliegenden Unterlagen lasst sich dies belegen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anhand" regiert den Genitiv: "der vorliegenden Unterlagen".',
    'exampleSentence': 'Anhand der vorliegenden Unterlagen lässt sich dies belegen.',
    'grammarRule': 'Präposition "anhand" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obschon er recht hatte, gab er nach.',
      'Obschon er recht hatte er gab nach.',
      'Obschon recht er hatte, gab er nach.',
      'Obschon er hatte recht, gab er nach.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "obschon" steht das Verb am Ende. Der Hauptsatz beginnt mit dem finiten Verb.',
    'exampleSentence': 'Obschon er recht hatte, gab er nach.',
    'grammarRule': 'Verbstellung im konzessiven Nebensatz mit "obschon"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Teufel an die Wand gemalt.',
      'Er hat den Teufel an der Wand gemalt.',
      'Er hat dem Teufel an die Wand gemalt.',
      'Er hat den Teufel an die Wand gemalen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Den Teufel an die Wand malen" (Unheil heraufbeschwören). Akkusativ: "an die Wand".',
    'exampleSentence': 'Er hat den Teufel an die Wand gemalt.',
    'grammarRule': 'Idiomatische Wendung mit Wechselpräposition (Akkusativ)',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anders als erwartet, verlief die Prüfung problemlos.',
      'Anders als erwartet verlief die Prüfung problemlos.',
      'Anders, als erwartet verlief die Prüfung problemlos.',
      'Anders als, erwartet, verlief die Prüfung problemlos.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der verkürzten Vergleichskonstruktion "anders als erwartet" steht ein Komma.',
    'exampleSentence': 'Anders als erwartet, verlief die Prüfung problemlos.',
    'grammarRule': 'Kommasetzung nach verkürztem Vergleichssatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist des Lobes voll.',
      'Sie ist dem Lob voll.',
      'Sie ist das Lob voll.',
      'Sie ist des Lobes volle.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Lobes voll sein" ist eine gehobene Genitivkonstruktion.',
    'exampleSentence': 'Sie ist des Lobes voll.',
    'grammarRule': 'Gehobene Genitivkonstruktion mit "voll"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Dissens zwischen den Parteien besteht fort.',
      'Das Dissens zwischen den Parteien besteht fort.',
      'Die Dissens zwischen den Parteien besteht fort.',
      'Der Dissens zwischen die Parteien besteht fort.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dissens" ist Maskulinum: der Dissens. "Zwischen den Parteien" im Dativ.',
    'exampleSentence': 'Der Dissens zwischen den Parteien besteht fort.',
    'grammarRule': 'Genus bei Fremdwörtern aus dem Lateinischen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder Geld noch Ruhm war ihm wichtig.',
      'Weder Geld noch Ruhm waren ihm wichtig.',
      'Weder Geld noch Ruhm war ihn wichtig.',
      'Weder Geld noch Ruhm waren ihn wichtig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei "weder ... noch" mit zwei Singular-Subjekten steht das Verb im Singular, bezogen auf den näheren Teil.',
    'exampleSentence': 'Weder Geld noch Ruhm war ihm wichtig.',
    'grammarRule': 'Kongruenz bei "weder ... noch" mit Singular-Subjekten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gebar den Verdacht, dass man ihn hintergehe.',
      'Er gebarte den Verdacht, dass man ihn hintergehe.',
      'Er gebar dem Verdacht, dass man ihn hintergehe.',
      'Er gebar den Verdacht, dass man ihm hintergehe.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gebaren" (hegen) hat das Präteritum "gebar". Akkusativ: "den Verdacht". Konjunktiv I: "hintergehe".',
    'exampleSentence': 'Er hegte den Verdacht, dass man ihn hintergehe.',
    'grammarRule': 'Gehobenes Verb mit Akkusativ und Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Nachgang zu der Besprechung wurden Protokolle erstellt.',
      'Im Nachgang zu die Besprechung wurden Protokolle erstellt.',
      'Im Nachgang zu der Besprechung wurde Protokolle erstellt.',
      'In Nachgang zu der Besprechung wurden Protokolle erstellt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Im Nachgang zu" regiert den Dativ: "der Besprechung". "Protokolle" (Plural) verlangt "wurden".',
    'exampleSentence': 'Im Nachgang zu der Besprechung wurden Protokolle erstellt.',
    'grammarRule': 'Amtssprachliche Präpositionalphrase mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wiewohl die Lage ernst war, bewahrte er die Ruhe.',
      'Wiewohl die Lage ernst war bewahrte er die Ruhe.',
      'Wiewohl ernst die Lage war, bewahrte er die Ruhe.',
      'Wiewohl die Lage ernst war, er bewahrte die Ruhe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "wiewohl" steht das Verb am Ende. Der Hauptsatz beginnt mit dem finiten Verb.',
    'exampleSentence': 'Wiewohl die Lage ernst war, bewahrte er die Ruhe.',
    'grammarRule': 'Verbstellung im konzessiven Nebensatz mit "wiewohl"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr den Boden unter den Füßen weggezogen.',
      'Er hat ihr den Boden unter die Füße weggezogen.',
      'Er hat sie den Boden unter den Füßen weggezogen.',
      'Er hat ihr dem Boden unter den Füßen weggezogen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem den Boden unter den Füßen wegziehen". Dativ: "ihr", "unter den Füßen".',
    'exampleSentence': 'Er hat ihr den Boden unter den Füßen weggezogen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Was mich betrifft, so habe ich keine Einwände.',
      'Was mich betrifft so habe ich keine Einwände.',
      'Was mich betrifft, so habe ich keine, Einwände.',
      'Was, mich betrifft, so habe ich keine Einwände.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem vorangestellten Relativsatz "was mich betrifft" steht ein Komma.',
    'exampleSentence': 'Was mich betrifft, so habe ich keine Einwände.',
    'grammarRule': 'Kommasetzung nach thematisierendem Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war seiner selbst nicht mächtig.',
      'Er war sich selbst nicht mächtig.',
      'Er war seine selbst nicht mächtig.',
      'Er war seines selbst nicht mächtig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Seiner selbst nicht mächtig sein" (sich nicht beherrschen können). "Seiner" im Genitiv.',
    'exampleSentence': 'Er war seiner selbst nicht mächtig.',
    'grammarRule': 'Genitivrektion bei reflexiver Konstruktion mit "mächtig"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Tonus seiner Stimme verriet Nervosität.',
      'Das Tonus seiner Stimme verriet Nervosität.',
      'Die Tonus seiner Stimme verriet Nervosität.',
      'Der Tonus sein Stimme verriet Nervosität.'
    ],
    'correctAnswer': 0,
    'explanation': '"Tonus" ist Maskulinum: der Tonus.',
    'exampleSentence': 'Der Tonus seiner Stimme verriet Nervosität.',
    'grammarRule': 'Genus bei medizinischen Fachbegriffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-036',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gibt weniges, was mich mehr berührt hat.',
      'Es gibt weniges, was mich mehr berührt haben.',
      'Es gibt weniges, das mich mehr berührt hat.',
      'Es gibt wenigem, was mich mehr berührt hat.'
    ],
    'correctAnswer': 0,
    'explanation': '"Weniges" (Singular) verlangt "hat". Nach "weniges" folgt "was" als Relativpronomen.',
    'exampleSentence': 'Es gibt weniges, was mich mehr berührt hat.',
    'grammarRule': 'Relativpronomen nach "weniges"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schied dahin, von allen betrauert.',
      'Er schied dahin, von allen betraueret.',
      'Er schied dahin, von allem betrauert.',
      'Er scheidete dahin, von allen betrauert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dahinschieded" (sterben) hat das Präteritum "schied dahin". "Von allen betrauert" ist korrekte Partizipialkonstruktion.',
    'exampleSentence': 'Er schied dahin, von allen betrauert.',
    'grammarRule': 'Gehobenes Verb im Präteritum mit Partizipialkonstruktion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Gegensatz zu seinem Vorgänger legte er Wert auf Transparenz.',
      'Im Gegensatz zu seinen Vorgänger legte er Wert auf Transparenz.',
      'Im Gegensatz zu seinem Vorgänger legte er Wert auf Transparenze.',
      'In Gegensatz zu seinem Vorgänger legte er Wert auf Transparenz.'
    ],
    'correctAnswer': 0,
    'explanation': '"Im Gegensatz zu" regiert den Dativ: "seinem Vorgänger". "Wert legen auf" mit Akkusativ.',
    'exampleSentence': 'Im Gegensatz zu seinem Vorgänger legte er Wert auf Transparenz.',
    'grammarRule': 'Präpositionalphrase mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dementsprechend wurde das Verfahren eingestellt.',
      'Dementsprechend das Verfahren wurde eingestellt.',
      'Dementsprechend wurde eingestellt das Verfahren.',
      'Das Verfahren dementsprechend eingestellt wurde.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dementsprechend" im Vorfeld verlangt Inversion: Verb vor Subjekt.',
    'exampleSentence': 'Dementsprechend wurde das Verfahren eingestellt.',
    'grammarRule': 'Inversion nach konjunktionalem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Pferd von hinten aufgezäumt.',
      'Er hat das Pferd von hinten aufgezäumet.',
      'Er hat dem Pferd von hinten aufgezäumt.',
      'Er hat das Pferd von hinten aufzäumen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Das Pferd von hinten aufzäumen" (etwas falsch angehen). Akkusativ: "das Pferd".',
    'exampleSentence': 'Er hat das Pferd von hinten aufgezäumt.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Freilich, das muss man zugeben, hat er recht.',
      'Freilich das muss man zugeben hat er recht.',
      'Freilich, das muss man zugeben hat er recht.',
      'Freilich das muss man zugeben, hat er recht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der parenthetische Einschub "das muss man zugeben" wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Freilich, das muss man zugeben, hat er recht.',
    'grammarRule': 'Paarige Kommas bei parenthetischem Hauptsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir sind uns der Schwierigkeiten durchaus bewusst.',
      'Wir sind uns die Schwierigkeiten durchaus bewusst.',
      'Wir sind uns den Schwierigkeiten durchaus bewusst.',
      'Wir sind uns der Schwierigkeiten durchaus bewusste.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache bewusst sein" mit Genitiv: "der Schwierigkeiten".',
    'exampleSentence': 'Wir sind uns der Schwierigkeiten durchaus bewusst.',
    'grammarRule': 'Genitivrektion bei "bewusst sein" im Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Requiem wurde feierlich aufgeführt.',
      'Der Requiem wurde feierlich aufgeführt.',
      'Die Requiem wurde feierlich aufgeführt.',
      'Das Requiem wurden feierlich aufgeführt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Requiem" ist Neutrum: das Requiem.',
    'exampleSentence': 'Das Requiem wurde feierlich aufgeführt.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein jeder muss für sich selbst entscheiden.',
      'Ein jeder müssen für sich selbst entscheiden.',
      'Einen jeden muss für sich selbst entscheiden.',
      'Ein jeder muss für sich selber entscheidet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ein jeder" (Singular) verlangt "muss". "Für sich selbst" mit Akkusativ-Reflexiv.',
    'exampleSentence': 'Ein jeder muss für sich selbst entscheiden.',
    'grammarRule': 'Kongruenz bei gehobenem Indefinitpronomen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er trug Sorge dafür, dass alles bereit sei.',
      'Er trug Sorge dafür, dass alles bereit ist.',
      'Er trug Sorge dafür, das alles bereit sei.',
      'Er truge Sorge dafür, dass alles bereit sei.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sorge tragen" (sich kümmern) ist eine gehobene Wendung. "Sei" im Konjunktiv I (indirekte Absicht).',
    'exampleSentence': 'Er trug Sorge dafür, dass alles bereit sei.',
    'grammarRule': 'Gehobene Wendung mit Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Demzufolge ist eine Änderung des Vertrags notwendig.',
      'Demzufolge ist eine Änderung dem Vertrag notwendig.',
      'Demzufolge ist einen Änderung des Vertrags notwendig.',
      'Dem zufolge ist eine Änderung des Vertrags notwendig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Demzufolge" (zusammengeschrieben) als Konjunktionaladverb. "Des Vertrags" im Genitiv.',
    'exampleSentence': 'Demzufolge ist eine Änderung des Vertrags notwendig.',
    'grammarRule': 'Konjunktionaladverb mit Genitivattribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotzdem hielt er an seinem Plan fest.',
      'Trotzdem er hielt an seinem Plan fest.',
      'Trotzdem hielt an seinem Plan er fest.',
      'Er trotzdem hielt an seinem Plan fest.'
    ],
    'correctAnswer': 0,
    'explanation': '"Trotzdem" als Konjunktionaladverb im Vorfeld verlangt Inversion.',
    'exampleSentence': 'Trotzdem hielt er an seinem Plan fest.',
    'grammarRule': 'Inversion nach konzessivem Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm einen Strich durch die Rechnung gemacht.',
      'Sie hat ihn einen Strich durch die Rechnung gemacht.',
      'Sie hat ihm einem Strich durch die Rechnung gemacht.',
      'Sie hat ihm einen Strich durch der Rechnung gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem einen Strich durch die Rechnung machen" (Pläne durchkreuzen). Dativ: "ihm".',
    'exampleSentence': 'Sie hat ihm einen Strich durch die Rechnung gemacht.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptete, ohne es beweisen zu können, dass dies falsch sei.',
      'Er behauptete ohne es beweisen zu können dass dies falsch sei.',
      'Er behauptete, ohne es beweisen zu können dass dies falsch sei.',
      'Er behauptete ohne es beweisen zu können, dass dies falsch sei.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die eingeschobene Infinitivgruppe "ohne es beweisen zu können" wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Er behauptete, ohne es beweisen zu können, dass dies falsch sei.',
    'grammarRule': 'Paarige Kommas bei eingeschobener Infinitivgruppe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p8-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich der Sache angenommen.',
      'Er hat sich die Sache angenommen.',
      'Er hat sich dem Sache angenommen.',
      'Er hat sich der Sache angenommt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache annehmen" regiert den Genitiv: "der Sache".',
    'exampleSentence': 'Er hat sich der Sache angenommen.',
    'grammarRule': 'Genitivrektion bei "sich annehmen"',
    'tags': ['satzkorrektur']
  }
];

export default questions;
