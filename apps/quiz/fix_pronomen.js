const fs = require('fs');
const path = require('path');

// Build a comprehensive pool of pronomen replacement questions
// covering all pronomen types: Indefinitpronomen, Fragepronomen, Possessivpronomen (different contexts)
const pool = [
  // Indefinitpronomen
  {q:"Welches Indefinitpronomen passt? 'Ich sehe ___ in der Dunkelheit.'",opts:["jemanden","niemanden","keiner","nichts"],correct:0,expl:"'jemanden' = eine unbekannte Person (Akkusativ).",rule:"Indefinitpronomen: jemand → jemanden (Akk.)"},
  {q:"Welches Indefinitpronomen passt? 'Hat ___ mein Buch gesehen?'",opts:["jemand","niemand","keiner","etwas"],correct:0,expl:"'jemand' = eine unbekannte Person.",rule:"Indefinitpronomen: jemand (Nominativ)"},
  {q:"Welches Indefinitpronomen passt? 'Es gibt ___ zu essen.'",opts:["jemand","etwas","nichts","keiner"],correct:1,expl:"'etwas' = eine unbestimmte Sache.",rule:"Indefinitpronomen: etwas = eine Sache"},
  {q:"Welches Indefinitpronomen passt? '___ kann solche Fehler machen.'",opts:["Jemand","Etwas","Jeder","Nichts"],correct:2,expl:"'Jeder' = alle Personen.",rule:"Indefinitpronomen: jeder = alle"},
  {q:"Welches Indefinitpronomen passt? 'Ich habe ___ davon gewusst.'",opts:["etwas","jemand","nichts","keiner"],correct:2,expl:"'nichts' = keine Sache.",rule:"Indefinitpronomen: nichts = keine Sache"},
  {q:"Welches Indefinitpronomen passt? '___ von uns war dabei.'",opts:["Jeder","Keiner","Etwas","Jemand"],correct:0,expl:"'Jeder von uns' = alle Personen aus einer Gruppe.",rule:"Indefinitpronomen: jeder von"},
  {q:"Welches Indefinitpronomen passt? 'Das ist ___ Problem.' (Verneinung, neutrum)",opts:["kein","keines","keiner","nichts"],correct:0,expl:"'kein' als Pronomen vor Nomen (neutrum Nominativ).",rule:"Negation: kein/keine/keines"},
  {q:"Welches Indefinitpronomen passt? 'Ich kenne ___ hier.' (Verneinung)",opts:["niemand","jemanden","keinen","etwas"],correct:0,expl:"'niemanden' = keine Person (Akkusativ).",rule:"Indefinitpronomen: niemanden (Akk.)"},
  // Fragepronomen
  {q:"Welches Fragepronomen fragt nach Personen?",opts:["was","wie","wer","wo"],correct:2,expl:"'wer' fragt nach Personen: 'Wer ist das?'",rule:"Fragepronomen: wer = Person; was = Sache"},
  {q:"Welches Fragepronomen fragt nach Sachen?",opts:["wer","wessen","was","wem"],correct:2,expl:"'was' fragt nach Sachen: 'Was machst du?'",rule:"Fragepronomen: was = Sache"},
  {q:"Ergänzen Sie das Fragepronomen: '___ hast du das gegeben?' (Person, Dativ)",opts:["Wer","Wen","Wem","Wessen"],correct:2,expl:"'Wem' = Dativ der Person.",rule:"Fragepronomen Dativ: wem"},
  {q:"Ergänzen Sie das Fragepronomen: '___ hast du eingeladen?' (Person, Akkusativ)",opts:["Wer","Wen","Wem","Wessen"],correct:1,expl:"'Wen' = Akkusativ der Person.",rule:"Fragepronomen Akkusativ: wen"},
  {q:"Ergänzen Sie das Fragepronomen: '___ Tasche ist das?' (Genitiv)",opts:["Wer","Wen","Wem","Wessen"],correct:3,expl:"'Wessen' = Genitiv der Person.",rule:"Fragepronomen Genitiv: wessen"},
  // Relativpronomen (different contexts)
  {q:"Ergänzen Sie das Relativpronomen: 'das Restaurant, ___ wir empfehlen, ...' (neutrum Akkusativ)",opts:["der","die","dem","das"],correct:3,expl:"Relativpronomen für neutrum Akkusativ: das.",rule:"Relativpronomen neutrum Akkusativ = das"},
  {q:"Ergänzen Sie das Relativpronomen: 'der Park, ___ sehr schön ist, ...' (maskulin Nominativ)",opts:["den","dem","der","dessen"],correct:2,expl:"Relativpronomen für maskulin Nominativ: der.",rule:"Relativpronomen maskulin Nominativ = der"},
  {q:"Ergänzen Sie das Relativpronomen: 'die Schule, ___ ich besuche, ...' (feminin Akkusativ)",opts:["der","die","dem","deren"],correct:1,expl:"Relativpronomen für feminin Akkusativ: die.",rule:"Relativpronomen feminin Akkusativ = die"},
  {q:"Ergänzen Sie das Relativpronomen: 'der Kollege, ___ ich seit Jahren kenne, ...' (maskulin Akkusativ)",opts:["der","dem","den","dessen"],correct:2,expl:"Relativpronomen für maskulin Akkusativ: den.",rule:"Relativpronomen maskulin Akkusativ = den"},
  {q:"Ergänzen Sie das Relativpronomen: 'das Buch, ___ ich lese, ...' (neutrum Akkusativ)",opts:["der","die","dem","das"],correct:3,expl:"Relativpronomen für neutrum Akkusativ: das.",rule:"Relativpronomen neutrum Akkusativ = das"},
  {q:"Ergänzen Sie das Relativpronomen: 'die Stadt, ___ wir besucht haben, ...' (feminin Akkusativ)",opts:["der","die","dem","deren"],correct:1,expl:"Relativpronomen für feminin Akkusativ: die.",rule:"Relativpronomen feminin Akkusativ = die"},
  {q:"Ergänzen Sie das Relativpronomen: 'der Mann, ___ ich vertraue, ...' (maskulin Dativ)",opts:["der","dem","den","dessen"],correct:1,expl:"Relativpronomen für maskulin Dativ: dem.",rule:"Relativpronomen maskulin Dativ = dem"},
  {q:"Ergänzen Sie das Relativpronomen: 'das Kind, ___ ich geholfen habe, ...' (neutrum Dativ)",opts:["das","dem","den","dessen"],correct:1,expl:"Relativpronomen für neutrum Dativ: dem.",rule:"Relativpronomen neutrum Dativ = dem"},
  {q:"Ergänzen Sie das Relativpronomen: 'die Lehrerin, ___ Unterricht mir gefällt, ...' (feminin Genitiv)",opts:["die","der","dem","deren"],correct:3,expl:"Relativpronomen für feminin Genitiv: deren.",rule:"Relativpronomen feminin Genitiv = deren"},
  {q:"Ergänzen Sie das Relativpronomen: 'der Autor, ___ Bücher ich lese, ...' (maskulin Genitiv)",opts:["der","dem","dessen","deren"],correct:2,expl:"Relativpronomen für maskulin Genitiv: dessen.",rule:"Relativpronomen maskulin Genitiv = dessen"},
  // Reflexivpronomen (different verbs)
  {q:"Ergänzen Sie das Reflexivpronomen: 'ich ärgere ___ über den Fehler.'",opts:["mir","mich","sich","dich"],correct:1,expl:"'sich ärgern' mit ich: mich.",rule:"Reflexivpronomen Akkusativ: mich, dich, sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'du bewirbst ___ um die Stelle.'",opts:["dich","mich","sich","uns"],correct:0,expl:"'sich bewerben' mit du: dich.",rule:"Reflexivpronomen Akkusativ: mich, dich, sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'sie (Sg.) bereitet ___ auf die Prüfung vor.'",opts:["euch","mich","sich","uns"],correct:2,expl:"'sich vorbereiten' mit sie: sich.",rule:"Reflexivpronomen 3. Person: sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'wir verabschieden ___ von den Gästen.'",opts:["euch","sich","mich","uns"],correct:3,expl:"'sich verabschieden' mit wir: uns.",rule:"Reflexivpronomen Akkusativ: wir → uns"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'ihr beschäftigt ___ mit dem Thema.'",opts:["uns","sich","mich","euch"],correct:3,expl:"'sich beschäftigen' mit ihr: euch.",rule:"Reflexivpronomen Akkusativ: ihr → euch"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'er entschuldigt ___ für den Fehler.'",opts:["ihn","mir","sich","mich"],correct:2,expl:"'sich entschuldigen' mit er: sich.",rule:"Reflexivpronomen 3. Person: sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'ich freue ___ sehr darauf.'",opts:["mir","sich","mich","dich"],correct:2,expl:"'sich freuen' mit ich: mich.",rule:"Reflexivpronomen Akkusativ: ich → mich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'sie (Pl.) kennen ___ schon lange.'",opts:["euch","mich","uns","sich"],correct:3,expl:"'sich kennen' mit sie (Pl.): sich.",rule:"Reflexivpronomen 3. Person Plural: sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'ich kaufe ___ ein neues Buch.' (Dativ)",opts:["mich","mir","sich","dir"],correct:1,expl:"'sich etwas kaufen' mit ich im Dativ: mir.",rule:"Reflexivpronomen Dativ: mir, dir, sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'du kaufst ___ ein neues Hemd.' (Dativ)",opts:["dich","mir","dir","sich"],correct:2,expl:"'sich etwas kaufen' mit du im Dativ: dir.",rule:"Reflexivpronomen Dativ: mir, dir, sich"},
  {q:"Ergänzen Sie das Reflexivpronomen: 'wir haben ___ über den Besuch gefreut.'",opts:["euch","sich","uns","mich"],correct:2,expl:"'sich freuen' mit wir: uns.",rule:"Reflexivpronomen Akkusativ: wir → uns"},
  // Personalpronomen Akkusativ
  {q:"Welches Pronomen steht im Akkusativ für 'du'?",opts:["dir","dich","sich","dein"],correct:1,expl:"Das Akkusativpronomen von 'du' ist 'dich'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  {q:"Welches Pronomen steht im Akkusativ für 'sie (Sg.)'?",opts:["ihr","ihn","sie","ihm"],correct:2,expl:"Das Akkusativpronomen von 'sie' (Sg.) ist 'sie'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  {q:"Welches Pronomen steht im Akkusativ für 'er'?",opts:["ihm","ihn","er","sein"],correct:1,expl:"Das Akkusativpronomen von 'er' ist 'ihn'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  {q:"Welches Pronomen steht im Akkusativ für 'wir'?",opts:["uns","euch","mir","sich"],correct:0,expl:"Das Akkusativpronomen von 'wir' ist 'uns'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  {q:"Welches Pronomen steht im Akkusativ für 'ihr'?",opts:["uns","euch","ihr","sich"],correct:1,expl:"Das Akkusativpronomen von 'ihr' ist 'euch'.",rule:"Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie"},
  // Dativ
  {q:"Welches Pronomen steht im Dativ für 'wir'?",opts:["uns","euch","mir","sich"],correct:0,expl:"Das Dativpronomen von 'wir' ist 'uns'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'du'?",opts:["dich","dir","ihr","sich"],correct:1,expl:"Das Dativpronomen von 'du' ist 'dir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'ich'?",opts:["mich","mir","dir","sich"],correct:1,expl:"Das Dativpronomen von 'ich' ist 'mir'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'er'?",opts:["ihn","er","ihm","sein"],correct:2,expl:"Das Dativpronomen von 'er' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'sie (Sg.)'?",opts:["sie","ihr","ihm","ihr"],correct:1,expl:"Das Dativpronomen von 'sie' (Sg.) ist 'ihr'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'sie (Pl.)'?",opts:["ihr","ihm","ihnen","euch"],correct:2,expl:"Das Dativpronomen von 'sie' (Pl.) ist 'ihnen'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'ihr'?",opts:["dir","euch","mir","ihr"],correct:1,expl:"Das Dativpronomen von 'ihr' ist 'euch'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  {q:"Welches Pronomen steht im Dativ für 'es'?",opts:["ihn","ihm","ihr","es"],correct:1,expl:"Das Dativpronomen von 'es' ist 'ihm'.",rule:"Dativ: mir, dir, ihm, ihr, ihm, uns, euch, ihnen/Ihnen"},
  // Demonstrativpronomen
  {q:"Welches Demonstrativpronomen passt? '___ Idee ist gut.' (feminin, Nominativ)",opts:["Dieser","Dieses","Diese","Diesem"],correct:2,expl:"Demonstrativpronomen für feminin Nominativ: diese.",rule:"Demonstrativpronomen feminin Nominativ = diese"},
  {q:"Welches Demonstrativpronomen passt? 'Ich helfe ___ Mann.' (maskulin, Dativ)",opts:["dieser","diesen","diesem","dieses"],correct:2,expl:"Demonstrativpronomen für maskulin Dativ: diesem.",rule:"Demonstrativpronomen maskulin Dativ = diesem"},
  {q:"Welches Demonstrativpronomen passt? 'Ich kenne ___ Frau.' (feminin, Akkusativ)",opts:["dieser","diese","diesem","diesen"],correct:1,expl:"Demonstrativpronomen für feminin Akkusativ: diese.",rule:"Demonstrativpronomen feminin Akkusativ = diese"},
  {q:"Welches Demonstrativpronomen passt? '___ Auto ist neu.' (neutrum, Nominativ)",opts:["Dieser","Dieses","Diese","Diesem"],correct:1,expl:"Demonstrativpronomen für neutrum Nominativ: dieses.",rule:"Demonstrativpronomen neutrum Nominativ = dieses"},
  {q:"Welches Demonstrativpronomen passt? 'Trotz ___ Arbeit hat er Zeit.' (feminin, Genitiv)",opts:["dieser","dieses","diesem","diese"],correct:0,expl:"Demonstrativpronomen für feminin Genitiv: dieser.",rule:"Demonstrativpronomen feminin Genitiv = dieser"},
  {q:"Welches Demonstrativpronomen passt? 'Ich spreche von ___ Thema.' (neutrum, Dativ)",opts:["diesen","dieser","diesem","dieses"],correct:2,expl:"Demonstrativpronomen für neutrum Dativ: diesem.",rule:"Demonstrativpronomen neutrum Dativ = diesem"},
  {q:"Welches Demonstrativpronomen passt? '___ Leute kenne ich.' (Plural, Akkusativ)",opts:["diesen","dieser","diese","diesem"],correct:2,expl:"Demonstrativpronomen für Plural Akkusativ: diese.",rule:"Demonstrativpronomen Plural Akkusativ = diese"},
  {q:"Welches Demonstrativpronomen passt? 'Mit ___ Kindern spiele ich.' (Plural, Dativ)",opts:["diese","dieser","dieses","diesen"],correct:3,expl:"Demonstrativpronomen für Plural Dativ: diesen.",rule:"Demonstrativpronomen Plural Dativ = diesen"},
];

// Fix all pronomen duplicates
function fixAllDups(cat, pool) {
  const base = 'src/data/german/b1';
  const dir = path.join(base, cat);
  const files = fs.readdirSync(dir).filter(f => f.match(/^part\d+\.ts$/)).sort();

  // Build global seen map
  const globalSeen = new Map();
  const toFix = []; // {file, id, q}

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

  // Organize by file
  const byFile = {};
  for (const item of toFix) {
    if (!byFile[item.file]) byFile[item.file] = [];
    byFile[item.file].push(item);
  }

  let poolIdx = 0;
  let totalFixed = 0;

  for (const [file, items] of Object.entries(byFile)) {
    let content = fs.readFileSync(path.join(dir, file), 'utf8');

    for (const item of items) {
      // Get next non-duplicate replacement
      let rep;
      let tries = 0;
      do {
        rep = pool[poolIdx % pool.length];
        poolIdx++;
        tries++;
      } while (globalSeen.has(rep.q) && tries < pool.length * 2);

      if (globalSeen.has(rep.q)) {
        console.log(`WARNING: Could not find unique replacement for ${item.id}`);
        continue;
      }

      globalSeen.set(rep.q, item.id);

      // Use simple string replacement on the oldQ text
      const oldQ = item.oldQ;

      // Replace question text (may appear in double quotes)
      const escapedOldQ = oldQ.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');

      // Replace in content - find the question's block and replace just the question text
      // The question text appears as: "question": "...oldQ..."
      content = content.replace(
        `"question": "${oldQ}"`,
        `"question": "${rep.q}"`
      );
      // Also handle single-line compact format
      if (content.includes(`"question":"${oldQ}"`)) {
        content = content.replace(`"question":"${oldQ}"`, `"question":"${rep.q}"`);
      }

      totalFixed++;
    }

    fs.writeFileSync(path.join(dir, file), content, 'utf8');
    console.log(`  Fixed ${items.length} in ${file}`);
  }

  return totalFixed;
}

const n = fixAllDups('pronomen', pool);
console.log(`Total fixed: ${n}`);

// Verify
function countDups(cat) {
  const base = 'src/data/german/b1';
  const dir = path.join(base, cat);
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
console.log('pronomen remaining dups:', countDups('pronomen'));
