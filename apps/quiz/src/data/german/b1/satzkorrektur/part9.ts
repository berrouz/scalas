import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-001',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Antrag muss bis Freitag eingereicht werden.',
      'Der Antrag muss bis Freitag eingereicht wird.',
      'Der Antrag muss bis Freitag einreichen werden.',
      'Der Antrag muss bis Freitag werden eingereicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv mit Modalverb: muss + Partizip II + werden (Infinitiv am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-002',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Chef bietet seinen Angestellten mehr Urlaub an.',
      'Der Chef bietet seine Angestellte mehr Urlaub an.',
      'Der Chef bietet seinen Angestellten mehr Urlaub.',
      'Der Chef bietet seine Angestellten mehr Urlaub an.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Anbieten\' + Dativ (Person) + Akkusativ (Sache): seinen Angestellten (Dativ Plural) mehr Urlaub.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-003',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allerdings muss man auch die Nachteile berücksichtigen.',
      'Allerdings man muss auch die Nachteile berücksichtigen.',
      'Allerdings muss auch die Nachteile man berücksichtigen.',
      'Allerdings berücksichtigen muss man auch die Nachteile.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'allerdings\' am Satzanfang: Verb auf Position 2 mit Inversion: muss man.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-004',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich ein hübsches Kleid für die Party ausgesucht.',
      'Sie hat sich einen hübschen Kleid für die Party ausgesucht.',
      'Sie hat sich einer hübschen Kleid für die Party ausgesucht.',
      'Sie hat sich ein hübscher Kleid für die Party ausgesucht.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kleid\' ist Neutrum. Akkusativ: ein hübsches Kleid.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-005',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie kämpft für die Rechte der Frauen.',
      'Sie kämpft über die Rechte der Frauen.',
      'Sie kämpft an die Rechte der Frauen.',
      'Sie kämpft auf die Rechte der Frauen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Kämpfen für\' + Akkusativ ist die korrekte Verbindung (einsetzen für).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-006',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nachdem die Sonne untergegangen war, wurde es kalt.',
      'Nachdem die Sonne untergegangen war, es wurde kalt.',
      'Nachdem war die Sonne untergegangen, wurde es kalt.',
      'Nachdem die Sonne war untergegangen, wurde es kalt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'nachdem\' steht das Hilfsverb am Ende: untergegangen war. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-007',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich über die schlechte Qualität beschwert.',
      'Er hat sich über die schlechter Qualität beschwert.',
      'Er hat sich über der schlechten Qualität beschwert.',
      'Er hat sich über die schlechten Qualität beschwert.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Über\' + Akkusativ. \'Qualität\' ist feminin: die schlechte Qualität.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-008',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hätte er besser aufgepasst, wäre der Unfall nicht passiert.',
      'Hat er besser aufgepasst, wäre der Unfall nicht passiert.',
      'Hätte er besser aufgepasst, ist der Unfall nicht passiert.',
      'Hätte er besser aufgepasst, war der Unfall nicht passiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Plusquamperfekt: hätte aufgepasst + wäre passiert. Für irreale Vergangenheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-009',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es geschafft, den Marathon zu laufen.',
      'Er hat es geschafft, den Marathon laufen.',
      'Er hat es geschafft, den Marathon zu gelaufen.',
      'Er hat es geschafft, den Marathon laufen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'schaffen\' folgt ein Infinitivsatz mit \'zu\': zu laufen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-010',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er teilt seiner Freundin die Neuigkeit mit.',
      'Er teilt seine Freundin die Neuigkeit mit.',
      'Er teilt seiner Freundin der Neuigkeit mit.',
      'Er teilt sein Freundin die Neuigkeit mit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mitteilen\' + Dativ (Person) + Akkusativ (Sache): seiner Freundin (Dativ) die Neuigkeit (Akkusativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-011',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Inzwischen hat sich die Lage deutlich verbessert.',
      'Inzwischen sich hat die Lage deutlich verbessert.',
      'Inzwischen hat die Lage sich deutlich verbessert.',
      'Inzwischen die Lage hat sich deutlich verbessert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'inzwischen\' am Satzanfang: Verb auf Position 2 mit Inversion: hat sich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-012',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat seiner Tochter das neue Spielzeug geschenkt.',
      'Er hat seine Tochter das neue Spielzeug geschenkt.',
      'Er hat seiner Tochter den neuen Spielzeug geschenkt.',
      'Er hat seinem Tochter das neue Spielzeug geschenkt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Schenken\' + Dativ (Person): seiner Tochter. \'Spielzeug\' ist Neutrum: das neue Spielzeug.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-013',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie freut sich über das Geschenk.',
      'Sie freut sich auf das Geschenk.',
      'Sie freut sich für das Geschenk.',
      'Sie freut sich an dem Geschenk.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich freuen über\' + Akkusativ bedeutet Freude über etwas Gegenwärtiges/Vergangenes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-014',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl er viel gelernt hat, hat er die Prüfung nicht bestanden.',
      'Obwohl er viel gelernt hat, er hat die Prüfung nicht bestanden.',
      'Obwohl er hat viel gelernt, hat er die Prüfung nicht bestanden.',
      'Obwohl er viel gelernt hat, nicht bestanden hat er die Prüfung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'obwohl\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-015',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dieser kleine Fehler hat große Folgen gehabt.',
      'Dieser kleiner Fehler hat große Folgen gehabt.',
      'Diesen kleinen Fehler hat große Folgen gehabt.',
      'Diesem kleinen Fehler hat große Folgen gehabt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominativ maskulin: dieser kleine Fehler. Nach \'dieser\' folgt schwache Deklination: kleine.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-016',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptete, er habe den Brief nicht bekommen.',
      'Er behauptete, er hat den Brief nicht bekommen.',
      'Er behauptete, er hatte den Brief nicht bekommen.',
      'Er behauptete, er haben den Brief nicht bekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede im Konjunktiv I Perfekt: habe ... bekommen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-017',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Auto ist in der Werkstatt repariert worden.',
      'Das Auto ist in der Werkstatt repariert geworden.',
      'Das Auto hat in der Werkstatt repariert worden.',
      'Das Auto ist in der Werkstatt repariert werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Perfekt: ist + Partizip II + worden (nicht \'geworden\').',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-018',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er steht seinem Bruder in nichts nach.',
      'Er steht seinen Bruder in nichts nach.',
      'Er steht sein Bruder in nichts nach.',
      'Er steht seines Bruders in nichts nach.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Nachstehen\' verlangt den Dativ: seinem Bruder.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-019',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat auf meine Frage geantwortet.',
      'Sie hat über meine Frage geantwortet.',
      'Sie hat für meine Frage geantwortet.',
      'Sie hat an meine Frage geantwortet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Antworten auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-020',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Schließlich haben wir eine Lösung gefunden.',
      'Schließlich wir haben eine Lösung gefunden.',
      'Schließlich haben eine Lösung wir gefunden.',
      'Schließlich gefunden haben wir eine Lösung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'schließlich\' am Satzanfang: Verb auf Position 2 mit Inversion: haben wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-021',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Buch, das auf dem Tisch liegt, gehört mir.',
      'Das Buch, der auf dem Tisch liegt, gehört mir.',
      'Das Buch, die auf dem Tisch liegt, gehört mir.',
      'Das Buch, den auf dem Tisch liegt, gehört mir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Nominativ Neutrum: das. Es bezieht sich auf \'das Buch\'.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-022',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Damit die Kinder nicht frieren, hat sie ihnen warme Jacken angezogen.',
      'Damit die Kinder nicht frieren, sie hat ihnen warme Jacken angezogen.',
      'Damit die Kinder frieren nicht, hat sie ihnen warme Jacken angezogen.',
      'Damit nicht frieren die Kinder, hat sie ihnen warme Jacken angezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'damit\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-023',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Heißer Tee tut bei Erkältung gut.',
      'Heißen Tee tut bei Erkältung gut.',
      'Heißem Tee tut bei Erkältung gut.',
      'Heißes Tee tut bei Erkältung gut.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Tee\' ist maskulin. Nominativ ohne Artikel (starke Deklination): heißer Tee.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-024',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nächste Woche wird der neue Laden eröffnet.',
      'Nächste Woche wurde der neue Laden eröffnet.',
      'Nächste Woche ist der neue Laden eröffnet worden.',
      'Nächste Woche würde der neue Laden eröffnet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiv Präsens für geplante Zukunft: wird eröffnet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-025',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat aufgehört zu rauchen.',
      'Sie hat aufgehört rauchen.',
      'Sie hat aufgehört zu geraucht.',
      'Sie hat aufgehört rauchen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'aufhören\' folgt ein Infinitivsatz mit \'zu\': zu rauchen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-026',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat dem Touristen den Weg erklärt.',
      'Er hat den Touristen den Weg erklärt.',
      'Er hat der Tourist den Weg erklärt.',
      'Er hat dem Tourist den Weg erklärt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Erklären\' + Dativ (Person). \'Tourist\' ist N-Deklination: dem Touristen (Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-027',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er bewirbt sich um ein Stipendium.',
      'Er bewirbt sich für ein Stipendium.',
      'Er bewirbt sich auf ein Stipendium.',
      'Er bewirbt sich über ein Stipendium.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Sich bewerben um\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-028',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Immerhin hat er sich entschuldigt.',
      'Immerhin er hat sich entschuldigt.',
      'Immerhin hat sich er entschuldigt.',
      'Immerhin entschuldigt hat er sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'immerhin\' am Satzanfang: Verb auf Position 2 mit Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-029',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Lehrer, den alle mögen, geht bald in Rente.',
      'Der Lehrer, der alle mögen, geht bald in Rente.',
      'Der Lehrer, dem alle mögen, geht bald in Rente.',
      'Der Lehrer, dessen alle mögen, geht bald in Rente.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Akkusativ maskulin: den. \'Mögen\' verlangt den Akkusativ.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-030',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Falls es morgen regnet, bleiben wir zu Hause.',
      'Falls es morgen regnet, wir bleiben zu Hause.',
      'Falls regnet es morgen, bleiben wir zu Hause.',
      'Falls es morgen regnet, zu Hause bleiben wir.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'falls\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-031',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er kauft sich jeden Monat ein neues Buch.',
      'Er kauft sich jeden Monat ein neuer Buch.',
      'Er kauft sich jeder Monat ein neues Buch.',
      'Er kauft sich jeden Monat einen neuen Buch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Buch\' ist Neutrum. Akkusativ: ein neues Buch. Akkusativ der Zeit: jeden Monat.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-032',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich du wäre, würde ich zum Arzt gehen.',
      'Wenn ich du bin, würde ich zum Arzt gehen.',
      'Wenn ich du wäre, werde ich zum Arzt gehen.',
      'Wenn ich du wäre, gehe ich zum Arzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II für irreale Bedingungen: wäre + würde gehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-033',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sie dazu ermutigt, an dem Kurs teilzunehmen.',
      'Er hat sie dazu ermutigt, an dem Kurs zu teilnehmen.',
      'Er hat sie dazu ermutigt, an dem Kurs teilnehmen.',
      'Er hat sie dazu ermutigt, an dem Kurs teilgenommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: teilzunehmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-034',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Firma dankt allen treuen Kunden für ihre Geduld.',
      'Die Firma dankt alle treue Kunden für ihre Geduld.',
      'Die Firma dankt allen treuen Kunden für ihrer Geduld.',
      'Die Firma dankt allen treuer Kunden für ihre Geduld.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Danken\' + Dativ: allen treuen Kunden (Dativ Plural). \'Für\' + Akkusativ: ihre Geduld.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-035',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist von seiner Unschuld überzeugt.',
      'Er ist über seine Unschuld überzeugt.',
      'Er ist für seine Unschuld überzeugt.',
      'Er ist an seiner Unschuld überzeugt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Überzeugt von\' + Dativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-036',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Daraufhin hat er seine Meinung geändert.',
      'Daraufhin er hat seine Meinung geändert.',
      'Daraufhin hat seine Meinung er geändert.',
      'Daraufhin geändert hat er seine Meinung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'daraufhin\' am Satzanfang: Verb auf Position 2 mit Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-037',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er zieht in die große Stadt am Fluss.',
      'Er zieht in der großen Stadt am Fluss.',
      'Er zieht in den großen Stadt am Fluss.',
      'Er zieht in das große Stadt am Fluss.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Stadt\' ist feminin. \'In\' + Akkusativ (Wohin?): in die große Stadt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-038',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Solange du in meinem Haus wohnst, musst du dich an die Regeln halten.',
      'Solange du in meinem Haus wohnst, du musst dich an die Regeln halten.',
      'Solange du wohnst in meinem Haus, musst du dich an die Regeln halten.',
      'Solange in meinem Haus du wohnst, musst du dich an die Regeln halten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'solange\' steht das Verb am Ende. Im Hauptsatz folgt Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-039',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe mir einen warmen Mantel gekauft.',
      'Ich habe mir ein warmer Mantel gekauft.',
      'Ich habe mir einen warmer Mantel gekauft.',
      'Ich habe mir einem warmen Mantel gekauft.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mantel\' ist maskulin. Akkusativ mit unbestimmtem Artikel: einen warmen Mantel.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-040',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sagte, er werde nächste Woche verreisen.',
      'Er sagte, er wird nächste Woche verreisen.',
      'Er sagte, er werden nächste Woche verreisen.',
      'Er sagte, er werde nächste Woche verreist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede im Konjunktiv I Futur: werde verreisen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-041',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich entschlossen, das Angebot anzunehmen.',
      'Er hat sich entschlossen, das Angebot zu annehmen.',
      'Er hat sich entschlossen, das Angebot annehmen.',
      'Er hat sich entschlossen, das Angebot angenommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Bei trennbaren Verben steht \'zu\' zwischen Präfix und Verb: anzunehmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-042',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mangels besserer Alternativen nahm er das Angebot an.',
      'Mangels bessere Alternativen nahm er das Angebot an.',
      'Mangels besseren Alternativen nahm er das Angebot an.',
      'Mangels besserem Alternativen nahm er das Angebot an.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mangels\' verlangt den Genitiv: mangels besserer Alternativen (Genitiv Plural).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-043',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er legt großen Wert auf Pünktlichkeit.',
      'Er legt großen Wert für Pünktlichkeit.',
      'Er legt großen Wert über Pünktlichkeit.',
      'Er legt großen Wert an Pünktlichkeit.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Wert legen auf\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-044',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Grundsätzlich bin ich mit dem Vorschlag einverstanden.',
      'Grundsätzlich ich bin mit dem Vorschlag einverstanden.',
      'Grundsätzlich bin mit dem Vorschlag ich einverstanden.',
      'Grundsätzlich einverstanden bin ich mit dem Vorschlag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach \'grundsätzlich\' am Satzanfang: Verb auf Position 2 mit Inversion: bin ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-045',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Artikel',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Schülerin, der er die Aufgabe erklärt hat, versteht es jetzt.',
      'Die Schülerin, die er die Aufgabe erklärt hat, versteht es jetzt.',
      'Die Schülerin, den er die Aufgabe erklärt hat, versteht es jetzt.',
      'Die Schülerin, dem er die Aufgabe erklärt hat, versteht es jetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Dativ feminin: der. \'Erklären\' verlangt den Dativ (Person).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-046',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bevor die Gäste kamen, hatte sie alles vorbereitet.',
      'Bevor die Gäste kamen, sie hatte alles vorbereitet.',
      'Bevor kamen die Gäste, hatte sie alles vorbereitet.',
      'Bevor die Gäste kamen, alles hatte sie vorbereitet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit \'bevor\' steht das Verb am Ende. Plusquamperfekt im Hauptsatz für Vorzeitigkeit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-047',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Deklination',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mit freundlichen Grüßen verabschiede ich mich.',
      'Mit freundlicher Grüße verabschiede ich mich.',
      'Mit freundliche Grüße verabschiede ich mich.',
      'Mit freundlichem Grüßen verabschiede ich mich.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Mit\' + Dativ Plural ohne Artikel (starke Deklination): freundlichen Grüßen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-048',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Tempus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie wird uns sicherlich vermissen.',
      'Sie wird uns sicherlich vermisst.',
      'Sie wurde uns sicherlich vermissen.',
      'Sie werde uns sicherlich vermissen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I: wird + Infinitiv (vermissen). \'Sicherlich\' drückt Vermutung aus.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-049',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es ist wichtig, die Anweisungen genau zu befolgen.',
      'Es ist wichtig, die Anweisungen genau befolgen.',
      'Es ist wichtig, die Anweisungen genau zu befolgt.',
      'Es ist wichtig, die Anweisungen genau befolgen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Es ist wichtig + Infinitivsatz mit \'zu\': zu befolgen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzkorrektur-p9-050',
    'level': 'b1',
    'category': 'Satzkorrektur',
    'subcategory': 'Präpositionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich bin dankbar für deine Unterstützung.',
      'Ich bin dankbar über deine Unterstützung.',
      'Ich bin dankbar an deine Unterstützung.',
      'Ich bin dankbar auf deine Unterstützung.'
    ],
    'correctAnswer': 0,
    'explanation': '\'Dankbar für\' + Akkusativ ist die korrekte Verbindung.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
