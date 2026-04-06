import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbau-p1-005', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist stilistische Inversion in literarischen Texten?',
    'options': ['Bewusste Umstellung zur Erzeugung rhythmischer/emphatischer Wirkung.', 'Zufaellige Wortstellung.', 'Standardinversion nach Temporalangabe.', 'Auslassung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'In literarischen Texten dient Inversion oft rhythmischen oder emphatischen Zwecken.',
    'grammarRule': 'Stilistische Inversion: rhythmisch/emphatisch', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-006', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt literarische Nachfeldbesetzung mit stilistischem Effekt?',
    'options': ['Er stand da, allein und verlassen, im fahlen Licht des Mondes.', 'Er stand allein und verlassen im fahlen Licht des Mondes da.', 'Er stand da allein und verlassen im fahlen Licht des Mondes.', 'Im fahlen Licht des Mondes er stand da allein und verlassen.'],
    'correctAnswer': 0, 'explanation': 'Doppelte Ausklammerung (Appositiv + PP) erzeugt Spannung und Rhythmus.',
    'grammarRule': 'Literarische Nachfeldbesetzung: Spannung/Rhythmus', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-007', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anakoluth?',
    'options': ['Ein Satzbruch: der Satz wird anders fortgesetzt als begonnen.', 'Ein korrekt gebauter NS.', 'Ein einfacher HS.', 'Eine Wiederholung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Anakoluth: Satzbruch, oft in muendlicher Sprache oder stilistisch eingesetzt.',
    'exampleSentence': 'Der Mann, den ich gestern – also, ich meine, er war wirklich nett.',
    'grammarRule': 'Anakoluth: Satzbruch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-008', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Aposiopese (Satzabbruch als Stilmittel)?',
    'options': ['Wenn du nicht sofort –! (Drohung, Satz bewusst abgebrochen)', 'Wenn du nicht sofort gehst, werde ich boese.', 'Du gehst sofort, oder ich werde boese.', 'Geh sofort!'],
    'correctAnswer': 0, 'explanation': 'Aposiopese: bewusster Satzabbruch, oft fuer Drohung/Emotion.',
    'grammarRule': 'Aposiopese: bewusster Satzabbruch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-009', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Prolepse im gehobenen Stil?',
    'options': ['Ein NS-Element wird in den HS vorgezogen (emphatisch).', 'Das Verb wird verdoppelt.', 'Das Subjekt faellt weg.', 'Der NS wird gestrichen.'],
    'correctAnswer': 0, 'explanation': 'Prolepse: emphatische Vorwegnahme eines NS-Elements im HS.',
    'exampleSentence': 'Diesen Mann glaube ich, dass niemand vergessen wird.',
    'grammarRule': 'Prolepse: NS-Element -> HS (emphatisch)', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-010', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt literarische V1-Stellung (narrativ)?',
    'options': ['Trat ein Fremder durch die Tuer und sprach kein Wort.', 'Ein Fremder trat durch die Tuer und sprach kein Wort.', 'Durch die Tuer trat ein Fremder und sprach kein Wort.', 'Kein Wort sprach der Fremde, der durch die Tuer trat.'],
    'correctAnswer': 0, 'explanation': 'Narrative V1: Verb auf Pos. 1 in Erzaehlungen (literarisch/maerchenhaft).',
    'grammarRule': 'Narrative V1: Verb (Pos. 1) in Erzaehlungen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-011', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist ein Periodenaufbau in wissenschaftlicher Prosa?',
    'options': ['Komplexer Satz mit mehreren NS-Ebenen, der erst am Ende aufgeloest wird.', 'Ein einfacher HS.', 'Nur Parataxe.', 'Satz ohne Verb.'],
    'correctAnswer': 0, 'explanation': 'Periodenaufbau: Protasis (NS-Kette) -> Apodosis (HS-Aufloesung am Ende).',
    'grammarRule': 'Periodenaufbau: NS-Kette -> HS-Aufloesung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-012', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt stilistische Ausklammerung in gehobener Sprache?',
    'options': ['Er hatte sich entschlossen zu einem Schritt von ungeheurer Tragweite.', 'Er hatte sich zu einem Schritt von ungeheurer Tragweite entschlossen.', 'Er hatte entschlossen sich zu einem Schritt von ungeheurer Tragweite.', 'Zu einem Schritt er hatte sich entschlossen von ungeheurer Tragweite.'],
    'correctAnswer': 0, 'explanation': 'Gehobene Ausklammerung: PP mit schwerem Attribut ins Nachfeld.',
    'grammarRule': 'Stilistische Ausklammerung: schwere PP ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-013', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Chiasmus in der Satzstruktur?',
    'options': ['Kreuzstellung von Satzgliedern: A-B / B-A.', 'Wiederholung des Subjekts.', 'Parallelismus.', 'Auslassung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Chiasmus: Kreuzstellung: Die Kunst ist lang, und kurz ist unser Leben.',
    'exampleSentence': 'Die Kunst ist lang, und kurz ist unser Leben.',
    'grammarRule': 'Chiasmus: Kreuzstellung A-B / B-A', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-014', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt stilistischen Parallelismus?',
    'options': ['Er kam, er sah, er siegte.', 'Er kam und nachdem er gesehen hatte, siegte er.', 'Nachdem er gekommen war und gesehen hatte, siegte er.', 'Er siegte, weil er kam und sah.'],
    'correctAnswer': 0, 'explanation': 'Parallelismus: gleicher Satzbau in Folgesaetzen (Subj. + Verb).',
    'grammarRule': 'Parallelismus: gleicher Satzbau wiederholt', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-015', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Hypotaxe?',
    'options': ['Unterordnung: HS + NS (Nebensatzgefuege).', 'Nebenordnung: HS + HS.', 'Satz ohne Verb.', 'Nur einfache Saetze.'],
    'correctAnswer': 0, 'explanation': 'Hypotaxe: Subordination (HS + NS). Gegensatz: Parataxe (Nebenordnung).',
    'grammarRule': 'Hypotaxe: Unterordnung (HS + NS)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-016', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Parataxe?',
    'options': ['Nebenordnung: HS + HS (gleichgestellte Saetze).', 'Unterordnung: HS + NS.', 'Satz ohne Verb.', 'Nur NS.'],
    'correctAnswer': 0, 'explanation': 'Parataxe: Koordination gleichgestellter HS. Gegensatz: Hypotaxe.',
    'grammarRule': 'Parataxe: Nebenordnung (HS + HS)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-017', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Nachfeldbesetzung fuer rhetorischen Effekt?',
    'options': ['Er hat es endlich verstanden, nach all den Jahren des Zweifelns und Zauderns.', 'Er hat es nach all den Jahren des Zweifelns und Zauderns endlich verstanden.', 'Er hat endlich verstanden es nach all den Jahren des Zweifelns und Zauderns.', 'Nach all den Jahren er hat es endlich verstanden des Zweifelns und Zauderns.'],
    'correctAnswer': 0, 'explanation': 'Schwere PP ins Nachfeld: rhetorischer Nachtrag, Spannungsbogen.',
    'grammarRule': 'Rhetorische Nachfeldbesetzung: Nachtrag', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-018', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Asyndeton?',
    'options': ['Reihung ohne Konjunktion.', 'Reihung mit und.', 'Satz ohne Verb.', 'Nur NS.'],
    'correctAnswer': 0, 'explanation': 'Asyndeton: Aufzaehlung ohne Bindewort (Heute, morgen, uebermorgen).',
    'exampleSentence': 'Er kam, sah, siegte.',
    'grammarRule': 'Asyndeton: Reihung ohne Konjunktion', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-019', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Polysyndeton?',
    'options': ['Reihung mit wiederholter Konjunktion.', 'Reihung ohne Konjunktion.', 'Satz ohne Verb.', 'Nur ein NS.'],
    'correctAnswer': 0, 'explanation': 'Polysyndeton: und ... und ... und (Wiederholung der Konjunktion).',
    'exampleSentence': 'Und es regnet und es stuermt und es blitzt.',
    'grammarRule': 'Polysyndeton: wiederholte Konjunktion', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-020', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Ellipse als literarisches Stilmittel?',
    'options': ['Alles verloren. Kein Wort mehr.', 'Alles wurde verloren. Es gab kein Wort mehr.', 'Er hat alles verloren und sagte kein Wort mehr.', 'Nachdem alles verloren war, sagte er kein Wort mehr.'],
    'correctAnswer': 0, 'explanation': 'Literarische Ellipse: bewusste Auslassung fuer Knappheit/Dramatik.',
    'grammarRule': 'Literarische Ellipse: Verknappung fuer Effekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-021', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Tmesis?',
    'options': ['Trennung eines zusammengesetzten Wortes durch eingeschobene Elemente.', 'Zusammensetzung zweier Saetze.', 'Auslassung des Verbs.', 'Verdopplung des Objekts.'],
    'correctAnswer': 0, 'explanation': 'Tmesis: Ein Wort wird getrennt, z.B. trennbare Verben, oder stilistisch: wo ... hinaus.',
    'grammarRule': 'Tmesis: Worttrennung durch Einschub', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-022', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt stilistische V1-Stellung mit expressiver Funktion?',
    'options': ['Haetten wir doch nur auf ihn gehoert!', 'Wir haetten doch nur auf ihn gehoert!', 'Doch haetten wir nur auf ihn gehoert!', 'Auf ihn haetten wir doch nur gehoert!'],
    'correctAnswer': 0, 'explanation': 'V1-Wunschsatz: expressiv, Verb auf Pos. 1 + doch/nur.',
    'grammarRule': 'V1-Wunschsatz: expressiv/emotional', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-023', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Inversion als rhetorisches Mittel?',
    'options': ['Bewusste Umkehrung der Wortstellung fuer Nachdruck.', 'Standardwortstellung.', 'Auslassung des Subjekts.', 'Verdopplung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Rhetorische Inversion: Selten ist solch ein Talent. (statt: Solch ein Talent ist selten.)',
    'grammarRule': 'Rhetorische Inversion: Umkehrung fuer Nachdruck', 'subcategory': 'Inversion', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-024', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Sperrung (Distanzstellung) als Stilmittel?',
    'options': ['Ein so noch nie gesehenes, von allen bewundertes und doch raetselhaftes Phaenomen trat auf.', 'Ein Phaenomen, das so noch nie gesehen, von allen bewundert und doch raetselhaft war, trat auf.', 'Ein Phaenomen trat auf, so noch nie gesehen, von allen bewundert und doch raetselhaft.', 'Trat ein Phaenomen auf, so noch nie gesehen.'],
    'correctAnswer': 0, 'explanation': 'Sperrung: Distanz zwischen Artikel und Nomen durch erweiterte Attribute.',
    'grammarRule': 'Sperrung: erweiterte Attribute zwischen Artikel und Nomen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-025', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Epanalepse in der Satzstruktur?',
    'options': ['Wiederaufnahme eines Wortes/Satzteils am Satzanfang des Folgesatzes.', 'Auslassung des Verbs.', 'Verdopplung des Subjekts.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Epanalepse: Er ging. Ging, ohne sich umzudrehen.',
    'grammarRule': 'Epanalepse: Wiederaufnahme am Satzanfang', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-026', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Hyperbaton (Sperrung)?',
    'options': ['Gross war die Not und das Elend der Bevoelkerung.', 'Die grosse Not und das Elend der Bevoelkerung waren bekannt.', 'Die Not der Bevoelkerung war gross und das Elend ebenfalls.', 'Die Bevoelkerung litt unter grosser Not und Elend.'],
    'correctAnswer': 0, 'explanation': 'Hyperbaton: Adjektiv von seinem Bezugswort getrennt (Gross ... Not).',
    'grammarRule': 'Hyperbaton: Trennung zusammengehoeriger Elemente', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-027', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anadiplose?',
    'options': ['Das letzte Wort eines Satzes wird am Anfang des naechsten wiederholt.', 'Das erste Wort wird am Ende wiederholt.', 'Auslassung des Verbs.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Anadiplose: Er kaempfte um sein Leben. Sein Leben war alles, was er hatte.',
    'grammarRule': 'Anadiplose: Satzende -> Satzanfang (Wiederholung)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-028', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewussten Wechsel von Hypo- und Parataxe?',
    'options': ['Obwohl er muede war, ging er weiter. Er ging und ging. Die Nacht brach herein.', 'Obwohl er muede war, ging er weiter, und die Nacht brach herein.', 'Er war muede. Er ging weiter. Die Nacht brach herein.', 'Er ging weiter, obwohl er muede war und die Nacht hereinbrach.'],
    'correctAnswer': 0, 'explanation': 'Stilistischer Wechsel: Hypotaxe (obwohl) -> Parataxe (kurze HS) fuer Tempowechsel.',
    'grammarRule': 'Stilwechsel: Hypotaxe -> Parataxe', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-029', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Zeugma?',
    'options': ['Ein Verb bezieht sich auf zwei Objekte in unterschiedlicher Bedeutung.', 'Zwei Verben beziehen sich auf ein Objekt.', 'Auslassung des Subjekts.', 'Wiederholung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Zeugma: Er schlug die Augen und das Buch auf.',
    'exampleSentence': 'Er schlug die Augen und das Buch auf.',
    'grammarRule': 'Zeugma: ein Verb, zwei Bedeutungen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-030', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion des Praedikativs (literarisch)?',
    'options': ['Dunkel war die Nacht und kalt der Wind.', 'Die Nacht war dunkel und der Wind kalt.', 'Die dunkle Nacht und der kalte Wind herrschten.', 'Es war dunkel in der Nacht und der Wind war kalt.'],
    'correctAnswer': 0, 'explanation': 'Literarische Inversion: Praedikativ im Vorfeld (Dunkel war ...). Chiasmus-Effekt.',
    'grammarRule': 'Praedikativ-Inversion: literarisch', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-031', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anapher in der Satzstruktur?',
    'options': ['Wiederholung des gleichen Wortes/der gleichen Wortgruppe am Satzanfang.', 'Wiederholung am Satzende.', 'Auslassung des Verbs.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Anapher: Wer kaempft, kann verlieren. Wer nicht kaempft, hat schon verloren.',
    'grammarRule': 'Anapher: Wiederholung am Satzanfang', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-032', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antithese durch Satzstruktur?',
    'options': ['Nicht der Starke siegt, sondern der Kluge.', 'Der Starke und der Kluge siegen.', 'Weder der Starke noch der Kluge siegt.', 'Der Starke siegt immer.'],
    'correctAnswer': 0, 'explanation': 'Antithese: Nicht X, sondern Y – kontrastierende Satzstruktur.',
    'grammarRule': 'Antithese: Nicht X, sondern Y', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-033', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Kohaerenz bei Infinitivkonstruktionen im NS?',
    'options': ['Infinitiv bildet mit dem Matrixverb einen gemeinsamen Verbkomplex.', 'Infinitiv steht allein.', 'Infinitiv faellt weg.', 'Infinitiv im Vorfeld.'],
    'correctAnswer': 0, 'explanation': 'Kohaerenz: ...weil er ihn hat sehen koennen. Inkohaerenz: ...weil er versucht hat, ihn zu sehen.',
    'grammarRule': 'Kohaerenz: Inf. im Verbkomplex', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-034', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Klimax (Steigerung) in der Satzstruktur?',
    'options': ['Er war besorgt, dann verängstigt, schliesslich in panischer Angst.', 'Er war in panischer Angst, dann veraengstigt, schliesslich besorgt.', 'Er war besorgt und veraengstigt.', 'Er hatte Angst.'],
    'correctAnswer': 0, 'explanation': 'Klimax: Steigerung der Intensitaet durch Satzglied-Reihung.',
    'grammarRule': 'Klimax: Steigerung durch Reihung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-035', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Epipher (Epiphora)?',
    'options': ['Wiederholung des gleichen Wortes am Satzende.', 'Wiederholung am Satzanfang.', 'Auslassung des Verbs.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Epipher: Er kaempfte fuer die Freiheit. Er starb fuer die Freiheit.',
    'grammarRule': 'Epipher: Wiederholung am Satzende', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-036', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt stilistisch markierte Sperrung eines Partizipialattributs?',
    'options': ['Die von den schweren Unwettern der vergangenen Wochen stark beschaedigten Strassen muessen saniert werden.', 'Die Strassen, die von den schweren Unwettern stark beschaedigt wurden, muessen saniert werden.', 'Die beschaedigten Strassen muessen saniert werden.', 'Die Strassen muessen saniert werden, weil sie beschaedigt sind.'],
    'correctAnswer': 0, 'explanation': 'Gesperrtes Partizipialattribut: grosse Distanz zwischen Artikel und Nomen.',
    'grammarRule': 'Sperrung: erweitertes Partizipialattribut', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'partizipialattribut']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-037', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Nachtrag als Stilmittel?',
    'options': ['Ein nach dem Satzende angefuegtes Element zur Praezisierung.', 'Ein vorangestellter NS.', 'Ein eingeschobener HS.', 'Ein Satz ohne Verb.'],
    'correctAnswer': 0, 'explanation': 'Nachtrag: nachtraegliche Praezisierung/Ergaenzung nach Satzschluss.',
    'exampleSentence': 'Er hat alles verloren. Alles.',
    'grammarRule': 'Nachtrag: nachtraegliche Ergaenzung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-038', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Parenthese als literarisches Stilmittel?',
    'options': ['Die Stadt – wer haette das gedacht – verwandelte sich in eine Geisterstadt.', 'Die Stadt verwandelte sich in eine Geisterstadt, was niemand gedacht haette.', 'Wer haette gedacht, dass die Stadt sich verwandeln wuerde?', 'Die Stadt verwandelte sich; niemand haette das gedacht.'],
    'correctAnswer': 0, 'explanation': 'Literarische Parenthese: eingeschobener Satz fuer Ueberraschung/Ironie.',
    'grammarRule': 'Literarische Parenthese: Einschub fuer Effekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-039', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Symploke?',
    'options': ['Kombination aus Anapher und Epipher (gleicher Anfang und gleiches Ende).', 'Nur Anapher.', 'Nur Epipher.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Symploke: Wer kaempft, kann verlieren. Wer nicht kaempft, hat verloren.',
    'grammarRule': 'Symploke: Anapher + Epipher', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-040', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antiklimax (Absteigende Reihung)?',
    'options': ['Er verlor sein Vermoegen, sein Haus, seinen Hut.', 'Er verlor seinen Hut, sein Haus, sein Vermoegen.', 'Er verlor alles.', 'Er verlor nichts.'],
    'correctAnswer': 0, 'explanation': 'Antiklimax: absteigende Reihung vom Grossen zum Kleinen.',
    'grammarRule': 'Antiklimax: absteigende Steigerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-041', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist eine rhetorische Frage mit V1?',
    'options': ['V1-Fragesatz, der keine Antwort erwartet.', 'Ein normaler Fragesatz.', 'Ein NS am Ende.', 'Ein Imperativ.'],
    'correctAnswer': 0, 'explanation': 'Rhetorische Frage (V1): Ist das nicht wunderbar? (Antwort impliziert.)',
    'grammarRule': 'Rhetorische Frage: V1, keine Antwort erwartet', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-042', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Satzfragmentierung (Stakkato)?',
    'options': ['Regen. Wind. Kaelte. Er ging trotzdem.', 'Es regnete, es war windig und kalt, aber er ging trotzdem.', 'Trotz des Regens, des Windes und der Kaelte ging er.', 'Obwohl es regnete und stuermt, ging er.'],
    'correctAnswer': 0, 'explanation': 'Stakkato: kurze Satzfragmente fuer Dynamik/Dramatik.',
    'grammarRule': 'Stakkato: kurze Fragmente fuer Dynamik', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-043', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Kyklos (Ringkomposition)?',
    'options': ['Ein Satz beginnt und endet mit dem gleichen Wort/Ausdruck.', 'Kreuzstellung.', 'Parallelismus.', 'Auslassung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Kyklos: Entfliehen koenne niemand, niemand entfliehen.',
    'grammarRule': 'Kyklos: gleiches Wort am Anfang und Ende', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-044', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Hendiadyoin?',
    'options': ['Er bat um Rat und Hilfe. (= um hilfreichen Rat)', 'Er bat um hilfreichen Rat.', 'Er bat um Rat, der hilfreich war.', 'Er bat, und man half ihm.'],
    'correctAnswer': 0, 'explanation': 'Hendiadyoin: ein Begriff durch zwei koordinierte Ausdruecke.',
    'grammarRule': 'Hendiadyoin: ein Begriff in zwei Woertern', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-045', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Enallage (Verschiebung des Adjektivs)?',
    'options': ['Ein Adjektiv wird einem anderen Bezugswort zugeordnet als erwartet.', 'Ein Adjektiv faellt weg.', 'Ein Adjektiv wird verdoppelt.', 'Ein Adjektiv steht am Satzende.'],
    'correctAnswer': 0, 'explanation': 'Enallage: Er trank einen einsamen Kaffee. (nicht der Kaffee ist einsam)',
    'grammarRule': 'Enallage: Adjektiv bei unerwartetem Bezugswort', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-046', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Enjambement (Zeilensprung) in poetischer Prosa?',
    'options': ['Er ging durch die / vom Mondlicht ueberflutete / Strasse. (Satzglied ueber Zeilenende)', 'Er ging durch die vom Mondlicht ueberflutete Strasse.', 'Die Strasse war vom Mondlicht ueberflutet, und er ging durch sie.', 'Im Mondlicht ging er durch die Strasse.'],
    'correctAnswer': 0, 'explanation': 'Enjambement: Satzglied wird ueber Zeilenende/Satzgrenze gezogen (poetisch).',
    'grammarRule': 'Enjambement: Satzglied ueber Grenze', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-047', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist eine komplexe Satzperiode im wissenschaftlichen Stil?',
    'options': ['Hypotaktischer Satz mit mehreren NS-Ebenen und spaeter Aufloesung.', 'Ein einfacher HS.', 'Nur Parataxe.', 'Ein Fragesatz.'],
    'correctAnswer': 0, 'explanation': 'Wissenschaftliche Satzperiode: mehrere NS-Ebenen, HS-Verb erst am Ende.',
    'grammarRule': 'Satzperiode: mehrere NS-Ebenen, spaete Aufloesung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-048', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusstes Spiel mit der Satzklammer (Spannung)?',
    'options': ['Er hat, obwohl alle davon abrieten und die Umstaende voellig dagegen sprachen, am Ende doch noch den Vertrag unterschrieben.', 'Er hat den Vertrag unterschrieben, obwohl alle davon abrieten.', 'Er hat am Ende den Vertrag unterschrieben.', 'Obwohl alle davon abrieten, hat er den Vertrag unterschrieben.'],
    'correctAnswer': 0, 'explanation': 'Maximale Klammerexpansion: sehr langes Mittelfeld erzeugt Spannung.',
    'grammarRule': 'Klammerexpansion: langes MF = Spannung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-049', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Correctio als Stilfigur?',
    'options': ['Selbstkorrektur: Er war mutig – nein, tollkuehn.', 'Wiederholung ohne Korrektur.', 'Auslassung.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Correctio: Selbstkorrektur/Steigerung durch Verbesserung.',
    'grammarRule': 'Correctio: Selbstkorrektur im Satz', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-050', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Koncinnitas (symmetrischen Satzbau)?',
    'options': ['Was der Verstand nicht begreift, das fuehlt das Herz.', 'Der Verstand begreift manches nicht, aber das Herz fuehlt es.', 'Verstand und Herz sind verschieden.', 'Man kann nicht alles begreifen, was man fuehlt.'],
    'correctAnswer': 0, 'explanation': 'Koncinnitas: symmetrischer, ausgewogener Satzbau (NS + HS parallel).',
    'grammarRule': 'Koncinnitas: symmetrischer Satzbau', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-051', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Prolepse im engeren syntaktischen Sinne?',
    'options': ['Ein NS-Element wird als Akkusativobjekt in den HS vorweggenommen.', 'Ein Verb wird verdoppelt.', 'Ein Satz wird abgebrochen.', 'Eine Wiederholung am Satzanfang.'],
    'correctAnswer': 0, 'explanation': 'Prolepse: Ich sehe ihn, wie er kommt (\'ihn\' = proleptsches Objekt).',
    'grammarRule': 'Prolepse: vorweggenommenes Objekt aus dem NS', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-052', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Zeugma als stilistisches Mittel?',
    'options': ['Er hob den Blick und den Hut.', 'Er hob den Blick. Er hob den Hut.', 'Er hob beides, Blick und Hut.', 'Er hob weder Blick noch Hut.'],
    'correctAnswer': 0, 'explanation': 'Zeugma: Ein Verb (hob) bezieht sich auf zwei semantisch verschiedene Objekte.',
    'grammarRule': 'Zeugma: ein Verb + zwei semantisch verschiedene Objekte', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-053', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was kennzeichnet Hypotaxe im Unterschied zur Parataxe?',
    'options': ['Verschachtelung von Haupt- und Nebensaetzen.', 'Nebenordnung gleichrangiger Hauptsaetze.', 'Nur Hauptsaetze.', 'Nur Nebensaetze.'],
    'correctAnswer': 0, 'explanation': 'Hypotaxe: hierarchische Unterordnung (NS unter HS). Parataxe: Nebenordnung (HS + HS).',
    'grammarRule': 'Hypotaxe: hierarchische NS-Einbettung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p1-054', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Aposiopese (Abbruch) als rhetorisches Mittel?',
    'options': ['Wenn du nicht sofort ..!', 'Wenn du nicht sofort kommst, werde ich gehen.', 'Du sollst sofort kommen.', 'Kommst du nicht sofort, gehe ich.'],
    'correctAnswer': 0, 'explanation': 'Aposiopese: bewusster Satzabbruch mit dramatischer Wirkung.',
    'grammarRule': 'Aposiopese: Satzabbruch als rhetorisches Mittel', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  }
];

export default questions;
