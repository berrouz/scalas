import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-konnektoren-p3-002",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'indem'?",
    "options": [
      "Infinitivsatz",
      "Inversion (Verb-Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz (Verb auf Position 2)"
    ],
    "correctAnswer": 2,
    "explanation": "'indem' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "nebensatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-004",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'nicht nur ... ___ ...'",
    "options": [
      "oder",
      "als auch",
      "sondern auch",
      "desto"
    ],
    "correctAnswer": 2,
    "explanation": "Der zweiteilige Konnektor lautet: 'nicht nur ... sondern auch ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-008",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'einerseits ... ___ ...'",
    "options": [
      "aber",
      "als auch",
      "umso",
      "andererseits"
    ],
    "correctAnswer": 3,
    "explanation": "Der zweiteilige Konnektor lautet: 'einerseits ... andererseits ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-009",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'denn'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Hauptsatz (Position 0)",
      "Nebensatz + Nebensatz",
      "Hauptsatz + Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 1,
    "explanation": "'denn' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "hauptsatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-011",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'folglich'?",
    "options": [
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz ohne Inversion",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)"
    ],
    "correctAnswer": 3,
    "explanation": "'folglich' steht auf Position 1, dann folgt Inversion: folglich, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adverb"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-018",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'falls'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Infinitivsatz",
      "Hauptsatz (Verb auf Position 2)",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 3,
    "explanation": "'falls' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "nebensatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-031",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'deshalb'?",
    "options": [
      "Hauptsatz ohne Inversion",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)"
    ],
    "correctAnswer": 3,
    "explanation": "'deshalb' steht auf Position 1, dann folgt Inversion: deshalb, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adverb"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-051",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Die Kinder spielten draußen, ___ es kalt war.'",
    "options": ["weil", "obwohl", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'obwohl' drückt einen konzessiven Widerspruch aus (trotz der Kälte).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-052",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Der Verkehr war dicht. ___ kam er pünktlich an.'",
    "options": ["Deshalb", "Folglich", "Trotzdem", "Daher"],
    "correctAnswer": 2,
    "explanation": "'Trotzdem' drückt eine Handlung entgegen der Erwartung aus (konzessiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-053",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Sie lernt täglich, ___ die Prüfung zu bestehen.'",
    "options": ["damit", "um", "weil", "indem"],
    "correctAnswer": 1,
    "explanation": "'um ... zu + Infinitiv' drückt einen Zweck aus (gleiches Subjekt).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-054",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? '___ er die Nachricht erhielt, rief er sofort zurück.'",
    "options": ["Während", "Als", "Bis", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Als' drückt ein einmaliges Ereignis in der Vergangenheit aus (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-055",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'je höher die Temperatur, ___ schneller verdunstet das Wasser.'",
    "options": ["umso", "als", "wie", "denn"],
    "correctAnswer": 0,
    "explanation": "'je ... desto/umso' drückt eine proportionale Beziehung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-056",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er sprach kein Deutsch. ___ verstand er die Anweisungen nicht.'",
    "options": ["Trotzdem", "Deswegen", "Allerdings", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Deswegen' drückt eine kausale Folge aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-057",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Man kann die Qualität verbessern, ___ man mehr investiert.'",
    "options": ["weil", "obwohl", "indem", "damit"],
    "correctAnswer": 2,
    "explanation": "'indem' beschreibt die Art und Weise/das Mittel (modal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-058",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher nebenordnende Konnektor passt? 'Er spricht Englisch ___ Französisch.'",
    "options": ["aber", "oder", "und", "denn"],
    "correctAnswer": 2,
    "explanation": "'und' verbindet zwei gleichwertige Elemente (kopulativ, Position 0).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "kopulativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-059",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat gearbeitet, ___ die anderen feierten.'",
    "options": ["nachdem", "bevor", "während", "bis"],
    "correctAnswer": 2,
    "explanation": "'während' drückt Gleichzeitigkeit oder einen adversativen Gegensatz aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-060",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Sie hatte Fieber. ___ blieb sie im Bett.'",
    "options": ["Trotzdem", "Darum", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Darum' drückt eine kausale Folge aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-061",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'sowohl das Frühstück ___ das Abendessen sind im Preis inbegriffen.'",
    "options": ["und", "als auch", "oder", "noch"],
    "correctAnswer": 1,
    "explanation": "'sowohl ... als auch' verbindet zwei Elemente additiv.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-062",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? '___ du die Hausaufgaben gemacht hast, darfst du fernsehen.'",
    "options": ["Während", "Nachdem", "Bevor", "Bis"],
    "correctAnswer": 1,
    "explanation": "'Nachdem' drückt Vorzeitigkeit aus (zuerst Hausaufgaben, dann fernsehen).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-063",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er nahm den Job an, ___ das Gehalt niedrig war.'",
    "options": ["weil", "obwohl", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'obwohl' drückt einen konzessiven Widerspruch aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-064",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er hat wenig Erfahrung. ___ zeigt er großes Engagement.'",
    "options": ["Deshalb", "Dennoch", "Folglich", "Daher"],
    "correctAnswer": 1,
    "explanation": "'Dennoch' drückt aus, dass etwas entgegen der Erwartung geschieht.",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-065",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er ging spazieren, ___ nachzudenken.'",
    "options": ["um", "ohne", "anstatt", "damit"],
    "correctAnswer": 0,
    "explanation": "'um ... zu + Infinitiv' drückt den Zweck aus (gleiches Subjekt).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-066",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Die Besprechung wurde verschoben, ___ mehrere Teilnehmer krank waren.'",
    "options": ["obwohl", "weil", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'weil' leitet einen kausalen Nebensatz ein (Grund).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-067",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'weder die Zeit ___ das Geld reichen aus.'",
    "options": ["und", "oder", "noch", "aber"],
    "correctAnswer": 2,
    "explanation": "'weder ... noch' verneint beide Elemente.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-068",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er hat den Termin abgesagt. ___ hat er einen neuen vorgeschlagen.'",
    "options": ["Trotzdem", "Stattdessen", "Deshalb", "Dennoch"],
    "correctAnswer": 1,
    "explanation": "'Stattdessen' drückt eine Ersatzhandlung aus.",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "substitutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-069",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er lernt Deutsch, ___ er eine Stelle in Berlin hat.'",
    "options": ["obwohl", "da", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'da' gibt einen bekannten Grund an (kausal, formeller als 'weil').",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-070",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er hat die Aufgabe erledigt, ___ einen Fehler zu machen.'",
    "options": ["um", "ohne", "anstatt", "damit"],
    "correctAnswer": 1,
    "explanation": "'ohne ... zu + Infinitiv' drückt aus, dass etwas nicht geschehen ist.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-071",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt eine Ergänzung aus? 'Das Hotel ist modern. ___ hat es eine tolle Lage.'",
    "options": ["Dennoch", "Darüber hinaus", "Deshalb", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Darüber hinaus' fügt eine zusätzliche Information hinzu (additiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "additiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-072",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Ich warte hier, ___ du fertig bist.'",
    "options": ["nachdem", "sobald", "bis", "während"],
    "correctAnswer": 2,
    "explanation": "'bis' drückt einen Endpunkt aus (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-073",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Es war so laut, ___ niemand den Redner verstehen konnte.'",
    "options": ["weil", "dass", "obwohl", "damit"],
    "correctAnswer": 1,
    "explanation": "'so ... dass' drückt eine konsekutive Folge aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-074",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor korrigiert? 'Das Buch ist nicht langweilig, ___ es ist sehr spannend.'",
    "options": ["und", "aber", "sondern", "denn"],
    "correctAnswer": 2,
    "explanation": "'sondern' korrigiert nach einer Negation (nicht A, sondern B).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-075",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Die Preise sind gestiegen. ___ kaufen die Leute weniger ein.'",
    "options": ["Trotzdem", "Infolgedessen", "Allerdings", "Dennoch"],
    "correctAnswer": 1,
    "explanation": "'Infolgedessen' drückt eine formelle konsekutive Folge aus.",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-076",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er zu Hause arbeitet, ist er sehr produktiv.'",
    "options": ["Obwohl", "Wenn", "Nachdem", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Wenn' drückt eine Bedingung oder Wiederholung aus (konditional/temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-077",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'entweder wir einigen uns heute ___ wir verschieben die Entscheidung.'",
    "options": ["und", "oder", "noch", "aber"],
    "correctAnswer": 1,
    "explanation": "'entweder ... oder' bietet zwei Alternativen an.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-078",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er sprach leise, ___ die Kinder nicht aufwachten.'",
    "options": ["weil", "damit", "obwohl", "indem"],
    "correctAnswer": 1,
    "explanation": "'damit' drückt einen Zweck aus (final, verschiedene Subjekte).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-079",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Sie hat eine Zusage. ___ muss sie noch den Vertrag unterschreiben.'",
    "options": ["Deshalb", "Allerdings", "Folglich", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Allerdings' schränkt die vorherige Aussage ein (adversativ).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-080",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ die Sonne unterging, wurde es schnell kalt.'",
    "options": ["Während", "Sobald", "Obwohl", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Sobald' drückt eine unmittelbare zeitliche Abfolge aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-081",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ zu arbeiten, sah er den ganzen Tag fern.'",
    "options": ["Um", "Ohne", "Anstatt", "Damit"],
    "correctAnswer": 2,
    "explanation": "'anstatt ... zu + Infinitiv' drückt eine Ersatzhandlung aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "substitutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-082",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Der Plan war gut. ___ scheiterte er an der Umsetzung.'",
    "options": ["Deshalb", "Dennoch", "Folglich", "Daher"],
    "correctAnswer": 1,
    "explanation": "'Dennoch' drückt eine konzessive Handlung aus (entgegen der Erwartung).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-083",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat das Buch gelesen, ___ er eine Buchbesprechung schreiben musste.'",
    "options": ["obwohl", "weil", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'weil' gibt den Grund an (kausal, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-084",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Es ist wichtig, ___ Sie den Antrag rechtzeitig einreichen.'",
    "options": ["weil", "dass", "obwohl", "damit"],
    "correctAnswer": 1,
    "explanation": "'dass' leitet einen Inhaltssatz ein (Nebensatz, Verb am Ende).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "inhaltssatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-085",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'zwar war das Wetter schlecht, ___ wir hatten trotzdem Spaß.'",
    "options": ["und", "aber", "oder", "denn"],
    "correctAnswer": 1,
    "explanation": "'zwar ... aber' drückt eine konzessive Einschränkung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-086",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er den Unfall gesehen hatte, rief er sofort die Polizei.'",
    "options": ["Während", "Bevor", "Nachdem", "Bis"],
    "correctAnswer": 2,
    "explanation": "'Nachdem' + Plusquamperfekt drückt Vorzeitigkeit aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-087",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Das Projekt war erfolgreich. ___ gab es einige Schwierigkeiten.'",
    "options": ["Deshalb", "Folglich", "Allerdings", "Daher"],
    "correctAnswer": 2,
    "explanation": "'Allerdings' drückt einen einschränkenden Gegensatz aus (adversativ).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-088",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Man kann Deutsch lernen, ___ man regelmäßig übt.'",
    "options": ["weil", "indem", "damit", "obwohl"],
    "correctAnswer": 1,
    "explanation": "'indem' beschreibt die Art und Weise (modal/instrumental).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-089",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Wir bleiben zu Hause, ___ das Wetter besser wird.'",
    "options": ["nachdem", "sobald", "bis", "während"],
    "correctAnswer": 2,
    "explanation": "'bis' drückt einen Endpunkt aus (temporal, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-090",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'entweder du kommst jetzt ___ du bleibst zu Hause.'",
    "options": ["und", "aber", "oder", "noch"],
    "correctAnswer": 2,
    "explanation": "'entweder ... oder' bietet zwei Alternativen an.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-091",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Der Zug hatte Verspätung. ___ verpassten wir den Anschluss.'",
    "options": ["Dennoch", "Deshalb", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Deshalb' drückt eine kausale Folge aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-092",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er spricht leise, ___ die Kinder nicht aufwachen.'",
    "options": ["weil", "damit", "obwohl", "indem"],
    "correctAnswer": 1,
    "explanation": "'damit' leitet einen finalen Nebensatz ein (Zweck).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p3-093",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher nebenordnende Konnektor verbindet gleichwertig? 'Sie singt ___ er spielt Gitarre.'",
    "options": ["aber", "oder", "denn", "und"],
    "correctAnswer": 3,
    "explanation": "'und' verbindet zwei gleichwertige Aussagen (kopulativ, Position 0).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "kopulativ"]
  }
];

export default questions;
