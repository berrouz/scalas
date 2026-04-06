const fs = require('fs');
const path = require('path');

// Pool of KII verb questions not yet used in part1/part2
const kiiPool = [
  // verb, kii-form, wrong1, wrong2, wrong3
  ['backen','bük','buk','backt','würde backe'],
  ['beißen','bisse','biss','beißt','würde beiße'],
  ['biegen','böge','bog','biegt','würde biege'],
  ['binden','bände','band','bindet','würde binde'],
  ['blasen','bliese','blies','bläst','würde blase'],
  ['braten','briete','briet','brät','würde brate'],
  ['fechten','föchte','focht','ficht','würde fechte'],
  ['fließen','flösse','floss','fließt','würde fließe'],
  ['frieren','fröre','fror','friert','würde friere'],
  ['gebären','gebäre','gebar','gebärt','würde gebäre'],
  ['gleichen','gliche','glich','gleicht','würde gleiche'],
  ['gleiten','glitte','glitt','gleitet','würde gleite'],
  ['graben','grübe','grub','gräbt','würde grabe'],
  ['greifen','griffe','griff','greift','würde greife'],
  ['hängen','hinge','hing','hängt','würde hange'],
  ['heben','höbe','hob','hebt','würde hebe'],
  ['laden','lüde','lud','lädt','würde lade'],
  ['liegen','läge','lag','liegt','würde liege'],
  ['meiden','miede','mied','meidet','würde meide'],
  ['messen','mäße','maß','misst','würde messe'],
  ['raten','riete','riet','rät','würde rate'],
  ['reißen','risse','riss','reißt','würde reiße'],
  ['reiten','ritte','ritt','reitet','würde reite'],
  ['rennen','rennte','rannte','rennt','würde renne'],
  ['riechen','röche','roch','riecht','würde rieche'],
  ['schlagen','schlüge','schlug','schlägt','würde schlage'],
  ['schließen','schlösse','schloss','schließt','würde schließe'],
  ['schneiden','schnitte','schnitt','schneidet','würde schneide'],
  ['schweigen','schwiege','schwieg','schweigt','würde schweige'],
  ['sinken','sänke','sank','sinkt','würde sinke'],
  ['sitzen','säße','saß','sitzt','würde sitze'],
  ['springen','spränge','sprang','springt','würde springe'],
  ['stehlen','stähle','stahl','stiehlt','würde stehle'],
  ['steigen','stiege','stieg','steigt','würde steige'],
  ['stoßen','stieße','stieß','stößt','würde stoße'],
  ['streichen','striche','strich','streicht','würde streiche'],
  ['treten','träte','trat','tritt','würde trete'],
  ['wachsen','wüchse','wuchs','wächst','würde wachse'],
  ['waschen','wüsche','wusch','wäscht','würde wasche'],
  ['weichen','wiche','wich','weicht','würde weiche'],
  ['werben','würbe','warb','wirbt','würde werbe'],
];

