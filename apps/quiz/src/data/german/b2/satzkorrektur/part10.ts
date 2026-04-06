import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-001',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Perfekt: haben + Partizip II',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich habe gestern ein Buch gelest.',
      'Ich habe ein Buch gestern gelest.',
      'Ich gestern habe ein Buch gelesen.',
      'Ich habe gestern ein Buch gelesen.'
    ],
    'correctAnswer': 3,
    'explanation': 'Partizip II von "lesen" ist "gelesen", Verb auf Position 2.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich Präsident wäre, würde ich die Steuern senken.',
      'Wenn ich Präsident bin, würde ich die Steuern senken.',
      'Wenn ich Präsident wäre, senke ich die Steuern.',
      'Wenn ich Präsident sei, würde ich die Steuern senken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: wäre + würde senken.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Gebäude wurde im 18. Jahrhundert errichtet.',
      'Das Gebäude wurde im 18. Jahrhundert errichten.',
      'Das Gebäude worden im 18. Jahrhundert errichtet.',
      'Das Gebäude wurde im 18. Jahrhundert errichteten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (errichtet).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Kind, dessen Eltern verreist sind, wohnt bei den Großeltern.',
      'Das Kind, deren Eltern verreist sind, wohnt bei den Großeltern.',
      'Das Kind, dem Eltern verreist sind, wohnt bei den Großeltern.',
      'Das Kind, wessen Eltern verreist sind, wohnt bei den Großeltern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv neutrum: dessen (das Kind → dessen Eltern).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat mich sehen kommen.',
      'Er hat mich kommen sehen.',
      'Er hat mich kommen gesehen.',
      'Er hat mich gekommen sehen.'
    ],
    'correctAnswer': 1,
    'explanation': '"Sehen" im Perfekt mit Ersatzinfinitiv: hat kommen sehen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter anderem wurde auch das Thema Klimawandel besprochen.',
      'Unter anderem auch wurde das Thema Klimawandel besprochen.',
      'Unter anderem wurde das Thema Klimawandel auch besprochen.',
      'Sowohl A als auch C sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Die Stellung von "auch" ist im Mittelfeld flexibel. Beide Varianten sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So lange wie ich hier arbeite, hat es so etwas nicht gegeben.',
      'So lange wie ich hier arbeite, es hat so etwas nicht gegeben.',
      'So lange wie hier ich arbeite, hat es so etwas nicht gegeben.',
      'So lange wie ich arbeite hier, hat es so etwas nicht gegeben.'
    ],
    'correctAnswer': 0,
    'explanation': '"So lange wie" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie ist sich des Risikos bewusst.',
      'Sie ist sich das Risiko bewusst.',
      'Sie ist sich dem Risiko bewusst.',
      'Sie ist sich den Risikos bewusst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich bewusst sein" + Genitiv: des Risikos.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die vom Sturm beschädigten Häuser wurden repariert.',
      'Die vom Sturm beschädigende Häuser wurden repariert.',
      'Die vom Sturm beschädigt Häuser wurden repariert.',
      'Die vom Sturm beschädigte Häuser wurden repariert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II Plural als Adjektiv: beschädigten (die beschädigten Häuser).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Minister erklärte, er werde zurücktreten.',
      'Der Minister erklärte, er wird zurücktreten.',
      'Der Minister erklärte, er wurde zurücktreten.',
      'Der Minister erklärte, er würde zurücktreten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Futur: er werde zurücktreten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Fehler hätten längst korrigiert werden müssen.',
      'Die Fehler hätten längst korrigiert werden gemusst.',
      'Die Fehler hätten längst korrigiert geworden müssen.',
      'Die Fehler hätten längst korrigieren werden müssen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Passiv + Modalverb: hätten + Partizip II + werden + Infinitiv Modalverb.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Veranstaltung, zu der alle eingeladen waren, war ein Erfolg.',
      'Die Veranstaltung, zu die alle eingeladen waren, war ein Erfolg.',
      'Die Veranstaltung, zu dem alle eingeladen waren, war ein Erfolg.',
      'Die Veranstaltung, zu den alle eingeladen waren, war ein Erfolg.'
    ],
    'correctAnswer': 0,
    'explanation': '"Zu" + Dativ feminin: zu der (der Veranstaltung).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat darauf bestanden, den Vertrag zu prüfen.',
      'Er hat darauf bestanden, den Vertrag prüfen.',
      'Er hat darauf bestanden, den Vertrag geprüft zu.',
      'Er hat darauf bestanden, den Vertrag zu geprüft.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bestehen auf" + Infinitiv mit "zu": zu prüfen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aus diesem Grund haben wir uns für diese Lösung entschieden.',
      'Aus diesem Grund wir haben uns für diese Lösung entschieden.',
      'Aus diesem Grund haben für diese Lösung wir uns entschieden.',
      'Aus diesem Grund entschieden haben wir uns für diese Lösung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Aus diesem Grund" an Position 1 erfordert Inversion: haben wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mag er auch noch so reich sein, glücklich ist er nicht.',
      'Mag er auch noch so reich sein, er ist nicht glücklich.',
      'Mag auch er noch so reich sein, glücklich ist er nicht.',
      'Mag er auch noch so sein reich, glücklich ist er nicht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mag ... auch noch so" als konzessiver Ausdruck. Hauptsatz kann mit Inversion folgen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Halber des Vergnügens machte er sich auf den Weg.',
      'Um des Vergnügens willen machte er sich auf den Weg.',
      'Wegen dem Vergnügen machte er sich auf den Weg.',
      'Für des Vergnügens machte er sich auf den Weg.'
    ],
    'correctAnswer': 1,
    'explanation': '"Um ... willen" + Genitiv: um des Vergnügens willen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die den Erwartungen entsprechenden Ergebnisse wurden begrüßt.',
      'Die den Erwartungen entsprechene Ergebnisse wurden begrüßt.',
      'Die den Erwartungen entsprechend Ergebnisse wurden begrüßt.',
      'Die den Erwartungen entsprochen Ergebnisse wurden begrüßt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I Plural als Adjektiv: entsprechenden (die entsprechenden Ergebnisse).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wenn ich nur besser aufgepasst hätte!',
      'Wenn ich nur besser aufgepasst habe!',
      'Wenn ich nur besser aufgepasst hatte!',
      'Wenn ich nur besser aufpassen hätte!'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Wunschsatz Vergangenheit: hätte + Partizip II: aufgepasst hätte.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Rätsel konnte von niemandem gelöst werden.',
      'Das Rätsel konnte von niemandem gelöst wird.',
      'Das Rätsel konnte von niemandem lösen werden.',
      'Das Rätsel konnte von niemand gelöst geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb Präteritum + Passiv: konnte + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Professorin, deren Vorlesungen sehr beliebt sind, geht in Rente.',
      'Die Professorin, dessen Vorlesungen sehr beliebt sind, geht in Rente.',
      'Die Professorin, derer Vorlesungen sehr beliebt sind, geht in Rente.',
      'Die Professorin, die Vorlesungen sehr beliebt sind, geht in Rente.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv feminin: deren (die Professorin → deren Vorlesungen).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat es geschafft, den Marathon durchzuhalten.',
      'Er hat es geschafft, den Marathon durchhalten.',
      'Er hat es geschafft, den Marathon zu durchhalten.',
      'Er hat es geschafft, den Marathon durchgehalten zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": durchzuhalten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet dessen, dass er gewarnt wurde, machte er weiter.',
      'Ungeachtet dessen, dass er gewarnt wurde, er machte weiter.',
      'Ungeachtet dessen, dass gewarnt er wurde, machte er weiter.',
      'Ungeachtet dessen, dass er wurde gewarnt, machte er weiter.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ungeachtet dessen, dass" + Nebensatz (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mittels einer neuen Methode wurde das Problem gelöst.',
      'Mittels eine neue Methode wurde das Problem gelöst.',
      'Mittels einem neuen Methode wurde das Problem gelöst.',
      'Mittels einen neuen Methode wurde das Problem gelöst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mittels" verlangt den Genitiv: mittels einer neuen Methode.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einmal abgesehen davon, ist der Plan gut.',
      'Einmal absehend davon, ist der Plan gut.',
      'Einmal abgeseht davon, ist der Plan gut.',
      'Einmal zu absehen davon, ist der Plan gut.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: einmal abgesehen davon (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gab an, er sei zur Tatzeit nicht am Tatort gewesen.',
      'Er gab an, er ist zur Tatzeit nicht am Tatort gewesen.',
      'Er gab an, er war zur Tatzeit nicht am Tatort gewesen.',
      'Er gab an, er wäre zur Tatzeit nicht am Tatort gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede: Konjunktiv I Perfekt: sei gewesen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mir wurde geraten, einen Anwalt zu konsultieren.',
      'Ich wurde geraten, einen Anwalt zu konsultieren.',
      'Mir wurde geraten, einen Anwalt konsultieren.',
      'Mir worden geraten, einen Anwalt zu konsultieren.'
    ],
    'correctAnswer': 0,
    'explanation': '"Raten" + Dativ → Passiv: Mir wurde geraten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Frage, auf die er keine Antwort wusste, war schwierig.',
      'Die Frage, auf der er keine Antwort wusste, war schwierig.',
      'Die Frage, auf dem er keine Antwort wusste, war schwierig.',
      'Die Frage, auf den er keine Antwort wusste, war schwierig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Auf" + Akkusativ feminin: auf die (die Frage).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich geweigert, Stellung dazu zu nehmen.',
      'Sie hat sich geweigert, Stellung dazu nehmen.',
      'Sie hat sich geweigert, Stellung dazu zu genommen.',
      'Sie hat sich geweigert, Stellung dazu nehmen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich weigern" + Infinitiv mit "zu": zu nehmen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstatt dass er sich beschwert, sollte er handeln.',
      'Anstatt dass er sich beschwert, er sollte handeln.',
      'Anstatt dass beschwert er sich, sollte er handeln.',
      'Anstatt dass er beschwert sich, sollte er handeln.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anstatt dass" + Nebensatz (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wurde des Landes verwiesen.',
      'Er wurde das Land verwiesen.',
      'Er wurde dem Land verwiesen.',
      'Er wurde den Landes verwiesen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Des Landes verweisen" (Genitiv): Er wurde des Landes verwiesen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So gesehen hat er nicht unrecht.',
      'So sehend hat er nicht unrecht.',
      'So geseht hat er nicht unrecht.',
      'So zu sehen hat er nicht unrecht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: so gesehen (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man müsste eigentlich mehr Sport treiben.',
      'Man muss eigentlich mehr Sport treiben.',
      'Man musste eigentlich mehr Sport treiben.',
      'Man müssen eigentlich mehr Sport treiben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II für vorsichtige Aussage: müsste.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Waren sind fristgerecht geliefert worden.',
      'Die Waren sind fristgerecht geliefert geworden.',
      'Die Waren haben fristgerecht geliefert worden.',
      'Die Waren sind fristgerecht liefern worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt Passiv: sind + Partizip II + worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bleibt abzuwarten, wie sich die Lage entwickelt.',
      'Es bleibt abwarten, wie sich die Lage entwickelt.',
      'Es bleibt zu abwarten, wie sich die Lage entwickelt.',
      'Es bleibt abgewartet zu, wie sich die Lage entwickelt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bleiben" + "zu" + Infinitiv: bleibt abzuwarten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Folglich muss eine neue Strategie entwickelt werden.',
      'Folglich eine neue Strategie muss entwickelt werden.',
      'Folglich muss entwickelt werden eine neue Strategie.',
      'Folglich entwickelt muss eine neue Strategie werden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Folglich" an Position 1 erfordert Inversion: muss eine neue Strategie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Dadurch, dass er fleißig trainierte, gewann er den Wettkampf.',
      'Dadurch, dass er fleißig trainierte, er gewann den Wettkampf.',
      'Dadurch, dass trainierte er fleißig, gewann er den Wettkampf.',
      'Dadurch, dass er fleißig trainierte, den Wettkampf gewann er.'
    ],
    'correctAnswer': 0,
    'explanation': '"Dadurch, dass" + Nebensatz (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Abzüglich der Steuern bleibt nicht viel übrig.',
      'Abzüglich die Steuern bleibt nicht viel übrig.',
      'Abzüglich den Steuern bleibt nicht viel übrig.',
      'Abzüglich dem Steuern bleibt nicht viel übrig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Abzüglich" verlangt den Genitiv: abzüglich der Steuern.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nebenbei bemerkt, finde ich den Vorschlag interessant.',
      'Nebenbei bemerkend, finde ich den Vorschlag interessant.',
      'Nebenbei bemerken, finde ich den Vorschlag interessant.',
      'Nebenbei bemerktet, finde ich den Vorschlag interessant.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: nebenbei bemerkt (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, er käme morgen, was würden wir tun?',
      'Angenommen, er kommt morgen, was würden wir tun?',
      'Angenommen, er käme morgen, was tun wir?',
      'Angenommen, er kam morgen, was würden wir tun?'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz: käme (Konjunktiv II) + würden tun.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das darf nicht unterschätzt werden.',
      'Das darf nicht unterschätzt wird.',
      'Das darf nicht unterschätzen werden.',
      'Das darf nicht unterschätzt geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: darf + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Politiker, über den viel berichtet wird, hielt eine Rede.',
      'Der Politiker, über dem viel berichtet wird, hielt eine Rede.',
      'Der Politiker, über der viel berichtet wird, hielt eine Rede.',
      'Der Politiker, über dessen viel berichtet wird, hielt eine Rede.'
    ],
    'correctAnswer': 0,
    'explanation': '"Über" + Akkusativ maskulin: über den (über den Politiker berichten).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat vergessen, die Rechnung zu bezahlen.',
      'Er hat vergessen, die Rechnung bezahlen.',
      'Er hat vergessen, die Rechnung zu bezahlt.',
      'Er hat vergessen, die Rechnung bezahlen zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vergessen" + Infinitiv mit "zu": zu bezahlen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nicht einmal er wusste die Antwort.',
      'Nicht einmal wusste er die Antwort.',
      'Nicht einmal die Antwort er wusste.',
      'Nicht einmal er die Antwort wusste.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nicht einmal er" als Subjekt an Position 1, dann Verb: wusste.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Egal, was passiert, wir halten zusammen.',
      'Egal, was passiert, zusammen halten wir.',
      'Egal, was passiert, wir zusammen halten.',
      'Egal, passiert was, wir halten zusammen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Egal, was ..." als eingeschobener Ausdruck. Hauptsatz behält normale Wortstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Namens des Vorstands spreche ich Ihnen meinen Dank aus.',
      'Namens dem Vorstand spreche ich Ihnen meinen Dank aus.',
      'Namens den Vorstand spreche ich Ihnen meinen Dank aus.',
      'Namens der Vorstand spreche ich Ihnen meinen Dank aus.'
    ],
    'correctAnswer': 0,
    'explanation': '"Namens" (im Namen) + Genitiv: namens des Vorstands.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vorausgesetzt, die Finanzierung steht, starten wir im Mai.',
      'Voraussetzend, die Finanzierung steht, starten wir im Mai.',
      'Vorausgesetzen, die Finanzierung steht, starten wir im Mai.',
      'Vorauszusetzen, die Finanzierung steht, starten wir im Mai.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: vorausgesetzt (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sollte es Probleme geben, wenden Sie sich bitte an mich.',
      'Sollte es Probleme geben, Sie wenden sich bitte an mich.',
      'Sollte Probleme es geben, wenden Sie sich bitte an mich.',
      'Sollte es Probleme geben, bitte an mich wenden Sie sich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sollte" + Infinitiv am Ende (irreale Bedingung). Hauptsatz: Imperativ.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p10-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Projekt wird als erfolgreich angesehen.',
      'Das Projekt wird als erfolgreich ansehen.',
      'Das Projekt werden als erfolgreich angesehen.',
      'Das Projekt wird als erfolgreich angesehenen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + als ... + Partizip II (angesehen).',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
