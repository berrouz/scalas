import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbau-p4-005', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt der maximalen Klammerexpansion?',
    'options': ['Spannung und Verzoegerung: der Leser wartet auf die rechte Klammer.', 'Kuere.', 'Klarheit.', 'Schnelles Tempo.'],
    'correctAnswer': 0, 'explanation': 'Maximale Klammerexpansion: langes MF = Spannungsbogen bis zum Partizip/Infinitiv.',
    'grammarRule': 'Klammerexpansion: Spannung/Verzoegerung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-006', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversionsparallelismus?',
    'options': ['Schoen war der Tag, und mild die Nacht.', 'Der Tag war schoen und die Nacht war mild.', 'Es war ein schoener Tag und eine milde Nacht.', 'Der schoene Tag und die milde Nacht.'],
    'correctAnswer': 0, 'explanation': 'Inversionsparallelismus: Praedikativ im Vorfeld in beiden Saetzen parallel.',
    'grammarRule': 'Inversionsparallelismus: Praedikativ + V2', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-007', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Unterschied zwischen Hypotaxe und Parataxe?',
    'options': ['Hypotaxe: komplex, differenziert, langsam. Parataxe: einfach, direkt, schnell.', 'Kein Unterschied.', 'Hypotaxe = kurze Saetze. Parataxe = lange Saetze.', 'Beide sind identisch.'],
    'correctAnswer': 0, 'explanation': 'Hypotaxe: Gedankentiefe, Differenziertheit. Parataxe: Unmittelbarkeit, Tempo.',
    'grammarRule': 'Hypotaxe (komplex) vs. Parataxe (direkt)', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-008', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Aposiopese in literarischer Sprache?',
    'options': ['Er wollte sprechen, aber – die Worte versagten ihm.', 'Er wollte sprechen, aber die Worte versagten ihm.', 'Er konnte nicht sprechen.', 'Die Worte versagten ihm.'],
    'correctAnswer': 0, 'explanation': 'Aposiopese: Gedankenstrich markiert den Abbruch/die Pause.',
    'grammarRule': 'Aposiopese: Gedankenstrich = Abbruch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-009', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Prolepse in wissenschaftlichen Texten?',
    'options': ['Vorwegnahme eines Arguments aus dem NS im HS fuer Emphase.', 'Nachstellung.', 'Auslassung.', 'Wiederholung.'],
    'correctAnswer': 0, 'explanation': 'Wissenschaftliche Prolepse: Dieses Phaenomen ist bekannt, dass es haeufig auftritt.',
    'grammarRule': 'Prolepse: Vorwegnahme fuer Emphase', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-010', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt narrative V1 mit maerchenhaftem Ton?',
    'options': ['War einmal ein alter Koenig, der hatte drei Toechter.', 'Es war einmal ein alter Koenig, der drei Toechter hatte.', 'Ein alter Koenig hatte einmal drei Toechter.', 'Einmal hatte ein alter Koenig drei Toechter.'],
    'correctAnswer': 0, 'explanation': 'Narrative V1: Maerchenton, archaisch, unmittelbar.',
    'grammarRule': 'Narrative V1: Maerchenton', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-011', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Epanalepse?',
    'options': ['Wiederaufnahme eines Satzanfangs nach Einschub oder am naechsten Satzanfang.', 'Auslassung am Satzende.', 'Kreuzstellung.', 'Verdopplung am Ende.'],
    'correctAnswer': 0, 'explanation': 'Epanalepse: Er ging fort. Fort von allem, was er kannte.',
    'grammarRule': 'Epanalepse: Wiederaufnahme', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-012', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Durchbrechung von TeKaMoLo fuer Kontrast?',
    'options': ['Aus Liebe hat er gestern trotz aller Warnungen in Berlin alles aufgegeben.', 'Er hat gestern aus Liebe trotz aller Warnungen in Berlin alles aufgegeben.', 'Er hat gestern in Berlin aus Liebe trotz aller Warnungen alles aufgegeben.', 'Gestern hat er in Berlin aus Liebe trotz aller Warnungen alles aufgegeben.'],
    'correctAnswer': 0, 'explanation': 'Kausal (Aus Liebe) im Vorfeld statt in TeKaMoLo-Position -> Fokus auf Motiv.',
    'grammarRule': 'TeKaMoLo-Durchbrechung: Fokus auf Motiv', 'subcategory': 'Scrambling', 'tags': ['satzbau', 'scrambling']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-013', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Parenthese in ironischem Stil?',
    'options': ['Distanzierung oder Kommentar, der die HS-Aussage untergraebt.', 'Verstaerkung der HS-Aussage.', 'Nur syntaktische Funktion.', 'Keine Funktion.'],
    'correctAnswer': 0, 'explanation': 'Ironische Parenthese: Er war – wie so oft – bestens vorbereitet. (ironisch)',
    'grammarRule': 'Ironische Parenthese: Distanzierung/Untergraben', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-014', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Satzverschraenkung mit stilistischem Effekt?',
    'options': ['Diesen Traum hoffte sie, dass das Schicksal ihr erfuellen wuerde.', 'Sie hoffte, dass das Schicksal ihr diesen Traum erfuellen wuerde.', 'Dass das Schicksal ihr diesen Traum erfuellen wuerde, hoffte sie.', 'Sie hoffte auf die Erfuellung dieses Traums durch das Schicksal.'],
    'correctAnswer': 0, 'explanation': 'Satzverschraenkung: NS-Akkusativ (Diesen Traum) ins Vorfeld des HS -> Emphase.',
    'grammarRule': 'Satzverschraenkung: NS-Element -> VF (Emphase)', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-015', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung von Nominalsaetzen?',
    'options': ['Verdichtung, Statik, Eindruecklichkeit.', 'Dynamik.', 'Komplexitaet.', 'Laenge.'],
    'correctAnswer': 0, 'explanation': 'Nominalsaetze (verblose Saetze): Ein Abend. Stille. Mondlicht. -> Verdichtung.',
    'grammarRule': 'Nominalsaetze: Verdichtung/Statik', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-016', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Parallelismus in der Rede?',
    'options': ['Wir wollen Frieden. Wir wollen Gerechtigkeit. Wir wollen Freiheit.', 'Wir wollen Frieden, Gerechtigkeit und Freiheit.', 'Frieden, Gerechtigkeit und Freiheit sind unser Ziel.', 'Unser Ziel ist es, Frieden zu schaffen.'],
    'correctAnswer': 0, 'explanation': 'Parallelismus + Anapher: Wir wollen ... (dreimal) -> rhetorische Wucht.',
    'grammarRule': 'Parallelismus + Anapher: rhetorische Wucht', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-017', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anadiplose als Verknuepfungstechnik?',
    'options': ['Satzende = naechster Satzanfang -> Kettenbildung.', 'Gleicher Anfang.', 'Gleiches Ende.', 'Auslassung.'],
    'correctAnswer': 0, 'explanation': 'Anadiplose: Macht erzeugt Angst. Angst erzeugt Gehorsam. -> Kette.',
    'grammarRule': 'Anadiplose: Kettenbildung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-018', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt literarische Ausklammerung mit Nachklang?',
    'options': ['Sie hatte gewartet, Tag fuer Tag, Woche fuer Woche.', 'Sie hatte Tag fuer Tag und Woche fuer Woche gewartet.', 'Tag fuer Tag hatte sie gewartet.', 'Wochenlang hatte sie gewartet.'],
    'correctAnswer': 0, 'explanation': 'Ausklammerung: Zeitangaben im Nachfeld = Nachklang, Betonung der Dauer.',
    'grammarRule': 'Literarische Ausklammerung: Nachklang', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-019', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion von Correctio in Reden?',
    'options': ['Steigerung durch scheinbare Selbstkorrektur.', 'Echte Korrektur eines Fehlers.', 'Abschwuechung.', 'Wiederholung.'],
    'correctAnswer': 0, 'explanation': 'Correctio: Er war gut – nein, herausragend! -> Steigerung durch Korrektur.',
    'grammarRule': 'Correctio: Steigerung durch Scheinkorrektur', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-020', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Exclamatio mit emphatischer Inversion?',
    'options': ['Wie herrlich leuchtet mir die Natur!', 'Die Natur leuchtet mir herrlich.', 'Mir leuchtet die Natur herrlich.', 'Die Natur ist herrlich leuchtend.'],
    'correctAnswer': 0, 'explanation': 'Exclamatio: emotionaler Ausruf mit w-Wort + Inversion (Goethe).',
    'grammarRule': 'Exclamatio: w-Wort + Inversion', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-021', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung des Stakkato-Stils?',
    'options': ['Schnelles Tempo, Atemlosigkeit, Dramatik.', 'Langsamkeit.', 'Ruhe.', 'Feierlichkeit.'],
    'correctAnswer': 0, 'explanation': 'Stakkato: Kurze Saetze/Fragmente -> Tempo, Spannung, Dramatik.',
    'grammarRule': 'Stakkato: Tempo/Dramatik', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-022', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Symploke?',
    'options': ['Wer kaempft, kann verlieren. Wer nicht kaempft, hat schon verloren.', 'Wer kaempft, kann verlieren oder gewinnen.', 'Man kann verlieren und man kann gewinnen.', 'Kampf fuehrt zu Sieg oder Niederlage.'],
    'correctAnswer': 0, 'explanation': 'Symploke: gleicher Anfang (Wer) + gleiches Ende (verlieren/verloren).',
    'grammarRule': 'Symploke: Anapher + Epipher', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-023', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt der Nachfeldbesetzung in Reden?',
    'options': ['Das Nachfeldelement bleibt im Gedaechtnis (Endposition = Betonung).', 'Das Nachfeldelement wird vergessen.', 'Abschwuechung.', 'Keine Wirkung.'],
    'correctAnswer': 0, 'explanation': 'Endstellung = Betonung: Das Nachfeldelement wirkt als letzter Eindruck.',
    'grammarRule': 'Nachfeld: Endposition = Betonung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-024', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Antithese mit paralleler Struktur?',
    'options': ['Die Jugend weiss viel, die Weisheit schweigt.', 'Die Jugend und die Weisheit sind verschieden.', 'Jugend ist laut, Weisheit ist leise.', 'Junge Menschen wissen viel, weise Menschen schweigen.'],
    'correctAnswer': 0, 'explanation': 'Antithese: paralleler Bau (Subj.+Verb) + inhaltlicher Kontrast.',
    'grammarRule': 'Antithese: parallele Struktur + Kontrast', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-025', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Enallage als stilistischer Normbruch?',
    'options': ['Adjektiv bei semantisch unerwartetem Bezugswort.', 'Adjektiv an korrekter Stelle.', 'Adjektiv faellt weg.', 'Adjektiv wird verdoppelt.'],
    'correctAnswer': 0, 'explanation': 'Enallage: die schlaflosen Naechte seiner Einsamkeit (nicht die Naechte sind schlaflos, sondern er).',
    'grammarRule': 'Enallage: Adjektiv bei unerwartetem Bezug', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-026', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt erlebte Rede mit rhetorischer Frage?',
    'options': ['Sie blickte zum Himmel. Wuerde es jemals aufhoeren zu regnen?', 'Sie fragte sich, ob es jemals aufhoeren wuerde zu regnen.', 'Sie sagte: Wird es jemals aufhoeren zu regnen?', 'Es regnete und sie fragte sich, wann es aufhoeren wuerde.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: Figurenperspektive + V2 + Fragesatz ohne Redeeinleitung.',
    'grammarRule': 'Erlebte Rede: V2-Frage ohne Einleitung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-027', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion des Vorfelds in literarischen Texten?',
    'options': ['Steuerung der Leserperspektive und Fokussierung.', 'Nur syntaktische Pflicht.', 'Keine besondere Funktion.', 'Immer Subjekt.'],
    'correctAnswer': 0, 'explanation': 'Literarisches Vorfeld: bewusste Wahl steuert Perspektive und Fokus des Lesers.',
    'grammarRule': 'Vorfeld: Perspektivsteuerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-028', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Hyperbaton mit Spannungseffekt?',
    'options': ['Lang war der Weg und beschwerlich die Reise.', 'Der Weg war lang und die Reise beschwerlich.', 'Der lange Weg und die beschwerliche Reise.', 'Es war ein langer und beschwerlicher Weg.'],
    'correctAnswer': 0, 'explanation': 'Hyperbaton: Adjektiv getrennt vom Nomen (Lang ... Weg) -> Spannung.',
    'grammarRule': 'Hyperbaton: Spannung durch Trennung', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-029', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Akkumulation und Klimax?',
    'options': ['Akkumulation: Reihung ohne Steigerung. Klimax: Reihung mit Steigerung.', 'Kein Unterschied.', 'Akkumulation = Steigerung. Klimax = Reihung.', 'Beide sind identisch.'],
    'correctAnswer': 0, 'explanation': 'Akkumulation: gleichwertige Reihung. Klimax: steigende Intensitaet.',
    'grammarRule': 'Akkumulation (gleichwertig) vs. Klimax (steigend)', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-030', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Chiasmus mit syntaktischer Spiegelung?',
    'options': ['Er lacht am Morgen, und am Abend weint er.', 'Er lacht am Morgen und weint am Abend.', 'Am Morgen lacht er und am Abend weint er.', 'Morgens lacht und abends weint er.'],
    'correctAnswer': 0, 'explanation': 'Chiasmus: Subj.+Verb+Adv. / Adv.+Verb+Subj. = syntaktische Spiegelung.',
    'grammarRule': 'Chiasmus: syntaktische Spiegelung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-031', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Praeteritio als rhetorische Strategie?',
    'options': ['Man lenkt Aufmerksamkeit auf etwas, indem man betont, es nicht erwaehnen zu wollen.', 'Man verschweigt etwas vollstaendig.', 'Man wiederholt etwas.', 'Man korrigiert sich.'],
    'correctAnswer': 0, 'explanation': 'Praeteritio: Ich will nicht sagen, dass er unfaehig ist, aber ... -> Aufmerksamkeit.',
    'grammarRule': 'Praeteritio: Aufmerksamkeit durch Nicht-Erwaehnung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-032', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Epexegese mit erklaerend-erweiterndem Nachtrag?',
    'options': ['Er verlor alles – sein Haus, sein Geschaeft, seine Familie.', 'Er verlor sein Haus, sein Geschaeft und seine Familie.', 'Alles, was er hatte, verlor er.', 'Er verlor alles, was ihm wichtig war.'],
    'correctAnswer': 0, 'explanation': 'Epexegese: Gedankenstrich + praezisierende Aufzaehlung im Nachtrag.',
    'grammarRule': 'Epexegese: praezisierender Nachtrag', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-033', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung von Polysyndeton in poetischen Texten?',
    'options': ['Verlangsamung, Gewichtung jedes Elements, Feierlichkeit.', 'Beschleunigung.', 'Kuere.', 'Sachlichkeit.'],
    'correctAnswer': 0, 'explanation': 'Polysyndeton: und ... und ... -> jedes Element wird einzeln gewuerdigt.',
    'grammarRule': 'Polysyndeton: Verlangsamung/Gewichtung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-034', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewussten Wechsel von V1 und V2?',
    'options': ['Er stand auf. Ging zur Tuer. Oeffnete sie. Dann sprach er.', 'Er stand auf, ging zur Tuer, oeffnete sie und sprach dann.', 'Nachdem er aufgestanden war, ging er zur Tuer.', 'Er stand auf und ging zur Tuer.'],
    'correctAnswer': 0, 'explanation': 'V2 -> V1 (Topik-Drop) -> V2: Wechsel erzeugt Rhythmus und Dynamik.',
    'grammarRule': 'V1/V2-Wechsel: Rhythmus/Dynamik', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-035', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Syllepse als Stilmittel?',
    'options': ['Ein Wort regiert zwei Glieder in verschiedener Weise.', 'Ein Wort wird ausgelassen.', 'Ein Wort wird verdoppelt.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Syllepse: Er trug einen Hut und gute Laune. (tragen: physisch + abstrakt)',
    'grammarRule': 'Syllepse: ein Wort, zwei Bezuege', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-036', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Oxymoron als literarische Figur?',
    'options': ['Sein lautes Schweigen erfuellte den Raum.', 'Er schwieg laut.', 'Der Raum war still.', 'Niemand sprach.'],
    'correctAnswer': 0, 'explanation': 'Oxymoron: lautes Schweigen – widersprüchliche Verbindung fuer Effekt.',
    'grammarRule': 'Oxymoron: widersprüchliche Verbindung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-037', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Katapher in der Textstruktur?',
    'options': ['Ein Verweis auf etwas, das erst spaeter im Text erwaehnt wird.', 'Ein Verweis auf etwas bereits Erwaehtes.', 'Auslassung.', 'Wiederholung.'],
    'correctAnswer': 0, 'explanation': 'Katapher: Das muss man wissen: Die Erde dreht sich um die Sonne. (das verweist voraus)',
    'grammarRule': 'Katapher: Vorwaertsverweisung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'informationsstruktur']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-038', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Litotes in gehobenem Stil?',
    'options': ['Sein Beitrag war nicht ohne Bedeutung.', 'Sein Beitrag war bedeutend.', 'Sein Beitrag war unbedeutend.', 'Sein Beitrag war sehr wichtig.'],
    'correctAnswer': 0, 'explanation': 'Litotes: nicht ohne Bedeutung = bedeutend (Untertreibung).',
    'grammarRule': 'Litotes: Untertreibung durch doppelte Negation', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-039', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung der Satzperiode in politischen Reden?',
    'options': ['Aufbau von Spannung und Pathos; die Aufloesung wirkt befreiend.', 'Kuere und Klarheit.', 'Sachlichkeit.', 'Ironie.'],
    'correctAnswer': 0, 'explanation': 'Satzperiode in Reden: NS-Kette (Spannung) -> HS (pathetische Aufloesung).',
    'grammarRule': 'Satzperiode: Pathos und Spannung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-040', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion mit Praedikativ im Vorfeld?',
    'options': ['Wunderbar war die Aussicht von hier.', 'Die Aussicht von hier war wunderbar.', 'Von hier war die Aussicht wunderbar.', 'Die wunderbare Aussicht erstreckte sich von hier.'],
    'correctAnswer': 0, 'explanation': 'Praedikativ im Vorfeld: poetisch, betont die Eigenschaft.',
    'grammarRule': 'Praedikativ im Vorfeld: poetisch/emphatisch', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-041', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Paronomasie als Wortspiel in der Satzstruktur?',
    'options': ['Klangaehnliche Woerter in syntaktischer Naehe fuer Effekt.', 'Bedeutungsgleiche Woerter.', 'Auslassung.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Paronomasie: Eile mit Weile. Wer rastet, der rostet.',
    'grammarRule': 'Paronomasie: Klangspiel', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-042', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Trikolon mit abschliessender Zusammenfassung?',
    'options': ['Er arbeitete, er litt, er kaempfte – und am Ende siegte er.', 'Er arbeitete und siegte.', 'Er litt und kaempfte.', 'Am Ende siegte er.'],
    'correctAnswer': 0, 'explanation': 'Trikolon: drei parallele Glieder + zusammenfassende Wendung.',
    'grammarRule': 'Trikolon + Zusammenfassung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-043', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Besonderheit der Satzstruktur in Kleists Prosa?',
    'options': ['Extreme Verschachtelung mit vielen Einschueben und spaeter Aufloesung.', 'Kurze Parataxe.', 'Einfache HS.', 'Fragmentarischer Stil.'],
    'correctAnswer': 0, 'explanation': 'Kleists Stil: extreme Hypotaxe, Parenthesen, spaete Aufloesung = Spannung.',
    'grammarRule': 'Kleist: extreme Verschachtelung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-044', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Epipher?',
    'options': ['Er kaempfte fuer die Freiheit. Er lebte fuer die Freiheit. Er starb fuer die Freiheit.', 'Er kaempfte, lebte und starb fuer die Freiheit.', 'Fuer die Freiheit kaempfte, lebte und starb er.', 'Die Freiheit war sein Lebensinhalt.'],
    'correctAnswer': 0, 'explanation': 'Epipher: fuer die Freiheit am Ende jedes Satzes wiederholt.',
    'grammarRule': 'Epipher: Wiederholung am Satzende', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-045', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Apposition als Nachtrag?',
    'options': ['Erklaerend-identifizierende Information nach dem Bezugswort.', 'Vorwegnahme.', 'Streichung.', 'Verdopplung des Verbs.'],
    'correctAnswer': 0, 'explanation': 'Apposition als Nachtrag: Goethe, der groesste deutsche Dichter, wurde in Frankfurt geboren.',
    'grammarRule': 'Apposition: erklaerend-identifizierend', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-046', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Kyklos (Ringkomposition)?',
    'options': ['Hoffnung trug ihn, und er trug Hoffnung.', 'Er trug Hoffnung.', 'Hoffnung trug ihn.', 'Er hatte Hoffnung und sie trug ihn.'],
    'correctAnswer': 0, 'explanation': 'Kyklos: Hoffnung am Anfang und Ende -> Abgeschlossenheit.',
    'grammarRule': 'Kyklos: Anfang = Ende', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-047', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung von Ellipse in Dialogpassagen?',
    'options': ['Natuerlichkeit, Muendlichkeit, Tempo.', 'Formalitaet.', 'Komplexitaet.', 'Langsamkeit.'],
    'correctAnswer': 0, 'explanation': 'Ellipse im Dialog: Wohin? – Nach Hause. -> natuerlich, muendlich, schnell.',
    'grammarRule': 'Ellipse: Natuerlichkeit/Tempo', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-048', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Akkumulation mit rhetorischem Hoehepunkt?',
    'options': ['Krieg, Hunger, Seuchen, Tod – so sah das Leben aus.', 'Das Leben war gepraegt von Krieg und Hunger.', 'Krieg und Hunger herrschten.', 'Viele Probleme plagten die Menschen.'],
    'correctAnswer': 0, 'explanation': 'Akkumulation + zusammenfassender HS -> rhetorischer Hoehepunkt.',
    'grammarRule': 'Akkumulation + Hoehepunkt', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-049', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung von Hendiadyoin in gehobener Sprache?',
    'options': ['Feierlichkeit und Nachdruck durch Verdopplung.', 'Kuere.', 'Sachlichkeit.', 'Ironie.'],
    'correctAnswer': 0, 'explanation': 'Hendiadyoin: Hab und Gut, Grund und Boden -> feierlich, nachdruecklich.',
    'grammarRule': 'Hendiadyoin: Feierlichkeit/Nachdruck', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-050', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt rhetorische Frage als Argument in der Rede?',
    'options': ['Wollen wir wirklich zusehen, wie alles zerstoert wird?', 'Wir wollen nicht zusehen, wie alles zerstoert wird.', 'Ich frage Sie, ob Sie zusehen wollen.', 'Niemand will zusehen.'],
    'correctAnswer': 0, 'explanation': 'Rhetorische Frage: V1 + implizierte Antwort (Nein!) -> persuasiv.',
    'grammarRule': 'Rhetorische Frage: persuasiv', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-051', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Epanalepse und welche Wirkung hat sie?',
    'options': ['Wiederholung eines Wortes/einer Gruppe am Satzanfang -> Nachdruck.', 'Satzbruch.', 'Weglassung des Verbs.', 'Umstellung des Subjekts.'],
    'correctAnswer': 0, 'explanation': 'Epanalepse: \'O Gott, o Gott!\' -> Verstärkung durch Wiederholung.',
    'grammarRule': 'Epanalepse: Wiederholung = Nachdruck', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-052', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Litotes als Understatement?',
    'options': ['Das ist nicht uninteressant.', 'Das ist sehr interessant.', 'Das ist langweilig.', 'Das ist ein wenig interessant.'],
    'correctAnswer': 0, 'explanation': 'Litotes: doppelte Verneinung (nicht + un-) als stilistisches Understatement.',
    'grammarRule': 'Litotes: doppelte Negation als Understatement', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-053', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion der Prolepse in literarischer Sprache?',
    'options': ['Vorwegnahme eines NS-Elements im HS zur Hervorhebung.', 'Wiederholung des Verbs.', 'Weglassung des Subjekts.', 'Umstellung der Zeitform.'],
    'correctAnswer': 0, 'explanation': 'Literarische Prolepse: \'Ich sah ihn, wie er fiel\' -> \'ihn\' als vorweggenommenes Objekt.',
    'grammarRule': 'Prolepse: Vorwegnahme zur Hervorhebung', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p4-054', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Oxymoron als syntaktische Spannung?',
    'options': ['Ein beredtes Schweigen lag ueber dem Raum.', 'Der Raum war still.', 'Niemand sprach, alle schwiegen.', 'Das Schweigen war lang und unangenehm.'],
    'correctAnswer': 0, 'explanation': 'Oxymoron: Widerspruch in der Wortgruppe (beredt + Schweigen) -> semantische Spannung.',
    'grammarRule': 'Oxymoron: Widerspruch in der NP', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  }
];

export default questions;