// Pool of alternative conceptual konjunktiv questions
const conceptualPool = [
  {q:"Wie lautet der Konjunktiv I von 'laufen' (er/sie)?",opts:["läuft","lief","laufe","liefe"],correct:2,expl:"KI von 'laufen': er laufe.",rule:"KI: laufen → er laufe"},
  {q:"Wie lautet der Konjunktiv I von 'schreiben' (er/sie)?",opts:["schreibt","schrieb","schreibe","schriebe"],correct:2,expl:"KI von 'schreiben': er schreibe.",rule:"KI: schreiben → er schreibe"},
  {q:"Wie lautet der Konjunktiv I von 'fahren' (er/sie)?",opts:["fährt","fuhr","fahre","führe"],correct:2,expl:"KI von 'fahren': er fahre.",rule:"KI: fahren → er fahre"},
  {q:"Wie lautet der Konjunktiv I von 'helfen' (er/sie)?",opts:["hilft","half","helfe","hülfe"],correct:2,expl:"KI von 'helfen': er helfe.",rule:"KI: helfen → er helfe"},
  {q:"Wie lautet der Konjunktiv I von 'sehen' (er/sie)?",opts:["sieht","sah","sehe","sähe"],correct:2,expl:"KI von 'sehen': er sehe.",rule:"KI: sehen → er sehe"},
  {q:"Wie lautet der Konjunktiv I von 'denken' (er/sie)?",opts:["denkt","dachte","denke","dächte"],correct:2,expl:"KI von 'denken': er denke.",rule:"KI: denken → er denke"},
  {q:"Wie lautet der Konjunktiv I von 'trinken' (er/sie)?",opts:["trinkt","trank","trinke","tränke"],correct:2,expl:"KI von 'trinken': er trinke.",rule:"KI: trinken → er trinke"},
  {q:"Wie lautet der Konjunktiv I von 'kaufen' (er/sie)?",opts:["kauft","kaufte","kaufe","kaufte"],correct:2,expl:"KI von 'kaufen': er kaufe.",rule:"KI: kaufen → er kaufe"},
  {q:"Wie lautet der Konjunktiv I von 'spielen' (er/sie)?",opts:["spielt","spielte","spiele","spielte"],correct:2,expl:"KI von 'spielen': er spiele.",rule:"KI: spielen → er spiele"},
  {q:"Wie lautet der Konjunktiv I von 'finden' (er/sie)?",opts:["findet","fand","finde","fände"],correct:2,expl:"KI von 'finden': er finde.",rule:"KI: finden → er finde"},
  {q:"Welcher Satz steht im Konjunktiv I (indirekte Rede)?",opts:["Er kommt morgen.","Er sagte, er komme morgen.","Er sagte, er ist gekommen.","Er würde kommen."],correct:1,expl:"KI in indirekter Rede: 'er komme'.",rule:"KI für indirekte Rede"},
  {q:"Welcher Satz enthält eine 'als ob'-Konstruktion mit Konjunktiv II?",opts:["Er sieht aus, als ob er schläft.","Er sieht aus, als ob er geschlafen hätte.","Er sieht aus wie ein Schläfer.","Er schläft, als ob er müde ist."],correct:1,expl:"'als ob' + KII: 'als ob er geschlafen hätte'.",rule:"als ob + KII"},
  {q:"Was bedeutet 'würde + Infinitiv' im Konjunktiv II?",opts:["Futur I","Konjunktiv II (Umschreibung)","Passiv","Imperativ"],correct:1,expl:"'würde + Infinitiv' ist die analytische Form des Konjunktivs II.",rule:"KII-Umschreibung: würde + Infinitiv"},
  {q:"Welchen Konjunktiv verwendet man in der indirekten Rede?",opts:["Konjunktiv II","Konjunktiv I","Indikativ Präsens","Indikativ Präteritum"],correct:1,expl:"In der indirekten Rede wird hauptsächlich Konjunktiv I verwendet.",rule:"Indirekte Rede: Konjunktiv I"},
  {q:"Ergänze: 'Wenn er mehr lernte, ___ er die Prüfung bestehen.'",opts:["wird","würde","hat","ist"],correct:1,expl:"Irrealer Konditionalsatz: würde + Infinitiv.",rule:"Irrealer Konditional: KII in Haupt- und Nebensatz"},
  {q:"Wie bildet man den Konjunktiv II Vergangenheit?",opts:["hatte/war + Partizip II","hätte/wäre + Partizip II","würde + Partizip II","haben + Infinitiv"],correct:1,expl:"KII Vergangenheit: hätte/wäre + Partizip II.",rule:"KII Vergangenheit: hätte/wäre + Partizip II"},
];

let kiiPoolIdx = 0;
let conceptIdx = 0;

function makeKIIQuestion(id) {
  if (kiiPoolIdx >= kiiPool.length) return makeConceptualQuestion(id);
  const [verb, kii, w1, w2, w3] = kiiPool[kiiPoolIdx++];
  return {
    q: `Wie lautet der Konjunktiv II von '${verb}' (er/sie)?`,
    opts: [kii, w1, w2, w3],
    correct: 0,
    expl: `KII von '${verb}': ${kii}.`,
    rule: `KII: ${verb} → ${kii}`
  };
}

function makeConceptualQuestion(id) {
  if (conceptIdx >= conceptualPool.length) {
    // fallback
    const n = conceptIdx % conceptualPool.length;
    conceptIdx++;
    return conceptualPool[n];
  }
  return conceptualPool[conceptIdx++];
}

