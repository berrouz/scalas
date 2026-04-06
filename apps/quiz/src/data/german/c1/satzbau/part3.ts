import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbau-p3-005', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die rechte Satzklammer?',
    'options': ['Position des infiniten Verbteils am Satzende.', 'Position des finiten Verbs.', 'Das Vorfeld.', 'Der Nebensatz.'],
    'correctAnswer': 0, 'explanation': 'Rechte Klammer: Partizip/Infinitiv/Praefix am Satzende.',
    'grammarRule': 'Rechte Klammer: infiniter Verbteil am Ende', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-006', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Satzklammer im Perfekt ist korrekt?',
    'options': ['Sie hat den ganzen Nachmittag im Buero gearbeitet.', 'Sie hat gearbeitet den ganzen Nachmittag im Buero.', 'Sie den ganzen Nachmittag hat im Buero gearbeitet.', 'Im Buero hat sie gearbeitet den ganzen Nachmittag.'],
    'correctAnswer': 0, 'explanation': 'Perfekt: hat (linke Klammer) ... gearbeitet (rechte Klammer).',
    'grammarRule': 'Satzklammer Perfekt: hat ... Partizip II', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-007', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was passiert mit dem Subjekt bei Inversion?',
    'options': ['Es rueckt auf Position 3.', 'Es faellt weg.', 'Es bleibt auf Position 1.', 'Es steht am Satzende.'],
    'correctAnswer': 0, 'explanation': 'Bei Inversion steht ein anderes Satzglied im Vorfeld; das Subjekt auf Pos. 3.',
    'grammarRule': 'Inversion: Subjekt auf Pos. 3', 'subcategory': 'Inversion', 'tags': ['satzbau', 'inversion']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-008', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit NS im Vorfeld ist korrekt?',
    'options': ['Weil er krank war, blieb er zu Hause.', 'Weil er krank war blieb er zu Hause.', 'Weil er war krank, blieb er zu Hause.', 'Blieb er zu Hause, weil er krank war.'],
    'correctAnswer': 0, 'explanation': 'NS im Vorfeld + Komma + Verb (Pos. 2) + Subjekt (Inversion).',
    'grammarRule': 'NS (Vorfeld) + Komma + V2 + Subjekt', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-009', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist das Mittelfeld im topologischen Modell?',
    'options': ['Der Bereich zwischen linker und rechter Satzklammer.', 'Der Bereich vor dem Vorfeld.', 'Das Satzende.', 'Nur das Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Mittelfeld: zwischen finitem Verb (linke Klammer) und infinitem Verbteil (rechte Klammer).',
    'grammarRule': 'Mittelfeld: zwischen LK und RK', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-010', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ausklammerung einer schweren PP ist korrekt?',
    'options': ['Er hat sich beschwert ueber die seit Wochen andauernden Bauarbeiten.', 'Er hat sich ueber die seit Wochen andauernden Bauarbeiten beschwert.', 'Er hat beschwert sich ueber die seit Wochen andauernden Bauarbeiten.', 'Ueber die seit Wochen andauernden Bauarbeiten hat er beschwert sich.'],
    'correctAnswer': 0, 'explanation': 'Schwere PP ins Nachfeld ausgeklammert (nach dem Partizip).',
    'grammarRule': 'Ausklammerung: schwere PP ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-011', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Wo stehen Pronomen im Mittelfeld?',
    'options': ['Moeglichst weit links (nah am finiten Verb).', 'Am Satzende.', 'Nach allen Angaben.', 'Im Nachfeld.'],
    'correctAnswer': 0, 'explanation': 'Pronomen stehen im Mittelfeld weit links (Wackernagel-Position).',
    'grammarRule': 'Pronomen: weit links im Mittelfeld', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-012', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Topikalisierung des Dativobjekts ist korrekt?',
    'options': ['Dem Lehrer hat der Schueler die Aufgabe gegeben.', 'Dem Lehrer der Schueler hat die Aufgabe gegeben.', 'Hat dem Lehrer der Schueler die Aufgabe gegeben.', 'Der Schueler dem Lehrer hat die Aufgabe gegeben.'],
    'correctAnswer': 0, 'explanation': 'Dativobjekt im Vorfeld: Topikalisierung + Inversion.',
    'grammarRule': 'Topikalisierung: Dat.-Obj. + V2 + Subjekt', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-013', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Nachfeldbesetzung?',
    'options': ['Ein Satzglied steht nach der rechten Satzklammer.', 'Ein Satzglied steht vor dem Vorfeld.', 'Das Verb steht am Ende.', 'Das Subjekt faellt weg.'],
    'correctAnswer': 0, 'explanation': 'Nachfeld: Bereich nach der rechten Klammer, fuer NS oder schwere PP.',
    'grammarRule': 'Nachfeld: nach der rechten Satzklammer', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-014', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Konditional ist korrekt?',
    'options': ['Kaeme er rechtzeitig, koennten wir anfangen.', 'Er kaeme rechtzeitig, koennten wir anfangen.', 'Kaeme rechtzeitig er, koennten wir anfangen.', 'Rechtzeitig kaeme er, koennten wir anfangen.'],
    'correctAnswer': 0, 'explanation': 'V1-Konditional: Verb (K.II) auf Pos. 1 ersetzt wenn.',
    'grammarRule': 'V1-Konditional: Verb (Pos. 1) + Subjekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'konditionalsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-015', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb-Satzklammer ist korrekt?',
    'options': ['Sie moechte am Wochenende nach Hamburg fahren.', 'Sie moechte fahren am Wochenende nach Hamburg.', 'Sie am Wochenende moechte nach Hamburg fahren.', 'Fahren moechte sie am Wochenende nach Hamburg.'],
    'correctAnswer': 0, 'explanation': 'Modalverb (linke Klammer) ... Infinitiv (rechte Klammer).',
    'grammarRule': 'Satzklammer: Modalverb + ... + Infinitiv', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-017', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Extraposition eines RS ist korrekt?',
    'options': ['Sie hat das Geschenk bekommen, das ihr Freund bestellt hatte.', 'Sie hat das Geschenk, das ihr Freund bestellt hatte, bekommen.', 'Sie hat bekommen das Geschenk, das ihr Freund bestellt hatte.', 'Das Geschenk, das ihr Freund bestellt hatte, sie hat bekommen.'],
    'correctAnswer': 0, 'explanation': 'RS vom Bezugsnomen getrennt ins Nachfeld extraponiert.',
    'grammarRule': 'Extraposition: RS ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-019', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Spaltsatz ist korrekt?',
    'options': ['Es ist die Lehrerin, die uns geholfen hat.', 'Es ist, die Lehrerin die uns geholfen hat.', 'Die Lehrerin es ist, die uns geholfen hat.', 'Es die Lehrerin ist, die uns geholfen hat.'],
    'correctAnswer': 0, 'explanation': 'Spaltsatz: Es ist + fokussiertes Element + Relativsatz.',
    'grammarRule': 'Spaltsatz: Es ist + Fokus + RS', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'spaltsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-022', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit je ... desto ist korrekt?',
    'options': ['Je laenger man wartet, desto schwieriger wird die Aufgabe.', 'Je laenger man wartet, desto die Aufgabe schwieriger wird.', 'Je man laenger wartet, desto schwieriger wird die Aufgabe.', 'Laenger je man wartet, desto schwieriger wird die Aufgabe.'],
    'correctAnswer': 0, 'explanation': 'Je + Komparativ + VL; desto + Komparativ + V2 + Subjekt.',
    'grammarRule': 'Je + Komp. + VL, desto + Komp. + V2', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-023', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Scrambling?',
    'options': ['Pragmatisch motivierte Umstellung der Satzglieder im Mittelfeld.', 'Verschiebung des Verbs.', 'Auslassung des Subjekts.', 'Wiederholung von Praepositionen.'],
    'correctAnswer': 0, 'explanation': 'Scrambling: freie Umstellung im Mittelfeld fuer Fokus-/Topikmarkierung.',
    'grammarRule': 'Scrambling: freie Umstellung im Mittelfeld', 'subcategory': 'Scrambling', 'tags': ['satzbau', 'scrambling']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-024', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Korrelat-es ist korrekt?',
    'options': ['Es ist schade, dass er nicht kommen kann.', 'Schade es ist, dass er nicht kommen kann.', 'Es ist schade dass er nicht kommen kann.', 'Dass er nicht kommen kann es ist schade.'],
    'correctAnswer': 0, 'explanation': 'Korrelat-es im Vorfeld; der dass-Satz steht im Nachfeld.',
    'grammarRule': 'Korrelat-es + HS + dass-NS (Nachfeld)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-025', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Stellungsfeldertheorie?',
    'options': ['Vorfeld + linke Klammer + Mittelfeld + rechte Klammer + Nachfeld.', 'Nur Vorfeld und Nachfeld.', 'Nur Mittelfeld.', 'Subjekt + Verb + Objekt.'],
    'correctAnswer': 0, 'explanation': 'Topologisches Modell: VF | LK | MF | RK | NF.',
    'grammarRule': 'Stellungsfelder: VF | LK | MF | RK | NF', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-026', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz ist korrekt?',
    'options': ['Sie bat ihn, das Fenster zu oeffnen.', 'Sie bat ihn das Fenster oeffnen zu.', 'Sie bat ihn, zu oeffnen das Fenster.', 'Sie bat, ihn das Fenster zu oeffnen.'],
    'correctAnswer': 0, 'explanation': 'Infinitivsatz: Komma + ... + zu + Infinitiv am Ende.',
    'grammarRule': 'Infinitivsatz: ... + zu + Infinitiv (Ende)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-027', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Rechtsversetzung?',
    'options': ['Ein Pronomen im Satz wird durch eine NP am Satzende praezisiert.', 'Eine NP wird ins Vorfeld verschoben.', 'Das Verb wird verdoppelt.', 'Das Subjekt faellt weg.'],
    'correctAnswer': 0, 'explanation': 'Rechtsversetzung: Pronomen im Satz + NP im Nachfeld.',
    'exampleSentence': 'Sie ist nett, die neue Kollegin.',
    'grammarRule': 'Rechtsversetzung: Pronomen + NP (Nachfeld)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'rechtsversetzung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-028', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizipialgruppe im Vorfeld ist korrekt?',
    'options': ['Tief in Gedanken versunken, bemerkte sie den Besucher nicht.', 'Tief in Gedanken versunken bemerkte sie den Besucher nicht.', 'Bemerkte sie den Besucher nicht, tief in Gedanken versunken.', 'Sie tief in Gedanken versunken bemerkte den Besucher nicht.'],
    'correctAnswer': 0, 'explanation': 'Partizipialgruppe im Vorfeld + Komma + HS mit Inversion.',
    'grammarRule': 'Partizipialgruppe (Vorfeld) + Komma + V2', 'subcategory': 'Inversion', 'tags': ['satzbau', 'partizipialgruppe']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-029', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit als ob + K.II ist korrekt?',
    'options': ['Er sieht aus, als ob er tagelang nicht geschlafen haette.', 'Er sieht aus, als ob er haette tagelang nicht geschlafen.', 'Er sieht aus, als ob haette er tagelang nicht geschlafen.', 'Er sieht aus als ob er tagelang nicht geschlafen haette.'],
    'correctAnswer': 0, 'explanation': 'Als ob + NS: Verb (K.II) am Ende.',
    'grammarRule': 'Als ob + ... + Verb (K.II, Ende)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-030', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist ein Verbalkomplex?',
    'options': ['Alle Verbteile (finit + infinit) zusammen.', 'Nur das finite Verb.', 'Ein Satz ohne Verb.', 'Ein Hilfsverb allein.'],
    'correctAnswer': 0, 'explanation': 'Verbalkomplex: finites Verb + alle infiniten Verbteile.',
    'grammarRule': 'Verbalkomplex: finites + infinite Verbteile', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-031', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Wunschsatz ist korrekt?',
    'options': ['Haette ich doch mehr gelernt!', 'Ich haette doch mehr gelernt!', 'Doch haette ich mehr gelernt!', 'Mehr gelernt haette ich doch!'],
    'correctAnswer': 0, 'explanation': 'V1-Wunschsatz: Verb (K.II) auf Pos. 1 + doch.',
    'grammarRule': 'V1-Wunschsatz: Verb (Pos. 1) + doch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-033', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Fokuspartikel ist korrekt?',
    'options': ['Auch der Chef hat an der Besprechung teilgenommen.', 'Der Chef auch hat an der Besprechung teilgenommen.', 'Der Chef hat auch teilgenommen an der Besprechung.', 'Hat auch der Chef an der Besprechung teilgenommen.'],
    'correctAnswer': 0, 'explanation': 'Fokuspartikel auch direkt vor dem fokussierten Element.',
    'grammarRule': 'Fokuspartikel: vor dem fokussierten Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'fokuspartikel']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-035', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Pronomenfolge (Akk. + Dat.) ist korrekt?',
    'options': ['Gestern hat er es ihm erklaert.', 'Gestern hat er ihm es erklaert.', 'Gestern hat es er ihm erklaert.', 'Gestern hat ihm er es erklaert.'],
    'correctAnswer': 0, 'explanation': 'Pronomenfolge: Nominativ + Akkusativ + Dativ.',
    'grammarRule': 'Pronomenfolge: Nom. + Akk. + Dat.', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-036', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist eine Parenthese?',
    'options': ['Ein eingeschobener Ausdruck, der die Satzstruktur nicht veraendert.', 'Ein NS am Ende.', 'Ein HS ohne Verb.', 'Ein Imperativsatz.'],
    'correctAnswer': 0, 'explanation': 'Parenthese: eingeschobener Ausdruck (Kommas, Gedankenstriche).',
    'grammarRule': 'Parenthese: eingeschobener Ausdruck', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-037', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit obwohl + Inversion im HS ist korrekt?',
    'options': ['Obwohl es regnete, gingen sie spazieren.', 'Obwohl es regnete, sie gingen spazieren.', 'Obwohl regnete es, gingen sie spazieren.', 'Es regnete obwohl, gingen sie spazieren.'],
    'correctAnswer': 0, 'explanation': 'Obwohl-NS (Verb Ende) + Komma + HS (Verb Pos. 2, Inversion).',
    'grammarRule': 'Obwohl + NS + HS (Inversion)', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-038', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Dativ vor Akkusativ (volle NPs) ist korrekt?',
    'options': ['Er schenkt dem Kind ein Spielzeug.', 'Er schenkt ein Spielzeug dem Kind.', 'Er dem Kind schenkt ein Spielzeug.', 'Dem Kind er schenkt ein Spielzeug.'],
    'correctAnswer': 0, 'explanation': 'Bei vollen NPs: Dativ vor Akkusativ (unmarkierte Reihenfolge).',
    'grammarRule': 'Volle NPs: Dativ vor Akkusativ', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-039', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Kontrastfokus?',
    'options': ['Betonung eines Elements zum Kontrast mit einem anderen.', 'Keine besondere Betonung.', 'Auslassung des Verbs.', 'Wiederholung des Subjekts.'],
    'correctAnswer': 0, 'explanation': 'Kontrastfokus: PETER hat das gemacht, nicht Maria.',
    'grammarRule': 'Kontrastfokus: Betonung auf dem kontrastierten Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-040', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ersatzinfinitiv ist korrekt?',
    'options': ['Sie hat das Kind spielen lassen.', 'Sie hat das Kind gelassen spielen.', 'Sie hat das Kind spielen gelassen.', 'Sie hat spielen das Kind lassen.'],
    'correctAnswer': 0, 'explanation': 'Ersatzinfinitiv: lassen statt gelassen bei weiterem Infinitiv.',
    'grammarRule': 'Ersatzinfinitiv: Inf. + Inf. statt Part. II + Inf.', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ersatzinfinitiv']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-041', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion des Vorfelds?',
    'options': ['Thematische Anbindung und Informationssteuerung.', 'Nur syntaktische Pflicht.', 'Keine besondere Funktion.', 'Immer neue Information.'],
    'correctAnswer': 0, 'explanation': 'Das Vorfeld dient der Thema-Rhema-Steuerung und Textkohaerenz.',
    'grammarRule': 'Vorfeld: thematische Anbindung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-042', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Parenthese (Gedankenstriche) ist korrekt?',
    'options': ['Die Ergebnisse – das muss man zugeben – waren ueberraschend.', 'Die Ergebnisse das muss man zugeben – waren ueberraschend.', 'Die Ergebnisse – das muss man zugeben waren ueberraschend.', '– Die Ergebnisse das muss man zugeben – waren ueberraschend.'],
    'correctAnswer': 0, 'explanation': 'Parenthese: durch zwei Gedankenstriche eingeschlossen.',
    'grammarRule': 'Parenthese: durch Gedankenstriche eingeschlossen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-043', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was passiert bei expletivem es bei Inversion?',
    'options': ['Es faellt weg.', 'Es bleibt im Satz.', 'Es wird verdoppelt.', 'Es rueckt ans Satzende.'],
    'correctAnswer': 0, 'explanation': 'Expletives es faellt weg, wenn ein anderes Element im Vorfeld steht.',
    'exampleSentence': 'Es kamen viele Gaeste. -> Gestern kamen viele Gaeste.',
    'grammarRule': 'Expletives es: faellt bei Inversion weg', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-044', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit indirektem Fragesatz ist korrekt?',
    'options': ['Ich weiss nicht, wann der Zug abfaehrt.', 'Ich weiss nicht, wann faehrt der Zug ab.', 'Ich weiss nicht wann der Zug abfaehrt.', 'Wann der Zug abfaehrt ich weiss nicht.'],
    'correctAnswer': 0, 'explanation': 'Indirekter Fragesatz: w-Wort + ... + Verb am Ende.',
    'grammarRule': 'Indirekter Fragesatz: w-Wort + ... + Verb (Ende)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-045', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Negation (Satznegation) ist korrekt?',
    'options': ['Er hat das Buch gestern nicht gelesen.', 'Er hat das Buch nicht gestern gelesen.', 'Er nicht hat das Buch gestern gelesen.', 'Nicht er hat das Buch gestern gelesen.'],
    'correctAnswer': 0, 'explanation': 'Satznegation: nicht steht vor dem infiniten Verbteil (rechte Klammer).',
    'grammarRule': 'Satznegation: nicht vor der rechten Klammer', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-047', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Futur-I-Satzklammer ist korrekt?',
    'options': ['Er wird naechste Woche die Pruefung ablegen.', 'Er wird ablegen naechste Woche die Pruefung.', 'Er naechste Woche wird die Pruefung ablegen.', 'Ablegen wird er naechste Woche die Pruefung.'],
    'correctAnswer': 0, 'explanation': 'Futur I: wird (linke Klammer) ... Infinitiv (rechte Klammer).',
    'grammarRule': 'Futur I: wird + ... + Infinitiv', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-048', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist ein Pseudo-Spaltsatz?',
    'options': ['Was + RS + ist/war + fokussiertes Element.', 'Ein Satz ohne Verb.', 'Ein einfacher HS.', 'Ein Imperativsatz.'],
    'correctAnswer': 0, 'explanation': 'Pseudo-Cleft: Was mich stoert, ist seine Unpuenktlichkeit.',
    'grammarRule': 'Pseudo-Cleft: Was-RS + ist + fokussiertes Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'spaltsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-049', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit anstatt dass ist korrekt?',
    'options': ['Anstatt dass er hilft, sitzt er nur herum.', 'Anstatt dass hilft er, sitzt er nur herum.', 'Dass anstatt er hilft, sitzt er nur herum.', 'Anstatt dass er hilft sitzt er nur herum.'],
    'correctAnswer': 0, 'explanation': 'Anstatt dass + NS (Verb am Ende) + Komma + HS.',
    'grammarRule': 'Anstatt dass + NS + HS', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-050', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Distanzstellung bei trennbarem Verb im NS ist korrekt?',
    'options': ['Ich weiss, dass er morgen frueh ankommt.', 'Ich weiss, dass er morgen frueh kommt an.', 'Ich weiss, dass ankommt er morgen frueh.', 'Ich weiss, dass er an morgen frueh kommt.'],
    'correctAnswer': 0, 'explanation': 'Im NS bleibt das trennbare Verb zusammen am Ende: \'ankommt\'.',
    'grammarRule': 'NS: trennbares Verb zusammen am Ende', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-051', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizipialkonstruktion im Vorfeld ist korrekt?',
    'options': ['Vom Regen durchnaesst, betrat er das Haus.', 'Durchnaesst vom Regen betrat, er das Haus.', 'Er betrat, vom Regen durchnaesst das Haus.', 'Vom Regen durchnaesst er, betrat das Haus.'],
    'correctAnswer': 0, 'explanation': 'Partizipialkonstruktion als Satzglied im Vorfeld + Komma + V2-HS.',
    'grammarRule': 'Partizipialkonstruktion (Vorfeld) + Komma + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'partizip']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-052', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welche Stellung hat \'nicht\' bei Sondernegation?',
    'options': ['Nicht er hat den Fehler gemacht, sondern sie.', 'Er hat nicht den Fehler gemacht, sondern sie.', 'Er nicht hat den Fehler gemacht, sondern sie.', 'Er hat den Fehler nicht gemacht, sondern sie.'],
    'correctAnswer': 0, 'explanation': 'Sondernegation: \'nicht\' steht direkt vor dem negierten Element (hier: Subjekt im Vorfeld).',
    'grammarRule': 'Sondernegation: nicht + fokussiertes Element', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'negation']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-053', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt korrekte Stellung bei Modalpartikel \'doch\'?',
    'options': ['Komm doch endlich!', 'Doch komm endlich!', 'Komm endlich doch!', 'Endlich doch komm!'],
    'correctAnswer': 0, 'explanation': 'Modalpartikeln stehen im Mittelfeld, meist direkt nach dem Verb oder nach dem Subjekt.',
    'grammarRule': 'Modalpartikel: im Mittelfeld nach dem Verb', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'modalpartikel']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-054', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit eingebettetem V2-Satz ist korrekt?',
    'options': ['Er glaubt, er hat recht.', 'Er glaubt, recht hat er.', 'Er glaubt er hat recht.', 'Glaubt er, er hat recht.'],
    'correctAnswer': 0, 'explanation': 'Nach Verben des Meinens/Glaubens kann ein V2-Satz statt eines dass-Satzes folgen.',
    'grammarRule': 'Eingebetteter V2: Verb des Meinens + Komma + V2-Satz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'v2-einbettung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-055', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Apposition ist korrekt?',
    'options': ['Berlin, die Hauptstadt Deutschlands, hat viel zu bieten.', 'Berlin die Hauptstadt Deutschlands, hat viel zu bieten.', 'Berlin, die Hauptstadt Deutschlands hat viel zu bieten.', 'Die Hauptstadt Deutschlands, Berlin hat viel zu bieten.'],
    'correctAnswer': 0, 'explanation': 'Apposition: zwischen zwei Kommas eingeschoben, unterbricht den Hauptsatz nicht.',
    'grammarRule': 'Apposition: NP, + Apposition, + Satzfortsetzung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'apposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-056', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Wo steht das Pronomen \'es\' als Platzhalter im Vorfeld?',
    'options': ['Es kamen viele Gaeste zur Feier.', 'Viele Gaeste es kamen zur Feier.', 'Kamen es viele Gaeste zur Feier.', 'Zur Feier es kamen viele Gaeste.'],
    'correctAnswer': 0, 'explanation': 'Vorfeld-es: Platzhalter auf Pos. 1, faellt weg bei Inversion.',
    'grammarRule': 'Vorfeld-es: Platzhalter Pos. 1 + V2 + Subjekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'vorfeld-es']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-058', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Konjunktiv-II-Inversion ist korrekt?',
    'options': ['Waere ich doch fruehzeitig gewarnt worden!', 'Ich waere doch fruehzeitig gewarnt worden!', 'Doch waere ich fruehzeitig gewarnt worden!', 'Waere ich gewarnt doch fruehzeitig worden!'],
    'correctAnswer': 0, 'explanation': 'Irrealer Wunsch ohne \'wenn\': Verb an Pos. 1, Partikel \'doch\' im Mittelfeld.',
    'grammarRule': 'Irrealer Wunsch: V1 + Subjekt + doch + ...', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'konjunktiv']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-059', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit nachgestelltem weil-HS (V2) ist in der gesprochenen Sprache akzeptabel?',
    'options': ['Er bleibt zu Hause, weil er ist krank.', 'Er bleibt zu Hause, weil er krank ist.', 'Weil er ist krank, bleibt er zu Hause.', 'Er bleibt zu Hause weil er ist krank.'],
    'correctAnswer': 0, 'explanation': 'Im gesprochenen Deutsch: \'weil\' + V2 (Hauptsatzstellung) ist ueblich fuer Begruendungen.',
    'grammarRule': 'Gesprochenes Deutsch: weil + V2 (statt VE)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'gesprochene-sprache']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-148',
    'level': 'c1',
    'category': 'Satzbau',
    'subcategory': 'Feldermodell',
    'question': 'Was ist das Mittelfeld im deutschen Satz?',
    'options': ['Alles vor dem Verb', 'Der Bereich zwischen finitem Verb und Satzende/Partizip', 'Der letzte Satzteil', 'Der Nebensatz'],
    'correctAnswer': 1,
    'explanation': 'Das Mittelfeld liegt zwischen dem finiten Verb und dem rechten Satzrand.',
    'tags': ['satzbau']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-149',
    'level': 'c1',
    'category': 'Satzbau',
    'subcategory': 'Nachfeld',
    'question': 'Was steht im Nachfeld des Satzes?',
    'options': ['Das Subjekt', 'Schwere/lange Elemente, Vergleichssaetze, Nebensaetze', 'Das Verb', 'Nur Adverbien'],
    'correctAnswer': 1,
    'explanation': 'Das Nachfeld enthaelt schwere Elemente, die aus dem Mittelfeld ausgelagert werden.',
    'tags': ['satzbau']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p3-150',
    'level': 'c1',
    'category': 'Satzbau',
    'subcategory': 'Topikalisierung',
    'question': 'Was bewirkt die Linksversetzung (Topikalisierung)?',
    'options': ['Betonung/Hervorhebung des vorangestellten Elements', 'Grammatikfehler', 'Stilistische Verschlechterung', 'Nichts'],
    'correctAnswer': 0,
    'explanation': 'Linksversetzung hebt das vorangestellte Element hervor.',
    'tags': ['satzbau']
  }
];

export default questions;
