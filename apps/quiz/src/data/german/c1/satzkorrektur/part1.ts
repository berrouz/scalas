import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Durchführung des Experiments erfolgte unter strengen Bedingungen.',
      'Die Durchführung des Experiments erfolgt unter strengen Bedingungen.',
      'Die Durchführung dem Experiment erfolgte unter strengen Bedingungen.',
      'Die Durchführung des Experiments erfolgten unter strengen Bedingungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil mit Genitiv: Die Durchführung des Experiments. Verb im Singular Präteritum: erfolgte.',
    'exampleSentence': 'Die Durchführung des Experiments erfolgte unter strengen Bedingungen.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der von dem Professor gehaltener Vortrag war ausgezeichnet.',
      'Der von dem Professor gehaltene Vortrag war ausgezeichnet.',
      'Der von dem Professor haltende Vortrag war ausgezeichnet.',
      'Der von dem Professor gehaltenem Vortrag war ausgezeichnet.'
    ],
    'correctAnswer': 1,
    'explanation': 'Erweitertes Partizip II als Attribut: gehaltene dekliniert wie ein Adjektiv (Nominativ maskulin mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der von dem Professor gehaltene Vortrag war ausgezeichnet.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Minister sagte, er werde die Reform unterstützen.',
      'Der Minister sagte, er wird die Reform unterstützen.',
      'Der Minister sagte, er würde die Reform unterstützen wird.',
      'Der Minister sagte, er werde die Reform unterstützen wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede steht Konjunktiv I: er werde (Futur I im Konjunktiv I).',
    'exampleSentence': 'Der Minister sagte, er werde die Reform unterstützen.',
    'grammarRule': 'Konjunktiv I in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dieses Problem lässt sich leicht lösen.',
      'Dieses Problem lässt sich leicht zu lösen.',
      'Dieses Problem lässt leicht sich lösen.',
      'Dieses Problem lässt sich leicht gelöst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit sich lassen + Infinitiv: lässt sich lösen (= kann gelöst werden).',
    'exampleSentence': 'Dieses Problem lässt sich leicht lösen.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl er krank war, ging er trotzdem zur Arbeit.',
      'Obwohl er krank war, aber er ging zur Arbeit.',
      'Obwohl er war krank, ging er zur Arbeit.',
      'Obwohl er krank war, er ging zur Arbeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Nebensatz mit obwohl steht im Hauptsatz das Verb an erster Stelle (Inversion). Kein zusätzliches aber nötig.',
    'exampleSentence': 'Obwohl er krank war, ging er trotzdem zur Arbeit.',
    'grammarRule': 'Satzgefüge mit Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Regierung hat eine Entscheidung getroffen.',
      'Die Regierung hat eine Entscheidung gemacht.',
      'Die Regierung hat eine Entscheidung genommen.',
      'Die Regierung hat eine Entscheidung gegeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: eine Entscheidung treffen (nicht machen, nehmen oder geben).',
    'exampleSentence': 'Die Regierung hat eine Entscheidung getroffen.',
    'grammarRule': 'Funktionsverbgefüge: eine Entscheidung treffen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz des schlechten Wetters fand die Veranstaltung statt.',
      'Trotz dem schlechten Wetter fand die Veranstaltung statt.',
      'Trotz des schlechtes Wetters fand die Veranstaltung statt.',
      'Trotz des schlechten Wetter fand die Veranstaltung statt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trotz verlangt den Genitiv: trotz des schlechten Wetters.',
    'exampleSentence': 'Trotz des schlechten Wetters fand die Veranstaltung statt.',
    'grammarRule': 'Präposition trotz + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht nur hat er die Prüfung bestanden, sondern er hat auch den ersten Platz belegt.',
      'Nicht nur er hat die Prüfung bestanden, sondern auch er hat den ersten Platz belegt.',
      'Nicht nur hat er die Prüfung bestanden, sondern auch hat er den ersten Platz belegt.',
      'Nicht nur er hat bestanden die Prüfung, sondern er hat auch den ersten Platz belegt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei nicht nur ... sondern auch steht nach nicht nur das Verb vor dem Subjekt (Inversion). Im zweiten Teil: sondern + Subjekt + Verb + auch.',
    'exampleSentence': 'Nicht nur hat er die Prüfung bestanden, sondern er hat auch den ersten Platz belegt.',
    'grammarRule': 'Wortstellung: nicht nur ... sondern auch',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Infolge der steigenden Preise müssen viele Haushalte sparen.',
      'Infolge den steigenden Preise müssen viele Haushalte sparen.',
      'Infolge der steigenden Preisen müssen viele Haushalte sparen.',
      'Infolge die steigenden Preise müssen viele Haushalte sparen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infolge verlangt den Genitiv: infolge der steigenden Preise (Plural Genitiv).',
    'exampleSentence': 'Infolge der steigenden Preise müssen viele Haushalte sparen.',
    'grammarRule': 'Präposition infolge + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die seit Wochen andauernde Debatte hat zu keinem Ergebnis geführt.',
      'Die seit Wochen andauernden Debatte hat zu keinem Ergebnis geführt.',
      'Die seit Wochen andauernder Debatte hat zu keinem Ergebnis geführt.',
      'Die seit Wochen angedauerte Debatte hat zu keinem Ergebnis geführt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I: andauernde (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die seit Wochen andauernde Debatte hat zu keinem Ergebnis geführt.',
    'grammarRule': 'Erweitertes Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Sprecherin betonte, die Lage sei unter Kontrolle.',
      'Die Sprecherin betonte, die Lage ist unter Kontrolle.',
      'Die Sprecherin betonte, die Lage wäre unter Kontrolle.',
      'Die Sprecherin betonte, die Lage sei unter Kontrolle ist.'
    ],
    'correctAnswer': 0,
    'explanation': 'In der indirekten Rede steht Konjunktiv I: sei (3. Person Singular von sein).',
    'exampleSentence': 'Die Sprecherin betonte, die Lage sei unter Kontrolle.',
    'grammarRule': 'Konjunktiv I: sein → sei',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Gebäude ist nicht mehr zu retten.',
      'Das Gebäude ist nicht mehr zu gerettet.',
      'Das Gebäude ist nicht mehr retten zu.',
      'Das Gebäude ist nicht mehr zum Retten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit sein + zu + Infinitiv: ist zu retten (= kann gerettet werden).',
    'exampleSentence': 'Das Gebäude ist nicht mehr zu retten.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je mehr man übt, desto besser werden die Ergebnisse.',
      'Je mehr man übt, je besser werden die Ergebnisse.',
      'Je mehr man übt, desto die Ergebnisse werden besser.',
      'Je mehr man übt, desto besser die Ergebnisse werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Proportionalsatz: je ... desto + Komparativ + Verb + Subjekt.',
    'exampleSentence': 'Je mehr man übt, desto besser werden die Ergebnisse.',
    'grammarRule': 'Proportionalsatz: je ... desto',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man muss die Kosten in Kauf nehmen.',
      'Man muss die Kosten in Kauf geben.',
      'Man muss die Kosten in Kauf bringen.',
      'Man muss die Kosten in Kauf machen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Kauf nehmen (= akzeptieren).',
    'exampleSentence': 'Man muss die Kosten in Kauf nehmen.',
    'grammarRule': 'Funktionsverbgefüge: in Kauf nehmen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während des Studiums arbeitete sie in einer Bibliothek.',
      'Während dem Studium arbeitete sie in einer Bibliothek.',
      'Während des Studium arbeitete sie in einer Bibliothek.',
      'Während den Studiums arbeitete sie in einer Bibliothek.'
    ],
    'correctAnswer': 0,
    'explanation': 'Während verlangt den Genitiv: während des Studiums.',
    'exampleSentence': 'Während des Studiums arbeitete sie in einer Bibliothek.',
    'grammarRule': 'Präposition während + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kaum hatte er das Haus verlassen, begann es zu regnen.',
      'Kaum er hatte das Haus verlassen, begann es zu regnen.',
      'Kaum hatte er das Haus verlassen, es begann zu regnen.',
      'Kaum er das Haus hatte verlassen, begann es zu regnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach kaum steht das finite Verb direkt nach kaum (Inversion), dann folgt im Hauptsatz ebenfalls Inversion.',
    'exampleSentence': 'Kaum hatte er das Haus verlassen, begann es zu regnen.',
    'grammarRule': 'Wortstellung nach kaum',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Einführung neuer Technologien erfordert umfangreiche Schulungen.',
      'Die Einführung neuen Technologien erfordert umfangreiche Schulungen.',
      'Die Einführung neue Technologien erfordert umfangreiche Schulungen.',
      'Die Einführung neuer Technologien erfordern umfangreiche Schulungen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Einführung + Genitiv Plural (neuer Technologien). Subjekt ist Einführung (Singular) → erfordert.',
    'exampleSentence': 'Die Einführung neuer Technologien erfordert umfangreiche Schulungen.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das in der Zeitung veröffentlichten Bild sorgte für Aufsehen.',
      'Das in der Zeitung veröffentlichte Bild sorgte für Aufsehen.',
      'Das in der Zeitung veröffentlichtes Bild sorgte für Aufsehen.',
      'Das in der Zeitung veröffentlichtem Bild sorgte für Aufsehen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Erweitertes Partizip II als Attribut: veröffentlichte (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das in der Zeitung veröffentlichte Bild sorgte für Aufsehen.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptete, er habe nichts davon gewusst.',
      'Er behauptete, er hat nichts davon gewusst.',
      'Er behauptete, er hätte nichts davon gewusst.',
      'Er behauptete, er habe nichts davon geweißt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede im Konjunktiv I Perfekt: habe gewusst. Partizip II von wissen: gewusst.',
    'exampleSentence': 'Er behauptete, er habe nichts davon gewusst.',
    'grammarRule': 'Konjunktiv I Perfekt in indirekter Rede',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aufgabe gilt als unlösbar.',
      'Die Aufgabe gilt als unlösbare.',
      'Die Aufgabe gilt für unlösbar.',
      'Die Aufgabe gilt wie unlösbar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gelten als + Adjektiv (prädikativ, nicht dekliniert): gilt als unlösbar.',
    'exampleSentence': 'Die Aufgabe gilt als unlösbar.',
    'grammarRule': 'Passiversatzform: gelten als + Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, dass er kommt, könnten wir das Projekt besprechen.',
      'Angenommen, dass er kommt, wir könnten das Projekt besprechen.',
      'Angenommen, er kommt dass, könnten wir das Projekt besprechen.',
      'Angenommen, dass er kommt, könnten das Projekt wir besprechen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit angenommen, dass: im Nebensatz steht das Verb am Ende, im Hauptsatz steht das Verb an erster Stelle.',
    'exampleSentence': 'Angenommen, dass er kommt, könnten wir das Projekt besprechen.',
    'grammarRule': 'Satzgefüge: Konditionalsatz mit angenommen, dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorschlag wurde in Betracht genommen.',
      'Der Vorschlag wurde in Betracht gezogen.',
      'Der Vorschlag wurde in Betracht gebracht.',
      'Der Vorschlag wurde in Betracht gemacht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: in Betracht ziehen (= erwägen). Passiv: wurde in Betracht gezogen.',
    'exampleSentence': 'Der Vorschlag wurde in Betracht gezogen.',
    'grammarRule': 'Funktionsverbgefüge: in Betracht ziehen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aufgrund eines technischen Defekts musste der Flug gestrichen werden.',
      'Aufgrund einem technischen Defekt musste der Flug gestrichen werden.',
      'Aufgrund eines technischen Defekt musste der Flug gestrichen werden.',
      'Aufgrund einen technischen Defekts musste der Flug gestrichen werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Aufgrund verlangt den Genitiv: aufgrund eines technischen Defekts.',
    'exampleSentence': 'Aufgrund eines technischen Defekts musste der Flug gestrichen werden.',
    'grammarRule': 'Präposition aufgrund + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selten hat man eine so beeindruckende Ausstellung gesehen.',
      'Selten man hat eine so beeindruckende Ausstellung gesehen.',
      'Selten hat man so eine beeindruckende Ausstellung gesehen hat.',
      'Selten eine so beeindruckende Ausstellung hat man gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem Adverb selten im Vorfeld steht das finite Verb an zweiter Stelle mit Inversion des Subjekts.',
    'exampleSentence': 'Selten hat man eine so beeindruckende Ausstellung gesehen.',
    'grammarRule': 'Inversion nach vorangestelltem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter Berücksichtigung aller Faktoren wurde die Entscheidung getroffen.',
      'Unter Berücksichtigung allen Faktoren wurde die Entscheidung getroffen.',
      'Unter Berücksichtigung aller Faktoren wurden die Entscheidung getroffen.',
      'Unter Berücksichtigung alle Faktoren wurde die Entscheidung getroffen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: unter Berücksichtigung + Genitiv Plural (aller Faktoren). Subjekt: die Entscheidung → wurde.',
    'exampleSentence': 'Unter Berücksichtigung aller Faktoren wurde die Entscheidung getroffen.',
    'grammarRule': 'Nominalstil: unter Berücksichtigung + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der am Projekt beteiligte Mitarbeiter wurde befördert.',
      'Der am Projekt beteiligter Mitarbeiter wurde befördert.',
      'Der am Projekt beteiligten Mitarbeiter wurde befördert.',
      'Der am Projekt beteiligende Mitarbeiter wurde befördert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: beteiligte (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der am Projekt beteiligte Mitarbeiter wurde befördert.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Zeitung berichtete, die Verhandlungen seien gescheitert.',
      'Die Zeitung berichtete, die Verhandlungen sind gescheitert.',
      'Die Zeitung berichtete, die Verhandlungen waren gescheitert.',
      'Die Zeitung berichtete, die Verhandlungen seien gescheitert sind.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede im Konjunktiv I: seien gescheitert (Perfekt mit sein).',
    'exampleSentence': 'Die Zeitung berichtete, die Verhandlungen seien gescheitert.',
    'grammarRule': 'Konjunktiv I Perfekt: seien + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Text ist leicht verständlich.',
      'Der Text ist leicht verständliche.',
      'Der Text ist leicht zu verständlich.',
      'Der Text ist leicht verständlichem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -lich/-bar: verständlich (= kann verstanden werden). Prädikativ, nicht dekliniert.',
    'exampleSentence': 'Der Text ist leicht verständlich.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -lich',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insofern als die Daten korrekt sind, können wir fortfahren.',
      'Insofern als die Daten korrekt sind, wir können fortfahren.',
      'Insofern als die Daten sind korrekt, können wir fortfahren.',
      'Insofern als die Daten korrekt sind, können fortfahren wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit insofern als: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Insofern als die Daten korrekt sind, können wir fortfahren.',
    'grammarRule': 'Satzgefüge: insofern als',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Maßnahme wurde in Kraft getreten.',
      'Die Maßnahme ist in Kraft getreten.',
      'Die Maßnahme hat in Kraft getreten.',
      'Die Maßnahme wurde in Kraft getretet.'
    ],
    'correctAnswer': 1,
    'explanation': 'In Kraft treten ist intransitiv und bildet das Perfekt mit sein: ist in Kraft getreten.',
    'exampleSentence': 'Die Maßnahme ist in Kraft getreten.',
    'grammarRule': 'Funktionsverbgefüge: in Kraft treten',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angesichts der wachsenden Probleme muss gehandelt werden.',
      'Angesichts den wachsenden Problemen muss gehandelt werden.',
      'Angesichts der wachsenden Problemen muss gehandelt werden.',
      'Angesichts die wachsenden Probleme muss gehandelt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Angesichts verlangt den Genitiv: angesichts der wachsenden Probleme.',
    'exampleSentence': 'Angesichts der wachsenden Probleme muss gehandelt werden.',
    'grammarRule': 'Präposition angesichts + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter keinen Umständen darf diese Information weitergegeben werden.',
      'Unter keinen Umständen diese Information darf weitergegeben werden.',
      'Unter keinen Umständen darf weitergegeben werden diese Information.',
      'Unter keinen Umständen diese Information weitergegeben werden darf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach einer negativen adverbialen Bestimmung im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Unter keinen Umständen darf diese Information weitergegeben werden.',
    'grammarRule': 'Inversion nach negativer adverbialer Bestimmung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Inanspruchnahme öffentlicher Mittel bedarf einer Genehmigung.',
      'Die Inanspruchnahme öffentlichen Mittel bedarf einer Genehmigung.',
      'Die Inanspruchnahme öffentlicher Mittel bedürfen einer Genehmigung.',
      'Die Inanspruchnahme öffentliche Mittel bedarf einer Genehmigung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Inanspruchnahme + Genitiv Plural (öffentlicher Mittel). Subjekt Singular → bedarf.',
    'exampleSentence': 'Die Inanspruchnahme öffentlicher Mittel bedarf einer Genehmigung.',
    'grammarRule': 'Nominalstil mit Genitiv + bedürfen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die auf dem Kongress vorgestellten Ergebnisse waren überraschend.',
      'Die auf dem Kongress vorgestellte Ergebnisse waren überraschend.',
      'Die auf dem Kongress vorgestellter Ergebnisse waren überraschend.',
      'Die auf dem Kongress vorstellenden Ergebnisse waren überraschend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: vorgestellten (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die auf dem Kongress vorgestellten Ergebnisse waren überraschend.',
    'grammarRule': 'Erweitertes Partizip II Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Arzt empfahl, der Patient nehme das Medikament regelmäßig.',
      'Der Arzt empfahl, der Patient nimmt das Medikament regelmäßig.',
      'Der Arzt empfahl, der Patient nehme das Medikament regelmäßig nehme.',
      'Der Arzt empfahl, der Patient nähme das Medikament regelmäßig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: nehme (3. Person Singular Konjunktiv I von nehmen).',
    'exampleSentence': 'Der Arzt empfahl, der Patient nehme das Medikament regelmäßig.',
    'grammarRule': 'Konjunktiv I: nehmen → nehme',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bleibt abzuwarten, ob die Strategie erfolgreich sein wird.',
      'Es bleibt abwarten, ob die Strategie erfolgreich sein wird.',
      'Es bleibt abzuwarten zu, ob die Strategie erfolgreich sein wird.',
      'Es bleibt abgewartet, ob die Strategie erfolgreich sein wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: bleiben + zu + Infinitiv: bleibt abzuwarten (= muss abgewartet werden).',
    'exampleSentence': 'Es bleibt abzuwarten, ob die Strategie erfolgreich sein wird.',
    'grammarRule': 'Passiversatzform: bleiben + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sosehr er sich auch bemühte, er konnte das Ziel nicht erreichen.',
      'Sosehr er sich auch bemühte, konnte er das Ziel nicht erreichen.',
      'Sosehr er bemühte sich auch, er konnte das Ziel nicht erreichen.',
      'Sosehr er sich auch bemühte er, konnte das Ziel nicht erreichen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit sosehr: Im Nebensatz steht das Verb am Ende, der Hauptsatz folgt mit normaler Wortstellung.',
    'exampleSentence': 'Sosehr er sich auch bemühte, er konnte das Ziel nicht erreichen.',
    'grammarRule': 'Satzgefüge: sosehr + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Beschluss wurde zur Kenntnis gebracht.',
      'Der Beschluss wurde zur Kenntnis genommen.',
      'Der Beschluss wurde zur Kenntnis gezogen.',
      'Der Beschluss wurde zur Kenntnis gemacht.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: etwas zur Kenntnis nehmen (= wahrnehmen, beachten). Passiv: wurde zur Kenntnis genommen.',
    'exampleSentence': 'Der Beschluss wurde zur Kenntnis genommen.',
    'grammarRule': 'Funktionsverbgefüge: zur Kenntnis nehmen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Innerhalb des vorgegebenen Rahmens ist alles erlaubt.',
      'Innerhalb dem vorgegebenen Rahmen ist alles erlaubt.',
      'Innerhalb des vorgegebenen Rahmen ist alles erlaubt.',
      'Innerhalb den vorgegebenen Rahmens ist alles erlaubt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Innerhalb verlangt den Genitiv: innerhalb des vorgegebenen Rahmens.',
    'exampleSentence': 'Innerhalb des vorgegebenen Rahmens ist alles erlaubt.',
    'grammarRule': 'Präposition innerhalb + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst nachdem alle Gäste eingetroffen waren, wurde mit dem Essen begonnen.',
      'Erst nachdem alle Gäste eingetroffen waren, mit dem Essen wurde begonnen.',
      'Erst nachdem alle Gäste waren eingetroffen, wurde mit dem Essen begonnen.',
      'Erst nachdem eingetroffen waren alle Gäste, wurde mit dem Essen begonnen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporalsatz mit nachdem: Im Nebensatz Verb am Ende, im Hauptsatz Inversion nach vorangestelltem Nebensatz.',
    'exampleSentence': 'Erst nachdem alle Gäste eingetroffen waren, wurde mit dem Essen begonnen.',
    'grammarRule': 'Wortstellung: Temporalsatz mit nachdem',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zur Vermeidung von Missverständnissen sollte man klar kommunizieren.',
      'Zur Vermeidung vor Missverständnissen sollte man klar kommunizieren.',
      'Zur Vermeidung von Missverständnisse sollte man klar kommunizieren.',
      'Zum Vermeidung von Missverständnissen sollte man klar kommunizieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: zur Vermeidung von + Dativ Plural (Missverständnissen). Vermeidung ist feminin → zur.',
    'exampleSentence': 'Zur Vermeidung von Missverständnissen sollte man klar kommunizieren.',
    'grammarRule': 'Nominalstil: zur Vermeidung von + Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der sich schnell verändernde Markt erfordert flexible Strategien.',
      'Der sich schnell verändernden Markt erfordert flexible Strategien.',
      'Der sich schnell veränderter Markt erfordert flexible Strategien.',
      'Der sich schnell veränderndem Markt erfordert flexible Strategien.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I mit Reflexivpronomen: verändernde (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der sich schnell verändernde Markt erfordert flexible Strategien.',
    'grammarRule': 'Erweitertes Partizip I mit Reflexivpronomen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man sagt, er spreche fünf Sprachen fließend.',
      'Man sagt, er spricht fünf Sprachen fließend.',
      'Man sagt, er spräche fünf Sprachen fließend.',
      'Man sagt, er spreche fünf Sprachen fließend spricht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: spreche (3. Person Singular von sprechen).',
    'exampleSentence': 'Man sagt, er spreche fünf Sprachen fließend.',
    'grammarRule': 'Konjunktiv I: sprechen → spreche',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Diese Frage ist schwer beantwortbar.',
      'Diese Frage ist schwer zu beantwortbar.',
      'Diese Frage ist schwer beantwortenbar.',
      'Diese Frage ist schwer zu beantwortenbar.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: beantwortbar (= kann beantwortet werden).',
    'exampleSentence': 'Diese Frage ist schwer beantwortbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenngleich die Ergebnisse vielversprechend sind, bedarf es weiterer Forschung.',
      'Wenngleich die Ergebnisse vielversprechend sind, es bedarf weiterer Forschung.',
      'Wenngleich die Ergebnisse sind vielversprechend, bedarf es weiterer Forschung.',
      'Wenngleich die Ergebnisse vielversprechend sind, bedarf weiterer Forschung es.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit wenngleich: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Wenngleich die Ergebnisse vielversprechend sind, bedarf es weiterer Forschung.',
    'grammarRule': 'Satzgefüge: wenngleich + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die neue Regelung wurde in Frage gebracht.',
      'Die neue Regelung wurde in Frage gestellt.',
      'Die neue Regelung wurde in Frage genommen.',
      'Die neue Regelung wurde in Frage gezogen.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: etwas in Frage stellen (= bezweifeln). Passiv: wurde in Frage gestellt.',
    'exampleSentence': 'Die neue Regelung wurde in Frage gestellt.',
    'grammarRule': 'Funktionsverbgefüge: in Frage stellen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zugunsten der Mitarbeiter wurde die Arbeitszeit verkürzt.',
      'Zugunsten den Mitarbeitern wurde die Arbeitszeit verkürzt.',
      'Zugunsten der Mitarbeitern wurde die Arbeitszeit verkürzt.',
      'Zugunsten die Mitarbeiter wurde die Arbeitszeit verkürzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zugunsten verlangt den Genitiv: zugunsten der Mitarbeiter (Genitiv Plural).',
    'exampleSentence': 'Zugunsten der Mitarbeiter wurde die Arbeitszeit verkürzt.',
    'grammarRule': 'Präposition zugunsten + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hätte ich das gewusst, wäre ich anders vorgegangen.',
      'Hätte ich das gewusst, ich wäre anders vorgegangen.',
      'Ich hätte das gewusst, wäre ich anders vorgegangen.',
      'Hätte ich das gewusst, wäre anders ich vorgegangen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz ohne wenn: Verb an erster Stelle im Nebensatz, Inversion im Hauptsatz.',
    'exampleSentence': 'Hätte ich das gewusst, wäre ich anders vorgegangen.',
    'grammarRule': 'Irrealer Konditionalsatz ohne wenn',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Überprüfung der Ergebnisse steht noch aus.',
      'Die Überprüfung den Ergebnissen steht noch aus.',
      'Die Überprüfung der Ergebnissen steht noch aus.',
      'Die Überprüfung die Ergebnisse steht noch aus.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Überprüfung + Genitiv Plural (der Ergebnisse).',
    'exampleSentence': 'Die Überprüfung der Ergebnisse steht noch aus.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p1-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein vom Sturm entwurzelter Baum blockierte die Straße.',
      'Ein vom Sturm entwurzelten Baum blockierte die Straße.',
      'Ein vom Sturm entwurzelnder Baum blockierte die Straße.',
      'Ein vom Sturm entwurzeltem Baum blockierte die Straße.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: entwurzelter (Nominativ maskulin Singular mit unbestimmtem Artikel: -er).',
    'exampleSentence': 'Ein vom Sturm entwurzelter Baum blockierte die Straße.',
    'grammarRule': 'Erweitertes Partizip II mit unbestimmtem Artikel',
    'tags': ['satzkorrektur']
  }
];

export default questions;
