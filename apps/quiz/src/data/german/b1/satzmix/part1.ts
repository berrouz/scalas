import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "b1-satzmix-p1-001",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welcher Artikel gehört zu 'Wind'?",
    "options": [
      "dem",
      "die",
      "das",
      "der"
    ],
    "correctAnswer": 3,
    "explanation": "'Wind' ist der Wind.",
    "grammarRule": "Maskuline Nomen: oft Personen (männl.), Tage, Monate, Jahreszeiten, Wetter",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "artikel",
      "genus",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-002",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet die 3. Person Singular Präteritum von 'singen'?",
    "options": [
      "sang",
      "sprach",
      "meinte",
      "suchte"
    ],
    "correctAnswer": 0,
    "explanation": "Das Präteritum von 'singen' ist 'er/sie sang'.",
    "exampleSentence": "Gestern sang er den ganzen Tag.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjugation",
      "praeteritum",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-003",
    "level": "b1",
    "category": "Satzmix",
    "question": "Die Präposition 'vor' ist eine Wechselpräposition. Was bedeutet das?",
    "options": [
      "nur Akkusativ",
      "Akkusativ oder Dativ",
      "nur Dativ",
      "Genitiv"
    ],
    "correctAnswer": 1,
    "explanation": "'vor' steht mit Akkusativ (Richtung/Wohin?) oder Dativ (Ort/Wo?).",
    "grammarRule": "Wechselpräpositionen: an, auf, hinter, in, neben, über, unter, vor, zwischen",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "wechsel",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-004",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'den kühl___ Bahnhof' (Akkusativ)",
    "options": [
      "kühler",
      "kühlem",
      "kühle",
      "kühlen"
    ],
    "correctAnswer": 3,
    "explanation": "Nach bestimmtem Artikel + maskulin Akkusativ: Endung -en.",
    "grammarRule": "Nach bestimmtem Artikel: Akk.mask = -en, alle Dativ/Genitiv = -en",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektivdeklination",
      "akkusativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-005",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welches Pronomen steht im Akkusativ für 'es'?",
    "options": [
      "euch",
      "es",
      "mich",
      "dich"
    ],
    "correctAnswer": 1,
    "explanation": "Das Akkusativpronomen von 'es' ist 'es'.",
    "grammarRule": "Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "pronomen",
      "akkusativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-006",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wo steht das konjugierte Verb im Nebensatz mit 'dass'?",
    "options": [
      "auf Position 1",
      "am Ende des Nebensatzes",
      "auf Position 2",
      "vor der Subjunktion"
    ],
    "correctAnswer": 1,
    "explanation": "Im Nebensatz steht das konjugierte Verb am Ende: 'Ich weiß, dass er kommt.'",
    "grammarRule": "Nebensatz: Subjunktion + ... + konjugiertes Verb (Verbletzstellung)",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "nebensaetze",
      "verbposition",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-007",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet der Konjunktiv I von 'gehen' (er/sie)?",
    "options": [
      "sage",
      "sei",
      "gehe",
      "wisse"
    ],
    "correctAnswer": 2,
    "explanation": "Der Konjunktiv I von 'gehen' ist 'er/sie gehe'. Wird für indirekte Rede verwendet.",
    "grammarRule": "Konjunktiv I = Stamm + -e (er/sie). Für indirekte Rede in formellen Texten.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjunktiv",
      "konjunktiv-i",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-008",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie bildet man das Vorgangspassiv im Präsens?",
    "options": [
      "sein + Partizip II",
      "werden + Partizip II",
      "werden + Infinitiv",
      "haben + Partizip II"
    ],
    "correctAnswer": 1,
    "explanation": "Das Vorgangspassiv wird mit 'werden' + Partizip II gebildet.",
    "exampleSentence": "Das Haus wird gebaut.",
    "grammarRule": "Vorgangspassiv: werden + Partizip II",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "passiv",
      "vorgangspassiv",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-009",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Satzstruktur folgt nach dem Konnektor 'denn'?",
    "options": [
      "Inversion (Verb-Subjekt)",
      "Hauptsatz + Nebensatz (Verb am Ende)",
      "Nebensatz + Nebensatz",
      "Hauptsatz + Hauptsatz (Position 0)"
    ],
    "correctAnswer": 3,
    "explanation": "'denn' ist ein nebenordnender Konnektor (Position 0): HS + HS, keine Inversion.",
    "grammarRule": "Nebenordnende Konnektoren (und, aber, oder, denn, sondern): Position 0, kein Einfluss auf Wortstellung",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konnektoren",
      "hauptsatz",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-010",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welcher Beispielsatz zeigt das Futur II?",
    "options": [
      "Er wird Deutsch gelernt haben.",
      "Er lernte Deutsch.",
      "Er wird Deutsch lernen.",
      "Er hatte Deutsch gelernt."
    ],
    "correctAnswer": 0,
    "explanation": "'Er wird Deutsch gelernt haben.' ist ein Beispiel für das Futur II.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "zeitformen",
      "beispiel",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-011",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie den Dativ: 'Ich helfe ___ Wert.' (der Wert)",
    "options": [
      "der",
      "des",
      "den",
      "dem"
    ],
    "correctAnswer": 3,
    "explanation": "Im Dativ: der/das → dem, die → der. Wert ist der, also: dem.",
    "grammarRule": "Dativ: der/das → dem; die → der; Plural → den + -n",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "artikel",
      "dativ",
      "kasus",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-012",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet das Partizip II von 'wachsen'?",
    "options": [
      "gewohnt",
      "gewachsen",
      "erklärt",
      "gehalten"
    ],
    "correctAnswer": 1,
    "explanation": "Das Partizip II von 'wachsen' ist 'gewachsen'.",
    "grammarRule": "Starke Verben: Stammvokalwechsel (ge-...-en). Schwache Verben: ge-...-t",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjugation",
      "partizip",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-014",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'die faul___ Woche' (Nominativ)",
    "options": [
      "fauler",
      "faule",
      "faules",
      "faulen"
    ],
    "correctAnswer": 1,
    "explanation": "Nach bestimmtem Artikel + Nominativ/Akkusativ feminin: Endung -e.",
    "grammarRule": "Schwache Deklination (nach der/die/das): meist -e oder -en",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektivdeklination",
      "schwach",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-015",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie das Reflexivpronomen: 'ihr freut ___ auf das Wochenende.'",
    "options": [
      "uns",
      "euch",
      "mich",
      "dich"
    ],
    "correctAnswer": 1,
    "explanation": "Das Reflexivpronomen für 'ihr' ist 'euch'.",
    "grammarRule": "Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "pronomen",
      "reflexiv",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-016",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Subjunktion passt: '___ es regnet, bleibe ich zu Hause.' (mögliche Bedingung)",
    "options": [
      "als",
      "falls",
      "weil",
      "während"
    ],
    "correctAnswer": 1,
    "explanation": "Für mögliche Bedingung verwendet man 'falls'.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "nebensaetze",
      "auswahl",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-017",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet der Konjunktiv II von 'tun' (er/sie)?",
    "options": [
      "täte",
      "wäre",
      "stünde",
      "sollte"
    ],
    "correctAnswer": 0,
    "explanation": "Der Konjunktiv II von 'tun' ist 'täte'.",
    "exampleSentence": "Wenn ich reich wäre, würde ich reisen.",
    "grammarRule": "Konjunktiv II: irreale Wünsche, höfliche Bitten, Bedingungssätze",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjunktiv",
      "konjunktiv-ii",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-018",
    "level": "b1",
    "category": "Satzmix",
    "question": "Formulieren Sie im Passiv: 'Die Firma stellt neue Mitarbeiter ein.'",
    "options": [
      "Ein neues Haus wird gebaut.",
      "Das Essen wird von der Mutter gekocht.",
      "Der Patient wird vom Arzt untersucht.",
      "Neue Mitarbeiter werden von der Firma eingestellt."
    ],
    "correctAnswer": 3,
    "explanation": "Im Passiv: 'Neue Mitarbeiter werden von der Firma eingestellt.' (Vorgangspassiv Präsens).",
    "grammarRule": "Aktiv → Passiv: Akkusativobjekt wird Subjekt",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "passiv",
      "umformung",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-020",
    "level": "b1",
    "category": "Satzmix",
    "question": "In welcher Zeitform steht der Satz: 'Er hatte Deutsch gelernt.'?",
    "options": [
      "Präsens",
      "Plusquamperfekt",
      "Futur II",
      "Futur I"
    ],
    "correctAnswer": 1,
    "explanation": "Der Satz steht im Plusquamperfekt: Vorvergangenheit.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "zeitformen",
      "erkennung",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-022",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet die 3. Person Singular Präteritum von 'spielen'?",
    "options": [
      "spielte",
      "meinte",
      "saß",
      "wohnte"
    ],
    "correctAnswer": 0,
    "explanation": "Das Präteritum von 'spielen' ist 'er/sie spielte'.",
    "exampleSentence": "Gestern spielte er den ganzen Tag.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjugation",
      "praeteritum",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-023",
    "level": "b1",
    "category": "Satzmix",
    "question": "Die Präposition 'an' ist eine Wechselpräposition. Was bedeutet das?",
    "options": [
      "Genitiv",
      "nur Akkusativ",
      "nur Dativ",
      "Akkusativ oder Dativ"
    ],
    "correctAnswer": 3,
    "explanation": "'an' steht mit Akkusativ (Richtung/Wohin?) oder Dativ (Ort/Wo?).",
    "grammarRule": "Wechselpräpositionen: an, auf, hinter, in, neben, über, unter, vor, zwischen",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "wechsel",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-024",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'den nötig___ Fluss' (Akkusativ)",
    "options": [
      "nötige",
      "nötigem",
      "nötigen",
      "nötiger"
    ],
    "correctAnswer": 2,
    "explanation": "Nach bestimmtem Artikel + maskulin Akkusativ: Endung -en.",
    "grammarRule": "Nach bestimmtem Artikel: Akk.mask = -en, alle Dativ/Genitiv = -en",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektivdeklination",
      "akkusativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-025",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welches Pronomen steht im Akkusativ für 'ich'?",
    "options": [
      "keine Angabe",
      "mich",
      "dich",
      "sie"
    ],
    "correctAnswer": 1,
    "explanation": "Das Akkusativpronomen von 'ich' ist 'mich'.",
    "grammarRule": "Akkusativ: mich, dich, ihn, sie, es, uns, euch, sie/Sie",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "pronomen",
      "akkusativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-026",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Bedeutung hat die Subjunktion 'während'?",
    "options": [
      "Gleichzeitigkeit",
      "Anfangszeitpunkt",
      "Grund/Ursache",
      "indirekte Ja/Nein-Frage"
    ],
    "correctAnswer": 0,
    "explanation": "'während' drückt Gleichzeitigkeit aus.",
    "exampleSentence": "Während ich koche, liest er die Zeitung.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "nebensaetze",
      "subjunktion",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-027",
    "level": "b1",
    "category": "Satzmix",
    "question": "Was drückt der Satz 'Wenn ich Zeit hätte, würde ich kommen.' aus?",
    "options": [
      "Zustandspassiv",
      "Aufforderung",
      "irreale Bedingung",
      "direkte Rede"
    ],
    "correctAnswer": 2,
    "explanation": "Der Konjunktiv II drückt hier eine irreale Bedingung aus — die Person hat keine Zeit.",
    "grammarRule": "Wenn + Konjunktiv II, ... würde + Infinitiv (irrealer Bedingungssatz)",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjunktiv",
      "irrealis",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-028",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Passivform liegt vor: 'Das Buch wird gelesen.'?",
    "options": [
      "Aktiv",
      "Reflexiv",
      "Zustandspassiv",
      "Vorgangspassiv"
    ],
    "correctAnswer": 3,
    "explanation": "'wird + Partizip II' = Vorgangspassiv. Zustandspassiv wäre: 'ist gelesen'.",
    "grammarRule": "werden + P.II = Vorgangspassiv; sein + P.II = Zustandspassiv",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "passiv",
      "erkennung",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-030",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wofür wird das Präteritum hauptsächlich verwendet?",
    "options": [
      "Zukunft / Vermutung",
      "Vorvergangenheit",
      "Gegenwart / allgemeine Aussagen",
      "Vergangenheit (schriftlich/Erzählung)"
    ],
    "correctAnswer": 3,
    "explanation": "Das Präteritum wird für Vergangenheit (schriftlich/Erzählung) verwendet.",
    "exampleSentence": "Er lernte Deutsch.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "zeitformen",
      "verwendung",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-031",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie den Dativ: 'Ich helfe ___ Ofen.' (der Ofen)",
    "options": [
      "dem",
      "des",
      "der",
      "den"
    ],
    "correctAnswer": 0,
    "explanation": "Im Dativ: der/das → dem, die → der. Ofen ist der, also: dem.",
    "grammarRule": "Dativ: der/das → dem; die → der; Plural → den + -n",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "artikel",
      "dativ",
      "kasus",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-032",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet das Partizip II von 'hören'?",
    "options": [
      "gebeten",
      "gehört",
      "geholfen",
      "verschwunden"
    ],
    "correctAnswer": 1,
    "explanation": "Das Partizip II von 'hören' ist 'gehört'.",
    "grammarRule": "Starke Verben: Stammvokalwechsel (ge-...-en). Schwache Verben: ge-...-t",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjugation",
      "partizip",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-033",
    "level": "b1",
    "category": "Satzmix",
    "question": "Die Präposition 'auf' ist eine Wechselpräposition. Was bedeutet das?",
    "options": [
      "Akkusativ oder Dativ",
      "nur Akkusativ",
      "nur Dativ",
      "Genitiv"
    ],
    "correctAnswer": 0,
    "explanation": "'auf' steht mit Akkusativ (Richtung/Wohin?) oder Dativ (Ort/Wo?).",
    "grammarRule": "Wechselpräpositionen: an, auf, hinter, in, neben, über, unter, vor, zwischen",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "wechsel",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-034",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'die gefährlich___ Schwierigkeit' (Nominativ)",
    "options": [
      "gefährlichen",
      "gefährliches",
      "gefährliche",
      "gefährlicher"
    ],
    "correctAnswer": 2,
    "explanation": "Nach bestimmtem Artikel + Nominativ/Akkusativ feminin: Endung -e.",
    "grammarRule": "Schwache Deklination (nach der/die/das): meist -e oder -en",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektivdeklination",
      "schwach",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-035",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie das Reflexivpronomen: 'ich freue ___ auf das Wochenende.'",
    "options": [
      "dich",
      "euch",
      "uns",
      "mich"
    ],
    "correctAnswer": 3,
    "explanation": "Das Reflexivpronomen für 'ich' ist 'mich'.",
    "grammarRule": "Reflexivpronomen = Akkusativ-Personalpronomen, außer 3.P. → sich",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "pronomen",
      "reflexiv",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-036",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wo steht das konjugierte Verb im Nebensatz mit 'nachdem'?",
    "options": [
      "am Ende des Nebensatzes",
      "vor der Subjunktion",
      "auf Position 1",
      "auf Position 2"
    ],
    "correctAnswer": 0,
    "explanation": "Im Nebensatz steht das konjugierte Verb am Ende: 'Nachdem er gegessen hatte, ging er spazieren.'",
    "grammarRule": "Nebensatz: Subjunktion + ... + konjugiertes Verb (Verbletzstellung)",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "nebensaetze",
      "verbposition",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-039",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Satzstruktur folgt bei Satzadverbien wie 'daher'?",
    "options": [
      "Nebensatz (Verb am Ende)",
      "Hauptsatz ohne Inversion",
      "Infinitivsatz",
      "Hauptsatz mit Inversion (Adverb + Verb + Subjekt)"
    ],
    "correctAnswer": 3,
    "explanation": "'daher' steht auf Position 1, dann folgt Inversion: daher, Verb, Subjekt...",
    "grammarRule": "Satzadverbien (deshalb, trotzdem, etc.): Position 1 + Inversion",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konnektoren",
      "adverb",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-041",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welcher Artikel gehört zu 'Frühling'?",
    "options": [
      "das",
      "dem",
      "der",
      "die"
    ],
    "correctAnswer": 2,
    "explanation": "'Frühling' ist der Frühling.",
    "grammarRule": "Maskuline Nomen: oft Personen (männl.), Tage, Monate, Jahreszeiten, Wetter",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "artikel",
      "genus",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-042",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet die 3. Person Singular Präteritum von 'kommen'?",
    "options": [
      "erzählte",
      "gewann",
      "kam",
      "schlief"
    ],
    "correctAnswer": 2,
    "explanation": "Das Präteritum von 'kommen' ist 'er/sie kam'.",
    "exampleSentence": "Gestern kam er den ganzen Tag.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjugation",
      "praeteritum",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-043",
    "level": "b1",
    "category": "Satzmix",
    "question": "Die Präposition 'hinter' ist eine Wechselpräposition. Was bedeutet das?",
    "options": [
      "Genitiv",
      "nur Dativ",
      "Akkusativ oder Dativ",
      "nur Akkusativ"
    ],
    "correctAnswer": 2,
    "explanation": "'hinter' steht mit Akkusativ (Richtung/Wohin?) oder Dativ (Ort/Wo?).",
    "grammarRule": "Wechselpräpositionen: an, auf, hinter, in, neben, über, unter, vor, zwischen",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "wechsel",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-044",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'den neu___ Kaffee' (Akkusativ)",
    "options": [
      "neue",
      "neuen",
      "neuer",
      "neuem"
    ],
    "correctAnswer": 1,
    "explanation": "Nach bestimmtem Artikel + maskulin Akkusativ: Endung -en.",
    "grammarRule": "Nach bestimmtem Artikel: Akk.mask = -en, alle Dativ/Genitiv = -en",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektivdeklination",
      "akkusativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-046",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Subjunktion passt: '___ es regnet, bleibe ich zu Hause.' (Gegengrund/Konzession)",
    "options": [
      "nachdem",
      "obwohl",
      "damit",
      "ob"
    ],
    "correctAnswer": 1,
    "explanation": "Für Gegengrund/Konzession verwendet man 'obwohl'.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "nebensaetze",
      "auswahl",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-047",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet der Konjunktiv II von 'wollen' (er/sie)?",
    "options": [
      "wollte",
      "müsste",
      "gäbe",
      "hätte"
    ],
    "correctAnswer": 0,
    "explanation": "Der Konjunktiv II von 'wollen' ist 'wollte'.",
    "exampleSentence": "Wenn ich reich wäre, würde ich reisen.",
    "grammarRule": "Konjunktiv II: irreale Wünsche, höfliche Bitten, Bedingungssätze",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjunktiv",
      "konjunktiv-ii",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-048",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welcher Artikel gehört zu 'Mädchen'?",
    "options": [
      "die",
      "der",
      "das",
      "dem"
    ],
    "correctAnswer": 2,
    "explanation": "'Mädchen' ist das Mädchen. Nomen mit -chen sind immer Neutrum.",
    "grammarRule": "Neutrale Nomen: oft -chen, -lein, -um, -ment, Ge-...-e",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "artikel",
      "genus",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-049",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'Ich interessiere mich ___ Musik.' (Präposition)",
    "options": [
      "an",
      "für",
      "auf",
      "über"
    ],
    "correctAnswer": 1,
    "explanation": "Das Verb 'sich interessieren' verlangt die Präposition 'für'.",
    "grammarRule": "Feste Verb-Präposition-Verbindungen: sich interessieren für + Akk.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "verben",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-050",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie den Genitiv: 'das Auto ___ Vaters' (der Vater)",
    "options": [
      "dem",
      "den",
      "der",
      "des"
    ],
    "correctAnswer": 3,
    "explanation": "Im Genitiv maskulin/neutrum: der/das → des (+ -s/-es am Nomen).",
    "grammarRule": "Genitiv: der/das → des (+s/es); die → der; Plural → der",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "artikel",
      "genitiv",
      "kasus",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-051",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welches Verb verlangt den Dativ?",
    "options": [
      "sehen",
      "brauchen",
      "helfen",
      "kennen"
    ],
    "correctAnswer": 2,
    "explanation": "'helfen' verlangt den Dativ: Ich helfe dem Kind.",
    "grammarRule": "Dativverben: helfen, danken, gefallen, gehören, passen, schmecken, etc.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "verben",
      "dativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-052",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet die Komparativform von 'gut'?",
    "options": [
      "güter",
      "besser",
      "guter",
      "mehr gut"
    ],
    "correctAnswer": 1,
    "explanation": "Der Komparativ von 'gut' ist 'besser' (unregelmäßig).",
    "grammarRule": "Unregelmäßige Steigerung: gut – besser – am besten",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektive",
      "komparativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-053",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'Er wartet ___ den Bus.' (Präposition)",
    "options": [
      "für",
      "an",
      "auf",
      "über"
    ],
    "correctAnswer": 2,
    "explanation": "'warten auf' + Akkusativ: Er wartet auf den Bus.",
    "grammarRule": "Feste Verb-Präposition-Verbindungen: warten auf + Akk.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "verben",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-054",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welcher Satz enthält einen Relativsatz?",
    "options": [
      "Er geht nach Hause, weil er müde ist.",
      "Der Mann, der dort steht, ist mein Lehrer.",
      "Wenn es regnet, bleibe ich drinnen.",
      "Ich weiß, dass er kommt."
    ],
    "correctAnswer": 1,
    "explanation": "'Der Mann, der dort steht, ist mein Lehrer.' enthält einen Relativsatz mit dem Relativpronomen 'der'.",
    "grammarRule": "Relativsätze: Relativpronomen (der/die/das/...) + Verb am Ende",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "relativsaetze",
      "erkennung",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-055",
    "level": "b1",
    "category": "Satzmix",
    "question": "Ergänzen Sie: 'ein groß___ Haus' (Nominativ, ohne Artikel)",
    "options": [
      "große",
      "großer",
      "großes",
      "großen"
    ],
    "correctAnswer": 2,
    "explanation": "Ohne Artikel + Nominativ neutrum: starke Deklination, Endung -es.",
    "grammarRule": "Starke Deklination (ohne Artikel): Adjektiv übernimmt Artikelendung",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "adjektivdeklination",
      "stark",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-056",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Präposition verlangt immer den Dativ?",
    "options": [
      "durch",
      "für",
      "mit",
      "gegen"
    ],
    "correctAnswer": 2,
    "explanation": "'mit' verlangt immer den Dativ: mit dem Freund, mit der Arbeit.",
    "grammarRule": "Dativpräpositionen: mit, nach, bei, seit, von, zu, aus, außer, gegenüber",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "praepositionen",
      "dativ",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-057",
    "level": "b1",
    "category": "Satzmix",
    "question": "Wie lautet die 3. Person Singular Präteritum von 'lesen'?",
    "options": [
      "las",
      "leste",
      "liest",
      "gelesen"
    ],
    "correctAnswer": 0,
    "explanation": "Das Präteritum von 'lesen' ist 'er/sie las' (starkes Verb).",
    "exampleSentence": "Sie las den ganzen Abend ein Buch.",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "konjugation",
      "praeteritum",
      "satzmix"
    ]
  },
  {
    "language": "german", "id": "b1-satzmix-p1-058",
    "level": "b1",
    "category": "Satzmix",
    "question": "Welche Konjunktion leitet einen Finalsatz ein?",
    "options": [
      "obwohl",
      "damit",
      "nachdem",
      "weil"
    ],
    "correctAnswer": 1,
    "explanation": "'damit' leitet einen Finalsatz (Zweck/Absicht) ein: Ich lerne, damit ich die Prüfung bestehe.",
    "grammarRule": "Finalsatz: damit + Nebensatz (Verb am Ende) = Zweck/Absicht",
    "subcategory": "Gemischte Grammatik",
    "tags": [
      "nebensaetze",
      "finalsatz",
      "satzmix"
    ]
  }
];

export default questions;
