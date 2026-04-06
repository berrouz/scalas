import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbau-p3-005', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Aposiopese?',
    'options': ['Bewusster Satzabbruch fuer Spannung, Drohung oder Emotion.', 'Satzverlaengerung.', 'Verdopplung des Verbs.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Aposiopese: Wenn du nicht sofort –! (Drohung durch Abbruch)',
    'grammarRule': 'Aposiopese: bewusster Abbruch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-006', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Durchbrechung der Satzklammer (literarisch)?',
    'options': ['Er hatte sich verirrt in einem Labyrinth aus Gaengen und Treppen.', 'Er hatte sich in einem Labyrinth aus Gaengen und Treppen verirrt.', 'Er hatte verirrt sich in einem Labyrinth aus Gaengen und Treppen.', 'In einem Labyrinth er hatte sich verirrt aus Gaengen und Treppen.'],
    'correctAnswer': 0, 'explanation': 'Literarische Ausklammerung: PP nach Partizip fuer Nachklang-Effekt.',
    'grammarRule': 'Literarische Ausklammerung: Nachklang', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-007', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Anapher und Epipher?',
    'options': ['Anapher: Wiederholung am Satzanfang. Epipher: Wiederholung am Satzende.', 'Kein Unterschied.', 'Anapher = Auslassung. Epipher = Verdopplung.', 'Anapher: am Ende. Epipher: am Anfang.'],
    'correctAnswer': 0, 'explanation': 'Anapher: gleicher Anfang. Epipher: gleiches Ende. Symploke: beides.',
    'grammarRule': 'Anapher (Anfang) vs. Epipher (Ende)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-008', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Klimax (Steigerung) durch Satzstruktur?',
    'options': ['Er war unzufrieden, dann wuetend, schliesslich rasend vor Zorn.', 'Er war rasend vor Zorn, dann wuetend, schliesslich unzufrieden.', 'Er war wuetend.', 'Er war sehr wuetend und unzufrieden.'],
    'correctAnswer': 0, 'explanation': 'Klimax: stufenweise Steigerung der Intensitaet.',
    'grammarRule': 'Klimax: Steigerung durch Reihung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-009', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion des Nachtrags?',
    'options': ['Praezisierung, Korrektur oder emotionaler Nachhall nach dem Satzschluss.', 'Keine Funktion.', 'Vorwegnahme.', 'Streichung.'],
    'correctAnswer': 0, 'explanation': 'Nachtrag: Er verliess die Stadt. Fuer immer. (emotionaler Nachhall)',
    'grammarRule': 'Nachtrag: Praezisierung/emotionaler Nachhall', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-010', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Chiasmus mit inhaltlichem Kontrast?',
    'options': ['Was der eine baut, reisst der andere nieder.', 'Der eine baut und der andere reisst nieder.', 'Einer baut, einer reisst nieder.', 'Bauen und Niederreissen wechseln sich ab.'],
    'correctAnswer': 0, 'explanation': 'Chiasmus: Kreuzstellung (Was-Obj.+Verb / Verb+Obj.) + inhaltlicher Kontrast.',
    'grammarRule': 'Chiasmus: Kreuzstellung + Kontrast', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-011', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Parenthese als Mittel der Ironie?',
    'options': ['Einschub, der die Aussage des HS ironisch kommentiert.', 'Ein ernster Einschub.', 'Auslassung des Verbs.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Ironische Parenthese: Er war – wie koennte es anders sein – zu spaet.',
    'grammarRule': 'Ironische Parenthese: kommentierender Einschub', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-012', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antiklimax als Stilmittel?',
    'options': ['Er verlor sein Haus, sein Auto und seinen Kugelschreiber.', 'Er verlor seinen Kugelschreiber, sein Auto und sein Haus.', 'Er verlor alles.', 'Er verlor nichts.'],
    'correctAnswer': 0, 'explanation': 'Antiklimax: absteigende Reihung (vom Grossen zum Kleinen) fuer Ironie/Ueberraschung.',
    'grammarRule': 'Antiklimax: absteigende Reihung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-013', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist erlebte Rede (freie indirekte Rede)?',
    'options': ['Mischform: Erzaehlerperspektive (Praeteritum) + Figurengedanken (V2, ohne Konjunktion).', 'Direkte Rede.', 'Indirekte Rede mit dass.', 'Nur Konjunktiv I.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: Sie blickte hinaus. Was sollte sie tun? (Figur denkt, Erzaehler berichtet)',
    'grammarRule': 'Erlebte Rede: Praeteritum + V2 + Figurenperspektive', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-014', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Hyperbaton in gehobener Sprache?',
    'options': ['Still lag das Dorf im Tal.', 'Das Dorf lag still im Tal.', 'Im Tal lag das stille Dorf.', 'Das stille Dorf im Tal lag da.'],
    'correctAnswer': 0, 'explanation': 'Hyperbaton: Still von seinem Bezug (Dorf) getrennt ins Vorfeld.',
    'grammarRule': 'Hyperbaton: Adjektiv vom Nomen getrennt', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-015', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung der Parataxe in der Moderne?',
    'options': ['Sachlichkeit, Naehe zur muendlichen Sprache, Tempo.', 'Komplexitaet und Tiefe.', 'Formalitaet.', 'Langsamkeit.'],
    'correctAnswer': 0, 'explanation': 'Moderne Parataxe: kurze HS = Sachlichkeit, Tempo, muendlicher Duktus.',
    'grammarRule': 'Parataxe: Sachlichkeit/Tempo', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-016', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Parallelismus mit Antithese?',
    'options': ['Der Weise schweigt, der Tor spricht.', 'Der Weise und der Tor verhalten sich unterschiedlich.', 'Sowohl der Weise als auch der Tor haben ihre Eigenarten.', 'Der Weise spricht wenig und der Tor zu viel.'],
    'correctAnswer': 0, 'explanation': 'Parallelismus + Antithese: gleiche Struktur, gegensaetzlicher Inhalt.',
    'grammarRule': 'Parallelismus + Antithese: gleiche Struktur, Kontrast', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-017', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Katapher?',
    'options': ['Vorwaertsverweisung: ein Pronomen verweist auf ein nachfolgendes Element.', 'Rueckwaertsverweisung.', 'Auslassung.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Katapher: Das ueberraschte mich: sein ploetzliches Verschwinden.',
    'grammarRule': 'Katapher: Vorwaertsverweisung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-018', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Correctio als rhetorisches Mittel?',
    'options': ['Er war tapfer – nein, tollkuehn ging er ins Gefecht.', 'Er war tapfer und tollkuehn.', 'Er war sehr tapfer.', 'Er ging tapfer ins Gefecht.'],
    'correctAnswer': 0, 'explanation': 'Correctio: Selbstkorrektur mit Steigerung (tapfer -> tollkuehn).',
    'grammarRule': 'Correctio: Selbstkorrektur/Steigerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-019', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt der Nachstellung des Subjekts (Inversion)?',
    'options': ['Betonung des vorangestellten Elements; das Subjekt tritt zurueck.', 'Betonung des Subjekts.', 'Keine Wirkung.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Inversion: das Vorfeldelement wird betont; das Subjekt rueckt in den Hintergrund.',
    'grammarRule': 'Inversion: Betonung des Vorfeldelements', 'subcategory': 'Inversion', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-020', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Zeugma als Stilmittel?',
    'options': ['Er ergriff das Wort und die Flucht.', 'Er ergriff das Wort und floh.', 'Er sprach und floh dann.', 'Er ergriff zuerst das Wort und dann die Flucht.'],
    'correctAnswer': 0, 'explanation': 'Zeugma: ergreifen in zwei Bedeutungen (Wort ergreifen / Flucht ergreifen).',
    'grammarRule': 'Zeugma: ein Verb, zwei Bedeutungen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-021', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der erlebten Rede in der Satzstruktur?',
    'options': ['V2-Stellung + Praeteritum + Figurenperspektive, ohne Redeeinleitung.', 'VL-Stellung + Konjunktiv.', 'Direkte Rede + Anfuehrungszeichen.', 'Indirekte Rede + dass.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: HS-Struktur (V2) + Praeteritum + Figur denkt/fuehlt.',
    'grammarRule': 'Erlebte Rede: V2 + Praeteritum + Figurenperspektive', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-022', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Emphase durch Voranstellung des Infinitivs?',
    'options': ['Vergessen kann man so etwas nicht.', 'Man kann so etwas nicht vergessen.', 'So etwas kann man nicht vergessen.', 'Man vergisst so etwas nicht.'],
    'correctAnswer': 0, 'explanation': 'Infinitiv im Vorfeld: emphatisch, betont die Handlung (Vergessen).',
    'grammarRule': 'Infinitiv im Vorfeld: emphatisch', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-023', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anakoluth in der literarischen Prosa?',
    'options': ['Bewusster Satzbruch, der Gedankenspruenge oder Verwirrung abbildet.', 'Grammatisch korrekter Satz.', 'Ein Parallelismus.', 'Eine Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Literarisches Anakoluth: Satzbruch bildet innere Unruhe oder Verwirrung ab.',
    'grammarRule': 'Anakoluth: Satzbruch = innere Unruhe', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-024', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Akkumulation fuer rhetorischen Effekt?',
    'options': ['Hunger, Durst, Muedigkeit, Kaelte, Angst – nichts konnte ihn aufhalten.', 'Nichts konnte ihn aufhalten, weder Hunger noch Durst.', 'Er litt unter vielem.', 'Trotz Hunger und Durst ging er weiter.'],
    'correctAnswer': 0, 'explanation': 'Akkumulation: Reihung + zusammenfassendes Element (nichts) = Eindringlichkeit.',
    'grammarRule': 'Akkumulation: Reihung + Zusammenfassung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-025', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Gradatio?',
    'options': ['Stufenweise Steigerung von Element zu Element.', 'Abstufung.', 'Gleichbleibende Intensitaet.', 'Auslassung.'],
    'correctAnswer': 0, 'explanation': 'Gradatio: jedes Element steigert das vorherige (Stufe fuer Stufe).',
    'grammarRule': 'Gradatio: stufenweise Steigerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-026', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Koncinnitas (ausgewogenen Satzbau)?',
    'options': ['Wer viel redet, sagt wenig; wer wenig redet, sagt viel.', 'Manche reden viel, andere wenig.', 'Man sollte weniger reden.', 'Viel reden bringt nichts.'],
    'correctAnswer': 0, 'explanation': 'Koncinnitas: symmetrischer, ausgewogener Bau (Wer ... ; wer ...).',
    'grammarRule': 'Koncinnitas: symmetrischer Satzbau', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-027', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt kurzer parataktischer Saetze?',
    'options': ['Tempo, Spannung, Eindringlichkeit, Sachlichkeit.', 'Komplexitaet und Tiefe.', 'Langsamkeit.', 'Formalitaet.'],
    'correctAnswer': 0, 'explanation': 'Kurze Parataxe: Er kam. Er sah. Er siegte. -> Tempo, Spannung.',
    'grammarRule': 'Kurze Parataxe: Tempo/Spannung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-028', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Epexegese (nachtraegliche Erklaerung)?',
    'options': ['Er sprach die Wahrheit – eine Wahrheit, die niemand hoeren wollte.', 'Er sprach eine Wahrheit, die niemand hoeren wollte.', 'Die Wahrheit, die er sprach, wollte niemand hoeren.', 'Niemand wollte die Wahrheit hoeren, die er sprach.'],
    'correctAnswer': 0, 'explanation': 'Epexegese: nachtraegliche Praezisierung/Erklaerung nach Gedankenstrich.',
    'grammarRule': 'Epexegese: nachtraegliche Erklaerung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-029', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Fuge-Stil und Reihungs-Stil?',
    'options': ['Fuge: verschachtelte Hypotaxe. Reihung: aneinandergereihte Parataxe.', 'Kein Unterschied.', 'Fuge = kurze Saetze. Reihung = lange Saetze.', 'Beide sind identisch.'],
    'correctAnswer': 0, 'explanation': 'Fuge-Stil (z.B. Thomas Mann): komplexe Verschachtelung. Reihungs-Stil (z.B. Hemingway): einfache Reihung.',
    'grammarRule': 'Fuge (Hypotaxe) vs. Reihung (Parataxe)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-030', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Praeteritio?',
    'options': ['Ich will gar nicht erwaehnen, dass er dreimal durchgefallen ist.', 'Er ist dreimal durchgefallen.', 'Ich erwaehne nicht, dass er Probleme hatte.', 'Seine Probleme sind bekannt.'],
    'correctAnswer': 0, 'explanation': 'Praeteritio: Erwaehnung durch vermeintliche Nicht-Erwaehnung.',
    'grammarRule': 'Praeteritio: Erwaehnung durch Nicht-Erwaehnung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-031', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Sperrung in Lyrik?',
    'options': ['Spannung und Rhythmus durch Distanz zusammengehoeriger Elemente.', 'Klarheit.', 'Kuere.', 'Keine Funktion.'],
    'correctAnswer': 0, 'explanation': 'Sperrung in Lyrik: Spannung + metrischer Rhythmus.',
    'grammarRule': 'Sperrung: Spannung + Rhythmus', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-032', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Verbletztstellung im HS (archaisch)?',
    'options': ['Wer den Mut hat, der siege. (archaisch/literarisch)', 'Wer Mut hat, der soll siegen.', 'Der Mutige siegt.', 'Siegen soll, wer Mut hat.'],
    'correctAnswer': 0, 'explanation': 'Archaische VL im HS: literarisch, biblisch, feierlich.',
    'grammarRule': 'Archaische VL im HS: feierlich/literarisch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-033', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Hendiadyoin?',
    'options': ['Ein Begriff durch zwei koordinierte Ausdruecke (Rat und Hilfe = hilfreicher Rat).', 'Zwei verschiedene Begriffe.', 'Ein Wort in zwei Saetzen.', 'Auslassung.'],
    'correctAnswer': 0, 'explanation': 'Hendiadyoin: Feuer und Flamme (= begeistert), Hab und Gut (= Besitz).',
    'grammarRule': 'Hendiadyoin: ein Begriff in zwei Woertern', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-034', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Anapher (Wiederholung am Anfang)?',
    'options': ['Kein Licht, kein Ton, kein Zeichen von Leben.', 'Es gab weder Licht noch Ton noch Zeichen von Leben.', 'Alles war dunkel und still.', 'Nichts war zu sehen oder zu hoeren.'],
    'correctAnswer': 0, 'explanation': 'Anapher: kein ... kein ... kein ... (Wiederholung am Glied-Anfang).',
    'grammarRule': 'Anapher: gleicher Anfang wiederholt', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-035', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der rhetorischen Frage?',
    'options': ['Scheinbare Frage, die die eigene These verstaerkt.', 'Echte Informationsfrage.', 'Auslassung.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Rhetorische Frage: Antwort impliziert -> verstaerkt die Aussage.',
    'grammarRule': 'Rhetorische Frage: Verstaerkung der These', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-036', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Asyndeton fuer schnelles Erzaehltempo?',
    'options': ['Er rannte, stolperte, fiel, stand auf, rannte weiter.', 'Er rannte und stolperte und fiel und stand auf und rannte weiter.', 'Er rannte, bevor er stolperte und fiel.', 'Nachdem er gerannt war, stolperte er und fiel.'],
    'correctAnswer': 0, 'explanation': 'Asyndeton: Reihung ohne und -> schnelles Tempo, Atemlosigkeit.',
    'grammarRule': 'Asyndeton: schnelles Tempo', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-037', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Satzperiode in der Rede?',
    'options': ['Aufbau von Spannung, die sich in der Apodosis loest.', 'Kuere und Klarheit.', 'Schnelles Tempo.', 'Fragmentierung.'],
    'correctAnswer': 0, 'explanation': 'Satzperiode in Reden: NS-Kette (Protasis) baut Spannung auf -> HS loest auf.',
    'grammarRule': 'Satzperiode: Spannung -> Aufloesung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-038', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Polysyndeton fuer Feierlichkeit?',
    'options': ['Und die Berge und die Taealer und die Fluesse lagen im Licht.', 'Die Berge, Taeler und Fluesse lagen im Licht.', 'Alles lag im Licht.', 'Berge, Taeler, Fluesse – alles lag im Licht.'],
    'correctAnswer': 0, 'explanation': 'Polysyndeton: und ... und ... und -> Feierlichkeit, Gewichtung jedes Elements.',
    'grammarRule': 'Polysyndeton: Feierlichkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-039', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung der Ellipse im Telegrammstil?',
    'options': ['Kuere, Dringlichkeit, Sachlichkeit.', 'Ausfuehrlichkeit.', 'Formalitaet.', 'Langsamkeit.'],
    'correctAnswer': 0, 'explanation': 'Telegrammstil: Ankunft 14 Uhr. Bitte abholen. -> Kuere, Dringlichkeit.',
    'grammarRule': 'Telegrammstil: Kuere/Dringlichkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-040', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Oxymoron als stilistische Figur?',
    'options': ['Ein offenes Geheimnis lag ueber der Stadt.', 'Die Stadt hatte ein Geheimnis.', 'Das Geheimnis war allen bekannt.', 'Niemand kannte das Geheimnis.'],
    'correctAnswer': 0, 'explanation': 'Oxymoron: offenes Geheimnis – widersprüchliche Verbindung.',
    'grammarRule': 'Oxymoron: widersprüchliche Verbindung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-041', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Iskolon in rhetorischen Texten?',
    'options': ['Parallele Glieder mit gleicher Laenge und gleichem Rhythmus.', 'Ungleiche Glieder.', 'Auslassung.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Isokolon: Gleiche Laenge, gleicher Rhythmus -> Harmonie, Emphase.',
    'grammarRule': 'Isokolon: Gleiche Laenge/Rhythmus', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-042', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Abweichung von V2 (Verb-Erst) fuer poetischen Effekt?',
    'options': ['Rauschen die Baeume im Wind.', 'Die Baeume rauschen im Wind.', 'Im Wind rauschen die Baeume.', 'Die Baeume, die im Wind rauschen.'],
    'correctAnswer': 0, 'explanation': 'V1 in Lyrik: poetisch, evokativ, bildhaft.',
    'grammarRule': 'Poetische V1: evokativ/bildhaft', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-043', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Tmesis bei trennbaren Verben?',
    'options': ['Maximale Klammerweite erzeugt Spannung bis zur Aufloesung.', 'Keine Funktion.', 'Verkuerzung.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Tmesis/Satzklammer: Je weiter LK und RK auseinander, desto groesser die Spannung.',
    'grammarRule': 'Tmesis: Spannung durch maximale Klammerweite', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-044', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Trikolon (Dreierformel) mit Klimax?',
    'options': ['Er war beunruhigt, besorgt, entsetzt.', 'Er war entsetzt, besorgt, beunruhigt.', 'Er war besorgt.', 'Er war sehr beunruhigt.'],
    'correctAnswer': 0, 'explanation': 'Trikolon + Klimax: drei Glieder mit steigender Intensitaet.',
    'grammarRule': 'Trikolon + Klimax: drei steigende Glieder', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-045', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion des Vorfelds in persuasiven Texten?',
    'options': ['Steuerung der Aufmerksamkeit: das Vorfeldelement wird als erstes wahrgenommen.', 'Keine besondere Funktion.', 'Nur syntaktische Pflicht.', 'Immer das Subjekt.'],
    'correctAnswer': 0, 'explanation': 'In Reden/Werbung: Vorfeldelement steuert Aufmerksamkeit (Topik-Kontrolle).',
    'grammarRule': 'Vorfeld: Aufmerksamkeitssteuerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-046', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Geminatio fuer emotionalen Nachdruck?',
    'options': ['Nie, nie werde ich das vergessen!', 'Ich werde das nie vergessen.', 'Das werde ich nicht vergessen.', 'Niemals vergesse ich das.'],
    'correctAnswer': 0, 'explanation': 'Geminatio: Nie, nie – direkte Wiederholung fuer emotionalen Nachdruck.',
    'grammarRule': 'Geminatio: Wiederholung fuer Nachdruck', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-047', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung des Enjambements in Prosa?',
    'options': ['Gedanke fliesst ueber die Satzgrenze hinweg: Dynamik, Kontinuitaet.', 'Abbruch.', 'Statik.', 'Isolation.'],
    'correctAnswer': 0, 'explanation': 'Enjambement: Satzglied ueber Satzgrenze/Zeilenende -> Fluss, Dynamik.',
    'grammarRule': 'Enjambement: Fluss/Dynamik', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-048', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Kyklos (Ringkomposition)?',
    'options': ['Vergebens suchte er, er suchte vergebens.', 'Er suchte vergebens.', 'Vergebens war seine Suche.', 'Er suchte und fand nichts.'],
    'correctAnswer': 0, 'explanation': 'Kyklos: gleiches Element am Anfang und Ende -> Abgeschlossenheit.',
    'grammarRule': 'Kyklos: Ringkomposition', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-049', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Unterschied zwischen Satzverschraenkung und Prolepse?',
    'options': ['Satzverschraenkung: NS-Element -> VF des HS. Prolepse: NS-Element -> MF/Akk. des HS.', 'Kein Unterschied.', 'Prolepse = Rechtsversetzung.', 'Satzverschraenkung = Ellipse.'],
    'correctAnswer': 0, 'explanation': 'Satzverschraenkung: VF-Besetzung. Prolepse: Akkusativ-Objekt im HS.',
    'grammarRule': 'Satzverschraenkung (VF) vs. Prolepse (Akk.)', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-050', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antithese mit chiastischer Struktur?',
    'options': ['Der Mensch denkt, und Gott lenkt.', 'Der Mensch und Gott haben verschiedene Plaene.', 'Der Mensch denkt viel, Gott lenkt wenig.', 'Gott lenkt, und der Mensch denkt.'],
    'correctAnswer': 0, 'explanation': 'Antithese + Chiasmus: Mensch-denkt / Gott-lenkt (Kreuzstellung + Kontrast).',
    'grammarRule': 'Antithese + Chiasmus: Kontrast + Kreuzstellung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-051', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Isocolon in der Rhetorik?',
    'options': ['Gleichbau aufeinanderfolgender Satzglieder oder Saetze.', 'Ungleiche Satzlaenge.', 'Satzbruch.', 'Verdoppelung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Isocolon: gleiche syntaktische Struktur und aehnliche Laenge in parallelen Einheiten.',
    'grammarRule': 'Isocolon: gleicher Bau + aehnliche Laenge', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-052', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Correctio (Selbstkorrektur) als Stilmittel?',
    'options': ['Er war klug – nein, er war genial.', 'Er war klug und genial.', 'Er war nicht klug, sondern genial.', 'Obwohl er klug war, war er genial.'],
    'correctAnswer': 0, 'explanation': 'Correctio: bewusste Selbstkorrektur zur Steigerung (klug -> genial).',
    'grammarRule': 'Correctio: Selbstkorrektur mit Steigerung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-053', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was unterscheidet syntaktische Ambiguitaet von lexikalischer?',
    'options': ['Syntaktische Ambiguitaet entsteht durch mehrdeutige Satzstruktur, nicht durch Wortbedeutung.', 'Es gibt keinen Unterschied.', 'Syntaktische betrifft nur Verben.', 'Lexikalische betrifft die Satzstruktur.'],
    'correctAnswer': 0, 'explanation': 'Syntaktische Ambiguitaet: \'Alte Maenner und Frauen\' (alle alt oder nur Maenner?).',
    'grammarRule': 'Syntaktische Ambiguitaet: mehrdeutige Struktur', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'linguistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p3-054', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Hysteron proteron (zeitliche Umkehrung)?',
    'options': ['Lasst uns sterben und ins Getummel stuerzen! (Vergil)', 'Wir stuerzten ins Getummel und starben.', 'Zuerst stuerzen wir uns hinein, dann sterben wir.', 'Sie kaempften und fielen.'],
    'correctAnswer': 0, 'explanation': 'Hysteron proteron: Das zeitlich Spaetere (sterben) wird vor dem Frueheren (stuerzen) genannt.',
    'grammarRule': 'Hysteron proteron: zeitliche Umkehrung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'literarisch']
  }
];

export default questions;
