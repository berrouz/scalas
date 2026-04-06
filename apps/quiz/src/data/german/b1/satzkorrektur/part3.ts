import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Perfekt: haben + Partizip II',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich gestern habe ein Buch gelesen.',
      'Ich habe ein Buch gestern gelest.',
      'Ich habe gestern ein Buch gelesen.',
      'Ich habe gestern ein Buch gelest.'
    ],
    'correctAnswer': 2,
    'explanation': 'Partizip II von \'lesen\' ist \'gelesen\', Verb auf Position 2.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich danke dir für deine Hilfe.',
      'Ich danke dich für deine Hilfe.',
      'Ich danke dir für deiner Hilfe.',
      'Ich danke dich für deiner Hilfe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Danken\' verlangt den Dativ: dir. \'Für\' verlangt den Akkusativ: deine Hilfe.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich weiß, dass sie morgen nach München fährt.',
      'Ich weiß, dass sie morgen nach München fahrt.',
      'Ich weiß, dass sie fährt morgen nach München.',
      'Ich weiß, dass morgen sie nach München fährt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'dass\' steht das konjugierte Verb am Ende: fährt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie trinkt jeden Morgen eine Tasse heißen Tee.',
      'Sie trinkt jeden Morgen eine Tasse heißer Tee.',
      'Sie trinkt jeden Morgen eine Tasse heißem Tee.',
      'Sie trinkt jeden Morgen eine Tasse heißen Tees.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'eine Tasse\' steht Akkusativ: heißen Tee (maskulin, starke Deklination).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er bittet seinen Freund um Hilfe.',
      'Er bittet seinen Freund für Hilfe.',
      'Er bittet seinen Freund nach Hilfe.',
      'Er bittet seinen Freund über Hilfe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bitten um\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl sie krank ist, geht sie zur Arbeit.',
      'Obwohl sie krank ist, sie geht zur Arbeit.',
      'Obwohl ist sie krank, geht sie zur Arbeit.',
      'Obwohl sie ist krank, geht sie zur Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'obwohl\' steht das Verb am Ende. Im Hauptsatz danach folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er spricht mit einem freundlichen Kollegen.',
      'Er spricht mit einem freundlicher Kollegen.',
      'Er spricht mit einen freundlichen Kollegen.',
      'Er spricht mit einem freundlichen Kollege.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mit\' verlangt Dativ: einem freundlichen Kollegen (N-Deklination).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir sind letztes Jahr nach Italien gereist.',
      'Wir haben letztes Jahr nach Italien gereist.',
      'Wir sind letztes Jahr nach Italien gereisen.',
      'Wir sind letztes Jahr nach Italien reiste.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Reisen\' bildet Perfekt mit \'sein\' (Ortswechsel): sind gereist.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie darf heute nicht arbeiten.',
      'Sie darf heute nicht gearbeitet.',
      'Sie darf heute nicht zu arbeiten.',
      'Sie darf heute nicht arbeitete.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Modalverben steht der Infinitiv ohne \'zu\': darf ... arbeiten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie vertraut ihrem Mann vollkommen.',
      'Sie vertraut ihren Mann vollkommen.',
      'Sie vertraut ihr Mann vollkommen.',
      'Sie vertraut ihres Mannes vollkommen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Vertrauen\' verlangt den Dativ: ihrem Mann.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er fragte mich, wohin ich in den Ferien fahre.',
      'Er fragte mich, wohin fahre ich in den Ferien.',
      'Er fragte mich, wohin ich in den Ferien fahren.',
      'Er fragte mich, wohin ich fahre in den Ferien.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Frage steht das Verb am Ende des Nebensatzes: wohin ich ... fahre.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder spielen mit dem neuen Ball.',
      'Die Kinder spielen mit den neuen Ball.',
      'Die Kinder spielen mit der neue Ball.',
      'Die Kinder spielen mit das neue Ball.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Ball\' ist maskulin. \'Mit\' + Dativ: dem neuen Ball.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er achtet immer auf seine Gesundheit.',
      'Er achtet immer für seine Gesundheit.',
      'Er achtet immer über seine Gesundheit.',
      'Er achtet immer an seine Gesundheit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Achten auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er lernt Deutsch, um in Deutschland zu arbeiten.',
      'Er lernt Deutsch, um in Deutschland arbeiten.',
      'Er lernt Deutsch, um zu arbeiten in Deutschland.',
      'Er lernt Deutsch, um in Deutschland arbeitet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Um ... zu\' + Infinitiv: um in Deutschland zu arbeiten. \'Zu\' steht direkt vor dem Infinitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich ein teures Kleid gekauft.',
      'Sie hat sich ein teurer Kleid gekauft.',
      'Sie hat sich ein teurem Kleid gekauft.',
      'Sie hat sich einen teuren Kleid gekauft.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kleid\' ist Neutrum. Akkusativ mit unbestimmtem Artikel: ein teures Kleid.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bis morgen werde ich den Bericht fertiggestellt haben.',
      'Bis morgen werde ich den Bericht fertiggestellt.',
      'Bis morgen werde ich den Bericht fertigstellen haben.',
      'Bis morgen habe ich den Bericht fertiggestellt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur II: werde + Partizip II + haben. Drückt eine abgeschlossene Handlung in der Zukunft aus.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Patient wird vom Arzt untersucht.',
      'Der Patient wird vom Arzt untersuchen.',
      'Der Patient wird vom Arzt untersuchte.',
      'Der Patient wird vom Arzt geuntersucht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorgangspassiv Präsens: wird + Partizip II. Partizip II von \'untersuchen\' ist \'untersucht\' (kein ge- bei untrennbarem Präfix).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Außerhalb der Stadt gibt es viele Wälder.',
      'Außerhalb die Stadt gibt es viele Wälder.',
      'Außerhalb dem Stadt gibt es viele Wälder.',
      'Außerhalb den Stadt gibt es viele Wälder.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Außerhalb\' verlangt den Genitiv: außerhalb der Stadt (feminin Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie kümmert sich um ihre kranke Mutter.',
      'Sie kümmert sich für ihre kranke Mutter.',
      'Sie kümmert sich über ihre kranke Mutter.',
      'Sie kümmert sich an ihre kranke Mutter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich kümmern um\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotzdem bin ich zum Unterricht gegangen.',
      'Trotzdem ich bin zum Unterricht gegangen.',
      'Trotzdem bin zum Unterricht ich gegangen.',
      'Trotzdem gegangen bin ich zum Unterricht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'trotzdem\' (Adverb) steht Inversion: bin ich...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schreibt seiner besten Freundin eine Nachricht.',
      'Er schreibt seine beste Freundin eine Nachricht.',
      'Er schreibt seinem besten Freundin eine Nachricht.',
      'Er schreibt seiner bester Freundin eine Nachricht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schreiben\' + Dativ (Person). Feminin Dativ: seiner besten Freundin.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Solange du hier bist, musst du die Regeln beachten.',
      'Solange du hier bist, du musst die Regeln beachten.',
      'Solange du bist hier, musst du die Regeln beachten.',
      'Solange hier du bist, musst du die Regeln beachten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'solange\' steht das Verb am Ende: solange du hier bist. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kalter Kaffee schmeckt mir nicht.',
      'Kalten Kaffee schmeckt mir nicht.',
      'Kaltem Kaffee schmeckt mir nicht.',
      'Kaltes Kaffee schmeckt mir nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaffee\' ist maskulin. Nominativ ohne Artikel (starke Deklination): kalter Kaffee.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Als das Telefon klingelte, duschte ich gerade.',
      'Wenn das Telefon klingelte, duschte ich gerade.',
      'Als das Telefon klingelt, duschte ich gerade.',
      'Als das Telefon klingelte, ich duschte gerade.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als\' für einmalige Ereignisse in der Vergangenheit. Im Hauptsatz: Verb auf Position 1 nach Nebensatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben beschlossen, früher abzureisen.',
      'Wir haben beschlossen, früher abreisen.',
      'Wir haben beschlossen, früher zu abreisen.',
      'Wir haben beschlossen, früher abgereist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: abzureisen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Statt des Kuchens hat sie Obst mitgebracht.',
      'Statt dem Kuchen hat sie Obst mitgebracht.',
      'Statt den Kuchen hat sie Obst mitgebracht.',
      'Statt der Kuchen hat sie Obst mitgebracht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Statt\' (anstatt) verlangt den Genitiv: statt des Kuchens.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat Angst vor Spinnen.',
      'Sie hat Angst über Spinnen.',
      'Sie hat Angst von Spinnen.',
      'Sie hat Angst für Spinnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Angst haben vor\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Deshalb habe ich mich für diesen Kurs angemeldet.',
      'Deshalb ich habe mich für diesen Kurs angemeldet.',
      'Deshalb habe mich ich für diesen Kurs angemeldet.',
      'Deshalb angemeldet habe ich mich für diesen Kurs.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'deshalb\' (Adverb) steht das Verb auf Position 2 mit Inversion: habe ich...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir besuchen das berühmte Museum in der Altstadt.',
      'Wir besuchen den berühmten Museum in der Altstadt.',
      'Wir besuchen der berühmte Museum in der Altstadt.',
      'Wir besuchen die berühmte Museum in der Altstadt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Museum\' ist Neutrum (das Museum). Im Akkusativ: das berühmte Museum.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstatt fernzusehen, solltest du lieber lesen.',
      'Anstatt fernsehen, solltest du lieber lesen.',
      'Anstatt zu fernsehen, solltest du lieber lesen.',
      'Anstatt ferngesehen, solltest du lieber lesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Anstatt ... zu\' + Infinitiv: Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: fernzusehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Ergebnis des letzten Tests war schlecht.',
      'Das Ergebnis des letzter Tests war schlecht.',
      'Das Ergebnis dem letzten Tests war schlecht.',
      'Das Ergebnis der letzten Tests war schlecht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv maskulin: des letzten Tests. Nach bestimmtem Artikel im Genitiv endet das Adjektiv auf -en.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie war gerade eingeschlafen, als jemand an die Tür klopfte.',
      'Sie ist gerade eingeschlafen, als jemand an die Tür klopfte.',
      'Sie hat gerade eingeschlafen, als jemand an die Tür klopfte.',
      'Sie war gerade eingeschlafen, als jemand an die Tür geklopft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt mit \'sein\' (Zustandsänderung): war eingeschlafen. \'Als\' + Präteritum für einmalige Handlung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er scheint ein netter Mensch zu sein.',
      'Er scheint ein netter Mensch sein.',
      'Er scheint ein netter Mensch ist.',
      'Er scheint ein netter Mensch zu ist.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Scheinen\' + zu + Infinitiv: scheint ... zu sein.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin meinem Freund zufällig begegnet.',
      'Ich bin meinen Freund zufällig begegnet.',
      'Ich habe meinem Freund zufällig begegnet.',
      'Ich bin mein Freund zufällig begegnet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Begegnen\' verlangt Dativ und bildet Perfekt mit \'sein\': bin meinem Freund begegnet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich verzichte auf das Dessert.',
      'Ich verzichte für das Dessert.',
      'Ich verzichte über das Dessert.',
      'Ich verzichte von dem Dessert.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Verzichten auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wahrscheinlich wird er morgen nicht kommen.',
      'Wahrscheinlich er wird morgen nicht kommen.',
      'Wahrscheinlich wird morgen er nicht kommen.',
      'Wahrscheinlich morgen wird er nicht kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Adverb \'wahrscheinlich\' am Satzanfang steht das Verb auf Position 2 mit Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kannst du mir bitte den blauen Stift geben?',
      'Kannst du mir bitte der blaue Stift geben?',
      'Kannst du mir bitte dem blauen Stift geben?',
      'Kannst du mir bitte die blaue Stift geben?'
    ],
    'correctAnswer': 0,
    'explanation': '\'Stift\' ist maskulin. \'Geben\' + Akkusativ: den blauen Stift.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder sein Bruder noch seine Schwester kommen zur Feier.',
      'Weder sein Bruder noch seine Schwester kommt zur Feier.',
      'Weder sein Bruder oder seine Schwester kommen zur Feier.',
      'Weder sein Bruder noch kommen seine Schwester zur Feier.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Weder ... noch\' verbindet zwei Subjekte. Bei zwei Subjekten steht das Verb im Plural: kommen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz schwerer Krankheit arbeitet sie weiter.',
      'Trotz schwere Krankheit arbeitet sie weiter.',
      'Trotz schwerem Krankheit arbeitet sie weiter.',
      'Trotz schweren Krankheit arbeitet sie weiter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Trotz\' + Genitiv. Feminin Genitiv ohne Artikel (starke Deklination): schwerer Krankheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jeden Sommer fuhren wir an die Ostsee.',
      'Jeden Sommer fahren wir an die Ostsee gefahren.',
      'Jeden Sommer fuhren wir auf die Ostsee.',
      'Jeden Sommer fährt wir an die Ostsee.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum von \'fahren\' in der 1. Person Plural: fuhren. \'An die Ostsee\' für Richtung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem lässt sich leicht lösen.',
      'Das Problem lässt sich leicht gelöst.',
      'Das Problem lässt sich leicht zu lösen.',
      'Das Problem lässt sich leicht löste.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich lassen\' + Infinitiv drückt eine Möglichkeit aus: lässt sich lösen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den ganzen Abend mit seinen Freunden verbracht.',
      'Er hat den ganzen Abend mit seine Freunde verbracht.',
      'Er hat den ganzen Abend mit seinen Freunde verbracht.',
      'Er hat der ganze Abend mit seinen Freunden verbracht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mit\' + Dativ Plural: mit seinen Freunden. Akkusativ der Zeit: den ganzen Abend.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie leidet unter starken Kopfschmerzen.',
      'Sie leidet von starken Kopfschmerzen.',
      'Sie leidet an starken Kopfschmerzen.',
      'Sie leidet über starke Kopfschmerzen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Leiden unter\' + Dativ ist die korrekte Verbindung bei Beschwerden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zuerst müssen wir einkaufen und dann kochen.',
      'Zuerst wir müssen einkaufen und dann kochen.',
      'Zuerst müssen einkaufen wir und dann kochen.',
      'Zuerst wir einkaufen müssen und dann kochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'zuerst\' am Satzanfang steht das Verb auf Position 2 mit Inversion: müssen wir...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Geschäft um die Ecke ist sehr günstig.',
      'Der Geschäft um die Ecke ist sehr günstig.',
      'Die Geschäft um die Ecke ist sehr günstig.',
      'Den Geschäft um die Ecke ist sehr günstig.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Geschäft\' ist Neutrum (das Geschäft). Nominativ: das Geschäft.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sowohl Peter als auch Maria sprechen Englisch.',
      'Sowohl Peter als auch Maria spricht Englisch.',
      'Sowohl Peter und auch Maria sprechen Englisch.',
      'Sowohl Peter als Maria auch sprechen Englisch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sowohl ... als auch\' verbindet zwei Subjekte. Bei zwei Subjekten steht das Verb im Plural.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir brauchen neue, bequeme Stühle.',
      'Wir brauchen neuen, bequemen Stühle.',
      'Wir brauchen newer, bequemer Stühle.',
      'Wir brauchen neuem, bequemem Stühle.'
    ],
    'correctAnswer': 0,
    'explanation': 'Akkusativ Plural ohne Artikel (starke Deklination): neue, bequeme Stühle.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn er Zeit hätte, würde er uns besuchen.',
      'Wenn er Zeit hätte, wird er uns besuchen.',
      'Wenn er Zeit hätte, besucht er uns.',
      'Wenn er Zeit hat, würde er uns besuchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: hätte (Nebensatz) + würde besuchen (Hauptsatz) für irreale Bedingungen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachricht wurde sofort weitergeleitet.',
      'Die Nachricht wurde sofort weiterleiten.',
      'Die Nachricht wurde sofort weitergeleiten.',
      'Die Nachricht wurde sofort geweitergeleitet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Präteritum: wurde + Partizip II. Bei trennbaren Verben: weitergeleitet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p3-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich an die neue Umgebung gewöhnt.',
      'Er hat sich auf die neue Umgebung gewöhnt.',
      'Er hat sich mit die neue Umgebung gewöhnt.',
      'Er hat sich in die neue Umgebung gewöhnt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich gewöhnen an\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
