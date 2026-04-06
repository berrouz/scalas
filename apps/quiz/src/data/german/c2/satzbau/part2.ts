import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbau-p2-005', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Apokoinou?',
    'options': ['Ein Satzteil gehoert gleichzeitig zu zwei Saetzen.', 'Auslassung des Verbs.', 'Wiederholung des Subjekts.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Apokoinou: Er kam und war gluecklich der Mann. (der Mann = Subj. beider Saetze)',
    'grammarRule': 'Apokoinou: gemeinsamer Satzteil', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-006', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversionsparallelismus (literarisch)?',
    'options': ['Gross ist die Gefahr, und klein die Hoffnung.', 'Die Gefahr ist gross und die Hoffnung klein.', 'Die Gefahr und die Hoffnung sind verschieden.', 'Es gibt grosse Gefahr und kleine Hoffnung.'],
    'correctAnswer': 0, 'explanation': 'Inversionsparallelismus: Praedikativ im Vorfeld in parallelen Saetzen.',
    'grammarRule': 'Inversionsparallelismus: Praedikativ + V2 parallel', 'subcategory': 'Inversion', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-007', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Satzperiode bei Thomas Mann?',
    'options': ['Komplexe Hypotaxe spiegelt Gedankentiefe und Differenziertheit.', 'Einfache Parataxe fuer Klarheit.', 'Nur kurze Saetze.', 'Nur Fragen.'],
    'correctAnswer': 0, 'explanation': 'Manns Satzperioden: verschachtelte NS-Ketten = intellektuelle Differenziertheit.',
    'grammarRule': 'Satzperiode: Hypotaxe = Gedankentiefe', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-008', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewussten Parataxestil (z.B. Kafka)?',
    'options': ['Er stand auf. Er ging zur Tuer. Er oeffnete sie. Niemand war da.', 'Obwohl er aufstand und zur Tuer ging, die er oeffnete, war niemand da.', 'Er stand auf, ging zur Tuer und oeffnete sie, aber niemand war da.', 'Aufstehend ging er zur Tuer, oeffnete sie und fand niemanden.'],
    'correctAnswer': 0, 'explanation': 'Kafka-Stil: kurze parataktische Saetze = Sachlichkeit, Beklemmung.',
    'grammarRule': 'Parataxestil: kurze HS = Sachlichkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-009', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Anadiplose in der Satzverknuepfung?',
    'options': ['Das letzte Wort eines Satzes wird am Anfang des naechsten aufgegriffen.', 'Wiederholung am Satzanfang.', 'Auslassung des Verbs.', 'Kreuzstellung.'],
    'correctAnswer': 0, 'explanation': 'Anadiplose: Die Liebe bringt Leid. Leid bringt Erkenntnis.',
    'grammarRule': 'Anadiplose: Satzende -> naechster Satzanfang', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-010', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt stilistische Voranstellung des Partizips?',
    'options': ['Vernichtet lag die Stadt, zerstoert die Traeume ihrer Bewohner.', 'Die Stadt lag vernichtet und die Traeume ihrer Bewohner waren zerstoert.', 'Die vernichtete Stadt und die zerstoerten Traeume lagen da.', 'Die Stadt war vernichtet; die Traeume waren zerstoert.'],
    'correctAnswer': 0, 'explanation': 'Partizip im Vorfeld: literarisch, emphatisch.',
    'grammarRule': 'Partizip-Voranstellung: literarisch/emphatisch', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-011', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Hyperbaton in der deutschen Literatursprache?',
    'options': ['Trennung syntaktisch zusammengehoeriger Teile durch Einschub.', 'Zusammenfuegung getrennter Teile.', 'Auslassung des Verbs.', 'Verdopplung des Subjekts.'],
    'correctAnswer': 0, 'explanation': 'Hyperbaton: Gross war die Not des Volkes. (Gross ... Not getrennt)',
    'grammarRule': 'Hyperbaton: Trennung zusammengehoeriger Teile', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-012', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Prolepse mit emphatischem Effekt?',
    'options': ['Diesen Fehler bin ich sicher, dass er bereuen wird.', 'Ich bin sicher, dass er diesen Fehler bereuen wird.', 'Diesen Fehler wird er bereuen, bin ich sicher.', 'Sicher bin ich, diesen Fehler wird er bereuen.'],
    'correctAnswer': 0, 'explanation': 'Prolepse: NS-Objekt (Diesen Fehler) ins Vorfeld des HS gehoben.',
    'grammarRule': 'Prolepse: NS-Element -> HS (emphatisch)', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-013', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung extremer Klammerexpansion?',
    'options': ['Spannung und Verzoegenrungseffekt durch langes Mittelfeld.', 'Klarheit und Kuere.', 'Keine Wirkung.', 'Humor.'],
    'correctAnswer': 0, 'explanation': 'Extreme Klammerexpansion: LK (Verb) ... sehr langes MF ... RK (Partizip) = Spannung.',
    'grammarRule': 'Klammerexpansion: Spannung durch Verzoegerung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-014', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Chiasmus als Stilfigur?',
    'options': ['Ich lebe, um zu arbeiten, und arbeite, um zu leben.', 'Ich lebe und arbeite gleichzeitig.', 'Ich arbeite, um zu leben.', 'Leben und Arbeiten gehoeren zusammen.'],
    'correctAnswer': 0, 'explanation': 'Chiasmus: Kreuzstellung (lebe-arbeiten / arbeite-leben).',
    'grammarRule': 'Chiasmus: A-B / B-A', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-015', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Kohaerenz und Inkohaerenz bei Infinitivkonstruktionen?',
    'options': ['Kohaerenz: Inf. im Verbkomplex. Inkohaerenz: Inf. bildet eigene Phrase.', 'Kein Unterschied.', 'Kohaerenz = HS. Inkohaerenz = NS.', 'Kohaerenz = V2. Inkohaerenz = VL.'],
    'correctAnswer': 0, 'explanation': 'Kohaerenz: ...weil er ihn hat sehen koennen. Inkohaerenz: ...weil er versucht hat, ihn zu sehen.',
    'grammarRule': 'Kohaerenz vs. Inkohaerenz', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'satzklammer']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-016', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Satzverschraenkung in gehobenem Stil?',
    'options': ['Dieses Werk glaube ich, dass die Nachwelt noch lange schaetzen wird.', 'Ich glaube, dass die Nachwelt dieses Werk noch lange schaetzen wird.', 'Dass die Nachwelt dieses Werk schaetzen wird, glaube ich.', 'Die Nachwelt wird dieses Werk schaetzen, glaube ich.'],
    'correctAnswer': 0, 'explanation': 'Satzverschraenkung: NS-Objekt ins Vorfeld des HS (gehobener Stil).',
    'grammarRule': 'Satzverschraenkung: NS-Element -> VF HS', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-017', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Polyptoton in der Satzstruktur?',
    'options': ['Wiederholung eines Wortstamms in verschiedenen Flexionsformen.', 'Auslassung eines Wortes.', 'Kreuzstellung.', 'Parallelismus.'],
    'correctAnswer': 0, 'explanation': 'Polyptoton: Der Richter richtet richtend. (richten in verschiedenen Formen)',
    'grammarRule': 'Polyptoton: Wortstamm in verschiedenen Formen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-018', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Anakoluth als bewusstes Stilmittel?',
    'options': ['Der Mann, der gestern – ich meine, er hatte doch gesagt, er wuerde kommen.', 'Der Mann, der gestern gekommen war, hatte gesagt, er wuerde wiederkommen.', 'Der Mann kam gestern und sagte, er wuerde wiederkommen.', 'Gestern kam der Mann, der gesagt hatte, er wuerde kommen.'],
    'correctAnswer': 0, 'explanation': 'Bewusstes Anakoluth: Satzbruch simuliert muendliches Erzaehlen.',
    'grammarRule': 'Anakoluth: bewusster Satzbruch', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-019', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt eines leeren Vorfelds (V1 in Erzaehlungen)?',
    'options': ['Unmittelbarkeit und Dynamik.', 'Formalitaet.', 'Distanz.', 'Langsamkeit.'],
    'correctAnswer': 0, 'explanation': 'V1-Erzaehlung: Kam ein Reiter des Wegs. -> Unmittelbarkeit, Maerchenton.',
    'grammarRule': 'V1-Erzaehlung: Unmittelbarkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-020', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Litotes als Satzstruktur-Stilmittel?',
    'options': ['Das ist nicht gerade unwichtig. (= sehr wichtig)', 'Das ist sehr wichtig.', 'Das ist unwichtig.', 'Das ist weder wichtig noch unwichtig.'],
    'correctAnswer': 0, 'explanation': 'Litotes: doppelte Negation (nicht + un-) = abgeschwuechte Bejahung.',
    'grammarRule': 'Litotes: nicht + un- = Untertreibung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-021', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Antithese im Satzbau?',
    'options': ['Gegensaetzliche Satzglieder oder Saetze werden kontrastiert.', 'Gleichbedeutende Saetze werden verbunden.', 'Auslassung des Verbs.', 'Wiederholung.'],
    'correctAnswer': 0, 'explanation': 'Antithese: Die einen lachen, die anderen weinen.',
    'grammarRule': 'Antithese: Kontrast in der Satzstruktur', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-022', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Akkumulation (Haeufung)?',
    'options': ['Haeuser, Strassen, Bruecken, Kirchen – alles lag in Truemmern.', 'Alles lag in Truemmern: die Haeuser und die Bruecken.', 'Die Stadt war zerstoert.', 'Es gab keine Haeuser mehr.'],
    'correctAnswer': 0, 'explanation': 'Akkumulation: Reihung gleichartiger Elemente fuer Eindringlichkeit.',
    'grammarRule': 'Akkumulation: Reihung fuer Eindringlichkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-023', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Parenthese in wissenschaftlichen Texten?',
    'options': ['Einschub von Praezisierungen, Einschraenkungen oder Quellenangaben.', 'Nur Dekoration.', 'Verdopplung des Verbs.', 'Streichung des NS.'],
    'correctAnswer': 0, 'explanation': 'Wissenschaftliche Parenthese: Praezisierung (vgl. Muller, 2020) oder Einschraenkung.',
    'grammarRule': 'Wissenschaftliche Parenthese: Praezisierung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-024', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Gradatio (stufenweise Steigerung)?',
    'options': ['Er sprach leise, dann lauter, dann schrie er.', 'Er schrie und sprach leise.', 'Er sprach immer gleich laut.', 'Er schwieg.'],
    'correctAnswer': 0, 'explanation': 'Gradatio: stufenweise Steigerung durch parallele Satzglieder.',
    'grammarRule': 'Gradatio: stufenweise Steigerung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-025', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist freie indirekte Rede (erlebte Rede)?',
    'options': ['Mischform: Erzaehlerperspektive + Figurengedanken ohne Konjunktion.', 'Direkte Rede in Anfuehrungszeichen.', 'Indirekte Rede mit dass.', 'Nur Konjunktiv I.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: Sie blickte hinaus. War das wirklich wahr? (V2, keine Konjunktion)',
    'grammarRule': 'Erlebte Rede: V2 ohne Konjunktion', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-026', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt erlebte Rede?',
    'options': ['Sie sass am Fenster. Morgen wuerde sie abreisen. Aber wohin?', 'Sie sagte, dass sie morgen abreisen wuerde.', 'Sie sass am Fenster und sagte: Morgen reise ich ab.', 'Am Fenster sitzend, ueberlegte sie, wohin sie reisen wuerde.'],
    'correctAnswer': 0, 'explanation': 'Erlebte Rede: Figurenperspektive, V2, Praeteritum, keine Redeeinleitung.',
    'grammarRule': 'Erlebte Rede: Figurenperspektive ohne Einleitung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-027', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Isokolon?',
    'options': ['Parallele Satzglieder/Saetze mit gleicher Laenge und Struktur.', 'Ungleiche Satzglieder.', 'Kreuzstellung.', 'Auslassung.'],
    'correctAnswer': 0, 'explanation': 'Isokolon: Gleiche Laenge + gleiche Struktur in parallelen Saetzen/Gliedern.',
    'grammarRule': 'Isokolon: gleiche Laenge + Struktur', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-028', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion mit Fokuseffekt (literarisch)?',
    'options': ['Verloren hat er alles, was ihm lieb war.', 'Er hat alles verloren, was ihm lieb war.', 'Alles, was ihm lieb war, hat er verloren.', 'Was ihm lieb war, hat er verloren.'],
    'correctAnswer': 0, 'explanation': 'Partizip im Vorfeld: emphatische Fokussierung auf die Handlung.',
    'grammarRule': 'Partizip-Voranstellung: Fokus auf Handlung', 'subcategory': 'Topikalisierung', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-029', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist eine Periode im klassischen Sinne?',
    'options': ['Ein kunstvoll gebauter langer Satz mit Vordersatz (Protasis) und Nachsatz (Apodosis).', 'Ein kurzer HS.', 'Ein Fragesatz.', 'Ein Imperativ.'],
    'correctAnswer': 0, 'explanation': 'Klassische Periode: Protasis (Spannung durch NS) -> Apodosis (Aufloesung im HS).',
    'grammarRule': 'Periode: Protasis -> Apodosis', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-030', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Satzfragmentierung fuer poetischen Effekt?',
    'options': ['Stille. Dann ein Schuss. Dann wieder Stille.', 'Es war still, dann fiel ein Schuss, und dann war es wieder still.', 'Die Stille wurde durch einen Schuss unterbrochen.', 'Nach dem Schuss herrschte wieder Stille.'],
    'correctAnswer': 0, 'explanation': 'Satzfragmente: Nominalsaetze fuer poetische Verdichtung.',
    'grammarRule': 'Satzfragmente: poetische Verdichtung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-031', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der Unterschied zwischen Stil der Fuge und Stil der Reihung?',
    'options': ['Fuge: hypotaktisch (ineinander). Reihung: parataktisch (nebeneinander).', 'Kein Unterschied.', 'Fuge = Parataxe. Reihung = Hypotaxe.', 'Beide nur in Musik.'],
    'correctAnswer': 0, 'explanation': 'Fuge: verschachtelte Hypotaxe. Reihung: einfache Parataxe nebeneinander.',
    'grammarRule': 'Fuge: Hypotaxe. Reihung: Parataxe.', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-032', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Geminatio (Verdopplung)?',
    'options': ['Nein, nein, das kann nicht sein!', 'Nein, das kann nicht sein!', 'Das kann nicht sein!', 'Es ist nicht wahr!'],
    'correctAnswer': 0, 'explanation': 'Geminatio: Wiederholung desselben Wortes direkt hintereinander.',
    'grammarRule': 'Geminatio: direkte Wortwiederholung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-033', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Hypotaxe als Stilmerkmal wissenschaftlicher Texte?',
    'options': ['Komplexe Nebensatzgefuege fuer praezise Argumentation.', 'Kurze parataktische Saetze.', 'Nur Hauptsaetze.', 'Fragmentarischer Stil.'],
    'correctAnswer': 0, 'explanation': 'Wissenschaftliche Hypotaxe: Kausale, konditionale, konzessive NS fuer Praezision.',
    'grammarRule': 'Wissenschaftliche Hypotaxe: praezise Argumentation', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'satzgefuege']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-034', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt rhetorische Frage mit V2 (w-Wort)?',
    'options': ['Wer haette das gedacht? (Niemand.)', 'Wer hat das gedacht?', 'Hat jemand das gedacht?', 'Ich frage, wer das gedacht hat.'],
    'correctAnswer': 0, 'explanation': 'Rhetorische w-Frage (V2): keine echte Frage, Antwort impliziert.',
    'grammarRule': 'Rhetorische w-Frage: Antwort impliziert', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-035', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Praeteritio (Paralipse)?',
    'options': ['Man erwaehnt etwas, indem man sagt, es nicht erwaehnen zu wollen.', 'Man laesst etwas vollstaendig aus.', 'Man wiederholt etwas.', 'Man negiert alles.'],
    'correctAnswer': 0, 'explanation': 'Praeteritio: Ich will gar nicht davon sprechen, dass ... (und spricht doch davon).',
    'grammarRule': 'Praeteritio: Erwaehnung durch Nicht-Erwaehnung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-036', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Exclamatio (Ausruf) mit V1?',
    'options': ['Welch ein Glueck war das!', 'Das war ein grosses Glueck.', 'War das Glueck?', 'Ich frage mich, ob das Glueck war.'],
    'correctAnswer': 0, 'explanation': 'Exclamatio: emotionaler Ausruf, oft mit w-Wort oder V1.',
    'grammarRule': 'Exclamatio: emotionaler Ausruf', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-037', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Funktion der Nachfeldbesetzung in Reden?',
    'options': ['Rhetorischer Nachtrag fuer Nachdruck und Erinnerungseffekt.', 'Keine Funktion.', 'Abschwuechung.', 'Formalisierung.'],
    'correctAnswer': 0, 'explanation': 'Rhetorischer Nachtrag: Wichtiges im Nachfeld bleibt im Gedaechtnis.',
    'grammarRule': 'Nachfeld in Reden: Nachdruck/Erinnerung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-038', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion mit rhetorischem Nachdruck?',
    'options': ['Selten hat man einen solchen Irrtum erlebt.', 'Man hat selten einen solchen Irrtum erlebt.', 'Einen solchen Irrtum hat man selten erlebt.', 'Man hat einen solchen Irrtum erlebt, selten.'],
    'correctAnswer': 0, 'explanation': 'Selten im Vorfeld: rhetorischer Nachdruck auf die Seltenheit.',
    'grammarRule': 'Adverb im Vorfeld: rhetorischer Nachdruck', 'subcategory': 'Inversion', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-039', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Syllepse (semantisches Zeugma)?',
    'options': ['Ein Wort wird in verschiedener Bedeutung auf zwei Bezugswoerter angewendet.', 'Ein Wort wird verdoppelt.', 'Ein Wort wird ausgelassen.', 'Ein Wort wird umgestellt.'],
    'correctAnswer': 0, 'explanation': 'Syllepse: Er hob den Arm und seine Stimme. (heben: physisch + metaphorisch)',
    'grammarRule': 'Syllepse: ein Wort, zwei Bedeutungen', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-040', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Kolon (parallele Glieder)?',
    'options': ['Der Geist ist willig, das Fleisch ist schwach.', 'Der Geist und das Fleisch sind verschieden.', 'Obwohl der Geist willig ist, ist das Fleisch schwach.', 'Sowohl der Geist als auch das Fleisch haben Schwaechen.'],
    'correctAnswer': 0, 'explanation': 'Kolon: zwei parallele Hauptsaetze mit gleichem Bau.',
    'grammarRule': 'Kolon: parallele HS-Struktur', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-041', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Funktion von Asyndeton in Reden?',
    'options': ['Beschleunigung, Eindringlichkeit, Dramatik.', 'Verlangsamung.', 'Formalisierung.', 'Abschwuechung.'],
    'correctAnswer': 0, 'explanation': 'Asyndeton: Aufzaehlung ohne und -> Tempo, Dramatik.',
    'grammarRule': 'Asyndeton: Beschleunigung/Dramatik', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-042', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Epexegese (erklaerenden Nachtrag)?',
    'options': ['Er verliess die Stadt – fuer immer, wie sich herausstellen sollte.', 'Er verliess die Stadt fuer immer.', 'Er verliess die Stadt, und es stellte sich heraus, dass es fuer immer war.', 'Fuer immer verliess er die Stadt.'],
    'correctAnswer': 0, 'explanation': 'Epexegese: erklaerend-praezisierender Nachtrag nach Gedankenstrich.',
    'grammarRule': 'Epexegese: erklaerend-praezisierender Nachtrag', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-043', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist der stilistische Effekt von Polysyndeton?',
    'options': ['Verlangsamung, Feierlichkeit, Gewichtung jedes Elements.', 'Beschleunigung.', 'Kuere.', 'Keine Wirkung.'],
    'correctAnswer': 0, 'explanation': 'Polysyndeton: und ... und ... und -> Verlangsamung, jedes Element betont.',
    'grammarRule': 'Polysyndeton: Verlangsamung/Feierlichkeit', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-044', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Oxymoron in der Satzstruktur?',
    'options': ['Es war ein beredtes Schweigen.', 'Es war sehr still.', 'Niemand sprach ein Wort.', 'Alle schwiegen.'],
    'correctAnswer': 0, 'explanation': 'Oxymoron: Verbindung widersprüchlicher Begriffe (beredt + Schweigen).',
    'grammarRule': 'Oxymoron: widersprüchliche Verbindung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-045', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Pleonasmus in der Satzstruktur?',
    'options': ['Ueberfluessige Verdopplung eines Ausdrucks (weisser Schimmel).', 'Auslassung eines Elements.', 'Kreuzstellung.', 'Parallelismus.'],
    'correctAnswer': 0, 'explanation': 'Pleonasmus: bedeutungsgleiche Verdopplung (stilistisch bewusst oder fehlerhaft).',
    'grammarRule': 'Pleonasmus: ueberfluessige Verdopplung', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-046', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt bewusste Abweichung von TeKaMoLo fuer Fokuseffekt?',
    'options': ['In Berlin hat er gestern aus purem Leichtsinn das Auto gestohlen.', 'Er hat gestern aus purem Leichtsinn in Berlin das Auto gestohlen.', 'Er hat gestern in Berlin aus purem Leichtsinn das Auto gestohlen.', 'Er hat das Auto gestern in Berlin aus purem Leichtsinn gestohlen.'],
    'correctAnswer': 0, 'explanation': 'Lokal vor Temporal: Fokus auf den Ort (In Berlin!) durch Vorfeldbesetzung.',
    'grammarRule': 'TeKaMoLo-Abweichung: Fokus auf bestimmtes Element', 'subcategory': 'Scrambling', 'tags': ['satzbau', 'scrambling']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-047', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Paronomasie?',
    'options': ['Wortspiel mit klangaehnlichen Woertern.', 'Auslassung des Verbs.', 'Kreuzstellung.', 'Verdopplung.'],
    'correctAnswer': 0, 'explanation': 'Paronomasie: Wer rastet, der rostet. (rasten/rosten = klangaehnlich)',
    'grammarRule': 'Paronomasie: Wortspiel mit Klangnaeaehe', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-048', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Trikolon (Dreierformel)?',
    'options': ['Freiheit, Gleichheit, Bruederlichkeit – das waren seine Ideale.', 'Freiheit und Gleichheit waren seine Ideale.', 'Seine Ideale waren vielfaeltig.', 'Er hatte viele Ideale.'],
    'correctAnswer': 0, 'explanation': 'Trikolon: Dreigliedrige Aufzaehlung fuer Emphase.',
    'grammarRule': 'Trikolon: dreigliedrige Aufzaehlung', 'subcategory': 'Informationsstruktur', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-049', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die stilistische Wirkung von Sperrung (Distanzstellung)?',
    'options': ['Spannung durch Distanz zwischen zusammengehoerigen Satzgliedern.', 'Entspannung.', 'Kuere.', 'Klarheit.'],
    'correctAnswer': 0, 'explanation': 'Sperrung erzeugt Spannung: Der Leser wartet auf die Aufloesung.',
    'grammarRule': 'Sperrung: Spannung durch Distanz', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-050', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Inversion mit emphatischer Wirkung in der Rede?',
    'options': ['Nie zuvor hat ein Mensch solches Leid erfahren.', 'Ein Mensch hat nie zuvor solches Leid erfahren.', 'Solches Leid hat nie zuvor ein Mensch erfahren.', 'Ein Mensch hat solches Leid nie zuvor erfahren.'],
    'correctAnswer': 0, 'explanation': 'Nie zuvor im Vorfeld: emphatischer Nachdruck in der Rede.',
    'grammarRule': 'Emphatische Inversion: Adverb im Vorfeld', 'subcategory': 'Inversion', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-051', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist Tmesis in der deutschen Sprache?',
    'options': ['Trennung eines Kompositums durch ein eingefuegtes Wort.', 'Verdoppelung eines Verbs.', 'Streichung des Subjekts.', 'Umstellung aller Satzglieder.'],
    'correctAnswer': 0, 'explanation': 'Tmesis: Trennung zusammengesetzter Woerter (z.B. \'was fuer ein\' statt \'was fuer einer\').',
    'grammarRule': 'Tmesis: Trennung eines Kompositums', 'subcategory': 'Verbposition', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-052', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Asyndeton als Stilmittel?',
    'options': ['Er kam, sah, siegte.', 'Er kam und sah und siegte.', 'Er kam, und er sah, und er siegte.', 'Nachdem er kam und sah, siegte er.'],
    'correctAnswer': 0, 'explanation': 'Asyndeton: Aufzaehlung ohne Konjunktionen -> Dynamik, Schnelligkeit.',
    'grammarRule': 'Asyndeton: Aufzaehlung ohne Konjunktionen', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-053', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Was ist die Wirkung von bewusst langen Perioden (Hypotaxe)?',
    'options': ['Komplexitaet, Differenziertheit, Spannung.', 'Einfachheit und Klarheit.', 'Humor.', 'Kuerze und Praegnanz.'],
    'correctAnswer': 0, 'explanation': 'Lange hypotaktische Perioden erzeugen Komplexitaet und halten die Spannung bis zum Ende.',
    'grammarRule': 'Hypotaktische Periode: Komplexitaet + Spannung', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  },
  {
    'language': 'german', 'id': 'c2-satzbau-p2-054', 'level': 'c2', 'category': 'Satzstruktur',
    'question': 'Welcher Satz zeigt Polysyndeton als Stilmittel?',
    'options': ['Und es regnet und es stuermt und es donnert.', 'Es regnet, stuermt, donnert.', 'Es regnet. Es stuermt. Es donnert.', 'Es regnet, aber stuermt und donnert.'],
    'correctAnswer': 0, 'explanation': 'Polysyndeton: Wiederholung der Konjunktion \'und\' -> Nachdruck, Unaufhoerlichkeit.',
    'grammarRule': 'Polysyndeton: wiederholte Konjunktion', 'subcategory': 'Satzklammer', 'tags': ['satzbau', 'stilistik']
  }
];

export default questions;
