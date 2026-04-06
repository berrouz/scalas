import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b2-textgrammatik-p1-001",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Merkmal gehört zur Textsorte 'formeller Brief'?",
    "options": [
      "sachlich, Präteritum, keine persönliche Meinung",
      "Sehr geehrte Damen und Herren",
      "Präsens, indirekte Rede, Konjunktiv I",
      "persönliche Meinung, Argumente"
    ],
    "correctAnswer": 1,
    "explanation": "Ein formeller Brief ist gekennzeichnet durch: Sehr geehrte Damen und Herren.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-002",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Hey, hast du schon gehört, dass...'?",
    "options": ["informell", "neutral", "umgangssprachlich", "formell"],
    "correctAnswer": 0,
    "explanation": "Dieser Satz gehört zum informellen Register.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-003",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist 'Rekurrenz' als Kohäsionsmittel?",
    "options": [
      "Wiederholung gleicher Wörter/Wortgruppen",
      "Auslassung bereits genannter Elemente",
      "Ersetzung durch Synonyme oder Oberbegriffe",
      "Verknüpfungswörter (deshalb, trotzdem, außerdem)"
    ],
    "correctAnswer": 0,
    "explanation": "Rekurrenz = Wiederholung gleicher Wörter/Wortgruppen.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-004",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was beschreibt 'Kohärenz' in einem Text?",
    "options": [
      "die Anzahl der Wörter im Text",
      "die Aussprache der Sätze",
      "den logischen Zusammenhang zwischen Sätzen",
      "die Rechtschreibung der Wörter"
    ],
    "correctAnswer": 2,
    "explanation": "Kohärenz bezeichnet den inhaltlich-logischen Zusammenhang eines Textes.",
    "grammarRule": "Kohärenz = inhaltlicher Zusammenhang; Kohäsion = sprachliche Verknüpfung",
    "subcategory": "Kohärenz",
    "tags": ["textgrammatik", "kohaerenz"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-005",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Merkmal gehört zur Textsorte 'Zusammenfassung'?",
    "options": [
      "Präsens, Adjektive, Lokalangaben",
      "Bezug auf Artikel, persönliche Meinung",
      "Sehr geehrte Damen und Herren",
      "Präsens, indirekte Rede, Konjunktiv I"
    ],
    "correctAnswer": 3,
    "explanation": "Eine Zusammenfassung ist gekennzeichnet durch: Präsens, indirekte Rede, Konjunktiv I.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-007",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist 'Konnektoren' als Kohäsionsmittel?",
    "options": [
      "Verknüpfungswörter (deshalb, trotzdem, außerdem)",
      "Ersetzung durch Pronomen (er, sie, es, dieser, jener)",
      "Auslassung bereits genannter Elemente",
      "Wiederholung gleicher Wörter/Wortgruppen"
    ],
    "correctAnswer": 0,
    "explanation": "Konnektoren = Verknüpfungswörter (deshalb, trotzdem, außerdem).",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-011",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist 'Pronominalisierung' als Kohäsionsmittel?",
    "options": [
      "Ersetzung durch Pronomen (er, sie, es, dieser, jener)",
      "Ersetzung durch Synonyme oder Oberbegriffe",
      "Wiederholung gleicher Wörter/Wortgruppen",
      "Verknüpfungswörter (deshalb, trotzdem, außerdem)"
    ],
    "correctAnswer": 0,
    "explanation": "Pronominalisierung = Ersetzung durch Pronomen (er, sie, es, dieser, jener).",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-015",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist 'Ellipse' als Kohäsionsmittel?",
    "options": [
      "Verknüpfungswörter (deshalb, trotzdem, außerdem)",
      "Ersetzung durch Synonyme oder Oberbegriffe",
      "Ersetzung durch Pronomen (er, sie, es, dieser, jener)",
      "Auslassung bereits genannter Elemente"
    ],
    "correctAnswer": 3,
    "explanation": "Ellipse = Auslassung bereits genannter Elemente.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-019",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist 'Substitution' als Kohäsionsmittel?",
    "options": [
      "Wiederholung gleicher Wörter/Wortgruppen",
      "Auslassung bereits genannter Elemente",
      "Ersetzung durch Synonyme oder Oberbegriffe",
      "Verknüpfungswörter (deshalb, trotzdem, außerdem)"
    ],
    "correctAnswer": 2,
    "explanation": "Substitution = Ersetzung durch Synonyme oder Oberbegriffe.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-020",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist das 'Thema' im Thema-Rhema-Modell?",
    "options": [
      "die neue, unbekannte Information im Satz",
      "die bereits bekannte Information im Satz",
      "der Hauptgedanke eines ganzen Textes",
      "die Überschrift eines Absatzes"
    ],
    "correctAnswer": 1,
    "explanation": "Das Thema ist die bekannte, schon eingeführte Information, an die der Satz anknüpft.",
    "subcategory": "Thema-Rhema",
    "tags": ["textgrammatik", "thema-rhema"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-021",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist das 'Rhema' im Thema-Rhema-Modell?",
    "options": [
      "die bereits bekannte Information",
      "die neue, noch unbekannte Information im Satz",
      "das Verb im Hauptsatz",
      "die Wiederholung eines Wortes"
    ],
    "correctAnswer": 1,
    "explanation": "Das Rhema ist die neue Information, die der Satz mitteilt.",
    "subcategory": "Thema-Rhema",
    "tags": ["textgrammatik", "thema-rhema"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-022",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt einen Gegensatz aus?",
    "options": ["deshalb", "außerdem", "trotzdem", "danach"],
    "correctAnswer": 2,
    "explanation": "'Trotzdem' drückt einen Gegensatz (Konzession) aus: Etwas passiert entgegen der Erwartung.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-023",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Hiermit beantrage ich die Verlängerung meines Vertrags'?",
    "options": ["informell", "umgangssprachlich", "formell", "neutral"],
    "correctAnswer": 2,
    "explanation": "'Hiermit beantrage ich...' gehört zum formellen Register (Behörden-/Geschäftssprache).",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-024",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist ein typisches Merkmal der Textsorte 'Leserbrief'?",
    "options": [
      "Präsens, indirekte Rede, Konjunktiv I",
      "Bezug auf Artikel, persönliche Meinung",
      "Sehr geehrte Damen und Herren",
      "sachlich, Präteritum, keine persönliche Meinung"
    ],
    "correctAnswer": 1,
    "explanation": "Ein Leserbrief nimmt Bezug auf einen Artikel und äußert eine persönliche Meinung.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-025",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt eine Folge/Konsequenz aus?",
    "options": ["obwohl", "deshalb", "aber", "zwar"],
    "correctAnswer": 1,
    "explanation": "'Deshalb' zeigt eine Folge oder Konsequenz an: Grund -> deshalb -> Folge.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-026",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist ein typisches Merkmal der Textsorte 'Erörterung'?",
    "options": [
      "Liebe/Lieber ...",
      "Präsens, Adjektive, Lokalangaben",
      "These, Argumente, Fazit",
      "sachlich, Präteritum, keine persönliche Meinung"
    ],
    "correctAnswer": 2,
    "explanation": "Eine Erörterung besteht aus These, Argumenten (pro/contra) und einem Fazit.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-027",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel liegt vor: 'Die Katze schläft. Sie schnurrt dabei.'?",
    "options": ["Rekurrenz", "Pronominalisierung", "Ellipse", "Substitution"],
    "correctAnswer": 1,
    "explanation": "'Sie' ersetzt 'Die Katze' durch ein Pronomen. Das ist Pronominalisierung.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-028",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel liegt vor: 'Das Auto ist rot. Das Auto steht in der Garage.'?",
    "options": ["Pronominalisierung", "Substitution", "Rekurrenz", "Ellipse"],
    "correctAnswer": 2,
    "explanation": "'Das Auto' wird wörtlich wiederholt. Das ist Rekurrenz.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-029",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel liegt vor: 'Der Hund bellt. Das Tier ist aufgeregt.'?",
    "options": ["Rekurrenz", "Pronominalisierung", "Substitution", "Konnektoren"],
    "correctAnswer": 2,
    "explanation": "'Der Hund' wird durch den Oberbegriff 'Das Tier' ersetzt. Das ist Substitution.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-030",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Laut einer Studie der Universität...'?",
    "options": ["informell", "umgangssprachlich", "neutral", "formell/wissenschaftlich"],
    "correctAnswer": 3,
    "explanation": "Der Verweis auf eine Studie und der sachliche Stil gehören zum formellen/wissenschaftlichen Register.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-031",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist ein typisches Merkmal der Textsorte 'Beschreibung'?",
    "options": [
      "These, Argumente, Fazit",
      "Bezug auf Artikel, persönliche Meinung",
      "Präsens, Adjektive, Lokalangaben",
      "Präsens, indirekte Rede, Konjunktiv I"
    ],
    "correctAnswer": 2,
    "explanation": "Eine Beschreibung verwendet Präsens, viele Adjektive und genaue Ortsangaben.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-032",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist ein typisches Merkmal der Textsorte 'Bericht'?",
    "options": [
      "Liebe/Lieber ...",
      "sachlich, Präteritum, keine persönliche Meinung",
      "persönliche Meinung, Argumente",
      "Präsens, Adjektive, Lokalangaben"
    ],
    "correctAnswer": 1,
    "explanation": "Ein Bericht ist sachlich, verwendet das Präteritum und enthält keine persönliche Meinung.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-033",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt eine Ergänzung/Addition aus?",
    "options": ["trotzdem", "deshalb", "außerdem", "jedoch"],
    "correctAnswer": 2,
    "explanation": "'Außerdem' fügt eine zusätzliche Information hinzu (additive Verknüpfung).",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-034",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist ein typisches Merkmal der Textsorte 'informeller Brief'?",
    "options": [
      "Sehr geehrte Damen und Herren",
      "These, Argumente, Fazit",
      "Liebe/Lieber ...",
      "sachlich, Präteritum"
    ],
    "correctAnswer": 2,
    "explanation": "Ein informeller Brief beginnt mit einer persönlichen Anrede wie 'Liebe/Lieber...'.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-035",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel liegt vor: 'Er mag Kaffee, sie Tee.'?",
    "options": ["Rekurrenz", "Pronominalisierung", "Ellipse", "Substitution"],
    "correctAnswer": 2,
    "explanation": "Das Verb 'mag' wird im zweiten Teil ausgelassen. Das ist eine Ellipse.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-036",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "In welchem Satzteil steht normalerweise das Thema?",
    "options": ["am Satzende", "im Nebensatz", "am Satzanfang", "nach dem Verb"],
    "correctAnswer": 2,
    "explanation": "Das Thema (bekannte Information) steht normalerweise am Satzanfang.",
    "subcategory": "Thema-Rhema",
    "tags": ["textgrammatik", "thema-rhema"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-037",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "In welchem Satzteil steht normalerweise das Rhema?",
    "options": ["am Satzanfang", "vor dem Subjekt", "am Satzende", "im Vorfeld"],
    "correctAnswer": 2,
    "explanation": "Das Rhema (neue Information) steht typischerweise am Satzende.",
    "subcategory": "Thema-Rhema",
    "tags": ["textgrammatik", "thema-rhema"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-038",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor leitet einen zeitlichen Ablauf ein?",
    "options": ["trotzdem", "deshalb", "danach", "außerdem"],
    "correctAnswer": 2,
    "explanation": "'Danach' zeigt eine zeitliche Abfolge an (temporale Verknüpfung).",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-039",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was unterscheidet Kohäsion von Kohärenz?",
    "options": [
      "Kohäsion ist der inhaltliche, Kohärenz der sprachliche Zusammenhang",
      "Kohäsion betrifft die Grammatik, Kohärenz die Aussprache",
      "Kohäsion ist die sprachliche Verknüpfung, Kohärenz der inhaltliche Zusammenhang",
      "Es gibt keinen Unterschied"
    ],
    "correctAnswer": 2,
    "explanation": "Kohäsion = sprachliche Verknüpfungsmittel; Kohärenz = inhaltlich-logischer Zusammenhang.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-040",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Die Ergebnisse werden im Folgenden dargestellt'?",
    "options": ["informell", "umgangssprachlich", "formell/wissenschaftlich", "neutral"],
    "correctAnswer": 2,
    "explanation": "Passivkonstruktion und sachlicher Stil kennzeichnen das formelle/wissenschaftliche Register.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-041",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welche Textsorte hat typischerweise die Struktur Einleitung-Hauptteil-Schluss?",
    "options": ["Einkaufsliste", "Erörterung", "Notizzettel", "SMS"],
    "correctAnswer": 1,
    "explanation": "Eine Erörterung folgt der klassischen Struktur: Einleitung, Hauptteil (Argumente), Schluss (Fazit).",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-042",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel verbindet: 'Es regnete stark. Trotzdem ging er spazieren.'?",
    "options": ["Rekurrenz", "Pronominalisierung", "Konnektoren", "Ellipse"],
    "correctAnswer": 2,
    "explanation": "'Trotzdem' ist ein Konnektor, der die beiden Sätze logisch verknüpft.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-043",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was bedeutet 'Textsorte'?",
    "options": [
      "die Sprache, in der ein Text geschrieben ist",
      "ein bestimmter Typ von Text mit festen Merkmalen",
      "die Länge eines Textes",
      "die Schriftart eines Textes"
    ],
    "correctAnswer": 1,
    "explanation": "Eine Textsorte ist ein Typ von Text mit charakteristischen Merkmalen (z.B. Brief, Bericht, Erörterung).",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-044",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was bedeutet 'Register' in der Textgrammatik?",
    "options": [
      "die Lautstärke beim Sprechen",
      "die Sprachebene, die zur Situation passt",
      "die Anzahl der Absätze",
      "die Reihenfolge der Wörter"
    ],
    "correctAnswer": 1,
    "explanation": "Das Register ist die Sprachebene (formell, neutral, informell), die zur Kommunikationssituation passt.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-045",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Der Film war echt cool, oder?'?",
    "options": ["formell", "neutral", "informell", "wissenschaftlich"],
    "correctAnswer": 2,
    "explanation": "'Echt cool' und die Partikel 'oder?' zeigen informelles Register an.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-046",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt eine Einschränkung aus?",
    "options": ["außerdem", "deshalb", "allerdings", "danach"],
    "correctAnswer": 2,
    "explanation": "'Allerdings' drückt eine Einschränkung oder einen Gegensatz aus.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-047",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "In welcher Textsorte findet man häufig die indirekte Rede?",
    "options": ["Einkaufsliste", "Zusammenfassung", "Postkarte", "Gedicht"],
    "correctAnswer": 1,
    "explanation": "In einer Zusammenfassung gibt man Aussagen anderer in indirekter Rede wieder.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-048",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist 'thematische Progression'?",
    "options": [
      "wenn alle Sätze gleich lang sind",
      "wenn das Rhema eines Satzes zum Thema des nächsten wird",
      "wenn ein Text immer schwieriger wird",
      "wenn das Register sich ändert"
    ],
    "correctAnswer": 1,
    "explanation": "Thematische Progression: Die neue Information (Rhema) wird im Folgesatz zur bekannten Information (Thema).",
    "subcategory": "Thema-Rhema",
    "tags": ["textgrammatik", "thema-rhema"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-049",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Das Wetter wird morgen schön.'?",
    "options": ["formell", "informell", "neutral", "umgangssprachlich"],
    "correctAnswer": 2,
    "explanation": "Dieser Satz ist sachlich und weder besonders formell noch informell - neutrales Register.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-050",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel liegt vor: 'Berlin ist die Hauptstadt. Die Metropole hat viele Sehenswürdigkeiten.'?",
    "options": ["Rekurrenz", "Ellipse", "Substitution", "Konnektoren"],
    "correctAnswer": 2,
    "explanation": "'Berlin' wird durch das Synonym 'Die Metropole' ersetzt. Das ist Substitution.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-051",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor leitet einen Nebensatz ein?",
    "options": ["deshalb", "trotzdem", "obwohl", "außerdem"],
    "correctAnswer": 2,
    "explanation": "'Obwohl' leitet einen Nebensatz ein (Verb am Ende).",
    "subcategory": "Konnektoren",
    "tags": ["textgrammatik", "konnektoren"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-052",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was kennzeichnet die Textsorte 'Anzeige'?",
    "options": ["sachlich, Präteritum", "kurze Sätze, Schlüsselwörter, Kontaktdaten", "indirekte Rede", "persönliche Meinung"],
    "correctAnswer": 1,
    "explanation": "Eine Anzeige: kurze Sätze, Schlüsselwörter, Kontaktdaten.",
    "subcategory": "Textsorten",
    "tags": ["textgrammatik", "textsorten"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-053",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Was ist der Unterschied zwischen Kohäsion und Kohärenz?",
    "options": ["kein Unterschied", "Kohäsion = sprachliche Mittel, Kohärenz = inhaltlicher Zusammenhang", "Kohäsion = Inhalt, Kohärenz = Grammatik", "beides = Textsorten"],
    "correctAnswer": 1,
    "explanation": "Kohäsion = sprachliche Mittel, Kohärenz = inhaltlicher Zusammenhang.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-054",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt 'vorher' aus?",
    "options": ["danach", "bevor", "deshalb", "trotzdem"],
    "correctAnswer": 1,
    "explanation": "'Bevor' drückt 'vorher' aus.",
    "subcategory": "Konnektoren",
    "tags": ["textgrammatik", "konnektoren"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-055",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Register hat der Satz: 'Im Folgenden werden die Ergebnisse dargestellt.'?",
    "options": ["umgangssprachlich", "informell", "formell", "neutral"],
    "correctAnswer": 2,
    "explanation": "Formelles Register.",
    "subcategory": "Register",
    "tags": ["textgrammatik", "register"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-056",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt eine Einräumung aus?",
    "options": ["deshalb", "obwohl", "außerdem", "danach"],
    "correctAnswer": 1,
    "explanation": "'Obwohl' drückt eine Einräumung aus.",
    "subcategory": "Konnektoren",
    "tags": ["textgrammatik", "konnektoren"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-057",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor verbindet zwei Hauptsätze?",
    "options": ["weil", "obwohl", "denn", "damit"],
    "correctAnswer": 2,
    "explanation": "'Denn' verbindet zwei Hauptsätze.",
    "subcategory": "Konnektoren",
    "tags": ["textgrammatik", "konnektoren"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-058",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt eine Bedingung aus?",
    "options": ["trotzdem", "deshalb", "falls", "außerdem"],
    "correctAnswer": 2,
    "explanation": "'Falls' drückt eine Bedingung aus.",
    "subcategory": "Konnektoren",
    "tags": ["textgrammatik", "konnektoren"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-059",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welcher Konnektor drückt einen Zweck aus?",
    "options": ["deshalb", "trotzdem", "damit", "außerdem"],
    "correctAnswer": 2,
    "explanation": "'Damit' drückt einen Zweck aus.",
    "subcategory": "Konnektoren",
    "tags": ["textgrammatik", "konnektoren"]
  },
  {
    "language": "german", "id": "b2-textgrammatik-p1-060",
    "level": "b2",
    "category": "Textgrammatik",
    "question": "Welches Kohäsionsmittel liegt vor: 'Der Lehrer erklärte die Aufgabe. Die Aufgabe war schwer.'?",
    "options": ["Substitution", "Pronominalisierung", "Rekurrenz", "Ellipse"],
    "correctAnswer": 2,
    "explanation": "'Die Aufgabe' wird wörtlich wiederholt. Das ist Rekurrenz.",
    "subcategory": "Kohäsion",
    "tags": ["textgrammatik", "kohaesion"]
  }
];

export default questions;
