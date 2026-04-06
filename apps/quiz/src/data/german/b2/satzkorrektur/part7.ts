import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn er das gewusst hätte, wäre er nicht mitgekommen.',
      'Wenn er das gewusst hat, wäre er nicht mitgekommen.',
      'Wenn er das gewusst hätte, ist er nicht mitgekommen.',
      'Wenn er das wusste, wäre er nicht mitgekommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Vergangenheitssatz: hätte gewusst → wäre nicht mitgekommen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die neue Regel wird ab sofort angewendet.',
      'Die neue Regel wird ab sofort anwenden.',
      'Die neue Regel werden ab sofort angewendet.',
      'Die neue Regel wird ab sofort angewendeten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II (angewendet).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Freundin, an die ich oft denke, lebt in Paris.',
      'Die Freundin, an der ich oft denke, lebt in Paris.',
      'Die Freundin, an dem ich oft denke, lebt in Paris.',
      'Die Freundin, an den ich oft denke, lebt in Paris.'
    ],
    'correctAnswer': 0,
    'explanation': '"Denken an" + Akkusativ feminin: an die (die Freundin).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wir haben das Meeting verschieben müssen.',
      'Wir haben das Meeting verschoben müssen.',
      'Wir haben das Meeting verschieben gemusst.',
      'Wir haben das Meeting zu verschieben müssen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt mit Modalverb: haben + Infinitiv + Ersatzinfinitiv (müssen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zugegebenermaßen habe ich einen Fehler gemacht.',
      'Zugegebenermaßen ich habe einen Fehler gemacht.',
      'Zugegebenermaßen habe einen Fehler ich gemacht.',
      'Zugegebenermaßen einen Fehler habe ich gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Adverb an Position 1 erfordert Inversion: habe ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Da er krank war, konnte er nicht teilnehmen.',
      'Da er krank war, er konnte nicht teilnehmen.',
      'Da war er krank, konnte er nicht teilnehmen.',
      'Da er war krank, konnte er nicht teilnehmen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Da" (kausal) leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er bediente sich eines Tricks.',
      'Er bediente sich einen Trick.',
      'Er bediente sich einem Trick.',
      'Er bediente sich ein Trick.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich bedienen" + Genitiv: eines Tricks.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die weit verbreitete Meinung ist falsch.',
      'Die weit verbreitende Meinung ist falsch.',
      'Die weit verbreitet Meinung ist falsch.',
      'Die weit verbreiteter Meinung ist falsch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: verbreitete (die verbreitete Meinung).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Zeuge sagte aus, er habe den Täter gesehen.',
      'Der Zeuge sagte aus, er hat den Täter gesehen.',
      'Der Zeuge sagte aus, er hatte den Täter gesehen.',
      'Der Zeuge sagte aus, er hätte den Täter gesehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Perfekt: habe gesehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Waren müssen vor Nässe geschützt werden.',
      'Die Waren müssen vor Nässe geschützt wird.',
      'Die Waren müssen vor Nässe schützen werden.',
      'Die Waren müssen vor Nässe geschützt geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: müssen + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Idee, von der alle begeistert waren, wurde umgesetzt.',
      'Die Idee, von die alle begeistert waren, wurde umgesetzt.',
      'Die Idee, von dem alle begeistert waren, wurde umgesetzt.',
      'Die Idee, von den alle begeistert waren, wurde umgesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Von" + Dativ feminin: von der (die Idee → von der).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich geweigert mitzumachen.',
      'Er hat sich geweigert mitmachen.',
      'Er hat sich geweigert zu mitmachen.',
      'Er hat sich geweigert mitgemacht zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": mitzumachen. Bei "sich weigern" oft ohne Komma.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vermutlich wird er morgen nicht kommen.',
      'Vermutlich er wird morgen nicht kommen.',
      'Vermutlich wird morgen nicht kommen er.',
      'Vermutlich morgen wird er nicht kommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vermutlich" an Position 1 erfordert Inversion: wird er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obgleich er sich angestrengt hat, hat er das Ziel nicht erreicht.',
      'Obgleich er sich angestrengt hat, er hat das Ziel nicht erreicht.',
      'Obgleich hat er sich angestrengt, hat er das Ziel nicht erreicht.',
      'Obgleich er sich hat angestrengt, hat er das Ziel nicht erreicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Obgleich" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abseits des Weges fanden sie eine versteckte Höhle.',
      'Abseits dem Weg fanden sie eine versteckte Höhle.',
      'Abseits den Weg fanden sie eine versteckte Höhle.',
      'Abseits der Weg fanden sie eine versteckte Höhle.'
    ],
    'correctAnswer': 0,
    'explanation': '"Abseits" verlangt den Genitiv: abseits des Weges.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Müde geworden, beschloss er, ins Bett zu gehen.',
      'Müde werdend, beschloss er, ins Bett zu gehen.',
      'Müde gewordt, beschloss er, ins Bett zu gehen.',
      'Müde werden, beschloss er, ins Bett zu gehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung: müde geworden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dürfte ich Sie um einen Gefallen bitten?',
      'Darf ich Sie um einen Gefallen bitten?',
      'Durfte ich Sie um einen Gefallen bitten?',
      'Dürfe ich Sie um einen Gefallen bitten?'
    ],
    'correctAnswer': 0,
    'explanation': 'Höfliche Bitte: Konjunktiv II von "dürfen": Dürfte ich ...',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Straße wird wegen Bauarbeiten gesperrt werden.',
      'Die Straße wird wegen Bauarbeiten sperren werden.',
      'Die Straße wird wegen Bauarbeiten gesperrt worden.',
      'Die Straße wird wegen Bauarbeiten gesperrt wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Futur I Passiv: wird + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Nachricht, die mich überraschte, kam heute Morgen.',
      'Die Nachricht, der mich überraschte, kam heute Morgen.',
      'Die Nachricht, den mich überraschte, kam heute Morgen.',
      'Die Nachricht, dem mich überraschte, kam heute Morgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Nominativ feminin: die (die Nachricht überraschte mich).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie behauptet, nichts davon gehört zu haben.',
      'Sie behauptet, nichts davon gehört haben.',
      'Sie behauptet, nichts davon zu gehört haben.',
      'Sie behauptet, nichts davon gehört zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitiv Perfekt: Partizip II + zu haben: gehört zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf dass alles gut werde!',
      'Auf dass alles gut wird!',
      'Auf dass werde alles gut!',
      'Auf dass alles werde gut!'
    ],
    'correctAnswer': 0,
    'explanation': '"Auf dass" + Konjunktiv I (werde) in gehobener Sprache. Verb am Ende.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unweit des Bahnhofs gibt es ein gutes Restaurant.',
      'Unweit dem Bahnhof gibt es ein gutes Restaurant.',
      'Unweit den Bahnhof gibt es ein gutes Restaurant.',
      'Unweit der Bahnhof gibt es ein gutes Restaurant.'
    ],
    'correctAnswer': 0,
    'explanation': '"Unweit" verlangt den Genitiv: unweit des Bahnhofs.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die noch ausstehenden Rechnungen müssen sofort beglichen werden.',
      'Die noch ausgestanden Rechnungen müssen sofort beglichen werden.',
      'Die noch ausstehend Rechnungen müssen sofort beglichen werden.',
      'Die noch ausstehendes Rechnungen müssen sofort beglichen werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I Plural als Adjektiv: ausstehenden (die ausstehenden Rechnungen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wäre nett, wenn Sie mir die Unterlagen schicken würden.',
      'Es wäre nett, wenn Sie mir die Unterlagen schicken werden.',
      'Es ist nett, wenn Sie mir die Unterlagen schicken würden.',
      'Es wäre nett, wenn Sie mir die Unterlagen schicken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Höfliche Bitte: wäre + wenn + Konjunktiv II: würden schicken.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Miete muss pünktlich überwiesen werden.',
      'Die Miete muss pünktlich überwiesen wird.',
      'Die Miete muss pünktlich überweisen werden.',
      'Die Miete muss pünktlich überwiesen geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: muss + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Geschäft, in dem ich einkaufe, hat montags geschlossen.',
      'Das Geschäft, in den ich einkaufe, hat montags geschlossen.',
      'Das Geschäft, in das ich einkaufe, hat montags geschlossen.',
      'Das Geschäft, in der ich einkaufe, hat montags geschlossen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wo? → Dativ neutrum: in dem (in dem Geschäft).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich vorgenommen abzunehmen.',
      'Er hat sich vorgenommen abnehmen.',
      'Er hat sich vorgenommen zu abnehmen.',
      'Er hat sich vorgenommen abgenommen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": abzunehmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Soweit ich weiß, ist er verreist.',
      'Soweit ich weiß, er ist verreist.',
      'Soweit weiß ich, ist er verreist.',
      'Soweit ich weiß, verreist ist er.'
    ],
    'correctAnswer': 0,
    'explanation': '"Soweit ich weiß" als Nebensatz. Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mal abgesehen davon, dass er zu spät kam, war er auch unvorbereitet.',
      'Mal abgesehen davon, dass er zu spät kam, er war auch unvorbereitet.',
      'Mal abgesehen davon, dass kam er zu spät, war er auch unvorbereitet.',
      'Mal abgesehen davon, dass er kam zu spät, war er auch unvorbereitet.'
    ],
    'correctAnswer': 0,
    'explanation': '"Abgesehen davon, dass" + Nebensatz (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man verdächtigt ihn des Betrugs.',
      'Man verdächtigt ihm des Betrugs.',
      'Man verdächtigt ihn den Betrug.',
      'Man verdächtigt ihn dem Betrug.'
    ],
    'correctAnswer': 0,
    'explanation': '"Verdächtigen" + Akkusativ (Person) + Genitiv (Sache): ihn des Betrugs.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zugegeben, die Aufgabe war nicht einfach.',
      'Zugebend, die Aufgabe war nicht einfach.',
      'Zugegebt, die Aufgabe war nicht einfach.',
      'Zu geben, die Aufgabe war nicht einfach.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: zugegeben (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man nehme 200 Gramm Mehl und zwei Eier.',
      'Man nimmt 200 Gramm Mehl und zwei Eier.',
      'Man nähme 200 Gramm Mehl und zwei Eier.',
      'Man nehmen 200 Gramm Mehl und zwei Eier.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in Rezepten/Anleitungen: Man nehme (gehobener Stil).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Medikament darf nur nach ärztlicher Verordnung eingenommen werden.',
      'Das Medikament darf nur nach ärztlicher Verordnung eingenommen wird.',
      'Das Medikament darf nur nach ärztlicher Verordnung einnehmen werden.',
      'Das Medikament darf nur nach ärztlicher Verordnung eingenommen geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: darf + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat versucht, ihn umzustimmen.',
      'Sie hat versucht, ihn umstimmen.',
      'Sie hat versucht, ihn zu umstimmen.',
      'Sie hat versucht, ihn umgestimmt zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": umzustimmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bedauerlicherweise müssen wir Ihnen mitteilen, dass ...',
      'Bedauerlicherweise wir müssen Ihnen mitteilen, dass ...',
      'Bedauerlicherweise müssen Ihnen wir mitteilen, dass ...',
      'Bedauerlicherweise mitteilen müssen wir Ihnen, dass ...'
    ],
    'correctAnswer': 0,
    'explanation': 'Adverb an Position 1 erfordert Inversion: müssen wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Soweit ich informiert bin, findet die Konferenz statt.',
      'Soweit ich informiert bin, die Konferenz findet statt.',
      'Soweit informiert bin ich, findet die Konferenz statt.',
      'Soweit ich bin informiert, findet die Konferenz statt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Soweit" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anhand der vorliegenden Daten können wir Folgendes feststellen.',
      'Anhand die vorliegenden Daten können wir Folgendes feststellen.',
      'Anhand den vorliegenden Daten können wir Folgendes feststellen.',
      'Anhand dem vorliegenden Daten können wir Folgendes feststellen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anhand" verlangt den Genitiv: anhand der vorliegenden Daten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sachlich betrachtet hat er nicht unrecht.',
      'Sachlich betrachtend hat er nicht unrecht.',
      'Sachlich betrachten hat er nicht unrecht.',
      'Sachlich betrachtete hat er nicht unrecht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: sachlich betrachtet (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Fast wäre er gestolpert.',
      'Fast ist er gestolpert.',
      'Fast wäre er stolpern.',
      'Fast würde er gestolpert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Fast" + Konjunktiv II Vergangenheit: wäre gestolpert (etwas, das beinahe passiert wäre).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kosten werden vom Arbeitgeber übernommen.',
      'Die Kosten werden vom Arbeitgeber übernehmen.',
      'Die Kosten wird vom Arbeitgeber übernommen.',
      'Die Kosten werden von Arbeitgeber übernommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv Plural: werden + Partizip II. "Vom" = von dem (Dativ).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vorschlag, dem alle zugestimmt haben, wird umgesetzt.',
      'Der Vorschlag, den alle zugestimmt haben, wird umgesetzt.',
      'Der Vorschlag, der alle zugestimmt haben, wird umgesetzt.',
      'Der Vorschlag, dessen alle zugestimmt haben, wird umgesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zustimmen" + Dativ maskulin: dem (dem Vorschlag zustimmen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem ist nicht zu unterschätzen.',
      'Das Problem ist nicht zu unterschätzt.',
      'Das Problem ist nicht unterschätzen.',
      'Das Problem ist nicht unterschätzt zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sein" + "zu" + Infinitiv: ist nicht zu unterschätzen (passive Bedeutung).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Selbstverständlich helfe ich Ihnen gern.',
      'Selbstverständlich ich helfe Ihnen gern.',
      'Selbstverständlich helfe Ihnen gern ich.',
      'Selbstverständlich gern helfe ich Ihnen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Selbstverständlich" an Position 1 erfordert Inversion: helfe ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wo immer er hingeht, findet er Freunde.',
      'Wo immer er hingeht, er findet Freunde.',
      'Wo immer hingeht er, findet er Freunde.',
      'Wo immer er geht hin, findet er Freunde.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wo immer" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zulasten des Verursachers gehen die Reparaturkosten.',
      'Zulasten dem Verursacher gehen die Reparaturkosten.',
      'Zulasten den Verursacher gehen die Reparaturkosten.',
      'Zulasten der Verursacher gehen die Reparaturkosten.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zulasten" verlangt den Genitiv: zulasten des Verursachers.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet aller Warnungen fortfahrend, machte er weiter.',
      'Ungeachtet aller Warnungen gefahren, machte er weiter.',
      'Ungeachtet aller Warnungen fahren, machte er weiter.',
      'Ungeachtet aller Warnungen gefahrend, machte er weiter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als adverbiale Bestimmung (gleichzeitig): fortfahrend.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es lebe die Freiheit!',
      'Es lebt die Freiheit!',
      'Es lebte die Freiheit!',
      'Es leben die Freiheit!'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als Wunsch/Ausruf: Es lebe die Freiheit!',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p7-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Termin wurde kurzfristig abgesagt.',
      'Der Termin wurde kurzfristig absagen.',
      'Der Termin worden kurzfristig abgesagt.',
      'Der Termin wurde kurzfristig abgesagen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (abgesagt).',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
