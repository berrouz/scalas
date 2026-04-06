import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbau-p3-003',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt der Regel TeKaMoLo?',
    'options': [
      'Er gestern hat in Berlin ein Buch gekauft.',
      'Er hat gestern in Berlin ein Buch gekauft.',
      'Er hat gekauft gestern in Berlin ein Buch.',
      'Er hat ein Buch gestern in Berlin gekauft.'
    ],
    'correctAnswer': 1,
    'explanation': 'TeKaMoLo = Temporal, Kausal, Modal, Lokal — die uebliche Reihenfolge der Angaben im Mittelfeld.',
    'grammarRule': 'TeKaMoLo: Temporal -> Kausal -> Modal -> Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-004',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht der trennbare Verbteil (Praefix) im Hauptsatz Praesens?',
    'options': ['auf Position 2', 'am Ende des Satzes', 'vor dem Subjekt', 'auf Position 1'],
    'correctAnswer': 1,
    'explanation': 'Bei trennbaren Verben wandert das Praefix ans Satzende: \'Ich stehe um 7 Uhr auf.\'',
    'exampleSentence': 'Er ruft seine Mutter an.',
    'grammarRule': 'Satzklammer: Verb (Pos. 2) ... Verbzusatz/Partizip/Infinitiv (Satzende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-005',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Nebensatz mit \'wenn\' ist korrekt?',
    'options': [
      'Wenn du hast Zeit, ruf mich an.',
      'Wenn du Zeit hast, ruf mich an.',
      'Wenn hast du Zeit, ruf mich an.',
      'Wenn Zeit du hast, ruf mich an.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Wenn\' leitet einen Nebensatz ein; das Verb steht am Ende.',
    'grammarRule': 'Nebensatz: wenn + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-006',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert im Hauptsatz nach einem vorangestellten Nebensatz?',
    'options': [
      'Normale Wortstellung (Subjekt + Verb)',
      'Inversion (Verb + Subjekt)',
      'Verb am Ende',
      'Kein Verb noetig'
    ],
    'correctAnswer': 1,
    'explanation': 'Der vorangestellte Nebensatz nimmt Pos. 1 ein; das Verb folgt auf Pos. 2, dann das Subjekt.',
    'exampleSentence': 'Wenn du kommst, freue ich mich.',
    'grammarRule': 'Nebensatz (Pos. 1) + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-007',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Wortstellung hat ein Satz mit \'und\' zwischen zwei Hauptsaetzen?',
    'options': [
      'Verb am Ende im zweiten Satz',
      'Inversion im zweiten Satz',
      'Normale Hauptsatz-Stellung in beiden Saetzen',
      'Verb auf Position 1 im zweiten Satz'
    ],
    'correctAnswer': 2,
    'explanation': '\'Und\' ist koordinierend; beide Hauptsaetze behalten ihre normale Wortstellung.',
    'exampleSentence': 'Er liest ein Buch und sie hoert Musik.',
    'grammarRule': 'Koordinierende Konjunktionen: keine Stellungsaenderung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-008',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht die Negation \'kein\' im Satz?',
    'options': [
      'Am Satzende',
      'Vor dem Nomen, das es verneint',
      'Auf Position 1',
      'Nach dem Partizip II'
    ],
    'correctAnswer': 1,
    'explanation': '\'Kein\' steht als Artikelwort direkt vor dem Nomen, das es verneint.',
    'exampleSentence': 'Er hat kein Auto.',
    'grammarRule': 'Negation \'kein\' vor dem Nomen',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-009',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb im Nebensatz ist korrekt?',
    'options': [
      '...weil er muss morgen arbeiten.',
      '...weil er morgen muss arbeiten.',
      '...weil er morgen arbeiten muss.',
      '...weil muss er morgen arbeiten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz: Infinitiv + Modalverb am Ende.',
    'grammarRule': 'Nebensatz + Modalverb: ... + Infinitiv + Modalverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-010',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wie lautet die korrekte Reihenfolge: Temporal (T) und Lokal (L)?',
    'options': [
      'L vor T',
      'T vor L',
      'Beliebig',
      'L und T stehen immer zusammen'
    ],
    'correctAnswer': 1,
    'explanation': 'Nach TeKaMoLo steht Temporal vor Lokal.',
    'exampleSentence': 'Er faehrt morgen nach Hamburg.',
    'grammarRule': 'TeKaMoLo: T(emporal) vor L(okal)',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-011',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'damit\' ist korrekt?',
    'options': [
      'Er spart Geld, damit er kann reisen.',
      'Er spart Geld, damit er reisen kann.',
      'Er spart Geld, damit kann er reisen.',
      'Er spart Geld, damit reisen er kann.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Damit\' leitet Nebensatz ein; Infinitiv + Modalverb am Ende.',
    'grammarRule': 'Nebensatz mit damit: ... + Infinitiv + Modalverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-012',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Position hat das Verb im Imperativ (du-Form)?',
    'options': [
      'Position 2',
      'Position 1',
      'Am Ende',
      'Position 3'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Imperativ steht das Verb auf Position 1.',
    'exampleSentence': 'Lies das Buch!',
    'grammarRule': 'Imperativ: Verb auf Position 1',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'imperativ']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-013',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Relativsatz ist korrekt?',
    'options': [
      'Das Auto, das er hat gekauft, ist rot.',
      'Das Auto, das er gekauft hat, ist rot.',
      'Das Auto, das hat er gekauft, ist rot.',
      'Das Auto, das gekauft er hat, ist rot.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Relativsatz (Nebensatz): Partizip II + Hilfsverb am Ende.',
    'grammarRule': 'Relativsatz + Perfekt: ... + Partizip II + Hilfsverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-014',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht die Praepositionalergaenzung im Satz?',
    'options': [
      'Vor dem finiten Verb',
      'Im Mittelfeld oder am Ende vor dem zweiten Verbteil',
      'Immer auf Position 1',
      'Immer direkt nach dem Subjekt'
    ],
    'correctAnswer': 1,
    'explanation': 'Praepositionalergaenzungen stehen im Mittelfeld, vor dem Partizip/Infinitiv.',
    'exampleSentence': 'Er wartet auf seinen Freund.',
    'grammarRule': 'Praepositionalergaenzung: im Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-015',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'trotzdem\' ist korrekt?',
    'options': [
      'Es regnet. Trotzdem er geht spazieren.',
      'Es regnet. Trotzdem spazieren geht er.',
      'Es regnet. Trotzdem geht er spazieren.',
      'Es regnet. Er trotzdem geht spazieren.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Trotzdem\' im Vorfeld erfordert Inversion: trotzdem + Verb + Subjekt.',
    'grammarRule': 'Konjunktionaladverb trotzdem: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-016',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher indirekte Fragesatz ist korrekt?',
    'options': [
      'Kannst du mir sagen, wie heisst du?',
      'Kannst du mir sagen, wie du heisst?',
      'Kannst du mir sagen, du wie heisst?',
      'Kannst du mir sagen, heisst wie du?'
    ],
    'correctAnswer': 1,
    'explanation': 'Indirekte Fragen sind Nebensaetze: W-Wort + ... + Verb (Ende).',
    'grammarRule': 'Indirekter Fragesatz: W-Wort + Subjekt + ... + Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-017',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'sich\' im Nebensatz?',
    'options': [
      'Am Ende',
      'Direkt nach der Konjunktion',
      'Nach dem Subjekt',
      'Vor der Konjunktion'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nebensatz steht das Reflexivpronomen nach dem Subjekt.',
    'exampleSentence': '...weil er sich auf den Urlaub freut.',
    'grammarRule': 'Nebensatz + Reflexiv: Konjunktion + Subjekt + sich + ...',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'reflexiv']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-018',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung mit \'nie\'?',
    'options': [
      'Nie er geht ins Theater.',
      'Er nie geht ins Theater.',
      'Er geht nie ins Theater.',
      'Er geht ins Theater nie.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Nie\' als Frequenzadverb steht im Mittelfeld nach dem Verb.',
    'grammarRule': 'Frequenzadverb \'nie\': im Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-019',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'ob\' ist korrekt?',
    'options': [
      'Er fragt, ob sie kommt morgen.',
      'Er fragt, ob kommt sie morgen.',
      'Er fragt, ob sie morgen kommt.',
      'Er fragt, ob morgen sie kommt.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Ob\' leitet indirekten Fragesatz ein; Verb am Ende.',
    'grammarRule': 'Indirekter Fragesatz mit ob: ob + Subjekt + ... + Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-020',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt richtige Passiv-Satzklammer?',
    'options': [
      'Der Brief wurde geschrieben gestern.',
      'Der Brief wurde gestern geschrieben.',
      'Der Brief gestern wurde geschrieben.',
      'Geschrieben wurde der Brief gestern.'
    ],
    'correctAnswer': 1,
    'explanation': 'Passiv: \'wurde\' (Pos. 2) + Mittelfeld + Partizip II (Ende).',
    'grammarRule': 'Passiv-Satzklammer: wurde (Pos. 2) + ... + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-021',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Angabe steht nach TeKaMoLo an letzter Stelle?',
    'options': [
      'Temporal',
      'Kausal',
      'Modal',
      'Lokal'
    ],
    'correctAnswer': 3,
    'explanation': 'Lokal (Wo?/Wohin?) steht in TeKaMoLo an letzter Stelle.',
    'grammarRule': 'TeKaMoLo: Lokal steht am Ende der Angaben-Kette',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-022',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt richtige Wortstellung mit \'dass\' und Modalverb?',
    'options': [
      'Ich glaube, dass er kann morgen kommen.',
      'Ich glaube, dass er morgen kommen kann.',
      'Ich glaube, dass kann er morgen kommen.',
      'Ich glaube, dass er morgen kann kommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Im dass-Nebensatz: Infinitiv + Modalverb am Ende.',
    'grammarRule': 'Nebensatz + Modalverb: ... + Infinitiv + Modalverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-023',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist die korrekte Stellung bei \'nicht nur ... sondern auch\'?',
    'options': [
      'Beide Teile erfordern Nebensatz-Stellung.',
      'Die Teile verbinden parallele Satzglieder.',
      'Das Verb faellt im zweiten Teil weg.',
      'Inversion in beiden Teilen.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nicht nur ... sondern auch\' verbindet gleichrangige Satzglieder oder Saetze.',
    'exampleSentence': 'Er spricht nicht nur Deutsch, sondern auch Englisch.',
    'grammarRule': 'Nicht nur ... sondern auch: parallele Struktur',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-024',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'um ... zu\' ist korrekt?',
    'options': [
      'Er geht in die Bibliothek, um zu lernen Deutsch.',
      'Er geht in die Bibliothek, um Deutsch zu lernen.',
      'Er geht in die Bibliothek, um Deutsch lernen zu.',
      'Er geht in die Bibliothek, zu um Deutsch lernen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz: um + Objekt + zu + Infinitiv (Ende).',
    'grammarRule': 'Infinitivsatz mit um...zu: um + ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-025',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'vielleicht\' typischerweise im Hauptsatz?',
    'options': [
      'Nur am Satzende',
      'Im Vorfeld oder im Mittelfeld',
      'Nur nach dem Partizip II',
      'Immer vor dem Subjekt'
    ],
    'correctAnswer': 1,
    'explanation': '\'Vielleicht\' kann im Vorfeld stehen (mit Inversion) oder im Mittelfeld.',
    'exampleSentence': 'Vielleicht kommt er morgen. / Er kommt vielleicht morgen.',
    'grammarRule': 'Satzadverbien: Vorfeld (Inversion) oder Mittelfeld',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-026',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'so dass\' ist korrekt?',
    'options': [
      'Er war muede, so dass er schlief sofort ein.',
      'Er war muede, so dass er sofort einschlief.',
      'Er war muede, so dass sofort er einschlief.',
      'Er war muede, so dass einschlief er sofort.'
    ],
    'correctAnswer': 1,
    'explanation': '\'So dass\' leitet einen Nebensatz ein; Verb am Ende. Trennbares Verb zusammen am Ende.',
    'grammarRule': 'Nebensatz mit so dass: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-027',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung mit Dativ-Pronomen und Akkusativ-Nomen?',
    'options': [
      'Er gibt seiner Mutter es.',
      'Er gibt es seiner Mutter.',
      'Er es gibt seiner Mutter.',
      'Er seiner Mutter es gibt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Akkusativ-Pronomen vor Dativ-Nomen: \'Er gibt es seiner Mutter.\'',
    'grammarRule': 'Pronomen-Akk. vor Nomen-Dativ',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'objektstellung']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-028',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Inversion nach \'deshalb\'?',
    'options': [
      'Er hat Hunger. Deshalb er geht in die Mensa.',
      'Er hat Hunger. Deshalb geht er in die Mensa.',
      'Er hat Hunger. Deshalb in die Mensa geht er.',
      'Er hat Hunger. Er deshalb geht in die Mensa.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Deshalb\' im Vorfeld: Inversion (Verb + Subjekt).',
    'grammarRule': 'Konjunktionaladverb deshalb: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-029',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'nachdem\' ist korrekt?',
    'options': [
      'Nachdem er hat aufgeraeumt, ging er schlafen.',
      'Nachdem er aufgeraeumt hat, ging er schlafen.',
      'Nachdem hat er aufgeraeumt, ging er schlafen.',
      'Nachdem aufgeraeumt er hat, ging er schlafen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Nachdem-Nebensatz: Partizip + Hilfsverb am Ende.',
    'grammarRule': 'Nebensatz mit nachdem: ... + Partizip II + Hilfsverb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-030',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Praepositionaladverb \'darauf\' ist korrekt?',
    'options': [
      'Er freut darauf sich.',
      'Er sich freut darauf.',
      'Er freut sich darauf.',
      'Darauf er sich freut.'
    ],
    'correctAnswer': 2,
    'explanation': 'Praepositionalobjekte (darauf, dafuer, ...) stehen im Mittelfeld oder am Ende.',
    'grammarRule': 'Praepositionaladverb: nach dem Reflexivpronomen',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-032',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was steht im Nachfeld eines Satzes?',
    'options': [
      'Das Subjekt',
      'Das finite Verb',
      'Vergleiche mit \'als/wie\' oder Nebensaetze',
      'Die Negation'
    ],
    'correctAnswer': 2,
    'explanation': 'Im Nachfeld stehen Vergleiche, Nebensaetze oder lange Praepositionalphrasen.',
    'exampleSentence': 'Er laeuft schneller als sein Bruder.',
    'grammarRule': 'Nachfeld: Vergleiche, Nebensaetze, Appositionen',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-033',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'anstatt ... zu\' ist korrekt?',
    'options': [
      'Anstatt zu lernen, er sieht fern.',
      'Anstatt zu lernen, sieht er fern.',
      'Anstatt lernen zu, sieht er fern.',
      'Anstatt er zu lernen, sieht fern.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz mit anstatt ... zu im Vorfeld; Hauptsatz mit Inversion.',
    'grammarRule': 'Anstatt zu + Infinitiv (Vorfeld) + Hauptsatz mit Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-034',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Plusquamperfekt hat die richtige Satzklammer?',
    'options': [
      'Er hatte das Buch schon gelesen.',
      'Er hatte gelesen das Buch schon.',
      'Er das Buch hatte schon gelesen.',
      'Er hatte schon das Buch gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Plusquamperfekt: \'hatte\' (Pos. 2) + Mittelfeld + Partizip II (Ende).',
    'grammarRule': 'Plusquamperfekt-Satzklammer: hatte/war (Pos. 2) + ... + Partizip II (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-035',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welche Konjunktion erfordert Verbendstellung?',
    'options': [
      'aber',
      'denn',
      'oder',
      'falls'
    ],
    'correctAnswer': 3,
    'explanation': '\'Falls\' ist eine subordinierende Konjunktion und erfordert Verbendstellung.',
    'exampleSentence': 'Falls du Zeit hast, ruf mich an.',
    'grammarRule': 'Subordinierende Konjunktionen: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-036',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'waehrend\' ist korrekt?',
    'options': [
      'Waehrend er lernt, sie kocht.',
      'Waehrend er lernt, kocht sie.',
      'Waehrend lernt er, kocht sie.',
      'Waehrend er lernt, sie sie kocht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Waehrend-Nebensatz + Hauptsatz mit Inversion.',
    'grammarRule': 'Waehrend-Nebensatz (Verb am Ende) + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-037',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wie werden Hauptsaetze mit \'denn\' verbunden?',
    'options': [
      'Verb am Ende im zweiten Satz',
      'Inversion im zweiten Satz',
      'Normale Hauptsatz-Wortstellung bleibt',
      'Verb faellt weg'
    ],
    'correctAnswer': 2,
    'explanation': '\'Denn\' ist koordinierend; der Hauptsatz danach hat normale Wortstellung.',
    'exampleSentence': 'Er bleibt zu Hause, denn es regnet.',
    'grammarRule': 'Denn: koordinierend, keine Stellungsaenderung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-038',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'ohne ... zu\' ist korrekt?',
    'options': [
      'Er ging weg, ohne zu sagen ein Wort.',
      'Er ging weg, ohne ein Wort zu sagen.',
      'Er ging weg, ohne ein Wort sagen zu.',
      'Er ging weg, zu ohne ein Wort sagen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Infinitivsatz mit ohne...zu: ohne + Objekt + zu + Infinitiv.',
    'grammarRule': 'Infinitivsatz mit ohne...zu: ohne + ... + zu + Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-039',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Wo steht \'auch\' bei Inversion?',
    'options': [
      'Vor dem Verb',
      'Am Satzende',
      'Nach dem Subjekt im Mittelfeld',
      'Vor der Konjunktion'
    ],
    'correctAnswer': 2,
    'explanation': '\'Auch\' steht typisch im Mittelfeld, nach dem Subjekt.',
    'exampleSentence': 'Gestern hat er auch ein Geschenk bekommen.',
    'grammarRule': '\'Auch\': im Mittelfeld nach dem Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-040',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was passiert mit \'doch\' im Vorfeld?',
    'options': [
      'Verb am Ende',
      'Keine Aenderung der Wortstellung',
      'Inversion (Verb auf Pos. 2, Subjekt auf Pos. 3)',
      'Das Verb faellt weg'
    ],
    'correctAnswer': 2,
    'explanation': '\'Doch\' als Konjunktionaladverb im Vorfeld erfordert Inversion.',
    'exampleSentence': 'Er hat wenig Zeit. Doch hilft er gern.',
    'grammarRule': 'Doch (Konjunktionaladverb): Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-042',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Wortstellung mit zwei Nebensaetzen?',
    'options': [
      'Er sagt, dass er kommt, wenn er Zeit hat.',
      'Er sagt, dass er kommt, wenn er hat Zeit.',
      'Er sagt, dass kommt er, wenn er Zeit hat.',
      'Er sagt, wenn er Zeit hat, dass er kommt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Beide Nebensaetze haben Verbendstellung.',
    'grammarRule': 'Verschachtelte Nebensaetze: jeweils Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-043',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'solange\' ist korrekt?',
    'options': [
      'Solange es ist hell, spielen die Kinder draussen.',
      'Solange es hell ist, spielen die Kinder draussen.',
      'Solange hell es ist, spielen die Kinder draussen.',
      'Solange ist es hell, spielen die Kinder draussen.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Solange\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit solange: solange + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-044',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Inversion nach Praepositionalphrase ist korrekt?',
    'options': [
      'Auf dem Tisch das Buch liegt.',
      'Auf dem Tisch liegt das Buch.',
      'Liegt auf dem Tisch das Buch.',
      'Das Buch auf dem Tisch liegt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Praepositionalphrase im Vorfeld: Inversion (Verb + Subjekt).',
    'grammarRule': 'Praepositionalphrase (Vorfeld) + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-045',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Was ist die Satzklammer im Satz \'Er will morgen nach Berlin fahren\'?',
    'options': [
      'Er ... fahren',
      'will ... fahren',
      'morgen ... Berlin',
      'Er ... Berlin'
    ],
    'correctAnswer': 1,
    'explanation': 'Die Satzklammer besteht aus \'will\' (Pos. 2) und \'fahren\' (Ende).',
    'grammarRule': 'Satzklammer: finites Verb + ... + infiniter Verbteil',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-046',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'je ... desto\' ist korrekt?',
    'options': [
      'Je mehr er lernt, desto besser er wird.',
      'Je mehr er lernt, desto er wird besser.',
      'Je mehr er lernt, desto wird er besser.',
      'Je er mehr lernt, desto besser wird er.'
    ],
    'correctAnswer': 2,
    'explanation': 'Je-Satz: Verb am Ende (Nebensatz). Desto-Satz: Inversion (Verb auf Pos. 2).',
    'grammarRule': 'Je + ... + Verb (Ende), desto + Komparativ + Verb + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-048',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Vergleich im Nachfeld ist korrekt?',
    'options': [
      'Er ist als ich groesser.',
      'Er ist groesser als ich.',
      'Groesser er ist als ich.',
      'Als ich er ist groesser.'
    ],
    'correctAnswer': 1,
    'explanation': 'Der Vergleich mit \'als\' steht im Nachfeld nach dem Adjektiv.',
    'grammarRule': 'Vergleich: Adjektiv + als/wie + Vergleichselement (Nachfeld)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-049',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'sobald\' hat die richtige Wortstellung?',
    'options': [
      'Sobald er kommt an, rufe ich dich an.',
      'Sobald er ankommt, rufe ich dich an.',
      'Sobald kommt er an, rufe ich dich an.',
      'Sobald an er kommt, rufe ich dich an.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Sobald\' leitet Nebensatz ein; trennbares Verb zusammen am Ende.',
    'grammarRule': 'Nebensatz mit sobald: trennbares Verb zusammen am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-050',
    'level': 'b1',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt die korrekte Position von \'gerade\' (temporal)?',
    'options': [
      'Gerade er isst.',
      'Er gerade isst.',
      'Er isst gerade.',
      'Isst er gerade.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Gerade\' als Temporaladverb steht im Mittelfeld oder am Satzende.',
    'exampleSentence': 'Er isst gerade.',
    'grammarRule': '\'Gerade\': im Mittelfeld oder am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-148',
    'level': 'b1',
    'category': 'Satzbau',
    'subcategory': 'Inversion',
    'question': 'Was passiert mit der Wortstellung bei \'Gestern ...\'?',
    'options': ['Verb auf Position 3', 'Inversion: Gestern + Verb + Subjekt', 'Keine Aenderung', 'Verb am Ende'],
    'correctAnswer': 1,
    'explanation': 'Nach einem Adverb auf Position 1 folgt Inversion: Verb auf Position 2.',
    'tags': ['satzbau']
  },
  {
    'language': 'german', 'id': 'b1-satzbau-p3-149',
    'level': 'b1',
    'category': 'Satzbau',
    'subcategory': 'Satzklammer',
    'question': 'Wo steht das Partizip II im Perfekt? \'Er hat das Buch ___.\'',
    'options': ['am Anfang', 'auf Position 2', 'am Ende', 'nach dem Subjekt'],
    'correctAnswer': 2,
    'explanation': 'Das Partizip II steht im Hauptsatz am Satzende (Satzklammer).',
    'tags': ['satzbau']
  }
];

export default questions;
