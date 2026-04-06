import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-002',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Wofür wird das Präteritum hauptsächlich verwendet?',
    'options': ['Vorvergangenheit', 'Vergangenheit (schriftlich/Erzählung)', 'Gegenwart / allgemeine Aussagen', 'abgeschlossene Zukunft / Vermutung über Vergangenes'],
    'correctAnswer': 1,
    'explanation': 'Das Präteritum wird für Vergangenheit (schriftlich/Erzählung) verwendet.',
    'exampleSentence': 'Er lernte Deutsch.',
    'subcategory': 'Verwendung',
    'tags': ['zeitformen', 'verwendung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-007',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welche Funktion hat das Plusquamperfekt in Erzähltexten?',
    'options': [
      'Es leitet die Erzählung ein.',
      'Es beschreibt Hintergründe und Rückblenden vor dem Erzählzeitpunkt.',
      'Es drückt die Zukunft aus.',
      'Es ist ein Stilmittel für die Gegenwart.'
    ],
    'correctAnswer': 1,
    'explanation': 'In Erzähltexten wird das Plusquamperfekt für Rückblenden verwendet: Es beschreibt Ereignisse, die vor dem Erzählzeitpunkt (im Präteritum) stattfanden.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'erzählung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-009',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welche Zeitenfolge ist korrekt mit \'seitdem\'?',
    'options': [
      'Seitdem er umgezogen ist, fährt er mit dem Bus.',
      'Seitdem er umzog, fährt er mit dem Bus.',
      'Seitdem er umziehen wird, fährt er mit dem Bus.',
      'Seitdem er umgezogen hatte, fährt er mit dem Bus.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Seitdem\' + Perfekt (vergangener Startpunkt) + Präsens (andauernde Handlung): \'Seitdem er umgezogen ist, fährt er mit dem Bus.\'',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'seitdem', 'zeitenfolge']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-010',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was drückt \'Sie wird sich wohl verspätet haben.\' aus?',
    'options': [
      'Sie verspätet sich in der Zukunft.',
      'Eine Vermutung: Wahrscheinlich hat sie sich verspätet.',
      'Sie hat sich definitiv verspätet.',
      'Sie wird sich bald verspäten.'
    ],
    'correctAnswer': 1,
    'explanation': 'Futur II mit \'wohl\' drückt eine Vermutung über Vergangenes aus: Man vermutet, dass sie sich verspätet hat.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'vermutung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-011',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Ergänze: \'Nachdem das Gewitter ___ hatte, schien die Sonne wieder.\'',
    'options': ['aufhören', 'aufhört', 'aufgehört', 'aufhörte'],
    'correctAnswer': 2,
    'explanation': 'Plusquamperfekt: \'aufgehört hatte\' (Partizip II + haben im Präteritum). \'Nachdem\' + Plusquamperfekt → Präteritum.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'nachdem']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-012',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt die korrekte Verwendung von \'sobald\' mit Vorzeitigkeit?',
    'options': [
      'Sobald er ankommt, werden wir essen.',
      'Sobald er angekommen war, setzte er sich hin.',
      'Sobald er ankommen wird, essen wir.',
      'Sobald er aß, ging er.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Sobald\' + Plusquamperfekt (\'angekommen war\') + Präteritum im Hauptsatz zeigt die korrekte Vorzeitigkeit in der Vergangenheit.',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'sobald', 'plusquamperfekt']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-013',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was bedeutet der Satz: \'Sie wird schon wissen, was sie tut.\'?',
    'options': [
      'Sie weiß es in der Zukunft.',
      'Man vermutet, dass sie weiß, was sie tut.',
      'Sie wusste es in der Vergangenheit.',
      'Eine Aufforderung, dass sie es wissen soll.'
    ],
    'correctAnswer': 1,
    'explanation': 'Futur I mit \'schon\' drückt eine Vermutung über die Gegenwart aus: Man vermutet, dass sie weiß, was sie tut.',
    'subcategory': 'Futur I',
    'tags': ['zeitformen', 'futur', 'vermutung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-015',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt das Futur II als abgeschlossene Zukunft?',
    'options': [
      'Er wird das wohl nicht verstanden haben.',
      'Bis Mitternacht werden wir alles vorbereitet haben.',
      'Er wird morgen kommen.',
      'Sie hat alles vorbereitet.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Bis Mitternacht werden wir alles vorbereitet haben.\' zeigt, dass die Vorbereitung bis Mitternacht abgeschlossen sein wird.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'abgeschlossen']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-016',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was ist der Unterschied zwischen \'als\' und \'nachdem\' bezüglich der Zeitform?',
    'options': [
      '\'Als\' verlangt immer Plusquamperfekt, \'nachdem\' nicht.',
      '\'Nachdem\' verlangt einen Zeitstufenwechsel, \'als\' erlaubt dieselbe Zeitstufe.',
      'Es gibt keinen Unterschied.',
      '\'Als\' steht nur im Futur, \'nachdem\' nur im Perfekt.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Nachdem\' verlangt einen Zeitstufenwechsel (z. B. Plusquamperfekt + Präteritum). \'Als\' erlaubt dieselbe Zeitstufe (z. B. Präteritum + Präteritum).',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'als', 'nachdem', 'unterschied']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-018',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'In welchem Satz steht das Plusquamperfekt im Passiv?',
    'options': [
      'Der Brief wurde geschrieben.',
      'Der Brief war geschrieben worden.',
      'Der Brief wird geschrieben werden.',
      'Der Brief ist geschrieben worden.'
    ],
    'correctAnswer': 1,
    'explanation': '\'War ... geschrieben worden\' ist Plusquamperfekt Passiv (sein im Präteritum + Partizip II + worden).',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'passiv']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-019',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was drückt der Satz \'Das wird schon stimmen.\' aus?',
    'options': [
      'Eine zukünftige Handlung',
      'Eine Vermutung über die Gegenwart',
      'Eine Aufforderung',
      'Die Vorvergangenheit'
    ],
    'correctAnswer': 1,
    'explanation': 'Futur I mit \'schon\' drückt eine Vermutung über die Gegenwart aus: Man vermutet, dass es stimmt.',
    'subcategory': 'Futur I',
    'tags': ['zeitformen', 'futur', 'vermutung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-020',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Ergänze: \'Nachdem die Verhandlungen ___ waren, wurde der Vertrag unterzeichnet.\'',
    'options': ['abschließen', 'abgeschlossen', 'abschloss', 'abschließend'],
    'correctAnswer': 1,
    'explanation': 'Plusquamperfekt Passiv: \'abgeschlossen worden waren\' (hier verkürzt: \'abgeschlossen waren\' als Zustandspassiv im Plusquamperfekt).',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'nachdem']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-021',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt das Futur II korrekt mit \'sein\'?',
    'options': [
      'Er wird angekommen sein.',
      'Er wird angekommen haben.',
      'Er ist angekommen werden.',
      'Er hatte angekommen sein.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wird angekommen sein\' ist Futur II mit \'sein\' (für Bewegungsverben): werden + Partizip II + sein.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'sein']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-022',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welche Partikel verstärkt die Vermutungsbedeutung des Futur I?',
    'options': ['schon', 'wohl', 'noch', 'Alle genannten können die Vermutung verstärken.'],
    'correctAnswer': 3,
    'explanation': '\'Wohl\', \'schon\' und \'noch\' können die Vermutungsbedeutung des Futur I verstärken: \'Er wird wohl/schon krank sein.\'',
    'subcategory': 'Futur I',
    'tags': ['zeitformen', 'futur', 'partikeln']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-024',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was drückt \'Bis Freitag wird er den Bericht eingereicht haben.\' aus?',
    'options': [
      'Eine Vermutung über Vergangenes',
      'Eine abgeschlossene Handlung zu einem zukünftigen Zeitpunkt',
      'Eine Handlung in der Gegenwart',
      'Die Vorvergangenheit'
    ],
    'correctAnswer': 1,
    'explanation': 'Futur II mit \'bis Freitag\' drückt aus, dass der Bericht bis zu diesem zukünftigen Zeitpunkt fertig eingereicht sein wird.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'abgeschlossen']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-025',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welche Zeitenfolge ist bei \'während\' korrekt?',
    'options': [
      'Während er kochte, las sie ein Buch.',
      'Während er gekocht hatte, las sie ein Buch.',
      'Während er kochen wird, las sie ein Buch.',
      'Während er kocht, las sie ein Buch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Während\' drückt Gleichzeitigkeit aus. Beide Satzteile stehen in derselben Zeitform: Präteritum + Präteritum.',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'während', 'gleichzeitigkeit']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-027',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt \'kaum ... da\' mit korrekter Zeitenfolge?',
    'options': [
      'Kaum war er eingestiegen, da fuhr der Zug ab.',
      'Kaum ist er eingestiegen, da fuhr der Zug ab.',
      'Kaum stieg er ein, da war der Zug abgefahren.',
      'Kaum wird er eingestiegen sein, da fährt der Zug.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kaum ... da\' mit Plusquamperfekt + Präteritum: \'Kaum war er eingestiegen, da fuhr der Zug ab.\'',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'kaum']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-028',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Warum sagt man in Norddeutschland eher \'Ich ging\' als \'Ich bin gegangen\'?',
    'options': [
      'Weil dort nur das Präteritum grammatisch korrekt ist.',
      'In Norddeutschland wird das Präteritum auch mündlich für alle Verben bevorzugt.',
      'Weil das Perfekt in Norddeutschland unbekannt ist.',
      'Es gibt keinen regionalen Unterschied.'
    ],
    'correctAnswer': 1,
    'explanation': 'In Norddeutschland tendiert man dazu, auch mündlich das Präteritum zu verwenden, während in Süddeutschland, Österreich und der Schweiz das Perfekt bevorzugt wird.',
    'subcategory': 'Perfekt vs. Präteritum',
    'tags': ['zeitformen', 'regional', 'präteritum']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-030',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt das Futur I als Zukunftsaussage?',
    'options': [
      'Er wird wohl krank sein.',
      'Du wirst das sofort aufräumen!',
      'Wir werden nächstes Jahr nach Japan reisen.',
      'Er wird schon wissen, was er tut.'
    ],
    'correctAnswer': 2,
    'explanation': '\'Wir werden nächstes Jahr nach Japan reisen.\' ist eine reine Zukunftsaussage ohne Vermutungs- oder Aufforderungsbedeutung.',
    'subcategory': 'Futur I',
    'tags': ['zeitformen', 'futur', 'zukunft']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-031',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Wie bildet man das Plusquamperfekt Passiv?',
    'options': [
      'werden im Präteritum + Partizip II',
      'sein im Präteritum + Partizip II + worden',
      'haben im Präteritum + Partizip II + werden',
      'sein im Präsens + Partizip II + worden'
    ],
    'correctAnswer': 1,
    'explanation': 'Plusquamperfekt Passiv: sein im Präteritum + Partizip II + worden: \'Das Haus war gebaut worden.\'',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'passiv']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-033',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt die korrekte Zeitenfolge bei Gegenwartsbezug?',
    'options': [
      'Nachdem ich gegessen habe, gehe ich spazieren.',
      'Nachdem ich aß, gehe ich spazieren.',
      'Nachdem ich esse, gehe ich spazieren.',
      'Nachdem ich gegessen hatte, gehe ich spazieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei Gegenwartsbezug: \'nachdem\' + Perfekt + Präsens: \'Nachdem ich gegessen habe, gehe ich spazieren.\'',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'nachdem', 'gegenwart']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-034',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was drückt \'Du wirst dich noch wundern!\' aus?',
    'options': [
      'Eine Vermutung über die Gegenwart',
      'Eine Warnung oder Drohung',
      'Eine abgeschlossene Zukunft',
      'Die Vorvergangenheit'
    ],
    'correctAnswer': 1,
    'explanation': '\'Du wirst dich noch wundern!\' nutzt das Futur I als Warnung oder Drohung.',
    'subcategory': 'Futur I',
    'tags': ['zeitformen', 'futur', 'warnung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-035',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Ergänze: \'Nachdem die Mannschaft das Spiel ___ hatte, feierte sie den Sieg.\'',
    'options': ['gewinnen', 'gewonnen', 'gewinnt', 'gewann'],
    'correctAnswer': 1,
    'explanation': 'Plusquamperfekt: \'gewonnen hatte\' (Partizip II + haben im Präteritum). \'Nachdem\' verlangt Vorzeitigkeit.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'nachdem']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-036',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz verwendet \'bis\' + Futur II korrekt?',
    'options': [
      'Bis morgen habe ich alles erledigt.',
      'Bis morgen werde ich alles erledigt haben.',
      'Bis morgen hatte ich alles erledigt.',
      'Bis morgen erledige ich alles.'
    ],
    'correctAnswer': 1,
    'explanation': '\'Bis morgen werde ich alles erledigt haben.\' ist Futur II mit \'bis\' für eine abgeschlossene Zukunft.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'bis']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-037',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was drückt \'Es wird wohl einen Grund dafür gegeben haben.\' aus?',
    'options': [
      'In Zukunft gibt es einen Grund.',
      'Man vermutet, dass es einen Grund gegeben hat.',
      'Es gab definitiv einen Grund.',
      'Es wird in Zukunft einen Grund geben.'
    ],
    'correctAnswer': 1,
    'explanation': 'Futur II mit \'wohl\': Vermutung über Vergangenes. Man vermutet rückblickend, dass es einen Grund gab.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'vermutung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-040',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welche Zeitenfolge ist bei \'solange\' korrekt?',
    'options': [
      'Solange er studierte, lebte er in München.',
      'Solange er studiert hatte, lebte er in München.',
      'Solange er studieren wird, lebte er in München.',
      'Solange er studiert, lebte er in München.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Solange\' drückt Gleichzeitigkeit aus: Beide Satzteile stehen in derselben Zeitform (hier: Präteritum + Präteritum).',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'solange', 'gleichzeitigkeit']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-042',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was drückt \'Die Sitzung wird wohl länger gedauert haben.\' aus?',
    'options': [
      'Die Sitzung dauert gerade lang.',
      'Man vermutet, dass die Sitzung lang gedauert hat.',
      'Die Sitzung wird in der Zukunft lang dauern.',
      'Die Sitzung hatte schon vor der Vergangenheit gedauert.'
    ],
    'correctAnswer': 1,
    'explanation': 'Futur II + \'wohl\': Vermutung über Vergangenes. Man vermutet, dass die Sitzung lang gedauert hat.',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'vermutung']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-043',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz zeigt die Verwendung des Plusquamperfekts in einer Rückblende?',
    'options': [
      'Er ging durch die Straßen. Hier hatte er als Kind gespielt.',
      'Er ging durch die Straßen. Hier spielte er als Kind.',
      'Er geht durch die Straßen. Hier hat er als Kind gespielt.',
      'Er wird durch die Straßen gehen. Hier wird er als Kind gespielt haben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Hatte gespielt\' ist eine Rückblende im Plusquamperfekt innerhalb einer Erzählung im Präteritum.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'rückblende']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-044',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Ergänze: \'Nachdem alle Plätze ___ worden waren, begann die Vorstellung.\'',
    'options': ['besetzen', 'besetzt', 'besetzten', 'besetze'],
    'correctAnswer': 1,
    'explanation': 'Plusquamperfekt Passiv: \'besetzt worden waren\'. \'Nachdem\' + Plusquamperfekt Passiv im Nebensatz.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'passiv']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-046',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welche Zeitenfolge ist bei \'bis\' + Nebensatz korrekt?',
    'options': [
      'Er wartete, bis der Bus kam.',
      'Er wartete, bis der Bus gekommen war.',
      'Er wartet, bis der Bus kam.',
      'Beide Varianten (a und b) sind möglich.'
    ],
    'correctAnswer': 3,
    'explanation': 'Bei \'bis\' kann der Nebensatz im Präteritum oder Plusquamperfekt stehen: \'bis der Bus kam\' (gleichzeitig) oder \'bis der Bus gekommen war\' (Betonung des Abschlusses).',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'bis', 'zeitenfolge']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-048',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Was ist ein typisches Signal für das Plusquamperfekt im Text?',
    'options': [
      'Zeitangaben mit \'morgen\'',
      'Wörter wie \'vorher\', \'zuvor\', \'bereits\', \'schon\'',
      'Das Wort \'wohl\'',
      'Zeitangaben mit \'jetzt\''
    ],
    'correctAnswer': 1,
    'explanation': 'Signalwörter wie \'vorher\', \'zuvor\', \'bereits\' und \'schon\' deuten oft auf das Plusquamperfekt hin, da sie Vorzeitigkeit signalisieren.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'signalwörter']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-049',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Welcher Satz verwendet das Futur II im Passiv korrekt?',
    'options': [
      'Die Arbeit wird erledigt worden sein.',
      'Die Arbeit wird erledigt werden sein.',
      'Die Arbeit wird erledigt sein worden.',
      'Die Arbeit wird erledigt haben worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur II Passiv: werden + Partizip II + worden + sein: \'Die Arbeit wird erledigt worden sein.\'',
    'subcategory': 'Futur II',
    'tags': ['zeitformen', 'futur-ii', 'passiv']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-050',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'Ergänze: \'Sobald der Vertrag ___ worden war, begannen die Bauarbeiten.\'',
    'options': ['unterschreiben', 'unterschrieben', 'unterschreibt', 'unterschrieb'],
    'correctAnswer': 1,
    'explanation': 'Plusquamperfekt Passiv: \'unterschrieben worden war\'. \'Sobald\' + Plusquamperfekt zeigt die Vorzeitigkeit.',
    'subcategory': 'Plusquamperfekt',
    'tags': ['zeitformen', 'plusquamperfekt', 'passiv']
  },
  {
    'language': 'german', 'id': 'b2-zeitformen-p2-004',
    'level': 'b2',
    'category': 'Zeitformen & Tempus',
    'question': 'In welcher Zeitform steht: \'Er hatte den Schlüssel verloren, bevor er nach Hause kam.\'?',
    'options': ['Perfekt + Präteritum', 'Plusquamperfekt + Präteritum', 'Präteritum + Präteritum', 'Futur II + Präteritum'],
    'correctAnswer': 1,
    'explanation': '\'Hatte verloren\' ist Plusquamperfekt, \'kam\' ist Präteritum. Die vorzeitige Handlung steht im Plusquamperfekt.',
    'subcategory': 'Zeitenfolge',
    'tags': ['zeitformen', 'plusquamperfekt', 'bevor']
  },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-051', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Was drückt \'Er wird den Brief wohl schon abgeschickt haben.\' aus?', 'options': ['Er schickt den Brief morgen ab.', 'Man vermutet, dass er den Brief schon abgeschickt hat.', 'Er hat definitiv abgeschickt.', 'Eine Aufforderung.'], 'correctAnswer': 1, 'explanation': 'Futur II + \'wohl\': Vermutung über Vergangenes.', 'subcategory': 'Futur II', 'tags': ['zeitformen', 'futur-ii', 'vermutung'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-053', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welcher Satz zeigt das Futur I als Absichtserklärung?', 'options': ['Er wird wohl krank sein.', 'Wir werden die Preise senken.', 'Das wirst du noch bereuen!', 'Er wird schon recht haben.'], 'correctAnswer': 1, 'explanation': '\'Wir werden die Preise senken.\' drückt eine feste Absicht oder Ankündigung aus.', 'subcategory': 'Futur I', 'tags': ['zeitformen', 'futur', 'absicht'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-054', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welche Zeitenfolge ist bei \'solange\' korrekt?', 'options': ['Solange er studiert, jobbt er nebenbei.', 'Solange er studiert hatte, jobbt er nebenbei.', 'Solange er studiert, jobbte er nebenbei.', 'Solange er studieren wird, jobbt er.'], 'correctAnswer': 0, 'explanation': '\'Solange\' drückt Gleichzeitigkeit aus: Beide Satzteile stehen in derselben Zeitform.', 'subcategory': 'Zeitenfolge', 'tags': ['zeitformen', 'solange', 'gleichzeitigkeit'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-055', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Was drückt \'Die Gäste werden wohl schon gegangen sein.\' aus?', 'options': ['Die Gäste gehen in der Zukunft.', 'Man vermutet, dass die Gäste schon gegangen sind.', 'Die Gäste sind definitiv gegangen.', 'Eine Aufforderung zu gehen.'], 'correctAnswer': 1, 'explanation': 'Futur II + \'wohl\': Vermutung über Vergangenes.', 'subcategory': 'Futur II', 'tags': ['zeitformen', 'futur-ii', 'vermutung'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-056', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Ergänze: \'Nachdem er den Schlüssel ___ hatte, konnte er die Tür öffnen.\'', 'options': ['finden', 'gefunden', 'fand', 'findend'], 'correctAnswer': 1, 'explanation': 'Plusquamperfekt: \'gefunden hatte\'. Das Finden fand VOR dem Öffnen statt.', 'subcategory': 'Plusquamperfekt', 'tags': ['zeitformen', 'plusquamperfekt', 'nachdem'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-057', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welcher Satz zeigt die Zeitenfolge mit \'ehe\' korrekt?', 'options': ['Ehe der Zug abfuhr, hatte er das Ticket gelöst.', 'Ehe der Zug abfährt, hatte er das Ticket gelöst.', 'Ehe der Zug abgefahren war, löste er das Ticket.', 'Ehe der Zug abfuhr, hat er das Ticket gelöst.'], 'correctAnswer': 0, 'explanation': '\'Ehe\' + Präteritum + Plusquamperfekt zeigt die korrekte Vorzeitigkeit.', 'subcategory': 'Zeitenfolge', 'tags': ['zeitformen', 'ehe', 'plusquamperfekt'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-058', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Was drückt \'Bis nächsten Freitag werden alle Berichte eingereicht worden sein.\' aus?', 'options': ['Vermutung über die Gegenwart', 'Abgeschlossene Handlung in der Zukunft (Passiv)', 'Vorvergangenheit', 'Aufforderung'], 'correctAnswer': 1, 'explanation': 'Futur II Passiv mit \'bis\': Die Einreichung wird zu diesem Zeitpunkt abgeschlossen sein.', 'subcategory': 'Futur II', 'tags': ['zeitformen', 'futur-ii', 'passiv'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-059', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welcher Satz verwendet \'seitdem\' mit Gegenwartsbezug?', 'options': ['Seitdem er die Stelle gewechselt hat, ist er zufriedener.', 'Seitdem er die Stelle wechselte, ist er zufriedener.', 'Seitdem er die Stelle gewechselt hatte, war er zufriedener.', 'Seitdem er die Stelle wechseln wird, ist er zufriedener.'], 'correctAnswer': 0, 'explanation': '\'Seitdem\' + Perfekt + Präsens: Der Wechsel als Startpunkt für den andauernden Zustand.', 'subcategory': 'Zeitenfolge', 'tags': ['zeitformen', 'seitdem', 'perfekt'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-060', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Ergänze: \'Kaum hatte sie die Tür ___, klingelte das Telefon.\'', 'options': ['geöffnet', 'öffnen', 'öffnete', 'öffnend'], 'correctAnswer': 0, 'explanation': '\'Kaum + Plusquamperfekt\': \'geöffnet\' + \'hatte\'. Unmittelbare Abfolge.', 'subcategory': 'Plusquamperfekt', 'tags': ['zeitformen', 'plusquamperfekt', 'kaum'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-061', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welches Modalwort signalisiert im Futur I eine Vermutung?', 'options': ['bitte', 'leider', 'wohl/wahrscheinlich/vielleicht', 'sofort'], 'correctAnswer': 2, 'explanation': 'Modalwörter wie \'wohl\', \'wahrscheinlich\' oder \'vielleicht\' signalisieren, dass das Futur I eine Vermutung ausdrückt.', 'subcategory': 'Futur I', 'tags': ['zeitformen', 'futur', 'vermutung'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-062', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Was drückt \'Er wird den Fehler wohl bemerkt haben.\' aus?', 'options': ['Er bemerkt den Fehler morgen.', 'Man vermutet, dass er den Fehler bemerkt hat.', 'Er hat definitiv den Fehler bemerkt.', 'Eine Warnung.'], 'correctAnswer': 1, 'explanation': 'Futur II + \'wohl\': Vermutung über Vergangenes.', 'subcategory': 'Futur II', 'tags': ['zeitformen', 'futur-ii', 'vermutung'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-063', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Ergänze: \'Nachdem die Rede ___ worden war, applaudierte das Publikum.\'', 'options': ['halten', 'gehalten', 'hielt', 'haltend'], 'correctAnswer': 1, 'explanation': 'Plusquamperfekt Passiv: \'gehalten worden war\'. Die Rede fand VOR dem Applaus statt.', 'subcategory': 'Plusquamperfekt', 'tags': ['zeitformen', 'plusquamperfekt', 'passiv'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-064', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welcher Satz zeigt die Verwendung des Perfekts mit \'noch nie\'?', 'options': ['Ich habe noch nie Sushi gegessen.', 'Ich aß noch nie Sushi.', 'Ich hatte noch nie Sushi gegessen.', 'Ich werde noch nie Sushi essen.'], 'correctAnswer': 0, 'explanation': 'Bei Erfahrungen mit \'noch nie\' bevorzugt man das Perfekt: \'Ich habe noch nie ... gegessen.\'', 'subcategory': 'Perfekt vs. Präteritum', 'tags': ['zeitformen', 'perfekt', 'erfahrung'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-066', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Ergänze: \'Sobald er sich ___ hatte, ging er schlafen.\'', 'options': ['umziehen', 'umgezogen', 'umzog', 'umziehend'], 'correctAnswer': 1, 'explanation': 'Plusquamperfekt: \'sich umgezogen hatte\'. \'Sobald\' + Plusquamperfekt zeigt Vorzeitigkeit.', 'subcategory': 'Plusquamperfekt', 'tags': ['zeitformen', 'plusquamperfekt', 'sobald'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-067', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Welcher Satz zeigt das Futur I als Aufforderung?', 'options': ['Er wird wohl schon unterwegs sein.', 'Du wirst jetzt deine Hausaufgaben machen!', 'Morgen wird es regnen.', 'Ich werde mich melden.'], 'correctAnswer': 1, 'explanation': '\'Du wirst jetzt deine Hausaufgaben machen!\' nutzt das Futur I als nachdrückliche Aufforderung.', 'subcategory': 'Futur I', 'tags': ['zeitformen', 'futur', 'aufforderung'] },
  { 'language': 'german', 'id': 'b2-zeitformen-p2-068', 'level': 'b2', 'category': 'Zeitformen & Tempus', 'question': 'Was drückt \'Die Verhandlungen werden wohl gescheitert sein.\' aus?', 'options': ['Die Verhandlungen scheitern morgen.', 'Man vermutet, dass die Verhandlungen gescheitert sind.', 'Die Verhandlungen sind definitiv gescheitert.', 'Eine Warnung.'], 'correctAnswer': 1, 'explanation': 'Futur II + \'wohl\': Vermutung über Vergangenes.', 'subcategory': 'Futur II', 'tags': ['zeitformen', 'futur-ii', 'vermutung'] }
];

export default questions;
