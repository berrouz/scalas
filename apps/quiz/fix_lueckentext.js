const fs = require('fs');
const path = require('path');

const base = 'src/data/german/b1';
const dir = path.join(base, 'lueckentext');

// Large pool of unique lueckentext sentences
const pool = [
  {q:"Ergänze: 'Der Lehrer erklärt ___ Schülern die Aufgabe.'",opts:["den","dem","die","der"],correct:0,expl:"'den Schülern' = Dativ Plural.",rule:"Dativ Plural: den"},
  {q:"Ergänze: 'Ich fahre morgen ___ Berlin.'",opts:["nach","in","zu","an"],correct:0,expl:"'nach' bei Städten und Ländern ohne Artikel.",rule:"Richtung: nach + Stadt"},
  {q:"Ergänze: 'Sie arbeitet ___ einem großen Unternehmen.'",opts:["bei","in","an","für"],correct:0,expl:"'bei' für Arbeitgeber: bei einem Unternehmen.",rule:"Präposition: bei + Arbeitgeber"},
  {q:"Ergänze: 'Er hat ___ seinem Chef gesprochen.'",opts:["mit","bei","von","zu"],correct:0,expl:"'sprechen mit' = mit jemandem sprechen.",rule:"sprechen mit + Dativ"},
  {q:"Ergänze: 'Wir kommen ___ Hause.'",opts:["nach","zu","von","aus"],correct:0,expl:"'nach Hause' = wohin (Richtung).",rule:"nach Hause = Richtung"},
  {q:"Ergänze: 'Das Buch gehört ___ meiner Schwester.'",opts:["zu","bei","von","mit"],correct:0,expl:"'gehören zu' oder 'gehören' + Dativ.",rule:"gehören + Dativ"},
  {q:"Ergänze: 'Sie lacht ___ seinen Witzen.'",opts:["über","bei","auf","von"],correct:0,expl:"'lachen über' = sich über etwas amüsieren.",rule:"lachen über + Akkusativ"},
  {q:"Ergänze: 'Ich interessiere mich ___ Geschichte.'",opts:["für","an","bei","über"],correct:0,expl:"'sich interessieren für' = etwas interessant finden.",rule:"sich interessieren für + Akkusativ"},
  {q:"Ergänze: 'Er wartet ___ seine Freundin.'",opts:["auf","für","nach","von"],correct:0,expl:"'warten auf' = auf jemanden warten.",rule:"warten auf + Akkusativ"},
  {q:"Ergänze: 'Sie hat Angst ___ Hunden.'",opts:["vor","von","bei","um"],correct:0,expl:"'Angst vor' = Angst vor etwas haben.",rule:"Angst vor + Dativ"},
  {q:"Ergänze: 'Er beschwert sich ___ den Lärm.'",opts:["über","bei","von","auf"],correct:0,expl:"'sich beschweren über' = klagen über.",rule:"sich beschweren über + Akkusativ"},
  {q:"Ergänze: 'Wir fahren ___ Urlaub nach Spanien.'",opts:["in den","in die","im","an den"],correct:0,expl:"'in den Urlaub fahren' = Urlaub machen.",rule:"in den Urlaub fahren"},
  {q:"Ergänze: 'Sie hat ___ Arzt einen Termin gemacht.'",opts:["beim","beim","am","zum"],correct:0,expl:"'beim Arzt' = bei dem Arzt.",rule:"beim Arzt = bei dem Arzt"},
  {q:"Ergänze: 'Ich habe ___ Glück das Portemonnaie gefunden.'",opts:["zum","beim","mit","nach"],correct:0,expl:"'zum Glück' = glücklicherweise.",rule:"zum Glück = Glücksausdruck"},
  {q:"Ergänze: 'Er hat das Projekt ___ Zeit fertiggestellt.'",opts:["rechtzeitig","rechtzeitige","zeitig","zu Zeit"],correct:0,expl:"'rechtzeitig' = zur richtigen Zeit.",rule:"rechtzeitig = zur richtigen Zeit"},
  {q:"Ergänze: 'Sie freut sich ___ das Geschenk.'",opts:["über","für","an","bei"],correct:0,expl:"'sich freuen über' = Freude empfinden über etwas.",rule:"sich freuen über + Akkusativ"},
  {q:"Ergänze: 'Ich denke ___ an dich.'",opts:["oft","täglich","gerne","regelmäßig"],correct:0,expl:"'oft' = häufig, mehrmals.",rule:"Frequenzadverb: oft"},
  {q:"Ergänze: 'Das Kind rennt ___ die Wiese.'",opts:["über","auf","durch","an"],correct:2,expl:"'durch die Wiese' oder 'über die Wiese' — 'durch' bedeutet: von einer Seite zur anderen.",rule:"durch + Akkusativ (Bewegung durch etwas)"},
  {q:"Ergänze: 'Sie hat ___ keinen Hunger mehr.'",opts:["abends","heute","jetzt","morgens"],correct:2,expl:"'jetzt' = in diesem Moment.",rule:"Temporaladverb: jetzt"},
  {q:"Ergänze: 'Er kommt ___ drei Stunden zurück.'",opts:["in","nach","seit","vor"],correct:0,expl:"'in drei Stunden' = nach einer Zeitspanne von drei Stunden.",rule:"in + Zeitdauer = zukünftiger Zeitpunkt"},
  {q:"Ergänze: 'Ich habe das Buch ___ drei Tagen fertig gelesen.'",opts:["in","seit","vor","nach"],correct:2,expl:"'vor drei Tagen' = drei Tage in der Vergangenheit.",rule:"vor + Dativ = in der Vergangenheit"},
  {q:"Ergänze: 'Sie wohnt ___ zwei Jahren in Deutschland.'",opts:["seit","vor","in","nach"],correct:0,expl:"'seit zwei Jahren' = der Anfang liegt in der Vergangenheit, Gegenwart dauert an.",rule:"seit + Dativ = seit einem Zeitpunkt"},
  {q:"Ergänze: 'Er fährt ___ Montag in den Urlaub.'",opts:["am","an dem","im","den"],correct:0,expl:"'am Montag' = an dem Montag (Wochentag im Dativ).",rule:"am + Wochentag"},
  {q:"Ergänze: 'Das Konzert findet ___ 8 Uhr statt.'",opts:["um","an","bei","in"],correct:0,expl:"'um 8 Uhr' = genaue Uhrzeit.",rule:"um + Uhrzeit"},
  {q:"Ergänze: 'Ich stehe ___ Morgens früh auf.'",opts:["jeden","jedes","jedem","jeder"],correct:0,expl:"'jeden Morgen' = Akkusativ bei Zeitangaben.",rule:"jeden Morgen = Akkusativ"},
  {q:"Ergänze: 'Sie kauft das Gemüse ___ Markt.'",opts:["auf dem","auf den","am","in dem"],correct:0,expl:"'auf dem Markt' = Dativ bei Ort.",rule:"auf dem Markt = Ortsangabe"},
  {q:"Ergänze: 'Ich habe das Paket ___ Post geschickt.'",opts:["mit der","mit die","per","durch"],correct:0,expl:"'mit der Post' = Versandweg.",rule:"mit der Post"},
  {q:"Ergänze: 'Er sitzt ___ Sofa und schaut Fernsehen.'",opts:["auf dem","auf den","im","in dem"],correct:0,expl:"'auf dem Sofa' = sitzen auf + Dativ.",rule:"auf dem Sofa = Dativ"},
  {q:"Ergänze: 'Sie hängt das Bild ___ Wand.'",opts:["an die","an der","auf die","auf der"],correct:0,expl:"'an die Wand hängen' = Bewegung/Richtung → Akkusativ.",rule:"an + Akkusativ (Bewegung)"},
  {q:"Ergänze: 'Das Bild hängt ___ Wand.'",opts:["an der","an die","auf der","auf die"],correct:0,expl:"'an der Wand hängen' = Ort/Position → Dativ.",rule:"an + Dativ (Position)"},
  {q:"Ergänze: 'Er stellt das Glas ___ Tisch.'",opts:["auf den","auf dem","an den","in den"],correct:0,expl:"'auf den Tisch stellen' = Bewegung → Akkusativ.",rule:"auf + Akkusativ (Richtung)"},
  {q:"Ergänze: 'Das Glas steht ___ Tisch.'",opts:["auf dem","auf den","an dem","in dem"],correct:0,expl:"'auf dem Tisch stehen' = Position → Dativ.",rule:"auf + Dativ (Ort)"},
  {q:"Ergänze: 'Ich lege das Buch ___ Regal.'",opts:["ins","in das","in dem","im"],correct:0,expl:"'ins Regal legen' = Bewegung → ins = in das (Akkusativ).",rule:"ins = in das (Akkusativ, Bewegung)"},
  {q:"Ergänze: 'Das Buch liegt ___ Regal.'",opts:["im","in das","ins","in dem"],correct:0,expl:"'im Regal liegen' = Position → im = in dem (Dativ).",rule:"im = in dem (Dativ, Ort)"},
  {q:"Ergänze: 'Sie geht ___ Schule zu Fuß.'",opts:["zur","zu der","in die","in der"],correct:0,expl:"'zur Schule gehen' = zur = zu der.",rule:"zur Schule = zu der Schule"},
  {q:"Ergänze: 'Ich lerne ___ Prüfung.'",opts:["für die","für der","auf die","auf der"],correct:0,expl:"'lernen für' = Zweck.",rule:"für + Akkusativ (Zweck)"},
  {q:"Ergänze: 'Sie spielt ___ Geige.'",opts:["Geige","die Geige","auf der Geige","auf die Geige"],correct:2,expl:"'auf der Geige spielen' = Musikinstrument.",rule:"auf + Dativ bei Instrumenten"},
  {q:"Ergänze: 'Er arbeitet ___ der Universität.'",opts:["an","auf","bei","in"],correct:0,expl:"'an der Universität arbeiten' = Beschäftigungsort.",rule:"an der Universität"},
  {q:"Ergänze: 'Ich bin ___ Deutschland aufgewachsen.'",opts:["in","nach","bei","an"],correct:0,expl:"'in Deutschland aufwachsen' = Ort.",rule:"in + Land"},
  {q:"Ergänze: 'Er ist ___ dem Hund spazieren gegangen.'",opts:["mit","bei","auf","an"],correct:0,expl:"'mit dem Hund spazieren gehen' = Begleitung.",rule:"mit + Dativ (Begleitung)"},
  {q:"Ergänze: 'Sie hat ___ Hunger gegessen.'",opts:["trotz","obwohl","obgleich","ohne"],correct:0,expl:"'trotz Hunger' = obwohl sie Hunger hatte.",rule:"trotz + Genitiv (konzessiv)"},
  {q:"Ergänze: 'Ich rufe dich ___ dem Abendessen an.'",opts:["nach","nach dem","vor","vor dem"],correct:1,expl:"'nach dem Abendessen' = Zeitpunkt nach etwas.",rule:"nach dem + Nomen"},
  {q:"Ergänze: 'Er hat ___ dem Essen ein Dessert bestellt.'",opts:["nach","nach dem","vor","vor dem"],correct:3,expl:"'vor dem Essen' = Zeitpunkt vor etwas.",rule:"vor dem + Nomen"},
  {q:"Ergänze: 'Sie fährt ___ dem Fahrrad zur Arbeit.'",opts:["mit","auf","per","an"],correct:0,expl:"'mit dem Fahrrad' = Transportmittel.",rule:"mit + Dativ (Transportmittel)"},
  {q:"Ergänze: 'Ich komme ___ einer Stunde.'",opts:["in","nach","vor","seit"],correct:0,expl:"'in einer Stunde' = nach einer Zeitspanne.",rule:"in + Dativ = Zeitspanne"},
  {q:"Ergänze: 'Er hat ___ Freude geholfen.'",opts:["mit","vor","aus","nach"],correct:2,expl:"'aus Freude' = aus einem Gefühl heraus.",rule:"aus + Dativ (Grund/Motiv)"},
  {q:"Ergänze: 'Sie hat ___ Versehen das falsche Buch mitgenommen.'",opts:["aus","mit","von","durch"],correct:0,expl:"'aus Versehen' = unabsichtlich.",rule:"aus Versehen = unabsichtlich"},
  {q:"Ergänze: 'Ich verstehe das ___ Schwierigkeiten.'",opts:["ohne","mit","trotz","durch"],correct:0,expl:"'ohne Schwierigkeiten' = problemlos.",rule:"ohne + Akkusativ"},
  {q:"Ergänze: 'Er spricht ___ Akzent Deutsch.'",opts:["mit","ohne","durch","bei"],correct:1,expl:"'ohne Akzent' = akzentfrei.",rule:"ohne + Akkusativ"},
  {q:"Ergänze: 'Sie hat ___ Regen draußen gewartet.'",opts:["trotz des","trotz dem","wegen des","wegen dem"],correct:0,expl:"'trotz des Regens' = obwohl es regnete (Genitiv).",rule:"trotz + Genitiv"},
  {q:"Ergänze: 'Er ist ___ Krankheit ins Büro gegangen.'",opts:["trotz","trotz der","wegen","wegen der"],correct:1,expl:"'trotz der Krankheit' = obwohl er krank war.",rule:"trotz + Genitiv (mit Artikel)"},
  {q:"Ergänze: 'Ich habe ___ Stress viel zu tun.'",opts:["wegen des","trotz des","durch","infolge"],correct:0,expl:"'wegen des Stresses' = aufgrund von Stress.",rule:"wegen + Genitiv"},
  {q:"Ergänze: 'Sie bleibt ___ des schlechten Wetters zu Hause.'",opts:["wegen","trotz","durch","infolge"],correct:0,expl:"'wegen des schlechten Wetters' = aufgrund.",rule:"wegen + Genitiv"},
  {q:"Ergänze: 'Er hat ___ das Ergebnis gefreut.'",opts:["sich über","sich für","sich auf","sich von"],correct:0,expl:"'sich freuen über' = Freude über etwas.",rule:"sich freuen über + Akkusativ"},
  {q:"Ergänze: 'Sie hat ___ neue Aufgabe gut gemeistert.'",opts:["die","der","dem","das"],correct:0,expl:"'die Aufgabe' = feminin Akkusativ → die.",rule:"Akkusativ feminin: die"},
  {q:"Ergänze: 'Ich habe ___ neuen Kollegen vorgestellt.'",opts:["dem","den","der","die"],correct:0,expl:"'dem Kollegen' = maskulin Dativ.",rule:"Dativ maskulin: dem"},
  {q:"Ergänze: 'Er hilft ___ alten Dame mit dem Gepäck.'",opts:["der","die","dem","den"],correct:0,expl:"'helfen' + Dativ: 'der alten Dame' (feminin Dativ).",rule:"helfen + Dativ"},
  {q:"Ergänze: 'Sie kauft ___ Hund ein Spielzeug.'",opts:["ihrem","ihren","ihrer","ihr"],correct:0,expl:"'ihrem Hund' = Dativ maskulin.",rule:"Dativ maskulin: ihrem"},
  {q:"Ergänze: 'Das Kind gibt ___ Mutter die Blumen.'",opts:["der","die","dem","den"],correct:0,expl:"'der Mutter' = feminin Dativ.",rule:"Dativ feminin: der"},
  {q:"Ergänze: '___ Morgen bin ich sehr müde.'",opts:["Jeden","Jeder","Jedes","Jedem"],correct:0,expl:"'Jeden Morgen' = Akkusativ bei Zeitangaben.",rule:"jeden Morgen (Akkusativ)"},
  {q:"Ergänze: 'Sie hat das Problem ___ gelöst.'",opts:["selbst","selber","alleine","eigenständig"],correct:0,expl:"'selbst' = eigenständig, ohne Hilfe.",rule:"selbst = eigenständig"},
  {q:"Ergänze: 'Ich habe ___ Wochen lang auf Antwort gewartet.'",opts:["mehrere","mehreren","manche","einige"],correct:0,expl:"'mehrere Wochen' = mehr als zwei Wochen.",rule:"mehrere + Plural"},
  {q:"Ergänze: 'Er hat die Hausaufgaben ___ gemacht.'",opts:["nicht","nie","kein","nichts"],correct:0,expl:"'nicht gemacht' = Verneinung des Verbs.",rule:"Verneinung: nicht"},
  {q:"Ergänze: 'Sie liest ___ Bücher als ihr Bruder.'",opts:["mehr","mehrere","viele","meisten"],correct:0,expl:"'mehr Bücher' = Komparativ von viel.",rule:"Komparativ: mehr"},
  {q:"Ergänze: 'Das ist ___ interessanteste Film des Jahres.'",opts:["der","die","das","den"],correct:0,expl:"'der interessanteste Film' = maskulin Nominativ Superlativ.",rule:"Superlativ maskulin Nominativ: der"},
  {q:"Ergänze: 'Ich habe ___ Konzert nicht gefallen.'",opts:["das","dem","die","den"],correct:1,expl:"'das Konzert hat mir gefallen' → 'dem Konzert' ist nicht richtig; 'das Konzert gefällt mir' — hier Nominativ: Das Konzert hat mir nicht gefallen.",rule:"gefallen + Dativ"},
  {q:"Ergänze: 'Er erklärt ___ Kindern die Regeln.'",opts:["den","die","dem","der"],correct:0,expl:"'den Kindern' = Dativ Plural.",rule:"Dativ Plural: den"},
  {q:"Ergänze: 'Sie wartet ___ Ende der Veranstaltung.'",opts:["auf das","auf dem","bis zum","an das"],correct:2,expl:"'bis zum Ende' = bis zu einem Zeitpunkt.",rule:"bis zum + Dativ"},
  {q:"Ergänze: 'Ich spreche ___ Englisch und Deutsch.'",opts:["sowohl","beides","auch","weder"],correct:0,expl:"'sowohl ... als auch' = beide Sprachen.",rule:"sowohl ... als auch"},
  {q:"Ergänze: 'Er hat ___ Rat nicht befolgt.'",opts:["meinen","mein","mir","meinem"],correct:0,expl:"'meinen Rat' = maskulin Akkusativ.",rule:"Akkusativ maskulin: meinen"},
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
console.log('lueckentext remaining dups:', countDups());
