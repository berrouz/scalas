import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-001',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ins Kino gestern ich bin gegangen.',
      'Ich gestern ins Kino bin gegangen.',
      'Gestern ich bin ins Kino gegangen.',
      'Gestern bin ich ins Kino gegangen.'
    ],
    'correctAnswer': 3,
    'explanation': 'Inversion: Zeitangabe (Position 1) + Verb + Subjekt.',
    'exampleSentence': 'Gestern bin ich ins Kino gegangen.',
    'grammarRule': 'Inversion: Zeitangabe + Verb + Subjekt',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-013',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Aller Voraussicht nach wird sich die Lage entspannen.',
      'Aller Voraussicht nach die Lage wird sich entspannen.',
      'Aller Voraussicht nach wird die Lage entspannen sich.',
      'Nach aller Voraussicht sich wird die Lage entspannen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aller Voraussicht nach + Inversion: wird + sich + Subjekt + Infinitiv.',
    'exampleSentence': 'Aller Voraussicht nach wird sich die Lage entspannen.',
    'grammarRule': 'Gehobene Wendung mit Inversion',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-014',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei betont, dass dies keine leichte Aufgabe ist.',
      'Es sei betont, dass dies ist keine leichte Aufgabe.',
      'Betont sei es, dass dies keine leichte Aufgabe ist.',
      'Es sei betonen, dass dies keine leichte Aufgabe ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in formeller Betonung: Es sei betont + dass-Nebensatz (Verb am Ende).',
    'exampleSentence': 'Es sei betont, dass dies keine leichte Aufgabe ist.',
    'grammarRule': 'Konjunktiv I in formellen Betonungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-015',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Keineswegs war er gewillt, das Feld zu räumen.',
      'Keineswegs er war gewillt, das Feld zu räumen.',
      'Keineswegs war gewillt er, das Feld zu räumen.',
      'Gewillt war er keineswegs, das Feld zu räumen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach keineswegs folgt Inversion: war + er.',
    'exampleSentence': 'Keineswegs war er gewillt, das Feld zu räumen.',
    'grammarRule': 'Inversion nach negierendem Adverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-016',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ungeachtet dessen, dass die Risiken bekannt waren, wurde investiert.',
      'Ungeachtet dessen, dass die Risiken bekannt waren, investiert wurde.',
      'Ungeachtet dessen, dass bekannt waren die Risiken, wurde investiert.',
      'Dessen ungeachtet, dass die Risiken bekannt waren, wurde investiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ungeachtet dessen, dass + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Ungeachtet dessen, dass die Risiken bekannt waren, wurde investiert.',
    'grammarRule': 'Konzessivsatz mit ungeachtet dessen',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-017',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Möge die Vorsehung uns beistehen.',
      'Möge die Vorsehung beistehen uns.',
      'Die Vorsehung möge beistehen uns.',
      'Möge uns die Vorsehung beistehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I: Möge + Subjekt + Dativobjekt + Infinitiv.',
    'exampleSentence': 'Möge die Vorsehung uns beistehen.',
    'grammarRule': 'Konjunktiv I in gehobenen Wünschen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-018',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Umso bemerkenswerter ist die Tatsache, dass er es geschafft hat.',
      'Umso bemerkenswerter die Tatsache ist, dass er es geschafft hat.',
      'Umso ist bemerkenswerter die Tatsache, dass er es geschafft hat.',
      'Die Tatsache umso bemerkenswerter ist, dass er es geschafft hat.'
    ],
    'correctAnswer': 0,
    'explanation': 'Umso + Komparativ + Inversion: ist + Subjekt + dass-Nebensatz.',
    'exampleSentence': 'Umso bemerkenswerter ist die Tatsache, dass er es geschafft hat.',
    'grammarRule': 'Gehobener Ausdruck mit umso + Komparativ',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-019',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ob er nun will oder nicht, er muss teilnehmen.',
      'Ob er nun will oder nicht, teilnehmen muss er.',
      'Ob nun er will oder nicht, er muss teilnehmen.',
      'Ob er nun will nicht oder, er muss teilnehmen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessive Alternativkonstruktion: Ob...oder nicht + Hauptsatz ohne Inversion.',
    'exampleSentence': 'Ob er nun will oder nicht, er muss teilnehmen.',
    'grammarRule': 'Konzessivsatz mit ob...oder nicht',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-020',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es gebührt ihm, als Erster zu sprechen.',
      'Es gebührt ihn, als Erster zu sprechen.',
      'Es gebührt ihm, als Erster sprechen zu.',
      'Ihm gebührt, als Erster es zu sprechen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Verb gebühren + Dativ: ihm + Infinitiv mit zu.',
    'exampleSentence': 'Es gebührt ihm, als Erster zu sprechen.',
    'grammarRule': 'Gehobenes Verb gebühren + Dativ',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-021',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Auf dass die Wahrheit ans Licht komme!',
      'Auf dass die Wahrheit ans Licht kommt!',
      'Auf dass komme die Wahrheit ans Licht!',
      'Dass auf die Wahrheit ans Licht komme!'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Finalkonstruktion: Auf dass + Konjunktiv I (komme) am Ende.',
    'exampleSentence': 'Auf dass die Wahrheit ans Licht komme!',
    'grammarRule': 'Finalsatz mit auf dass + Konjunktiv I',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-022',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Erst als alle Möglichkeiten ausgeschöpft waren, gab er auf.',
      'Erst als alle Möglichkeiten ausgeschöpft waren, auf gab er.',
      'Erst als alle Möglichkeiten waren ausgeschöpft, gab er auf.',
      'Erst als alle Möglichkeiten ausgeschöpft waren, er gab auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erst als + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'Erst als alle Möglichkeiten ausgeschöpft waren, gab er auf.',
    'grammarRule': 'Temporalsatz mit erst als',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-023',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es steht zu befürchten, dass die Krise sich verschärft.',
      'Es steht befürchten zu, dass die Krise sich verschärft.',
      'Es steht zu befürchten, dass verschärft sich die Krise.',
      'Zu befürchten steht es, dass die Krise sich verschärft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es steht zu befürchten (= es ist zu befürchten) + dass-Nebensatz.',
    'exampleSentence': 'Es steht zu befürchten, dass die Krise sich verschärft.',
    'grammarRule': 'Gehobene Wendung mit stehen + zu + Infinitiv',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-024',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Einzig und allein sein Mut rettete ihn.',
      'Einzig und allein rettete sein Mut ihn.',
      'Sein Mut einzig und allein rettete ihn.',
      'Rettete einzig und allein sein Mut ihn.'
    ],
    'correctAnswer': 0,
    'explanation': 'Einzig und allein als Attribut zu Subjekt: Einzig und allein sein Mut + Verb.',
    'exampleSentence': 'Einzig und allein sein Mut rettete ihn.',
    'grammarRule': 'Gehobene Betonung mit einzig und allein',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-025',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Inwiefern dies zutrifft, sei dahingestellt.',
      'Inwiefern dies zutrifft, dahingestellt sei.',
      'Inwiefern zutrifft dies, sei dahingestellt.',
      'Dies inwiefern zutrifft, sei dahingestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inwiefern + Nebensatz (Verb am Ende), + Hauptsatz (Konjunktiv I: sei + dahingestellt).',
    'exampleSentence': 'Inwiefern dies zutrifft, sei dahingestellt.',
    'grammarRule': 'Gehobene Wendung mit dahingestellt sein',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-026',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es wäre vermessen, das Gegenteil zu behaupten.',
      'Es wäre vermessen, das Gegenteil behaupten zu.',
      'Vermessen wäre es, zu behaupten das Gegenteil.',
      'Es vermessen wäre, das Gegenteil zu behaupten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobener Ausdruck: Es wäre vermessen (Konjunktiv II) + Infinitiv mit zu.',
    'exampleSentence': 'Es wäre vermessen, das Gegenteil zu behaupten.',
    'grammarRule': 'Gehobener Konjunktiv II + Infinitiv',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-027',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Fürwahr, eine bemerkenswerte Leistung hat er vollbracht.',
      'Fürwahr, er eine bemerkenswerte Leistung hat vollbracht.',
      'Fürwahr, hat er eine bemerkenswerte Leistung vollbracht.',
      'Fürwahr, eine bemerkenswerte Leistung er hat vollbracht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaisches fürwahr (= wahrhaftig) als Einleitung, dann Satz mit Objekt-Topikalisierung.',
    'exampleSentence': 'Fürwahr, eine bemerkenswerte Leistung hat er vollbracht.',
    'grammarRule': 'Archaische Bekräftigung mit fürwahr',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-029',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es darf nicht verschwiegen werden, dass Fehler gemacht wurden.',
      'Es darf nicht verschwiegen werden, dass wurden Fehler gemacht.',
      'Verschwiegen werden darf es nicht, dass Fehler gemacht wurden.',
      'Es nicht darf verschwiegen werden, dass Fehler gemacht wurden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es darf nicht verschwiegen werden + dass-Nebensatz.',
    'exampleSentence': 'Es darf nicht verschwiegen werden, dass Fehler gemacht wurden.',
    'grammarRule': 'Gehobene Passivkonstruktion',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-030',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Schwerlich hätte man ein besseres Ergebnis erzielen können.',
      'Schwerlich man hätte ein besseres Ergebnis erzielen können.',
      'Schwerlich hätte man erzielen ein besseres Ergebnis können.',
      'Man hätte schwerlich können ein besseres Ergebnis erzielen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Schwerlich (= kaum) + Inversion: hätte + man + Objekt + Infinitiv + können.',
    'exampleSentence': 'Schwerlich hätte man ein besseres Ergebnis erzielen können.',
    'grammarRule': 'Gehobenes Adverb mit Inversion + Konjunktiv II',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-031',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wiewohl die Argumente stichhaltig waren, wurde der Antrag abgelehnt.',
      'Wiewohl die Argumente stichhaltig waren, der Antrag wurde abgelehnt.',
      'Wiewohl waren die Argumente stichhaltig, wurde der Antrag abgelehnt.',
      'Die Argumente wiewohl stichhaltig waren, wurde der Antrag abgelehnt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes wiewohl (= obwohl) + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Wiewohl die Argumente stichhaltig waren, wurde der Antrag abgelehnt.',
    'grammarRule': 'Konzessivsatz mit wiewohl',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-032',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es steht außer Zweifel, dass er qualifiziert ist.',
      'Es steht außer Zweifel, dass qualifiziert er ist.',
      'Außer Zweifel steht, dass er qualifiziert ist es.',
      'Es außer Zweifel steht, dass er qualifiziert ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es steht außer Zweifel (= es ist unbestreitbar) + dass-Nebensatz.',
    'exampleSentence': 'Es steht außer Zweifel, dass er qualifiziert ist.',
    'grammarRule': 'Gehobene Wendung: außer Zweifel stehen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-033',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wohl oder übel musste er sich fügen.',
      'Wohl oder übel er musste sich fügen.',
      'Wohl oder übel musste sich er fügen.',
      'Er musste wohl oder übel sich fügen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wohl oder übel (= ob man will oder nicht) + Inversion: musste + er + sich fügen.',
    'exampleSentence': 'Wohl oder übel musste er sich fügen.',
    'grammarRule': 'Feste Wendung mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-034',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wohlgemerkt handelt es sich um eine vorläufige Entscheidung.',
      'Wohlgemerkt es handelt sich um eine vorläufige Entscheidung.',
      'Wohlgemerkt handelt sich es um eine vorläufige Entscheidung.',
      'Es handelt wohlgemerkt um eine vorläufige Entscheidung sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wohlgemerkt (= nota bene) + Inversion: handelt + es sich.',
    'exampleSentence': 'Wohlgemerkt handelt es sich um eine vorläufige Entscheidung.',
    'grammarRule': 'Gehobenes Adverb mit Inversion',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-035',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man hüte sich davor, voreilige Schlüsse zu ziehen.',
      'Man hüte davor sich, voreilige Schlüsse zu ziehen.',
      'Man hüte sich davor, voreilige Schlüsse ziehen zu.',
      'Sich hüte man davor, voreilige Schlüsse zu ziehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als gehobene Warnung: Man hüte sich + Infinitiv mit zu.',
    'exampleSentence': 'Man hüte sich davor, voreilige Schlüsse zu ziehen.',
    'grammarRule': 'Konjunktiv I in gehobenen Warnungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-036',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'So gering die Aussichten auch waren, er gab nicht auf.',
      'So gering die Aussichten auch waren, gab er nicht auf.',
      'So gering auch die Aussichten waren, er gab nicht auf.',
      'Die Aussichten so gering auch waren, er gab nicht auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessiver Nebensatz: So + Adjektiv + Subjekt + auch + Verb am Ende, dann Hauptsatz.',
    'exampleSentence': 'So gering die Aussichten auch waren, er gab nicht auf.',
    'grammarRule': 'Konzessivsatz mit so...auch',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-037',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Allem Anschein nach hat er die Stadt verlassen.',
      'Allem Anschein nach er hat die Stadt verlassen.',
      'Allem Anschein nach hat die Stadt er verlassen.',
      'Nach allem Anschein hat er die Stadt verlassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Allem Anschein nach + Inversion: hat + er.',
    'exampleSentence': 'Allem Anschein nach hat er die Stadt verlassen.',
    'grammarRule': 'Gehobene Wendung mit Inversion',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p4-050',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei darauf verwiesen, dass weiterführende Literatur existiert.',
      'Es sei darauf verwiesen, dass existiert weiterführende Literatur.',
      'Darauf sei es verwiesen, dass weiterführende Literatur existiert.',
      'Es sei darauf verweisen, dass weiterführende Literatur existiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in formellen Verweisen: Es sei darauf verwiesen + dass-Nebensatz.',
    'exampleSentence': 'Es sei darauf verwiesen, dass weiterführende Literatur existiert.',
    'grammarRule': 'Konjunktiv I in formellen Verweisen',
    'tags': ['satzbildung', 'archaisch']
  },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-038', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Erschwerend kommt hinzu, dass die Ressourcen knapp sind.', 'Erschwerend hinzu kommt, dass die Ressourcen knapp sind.', 'Erschwerend kommt hinzu, dass knapp sind die Ressourcen.', 'Kommt erschwerend hinzu, dass die Ressourcen knapp sind.'], 'correctAnswer': 0, 'explanation': 'Erschwerend kommt hinzu (= zusätzlich belastend) + dass-Nebensatz.', 'exampleSentence': 'Erschwerend kommt hinzu, dass die Ressourcen knapp sind.', 'grammarRule': 'Gehobene Wendung: erschwerend hinzukommen', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-039', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei nochmals betont, dass die Sicherheit Vorrang hat.', 'Es sei nochmals betonen, dass die Sicherheit Vorrang hat.', 'Nochmals betont sei es, dass die Sicherheit Vorrang hat.', 'Es sei nochmals betont, dass Vorrang hat die Sicherheit.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Es sei nochmals betont + dass-Nebensatz.', 'exampleSentence': 'Es sei nochmals betont, dass die Sicherheit Vorrang hat.', 'grammarRule': 'Konjunktiv I in formellen Betonungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-040', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Flugs hatte er einen Plan geschmiedet.', 'Flugs er hatte einen Plan geschmiedet.', 'Flugs hatte einen Plan er geschmiedet.', 'Er flugs hatte einen Plan geschmiedet.'], 'correctAnswer': 0, 'explanation': 'Flugs (= schnell, archaisch) + Inversion: hatte + er.', 'exampleSentence': 'Flugs hatte er einen Plan geschmiedet.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-041', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es liegt in der Natur der Sache, dass Konflikte entstehen.', 'Es liegt in der Natur der Sache, dass entstehen Konflikte.', 'In der Natur der Sache liegt es, dass Konflikte entstehen.', 'Es liegt in die Natur der Sache, dass Konflikte entstehen.'], 'correctAnswer': 0, 'explanation': 'Gehobene Wendung: Es liegt in der Natur der Sache + dass-Nebensatz.', 'exampleSentence': 'Es liegt in der Natur der Sache, dass Konflikte entstehen.', 'grammarRule': 'Gehobene Wendung: in der Natur der Sache liegen', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-042', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man vergegenwärtige sich, dass die Zeit knapp ist.', 'Man vergegenwärtigt sich, dass die Zeit knapp ist.', 'Man vergegenwärtige sich, dass knapp ist die Zeit.', 'Vergegenwärtige man sich, dass die Zeit knapp ist.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man vergegenwärtige sich + dass-Nebensatz.', 'exampleSentence': 'Man vergegenwärtige sich, dass die Zeit knapp ist.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-043', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Gar bald zeigte sich, dass die Befürchtungen berechtigt waren.', 'Gar bald sich zeigte, dass die Befürchtungen berechtigt waren.', 'Gar bald zeigte sich, dass berechtigt waren die Befürchtungen.', 'Sich gar bald zeigte, dass die Befürchtungen berechtigt waren.'], 'correctAnswer': 0, 'explanation': 'Gar bald (= sehr bald, archaisch) + Inversion: zeigte + sich.', 'exampleSentence': 'Gar bald zeigte sich, dass die Befürchtungen berechtigt waren.', 'grammarRule': 'Archaische Wendung mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-044', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Im Übrigen sei darauf verwiesen, dass weitere Informationen vorliegen.', 'Im Übrigen sei darauf verweisen, dass weitere Informationen vorliegen.', 'Im Übrigen darauf sei verwiesen, dass weitere Informationen vorliegen.', 'Im Übrigen sei darauf verwiesen, dass vorliegen weitere Informationen.'], 'correctAnswer': 0, 'explanation': 'Im Übrigen + Konjunktiv I: sei darauf verwiesen + dass-Nebensatz.', 'exampleSentence': 'Im Übrigen sei darauf verwiesen, dass weitere Informationen vorliegen.', 'grammarRule': 'Konjunktiv I in formellen Verweisen', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-045', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es obliegt dem Vorstand, die Jahresbilanz zu genehmigen.', 'Es obliegt den Vorstand, die Jahresbilanz zu genehmigen.', 'Es obliegt dem Vorstand, die Jahresbilanz genehmigen zu.', 'Dem Vorstand obliegt, die Jahresbilanz zu genehmigen es.'], 'correctAnswer': 0, 'explanation': 'Gehobenes obliegen + Dativ: dem Vorstand + Infinitiv mit zu.', 'exampleSentence': 'Es obliegt dem Vorstand, die Jahresbilanz zu genehmigen.', 'grammarRule': 'Gehobenes Verb obliegen + Dativ', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-046', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Alsbald wurde der Beschluss gefasst.', 'Alsbald der Beschluss wurde gefasst.', 'Alsbald wurde gefasst der Beschluss.', 'Der Beschluss alsbald wurde gefasst.'], 'correctAnswer': 0, 'explanation': 'Alsbald (= sogleich, archaisch) + Inversion: wurde + Subjekt + Partizip.', 'exampleSentence': 'Alsbald wurde der Beschluss gefasst.', 'grammarRule': 'Archaisches Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-047', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unbeschadet der Meinungsverschiedenheiten wurde eine Einigung erzielt.', 'Unbeschadet die Meinungsverschiedenheiten wurde eine Einigung erzielt.', 'Unbeschadet der Meinungsverschiedenheiten eine Einigung wurde erzielt.', 'Unbeschadet der Meinungsverschiedenheiten wurde erzielt eine Einigung.'], 'correctAnswer': 0, 'explanation': 'Unbeschadet + Genitiv: der Meinungsverschiedenheiten. Inversion im Hauptsatz.', 'exampleSentence': 'Unbeschadet der Meinungsverschiedenheiten wurde eine Einigung erzielt.', 'grammarRule': 'Gehobene Konzessivkonstruktion mit unbeschadet', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-048', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es vermag niemand, das Ergebnis vorherzusagen.', 'Es vermag niemand, das Ergebnis vorhersagen zu.', 'Niemand es vermag, das Ergebnis vorherzusagen.', 'Es vermag niemand, vorherzusagen das Ergebnis.'], 'correctAnswer': 0, 'explanation': 'Gehobenes vermögen (= können) + Infinitiv mit zu.', 'exampleSentence': 'Es vermag niemand, das Ergebnis vorherzusagen.', 'grammarRule': 'Gehobenes Verb vermögen + zu + Infinitiv', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-049', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nichtsdestotrotz blieb er seiner Überzeugung treu.', 'Nichtsdestotrotz er blieb seiner Überzeugung treu.', 'Nichtsdestotrotz blieb seiner Überzeugung er treu.', 'Er nichtsdestotrotz blieb seiner Überzeugung treu.'], 'correctAnswer': 0, 'explanation': 'Nichtsdestotrotz (= trotzdem) + Inversion: blieb + er.', 'exampleSentence': 'Nichtsdestotrotz blieb er seiner Überzeugung treu.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-050', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nichtsdestoweniger verdient der Vorschlag Beachtung.', 'Nichtsdestoweniger der Vorschlag verdient Beachtung.', 'Nichtsdestoweniger verdient Beachtung der Vorschlag.', 'Der Vorschlag nichtsdestoweniger verdient Beachtung.'], 'correctAnswer': 0, 'explanation': 'Nichtsdestoweniger + Inversion: verdient + Subjekt.', 'exampleSentence': 'Nichtsdestoweniger verdient der Vorschlag Beachtung.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-051', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei ausdrücklich betont, dass Diskretion geboten ist.', 'Es sei ausdrücklich betonen, dass Diskretion geboten ist.', 'Betont sei es ausdrücklich, dass Diskretion geboten ist.', 'Es sei ausdrücklich betont, dass geboten ist Diskretion.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es sei betont + dass-Nebensatz.', 'exampleSentence': 'Es sei ausdrücklich betont, dass Diskretion geboten ist.', 'grammarRule': 'Konjunktiv I Passiv in formeller Sprache', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-052', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fürwahr verdient diese Leistung Anerkennung.', 'Fürwahr diese Leistung verdient Anerkennung.', 'Fürwahr verdient Anerkennung diese Leistung.', 'Diese Leistung fürwahr verdient Anerkennung.'], 'correctAnswer': 0, 'explanation': 'Fürwahr (= wahrhaftig) + Inversion: verdient + Subjekt.', 'exampleSentence': 'Fürwahr verdient diese Leistung Anerkennung.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-053', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zumal die Risiken erheblich sind, ist Vorsicht geboten.', 'Zumal die Risiken erheblich sind, Vorsicht ist geboten.', 'Zumal erheblich sind die Risiken, ist Vorsicht geboten.', 'Zumal die Risiken sind erheblich, ist Vorsicht geboten.'], 'correctAnswer': 0, 'explanation': 'Zumal + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Zumal die Risiken erheblich sind, ist Vorsicht geboten.', 'grammarRule': 'Kausalsatz mit zumal', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-054', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge sich vergegenwärtigen, welche Tragweite die Entscheidung hat.', 'Man vergegenwärtigt möge sich, welche Tragweite die Entscheidung hat.', 'Man möge sich vergegenwärtigen, welche Tragweite hat die Entscheidung.', 'Vergegenwärtigen möge man sich, welche Tragweite die Entscheidung hat.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man möge sich vergegenwärtigen + indirekter Fragesatz.', 'exampleSentence': 'Man möge sich vergegenwärtigen, welche Tragweite die Entscheidung hat.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-055', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ungeachtet der Proteste wurde die Reform durchgesetzt.', 'Ungeachtet die Proteste wurde die Reform durchgesetzt.', 'Ungeachtet der Proteste die Reform wurde durchgesetzt.', 'Ungeachtet der Proteste wurde durchgesetzt die Reform.'], 'correctAnswer': 0, 'explanation': 'Ungeachtet + Genitiv: der Proteste. Inversion im Hauptsatz.', 'exampleSentence': 'Ungeachtet der Proteste wurde die Reform durchgesetzt.', 'grammarRule': 'Gehobene Konzessivkonstruktion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-056', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Insofern als die Voraussetzungen gegeben sind, kann begonnen werden.', 'Insofern als die Voraussetzungen gegeben sind, begonnen werden kann.', 'Insofern als gegeben sind die Voraussetzungen, kann begonnen werden.', 'Insofern als die Voraussetzungen sind gegeben, kann begonnen werden.'], 'correctAnswer': 0, 'explanation': 'Insofern als + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Insofern als die Voraussetzungen gegeben sind, kann begonnen werden.', 'grammarRule': 'Gehobene Konditionalkonstruktion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-057', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es werde hiermit festgehalten, dass die Vereinbarung bindend ist.', 'Es werde hiermit festhalten, dass die Vereinbarung bindend ist.', 'Festgehalten werde es hiermit, dass die Vereinbarung bindend ist.', 'Es werde hiermit festgehalten, dass bindend ist die Vereinbarung.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es werde festgehalten + dass-Nebensatz.', 'exampleSentence': 'Es werde hiermit festgehalten, dass die Vereinbarung bindend ist.', 'grammarRule': 'Konjunktiv I Passiv in Protokollen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-058', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Allenthalben machte sich Ernüchterung breit.', 'Allenthalben Ernüchterung machte sich breit.', 'Allenthalben machte breit sich Ernüchterung.', 'Ernüchterung allenthalben machte sich breit.'], 'correctAnswer': 0, 'explanation': 'Allenthalben (= überall, archaisch) + Inversion: machte + sich + Subjekt.', 'exampleSentence': 'Allenthalben machte sich Ernüchterung breit.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-059', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unbestritten ist, dass die Maßnahmen notwendig waren.', 'Unbestritten, dass die Maßnahmen notwendig waren, ist.', 'Ist unbestritten, dass die Maßnahmen notwendig waren.', 'Unbestritten ist, dass notwendig waren die Maßnahmen.'], 'correctAnswer': 0, 'explanation': 'Vorangestelltes Adjektiv: Unbestritten + ist + dass-Nebensatz.', 'exampleSentence': 'Unbestritten ist, dass die Maßnahmen notwendig waren.', 'grammarRule': 'Vorangestelltes Adjektiv + ist + dass', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-060', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei daran erinnert, dass die Frist morgen abläuft.', 'Es sei daran erinnern, dass die Frist morgen abläuft.', 'Erinnert sei es daran, dass die Frist morgen abläuft.', 'Es sei daran erinnert, dass morgen abläuft die Frist.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es sei erinnert + dass-Nebensatz.', 'exampleSentence': 'Es sei daran erinnert, dass die Frist morgen abläuft.', 'grammarRule': 'Konjunktiv I Passiv in Erinnerungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p4-061', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fürderhin ist mit strengeren Kontrollen zu rechnen.', 'Fürderhin mit strengeren Kontrollen ist zu rechnen.', 'Fürderhin ist zu rechnen mit strengeren Kontrollen.', 'Mit strengeren Kontrollen fürderhin ist zu rechnen.'], 'correctAnswer': 0, 'explanation': 'Fürderhin (= künftig, archaisch) + Inversion: ist + mit + zu + Infinitiv.', 'exampleSentence': 'Fürderhin ist mit strengeren Kontrollen zu rechnen.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] }
];

export default questions;
