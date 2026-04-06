import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wechselpräposition + Dativ',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder spielen im Garten.',
      'Die Kinder spielen in Garten.',
      'Die Kinder spielen ins Garten.',
      'Die Kinder spielen in den Garten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wo? → Dativ: im Garten (in dem Garten).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat die Prüfung bestanden.',
      'Er hat die Prüfung besteht.',
      'Er hat die Prüfung bestehend.',
      'Er hat die Prüfung gebestanden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II von \'bestehen\' ist \'bestanden\'. Kein ge- bei untrennbarem Präfix be-.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Buch gehört dem kleinen Jungen.',
      'Das Buch gehört den kleinen Jungen.',
      'Das Buch gehört der kleine Junge.',
      'Das Buch gehört des kleinen Jungen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gehören\' verlangt Dativ. \'Junge\' ist N-Deklination: dem kleinen Jungen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Leider konnte ich gestern nicht zur Party kommen.',
      'Leider ich konnte gestern nicht zur Party kommen.',
      'Leider konnte gestern ich nicht zur Party kommen.',
      'Leider gestern konnte ich nicht zur Party kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'leider\' am Satzanfang steht das Verb auf Position 2 mit Inversion: konnte ich...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat eine wichtige Entscheidung getroffen.',
      'Er hat einen wichtigen Entscheidung getroffen.',
      'Er hat ein wichtiges Entscheidung getroffen.',
      'Er hat einer wichtiger Entscheidung getroffen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Entscheidung\' ist feminin. Akkusativ: eine wichtige Entscheidung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich verlasse mich auf dich.',
      'Ich verlasse mich an dich.',
      'Ich verlasse mich über dich.',
      'Ich verlasse mich für dich.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich verlassen auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seit ich in Deutschland lebe, spreche ich besser Deutsch.',
      'Seit ich in Deutschland lebe, ich spreche besser Deutsch.',
      'Seit ich lebe in Deutschland, spreche ich besser Deutsch.',
      'Seit in Deutschland ich lebe, spreche ich besser Deutsch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'seit\' steht das Verb am Ende. Im Hauptsatz danach steht das Verb auf Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat einen langen, anstrengenden Tag gehabt.',
      'Sie hat einen langer, anstrengender Tag gehabt.',
      'Sie hat einem langen, anstrengenden Tag gehabt.',
      'Sie hat ein langes, anstrengendes Tag gehabt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Tag\' ist maskulin. Akkusativ: einen langen, anstrengenden Tag.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem er geduscht hatte, frühstückte er.',
      'Nachdem er geduscht hat, frühstückte er.',
      'Nachdem er duschte, frühstückte er.',
      'Nachdem er geduscht hatte, er frühstückte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'nachdem\' steht Plusquamperfekt bei Hauptsatz im Präteritum: hatte geduscht ... frühstückte.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat vergessen, den Brief einzuwerfen.',
      'Sie hat vergessen, den Brief zu einwerfen.',
      'Sie hat vergessen, den Brief einwerfen.',
      'Sie hat vergessen, den Brief eingeworfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: einzuwerfen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Lehrerin gibt den Kindern die Hefte zurück.',
      'Die Lehrerin gibt die Kinder die Hefte zurück.',
      'Die Lehrerin gibt den Kindern den Hefte zurück.',
      'Die Lehrerin gibt der Kinder die Hefte zurück.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Geben\' + Dativ (Person) + Akkusativ (Sache): den Kindern (Dativ Plural) die Hefte (Akkusativ Plural).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sagte, er habe keine Zeit gehabt.',
      'Er sagte, er keine Zeit gehabt habe.',
      'Er sagte, habe er keine Zeit gehabt.',
      'Er sagte, er habe gehabt keine Zeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede ohne \'dass\': Verb auf Position 2. Konjunktiv I: habe ... gehabt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben uns in einem gemütlichen Café getroffen.',
      'Wir haben uns in einen gemütlichen Café getroffen.',
      'Wir haben uns in einem gemütlicher Café getroffen.',
      'Wir haben uns in ein gemütliches Café getroffen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Café\' ist Neutrum. \'In\' + Dativ (Wo?): in einem gemütlichen Café.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie zweifelt an seiner Ehrlichkeit.',
      'Sie zweifelt über seine Ehrlichkeit.',
      'Sie zweifelt für seine Ehrlichkeit.',
      'Sie zweifelt auf seine Ehrlichkeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Zweifeln an\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Indem man viel liest, erweitert man seinen Wortschatz.',
      'Indem man viel liest, man erweitert seinen Wortschatz.',
      'Indem man liest viel, erweitert man seinen Wortschatz.',
      'Indem viel man liest, erweitert man seinen Wortschatz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'indem\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist ein bekannter deutscher Schriftsteller.',
      'Er ist ein bekannter deutsches Schriftsteller.',
      'Er ist ein bekannten deutschen Schriftsteller.',
      'Er ist einer bekannter deutscher Schriftsteller.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominativ maskulin nach unbestimmtem Artikel: ein bekannter deutscher Schriftsteller.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bevor sie nach Hause ging, hatte sie noch eingekauft.',
      'Bevor sie nach Hause ging, hat sie noch eingekauft.',
      'Bevor sie nach Hause ging, kaufte sie noch eingekauft.',
      'Bevor sie nach Hause ging, hatte sie noch einkaufen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt (hatte eingekauft) für die Vorzeitigkeit im Zusammenhang mit Präteritum.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Straße wird gerade repariert.',
      'Die Straße wird gerade reparieren.',
      'Die Straße wird gerade gerepariert.',
      'Die Straße ist gerade repariert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorgangspassiv Präsens: wird + Partizip II. Kein ge- bei Verben auf -ieren: repariert.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angesichts der schwierigen Lage müssen wir handeln.',
      'Angesichts die schwierige Lage müssen wir handeln.',
      'Angesichts dem schwierigen Lage müssen wir handeln.',
      'Angesichts den schwierigen Lage müssen wir handeln.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Angesichts\' verlangt den Genitiv: angesichts der schwierigen Lage.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich über das Ergebnis beschwert.',
      'Er hat sich auf das Ergebnis beschwert.',
      'Er hat sich für das Ergebnis beschwert.',
      'Er hat sich an das Ergebnis beschwert.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich beschweren über\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Normalerweise stehe ich um sieben Uhr auf.',
      'Normalerweise ich stehe um sieben Uhr auf.',
      'Normalerweise stehe auf ich um sieben Uhr.',
      'Normalerweise auf stehe ich um sieben Uhr.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb: Präfix am Ende. Nach Adverb am Satzanfang: Verb auf Position 2.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Qualität des deutschen Bieres ist weltbekannt.',
      'Die Qualität des deutsches Bieres ist weltbekannt.',
      'Die Qualität dem deutschen Bieres ist weltbekannt.',
      'Die Qualität der deutschen Bieres ist weltbekannt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv Neutrum: des deutschen Bieres. Nach bestimmtem Artikel im Genitiv endet das Adjektiv auf -en.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich weiß nicht, ob ich das schaffen kann.',
      'Ich weiß nicht, ob ich das schaffen könnte.',
      'Ich weiß nicht, ob ich kann das schaffen.',
      'Ich weiß nicht, ob das schaffen ich kann.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'ob\' steht das konjugierte Verb am Ende: ob ich das schaffen kann.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Guter Wein muss nicht teuer sein.',
      'Guten Wein muss nicht teuer sein.',
      'Gutem Wein muss nicht teuer sein.',
      'Gutes Wein muss nicht teuer sein.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wein\' ist maskulin. Nominativ ohne Artikel (starke Deklination): guter Wein.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich mehr Geld hätte, würde ich ein Haus kaufen.',
      'Wenn ich mehr Geld habe, würde ich ein Haus kaufen.',
      'Wenn ich mehr Geld hätte, werde ich ein Haus kaufen.',
      'Wenn ich mehr Geld hätte, kaufe ich ein Haus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II für irreale Wünsche: hätte (Nebensatz) + würde kaufen (Hauptsatz).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Konzert wurde leider abgesagt.',
      'Das Konzert wurde leider absagen.',
      'Das Konzert wurde leider geabsagt.',
      'Das Konzert wurde leider abgesagen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Präteritum: wurde + Partizip II. Trennbares Verb: ab|sagen → abgesagt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat mir bei meinem Problem geholfen.',
      'Sie hat mich bei meinem Problem geholfen.',
      'Sie hat mir bei mein Problem geholfen.',
      'Sie hat mir bei meinen Problem geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Helfen\' verlangt Dativ: mir. \'Bei\' + Dativ: bei meinem Problem (Neutrum Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hofft auf besseres Wetter.',
      'Er hofft für besseres Wetter.',
      'Er hofft über besseres Wetter.',
      'Er hofft an besseres Wetter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Hoffen auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aus diesem Grund hat er sich entschieden, umzuziehen.',
      'Aus diesem Grund er hat sich entschieden, umzuziehen.',
      'Aus diesem Grund hat sich er entschieden, umzuziehen.',
      'Aus diesem Grund entschieden hat er sich, umzuziehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach kausaler Angabe am Satzanfang: Verb auf Position 2, dann Subjekt: hat er sich entschieden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'In der kleinen Stadt gibt es nur ein Krankenhaus.',
      'In der kleinen Stadt gibt es nur einen Krankenhaus.',
      'In die kleine Stadt gibt es nur ein Krankenhaus.',
      'In der kleiner Stadt gibt es nur ein Krankenhaus.'
    ],
    'correctAnswer': 0,
    'explanation': '\'In\' + Dativ (Wo?): in der kleinen Stadt. \'Krankenhaus\' ist Neutrum: ein Krankenhaus.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er arbeitet fleißig, sodass er gute Noten bekommt.',
      'Er arbeitet fleißig, sodass er bekommt gute Noten.',
      'Er arbeitet fleißig, sodass gute Noten er bekommt.',
      'Er arbeitet fleißig, sodass bekommt er gute Noten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'sodass\' steht das Verb am Ende: sodass er gute Noten bekommt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist der Hund unseres neuen Nachbarn.',
      'Das ist der Hund unseres neuen Nachbar.',
      'Das ist der Hund unserem neuen Nachbarn.',
      'Das ist der Hund unseren neuen Nachbarn.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv: unseres neuen Nachbarn. \'Nachbar\' ist N-Deklination: -n im Genitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'In zehn Jahren werde ich hoffentlich als Ärztin arbeiten.',
      'In zehn Jahren würde ich hoffentlich als Ärztin arbeiten.',
      'In zehn Jahren werde ich hoffentlich als Ärztin gearbeitet.',
      'In zehn Jahren werde ich hoffentlich als Ärztin arbeitete.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I für Pläne: werde + Infinitiv (arbeiten).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptet, alles verstanden zu haben.',
      'Er behauptet, alles verstanden haben.',
      'Er behauptet, alles zu verstanden haben.',
      'Er behauptet, alles verstehen gehabt zu haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitiv Perfekt: Partizip II + zu + haben: verstanden zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz seines hohen Alters ist er sehr aktiv.',
      'Trotz seinem hohen Alter ist er sehr aktiv.',
      'Trotz sein hohes Alter ist er sehr aktiv.',
      'Trotz seinen hohen Alters ist er sehr aktiv.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Trotz\' verlangt den Genitiv: trotz seines hohen Alters (Neutrum Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hängt das Bild an die Wand.',
      'Er hängt das Bild auf die Wand.',
      'Er hängt das Bild in die Wand.',
      'Er hängt das Bild bei die Wand.'
    ],
    'correctAnswer': 0,
    'explanation': '\'An die Wand hängen\' (Wohin? + Akkusativ) ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nur wenn du dich anstrengst, kannst du es schaffen.',
      'Nur wenn du dich anstrengst, du kannst es schaffen.',
      'Nur wenn du anstrengst dich, kannst du es schaffen.',
      'Nur wenn dich du anstrengst, kannst du es schaffen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz steht das Verb am Ende. Im Hauptsatz nach Nebensatz steht das Verb auf Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich mit der netten Kollegin unterhalten.',
      'Er hat sich mit die nette Kollegin unterhalten.',
      'Er hat sich mit dem netten Kollegin unterhalten.',
      'Er hat sich mit der netter Kollegin unterhalten.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kollegin\' ist feminin. \'Mit\' + Dativ: der netten Kollegin.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sobald er ankommt, ruft er uns an.',
      'Sobald er ankommt, er ruft uns an.',
      'Sobald er kommt an, ruft er uns an.',
      'Sobald ankommt er, ruft er uns an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'sobald\' steht das Verb am Ende (zusammengeschrieben bei trennbaren Verben). Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Frische Luft tut jedem Menschen gut.',
      'Frischer Luft tut jedem Menschen gut.',
      'Frische Luft tut jeden Menschen gut.',
      'Frische Luft tut jeder Mensch gut.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Luft\' ist feminin. Nominativ: frische Luft. \'Guttun\' + Dativ: jedem Menschen (N-Deklination).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sagte, er sei gestern zu Hause gewesen.',
      'Er sagte, er ist gestern zu Hause gewesen.',
      'Er sagte, er war gestern zu Hause gewesen.',
      'Er sagte, er wäre gestern zu Hause.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Perfekt mit \'sein\': sei ... gewesen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man sollte regelmäßig Sport treiben.',
      'Man sollte regelmäßig Sport getrieben.',
      'Man sollte regelmäßig Sport zu treiben.',
      'Man sollte regelmäßig Sport treibt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb \'sollte\' + Infinitiv ohne \'zu\': sollte ... treiben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gibt dem Obdachlosen etwas Geld.',
      'Er gibt den Obdachlosen etwas Geld.',
      'Er gibt der Obdachlose etwas Geld.',
      'Er gibt des Obdachlosen etwas Geld.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Geben\' + Dativ (Person). Adjektivdeklination als Nomen im Dativ Singular maskulin: dem Obdachlosen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie teilnimmt an einem Sprachkurs.',
      'Sie nimmt an einem Sprachkurs teil.',
      'Sie nimmt für einen Sprachkurs teil.',
      'Sie nimmt in einem Sprachkurs teil.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Teilnehmen an\' + Dativ ist korrekt. Im Hauptsatz wird das trennbare Verb getrennt: nimmt ... teil.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nie hätte ich das gedacht.',
      'Nie ich hätte das gedacht.',
      'Nie hätte das gedacht ich.',
      'Nie gedacht hätte ich das.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach negativem Adverb \'nie\' am Satzanfang steht das Verb auf Position 2 mit Inversion: hätte ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie legt das Buch auf den Tisch.',
      'Sie legt das Buch auf dem Tisch.',
      'Sie legt das Buch auf der Tisch.',
      'Sie legt das Buch auf die Tisch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Legen\' + Wohin? → Akkusativ: auf den Tisch (maskulin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obgleich das Wetter schlecht war, machten wir einen Ausflug.',
      'Obgleich das Wetter schlecht war, wir machten einen Ausflug.',
      'Obgleich war das Wetter schlecht, machten wir einen Ausflug.',
      'Obgleich das Wetter war schlecht, machten wir einen Ausflug.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'obgleich\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich möchte ein Glas kalte Milch trinken.',
      'Ich möchte ein Glas kalten Milch trinken.',
      'Ich möchte ein Glas kalter Milch trinken.',
      'Ich möchte ein Glas kaltem Milch trinken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Maßangaben wie \'ein Glas\' folgt Nominativ/Akkusativ: kalte Milch (feminin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hatte den Zug verpasst, deshalb kam sie zu spät.',
      'Sie hat den Zug verpasst, deshalb kam sie zu spät.',
      'Sie hatte den Zug verpasste, deshalb kam sie zu spät.',
      'Sie hatte den Zug verpassen, deshalb kam sie zu spät.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt (hatte verpasst) für eine Handlung vor einer anderen in der Vergangenheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p4-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er braucht nicht zu kommen.',
      'Er braucht nicht kommen.',
      'Er braucht nicht zu gekommen.',
      'Er braucht nicht kommen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Brauchen\' + \'nicht zu\' + Infinitiv: braucht nicht zu kommen.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
