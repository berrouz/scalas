import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b1-konnektoren-p1-001",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'und'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Hauptsatz (Position 0)",
      "Nebensatz + Nebensatz",
      "Hauptsatz + Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 1,
    "explanation": "'und' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "hauptsatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-002",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'dass'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz (Verb auf Position 2)",
      "Infinitivsatz"
    ],
    "correctAnswer": 1,
    "explanation": "'dass' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-003",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'dennoch'?",
    "options": [
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Infinitivsatz",
      "Hauptsatz ohne Inversion",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 0,
    "explanation": "'dennoch' steht auf Position 1, dann folgt Inversion: dennoch, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-004",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'nicht nur ... ___ ...'",
    "options": [
      "sondern auch",
      "desto",
      "andererseits",
      "umso"
    ],
    "correctAnswer": 0,
    "explanation": "Der zweiteilige Konnektor lautet: 'nicht nur ... sondern auch ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": [
      "konnektoren",
      "zweiteilig"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-005",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'sondern'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Hauptsatz (Position 0)",
      "Hauptsatz + Nebensatz (Verb am Ende)",
      "Nebensatz + Nebensatz"
    ],
    "correctAnswer": 1,
    "explanation": "'sondern' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "hauptsatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-006",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'obwohl'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz (Verb auf Position 2)",
      "Inversion (Verb-Subjekt)"
    ],
    "correctAnswer": 0,
    "explanation": "'obwohl' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-007",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'folglich'?",
    "options": [
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz ohne Inversion",
      "Infinitivsatz"
    ],
    "correctAnswer": 0,
    "explanation": "'folglich' steht auf Position 1, dann folgt Inversion: folglich, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-008",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'einerseits ... ___ ...'",
    "options": [
      "als auch",
      "andererseits",
      "aber",
      "umso"
    ],
    "correctAnswer": 1,
    "explanation": "Der zweiteilige Konnektor lautet: 'einerseits ... andererseits ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": [
      "konnektoren",
      "zweiteilig"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-009",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'denn'?",
    "options": [
      "Nebensatz + Nebensatz",
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Nebensatz (Verb am Ende)",
      "Hauptsatz + Hauptsatz (Position 0)"
    ],
    "correctAnswer": 3,
    "explanation": "'denn' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "hauptsatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-010",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'während'?",
    "options": [
      "Hauptsatz (Verb auf Position 2)",
      "Infinitivsatz",
      "Inversion (Verb-Subjekt)",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 3,
    "explanation": "'während' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-011",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'nichtsdestotrotz'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Hauptsatz ohne Inversion",
      "Infinitivsatz"
    ],
    "correctAnswer": 1,
    "explanation": "'nichtsdestotrotz' steht auf Position 1, dann folgt Inversion: nichtsdestotrotz, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-013",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'oder'?",
    "options": [
      "Hauptsatz + Hauptsatz (Position 0)",
      "Inversion (Verb-Subjekt)",
      "Nebensatz + Nebensatz",
      "Hauptsatz + Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 0,
    "explanation": "'oder' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "hauptsatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-014",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'falls'?",
    "options": [
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)",
      "Inversion (Verb-Subjekt)",
      "Hauptsatz (Verb auf Position 2)"
    ],
    "correctAnswer": 1,
    "explanation": "'falls' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-015",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'trotzdem'?",
    "options": [
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Hauptsatz ohne Inversion"
    ],
    "correctAnswer": 2,
    "explanation": "'trotzdem' steht auf Position 1, dann folgt Inversion: trotzdem, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-017",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'aber'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Hauptsatz (Position 0)",
      "Nebensatz + Nebensatz",
      "Hauptsatz + Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 1,
    "explanation": "'aber' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "hauptsatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-018",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'anstatt dass'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz (Verb auf Position 2)",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz"
    ],
    "correctAnswer": 2,
    "explanation": "'anstatt dass' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-019",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'jedoch'?",
    "options": [
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Infinitivsatz",
      "Hauptsatz ohne Inversion",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 0,
    "explanation": "'jedoch' steht auf Position 1, dann folgt Inversion: jedoch, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-022",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'wenn'?",
    "options": [
      "Hauptsatz (Verb auf Position 2)",
      "Inversion (Verb-Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz"
    ],
    "correctAnswer": 2,
    "explanation": "'wenn' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-023",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'infolgedessen'?",
    "options": [
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz ohne Inversion"
    ],
    "correctAnswer": 0,
    "explanation": "'infolgedessen' steht auf Position 1, dann folgt Inversion: infolgedessen, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-026",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'nachdem'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz (Verb auf Position 2)"
    ],
    "correctAnswer": 2,
    "explanation": "'nachdem' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-027",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'deshalb'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Hauptsatz ohne Inversion"
    ],
    "correctAnswer": 2,
    "explanation": "'deshalb' steht auf Position 1, dann folgt Inversion: deshalb, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-030",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'bis'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)",
      "Hauptsatz (Verb auf Position 2)"
    ],
    "correctAnswer": 2,
    "explanation": "'bis' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-031",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'außerdem'?",
    "options": [
      "Hauptsatz ohne Inversion",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 1,
    "explanation": "'außerdem' steht auf Position 1, dann folgt Inversion: außerdem, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-034",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt nach der Subjunktion 'indem'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Inversion (Verb-Subjekt)",
      "Infinitivsatz",
      "Hauptsatz (Verb auf Position 2)"
    ],
    "correctAnswer": 0,
    "explanation": "'indem' leitet einen Nebensatz ein: das Verb steht am Ende.",
    "grammarRule": "Subjunktionen: weil, dass, ob, wenn, als, obwohl... → Verb am Ende",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "nebensatz"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-035",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'deswegen'?",
    "options": [
      "Infinitivsatz",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Hauptsatz ohne Inversion",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 1,
    "explanation": "'deswegen' steht auf Position 1, dann folgt Inversion: deswegen, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-039",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'andererseits'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz ohne Inversion",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)"
    ],
    "correctAnswer": 3,
    "explanation": "'andererseits' steht auf Position 1, dann folgt Inversion: andererseits, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-043",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'allerdings'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Hauptsatz ohne Inversion"
    ],
    "correctAnswer": 2,
    "explanation": "'allerdings' steht auf Position 1, dann folgt Inversion: allerdings, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-047",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'daher'?",
    "options": [
      "Hauptsatz ohne Inversion",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Infinitivsatz",
      "Nebensatz (Verb am Ende)"
    ],
    "correctAnswer": 1,
    "explanation": "'daher' steht auf Position 1, dann folgt Inversion: daher, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-051",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Wählen Sie den passenden Konnektor: 'Ich bin müde, ___ ich habe schlecht geschlafen.'",
    "options": [
      "denn",
      "obwohl",
      "damit",
      "falls"
    ],
    "correctAnswer": 0,
    "explanation": "'denn' gibt einen Grund an und verbindet zwei Hauptsätze (Position 0).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "kausal"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-052",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? '___ es regnet, nehme ich einen Schirm mit.'",
    "options": [
      "Denn",
      "Weil",
      "Deshalb",
      "Trotzdem"
    ],
    "correctAnswer": 1,
    "explanation": "'Weil' leitet einen kausalen Nebensatz ein (Verb am Ende).",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "kausal"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-053",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Ich lerne Deutsch, ___ ich in Deutschland arbeiten möchte.'",
    "options": [
      "trotzdem",
      "weil",
      "aber",
      "oder"
    ],
    "correctAnswer": 1,
    "explanation": "'weil' drückt einen Grund aus und leitet einen Nebensatz ein.",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "kausal"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-054",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor drückt einen Gegensatz aus? 'Er ist reich, ___ er ist nicht glücklich.'",
    "options": [
      "und",
      "denn",
      "aber",
      "oder"
    ],
    "correctAnswer": 2,
    "explanation": "'aber' drückt einen Gegensatz aus und ist ein nebenordnender Konnektor.",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "adversativ"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-055",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'weder ... ___ ...'",
    "options": [
      "noch",
      "oder",
      "sondern",
      "als"
    ],
    "correctAnswer": 0,
    "explanation": "Der zweiteilige Konnektor lautet: 'weder ... noch ...' (weder A noch B).",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": [
      "konnektoren",
      "zweiteilig"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-056",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Ich komme, ___ ich Zeit habe.'",
    "options": [
      "weil",
      "wenn",
      "denn",
      "deshalb"
    ],
    "correctAnswer": 1,
    "explanation": "'wenn' leitet eine Bedingung ein und steht mit Nebensatz (Verb am Ende).",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "konditional"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-057",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Wählen Sie das passende Satzadverb: 'Es regnet. ___ bleibe ich zu Hause.'",
    "options": [
      "Weil",
      "Obwohl",
      "Deshalb",
      "Dass"
    ],
    "correctAnswer": 2,
    "explanation": "'Deshalb' ist ein Satzadverb (Position 1 + Inversion) und drückt eine Folge aus.",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "konsekutiv"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-058",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'sowohl ... ___ ...'",
    "options": [
      "als auch",
      "oder",
      "noch",
      "sondern"
    ],
    "correctAnswer": 0,
    "explanation": "Der zweiteilige Konnektor lautet: 'sowohl ... als auch ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": [
      "konnektoren",
      "zweiteilig"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-059",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? '___ er krank war, ging er zur Arbeit.'",
    "options": [
      "Weil",
      "Obwohl",
      "Wenn",
      "Damit"
    ],
    "correctAnswer": 1,
    "explanation": "'Obwohl' drückt einen Widerspruch aus (konzessiv) und leitet einen Nebensatz ein.",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "konzessiv"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-060",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Wählen Sie den passenden Konnektor: 'Ich möchte Tee ___ Kaffee.'",
    "options": [
      "und",
      "aber",
      "oder",
      "denn"
    ],
    "correctAnswer": 2,
    "explanation": "'oder' bietet eine Alternative an und ist ein nebenordnender Konnektor.",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "alternativ"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-061",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt einen Gegensatz aus? 'Sie wollte kommen. ___ hatte sie keine Zeit.'",
    "options": [
      "Deshalb",
      "Außerdem",
      "Allerdings",
      "Folglich"
    ],
    "correctAnswer": 2,
    "explanation": "'Allerdings' drückt eine Einschränkung/einen Gegensatz aus (Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adversativ"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-062",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er lernt Deutsch, ___ er einen besseren Job zu bekommen.'",
    "options": [
      "weil",
      "um",
      "damit",
      "denn"
    ],
    "correctAnswer": 1,
    "explanation": "'um ... zu + Infinitiv' drückt einen Zweck aus (gleiches Subjekt).",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "final"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-063",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor leitet einen Zeitsatz ein? '___ ich nach Hause kam, war es dunkel.'",
    "options": [
      "Weil",
      "Obwohl",
      "Als",
      "Damit"
    ],
    "correctAnswer": 2,
    "explanation": "'Als' leitet einen einmaligen Zeitsatz in der Vergangenheit ein.",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "temporal"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-064",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Wählen Sie: 'Ich bleibe hier, ___ du zurückkommst.'",
    "options": [
      "als",
      "bis",
      "seit",
      "nachdem"
    ],
    "correctAnswer": 1,
    "explanation": "'bis' gibt einen Endpunkt an und leitet einen temporalen Nebensatz ein.",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "temporal"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-065",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor drückt eine Folge aus? 'Er hat viel gelernt, ___ hat er die Prüfung bestanden.'",
    "options": [
      "trotzdem",
      "daher",
      "obwohl",
      "weil"
    ],
    "correctAnswer": 1,
    "explanation": "'daher' ist ein konsekutives Satzadverb (Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "konsekutiv"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-066",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'entweder ... ___ ...'",
    "options": [
      "noch",
      "oder",
      "und",
      "aber"
    ],
    "correctAnswer": 1,
    "explanation": "Der zweiteilige Konnektor lautet: 'entweder ... oder ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": [
      "konnektoren",
      "zweiteilig"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-067",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er ist nicht gekommen, ___ er hat auch nicht angerufen.'",
    "options": [
      "und",
      "aber",
      "denn",
      "oder"
    ],
    "correctAnswer": 0,
    "explanation": "'und' verbindet zwei gleichrangige Aussagen (nebenordnend, Position 0).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": [
      "konnektoren",
      "kopulativ"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-068",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Wählen Sie das passende Satzadverb: 'Er war krank. ___ ist er zur Arbeit gegangen.'",
    "options": [
      "Deshalb",
      "Trotzdem",
      "Außerdem",
      "Folglich"
    ],
    "correctAnswer": 1,
    "explanation": "'Trotzdem' drückt einen Widerspruch aus (konzessiv, Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "konzessiv"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-069",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er Deutsch gelernt hat, spricht er jetzt fließend.'",
    "options": [
      "Bevor",
      "Nachdem",
      "Bis",
      "Während"
    ],
    "correctAnswer": 1,
    "explanation": "'Nachdem' drückt Vorzeitigkeit aus (die Handlung im Nebensatz geschah zuerst).",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "temporal"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-070",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welcher Konnektor drückt einen Zweck aus? 'Ich lerne, ___ ich die Prüfung bestehe.'",
    "options": [
      "weil",
      "damit",
      "obwohl",
      "als"
    ],
    "correctAnswer": 1,
    "explanation": "'damit' leitet einen finalen Nebensatz ein (Zweck/Ziel).",
    "subcategory": "Subjunktionen",
    "tags": [
      "konnektoren",
      "final"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-071",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'je mehr ... ___ besser.'",
    "options": [
      "umso",
      "als",
      "wie",
      "so"
    ],
    "correctAnswer": 0,
    "explanation": "Der zweiteilige Konnektor lautet: 'je ... desto/umso ...'.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": [
      "konnektoren",
      "zweiteilig"
    ]
  },
  {
    "language": "german", "id": "b1-konnektoren-p1-072",
    "level": "b1",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er spricht gut Deutsch. ___ hat er einen guten Job gefunden.'",
    "options": [
      "Trotzdem",
      "Infolgedessen",
      "Allerdings",
      "Stattdessen"
    ],
    "correctAnswer": 1,
    "explanation": "'Infolgedessen' drückt eine Folge aus (konsekutiv, Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "konsekutiv"
    ]
  }
];

export default questions;
