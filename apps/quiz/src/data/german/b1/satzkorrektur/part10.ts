import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wechselpräposition + Dativ',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder spielen ins Garten.',
      'Die Kinder spielen in Garten.',
      'Die Kinder spielen im Garten.',
      'Die Kinder spielen in den Garten.'
    ],
    'correctAnswer': 2,
    'explanation': 'Wo? → Dativ: im Garten (in dem Garten).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Dokument wurde gestern abgeschickt.',
      'Das Dokument wurde gestern abschicken.',
      'Das Dokument wurde gestern geabschickt.',
      'Das Dokument wurde gestern abgeschicken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Präteritum: wurde + Partizip II. Trennbares Verb: ab|schicken → abgeschickt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat seinem Nachbarn beim Umzug geholfen.',
      'Er hat seinen Nachbarn beim Umzug geholfen.',
      'Er hat sein Nachbar beim Umzug geholfen.',
      'Er hat seinem Nachbar beim Umzug geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Helfen\' verlangt Dativ. \'Nachbar\' ist N-Deklination: dem/seinem Nachbarn (Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Tatsächlich hat er recht gehabt.',
      'Tatsächlich er hat recht gehabt.',
      'Tatsächlich hat recht er gehabt.',
      'Tatsächlich gehabt hat er recht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'tatsächlich\' am Satzanfang: Verb auf Position 2 mit Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat dem kleinen Mädchen einen Teddy geschenkt.',
      'Er hat das kleine Mädchen einen Teddy geschenkt.',
      'Er hat dem kleinen Mädchen ein Teddy geschenkt.',
      'Er hat dem kleiner Mädchen einen Teddy geschenkt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schenken\' + Dativ (Person): dem kleinen Mädchen (Neutrum Dativ). \'Teddy\' ist maskulin: einen Teddy.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er zweifelt an der Richtigkeit der Aussage.',
      'Er zweifelt über die Richtigkeit der Aussage.',
      'Er zweifelt für die Richtigkeit der Aussage.',
      'Er zweifelt auf die Richtigkeit der Aussage.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Zweifeln an\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seit er den neuen Job hat, ist er viel glücklicher.',
      'Seit er den neuen Job hat, er ist viel glücklicher.',
      'Seit er hat den neuen Job, ist er viel glücklicher.',
      'Seit den neuen Job er hat, ist er viel glücklicher.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'seit\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Bild hängt über dem gemütlichen Sofa.',
      'Das Bild hängt über dem gemütlicher Sofa.',
      'Das Bild hängt über den gemütlichen Sofa.',
      'Das Bild hängt über der gemütlichen Sofa.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Über\' + Dativ (Wo?). \'Sofa\' ist Neutrum: dem gemütlichen Sofa.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kaum hatte er den Raum betreten, klingelte sein Handy.',
      'Kaum hat er den Raum betreten, klingelte sein Handy.',
      'Kaum betrat er den Raum, klingelte sein Handy.',
      'Kaum hatte er den Raum betreten, klingelt sein Handy.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaum\' + Plusquamperfekt für Vorzeitigkeit. Im Hauptsatz Präteritum.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat mich darum gebeten, ihn abzuholen.',
      'Er hat mich darum gebeten, ihn zu abholen.',
      'Er hat mich darum gebeten, ihn abholen.',
      'Er hat mich darum gebeten, ihn abgeholt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: abzuholen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Infolge des Unfalls wurde die Straße gesperrt.',
      'Infolge dem Unfall wurde die Straße gesperrt.',
      'Infolge den Unfall wurde die Straße gesperrt.',
      'Infolge der Unfall wurde die Straße gesperrt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Infolge\' verlangt den Genitiv: infolge des Unfalls (maskulin Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Folglich muss eine neue Lösung gefunden werden.',
      'Folglich eine neue Lösung muss gefunden werden.',
      'Folglich muss gefunden eine neue Lösung werden.',
      'Folglich gefunden werden muss eine neue Lösung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'folglich\' am Satzanfang: Verb auf Position 2: muss eine neue Lösung...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das ist der Kollege, mit dem ich zusammenarbeite.',
      'Das ist der Kollege, mit den ich zusammenarbeite.',
      'Das ist der Kollege, mit der ich zusammenarbeite.',
      'Das ist der Kollege, mit das ich zusammenarbeite.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen mit \'mit\' + Dativ. \'Kollege\' ist maskulin: mit dem.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hängt sehr an ihrer Familie.',
      'Sie hängt sehr auf ihre Familie.',
      'Sie hängt sehr über ihrer Familie.',
      'Sie hängt sehr für ihre Familie.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Hängen an\' + Dativ (emotional verbunden sein) ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Während die Eltern arbeiten, sind die Kinder in der Schule.',
      'Während die Eltern arbeiten, die Kinder sind in der Schule.',
      'Während arbeiten die Eltern, sind die Kinder in der Schule.',
      'Während die Eltern arbeiten, in der Schule sind die Kinder.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'während\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben den ganzen Abend über interessante Themen gesprochen.',
      'Wir haben den ganzen Abend über interessanten Themen gesprochen.',
      'Wir haben der ganze Abend über interessante Themen gesprochen.',
      'Wir haben den ganzen Abend über interessanter Themen gesprochen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Über\' + Akkusativ Plural: interessante Themen. Akkusativ der Zeit: den ganzen Abend.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wird nächstes Jahr ihr Studium abschließen.',
      'Sie wird nächstes Jahr ihr Studium abgeschlossen.',
      'Sie wird nächstes Jahr ihr Studium abschließt.',
      'Sie wurde nächstes Jahr ihr Studium abschließen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: wird + Infinitiv (abschließen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es vermieden, über das Thema zu sprechen.',
      'Er hat es vermieden, über das Thema sprechen.',
      'Er hat es vermieden, über das Thema zu gesprochen.',
      'Er hat es vermieden, über das Thema sprechen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'vermeiden\' folgt ein Infinitivsatz mit \'zu\': zu sprechen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet der Warnung ging er allein in den Wald.',
      'Ungeachtet die Warnung ging er allein in den Wald.',
      'Ungeachtet dem Warnung ging er allein in den Wald.',
      'Ungeachtet den Warnung ging er allein in den Wald.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Ungeachtet\' verlangt den Genitiv: ungeachtet der Warnung (feminin Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin auf die Unterstützung meiner Freunde angewiesen.',
      'Ich bin für die Unterstützung meiner Freunde angewiesen.',
      'Ich bin über die Unterstützung meiner Freunde angewiesen.',
      'Ich bin an die Unterstützung meiner Freunde angewiesen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Angewiesen auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestotrotz hat er eine gute Leistung erbracht.',
      'Nichtsdestotrotz er hat eine gute Leistung erbracht.',
      'Nichtsdestotrotz hat eine gute Leistung er erbracht.',
      'Nichtsdestotrotz erbracht hat er eine gute Leistung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'nichtsdestotrotz\' am Satzanfang: Verb auf Position 2 mit Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er arbeitet in einem großen internationalen Unternehmen.',
      'Er arbeitet in einen großen internationalen Unternehmen.',
      'Er arbeitet in einem großer internationaler Unternehmen.',
      'Er arbeitet in ein großes internationales Unternehmen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'In\' + Dativ (Wo?). \'Unternehmen\' ist Neutrum: einem großen internationalen Unternehmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Um Missverständnisse zu vermeiden, sollte man klar kommunizieren.',
      'Um Missverständnisse vermeiden, sollte man klar kommunizieren.',
      'Um zu vermeiden Missverständnisse, sollte man klar kommunizieren.',
      'Um Missverständnisse zu vermeiden, man sollte klar kommunizieren.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Um ... zu\' + Infinitiv: um Missverständnisse zu vermeiden. \'Zu\' steht direkt vor dem Infinitiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Angebot gilt für alle neuen Kunden.',
      'Das Angebot gilt für alle neue Kunden.',
      'Das Angebot gilt für alle neuer Kunden.',
      'Das Angebot gilt für allen neuen Kunden.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Für\' + Akkusativ Plural. Nach \'alle\': schwache Deklination: alle neuen Kunden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem er den Vertrag unterschrieben hatte, ging er nach Hause.',
      'Nachdem er den Vertrag unterschrieben hat, ging er nach Hause.',
      'Nachdem er den Vertrag unterschrieb, ging er nach Hause.',
      'Nachdem er den Vertrag unterschrieben hatte, er ging nach Hause.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'nachdem\' Plusquamperfekt (hatte unterschrieben), im Hauptsatz Präteritum (ging).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wünscht sich, in Paris leben zu können.',
      'Sie wünscht sich, in Paris leben können.',
      'Sie wünscht sich, in Paris zu leben können.',
      'Sie wünscht sich, in Paris leben zu können.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz mit Modalverb: zu + Infinitiv des Modalverbs am Ende: leben zu können.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie überreicht dem Gewinner den Pokal.',
      'Sie überreicht den Gewinner den Pokal.',
      'Sie überreicht der Gewinner den Pokal.',
      'Sie überreicht dem Gewinner der Pokal.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Überreichen\' + Dativ (Person) + Akkusativ (Sache): dem Gewinner den Pokal.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er besteht aus drei Teilen.',
      'Er besteht von drei Teilen.',
      'Er besteht mit drei Teilen.',
      'Er besteht über drei Teile.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Bestehen aus\' + Dativ (zusammengesetzt sein) ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bedauerlicherweise können wir Ihnen nicht helfen.',
      'Bedauerlicherweise wir können Ihnen nicht helfen.',
      'Bedauerlicherweise können Ihnen nicht wir helfen.',
      'Bedauerlicherweise helfen können wir Ihnen nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'bedauerlicherweise\' am Satzanfang: Verb auf Position 2: können wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie gibt dem traurigen Kind ein Stück Schokolade.',
      'Sie gibt das traurige Kind ein Stück Schokolade.',
      'Sie gibt den traurigen Kind ein Stück Schokolade.',
      'Sie gibt dem trauriger Kind ein Stück Schokolade.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Geben\' + Dativ (Person). \'Kind\' ist Neutrum: dem traurigen Kind.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Weil er krank war, konnte er nicht zur Arbeit gehen.',
      'Weil er krank war, er konnte nicht zur Arbeit gehen.',
      'Weil er war krank, konnte er nicht zur Arbeit gehen.',
      'Weil krank er war, konnte er nicht zur Arbeit gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'weil\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er trinkt gern Kaffee mit frischer Milch.',
      'Er trinkt gern Kaffee mit frische Milch.',
      'Er trinkt gern Kaffee mit frischem Milch.',
      'Er trinkt gern Kaffee mit frischen Milch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Milch\' ist feminin. \'Mit\' + Dativ ohne Artikel (starke Deklination): frischer Milch.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich das gewusst hätte, hätte ich anders gehandelt.',
      'Wenn ich das gewusst habe, hätte ich anders gehandelt.',
      'Wenn ich das gewusst hätte, habe ich anders gehandelt.',
      'Wenn ich das gewusst hätte, würde ich anders gehandelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Plusquamperfekt: hätte gewusst + hätte gehandelt. Für irreale Vergangenheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man hat ihm geraten, einen Anwalt einzuschalten.',
      'Man hat ihm geraten, einen Anwalt zu einschalten.',
      'Man hat ihm geraten, einen Anwalt einschalten.',
      'Man hat ihm geraten, einen Anwalt eingeschaltet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: einzuschalten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jenseits des Flusses liegt ein kleines Dorf.',
      'Jenseits dem Fluss liegt ein kleines Dorf.',
      'Jenseits den Fluss liegt ein kleines Dorf.',
      'Jenseits der Fluss liegt ein kleines Dorf.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Jenseits\' verlangt den Genitiv: jenseits des Flusses (maskulin Genitiv).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin neugierig auf das Ergebnis.',
      'Ich bin neugierig über das Ergebnis.',
      'Ich bin neugierig für das Ergebnis.',
      'Ich bin neugierig an dem Ergebnis.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Neugierig auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erstens habe ich keine Zeit und zweitens kein Geld.',
      'Erstens ich habe keine Zeit und zweitens kein Geld.',
      'Erstens habe keine Zeit ich und zweitens kein Geld.',
      'Erstens keine Zeit habe ich und zweitens kein Geld.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'erstens\' am Satzanfang: Verb auf Position 2 mit Inversion: habe ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wartet auf den nächsten Bus.',
      'Er wartet auf dem nächsten Bus.',
      'Er wartet auf der nächste Bus.',
      'Er wartet auf das nächste Bus.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Warten auf\' + Akkusativ. \'Bus\' ist maskulin: den nächsten Bus.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ob er kommt oder nicht, ist mir egal.',
      'Ob kommt er oder nicht, ist mir egal.',
      'Ob er kommt oder nicht, mir ist egal.',
      'Ob er oder nicht kommt, ist mir egal.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'ob\' steht das Verb am Ende: ob er kommt. Der Hauptsatz ist normal: ist mir egal.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jedes kleine Detail ist wichtig.',
      'Jedes kleines Detail ist wichtig.',
      'Jedem kleinen Detail ist wichtig.',
      'Jeder kleine Detail ist wichtig.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Detail\' ist Neutrum. Nominativ: jedes kleine Detail. Nach \'jedes\' schwache Deklination: kleine.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Als sie das hörte, fing sie an zu weinen.',
      'Wenn sie das hörte, fing sie an zu weinen.',
      'Als sie das hört, fing sie an zu weinen.',
      'Als sie das hörte, sie fing an zu weinen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Als\' für einmaliges Ereignis in der Vergangenheit. Präteritum in beiden Satzteilen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Arzt hat ihm empfohlen, mehr Wasser zu trinken.',
      'Der Arzt hat ihm empfohlen, mehr Wasser trinken.',
      'Der Arzt hat ihm empfohlen, mehr Wasser zu getrunken.',
      'Der Arzt hat ihm empfohlen, mehr Wasser trinken zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'empfehlen\' folgt ein Infinitivsatz mit \'zu\': zu trinken.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie leiht ihrem Kollegen ihr Auto.',
      'Sie leiht ihren Kollegen ihr Auto.',
      'Sie leiht ihr Kollege ihr Auto.',
      'Sie leiht ihrem Kollege ihr Auto.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Leihen\' + Dativ (Person) + Akkusativ (Sache). \'Kollege\' N-Deklination Dativ: dem/ihrem Kollegen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist auf ihren Sohn sehr stolz.',
      'Sie ist über ihren Sohn sehr stolz.',
      'Sie ist für ihren Sohn sehr stolz.',
      'Sie ist von ihrem Sohn sehr stolz.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Stolz auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selbstverständlich können Sie sich jederzeit an uns wenden.',
      'Selbstverständlich Sie können sich jederzeit an uns wenden.',
      'Selbstverständlich können sich jederzeit Sie an uns wenden.',
      'Selbstverständlich an uns wenden können Sie sich jederzeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'selbstverständlich\' am Satzanfang: Verb auf Position 2 mit Inversion: können Sie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem, über das wir gesprochen haben, ist gelöst.',
      'Das Problem, über den wir gesprochen haben, ist gelöst.',
      'Das Problem, über der wir gesprochen haben, ist gelöst.',
      'Das Problem, über die wir gesprochen haben, ist gelöst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen mit \'über\' + Akkusativ. \'Problem\' ist Neutrum: über das.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je mehr man reist, desto mehr lernt man.',
      'Je mehr man reist, desto man mehr lernt.',
      'Je mehr reist man, desto mehr lernt man.',
      'Je man mehr reist, desto mehr lernt man.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Je ... desto\': Im \'je\'-Satz steht das Verb am Ende. Im \'desto\'-Satz folgt das Verb nach dem Komparativ.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aus verschiedenen Gründen kann ich nicht kommen.',
      'Aus verschiedener Gründen kann ich nicht kommen.',
      'Aus verschiedene Gründen kann ich nicht kommen.',
      'Aus verschiedenem Gründen kann ich nicht kommen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Aus\' + Dativ Plural ohne Artikel (starke Deklination): verschiedenen Gründen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wird wohl schon nach Hause gegangen sein.',
      'Er wird wohl schon nach Hause gegangen.',
      'Er wird wohl schon nach Hause gehen sein.',
      'Er werde wohl schon nach Hause gegangen sein.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur II mit \'sein\': wird + Partizip II + sein. Für Vermutung über Vergangenes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p10-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich vorgenommen, ab morgen gesünder zu leben.',
      'Er hat sich vorgenommen, ab morgen gesünder leben.',
      'Er hat sich vorgenommen, ab morgen gesünder zu gelebt.',
      'Er hat sich vorgenommen, ab morgen gesünder leben zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'sich vornehmen\' folgt ein Infinitivsatz mit \'zu\': zu leben.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