// Strategy: for each still-duplicate question, replace with a new unique one
function fixCat(cat, makeReplacement) {
  const dir = path.join('src/data/german/b1', cat);
  const files = fs.readdirSync(dir).filter(f => f.match(/^part\d+\.ts$/)).sort();
  
  let globalSeen = new Map();
  let filesToFix = {};
  
  // Two passes: first identify duplicates
  for (const file of files) {
    const content = fs.readFileSync(path.join(dir, file), 'utf8');
    const ids = [...content.matchAll(/"id":\s*"([^"]+)"/g)].map(m=>m[1]);
    const qs = [...content.matchAll(/"question":\s*"([^"]+)"/g)].map(m=>m[1]);
    for (let i=0; i<Math.min(ids.length,qs.length); i++) {
      const id = ids[i], q = qs[i];
      if (globalSeen.has(q)) {
        if (!filesToFix[file]) filesToFix[file] = [];
        filesToFix[file].push(id);
      } else {
        globalSeen.set(q, id);
      }
    }
  }
  
  let totalFixed = 0;
  for (const [file, ids] of Object.entries(filesToFix)) {
    let content = fs.readFileSync(path.join(dir, file), 'utf8');
    let modified = false;
    
    for (const id of ids) {
      const rep = makeReplacement(id);
      
      // Make sure this replacement question isn't also a duplicate
      while (globalSeen.has(rep.q)) {
        const nextrep = makeReplacement(id);
        if (nextrep.q === rep.q) break; // prevent infinite loop
        Object.assign(rep, nextrep);
      }
      globalSeen.set(rep.q, id);
      
      const optStr = JSON.stringify(rep.opts);
      const escId = id.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      const newQ = rep.q.replace(/\\/g, '\\\\').replace(/"/g, '\\"');
      
      // Replace question
      content = content.replace(
        new RegExp('("id":\\s*"' + escId + '"[\\s\\S]*?"question":\\s*")([^"]+)(")', 'm'),
        '$1' + newQ + '$3'
      );
      // Replace options
      content = content.replace(
        new RegExp('("id":\\s*"' + escId + '"[\\s\\S]*?"options":\\s*)\\[[^\\]]*\\]', 'm'),
        '$1' + optStr
      );
      // Replace correctAnswer
      content = content.replace(
        new RegExp('("id":\\s*"' + escId + '"[\\s\\S]*?"correctAnswer":\\s*)\\d+', 'm'),
        '$1' + rep.correct
      );
      // Replace explanation
      content = content.replace(
        new RegExp('("id":\\s*"' + escId + '"[\\s\\S]*?"explanation":\\s*")([^"]+)(")', 'm'),
        '$1' + (rep.expl||'').replace(/\\/g,'\\\\').replace(/"/g,'\\"') + '$3'
      );
      // Replace grammarRule
      if (rep.rule) {
        content = content.replace(
          new RegExp('("id":\\s*"' + escId + '"[\\s\\S]*?"grammarRule":\\s*")([^"]*)(")','m'),
          '$1' + rep.rule.replace(/\\/g,'\\\\').replace(/"/g,'\\"') + '$3'
        );
      }
      
      modified = true;
      totalFixed++;
    }
    
    if (modified) {
      fs.writeFileSync(path.join(dir, file), content, 'utf8');
      console.log('  Fixed ' + ids.length + ' in ' + file);
    }
  }
  return totalFixed;
}

console.log('Fixing konjunktiv...');
const n = fixCat('konjunktiv', makeKIIQuestion);
console.log('Fixed', n, 'remaining dups in konjunktiv');

// Verify
const {execSync} = require('child_process');
const verify = `node -e "
const fs=require('fs'),path=require('path');
const dir='src/data/german/b1/konjunktiv';
const files=fs.readdirSync(dir).filter(f=>f.match(/^part\\\\d+\\.ts\$/)).sort();
const seen=new Map();let dups=0;
for(const f of files){const c=fs.readFileSync(path.join(dir,f),'utf8');
for(const m of c.matchAll(/\\"question\\":\\s*\\"([^\\"]+)\\"/g)){
if(seen.has(m[1]))dups++;else seen.set(m[1],1);}}
console.log('remaining dups:',dups);
"`;
console.log(execSync(verify, {cwd: process.cwd()}).toString());
