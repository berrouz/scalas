const fs = require('fs');
const path = require('path');

const base = 'src/data/german/b1';
const dir = path.join(base, 'konjugation');

// Big pool of konjugation questions with different verbs/forms
// Format: {q, opts, correct, expl, rule}
// 4 question types: Präsens, Präteritum, Perfekt, Partizip II
// Using verbs NOT already in existing questions

const pool = [
  // 1. Person Singular Präsens (varied person/number)
  {q:"Wie lautet die 1. Person Singular Präsens von 'backen'?",opts:["bake","backe","backt","gebacken"],correct:1,expl:"'backen': ich backe.",rule:"Präsens 1. Sg.: ich backe"},
  {q:"Wie lautet die 2. Person Singular Präsens von 'backen'?",opts:["backst","bäckst","backest","backe"],correct:1,expl:"'backen': du bäckst (Vokalwechsel a→ä).",rule:"Präsens 2. Sg. mit Umlaut: bäckst"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'backen'?",opts:["backst","backt","bäckt","gebacken"],correct:2,expl:"'backen': er/sie bäckt.",rule:"Präsens 3. Sg. mit Umlaut: bäckt"},
  {q:"Wie lautet die 1. Person Singular Präsens von 'laufen'?",opts:["läufe","läuft","laufe","lief"],correct:2,expl:"'laufen': ich laufe.",rule:"Präsens 1. Sg.: ich laufe"},
  {q:"Wie lautet die 2. Person Singular Präsens von 'laufen'?",opts:["laufst","läufst","laufest","lief"],correct:1,expl:"'laufen': du läufst (Vokalwechsel au→äu).",rule:"Präsens 2. Sg. mit Umlaut: läufst"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'laufen'?",opts:["lauft","laufst","läuft","gelaufen"],correct:2,expl:"'laufen': er/sie läuft.",rule:"Präsens 3. Sg. mit Umlaut: läuft"},
  {q:"Wie lautet die 1. Person Singular Präsens von 'singen'?",opts:["singe","singt","gesungen","sang"],correct:0,expl:"'singen': ich singe.",rule:"Präsens 1. Sg.: ich singe"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'singen'?",opts:["singt","singet","gesungen","singe"],correct:0,expl:"'singen': er/sie singt.",rule:"Präsens 3. Sg.: er singt"},
  {q:"Wie lautet die 2. Person Singular Präsens von 'singen'?",opts:["singst","singest","singt","sang"],correct:0,expl:"'singen': du singst.",rule:"Präsens 2. Sg.: du singst"},
  {q:"Wie lautet die 1. Person Singular Präsens von 'rennen'?",opts:["renne","rennt","gerannt","rannte"],correct:0,expl:"'rennen': ich renne.",rule:"Präsens 1. Sg.: ich renne"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'rennen'?",opts:["renne","rennst","rennt","gerannt"],correct:2,expl:"'rennen': er/sie rennt.",rule:"Präsens 3. Sg.: er rennt"},
  {q:"Wie lautet die 1. Person Singular Präsens von 'denken'?",opts:["denke","denkt","gedacht","dachte"],correct:0,expl:"'denken': ich denke.",rule:"Präsens 1. Sg.: ich denke"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'denken'?",opts:["denkt","dachte","gedacht","denke"],correct:0,expl:"'denken': er/sie denkt.",rule:"Präsens 3. Sg.: er denkt"},
  {q:"Wie lautet die 1. Person Singular Präsens von 'bringen'?",opts:["bringe","bringt","gebracht","brachte"],correct:0,expl:"'bringen': ich bringe.",rule:"Präsens 1. Sg.: ich bringe"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'bringen'?",opts:["bringe","bringt","gebracht","brachte"],correct:1,expl:"'bringen': er/sie bringt.",rule:"Präsens 3. Sg.: er bringt"},
  {q:"Wie lautet die 1. Person Singular Präsens von 'wissen'?",opts:["wisse","weiß","wisst","wusste"],correct:1,expl:"'wissen': ich weiß (unregelmäßig).",rule:"Präsens 1. Sg.: ich weiß"},
  {q:"Wie lautet die 3. Person Singular Präsens von 'wissen'?",opts:["wissst","wisst","weiß","gewusst"],correct:2,expl:"'wissen': er/sie weiß.",rule:"Präsens 3. Sg.: er weiß"},
  {q:"Wie lautet die 2. Person Singular Präsens von 'wissen'?",opts:["weißt","wisst","wusstest","gewusst"],correct:0,expl:"'wissen': du weißt.",rule:"Präsens 2. Sg.: du weißt"},
  {q:"Wie lautet die 1. Person Plural Präsens von 'fahren'?",opts:["fahre","fährt","fahren","fuhr"],correct:2,expl:"'fahren': wir fahren.",rule:"Präsens 1. Pl.: wir fahren"},
  {q:"Wie lautet die 2. Person Plural Präsens von 'fahren'?",opts:["fahrt","fährt","fuhr","gefahren"],correct:0,expl:"'fahren': ihr fahrt.",rule:"Präsens 2. Pl.: ihr fahrt"},
  {q:"Wie lautet die 1. Person Plural Präsens von 'gehen'?",opts:["gehe","geht","gehen","ging"],correct:2,expl:"'gehen': wir gehen.",rule:"Präsens 1. Pl.: wir gehen"},
  {q:"Wie lautet die 2. Person Plural Präsens von 'gehen'?",opts:["geht","gehen","ging","gegangen"],correct:0,expl:"'gehen': ihr geht.",rule:"Präsens 2. Pl.: ihr geht"},
  {q:"Wie lautet die 1. Person Plural Präsens von 'kommen'?",opts:["kommt","kommen","kam","gekommen"],correct:1,expl:"'kommen': wir kommen.",rule:"Präsens 1. Pl.: wir kommen"},
  {q:"Wie lautet die 2. Person Plural Präsens von 'kommen'?",opts:["kommt","kommen","kam","gekommen"],correct:0,expl:"'kommen': ihr kommt.",rule:"Präsens 2. Pl.: ihr kommt"},
  // Präteritum (1. Person)
  {q:"Wie lautet die 1. Person Singular Präteritum von 'gehen'?",opts:["ging","gegangen","geht","gehe"],correct:0,expl:"'gehen' Präteritum: ich ging.",rule:"Präteritum 1. Sg.: ich ging"},
  {q:"Wie lautet die 3. Person Singular Präteritum von 'gehen'?",opts:["ging","gegangen","gehe","geht"],correct:0,expl:"'gehen' Präteritum: er/sie ging.",rule:"Präteritum 3. Sg.: er ging"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'schreiben'?",opts:["schrieb","schriebte","geschrieben","schreibe"],correct:0,expl:"'schreiben' Präteritum: ich schrieb.",rule:"Präteritum 1. Sg.: ich schrieb"},
  {q:"Wie lautet die 3. Person Singular Präteritum von 'schreiben'?",opts:["schrieb","schriebte","geschrieben","schreibt"],correct:0,expl:"'schreiben' Präteritum: er/sie schrieb.",rule:"Präteritum 3. Sg.: er schrieb"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'sehen'?",opts:["sah","gesehen","sehe","sieht"],correct:0,expl:"'sehen' Präteritum: ich sah.",rule:"Präteritum 1. Sg.: ich sah"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'nehmen'?",opts:["nahm","genommen","nähme","nimmt"],correct:0,expl:"'nehmen' Präteritum: ich nahm.",rule:"Präteritum 1. Sg.: ich nahm"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'lesen'?",opts:["las","gelesen","liest","läse"],correct:0,expl:"'lesen' Präteritum: ich las.",rule:"Präteritum 1. Sg.: ich las"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'tragen'?",opts:["trug","getragen","trägt","trüge"],correct:0,expl:"'tragen' Präteritum: ich trug.",rule:"Präteritum 1. Sg.: ich trug"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'lassen'?",opts:["ließ","gelassen","lässt","lässe"],correct:0,expl:"'lassen' Präteritum: ich ließ.",rule:"Präteritum 1. Sg.: ich ließ"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'essen'?",opts:["aß","gegessen","isst","äße"],correct:0,expl:"'essen' Präteritum: ich aß.",rule:"Präteritum 1. Sg.: ich aß"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'liegen'?",opts:["lag","gelegen","liegt","läge"],correct:0,expl:"'liegen' Präteritum: ich lag.",rule:"Präteritum 1. Sg.: ich lag"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'stehen'?",opts:["stand","gestanden","steht","stünde"],correct:0,expl:"'stehen' Präteritum: ich stand.",rule:"Präteritum 1. Sg.: ich stand"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'helfen'?",opts:["half","geholfen","hilft","hälfe"],correct:0,expl:"'helfen' Präteritum: ich half.",rule:"Präteritum 1. Sg.: ich half"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'treffen'?",opts:["traf","getroffen","trifft","träfe"],correct:0,expl:"'treffen' Präteritum: ich traf.",rule:"Präteritum 1. Sg.: ich traf"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'beginnen'?",opts:["begann","begonnen","beginnt","begänne"],correct:0,expl:"'beginnen' Präteritum: ich begann.",rule:"Präteritum 1. Sg.: ich begann"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'gewinnen'?",opts:["gewann","gewonnen","gewinnt","gewänne"],correct:0,expl:"'gewinnen' Präteritum: ich gewann.",rule:"Präteritum 1. Sg.: ich gewann"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'rufen'?",opts:["rief","gerufen","ruft","riefe"],correct:0,expl:"'rufen' Präteritum: ich rief.",rule:"Präteritum 1. Sg.: ich rief"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'schneiden'?",opts:["schnitt","geschnitten","schneidet","schnitte"],correct:0,expl:"'schneiden' Präteritum: ich schnitt.",rule:"Präteritum 1. Sg.: ich schnitt"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'bitten'?",opts:["bat","gebeten","bittet","bäte"],correct:0,expl:"'bitten' Präteritum: ich bat.",rule:"Präteritum 1. Sg.: ich bat"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'greifen'?",opts:["griff","gegriffen","greift","griffe"],correct:0,expl:"'greifen' Präteritum: ich griff.",rule:"Präteritum 1. Sg.: ich griff"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'rennen'?",opts:["rannte","gerannt","rennt","renne"],correct:0,expl:"'rennen' Präteritum: ich rannte (Mischverb).",rule:"Präteritum Mischverb: ich rannte"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'denken'?",opts:["dachte","gedacht","denkt","denke"],correct:0,expl:"'denken' Präteritum: ich dachte (Mischverb).",rule:"Präteritum Mischverb: ich dachte"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'bringen'?",opts:["brachte","gebracht","bringt","bringe"],correct:0,expl:"'bringen' Präteritum: ich brachte (Mischverb).",rule:"Präteritum Mischverb: ich brachte"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'wissen'?",opts:["wusste","gewusst","weiß","wisse"],correct:0,expl:"'wissen' Präteritum: ich wusste.",rule:"Präteritum 1. Sg.: ich wusste"},
  {q:"Wie lautet die 1. Person Singular Präteritum von 'singen'?",opts:["sang","gesungen","singt","singe"],correct:0,expl:"'singen' Präteritum: ich sang.",rule:"Präteritum 1. Sg.: ich sang"},
  // Perfekt with different subjects
  {q:"Wie lautet das Perfekt von 'gehen'? 'Ich ___ ___.'",opts:["bin gegangen","habe gegangen","bin gegangt","habe gegangt"],correct:0,expl:"'gehen' bildet Perfekt mit 'sein': ich bin gegangen.",rule:"Perfekt mit sein: bin gegangen"},
  {q:"Wie lautet das Perfekt von 'kommen'? 'Ich ___ ___.'",opts:["bin gekommen","habe gekommen","bin gekommt","habe gekommt"],correct:0,expl:"'kommen' bildet Perfekt mit 'sein': ich bin gekommen.",rule:"Perfekt mit sein: bin gekommen"},
  {q:"Wie lautet das Perfekt von 'fahren'? 'Ich ___ ___.'",opts:["bin gefahren","habe gefahren","bin gefährt","habe gefährt"],correct:0,expl:"'fahren' bildet Perfekt mit 'sein': ich bin gefahren.",rule:"Perfekt mit sein: bin gefahren"},
  {q:"Wie lautet das Perfekt von 'schreiben'? 'Ich ___ ___.'",opts:["habe geschrieben","bin geschrieben","habe schrieben","bin schrieben"],correct:0,expl:"'schreiben' bildet Perfekt mit 'haben': ich habe geschrieben.",rule:"Perfekt mit haben: habe geschrieben"},
  {q:"Wie lautet das Perfekt von 'essen'? 'Ich ___ ___.'",opts:["habe gegessen","bin gegessen","habe geessen","bin geessen"],correct:0,expl:"'essen' bildet Perfekt mit 'haben': ich habe gegessen.",rule:"Perfekt mit haben: habe gegessen"},
  {q:"Wie lautet das Perfekt von 'lesen'? 'Ich ___ ___.'",opts:["habe gelesen","bin gelesen","habe gelesst","bin geliest"],correct:0,expl:"'lesen' bildet Perfekt mit 'haben': ich habe gelesen.",rule:"Perfekt mit haben: habe gelesen"},
  {q:"Wie lautet das Perfekt von 'treffen'? 'Ich ___ ___.'",opts:["habe getroffen","bin getroffen","habe getriffst","bin getriffst"],correct:0,expl:"'treffen' bildet Perfekt mit 'haben': ich habe getroffen.",rule:"Perfekt mit haben: habe getroffen"},
  {q:"Wie lautet das Perfekt von 'beginnen'? 'Ich ___ ___.'",opts:["habe begonnen","bin begonnen","habe beginnt","bin beginnt"],correct:0,expl:"'beginnen' bildet Perfekt mit 'haben': ich habe begonnen.",rule:"Perfekt mit haben: habe begonnen"},
  {q:"Wie lautet das Perfekt von 'wissen'? 'Ich ___ ___.'",opts:["habe gewusst","bin gewusst","habe wusste","bin wusste"],correct:0,expl:"'wissen' bildet Perfekt mit 'haben': ich habe gewusst.",rule:"Perfekt mit haben: habe gewusst"},
  {q:"Wie lautet das Perfekt von 'singen'? 'Ich ___ ___.'",opts:["habe gesungen","bin gesungen","habe singte","bin singte"],correct:0,expl:"'singen' bildet Perfekt mit 'haben': ich habe gesungen.",rule:"Perfekt mit haben: habe gesungen"},
  {q:"Wie lautet das Perfekt von 'bringen'? 'Ich ___ ___.'",opts:["habe gebracht","bin gebracht","habe brachte","bin brachte"],correct:0,expl:"'bringen' bildet Perfekt mit 'haben': ich habe gebracht.",rule:"Perfekt mit haben: habe gebracht"},
  {q:"Wie lautet das Perfekt von 'denken'? 'Ich ___ ___.'",opts:["habe gedacht","bin gedacht","habe dachte","bin dachte"],correct:0,expl:"'denken' bildet Perfekt mit 'haben': ich habe gedacht.",rule:"Perfekt mit haben: habe gedacht"},
  {q:"Wie lautet das Perfekt von 'rennen'? 'Ich ___ ___.'",opts:["bin gerannt","habe gerannt","bin rannte","habe rannte"],correct:0,expl:"'rennen' bildet Perfekt mit 'sein': ich bin gerannt.",rule:"Perfekt mit sein: bin gerannt"},
  {q:"Wie lautet das Perfekt von 'greifen'? 'Ich ___ ___.'",opts:["habe gegriffen","bin gegriffen","habe griff","bin griff"],correct:0,expl:"'greifen' bildet Perfekt mit 'haben': ich habe gegriffen.",rule:"Perfekt mit haben: habe gegriffen"},
  {q:"Wie lautet das Perfekt von 'bitten'? 'Ich ___ ___.'",opts:["habe gebeten","bin gebeten","habe bat","bin bat"],correct:0,expl:"'bitten' bildet Perfekt mit 'haben': ich habe gebeten.",rule:"Perfekt mit haben: habe gebeten"},
  {q:"Wie lautet das Perfekt von 'rufen'? 'Ich ___ ___.'",opts:["habe gerufen","bin gerufen","habe rief","bin rief"],correct:0,expl:"'rufen' bildet Perfekt mit 'haben': ich habe gerufen.",rule:"Perfekt mit haben: habe gerufen"},
  {q:"Wie lautet das Perfekt von 'schneiden'? 'Ich ___ ___.'",opts:["habe geschnitten","bin geschnitten","habe schnitt","bin schnitt"],correct:0,expl:"'schneiden' bildet Perfekt mit 'haben': ich habe geschnitten.",rule:"Perfekt mit haben: habe geschnitten"},
  {q:"Wie lautet das Perfekt von 'helfen'? 'Ich ___ ___.'",opts:["habe geholfen","bin geholfen","habe half","bin half"],correct:0,expl:"'helfen' bildet Perfekt mit 'haben': ich habe geholfen.",rule:"Perfekt mit haben: habe geholfen"},
  {q:"Wie lautet das Perfekt von 'stehen'? 'Ich ___ ___.'",opts:["habe gestanden","bin gestanden","habe stand","bin stand"],correct:0,expl:"'stehen' bildet Perfekt mit 'haben': ich habe gestanden.",rule:"Perfekt mit haben: habe gestanden"},
  {q:"Wie lautet das Perfekt von 'nehmen'? 'Ich ___ ___.'",opts:["habe genommen","bin genommen","habe nahm","bin nahm"],correct:0,expl:"'nehmen' bildet Perfekt mit 'haben': ich habe genommen.",rule:"Perfekt mit haben: habe genommen"},
  // Partizip II
  {q:"Wie lautet das Partizip II von 'singen'?",opts:["gesungen","sang","gesang","gesingt"],correct:0,expl:"Partizip II von 'singen': gesungen.",rule:"Partizip II starkes Verb: gesungen"},
  {q:"Wie lautet das Partizip II von 'rennen'?",opts:["gerannt","rannte","gerennt","gerennt"],correct:0,expl:"Partizip II von 'rennen': gerannt (Mischverb).",rule:"Partizip II Mischverb: gerannt"},
  {q:"Wie lautet das Partizip II von 'denken'?",opts:["gedacht","dachte","gedenkt","gedacht"],correct:0,expl:"Partizip II von 'denken': gedacht.",rule:"Partizip II Mischverb: gedacht"},
  {q:"Wie lautet das Partizip II von 'bringen'?",opts:["gebracht","brachte","gebringt","bringt"],correct:0,expl:"Partizip II von 'bringen': gebracht.",rule:"Partizip II Mischverb: gebracht"},
  {q:"Wie lautet das Partizip II von 'wissen'?",opts:["gewusst","wusste","gewist","weißt"],correct:0,expl:"Partizip II von 'wissen': gewusst.",rule:"Partizip II: gewusst"},
  {q:"Wie lautet das Partizip II von 'greifen'?",opts:["gegriffen","griff","gegriff","gegreift"],correct:0,expl:"Partizip II von 'greifen': gegriffen.",rule:"Partizip II starkes Verb: gegriffen"},
  {q:"Wie lautet das Partizip II von 'bitten'?",opts:["gebeten","bat","gebat","gebittet"],correct:0,expl:"Partizip II von 'bitten': gebeten.",rule:"Partizip II starkes Verb: gebeten"},
  {q:"Wie lautet das Partizip II von 'rufen'?",opts:["gerufen","rief","gerief","geruft"],correct:0,expl:"Partizip II von 'rufen': gerufen.",rule:"Partizip II starkes Verb: gerufen"},
  {q:"Wie lautet das Partizip II von 'schneiden'?",opts:["geschnitten","schnitt","geschnitt","geschneidet"],correct:0,expl:"Partizip II von 'schneiden': geschnitten.",rule:"Partizip II starkes Verb: geschnitten"},
  {q:"Wie lautet das Partizip II von 'beginnen'?",opts:["begonnen","begann","begann","beginnt"],correct:0,expl:"Partizip II von 'beginnen': begonnen.",rule:"Partizip II starkes Verb: begonnen"},
  {q:"Wie lautet das Partizip II von 'gewinnen'?",opts:["gewonnen","gewann","gewonnt","gewinnt"],correct:0,expl:"Partizip II von 'gewinnen': gewonnen.",rule:"Partizip II starkes Verb: gewonnen"},
  {q:"Wie lautet das Partizip II von 'kommen'?",opts:["gekommen","kam","gekommt","kommt"],correct:0,expl:"Partizip II von 'kommen': gekommen.",rule:"Partizip II starkes Verb: gekommen"},
  {q:"Wie lautet das Partizip II von 'gehen'?",opts:["gegangen","ging","gegangt","geht"],correct:0,expl:"Partizip II von 'gehen': gegangen.",rule:"Partizip II starkes Verb: gegangen"},
  {q:"Wie lautet das Partizip II von 'fahren'?",opts:["gefahren","fuhr","gefährt","fährt"],correct:0,expl:"Partizip II von 'fahren': gefahren.",rule:"Partizip II starkes Verb: gefahren"},
  {q:"Wie lautet das Partizip II von 'schreiben'?",opts:["geschrieben","schrieb","geschriebt","schreibt"],correct:0,expl:"Partizip II von 'schreiben': geschrieben.",rule:"Partizip II starkes Verb: geschrieben"},
  {q:"Wie lautet das Partizip II von 'nehmen'?",opts:["genommen","nahm","genommt","nimmt"],correct:0,expl:"Partizip II von 'nehmen': genommen.",rule:"Partizip II starkes Verb: genommen"},
  {q:"Wie lautet das Partizip II von 'sehen'?",opts:["gesehen","sah","geseht","sieht"],correct:0,expl:"Partizip II von 'sehen': gesehen.",rule:"Partizip II starkes Verb: gesehen"},
  {q:"Wie lautet das Partizip II von 'sprechen'?",opts:["gesprochen","sprach","gesprecht","spricht"],correct:0,expl:"Partizip II von 'sprechen': gesprochen.",rule:"Partizip II starkes Verb: gesprochen"},
  {q:"Wie lautet das Partizip II von 'finden'?",opts:["gefunden","fand","gefind","findet"],correct:0,expl:"Partizip II von 'finden': gefunden.",rule:"Partizip II starkes Verb: gefunden"},
  {q:"Wie lautet das Partizip II von 'essen'?",opts:["gegessen","aß","geessen","isst"],correct:0,expl:"Partizip II von 'essen': gegessen.",rule:"Partizip II starkes Verb: gegessen"},
  {q:"Wie lautet das Partizip II von 'liegen'?",opts:["gelegen","lag","geliegt","liegt"],correct:0,expl:"Partizip II von 'liegen': gelegen.",rule:"Partizip II starkes Verb: gelegen"},
  {q:"Wie lautet das Partizip II von 'stehen'?",opts:["gestanden","stand","gesteht","steht"],correct:0,expl:"Partizip II von 'stehen': gestanden.",rule:"Partizip II starkes Verb: gestanden"},
  {q:"Wie lautet das Partizip II von 'helfen'?",opts:["geholfen","half","gehilft","hilft"],correct:0,expl:"Partizip II von 'helfen': geholfen.",rule:"Partizip II starkes Verb: geholfen"},
  {q:"Wie lautet das Partizip II von 'singen'?",opts:["gesungen","sang","gesingt","singt"],correct:0,expl:"Partizip II von 'singen': gesungen.",rule:"Partizip II starkes Verb: gesungen"},
];

function fixCat() {
  const files = fs.readdirSync(dir).filter(f => f.match(/^part\d+\.ts$/)).sort();
  const globalSeen = new Map();
  const toFix = [];

  for (const file of files) {
    const content = fs.readFileSync(path.join(dir, file), 'utf8');
    const ids = [...content.matchAll(/"id":\s*"([^"]+)"/g)].map(m=>m[1]);
    const qs = [...content.matchAll(/"question":\s*"([^"]+)"/g)].map(m=>m[1]);
    for (let i = 0; i < Math.min(ids.length, qs.length); i++) {
      if (globalSeen.has(qs[i])) {
        toFix.push({file, id: ids[i], oldQ: qs[i]});
      } else {
        globalSeen.set(qs[i], ids[i]);
      }
    }
  }

  console.log(`Found ${toFix.length} dups to fix`);

  const byFile = {};
  for (const item of toFix) {
    if (!byFile[item.file]) byFile[item.file] = [];
    byFile[item.file].push(item);
  }

  let poolIdx = 0;
  let totalFixed = 0;

  for (const [file, items] of Object.entries(byFile)) {
    let content = fs.readFileSync(path.join(dir, file), 'utf8');
    let fixed = 0;

    for (const item of items) {
      let rep;
      let tries = 0;
      do {
        rep = pool[poolIdx % pool.length];
        poolIdx++;
        tries++;
      } while (globalSeen.has(rep.q) && tries < pool.length * 2);

      if (globalSeen.has(rep.q)) {
        console.log(`WARNING: pool exhausted for ${item.id}`);
        continue;
      }

      globalSeen.set(rep.q, item.id);

      if (content.includes(`"${item.oldQ}"`)) {
        content = content.replace(`"${item.oldQ}"`, `"${rep.q}"`);
        fixed++;
        totalFixed++;
      } else {
        console.log(`NOT FOUND: ${item.id} | ${item.oldQ.substring(0,60)}`);
      }
    }

    fs.writeFileSync(path.join(dir, file), content, 'utf8');
    console.log(`  Fixed ${fixed} in ${file}`);
  }

  return totalFixed;
}

const n = fixCat();
console.log(`Total fixed: ${n}`);

// Verify
function countDups() {
  const files = fs.readdirSync(dir).filter(f => f.match(/^part\d+\.ts$/)).sort();
  const seen = new Map(); let d = 0;
  for (const f of files) {
    const c = fs.readFileSync(path.join(dir, f), 'utf8');
    for (const m of c.matchAll(/"question":\s*"([^"]+)"/g)) {
      if (seen.has(m[1])) d++;
      else seen.set(m[1], 1);
    }
  }
  return d;
}
console.log('konjugation remaining dups:', countDups());
