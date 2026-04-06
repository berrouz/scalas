import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbau-p5-003', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz folgt TeKaMoLo?',
    'options': ['Er hat gestern in Berlin ein Buch gekauft.', 'Er hat ein Buch gestern in Berlin gekauft.', 'Er gestern hat in Berlin ein Buch gekauft.', 'Er hat gekauft gestern in Berlin ein Buch.'],
    'correctAnswer': 0, 'explanation': 'TeKaMoLo: Temporal + Kausal + Modal + Lokal.',
    'grammarRule': 'TeKaMoLo', 'subcategory': 'TeKaMoLo', 'tags': ['satzbau', 'tekamolo']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-005', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Stellungsfeldertheorie?',
    'options': ['VF + LK + MF + RK + NF.', 'Nur VF und NF.', 'Nur Mittelfeld.', 'SVO-Schema.'],
    'correctAnswer': 0, 'explanation': 'Topologisches Modell: Vorfeld | Linke Klammer | Mittelfeld | Rechte Klammer | Nachfeld.',
    'grammarRule': 'Stellungsfelder: VF | LK | MF | RK | NF', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-006', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist das Vorfeld?',
    'options': ['Die Position vor dem finiten Verb (genau ein Satzglied).', 'Die Position nach dem Verb.', 'Das Satzende.', 'Der Nebensatz.'],
    'correctAnswer': 0, 'explanation': 'Vorfeld: ein Satzglied vor dem finiten Verb auf Pos. 1.',
    'grammarRule': 'Vorfeld: ein Satzglied vor V2', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'vorfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-007', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit NS im Vorfeld ist korrekt?',
    'options': ['Dass er kommt, freut mich.', 'Dass er kommt freut mich.', 'Freut mich, dass er kommt.', 'Dass kommt er, freut mich.'],
    'correctAnswer': 0, 'explanation': 'Dass-NS im Vorfeld + Komma + Verb (Pos. 2).',
    'grammarRule': 'NS (Vorfeld) + Komma + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-008', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die linke Satzklammer im NS?',
    'options': ['Die Subjunktion (dass, weil, obwohl ...).', 'Das finite Verb.', 'Das Partizip.', 'Das Nachfeld.'],
    'correctAnswer': 0, 'explanation': 'Im NS: linke Klammer = Subjunktion; rechte Klammer = Verbkomplex.',
    'grammarRule': 'NS: LK = Subjunktion, RK = Verbkomplex', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-009', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ausklammerung ist korrekt?',
    'options': ['Sie hat sich verabschiedet von all den lieben Menschen, die sie kennengelernt hatte.', 'Sie hat sich von all den lieben Menschen, die sie kennengelernt hatte, verabschiedet.', 'Sie hat sich verabschiedet, von all den lieben Menschen die sie kennengelernt hatte.', 'Von all den lieben Menschen sie hat sich verabschiedet.'],
    'correctAnswer': 0, 'explanation': 'Schwere PP + RS ins Nachfeld ausgeklammert.',
    'grammarRule': 'Ausklammerung: schwere PP ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-010', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen V1, V2 und VL?',
    'options': ['V1: Verb Pos. 1 (Frage/Imperativ). V2: Verb Pos. 2 (HS). VL: Verb am Ende (NS).', 'Kein Unterschied.', 'V1 = HS. V2 = NS. VL = Imperativ.', 'V1 und V2 sind identisch.'],
    'correctAnswer': 0, 'explanation': 'V1: Frage/Imperativ. V2: Deklarativ-HS. VL: NS.',
    'grammarRule': 'V1 (Frage) / V2 (HS) / VL (NS)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-011', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Konditional ist korrekt?',
    'options': ['Sollte es regnen, bleiben wir zu Hause.', 'Es sollte regnen, bleiben wir zu Hause.', 'Sollte regnen es, bleiben wir zu Hause.', 'Regnen sollte es, bleiben wir zu Hause.'],
    'correctAnswer': 0, 'explanation': 'V1-Konditional: Verb auf Pos. 1 ersetzt wenn.',
    'grammarRule': 'V1-Konditional: Verb (Pos. 1) + Subjekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'konditionalsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-012', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Topikalisierung?',
    'options': ['Verschiebung eines Nicht-Subjekt-Elements ins Vorfeld.', 'Streichung des Verbs.', 'Verdopplung des Objekts.', 'Verschiebung ins Nachfeld.'],
    'correctAnswer': 0, 'explanation': 'Topikalisierung: Element ins Vorfeld + Inversion.',
    'grammarRule': 'Topikalisierung: Element ins VF + Inversion', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-013', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Topikalisierung einer PP ist korrekt?',
    'options': ['Mit diesem Problem hat sich niemand beschaeftigt.', 'Mit diesem Problem niemand hat sich beschaeftigt.', 'Hat mit diesem Problem sich niemand beschaeftigt.', 'Niemand mit diesem Problem hat sich beschaeftigt.'],
    'correctAnswer': 0, 'explanation': 'PP im Vorfeld + Verb (Pos. 2) + Subjekt (Inversion).',
    'grammarRule': 'PP (Vorfeld) + V2 + Subjekt', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-014', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Scrambling?',
    'options': ['Freie Umstellung im Mittelfeld fuer pragmatische Zwecke.', 'Feste Wortstellung.', 'Streichung des Verbs.', 'Verschiebung ins Vorfeld.'],
    'correctAnswer': 0, 'explanation': 'Scrambling: pragmatisch motivierte Umstellung im Mittelfeld.',
    'grammarRule': 'Scrambling: freie Umstellung im MF', 'subcategory': 'Scrambling', 'tags': ['satzbau', 'scrambling']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-015', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Pronomenstellung ist korrekt?',
    'options': ['Gestern hat sie es ihm gegeben.', 'Gestern hat sie ihm es gegeben.', 'Gestern hat es sie ihm gegeben.', 'Gestern hat ihm sie es gegeben.'],
    'correctAnswer': 0, 'explanation': 'Pronomenfolge: Nom. + Akk. + Dat.',
    'grammarRule': 'Pronomenfolge: Nom. + Akk. + Dat.', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-017', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Extraposition eines dass-Satzes ist korrekt?',
    'options': ['Die Hoffnung besteht, dass sich die Lage bessert.', 'Die Hoffnung, dass sich die Lage bessert, besteht.', 'Besteht die Hoffnung, dass sich die Lage bessert.', 'Dass sich die Lage bessert die Hoffnung besteht.'],
    'correctAnswer': 0, 'explanation': 'Dass-NS ins Nachfeld extraponiert (getrennt vom Bezugsnomen).',
    'grammarRule': 'Extraposition: dass-NS ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-019', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Spaltsatz ist korrekt?',
    'options': ['Es war der Sturm, der den Baum umgerissen hat.', 'Es war, der Sturm der den Baum umgerissen hat.', 'Der Sturm es war, der den Baum umgerissen hat.', 'Es der Sturm war, der den Baum umgerissen hat.'],
    'correctAnswer': 0, 'explanation': 'Spaltsatz: Es war + fokussiertes Element + RS.',
    'grammarRule': 'Spaltsatz: Es war + Fokus + RS', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'spaltsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-020', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist eine Parenthese?',
    'options': ['Eingeschobener Ausdruck, der die Satzstruktur nicht veraendert.', 'NS am Ende.', 'HS ohne Verb.', 'Imperativsatz.'],
    'correctAnswer': 0, 'explanation': 'Parenthese: eingeschobener Ausdruck (Kommas, Gedankenstriche, Klammern).',
    'grammarRule': 'Parenthese: eingeschobener Ausdruck', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-021', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Schaltsatz ist korrekt?',
    'options': ['Das Problem ist, denke ich, leicht zu loesen.', 'Das Problem ist denke ich leicht zu loesen.', 'Denke ich, das Problem ist leicht zu loesen.', 'Das Problem, ist denke ich leicht zu loesen.'],
    'correctAnswer': 0, 'explanation': 'Schaltsatz (denke ich) durch Kommas; V2-Stellung.',
    'grammarRule': 'Schaltsatz: Kommas + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-022', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Linksversetzung?',
    'options': ['NP vor dem Vorfeld + Pronomen-Wiederaufnahme im Satz.', 'NP ins Nachfeld.', 'Verb ans Satzende.', 'Subjekt faellt weg.'],
    'correctAnswer': 0, 'explanation': 'Linksversetzung: Element vor Vorfeld + Pronomen im Satz.',
    'exampleSentence': 'Die neue Wohnung, die gefaellt mir gut.',
    'grammarRule': 'Linksversetzung: NP + Pronomen', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-023', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Rechtsversetzung ist korrekt?',
    'options': ['Sie ist wirklich talentiert, die junge Pianistin.', 'Die junge Pianistin sie ist wirklich talentiert.', 'Talentiert ist sie wirklich, die junge Pianistin.', 'Die junge Pianistin, talentiert ist sie wirklich.'],
    'correctAnswer': 0, 'explanation': 'Rechtsversetzung: Pronomen + NP im Nachfeld zur Praezisierung.',
    'grammarRule': 'Rechtsversetzung: Pronomen + NP (Nachfeld)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'rechtsversetzung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-024', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Gapping?',
    'options': ['Tilgung des Verbs im zweiten koord. Satz.', 'Verdopplung des Verbs.', 'Auslassung des Subjekts.', 'Streichung des NS.'],
    'correctAnswer': 0, 'explanation': 'Gapping: Er liest Romane und sie Sachbuecher.',
    'grammarRule': 'Gapping: Verb im 2. Konjunkt getilgt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-025', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit je ... umso ist korrekt?',
    'options': ['Je schneller du arbeitest, umso frueher bist du fertig.', 'Je schneller du arbeitest, umso du frueher bist fertig.', 'Je du schneller arbeitest, umso frueher bist du fertig.', 'Schneller je du arbeitest, umso frueher bist du fertig.'],
    'correctAnswer': 0, 'explanation': 'Je + Komp. + VL; umso + Komp. + V2 + Subjekt.',
    'grammarRule': 'Je + Komp. + VL, umso + Komp. + V2', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-026', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Kontrastfokus?',
    'options': ['Betonung eines Elements zum Kontrast.', 'Keine Betonung.', 'Verb wird betont.', 'Alles wird betont.'],
    'correctAnswer': 0, 'explanation': 'Kontrastfokus: DIESEN Film habe ich gesehen, nicht jenen.',
    'grammarRule': 'Kontrastfokus: Betonung des kontrastierten Elements', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-027', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizipialgruppe im Vorfeld ist korrekt?',
    'options': ['Schwer beladen mit Gepaeck, erreichten die Wanderer die Huette.', 'Schwer beladen mit Gepaeck erreichten die Wanderer die Huette.', 'Erreichten die Wanderer die Huette, schwer beladen mit Gepaeck.', 'Die Wanderer schwer beladen mit Gepaeck erreichten die Huette.'],
    'correctAnswer': 0, 'explanation': 'Partizipialgruppe + Komma + HS mit Inversion.',
    'grammarRule': 'Partizipialgruppe (VF) + Komma + V2', 'subcategory': 'Inversion', 'tags': ['satzbau', 'partizipialgruppe']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-029', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ersatzinfinitiv ist korrekt?',
    'options': ['Er hat den Hund bellen hoeren.', 'Er hat den Hund gehoert bellen.', 'Er hat den Hund bellen gehoert.', 'Er hat bellen den Hund hoeren.'],
    'correctAnswer': 0, 'explanation': 'Ersatzinfinitiv: hoeren statt gehoert bei weiterem Infinitiv.',
    'grammarRule': 'Ersatzinfinitiv: Inf. + Inf. statt Part. II + Inf.', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ersatzinfinitiv']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-030', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die kanonische Wortstellung im HS?',
    'options': ['Subj. + Verb (Pos. 2) + Mittelfeld + infiniter Verbteil.', 'Verb + Subjekt + Objekt.', 'Subjekt + Objekt + Verb.', 'Verb + Objekt + Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Kanonisch: Subj. (VF) + V2 + MF + RK.',
    'grammarRule': 'Kanonisch: Subj. + V2 + MF + RK', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-031', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Wunschsatz ist korrekt?',
    'options': ['Koenntest du doch nur kommen!', 'Du koenntest doch nur kommen!', 'Doch koenntest du nur kommen!', 'Nur kommen koenntest du doch!'],
    'correctAnswer': 0, 'explanation': 'V1-Wunschsatz: Verb (K.II) auf Pos. 1 + doch/nur.',
    'grammarRule': 'V1-Wunschsatz: Verb (Pos. 1) + doch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-032', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist V2-weil?',
    'options': ['Umgangssprachlich: weil + V2-Stellung statt Verbendstellung.', 'Standard: weil + VL.', 'Weil hat immer V1.', 'Weil ist kein Konnektor.'],
    'correctAnswer': 0, 'explanation': 'V2-weil: umgangssprachlich, zeigt eigenstaendige Assertion.',
    'exampleSentence': 'Ich gehe, weil ich muss jetzt los.',
    'grammarRule': 'V2-weil: weil + V2 (umgangssprachlich)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-033', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit indirektem Fragesatz ist korrekt?',
    'options': ['Er fragte, ob sie morgen Zeit habe.', 'Er fragte, ob habe sie morgen Zeit.', 'Er fragte ob sie morgen Zeit habe.', 'Ob sie morgen Zeit habe er fragte.'],
    'correctAnswer': 0, 'explanation': 'Indirekter Fragesatz: ob + ... + Verb (Ende).',
    'grammarRule': 'Indirekter Fragesatz: ob + ... + Verb (Ende)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-034', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Fokusprojektion?',
    'options': ['Akzent auf letztem Argument = Fokus auf den ganzen Satz.', 'Jedes Wort gleich betont.', 'Fokus nur auf dem Verb.', 'Fokus nur auf dem Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Fokusprojektion: Normalakzent auf letztem Argument = weiter Fokus.',
    'grammarRule': 'Fokusprojektion: Akzent auf letztem Argument', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-035', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Fokuspartikel sogar ist korrekt?',
    'options': ['Sogar der Direktor hat sich entschuldigt.', 'Der Direktor sogar hat sich entschuldigt.', 'Der Direktor hat sogar entschuldigt sich.', 'Hat sogar der Direktor sich entschuldigt.'],
    'correctAnswer': 0, 'explanation': 'Fokuspartikel sogar direkt vor dem fokussierten Element.',
    'grammarRule': 'Fokuspartikel: vor dem fokussierten Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'fokuspartikel']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-036', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist eine Ellipse?',
    'options': ['Auslassung von Satzgliedern aus dem Kontext.', 'Verdopplung des Verbs.', 'Hinzufuegung eines NS.', 'Umstellung des Vorfelds.'],
    'correctAnswer': 0, 'explanation': 'Ellipse: kontextuell ergaenzbare Auslassung.',
    'grammarRule': 'Ellipse: kontextuell ergaenzbar', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-037', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Korrelat-es ist korrekt?',
    'options': ['Es gefaellt mir, dass du hier bist.', 'Gefaellt es mir, dass du hier bist.', 'Es gefaellt mir dass du hier bist.', 'Dass du hier bist es gefaellt mir.'],
    'correctAnswer': 0, 'explanation': 'Korrelat-es + HS + dass-NS im Nachfeld.',
    'grammarRule': 'Korrelat-es + HS + dass-NS', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-038', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit als (ohne ob) fuer irrealen Vergleich ist korrekt?',
    'options': ['Er sprach, als kenne er die ganze Geschichte.', 'Er sprach, als er kenne die ganze Geschichte.', 'Er sprach, als die ganze Geschichte kenne er.', 'Er sprach als kenne er die ganze Geschichte.'],
    'correctAnswer': 0, 'explanation': 'Als + Verb (K.II, Pos. 1): V1-Stellung.',
    'grammarRule': 'Als + Verb (K.II): irrealer Vergleich', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-039', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit des Verbalkomplexes im NS?',
    'options': ['Alle Verbteile stehen am Ende gebuendelt.', 'Verb auf Pos. 2.', 'Kein Verbalkomplex im NS.', 'Verbalkomplex am Anfang.'],
    'correctAnswer': 0, 'explanation': 'Im NS stehen alle Verbteile am Satzende.',
    'exampleSentence': '...weil er das Buch gelesen haben muss.',
    'grammarRule': 'NS: Verbalkomplex am Ende', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-040', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit obwohl + Inversion ist korrekt?',
    'options': ['Obwohl sie krank war, ging sie zur Arbeit.', 'Obwohl sie krank war, sie ging zur Arbeit.', 'Obwohl krank war sie, ging sie zur Arbeit.', 'Sie ging zur Arbeit obwohl sie krank war.'],
    'correctAnswer': 0, 'explanation': 'Obwohl-NS + Komma + HS mit Inversion (V2).',
    'grammarRule': 'Obwohl + NS + HS (Inversion)', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-041', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist narrative V1-Stellung?',
    'options': ['Verb auf Pos. 1 in Erzaehlungen.', 'Verb am Ende.', 'Verb faellt weg.', 'Verb auf Pos. 3.'],
    'correctAnswer': 0, 'explanation': 'Narrative V1: Steht da ein Reh auf der Strasse.',
    'grammarRule': 'Narrative V1: Verb (Pos. 1) in Erzaehlungen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-042', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Dativ vor Akkusativ ist korrekt?',
    'options': ['Er bringt der Nachbarin die Zeitung.', 'Er bringt die Zeitung der Nachbarin.', 'Er der Nachbarin bringt die Zeitung.', 'Der Nachbarin er bringt die Zeitung.'],
    'correctAnswer': 0, 'explanation': 'Bei vollen NPs: Dativ vor Akkusativ (unmarkiert).',
    'grammarRule': 'Volle NPs: Dativ vor Akkusativ', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-043', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Satzverschraenkung?',
    'options': ['NS-Element wird ins Vorfeld des HS bewegt.', 'Zwei HS verbunden.', 'NS gestrichen.', 'Verb verdoppelt.'],
    'correctAnswer': 0, 'explanation': 'Satzverschraenkung: Element aus NS -> Vorfeld HS.',
    'exampleSentence': 'Das Buch glaube ich, dass er gelesen hat.',
    'grammarRule': 'Satzverschraenkung: NS-Element -> VF HS', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-044', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv-Satzklammer ist korrekt?',
    'options': ['Der Brief wurde gestern von der Sekretaerin geschrieben.', 'Der Brief wurde geschrieben gestern von der Sekretaerin.', 'Der Brief gestern wurde von der Sekretaerin geschrieben.', 'Geschrieben wurde der Brief gestern von der Sekretaerin.'],
    'correctAnswer': 0, 'explanation': 'Passiv: wurde (LK) + MF + Partizip II (RK).',
    'grammarRule': 'Passiv: wurde + ... + Partizip II', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-045', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit expletivem es ist korrekt?',
    'options': ['Es wurde den ganzen Abend getanzt.', 'Den ganzen Abend es wurde getanzt.', 'Getanzt wurde es den ganzen Abend.', 'Es den ganzen Abend wurde getanzt.'],
    'correctAnswer': 0, 'explanation': 'Expletives es im Vorfeld; faellt bei Inversion weg.',
    'grammarRule': 'Expletives es: nur im Vorfeld', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-046', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der Pseudo-Spaltsatz?',
    'options': ['Was-RS + ist + fokussiertes Element.', 'Einfacher HS.', 'Satz ohne Verb.', 'Imperativsatz.'],
    'correctAnswer': 0, 'explanation': 'Pseudo-Cleft: Was ihn stoert, ist der Laerm.',
    'grammarRule': 'Pseudo-Cleft: Was-RS + ist + Fokus', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'spaltsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-047', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz (um ... zu) ist korrekt?',
    'options': ['Sie fliegt nach Japan, um die Kultur kennenzulernen.', 'Sie fliegt nach Japan um die Kultur kennenzulernen.', 'Sie fliegt nach Japan, um kennenzulernen die Kultur.', 'Um die Kultur kennenzulernen sie fliegt nach Japan.'],
    'correctAnswer': 0, 'explanation': 'Um ... zu + Infinitiv: Komma + um + ... + zu + Inf. (Ende).',
    'grammarRule': 'Um ... zu: Komma + um + ... + zu + Inf.', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-049', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Negation (Satznegation) ist korrekt?',
    'options': ['Sie hat den Vertrag gestern nicht unterschrieben.', 'Sie hat den Vertrag nicht gestern unterschrieben.', 'Sie nicht hat den Vertrag gestern unterschrieben.', 'Nicht sie hat den Vertrag gestern unterschrieben.'],
    'correctAnswer': 0, 'explanation': 'Satznegation: nicht vor der rechten Klammer.',
    'grammarRule': 'Satznegation: nicht vor RK', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-050', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Korrelat-es und Infinitivsatz ist korrekt?',
    'options': ['Es ist wichtig, diese Regel zu beachten.', 'Wichtig ist es, diese Regel zu beachten.', 'Es ist wichtig diese Regel zu beachten.', 'Zu beachten diese Regel es ist wichtig.'],
    'correctAnswer': 0, 'explanation': 'Korrelat-es im Vorfeld verweist auf den Infinitivsatz im Nachfeld.',
    'grammarRule': 'Korrelat-es + V2 + Praedikat, + Infinitivsatz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-051', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Parenthese ist korrekt?',
    'options': ['Die Loesung – so meine ich – liegt auf der Hand.', 'Die Loesung so meine ich liegt auf der Hand.', 'Die Loesung – so meine ich liegt – auf der Hand.', '– So meine ich – die Loesung liegt auf der Hand.'],
    'correctAnswer': 0, 'explanation': 'Parenthese: eingeschobener Satz zwischen Gedankenstrichen, unterbricht die Satzstruktur.',
    'grammarRule': 'Parenthese: Satz – Einschub – Satzfortsetzung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-052', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'wobei\' als weiterfuehrendem Konnektor ist korrekt?',
    'options': ['Er arbeitet viel, wobei er selten Pausen macht.', 'Er arbeitet viel wobei er selten Pausen macht.', 'Er arbeitet viel, wobei macht er selten Pausen.', 'Wobei er selten Pausen macht er arbeitet viel.'],
    'correctAnswer': 0, 'explanation': '\'Wobei\' leitet einen weiterfuehrenden NS ein (Verb am Ende).',
    'grammarRule': 'Wobei + NS (VE): weiterfuehrender Relativsatz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'relativsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-053', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit doppeltem Vorfeld ist (gesprochen) akzeptabel?',
    'options': ['Gestern Abend da hat er mich angerufen.', 'Gestern Abend hat da er mich angerufen.', 'Da gestern Abend hat er mich angerufen.', 'Hat gestern Abend da er mich angerufen.'],
    'correctAnswer': 0, 'explanation': 'Doppeltes Vorfeld (gesprochene Sprache): Adverbial + resumptives \'da\' + V2.',
    'grammarRule': 'Doppeltes Vorfeld: Adv + da + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'gesprochene-sprache']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-054', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ausklammerung eines Vergleichs ist korrekt?',
    'options': ['Er hat mehr geleistet als alle anderen zusammen.', 'Er hat als alle anderen zusammen mehr geleistet.', 'Er hat mehr als alle anderen zusammen geleistet.', 'Als alle anderen zusammen hat er mehr geleistet.'],
    'correctAnswer': 0, 'explanation': 'Der Vergleich mit \'als\' wird nach der rechten Satzklammer ausgeklammert.',
    'grammarRule': 'Ausklammerung: Vergleich nach rechter Klammer', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-055', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'insofern\' als Satzadverb ist korrekt?',
    'options': ['Insofern hat er recht.', 'Insofern er hat recht.', 'Er insofern hat recht.', 'Hat insofern er recht.'],
    'correctAnswer': 0, 'explanation': '\'Insofern\' als Satzadverb im Vorfeld: Insofern + V2 + Subjekt.',
    'grammarRule': 'Insofern (Satzadverb) + V2 + Subjekt', 'subcategory': 'Inversion', 'tags': ['satzbau', 'konnektor']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-056', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit freiem Relativsatz (wer) ist korrekt?',
    'options': ['Wer nicht wagt, der nicht gewinnt.', 'Wer nicht wagt, nicht gewinnt der.', 'Der nicht gewinnt, wer nicht wagt.', 'Wer nicht wagt nicht gewinnt der.'],
    'correctAnswer': 0, 'explanation': 'Freier RS mit \'wer\': Verb am Ende im RS + Korrelat \'der\' + V2 im HS.',
    'grammarRule': 'Freier RS: Wer + VE, + der + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'relativsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p5-057', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit nachgestelltem Attribut ist korrekt?',
    'options': ['Der Vorschlag, naemlich die Kosten zu senken, wurde angenommen.', 'Der Vorschlag naemlich die Kosten zu senken wurde angenommen.', 'Naemlich die Kosten zu senken der Vorschlag wurde angenommen.', 'Der Vorschlag, die Kosten naemlich zu senken, wurde angenommen.'],
    'correctAnswer': 0, 'explanation': 'Nachgestelltes Attribut mit \'naemlich\': zwischen Kommas eingeschoben.',
    'grammarRule': 'Nachgestelltes Attribut: NP, + naemlich + Spezifizierung, + Satzfortsetzung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'apposition']
  }
];

export default questions;
