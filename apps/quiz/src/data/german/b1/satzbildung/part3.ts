import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-001',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich fahre jeden Morgen mit dem Zug zur Arbeit.',
      'Ich fahre jeden Morgen mit den Zug zur Arbeit.',
      'Ich fahre jeden Morgen mit der Zug zur Arbeit.',
      'Ich fahre jeden Morgen mit das Zug zur Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'mit\' verlangt Dativ: der Zug -> dem Zug.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-002',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Weil er den Bus verpasst hat, kam er zu spät.',
      'Weil er hat den Bus verpasst, kam er zu spät.',
      'Weil er den Bus verpasst hat, er kam zu spät.',
      'Weil den Bus er verpasst hat, kam er zu spät.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'weil\'-Nebensatz steht das Hilfsverb (hat) am Ende. Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-003',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er stellte den Koffer neben die Tür.',
      'Er stellte den Koffer neben der Tür.',
      'Er stellte den Koffer neben dem Tür.',
      'Er stellte der Koffer neben die Tür.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stellen neben\' = Richtung (wohin?) -> Akkusativ: neben die Tür.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-004',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich kann dir leider nicht helfen.',
      'Ich kann dich leider nicht helfen.',
      'Ich kann dir leider nicht zu helfen.',
      'Ich kann leider dir helfen nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt Dativ (dir). Nach Modalverben kein \'zu\' vor dem Infinitiv.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-005',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Mann, dessen Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, deren Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, dem Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, den Auto gestohlen wurde, rief die Polizei.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv maskulin: dessen (Besitz des Mannes).',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-006',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sich die Hände gewaschen.',
      'Er hat seine Hände gewaschen sich.',
      'Er hat gewaschen sich die Hände.',
      'Er hat die Hände sich gewaschen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Reflexivpronomen (sich) steht nach dem Hilfsverb; Partizip II am Ende.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-007',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Während der Ferien haben wir viel unternommen.',
      'Während die Ferien haben wir viel unternommen.',
      'Während den Ferien haben wir viel unternommen.',
      'Während dem Ferien haben wir viel unternommen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'während\' als Präposition verlangt Genitiv: während der Ferien.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-008',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es wäre schön, wenn du mitkommen könntest.',
      'Es wäre schön, wenn du mitkommen kannst.',
      'Es wäre schön, wenn du könntest mitkommen.',
      'Es wäre schön, wenn du mitkommen konntest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'wäre\' im Hauptsatz + \'könntest\' am Ende des Nebensatzes.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-009',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sobald er ankommt, ruft er mich an.',
      'Sobald er ankommt, er ruft mich an.',
      'Sobald ankommt er, ruft er mich an.',
      'Sobald er ankommt, mich ruft er an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'sobald\'-Nebensatz steht das Verb am Ende; im Hauptsatz folgt Inversion.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-010',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat den Schlüssel in die Tasche gesteckt.',
      'Er hat den Schlüssel in der Tasche gesteckt.',
      'Er hat den Schlüssel in dem Tasche gesteckt.',
      'Er hat der Schlüssel in die Tasche gesteckt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stecken in\' = Richtung (wohin?) -> Akkusativ: in die Tasche.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-011',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe ihr eine Nachricht geschickt.',
      'Ich habe sie eine Nachricht geschickt.',
      'Ich habe ihr einen Nachricht geschickt.',
      'Ich habe ihr eine Nachricht geschicken.'
    ],
    'correctAnswer': 0,
    'explanation': '\'schicken\' verlangt Dativ (ihr) + Akkusativ (eine Nachricht).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-012',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Film, über den alle sprechen, läuft im Kino.',
      'Der Film, über dem alle sprechen, läuft im Kino.',
      'Der Film, über der alle sprechen, läuft im Kino.',
      'Der Film, über die alle sprechen, läuft im Kino.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sprechen über\' + Akkusativ; \'Film\' ist maskulin -> über den.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-013',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Jeden Abend ruft er seine Mutter an.',
      'Jeden Abend er ruft seine Mutter an.',
      'Jeden Abend anruft er seine Mutter.',
      'Jeden Abend ruft seine Mutter er an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion bei Zeitangabe am Anfang; trennbares Verb: Präfix \'an\' am Ende.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-014',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er achtet auf seine Gesundheit.',
      'Er achtet über seine Gesundheit.',
      'Er achtet an seine Gesundheit.',
      'Er achtet für seine Gesundheit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'achten auf\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-015',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Seitdem sie hier arbeitet, fühlt sie sich wohler.',
      'Seitdem sie hier arbeitet, sie fühlt sich wohler.',
      'Seitdem sie arbeitet hier, fühlt sie sich wohler.',
      'Seitdem hier sie arbeitet, fühlt sie sich wohler.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'seitdem\'-Nebensatz steht das Verb am Ende; Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-016',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Kind klettert auf den Baum.',
      'Das Kind klettert auf dem Baum.',
      'Das Kind klettert auf der Baum.',
      'Das Kind klettert auf des Baumes.'
    ],
    'correctAnswer': 0,
    'explanation': '\'klettern auf\' = Richtung (wohin?) -> Akkusativ: auf den Baum.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-017',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Lehrerin, bei der ich Unterricht habe, ist nett.',
      'Die Lehrerin, bei die ich Unterricht habe, ist nett.',
      'Die Lehrerin, bei den ich Unterricht habe, ist nett.',
      'Die Lehrerin, bei dem ich Unterricht habe, ist nett.'
    ],
    'correctAnswer': 0,
    'explanation': '\'bei\' verlangt Dativ; \'Lehrerin\' ist feminin -> bei der.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-018',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sich bei mir für die Einladung bedankt.',
      'Er hat sich bei mich für die Einladung bedankt.',
      'Er hat sich bei mir über die Einladung bedankt.',
      'Er hat bei mir sich für die Einladung bedankt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich bedanken bei\' + Dativ (mir), \'für\' + Akkusativ (die Einladung).',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-019',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er würde gern nach Japan reisen.',
      'Er würde gern nach Japan zu reisen.',
      'Er würde gern nach Japan reist.',
      'Er gern würde nach Japan reisen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'würde\' + Infinitiv am Ende, ohne \'zu\'. Adverb \'gern\' steht zwischen.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-020',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie bringt ihrem Vater das Frühstück.',
      'Sie bringt ihren Vater das Frühstück.',
      'Sie bringt ihrem Vater den Frühstück.',
      'Sie bringt ihres Vaters das Frühstück.'
    ],
    'correctAnswer': 0,
    'explanation': '\'bringen\' verlangt Dativ (ihrem Vater) + Akkusativ (das Frühstück).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-021',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er ist weder reich noch berühmt.',
      'Er ist weder reich noch er ist berühmt.',
      'Er weder ist reich noch berühmt.',
      'Weder er ist reich noch berühmt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'weder ... noch\': Das Verb bleibt an Position 2; parallele Struktur.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-022',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Da es schon spät war, sind wir nach Hause gegangen.',
      'Da es schon spät war, wir sind nach Hause gegangen.',
      'Da schon spät es war, sind wir nach Hause gegangen.',
      'Da es schon spät war, nach Hause sind wir gegangen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'da\'-Nebensatz steht das Verb am Ende; im Hauptsatz folgt Inversion.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-023',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Katze springt auf den Schrank.',
      'Die Katze springt auf dem Schrank.',
      'Die Katze springt auf der Schrank.',
      'Die Katze springt auf des Schrankes.'
    ],
    'correctAnswer': 0,
    'explanation': '\'springen auf\' = Richtung (wohin?) -> Akkusativ: auf den Schrank.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-024',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie entschied sich für das rote Kleid.',
      'Sie entschied sich über das rote Kleid.',
      'Sie entschied sich an das rote Kleid.',
      'Sie entschied sich zu das rote Kleid.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich entscheiden für\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-025',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Kinder, denen wir geholfen haben, waren dankbar.',
      'Die Kinder, die wir geholfen haben, waren dankbar.',
      'Die Kinder, den wir geholfen haben, waren dankbar.',
      'Die Kinder, dessen wir geholfen haben, waren dankbar.'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt Dativ; Plural -> Relativpronomen: denen.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-026',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat die Tür zugemacht und ist gegangen.',
      'Er hat die Tür zugemacht und ist gehen.',
      'Er hat die Tür zugemacht und gegangen ist.',
      'Er hat zugemacht die Tür und ist gegangen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zwei Hauptsätze mit \'und\': normales Perfekt in beiden Teilen.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-027',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich wünschte, ich hätte mehr Zeit.',
      'Ich wünschte, ich habe mehr Zeit.',
      'Ich wünsche, ich hätte mehr Zeit.',
      'Ich wünschte, hätte ich mehr Zeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'ich wünschte\' (Konjunktiv II) + Nebensatz mit \'hätte\' für irrealen Wunsch.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-028',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er leiht seinem Bruder das Fahrrad.',
      'Er leiht seinen Bruder das Fahrrad.',
      'Er leiht seinem Bruder den Fahrrad.',
      'Er leiht sein Bruder das Fahrrad.'
    ],
    'correctAnswer': 0,
    'explanation': '\'leihen\' verlangt Dativ (seinem Bruder) + Akkusativ (das Fahrrad).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-029',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat vergessen, das Fenster zuzumachen.',
      'Er hat vergessen, das Fenster zu zumachen.',
      'Er hat vergessen, zuzumachen das Fenster.',
      'Er hat vergessen, das Fenster zumachen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: zuzumachen.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-030',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Vogel sitzt auf dem Dach.',
      'Der Vogel sitzt auf den Dach.',
      'Der Vogel sitzt auf das Dach.',
      'Der Vogel sitzt auf der Dach.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sitzen auf\' = Ort (wo?) -> Dativ: auf dem Dach. \'Dach\' ist Neutrum.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-031',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er fürchtet sich vor Spinnen.',
      'Er fürchtet sich über Spinnen.',
      'Er fürchtet sich an Spinnen.',
      'Er fürchtet sich für Spinnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich fürchten vor\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-032',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Stadt, aus der ich komme, liegt im Süden.',
      'Die Stadt, aus die ich komme, liegt im Süden.',
      'Die Stadt, aus dem ich komme, liegt im Süden.',
      'Die Stadt, aus den ich komme, liegt im Süden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'aus\' verlangt Dativ; \'Stadt\' ist feminin -> aus der.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-033',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nachdem sie eingekauft hatte, kochte sie das Abendessen.',
      'Nachdem sie eingekauft hat, kochte sie das Abendessen.',
      'Nachdem sie einkaufte, kochte sie das Abendessen.',
      'Nachdem sie eingekauft hatte, sie kochte das Abendessen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'nachdem\' + Plusquamperfekt; Inversion im Hauptsatz nach vorangestelltem Nebensatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-034',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Mutter zieht dem Kind die Jacke an.',
      'Die Mutter zieht das Kind die Jacke an.',
      'Die Mutter zieht den Kind die Jacke an.',
      'Die Mutter zieht dem Kind der Jacke an.'
    ],
    'correctAnswer': 0,
    'explanation': '\'anziehen\' mit Person: Dativ (dem Kind) + Akkusativ (die Jacke).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-035',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er zieht heute Abend in die neue Wohnung ein.',
      'Er zieht heute Abend in der neuen Wohnung ein.',
      'Er einzieht heute Abend in die neue Wohnung.',
      'Er zieht in die neue Wohnung heute Abend ein.'
    ],
    'correctAnswer': 0,
    'explanation': '\'einziehen in\' = Richtung (wohin?) -> Akkusativ. Trennbares Verb: Präfix am Ende.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-036',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er kam zu spät, deshalb hat er den Anfang verpasst.',
      'Er kam zu spät, deshalb er hat den Anfang verpasst.',
      'Er kam zu spät, deshalb den Anfang hat er verpasst.',
      'Er kam zu spät, er hat deshalb den Anfang verpasst.'
    ],
    'correctAnswer': 0,
    'explanation': '\'deshalb\' leitet einen Hauptsatz mit Inversion ein: Verb vor Subjekt.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-037',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Hätte ich das gewusst, wäre ich nicht gekommen.',
      'Hätte ich das gewusst, ich wäre nicht gekommen.',
      'Habe ich das gewusst, wäre ich nicht gekommen.',
      'Hätte ich das gewusst, würde ich nicht gekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit ohne \'wenn\': Hätte + Subjekt; Inversion im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-038',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie kümmert sich um ihre kranke Großmutter.',
      'Sie kümmert sich für ihre kranke Großmutter.',
      'Sie kümmert sich über ihre kranke Großmutter.',
      'Sie kümmert sich an ihre kranke Großmutter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich kümmern um\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-039',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Leute, mit denen ich arbeite, sind freundlich.',
      'Die Leute, mit die ich arbeite, sind freundlich.',
      'Die Leute, mit den ich arbeite, sind freundlich.',
      'Die Leute, mit dem ich arbeite, sind freundlich.'
    ],
    'correctAnswer': 0,
    'explanation': '\'mit\' verlangt Dativ; Plural -> Relativpronomen: denen.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-040',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat mich gebeten, ihm zu helfen.',
      'Er hat mich gebeten, ihm helfen.',
      'Er hat mich gebeten, zu ihm helfen.',
      'Er hat mich gebeten, ihm helfen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz: \'zu\' steht direkt vor dem Infinitiv \'helfen\'.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-041',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat seinen Freunden die Wahrheit gesagt.',
      'Er hat seine Freunde die Wahrheit gesagt.',
      'Er hat seinen Freunden der Wahrheit gesagt.',
      'Er hat sein Freunden die Wahrheit gesagt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sagen\' verlangt Dativ (seinen Freunden) + Akkusativ (die Wahrheit).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-043',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er läuft schnell über die Straße.',
      'Er läuft schnell über der Straße.',
      'Er läuft schnell über dem Straße.',
      'Er läuft schnell über den Straße.'
    ],
    'correctAnswer': 0,
    'explanation': '\'über die Straße\' = Richtung (wohin?) -> Akkusativ. \'Straße\' ist feminin.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-044',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Entweder gehen wir ins Kino oder wir bleiben zu Hause.',
      'Entweder gehen wir ins Kino oder bleiben wir zu Hause.',
      'Entweder wir gehen ins Kino oder wir bleiben zu Hause.',
      'Entweder ins Kino gehen wir oder zu Hause bleiben wir.'
    ],
    'correctAnswer': 0,
    'explanation': '\'entweder ... oder\': Inversion nach \'entweder\', normale Stellung nach \'oder\'.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-045',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'An seiner Stelle hätte ich anders gehandelt.',
      'An seiner Stelle ich hätte anders gehandelt.',
      'An seiner Stelle hätte ich anders handeln.',
      'An seiner Stelle hätte anders ich gehandelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit: \'hätte + Partizip II\' mit Inversion.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-046',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie bittet ihren Mann, die Kinder abzuholen.',
      'Sie bittet ihren Mann, die Kinder abholen.',
      'Sie bittet ihrem Mann, die Kinder abzuholen.',
      'Sie bittet ihren Mann, die Kinder zu abholen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'bitten\' + Akkusativ (ihren Mann); \'zu\' zwischen Präfix und Verb: abzuholen.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-047',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er gibt dem Kellner ein großzügiges Trinkgeld.',
      'Er gibt den Kellner ein großzügiges Trinkgeld.',
      'Er gibt dem Kellner einen großzügigen Trinkgeld.',
      'Er gibt der Kellner ein großzügiges Trinkgeld.'
    ],
    'correctAnswer': 0,
    'explanation': '\'geben\' verlangt Dativ (dem Kellner) + Akkusativ (ein Trinkgeld, Neutrum).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-048',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wartet darauf, dass der Bus kommt.',
      'Er wartet darauf, dass der Bus kommen.',
      'Er wartet darauf, dass kommt der Bus.',
      'Er wartet drauf, dass der Bus kommt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'warten darauf, dass\' — im Nebensatz steht das Verb am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-049',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Hund liegt unter dem Bett.',
      'Der Hund liegt unter den Bett.',
      'Der Hund liegt unter das Bett.',
      'Der Hund liegt unter der Bett.'
    ],
    'correctAnswer': 0,
    'explanation': '\'liegen unter\' = Ort (wo?) -> Dativ: unter dem Bett. \'Bett\' ist Neutrum.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p3-050',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie verlässt sich auf ihre beste Freundin.',
      'Sie verlässt sich über ihre beste Freundin.',
      'Sie verlässt sich an ihre beste Freundin.',
      'Sie verlässt sich für ihre beste Freundin.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich verlassen auf\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  { 'language': 'german', 'id': 'b1-satzbildung-p3-050', 'level': 'b1', 'category': 'Satzbildung', 'subcategory': 'Wortstellung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Gestern hat er den ganzen Tag im Büro gearbeitet.', 'Gestern er hat den ganzen Tag im Büro gearbeitet.', 'Gestern hat er im Büro den ganzen Tag gearbeitet.', 'Gestern hat den ganzen Tag er im Büro gearbeitet.'], 'correctAnswer': 0, 'explanation': 'Nach temporalem Adverb auf Position 1 folgt Inversion (Verb + Subjekt). tekaDODA: temporal-kausal-modal-lokal.', 'grammarRule': 'Wortstellung: Zeitangabe auf Position 1 -> Inversion', 'tags': ['satzbildung', 'wortstellung'] }
];

export default questions;
