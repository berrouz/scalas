import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbau-p4-005', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die linke Satzklammer im HS?',
    'options': ['Die Position des finiten Verbs (Pos. 2).', 'Das Nachfeld.', 'Das Vorfeld.', 'Die Position des Partizips.'],
    'correctAnswer': 0, 'explanation': 'Linke Klammer = finites Verb auf Pos. 2 im HS.',
    'grammarRule': 'Linke Klammer: finites Verb', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-006', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Akkusativobjekt im Vorfeld ist korrekt?',
    'options': ['Diesen Fehler werde ich nicht wiederholen.', 'Diesen Fehler ich werde nicht wiederholen.', 'Werde diesen Fehler ich nicht wiederholen.', 'Ich diesen Fehler werde nicht wiederholen.'],
    'correctAnswer': 0, 'explanation': 'Topikalisierung: Akk.-Objekt im Vorfeld + Verb (Pos. 2) + Subjekt.',
    'grammarRule': 'Topikalisierung: Akk. + V2 + Subjekt', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-008', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Nachfeldbesetzung durch NS ist korrekt?',
    'options': ['Er hat es gewusst, dass sie kommen wuerde.', 'Er hat es, dass sie kommen wuerde, gewusst.', 'Dass sie kommen wuerde er hat es gewusst.', 'Er hat gewusst es, dass sie kommen wuerde.'],
    'correctAnswer': 0, 'explanation': 'Der dass-NS steht im Nachfeld (nach der rechten Klammer).',
    'grammarRule': 'Nachfeld: NS nach rechter Klammer', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'nachfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-010', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit V1-Konditional (Plusquamperfekt) ist korrekt?',
    'options': ['Waere er frueher aufgestanden, haette er den Zug erreicht.', 'Er waere frueher aufgestanden, haette er den Zug erreicht.', 'Waere aufgestanden er frueher, haette er den Zug erreicht.', 'Frueher waere er aufgestanden, haette er den Zug erreicht.'],
    'correctAnswer': 0, 'explanation': 'V1-Konditional: Verb (K.II) auf Pos. 1.',
    'grammarRule': 'V1-Konditional: Verb (Pos. 1) + Subjekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'konditionalsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-011', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Wo stehen Reflexivpronomen im Mittelfeld?',
    'options': ['Nah am finiten Verb (weit links).', 'Am Satzende.', 'Nach allen Angaben.', 'Im Nachfeld.'],
    'correctAnswer': 0, 'explanation': 'Reflexivpronomen stehen im Mittelfeld moeglichst weit links.',
    'grammarRule': 'Reflexivpronomen: weit links im Mittelfeld', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-012', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Relativsatz im Nachfeld ist korrekt?',
    'options': ['Er hat den Bericht gelesen, den sein Kollege verfasst hatte.', 'Er hat den Bericht, den sein Kollege verfasst hatte, gelesen.', 'Er hat gelesen den Bericht, den sein Kollege verfasst hatte.', 'Den Bericht, den sein Kollege verfasst hatte, er hat gelesen.'],
    'correctAnswer': 0, 'explanation': 'RS im Nachfeld: nach der rechten Klammer (Extraposition).',
    'grammarRule': 'Extraposition: RS ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-013', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Topikalisierung?',
    'options': ['Verschiebung eines Satzglieds ins Vorfeld zur Hervorhebung.', 'Auslassung des Verbs.', 'Verdopplung des Subjekts.', 'Verschiebung ans Satzende.'],
    'correctAnswer': 0, 'explanation': 'Topikalisierung: ein Nicht-Subjekt-Element ins Vorfeld + Inversion.',
    'grammarRule': 'Topikalisierung: Element ins Vorfeld + Inversion', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-014', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Modalverb + Perfekt-Satzklammer ist korrekt?',
    'options': ['Er hat gestern nicht kommen koennen.', 'Er hat nicht koennen gestern kommen.', 'Er hat gestern kommen nicht koennen.', 'Er gestern hat nicht kommen koennen.'],
    'correctAnswer': 0, 'explanation': 'Ersatzinfinitiv: hat + Infinitiv + Modal-Infinitiv.',
    'grammarRule': 'Ersatzinfinitiv: hat + Inf. + Modal-Inf.', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ersatzinfinitiv']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-015', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Ausklammerung?',
    'options': ['Verschiebung eines Elements nach der rechten Satzklammer ins Nachfeld.', 'Verschiebung ins Vorfeld.', 'Streichung des Verbs.', 'Verdopplung der Klammer.'],
    'correctAnswer': 0, 'explanation': 'Ausklammerung: schwere/komplexe Elemente hinter die rechte Klammer.',
    'grammarRule': 'Ausklammerung: Element ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-016', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ausklammerung eines Vergleichs ist korrekt?',
    'options': ['Sie hat besser abgeschnitten als alle anderen Teilnehmer.', 'Sie hat als alle anderen Teilnehmer besser abgeschnitten.', 'Sie hat besser als alle anderen Teilnehmer abgeschnitten.', 'Als alle anderen Teilnehmer sie hat besser abgeschnitten.'],
    'correctAnswer': 0, 'explanation': 'Vergleich mit als: ins Nachfeld ausgeklammert.',
    'grammarRule': 'Ausklammerung: Vergleich ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-018', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Kontrastfokus ist korrekt?',
    'options': ['MORGEN fahren wir, nicht heute.', 'Morgen FAHREN wir, nicht heute.', 'Morgen fahren WIR, nicht heute.', 'Morgen fahren wir, nicht HEUTE.'],
    'correctAnswer': 0, 'explanation': 'Kontrastfokus: MORGEN wird betont (vs. heute).',
    'grammarRule': 'Kontrastfokus: betontes Element im Vorfeld', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-019', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Schaltsatz ist korrekt?',
    'options': ['Die Pruefung war, glaube ich, nicht besonders schwer.', 'Die Pruefung war glaube ich nicht besonders schwer.', 'Glaube ich, die Pruefung war nicht besonders schwer.', 'Die Pruefung, war glaube ich nicht besonders schwer.'],
    'correctAnswer': 0, 'explanation': 'Schaltsatz (glaube ich) durch Kommas eingeschlossen; V2-Stellung.',
    'grammarRule': 'Schaltsatz: Kommas + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'parenthese']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-021', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit als (ohne ob) fuer irrealen Vergleich ist korrekt?',
    'options': ['Sie tat, als waere nichts geschehen.', 'Sie tat, als sie waere nichts geschehen.', 'Sie tat, als nichts geschehen waere.', 'Sie tat als waere nichts geschehen.'],
    'correctAnswer': 0, 'explanation': 'Als + Verb (K.II, Pos. 1): V1-Stellung im irrealen Vergleich.',
    'grammarRule': 'Als + Verb (K.II) + Subjekt: irrealer Vergleich', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-022', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist eine Ellipse?',
    'options': ['Auslassung von Satzgliedern, die aus dem Kontext ergaenzt werden.', 'Verdopplung des Verbs.', 'Hinzufuegung eines NS.', 'Umstellung des Vorfelds.'],
    'correctAnswer': 0, 'explanation': 'Ellipse: kontextuell ergaenzbare Auslassung.',
    'exampleSentence': 'Wann kommst du? – Morgen. (= Ich komme morgen.)',
    'grammarRule': 'Ellipse: kontextuell ergaenzbar', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-023', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit dass-Satz im Vorfeld ist korrekt?',
    'options': ['Dass er so spaet kommt, ueberrascht mich.', 'Dass er so spaet kommt ueberrascht mich.', 'Ueberrascht mich, dass er so spaet kommt.', 'Dass er kommt so spaet, ueberrascht mich.'],
    'correctAnswer': 0, 'explanation': 'Dass-NS im Vorfeld + Komma + Verb (Pos. 2).',
    'grammarRule': 'Dass-NS (Vorfeld) + Komma + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-025', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Scrambling (Akk. vor Dat.) ist korrekt?',
    'options': ['...weil das Buch dem Schueler der Lehrer gegeben hat.', '...weil der Lehrer dem Schueler das Buch gegeben hat.', '...weil gegeben hat der Lehrer dem Schueler das Buch.', '...weil der Lehrer hat dem Schueler das Buch gegeben.'],
    'correctAnswer': 0, 'explanation': 'Scrambling: Akk. vor Dat. vor Subj. (markierte, aber moegliche Abfolge).',
    'grammarRule': 'Scrambling: markierte Abfolge im Mittelfeld', 'subcategory': 'Scrambling', 'tags': ['satzbau', 'scrambling']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-026', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist V1-Exklamativ?',
    'options': ['Verb auf Pos. 1 drueckt Erstaunen aus.', 'Verb am Ende.', 'Verb auf Pos. 3.', 'Verb faellt weg.'],
    'correctAnswer': 0, 'explanation': 'V1-Exklamativ: Ist das aber kalt!',
    'exampleSentence': 'Ist das aber kalt!',
    'grammarRule': 'V1-Exklamativ: Verb (Pos. 1) + Erstaunen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-027', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Partizipialgruppe am Satzanfang ist korrekt?',
    'options': ['Von allen bewundert, betrat die Kuenstlerin die Buehne.', 'Von allen bewundert betrat die Kuenstlerin die Buehne.', 'Betrat die Kuenstlerin die Buehne, von allen bewundert.', 'Die Kuenstlerin von allen bewundert betrat die Buehne.'],
    'correctAnswer': 0, 'explanation': 'Partizipialgruppe + Komma + HS mit Inversion.',
    'grammarRule': 'Partizipialgruppe + Komma + V2', 'subcategory': 'Inversion', 'tags': ['satzbau', 'partizipialgruppe']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-028', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit mag ... auch (konzessiv) ist korrekt?',
    'options': ['Mag das Problem auch komplex sein, eine Loesung gibt es.', 'Das Problem mag auch komplex sein, eine Loesung gibt es.', 'Auch mag das Problem komplex sein, eine Loesung gibt es.', 'Mag auch das Problem komplex sein, eine Loesung gibt es.'],
    'correctAnswer': 0, 'explanation': 'Konzessiver V1-Satz: Mag + Subj. + auch + ...',
    'grammarRule': 'Mag + Subj. + auch: konzessiver V1-Satz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-029', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Wackernagel-Position?',
    'options': ['Unbetonte Pronomen stehen im Mittelfeld moeglichst weit links.', 'Pronomen stehen am Satzende.', 'Pronomen stehen im Nachfeld.', 'Pronomen stehen im Vorfeld.'],
    'correctAnswer': 0, 'explanation': 'Wackernagel: unbetonte/klitische Elemente direkt nach dem finiten Verb.',
    'grammarRule': 'Wackernagel: Pronomen weit links im MF', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-030', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Korrelat darueber ist korrekt?',
    'options': ['Er freut sich darueber, dass sie gewonnen hat.', 'Er freut sich, darueber dass sie gewonnen hat.', 'Er darueber freut sich, dass sie gewonnen hat.', 'Darueber er sich freut, dass sie gewonnen hat.'],
    'correctAnswer': 0, 'explanation': 'Korrelat darueber im HS; dass-Satz im Nachfeld.',
    'grammarRule': 'Korrelat: Praep.adverb + dass-NS', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'korrelat']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-031', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Rechtsversetzung ist korrekt?',
    'options': ['Er ist wirklich nett, der neue Nachbar.', 'Der neue Nachbar er ist wirklich nett.', 'Nett ist er wirklich, der neue Nachbar.', 'Der neue Nachbar, nett ist er wirklich.'],
    'correctAnswer': 0, 'explanation': 'Rechtsversetzung: Pronomen im Satz + NP im Nachfeld.',
    'grammarRule': 'Rechtsversetzung: Pronomen + NP (Nachfeld)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'rechtsversetzung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-032', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die kanonische Wortstellung im HS?',
    'options': ['Subjekt + Verb (Pos. 2) + Mittelfeld + infiniter Verbteil.', 'Verb + Subjekt + Objekt.', 'Subjekt + Objekt + Verb.', 'Verb + Objekt + Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Kanonisch: Subj. (VF) + Verb (Pos. 2) + MF + rechte Klammer.',
    'grammarRule': 'Kanonisch: Subj. + V2 + MF + RK', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-033', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Linksversetzung ist korrekt?',
    'options': ['Den alten Computer, den kann man nicht mehr reparieren.', 'Kann den alten Computer, den man nicht mehr reparieren.', 'Den alten Computer den kann man nicht mehr reparieren.', 'Man den alten Computer, den kann nicht mehr reparieren.'],
    'correctAnswer': 0, 'explanation': 'Linksversetzung: NP + Pronomen-Wiederaufnahme im Vorfeld.',
    'grammarRule': 'Linksversetzung: NP + Pronomen', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'topikalisierung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-034', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit obschon + HS (Inversion) ist korrekt?',
    'options': ['Obschon sie wenig uebte, bestand sie die Pruefung.', 'Obschon sie uebte wenig, bestand sie die Pruefung.', 'Obschon uebte sie wenig, bestand sie die Pruefung.', 'Obschon wenig sie uebte, bestand sie die Pruefung.'],
    'correctAnswer': 0, 'explanation': 'Obschon-NS (Verb am Ende) + Komma + HS (Inversion).',
    'grammarRule': 'Obschon + NS + HS (Inversion)', 'subcategory': 'Inversion', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-036', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Spaltsatz ist korrekt?',
    'options': ['Es war der Regen, der die Ernte zerstoert hat.', 'Es war, der Regen der die Ernte zerstoert hat.', 'Der Regen es war, der die Ernte zerstoert hat.', 'Es der Regen war, der die Ernte zerstoert hat.'],
    'correctAnswer': 0, 'explanation': 'Spaltsatz: Es war + fokussiertes Element + RS.',
    'grammarRule': 'Spaltsatz: Es war + Fokus + RS', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'spaltsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-037', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Gradpartikel nur ist korrekt?',
    'options': ['Nur am Wochenende hat er Zeit.', 'Am Wochenende nur hat er Zeit.', 'Am Wochenende hat er nur Zeit.', 'Hat nur am Wochenende er Zeit.'],
    'correctAnswer': 0, 'explanation': 'Gradpartikel nur vor dem fokussierten Element (am Wochenende).',
    'grammarRule': 'Gradpartikel: vor dem fokussierten Element', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'fokuspartikel']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-038', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist der V2-Effekt bei weil?',
    'options': ['Umgangssprachlich: weil + V2-Stellung statt Verbendstellung.', 'Weil erlaubt nie V2.', 'Weil hat immer V1.', 'Weil ist kein Konnektor.'],
    'correctAnswer': 0, 'explanation': 'V2-weil: umgangssprachlich verbreitet, zeigt eigenstaendige Assertion.',
    'grammarRule': 'V2-weil: Verb auf Pos. 2 (umgangssprachlich)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-039', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Passiv-Satzklammer ist korrekt?',
    'options': ['Das Haus wird naechstes Jahr renoviert.', 'Das Haus wird renoviert naechstes Jahr.', 'Das Haus naechstes Jahr wird renoviert.', 'Renoviert wird das Haus naechstes Jahr.'],
    'correctAnswer': 0, 'explanation': 'Passiv: wird (linke Klammer) + MF + Partizip II (rechte Klammer).',
    'grammarRule': 'Passiv: wird + ... + Partizip II', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-040', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Infinitivsatz (um ... zu) ist korrekt?',
    'options': ['Er lernt viel, um die Pruefung zu bestehen.', 'Er lernt viel um die Pruefung bestehen zu.', 'Er lernt viel, um zu bestehen die Pruefung.', 'Um die Pruefung zu bestehen er lernt viel.'],
    'correctAnswer': 0, 'explanation': 'Um ... zu + Infinitiv: Komma + um + ... + zu + Infinitiv (Ende).',
    'grammarRule': 'Um ... zu: Komma + um + ... + zu + Inf.', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'infinitivsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-042', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Gewichtsverschiebung ist korrekt?',
    'options': ['Er hat gestern angerufen bei der Firma, die fuer internationale Projekte zustaendig ist.', 'Er hat gestern bei der Firma, die fuer internationale Projekte zustaendig ist, angerufen.', 'Er hat gestern angerufen, bei der Firma die fuer internationale Projekte zustaendig ist.', 'Bei der Firma er hat gestern angerufen, die fuer internationale Projekte zustaendig ist.'],
    'correctAnswer': 0, 'explanation': 'Schwere PP + RS ins Nachfeld verschoben (Ausklammerung).',
    'grammarRule': 'Gewichtsverschiebung: schwere PP ins Nachfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ausklammerung']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-044', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit wie + Adj. + auch (konzessiv) ist korrekt?',
    'options': ['Wie gross die Schwierigkeiten auch sein moegen, wir geben nicht auf.', 'Wie gross auch die Schwierigkeiten sein moegen, wir geben nicht auf.', 'Wie die Schwierigkeiten gross auch sein moegen, wir geben nicht auf.', 'Gross wie die Schwierigkeiten auch sein moegen, wir geben nicht auf.'],
    'correctAnswer': 0, 'explanation': 'Konzessiver wie-Satz: wie + Adj. + Subj. + auch + Verb.',
    'grammarRule': 'Wie + Adj. + Subj. + auch + Verb: konzessiv', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-045', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Right Node Raising (RNR)?',
    'options': ['Gemeinsames Element am Ende koordinierter Saetze nur einmal realisiert.', 'Verb wird verdoppelt.', 'Subjekt am Ende.', 'Zwei NS verschmolzen.'],
    'correctAnswer': 0, 'explanation': 'RNR: Er mag und sie liebt klassische Musik.',
    'exampleSentence': 'Er mag und sie liebt klassische Musik.',
    'grammarRule': 'RNR: gemeinsames Element am Ende', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-046', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit dreifacher NS-Einbettung ist korrekt?',
    'options': ['Er sagt, dass er hofft, dass sie versteht, dass es wichtig ist.', 'Er sagt, dass er hofft, dass sie versteht, dass ist es wichtig.', 'Er sagt, dass er hofft, dass versteht sie, dass es wichtig ist.', 'Er sagt dass er hofft dass sie versteht dass es wichtig ist.'],
    'correctAnswer': 0, 'explanation': 'Jeder NS hat Verbendstellung; Kommas trennen.',
    'grammarRule': 'Verschachtelte NS: Verb am Ende', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-047', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Topik-Drop?',
    'options': ['Auslassung des Topiks im Vorfeld (umgangssprachlich).', 'Verdopplung des Subjekts.', 'Auslassung des Verbs.', 'Hinzufuegung des NS.'],
    'correctAnswer': 0, 'explanation': 'Topik-Drop: (Ich) Hab keine Zeit. (Das) Weiss ich nicht.',
    'grammarRule': 'Topik-Drop: Topik ausgelassen', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-048', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit resumptivem so ist korrekt?',
    'options': ['Wenn du kommst, so werde ich mich freuen.', 'Wenn du kommst, werde ich so mich freuen.', 'So wenn du kommst, werde ich mich freuen.', 'Wenn du kommst, ich werde so mich freuen.'],
    'correctAnswer': 0, 'explanation': 'Resumptives so im HS nach vorangestelltem NS (gehoben).',
    'grammarRule': 'Resumptives so: NS + , so + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'verbposition']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-049', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der Verbklammer?',
    'options': ['Sie schafft eine Rahmenstruktur um das Mittelfeld.', 'Es gibt keine Verbklammer.', 'Nur NS haben eine Klammer.', 'Die Klammer umschliesst nur das Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Verbklammer: LK (Verb) + MF + RK (infiniter Teil) = Rahmen.',
    'grammarRule': 'Verbklammer: Rahmen um das Mittelfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-050', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit koordinierten NS ist korrekt?',
    'options': ['Er weiss, dass sie kommt und dass er warten muss.', 'Er weiss, dass sie kommt und er warten muss dass.', 'Er weiss dass sie kommt, und dass er warten muss.', 'Er weiss, dass sie kommt, und dass muss er warten.'],
    'correctAnswer': 0, 'explanation': 'Koordinierte dass-Saetze: jeweils Verb am Ende.',
    'grammarRule': 'Koordinierte NS: Verb am Ende', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-051', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'zumal\'-Nebensatz ist korrekt?',
    'options': ['Er blieb zu Hause, zumal er sich nicht wohlfuehlte.', 'Er blieb zu Hause, zumal er sich wohlfuehlte nicht.', 'Er blieb zu Hause zumal, er sich nicht wohlfuehlte.', 'Zumal er sich nicht wohlfuehlte er blieb zu Hause.'],
    'correctAnswer': 0, 'explanation': '\'Zumal\' leitet einen kausalen Nebensatz ein (Verb am Ende), steht meist nachgestellt.',
    'grammarRule': 'Zumal + NS (VE): nachgestellter Kausalsatz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-052', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'obschon\' zeigt korrekte Verbstellung?',
    'options': ['Obschon er muede war, arbeitete er weiter.', 'Obschon er war muede, arbeitete er weiter.', 'Obschon muede er war, arbeitete er weiter.', 'Obschon er muede war arbeitete er weiter.'],
    'correctAnswer': 0, 'explanation': '\'Obschon\' leitet konzessiven NS ein (Verb am Ende) + HS mit Inversion.',
    'grammarRule': 'Obschon + NS (VE) + HS (V2)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-053', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welche Stellung hat das Adverb \'allerdings\' als Konnektor?',
    'options': ['Er versprach es. Allerdings hielt er sein Wort nicht.', 'Er versprach es. Allerdings er hielt sein Wort nicht.', 'Er versprach es. Hielt allerdings er sein Wort nicht.', 'Er versprach es allerdings. Hielt er sein Wort nicht.'],
    'correctAnswer': 0, 'explanation': '\'Allerdings\' als Satzadverb im Vorfeld: Allerdings + V2 + Subjekt (Inversion).',
    'grammarRule': 'Allerdings (Vorfeld) + V2 + Subjekt', 'subcategory': 'Inversion', 'tags': ['satzbau', 'konnektor']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-054', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit komplexem Vorfeld ist korrekt?',
    'options': ['Erst nachdem alle gegangen waren, raeumte er auf.', 'Erst nachdem alle gegangen waren raeumte er auf.', 'Nachdem erst alle gegangen waren, raeumte er auf.', 'Erst nachdem alle waren gegangen, raeumte er auf.'],
    'correctAnswer': 0, 'explanation': 'Komplexes Vorfeld: \'erst\' + ganzer NS im Vorfeld + Komma + V2.',
    'grammarRule': 'Komplexes Vorfeld: Partikel + NS + V2', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'vorfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-055', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Was ist Scrambling im deutschen Mittelfeld?',
    'options': ['Die freie Umstellung von Satzgliedern im Mittelfeld.', 'Die Tilgung des Verbs.', 'Die Verdoppelung des Subjekts.', 'Die Ausklammerung aller Objekte.'],
    'correctAnswer': 0, 'explanation': 'Scrambling: freie Umstellung der Satzglieder im Mittelfeld (zwischen LK und RK).',
    'grammarRule': 'Scrambling: freie Stellung im Mittelfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'mittelfeld']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-056', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'soweit\'-Nebensatz zeigt korrekte Wortstellung?',
    'options': ['Soweit mir bekannt ist, findet die Sitzung statt.', 'Soweit mir bekannt ist findet die Sitzung statt.', 'Soweit mir ist bekannt, findet die Sitzung statt.', 'Soweit bekannt mir ist, findet die Sitzung statt.'],
    'correctAnswer': 0, 'explanation': '\'Soweit\' leitet NS ein (Verb am Ende) + Komma + HS (Inversion).',
    'grammarRule': 'Soweit + NS (VE) + HS (V2)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-057', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Ellipse im zweiten Konjunkt ist korrekt?',
    'options': ['Er liest Buecher und sie Zeitungen.', 'Er liest Buecher und sie liest Zeitungen.', 'Er liest Buecher und Zeitungen sie.', 'Er Buecher liest und sie Zeitungen.'],
    'correctAnswer': 0, 'explanation': 'Gapping: Das Verb im zweiten Konjunkt kann getilgt werden bei Koordination.',
    'grammarRule': 'Gapping: Verbtilgung im zweiten Konjunkt', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'ellipse']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-058', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit weiterführendem Relativsatz ist korrekt?',
    'options': ['Er bestand die Pruefung, was alle ueberraschte.', 'Er bestand die Pruefung was alle ueberraschte.', 'Was alle ueberraschte, er bestand die Pruefung.', 'Er bestand die Pruefung, was ueberraschte alle.'],
    'correctAnswer': 0, 'explanation': 'Weiterfuehrender RS mit \'was\': bezieht sich auf den ganzen Satz, Verb am Ende.',
    'grammarRule': 'Weiterfuehrender RS: Satz, + was + ... + Verb (Ende)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'relativsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-059', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit Satzverschraenkung ist korrekt?',
    'options': ['Den Mann, den ich gesehen habe, kenne ich nicht.', 'Den Mann ich gesehen habe, den kenne ich nicht.', 'Den Mann, den ich habe gesehen, kenne ich nicht.', 'Den Mann den, ich gesehen habe, kenne ich nicht.'],
    'correctAnswer': 0, 'explanation': 'Der RS ist in den HS eingeschoben: HS-Anfang + RS + HS-Ende.',
    'grammarRule': 'Satzverschraenkung: HS + eingebetteter RS + HS-Fortsetzung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'relativsatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-060', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'es sei denn\' ist korrekt?',
    'options': ['Wir fahren morgen, es sei denn, es regnet.', 'Wir fahren morgen es sei denn es regnet.', 'Wir fahren morgen, es sei denn es regnet.', 'Es sei denn es regnet, wir fahren morgen.'],
    'correctAnswer': 0, 'explanation': '\'Es sei denn\' leitet eine Ausnahme ein: HS + Komma + es sei denn + Komma + NS/HS.',
    'grammarRule': 'Es sei denn: HS, + es sei denn, + Bedingung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'konjunktion']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-061', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Welcher Satz mit \'um so mehr als\' ist korrekt?',
    'options': ['Die Kritik trifft ihn, um so mehr als er sich bemuehte.', 'Die Kritik trifft ihn um so mehr als er sich bemuehte.', 'Die Kritik trifft ihn, um so mehr als bemuehte er sich.', 'Um so mehr als er sich bemuehte die Kritik trifft ihn.'],
    'correctAnswer': 0, 'explanation': '\'Um so mehr als\' verstaerkt kausal; leitet NS ein (Verb am Ende).',
    'grammarRule': 'Um so mehr als + NS (VE)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'nebensatz']
  },
  {
    'language': 'german', 'id': 'c1-satzbau-p4-062', 'level': 'c1', 'category': 'Satzstruktur',
    'question': 'Wo steht das Subjekt, wenn ein Pronomen-Objekt im Mittelfeld vorkommt?',
    'options': ['Gestern hat es ihm der Chef gesagt.', 'Gestern hat der Chef es ihm gesagt.', 'Gestern hat ihm es der Chef gesagt.', 'Gestern der Chef hat es ihm gesagt.'],
    'correctAnswer': 0, 'explanation': 'Pronominale Objekte stehen vor nominalen Satzgliedern. \'es ihm\' vor \'der Chef\'.',
    'grammarRule': 'Pronomen vor Nomen im Mittelfeld', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'mittelfeld']
  }
];

export default questions;
