import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "german", "id": "c1-satzbildung-p1-005",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Wortstellung",
    "question": "Bilde einen korrekten Satz: gestern / ich / ins Kino / gehen",
    "options": [
      "Ins Kino gestern ich bin gegangen.",
      "Gestern bin ich ins Kino gegangen.",
      "Gestern ich bin ins Kino gegangen.",
      "Ich gestern ins Kino bin gegangen."
    ],
    "correctAnswer": 1,
    "explanation": "Die richtige Reihenfolge ist: 'Gestern bin ich ins Kino gegangen.'. Regel: Inversion: Zeitangabe + Verb + Subjekt.",
    "exampleSentence": "Gestern bin ich ins Kino gegangen.",
    "grammarRule": "Inversion: Zeitangabe + Verb + Subjekt",
    "tags": ["satzbildung", "wortstellung"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-006",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Wortstellung",
    "question": "Bilde einen korrekten Satz: meine Schwester / jeden Tag / Sport / machen",
    "options": [
      "Meine Schwester jeden Tag Sport macht.",
      "Jeden Tag meine Schwester macht Sport.",
      "Sport macht meine Schwester jeden Tag.",
      "Meine Schwester macht jeden Tag Sport."
    ],
    "correctAnswer": 3,
    "explanation": "Die richtige Reihenfolge ist: 'Meine Schwester macht jeden Tag Sport.'. Regel: SVO-Reihenfolge.",
    "exampleSentence": "Meine Schwester macht jeden Tag Sport.",
    "grammarRule": "SVO-Reihenfolge",
    "tags": ["satzbildung", "wortstellung"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-009",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Wortstellung",
    "question": "Bilde einen korrekten Satz: weil / er / krank / sein / bleiben / zu Hause",
    "options": [
      "Er bleibt zu Hause, weil er krank ist.",
      "Weil er krank ist, er bleibt zu Hause.",
      "Er bleibt weil er krank ist zu Hause.",
      "Er bleibt zu Hause, weil er ist krank."
    ],
    "correctAnswer": 0,
    "explanation": "Die richtige Reihenfolge ist: 'Er bleibt zu Hause, weil er krank ist.'. Regel: Nebensatz: Verb am Ende.",
    "exampleSentence": "Er bleibt zu Hause, weil er krank ist.",
    "grammarRule": "Nebensatz: Verb am Ende",
    "tags": ["satzbildung", "wortstellung"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-012",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Wortstellung",
    "question": "Bilde einen korrekten Satz: ich / sich / auf die Prüfung / vorbereiten",
    "options": [
      "Mich bereite ich auf die Prüfung vor.",
      "Ich vorbereite mich auf die Prüfung.",
      "Ich bereite mich auf die Prüfung vor.",
      "Ich bereite auf die Prüfung mich vor."
    ],
    "correctAnswer": 2,
    "explanation": "Die richtige Reihenfolge ist: 'Ich bereite mich auf die Prüfung vor.'. Regel: Trennbares Verb + Reflexivpronomen.",
    "exampleSentence": "Ich bereite mich auf die Prüfung vor.",
    "grammarRule": "Trennbares Verb + Reflexivpronomen",
    "tags": ["satzbildung", "wortstellung"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-013",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die Durchführung des Experiments erfolgte unter strengen Sicherheitsvorkehrungen.",
      "Die Durchführung des Experiments erfolgt unter strengen Sicherheitsvorkehrungen wurde.",
      "Die Durchführung von dem Experiment erfolgte unter strengen Sicherheitsvorkehrungen.",
      "Des Experiments Durchführung erfolgte unter strengen Sicherheitsvorkehrungen."
    ],
    "correctAnswer": 0,
    "explanation": "Im Nominalstil wird das Verb ('durchführen') zum Nomen ('Durchführung') mit Genitiv-Ergänzung ('des Experiments').",
    "exampleSentence": "Die Durchführung des Experiments erfolgte unter strengen Sicherheitsvorkehrungen.",
    "grammarRule": "Nominalstil mit Genitiv-Ergänzung",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-014",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Von der langen Reise erschöpft, legte er sich sofort ins Bett.",
      "Von der langen Reise erschöpft, er legte sich sofort ins Bett.",
      "Erschöpft von der langen Reise, er sich sofort ins Bett legte.",
      "Von der langen Reise erschöpft legte, er sich sofort ins Bett."
    ],
    "correctAnswer": 0,
    "explanation": "Die Partizipialgruppe ('Von der langen Reise erschöpft') steht am Satzanfang, gefolgt von einem Komma und dem Hauptsatz mit Inversion.",
    "exampleSentence": "Von der langen Reise erschöpft, legte er sich sofort ins Bett.",
    "grammarRule": "Partizipialgruppe (Partizip II) am Satzanfang",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-015",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Nicht nur besticht das Werk durch seine Originalität, sondern es regt auch zum Nachdenken an.",
      "Nicht nur das Werk besticht durch seine Originalität, sondern regt es auch zum Nachdenken an.",
      "Nicht nur besticht das Werk durch seine Originalität, sondern auch es regt zum Nachdenken an.",
      "Nicht nur durch seine Originalität besticht das Werk, sondern regt auch es zum Nachdenken an."
    ],
    "correctAnswer": 0,
    "explanation": "'Nicht nur ... sondern auch' mit Inversion im ersten Satz: Verb vor Subjekt. Der zweite Satz hat normale Wortstellung.",
    "exampleSentence": "Nicht nur besticht das Werk durch seine Originalität, sondern es regt auch zum Nachdenken an.",
    "grammarRule": "Gehobene Inversion mit 'nicht nur ... sondern auch'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-016",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die Veröffentlichung der Ergebnisse führte zu einer lebhaften Debatte.",
      "Die Veröffentlichung den Ergebnissen führte zu einer lebhaften Debatte.",
      "Die Ergebnisse Veröffentlichung führte zu einer lebhaften Debatte.",
      "Die Veröffentlichung der Ergebnissen führte zu einer lebhaften Debatte."
    ],
    "correctAnswer": 0,
    "explanation": "Im Nominalstil steht der Genitiv ('der Ergebnisse') als Attribut zum Nomen ('Veröffentlichung'). Genitiv Plural: 'der' + Nomen.",
    "exampleSentence": "Die Veröffentlichung der Ergebnisse führte zu einer lebhaften Debatte.",
    "grammarRule": "Nominalstil: Verbalnomen + Genitiv",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-017",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die sich rasch verbreitende Nachricht sorgte für Aufregung.",
      "Die sich rasch verbreitete Nachricht sorgte für Aufregung.",
      "Die rasch sich verbreitende Nachricht sorgte für Aufregung.",
      "Die verbreitende sich rasch Nachricht sorgte für Aufregung."
    ],
    "correctAnswer": 0,
    "explanation": "Das erweiterte Partizip I ('sich rasch verbreitende') steht als Attribut vor dem Nomen. Das Reflexivpronomen steht vor dem Adverb.",
    "exampleSentence": "Die sich rasch verbreitende Nachricht sorgte für Aufregung.",
    "grammarRule": "Erweitertes Partizip I als Attribut",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-018",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Sei es aus Unwissenheit, sei es aus Nachlässigkeit, der Fehler hätte vermieden werden können.",
      "Sei es aus Unwissenheit, sei es aus Nachlässigkeit, hätte der Fehler vermieden werden können.",
      "Es sei aus Unwissenheit, es sei aus Nachlässigkeit, der Fehler hätte vermieden werden können.",
      "Sei es aus Unwissenheit oder aus Nachlässigkeit, hätte der Fehler vermieden werden können."
    ],
    "correctAnswer": 0,
    "explanation": "'Sei es ... sei es ...' ist eine gehobene konzessive Konstruktion. Der Hauptsatz folgt mit normaler Wortstellung.",
    "exampleSentence": "Sei es aus Unwissenheit, sei es aus Nachlässigkeit, der Fehler hätte vermieden werden können.",
    "grammarRule": "Konzessive Konstruktion 'sei es ... sei es'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-019",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Unter Berücksichtigung aller Umstände wurde die Entscheidung getroffen.",
      "Unter Berücksichtigung alle Umstände wurde die Entscheidung getroffen.",
      "Unter Berücksichtigung allen Umständen wurde die Entscheidung getroffen.",
      "Unter die Berücksichtigung aller Umstände wurde die Entscheidung getroffen."
    ],
    "correctAnswer": 0,
    "explanation": "'Unter Berücksichtigung' + Genitiv ist eine typische Nominalstilkonstruktion: 'aller Umstände' (Genitiv Plural).",
    "exampleSentence": "Unter Berücksichtigung aller Umstände wurde die Entscheidung getroffen.",
    "grammarRule": "Nominalstil: Präposition + Verbalnomen + Genitiv",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-020",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "In der Hoffnung, bald eine Antwort zu erhalten, wartete sie geduldig.",
      "In der Hoffnung, bald eine Antwort erhalten zu, wartete sie geduldig.",
      "In der Hoffnung bald eine Antwort zu erhalten wartete sie geduldig.",
      "In der Hoffnung, bald zu erhalten eine Antwort, wartete sie geduldig."
    ],
    "correctAnswer": 0,
    "explanation": "Die Infinitivgruppe ('bald eine Antwort zu erhalten') ergänzt das Nomen 'Hoffnung'. 'Zu' steht direkt vor dem Infinitiv am Ende.",
    "exampleSentence": "In der Hoffnung, bald eine Antwort zu erhalten, wartete sie geduldig.",
    "grammarRule": "Infinitivgruppe als Attribut zu einem Nomen",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-022",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die Inanspruchnahme staatlicher Leistungen setzt einen Antrag voraus.",
      "Die Inanspruchnahme staatlichen Leistungen setzt einen Antrag voraus.",
      "Die Inanspruchnahme von staatliche Leistungen setzt einen Antrag voraus.",
      "Die staatlichen Leistungen Inanspruchnahme setzt einen Antrag voraus."
    ],
    "correctAnswer": 0,
    "explanation": "'Inanspruchnahme' + Genitiv ('staatlicher Leistungen'). Im Nominalstil werden Verben durch Nomen ersetzt, Ergänzungen stehen im Genitiv.",
    "exampleSentence": "Die Inanspruchnahme staatlicher Leistungen setzt einen Antrag voraus.",
    "grammarRule": "Nominalstil: Verbalnomen + Genitiv ohne Artikel",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-023",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die von der Regierung beschlossenen Maßnahmen treten morgen in Kraft.",
      "Die von der Regierung beschlossen Maßnahmen treten morgen in Kraft.",
      "Die beschlossenen von der Regierung Maßnahmen treten morgen in Kraft.",
      "Die von der Regierung beschlossene Maßnahmen treten morgen in Kraft."
    ],
    "correctAnswer": 0,
    "explanation": "Erweitertes Partizip II als Attribut: 'die von der Regierung beschlossenen Maßnahmen'. Das Partizip wird wie ein Adjektiv dekliniert.",
    "exampleSentence": "Die von der Regierung beschlossenen Maßnahmen treten morgen in Kraft.",
    "grammarRule": "Erweitertes Partizip II als Attribut",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-024",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Er behauptete, den Vorfall nicht bemerkt zu haben.",
      "Er behauptete, den Vorfall nicht zu bemerkt haben.",
      "Er behauptete, nicht bemerkt zu haben den Vorfall.",
      "Er behauptete, den Vorfall zu nicht bemerkt haben."
    ],
    "correctAnswer": 0,
    "explanation": "Die Infinitivkonstruktion der Vergangenheit: 'bemerkt zu haben'. Das Objekt ('den Vorfall') und die Negation ('nicht') stehen vor dem Infinitiv.",
    "exampleSentence": "Er behauptete, den Vorfall nicht bemerkt zu haben.",
    "grammarRule": "Infinitiv Perfekt in Infinitivkonstruktionen",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-025",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Zur Vermeidung von Missverständnissen sollten die Regeln klar formuliert werden.",
      "Zur Vermeidung der Missverständnissen sollten die Regeln klar formuliert werden.",
      "Zur Vermeidung Missverständnisse sollten die Regeln klar formuliert werden.",
      "Zu Vermeidung von Missverständnissen sollten die Regeln klar formuliert werden."
    ],
    "correctAnswer": 0,
    "explanation": "'Zur Vermeidung von + Dativ' ist eine Nominalstilkonstruktion. 'Von Missverständnissen' steht im Dativ Plural.",
    "exampleSentence": "Zur Vermeidung von Missverständnissen sollten die Regeln klar formuliert werden.",
    "grammarRule": "Nominalstil: 'zur' + Verbalnomen + 'von' + Dativ",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-026",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Alle einschlägigen Vorschriften beachtend, führte er das Projekt durch.",
      "Alle einschlägigen Vorschriften beachtet, führte er das Projekt durch.",
      "Beachtend alle einschlägigen Vorschriften, führte er das Projekt durch.",
      "Alle einschlägigen Vorschriften beachtend führte, er das Projekt durch."
    ],
    "correctAnswer": 0,
    "explanation": "Die Partizipialgruppe mit Partizip I ('beachtend') drückt Gleichzeitigkeit aus. Das Objekt steht vor dem Partizip.",
    "exampleSentence": "Alle einschlägigen Vorschriften beachtend, führte er das Projekt durch.",
    "grammarRule": "Partizipialgruppe mit Partizip I (gleichzeitig)",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-027",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Kaum hatte er die Nachricht erhalten, als er auch schon losrannte.",
      "Kaum er hatte die Nachricht erhalten, als er auch schon losrannte.",
      "Kaum hatte er die Nachricht erhalten, er rannte auch schon los.",
      "Kaum hat er die Nachricht erhalten, als er auch schon losrannte."
    ],
    "correctAnswer": 0,
    "explanation": "'Kaum ... als' ist eine gehobene temporale Konstruktion. 'Kaum' mit Inversion, 'als' leitet den zweiten Teil ein.",
    "exampleSentence": "Kaum hatte er die Nachricht erhalten, als er auch schon losrannte.",
    "grammarRule": "Temporale Konstruktion 'kaum ... als'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-028",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die Einführung neuer Technologien erfordert umfangreiche Schulungen.",
      "Die Einführung neuen Technologien erfordert umfangreiche Schulungen.",
      "Die Einführung von neue Technologien erfordert umfangreiche Schulungen.",
      "Die neuen Technologien Einführung erfordert umfangreiche Schulungen."
    ],
    "correctAnswer": 0,
    "explanation": "'Einführung' + Genitiv Plural ohne Artikel: 'neuer Technologien'. Die Adjektivendung '-er' zeigt den Genitiv Plural an.",
    "exampleSentence": "Die Einführung neuer Technologien erfordert umfangreiche Schulungen.",
    "grammarRule": "Nominalstil: Genitiv Plural ohne Artikel",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-029",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Angesichts der drohenden Gefahr sofort handelnd, rettete er das Kind.",
      "Sofort handelnd angesichts der drohenden Gefahr, rettete er das Kind.",
      "Angesichts der drohenden Gefahr sofort gehandelt, rettete er das Kind.",
      "Angesichts der drohenden Gefahr sofort handelnd, er rettete das Kind."
    ],
    "correctAnswer": 0,
    "explanation": "Die erweiterte Partizipialgruppe mit Partizip I ('handelnd') steht vor dem Hauptsatz. Der Hauptsatz hat Inversion.",
    "exampleSentence": "Angesichts der drohenden Gefahr sofort handelnd, rettete er das Kind.",
    "grammarRule": "Erweiterte Partizipialgruppe mit Partizip I",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-030",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Möge es ihm gelingen, seine Ziele zu erreichen.",
      "Möge es ihm gelingt, seine Ziele zu erreichen.",
      "Es möge ihm gelingen, seine Ziele zu erreichen.",
      "Möge ihm es gelingen, seine Ziele zu erreichen."
    ],
    "correctAnswer": 0,
    "explanation": "'Möge' (Konjunktiv I) drückt einen Wunsch aus. Verb-Erst-Stellung: 'Möge es ihm gelingen'.",
    "exampleSentence": "Möge es ihm gelingen, seine Ziele zu erreichen.",
    "grammarRule": "Optativ mit Konjunktiv I 'möge'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-031",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Bei Nichtbeachtung der Vorschriften drohen empfindliche Strafen.",
      "Bei Nichtbeachtung den Vorschriften drohen empfindliche Strafen.",
      "Bei die Nichtbeachtung der Vorschriften drohen empfindliche Strafen.",
      "Bei Nichtbeachtung von den Vorschriften drohen empfindliche Strafen."
    ],
    "correctAnswer": 0,
    "explanation": "'Bei Nichtbeachtung' + Genitiv ist eine Nominalstilkonstruktion: 'der Vorschriften' (Genitiv Plural).",
    "exampleSentence": "Bei Nichtbeachtung der Vorschriften drohen empfindliche Strafen.",
    "grammarRule": "Nominalstil: 'bei' + Verbalnomen + Genitiv",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-032",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Der seit Langem geplante Umbau des Gebäudes beginnt nächsten Monat.",
      "Der seit Langem geplanter Umbau des Gebäudes beginnt nächsten Monat.",
      "Der geplante seit Langem Umbau des Gebäudes beginnt nächsten Monat.",
      "Der seit Langem geplanten Umbau des Gebäudes beginnt nächsten Monat."
    ],
    "correctAnswer": 0,
    "explanation": "Erweitertes Partizip II als Attribut: 'der seit Langem geplante Umbau'. Das Partizip wird wie ein Adjektiv dekliniert (Nominativ maskulin: '-e').",
    "exampleSentence": "Der seit Langem geplante Umbau des Gebäudes beginnt nächsten Monat.",
    "grammarRule": "Erweitertes Partizip II (temporal erweitert)",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-033",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "So mancher, der sich sicher glaubte, wurde eines Besseren belehrt.",
      "So mancher, der sich sicher glaubte, wurde eines Besseres belehrt.",
      "So mancher, der sich sicher geglaubt, wurde eines Besseren belehrt.",
      "So mancher, der sich sicher glaubte, wurde ein Besseren belehrt."
    ],
    "correctAnswer": 0,
    "explanation": "'Eines Besseren belehrt werden' ist eine feste gehobene Wendung mit Genitiv. 'Besseren' ist substantiviertes Adjektiv im Genitiv.",
    "exampleSentence": "So mancher, der sich sicher glaubte, wurde eines Besseren belehrt.",
    "grammarRule": "Feste Wendung mit Genitiv: 'eines Besseren belehren'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-034",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die Erhöhung der Beiträge stößt auf erheblichen Widerstand.",
      "Die Erhöhung den Beiträgen stößt auf erheblichen Widerstand.",
      "Die Beiträge Erhöhung stößt auf erheblichen Widerstand.",
      "Die Erhöhung die Beiträge stößt auf erheblichen Widerstand."
    ],
    "correctAnswer": 0,
    "explanation": "Im Nominalstil: 'Erhöhung' + Genitiv ('der Beiträge'). Das Nomen ersetzt das Verb 'erhöhen'.",
    "exampleSentence": "Die Erhöhung der Beiträge stößt auf erheblichen Widerstand.",
    "grammarRule": "Nominalstil: Verbalnomen + Genitiv Plural",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-035",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Auf seine langjährige Erfahrung vertrauend, übernahm er die schwierige Aufgabe.",
      "Auf seine langjährige Erfahrung vertraut, übernahm er die schwierige Aufgabe.",
      "Vertrauend auf seine langjährige Erfahrung, übernahm er die schwierige Aufgabe.",
      "Auf seine langjährige Erfahrung vertrauend übernahm, er die schwierige Aufgabe."
    ],
    "correctAnswer": 0,
    "explanation": "Die Partizipialgruppe mit Partizip I ('vertrauend') drückt Gleichzeitigkeit/Grund aus. Die Präpositionalgruppe steht vor dem Partizip.",
    "exampleSentence": "Auf seine langjährige Erfahrung vertrauend, übernahm er die schwierige Aufgabe.",
    "grammarRule": "Partizipialgruppe mit Partizip I (kausal)",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-036",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Wäre es auch noch so schwierig, er würde nicht aufgeben.",
      "Wäre es auch noch so schwierig, würde er nicht aufgeben.",
      "Es wäre auch noch so schwierig, er würde nicht aufgeben.",
      "Auch noch so schwierig wäre es, er würde nicht aufgeben."
    ],
    "correctAnswer": 0,
    "explanation": "'Wäre es auch noch so ...' ist eine gehobene konzessive Konstruktion im Konjunktiv II. Der Hauptsatz hat normale Wortstellung.",
    "exampleSentence": "Wäre es auch noch so schwierig, er würde nicht aufgeben.",
    "grammarRule": "Konzessiver Konjunktiv 'wäre ... auch noch so'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-037",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Infolge der Kürzung des Budgets mussten mehrere Projekte eingestellt werden.",
      "Infolge die Kürzung des Budgets mussten mehrere Projekte eingestellt werden.",
      "Infolge der Kürzung dem Budget mussten mehrere Projekte eingestellt werden.",
      "Infolge Kürzung des Budgets mussten mehrere Projekte eingestellt werden."
    ],
    "correctAnswer": 0,
    "explanation": "'Infolge' + Genitiv ('der Kürzung') in einer Nominalstilkonstruktion. 'Des Budgets' ist wiederum Genitiv-Attribut zu 'Kürzung'.",
    "exampleSentence": "Infolge der Kürzung des Budgets mussten mehrere Projekte eingestellt werden.",
    "grammarRule": "Nominalstil: verschachtelte Genitive",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-038",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Das in mehreren Sprachen verfasste Dokument liegt dem Antrag bei.",
      "Das in mehreren Sprachen verfasstes Dokument liegt dem Antrag bei.",
      "Das verfasste in mehreren Sprachen Dokument liegt dem Antrag bei.",
      "Das in mehreren Sprachen verfassten Dokument liegt dem Antrag bei."
    ],
    "correctAnswer": 0,
    "explanation": "Erweitertes Partizip II: 'das in mehreren Sprachen verfasste Dokument'. Neutrum Nominativ: '-e' Endung am Partizip.",
    "exampleSentence": "Das in mehreren Sprachen verfasste Dokument liegt dem Antrag bei.",
    "grammarRule": "Erweitertes Partizip II mit Präpositionalgruppe",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-039",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Es sei darauf hingewiesen, dass die Frist am Montag abläuft.",
      "Es wird darauf hingewiesen, dass die Frist am Montag abläuft.",
      "Es sei darauf hinweisen, dass die Frist am Montag abläuft.",
      "Es sei darauf hingewiesen, dass die Frist am Montag ablauft."
    ],
    "correctAnswer": 0,
    "explanation": "'Es sei darauf hingewiesen' verwendet den Konjunktiv I Passiv für eine distanzierte, formelle Aussage.",
    "exampleSentence": "Es sei darauf hingewiesen, dass die Frist am Montag abläuft.",
    "grammarRule": "Konjunktiv I Passiv in formeller Sprache",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-040",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Im Hinblick auf die bevorstehende Prüfung sollten alle Teilnehmer rechtzeitig erscheinen.",
      "Im Hinblick auf der bevorstehenden Prüfung sollten alle Teilnehmer rechtzeitig erscheinen.",
      "In Hinblick auf die bevorstehende Prüfung sollten alle Teilnehmer rechtzeitig erscheinen.",
      "Im Hinblick auf die bevorstehenden Prüfung sollten alle Teilnehmer rechtzeitig erscheinen."
    ],
    "correctAnswer": 0,
    "explanation": "'Im Hinblick auf' + Akkusativ: 'die bevorstehende Prüfung'. Diese Konstruktion ist typisch für den gehobenen Nominalstil.",
    "exampleSentence": "Im Hinblick auf die bevorstehende Prüfung sollten alle Teilnehmer rechtzeitig erscheinen.",
    "grammarRule": "Nominalstil: 'im Hinblick auf' + Akkusativ",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-041",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Streng genommen handelt es sich hierbei um einen Formfehler.",
      "Streng genommen es handelt sich hierbei um einen Formfehler.",
      "Genommen streng handelt es sich hierbei um einen Formfehler.",
      "Streng genommen, es sich hierbei um einen Formfehler handelt."
    ],
    "correctAnswer": 0,
    "explanation": "'Streng genommen' ist eine feste Partizipialwendung, die wie ein Adverb am Satzanfang steht. Der Hauptsatz folgt mit normaler Inversion.",
    "exampleSentence": "Streng genommen handelt es sich hierbei um einen Formfehler.",
    "grammarRule": "Feste Partizipialwendung als Satzadverb",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-042",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Erst nachdem alle Bedingungen erfüllt worden waren, konnte der Vertrag unterzeichnet werden.",
      "Erst nachdem alle Bedingungen erfüllt worden sind, konnte der Vertrag unterzeichnet werden.",
      "Erst nachdem alle Bedingungen erfüllt worden waren, der Vertrag konnte unterzeichnet werden.",
      "Erst nachdem waren alle Bedingungen erfüllt worden, konnte der Vertrag unterzeichnet werden."
    ],
    "correctAnswer": 0,
    "explanation": "'Nachdem' + Plusquamperfekt Passiv ('erfüllt worden waren') drückt Vorzeitigkeit aus. Der Hauptsatz steht im Präteritum Passiv.",
    "exampleSentence": "Erst nachdem alle Bedingungen erfüllt worden waren, konnte der Vertrag unterzeichnet werden.",
    "grammarRule": "Plusquamperfekt Passiv im Temporalsatz",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-043",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Auf Anordnung des Gerichts wurde das Vermögen eingefroren.",
      "Auf Anordnung dem Gericht wurde das Vermögen eingefroren.",
      "Auf die Anordnung des Gerichts wurde das Vermögen eingefroren.",
      "Auf Anordnung des Gerichtes wurde das Vermögen eingefroren."
    ],
    "correctAnswer": 0,
    "explanation": "'Auf Anordnung' + Genitiv ist eine feste Nominalstilkonstruktion ohne Artikel: 'auf Anordnung des Gerichts'.",
    "exampleSentence": "Auf Anordnung des Gerichts wurde das Vermögen eingefroren.",
    "grammarRule": "Nominalstil: feste Wendung 'auf Anordnung' + Genitiv",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-044",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die am Projekt beteiligten Forscher veröffentlichten ihre Ergebnisse.",
      "Die am Projekt beteiligte Forscher veröffentlichten ihre Ergebnisse.",
      "Die beteiligten am Projekt Forscher veröffentlichten ihre Ergebnisse.",
      "Die am Projekt beteiligten Forschern veröffentlichten ihre Ergebnisse."
    ],
    "correctAnswer": 0,
    "explanation": "Erweitertes Partizip II: 'die am Projekt beteiligten Forscher'. Plural Nominativ: '-en' Endung am Partizip nach Artikel.",
    "exampleSentence": "Die am Projekt beteiligten Forscher veröffentlichten ihre Ergebnisse.",
    "grammarRule": "Erweitertes Partizip II als Attribut (Plural)",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-045",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "So wichtig dieses Thema auch sein mag, wir können es heute nicht besprechen.",
      "So wichtig dieses Thema auch sein mag, können wir es heute nicht besprechen.",
      "So wichtig auch sein mag dieses Thema, wir können es heute nicht besprechen.",
      "So mag dieses Thema auch wichtig sein, wir können es heute nicht besprechen."
    ],
    "correctAnswer": 0,
    "explanation": "'So ... auch ... mag' ist eine gehobene konzessive Konstruktion. Der Hauptsatz hat normale Wortstellung.",
    "exampleSentence": "So wichtig dieses Thema auch sein mag, wir können es heute nicht besprechen.",
    "grammarRule": "Gehobene Konzession mit 'so ... auch ... mag'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-046",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Im Zuge der Umstrukturierung wurden mehrere Abteilungen zusammengelegt.",
      "Im Zuge die Umstrukturierung wurden mehrere Abteilungen zusammengelegt.",
      "Im Zuge von der Umstrukturierung wurden mehrere Abteilungen zusammengelegt.",
      "In Zuge der Umstrukturierung wurden mehrere Abteilungen zusammengelegt."
    ],
    "correctAnswer": 0,
    "explanation": "'Im Zuge' + Genitiv ist eine gehobene Nominalstilkonstruktion: 'im Zuge der Umstrukturierung'.",
    "exampleSentence": "Im Zuge der Umstrukturierung wurden mehrere Abteilungen zusammengelegt.",
    "grammarRule": "Nominalstil: 'im Zuge' + Genitiv",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-047",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Partizipialgruppe",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Die für den Export bestimmten Waren müssen gesondert gekennzeichnet werden.",
      "Die für den Export bestimmte Waren müssen gesondert gekennzeichnet werden.",
      "Die bestimmten für den Export Waren müssen gesondert gekennzeichnet werden.",
      "Die für den Export bestimmten Waren müssen gesondert kennzeichnet werden."
    ],
    "correctAnswer": 0,
    "explanation": "Erweitertes Partizip II: 'die für den Export bestimmten Waren'. Plural Nominativ nach Artikel: '-en' Endung.",
    "exampleSentence": "Die für den Export bestimmten Waren müssen gesondert gekennzeichnet werden.",
    "grammarRule": "Erweitertes Partizip II mit Finalangabe",
    "tags": ["satzbildung", "partizipialgruppe"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-048",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Man bedenke, dass diese Regelung bereits seit Jahren gilt.",
      "Man bedenkt, dass diese Regelung bereits seit Jahren gilt.",
      "Man bedenke, dass diese Regelung bereits seit Jahren geltet.",
      "Bedenke man, dass diese Regelung bereits seit Jahren gilt."
    ],
    "correctAnswer": 0,
    "explanation": "'Man bedenke' verwendet den Konjunktiv I als Aufforderung in gehobener Sprache. Das Verb 'gelten' hat die Form 'gilt'.",
    "exampleSentence": "Man bedenke, dass diese Regelung bereits seit Jahren gilt.",
    "grammarRule": "Konjunktiv I als Aufforderung",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-049",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Nominalstil",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Zwecks Überprüfung der Angaben wird um Vorlage der Originaldokumente gebeten.",
      "Zwecks Überprüfung den Angaben wird um Vorlage der Originaldokumente gebeten.",
      "Zwecks die Überprüfung der Angaben wird um Vorlage der Originaldokumente gebeten.",
      "Zweck Überprüfung der Angaben wird um Vorlage der Originaldokumente gebeten."
    ],
    "correctAnswer": 0,
    "explanation": "'Zwecks' + Genitiv in einer doppelten Nominalstilkonstruktion: 'Überprüfung der Angaben' und 'Vorlage der Originaldokumente'.",
    "exampleSentence": "Zwecks Überprüfung der Angaben wird um Vorlage der Originaldokumente gebeten.",
    "grammarRule": "Nominalstil: 'zwecks' + Verbalnomen + Genitiv",
    "tags": ["satzbildung", "nominalstil"]
  },
  {
    "language": "german", "id": "c1-satzbildung-p1-050",
    "level": "c1",
    "category": "Satzbildung",
    "subcategory": "Gehobene Grammatik",
    "question": "Welcher Satz ist grammatisch richtig?",
    "options": [
      "Dem sei hinzugefügt, dass die Kosten bereits genehmigt wurden.",
      "Dem ist hinzugefügt, dass die Kosten bereits genehmigt wurden.",
      "Dem sei hinzufügen, dass die Kosten bereits genehmigt wurden.",
      "Dem sei hinzugefügt, dass die Kosten bereits genehmigt waren."
    ],
    "correctAnswer": 0,
    "explanation": "'Dem sei hinzugefügt' ist eine gehobene Wendung im Konjunktiv I Passiv, die eine Ergänzung einleitet.",
    "exampleSentence": "Dem sei hinzugefügt, dass die Kosten bereits genehmigt wurden.",
    "grammarRule": "Konjunktiv I Passiv: 'dem sei hinzugefügt'",
    "tags": ["satzbildung", "gehobene_grammatik"]
  },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-052', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Erhöhung der Beiträge tritt zum 1. Januar in Kraft.', 'Die Erhöhung den Beiträgen tritt zum 1. Januar in Kraft.', 'Die Beiträge Erhöhung tritt zum 1. Januar in Kraft.', 'Die Erhöhung die Beiträge tritt zum 1. Januar in Kraft.'], 'correctAnswer': 0, 'explanation': '\'Erhöhung\' + Genitiv (\'der Beiträge\'). Genitiv Plural: \'der\' + Nomen.', 'grammarRule': 'Nominalstil: Verbalnomen + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-053', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppe', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Durch die Krise geschwächt, musste das Unternehmen Stellen abbauen.', 'Durch die Krise geschwächt musste, das Unternehmen Stellen abbauen.', 'Geschwächt durch die Krise das Unternehmen, musste Stellen abbauen.', 'Durch die Krise geschwächt das Unternehmen, musste Stellen abbauen.'], 'correctAnswer': 0, 'explanation': 'Partizipialgruppe mit P.II am Satzanfang, dann Komma + Hauptsatz mit Inversion.', 'grammarRule': 'Partizipialgruppe mit P.II am Satzanfang', 'tags': ['satzbildung', 'partizipialgruppe'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-054', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Gehobene Grammatik', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge bedenken, dass diese Maßnahme Konsequenzen hat.', 'Man möge bedenken dass, diese Maßnahme Konsequenzen hat.', 'Man bedenke möge, dass diese Maßnahme Konsequenzen hat.', 'Man möge bedenken, dass hat diese Maßnahme Konsequenzen.'], 'correctAnswer': 0, 'explanation': '\'Man möge bedenken\' = Konjunktiv I als gehobene Aufforderung.', 'grammarRule': 'Konjunktiv I als gehobene Aufforderung', 'tags': ['satzbildung', 'gehobene_grammatik'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-055', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Verbesserung der Infrastruktur ist dringend erforderlich.', 'Die Verbesserung die Infrastruktur ist dringend erforderlich.', 'Die Infrastruktur Verbesserung ist dringend erforderlich.', 'Die Verbesserung den Infrastruktur ist dringend erforderlich.'], 'correctAnswer': 0, 'explanation': '\'Verbesserung\' + Genitiv (\'der Infrastruktur\').', 'grammarRule': 'Nominalstil: Verbalnomen + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-056', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Gehobene Grammatik', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Dessen ungeachtet bleibt das Problem bestehen.', 'Dessen ungeachtet das Problem bleibt bestehen.', 'Dem ungeachtet bleibt das Problem bestehen.', 'Dessen ungeachtet, bleibt bestehen das Problem.'], 'correctAnswer': 0, 'explanation': '\'Dessen ungeachtet\' = trotzdem (gehoben). Normale Hauptsatzwortstellung folgt.', 'grammarRule': '\'Dessen ungeachtet\' = gehobene Konzession', 'tags': ['satzbildung', 'gehobene_grammatik'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-057', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppe', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die von den Wissenschaftlern veröffentlichte Studie sorgte für Aufsehen.', 'Die von den Wissenschaftlern veröffentlichten Studie sorgte für Aufsehen.', 'Die veröffentlichte von den Wissenschaftlern Studie sorgte für Aufsehen.', 'Die von den Wissenschaftlern veröffentlicht Studie sorgte für Aufsehen.'], 'correctAnswer': 0, 'explanation': 'Erweitertes P.II: \'die von den Wissenschaftlern veröffentlichte Studie\'. Fem. Nom.: \'-e\'.', 'grammarRule': 'Erweitertes Partizip II als Attribut', 'tags': ['satzbildung', 'partizipialgruppe'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-058', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zwecks Überprüfung der Angaben bitten wir um Geduld.', 'Zwecks die Überprüfung der Angaben bitten wir um Geduld.', 'Zwecks Überprüfung den Angaben bitten wir um Geduld.', 'Zweck Überprüfung der Angaben bitten wir um Geduld.'], 'correctAnswer': 0, 'explanation': '\'Zwecks\' + Genitiv: \'zwecks Überprüfung der Angaben\'.', 'grammarRule': 'Nominalstil: \'zwecks\' + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-059', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Gehobene Grammatik', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Inwieweit dies zutrifft, bleibt noch zu klären.', 'Inwieweit dies zutrifft bleibt, noch zu klären.', 'Inwieweit zutrifft dies, bleibt noch zu klären.', 'Inwieweit dies zutrifft, noch bleibt zu klären.'], 'correctAnswer': 0, 'explanation': '\'Inwieweit\'-Nebensatz + Komma + Hauptsatz. \'bleibt zu klären\' = Passivumschreibung.', 'grammarRule': '\'bleibt zu + Infinitiv\' = Passivumschreibung', 'tags': ['satzbildung', 'gehobene_grammatik'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p1-060', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppe', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Alle relevanten Aspekte berücksichtigend, kam die Kommission zu einem Ergebnis.', 'Alle relevanten Aspekte berücksichtigt, kam die Kommission zu einem Ergebnis.', 'Berücksichtigend alle relevanten Aspekte, kam die Kommission zu einem Ergebnis.', 'Alle relevanten Aspekte berücksichtigend kam, die Kommission zu einem Ergebnis.'], 'correctAnswer': 0, 'explanation': 'Partizipialgruppe mit P.I (\'berücksichtigend\'): Gleichzeitigkeit. Objekt steht vor dem Partizip.', 'grammarRule': 'Partizipialgruppe mit Partizip I', 'tags': ['satzbildung', 'partizipialgruppe'] }
];

export default questions;
