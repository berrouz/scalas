import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-001',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wechselpräposition + Dativ',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder spielen in Garten.',
      'Die Kinder spielen ins Garten.',
      'Die Kinder spielen im Garten.',
      'Die Kinder spielen in den Garten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Wo? → Dativ: im Garten (in dem Garten).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Haus wird von den Arbeitern gebaut.',
      'Das Haus wird von den Arbeitern gebauen.',
      'Das Haus werden von den Arbeitern gebaut.',
      'Das Haus wird von die Arbeiter gebaut.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorgangspassiv: wird + Partizip II (gebaut). Nach "von" steht der Dativ: den Arbeitern.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Mann, dessen Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, deren Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, dem Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, wessen Auto gestohlen wurde, rief die Polizei.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen im Genitiv maskulin: dessen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem er gegessen hatte, ging er spazieren.',
      'Nachdem er gegessen hat, ging er spazieren.',
      'Nachdem er aß, ging er spazieren.',
      'Nachdem er essen hatte, ging er spazieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "nachdem" steht Plusquamperfekt, wenn der Hauptsatz im Präteritum steht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gestern ich habe einen Film gesehen.',
      'Gestern habe ich einen Film gesehen.',
      'Gestern habe einen Film ich gesehen.',
      'Gestern einen Film habe ich gesehen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei vorangestelltem Adverb steht das Verb an Position 2 (Inversion): Gestern habe ich ...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich helfe mein Bruder bei der Arbeit.',
      'Ich helfe meinem Bruder bei der Arbeit.',
      'Ich helfe meinen Bruder bei der Arbeit.',
      'Ich helfe meiner Bruder bei der Arbeit.'
    ],
    'correctAnswer': 1,
    'explanation': '"Helfen" verlangt den Dativ: meinem Bruder.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die am Tisch sitzende Frau liest ein Buch.',
      'Die am Tisch gesitzene Frau liest ein Buch.',
      'Die am Tisch sitzend Frau liest ein Buch.',
      'Die am Tisch sitzte Frau liest ein Buch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: sitzend + Endung -e → sitzende Frau.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sagt, er sei krank.',
      'Er sagt, er wäre krank.',
      'Er sagt, er ist krank.',
      'Er sagt, er wird krank.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede verwendet man Konjunktiv I: er sei.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Fenster ist schon geöffnet worden.',
      'Das Fenster ist schon geöffnet geworden.',
      'Das Fenster hat schon geöffnet worden.',
      'Das Fenster ist schon öffnen worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt Passiv: ist + Partizip II + worden (nicht "geworden").',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Stadt, in der ich wohne, ist sehr schön.',
      'Die Stadt, in die ich wohne, ist sehr schön.',
      'Die Stadt, wo der ich wohne, ist sehr schön.',
      'Die Stadt, in dem ich wohne, ist sehr schön.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wo? → Dativ feminin: in der Stadt → in der ich wohne.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den ganzen Tag gearbeitet haben.',
      'Er hat den ganzen Tag arbeiten.',
      'Er hat den ganzen Tag gearbeitet.',
      'Er hat den ganzen Tag gearbeiten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Perfekt: hat + Partizip II (gearbeitet).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je mehr man übt, umso besser wird man.',
      'Je mehr man übt, umso besser man wird.',
      'Je mehr übt man, umso besser wird man.',
      'Je man mehr übt, umso besser wird man.'
    ],
    'correctAnswer': 0,
    'explanation': 'Je ... umso/desto: Im je-Satz Verb am Ende, im umso-Satz Verb an Position 2.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz des schlechten Wetters gingen wir wandern.',
      'Trotz dem schlechten Wetter gingen wir wandern.',
      'Trotz das schlechte Wetter gingen wir wandern.',
      'Trotz den schlechten Wetter gingen wir wandern.'
    ],
    'correctAnswer': 0,
    'explanation': '"Trotz" verlangt den Genitiv: trotz des schlechten Wetters.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der von dem Lehrer korrigiert Aufsatz war sehr gut.',
      'Der von dem Lehrer korrigierte Aufsatz war sehr gut.',
      'Der von dem Lehrer korrigierend Aufsatz war sehr gut.',
      'Der von dem Lehrer korrigierende Aufsatz war sehr gut.'
    ],
    'correctAnswer': 1,
    'explanation': 'Partizip II als Adjektiv mit Endung: korrigierte (der korrigierte Aufsatz).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich mehr Zeit hätte, lerne ich Klavier.',
      'Wenn ich mehr Zeit hätte, würde ich Klavier lernen.',
      'Wenn ich mehr Zeit habe, würde ich Klavier lernen.',
      'Wenn ich mehr Zeit hätte, lerne ich Klavier würde.'
    ],
    'correctAnswer': 1,
    'explanation': 'Irrealer Konditionalsatz: hätte (Konjunktiv II) → würde ... lernen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'In Deutschland wird viel Bier getrunken.',
      'In Deutschland wird viel Bier trinken.',
      'In Deutschland werden viel Bier getrunken.',
      'In Deutschland wird viel Bier getrinkt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unpersönliches Passiv: wird + Partizip II (getrunken).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Buch, das ich gelesen habe, war spannend.',
      'Das Buch, dass ich gelesen habe, war spannend.',
      'Das Buch, die ich gelesen habe, war spannend.',
      'Das Buch, den ich gelesen habe, war spannend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Akkusativ neutrum: das (nicht "dass", das ist eine Konjunktion).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ließ sich die Haare schneiden.',
      'Sie ließ sich die Haare geschnitten.',
      'Sie ließ sich die Haare zu schneiden.',
      'Sie ließ sich die Haare schnitt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Lassen" + Infinitiv ohne "zu": sich die Haare schneiden lassen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstatt dass er lernt, spielt er Computer.',
      'Anstatt dass er lernt, er spielt Computer.',
      'Anstatt er lernt, spielt er Computer.',
      'Anstatt dass lernt er, spielt er Computer.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anstatt dass" leitet einen Nebensatz ein (Verb am Ende), dann Hauptsatz mit Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wegen dem Stau kamen wir zu spät.',
      'Wegen des Staus kamen wir zu spät.',
      'Wegen den Stau kamen wir zu spät.',
      'Wegen der Stau kamen wir zu spät.'
    ],
    'correctAnswer': 1,
    'explanation': '"Wegen" verlangt den Genitiv: wegen des Staus.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut singend lief das Kind durch den Park.',
      'Laut gesungen lief das Kind durch den Park.',
      'Laut singen lief das Kind durch den Park.',
      'Laut singende lief das Kind durch den Park.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als adverbiale Bestimmung: singend (gleichzeitige Handlung).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat mir das Buch gestern gegeben.',
      'Er hat mir gestern das Buch gegeben.',
      'Er hat gestern mir das Buch gegeben.',
      'Alle Varianten sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Die Stellung von Dativ- und Akkusativobjekt sowie Zeitangabe ist im Mittelfeld relativ flexibel.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er tat so, als ob er nichts wüsste.',
      'Er tat so, als ob er nichts weiß.',
      'Er tat so, als ob er nichts gewusst.',
      'Er tat so, als ob er nichts wissen würde.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "als ob" steht Konjunktiv II: wüsste.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem muss gelöst werden.',
      'Das Problem muss gelöst wird.',
      'Das Problem muss lösen werden.',
      'Das Problem muss gelöst geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv Infinitiv: muss + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Alles, was er sagte, war gelogen.',
      'Alles, das er sagte, war gelogen.',
      'Alles, dass er sagte, war gelogen.',
      'Alles, welches er sagte, war gelogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "alles", "nichts", "etwas" steht das Relativpronomen "was".',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptet, das Buch gelesen haben.',
      'Er behauptet, das Buch gelesen zu haben.',
      'Er behauptet, das Buch zu gelesen haben.',
      'Er behauptet, das Buch haben gelesen zu.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitiv Perfekt mit "zu": gelesen zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sowohl die Mutter als auch der Vater waren einverstanden.',
      'Sowohl die Mutter und auch der Vater waren einverstanden.',
      'Sowohl die Mutter als der Vater waren einverstanden.',
      'Sowohl die Mutter wie auch der Vater war einverstanden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Korrekte Korrelation: sowohl ... als auch. Plural-Verb bei zwei Subjekten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er erinnert sich an seinem alten Lehrer.',
      'Er erinnert sich an seinen alten Lehrer.',
      'Er erinnert sich an sein alter Lehrer.',
      'Er erinnert sich an seiner alten Lehrer.'
    ],
    'correctAnswer': 1,
    'explanation': '"Sich erinnern an" + Akkusativ: an seinen alten Lehrer.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die gut vorbereiteten Studenten bestanden die Prüfung.',
      'Die gut vorbereitende Studenten bestanden die Prüfung.',
      'Die gut vorbereitet Studenten bestanden die Prüfung.',
      'Die gut vorbereitete Studenten bestanden die Prüfung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv, Plural: vorbereiteten (die vorbereiteten Studenten).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur ist er klug, sondern auch fleißig.',
      'Nicht nur er ist klug, sondern auch fleißig.',
      'Er ist nicht nur klug, sondern auch fleißig.',
      'Er ist klug nicht nur, sondern auch fleißig.'
    ],
    'correctAnswer': 2,
    'explanation': '"Nicht nur ... sondern auch" umrahmt die Adjektive: nicht nur klug, sondern auch fleißig.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Zeitung berichtet, der Minister habe seinen Rücktritt erklärt.',
      'Die Zeitung berichtet, der Minister hat seinen Rücktritt erklärt.',
      'Die Zeitung berichtet, der Minister hätte seinen Rücktritt erklärt.',
      'Die Zeitung berichtet, der Minister hatte seinen Rücktritt erklärt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede in Zeitungsberichten: Konjunktiv I (habe).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Brief wurde gestern geschrieben worden.',
      'Der Brief ist gestern geschrieben worden.',
      'Der Brief wurde gestern geschrieben geworden.',
      'Der Brief hat gestern geschrieben worden.'
    ],
    'correctAnswer': 1,
    'explanation': 'Perfekt Passiv: ist + Partizip II + worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Frau, mit dem ich gesprochen habe, ist Ärztin.',
      'Die Frau, mit der ich gesprochen habe, ist Ärztin.',
      'Die Frau, mit die ich gesprochen habe, ist Ärztin.',
      'Die Frau, mit den ich gesprochen habe, ist Ärztin.'
    ],
    'correctAnswer': 1,
    'explanation': 'Relativpronomen nach Präposition "mit" (Dativ), feminin: der.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er braucht heute nicht zu arbeiten.',
      'Er braucht heute nicht arbeiten.',
      'Er braucht heute nicht arbeiten zu.',
      'Er braucht heute zu nicht arbeiten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Brauchen" + "nicht" + "zu" + Infinitiv: braucht nicht zu arbeiten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seitdem er umgezogen ist, sehen wir uns selten.',
      'Seitdem er ist umgezogen, sehen wir uns selten.',
      'Seitdem er umgezogen ist, wir sehen uns selten.',
      'Seitdem ist er umgezogen, sehen wir uns selten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Seitdem" leitet einen Nebensatz ein (Verb am Ende). Im Hauptsatz dann Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während des Unterrichts darf man nicht telefonieren.',
      'Während dem Unterricht darf man nicht telefonieren.',
      'Während den Unterricht darf man nicht telefonieren.',
      'Während der Unterricht darf man nicht telefonieren.'
    ],
    'correctAnswer': 0,
    'explanation': '"Während" als Präposition verlangt den Genitiv: während des Unterrichts.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Von der Reise zurückgekehrt, packte er sofort seinen Koffer aus.',
      'Von der Reise zurückkehrend, packte er sofort seinen Koffer aus.',
      'Von der Reise zurückgekommen, packte er sofort seinen Koffer aus.',
      'Von der Reise zurückkehrt, packte er sofort seinen Koffer aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizipialgruppe mit Partizip II (vorzeitig, abgeschlossen): zurückgekehrt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hier darf nicht rauchen.',
      'Hier darf nicht geraucht werden.',
      'Hier darf nicht geraucht wird.',
      'Hier darf nicht geraucht geworden.'
    ],
    'correctAnswer': 1,
    'explanation': 'Modalverb + Passiv: darf + Partizip II + werden: darf nicht geraucht werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Lehrer, dem die Schüler vertrauen, ist beliebt.',
      'Der Lehrer, den die Schüler vertrauen, ist beliebt.',
      'Der Lehrer, der die Schüler vertrauen, ist beliebt.',
      'Der Lehrer, dessen die Schüler vertrauen, ist beliebt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vertrauen" + Dativ: dem (Dativ maskulin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Kind ist gestern im See geschwommen.',
      'Das Kind hat gestern im See geschwommen.',
      'Das Kind ist gestern im See geschwimmt.',
      'Das Kind hat gestern im See geschwimmt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Schwimmen" bildet das Perfekt mit "sein" (Fortbewegung): ist geschwommen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Damit er besser lernt, hat er einen Kurs besucht.',
      'Damit er besser lernt, er hat einen Kurs besucht.',
      'Damit lernt er besser, hat er einen Kurs besucht.',
      'Damit er lernt besser, hat er einen Kurs besucht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Damit" leitet einen Nebensatz ein (Verb am Ende). Im Hauptsatz Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Innerhalb des Gebäudes ist Rauchen verboten.',
      'Innerhalb dem Gebäude ist Rauchen verboten.',
      'Innerhalb den Gebäudes ist Rauchen verboten.',
      'Innerhalb das Gebäude ist Rauchen verboten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Innerhalb" verlangt den Genitiv: innerhalb des Gebäudes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die seit Jahren in Berlin lebende Familie zog um.',
      'Die seit Jahren in Berlin gelebte Familie zog um.',
      'Die seit Jahren in Berlin lebend Familie zog um.',
      'Die seit Jahren in Berlin gelebt Familie zog um.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv (gleichzeitig, aktiv): lebende Familie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nur wenn du fleißig lernst, wirst du die Prüfung bestehen.',
      'Nur wenn du fleißig lernst, du wirst die Prüfung bestehen.',
      'Nur wenn fleißig du lernst, wirst du die Prüfung bestehen.',
      'Nur wenn du lernst fleißig, wirst du die Prüfung bestehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nebensatz mit "wenn" (Verb am Ende), dann Hauptsatz mit Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'An deiner Stelle wurde ich zum Arzt gehen.',
      'An deiner Stelle gehe ich zum Arzt.',
      'An deiner Stelle würde ich zum Arzt gehen.',
      'An deiner Stelle ginge ich zum Arzt.'
    ],
    'correctAnswer': 2,
    'explanation': '"An deiner Stelle" + Konjunktiv II: würde ich ... gehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-147',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzstellung',
    'question': 'Welcher Satz ist korrekt?',
    'options': ['Er hat mich angerufen gestern.', 'Gestern hat er mich angerufen.', 'Gestern er hat mich angerufen.', 'Er hat mich gestern angerufen.'],
    'correctAnswer': 3,
    'explanation': 'Im Hauptsatz steht das Verb auf Position 2, Partizip am Ende.',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-148',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Nebensatzstellung',
    'question': 'Welcher Satz ist korrekt?',
    'options': ['Weil ich bin muede, gehe ich ins Bett.', 'Weil ich muede bin, gehe ich ins Bett.', 'Weil muede ich bin, gehe ich ins Bett.', 'Weil bin ich muede, gehe ich ins Bett.'],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz (weil) steht das Verb am Ende.',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p1-149',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verb + Praeposition',
    'question': 'Welcher Satz ist korrekt?',
    'options': ['Er freut sich auf den Urlaub.', 'Er freut sich fuer den Urlaub.', 'Er freut sich ueber den Urlaub.', 'Er freut sich um den Urlaub.'],
    'correctAnswer': 0,
    'explanation': '\'Sich freuen auf\' + Akk. = Vorfreude auf etwas Zukuenftiges.',
    'tags': ['satzkorrektur']
  }
];

export default questions;
