import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Perfekt: haben + Partizip II',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe gestern ein Buch gelesen.',
      'Ich habe ein Buch gestern gelest.',
      'Ich gestern habe ein Buch gelesen.',
      'Ich habe gestern ein Buch gelest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II von \'lesen\' ist \'gelesen\', Verb auf Position 2.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich helfe meinem Bruder bei der Arbeit.',
      'Ich helfe meinen Bruder bei der Arbeit.',
      'Ich helfe mein Bruder bei der Arbeit.',
      'Ich helfe meinem Bruder bei die Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Verb \'helfen\' verlangt den Dativ: meinem Bruder. \'Bei\' verlangt ebenfalls den Dativ: bei der Arbeit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gestern ich bin ins Kino gegangen.',
      'Gestern bin ich ins Kino gegangen.',
      'Gestern bin ins Kino ich gegangen.',
      'Gestern gegangen bin ich ins Kino.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Inversion steht das Verb auf Position 2 und das Subjekt direkt danach: Gestern bin ich...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Mädchen hat eine neue Kleid gekauft.',
      'Das Mädchen hat ein neues Kleid gekauft.',
      'Das Mädchen hat einen neuen Kleid gekauft.',
      'Das Mädchen hat einer neuer Kleid gekauft.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Kleid\' ist Neutrum (das Kleid). Im Akkusativ: ein neues Kleid.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich warte seit zwei Stunden auf den Bus.',
      'Ich warte seit zwei Stunden für den Bus.',
      'Ich warte seit zwei Stunden an den Bus.',
      'Ich warte seit zwei Stunden über den Bus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Verb \'warten\' wird mit der Präposition \'auf\' + Akkusativ verwendet: auf den Bus warten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bleibe zu Hause, weil ich bin krank.',
      'Ich bleibe zu Hause, weil ich krank bin.',
      'Ich bleibe zu Hause, weil krank ich bin.',
      'Ich bleibe zu Hause, weil bin ich krank.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nach der Konjunktion \'weil\' steht das Verb am Ende des Nebensatzes: weil ich krank bin.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den kleinen Hund gefunden.',
      'Er hat der kleiner Hund gefunden.',
      'Er hat dem kleinen Hund gefunden.',
      'Er hat des kleinen Hundes gefunden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Finden\' verlangt den Akkusativ. Maskulinum Akkusativ: den kleinen Hund.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich Zeit habe, werde ich dich besuchen.',
      'Wenn ich Zeit habe, werde ich dich besucht.',
      'Wenn ich Zeit habe, ich werde dich besuchen.',
      'Wenn ich Zeit habe, werde ich dich besuchte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Futur I steht \'werden\' + Infinitiv: werde ... besuchen. Im Hauptsatz nach Nebensatz steht das Verb auf Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er musste gestern lange arbeiten.',
      'Er gemusst gestern lange arbeiten.',
      'Er musste gestern lange gearbeitet.',
      'Er hat gestern lange arbeiten gemusst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Präteritum wird das Modalverb konjugiert: musste. Der Infinitiv \'arbeiten\' bleibt unverändert.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie schenkt ihrem Freund ein Buch.',
      'Sie schenkt ihren Freund ein Buch.',
      'Sie schenkt ihr Freund ein Buch.',
      'Sie schenkt ihrem Freund einen Buch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schenken\' verlangt Dativ (Person) + Akkusativ (Sache): ihrem Freund (Dativ) ein Buch (Akkusativ, Neutrum).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich weiß nicht, ob er morgen kommt.',
      'Ich weiß nicht, ob er morgen kommen.',
      'Ich weiß nicht, ob morgen er kommt.',
      'Ich weiß nicht, ob er kommt morgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'ob\' steht das Verb am Ende des Nebensatzes. Das Subjekt steht direkt nach \'ob\'.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er interessiert sich an Musik.',
      'Er interessiert sich über Musik.',
      'Er interessiert sich für Musik.',
      'Er interessiert sich von Musik.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Verb \'sich interessieren\' wird mit \'für\' + Akkusativ verwendet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich suche den Schlüssel der alten Wohnung.',
      'Ich suche den Schlüssel die alte Wohnung.',
      'Ich suche den Schlüssel der alter Wohnung.',
      'Ich suche den Schlüssel des alten Wohnung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv Femininum: der alten Wohnung. Der Schlüssel gehört der Wohnung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl es regnet, gehen wir spazieren.',
      'Obwohl es regnet, wir gehen spazieren.',
      'Obwohl regnet es, gehen wir spazieren.',
      'Obwohl es regnet, spazieren wir gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach einem Nebensatz mit \'obwohl\' beginnt der Hauptsatz mit dem Verb (Inversion). Im Nebensatz steht das Verb am Ende.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben mit dem netten Nachbar gesprochen.',
      'Wir haben mit dem netten Nachbarn gesprochen.',
      'Wir haben mit den netten Nachbar gesprochen.',
      'Wir haben mit der netten Nachbar gesprochen.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nachbar\' ist ein N-Deklination-Nomen. Im Dativ Singular: dem Nachbarn.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem ich gegessen hatte, ging ich spazieren.',
      'Nachdem ich gegessen habe, ging ich spazieren.',
      'Nachdem ich aß, ging ich spazieren.',
      'Nachdem ich esse, ging ich spazieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'nachdem\' steht Plusquamperfekt, wenn der Hauptsatz im Präteritum steht: hatte gegessen ... ging.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder sollen ihre Hausaufgaben machen.',
      'Die Kinder sollen ihre Hausaufgaben gemacht.',
      'Die Kinder sollen ihre Hausaufgaben zu machen.',
      'Die Kinder sollen ihre Hausaufgaben machten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb \'sollen\' + Infinitiv ohne \'zu\': sollen ... machen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Lehrer erklärt den Schülern die Aufgabe.',
      'Der Lehrer erklärt die Schüler die Aufgabe.',
      'Der Lehrer erklärt den Schülern der Aufgabe.',
      'Der Lehrer erklärt der Schülern die Aufgabe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Erklären\' verlangt Dativ (Person) + Akkusativ (Sache): den Schülern (Dativ Plural) die Aufgabe (Akkusativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie freut sich auf ihren Geburtstag.',
      'Sie freut sich für ihren Geburtstag.',
      'Sie freut sich an ihren Geburtstag.',
      'Sie freut sich zu ihren Geburtstag.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich freuen auf\' + Akkusativ bedeutet Vorfreude auf etwas in der Zukunft.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat mir gesagt, dass er nicht kommen kann.',
      'Er hat mir gesagt, dass er kann nicht kommen.',
      'Er hat mir gesagt, dass er nicht kann kommen.',
      'Er hat mir gesagt, dass nicht er kommen kann.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'dass\' stehen Modalverb und Infinitiv am Ende. Das Modalverb steht ganz am Schluss.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er trinkt gern einen schwarzen Kaffee.',
      'Er trinkt gern ein schwarzen Kaffee.',
      'Er trinkt gern einer schwarzen Kaffee.',
      'Er trinkt gern einem schwarzen Kaffee.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaffee\' ist maskulin. Im Akkusativ: einen schwarzen Kaffee.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich reich wäre, würde ich eine Weltreise machen.',
      'Wenn ich reich wäre, ich würde eine Weltreise machen.',
      'Wenn ich reich wäre, eine Weltreise ich würde machen.',
      'Wenn ich wäre reich, würde ich eine Weltreise machen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: Im Nebensatz mit \'wenn\' steht das Verb am Ende. Im Hauptsatz steht das Verb auf Position 1 (Inversion).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe einen interessanten Film gesehen.',
      'Ich habe ein interessanten Film gesehen.',
      'Ich habe einen interessanter Film gesehen.',
      'Ich habe einem interessanten Film gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Film\' ist maskulin. Akkusativ mit unbestimmtem Artikel: einen interessanten Film.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist gestern nach Berlin gefahren.',
      'Sie hat gestern nach Berlin gefahren.',
      'Sie ist gestern nach Berlin gefahrt.',
      'Sie hat gestern nach Berlin gefahrt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Fahren\' bildet das Perfekt mit \'sein\' (Ortswechsel): ist gefahren. Das Partizip II ist \'gefahren\'.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er versucht, das Problem zu lösen.',
      'Er versucht, das Problem lösen.',
      'Er versucht, das Problem zu gelöst.',
      'Er versucht, das Problem lösen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'versuchen\' steht ein Infinitivsatz mit \'zu\': versucht, ... zu lösen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz dem schlechten Wetter gehen wir wandern.',
      'Trotz des schlechten Wetters gehen wir wandern.',
      'Trotz das schlechte Wetter gehen wir wandern.',
      'Trotz den schlechten Wetter gehen wir wandern.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Trotz\' verlangt den Genitiv: trotz des schlechten Wetters.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich erinnere mich auf meinen ersten Schultag.',
      'Ich erinnere mich über meinen ersten Schultag.',
      'Ich erinnere mich an meinen ersten Schultag.',
      'Ich erinnere mich für meinen ersten Schultag.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Sich erinnern an\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Morgen muss ich früh aufstehen, weil ich einen Termin um acht habe.',
      'Morgen ich muss früh aufstehen, weil ich einen Termin um acht habe.',
      'Morgen muss ich früh aufstehen, weil ich habe einen Termin um acht.',
      'Morgen muss früh aufstehen ich, weil ich einen Termin um acht habe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Hauptsatz: Verb auf Position 2. Im Nebensatz mit \'weil\': Verb am Ende.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich brauche eine neue Brille.',
      'Ich brauche einen neuen Brille.',
      'Ich brauche ein neues Brille.',
      'Ich brauche einer neuen Brille.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Brille\' ist feminin (die Brille). Im Akkusativ: eine neue Brille.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er liest ein Buch, während seine Frau fernsieht.',
      'Er liest ein Buch, während seine Frau sieht fern.',
      'Er liest ein Buch, während fernsieht seine Frau.',
      'Er liest ein Buch, während seine Frau fern sieht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'während\' steht das trennbare Verb am Ende zusammengeschrieben: fernsieht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Meinung des junge Mannes ist wichtig.',
      'Die Meinung des jungen Mannes ist wichtig.',
      'Die Meinung den jungen Mannes ist wichtig.',
      'Die Meinung der jungen Mannes ist wichtig.'
    ],
    'correctAnswer': 1,
    'explanation': 'Genitiv Maskulinum: des jungen Mannes. Nach dem bestimmten Artikel im Genitiv endet das Adjektiv auf -en.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war schon eingeschlafen, als das Telefon klingelte.',
      'Er ist schon eingeschlafen, als das Telefon klingelte.',
      'Er hatte schon eingeschlafen, als das Telefon klingelte.',
      'Er war schon eingeschlafen, als das Telefon geklingelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt mit \'sein\' bei Zustandsänderung: war eingeschlafen. \'Als\' leitet einen einmaligen Zeitpunkt ein.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wird empfohlen, viel Wasser trinken.',
      'Es wird empfohlen, viel Wasser zu trinken.',
      'Es wird empfohlen, viel Wasser getrunken.',
      'Es wird empfohlen, viel Wasser trinkt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nach \'empfehlen\' folgt ein Infinitivsatz mit \'zu\': zu trinken.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während meines Urlaubs habe ich viel gelernt.',
      'Während meinem Urlaub habe ich viel gelernt.',
      'Während mein Urlaub habe ich viel gelernt.',
      'Während meinen Urlaub habe ich viel gelernt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Während\' als Präposition verlangt den Genitiv: während meines Urlaubs.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich bei seiner Chefin für die Hilfe bedankt.',
      'Er hat sich an seiner Chefin für die Hilfe bedankt.',
      'Er hat sich bei seiner Chefin über die Hilfe bedankt.',
      'Er hat sich mit seiner Chefin für die Hilfe bedankt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich bedanken bei\' + Dativ (Person) \'für\' + Akkusativ (Sache) ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur spricht er Deutsch, sondern auch Französisch.',
      'Er spricht nicht nur Deutsch, sondern auch Französisch.',
      'Er nicht nur spricht Deutsch, sondern auch Französisch.',
      'Er spricht Deutsch nicht nur, sondern Französisch auch.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nicht nur ... sondern auch\' verbindet zwei gleichwertige Teile. \'Nicht nur\' steht vor dem ersten Element.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat dem alten Frau über die Straße geholfen.',
      'Sie hat der alten Frau über die Straße geholfen.',
      'Sie hat die alte Frau über die Straße geholfen.',
      'Sie hat den alten Frau über die Straße geholfen.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Helfen\' verlangt den Dativ. \'Frau\' ist feminin: der alten Frau (Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bevor du gehst, vergiss deine Jacke nicht.',
      'Bevor du gehst, vergiss nicht deine Jacke.',
      'Bevor gehst du, vergiss deine Jacke nicht.',
      'Bevor du gehst, nicht vergiss deine Jacke.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'bevor\' steht das Verb am Ende. Im Hauptsatz (Imperativ) steht die Negation am Ende.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mit großer Freude habe ich deinen Brief gelesen.',
      'Mit große Freude habe ich deinen Brief gelesen.',
      'Mit großem Freude habe ich deinen Brief gelesen.',
      'Mit großen Freude habe ich deinen Brief gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Freude\' ist feminin. Nach \'mit\' (Dativ) ohne Artikel: großer Freude (starke Deklination).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bis nächste Woche werde ich das Projekt abgeschlossen haben.',
      'Bis nächste Woche werde ich das Projekt abschließen haben.',
      'Bis nächste Woche werde ich das Projekt abgeschlossen.',
      'Bis nächste Woche habe ich das Projekt abgeschlossen werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur II drückt eine abgeschlossene Handlung in der Zukunft aus: werde + Partizip II + haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er lässt sein Auto jede Woche waschen.',
      'Er lässt sein Auto jede Woche gewaschen.',
      'Er lässt sein Auto jede Woche zu waschen.',
      'Er lässt sein Auto jede Woche wäscht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Lassen\' + Infinitiv ohne \'zu\': lässt ... waschen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er folgt den Anweisungen seines Chefs.',
      'Er folgt die Anweisungen seines Chefs.',
      'Er folgt der Anweisungen seines Chefs.',
      'Er folgt dem Anweisungen seines Chefs.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Folgen\' verlangt den Dativ. Dativ Plural: den Anweisungen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich von ihrem Freund entschieden.',
      'Sie hat sich für einen neuen Job entschieden.',
      'Sie hat sich über einen neuen Job entschieden.',
      'Sie hat sich an einen neuen Job entschieden.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Sich entscheiden für\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat mich gefragt, wann der Zug abfährt.',
      'Sie hat mich gefragt, wann fährt der Zug ab.',
      'Sie hat mich gefragt, wann der Zug fährt ab.',
      'Sie hat mich gefragt, wann abfährt der Zug.'
    ],
    'correctAnswer': 0,
    'explanation': 'In einer indirekten Frage mit \'wann\' steht das Verb am Ende des Nebensatzes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben den ganzen Tag am Strand verbracht.',
      'Wir haben der ganze Tag am Strand verbracht.',
      'Wir haben das ganze Tag am Strand verbracht.',
      'Wir haben die ganze Tag am Strand verbracht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Tag\' ist maskulin (der Tag). Im Akkusativ: den ganzen Tag.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je mehr ich lerne, desto besser verstehe ich die Grammatik.',
      'Je mehr ich lerne, desto ich besser die Grammatik verstehe.',
      'Je ich mehr lerne, desto besser verstehe ich die Grammatik.',
      'Je mehr lerne ich, desto besser verstehe ich die Grammatik.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Je ... desto\': Im \'je\'-Satz steht das Verb am Ende, im \'desto\'-Satz auf Position 2 (nach dem Komparativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihrem kranken Vater Suppe gekocht.',
      'Sie hat ihren kranken Vater Suppe gekocht.',
      'Sie hat ihr kranken Vater Suppe gekocht.',
      'Sie hat ihrem kranker Vater Suppe gekocht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kochen\' mit Dativ (Person): ihrem kranken Vater. Nach Possessivpronomen im Dativ endet das Adjektiv auf -en.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Als ich Kind war, spielte ich oft im Wald.',
      'Als ich Kind war, habe ich oft im Wald gespielt.',
      'Wenn ich Kind war, spielte ich oft im Wald.',
      'Als ich Kind bin, spielte ich oft im Wald.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als\' wird für einmalige oder abgeschlossene Zeiträume in der Vergangenheit verwendet. Präteritum passt hier am besten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Fenster wurde vom Sturm zerbrochen.',
      'Das Fenster wurde vom Sturm zerbrechen.',
      'Das Fenster wird vom Sturm zerbrochen.',
      'Das Fenster wurde vom Sturm gezerbrochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Präteritum: wurde + Partizip II. Partizip II von \'zerbrechen\' ist \'zerbrochen\' (ohne ge- bei untrennbarem Präfix).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p1-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe mich bei ihm für den Fehler entschuldigt.',
      'Ich habe mich an ihm für den Fehler entschuldigt.',
      'Ich habe mich über ihm für den Fehler entschuldigt.',
      'Ich habe mich auf ihm für den Fehler entschuldigt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich entschuldigen bei\' + Dativ (Person) \'für\' + Akkusativ (Sache) ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
