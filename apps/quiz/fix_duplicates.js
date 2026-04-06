#!/usr/bin/env node
/**
 * Fixes duplicate question texts across German quiz categories.
 * For each duplicate ID, replaces the question, options, correctAnswer, explanation, etc.
 * with a new unique question on the same grammatical topic.
 */
const fs = require('fs');
const path = require('path');

const BASE = 'src/data/german/b1';

// Each entry: id -> replacement question fields as a JSON fragment
// The script will find the question block by ID and replace all fields
const REPLACEMENTS = {

  // ============ KONJUNKTIV ============
  // Part 2 replacements
  "b1-konjunktiv-p2-001": {q:`Wie bildet man den Konjunktiv I von regelmäßigen Verben (er/sie/es)?`,opts:["er/sie arbeite","er/sie arbeitet","er/sie arbeitete","er/sie hat gearbeitet"],correct:0,expl:"Der Konjunktiv I regelmäßiger Verben: Stamm + -e (er arbeite, er lerne).",rule:"KI regelmäßig: Stamm + e (er lerne, er arbeite)"},
  "b1-konjunktiv-p2-002": {q:`Wie lautet der Konjunktiv II von 'bleiben' (er/sie)?`,opts:["bliebe","blieb","bleibt","würde bleibe"],correct:0,expl:"'bleiben' KII: bliebe.",rule:"KII starker Verben: Präteritumstamm + Umlaut + -e"},
  "b1-konjunktiv-p2-004": {q:`Wie lautet der Konjunktiv I von 'haben' (er/sie)?`,opts:["hätte","hat","habe","hatte"],correct:2,expl:"KI von 'haben': er habe.",rule:"KI: haben → er habe"},
  "b1-konjunktiv-p2-005": {q:`Wie lautet der Konjunktiv II von 'helfen' (er/sie)?`,opts:["hülfe","half","hilft","hätte geholfen"],correct:0,expl:"KII von 'helfen': hülfe (oder: würde helfen).",rule:"KII starker Verben: Präteritumstamm + Umlaut + -e"},
  "b1-konjunktiv-p2-008": {q:`Wie lautet der Konjunktiv II von 'sprechen' (er/sie)?`,opts:["spräche","sprach","spricht","würde spreche"],correct:0,expl:"KII von 'sprechen': spräche.",rule:"KII: sprechen → spräche"},
  "b1-konjunktiv-p2-011": {q:`Wie lautet der Konjunktiv I von 'sein' (er/sie)?`,opts:["wäre","ist","sei","war"],correct:2,expl:"KI von 'sein': er sei (unregelmäßig).",rule:"KI sein → er sei (Ausnahme)"},
  "b1-konjunktiv-p2-017": {q:`Was ist der Unterschied zwischen Konjunktiv I und Konjunktiv II?`,opts:["KI für indirekte Rede; KII für Irreales","KI für Irreales; KII für indirekte Rede","Beide bedeuten dasselbe","KI für Vergangenheit; KII für Gegenwart"],correct:0,expl:"KI wird hauptsächlich für indirekte Rede genutzt; KII für irreale Bedingungen und höfliche Bitten.",rule:"KI = indirekte Rede; KII = Irrealis/Höflichkeit"},
  "b1-konjunktiv-p2-020": {q:`Wie lautet der Konjunktiv II von 'schreiben' (er/sie)?`,opts:["schriebe","schrieb","schreibt","würde schreibe"],correct:0,expl:"KII von 'schreiben': schriebe.",rule:"KII: schreiben → schriebe"},
  "b1-konjunktiv-p2-026": {q:`Welchen Konjunktiv verwendet man für höfliche Bitten?`,opts:["Konjunktiv I","Konjunktiv II","Indikativ","Imperativ"],correct:1,expl:"Konjunktiv II drückt Höflichkeit aus: 'Könnten Sie mir helfen?'",rule:"KII für höfliche Bitten: könnte, würde, dürfte"},
  "b1-konjunktiv-p2-029": {q:`Wie lautet der Konjunktiv II von 'laufen' (er/sie)?`,opts:["liefe","lief","läuft","würde laufe"],correct:0,expl:"KII von 'laufen': liefe.",rule:"KII: laufen → liefe"},
  "b1-konjunktiv-p2-041": {q:`Wie lautet der Konjunktiv II von 'halten' (er/sie)?`,opts:["hielte","hielt","hält","würde halte"],correct:0,expl:"KII von 'halten': hielte.",rule:"KII: halten → hielte"},
  "b1-konjunktiv-p2-044": {q:`Wie lautet der Konjunktiv II von 'fallen' (er/sie)?`,opts:["fiele","fiel","fällt","würde falle"],correct:0,expl:"KII von 'fallen': fiele.",rule:"KII: fallen → fiele"},
  "b1-konjunktiv-p2-047": {q:`Wie lautet der Konjunktiv II von 'schlafen' (er/sie)?`,opts:["schliefe","schlief","schläft","würde schlafe"],correct:0,expl:"KII von 'schlafen': schliefe.",rule:"KII: schlafen → schliefe"},
  "b1-konjunktiv-p2-050": {q:`Wie lautet der Konjunktiv II von 'tragen' (er/sie)?`,opts:["trüge","trug","trägt","würde trage"],correct:0,expl:"KII von 'tragen': trüge.",rule:"KII: tragen → trüge"},

  // Part 3 replacements
  "b1-konjunktiv-p3-001": {q:`In welchem Satz steht der Konjunktiv II für eine irreale Bedingung?`,opts:["Wenn er Zeit hat, kommt er.","Wenn er Zeit hätte, käme er.","Er sagt, er komme morgen.","Wenn er Zeit haben wird, kommt er."],correct:1,expl:"'Wenn er Zeit hätte, käme er' = irreale Bedingung im KII.",rule:"Irrealer Konditionalsatz: Wenn + KII, KII"},
  "b1-konjunktiv-p3-003": {q:`Wie lautet der Konjunktiv II von 'fahren' (wir)?`,opts:["führen","fuhren","fahren","würden fahren"],correct:0,expl:"KII von 'fahren' (wir): führen.",rule:"KII: fahren → er führe / wir führen"},
  "b1-konjunktiv-p3-005": {q:`Wie lautet der Konjunktiv I von 'kommen' (er/sie)?`,opts:["käme","kommt","komme","kam"],correct:2,expl:"KI von 'kommen': er komme.",rule:"KI: kommen → er komme"},
  "b1-konjunktiv-p3-006": {q:`Wie lautet der Konjunktiv II von 'trinken' (er/sie)?`,opts:["tränke","trank","trinkt","würde trinke"],correct:0,expl:"KII von 'trinken': tränke.",rule:"KII: trinken → tränke"},
  "b1-konjunktiv-p3-009": {q:`Wie lautet der Konjunktiv II von 'lesen' (er/sie)?`,opts:["läse","las","liest","würde lese"],correct:0,expl:"KII von 'lesen': läse.",rule:"KII: lesen → läse"},
  "b1-konjunktiv-p3-012": {q:`Wie lautet der Konjunktiv II von 'schließen' (er/sie)?`,opts:["schlösse","schloss","schließt","würde schließe"],correct:0,expl:"KII von 'schließen': schlösse.",rule:"KII: schließen → schlösse"},
  "b1-konjunktiv-p3-015": {q:`Wie lautet der Konjunktiv II von 'fliegen' (er/sie)?`,opts:["flöge","flog","fliegt","würde fliege"],correct:0,expl:"KII von 'fliegen': flöge.",rule:"KII: fliegen → flöge"},
  "b1-konjunktiv-p3-021": {q:`Wie lautet der Konjunktiv II von 'sinken' (er/sie)?`,opts:["sänke","sank","sinkt","würde sinke"],correct:0,expl:"KII von 'sinken': sänke.",rule:"KII: sinken → sänke"},
  "b1-konjunktiv-p3-024": {q:`Wie lautet der Konjunktiv II von 'bieten' (er/sie)?`,opts:["böte","bot","bietet","würde biete"],correct:0,expl:"KII von 'bieten': böte.",rule:"KII: bieten → böte"},
  "b1-konjunktiv-p3-027": {q:`Welche Form ist Konjunktiv II Vergangenheit von 'gehen'?`,opts:["wäre gegangen","ist gegangen","ging","ginge"],correct:0,expl:"KII Vergangenheit: wäre + Partizip II (wäre gegangen).",rule:"KII Vergangenheit: wäre/hätte + Partizip II"},
  "b1-konjunktiv-p3-030": {q:`Wie lautet der Konjunktiv II von 'ziehen' (er/sie)?`,opts:["zöge","zog","zieht","würde ziehe"],correct:0,expl:"KII von 'ziehen': zöge.",rule:"KII: ziehen → zöge"},
  "b1-konjunktiv-p3-033": {q:`Wie lautet der Konjunktiv II von 'rufen' (er/sie)?`,opts:["riefe","rief","ruft","würde rufe"],correct:0,expl:"KII von 'rufen': riefe.",rule:"KII: rufen → riefe"},
  "b1-konjunktiv-p3-036": {q:`Wie lautet der Konjunktiv II von 'werfen' (er/sie)?`,opts:["würfe","warf","wirft","würde werfe"],correct:0,expl:"KII von 'werfen': würfe.",rule:"KII: werfen → würfe"},
  "b1-konjunktiv-p3-039": {q:`Welche Form drückt eine höfliche Bitte aus?`,opts:["Geben Sie mir das Buch!","Kannst du mir das Buch geben?","Könnten Sie mir das Buch geben?","Du gibst mir das Buch."],correct:2,expl:"'Könnten Sie...' = höfliche Bitte im Konjunktiv II.",rule:"KII für Höflichkeit: könnten, würden, dürften"},
  "b1-konjunktiv-p3-042": {q:`Wie lautet der Konjunktiv II von 'stehlen' (er/sie)?`,opts:["stähle","stahl","stiehlt","würde stehle"],correct:0,expl:"KII von 'stehlen': stähle.",rule:"KII: stehlen → stähle"},
  "b1-konjunktiv-p3-045": {q:`Wie lautet der Konjunktiv II von 'fechten' (er/sie)?`,opts:["föchte","focht","ficht","würde fechte"],correct:0,expl:"KII von 'fechten': föchte.",rule:"KII: fechten → föchte"},
  "b1-konjunktiv-p3-048": {q:`Wie lautet der Konjunktiv II von 'braten' (er/sie)?`,opts:["briete","briet","brät","würde brate"],correct:0,expl:"KII von 'braten': briete.",rule:"KII: braten → briete"},
  "b1-konjunktiv-p3-058": {q:`Wie lautet der Konjunktiv I von 'arbeiten' (er/sie)?`,opts:["arbeite","arbeitet","arbeitete","hat gearbeitet"],correct:0,expl:"KI von 'arbeiten': er arbeite.",rule:"KI regelmäßig: Stamm + -e"},

  // Part 4 replacements
  "b1-konjunktiv-p4-001": {q:`Wie lautet der Konjunktiv II von 'brechen' (er/sie)?`,opts:["bräche","brach","bricht","würde breche"],correct:0,expl:"KII von 'brechen': bräche.",rule:"KII: brechen → bräche"},
  "b1-konjunktiv-p4-002": {q:`Welcher Satz drückt einen irrealen Wunsch aus?`,opts:["Ich wünsche mir ein neues Auto.","Wenn ich ein Auto hätte!","Ich habe ein Auto gekauft.","Ich werde ein Auto kaufen."],correct:1,expl:"'Wenn ich ein Auto hätte!' = irrealer Wunschsatz im KII.",rule:"Irrealer Wunsch: Wenn ich ... hätte/wäre/könnte!"},
  "b1-konjunktiv-p4-003": {q:`Wie lautet der Konjunktiv I von 'lernen' (er/sie)?`,opts:["lerne","lernt","lernte","hat gelernt"],correct:0,expl:"KI von 'lernen': er lerne.",rule:"KI regelmäßig: Stamm + -e"},
  "b1-konjunktiv-p4-006": {q:`Wie lautet der Konjunktiv I von 'machen' (er/sie)?`,opts:["mache","macht","machte","hat gemacht"],correct:0,expl:"KI von 'machen': er mache.",rule:"KI regelmäßig: Stamm + -e"},
  "b1-konjunktiv-p4-007": {q:`Wie lautet der Konjunktiv II von 'schwimmen' (er/sie)?`,opts:["schwömme","schwamm","schwimmt","würde schwimme"],correct:0,expl:"KII von 'schwimmen': schwömme.",rule:"KII: schwimmen → schwömme"},
  "b1-konjunktiv-p4-010": {q:`Wie lautet der Konjunktiv II von 'treffen' (er/sie)?`,opts:["träfe","traf","trifft","würde treffe"],correct:0,expl:"KII von 'treffen': träfe.",rule:"KII: treffen → träfe"},
  "b1-konjunktiv-p4-013": {q:`Wie lautet der Konjunktiv II von 'empfehlen' (er/sie)?`,opts:["empföhle","empfahl","empfiehlt","würde empfehle"],correct:0,expl:"KII von 'empfehlen': empföhle.",rule:"KII: empfehlen → empföhle"},
  "b1-konjunktiv-p4-016": {q:`Wie lautet der Konjunktiv II von 'beginnen' (er/sie)?`,opts:["begänne","begann","beginnt","würde beginne"],correct:0,expl:"KII von 'beginnen': begänne.",rule:"KII: beginnen → begänne"},
  "b1-konjunktiv-p4-019": {q:`Welche Form ist Konjunktiv II Vergangenheit von 'kommen'?`,opts:["wäre gekommen","ist gekommen","kam","käme"],correct:0,expl:"KII Vergangenheit: wäre + Partizip II (wäre gekommen).",rule:"KII Vergangenheit: wäre/hätte + P.II"},
  "b1-konjunktiv-p4-022": {q:`Wie lautet der Konjunktiv II von 'gewinnen' (er/sie)?`,opts:["gewönne","gewann","gewinnt","würde gewinne"],correct:0,expl:"KII von 'gewinnen': gewönne.",rule:"KII: gewinnen → gewönne"},
  "b1-konjunktiv-p4-025": {q:`Wie lautet der Konjunktiv II von 'sterben' (er/sie)?`,opts:["stürbe","starb","stirbt","würde sterbe"],correct:0,expl:"KII von 'sterben': stürbe.",rule:"KII: sterben → stürbe"},
  "b1-konjunktiv-p4-031": {q:`Wie lautet der Konjunktiv II von 'graben' (er/sie)?`,opts:["grübe","grub","gräbt","würde grabe"],correct:0,expl:"KII von 'graben': grübe.",rule:"KII: graben → grübe"},
  "b1-konjunktiv-p4-034": {q:`Wie lautet der Konjunktiv II von 'waschen' (er/sie)?`,opts:["würde waschen","wusch","wäscht","wüsche"],correct:3,expl:"KII von 'waschen': wüsche.",rule:"KII: waschen → wüsche"},
  "b1-konjunktiv-p4-037": {q:`Wie lautet der Konjunktiv II von 'tragen' (er/sie)?`,opts:["trüge","trug","trägt","würde trage"],correct:0,expl:"KII von 'tragen': trüge.",rule:"KII: tragen → trüge"},
  "b1-konjunktiv-p4-040": {q:`Wie lautet der Konjunktiv II von 'schlagen' (er/sie)?`,opts:["schlüge","schlug","schlägt","würde schlage"],correct:0,expl:"KII von 'schlagen': schlüge.",rule:"KII: schlagen → schlüge"},
  "b1-konjunktiv-p4-043": {q:`Wie lautet der Konjunktiv II von 'fangen' (er/sie)?`,opts:["finge","fing","fängt","würde fange"],correct:0,expl:"KII von 'fangen': finge.",rule:"KII: fangen → finge"},
  "b1-konjunktiv-p4-046": {q:`Wie bildet man 'würde'-Form im Konjunktiv II?`,opts:["würde + Infinitiv","würde + Partizip II","würde + zu + Infinitiv","hat + Partizip II"],correct:0,expl:"Die würde-Form: würde + Infinitiv (ich würde gehen).",rule:"KII Umschreibung: würde + Infinitiv"},
  "b1-konjunktiv-p4-054": {q:`Wie lautet der Konjunktiv II von 'heben' (er/sie)?`,opts:["höbe","hob","hebt","würde hebe"],correct:0,expl:"KII von 'heben': höbe.",rule:"KII: heben → höbe"},
  "b1-konjunktiv-p4-056": {q:`Wie lautet der Konjunktiv II von 'biegen' (er/sie)?`,opts:["böge","bog","biegt","würde biege"],correct:0,expl:"KII von 'biegen': böge.",rule:"KII: biegen → böge"},
  "b1-konjunktiv-p4-057": {q:`Wie lautet der Konjunktiv II von 'fließen' (er/sie)?`,opts:["flösse","floss","fließt","würde fließe"],correct:0,expl:"KII von 'fließen': flösse.",rule:"KII: fließen → flösse"},

  // Part 5 replacements
  "b1-konjunktiv-p5-005": {q:`Wie lautet der Konjunktiv II von 'pflegen' (er/sie)?`,opts:["pflegte","pflegt","würde pflegen","pfläge"],correct:2,expl:"'pflegen' ist ein regelmäßiges Verb. KII: pflegte (aber oft wird 'würde pflegen' bevorzugt).",rule:"KII regelmäßiger Verben = Präteritum (aber würde + Inf. ist üblicher)"},
  "b1-konjunktiv-p5-008": {q:`Wie lautet der Konjunktiv II von 'hängen' (er/sie)?`,opts:["hinge","hing","hängt","würde hange"],correct:0,expl:"KII von 'hängen': hinge.",rule:"KII: hängen → hinge"},
  "b1-konjunktiv-p5-014": {q:`Wie lautet der Konjunktiv II von 'singen' (er/sie)?`,opts:["sänge","sang","singt","würde singe"],correct:0,expl:"KII von 'singen': sänge.",rule:"KII: singen → sänge"},
  "b1-konjunktiv-p5-017": {q:`Wie lautet der Konjunktiv II von 'trinken' (er/sie)?`,opts:["tränke","trank","trinkt","würde trinke"],correct:0,expl:"KII von 'trinken': tränke.",rule:"KII: trinken → tränke"},
  "b1-konjunktiv-p5-020": {q:`Wie lautet der Konjunktiv II von 'liegen' (er/sie)?`,opts:["läge","lag","liegt","würde liege"],correct:0,expl:"KII von 'liegen': läge.",rule:"KII: liegen → läge"},
  "b1-konjunktiv-p5-023": {q:`Wie lautet der Konjunktiv II von 'bitten' (er/sie)?`,opts:["bäte","bat","bittet","würde bitte"],correct:0,expl:"KII von 'bitten': bäte.",rule:"KII: bitten → bäte"},
  "b1-konjunktiv-p5-026": {q:`Wie lautet der Konjunktiv II von 'reiten' (er/sie)?`,opts:["ritte","ritt","reitet","würde reite"],correct:0,expl:"KII von 'reiten': ritte.",rule:"KII: reiten → ritte"},
  "b1-konjunktiv-p5-029": {q:`Wie lautet der Konjunktiv II von 'schneiden' (er/sie)?`,opts:["schnitte","schnitt","schneidet","würde schneide"],correct:0,expl:"KII von 'schneiden': schnitte.",rule:"KII: schneiden → schnitte"},
  "b1-konjunktiv-p5-032": {q:`Wie lautet der Konjunktiv II von 'laden' (er/sie)?`,opts:["lüde","lud","lädt","würde lade"],correct:0,expl:"KII von 'laden': lüde.",rule:"KII: laden → lüde"},
  "b1-konjunktiv-p5-035": {q:`Wie lautet der Konjunktiv II von 'stoßen' (er/sie)?`,opts:["stieße","stieß","stößt","würde stoße"],correct:0,expl:"KII von 'stoßen': stieße.",rule:"KII: stoßen → stieße"},
  "b1-konjunktiv-p5-038": {q:`Wie lautet der Konjunktiv II von 'wachsen' (er/sie)?`,opts:["wüchse","wuchs","wächst","würde wachse"],correct:0,expl:"KII von 'wachsen': wüchse.",rule:"KII: wachsen → wüchse"},
  "b1-konjunktiv-p5-041": {q:`Wie lautet der Konjunktiv II von 'erscheinen' (er/sie)?`,opts:["erschiene","erschien","erscheint","würde erscheine"],correct:0,expl:"KII von 'erscheinen': erschiene.",rule:"KII: erscheinen → erschiene"},
  "b1-konjunktiv-p5-050": {q:`Wie lautet der Konjunktiv II von 'springen' (er/sie)?`,opts:["spränge","sprang","springt","würde springe"],correct:0,expl:"KII von 'springen': spränge.",rule:"KII: springen → spränge"},
  "b1-konjunktiv-p5-051": {q:`Welche Funktion hat der Konjunktiv II in 'Er täte es gern.'?`,opts:["Indirekte Rede","Irreales/Wunsch","Zukunft","Vergangenheit"],correct:1,expl:"'Er täte es gern' = irrealer Wunsch im KII.",rule:"KII: tun → täte (Wunsch/Irrealis)"},
  "b1-konjunktiv-p5-071": {q:`Wie lautet der Konjunktiv II von 'frieren' (er/sie)?`,opts:["fröre","fror","friert","würde friere"],correct:0,expl:"KII von 'frieren': fröre.",rule:"KII: frieren → fröre"},
  "b1-konjunktiv-p5-076": {q:`Wie lautet der Konjunktiv II von 'schreien' (er/sie)?`,opts:["schriee","schrie","schreit","würde schreie"],correct:0,expl:"KII von 'schreien': schriee.",rule:"KII: schreien → schriee"},
  "b1-konjunktiv-p5-077": {q:`Wie lautet der Konjunktiv II von 'steigen' (er/sie)?`,opts:["stiege","stieg","steigt","würde steige"],correct:0,expl:"KII von 'steigen': stiege.",rule:"KII: steigen → stiege"},

  // ============ PASSIV ============
  // Part 1 internal dups (within part1 itself)
  "b1-passiv-p1-043": {q:`Wie lautet das Passiv von 'Man backt den Kuchen.'?`,opts:["Der Kuchen wird gebacken.","Den Kuchen wird gebacken.","Der Kuchen ist gebacken worden.","Der Kuchen wird backen."],correct:0,expl:"Präsens Passiv: 'Der Kuchen wird gebacken.'",rule:"Vorgangspassiv Präsens: wird + Partizip II"},
  "b1-passiv-p1-067": {q:`Welches Verb kann kein persönliches Passiv bilden?`,opts:["bauen","kochen","schlafen","reparieren"],correct:2,expl:"'schlafen' ist intransitiv und hat kein Akkusativobjekt, daher kein persönliches Passiv.",rule:"Kein pers. Passiv: intransitive Verben (schlafen, laufen, sterben)"},

  // Part 2 dups
  "b1-passiv-p2-002": {q:`Wie lautet das Passiv Präteritum von 'Der Arzt operiert den Patienten.'?`,opts:["Der Patient wurde vom Arzt operiert.","Der Patient wird vom Arzt operiert.","Der Arzt wurde vom Patienten operiert.","Der Patient ist operiert worden."],correct:0,expl:"Präteritum Passiv: 'Der Patient wurde vom Arzt operiert.'",rule:"Vorgangspassiv Präteritum: wurde/wurden + Partizip II"},
  "b1-passiv-p2-003": {q:`Wie lautet das Passiv Perfekt von 'Man hat das Paket geliefert.'?`,opts:["Das Paket ist geliefert worden.","Das Paket wurde geliefert.","Das Paket wird geliefert.","Das Paket war geliefert worden."],correct:0,expl:"Perfekt Passiv: 'Das Paket ist geliefert worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p2-006": {q:`Formulieren Sie im Passiv: 'Die Polizei kontrolliert die Pässe.'`,opts:["Die Pässe werden von der Polizei kontrolliert.","Die Pässe wurden kontrolliert.","Die Pässe sind kontrolliert worden.","Die Polizei wird kontrolliert."],correct:0,expl:"Präsens Passiv: 'Die Pässe werden von der Polizei kontrolliert.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p2-009": {q:`Formulieren Sie im Passiv: 'Man hat die Fenster geputzt.'`,opts:["Die Fenster sind geputzt worden.","Die Fenster werden geputzt.","Die Fenster wurden geputzt.","Die Fenster waren geputzt worden."],correct:0,expl:"Perfekt Passiv: 'Die Fenster sind geputzt worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p2-012": {q:`Ergänzen Sie: 'Das Haus ___ gerade renoviert.' (Präsens Passiv)`,opts:["ist","hat","wird","wurde"],correct:2,expl:"Präsens Passiv: wird + Partizip II.",rule:"Vorgangspassiv Präsens: wird/werden + Partizip II"},
  "b1-passiv-p2-018": {q:`Formulieren Sie im Passiv: 'Die Studenten schreiben die Prüfung.'`,opts:["Die Prüfung wird von den Studenten geschrieben.","Die Studenten werden geschrieben.","Die Prüfung ist geschrieben worden.","Die Prüfung wurde geschrieben."],correct:0,expl:"Präsens Passiv: 'Die Prüfung wird von den Studenten geschrieben.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p2-024": {q:`Welche Zeitform ist: 'Die Tür war geöffnet worden.'?`,opts:["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Plusquamperfekt Passiv"],correct:3,expl:"'war + Partizip II + worden' = Plusquamperfekt Passiv.",rule:"Vorgangspassiv Plusquamperfekt: war/waren + Partizip II + worden"},
  "b1-passiv-p2-027": {q:`Formulieren Sie im Passiv: 'Man wird das Ergebnis bekannt geben.'`,opts:["Das Ergebnis wird bekannt gegeben werden.","Das Ergebnis wird bekannt gegeben.","Das Ergebnis wurde bekannt gegeben.","Das Ergebnis ist bekannt gegeben worden."],correct:0,expl:"Futur I Passiv: 'Das Ergebnis wird bekannt gegeben werden.'",rule:"Vorgangspassiv Futur I: wird + Partizip II + werden"},
  "b1-passiv-p2-030": {q:`Ergänzen Sie: 'Die Briefe ___ gestern abgeschickt ___.' (Perfekt Passiv)`,opts:["wurden ... worden","haben ... werden","sind ... worden","werden ... werden"],correct:2,expl:"Perfekt Passiv: sind + Partizip II + worden.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p2-031": {q:`Welcher Satz steht im Zustandspassiv?`,opts:["Das Licht wird ausgeschaltet.","Das Licht wurde ausgeschaltet.","Das Licht ist ausgeschaltet.","Das Licht ist ausgeschaltet worden."],correct:2,expl:"'ist + Partizip II' (ohne 'worden') = Zustandspassiv.",rule:"Zustandspassiv: sein + Partizip II"},
  "b1-passiv-p2-036": {q:`Formulieren Sie im Passiv Präteritum: 'Der Koch bereitete das Frühstück zu.'`,opts:["Das Frühstück wird zubereitet.","Das Frühstück wurde vom Koch zubereitet.","Das Frühstück ist zubereitet worden.","Das Frühstück war zubereitet worden."],correct:1,expl:"Präteritum Passiv: 'Das Frühstück wurde vom Koch zubereitet.'",rule:"Vorgangspassiv Präteritum: wurde/wurden + Partizip II"},
  "b1-passiv-p2-054": {q:`Welcher Satz steht im Vorgangspassiv?`,opts:["Die Tür ist geschlossen.","Die Tür wird geschlossen.","Die Tür war geschlossen.","Die Tür bleibt geschlossen."],correct:1,expl:"'wird + Partizip II' = Vorgangspassiv.",rule:"werden + P.II = Vorgangspassiv"},
  "b1-passiv-p2-060": {q:`Was bedeutet 'durch' im Passivsatz?`,opts:["Das direkte Agens (Person)","Ein Mittel oder eine Ursache (nicht belebt)","Den Ort der Handlung","Die Zeitangabe"],correct:1,expl:"'durch' zeigt das Mittel/Instrument: 'Das Fenster wurde durch den Sturm zerstört.'",rule:"von + Dativ = Agens (Person); durch + Akkusativ = Mittel/Ursache"},
  "b1-passiv-p2-064": {q:`Welcher Satz ist KEIN Passiv?`,opts:["Die Pizza wird gebacken.","Das Kind wird müde.","Die Post wird geliefert.","Der Vertrag wird unterschrieben."],correct:1,expl:"'Das Kind wird müde' = 'werden' als Vollverb (Zustandsänderung), kein Passiv.",rule:"werden + Adjektiv = Vollverb; werden + Partizip II = Passiv"},

  // Part 3 dups
  "b1-passiv-p3-001": {q:`Formulieren Sie im Passiv: 'Man hat das Projekt abgeschlossen.'`,opts:["Das Projekt ist abgeschlossen worden.","Das Projekt wird abgeschlossen.","Das Projekt wurde abgeschlossen.","Das Projekt war abgeschlossen worden."],correct:0,expl:"Perfekt Passiv: 'Das Projekt ist abgeschlossen worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p3-002": {q:`Wie lautet Passiv Präteritum von 'Der Arzt verschrieb das Medikament.'?`,opts:["Das Medikament wird verschrieben.","Das Medikament wurde vom Arzt verschrieben.","Das Medikament ist verschrieben worden.","Das Medikament war verschrieben worden."],correct:1,expl:"Präteritum Passiv: 'Das Medikament wurde vom Arzt verschrieben.'",rule:"Vorgangspassiv Präteritum: wurde + Partizip II"},
  "b1-passiv-p3-003": {q:`Ergänzen Sie: 'Das Auto ___ gerade gewaschen.' (Präsens Passiv)`,opts:["ist","hat","wird","wurde"],correct:2,expl:"Präsens Passiv: wird + Partizip II.",rule:"Vorgangspassiv Präsens: wird/werden + Partizip II"},
  "b1-passiv-p3-004": {q:`Formulieren Sie im Passiv: 'Die Sekretärin tippt den Brief.'`,opts:["Der Brief wird von der Sekretärin getippt.","Die Sekretärin wird getippt.","Der Brief ist getippt worden.","Der Brief wurde getippt."],correct:0,expl:"Präsens Passiv: 'Der Brief wird von der Sekretärin getippt.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p3-007": {q:`Welche Zeitform ist: 'Die Aufgaben sind verteilt worden.'?`,opts:["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Plusquamperfekt Passiv"],correct:1,expl:"'sind + Partizip II + worden' = Perfekt Passiv.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p3-013": {q:`Formulieren Sie im Passiv: 'Man renoviert das Schwimmbad.'`,opts:["Das Schwimmbad wird renoviert.","Das Schwimmbad ist renoviert.","Das Schwimmbad wurde renoviert.","Das Schwimmbad war renoviert worden."],correct:0,expl:"Präsens Passiv: 'Das Schwimmbad wird renoviert.'",rule:"Aktiv mit 'man' → Passiv ohne Agens"},
  "b1-passiv-p3-016": {q:`Welcher Satz zeigt unpersönliches Passiv?`,opts:["Das Buch wird gelesen.","Es wird hier nicht telefoniert.","Die Tür wird geschlossen.","Das Problem wird gelöst."],correct:1,expl:"'Es wird hier nicht telefoniert' = unpersönliches Passiv ohne logisches Subjekt.",rule:"Unpersönliches Passiv: es + wird + Partizip II"},
  "b1-passiv-p3-019": {q:`Ergänzen Sie: 'Der Verletzte ___ ins Krankenhaus gebracht ___.' (Perfekt Passiv)`,opts:["wurde ... worden","hat ... werden","ist ... worden","war ... worden"],correct:2,expl:"Perfekt Passiv: ist + Partizip II + worden.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p3-022": {q:`Formulieren Sie im Passiv: 'Man schließt die Bibliothek um 20 Uhr.'`,opts:["Die Bibliothek wird um 20 Uhr geschlossen.","Die Bibliothek ist um 20 Uhr geschlossen.","Die Bibliothek wurde geschlossen.","Man wird geschlossen."],correct:0,expl:"Präsens Passiv: 'Die Bibliothek wird um 20 Uhr geschlossen.'",rule:"Aktiv mit 'man' → Passiv ohne Agens"},
  "b1-passiv-p3-025": {q:`Welcher Satz steht im Vorgangspassiv Präteritum?`,opts:["Das Bild ist gemalt.","Das Bild wird gemalt.","Das Bild wurde gemalt.","Das Bild ist gemalt worden."],correct:2,expl:"'wurde + Partizip II' = Vorgangspassiv Präteritum.",rule:"Vorgangspassiv Präteritum: wurde/wurden + Partizip II"},
  "b1-passiv-p3-034": {q:`Wie kann man das Agens im Passivsatz weglassen?`,opts:["Nur bei bekanntem Täter","Immer wenn es nicht relevant ist","Nur im Präteritum","Nie – das Agens muss immer angegeben werden"],correct:1,expl:"Das Agens kann im Passivsatz weggelassen werden, wenn es nicht relevant oder unbekannt ist.",rule:"Passiv ohne Agens: wenn Täter unbekannt oder unwichtig"},
  "b1-passiv-p3-042": {q:`Formulieren Sie im Passiv: 'Der Busfahrer fährt die Kinder zur Schule.'`,opts:["Die Kinder werden vom Busfahrer zur Schule gefahren.","Der Busfahrer wird gefahren.","Die Kinder sind gefahren.","Die Kinder wurden gefahren."],correct:0,expl:"Präsens Passiv: 'Die Kinder werden vom Busfahrer zur Schule gefahren.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p3-053": {q:`Ergänzen Sie: 'Das Paket ___ noch nicht abgeholt.' (Zustandspassiv, Verneinung)`,opts:["wird","wurde","ist","hat"],correct:2,expl:"Zustandspassiv: ist + (noch nicht) + Partizip II.",rule:"Zustandspassiv: sein + Partizip II"},
  "b1-passiv-p3-059": {q:`Formulieren Sie im Passiv Perfekt: 'Man hat die Tickets reserviert.'`,opts:["Die Tickets werden reserviert.","Die Tickets wurden reserviert.","Die Tickets sind reserviert worden.","Die Tickets waren reserviert worden."],correct:2,expl:"Perfekt Passiv: 'Die Tickets sind reserviert worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p3-063": {q:`Welcher Satz steht im Passiv Perfekt?`,opts:["Das Bild wurde gemalt.","Das Bild ist gemalt.","Das Bild ist gemalt worden.","Das Bild wird gemalt."],correct:2,expl:"'ist + Partizip II + worden' = Perfekt Passiv.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},

  // Part 4 dups
  "b1-passiv-p4-002": {q:`Formulieren Sie im Passiv: 'Die Reinigungskraft wischt den Boden.'`,opts:["Der Boden wird von der Reinigungskraft gewischt.","Die Reinigungskraft wird gewischt.","Der Boden ist gewischt.","Der Boden wurde gewischt."],correct:0,expl:"Präsens Passiv: 'Der Boden wird von der Reinigungskraft gewischt.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p4-003": {q:`Welche Zeitform ist: 'Die Medikamente werden verschrieben werden.'?`,opts:["Präsens Passiv","Perfekt Passiv","Präteritum Passiv","Futur I Passiv"],correct:3,expl:"'werden + Partizip II + werden' = Futur I Passiv.",rule:"Vorgangspassiv Futur I: wird/werden + Partizip II + werden"},
  "b1-passiv-p4-005": {q:`Formulieren Sie im Passiv Perfekt: 'Man hat das Licht ausgeschaltet.'`,opts:["Das Licht wird ausgeschaltet.","Das Licht wurde ausgeschaltet.","Das Licht ist ausgeschaltet worden.","Das Licht war ausgeschaltet worden."],correct:2,expl:"Perfekt Passiv: 'Das Licht ist ausgeschaltet worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p4-008": {q:`Formulieren Sie im Passiv: 'Man putzt die Fenster jeden Monat.'`,opts:["Die Fenster werden jeden Monat geputzt.","Die Fenster sind geputzt.","Die Fenster wurden geputzt.","Man wird geputzt."],correct:0,expl:"Präsens Passiv: 'Die Fenster werden jeden Monat geputzt.'",rule:"Aktiv mit 'man' → Passiv ohne Agens"},
  "b1-passiv-p4-011": {q:`Ergänzen Sie: 'Die Daten ___ gespeichert ___.' (Perfekt Passiv)`,opts:["wurden ... worden","haben ... werden","sind ... worden","werden ... werden"],correct:2,expl:"Perfekt Passiv: sind + Partizip II + worden.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p4-014": {q:`Formulieren Sie im Passiv Präteritum: 'Man informierte die Eltern.'`,opts:["Die Eltern werden informiert.","Die Eltern wurden informiert.","Die Eltern sind informiert worden.","Die Eltern waren informiert worden."],correct:1,expl:"Präteritum Passiv: 'Die Eltern wurden informiert.'",rule:"Vorgangspassiv Präteritum: wurde/wurden + Partizip II"},
  "b1-passiv-p4-017": {q:`Formulieren Sie im Passiv: 'Man isst in Deutschland viel Brot.'`,opts:["In Deutschland wird viel Brot gegessen.","Brot ist gegessen.","In Deutschland wurde Brot gegessen.","Man wird gegessen."],correct:0,expl:"Präsens Passiv: 'In Deutschland wird viel Brot gegessen.'",rule:"Aktiv mit 'man' → Passiv ohne Agens"},
  "b1-passiv-p4-020": {q:`Formulieren Sie im Passiv Perfekt: 'Der Vermieter hat die Wohnung renoviert.'`,opts:["Die Wohnung wird renoviert.","Die Wohnung wurde renoviert.","Die Wohnung ist vom Vermieter renoviert worden.","Die Wohnung war renoviert worden."],correct:2,expl:"Perfekt Passiv: 'Die Wohnung ist vom Vermieter renoviert worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p4-023": {q:`Welcher Satz zeigt Passiv mit Modalverb?`,opts:["Das Formular wird ausgefüllt.","Das Formular muss ausgefüllt werden.","Das Formular ist ausgefüllt.","Das Formular wurde ausgefüllt."],correct:1,expl:"Passiv mit Modalverb: 'Das Formular muss ausgefüllt werden.'",rule:"Passiv mit Modalverb: Modalverb + Partizip II + werden"},
  "b1-passiv-p4-032": {q:`Welcher Satz steht im Zustandspassiv?`,opts:["Das Essen wird gekocht.","Das Essen wurde gekocht.","Das Essen ist gekocht.","Das Essen ist gekocht worden."],correct:2,expl:"'ist + Partizip II' (ohne 'worden') = Zustandspassiv.",rule:"Zustandspassiv: sein + Partizip II (ohne worden)"},
  "b1-passiv-p4-035": {q:`Welcher Satz ist KEIN Passiv?`,opts:["Das Buch wird gelesen.","Er wird immer nervös vor Prüfungen.","Die Straße wird gesperrt.","Der Brief wurde abgeschickt."],correct:1,expl:"'Er wird nervös' = 'werden' als Vollverb (Zustandsänderung), nicht Passiv.",rule:"werden + Adjektiv = Vollverb; werden + Partizip II = Passiv"},
  "b1-passiv-p4-053": {q:`Formulieren Sie im Passiv: 'Die Bibliothekarin ordnet die Bücher.'`,opts:["Die Bücher werden von der Bibliothekarin geordnet.","Die Bibliothekarin wird geordnet.","Die Bücher sind geordnet.","Die Bücher wurden geordnet."],correct:0,expl:"Präsens Passiv: 'Die Bücher werden von der Bibliothekarin geordnet.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p4-059": {q:`Welches Verb kann KEIN Passiv bilden?`,opts:["putzen","streichen","schlafen","liefern"],correct:2,expl:"'Schlafen' ist intransitiv und kann kein persönliches Passiv bilden.",rule:"Nur transitive Verben bilden ein persönliches Passiv"},
  "b1-passiv-p4-063": {q:`Ergänzen Sie: 'Das Haus ___ gerade gebaut.' (Präsens Passiv)`,opts:["ist","hat","wird","wurde"],correct:2,expl:"Präsens Passiv: wird + Partizip II.",rule:"Vorgangspassiv Präsens: wird/werden + Partizip II"},

  // Part 5 dups
  "b1-passiv-p5-002": {q:`Formulieren Sie im Passiv: 'Der Optiker prüft die Augen.'`,opts:["Die Augen werden vom Optiker geprüft.","Der Optiker wird geprüft.","Die Augen sind geprüft.","Die Augen wurden geprüft."],correct:0,expl:"Präsens Passiv: 'Die Augen werden vom Optiker geprüft.'",rule:"Aktiv → Passiv: Akkusativobjekt wird Subjekt"},
  "b1-passiv-p5-006": {q:`Formulieren Sie im Passiv: 'Man öffnet das Geschäft um 9 Uhr.'`,opts:["Das Geschäft wird um 9 Uhr geöffnet.","Das Geschäft ist um 9 Uhr geöffnet.","Das Geschäft wurde um 9 Uhr geöffnet.","Das Geschäft war geöffnet worden."],correct:0,expl:"Präsens Passiv: 'Das Geschäft wird um 9 Uhr geöffnet.'",rule:"Aktiv mit 'man' → Passiv ohne Agens"},
  "b1-passiv-p5-009": {q:`Ergänzen Sie: 'Die Prüfung ___ nächste Woche geschrieben ___.' (Futur I Passiv)`,opts:["ist ... worden","wird ... werden","wurde ... worden","wird ... worden"],correct:1,expl:"Futur I Passiv: wird + Partizip II + werden.",rule:"Vorgangspassiv Futur I: wird/werden + Partizip II + werden"},
  "b1-passiv-p5-012": {q:`Formulieren Sie im Passiv Präteritum: 'Die Schüler lösten die Aufgaben.'`,opts:["Die Aufgaben werden von den Schülern gelöst.","Die Aufgaben wurden von den Schülern gelöst.","Die Aufgaben sind von den Schülern gelöst worden.","Die Aufgaben waren gelöst worden."],correct:1,expl:"Präteritum Passiv: 'Die Aufgaben wurden von den Schülern gelöst.'",rule:"Vorgangspassiv Präteritum: wurde/wurden + Partizip II"},
  "b1-passiv-p5-015": {q:`Ergänzen Sie: 'Der Verletzte ___ operiert ___.' (Perfekt Passiv)`,opts:["wurde ... worden","hat ... werden","ist ... worden","war ... worden"],correct:2,expl:"Perfekt Passiv: ist + Partizip II + worden.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p5-018": {q:`Formulieren Sie im Passiv Perfekt: 'Man hat die Ergebnisse veröffentlicht.'`,opts:["Die Ergebnisse werden veröffentlicht.","Die Ergebnisse wurden veröffentlicht.","Die Ergebnisse sind veröffentlicht worden.","Die Ergebnisse waren veröffentlicht worden."],correct:2,expl:"Perfekt Passiv: 'Die Ergebnisse sind veröffentlicht worden.'",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p5-021": {q:`Formulieren Sie im Passiv: 'Der Zahnarzt zog den Zahn.'`,opts:["Der Zahn wird vom Zahnarzt gezogen.","Der Zahn wurde vom Zahnarzt gezogen.","Der Zahn ist gezogen worden.","Der Zahn war gezogen worden."],correct:1,expl:"Präteritum Passiv: 'Der Zahn wurde vom Zahnarzt gezogen.'",rule:"Vorgangspassiv Präteritum: wurde/wurden + Partizip II"},
  "b1-passiv-p5-032": {q:`Welcher Satz steht im Zustandspassiv?`,opts:["Der Computer wird repariert.","Der Computer wurde repariert.","Der Computer ist repariert.","Der Computer ist repariert worden."],correct:2,expl:"'ist + Partizip II' (ohne 'worden') = Zustandspassiv.",rule:"Zustandspassiv: sein + Partizip II"},
  "b1-passiv-p5-035": {q:`Welcher Satz ist KEIN Passiv?`,opts:["Die Pizza wird gebacken.","Das Baby ist eingeschlafen.","Das Paket wird geliefert.","Die Straße wird gesperrt."],correct:1,expl:"'Das Baby ist eingeschlafen' ist Perfekt Aktiv mit 'sein', kein Passiv.",rule:"Perfekt mit sein (intransitiv) ist kein Passiv"},
  "b1-passiv-p5-053": {q:`Welcher Satz steht im Vorgangspassiv?`,opts:["Die Tür ist geschlossen.","Die Tür wird geschlossen.","Die Tür war geschlossen.","Die Tür bleibt geschlossen."],correct:1,expl:"'wird + Partizip II' = Vorgangspassiv.",rule:"werden + P.II = Vorgangspassiv"},
  "b1-passiv-p5-059": {q:`Welches Verb kann KEIN Passiv bilden?`,opts:["malen","reparieren","schwimmen","verkaufen"],correct:2,expl:"'Schwimmen' ist intransitiv und kann kein persönliches Passiv bilden.",rule:"Nur transitive Verben bilden ein persönliches Passiv"},
  "b1-passiv-p5-063": {q:`Welcher Satz steht im Passiv Perfekt?`,opts:["Das Licht wurde ausgeschaltet.","Das Licht ist ausgeschaltet.","Das Licht ist ausgeschaltet worden.","Das Licht wird ausgeschaltet."],correct:2,expl:"'ist + Partizip II + worden' = Perfekt Passiv.",rule:"Vorgangspassiv Perfekt: ist/sind + Partizip II + worden"},
  "b1-passiv-p5-072": {q:`Welcher Satz ist KEIN Passiv?`,opts:["Das Essen wird serviert.","Die Fenster werden geputzt.","Sie wird Ärztin.","Die Post wurde geliefert."],correct:2,expl:"'Sie wird Ärztin' = 'werden' als Vollverb (Zustandsänderung), nicht Passiv.",rule:"werden + Nomen/Adjektiv = Vollverb; werden + Partizip II = Passiv"},

  // ============ PRONOMEN ============
  // Part 1 internal dups
  "b1-pronomen-p1-051": {q:`Welches Pronomen steht im Akkusativ für 'wir'?`,opts:["uns","euch","mir","sich"],correct:0,expl:"Das Akkusativpronomen von 'wir' ist 'uns'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  "b1-pronomen-p1-056": {q:`Welches Pronomen steht im Akkusativ für 'sie (Pl.)'?`,opts:["euch","ihr","sie","ihnen"],correct:2,expl:"Das Akkusativpronomen von 'sie (Pl.)' ist 'sie'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},

  // Part 2 dups
  "b1-pronomen-p2-002": {q:`Welches Personalpronomen ersetzt 'dem Lehrer' (Dativ)?`,opts:["ihn","ihm","er","sein"],correct:1,expl:"'dem Lehrer' = maskulin Dativ → ihm.",rule:"Personalpronomen Dativ: mir, dir, ihm/ihr/ihm, uns, euch, ihnen"},
  "b1-pronomen-p2-003": {q:`Ergänzen Sie das Reflexivpronomen: 'wir freuen ___ auf den Urlaub.'`,opts:["sich","euch","uns","mich"],correct:2,expl:"Das Reflexivpronomen für 'wir' ist 'uns'.",rule:"Reflexivpronomen: mich, dich, sich, uns, euch, sich"},
  "b1-pronomen-p2-004": {q:`Ergänzen Sie das Relativpronomen: 'das Mädchen, ___ dort spielt, ...' (neutrum Nominativ)`,opts:["der","die","das","dessen"],correct:2,expl:"Relativpronomen für neutrum Nominativ: das.",rule:"Relativpronomen = bestimmter Artikel (außer Genitiv, Dativ Pl.)"},
  "b1-pronomen-p2-005": {q:`Welches Pronomen steht im Akkusativ für 'er'?`,opts:["ihm","ihn","er","sein"],correct:1,expl:"Das Akkusativpronomen von 'er' ist 'ihn'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  "b1-pronomen-p2-006": {q:`Welches Pronomen steht im Dativ für 'wir'?`,opts:["uns","euch","mir","ihr"],correct:0,expl:"Das Dativpronomen von 'wir' ist 'uns'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p2-007": {q:`Ergänzen Sie das Reflexivpronomen: 'du freust ___ auf das Wochenende.'`,opts:["sich","mich","uns","dich"],correct:3,expl:"Das Reflexivpronomen für 'du' ist 'dich'.",rule:"Reflexivpronomen: mich, dich, sich, uns, euch, sich"},
  "b1-pronomen-p2-008": {q:`Ergänzen Sie das Relativpronomen: 'die Frau, ___ dort arbeitet, ...' (feminin Nominativ)`,opts:["der","die","das","deren"],correct:1,expl:"Relativpronomen für feminin Nominativ: die.",rule:"Relativpronomen feminin Nominativ = die"},
  "b1-pronomen-p2-010": {q:`Welches Pronomen steht im Dativ für 'du'?`,opts:["dich","dir","ihr","sich"],correct:1,expl:"Das Dativpronomen von 'du' ist 'dir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p2-011": {q:`Ergänzen Sie das Reflexivpronomen: 'wir freuen ___ auf das Fest.'`,opts:["sich","euch","uns","mich"],correct:2,expl:"Das Reflexivpronomen für 'wir' ist 'uns'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich"},
  "b1-pronomen-p2-012": {q:`Ergänzen Sie das Relativpronomen: 'der Schüler, ___ gut lernt, ...' (maskulin Nominativ)`,opts:["der","dem","die","dessen"],correct:0,expl:"Relativpronomen für maskulin Nominativ: der.",rule:"Relativpronomen maskulin Nominativ = der"},
  "b1-pronomen-p2-016": {q:`Ergänzen Sie das Relativpronomen: 'die Bücher, ___ auf dem Tisch liegen, ...' (Plural Nominativ)`,opts:["der","die","das","denen"],correct:1,expl:"Relativpronomen für Plural Nominativ: die.",rule:"Relativpronomen Plural Nominativ = die"},
  "b1-pronomen-p2-018": {q:`Welches Pronomen steht im Dativ für 'es'?`,opts:["ihn","ihm","ihr","es"],correct:1,expl:"Das Dativpronomen von 'es' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p2-020": {q:`Ergänzen Sie das Relativpronomen: 'das Kind, ___ ich helfe, ...' (neutrum Dativ)`,opts:["das","dem","den","dessen"],correct:1,expl:"Relativpronomen für neutrum Dativ: dem.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p2-022": {q:`Welches Pronomen steht im Dativ für 'sie (Sg.)'?`,opts:["sie","ihr","ihm","ihr"],correct:1,expl:"Das Dativpronomen von 'sie' (Sg.) ist 'ihr'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p2-024": {q:`Ergänzen Sie das Relativpronomen: 'der Mann, ___ Buch ich gelesen habe, ...' (maskulin Genitiv)`,opts:["dem","der","dessen","deren"],correct:2,expl:"Relativpronomen für maskulin Genitiv: dessen.",rule:"Relativpronomen Genitiv maskulin/neutrum = dessen"},
  "b1-pronomen-p2-028": {q:`Ergänzen Sie das Relativpronomen: 'die Frau, ___ ich gestern geholfen habe, ...' (feminin Dativ)`,opts:["die","der","dem","deren"],correct:1,expl:"Relativpronomen für feminin Dativ: der.",rule:"Relativpronomen feminin Dativ = der"},
  "b1-pronomen-p2-051": {q:`Welches Pronomen steht im Dativ für 'er'?`,opts:["ihn","er","ihm","sein"],correct:2,expl:"Das Dativpronomen von 'er' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p2-063": {q:`Welches Demonstrativpronomen passt? '___ Haus ist sehr alt.' (neutrum, Nominativ)`,opts:["Dieser","Diese","Dieses","Diesem"],correct:2,expl:"Demonstrativpronomen für neutrum Nominativ: dieses.",rule:"Demonstrativpronomen: dieser/diese/dieses deklinieren wie bestimmter Artikel"},

  // Part 3 dups
  "b1-pronomen-p3-002": {q:`Welches Pronomen steht im Dativ für 'er'?`,opts:["euch","ihnen","ihm","dir"],correct:2,expl:"Das Dativpronomen von 'er' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p3-003": {q:`Ergänzen Sie das Reflexivpronomen: 'ich freue ___ auf das Wochenende.'`,opts:["sich","mich","uns","dich"],correct:1,expl:"Das Reflexivpronomen für 'ich' ist 'mich'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich"},
  "b1-pronomen-p3-004": {q:`Ergänzen Sie das Relativpronomen: 'die Frau, ___ dort steht, ...' (feminin Dativ)`,opts:["deren","der","den","dem"],correct:1,expl:"Relativpronomen für feminin Dativ: der.",rule:"Relativpronomen feminin Dativ = der"},
  "b1-pronomen-p3-006": {q:`Welches Pronomen steht im Dativ für 'sie (Pl.)'?`,opts:["mir","ihr","uns","ihnen"],correct:3,expl:"Das Dativpronomen von 'sie (Pl.)' ist 'ihnen'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p3-007": {q:`Ergänzen Sie das Reflexivpronomen: 'ihr freut ___ auf das Wochenende.'`,opts:["sich","dich","mich","euch"],correct:3,expl:"Das Reflexivpronomen für 'ihr' ist 'euch'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich"},
  "b1-pronomen-p3-008": {q:`Ergänzen Sie das Relativpronomen: 'die Frau, ___ dort steht, ...' (feminin Nominativ)`,opts:["der","dessen","das","die"],correct:3,expl:"Relativpronomen für feminin Nominativ: die.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p3-010": {q:`Welches Pronomen steht im Dativ für 'sie'?`,opts:["mir","euch","dir","ihr"],correct:3,expl:"Das Dativpronomen von 'sie' ist 'ihr'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p3-011": {q:`Ergänzen Sie das Reflexivpronomen: 'er/sie/es freut ___ auf das Wochenende.'`,opts:["dich","euch","mich","sich"],correct:3,expl:"Das Reflexivpronomen für 'er/sie/es' ist 'sich'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich"},
  "b1-pronomen-p3-012": {q:`Ergänzen Sie das Relativpronomen: 'der Mann, ___ dort steht, ...' (maskulin Dativ)`,opts:["das","dem","dessen","die"],correct:1,expl:"Relativpronomen für maskulin Dativ: dem.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p3-014": {q:`Welches Pronomen steht im Dativ für 'ich'?`,opts:["dir","mir","ihm","ihr"],correct:1,expl:"Das Dativpronomen von 'ich' ist 'mir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p3-016": {q:`Ergänzen Sie das Relativpronomen: 'das Kind, ___ dort steht, ...' (neutrum Nominativ)`,opts:["dem","das","den","der"],correct:1,expl:"Relativpronomen für neutrum Nominativ: das.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p3-026": {q:`Welches Pronomen steht im Dativ für 'ihr'?`,opts:["dir","euch","mir","ihr"],correct:1,expl:"Das Dativpronomen von 'ihr' ist 'euch'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p3-028": {q:`Ergänzen Sie das Relativpronomen: 'der Mann, ___ dort steht, ...' (maskulin Nominativ)`,opts:["der","dem","die","deren"],correct:0,expl:"Relativpronomen für maskulin Nominativ: der.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p3-048": {q:`Ergänzen Sie das Reflexivpronomen: 'ich wasche ___ die Hände.'`,opts:["mich","mir","sich","dir"],correct:1,expl:"Das Reflexivpronomen für 'ich' im Dativ ist 'mir'. Bei Körperteilen steht der Dativ.",rule:"Reflexivpronomen im Dativ: mir, dir, sich, uns, euch, sich"},
  "b1-pronomen-p3-051": {q:`Welches Pronomen steht im Dativ für 'ihr'?`,opts:["ihnen","uns","euch","mir"],correct:2,expl:"Das Dativpronomen von 'ihr' ist 'euch'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p3-057": {q:`Ergänzen Sie das Reflexivpronomen: 'du erinnerst ___ an den Urlaub.'`,opts:["mir","sich","mich","dich"],correct:3,expl:"Das Reflexivpronomen für 'du' ist 'dich'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen"},

  // Part 4 dups
  "b1-pronomen-p4-001": {q:`Welches Pronomen steht im Akkusativ für 'ich'?`,opts:["ihn","sie","es","mich"],correct:3,expl:"Das Akkusativpronomen von 'ich' ist 'mich'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  "b1-pronomen-p4-003": {q:`Ergänzen Sie das Reflexivpronomen: 'er/sie/es freut ___ auf das Wochenende.'`,opts:["mich","sich","uns","dich"],correct:1,expl:"Das Reflexivpronomen für 'er/sie/es' ist 'sich'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich"},
  "b1-pronomen-p4-006": {q:`Welches Pronomen steht im Dativ für 'sie'?`,opts:["dir","mir","ihm","ihr"],correct:3,expl:"Das Dativpronomen von 'sie' ist 'ihr'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p4-010": {q:`Welches Pronomen steht im Dativ für 'ich'?`,opts:["euch","ihm","dir","mir"],correct:3,expl:"Das Dativpronomen von 'ich' ist 'mir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p4-011": {q:`Ergänzen Sie das Reflexivpronomen: 'ihr freut ___ auf das Wochenende.'`,opts:["mich","euch","uns","sich"],correct:1,expl:"Das Reflexivpronomen für 'ihr' ist 'euch'.",rule:"Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich"},
  "b1-pronomen-p4-012": {q:`Ergänzen Sie das Relativpronomen: 'das Kind, ___ dort steht, ...' (neutrum Nominativ)`,opts:["dessen","die","deren","das"],correct:3,expl:"Relativpronomen für neutrum Nominativ: das.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p4-014": {q:`Welches Pronomen steht im Dativ für 'wir'?`,opts:["mir","uns","ihnen","ihr"],correct:1,expl:"Das Dativpronomen von 'wir' ist 'uns'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p4-016": {q:`Ergänzen Sie das Relativpronomen: 'das Buch, ___ dort steht, ...' (neutrum Genitiv)`,opts:["den","dem","dessen","der"],correct:2,expl:"Relativpronomen für neutrum Genitiv: dessen.",rule:"Relativpronomen = bestimmter Artikel (Genitiv: dessen/deren)"},
  "b1-pronomen-p4-018": {q:`Welches Pronomen steht im Dativ für 'du'?`,opts:["uns","dir","ihm","ihr"],correct:1,expl:"Das Dativpronomen von 'du' ist 'dir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p4-020": {q:`Ergänzen Sie das Relativpronomen: 'der Mann, ___ dort steht, ...' (maskulin Akkusativ)`,opts:["dem","der","die","den"],correct:3,expl:"Relativpronomen für maskulin Akkusativ: den.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p4-022": {q:`Welches Pronomen steht im Dativ für 'ihr'?`,opts:["uns","euch","ihr","dir"],correct:1,expl:"Das Dativpronomen von 'ihr' ist 'euch'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p4-048": {q:`Ergänzen Sie das Reflexivpronomen: 'ich stelle ___ das vor.'`,opts:["mich","mir","sich","dir"],correct:1,expl:"Bei 'sich etwas vorstellen' steht das Reflexivpronomen im Dativ: 'ich stelle mir das vor'.",rule:"Reflexivpronomen im Dativ: mir, dir, sich, uns, euch, sich"},
  "b1-pronomen-p4-049": {q:`Ergänzen Sie das Relativpronomen: 'die Leute, ___ dort wohnen, ...' (Plural Nominativ)`,opts:["denen","die","der","das"],correct:1,expl:"Relativpronomen für Plural Nominativ: die.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p4-051": {q:`Welches Pronomen steht im Dativ für 'ich'?`,opts:["mich","mir","dir","ihm"],correct:1,expl:"Das Dativpronomen von 'ich' ist 'mir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p4-063": {q:`Welches Pronomen steht im Akkusativ für 'ich'?`,opts:["mir","mich","dir","sich"],correct:1,expl:"Das Akkusativpronomen von 'ich' ist 'mich'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  "b1-pronomen-p4-067": {q:`Welches Demonstrativpronomen passt? 'Wegen ___ Wetters bleiben wir zu Hause.' (neutrum, Genitiv)`,opts:["dieses","diesem","dieser","diese"],correct:0,expl:"Das Demonstrativpronomen für neutrum Genitiv ist 'dieses'.",rule:"Demonstrativpronomen: dieser/diese/dieses deklinieren wie bestimmter Artikel"},
  "b1-pronomen-p4-068": {q:`Welches Pronomen steht im Dativ für 'sie (Pl.)'?`,opts:["ihr","ihm","ihnen","euch"],correct:2,expl:"Das Dativpronomen von 'sie' (Pl.) ist 'ihnen'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},

  // Part 5 dups
  "b1-pronomen-p5-001": {q:`Welches Pronomen steht im Akkusativ für 'ich'?`,opts:["sie","uns","mich","ihn"],correct:2,expl:"Das Akkusativpronomen von 'ich' ist 'mich'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  "b1-pronomen-p5-002": {q:`Welches Pronomen steht im Dativ für 'sie'?`,opts:["uns","dir","ihr","mir"],correct:2,expl:"Das Dativpronomen von 'sie' ist 'ihr'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p5-004": {q:`Ergänzen Sie das Relativpronomen: 'der Mann, ___ dort steht, ...' (maskulin Dativ)`,opts:["dessen","der","deren","dem"],correct:3,expl:"Relativpronomen für maskulin Dativ: dem.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p5-014": {q:`Welches Pronomen steht im Dativ für 'du'?`,opts:["ihnen","ihr","mir","dir"],correct:3,expl:"Das Dativpronomen von 'du' ist 'dir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p5-016": {q:`Ergänzen Sie das Relativpronomen: 'der Mann, ___ dort steht, ...' (maskulin Akkusativ)`,opts:["dessen","dem","die","den"],correct:3,expl:"Relativpronomen für maskulin Akkusativ: den.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p5-018": {q:`Welches Pronomen steht im Dativ für 'ihr'?`,opts:["ihm","ihr","uns","euch"],correct:3,expl:"Das Dativpronomen von 'ihr' ist 'euch'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p5-022": {q:`Welches Pronomen steht im Dativ für 'er'?`,opts:["ihm","uns","euch","ihr"],correct:0,expl:"Das Dativpronomen von 'er' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p5-026": {q:`Welches Pronomen steht im Dativ für 'sie (Pl.)'?`,opts:["euch","ihnen","ihm","uns"],correct:1,expl:"Das Dativpronomen von 'sie (Pl.)' ist 'ihnen'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p5-028": {q:`Ergänzen Sie das Relativpronomen: 'die Frau, ___ dort steht, ...' (feminin Nominativ)`,opts:["deren","dem","dessen","die"],correct:3,expl:"Relativpronomen für feminin Nominativ: die.",rule:"Relativpronomen = bestimmter Artikel"},
  "b1-pronomen-p5-051": {q:`Welches Pronomen steht im Dativ für 'er'?`,opts:["ihn","ihm","ihr","mir"],correct:1,expl:"Das Dativpronomen von 'er' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  "b1-pronomen-p5-073": {q:`Welches Pronomen steht im Akkusativ für 'es'?`,opts:["ihm","ihn","sie","es"],correct:3,expl:"Das Akkusativpronomen von 'es' ist 'es'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},

};

// Now apply the replacements to the files
function escapeRegex(str) {
  return str.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
}

function applyReplacements(cat, replacements) {
  const base = 'src/data/german/b1';
  const dir = path.join(base, cat);
  if (!fs.existsSync(dir)) return 0;
  const files = fs.readdirSync(dir).filter(f => f.match(/^part\d+\.ts$/)).sort();
  let totalFixed = 0;

  for (const file of files) {
    const filePath = path.join(dir, file);
    let content = fs.readFileSync(filePath, 'utf8');
    let modified = false;

    for (const [id, rep] of Object.entries(replacements)) {
      if (!content.includes('"' + id + '"')) continue;

      // Find the question block for this ID and replace the question text, options, correctAnswer, explanation
      // Strategy: find "id": "xxx" and then replace key fields
      const optStr = JSON.stringify(rep.opts);
      const newQ = rep.q.replace(/\\/g, '\\\\').replace(/"/g, '\\"');
      const newExpl = (rep.expl || '').replace(/\\/g, '\\\\').replace(/"/g, '\\"');

      // Replace "question": "..." after the id
      // We'll use a pattern that matches from id to end of question field
      content = content.replace(
        new RegExp('("id":\\s*"' + escapeRegex(id) + '"[\\s\\S]*?"question":\\s*")([^"]+)(")', 'm'),
        '$1' + rep.q.replace(/\\/g, '\\\\').replace(/"/g, '\\"') + '$3'
      );

      // Replace options array
      content = content.replace(
        new RegExp('("id":\\s*"' + escapeRegex(id) + '"[\\s\\S]*?"options":\\s*)\\[[^\\]]*\\]', 'm'),
        '$1' + optStr
      );

      // Replace correctAnswer
      content = content.replace(
        new RegExp('("id":\\s*"' + escapeRegex(id) + '"[\\s\\S]*?"correctAnswer":\\s*)\\d+', 'm'),
        '$1' + rep.correct
      );

      // Replace explanation
      if (rep.expl) {
        content = content.replace(
          new RegExp('("id":\\s*"' + escapeRegex(id) + '"[\\s\\S]*?"explanation":\\s*")([^"]+)(")', 'm'),
          '$1' + rep.expl.replace(/\\/g, '\\\\').replace(/"/g, '\\"') + '$3'
        );
      }

      // Replace grammarRule if provided
      if (rep.rule) {
        content = content.replace(
          new RegExp('("id":\\s*"' + escapeRegex(id) + '"[\\s\\S]*?"grammarRule":\\s*")([^"]*)(")','m'),
          '$1' + rep.rule.replace(/\\/g, '\\\\').replace(/"/g, '\\"') + '$3'
        );
      }

      modified = true;
      totalFixed++;
    }

    if (modified) {
      fs.writeFileSync(filePath, content, 'utf8');
      console.log('  Updated: ' + file);
    }
  }
  return totalFixed;
}

const cats = {
  'konjunktiv': Object.fromEntries(Object.entries(REPLACEMENTS).filter(([k]) => k.includes('-konjunktiv-'))),
  'passiv': Object.fromEntries(Object.entries(REPLACEMENTS).filter(([k]) => k.includes('-passiv-'))),
  'pronomen': Object.fromEntries(Object.entries(REPLACEMENTS).filter(([k]) => k.includes('-pronomen-'))),
};

for (const [cat, reps] of Object.entries(cats)) {
  console.log('Processing ' + cat + ' (' + Object.keys(reps).length + ' replacements)...');
  const n = applyReplacements(cat, reps);
  console.log('  Fixed: ' + n);
}
