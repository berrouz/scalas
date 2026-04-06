import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-001',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn sie mehr verdienen würde, könnte sie sich ein Auto leisten.',
      'Wenn sie mehr verdienen wird, könnte sie sich ein Auto leisten.',
      'Wenn sie mehr verdienen würde, kann sie sich ein Auto leisten.',
      'Wenn sie mehr verdient, könnte sie sich ein Auto leisten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: würde verdienen → könnte leisten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Paket wurde gestern zugestellt.',
      'Das Paket wurde gestern zustellen.',
      'Das Paket worden gestern zugestellt.',
      'Das Paket wurde gestern zugestellten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (zugestellt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Kollege, mit dem ich telefoniert habe, ist verreist.',
      'Der Kollege, mit den ich telefoniert habe, ist verreist.',
      'Der Kollege, mit der ich telefoniert habe, ist verreist.',
      'Der Kollege, mit dessen ich telefoniert habe, ist verreist.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mit" + Dativ maskulin: mit dem (dem Kollegen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hofft, bald eine neue Stelle zu finden.',
      'Er hofft, bald eine neue Stelle finden.',
      'Er hofft, bald eine neue Stelle gefunden zu.',
      'Er hofft, bald eine neue Stelle zu gefunden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Hoffen" + Infinitiv mit "zu": zu finden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Leider konnte ich an dem Treffen nicht teilnehmen.',
      'Leider ich konnte an dem Treffen nicht teilnehmen.',
      'Leider konnte an dem Treffen ich nicht teilnehmen.',
      'Leider nicht konnte ich an dem Treffen teilnehmen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Leider" an Position 1 erfordert Inversion: konnte ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gesetzt den Fall, er sagt die Wahrheit, müssen wir ihm glauben.',
      'Gesetzt den Fall, er sagt die Wahrheit, wir müssen ihm glauben.',
      'Gesetzt den Fall, sagt er die Wahrheit, müssen wir ihm glauben.',
      'Gesetzt den Fall, er die Wahrheit sagt, müssen wir ihm glauben.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gesetzt den Fall" + Hauptsatzstellung im Bedingungssatz.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er schämt sich seiner Taten.',
      'Er schämt sich seine Taten.',
      'Er schämt sich seinen Taten.',
      'Er schämt sich sein Taten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich schämen" + Genitiv: seiner Taten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die gut durchdachte Strategie führte zum Erfolg.',
      'Die gut durchdenkende Strategie führte zum Erfolg.',
      'Die gut durchdacht Strategie führte zum Erfolg.',
      'Die gut durchgedachte Strategie führte zum Erfolg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: durchdachte (die durchdachte Strategie).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut Bericht hätten die Verhandlungen gute Fortschritte gemacht.',
      'Laut Bericht haben die Verhandlungen gute Fortschritte gemacht.',
      'Laut Bericht hatten die Verhandlungen gute Fortschritte gemacht.',
      'Laut Bericht hätte die Verhandlungen gute Fortschritte gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede mit Konjunktiv II (Ersatz, da Konj. I = Indikativ): hätten gemacht.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ergebnisse werden nächste Woche veröffentlicht.',
      'Die Ergebnisse werden nächste Woche veröffentlichen.',
      'Die Ergebnisse wird nächste Woche veröffentlicht.',
      'Die Ergebnisse werden nächste Woche veröffentlichet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv Plural: werden + Partizip II (veröffentlicht).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Patienten, denen das Medikament verschrieben wurde, fühlten sich besser.',
      'Die Patienten, die das Medikament verschrieben wurde, fühlten sich besser.',
      'Die Patienten, den das Medikament verschrieben wurde, fühlten sich besser.',
      'Die Patienten, deren das Medikament verschrieben wurde, fühlten sich besser.'
    ],
    'correctAnswer': 0,
    'explanation': '"Verschreiben" + Dativ Plural: denen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat angefangen, Japanisch zu lernen.',
      'Er hat angefangen, Japanisch lernen.',
      'Er hat angefangen, Japanisch zu gelernt.',
      'Er hat angefangen, Japanisch lernen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anfangen" + Infinitiv mit "zu": zu lernen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Tatsächlich hatte er den Termin vergessen.',
      'Tatsächlich er hatte den Termin vergessen.',
      'Tatsächlich hatte den Termin er vergessen.',
      'Tatsächlich vergessen hatte er den Termin.'
    ],
    'correctAnswer': 0,
    'explanation': '"Tatsächlich" an Position 1 erfordert Inversion: hatte er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selbst wenn er sich entschuldigt, vergebe ich ihm nicht.',
      'Selbst wenn er sich entschuldigt, ich vergebe ihm nicht.',
      'Selbst wenn entschuldigt er sich, vergebe ich ihm nicht.',
      'Selbst wenn er entschuldigt sich, vergebe ich ihm nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Selbst wenn" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vonseiten des Managements gab es keine Reaktion.',
      'Vonseiten dem Management gab es keine Reaktion.',
      'Vonseiten die Management gab es keine Reaktion.',
      'Vonseiten den Management gab es keine Reaktion.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vonseiten" verlangt den Genitiv: vonseiten des Managements.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vereinfacht ausgedrückt bedeutet das Folgendes.',
      'Vereinfacht ausdrückend bedeutet das Folgendes.',
      'Vereinfacht ausdrücken bedeutet das Folgendes.',
      'Vereinfachend ausgedrückt bedeutet das Folgendes.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: vereinfacht ausgedrückt (zwei Partizipien II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, Sie hätten die Wahl, was würden Sie wählen?',
      'Angenommen, Sie haben die Wahl, was würden Sie wählen?',
      'Angenommen, Sie hätten die Wahl, was wählen Sie?',
      'Angenommen, Sie hatten die Wahl, was würden Sie wählen?'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: hätten (Konjunktiv II) + würden wählen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vertrag hätte längst unterschrieben werden sollen.',
      'Der Vertrag hätte längst unterschrieben werden gesollt.',
      'Der Vertrag hätte längst unterschrieben geworden sollen.',
      'Der Vertrag hätte längst unterschreiben werden sollen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Passiv + Modalverb: hätte + Partizip II + werden + Infinitiv Modalverb.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Moment, an den ich mich am liebsten erinnere, war der Sonnenuntergang.',
      'Der Moment, an dem ich mich am liebsten erinnere, war der Sonnenuntergang.',
      'Der Moment, an der ich mich am liebsten erinnere, war der Sonnenuntergang.',
      'Der Moment, an dessen ich mich am liebsten erinnere, war der Sonnenuntergang.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich erinnern an" + Akkusativ maskulin: an den (den Moment).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat es abgelehnt, an dem Projekt teilzunehmen.',
      'Sie hat es abgelehnt, an dem Projekt teilnehmen.',
      'Sie hat es abgelehnt, an dem Projekt zu teilnehmen.',
      'Sie hat es abgelehnt, an dem Projekt teilgenommen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": teilzunehmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vor allem muss die Qualität stimmen.',
      'Vor allem die Qualität muss stimmen.',
      'Vor allem muss stimmen die Qualität.',
      'Vor allem stimmen muss die Qualität.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vor allem" an Position 1 erfordert Inversion: muss die Qualität.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht zuletzt, weil er fleißig war, hat er Erfolg gehabt.',
      'Nicht zuletzt, weil er fleißig war, er hat Erfolg gehabt.',
      'Nicht zuletzt, weil war er fleißig, hat er Erfolg gehabt.',
      'Nicht zuletzt, weil er war fleißig, hat er Erfolg gehabt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Weil" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zwecks besserer Verständigung wurde ein Dolmetscher engagiert.',
      'Zwecks bessere Verständigung wurde ein Dolmetscher engagiert.',
      'Zwecks besseren Verständigung wurde ein Dolmetscher engagiert.',
      'Zwecks besserem Verständigung wurde ein Dolmetscher engagiert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zwecks" verlangt den Genitiv: zwecks besserer Verständigung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Allgemein gesprochen ist die Lage stabil.',
      'Allgemein sprechend ist die Lage stabil.',
      'Allgemein gesprochen die Lage ist stabil.',
      'Allgemein gesprochend ist die Lage stabil.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: allgemein gesprochen (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sprach, als wisse er alles besser.',
      'Er sprach, als weiß er alles besser.',
      'Er sprach, als er alles besser wisse.',
      'Er sprach, als wusste er alles besser.'
    ],
    'correctAnswer': 0,
    'explanation': '"Als" (vergleichend) + Konjunktiv I mit Inversion: als wisse er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ware kann umgetauscht werden.',
      'Die Ware kann umgetauscht wird.',
      'Die Ware kann umtauschen werden.',
      'Die Ware kann umgetauscht geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: kann + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Konferenz, an der wir teilgenommen haben, war sehr informativ.',
      'Die Konferenz, an die wir teilgenommen haben, war sehr informativ.',
      'Die Konferenz, an den wir teilgenommen haben, war sehr informativ.',
      'Die Konferenz, an dem wir teilgenommen haben, war sehr informativ.'
    ],
    'correctAnswer': 0,
    'explanation': '"Teilnehmen an" + Dativ feminin: an der (der Konferenz).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es nicht gewagt, ihr zu widersprechen.',
      'Er hat es nicht gewagt, ihr widersprechen.',
      'Er hat es nicht gewagt, ihr zu widersprochen.',
      'Er hat es nicht gewagt, ihr widersprechen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wagen" + Infinitiv mit "zu": zu widersprechen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Offensichtlich hat er die Nachricht nicht erhalten.',
      'Offensichtlich er hat die Nachricht nicht erhalten.',
      'Offensichtlich hat die Nachricht er nicht erhalten.',
      'Offensichtlich nicht hat er die Nachricht erhalten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Offensichtlich" an Position 1 erfordert Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie er sagte, habe er den Bericht noch nicht gelesen.',
      'Wie er sagte, hat er den Bericht noch nicht gelesen.',
      'Wie sagte er, habe er den Bericht noch nicht gelesen.',
      'Wie er sagte, habe den Bericht er noch nicht gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wie er sagte" als Einschub + indirekte Rede: Konjunktiv I: habe gelesen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Entlang des Flusses gibt es einen schönen Wanderweg.',
      'Entlang dem Fluss gibt es einen schönen Wanderweg.',
      'Entlang den Fluss gibt es einen schönen Wanderweg.',
      'Sowohl A als auch B sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': '"Entlang" kann mit Genitiv (entlang des Flusses) oder Dativ (entlang dem Fluss) stehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die kaum zu bewältigende Aufgabe nahm viel Zeit in Anspruch.',
      'Die kaum zu bewältigte Aufgabe nahm viel Zeit in Anspruch.',
      'Die kaum bewältigende Aufgabe nahm viel Zeit in Anspruch.',
      'Die kaum zu bewältigen Aufgabe nahm viel Zeit in Anspruch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu + Partizip I + Endung: die zu bewältigende Aufgabe.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptete, er habe nichts damit zu tun.',
      'Er behauptete, er hat nichts damit zu tun.',
      'Er behauptete, er hatte nichts damit zu tun.',
      'Er behauptete, er hätte nichts damit zu tun.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I: er habe.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Maschine wird regelmäßig gewartet.',
      'Die Maschine wird regelmäßig warten.',
      'Die Maschine werden regelmäßig gewartet.',
      'Die Maschine wird regelmäßig gewartet werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II (gewartet). Option D wäre Futur I Passiv.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat beschlossen, sich selbstständig zu machen.',
      'Sie hat beschlossen, sich selbstständig machen.',
      'Sie hat beschlossen, sich selbstständig zu gemacht.',
      'Sie hat beschlossen, sich selbstständig machen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Beschließen" + Infinitiv mit "zu": zu machen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wahrscheinlich hat er den Zug verpasst.',
      'Wahrscheinlich er hat den Zug verpasst.',
      'Wahrscheinlich hat den Zug er verpasst.',
      'Wahrscheinlich verpasst hat er den Zug.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wahrscheinlich" an Position 1 erfordert Inversion: hat er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei denn, das Wetter bessert sich, fällt das Fest aus.',
      'Es sei denn, das Wetter bessert sich, das Fest fällt aus.',
      'Es sei denn, bessert sich das Wetter, fällt das Fest aus.',
      'Es sei denn, das Wetter sich bessert, fällt das Fest aus.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es sei denn" + Hauptsatzstellung im Bedingungssatz. Zweiter Satz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bar jeder Vernunft handelte er gegen alle Ratschläge.',
      'Bar jede Vernunft handelte er gegen alle Ratschläge.',
      'Bar jedem Vernunft handelte er gegen alle Ratschläge.',
      'Bar jedes Vernunft handelte er gegen alle Ratschläge.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bar" (gehobene Sprache) + Genitiv: bar jeder Vernunft.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Genau genommen stimmt das nicht ganz.',
      'Genau nehmend stimmt das nicht ganz.',
      'Genau genommt stimmt das nicht ganz.',
      'Genau zu nehmen stimmt das nicht ganz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: genau genommen (Partizip II von "nehmen").',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wäre ich doch nur zu Hause geblieben!',
      'Bin ich doch nur zu Hause geblieben!',
      'War ich doch nur zu Hause geblieben!',
      'Sei ich doch nur zu Hause geblieben!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunschsatz Vergangenheit: Wäre + doch nur + Partizip II.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ihm ist gestern gekündigt worden.',
      'Er ist gestern gekündigt worden.',
      'Ihm hat gestern gekündigt worden.',
      'Ihm ist gestern kündigen worden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kündigen" + Dativ → Passiv: Ihm ist gekündigt worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Park, durch den wir gelaufen sind, war wunderschön.',
      'Der Park, durch dem wir gelaufen sind, war wunderschön.',
      'Der Park, durch der wir gelaufen sind, war wunderschön.',
      'Der Park, durch dessen wir gelaufen sind, war wunderschön.'
    ],
    'correctAnswer': 0,
    'explanation': '"Durch" + Akkusativ maskulin: durch den (den Park).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat es vermieden, ihn direkt anzusprechen.',
      'Sie hat es vermieden, ihn direkt ansprechen.',
      'Sie hat es vermieden, ihn direkt zu ansprechen.',
      'Sie hat es vermieden, ihn direkt angesprochen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": anzusprechen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Darüber hinaus bieten wir kostenlose Beratung an.',
      'Darüber hinaus wir bieten kostenlose Beratung an.',
      'Darüber hinaus bieten kostenlose Beratung wir an.',
      'Darüber hinaus an bieten wir kostenlose Beratung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Darüber hinaus" an Position 1 erfordert Inversion: bieten wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So klug er auch sein mag, Fehler macht jeder.',
      'So klug er auch sein mag, jeder Fehler macht.',
      'So klug auch mag er sein, Fehler macht jeder.',
      'So klug er sein auch mag, Fehler macht jeder.'
    ],
    'correctAnswer': 0,
    'explanation': '"So ... auch" als konzessiver Nebensatz. Der Hauptsatz folgt mit normaler Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ausweislich der Akten war er nicht anwesend.',
      'Ausweislich die Akten war er nicht anwesend.',
      'Ausweislich den Akten war er nicht anwesend.',
      'Ausweislich dem Akten war er nicht anwesend.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ausweislich" (Amtssprache) + Genitiv: ausweislich der Akten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Im Großen und Ganzen betrachtet ist das Ergebnis zufriedenstellend.',
      'Im Großen und Ganzen betrachtend ist das Ergebnis zufriedenstellend.',
      'Im Großen und Ganzen betrachten ist das Ergebnis zufriedenstellend.',
      'Im Großen und Ganzen betrachtete ist das Ergebnis zufriedenstellend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung: betrachtet.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie wäre es, wenn wir eine Pause machten?',
      'Wie wäre es, wenn wir eine Pause machen?',
      'Wie ist es, wenn wir eine Pause machten?',
      'Wie wäre es, wenn wir eine Pause gemacht?'
    ],
    'correctAnswer': 0,
    'explanation': 'Höflicher Vorschlag: wäre + wenn + Konjunktiv II: machten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Fenster ist geöffnet.',
      'Das Fenster wird geöffnet.',
      'Das Fenster ist geöffnet worden.',
      'Alle drei Sätze sind korrekt, aber haben unterschiedliche Bedeutungen.'
    ],
    'correctAnswer': 3,
    'explanation': 'A = Zustandspassiv, B = Vorgangspassiv Präsens, C = Perfekt Passiv. Alle sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p9-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es nicht übers Herz gebracht, ihr die Wahrheit zu sagen.',
      'Er hat es nicht übers Herz gebracht, ihr die Wahrheit sagen.',
      'Er hat es nicht übers Herz gebracht, ihr die Wahrheit zu gesagt.',
      'Er hat es nicht übers Herz gebracht, ihr die Wahrheit sagen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es übers Herz bringen" + Infinitiv mit "zu": zu sagen.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
