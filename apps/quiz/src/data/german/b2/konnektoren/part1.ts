import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-konnektoren-p1-011",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'infolgedessen'?",
    "options": [
      "Hauptsatz ohne Inversion",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz"
    ],
    "correctAnswer": 1,
    "explanation": "'infolgedessen' steht auf Position 1, dann folgt Inversion: infolgedessen, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-023",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'deswegen'?",
    "options": [
      "Hauptsatz ohne Inversion",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)",
      "Nebensatz (Verb am Ende)",
      "Infinitivsatz"
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
    "language": "german", "id": "b2-konnektoren-p1-047",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'folglich'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Hauptsatz ohne Inversion",
      "Infinitivsatz",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)"
    ],
    "correctAnswer": 3,
    "explanation": "'folglich' steht auf Position 1, dann folgt Inversion: folglich, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Satzadverbien",
    "tags": [
      "konnektoren",
      "adverb"
    ]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-051",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt in den formellen Kontext? 'Die Kosten sind gestiegen, ___ müssen wir das Budget anpassen.'",
    "options": ["deshalb", "infolgedessen", "darum", "also"],
    "correctAnswer": 1,
    "explanation": "'infolgedessen' ist ein formelles konsekutives Satzadverb.",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv", "formell"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-052",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'je schneller man fährt, ___ gefährlicher ist es.'",
    "options": ["umso", "als", "wie", "so"],
    "correctAnswer": 0,
    "explanation": "'je ... desto/umso' drückt eine proportionale Beziehung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-053",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor drückt eine Einschränkung aus? 'Das Produkt ist gut, ___ ist es teuer.'",
    "options": ["deshalb", "außerdem", "allerdings", "folglich"],
    "correctAnswer": 2,
    "explanation": "'allerdings' drückt eine Einschränkung aus (adversativ, Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-054",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ ich mich beeile, komme ich pünktlich an.'",
    "options": ["Falls", "Obwohl", "Weil", "Damit"],
    "correctAnswer": 0,
    "explanation": "'Falls' leitet eine Bedingung ein (konditional, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-055",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor drückt Gleichzeitigkeit aus? '___ er telefonierte, schrieb sie eine E-Mail.'",
    "options": ["Nachdem", "Bevor", "Während", "Bis"],
    "correctAnswer": 2,
    "explanation": "'Während' drückt Gleichzeitigkeit zweier Handlungen aus (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-056",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'weder die Qualität ___ der Preis stimmen.'",
    "options": ["und", "oder", "noch", "aber"],
    "correctAnswer": 2,
    "explanation": "'weder ... noch' verneint beide Teile (weder A noch B).",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-057",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Wählen Sie den passenden Konnektor: 'Er hat das Projekt abgeschlossen, ___ er wenig Zeit hatte.'",
    "options": ["weil", "obwohl", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'obwohl' drückt einen konzessiven Widerspruch aus (Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-058",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er wollte ins Kino gehen. ___ ging er ins Theater.'",
    "options": ["Deshalb", "Stattdessen", "Außerdem", "Dennoch"],
    "correctAnswer": 1,
    "explanation": "'Stattdessen' drückt eine Ersatzhandlung aus (Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "substitutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-059",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er das Studium abgeschlossen hatte, fand er sofort eine Stelle.'",
    "options": ["Während", "Bevor", "Nachdem", "Bis"],
    "correctAnswer": 2,
    "explanation": "'Nachdem' drückt Vorzeitigkeit aus (zuerst Studium, dann Stelle).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-060",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Sie hat nicht nur Deutsch gelernt, ___ auch Französisch.'",
    "options": ["aber", "und", "sondern", "oder"],
    "correctAnswer": 2,
    "explanation": "'nicht nur ... sondern auch' erweitert eine Aussage um ein zusätzliches Element.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-062",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt eine Ergänzung aus? 'Er spricht Englisch. ___ lernt er Spanisch.'",
    "options": ["Trotzdem", "Deshalb", "Außerdem", "Stattdessen"],
    "correctAnswer": 2,
    "explanation": "'Außerdem' fügt eine zusätzliche Information hinzu (additiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "additiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-063",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor leitet eine Art und Weise ein? 'Man lernt am besten, ___ man viel übt.'",
    "options": ["weil", "indem", "damit", "obwohl"],
    "correctAnswer": 1,
    "explanation": "'indem' beschreibt die Art und Weise (modal/instrumental, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-064",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'entweder wir fahren mit dem Zug ___ wir fliegen.'",
    "options": ["und", "aber", "oder", "noch"],
    "correctAnswer": 2,
    "explanation": "'entweder ... oder' bietet zwei Alternativen an.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-065",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Die Firma hat Verluste gemacht. ___ wurden Mitarbeiter entlassen.'",
    "options": ["Trotzdem", "Folglich", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Folglich' drückt eine logische Konsequenz aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-066",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er arbeitet hart, ___ seine Familie zu unterstützen.'",
    "options": ["weil", "damit", "um", "indem"],
    "correctAnswer": 2,
    "explanation": "'um ... zu + Infinitiv' drückt einen Zweck aus (gleiches Subjekt).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-067",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Wählen Sie: '___ sie jung ist, hat sie viel Erfahrung.'",
    "options": ["Weil", "Obwohl", "Wenn", "Nachdem"],
    "correctAnswer": 1,
    "explanation": "'Obwohl' leitet einen konzessiven Nebensatz ein (Widerspruch).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-068",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat das Angebot abgelehnt. ___ hat er es nie bereut.'",
    "options": ["Deshalb", "Dennoch", "Folglich", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Dennoch' drückt aus, dass etwas entgegen der Erwartung geschieht (konzessiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-069",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er ging, ___ sich zu verabschieden.'",
    "options": ["um", "ohne", "anstatt", "damit"],
    "correctAnswer": 1,
    "explanation": "'ohne ... zu + Infinitiv' drückt aus, dass etwas nicht getan wurde.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "modal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-070",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'zwar ist das Angebot günstig, ___ die Qualität überzeugt mich nicht.'",
    "options": ["und", "aber", "oder", "denn"],
    "correctAnswer": 1,
    "explanation": "'zwar ... aber' drückt eine konzessive Einschränkung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-071",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ das Wetter schlecht ist, gehen wir spazieren.'",
    "options": ["Weil", "Obwohl", "Wenn", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Obwohl' drückt aus, dass die Handlung trotz eines Hindernisses stattfindet.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-072",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor drückt einen Ersatz aus? '___ er selbst zu kommen, schickte er seinen Vertreter.'",
    "options": ["Ohne", "Anstatt", "Bevor", "Nachdem"],
    "correctAnswer": 1,
    "explanation": "'anstatt' drückt eine Ersatzhandlung aus (anstatt zu + Infinitiv).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "substitutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-073",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Ich rufe dich an, ___ ich am Bahnhof ankomme.'",
    "options": ["nachdem", "sobald", "bis", "während"],
    "correctAnswer": 1,
    "explanation": "'sobald' drückt aus, dass die Handlung unmittelbar nach einem Ereignis erfolgt.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-074",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Sie hat viel geübt. ___ hat sie die Prüfung bestanden.'",
    "options": ["Trotzdem", "Deshalb", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Deshalb' drückt eine kausale Folge aus (konsekutiv, Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-075",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er lernt Deutsch, ___ er in Deutschland arbeiten will.'",
    "options": ["obwohl", "weil", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'weil' leitet einen kausalen Nebensatz ein (Grund).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-076",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor verbindet zwei Hauptsätze ohne Wortstellungsänderung? 'Er ist müde, ___ er geht trotzdem zur Arbeit.'",
    "options": ["weil", "obwohl", "aber", "deshalb"],
    "correctAnswer": 2,
    "explanation": "'aber' ist ein nebenordnender Konnektor (Position 0): keine Inversion nötig.",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-077",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ du morgen Zeit hast, können wir uns treffen.'",
    "options": ["Obwohl", "Wenn", "Nachdem", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Wenn' leitet einen konditionalen Nebensatz ein (Bedingung).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-078",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb drückt einen Gegensatz aus? 'Er ist qualifiziert. ___ hat er keine Berufserfahrung.'",
    "options": ["Deshalb", "Außerdem", "Allerdings", "Folglich"],
    "correctAnswer": 2,
    "explanation": "'Allerdings' drückt einen einschränkenden Gegensatz aus (adversativ).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-079",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'sowohl der Preis ___ die Qualität stimmen.'",
    "options": ["und", "als auch", "oder", "noch"],
    "correctAnswer": 1,
    "explanation": "'sowohl ... als auch' verbindet zwei gleichwertige Elemente (additiv).",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-080",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Wir warten, ___ der Regen aufhört.'",
    "options": ["nachdem", "sobald", "bis", "während"],
    "correctAnswer": 2,
    "explanation": "'bis' drückt einen Endpunkt aus (temporal, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-081",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er spricht langsam, ___ alle ihn verstehen können.'",
    "options": ["weil", "damit", "obwohl", "indem"],
    "correctAnswer": 1,
    "explanation": "'damit' leitet einen finalen Nebensatz ein (Zweck, verschiedene Subjekte).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-082",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Das Restaurant war geschlossen. ___ gingen wir in ein Café.'",
    "options": ["Dennoch", "Daher", "Allerdings", "Stattdessen"],
    "correctAnswer": 3,
    "explanation": "'Stattdessen' drückt eine Alternative/Ersatzhandlung aus.",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "substitutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-083",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Er hat den Job bekommen, ___ er am besten qualifiziert war.'",
    "options": ["obwohl", "da", "damit", "falls"],
    "correctAnswer": 1,
    "explanation": "'da' ist ein kausaler Konnektor (Nebensatz), etwas formeller als 'weil'.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-084",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat alles erledigt. ___ kann er jetzt Feierabend machen.'",
    "options": ["Trotzdem", "Also", "Allerdings", "Dennoch"],
    "correctAnswer": 1,
    "explanation": "'Also' drückt eine logische Folgerung aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-085",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher nebenordnende Konnektor gibt einen Grund an? 'Er blieb zu Hause, ___ er war krank.'",
    "options": ["aber", "oder", "denn", "und"],
    "correctAnswer": 2,
    "explanation": "'denn' gibt einen Grund an (kausal, Position 0, keine Inversion).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "kausal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-086",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ sie die Prüfung nicht besteht, muss sie den Kurs wiederholen.'",
    "options": ["Obwohl", "Falls", "Nachdem", "Während"],
    "correctAnswer": 1,
    "explanation": "'Falls' drückt eine mögliche Bedingung aus (konditional, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-087",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Die Straße war gesperrt. ___ nahmen wir einen Umweg.'",
    "options": ["Dennoch", "Daher", "Allerdings", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Daher' drückt eine kausale Folge aus (konsekutiv, Position 1 + Inversion).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-088",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er zu Hause ankam, machte er sofort das Licht an.'",
    "options": ["Während", "Als", "Bis", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Als' drückt ein einmaliges Ereignis in der Vergangenheit aus (temporal).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-089",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor korrigiert eine Aussage? 'Er ist nicht faul, ___ er ist sehr fleißig.'",
    "options": ["aber", "und", "sondern", "denn"],
    "correctAnswer": 2,
    "explanation": "'sondern' korrigiert eine negierte Aussage (nicht A, sondern B).",
    "subcategory": "Nebenordnende Konnektoren",
    "tags": ["konnektoren", "adversativ"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-090",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Er hat den ganzen Tag gearbeitet, ___ er erschöpft ist.'",
    "options": ["damit", "sodass", "obwohl", "falls"],
    "correctAnswer": 1,
    "explanation": "'sodass' drückt eine Folge aus (konsekutiv, Nebensatz).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konsekutiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-091",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er war krank. ___ ging er zur Arbeit.'",
    "options": ["Deshalb", "Trotzdem", "Folglich", "Außerdem"],
    "correctAnswer": 1,
    "explanation": "'Trotzdem' drückt aus, dass etwas entgegen der Erwartung geschieht (konzessiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konzessiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-092",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ er den Brief gelesen hatte, rief er sofort an.'",
    "options": ["Während", "Bevor", "Nachdem", "Bis"],
    "correctAnswer": 2,
    "explanation": "'Nachdem' + Plusquamperfekt drückt Vorzeitigkeit aus.",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-093",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie den zweiteiligen Konnektor: 'je mehr man übt, ___ besser wird man.'",
    "options": ["umso", "als", "wie", "so"],
    "correctAnswer": 0,
    "explanation": "'je ... desto/umso' drückt eine proportionale Steigerung aus.",
    "subcategory": "Zweiteilige Konnektoren",
    "tags": ["konnektoren", "zweiteilig"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-094",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welcher Konnektor passt? 'Ich schicke dir eine Nachricht, ___ du das nicht vergisst.'",
    "options": ["weil", "damit", "obwohl", "indem"],
    "correctAnswer": 1,
    "explanation": "'damit' drückt einen Zweck aus (final, unterschiedliche Subjekte möglich).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "final"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-095",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er spricht fließend Deutsch. ___ beherrscht er auch Englisch.'",
    "options": ["Trotzdem", "Deshalb", "Darüber hinaus", "Stattdessen"],
    "correctAnswer": 2,
    "explanation": "'Darüber hinaus' fügt eine zusätzliche Information hinzu (additiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "additiv"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-096",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: '___ du mir nicht hilfst, schaffe ich es allein.'",
    "options": ["Obwohl", "Wenn", "Weil", "Damit"],
    "correctAnswer": 1,
    "explanation": "'Wenn' kann auch eine negative Bedingung einleiten (konditional).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "konditional"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-097",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Ergänzen Sie: 'Sie hat den Vertrag unterschrieben, ___ sie ihn gelesen hatte.'",
    "options": ["bevor", "nachdem", "während", "bis"],
    "correctAnswer": 1,
    "explanation": "'nachdem' drückt Vorzeitigkeit aus (erst lesen, dann unterschreiben).",
    "subcategory": "Subjunktionen",
    "tags": ["konnektoren", "temporal"]
  },
  {
    "language": "german", "id": "b2-konnektoren-p1-098",
    "level": "b2",
    "category": "Konnektoren",
    "question": "Welches Satzadverb passt? 'Er hat viel Geld gespart. ___ konnte er sich ein Haus kaufen.'",
    "options": ["Trotzdem", "Infolgedessen", "Allerdings", "Stattdessen"],
    "correctAnswer": 1,
    "explanation": "'Infolgedessen' drückt eine formelle kausale Folge aus (konsekutiv).",
    "subcategory": "Satzadverbien",
    "tags": ["konnektoren", "konsekutiv"]
  }
];

export default questions;
