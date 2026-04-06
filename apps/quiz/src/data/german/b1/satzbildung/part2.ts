import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-001',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat dem Kind ein Eis gekauft.',
      'Sie hat das Kind ein Eis gekauft.',
      'Sie hat den Kind ein Eis gekauft.',
      'Sie hat dem Kind einen Eis gekauft.'
    ],
    'correctAnswer': 0,
    'explanation': '\'kaufen\' verlangt Dativ (dem Kind) + Akkusativ (ein Eis). \'Eis\' ist Neutrum.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-002',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe keine Ahnung, was soll ich machen.',
      'Ich habe keine Ahnung, was ich machen soll.',
      'Ich habe keine Ahnung, was machen ich soll.',
      'Ich habe keine Ahnung, was soll machen ich.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im indirekten Fragesatz steht das konjugierte Verb (soll) am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-003',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er legt das Buch auf dem Tisch.',
      'Er legt das Buch auf den Tisch.',
      'Er legt das Buch auf der Tisch.',
      'Er legt das Buch auf des Tisches.'
    ],
    'correctAnswer': 1,
    'explanation': '\'legen\' = Richtung (wohin?) -> Akkusativ: auf den Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-004',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe ihn gefragt, aber er hat nicht geantwortet.',
      'Ich habe ihn gefragt, aber er hat nicht antworten.',
      'Ich habe ihn gefragt, aber er nicht hat geantwortet.',
      'Ich habe ihn gefragt, aber nicht er hat geantwortet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Hauptsatz mit \'aber\' bleibt die normale Wortstellung. Partizip II am Ende.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-005',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Katze sitzt unter dem Tisch.',
      'Die Katze sitzt unter den Tisch.',
      'Die Katze sitzt unter der Tisch.',
      'Die Katze sitzt unter des Tisches.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sitzen\' = Ort (wo?) -> Dativ: unter dem Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-006',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er arbeitet hart, damit er kann sich ein Auto leisten.',
      'Er arbeitet hart, damit er sich ein Auto leisten kann.',
      'Er arbeitet hart, damit kann er sich ein Auto leisten.',
      'Er arbeitet hart, damit er sich ein Auto kann leisten.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz mit \'damit\' steht das konjugierte Verb (kann) am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-007',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er geht zum Bäcker Brot kaufen.',
      'Er geht zum Bäcker Brot zu kaufen.',
      'Er geht zum Bäcker um Brot kaufen.',
      'Er geht zu dem Bäcker für Brot kaufen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Verben der Bewegung kann der Infinitiv ohne \'zu\' stehen: Brot kaufen.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-008',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich bin nach Deutschland gefahren, um Deutsch zu lernen.',
      'Ich bin nach Deutschland gefahren, um Deutsch lernen.',
      'Ich bin nach Deutschland gefahren, um zu Deutsch lernen.',
      'Ich bin nach Deutschland gefahren, um Deutsch lernen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '\'um ... zu\' + Infinitiv: \'zu\' steht direkt vor dem Infinitiv.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-009',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er dankt seinem Lehrer für die Hilfe.',
      'Er dankt seinen Lehrer für die Hilfe.',
      'Er dankt seinem Lehrer über die Hilfe.',
      'Er dankt seinen Lehrer über die Hilfe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'danken\' verlangt Dativ (seinem Lehrer) + \'für\' + Akkusativ (die Hilfe).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-010',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich hätte gern ein Glas Wasser.',
      'Ich hätte gern einen Glas Wasser.',
      'Ich hätte gern einem Glas Wasser.',
      'Ich hätte gern eines Glas Wasser.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Glas\' ist Neutrum — Akkusativ: ein Glas Wasser.',
    'subcategory': 'Artikel',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-011',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Mädchen, das neben mir sitzt, heißt Anna.',
      'Das Mädchen, die neben mir sitzt, heißt Anna.',
      'Das Mädchen, der neben mir sitzt, heißt Anna.',
      'Das Mädchen, den neben mir sitzt, heißt Anna.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mädchen\' ist Neutrum — Relativpronomen Nominativ: das.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-012',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hängt das Bild an die Wand.',
      'Er hängt das Bild an der Wand.',
      'Er hängt das Bild an dem Wand.',
      'Er hängt das Bild an den Wand.'
    ],
    'correctAnswer': 0,
    'explanation': '\'hängen\' (transitiv) = Richtung (wohin?) -> Akkusativ: an die Wand.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-013',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Bevor ich gehe, muss ich noch aufräumen.',
      'Bevor ich gehe, ich muss noch aufräumen.',
      'Bevor gehe ich, muss ich noch aufräumen.',
      'Bevor ich gehe muss ich noch aufräumen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'bevor\' steht das Verb am Ende; im Hauptsatz folgt Inversion.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-014',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie erinnert sich an ihren ersten Schultag.',
      'Sie erinnert sich über ihren ersten Schultag.',
      'Sie erinnert sich auf ihren ersten Schultag.',
      'Sie erinnert sich für ihren ersten Schultag.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich erinnern an\' + Akkusativ ist die feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-015',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn ich mehr Geld hätte, reiste ich um die Welt.',
      'Wenn ich mehr Geld hätte, reise ich um die Welt.',
      'Wenn ich mehr Geld habe, reiste ich um die Welt.',
      'Wenn ich mehr Geld hätte, ich reiste um die Welt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'wenn + hätte\' im Nebensatz, Konjunktiv II (reiste) im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-016',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gestern habe ich meinen Schlüssel verloren.',
      'Gestern ich habe meinen Schlüssel verloren.',
      'Gestern habe ich meinem Schlüssel verloren.',
      'Gestern habe meinen Schlüssel ich verloren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion bei Zeitangabe am Anfang; \'verlieren\' verlangt Akkusativ (meinen Schlüssel).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-017',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Kinder laufen in den Garten.',
      'Die Kinder laufen in dem Garten.',
      'Die Kinder laufen in der Garten.',
      'Die Kinder laufen in des Gartens.'
    ],
    'correctAnswer': 0,
    'explanation': '\'laufen\' mit \'in\' = Richtung (wohin?) -> Akkusativ: in den Garten.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-018',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das ist die Frau, die ich gestern getroffen habe.',
      'Das ist die Frau, der ich gestern getroffen habe.',
      'Das ist die Frau, den ich gestern getroffen habe.',
      'Das ist die Frau, dem ich gestern getroffen habe.'
    ],
    'correctAnswer': 0,
    'explanation': '\'treffen\' verlangt Akkusativ; \'Frau\' ist feminin -> Relativpronomen: die.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-019',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie braucht nicht kommen.',
      'Sie braucht nicht zu kommen.',
      'Sie braucht zu nicht kommen.',
      'Sie braucht kommen nicht.'
    ],
    'correctAnswer': 1,
    'explanation': '\'brauchen\' mit Verneinung verlangt \'zu\' + Infinitiv.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-020',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er geht zur Universität zu Fuß.',
      'Er geht zu Fuß zur Universität.',
      'Er geht zu Fuß zu der Universität.',
      'Er geht zur Fuß zur Universität.'
    ],
    'correctAnswer': 1,
    'explanation': 'Modalangabe (zu Fuß) vor Lokalangabe (zur Universität) nach TeKaMoLo.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-021',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich warte auf dich seit zwei Stunden.',
      'Ich warte seit zwei Stunden auf dich.',
      'Ich warte seit zwei Stunde auf dich.',
      'Seit zwei Stunden ich warte auf dich.'
    ],
    'correctAnswer': 1,
    'explanation': 'Temporale Angabe (seit zwei Stunden) vor lokaler/präpositionaler Ergänzung.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-022',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat mir empfohlen, dieses Buch zu lesen.',
      'Er hat mich empfohlen, dieses Buch zu lesen.',
      'Er hat mir empfohlen, dieses Buch lesen.',
      'Er hat mir empfohlen, zu dieses Buch lesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'empfehlen\' verlangt Dativ (mir) + Infinitivsatz mit \'zu\'.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-023',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Anstatt zu lernen, spielte er Computerspiele.',
      'Anstatt lernen, spielte er Computerspiele.',
      'Anstatt zu lernen, er spielte Computerspiele.',
      'Anstatt lernen zu, spielte er Computerspiele.'
    ],
    'correctAnswer': 0,
    'explanation': '\'anstatt zu\' + Infinitiv; im Hauptsatz Inversion nach vorangestelltem Nebensatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-024',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat sich bei ihrem Chef entschuldigt.',
      'Sie hat sich bei ihren Chef entschuldigt.',
      'Sie hat sich bei ihr Chef entschuldigt.',
      'Sie hat sich bei ihrem Chef sich entschuldigt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'bei\' verlangt Dativ: ihrem Chef. \'sich entschuldigen bei\'.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-025',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er so getan hat, als ob er nichts wüsste.',
      'Er hat so getan, als ob er nichts wüsste.',
      'Er hat so getan, als ob er nichts wusste.',
      'Er hat so getan, als ob er wüsste nichts.'
    ],
    'correctAnswer': 1,
    'explanation': '\'als ob\' verlangt Konjunktiv II (wüsste); Verb am Ende des Nebensatzes.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-026',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe einen guten Freund, auf den ich mich verlassen kann.',
      'Ich habe einen guten Freund, auf dem ich mich verlassen kann.',
      'Ich habe einen guten Freund, auf der ich mich verlassen kann.',
      'Ich habe einen guten Freund, auf die ich mich verlassen kann.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich verlassen auf\' + Akkusativ; \'Freund\' ist maskulin -> auf den.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-027',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Schüler müssen ihre Hausaufgaben machen.',
      'Die Schüler müssen ihre Hausaufgaben zu machen.',
      'Die Schüler müssen ihre Hausaufgaben gemacht.',
      'Die Schüler müssen machen ihre Hausaufgaben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach Modalverben (müssen) steht der Infinitiv ohne \'zu\' am Ende.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-028',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er fährt lieber mit dem Fahrrad als mit dem Auto.',
      'Er fährt lieber mit dem Fahrrad wie mit dem Auto.',
      'Er fährt lieber mit den Fahrrad als mit den Auto.',
      'Er fährt lieber mit das Fahrrad als mit das Auto.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vergleich: \'lieber ... als\' (nicht \'wie\'). \'mit\' verlangt Dativ.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-029',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat den Teller auf den Tisch gestellt.',
      'Er hat den Teller auf dem Tisch gestellt.',
      'Er hat den Teller auf der Tisch gestellt.',
      'Er hat der Teller auf den Tisch gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stellen\' = Richtung (wohin?) -> Akkusativ: auf den Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-030',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Frau, mit der ich gesprochen habe, ist meine Nachbarin.',
      'Die Frau, mit die ich gesprochen habe, ist meine Nachbarin.',
      'Die Frau, mit den ich gesprochen habe, ist meine Nachbarin.',
      'Die Frau, mit dem ich gesprochen habe, ist meine Nachbarin.'
    ],
    'correctAnswer': 0,
    'explanation': '\'mit\' verlangt Dativ; \'Frau\' ist feminin -> Relativpronomen: der.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-031',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nachdem wir gegessen hatten, gingen wir spazieren.',
      'Nachdem wir gegessen haben, gingen wir spazieren.',
      'Nachdem wir aßen, gingen wir spazieren.',
      'Nachdem wir gegessen hatten, wir gingen spazieren.'
    ],
    'correctAnswer': 0,
    'explanation': '\'nachdem\' + Plusquamperfekt im Nebensatz, Präteritum im Hauptsatz. Inversion.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-032',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich gratuliere dir zu deinem Geburtstag.',
      'Ich gratuliere dich zu deinem Geburtstag.',
      'Ich gratuliere dir für deinen Geburtstag.',
      'Ich gratuliere dich für deinem Geburtstag.'
    ],
    'correctAnswer': 0,
    'explanation': '\'gratulieren\' verlangt Dativ (dir) + \'zu\' + Dativ (deinem Geburtstag).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-033',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Innerhalb der Stadt gibt es viele Parks.',
      'Innerhalb die Stadt gibt es viele Parks.',
      'Innerhalb dem Stadt gibt es viele Parks.',
      'Innerhalb den Stadt gibt es viele Parks.'
    ],
    'correctAnswer': 0,
    'explanation': '\'innerhalb\' verlangt den Genitiv: innerhalb der Stadt.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-034',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn er fleißiger wäre, würde er die Prüfung bestehen.',
      'Wenn er fleißiger wäre, er würde die Prüfung bestehen.',
      'Wenn er fleißiger ist, würde er die Prüfung bestehen.',
      'Wenn er fleißiger wäre, würde er die Prüfung zu bestehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'wenn + wäre\' im Nebensatz, \'würde + Infinitiv\' im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-035',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er sieht fern, während seine Frau kocht.',
      'Er sieht fern, während seine Frau kochen.',
      'Er sieht fern, während kocht seine Frau.',
      'Er fernsieht, während seine Frau kocht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'während\'-Nebensatz steht das Verb am Ende. \'fernsehen\' wird getrennt.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-036',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er setzte sich zwischen die beiden Stühle.',
      'Er setzte sich zwischen den beiden Stühlen.',
      'Er setzte sich zwischen der beiden Stühle.',
      'Er setzte sich zwischen dem beiden Stühle.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich setzen zwischen\' = Richtung (wohin?) -> Akkusativ: die beiden Stühle.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-037',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Haus, in dem wir wohnen, ist alt.',
      'Das Haus, in den wir wohnen, ist alt.',
      'Das Haus, in das wir wohnen, ist alt.',
      'Das Haus, in der wir wohnen, ist alt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'wohnen in\' + Dativ (wo?); \'Haus\' ist Neutrum -> Relativpronomen: dem.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-038',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Normalerweise stehe ich um sieben Uhr auf.',
      'Normalerweise ich stehe um sieben Uhr auf.',
      'Normalerweise stehe ich auf um sieben Uhr.',
      'Normalerweise aufstehe ich um sieben Uhr.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb \'aufstehen\': Präfix \'auf\' am Ende; Inversion nach Adverb.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-039',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sich an das Klima schnell gewöhnt.',
      'Er hat sich an das Klima schnell gegewöhnt.',
      'Er hat an das Klima sich schnell gewöhnt.',
      'Er hat sich an dem Klima schnell gewöhnt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich gewöhnen an\' + Akkusativ: an das Klima. Partizip II: gewöhnt.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-040',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er zeigt den Touristen den Weg.',
      'Er zeigt die Touristen den Weg.',
      'Er zeigt den Touristen dem Weg.',
      'Er zeigt der Touristen den Weg.'
    ],
    'correctAnswer': 0,
    'explanation': '\'zeigen\' verlangt Dativ (den Touristen) + Akkusativ (den Weg).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-041',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er ist so müde, dass er kaum die Augen aufhalten kann.',
      'Er ist so müde, dass er kaum die Augen kann aufhalten.',
      'Er ist so müde, dass kaum er die Augen aufhalten kann.',
      'Er ist so müde, dass er die Augen kaum aufhalten kann.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'dass\'-Nebensatz steht das konjugierte Verb (kann) am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-042',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er setzt sich neben mich.',
      'Er setzt sich neben mir.',
      'Er setzt sich neben ich.',
      'Er setzt sich neben meiner.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich setzen neben\' = Richtung (wohin?) -> Akkusativ: neben mich.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-043',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er könnte mir helfen, wenn er wollte.',
      'Er könnte mir helfen, wenn er will.',
      'Er könnte mich helfen, wenn er wollte.',
      'Er könnte mir helfen, wenn er wollt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II in beiden Teilen: könnte + wollte. \'helfen\' verlangt Dativ.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-044',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Lehrer, den alle mögen, geht in Pension.',
      'Der Lehrer, der alle mögen, geht in Pension.',
      'Der Lehrer, dem alle mögen, geht in Pension.',
      'Der Lehrer, dessen alle mögen, geht in Pension.'
    ],
    'correctAnswer': 0,
    'explanation': '\'mögen\' verlangt Akkusativ; \'Lehrer\' ist maskulin -> Relativpronomen: den.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-045',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Außerhalb der Öffnungszeiten ist das Geschäft geschlossen.',
      'Außerhalb die Öffnungszeiten ist das Geschäft geschlossen.',
      'Außerhalb den Öffnungszeiten ist das Geschäft geschlossen.',
      'Außerhalb dem Öffnungszeiten ist das Geschäft geschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'außerhalb\' verlangt den Genitiv: außerhalb der Öffnungszeiten.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-046',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat mir einen langen Brief geschrieben.',
      'Er hat mich einen langen Brief geschrieben.',
      'Er hat mir einem langen Brief geschrieben.',
      'Er hat mir einen lange Brief geschrieben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'schreiben\' verlangt Dativ (mir) + Akkusativ (einen langen Brief).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-047',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Je mehr ich lerne, desto besser verstehe ich.',
      'Je mehr ich lerne, je besser verstehe ich.',
      'Je mehr ich lerne, desto besser ich verstehe.',
      'Mehr ich lerne, desto besser verstehe ich.'
    ],
    'correctAnswer': 0,
    'explanation': '\'je ... desto\': Im desto-Satz folgt Inversion (Verb vor Subjekt).',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-048',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat versucht, das Problem allein zu lösen.',
      'Er hat versucht, das Problem allein lösen.',
      'Er hat versucht, zu das Problem allein lösen.',
      'Er hat versucht, das Problem lösen zu allein.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz mit \'zu\': \'zu\' steht direkt vor dem Infinitiv am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-049',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Buch liegt auf dem Regal.',
      'Das Buch liegt auf den Regal.',
      'Das Buch liegt auf das Regal.',
      'Das Buch liegt auf der Regal.'
    ],
    'correctAnswer': 0,
    'explanation': '\'liegen\' = Ort (wo?) -> Dativ: auf dem Regal. \'Regal\' ist Neutrum.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p2-050',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn ich Zeit gehabt hätte, wäre ich gekommen.',
      'Wenn ich Zeit gehabt hätte, ich wäre gekommen.',
      'Wenn ich Zeit hatte, wäre ich gekommen.',
      'Wenn ich Zeit gehabt hätte, würde ich gekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit: \'hätte + Partizip II\' im Nebensatz, \'wäre + Partizip II\' im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  }
];

export default questions;
