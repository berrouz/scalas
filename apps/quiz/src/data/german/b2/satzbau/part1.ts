import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzbau-p1-003',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt der Regel TeKaMoLo?',
    'options': [
      'Er hat gestern in Berlin ein Buch gekauft.',
      'Er hat ein Buch gestern in Berlin gekauft.',
      'Er hat gekauft gestern in Berlin ein Buch.',
      'Er gestern hat in Berlin ein Buch gekauft.'
    ],
    'correctAnswer': 0,
    'explanation': 'TeKaMoLo = Temporal, Kausal, Modal, Lokal.',
    'grammarRule': 'TeKaMoLo: Temporal -> Kausal -> Modal -> Lokal',
    'subcategory': 'TeKaMoLo',
    'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-004',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht der trennbare Verbteil im Hauptsatz Praesens?',
    'options': ['am Ende des Satzes', 'auf Position 1', 'vor dem Subjekt', 'auf Position 2'],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben wandert das Praefix ans Satzende.',
    'exampleSentence': 'Er ruft seine Mutter an.',
    'grammarRule': 'Satzklammer: Verb (Pos. 2) ... Verbzusatz (Satzende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-005',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit erweitertem Partizip I (Partizipialattribut) ist korrekt?',
    'options': [
      'Die schnell laufende Frau gewann das Rennen.',
      'Die Frau schnell laufende gewann das Rennen.',
      'Die laufende schnell Frau gewann das Rennen.',
      'Schnell die laufende Frau gewann das Rennen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizipialattribut: Erweiterung + Partizip I + Nomen.',
    'grammarRule': 'Partizipialattribut: Erweiterung + Partizip + Nomen',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'partizipialattribut']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-006',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Ausklammerung (Nachfeld)?',
    'options': [
      'Er hat mehr als erwartet geleistet.',
      'Er hat geleistet mehr als erwartet.',
      'Er hat mehr geleistet als erwartet.',
      'Mehr als erwartet er hat geleistet.'
    ],
    'correctAnswer': 2,
    'explanation': 'Vergleiche mit \'als\' werden oft ins Nachfeld ausgeklammert.',
    'grammarRule': 'Ausklammerung: Vergleich ins Nachfeld',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-007',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit doppeltem Nebensatz ist korrekt?',
    'options': [
      'Er sagte, dass er komme, wenn er Zeit habe.',
      'Er sagte, dass er komme, wenn er habe Zeit.',
      'Er sagte, dass komme er, wenn er Zeit habe.',
      'Er sagte, wenn er Zeit habe, dass er komme.'
    ],
    'correctAnswer': 0,
    'explanation': 'Verschachtelte Nebensaetze: jeweils Verb am Ende.',
    'grammarRule': 'Verschachtelte Nebensaetze: Verb am Ende in jedem Nebensatz',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-008',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung bei Ersatzinfinitiv im Nebensatz?',
    'options': [
      '...weil er hat kommen muessen.',
      '...weil er kommen muessen hat.',
      '...weil er hat muessen kommen.',
      '...weil er kommen hat muessen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Ersatzinfinitiv im Nebensatz: Infinitiv + Modalverb-Infinitiv + Hilfsverb am Ende.',
    'grammarRule': 'Ersatzinfinitiv im Nebensatz: ... + Inf. + Modal-Inf. + hat/ist',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'ersatzinfinitiv']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-009',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist eine Linksversetzung?',
    'options': [
      'Ein Element steht vor dem Vorfeld und wird durch ein Pronomen wiederaufgenommen.',
      'Das Verb steht auf Position 1.',
      'Ein Nebensatz steht am Anfang.',
      'Das Objekt steht vor dem Subjekt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Linksversetzung: Ein Thema wird vor das Vorfeld gestellt und im Satz pronominal aufgenommen.',
    'exampleSentence': 'Der Peter, der kommt immer zu spaet.',
    'grammarRule': 'Linksversetzung: Element + Pronomen-Wiederaufnahme im Hauptsatz',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'linksversetzung']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-010',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'je ... desto\' ist korrekt?',
    'options': [
      'Je mehr man uebt, desto besser wird man.',
      'Je man mehr uebt, desto besser wird man.',
      'Je mehr man uebt, desto man besser wird.',
      'Je mehr uebt man, desto besser wird man.'
    ],
    'correctAnswer': 0,
    'explanation': 'Je-Satz (Nebensatz, Verb am Ende) + desto + Komparativ + Verb + Subjekt.',
    'grammarRule': 'Je + ... + Verb (Ende), desto + Komparativ + Verb + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-011',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv im Nebensatz (Perfekt) ist korrekt?',
    'options': [
      '...weil das Haus renoviert worden ist.',
      '...weil das Haus ist renoviert worden.',
      '...weil das Haus worden renoviert ist.',
      '...weil renoviert das Haus worden ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nebensatz + Passiv Perfekt: Partizip II + worden + ist am Ende.',
    'grammarRule': 'Nebensatz + Passiv Perfekt: ... + Partizip II + worden + ist/hat',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-012',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist eine Rechtsversetzung?',
    'options': [
      'Das Verb wird ans Ende verschoben.',
      'Ein pronominales Element im Satz wird durch eine NP im Nachfeld praezisiert.',
      'Der Nebensatz steht rechts vom Hauptsatz.',
      'Das Subjekt steht am Satzende.'
    ],
    'correctAnswer': 1,
    'explanation': 'Rechtsversetzung: Ein Pronomen im Satz wird im Nachfeld durch eine NP erklaert.',
    'exampleSentence': 'Er kommt immer zu spaet, der Peter.',
    'grammarRule': 'Rechtsversetzung: Pronomen im Satz + NP im Nachfeld',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'rechtsversetzung']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-013',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Konjunktiv II Plusquamperfekt hat die richtige Satzklammer?',
    'options': [
      'Er haette das Buch gern gelesen.',
      'Er haette gelesen das Buch gern.',
      'Er das Buch gern haette gelesen.',
      'Er gern haette das Buch gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: haette (Pos. 2) + Mittelfeld + Partizip II (Ende).',
    'grammarRule': 'Konjunktiv II Plusquamperfekt: haette (Pos. 2) + ... + Partizip II',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-014',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Verbletztstellung im uneingeleiteten Konditionalsatz ist korrekt?',
    'options': [
      'Haette ich Zeit, wuerde ich kommen.',
      'Ich haette Zeit, wuerde ich kommen.',
      'Zeit haette ich, wuerde ich kommen.',
      'Haette Zeit ich, wuerde ich kommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Uneingeleiteter Konditionalsatz: Verb auf Pos. 1 (Verberststellung).',
    'grammarRule': 'Uneingeleiteter Konditionalsatz: Verb (Pos. 1) + Subjekt + ...',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konditionalsatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-015',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was steht typischerweise im Vorfeld eines Satzes mit Themawechsel?',
    'options': [
      'Immer das Subjekt',
      'Ein neues Thema oder ein kontrastives Element',
      'Immer ein Adverb',
      'Immer ein Objekt'
    ],
    'correctAnswer': 1,
    'explanation': 'Im Vorfeld steht oft das Thema oder ein kontrastives Element fuer Fokussierung.',
    'grammarRule': 'Vorfeld: Thema/Fokus-Element fuer Informationsstruktur',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-016',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'kaum ... als/da\' ist korrekt?',
    'options': [
      'Kaum hatte er angefangen, da klingelte das Telefon.',
      'Kaum er hatte angefangen, da klingelte das Telefon.',
      'Kaum hatte angefangen er, da klingelte das Telefon.',
      'Kaum angefangen hatte er, da klingelte das Telefon.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaum\'-Satz mit Inversion: kaum + Hilfsverb + Subjekt + ... + Partizip.',
    'grammarRule': 'Kaum + Verb (Pos. 1) + Subjekt + ..., da/als + Hauptsatz',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-017',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Apposition im Nachfeld ist korrekt?',
    'options': [
      'Berlin, die Hauptstadt Deutschlands, ist eine Grossstadt.',
      'Berlin ist eine Grossstadt, die Hauptstadt Deutschlands.',
      'Die Hauptstadt Deutschlands Berlin ist eine Grossstadt.',
      'Berlin die Hauptstadt Deutschlands, ist eine Grossstadt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Appositionen stehen direkt nach dem Bezugswort, eingeschlossen in Kommas.',
    'grammarRule': 'Apposition: nach dem Bezugswort, durch Kommas getrennt',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'apposition']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-018',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'nicht nur ... sondern auch\' zeigt korrekte Inversion?',
    'options': [
      'Nicht nur spricht er Deutsch, sondern auch Englisch.',
      'Nicht nur er spricht Deutsch, sondern auch Englisch.',
      'Nicht nur Deutsch spricht er, sondern auch Englisch.',
      'Er spricht nicht nur Deutsch, sondern auch Englisch.'
    ],
    'correctAnswer': 3,
    'explanation': '\'Nicht nur ... sondern auch\' verbindet parallele Satzglieder. Typisch im Mittelfeld.',
    'grammarRule': 'Nicht nur ... sondern auch: parallele Elemente',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-019',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist eine Ausklammerung?',
    'options': [
      'Das Verb wird ausgelassen.',
      'Ein Satzglied wird aus der Satzklammer ins Nachfeld verschoben.',
      'Das Subjekt wird ausgelassen.',
      'Der Nebensatz wird vorangestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Ausklammerung: Ein langes oder schweres Satzglied wird ins Nachfeld gestellt.',
    'exampleSentence': 'Er hat sich gefreut ueber das unerwartete Geschenk.',
    'grammarRule': 'Ausklammerung: schweres Element ins Nachfeld',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-021',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit weiterführendem Relativsatz ist korrekt?',
    'options': [
      'Er bestand die Pruefung, was ihn sehr freute.',
      'Er bestand die Pruefung, was sehr freute ihn.',
      'Er bestand die Pruefung, was ihn freute sehr.',
      'Was ihn sehr freute, er bestand die Pruefung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Weiterfuehrender Relativsatz mit \'was\': bezieht sich auf den ganzen Satz.',
    'grammarRule': 'Weiterfuehrender Relativsatz: Hauptsatz + , was + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-022',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Korrelat \'es\' bei einem Subjektsatz?',
    'options': [
      'Im Nachfeld',
      'Im Vorfeld als Platzhalter fuer den Subjektsatz',
      'Am Satzende',
      'Vor dem Subjektsatz'
    ],
    'correctAnswer': 1,
    'explanation': '\'Es\' steht als Korrelat im Vorfeld: \'Es ist wichtig, dass ...\'',
    'exampleSentence': 'Es ist wichtig, dass du puenktlich kommst.',
    'grammarRule': 'Korrelat \'es\' im Vorfeld fuer Subjektsatz im Nachfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-023',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'als ob\' ist korrekt?',
    'options': [
      'Er tut, als ob er alles wuesste.',
      'Er tut, als ob er wuesste alles.',
      'Er tut, als ob wuesste er alles.',
      'Er tut, als ob alles er wuesste.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als ob\' leitet irrealen Vergleichssatz ein; Verb (Konjunktiv II) am Ende.',
    'grammarRule': 'Als ob + Subjekt + ... + Verb (Konjunktiv II am Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-024',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Fokuspartikel \'sogar\' ist korrekt?',
    'options': [
      'Er hat sogar den schwierigsten Test bestanden.',
      'Sogar er hat bestanden den schwierigsten Test.',
      'Er hat den schwierigsten Test sogar bestanden.',
      'Er sogar hat den schwierigsten Test bestanden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sogar\' steht vor dem Element, das es hervorhebt.',
    'grammarRule': 'Fokuspartikel \'sogar\': vor dem fokussierten Element',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-025',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'zumal\' ist korrekt?',
    'options': [
      'Er blieb zu Hause, zumal er krank war.',
      'Er blieb zu Hause, zumal er war krank.',
      'Er blieb zu Hause, zumal war er krank.',
      'Er blieb zu Hause, zumal krank er war.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Zumal\' leitet einen Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Nebensatz mit zumal: zumal + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-026',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'anstatt dass\' ist korrekt?',
    'options': [
      'Anstatt dass er lernt, er spielt Videospiele.',
      'Anstatt dass er lernt, spielt er Videospiele.',
      'Anstatt dass lernt er, spielt er Videospiele.',
      'Anstatt dass er lernt, Videospiele spielt er.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Anstatt dass\'-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'grammarRule': 'Anstatt dass + Nebensatz + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-027',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist ein Korrelat im deutschen Satz?',
    'options': [
      'Ein Pronomen, das ein Element im Nachfeld ankuendigt',
      'Ein zweites Verb im Satz',
      'Eine Konjunktion',
      'Ein Relativpronomen'
    ],
    'correctAnswer': 0,
    'explanation': 'Ein Korrelat (es, das, darauf, ...) kuendigt einen Nebensatz oder Infinitivsatz an.',
    'exampleSentence': 'Er freut sich darauf, dass sie kommt.',
    'grammarRule': 'Korrelat: Platzhalter im Hauptsatz fuer Nebensatz/Infinitivsatz',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-028',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizip II als Attribut ist korrekt?',
    'options': [
      'Das Buch gelesen von vielen Leuten ist interessant.',
      'Das von vielen Leuten gelesene Buch ist interessant.',
      'Das gelesene von vielen Leuten Buch ist interessant.',
      'Von vielen Leuten das gelesene Buch ist interessant.'
    ],
    'correctAnswer': 1,
    'explanation': 'Erweitertes Partizip-II-Attribut: Erweiterung + Partizip II + Nomen.',
    'grammarRule': 'Partizip-II-Attribut: Erweiterung + Partizip II + Nomen',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'partizipialattribut']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-029',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'als\' (ohne \'ob\') fuer irrealen Vergleich ist korrekt?',
    'options': [
      'Er tat, als waere er krank.',
      'Er tat, als er waere krank.',
      'Er tat, als krank waere er.',
      'Er tat, als krank er waere.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als\' ohne \'ob\': Verb (Konjunktiv II) steht direkt nach \'als\' (Verbzweitstellung).',
    'grammarRule': 'Als + Verb (Konjunktiv II) + Subjekt + ... (Verbzweitstellung)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-030',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb im Passiv ist korrekt?',
    'options': [
      'Das Projekt kann bis morgen abgeschlossen werden.',
      'Das Projekt kann abgeschlossen bis morgen werden.',
      'Das Projekt kann werden bis morgen abgeschlossen.',
      'Das Projekt bis morgen kann abgeschlossen werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv + Modalverb: Modalverb (Pos. 2) + Mittelfeld + Partizip II + werden.',
    'grammarRule': 'Passiv + Modalverb: Modal + ... + Partizip II + werden (Ende)',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-031',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist ein uneingeleiteter Nebensatz?',
    'options': [
      'Ein Nebensatz ohne Konjunktion mit Verb auf Position 1',
      'Ein Nebensatz mit \'dass\'',
      'Ein Hauptsatz ohne Verb',
      'Ein Nebensatz mit Inversion'
    ],
    'correctAnswer': 0,
    'explanation': 'Uneingeleitete Nebensaetze haben keine Konjunktion; das Verb steht auf Pos. 1.',
    'exampleSentence': 'Haette ich gewusst, dass ..., waere ich nicht gekommen.',
    'grammarRule': 'Uneingeleiteter Nebensatz: Verb (Pos. 1) statt Konjunktion',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-032',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz als Subjekt ist korrekt?',
    'options': [
      'Deutsch zu lernen macht Spass.',
      'Zu lernen Deutsch macht Spass.',
      'Deutsch lernen zu macht Spass.',
      'Zu Deutsch lernen macht Spass.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz als Subjekt: Objekt + zu + Infinitiv auf Position 1.',
    'grammarRule': 'Infinitivsatz als Subjekt: ... + zu + Infinitiv (im Vorfeld)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-033',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Serialisierung im Mittelfeld (Pronomen + Nomen)?',
    'options': [
      'Er hat gestern dem Lehrer es gegeben.',
      'Er hat es gestern dem Lehrer gegeben.',
      'Er hat dem Lehrer gestern es gegeben.',
      'Er gestern hat es dem Lehrer gegeben.'
    ],
    'correctAnswer': 1,
    'explanation': 'Pronomen (es) vor Angaben (gestern) vor Nomen-Objekt (dem Lehrer).',
    'grammarRule': 'Mittelfeld: Pronomen vor Angaben vor Nomen-Objekten',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-034',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'obgleich\' ist korrekt?',
    'options': [
      'Obgleich er muede war, arbeitete er weiter.',
      'Obgleich er war muede, arbeitete er weiter.',
      'Obgleich war er muede, arbeitete er weiter.',
      'Obgleich muede er war, arbeitete er weiter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Obgleich\' leitet Nebensatz ein (Verb am Ende) + Hauptsatz mit Inversion.',
    'grammarRule': 'Obgleich-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-035',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'es sei denn\' ist korrekt?',
    'options': [
      'Ich komme morgen, es sei denn, es regnet.',
      'Ich komme morgen, es sei denn, regnet es.',
      'Ich komme morgen, es sei denn, es regnet es.',
      'Ich komme morgen, denn es sei, es regnet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Es sei denn\' leitet eine Ausnahme-Bedingung ein; danach Hauptsatz-Stellung.',
    'grammarRule': 'Es sei denn: + Hauptsatz-Stellung (Subjekt + Verb auf Pos. 2)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-036',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'geschweige denn\' ist korrekt?',
    'options': [
      'Er kann nicht laufen, geschweige denn rennen.',
      'Er kann nicht laufen, geschweige denn er rennen kann.',
      'Er kann nicht laufen, geschweige er denn rennen.',
      'Er kann nicht laufen, denn geschweige rennen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Geschweige denn\' verstaerkt die Negation; verbindet parallele Satzglieder.',
    'grammarRule': 'Geschweige denn: paralleles Satzglied (Steigerung der Negation)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-037',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Genitivattribut typischerweise?',
    'options': [
      'Vor dem Nomen (nur bei Namen)',
      'Immer nach dem Nomen',
      'Nach dem Nomen (bei Nicht-Namen) oder vor dem Nomen (bei Namen)',
      'Am Satzende'
    ],
    'correctAnswer': 2,
    'explanation': 'Genitivattribut: nach dem Nomen (das Buch des Lehrers) oder vor (Peters Buch).',
    'grammarRule': 'Genitivattribut: nachgestellt (Standard) oder vorangestellt (Eigennamen)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'genitiv']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-038',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit dreifacher Satzklammer (Passiv + Modalverb + Perfekt) ist korrekt?',
    'options': [
      'Das Haus haette renoviert werden muessen.',
      'Das Haus haette muessen renoviert werden.',
      'Das Haus haette werden renoviert muessen.',
      'Das Haus renoviert haette werden muessen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv + Modalverb + Konjunktiv: haette + Partizip II + werden + muessen.',
    'grammarRule': 'Komplexe Satzklammer: haette + Partizip II + werden + Modalverb-Infinitiv',
    'subcategory': 'Satzklammer',
    'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-039',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wobei\' ist korrekt?',
    'options': [
      'Er arbeitet viel, wobei er auch Sport treibt.',
      'Er arbeitet viel, wobei er treibt auch Sport.',
      'Er arbeitet viel, wobei treibt er auch Sport.',
      'Er arbeitet viel, wobei auch Sport er treibt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wobei\' leitet einen weiterfuehrenden Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Wobei-Nebensatz: wobei + Subjekt + ... + Verb (Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-040',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Topikalisierung des Objekts ist korrekt?',
    'options': [
      'Dieses Buch ich habe schon gelesen.',
      'Dieses Buch habe ich schon gelesen.',
      'Habe dieses Buch ich schon gelesen.',
      'Ich dieses Buch habe schon gelesen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Topikalisierung: Objekt im Vorfeld + Verb (Pos. 2) + Subjekt (Inversion).',
    'grammarRule': 'Topikalisierung: Objekt (Vorfeld) + Verb + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-041',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was ist ein Matrixsatz?',
    'options': [
      'Ein Nebensatz',
      'Der uebergeordnete Hauptsatz, der einen Nebensatz regiert',
      'Ein Relativsatz',
      'Ein Imperativsatz'
    ],
    'correctAnswer': 1,
    'explanation': 'Der Matrixsatz ist der uebergeordnete Satz, von dem ein Nebensatz abhaengt.',
    'grammarRule': 'Matrixsatz: uebergeordneter Satz mit Nebensatz als Ergaenzung',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-042',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'so sehr ... dass\' ist korrekt?',
    'options': [
      'Er hat sich so sehr gefreut, dass er vor Freude weinte.',
      'Er hat sich gefreut so sehr, dass er vor Freude weinte.',
      'So sehr er hat sich gefreut, dass er vor Freude weinte.',
      'Er hat sich so sehr gefreut, dass vor Freude er weinte.'
    ],
    'correctAnswer': 0,
    'explanation': '\'So sehr\' steht im Mittelfeld; \'dass\'-Nebensatz im Nachfeld.',
    'grammarRule': 'So sehr + ... + dass-Nebensatz (Verb am Ende)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-043',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Relativsatz im Genitiv ist korrekt?',
    'options': [
      'Der Mann, dessen Auto gestohlen wurde, rief die Polizei.',
      'Der Mann, dessen wurde Auto gestohlen, rief die Polizei.',
      'Der Mann, dessen Auto wurde gestohlen, rief die Polizei.',
      'Der Mann, Auto dessen gestohlen wurde, rief die Polizei.'
    ],
    'correctAnswer': 0,
    'explanation': 'Genitiv-Relativsatz: dessen + Nomen + ... + Verb (Ende).',
    'grammarRule': 'Relativsatz mit dessen/deren: dessen/deren + Nomen + ... + Verb',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-044',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'insofern als\' ist korrekt?',
    'options': [
      'Das ist richtig, insofern als man es so betrachtet.',
      'Das ist richtig, insofern als man betrachtet es so.',
      'Das ist richtig, insofern als betrachtet man es so.',
      'Das ist richtig, insofern als es so man betrachtet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Insofern als\' leitet Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Insofern als + Nebensatz: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-045',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht die Gradpartikel \'besonders\' typischerweise?',
    'options': [
      'Am Satzende',
      'Vor dem Element, das sie hervorhebt',
      'Immer auf Position 1',
      'Nach dem Partizip II'
    ],
    'correctAnswer': 1,
    'explanation': '\'Besonders\' steht vor dem Satzglied, das es hervorhebt.',
    'exampleSentence': 'Er mag besonders klassische Musik.',
    'grammarRule': 'Gradpartikel: vor dem fokussierten Element',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-046',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung bei nachgestelltem \'allerdings\'?',
    'options': [
      'Er ist allerdings nicht damit einverstanden.',
      'Er allerdings ist nicht damit einverstanden.',
      'Allerdings er ist nicht damit einverstanden.',
      'Er ist nicht damit allerdings einverstanden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Allerdings\' kann im Mittelfeld stehen, nach dem finiten Verb.',
    'grammarRule': '\'Allerdings\': Vorfeld (Inversion) oder Mittelfeld',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-047',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Gerundivkonstruktion (zu + Partizip I) ist korrekt?',
    'options': [
      'Das zu loesende Problem ist komplex.',
      'Das Problem zu loesende ist komplex.',
      'Das loesende zu Problem ist komplex.',
      'Zu das loesende Problem ist komplex.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu + Partizip I als Attribut vor dem Nomen.',
    'grammarRule': 'Gerundiv: zu + Partizip I + Nomen (= das Problem, das geloest werden muss)',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'partizipialattribut']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-048',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'soweit\' ist korrekt?',
    'options': [
      'Soweit ich weiss, kommt er morgen.',
      'Soweit ich weiss, er kommt morgen.',
      'Soweit weiss ich, kommt er morgen.',
      'Soweit ich weiss, morgen kommt er.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Soweit\' leitet Nebensatz ein (Verb am Ende); Hauptsatz mit Inversion.',
    'grammarRule': 'Soweit-Nebensatz + Hauptsatz: Inversion',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-049',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Was passiert bei Ellipse im zweiten Hauptsatz?',
    'options': [
      'Das Verb wird wiederholt.',
      'Gleiche Satzglieder koennen weggelassen werden.',
      'Der zweite Satz wird zum Nebensatz.',
      'Das Subjekt muss wiederholt werden.'
    ],
    'correctAnswer': 1,
    'explanation': 'Bei Ellipse werden wiederholte Satzglieder im zweiten Teilsatz ausgelassen.',
    'exampleSentence': 'Er trinkt Kaffee und sie (trinkt) Tee.',
    'grammarRule': 'Ellipse: gleiche Elemente im zweiten Teilsatz weglassbar',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-050',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wenngleich\' ist korrekt?',
    'options': [
      'Wenngleich er muede war, arbeitete er weiter.',
      'Wenngleich er war muede, arbeitete er weiter.',
      'Wenngleich war er muede, arbeitete er weiter.',
      'Wenngleich muede er war, arbeitete er weiter.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wenngleich\' leitet konzessiven Nebensatz ein; Verb am Ende.',
    'grammarRule': 'Wenngleich-Nebensatz (Verb am Ende) + Hauptsatz (Inversion)',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-051',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Wo steht das Verb im Nebensatz mit \'obschon\'?',
    'options': ['am Ende des Nebensatzes', 'auf Position 2', 'am Anfang', 'vor dem Subjekt'],
    'correctAnswer': 0,
    'explanation': '\'Obschon\' leitet einen konzessiven Nebensatz ein; das konjugierte Verb steht am Ende.',
    'grammarRule': 'Konzessivsatz mit obschon: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-052',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Inversion nach einem Adverb?',
    'options': [
      'Trotzdem konnte er das Problem loesen.',
      'Trotzdem er konnte das Problem loesen.',
      'Trotzdem das Problem konnte er loesen.',
      'Trotzdem loesen konnte er das Problem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Satzadverb \'trotzdem\' auf Position 1 folgt das Verb auf Position 2, dann das Subjekt.',
    'grammarRule': 'Inversion: Adverb (Pos. 1) + Verb (Pos. 2) + Subjekt',
    'subcategory': 'Inversion',
    'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'b2-satzbau-p1-053',
    'level': 'b2',
    'category': 'Satzstruktur',
    'question': 'Welche Wortstellung ist im Relativsatz korrekt?',
    'options': [
      'Das Buch, das ich gestern gekauft habe, ist spannend.',
      'Das Buch, das ich habe gestern gekauft, ist spannend.',
      'Das Buch, das habe ich gestern gekauft, ist spannend.',
      'Das Buch, das gestern ich gekauft habe, ist spannend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Relativsatz steht das konjugierte Verb am Ende: \'das ich gestern gekauft habe\'.',
    'grammarRule': 'Relativsatz: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': ['satzbau', 'relativsatz']
  }
];

export default questions;
