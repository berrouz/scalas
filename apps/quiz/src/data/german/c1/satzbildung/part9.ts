import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-002',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Meine Schwester macht jeden Tag Sport.',
      'Sport macht meine Schwester jeden Tag.',
      'Meine Schwester jeden Tag Sport macht.',
      'Jeden Tag meine Schwester macht Sport.'
    ],
    'correctAnswer': 0,
    'explanation': 'SVO-Reihenfolge: Subjekt + Verb + Objekt.',
    'exampleSentence': 'Meine Schwester macht jeden Tag Sport.',
    'grammarRule': 'SVO-Reihenfolge',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-003',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Am Wochenende wir fahren in die Berge.',
      'In die Berge am Wochenende wir fahren.',
      'Wir am Wochenende fahren in die Berge.',
      'Am Wochenende fahren wir in die Berge.'
    ],
    'correctAnswer': 3,
    'explanation': 'Inversion: Am Wochenende (Position 1) + fahren + wir.',
    'exampleSentence': 'Am Wochenende fahren wir in die Berge.',
    'grammarRule': 'Inversion',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-004',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Arzt gibt dem Patienten eine Tablette.',
      'Der Arzt dem Patienten gibt eine Tablette.',
      'Der Arzt gibt eine Tablette dem Patienten.',
      'Dem Patienten der Arzt eine Tablette gibt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dativ vor Akkusativ bei Nomen-Objekten.',
    'exampleSentence': 'Der Arzt gibt dem Patienten eine Tablette.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-012',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Den Kindern die Mutter erzählt Geschichten.',
      'Die Mutter erzählt Geschichten den Kindern.',
      'Die Mutter den Kindern Geschichten erzählt.',
      'Die Mutter erzählt den Kindern Geschichten.'
    ],
    'correctAnswer': 3,
    'explanation': 'Dativ vor Akkusativ: Die Mutter erzählt den Kindern (Dat.) Geschichten (Akk.).',
    'exampleSentence': 'Die Mutter erzählt den Kindern Geschichten.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-013',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Bereitstellung der Mittel erfolgt zeitnah.',
      'Die Bereitstellung die Mittel erfolgt zeitnah.',
      'Die Bereitstellung der Mittel zeitnah erfolgt.',
      'Die Bereitstellung der Mittel erfolgen zeitnah.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Bereitstellung (Singular) + Genitiv (der Mittel) + erfolgt (Singular).',
    'exampleSentence': 'Die Bereitstellung der Mittel erfolgt zeitnah.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-014',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der von allen geschätzte Kollege geht in Rente.',
      'Der von allen geschätzten Kollege geht in Rente.',
      'Der von allen geschätzt Kollege geht in Rente.',
      'Der von allen schätzende Kollege geht in Rente.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: geschätzt + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der von allen geschätzte Kollege geht in Rente.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-015',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Firma hat Insolvenz gestellt.',
      'Die Firma hat Insolvenz angemeldet.',
      'Die Firma hat Insolvenz gebracht.',
      'Die Firma hat Insolvenz genommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Insolvenz anmelden.',
    'exampleSentence': 'Die Firma hat Insolvenz angemeldet.',
    'grammarRule': 'Funktionsverbgefüge: Insolvenz anmelden',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-016',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Im Laufe der Verhandlungen wurde ein Kompromiss erzielt.',
      'Im Laufe die Verhandlungen wurde ein Kompromiss erzielt.',
      'Im Laufe der Verhandlungen ein Kompromiss wurde erzielt.',
      'Im Laufe der Verhandlungen wurde erzielt ein Kompromiss.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Laufe + Genitiv: der Verhandlungen. Inversion im Hauptsatz.',
    'exampleSentence': 'Im Laufe der Verhandlungen wurde ein Kompromiss erzielt.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-017',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die entscheidende Frage bleibt offen.',
      'Die entscheidenden Frage bleibt offen.',
      'Die entscheidend Frage bleibt offen.',
      'Die entschiedene Frage bleibt offen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: entscheidend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die entscheidende Frage bleibt offen.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-018',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Vorfall hat Folgen nach sich genommen.',
      'Der Vorfall hat Folgen nach sich gezogen.',
      'Der Vorfall hat Folgen nach sich gebracht.',
      'Der Vorfall hat Folgen nach sich gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Folgen nach sich ziehen (= Konsequenzen haben).',
    'exampleSentence': 'Der Vorfall hat Folgen nach sich gezogen.',
    'grammarRule': 'Funktionsverbgefüge: Folgen nach sich ziehen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-019',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Auf Empfehlung des Arztes wurde die Therapie geändert.',
      'Auf Empfehlung dem Arzt wurde die Therapie geändert.',
      'Auf Empfehlung des Arztes die Therapie wurde geändert.',
      'Auf Empfehlung des Arztes wurde geändert die Therapie.'
    ],
    'correctAnswer': 0,
    'explanation': 'Auf Empfehlung + Genitiv: des Arztes. Inversion im Hauptsatz.',
    'exampleSentence': 'Auf Empfehlung des Arztes wurde die Therapie geändert.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-020',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die sorgfältig ausgewählten Materialien sind hochwertig.',
      'Die sorgfältig ausgewählte Materialien sind hochwertig.',
      'Die sorgfältig ausgewählt Materialien sind hochwertig.',
      'Die sorgfältig auswählenden Materialien sind hochwertig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: ausgewählt + -en.',
    'exampleSentence': 'Die sorgfältig ausgewählten Materialien sind hochwertig.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-021',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat einen Fehler in Kauf gestellt.',
      'Er hat einen Fehler in Kauf gebracht.',
      'Er hat einen Fehler in Kauf genommen.',
      'Er hat einen Fehler in Kauf gesetzt.'
    ],
    'correctAnswer': 2,
    'explanation': 'Das Funktionsverbgefüge lautet: etwas in Kauf nehmen (= akzeptieren).',
    'exampleSentence': 'Er hat einen Fehler in Kauf genommen.',
    'grammarRule': 'Funktionsverbgefüge: in Kauf nehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-022',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Wahrung der Menschenrechte ist grundlegend.',
      'Die Wahrung die Menschenrechte ist grundlegend.',
      'Die Wahrung der Menschenrechte grundlegend ist.',
      'Die Wahrung der Menschenrechte sind grundlegend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Wahrung (Singular) + Genitiv (der Menschenrechte) + ist (Singular).',
    'exampleSentence': 'Die Wahrung der Menschenrechte ist grundlegend.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-023',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein neu entwickelter Impfstoff wird getestet.',
      'Ein neu entwickeltes Impfstoff wird getestet.',
      'Ein neu entwickelt Impfstoff wird getestet.',
      'Ein neu entwickelnder Impfstoff wird getestet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: entwickelt + -er (Singular, Nominativ, Maskulinum, unbestimmter Artikel).',
    'exampleSentence': 'Ein neu entwickelter Impfstoff wird getestet.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-024',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Diskussion kam zum Stillstand.',
      'Die Diskussion ging zum Stillstand.',
      'Die Diskussion nahm zum Stillstand.',
      'Die Diskussion stellte zum Stillstand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: zum Stillstand kommen (= aufhören).',
    'exampleSentence': 'Die Diskussion kam zum Stillstand.',
    'grammarRule': 'Funktionsverbgefüge: zum Stillstand kommen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-026',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die überraschend gut verlaufene Verhandlung endete mit einem Vertrag.',
      'Die überraschend gut verlaufenen Verhandlung endete mit einem Vertrag.',
      'Die überraschend gut verlaufen Verhandlung endete mit einem Vertrag.',
      'Die überraschend gut verlaufende Verhandlung endete mit einem Vertrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: verlaufen + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die überraschend gut verlaufene Verhandlung endete mit einem Vertrag.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-027',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat die Verantwortung überstellt.',
      'Er hat die Verantwortung übernommen.',
      'Er hat die Verantwortung übergebracht.',
      'Er hat die Verantwortung übergesetzt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Verantwortung übernehmen (= verantwortlich werden).',
    'exampleSentence': 'Er hat die Verantwortung übernommen.',
    'grammarRule': 'Funktionsverbgefüge: Verantwortung übernehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-028',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Innerhalb des festgelegten Zeitraums muss die Arbeit abgeschlossen sein.',
      'Innerhalb dem festgelegten Zeitraum muss die Arbeit abgeschlossen sein.',
      'Innerhalb des festgelegten Zeitraums die Arbeit muss abgeschlossen sein.',
      'Innerhalb des festgelegten Zeitraums muss abgeschlossen sein die Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Innerhalb + Genitiv: des festgelegten Zeitraums. Inversion im Hauptsatz.',
    'exampleSentence': 'Innerhalb des festgelegten Zeitraums muss die Arbeit abgeschlossen sein.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-030',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat Einspruch gegen das Urteil gestellt.',
      'Er hat Einspruch gegen das Urteil erhoben.',
      'Er hat Einspruch gegen das Urteil genommen.',
      'Er hat Einspruch gegen das Urteil gebracht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Einspruch erheben (= widersprechen).',
    'exampleSentence': 'Er hat Einspruch gegen das Urteil erhoben.',
    'grammarRule': 'Funktionsverbgefüge: Einspruch erheben',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-031',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Einführung neuer Technologien schreitet voran.',
      'Die Einführung neue Technologien schreitet voran.',
      'Die Einführung neuer Technologien voran schreitet.',
      'Die Einführung neuer Technologien schreiten voran.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Einführung (Singular) + Genitiv (neuer Technologien) + schreitet (Singular).',
    'exampleSentence': 'Die Einführung neuer Technologien schreitet voran.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-032',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der klar formulierte Antrag wurde genehmigt.',
      'Der klar formulierten Antrag wurde genehmigt.',
      'Der klar formuliert Antrag wurde genehmigt.',
      'Der klar formulierende Antrag wurde genehmigt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: formuliert + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).',
    'exampleSentence': 'Der klar formulierte Antrag wurde genehmigt.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-033',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Reform hat Wirkung genommen.',
      'Die Reform hat Wirkung gezeigt.',
      'Die Reform hat Wirkung gebracht.',
      'Die Reform hat Wirkung gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: Wirkung zeigen (= wirken).',
    'exampleSentence': 'Die Reform hat Wirkung gezeigt.',
    'grammarRule': 'Funktionsverbgefüge: Wirkung zeigen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-034',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Vorbehaltlich der Genehmigung beginnen die Arbeiten.',
      'Vorbehaltlich die Genehmigung beginnen die Arbeiten.',
      'Vorbehaltlich der Genehmigung die Arbeiten beginnen.',
      'Vorbehaltlich der Genehmigung beginnen die Arbeiten nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorbehaltlich + Genitiv: der Genehmigung. Inversion im Hauptsatz.',
    'exampleSentence': 'Vorbehaltlich der Genehmigung beginnen die Arbeiten.',
    'grammarRule': 'Nominalstil: Präposition + Genitiv',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-035',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ein beeindruckend gestaltetes Gebäude schmückt den Platz.',
      'Ein beeindruckend gestalteter Gebäude schmückt den Platz.',
      'Ein beeindruckend gestaltet Gebäude schmückt den Platz.',
      'Ein beeindruckend gestaltendes Gebäude schmückt den Platz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: gestaltet + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).',
    'exampleSentence': 'Ein beeindruckend gestaltetes Gebäude schmückt den Platz.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-036',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hat einen Versuch gemacht.',
      'Sie hat einen Versuch unternommen.',
      'Sie hat einen Versuch gebracht.',
      'Sie hat einen Versuch gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Das Funktionsverbgefüge lautet: einen Versuch unternehmen (= versuchen).',
    'exampleSentence': 'Sie hat einen Versuch unternommen.',
    'grammarRule': 'Funktionsverbgefüge: einen Versuch unternehmen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-038',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die langsam fortschreitende Digitalisierung verändert die Wirtschaft.',
      'Die langsam fortschreitenden Digitalisierung verändert die Wirtschaft.',
      'Die langsam fortschreitend Digitalisierung verändert die Wirtschaft.',
      'Die langsam fortgeschrittene Digitalisierung verändert die Wirtschaft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv: fortschreitend + -e (Singular, Nominativ, Femininum, bestimmter Artikel).',
    'exampleSentence': 'Die langsam fortschreitende Digitalisierung verändert die Wirtschaft.',
    'grammarRule': 'Partizipialattribut mit Partizip I',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-039',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Nachricht hat Bestürzung ausgelöst.',
      'Die Nachricht hat Bestürzung ausgestellt.',
      'Die Nachricht hat Bestürzung aufgenommen.',
      'Die Nachricht hat Bestürzung angesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Das Funktionsverbgefüge lautet: Bestürzung auslösen (= erschrecken).',
    'exampleSentence': 'Die Nachricht hat Bestürzung ausgelöst.',
    'grammarRule': 'Funktionsverbgefüge: Bestürzung auslösen',
    'tags': ['satzbildung', 'funktionsverbgefuege']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-040',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Stärkung der internationalen Zusammenarbeit ist essenziell.',
      'Die Stärkung die internationale Zusammenarbeit ist essenziell.',
      'Die Stärkung der internationalen Zusammenarbeit essenziell ist.',
      'Die Stärkung der internationalen Zusammenarbeit sind essenziell.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Stärkung (Singular) + Genitiv (der internationalen Zusammenarbeit) + ist.',
    'exampleSentence': 'Die Stärkung der internationalen Zusammenarbeit ist essenziell.',
    'grammarRule': 'Nominalstil mit Genitivattribut',
    'tags': ['satzbildung', 'nominalstil']
  },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-050',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Partizipialgruppen',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die überaus engagierten Freiwilligen halfen bei der Rettung.',
      'Die überaus engagierte Freiwilligen halfen bei der Rettung.',
      'Die überaus engagiert Freiwilligen halfen bei der Rettung.',
      'Die überaus engagierenden Freiwilligen halfen bei der Rettung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: engagiert + -en.',
    'exampleSentence': 'Die überaus engagierten Freiwilligen halfen bei der Rettung.',
    'grammarRule': 'Partizipialattribut mit Partizip II',
    'tags': ['satzbildung', 'partizipialgruppen']
  },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-041', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Regelung wurde außer Kraft genommen.', 'Die Regelung wurde außer Kraft gesetzt.', 'Die Regelung wurde außer Kraft gestellt.', 'Die Regelung wurde außer Kraft gebracht.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: außer Kraft setzen (= ungültig machen).', 'exampleSentence': 'Die Regelung wurde außer Kraft gesetzt.', 'grammarRule': 'Funktionsverbgefüge: außer Kraft setzen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-042', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Der soeben angekommene Zug steht auf Gleis 3.', 'Der soeben angekommenen Zug steht auf Gleis 3.', 'Der soeben angekommen Zug steht auf Gleis 3.', 'Der soeben ankommende Zug steht auf Gleis 3.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: angekommen + -e (Singular, Nominativ, Maskulinum, bestimmter Artikel).', 'exampleSentence': 'Der soeben angekommene Zug steht auf Gleis 3.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-044', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Er hat Kenntnis von dem Vorfall gestellt.', 'Er hat Kenntnis von dem Vorfall genommen.', 'Er hat Kenntnis von dem Vorfall gebracht.', 'Er hat Kenntnis von dem Vorfall gesetzt.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: Kenntnis nehmen von (= erfahren).', 'exampleSentence': 'Er hat Kenntnis von dem Vorfall genommen.', 'grammarRule': 'Funktionsverbgefüge: Kenntnis nehmen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-045', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die zunehmend besorgniserregenden Nachrichten verunsichern die Bevölkerung.', 'Die zunehmend besorgniserregende Nachrichten verunsichern die Bevölkerung.', 'Die zunehmend besorgniserregend Nachrichten verunsichern die Bevölkerung.', 'Die zunehmend besorgniserregten Nachrichten verunsichern die Bevölkerung.'], 'correctAnswer': 0, 'explanation': 'Partizip I als Adjektiv im Plural mit bestimmtem Artikel: besorgniserregend + -en.', 'exampleSentence': 'Die zunehmend besorgniserregenden Nachrichten verunsichern die Bevölkerung.', 'grammarRule': 'Partizipialattribut mit Partizip I', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-046', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Auf Veranlassung des Ministers wurde eine Untersuchung eingeleitet.', 'Auf Veranlassung dem Minister wurde eine Untersuchung eingeleitet.', 'Auf Veranlassung des Ministers eine Untersuchung wurde eingeleitet.', 'Auf Veranlassung des Ministers wurde eingeleitet eine Untersuchung.'], 'correctAnswer': 0, 'explanation': 'Auf Veranlassung + Genitiv: des Ministers. Inversion im Hauptsatz.', 'exampleSentence': 'Auf Veranlassung des Ministers wurde eine Untersuchung eingeleitet.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-048', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ein gut durchdachtes Konzept liegt vor.', 'Ein gut durchdachter Konzept liegt vor.', 'Ein gut durchdacht Konzept liegt vor.', 'Ein gut durchdenkendes Konzept liegt vor.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: durchdacht + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).', 'exampleSentence': 'Ein gut durchdachtes Konzept liegt vor.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-049', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Aufgrund mangelnder Nachfrage wurde das Angebot eingestellt.', 'Aufgrund mangelnde Nachfrage wurde das Angebot eingestellt.', 'Aufgrund mangelnder Nachfrage das Angebot wurde eingestellt.', 'Aufgrund mangelnder Nachfrage wurde eingestellt das Angebot.'], 'correctAnswer': 0, 'explanation': 'Aufgrund + Genitiv: mangelnder Nachfrage. Inversion im Hauptsatz.', 'exampleSentence': 'Aufgrund mangelnder Nachfrage wurde das Angebot eingestellt.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-051', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Der Antrag wurde in Bearbeitung gestellt.', 'Der Antrag wurde in Bearbeitung genommen.', 'Der Antrag wurde in Bearbeitung gebracht.', 'Der Antrag wurde in Bearbeitung gesetzt.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: in Bearbeitung nehmen (= bearbeiten).', 'exampleSentence': 'Der Antrag wurde in Bearbeitung genommen.', 'grammarRule': 'Funktionsverbgefüge: in Bearbeitung nehmen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-052', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die grundlegend überarbeitete Fassung wurde veröffentlicht.', 'Die grundlegend überarbeiteten Fassung wurde veröffentlicht.', 'Die grundlegend überarbeitet Fassung wurde veröffentlicht.', 'Die grundlegend überarbeitende Fassung wurde veröffentlicht.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: überarbeitet + -e (Singular, Nominativ, Femininum, bestimmter Artikel).', 'exampleSentence': 'Die grundlegend überarbeitete Fassung wurde veröffentlicht.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-053', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zugunsten der Arbeitnehmer wurde das Gesetz geändert.', 'Zugunsten die Arbeitnehmer wurde das Gesetz geändert.', 'Zugunsten der Arbeitnehmer das Gesetz wurde geändert.', 'Zugunsten der Arbeitnehmer wurde geändert das Gesetz.'], 'correctAnswer': 0, 'explanation': 'Zugunsten + Genitiv: der Arbeitnehmer. Inversion im Hauptsatz.', 'exampleSentence': 'Zugunsten der Arbeitnehmer wurde das Gesetz geändert.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-054', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Der Kandidat hat einen guten Eindruck genommen.', 'Der Kandidat hat einen guten Eindruck gemacht.', 'Der Kandidat hat einen guten Eindruck gestellt.', 'Der Kandidat hat einen guten Eindruck gebracht.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: einen Eindruck machen (= wirken).', 'exampleSentence': 'Der Kandidat hat einen guten Eindruck gemacht.', 'grammarRule': 'Funktionsverbgefüge: einen Eindruck machen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-055', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ein leicht zu handhabendes Gerät wurde entwickelt.', 'Ein leicht zu handhabendes Gerät wurde entwickeln.', 'Ein leicht zu handhaben Gerät wurde entwickelt.', 'Ein leicht handhabendes Gerät wurde entwickelt.'], 'correctAnswer': 0, 'explanation': 'Gerundiv (zu + Partizip I): zu handhabend + -es (Singular, Nominativ, Neutrum, unbestimmter Artikel).', 'exampleSentence': 'Ein leicht zu handhabendes Gerät wurde entwickelt.', 'grammarRule': 'Gerundiv als Adjektivattribut', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-056', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Wortstellung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Je früher man anfängt, desto besser sind die Ergebnisse.', 'Je man früher anfängt, desto besser sind die Ergebnisse.', 'Je früher man anfängt, desto die Ergebnisse sind besser.', 'Je früher man anfängt, desto sind die Ergebnisse besser.'], 'correctAnswer': 0, 'explanation': 'Je + Komparativ + Nebensatz (Verb am Ende), desto + Komparativ + Verb + Subjekt.', 'exampleSentence': 'Je früher man anfängt, desto besser sind die Ergebnisse.', 'grammarRule': 'Je...desto-Konstruktion', 'tags': ['satzbildung', 'wortstellung'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-057', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Nominalstil', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ungeachtet der Risiken wurde das Projekt fortgesetzt.', 'Ungeachtet die Risiken wurde das Projekt fortgesetzt.', 'Ungeachtet der Risiken das Projekt wurde fortgesetzt.', 'Ungeachtet der Risiken wurde fortgesetzt das Projekt.'], 'correctAnswer': 0, 'explanation': 'Ungeachtet + Genitiv: der Risiken. Inversion im Hauptsatz.', 'exampleSentence': 'Ungeachtet der Risiken wurde das Projekt fortgesetzt.', 'grammarRule': 'Nominalstil: Präposition + Genitiv', 'tags': ['satzbildung', 'nominalstil'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-058', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die Frage wurde zur Abstimmung genommen.', 'Die Frage wurde zur Abstimmung gestellt.', 'Die Frage wurde zur Abstimmung gebracht.', 'Die Frage wurde zur Abstimmung gesetzt.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: zur Abstimmung stellen (= abstimmen lassen).', 'exampleSentence': 'Die Frage wurde zur Abstimmung gestellt.', 'grammarRule': 'Funktionsverbgefüge: zur Abstimmung stellen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-059', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die erst kürzlich eingeführten Regelungen gelten ab sofort.', 'Die erst kürzlich eingeführte Regelungen gelten ab sofort.', 'Die erst kürzlich eingeführt Regelungen gelten ab sofort.', 'Die erst kürzlich einführenden Regelungen gelten ab sofort.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv im Plural mit bestimmtem Artikel: eingeführt + -en.', 'exampleSentence': 'Die erst kürzlich eingeführten Regelungen gelten ab sofort.', 'grammarRule': 'Partizipialattribut mit Partizip II (Plural)', 'tags': ['satzbildung', 'partizipialgruppen'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-061', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Funktionsverbgefüge', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Er hat einen Antrag auf Förderung genommen.', 'Er hat einen Antrag auf Förderung gestellt.', 'Er hat einen Antrag auf Förderung gebracht.', 'Er hat einen Antrag auf Förderung gesetzt.'], 'correctAnswer': 1, 'explanation': 'Das Funktionsverbgefüge lautet: einen Antrag stellen (= beantragen).', 'exampleSentence': 'Er hat einen Antrag auf Förderung gestellt.', 'grammarRule': 'Funktionsverbgefüge: einen Antrag stellen', 'tags': ['satzbildung', 'funktionsverbgefuege'] },
  { 'language': 'german', 'id': 'c1-satzbildung-p9-062', 'level': 'c1', 'category': 'Satzbildung', 'subcategory': 'Partizipialgruppen', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Die seit Wochen erwartete Lieferung traf endlich ein.', 'Die seit Wochen erwarteten Lieferung traf endlich ein.', 'Die seit Wochen erwartet Lieferung traf endlich ein.', 'Die seit Wochen erwartende Lieferung traf endlich ein.'], 'correctAnswer': 0, 'explanation': 'Partizip II als Adjektiv: erwartet + -e (Singular, Nominativ, Femininum, bestimmter Artikel).', 'exampleSentence': 'Die seit Wochen erwartete Lieferung traf endlich ein.', 'grammarRule': 'Partizipialattribut mit Partizip II', 'tags': ['satzbildung', 'partizipialgruppen'] },
  {
    'language': 'german', 'id': 'c1-satzbildung-p9-150',
    'level': 'c1',
    'category': 'Satzbildung',
    'subcategory': 'Satzverbindung',
    'question': 'Welche Satzverbindung ist korrekt?',
    'options': ['Er ist muede, denn er hat lange gearbeitet.', 'Er ist muede, weil er hat lange gearbeitet.', 'Er ist muede, denn hat er lange gearbeitet.', 'Er ist muede, weil lange er gearbeitet hat.'],
    'correctAnswer': 0,
    'explanation': '\'Denn\' + Hauptsatz (Subjekt + Verb), \'weil\' + Nebensatz (Verb am Ende).',
    'tags': ['satzbildung']
  }
];

export default questions;
