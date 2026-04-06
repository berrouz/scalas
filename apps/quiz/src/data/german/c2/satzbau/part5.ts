import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbau-p5-005', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung der Ausklammerung in der Belletristik?',
    'options': ['Nachklang und Nachhall: das ausgeklammerte Element wirkt nach.', 'Kuere.', 'Klarheit.', 'Schnelles Tempo.'],
    'correctAnswer': 0, 'explanation': 'Belletristische Ausklammerung: Element im Nachfeld = emotionaler Nachklang.',
    'grammarRule': 'Ausklammerung: Nachklang/Nachhall', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-006', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antithese in gehobenem Stil?',
    'options': ['Im Frieden bauen wir, im Krieg zerstoeren wir.', 'Wir bauen und zerstoeren.', 'Frieden bedeutet Aufbau, Krieg bedeutet Zerstoerung.', 'Aufbau und Zerstoerung wechseln sich ab.'],
    'correctAnswer': 0, 'explanation': 'Antithese: parallele Struktur mit inhaltlichem Kontrast (Frieden/Krieg).',
    'grammarRule': 'Antithese: paralleler Kontrast', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-007', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt langer Satzperioden?',
    'options': ['Gedankentiefe, Differenziertheit, Pathos.', 'Kuere und Sachlichkeit.', 'Schnelles Tempo.', 'Humor.'],
    'correctAnswer': 0, 'explanation': 'Lange Perioden: NS-Ketten = Gedankentiefe; spaete Aufloesung = Pathos.',
    'grammarRule': 'Satzperiode: Gedankentiefe/Pathos', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-008', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Anapher als rhetorisches Mittel?',
    'options': ['Ich klage an die Ungerechtigkeit. Ich klage an die Gleichgueltigkeit. Ich klage an das Schweigen.', 'Ich klage die Ungerechtigkeit, die Gleichgueltigkeit und das Schweigen an.', 'Die Ungerechtigkeit und das Schweigen werden angeklagt.', 'Es wird angeklagt: Ungerechtigkeit und Schweigen.'],
    'correctAnswer': 0, 'explanation': 'Anapher: Ich klage an ... (Wiederholung am Anfang) -> rhetorische Wucht.',
    'grammarRule': 'Anapher: rhetorische Wiederholung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-009', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der erlebten Rede in der Erzaehlperspektive?',
    'options': ['Verschmelzung von Erzaehler- und Figurenperspektive.', 'Strikte Trennung der Perspektiven.', 'Nur Erzaehlerperspektive.', 'Nur Figurenperspektive.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: Erzaehler berichtet (Praeteritum), aber Figur denkt (V2, Deiktika).',
    'grammarRule': 'Erlebte Rede: Perspektivenverschmelzung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-010', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Chiasmus mit philosophischem Inhalt?',
    'options': ['Man lebt nicht, um zu essen, sondern isst, um zu leben.', 'Man soll essen und leben.', 'Essen und Leben gehoeren zusammen.', 'Wer isst, lebt; wer lebt, isst.'],
    'correctAnswer': 0, 'explanation': 'Chiasmus: lebt-essen / isst-leben = Kreuzstellung mit Sinnumkehrung.',
    'grammarRule': 'Chiasmus: Kreuzstellung + Sinnumkehrung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-011', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der Satzstruktur in Kafkas Prosa?',
    'options': ['Nuechterner parataktischer Stil trotz surrealer Inhalte.', 'Extreme Hypotaxe.', 'Nur kurze Fragmente.', 'Nur lange Perioden.'],
    'correctAnswer': 0, 'explanation': 'Kafka: sachliche Parataxe + praezise Syntax -> Kontrast zum surrealen Inhalt.',
    'grammarRule': 'Kafka: sachliche Parataxe bei surrealem Inhalt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-012', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Gradatio (stufenweise Steigerung)?',
    'options': ['Erst fluesterte er, dann sprach er, dann rief er, schliesslich schrie er.', 'Er schrie und fluesterte gleichzeitig.', 'Er sprach laut.', 'Er rief und schrie.'],
    'correctAnswer': 0, 'explanation': 'Gradatio: fluestern -> sprechen -> rufen -> schreien = Steigerung.',
    'grammarRule': 'Gradatio: Steigerung in Stufen', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-013', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung der Parenthese als Gedankeneinschub?',
    'options': ['Unterbrechung des Hauptgedankens fuer Nebenbemerkung/Kommentar.', 'Verstaerkung des Hauptgedankens.', 'Streichung des Hauptgedankens.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Parenthese als Gedankeneinschub: Unterbrechung + Zurueckkehr zum Hauptgedanken.',
    'grammarRule': 'Parenthese: Unterbrechung/Kommentar', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-014', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Koncinnitas?',
    'options': ['Was dem einen Recht ist, ist dem anderen billig.', 'Der eine hat Recht, der andere auch.', 'Recht und Billigkeit sind verwandt.', 'Jeder hat seine eigene Vorstellung von Recht.'],
    'correctAnswer': 0, 'explanation': 'Koncinnitas: symmetrischer Bau (Was dem einen ... , ist dem anderen ...).',
    'grammarRule': 'Koncinnitas: symmetrischer Bau', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-015', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Apokoinou als Sonderform der Satzverknuepfung?',
    'options': ['Ein Satzteil gehoert gleichzeitig zu zwei benachbarten Saetzen.', 'Ein Satz wird verdoppelt.', 'Ein Satz wird gestrichen.', 'Zwei Saetze werden vertauscht.'],
    'correctAnswer': 0, 'explanation': 'Apokoinou: gemeinsames Glied zweier Saetze (z.B. in Dialekt/Literatur).',
    'grammarRule': 'Apokoinou: gemeinsames Satzglied', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-016', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion mit emotionalem Nachdruck?',
    'options': ['Bitter war die Enttaeuschung, die er empfand.', 'Die Enttaeuschung, die er empfand, war bitter.', 'Er empfand eine bittere Enttaeuschung.', 'Die bittere Enttaeuschung plagte ihn.'],
    'correctAnswer': 0, 'explanation': 'Praedikativ-Inversion: Bitter im Vorfeld -> emotionaler Nachdruck.',
    'grammarRule': 'Praedikativ-Inversion: emotionaler Nachdruck', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-017', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung des Asyndeton in emotionalen Passagen?',
    'options': ['Atemlosigkeit, Hast, Ueberwueltigung.', 'Ruhe und Besonnenheit.', 'Formalitaet.', 'Ironie.'],
    'correctAnswer': 0, 'explanation': 'Asyndeton: Er rannte, stolperte, fiel – ohne und -> Atemlosigkeit.',
    'grammarRule': 'Asyndeton: Atemlosigkeit/Hast', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-018', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Polyptoton?',
    'options': ['Mit List ueberlisten die Listigen die Arglistigen.', 'Listige Menschen sind schlau.', 'Man kann andere ueberlisten.', 'Arglist ist eine schlechte Eigenschaft.'],
    'correctAnswer': 0, 'explanation': 'Polyptoton: List/ueberlisten/Listigen/Arglistigen (ein Stamm in verschiedenen Formen).',
    'grammarRule': 'Polyptoton: Wortstamm in Varianten', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-019', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion bewusster Normverletzung in der Satzstruktur?',
    'options': ['Aufmerksamkeitserzeugung und Verfremdung.', 'Grammatische Korrektheit.', 'Keine Funktion.', 'Vereinfachung.'],
    'correctAnswer': 0, 'explanation': 'Bewusste Normverletzung: Verfremdungseffekt, Aufmerksamkeit des Lesers.',
    'grammarRule': 'Normverletzung: Verfremdung/Aufmerksamkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-020', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Geminatio fuer emotionale Intensitaet?',
    'options': ['Fort, fort von hier! Nur fort!', 'Er wollte weggehen.', 'Er ging schnell weg.', 'Er verliess den Ort.'],
    'correctAnswer': 0, 'explanation': 'Geminatio: Fort, fort – direkte Wiederholung fuer Dringlichkeit.',
    'grammarRule': 'Geminatio: Wiederholung fuer Dringlichkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-021', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Prolepse in gehobener Literatursprache?',
    'options': ['Emphatische Vorwegnahme eines NS-Elements im HS.', 'Nachstellung.', 'Auslassung.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Prolepse: Das Glueck meinte er, dass es nie wiederkehre.',
    'grammarRule': 'Prolepse: emphatische Vorwegnahme', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-022', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Epexegese als literarischen Nachtrag?',
    'options': ['Er kehrte heim – aelter, mueder, aber nicht weiser.', 'Er kehrte aelter und mueder heim.', 'Er war bei seiner Heimkehr aelter, mueder, aber nicht weiser.', 'Aelter und mueder kehrte er heim.'],
    'correctAnswer': 0, 'explanation': 'Epexegese: erklaerend-erweiternder Nachtrag nach Gedankenstrich.',
    'grammarRule': 'Epexegese: literarischer Nachtrag', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-023', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Unterschied zwischen Klimax und Antiklimax?',
    'options': ['Klimax: aufsteigende Steigerung. Antiklimax: absteigende Steigerung.', 'Kein Unterschied.', 'Klimax = Abfall. Antiklimax = Anstieg.', 'Beide sind identisch.'],
    'correctAnswer': 0, 'explanation': 'Klimax: schwach -> stark. Antiklimax: stark -> schwach (oft ironisch).',
    'grammarRule': 'Klimax (aufsteigend) vs. Antiklimax (absteigend)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-024', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Isokolon in der Rede?',
    'options': ['Dem Mutigen gehoert die Welt, dem Feigen droht der Untergang.', 'Der Mutige bekommt die Welt und der Feige geht unter.', 'Die Welt gehoert den Mutigen.', 'Mut wird belohnt, Feigheit bestraft.'],
    'correctAnswer': 0, 'explanation': 'Isokolon: gleiche Laenge und Struktur (Dem ... gehoert / dem ... droht).',
    'grammarRule': 'Isokolon: gleiche Laenge/Struktur', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-025', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der Satzstruktur bei Thomas Mann?',
    'options': ['Lange Satzperioden mit verschachtelten NS, Parenthesen und spaeter Aufloesung.', 'Kurze Parataxe.', 'Nur einfache Saetze.', 'Fragmentarischer Stil.'],
    'correctAnswer': 0, 'explanation': 'Thomas Mann: meisterhafte Satzperioden = intellektuelle Differenziertheit.',
    'grammarRule': 'Thomas Mann: Satzperioden = Differenziertheit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-026', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Anadiplose als Verknuepfungstechnik?',
    'options': ['Er suchte Trost. Trost fand er nirgends.', 'Er suchte vergeblich Trost.', 'Nirgends fand er Trost.', 'Trost war nicht zu finden.'],
    'correctAnswer': 0, 'explanation': 'Anadiplose: Trost am Satzende -> Trost am naechsten Satzanfang.',
    'grammarRule': 'Anadiplose: Satzende -> Satzanfang', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-027', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Sperrung in wissenschaftlichen Texten?',
    'options': ['Praezise Eingrenzung durch erweiterte Attribute zwischen Artikel und Nomen.', 'Keine Funktion.', 'Nur Dekoration.', 'Vereinfachung.'],
    'correctAnswer': 0, 'explanation': 'Wissenschaftliche Sperrung: die in der juengsten Studie nachgewiesenen Effekte = praezise.',
    'grammarRule': 'Wissenschaftliche Sperrung: praezise Eingrenzung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'partizipialattribut']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-028', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt narrative V1 in moderner Literatur?',
    'options': ['Geht da einer durch den Park, Haende in den Taschen.', 'Einer geht durch den Park, die Haende in den Taschen.', 'Durch den Park geht einer, die Haende in den Taschen.', 'Ein Mann ging durch den Park.'],
    'correctAnswer': 0, 'explanation': 'Moderne narrative V1: unmittelbare Bildlichkeit, Gegenwartseffekt.',
    'grammarRule': 'Narrative V1: Unmittelbarkeit/Gegenwartseffekt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-029', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung von Nominalsaetzen in Lyrik?',
    'options': ['Statik, Bild, Momentaufnahme.', 'Dynamik.', 'Komplexitaet.', 'Geschwindigkeit.'],
    'correctAnswer': 0, 'explanation': 'Nominalsaetze in Lyrik: Nacht. Stille. Sterne. -> Bilder, Momentaufnahmen.',
    'grammarRule': 'Nominalsaetze: Bild/Momentaufnahme', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-030', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Parallelismus mit Variation?',
    'options': ['Er kam als Fremder, er blieb als Freund, er ging als Bruder.', 'Er kam, blieb und ging.', 'Als Fremder kam er und als Freund ging er.', 'Er war erst Fremder, dann Freund, dann Bruder.'],
    'correctAnswer': 0, 'explanation': 'Parallelismus mit Variation: gleiche Struktur (er + Verb + als + NP), wechselnder Inhalt.',
    'grammarRule': 'Parallelismus mit Variation', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-031', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Satzverschraenkung in der Literatur?',
    'options': ['Emphatische Hervorhebung des herausbewegten Elements.', 'Keine besondere Funktion.', 'Abschwuechung.', 'Streichung.'],
    'correctAnswer': 0, 'explanation': 'Satzverschraenkung: Das herausbewgte Element erhaelt maximale Aufmerksamkeit.',
    'grammarRule': 'Satzverschraenkung: emphatische Hervorhebung', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-032', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Oxymoron in literarischer Sprache?',
    'options': ['Die suesse Bitterkeit der Erinnerung ueberkam ihn.', 'Die Erinnerung war bitter und suess zugleich.', 'Er erinnerte sich mit gemischten Gefuehlen.', 'Die Erinnerung war schmerzhaft.'],
    'correctAnswer': 0, 'explanation': 'Oxymoron: suesse Bitterkeit – widersprüchliche Adjektiv-Nomen-Verbindung.',
    'grammarRule': 'Oxymoron: widersprüchliche Verbindung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-033', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung von Trikolon in Reden?',
    'options': ['Rhythmus, Vollstaendigkeit, Emphase.', 'Kuere.', 'Sachlichkeit.', 'Ironie.'],
    'correctAnswer': 0, 'explanation': 'Trikolon: dreigliedrig = rhetorisch vollstaendig, rhythmisch, emphatisch.',
    'grammarRule': 'Trikolon: Rhythmus/Vollstaendigkeit/Emphase', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-034', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Satzfragmentierung fuer Dramatik?',
    'options': ['Ein Knall. Schreie. Dann Stille. Nichts mehr.', 'Es gab einen Knall, dann Schreie, und dann war Stille.', 'Nach dem Knall schrien die Menschen, dann wurde es still.', 'Ein lauter Knall erschreckte alle.'],
    'correctAnswer': 0, 'explanation': 'Satzfragmente: Nominalsaetze ohne Verb = Dramatik, Momentaufnahme.',
    'grammarRule': 'Satzfragmente: Dramatik/Momentaufnahme', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-035', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt des Wechsels zwischen Hypo- und Parataxe?',
    'options': ['Rhythmuswechsel und Tempoveraenderung im Text.', 'Monotonie.', 'Keine Wirkung.', 'Formalisierung.'],
    'correctAnswer': 0, 'explanation': 'Stilwechsel: Hypotaxe (langsam, differenziert) -> Parataxe (schnell, direkt) = Rhythmus.',
    'grammarRule': 'Hypo-/Parataxe-Wechsel: Rhythmus/Tempo', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-036', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Correctio als Steigerungsmittel?',
    'options': ['Das war falsch – nein, es war ein Verbrechen.', 'Das war ein grosser Fehler.', 'Es war falsch und verbrecherisch.', 'Das war weder falsch noch richtig.'],
    'correctAnswer': 0, 'explanation': 'Correctio: falsch -> Verbrechen (Steigerung durch Scheinkorrektur).',
    'grammarRule': 'Correctio: Steigerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-037', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Katapher in wissenschaftlichen Texten?',
    'options': ['Vorwaertsverweisung schafft Erwartung und Spannung.', 'Rueckwaertsverweisung.', 'Keine Funktion.', 'Streichung.'],
    'correctAnswer': 0, 'explanation': 'Katapher: Folgendes ist zu beachten: ... (das verweist auf das Kommende).',
    'grammarRule': 'Katapher: Erwartung/Spannung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-038', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Zeugma mit humoristischem Effekt?',
    'options': ['Er verlor die Nerven und seinen Regenschirm.', 'Er verlor seinen Regenschirm.', 'Er verlor die Nerven.', 'Er war nervoes und ohne Regenschirm.'],
    'correctAnswer': 0, 'explanation': 'Zeugma: verlieren in zwei Bedeutungen -> humoristischer Effekt.',
    'grammarRule': 'Zeugma: humoristisch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-039', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt der Litotes in diplomatischer Sprache?',
    'options': ['Hoefliche Untertreibung, die das Gegenteil impliziert.', 'Direkte Aussage.', 'Uebertreibung.', 'Ironie.'],
    'correctAnswer': 0, 'explanation': 'Diplomatische Litotes: nicht unerheblich = sehr wichtig (hoeflich untertrieben).',
    'grammarRule': 'Litotes: hoefliche Untertreibung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-040', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Epipher in rhetorischer Rede?',
    'options': ['Wir fordern Gerechtigkeit. Wir brauchen Gerechtigkeit. Wir verdienen Gerechtigkeit.', 'Gerechtigkeit wird gefordert, gebraucht und verdient.', 'Wir fordern, brauchen und verdienen Gerechtigkeit.', 'Gerechtigkeit ist unser Ziel.'],
    'correctAnswer': 0, 'explanation': 'Epipher: Gerechtigkeit am Ende jedes Satzes -> Nachdruck.',
    'grammarRule': 'Epipher: Nachdruck durch Endwiederholung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-041', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung der Aposiopese in emotionaler Rede?',
    'options': ['Das Unausgesprochene wirkt staerker als das Ausgesprochene.', 'Das Ausgesprochene wirkt staerker.', 'Keine Wirkung.', 'Klarheit.'],
    'correctAnswer': 0, 'explanation': 'Aposiopese: Satzabbruch -> das Verschwiegene wirkt im Kopf des Hoerers nach.',
    'grammarRule': 'Aposiopese: Unausgesprochenes wirkt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-042', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Hyperbaton in poetischer Sprache?',
    'options': ['Einsam wandelt er durch die weiten, menschenleeren Felder.', 'Er wandelt einsam durch die weiten, menschenleeren Felder.', 'Durch die weiten Felder wandelt er einsam.', 'Die weiten Felder durchquert er einsam.'],
    'correctAnswer': 0, 'explanation': 'Einsam getrennt vom Verb: Hyperbaton erzeugt poetischen Rhythmus.',
    'grammarRule': 'Hyperbaton: poetischer Rhythmus', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-043', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der Satzstruktur in Brechts epischem Theater?',
    'options': ['Bewusste Verfremdung durch ungewohnte Satzstrukturen und Brueche.', 'Klassische Hypotaxe.', 'Nur einfache Saetze.', 'Nur Fragen.'],
    'correctAnswer': 0, 'explanation': 'Brechts V-Effekt: Satzbrueche, ungewohnte Wortstellungen = Verfremdung.',
    'grammarRule': 'Brecht: Verfremdung durch Satzstruktur', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-044', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antiklimax mit ironischem Effekt?',
    'options': ['Er kaempfte fuer sein Land, fuer seine Ehre und fuer einen Parkplatz.', 'Er kaempfte fuer einen Parkplatz.', 'Er kaempfte fuer sein Land und seine Ehre.', 'Er kaempfte fuer vieles.'],
    'correctAnswer': 0, 'explanation': 'Antiklimax: Land -> Ehre -> Parkplatz (absteigend) = ironischer Bruch.',
    'grammarRule': 'Antiklimax: ironischer Bruch', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-045', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Inversionsvariation in literarischen Texten?',
    'options': ['Rhythmusvariation und Vermeidung monotoner Subjekt-Verb-Abfolge.', 'Keine Funktion.', 'Nur grammatische Pflicht.', 'Vereinfachung.'],
    'correctAnswer': 0, 'explanation': 'Inversionsvariation: wechselnde Vorfeldbesetzung = lebendiger Rhythmus.',
    'grammarRule': 'Inversionsvariation: Rhythmus/Lebendigkeit', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-046', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Kyklos als kompositorisches Prinzip?',
    'options': ['Am Anfang war das Wort, und das Wort war am Anfang.', 'Am Anfang war das Wort.', 'Das Wort war am Anfang.', 'Es gab am Anfang ein Wort.'],
    'correctAnswer': 0, 'explanation': 'Kyklos: Anfang = Ende (Am Anfang ... am Anfang) -> Geschlossenheit.',
    'grammarRule': 'Kyklos: kompositorische Geschlossenheit', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-047', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung der erlebten Rede auf den Leser?',
    'options': ['Einfuehlung in die Figur durch Perspektivenverschmelzung.', 'Distanz zur Figur.', 'Objektivitaet.', 'Kuere.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: Leser erlebt Gedanken/Gefuehle der Figur unmittelbar mit.',
    'grammarRule': 'Erlebte Rede: Einfuehlung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-048', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Symploke in rhetorischer Rede?',
    'options': ['Was nützt die Freiheit ohne Gerechtigkeit? Was nützt der Frieden ohne Gerechtigkeit?', 'Freiheit und Frieden brauchen Gerechtigkeit.', 'Ohne Gerechtigkeit sind Freiheit und Frieden nutzlos.', 'Gerechtigkeit ist die Grundlage von allem.'],
    'correctAnswer': 0, 'explanation': 'Symploke: gleicher Anfang (Was nuetzt) + gleiches Ende (ohne Gerechtigkeit).',
    'grammarRule': 'Symploke: gleicher Anfang + gleiches Ende', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-049', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion bewusster Ausklammerung in Reden?',
    'options': ['Das ausgeklammerte Element erhaelt als Letztes besondere Aufmerksamkeit.', 'Keine Funktion.', 'Abschwuechung.', 'Streichung.'],
    'correctAnswer': 0, 'explanation': 'Rednerische Ausklammerung: Nachfeld = letzte Position = maximale Aufmerksamkeit.',
    'grammarRule': 'Ausklammerung in Reden: maximale Aufmerksamkeit', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-050', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Anakoluth als Mittel der Charakterisierung?',
    'options': ['Ich wollte doch – also, wenn man bedenkt – na, lassen wir das.', 'Ich wollte etwas sagen, aber liess es sein.', 'Lassen wir das Thema.', 'Er wollte sprechen, schwieg aber.'],
    'correctAnswer': 0, 'explanation': 'Anakoluth: Satzbrueche charakterisieren unsicheres/zerstreutes Sprechen.',
    'grammarRule': 'Anakoluth: Charakterisierung durch Satzbrueche', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-051', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anadiplose und welche Wirkung hat sie?',
    'options': ['Wiederholung des letzten Wortes als erstes Wort des naechsten Satzes -> Verkettung.', 'Wiederholung am Satzanfang.', 'Wiederholung am Satzende.', 'Weglassung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Anadiplose: \'Er fiel. Fiel ins Bodenlose.\' -> Verkettung, Steigerung.',
    'grammarRule': 'Anadiplose: Ende -> Anfang = Verkettung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-052', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion als expressives Mittel in der Lyrik?',
    'options': ['Des Winters Klauen greifen nach dem Land.', 'Die Klauen des Winters greifen nach dem Land.', 'Der Winter greift mit Klauen nach dem Land.', 'Nach dem Land greifen des Winters Klauen.'],
    'correctAnswer': 0, 'explanation': 'Genitiv-Voranstellung: Des Winters Klauen -> archaisch-lyrische Inversion.',
    'grammarRule': 'Lyrische Inversion: Genitiv im Vorfeld', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-053', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was kennzeichnet den Nominalstil in wissenschaftlicher Prosa?',
    'options': ['Bevorzugung von Nominalisierungen und Praepositionalgruppen statt Nebensaetze.', 'Viele Nebensaetze.', 'Kurze Hauptsaetze.', 'Imperativformen.'],
    'correctAnswer': 0, 'explanation': 'Nominalstil: Nominalisierungen + PP statt NS -> komprimierte Information.',
    'grammarRule': 'Nominalstil: Nominalisierungen statt NS', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'fachsprache']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p5-054', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Enjambement als syntaktisches Stilmittel?',
    'options': ['Am Ende der Zeile steht kein syntaktischer Einschnitt; der Satz laeuft in die naechste Zeile.', 'Jede Zeile ist ein vollstaendiger Satz.', 'Das Verb steht immer am Zeilenende.', 'Jede Zeile beginnt mit dem Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Enjambement: Zeilensprung ohne syntaktischen Einschnitt -> Spannung, Dynamik.',
    'grammarRule': 'Enjambement: Satz ueber Zeilengrenze', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  }
];

export default questions;
