import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbau-p2-002', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz hat die richtige Wortstellung?',
    'options': ['Hat gestern er das Buch gelesen.', 'Gestern hat er das Buch gelesen.', 'Gestern er hat das Buch gelesen.', 'Gestern hat das Buch er gelesen.'],
    'correctAnswer': 1, 'explanation': 'Inversion: Angabe + Verb + Subjekt.',
    'grammarRule': 'Inversion', 'subcategory': 'Inversion', 'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-004', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Wo steht der trennbare Verbteil?',
    'options': ['am Ende des Satzes', 'auf Position 1', 'vor dem Subjekt', 'auf Position 2'],
    'correctAnswer': 0, 'explanation': 'Satzklammer: trennbarer Verbteil am Ende.',
    'grammarRule': 'Satzklammer', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-005', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Rechtsversetzung?',
    'options': ['Sie ist wirklich fleissig, die neue Praktikantin.', 'Die neue Praktikantin sie ist wirklich fleissig.', 'Fleissig ist sie wirklich, die neue Praktikantin.', 'Die neue Praktikantin, fleissig ist sie wirklich.'],
    'correctAnswer': 0, 'explanation': 'Rechtsversetzung: Pronomen im Satz + NP im Nachfeld.',
    'grammarRule': 'Rechtsversetzung: Pronomen + NP im Nachfeld', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-006', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Topik-Drop im informellen Deutsch?',
    'options': ['Auslassung des Topiks (Subjekt/Objekt) im Vorfeld.', 'Auslassung des Verbs.', 'Wiederholung des Subjekts.', 'Streichung des Nebensatzes.'],
    'correctAnswer': 0, 'explanation': 'Topik-Drop: \'(Ich) Hab keine Zeit.\' / \'(Das) Weiss ich nicht.\'',
    'grammarRule': 'Topik-Drop: Topik im Vorfeld ausgelassen', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-007', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Spaltsatz (Cleft) ist korrekt?',
    'options': ['Es war Maria, die das Buch geschrieben hat.', 'Es war, Maria die das Buch geschrieben hat.', 'Maria es war, die das Buch geschrieben hat.', 'Es Maria war, die das Buch geschrieben hat.'],
    'correctAnswer': 0, 'explanation': 'Spaltsatz: Es + sein + fokussiertes Element + Relativsatz.',
    'grammarRule': 'Spaltsatz: Es + sein + NP + Relativsatz', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-008', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist ein Pseudo-Spaltsatz (w-Cleft)?',
    'options': ['Was mich stoert, ist seine Unhoeflichkeit.', 'Es stoert mich seine Unhoeflichkeit.', 'Seine Unhoeflichkeit stoert mich.', 'Mich stoert, seine Unhoeflichkeit was.'],
    'correctAnswer': 0, 'explanation': 'Pseudo-Cleft: freier RS + ist/war + fokussiertes Element.',
    'grammarRule': 'Pseudo-Cleft: Was-RS + ist + fokussiertes Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-009', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Kohaerenz bei Infinitivkonstruktionen?',
    'options': ['Infinitiv bildet mit dem Matrixverb einen gemeinsamen Verbkomplex.', 'Infinitiv bildet eigene Phrase.', 'Infinitiv faellt weg.', 'Infinitiv steht im Vorfeld.'],
    'correctAnswer': 0, 'explanation': 'Kohaerenz: Infinitiv im Verbkomplex; Inkohaerenz: eigene Phrase.',
    'grammarRule': 'Kohaerenz: Infinitiv im Verbkomplex', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-010', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit kohaerenter Konstruktion im NS ist korrekt?',
    'options': ['...weil er das Buch hat lesen wollen.', '...weil er hat das Buch lesen wollen.', '...weil er das Buch lesen wollen hat.', '...weil er das Buch wollen lesen hat.'],
    'correctAnswer': 0, 'explanation': 'Kohaerente Konstruktion: Objekt + hat + Inf. + Modal-Inf.',
    'grammarRule': 'Kohaerenz im NS: Obj. + hat + Inf. + Modal-Inf.', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-011', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit des V1-Exklamativsatzes?',
    'options': ['Verb auf Pos. 1 drueckt Erstaunen aus.', 'Verb am Ende.', 'Verb faellt weg.', 'Verb auf Pos. 3.'],
    'correctAnswer': 0, 'explanation': 'V1-Exklamativ: \'Hat der aber Glueck gehabt!\'',
    'exampleSentence': 'Hat der aber Glueck gehabt!', 'grammarRule': 'V1-Exklamativ: Verb Pos. 1 + Erstaunen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-012', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizip im Vorfeld (emphatisch) ist korrekt?',
    'options': ['Gelesen habe ich das Buch schon.', 'Das Buch gelesen habe ich schon.', 'Habe gelesen ich das Buch schon.', 'Schon habe gelesen ich das Buch.'],
    'correctAnswer': 0, 'explanation': 'Partizip im Vorfeld: stilistisch markiert, betont die Handlung.',
    'grammarRule': 'Partizip im Vorfeld: emphatisch/literarisch', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-013', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist das Prinzip der zunehmenden Komplexitaet?',
    'options': ['Kurze/leichte Elemente links, lange/schwere rechts.', 'Schwere Elemente links, leichte rechts.', 'Alle gleich gewichtet.', 'Nur das Verb zaehlt.'],
    'correctAnswer': 0, 'explanation': 'Behagels Gesetz der wachsenden Glieder: kurz -> lang.',
    'grammarRule': 'Zunehmende Komplexitaet: kurz links, lang rechts', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-014', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit freiem Thema (Hanging Topic) ist korrekt?',
    'options': ['Was den Urlaub betrifft – ich fahre nach Spanien.', 'Ich fahre nach Spanien was den Urlaub betrifft.', 'Was den Urlaub betrifft ich fahre nach Spanien.', 'Den Urlaub betrifft was, ich fahre nach Spanien.'],
    'correctAnswer': 0, 'explanation': 'Freies Thema: ausserhalb der Satzstruktur + pronomiale Wiederaufnahme.',
    'grammarRule': 'Freies Thema: vor dem Satz + Wiederaufnahme', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-015', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Nachfeldbesetzung durch Vergleich ist korrekt?',
    'options': ['Er hat mehr geleistet als alle seine Kollegen zusammen.', 'Er hat als alle seine Kollegen zusammen mehr geleistet.', 'Er hat mehr als alle seine Kollegen zusammen geleistet.', 'Mehr als alle seine Kollegen er hat geleistet zusammen.'],
    'correctAnswer': 0, 'explanation': 'Vergleich mit als wird ins Nachfeld ausgeklammert.',
    'grammarRule': 'Ausklammerung: Vergleich ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-016', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der pragmatische Effekt der Topikalisierung?',
    'options': ['Kontrastierung oder Hervorhebung des topikalisierten Elements.', 'Keine besondere Wirkung.', 'Abschwuechung.', 'Formalisierung.'],
    'correctAnswer': 0, 'explanation': 'Topikalisierung markiert Kontrast: \'DAS Buch habe ich gelesen.\'',
    'grammarRule': 'Topikalisierung: Kontrast/Hervorhebung', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-017', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'mag ... auch\' ist korrekt?',
    'options': ['Mag die Aufgabe auch schwer sein, wir schaffen das.', 'Die Aufgabe mag auch schwer sein, wir schaffen das.', 'Auch mag die Aufgabe schwer sein, wir schaffen das.', 'Mag auch die Aufgabe schwer sein, wir schaffen das.'],
    'correctAnswer': 0, 'explanation': '\'Mag ... auch\': V1-Stellung (konzessiv).',
    'grammarRule': 'Mag + Subj. + auch + ...: konzessiver V1-Satz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-018', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Parenthese (Schaltsatz) ist korrekt?',
    'options': ['Er wird, so hoffe ich, bald zurueckkommen.', 'Er wird so hoffe ich bald zurueckkommen.', 'So hoffe ich, er wird bald zurueckkommen.', 'Er, wird so hoffe ich bald zurueckkommen.'],
    'correctAnswer': 0, 'explanation': 'Schaltsatz \'so hoffe ich\' durch Kommas eingeschlossen.',
    'grammarRule': 'Schaltsatz: durch Kommas eingeschlossen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-019', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion des Vorfelds in der Textgrammatik?',
    'options': ['Thematische Verknuepfung mit dem vorherigen Kontext.', 'Keine textgrammatische Funktion.', 'Immer neue Information.', 'Nur syntaktisch relevant.'],
    'correctAnswer': 0, 'explanation': 'Vorfeld: textgrammatisch wichtig fuer Thema-Progression und Kohaerenz.',
    'grammarRule': 'Vorfeld: Thema-Progression und Kohaerenz', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-020', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit dreifacher Satzklammer (K.II + Passiv + Modal) ist korrekt?',
    'options': ['Das haette laengst erledigt werden muessen.', 'Das haette muessen erledigt werden laengst.', 'Das haette werden erledigt muessen laengst.', 'Das laengst haette erledigt werden muessen.'],
    'correctAnswer': 0, 'explanation': 'Dreifache Klammer: haette + Partizip + werden + muessen.',
    'grammarRule': 'Dreifache Klammer: haette + Part. + werden + Modal-Inf.', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-021', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist narrative V1-Stellung?',
    'options': ['Verb auf Pos. 1 in Erzaehlungen ohne Fragecharakter.', 'Verb am Ende in Erzaehlungen.', 'Verb faellt weg.', 'Verb auf Pos. 3.'],
    'correctAnswer': 0, 'explanation': 'Narrative V1: \'Kommt da ein Mann um die Ecke.\' (Erzaehlstil)',
    'grammarRule': 'Narrative V1: Verb Pos. 1 in Erzaehlungen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-022', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Satzverschraenkung ist korrekt?',
    'options': ['Dieses Buch glaube ich, dass jeder lesen sollte.', 'Ich glaube, dieses Buch dass jeder lesen sollte.', 'Glaube ich dieses Buch, dass jeder lesen sollte.', 'Dieses Buch, glaube dass ich jeder lesen sollte.'],
    'correctAnswer': 0, 'explanation': 'Satzverschraenkung: NS-Element (Dieses Buch) ins Vorfeld des HS.',
    'grammarRule': 'Satzverschraenkung: NS-Element -> Vorfeld HS', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-023', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'obschon\' im Vorfeld ist korrekt?',
    'options': ['Obschon er wenig schlief, war er fit.', 'Obschon er schlief wenig, war er fit.', 'Obschon schlief er wenig, war er fit.', 'Obschon wenig er schlief, war er fit.'],
    'correctAnswer': 0, 'explanation': '\'Obschon\'-NS (Verb am Ende) + HS (Inversion).',
    'grammarRule': 'Obschon + NS + HS (Inversion)', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-024', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Klammerexpansion?',
    'options': ['Erweiterung des Mittelfelds durch zusaetzliche Satzglieder.', 'Verkuerzung des Mittelfelds.', 'Auslassung des Verbs.', 'Wiederholung der Klammer.'],
    'correctAnswer': 0, 'explanation': 'Klammerexpansion: Mittelfeld kann beliebig erweitert werden.',
    'grammarRule': 'Klammerexpansion: beliebige Erweiterung des Mittelfelds', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-025', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit resumptivem \'so\' ist korrekt?',
    'options': ['Wenn du kommst, so freue ich mich.', 'Wenn du kommst, freue ich so mich.', 'So wenn du kommst, freue ich mich.', 'Wenn du kommst, ich freue so mich.'],
    'correctAnswer': 0, 'explanation': 'Resumptives \'so\' im HS nach vorangestelltem NS (gehoben).',
    'grammarRule': 'Resumptives so: NS + , so + Verb + Subjekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-026', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Extraposition eines RS ist korrekt?',
    'options': ['Er hat gestern den Mann getroffen, den du auch kennst.', 'Er hat gestern den Mann, den du auch kennst, getroffen.', 'Er hat gestern getroffen den Mann, den du auch kennst.', 'Den Mann, den du auch kennst, er hat gestern getroffen.'],
    'correctAnswer': 0, 'explanation': 'Extraposition: RS vom Bezugsnomen getrennt ins Nachfeld.',
    'grammarRule': 'Extraposition: RS ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-027', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Haupt- und Nebensatzstellung?',
    'options': ['HS: V2 (Verb Pos. 2). NS: VL (Verb am Ende).', 'HS: Verb am Ende. NS: Verb Pos. 2.', 'Kein Unterschied.', 'HS: kein Verb. NS: zwei Verben.'],
    'correctAnswer': 0, 'explanation': 'HS: V2 (Verb Pos. 2); NS: VL (Verb am Ende).',
    'grammarRule': 'HS: V2. NS: VL.', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-028', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Gewichtung: Pronomen vor Angabe vor NP?',
    'options': ['Sie hat ihn gestern dem Lehrer vorgestellt.', 'Sie hat gestern ihn dem Lehrer vorgestellt.', 'Sie hat dem Lehrer gestern ihn vorgestellt.', 'Sie gestern hat ihn dem Lehrer vorgestellt.'],
    'correctAnswer': 0, 'explanation': 'Pronomen (ihn) vor Angabe (gestern) vor NP (dem Lehrer).',
    'grammarRule': 'Mittelfeld: Pronomen > Angabe > NP', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-029', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist eine Satzperiode?',
    'options': ['Ein komplex gebauter Satz mit mehreren NS auf verschiedenen Ebenen.', 'Ein einfacher HS.', 'Ein Fragesatz.', 'Ein Satz ohne Verb.'],
    'correctAnswer': 0, 'explanation': 'Satzperiode: komplex verschachtelter Satz (wissenschaftl./literarisch).',
    'grammarRule': 'Satzperiode: komplex verschachtelter Satz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-030', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Konditional (K.II PQP) ist korrekt?',
    'options': ['Haette er frueher angefangen, waere er fertig.', 'Er haette frueher angefangen, waere er fertig.', 'Haette angefangen er frueher, waere er fertig.', 'Frueher haette er angefangen, waere er fertig.'],
    'correctAnswer': 0, 'explanation': 'V1-Konditional: haette (Pos. 1) + Subjekt + ... + Partizip.',
    'grammarRule': 'V1-Konditional: haette (Pos. 1) + ...', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'konditionalsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-031', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Linksversetzung und Pronomen-Aufnahme ist korrekt?',
    'options': ['Das Buch da, das habe ich schon gelesen.', 'Das habe ich schon gelesen, das Buch da.', 'Habe das Buch da, das ich schon gelesen.', 'Ich das Buch da, das habe schon gelesen.'],
    'correctAnswer': 0, 'explanation': 'Linksversetzung: Element + Pronomen (das) im Vorfeld.',
    'grammarRule': 'Linksversetzung: Element + Pronomen-Wiederaufnahme', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-032', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Kohaerenz und Inkohaerenz?',
    'options': ['Kohaerenz: Inf. im Verbkomplex. Inkohaerenz: Inf. bildet eigene Phrase.', 'Kein Unterschied.', 'Kohaerenz = VL. Inkohaerenz = V2.', 'Kohaerenz: HS. Inkohaerenz: NS.'],
    'correctAnswer': 0, 'explanation': 'Kohaerenz: ...weil er ihn hat sehen koennen. Inkohaerenz: ...weil er versucht hat, ihn zu sehen.',
    'grammarRule': 'Kohaerenz vs. Inkohaerenz bei Infinitivkonstruktionen', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-033', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Gradpartikelsetzung ist korrekt?',
    'options': ['Nur PETER hat die Pruefung bestanden.', 'PETER nur hat die Pruefung bestanden.', 'Peter hat nur die Pruefung BESTANDEN.', 'Peter hat die Pruefung nur bestanden PETER.'],
    'correctAnswer': 0, 'explanation': '\'Nur\' vor dem fokussierten Element (PETER).',
    'grammarRule': 'Gradpartikel vor dem fokussierten Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-034', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ersatzinfinitiv im NS ist korrekt?',
    'options': ['...weil er den Film hat sehen wollen.', '...weil er hat den Film sehen wollen.', '...weil er den Film sehen wollen hat.', '...weil er den Film wollen sehen hat.'],
    'correctAnswer': 0, 'explanation': 'Ersatzinfinitiv im NS: hat vor den Infinitiven (Standarddeutsch).',
    'grammarRule': 'Ersatzinfinitiv im NS: hat + Inf. + Modal-Inf.', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ersatzinfinitiv']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-035', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die kommunikative Dynamik im Satz?',
    'options': ['Der Informationsgehalt nimmt von links nach rechts zu.', 'Alle Teile gleich wichtig.', 'Info nimmt von rechts nach links zu.', 'Nur das Verb traegt Info.'],
    'correctAnswer': 0, 'explanation': 'Kommunikative Dynamik: Thema (bekannt, links) -> Rhema (neu, rechts).',
    'grammarRule': 'Kommunikative Dynamik: Info steigt nach rechts', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-036', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Wunschsatz ist korrekt?',
    'options': ['Waere ich doch reich!', 'Ich waere doch reich!', 'Doch waere ich reich!', 'Reich waere doch ich!'],
    'correctAnswer': 0, 'explanation': 'V1-Wunschsatz: Verb auf Pos. 1 + \'doch\'.',
    'grammarRule': 'V1-Wunschsatz: Verb (Pos. 1) + doch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-037', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist multiple Vorfeldbesetzung?',
    'options': ['Zwei oder mehr Elemente im Vorfeld (selten, markiert).', 'Nur ein Element im Vorfeld.', 'Vorfeld ist leer.', 'Drei Verben im Vorfeld.'],
    'correctAnswer': 0, 'explanation': 'Multiple Vorfeldbesetzung: selten und stilistisch markiert.',
    'exampleSentence': 'Gestern in Berlin hat er sie getroffen.',
    'grammarRule': 'Multiple Vorfeldbesetzung: markiert, aber moeglich', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-038', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Herausstellung nach rechts ist korrekt?',
    'options': ['Er hat es schon erledigt, das Problem mit dem Computer.', 'Das Problem mit dem Computer er hat es schon erledigt.', 'Er hat das Problem mit dem Computer es schon erledigt.', 'Es hat er schon erledigt das Problem mit dem Computer.'],
    'correctAnswer': 0, 'explanation': 'Herausstellung nach rechts: Pronomen (es) im Satz + NP im Nachfeld.',
    'grammarRule': 'Herausstellung nach rechts: Pronomen + NP im Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-039', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was passiert bei expletivem \'es\' bei Inversion?',
    'options': ['Es faellt weg.', 'Es bleibt.', 'Es wird verdoppelt.', 'Es rueckt ans Ende.'],
    'correctAnswer': 0, 'explanation': 'Expletives es faellt weg, wenn ein anderes Element im Vorfeld steht.',
    'exampleSentence': 'Es wird hier gearbeitet. -> Hier wird gearbeitet.',
    'grammarRule': 'Expletives es: faellt bei Inversion weg', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-040', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wie + Adj. + Subjekt + auch + immer\' ist korrekt?',
    'options': ['Wie gross die Herausforderung auch immer sein mag, wir geben nicht auf.', 'Wie gross auch immer die Herausforderung sein mag, wir geben nicht auf.', 'Wie die Herausforderung gross auch immer sein mag, wir geben nicht auf.', 'Gross wie die Herausforderung auch immer sein mag, wir geben nicht auf.'],
    'correctAnswer': 0, 'explanation': 'Konzessiver wie-Satz: wie + Adj. + Subj. + auch immer + Verb.',
    'grammarRule': 'Wie + Adj. + Subj. + auch immer + Verb: konzessiv', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-041', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Prolepse?',
    'options': ['Ein Element des NS wird in den HS vorgezogen.', 'Ein Element des HS wird in den NS verschoben.', 'Das Verb faellt weg.', 'Das Subjekt wird verdoppelt.'],
    'correctAnswer': 0, 'explanation': 'Prolepse (Vorwegnahme): NS-Element wird in den HS herausbewegt.',
    'grammarRule': 'Prolepse: NS-Element -> HS', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-042', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit komplexem erweitertem Partizipialattribut ist korrekt?',
    'options': ['Die seit vielen Jahren in Deutschland lebenden Auslaender haben Rechte.', 'Die Auslaender seit vielen Jahren in Deutschland lebenden haben Rechte.', 'Die lebenden seit vielen Jahren in Deutschland Auslaender haben Rechte.', 'Seit vielen Jahren die in Deutschland lebenden Auslaender haben Rechte.'],
    'correctAnswer': 0, 'explanation': 'Erweitertes Partizipialattribut: alle Erweiterungen + Partizip + Nomen.',
    'grammarRule': 'Partizipialattr.: Erweiterungen + Partizip + Nomen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'partizipialattribut']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-043', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der Vorfeld-es-Test?',
    'options': ['Pruefung, ob \'es\' obligatorisch ist (referenzielles es) oder wegfallen kann (expletives es).', 'Pruefung der Verbkonjugation.', 'Zaehlung der Woerter.', 'Pruefung des Kasus.'],
    'correctAnswer': 0, 'explanation': 'Referenzielles es bleibt bei Inversion; expletives es faellt weg.',
    'grammarRule': 'Vorfeld-es-Test: referenziell (bleibt) vs. expletiv (faellt weg)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-044', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'V2-weil\' (umgangssprachlich) ist korrekt?',
    'options': ['Ich kann nicht kommen, weil ich habe keine Zeit.', 'Ich kann nicht kommen, weil ich keine Zeit habe.', 'Ich kann nicht kommen, weil habe ich keine Zeit.', 'Ich kann nicht kommen, weil keine Zeit ich habe.'],
    'correctAnswer': 0, 'explanation': 'V2-weil: umgangssprachlich, Verb auf Pos. 2 (statt am Ende).',
    'grammarRule': 'V2-weil: weil + Verb Pos. 2 (umgangssprachlich)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-045', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Right Node Raising (RNR)?',
    'options': ['Ein gemeinsames Element am Ende zweier koordinierter Saetze wird nur einmal realisiert.', 'Das Verb wird verdoppelt.', 'Das Subjekt steht am Ende.', 'Zwei NS werden verschmolzen.'],
    'correctAnswer': 0, 'explanation': 'RNR: \'Er kaufte und sie las das Buch.\' (\'das Buch\' nur einmal).',
    'exampleSentence': 'Er kaufte und sie las das gleiche Buch.',
    'grammarRule': 'RNR: gemeinsames Element am Ende nur einmal', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-046', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte multiple NS-Einbettung?',
    'options': ['Er behauptet, dass er glaubt, dass sie weiss, dass es stimmt.', 'Er behauptet, dass er glaubt, dass sie weiss, dass stimmt es.', 'Er behauptet, dass er glaubt, dass weiss sie, dass es stimmt.', 'Er behauptet dass er glaubt dass sie weiss dass es stimmt.'],
    'correctAnswer': 0, 'explanation': 'Jeder NS hat Verbendstellung; Kommas trennen.',
    'grammarRule': 'Multiple NS-Einbettung: Verb am Ende in jedem NS', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-047', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Forward Gapping?',
    'options': ['Tilgung des Verbs im zweiten koord. Satz (normal).', 'Tilgung des Verbs im ersten Satz.', 'Tilgung des Subjekts.', 'Tilgung des Objekts.'],
    'correctAnswer': 0, 'explanation': 'Forward Gapping: Verb im 2. Konjunkt getilgt (Standardfall).',
    'grammarRule': 'Forward Gapping: Verb im 2. Konjunkt getilgt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-048', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Adjektiv im Vorfeld (emphatisch) ist korrekt?',
    'options': ['Wunderbar war das Konzert gestern.', 'Das Konzert wunderbar war gestern.', 'War wunderbar das Konzert gestern.', 'Gestern das Konzert wunderbar war.'],
    'correctAnswer': 0, 'explanation': 'Adjektiv/Praedikativ im Vorfeld: emphatisch/stilistisch markiert.',
    'grammarRule': 'Praedikativ im Vorfeld: emphatisch', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-049', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der dt. Verbklammer?',
    'options': ['Sie schafft eine Rahmenstruktur um das Mittelfeld.', 'Es gibt keine Verbklammer.', 'Nur NS haben eine Klammer.', 'Die Klammer umschliesst nur das Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Verbklammer: linke (Verb Pos. 2) + rechte Klammer (infiniter Teil) umrahmen das MF.',
    'grammarRule': 'Verbklammer: Rahmen um das Mittelfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-050', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Rechtsextraposition eines schweren RS ist korrekt?',
    'options': ['Er hat gestern den Vorschlag abgelehnt, den die Kollegin aus der Marketingabteilung gemacht hatte.', 'Er hat gestern den Vorschlag, den die Kollegin aus der Marketingabteilung gemacht hatte, abgelehnt.', 'Er hat gestern abgelehnt den Vorschlag, den die Kollegin gemacht hatte.', 'Den Vorschlag, den die Kollegin gemacht hatte, er hat gestern abgelehnt.'],
    'correctAnswer': 0, 'explanation': 'Schwerer RS wird ins Nachfeld extraponiert (Verarbeitungserleichterung).',
    'grammarRule': 'Rechtsextraposition: schwerer RS ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-051', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit freiem Dativ (Dativus ethicus) ist korrekt?',
    'options': ['Komm mir ja nicht zu spaet!', 'Komm ja mir nicht zu spaet!', 'Mir komm ja nicht zu spaet!', 'Komm ja nicht mir zu spaet!'],
    'correctAnswer': 0, 'explanation': 'Dativus ethicus: emotionaler Dativ (mir) direkt nach dem Verb.',
    'grammarRule': 'Dativus ethicus: Verb + mir/dir + ...', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'dativ']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p2-052', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Topikalisierung eines Objekts?',
    'options': ['Diesen Fehler haette ich nie gemacht.', 'Haette ich diesen Fehler nie gemacht.', 'Diesen Fehler nie haette ich gemacht.', 'Ich diesen Fehler haette nie gemacht.'],
    'correctAnswer': 0, 'explanation': 'Topikalisierung: Akkusativobjekt im Vorfeld + V2 + Subjekt.',
    'grammarRule': 'Topikalisierung: Objekt (Vorfeld) + V2 + Subjekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'topikalisierung']
  }
];

export default questions;
