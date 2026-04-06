import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Perfekt: haben + Partizip II',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe ein Buch gestern gelest.',
      'Ich habe gestern ein Buch gelesen.',
      'Ich gestern habe ein Buch gelesen.',
      'Ich habe gestern ein Buch gelest.'
    ],
    'correctAnswer': 1,
    'explanation': 'Partizip II von \'lesen\' ist \'gelesen\', Verb auf Position 2.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie empfiehlt ihrem Bruder das Restaurant.',
      'Sie empfiehlt ihren Bruder das Restaurant.',
      'Sie empfiehlt ihr Bruder das Restaurant.',
      'Sie empfiehlt ihrem Bruder den Restaurant.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Empfehlen\' + Dativ (Person) + Akkusativ (Sache): ihrem Bruder (Dativ) das Restaurant (Akkusativ Neutrum).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl sie müde war, ging sie noch joggen.',
      'Obwohl sie müde war, sie ging noch joggen.',
      'Obwohl war sie müde, ging sie noch joggen.',
      'Obwohl sie war müde, ging sie noch joggen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'obwohl\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Kind spielt mit einem bunten Luftballon.',
      'Das Kind spielt mit einen bunten Luftballon.',
      'Das Kind spielt mit einem bunter Luftballon.',
      'Das Kind spielt mit ein buntes Luftballon.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Luftballon\' ist maskulin. \'Mit\' + Dativ: einem bunten Luftballon.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er leidet an einer schweren Krankheit.',
      'Er leidet unter einer schweren Krankheit.',
      'Er leidet von einer schweren Krankheit.',
      'Er leidet über eine schwere Krankheit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Leiden an\' + Dativ wird bei konkreten Krankheiten verwendet: an einer schweren Krankheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Als wir ankamen, hatte das Konzert schon begonnen.',
      'Als wir ankamen, das Konzert hatte schon begonnen.',
      'Als ankamen wir, hatte das Konzert schon begonnen.',
      'Als wir ankamen, hatte das Konzert schon beginnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als\' für einmalige Vergangenheit. Verb am Ende im Nebensatz. Plusquamperfekt im Hauptsatz für Vorzeitigkeit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist die Meinung vieler junger Menschen.',
      'Das ist die Meinung vieler jungen Menschen.',
      'Das ist die Meinung vielen jungen Menschen.',
      'Das ist die Meinung viele junger Menschen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv Plural nach \'vieler\' (starke Deklination): vieler junger Menschen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wird sicherlich bald ankommen.',
      'Er wird sicherlich bald angekommen.',
      'Er wird sicherlich bald ankommt.',
      'Er wurde sicherlich bald ankommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: wird + Infinitiv (ankommen). Für Zukunft oder Vermutung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Vertrag unterschrieben.',
      'Er hat den Vertrag unterschreiben.',
      'Er hat den Vertrag geunterschrieben.',
      'Er hat den Vertrag unterschrieb.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II von \'unterschreiben\' ist \'unterschrieben\'. Kein ge- bei untrennbarem Präfix unter-.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ähnelt seinem Vater sehr.',
      'Er ähnelt seinen Vater sehr.',
      'Er ähnelt sein Vater sehr.',
      'Er ähnelt seines Vaters sehr.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Ähneln\' verlangt den Dativ: seinem Vater.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bisher hat er noch keine Antwort bekommen.',
      'Bisher er hat noch keine Antwort bekommen.',
      'Bisher hat noch keine Antwort er bekommen.',
      'Bisher bekommen hat er noch keine Antwort.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'bisher\' am Satzanfang: Verb auf Position 2 mit Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat eine lange, schwierige Reise hinter sich.',
      'Er hat einen langen, schwierigen Reise hinter sich.',
      'Er hat ein langes, schwieriges Reise hinter sich.',
      'Er hat einer langen, schwierigen Reise hinter sich.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Reise\' ist feminin. Akkusativ: eine lange, schwierige Reise.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie beschwert sich bei dem Chef über die Arbeitsbedingungen.',
      'Sie beschwert sich an dem Chef über die Arbeitsbedingungen.',
      'Sie beschwert sich bei dem Chef für die Arbeitsbedingungen.',
      'Sie beschwert sich mit dem Chef über die Arbeitsbedingungen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich beschweren bei\' + Dativ (Person) \'über\' + Akkusativ (Sache).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich lese gern, während mein Mann fernsieht.',
      'Ich lese gern, während mein Mann sieht fern.',
      'Ich lese gern, während fernsieht mein Mann.',
      'Ich lese gern, während mein Mann fern sieht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'während\' steht das trennbare Verb am Ende zusammengeschrieben: fernsieht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz aller Schwierigkeiten hat er es geschafft.',
      'Trotz alle Schwierigkeiten hat er es geschafft.',
      'Trotz allen Schwierigkeiten hat er es geschafft.',
      'Trotz aller Schwierigkeit hat er es geschafft.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Trotz\' + Genitiv Plural: trotz aller Schwierigkeiten. \'Aller\' ist Genitiv Plural.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Immer wenn es regnete, blieb er zu Hause.',
      'Immer als es regnete, blieb er zu Hause.',
      'Immer wenn es regnet, blieb er zu Hause.',
      'Immer wenn es regnete, bleibt er zu Hause.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Immer wenn\' für wiederholte Handlungen in der Vergangenheit (nicht \'als\'). Beide Teile im Präteritum.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat mich gebeten, ihm bei der Arbeit zu helfen.',
      'Er hat mich gebeten, ihm bei der Arbeit helfen.',
      'Er hat mich gebeten, ihm bei der Arbeit zu geholfen.',
      'Er hat mich gebeten, ihm bei der Arbeit helfen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'bitten\' folgt ein Infinitivsatz mit \'zu\': zu helfen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Ergebnis entspricht meinen Erwartungen.',
      'Das Ergebnis entspricht meine Erwartungen.',
      'Das Ergebnis entspricht meiner Erwartungen.',
      'Das Ergebnis entspricht meines Erwartungen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Entsprechen\' verlangt den Dativ: meinen Erwartungen (Dativ Plural).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich bei seinem Chef über das Gehalt beschwert.',
      'Er hat sich an seinem Chef über das Gehalt beschwert.',
      'Er hat sich bei seinem Chef für das Gehalt beschwert.',
      'Er hat sich auf seinem Chef über das Gehalt beschwert.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich beschweren bei\' + Dativ (Person) \'über\' + Akkusativ (Sache).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Meiner Meinung nach sollte man mehr Sport treiben.',
      'Meiner Meinung nach man sollte mehr Sport treiben.',
      'Meiner Meinung nach sollte mehr Sport man treiben.',
      'Meiner Meinung nach treiben sollte man mehr Sport.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der Angabe am Satzanfang: Verb auf Position 2 mit Inversion: sollte man.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er bewirbt sich um eine freie Stelle.',
      'Er bewirbt sich um einen freien Stelle.',
      'Er bewirbt sich um ein freies Stelle.',
      'Er bewirbt sich um einer freier Stelle.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Stelle\' ist feminin. \'Um\' + Akkusativ: eine freie Stelle.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seit sie hier arbeitet, hat sich vieles verbessert.',
      'Seit sie hier arbeitet, vieles hat sich verbessert.',
      'Seit arbeitet sie hier, hat sich vieles verbessert.',
      'Seit sie hier arbeitet, sich hat vieles verbessert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'seit\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dunkles Bier schmeckt ihm am besten.',
      'Dunkler Bier schmeckt ihm am besten.',
      'Dunklem Bier schmeckt ihm am besten.',
      'Dunklen Bier schmeckt ihm am besten.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bier\' ist Neutrum. Nominativ ohne Artikel (starke Deklination): dunkles Bier.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem sie den Brief gelesen hatte, weinte sie.',
      'Nachdem sie den Brief gelesen hat, weinte sie.',
      'Nachdem sie den Brief las, weinte sie.',
      'Nachdem sie den Brief gelesen hatte, sie weinte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'nachdem\' steht Plusquamperfekt (hatte gelesen), im Hauptsatz Präteritum (weinte).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat versucht, das Schloss aufzubrechen.',
      'Er hat versucht, das Schloss zu aufbrechen.',
      'Er hat versucht, das Schloss aufbrechen.',
      'Er hat versucht, das Schloss aufgebrochen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: aufzubrechen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schmeichelt seiner Kollegin.',
      'Er schmeichelt seine Kollegin.',
      'Er schmeichelt seiner Kollegin zu.',
      'Er schmeichelt seines Kollegin.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schmeicheln\' verlangt den Dativ: seiner Kollegin (feminin Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie erkundigt sich nach dem Preis.',
      'Sie erkundigt sich über den Preis.',
      'Sie erkundigt sich für den Preis.',
      'Sie erkundigt sich auf den Preis.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich erkundigen nach\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anschließend besuchten wir die Ausstellung.',
      'Anschließend wir besuchten die Ausstellung.',
      'Anschließend besuchten die Ausstellung wir.',
      'Anschließend die Ausstellung besuchten wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'anschließend\' am Satzanfang: Verb auf Position 2 mit Inversion: besuchten wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Stadt, in der ich aufgewachsen bin, ist sehr schön.',
      'Die Stadt, in die ich aufgewachsen bin, ist sehr schön.',
      'Die Stadt, in dem ich aufgewachsen bin, ist sehr schön.',
      'Die Stadt, in den ich aufgewachsen bin, ist sehr schön.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen mit Präposition \'in\' + Dativ (Wo?). \'Stadt\' ist feminin: in der.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bevor er abreiste, verabschiedete er sich von allen.',
      'Bevor er abreiste, er verabschiedete sich von allen.',
      'Bevor abreiste er, verabschiedete er sich von allen.',
      'Bevor er abreiste, von allen verabschiedete er sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'bevor\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ein paar wichtige Termine abgesagt.',
      'Sie hat ein paar wichtigen Termine abgesagt.',
      'Sie hat ein paar wichtiger Termine abgesagt.',
      'Sie hat ein paar wichtigem Termine abgesagt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'ein paar\' im Akkusativ Plural: starke Deklination: wichtige Termine.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'An deiner Stelle würde ich den Arzt aufsuchen.',
      'An deiner Stelle werde ich den Arzt aufsuchen.',
      'An deiner Stelle wurde ich den Arzt aufsuchen.',
      'An deiner Stelle würde ich den Arzt aufgesucht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II für höfliche Ratschläge: würde + Infinitiv (aufsuchen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Gebäude soll nächstes Jahr renoviert werden.',
      'Das Gebäude soll nächstes Jahr renoviert wird.',
      'Das Gebäude soll nächstes Jahr renovieren werden.',
      'Das Gebäude soll nächstes Jahr werden renoviert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv mit Modalverb: soll + Partizip II + werden (Infinitiv am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachricht hat allen Mitarbeitern Sorgen bereitet.',
      'Die Nachricht hat alle Mitarbeiter Sorgen bereitet.',
      'Die Nachricht hat aller Mitarbeiter Sorgen bereitet.',
      'Die Nachricht hat allen Mitarbeiter Sorgen bereitet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bereiten\' + Dativ (Person): allen Mitarbeitern (Dativ Plural).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin gespannt auf das Ergebnis.',
      'Ich bin gespannt über das Ergebnis.',
      'Ich bin gespannt für das Ergebnis.',
      'Ich bin gespannt an das Ergebnis.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gespannt auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst nachdem alle gegangen waren, räumte er auf.',
      'Erst nachdem alle gegangen waren, er räumte auf.',
      'Erst nachdem waren alle gegangen, räumte er auf.',
      'Erst nachdem alle gegangen waren, auf räumte er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz steht das Hilfsverb am Ende: gegangen waren. Im Hauptsatz folgt Inversion: räumte er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat seinem besten Freund ein Geheimnis anvertraut.',
      'Er hat seinen besten Freund ein Geheimnis anvertraut.',
      'Er hat seinem bester Freund ein Geheimnis anvertraut.',
      'Er hat seinem besten Freund einen Geheimnis anvertraut.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Anvertrauen\' + Dativ (Person): seinem besten Freund. + Akkusativ (Sache): ein Geheimnis (Neutrum).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe ihn gefragt, ob er mitkommen möchte.',
      'Ich habe ihn gefragt, ob er möchte mitkommen.',
      'Ich habe ihn gefragt, ob mitkommen er möchte.',
      'Ich habe ihn gefragt, ob er mitkommen möchten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'ob\' steht das Modalverb am Ende: ob er mitkommen möchte.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nach langem Überlegen hat er sich entschieden.',
      'Nach langer Überlegen hat er sich entschieden.',
      'Nach langes Überlegen hat er sich entschieden.',
      'Nach langen Überlegen hat er sich entschieden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Überlegen\' als Nomen ist Neutrum. \'Nach\' + Dativ ohne Artikel (starke Deklination): langem Überlegen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie sagte, sie werde morgen kommen.',
      'Sie sagte, sie wird morgen kommen.',
      'Sie sagte, sie werden morgen kommen.',
      'Sie sagte, sie werde morgen gekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede im Konjunktiv I Futur: werde + Infinitiv (kommen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Brief ist noch nicht zugestellt worden.',
      'Der Brief ist noch nicht zugestellt geworden.',
      'Der Brief hat noch nicht zugestellt worden.',
      'Der Brief ist noch nicht zugestellt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Perfekt: ist + Partizip II + worden (nicht \'geworden\').',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es seinen Eltern verschwiegen.',
      'Er hat es seine Eltern verschwiegen.',
      'Er hat es seiner Eltern verschwiegen.',
      'Er hat es sein Eltern verschwiegen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Verschweigen\' + Dativ (Person): seinen Eltern (Dativ Plural).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin neidisch auf seinen Erfolg.',
      'Ich bin neidisch über seinen Erfolg.',
      'Ich bin neidisch für seinen Erfolg.',
      'Ich bin neidisch an seinem Erfolg.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Neidisch auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Glücklicherweise ist niemandem etwas passiert.',
      'Glücklicherweise niemandem ist etwas passiert.',
      'Glücklicherweise ist etwas niemandem passiert.',
      'Glücklicherweise passiert ist niemandem etwas.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'glücklicherweise\' am Satzanfang: Verb auf Position 2: ist niemandem.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat den ganzen Nachmittag im Garten verbracht.',
      'Sie hat der ganze Nachmittag im Garten verbracht.',
      'Sie hat das ganze Nachmittag im Garten verbracht.',
      'Sie hat die ganze Nachmittag im Garten verbracht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Nachmittag\' ist maskulin. Akkusativ der Zeit: den ganzen Nachmittag.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Statt zu arbeiten, hat er den ganzen Tag geschlafen.',
      'Statt arbeiten, hat er den ganzen Tag geschlafen.',
      'Statt zu gearbeitet, hat er den ganzen Tag geschlafen.',
      'Statt er arbeitet, hat er den ganzen Tag geschlafen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Statt ... zu\' + Infinitiv: statt zu arbeiten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist ein Mann mit starkem Charakter.',
      'Er ist ein Mann mit starken Charakter.',
      'Er ist ein Mann mit starker Charakter.',
      'Er ist ein Mann mit starkes Charakter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Charakter\' ist maskulin. \'Mit\' + Dativ ohne Artikel (starke Deklination): starkem Charakter.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wäre ich früher aufgestanden, hätte ich den Zug nicht verpasst.',
      'Bin ich früher aufgestanden, hätte ich den Zug nicht verpasst.',
      'Wäre ich früher aufgestanden, habe ich den Zug nicht verpasst.',
      'War ich früher aufgestanden, hätte ich den Zug nicht verpasst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Plusquamperfekt für irreale Vergangenheit: wäre aufgestanden + hätte verpasst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihn davon überzeugt, den Kurs zu besuchen.',
      'Sie hat ihn davon überzeugt, den Kurs besuchen.',
      'Sie hat ihn davon überzeugt, den Kurs zu besucht.',
      'Sie hat ihn davon überzeugt, den Kurs besuchen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'überzeugen\' folgt ein Infinitivsatz mit \'zu\': zu besuchen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p7-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er konzentriert sich auf seine Aufgabe.',
      'Er konzentriert sich an seine Aufgabe.',
      'Er konzentriert sich über seine Aufgabe.',
      'Er konzentriert sich für seine Aufgabe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich konzentrieren auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
