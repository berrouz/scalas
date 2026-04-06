import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b1-umformung-p2-001",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Der Koch bereitet das Abendessen vor.'",
    "options": [
      "Das Abendessen wird vom Koch vorbereitet.",
      "Das Abendessen ist vom Koch vorbereitet.",
      "Das Abendessen vorbereitet vom Koch wird.",
      "Vom Koch das Abendessen vorbereitet wird."
    ],
    "correctAnswer": 0,
    "explanation": "Trennbares Verb: 'vorbereiten' → P.II 'vorbereitet'. Passiv Präsens: 'wird vorbereitet'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-002",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Studenten schreiben eine Klausur.'",
    "options": [
      "Eine Klausur wird geschrieben.",
      "Eine Klausur wird von den Studenten geschrieben.",
      "Eine Klausur ist von den Studenten geschrieben.",
      "Von den Studenten eine Klausur geschrieben wird."
    ],
    "correctAnswer": 1,
    "explanation": "Vollständiges Passiv mit Agens: 'von den Studenten'. Präsens: 'wird geschrieben'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-003",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Man darf hier nicht rauchen.'",
    "options": [
      "Hier darf nicht geraucht werden.",
      "Hier wird nicht geraucht.",
      "Hier ist nicht geraucht worden.",
      "Hier raucht nicht gedurft werden."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv mit Modalverb: Modalverb + P.II + 'werden'. 'man' entfällt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-004",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Verkäuferin bedient die Kunden.'",
    "options": [
      "Die Kunden werden von der Verkäuferin bedient.",
      "Die Kunden sind von der Verkäuferin bedient.",
      "Die Kunden bedienen von der Verkäuferin.",
      "Von der Verkäuferin die Kunden bedient werden."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'werden bedient'. Agens: 'von der Verkäuferin'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-005",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Der Briefträger brachte das Paket.'",
    "options": [
      "Das Paket wurde vom Briefträger gebracht.",
      "Das Paket wird vom Briefträger gebracht.",
      "Das Paket ist vom Briefträger gebracht.",
      "Das Paket brachte vom Briefträger."
    ],
    "correctAnswer": 0,
    "explanation": "Präteritum Aktiv → Präteritum Passiv: 'wurde' + P.II ('gebracht').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-006",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Das Fenster wird vom Vater geputzt.'",
    "options": [
      "Der Vater putzt das Fenster.",
      "Das Fenster putzt den Vater.",
      "Der Vater wird das Fenster putzen.",
      "Das Fenster wird den Vater putzen."
    ],
    "correctAnswer": 0,
    "explanation": "'vom Vater' (Agens) → Subjekt. 'Das Fenster' → Akkusativobjekt. Präsens: 'putzt'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-007",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Die E-Mail wurde von der Chefin geschickt.'",
    "options": [
      "Die Chefin schickte die E-Mail.",
      "Die E-Mail schickte die Chefin.",
      "Die Chefin wurde die E-Mail schicken.",
      "Die Chefin hat die E-Mail geschickt."
    ],
    "correctAnswer": 0,
    "explanation": "Präteritum Passiv → Präteritum Aktiv: 'wurde geschickt' → 'schickte'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-008",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Die Blumen werden von der Nachbarin gegossen.'",
    "options": [
      "Die Nachbarin gießt die Blumen.",
      "Die Blumen gießen die Nachbarin.",
      "Die Nachbarin wird die Blumen gießen.",
      "Die Blumen gießt die Nachbarin."
    ],
    "correctAnswer": 0,
    "explanation": "'von der Nachbarin' → Subjekt. 'gießen' im Präsens mit Subjekt 3. Person: 'gießt'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-009",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Er sagt: 'Ich habe das Buch gelesen.''",
    "options": [
      "Er sagt, er habe das Buch gelesen.",
      "Er sagt, er hat das Buch gelesen.",
      "Er sagt, er hätte das Buch gelesen.",
      "Er sagt, dass er das Buch gelesen hat."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt in indirekter Rede: Konjunktiv I von 'haben' = 'habe'. P.II bleibt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-010",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Die Lehrerin fragt: 'Wann habt ihr die Aufgabe gemacht?''",
    "options": [
      "Die Lehrerin fragt, wann wir die Aufgabe gemacht hätten.",
      "Die Lehrerin fragt, wann wir die Aufgabe gemacht haben.",
      "Die Lehrerin fragt, ob wir die Aufgabe gemacht haben.",
      "Die Lehrerin fragt, wann hätten wir die Aufgabe gemacht."
    ],
    "correctAnswer": 1,
    "explanation": "W-Frage → Fragewort bleibt. Verb am Ende. Indikativ ist hier auch möglich.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-011",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Maria sagt: 'Ich kann gut schwimmen.''",
    "options": [
      "Maria sagt, sie könne gut schwimmen.",
      "Maria sagt, sie kann gut schwimmen.",
      "Maria sagt, sie konnte gut schwimmen.",
      "Maria sagt, dass sie gut schwimmen könne."
    ],
    "correctAnswer": 0,
    "explanation": "Konjunktiv I von 'können': 'könne'. Infinitiv 'schwimmen' bleibt am Ende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-012",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Tom fragt: 'Wie alt bist du?''",
    "options": [
      "Tom fragt, wie alt ich sei.",
      "Tom fragt, ob alt ich bin.",
      "Tom fragt, wie alt bin ich.",
      "Tom fragt, dass wie alt ich sei."
    ],
    "correctAnswer": 0,
    "explanation": "W-Frage: Fragewort 'wie alt' bleibt. Konjunktiv I: 'sei'. Verb am Ende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-013",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Während er kocht, hört er Musik.'",
    "options": [
      "Er kocht. Gleichzeitig hört er Musik.",
      "Er kocht. Danach hört er Musik.",
      "Er kocht, während hört er Musik.",
      "Er kocht. Deshalb hört er Musik."
    ],
    "correctAnswer": 0,
    "explanation": "'während' (temporal/gleichzeitig) → 'gleichzeitig'. Zwei parallele Handlungen.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-014",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Seitdem er Sport treibt, fühlt er sich besser.'",
    "options": [
      "Er treibt Sport. Seitdem fühlt er sich besser.",
      "Er treibt Sport. Deshalb fühlt er sich besser.",
      "Er treibt Sport. Trotzdem fühlt er sich besser.",
      "Er treibt Sport, seitdem fühlt er sich besser."
    ],
    "correctAnswer": 0,
    "explanation": "'seitdem' kann auch als Satzadverb in einem Hauptsatz stehen: 'Seitdem fühlt er sich besser.'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-015",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Falls es morgen regnet, bleiben wir zu Hause.'",
    "options": [
      "Es regnet morgen vielleicht. Dann bleiben wir zu Hause.",
      "Es regnet morgen. Deshalb bleiben wir zu Hause.",
      "Es regnet morgen. Trotzdem bleiben wir zu Hause.",
      "Es regnet morgen, falls bleiben wir zu Hause."
    ],
    "correctAnswer": 0,
    "explanation": "'falls' (konditional) → 'vielleicht ... dann' drückt die Bedingung als Hauptsatz aus.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-016",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Sobald die Sonne scheint, gehen wir raus.'",
    "options": [
      "Die Sonne scheint. Dann gehen wir sofort raus.",
      "Die Sonne scheint. Deshalb gehen wir raus.",
      "Die Sonne scheint. Trotzdem gehen wir raus.",
      "Die Sonne scheint, sobald gehen wir raus."
    ],
    "correctAnswer": 0,
    "explanation": "'sobald' (temporal) → 'dann ... sofort'. Die unmittelbare Folge wird ausgedrückt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-017",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Er weiß die Antwort nicht. Er kann nicht antworten.'",
    "options": [
      "Wenn er die Antwort wüsste, könnte er antworten.",
      "Wenn er die Antwort weiß, könnte er antworten.",
      "Wenn er die Antwort wüsste, kann er antworten.",
      "Wenn er die Antwort wüsste, wird er antworten."
    ],
    "correctAnswer": 0,
    "explanation": "'wüsste' (Konj. II von 'wissen') + 'könnte' (Konj. II von 'können').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-018",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Das Wetter ist schlecht. Wir gehen nicht wandern.'",
    "options": [
      "Wenn das Wetter besser wäre, würden wir wandern gehen.",
      "Wenn das Wetter besser ist, gehen wir wandern.",
      "Wenn das Wetter besser wäre, gehen wir wandern.",
      "Wenn das Wetter besser wäre, werden wir wandern gehen."
    ],
    "correctAnswer": 0,
    "explanation": "'wäre' (Konj. II von 'sein') + 'würden ... gehen' (Konj. II mit 'würde').",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-019",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II: 'Ich habe keine Zeit.' → Wunschsatz",
    "options": [
      "Hätte ich doch mehr Zeit!",
      "Habe ich doch mehr Zeit!",
      "Wenn ich mehr Zeit habe!",
      "Ich hätte doch mehr Zeit."
    ],
    "correctAnswer": 0,
    "explanation": "Wunschsatz ohne 'wenn': Konjunktiv II am Satzanfang + 'doch': 'Hätte ich doch ...!'",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-020",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Die Lehrerin ist streng. Wir mögen sie trotzdem.'",
    "options": [
      "Die Lehrerin, die wir trotzdem mögen, ist streng.",
      "Die Lehrerin, der wir trotzdem mögen, ist streng.",
      "Die Lehrerin, den wir trotzdem mögen, ist streng.",
      "Die Lehrerin, welche wir trotzdem mögen, ist streng."
    ],
    "correctAnswer": 0,
    "explanation": "'sie' = Akkusativ feminin → Relativpronomen 'die'. 'mögen' + Akkusativ.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-021",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Der Arzt ist berühmt. Ich war bei ihm.'",
    "options": [
      "Der Arzt, bei dem ich war, ist berühmt.",
      "Der Arzt, bei den ich war, ist berühmt.",
      "Der Arzt, bei der ich war, ist berühmt.",
      "Der Arzt, wo ich war, ist berühmt."
    ],
    "correctAnswer": 0,
    "explanation": "'bei ihm' → Präposition 'bei' + Dativ maskulin → Relativpronomen 'dem'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-022",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Die Kinder spielen draußen. Ihre Eltern arbeiten.'",
    "options": [
      "Die Kinder, deren Eltern arbeiten, spielen draußen.",
      "Die Kinder, denen Eltern arbeiten, spielen draußen.",
      "Die Kinder, die Eltern arbeiten, spielen draußen.",
      "Die Kinder, welche Eltern arbeiten, spielen draußen."
    ],
    "correctAnswer": 0,
    "explanation": "'ihre' = Genitiv Plural → Relativpronomen 'deren'. Genitiv-Relativsatz zeigt Besitz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-023",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Man muss die Umwelt schützen.' → Nomen",
    "options": [
      "Der Schutz der Umwelt ist notwendig.",
      "Das Schützen der Umwelt ist notwendig.",
      "Die Schützung der Umwelt ist notwendig.",
      "Der Umweltschutz ist notwendig."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'schützen' → Nomen 'der Schutz'. 'der Umwelt' = Genitiv.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-024",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Sie trainiert regelmäßig.' → Nomen",
    "options": [
      "Ihr regelmäßiges Training.",
      "Ihre regelmäßige Trainierung.",
      "Ihr regelmäßig Training.",
      "Ihre Regelmäßigkeit im Training."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'trainieren' → Nomen 'das Training'. Adverb → Adjektiv: 'regelmäßiges'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-025",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Er hat sich beworben.' → Nomen",
    "options": [
      "Seine Bewerbung.",
      "Sein Bewerben.",
      "Seine Bewerberei.",
      "Sein Bewerbnis."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'sich bewerben' → Nomen 'die Bewerbung' (Suffix -ung, feminin).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-026",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Superlativ bilden: 'Der Rhein ist lang. Die Donau ist am ...'",
    "options": [
      "Die Donau ist am längsten.",
      "Die Donau ist am langsten.",
      "Die Donau ist die längste.",
      "Die Donau ist mehr lang."
    ],
    "correctAnswer": 0,
    "explanation": "Superlativ von 'lang' → 'am längsten' (mit Umlaut). Prädikativ: 'am + -sten'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-027",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Im Sommer ist es warm. Im Winter ist es kalt.' → Vergleich",
    "options": [
      "Im Sommer ist es wärmer als im Winter.",
      "Im Sommer ist es warmer als im Winter.",
      "Im Sommer ist es mehr warm als im Winter.",
      "Im Sommer ist es am wärmsten als im Winter."
    ],
    "correctAnswer": 0,
    "explanation": "Komparativ von 'warm' → 'wärmer' (mit Umlaut). Vergleich mit 'als'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-028",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Ich fahre gern Fahrrad. Ich schwimme lieber.' → Superlativ",
    "options": [
      "Am liebsten spiele ich Tennis.",
      "Am gernsten spiele ich Tennis.",
      "Am liebesten spiele ich Tennis.",
      "Ich spiele am meisten gern Tennis."
    ],
    "correctAnswer": 0,
    "explanation": "Unregelmäßig: 'gern' → 'lieber' → 'am liebsten'. Superlativ: 'am liebsten'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-029",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "dass-Satz → Infinitivsatz",
    "question": "dass-Satz → Infinitivsatz: 'Wir planen, dass wir nächstes Jahr umziehen.'",
    "options": [
      "Wir planen, nächstes Jahr umzuziehen.",
      "Wir planen, nächstes Jahr umziehen.",
      "Wir planen, zu nächstes Jahr umziehen.",
      "Wir planen, nächstes Jahr zu umziehen."
    ],
    "correctAnswer": 0,
    "explanation": "Bei trennbaren Verben steht 'zu' zwischen Vorsilbe und Verbstamm: 'umzuziehen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-030",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "dass-Satz → Infinitivsatz",
    "question": "dass-Satz → Infinitivsatz: 'Es ist wichtig, dass man gesund isst.'",
    "options": [
      "Es ist wichtig, gesund zu essen.",
      "Es ist wichtig, gesund essen.",
      "Es ist wichtig, zu gesund essen.",
      "Es ist wichtig, gesund zu isst."
    ],
    "correctAnswer": 0,
    "explanation": "Bei 'es ist wichtig' + gleiches Subjekt ('man') → Infinitivsatz: 'zu essen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-031",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Man muss den Antrag ausfüllen.'",
    "options": [
      "Der Antrag muss ausgefüllt werden.",
      "Der Antrag wird ausgefüllt müssen.",
      "Der Antrag ist ausgefüllt worden.",
      "Den Antrag muss man ausgefüllt werden."
    ],
    "correctAnswer": 0,
    "explanation": "Passiv mit Modalverb: Modalverb + P.II + 'werden' am Ende. 'man' entfällt.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-032",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Der Kellner bringt die Getränke.'",
    "options": [
      "Die Getränke werden vom Kellner gebracht.",
      "Die Getränke sind vom Kellner gebracht.",
      "Die Getränke bringen vom Kellner.",
      "Vom Kellner die Getränke gebracht werden."
    ],
    "correctAnswer": 0,
    "explanation": "Präsens Passiv: 'werden gebracht'. Agens mit 'von' + Dativ: 'vom Kellner'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-033",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Der Kuchen wurde von den Gästen gegessen.'",
    "options": [
      "Die Gäste aßen den Kuchen.",
      "Der Kuchen aß die Gäste.",
      "Die Gäste wurden den Kuchen essen.",
      "Den Kuchen aß von den Gästen."
    ],
    "correctAnswer": 0,
    "explanation": "Präteritum Passiv → Präteritum Aktiv: 'wurde gegessen' → 'aßen' (essen → aß/aßen).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-034",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Das Lied wird von den Kindern gesungen.'",
    "options": [
      "Die Kinder singen das Lied.",
      "Das Lied singt die Kinder.",
      "Die Kinder werden das Lied singen.",
      "Das Lied wird die Kinder singen."
    ],
    "correctAnswer": 0,
    "explanation": "'von den Kindern' → Subjekt. Präsens Passiv → Präsens Aktiv: 'singen'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-035",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Sie sagt: 'Ich muss heute arbeiten.''",
    "options": [
      "Sie sagt, sie müsse heute arbeiten.",
      "Sie sagt, sie muss heute arbeiten.",
      "Sie sagt, sie musste heute arbeiten.",
      "Sie sagt, dass sie heute arbeiten muss."
    ],
    "correctAnswer": 0,
    "explanation": "Konjunktiv I von 'müssen': 'müsse'. Infinitiv 'arbeiten' am Ende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-036",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Er fragt: 'Hast du den Schlüssel?''",
    "options": [
      "Er fragt, ob ich den Schlüssel habe.",
      "Er fragt, dass ich den Schlüssel habe.",
      "Er fragt, wenn ich den Schlüssel habe.",
      "Er fragt, habe ich den Schlüssel."
    ],
    "correctAnswer": 0,
    "explanation": "Ja/Nein-Frage → 'ob'. Konjunktiv I: 'habe'. Verb am Satzende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-037",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Als ich klein war, wohnte ich in Berlin.'",
    "options": [
      "Früher war ich klein. Damals wohnte ich in Berlin.",
      "Ich war klein. Deshalb wohnte ich in Berlin.",
      "Ich war klein. Trotzdem wohnte ich in Berlin.",
      "Ich war klein, als wohnte ich in Berlin."
    ],
    "correctAnswer": 0,
    "explanation": "'als' (temporal, Vergangenheit) → 'früher/damals'. Zwei Hauptsätze im Präteritum.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-038",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Indem er viel liest, verbessert er sein Deutsch.'",
    "options": [
      "Er liest viel. Dadurch verbessert er sein Deutsch.",
      "Er liest viel. Deshalb verbessert er sein Deutsch.",
      "Er liest viel. Trotzdem verbessert er sein Deutsch.",
      "Er liest viel, indem verbessert er sein Deutsch."
    ],
    "correctAnswer": 0,
    "explanation": "'indem' (modal/instrumental) → 'dadurch'. Beschreibt das Mittel zur Verbesserung.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-039",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II: 'Ich kann nicht gut kochen.' → höfliche Bitte",
    "options": [
      "Könntest du mir beim Kochen helfen?",
      "Kannst du mir beim Kochen helfen?",
      "Konntest du mir beim Kochen helfen?",
      "Wirst du mir beim Kochen helfen?"
    ],
    "correctAnswer": 0,
    "explanation": "Höfliche Bitte mit Konjunktiv II: 'könntest' (von 'können'). Wirkt höflicher als Indikativ.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-040",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Konjunktiv II bilden",
    "question": "Konjunktiv II bilden: 'Er hat keinen Urlaub. Er fliegt nicht nach Spanien.'",
    "options": [
      "Wenn er Urlaub hätte, würde er nach Spanien fliegen.",
      "Wenn er Urlaub hat, fliegt er nach Spanien.",
      "Wenn er Urlaub hätte, fliegt er nach Spanien.",
      "Wenn er Urlaub hätte, flöge er nach Spanien."
    ],
    "correctAnswer": 0,
    "explanation": "'hätte' (Konj. II von 'haben') + 'würde fliegen' (Konj. II Umschreibung).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-041",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Der Film war langweilig. Wir haben ihn gestern gesehen.'",
    "options": [
      "Der Film, den wir gestern gesehen haben, war langweilig.",
      "Der Film, der wir gestern gesehen haben, war langweilig.",
      "Der Film, dem wir gestern gesehen haben, war langweilig.",
      "Der Film, was wir gestern gesehen haben, war langweilig."
    ],
    "correctAnswer": 0,
    "explanation": "'ihn' = Akkusativ maskulin → Relativpronomen 'den'. Perfekt im Relativsatz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-042",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Relativsatz bilden",
    "question": "Relativsatz bilden: 'Die Freundin wohnt in München. Ich telefoniere oft mit ihr.'",
    "options": [
      "Die Freundin, mit der ich oft telefoniere, wohnt in München.",
      "Die Freundin, mit die ich oft telefoniere, wohnt in München.",
      "Die Freundin, mit dem ich oft telefoniere, wohnt in München.",
      "Die Freundin, womit ich oft telefoniere, wohnt in München."
    ],
    "correctAnswer": 0,
    "explanation": "'mit ihr' → Präposition 'mit' + Dativ feminin → Relativpronomen 'der'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-043",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Er kann gut singen.' → Nomen",
    "options": [
      "Er hat eine gute Stimme.",
      "Sein gutes Singen.",
      "Seine gute Singung.",
      "Sein Gesang ist gut."
    ],
    "correctAnswer": 3,
    "explanation": "Verb 'singen' → Nomen 'der Gesang'. Alternative Nominalisierung für die Fähigkeit.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-044",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nominalisierung",
    "question": "Nominalisierung: 'Sie entwickelt neue Software.' → Nomen",
    "options": [
      "Die Entwicklung neuer Software.",
      "Das Entwickeln neuer Software.",
      "Die Entwicklung von neue Software.",
      "Ihre Entwickelung neuer Software."
    ],
    "correctAnswer": 0,
    "explanation": "Verb 'entwickeln' → Nomen 'die Entwicklung' (Suffix -ung). 'neuer' = Genitiv Feminin.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-045",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Komparativ bilden",
    "question": "Komparativ bilden: 'Dieses Buch ist interessant. Jenes Buch ist langweilig.'",
    "options": [
      "Dieses Buch ist interessanter als jenes.",
      "Dieses Buch ist mehr interessant als jenes.",
      "Dieses Buch ist interessant als jenes.",
      "Dieses Buch ist am interessantesten als jenes."
    ],
    "correctAnswer": 0,
    "explanation": "Komparativ: 'interessant' → 'interessanter' (regelmäßig). Vergleich mit 'als'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-046",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "dass-Satz → Infinitivsatz",
    "question": "dass-Satz → Infinitivsatz: 'Sie hat vergessen, dass sie einkaufen muss.'",
    "options": [
      "Sie hat vergessen einzukaufen.",
      "Sie hat vergessen, einzukaufen.",
      "Sie hat vergessen, einkaufen.",
      "Sie hat vergessen, zu einkaufen."
    ],
    "correctAnswer": 1,
    "explanation": "Gleiches Subjekt → Infinitivsatz. Trennbares Verb: 'ein-zu-kaufen'. Komma vor dem Infinitivsatz.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-047",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Aktiv → Passiv",
    "question": "Aktiv → Passiv: 'Die Schüler haben die Aufgabe gelöst.'",
    "options": [
      "Die Aufgabe ist von den Schülern gelöst worden.",
      "Die Aufgabe wurde von den Schülern gelöst.",
      "Die Aufgabe wird von den Schülern gelöst.",
      "Die Aufgabe hat von den Schülern gelöst."
    ],
    "correctAnswer": 0,
    "explanation": "Perfekt Aktiv → Perfekt Passiv: 'ist ... gelöst worden' (sein + P.II + worden).",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-048",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Passiv → Aktiv",
    "question": "Passiv → Aktiv: 'Der Computer wird vom Techniker repariert.'",
    "options": [
      "Der Techniker repariert den Computer.",
      "Der Computer repariert den Techniker.",
      "Der Techniker wird den Computer reparieren.",
      "Den Computer repariert vom Techniker."
    ],
    "correctAnswer": 0,
    "explanation": "'vom Techniker' → Subjekt. 'Der Computer' → Akkusativobjekt. Präsens: 'repariert'.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-049",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "direkte → indirekte Rede",
    "question": "direkte → indirekte Rede: 'Der Arzt sagt: 'Sie sollen mehr Sport treiben.''",
    "options": [
      "Der Arzt sagt, ich solle mehr Sport treiben.",
      "Der Arzt sagt, ich soll mehr Sport treiben.",
      "Der Arzt sagt, ich sollte mehr Sport treiben.",
      "Der Arzt sagt, dass ich mehr Sport treiben soll."
    ],
    "correctAnswer": 0,
    "explanation": "Konjunktiv I von 'sollen': 'solle'. Infinitiv 'treiben' am Ende.",
    "tags": ["umformung", "grammatik"]
  },
  {
    "language": "german", "id": "b1-umformung-p2-050",
    "level": "b1",
    "category": "Umformung",
    "subcategory": "Nebensatz → Hauptsatz",
    "question": "Nebensatz → Hauptsatz: 'Während er studiert, arbeitet er nebenbei.'",
    "options": [
      "Er studiert. Gleichzeitig arbeitet er nebenbei.",
      "Er studiert. Deshalb arbeitet er nebenbei.",
      "Er studiert. Danach arbeitet er nebenbei.",
      "Er studiert, während arbeitet er nebenbei."
    ],
    "correctAnswer": 0,
    "explanation": "'während' (gleichzeitig) → 'gleichzeitig'. Beide Handlungen finden parallel statt.",
    "tags": ["umformung", "grammatik"]
  }
];

export default questions;
