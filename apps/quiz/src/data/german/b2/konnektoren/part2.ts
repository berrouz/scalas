import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-konnektoren-p2-013",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'oder'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Hauptsatz (Position 0)",
      "Hauptsatz + Nebensatz (Verb am Ende)",
      "Nebensatz + Nebensatz"
    ],
    "correctAnswer": 1,
    "explanation": "'oder' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "hauptsatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-015",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'jedoch'?",
    "options": [
      "Hauptsatz ohne Inversion",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Infinitivsatz"
    ],
    "correctAnswer": 2,
    "explanation": "'jedoch' steht auf Position 1, dann folgt Inversion: jedoch, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adverb"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-018",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'bis'?",
    "options": [
      "Infinitivsatz",
      "Inversion (Verb-Subjekt)",
      "Hauptsatz (Verb auf Position 2)",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 3,
    "explanation": "'bis' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "nebensatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-023",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'deshalb'?",
    "options": [
      "Infinitivsatz",
      "Hauptsatz ohne Inversion",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)"
    ],
    "correctAnswer": 3,
    "explanation": "'deshalb' steht auf Position 1, dann folgt Inversion: deshalb, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adverb"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-034",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'während'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz (Verb auf Position 2)"
    ],
    "correctAnswer": 1,
    "explanation": "'während' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "nebensatz"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-051",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat nicht angerufen, ___ er es versprochen hatte.'",
    "options": ["weil", "obwohl", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'obwohl' drückt einen konzessiven Widerspruch aus (trotz des Versprechens).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-052",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Ich gehe joggen, ___ fit zu bleiben.'",
    "options": ["damit", "um", "weil", "indem"],
    "correctAnswer": 1,
    "explanation": "'um ... zu + Infinitiv' drückt einen Zweck aus (gleiches Subjekt).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-053",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Die Ergebnisse waren enttäuschend. ___ geben wir nicht auf.'",
    "options": ["Deshalb", "Folglich", "Trotzdem", "Außerdem"],
    "correctAnswer": 2,
    "explanation": "'Trotzdem' drückt aus, dass man entgegen der Erwartung handelt (konzessiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-054",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ der Lehrer sprach, machten die Schüler Notizen.'",
    "options": ["Nachdem", "Während", "Bevor", "Bis"],
    "correctAnswer": 1,
    "explanation": "'Während' drückt Gleichzeitigkeit aus (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-055",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'entweder du kommst mit ___ du bleibst hier.'",
    "options": ["und", "oder", "noch", "aber"],
    "correctAnswer": 1,
    "explanation": "'entweder ... oder' bietet zwei Alternativen an.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-056",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Man kann Geld sparen, ___ man weniger ausgibt.'",
    "options": ["weil", "obwohl", "indem", "damit"],
    "correctAnswer": 2,
    "explanation": "'indem' beschreibt die Art und Weise/das Mittel (modal, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-057",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Der Flug wurde gestrichen. ___ mussten wir den Zug nehmen.'",
    "options": ["Dennoch", "Infolgedessen", "Allerdings", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Infolgedessen' drückt eine logische Konsequenz aus (konsekutiv, formell).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-058",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ du dich entscheidest, teile es mir mit.'",
    "options": ["Nachdem", "Sobald", "Obwohl", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Sobald' drückt aus, dass eine Handlung unmittelbar folgt (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-059",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Sie ist nicht gekommen, ___ sie war krank.'",
    "options": ["aber", "oder", "denn", "sondern"],
    "correctAnswer": 2,
    "explanation": "'denn' gibt einen Grund an (kausal, Position 0, Hauptsatz + Hauptsatz).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-060",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'weder er ___ sie konnten sich erinnern.'",
    "options": ["und", "oder", "noch", "aber"],
    "correctAnswer": 2,
    "explanation": "'weder ... noch' verneint beide Teile.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-061",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er hat viel gelernt. ___ hat er die Prüfung nicht bestanden.'",
    "options": ["Deshalb", "Dennoch", "Folglich", "Daher"],
    "correctAnswer": 1,
    "explanation": "'Dennoch' drückt aus, dass etwas entgegen der Erwartung geschieht (konzessiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-062",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er ist so müde, ___ er kaum die Augen offen halten kann.'",
    "options": ["weil", "dass", "obwohl", "damit"],
    "correctAnswer": 1,
    "explanation": "'so ... dass' drückt eine konsekutive Folge aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-063",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? '___ er die E-Mail geschrieben hatte, schickte er sie ab.'",
    "options": ["Während", "Nachdem", "Bevor", "Bis"],
    "correctAnswer": 1,
    "explanation": "'Nachdem' drückt Vorzeitigkeit aus (temporal, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-064",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ zu telefonieren, schrieb er eine E-Mail.'",
    "options": ["Um", "Ohne", "Anstatt", "Damit"],
    "correctAnswer": 2,
    "explanation": "'anstatt ... zu + Infinitiv' drückt eine Ersatzhandlung aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "substitutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-065",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Die Miete ist günstig. ___ liegt die Wohnung zentral.'",
    "options": ["Trotzdem", "Stattdessen", "Außerdem", "Dennoch"],
    "correctAnswer": 2,
    "explanation": "'Außerdem' fügt eine zusätzliche positive Information hinzu (additiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "additiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-066",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er ging nach Hause, ___ er sich ausruhen konnte.'",
    "options": ["indem", "damit", "obwohl", "falls"],
    "correctAnswer": 1,
    "explanation": "'damit' leitet einen finalen Nebensatz ein (Zweck).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-067",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er ist nicht dumm, ___ er ist nur faul.'",
    "options": ["und", "aber", "sondern", "denn"],
    "correctAnswer": 2,
    "explanation": "'sondern' korrigiert nach einer Negation (nicht A, sondern B).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-068",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'je länger man wartet, ___ schwieriger wird die Lösung.'",
    "options": ["umso", "als", "wie", "so"],
    "correctAnswer": 0,
    "explanation": "'je ... desto/umso' drückt eine proportionale Beziehung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-069",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er hat den Termin vergessen. ___ war sein Chef verärgert.'",
    "options": ["Trotzdem", "Deshalb", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Deshalb' drückt eine kausale Folge aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-070",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ du ankommst, ruf mich bitte an.'",
    "options": ["Nachdem", "Bevor", "Sobald", "Bis"],
    "correctAnswer": 2,
    "explanation": "'Sobald' drückt eine unmittelbare zeitliche Abfolge aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-071",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er ging zur Arbeit, ___ er sich nicht gut fühlte.'",
    "options": ["weil", "obwohl", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'obwohl' drückt einen konzessiven Gegensatz aus (Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-072",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er verließ das Büro, ___ ein Wort zu sagen.'",
    "options": ["um", "ohne", "anstatt", "damit"],
    "correctAnswer": 1,
    "explanation": "'ohne ... zu + Infinitiv' drückt aus, dass etwas nicht getan wurde.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-073",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Das Angebot ist verlockend. ___ sollte man die Risiken bedenken.'",
    "options": ["Deshalb", "Allerdings", "Folglich", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Allerdings' drückt eine Einschränkung/einen Gegensatz aus (adversativ).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-074",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'sowohl die Eltern ___ die Lehrer waren einverstanden.'",
    "options": ["und", "als auch", "oder", "noch"],
    "correctAnswer": 1,
    "explanation": "'sowohl ... als auch' verbindet zwei gleichwertige Elemente additiv.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-075",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er will Arzt werden, ___ er anderen Menschen helfen kann.'",
    "options": ["weil", "damit", "obwohl", "indem"],
    "correctAnswer": 1,
    "explanation": "'damit' leitet einen finalen Nebensatz ein (Zweck, verschiedene Subjekte).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-076",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er das Haus verließ, schloss er alle Fenster.'",
    "options": ["Nachdem", "Bevor", "Sobald", "Während"],
    "correctAnswer": 1,
    "explanation": "'Bevor' drückt Nachzeitigkeit aus (temporal: zuerst Fenster schließen, dann gehen).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-077",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er hat den Vertrag gelesen. ___ hat er ihn unterschrieben.'",
    "options": ["Trotzdem", "Dennoch", "Danach", "Allerdings"],
    "correctAnswer": 2,
    "explanation": "'Danach' drückt eine zeitliche Abfolge aus (temporal, Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-078",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Der Zug hatte Verspätung, ___ er zu spät zur Besprechung kam.'",
    "options": ["damit", "sodass", "obwohl", "falls"],
    "correctAnswer": 1,
    "explanation": "'sodass' drückt eine Folge aus (konsekutiv, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-079",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Ich bleibe hier, ___ du zurückkommst.'",
    "options": ["nachdem", "sobald", "bis", "während"],
    "correctAnswer": 2,
    "explanation": "'bis' drückt einen Endpunkt aus (temporal, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-080",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'zwar hat er Erfahrung, ___ ihm fehlt die nötige Qualifikation.'",
    "options": ["und", "aber", "oder", "denn"],
    "correctAnswer": 1,
    "explanation": "'zwar ... aber' drückt eine konzessive Einschränkung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-081",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? '___ es regnet, nehme ich einen Regenschirm mit.'",
    "options": ["Obwohl", "Falls", "Nachdem", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Falls' drückt eine mögliche Bedingung aus (konditional).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-082",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er ist intelligent. ___ ist er sehr fleißig.'",
    "options": ["Stattdessen", "Dennoch", "Außerdem", "Allerdings"],
    "correctAnswer": 2,
    "explanation": "'Außerdem' fügt eine zusätzliche Information hinzu (additiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "additiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-083",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er nahm ein Taxi, ___ er pünktlich ankam.'",
    "options": ["weil", "damit", "obwohl", "indem"],
    "correctAnswer": 1,
    "explanation": "'damit' drückt den Zweck aus (final, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-084",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt eine Folge aus? 'Das Experiment schlug fehl. ___ musste es wiederholt werden.'",
    "options": ["Dennoch", "Folglich", "Allerdings", "Trotzdem"],
    "correctAnswer": 1,
    "explanation": "'Folglich' drückt eine logische Konsequenz aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-085",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat mir geholfen, ___ ich Probleme hatte.'",
    "options": ["obwohl", "als", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'als' drückt ein einmaliges Ereignis in der Vergangenheit aus (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-086",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er hat die Stelle bekommen, ___ er die beste Präsentation gehalten hat.'",
    "options": ["obwohl", "da", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'da' ist ein kausaler Konnektor (formeller als 'weil').",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-087",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'nicht nur das Essen, ___ auch der Service war ausgezeichnet.'",
    "options": ["und", "oder", "sondern", "aber"],
    "correctAnswer": 2,
    "explanation": "'nicht nur ... sondern auch' erweitert eine Aussage um ein zusätzliches Element.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-088",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt eine Handlung entgegen der Erwartung aus? 'Es regnete stark. ___ gingen sie spazieren.'",
    "options": ["Deshalb", "Trotzdem", "Folglich", "Daher"],
    "correctAnswer": 1,
    "explanation": "'Trotzdem' drückt eine konzessive Handlung aus (entgegen der Erwartung).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-089",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ man die Anleitung liest, kann man das Gerät leicht bedienen.'",
    "options": ["Obwohl", "Wenn", "Damit", "Nachdem"],
    "correctAnswer": 1,
    "explanation": "'Wenn' leitet einen konditionalen Nebensatz ein (Bedingung/Wiederholung).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-090",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er hat nicht nur hart gearbeitet, ___ er hat auch viel gelernt.'",
    "options": ["aber", "und", "sondern", "oder"],
    "correctAnswer": 2,
    "explanation": "'nicht nur ... sondern (auch)' erweitert eine Aussage (additiv).",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-091",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er müde war, ging er früh ins Bett.'",
    "options": ["Obwohl", "Da", "Damit", "Falls"],
    "correctAnswer": 1,
    "explanation": "'Da' leitet einen kausalen Nebensatz ein (formeller als 'weil').",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-092",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt eine Folgerung aus? 'Er hat gelogen. ___ vertraue ich ihm nicht mehr.'",
    "options": ["Dennoch", "Daher", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Daher' drückt eine kausale Folge aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-093",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er lernt Spanisch, ___ er in Südamerika arbeiten möchte.'",
    "options": ["obwohl", "weil", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'weil' leitet einen kausalen Nebensatz ein (Grund).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-094",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'je länger man wartet, ___ schwieriger wird es.'",
    "options": ["umso", "als", "wie", "so"],
    "correctAnswer": 0,
    "explanation": "'je ... desto/umso' drückt eine proportionale Steigerung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p2-095",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er ging joggen, ___ zu Hause zu bleiben.'",
    "options": ["ohne", "anstatt", "bevor", "nachdem"],
    "correctAnswer": 1,
    "explanation": "'anstatt ... zu + Infinitiv' drückt eine Ersatzhandlung aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "substitutiv"]
  }
];

export default questions;
