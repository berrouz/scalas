import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Rechnung muss bis morgen bezahlt werden.',
      'Die Rechnung muss bis morgen bezahlt wird.',
      'Die Rechnung muss bis morgen bezahlen werden.',
      'Die Rechnung muss bis morgen werden bezahlt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv mit Modalverb: muss + Partizip II + werden (Infinitiv am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir gedenken der Opfer des Krieges.',
      'Wir gedenken die Opfer des Krieges.',
      'Wir gedenken den Opfern des Krieges.',
      'Wir gedenken dem Opfer des Krieges.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gedenken\' verlangt den Genitiv: der Opfer (Plural Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kaum hatte er das Haus verlassen, fing es an zu regnen.',
      'Kaum er hatte das Haus verlassen, fing es an zu regnen.',
      'Kaum hatte er das Haus verlassen, es fing an zu regnen.',
      'Kaum das Haus verlassen er hatte, fing es an zu regnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaum\' + Inversion im ersten Satz. Im zweiten Satz steht das Verb auf Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat seiner Mutter zum Geburtstag eine Kette geschenkt.',
      'Er hat seine Mutter zum Geburtstag eine Kette geschenkt.',
      'Er hat seinem Mutter zum Geburtstag eine Kette geschenkt.',
      'Er hat seiner Mutter zum Geburtstag einen Kette geschenkt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schenken\' + Dativ (Person): seiner Mutter (feminin Dativ). + Akkusativ (Sache): eine Kette.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er besteht auf seinem Recht.',
      'Er besteht für sein Recht.',
      'Er besteht über sein Recht.',
      'Er besteht an seinem Recht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bestehen auf\' + Dativ ist die korrekte Verbindung: auf seinem Recht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ehe du gehst, räum bitte dein Zimmer auf.',
      'Ehe du gehst, bitte räum auf dein Zimmer.',
      'Ehe gehst du, räum bitte dein Zimmer auf.',
      'Ehe du gehst, dein Zimmer räum bitte auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'ehe\' steht das Verb am Ende: ehe du gehst. Im Imperativsatz: Verb zuerst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Verhalten des kleinen Kindes war vorbildlich.',
      'Das Verhalten des kleiner Kindes war vorbildlich.',
      'Das Verhalten dem kleinen Kind war vorbildlich.',
      'Das Verhalten der kleinen Kindes war vorbildlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv Neutrum: des kleinen Kindes. Nach bestimmtem Artikel im Genitiv: -en.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sobald ich angekommen bin, rufe ich dich an.',
      'Sobald ich ankomme, habe ich dich angerufen.',
      'Sobald ich ankomme bin, rufe ich dich an.',
      'Sobald ich angekommen bin, rief ich dich an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'sobald\' kann Perfekt stehen für Vorzeitigkeit gegenüber Präsens im Hauptsatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er pflegte jeden Morgen spazieren zu gehen.',
      'Er pflegte jeden Morgen spazieren gehen.',
      'Er pflegte jeden Morgen zu spazieren gehen.',
      'Er pflegte jeden Morgen spazieren gegangen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Pflegen\' + zu + Infinitiv für Gewohnheiten: pflegte ... spazieren zu gehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aufgrund des hohen Preises kaufte er das Auto nicht.',
      'Aufgrund dem hohen Preis kaufte er das Auto nicht.',
      'Aufgrund den hohen Preis kaufte er das Auto nicht.',
      'Aufgrund der hohe Preis kaufte er das Auto nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Aufgrund\' verlangt den Genitiv: aufgrund des hohen Preises (maskulin Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er fragte, ob sie morgen kommen könne.',
      'Er fragte, ob sie morgen könne kommen.',
      'Er fragte, ob morgen sie kommen könne.',
      'Er fragte, ob sie kommen morgen könne.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'ob\' steht das konjugierte Verb am Ende: kommen könne.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Mann, dem ich begegnet bin, war sehr freundlich.',
      'Der Mann, den ich begegnet bin, war sehr freundlich.',
      'Der Mann, der ich begegnet bin, war sehr freundlich.',
      'Der Mann, dessen ich begegnet bin, war sehr freundlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Dativ maskulin: dem. \'Begegnen\' verlangt den Dativ.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat an dem Wettbewerb teilgenommen.',
      'Sie hat für den Wettbewerb teilgenommen.',
      'Sie hat über dem Wettbewerb teilgenommen.',
      'Sie hat auf den Wettbewerb teilgenommen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Teilnehmen an\' + Dativ ist die korrekte Verbindung: an dem Wettbewerb.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sofern alles nach Plan läuft, sind wir pünktlich fertig.',
      'Sofern alles nach Plan läuft, wir sind pünktlich fertig.',
      'Sofern alles läuft nach Plan, sind wir pünktlich fertig.',
      'Sofern nach Plan alles läuft, pünktlich sind wir fertig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'sofern\' steht das Verb am Ende: sofern alles ... läuft. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wegen starken Windes wurde das Spiel abgesagt.',
      'Wegen starkem Wind wurde das Spiel abgesagt.',
      'Wegen starker Wind wurde das Spiel abgesagt.',
      'Wegen starke Winde wurde das Spiel abgesagt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wegen\' + Genitiv. Maskulin Genitiv ohne Artikel (starke Deklination): starken Windes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich Zeit gehabt hätte, wäre ich mitgekommen.',
      'Wenn ich Zeit gehabt hätte, bin ich mitgekommen.',
      'Wenn ich Zeit gehabt hätte, ich wäre mitgekommen.',
      'Wenn ich Zeit gehabt habe, wäre ich mitgekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Plusquamperfekt: hätte gehabt + wäre mitgekommen. Für irreale Vergangenheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Paket ist gestern geliefert worden.',
      'Das Paket ist gestern geliefert geworden.',
      'Das Paket hat gestern geliefert worden.',
      'Das Paket ist gestern geliefert werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Perfekt: ist + Partizip II + worden (nicht \'geworden\' im Passiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder laufen ihrem Vater entgegen.',
      'Die Kinder laufen ihren Vater entgegen.',
      'Die Kinder laufen ihr Vater entgegen.',
      'Die Kinder laufen ihres Vaters entgegen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Entgegenlaufen\' verlangt den Dativ: ihrem Vater.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin mit dem Ergebnis zufrieden.',
      'Ich bin über das Ergebnis zufrieden.',
      'Ich bin für das Ergebnis zufrieden.',
      'Ich bin an dem Ergebnis zufrieden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Zufrieden mit\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter keinen Umständen dürfen Sie das Gebäude betreten.',
      'Unter keinen Umständen Sie dürfen das Gebäude betreten.',
      'Unter keinen Umständen dürfen das Gebäude Sie betreten.',
      'Unter keinen Umständen das Gebäude betreten dürfen Sie.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der Angabe am Satzanfang steht das Verb auf Position 2 mit Inversion: dürfen Sie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wohnt in einer schönen kleinen Wohnung.',
      'Sie wohnt in einer schöner kleiner Wohnung.',
      'Sie wohnt in eine schöne kleine Wohnung.',
      'Sie wohnt in einem schönen kleinen Wohnung.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wohnung\' ist feminin. \'In\' + Dativ (Wo?): in einer schönen kleinen Wohnung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur hat er sein Studium abgeschlossen, sondern auch eine Stelle gefunden.',
      'Er hat nicht nur sein Studium abgeschlossen, sondern auch eine Stelle gefunden.',
      'Er hat sein Studium nicht nur abgeschlossen, sondern eine Stelle auch gefunden.',
      'Nicht nur er hat sein Studium abgeschlossen, sondern auch eine Stelle gefunden.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nicht nur ... sondern auch\': \'Nicht nur\' steht vor dem ersten Element, \'sondern auch\' vor dem zweiten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bei schlechtem Wetter bleiben wir drinnen.',
      'Bei schlechter Wetter bleiben wir drinnen.',
      'Bei schlechtes Wetter bleiben wir drinnen.',
      'Bei schlechten Wetter bleiben wir drinnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wetter\' ist Neutrum. \'Bei\' + Dativ ohne Artikel (starke Deklination): bei schlechtem Wetter.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bis dahin werde ich alles erledigt haben.',
      'Bis dahin werde ich alles erledigt.',
      'Bis dahin werde ich alles erledigen haben.',
      'Bis dahin habe ich alles erledigt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur II: werde + Partizip II + haben: werde erledigt haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat die Kinder ins Bett gebracht.',
      'Sie hat die Kinder ins Bett bringen.',
      'Sie hat die Kinder ins Bett gebringt.',
      'Sie hat die Kinder ins Bett gebrungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II von \'bringen\' ist \'gebracht\' (unregelmäßiges Verb).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er zieht sich den Mantel an.',
      'Er zieht sich der Mantel an.',
      'Er zieht sich dem Mantel an.',
      'Er zieht sich des Mantels an.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Anziehen\' + Akkusativ (Kleidungsstück): den Mantel. Reflexivpronomen im Dativ: sich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie sehnt sich nach ihrer Heimat.',
      'Sie sehnt sich für ihre Heimat.',
      'Sie sehnt sich über ihre Heimat.',
      'Sie sehnt sich auf ihre Heimat.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich sehnen nach\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vermutlich hat er die Nachricht nicht gelesen.',
      'Vermutlich er hat die Nachricht nicht gelesen.',
      'Vermutlich hat die Nachricht er nicht gelesen.',
      'Vermutlich nicht gelesen hat er die Nachricht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'vermutlich\' am Satzanfang: Verb auf Position 2 mit Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Student, dessen Arbeit ausgezeichnet wurde, ist sehr talentiert.',
      'Der Student, deren Arbeit ausgezeichnet wurde, ist sehr talentiert.',
      'Der Student, dem Arbeit ausgezeichnet wurde, ist sehr talentiert.',
      'Der Student, der Arbeit ausgezeichnet wurde, ist sehr talentiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv maskulin: dessen. Es bezieht sich auf \'der Student\'.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zumal er keine Erfahrung hat, sollte er vorsichtig sein.',
      'Zumal er keine Erfahrung hat, er sollte vorsichtig sein.',
      'Zumal er hat keine Erfahrung, sollte er vorsichtig sein.',
      'Zumal keine Erfahrung er hat, sollte er vorsichtig sein.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'zumal\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf dem hohen Berg lag noch Schnee.',
      'Auf dem hoher Berg lag noch Schnee.',
      'Auf den hohen Berg lag noch Schnee.',
      'Auf der hohen Berg lag noch Schnee.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Auf\' + Dativ (Wo?). Maskulin Dativ: dem hohen Berg.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er meinte, er habe das Problem bereits gelöst.',
      'Er meinte, er hat das Problem bereits gelöst.',
      'Er meinte, er hatte das Problem bereits gelöst.',
      'Er meinte, er haben das Problem bereits gelöst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede im Konjunktiv I Perfekt: habe ... gelöst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie braucht das nicht zu wissen.',
      'Sie braucht das nicht wissen.',
      'Sie braucht das nicht zu gewusst.',
      'Sie braucht das nicht wissen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Brauchen\' + \'nicht zu\' + Infinitiv: braucht nicht zu wissen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wohnt gegenüber dem Rathaus.',
      'Er wohnt gegenüber das Rathaus.',
      'Er wohnt gegenüber den Rathaus.',
      'Er wohnt gegenüber des Rathauses.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Gegenüber\' verlangt den Dativ: gegenüber dem Rathaus (Neutrum Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er warnt seine Kinder vor der Gefahr.',
      'Er warnt seine Kinder über die Gefahr.',
      'Er warnt seine Kinder für die Gefahr.',
      'Er warnt seine Kinder an der Gefahr.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Warnen vor\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zum Glück hat niemand etwas bemerkt.',
      'Zum Glück niemand hat etwas bemerkt.',
      'Zum Glück hat etwas niemand bemerkt.',
      'Zum Glück bemerkt hat niemand etwas.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der Angabe am Satzanfang: Verb auf Position 2, dann Subjekt: hat niemand.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich an den neuen Arbeitsplatz gewöhnt.',
      'Sie hat sich an dem neuen Arbeitsplatz gewöhnt.',
      'Sie hat sich an der neue Arbeitsplatz gewöhnt.',
      'Sie hat sich an das neue Arbeitsplatz gewöhnt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich gewöhnen an\' + Akkusativ. \'Arbeitsplatz\' ist maskulin: den neuen Arbeitsplatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weder hat er mich angerufen noch mir geschrieben.',
      'Weder er hat mich angerufen noch mir geschrieben.',
      'Weder hat er mich angerufen oder mir geschrieben.',
      'Weder hat er angerufen mich noch geschrieben mir.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Weder ... noch\': Nach \'weder\' kann Inversion stehen. \'Noch\' verbindet das zweite Element.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sämtliche anwesenden Gäste waren begeistert.',
      'Sämtliche anwesende Gäste waren begeistert.',
      'Sämtlicher anwesenden Gäste waren begeistert.',
      'Sämtlichen anwesenden Gäste waren begeistert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'sämtliche\' im Nominativ Plural folgt schwache Deklination: sämtliche anwesenden Gäste.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich werde dich vermissen, wenn du weggehst.',
      'Ich werde dich vermissen, wenn du weggehen.',
      'Ich werde dich vermisst, wenn du weggehst.',
      'Ich wurde dich vermissen, wenn du weggehst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: werde + Infinitiv (vermissen). Im Nebensatz Präsens: wenn du weggehst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Bild an die Wand gehängt.',
      'Er hat das Bild an die Wand gehangen.',
      'Er hat das Bild an die Wand gehangt.',
      'Er hat das Bild an die Wand hängen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Hängen\' (transitiv, schwach): hat gehängt. \'Hängen\' (intransitiv, stark): hat gehangen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entlang des Flusses gibt es schöne Spazierwege.',
      'Entlang dem Fluss gibt es schöne Spazierwege.',
      'Entlang den Fluss gibt es schöne Spazierwege.',
      'Entlang der Fluss gibt es schöne Spazierwege.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Entlang\' + Genitiv (vorangestellt): entlang des Flusses.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schämt sich für sein Verhalten.',
      'Er schämt sich über sein Verhalten.',
      'Er schämt sich an sein Verhalten.',
      'Er schämt sich von seinem Verhalten.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich schämen für\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hoffentlich wird alles gut ausgehen.',
      'Hoffentlich alles wird gut ausgehen.',
      'Hoffentlich wird gut alles ausgehen.',
      'Hoffentlich ausgehen wird alles gut.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'hoffentlich\' am Satzanfang: Verb auf Position 2: wird alles.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder, denen er geholfen hat, sind dankbar.',
      'Die Kinder, die er geholfen hat, sind dankbar.',
      'Die Kinder, den er geholfen hat, sind dankbar.',
      'Die Kinder, deren er geholfen hat, sind dankbar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Dativ Plural: denen. \'Helfen\' verlangt den Dativ.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Soweit ich weiß, findet die Sitzung um drei Uhr statt.',
      'Soweit ich weiß, die Sitzung findet um drei Uhr statt.',
      'Soweit weiß ich, findet die Sitzung um drei Uhr statt.',
      'Soweit ich weiß, statt findet die Sitzung um drei Uhr.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'soweit\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist ein Mensch mit gutem Herzen.',
      'Er ist ein Mensch mit gutes Herzen.',
      'Er ist ein Mensch mit guter Herzen.',
      'Er ist ein Mensch mit guten Herzen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Herz\' ist Neutrum. \'Mit\' + Dativ ohne Artikel (starke Deklination): gutem Herzen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie behauptete, sie habe nichts davon gewusst.',
      'Sie behauptete, sie hat nichts davon gewusst.',
      'Sie behauptete, sie weiß nichts davon.',
      'Sie behauptete, sie haben nichts davon gewusst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Perfekt: habe gewusst.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p6-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe ihn kommen sehen.',
      'Ich habe ihn kommen gesehen.',
      'Ich habe ihn gekommen sehen.',
      'Ich habe ihn zu kommen sehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Wahrnehmungsverben (sehen, hören) steht der Ersatzinfinitiv: habe ... kommen sehen.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
