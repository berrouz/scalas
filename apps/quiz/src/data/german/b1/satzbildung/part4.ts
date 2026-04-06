import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-001',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie schreibt ihrer Freundin einen Brief.',
      'Sie schreibt ihre Freundin einen Brief.',
      'Sie schreibt ihrer Freundin einem Brief.',
      'Sie schreibt ihrem Freundin einen Brief.'
    ],
    'correctAnswer': 0,
    'explanation': '\'schreiben\' verlangt Dativ (ihrer Freundin) + Akkusativ (einen Brief).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-002',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Obwohl er müde war, ging er noch joggen.',
      'Obwohl er müde war, er ging noch joggen.',
      'Obwohl er war müde, ging er noch joggen.',
      'Obwohl er müde war ging er noch joggen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'obwohl\'-Nebensatz steht das Verb am Ende; Komma + Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-003',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hängt seinen Mantel an den Haken.',
      'Er hängt seinen Mantel an dem Haken.',
      'Er hängt seinen Mantel an der Haken.',
      'Er hängt sein Mantel an den Haken.'
    ],
    'correctAnswer': 0,
    'explanation': '\'hängen\' (transitiv) = Richtung (wohin?) -> Akkusativ: an den Haken.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-004',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wartet auf seinen Freund.',
      'Er wartet für seinen Freund.',
      'Er wartet über seinen Freund.',
      'Er wartet an seinen Freund.'
    ],
    'correctAnswer': 0,
    'explanation': '\'warten auf\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-005',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Hotel, in dem wir übernachtet haben, war teuer.',
      'Das Hotel, in den wir übernachtet haben, war teuer.',
      'Das Hotel, in das wir übernachtet haben, war teuer.',
      'Das Hotel, in der wir übernachtet haben, war teuer.'
    ],
    'correctAnswer': 0,
    'explanation': '\'übernachten in\' + Dativ (wo?); \'Hotel\' ist Neutrum -> in dem.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-006',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Am Morgen räumt sie immer die Küche auf.',
      'Am Morgen sie räumt immer die Küche auf.',
      'Am Morgen aufräumt sie immer die Küche.',
      'Am Morgen räumt sie die Küche immer auf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion nach Zeitangabe; trennbares Verb: Präfix \'auf\' am Ende.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-007',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Falls es morgen regnet, bleiben wir zu Hause.',
      'Falls es morgen regnet, wir bleiben zu Hause.',
      'Falls morgen es regnet, bleiben wir zu Hause.',
      'Falls es morgen regnet bleiben wir zu Hause.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'falls\'-Nebensatz steht das Verb am Ende; Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-008',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn ich mehr Geld hätte, würde ich verreisen.',
      'Wenn ich mehr Geld hätte, ich würde verreisen.',
      'Wenn ich mehr Geld habe, würde ich verreisen.',
      'Wenn ich mehr Geld hätte, würde ich zu verreisen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'hätte\' im Nebensatz, \'würde + Infinitiv\' im Hauptsatz mit Inversion.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-009',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er legte sich ins Bett.',
      'Er legte sich im Bett.',
      'Er legte sich in dem Bett.',
      'Er legte sich in des Bettes.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich legen ins\' (= in das) = Richtung (wohin?) -> Akkusativ.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-010',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich habe dem Nachbarn beim Umzug geholfen.',
      'Ich habe den Nachbarn beim Umzug geholfen.',
      'Ich habe dem Nachbarn bei dem Umzug geholfen.',
      'Ich habe dem Nachbar beim Umzug geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt Dativ (dem Nachbarn); \'beim\' = bei dem (Dativ).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-011',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er sorgt sich um seine Familie.',
      'Er sorgt sich für seine Familie.',
      'Er sorgt sich über seine Familie.',
      'Er sorgt sich an seine Familie.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich sorgen um\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-012',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Kollege, dem ich das Buch geliehen habe, hat es verloren.',
      'Der Kollege, den ich das Buch geliehen habe, hat es verloren.',
      'Der Kollege, der ich das Buch geliehen habe, hat es verloren.',
      'Der Kollege, dessen ich das Buch geliehen habe, hat es verloren.'
    ],
    'correctAnswer': 0,
    'explanation': '\'leihen\' verlangt Dativ; \'Kollege\' ist maskulin -> Relativpronomen: dem.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-013',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zuerst frühstückt er, dann geht er zur Arbeit.',
      'Zuerst frühstückt er, dann er geht zur Arbeit.',
      'Zuerst er frühstückt, dann geht er zur Arbeit.',
      'Zuerst frühstückt er, dann zur Arbeit geht er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion nach \'zuerst\' und nach \'dann\': Verb vor Subjekt.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-014',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie ist so freundlich, dass alle sie mögen.',
      'Sie ist so freundlich, dass alle mögen sie.',
      'Sie ist so freundlich, dass sie alle mögen.',
      'Sie ist so freundlich, dass mögen alle sie.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'dass\'-Nebensatz steht das Verb am Ende; Subjekt (alle) vor Objekt (sie).',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-015',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Auto steht vor dem Haus.',
      'Das Auto steht vor den Haus.',
      'Das Auto steht vor das Haus.',
      'Das Auto steht vor der Haus.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stehen vor\' = Ort (wo?) -> Dativ: vor dem Haus. \'Haus\' ist Neutrum.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-016',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sich um die Stelle beworben.',
      'Er hat sich für die Stelle beworben.',
      'Er hat sich über die Stelle beworben.',
      'Er hat sich an die Stelle beworben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich bewerben um\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-017',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hätte das nicht tun sollen.',
      'Er hätte das nicht tun gesollt.',
      'Er hätte das nicht sollen tun.',
      'Er hat das nicht tun sollen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II + Modalverb: \'hätte + Infinitiv + sollen\'.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-018',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie verbietet ihrem Sohn, spät aufzubleiben.',
      'Sie verbietet ihren Sohn, spät aufzubleiben.',
      'Sie verbietet ihrem Sohn, spät auf zu bleiben.',
      'Sie verbietet ihrem Sohn, spät aufbleiben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'verbieten\' + Dativ (ihrem Sohn); \'zu\' zwischen Präfix und Verb: aufzubleiben.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-019',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Studentin, für die ich das Buch gekauft habe, war begeistert.',
      'Die Studentin, für der ich das Buch gekauft habe, war begeistert.',
      'Die Studentin, für den ich das Buch gekauft habe, war begeistert.',
      'Die Studentin, für dem ich das Buch gekauft habe, war begeistert.'
    ],
    'correctAnswer': 0,
    'explanation': '\'für\' + Akkusativ; \'Studentin\' ist feminin -> für die.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-020',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Meistens kauft sie ihr Brot beim Bäcker.',
      'Meistens sie kauft ihr Brot beim Bäcker.',
      'Meistens kauft ihr Brot sie beim Bäcker.',
      'Meistens kauft sie beim Bäcker ihr Brot.'
    ],
    'correctAnswer': 0,
    'explanation': 'Inversion nach Adverb; Akkusativobjekt nach Subjekt, Lokalangabe am Ende.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-021',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er setzt sich auf den Stuhl.',
      'Er setzt sich auf dem Stuhl.',
      'Er setzt sich auf der Stuhl.',
      'Er setzt sich auf des Stuhles.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich setzen auf\' = Richtung (wohin?) -> Akkusativ: auf den Stuhl.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-022',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er beschäftigt sich mit diesem Thema.',
      'Er beschäftigt sich über dieses Thema.',
      'Er beschäftigt sich für dieses Thema.',
      'Er beschäftigt sich an diesem Thema.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich beschäftigen mit\' + Dativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-023',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Indem er viel liest, erweitert er seinen Wortschatz.',
      'Indem er viel liest, er erweitert seinen Wortschatz.',
      'Indem er liest viel, erweitert er seinen Wortschatz.',
      'Indem viel er liest, erweitert er seinen Wortschatz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'indem\'-Nebensatz steht das Verb am Ende; Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-024',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat einem alten Mann über die Straße geholfen.',
      'Er hat einen alten Mann über die Straße geholfen.',
      'Er hat einem alten Mann über der Straße geholfen.',
      'Er hat ein alten Mann über die Straße geholfen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'helfen\' verlangt Dativ (einem alten Mann); \'über die Straße\' = Richtung.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-025',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wäre ich nicht so beschäftigt, würde ich dir helfen.',
      'Wäre ich nicht so beschäftigt, ich würde dir helfen.',
      'Bin ich nicht so beschäftigt, würde ich dir helfen.',
      'Wäre ich nicht so beschäftigt, würde ich dich helfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II ohne \'wenn\': Verb am Anfang; Inversion im Hauptsatz. \'helfen\' + Dativ.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-026',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Der Junge, den ich kenne, spielt gut Klavier.',
      'Der Junge, der ich kenne, spielt gut Klavier.',
      'Der Junge, dem ich kenne, spielt gut Klavier.',
      'Der Junge, dessen ich kenne, spielt gut Klavier.'
    ],
    'correctAnswer': 0,
    'explanation': '\'kennen\' verlangt Akkusativ; \'Junge\' ist maskulin -> Relativpronomen: den.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-027',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Blumen stehen in der Vase auf dem Tisch.',
      'Die Blumen stehen in die Vase auf dem Tisch.',
      'Die Blumen stehen in dem Vase auf den Tisch.',
      'Die Blumen stehen in der Vase auf den Tisch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stehen in\' und \'auf\' = Ort (wo?) -> beide Dativ.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-028',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie freut sich über das Geschenk.',
      'Sie freut sich auf das Geschenk.',
      'Sie freut sich für das Geschenk.',
      'Sie freut sich an das Geschenk.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich freuen über\' = Freude über etwas Erhaltenes/Geschehenes (Akkusativ).',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-029',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Bis du zurückkommst, werde ich auf dich warten.',
      'Bis du zurückkommst, ich werde auf dich warten.',
      'Bis du kommst zurück, werde ich auf dich warten.',
      'Bis zurückkommst du, werde ich auf dich warten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'bis\'-Nebensatz steht das Verb am Ende; Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-030',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er brachte seiner Kollegin Blumen mit.',
      'Er brachte seine Kollegin Blumen mit.',
      'Er brachte seiner Kollegin Blumen.',
      'Er mitbrachte seiner Kollegin Blumen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'mitbringen\' verlangt Dativ (seiner Kollegin); trennbar: Präfix \'mit\' am Ende.',
    'subcategory': 'Konjugation',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-031',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat sich vorgenommen, mehr Sport zu treiben.',
      'Er hat sich vorgenommen, mehr Sport treiben.',
      'Er hat sich vorgenommen, zu mehr Sport treiben.',
      'Er hat vorgenommen sich, mehr Sport zu treiben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich vornehmen\' + Infinitivsatz mit \'zu\' vor dem Infinitiv.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-032',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er sitzt auf dem Stuhl und liest ein Buch.',
      'Er sitzt auf den Stuhl und liest ein Buch.',
      'Er sitzt auf der Stuhl und liest ein Buch.',
      'Er sitzt auf dem Stuhl und lest ein Buch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sitzen auf\' = Ort (wo?) -> Dativ. \'lesen\': er liest (Vokalwechsel).',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-033',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat seine Eltern um Erlaubnis gebeten.',
      'Er hat seinen Eltern um Erlaubnis gebeten.',
      'Er hat seine Eltern für Erlaubnis gebeten.',
      'Er hat seine Eltern um Erlaubnis gebitten.'
    ],
    'correctAnswer': 0,
    'explanation': '\'bitten\' verlangt Akkusativ (seine Eltern) + \'um\' + Akkusativ (Erlaubnis).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-034',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er verlässt sich darauf, dass sie pünktlich kommt.',
      'Er verlässt sich darauf, dass sie pünktlich kommen.',
      'Er verlässt sich darauf, dass pünktlich sie kommt.',
      'Er verlässt darauf sich, dass sie pünktlich kommt.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich verlassen darauf, dass\' — Verb (kommt) am Ende des Nebensatzes.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-035',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie gewöhnt sich an das neue Leben.',
      'Sie gewöhnt sich an dem neuen Leben.',
      'Sie gewöhnt sich über das neue Leben.',
      'Sie gewöhnt sich für das neue Leben.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich gewöhnen an\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-036',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er wünschte, er könnte besser Deutsch sprechen.',
      'Er wünschte, er kann besser Deutsch sprechen.',
      'Er wünscht, er könnte besser Deutsch sprechen.',
      'Er wünschte, er könnte besser Deutsch zu sprechen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II: \'wünschte\' + \'könnte\' (beide Konjunktiv II).',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-037',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Restaurant, das wir besucht haben, war ausgezeichnet.',
      'Das Restaurant, den wir besucht haben, war ausgezeichnet.',
      'Das Restaurant, der wir besucht haben, war ausgezeichnet.',
      'Das Restaurant, dem wir besucht haben, war ausgezeichnet.'
    ],
    'correctAnswer': 0,
    'explanation': '\'besuchen\' verlangt Akkusativ; \'Restaurant\' ist Neutrum -> Relativpronomen: das.',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-038',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er parkt das Auto hinter dem Haus.',
      'Er parkt das Auto hinter den Haus.',
      'Er parkt das Auto hinter das Haus.',
      'Er parkt das Auto hinter der Haus.'
    ],
    'correctAnswer': 0,
    'explanation': '\'parken hinter\' = Ort (wo?) -> Dativ: hinter dem Haus.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-039',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er hat ihr den Ring an den Finger gesteckt.',
      'Er hat ihr den Ring an dem Finger gesteckt.',
      'Er hat sie den Ring an den Finger gesteckt.',
      'Er hat ihr den Ring an der Finger gesteckt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dativ (ihr) + Akkusativ (den Ring); \'an den Finger\' = Richtung (wohin?).',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-040',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Trotzdem er krank war, ging er zur Arbeit.',
      'Obwohl er krank war, ging er trotzdem zur Arbeit.',
      'Trotzdem er war krank, ging er zur Arbeit.',
      'Er ging trotzdem zur Arbeit, obwohl war er krank.'
    ],
    'correctAnswer': 1,
    'explanation': '\'obwohl\' leitet den Nebensatz ein (Verb am Ende); \'trotzdem\' steht im Hauptsatz.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-041',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie hofft, bald eine neue Arbeit zu finden.',
      'Sie hofft, bald eine neue Arbeit finden.',
      'Sie hofft, zu bald eine neue Arbeit finden.',
      'Sie hofft, bald eine neue Arbeit finden zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitivsatz: \'zu\' steht direkt vor dem Infinitiv am Ende.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-042',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er ärgert sich über seinen Fehler.',
      'Er ärgert sich auf seinen Fehler.',
      'Er ärgert sich für seinen Fehler.',
      'Er ärgert sich an seinen Fehler.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich ärgern über\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-043',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wenn er Zeit gehabt hätte, hätte er uns besucht.',
      'Wenn er Zeit gehabt hätte, er hätte uns besucht.',
      'Wenn er Zeit hatte, hätte er uns besucht.',
      'Wenn er Zeit gehabt hätte, hätte er uns besuchen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit: \'hätte + Partizip II\' in beiden Teilen. Inversion im Hauptsatz.',
    'subcategory': 'Konjunktiv',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-044',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sein Mantel hängt am Haken.',
      'Sein Mantel hängt an den Haken.',
      'Sein Mantel hängt an der Haken.',
      'Sein Mantel hängt an des Hakens.'
    ],
    'correctAnswer': 0,
    'explanation': '\'hängen\' (intransitiv) = Ort (wo?) -> Dativ: am (= an dem) Haken.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-045',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Nachbarin, deren Hund immer bellt, ist verreist.',
      'Die Nachbarin, dessen Hund immer bellt, ist verreist.',
      'Die Nachbarin, derer Hund immer bellt, ist verreist.',
      'Die Nachbarin, die Hund immer bellt, ist verreist.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv feminin: deren (Besitz der Nachbarin).',
    'subcategory': 'Relativsätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-046',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er empfiehlt mir, diesen Film anzuschauen.',
      'Er empfiehlt mich, diesen Film anzuschauen.',
      'Er empfiehlt mir, diesen Film anschauen.',
      'Er empfiehlt mir, diesen Film zu anschauen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'empfehlen\' + Dativ (mir); \'zu\' zwischen Präfix und Verb: anzuschauen.',
    'subcategory': 'Kasus',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-047',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Kaum hatte er das Haus verlassen, begann es zu regnen.',
      'Kaum er hatte das Haus verlassen, begann es zu regnen.',
      'Kaum hatte er das Haus verlassen, es begann zu regnen.',
      'Kaum hatte das Haus er verlassen, begann es zu regnen.'
    ],
    'correctAnswer': 0,
    'explanation': '\'kaum\' + Inversion (Verb vor Subjekt); Inversion auch im Hauptsatz.',
    'subcategory': 'Wortstellung',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-048',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sie beschwert sich über den schlechten Service.',
      'Sie beschwert sich für den schlechten Service.',
      'Sie beschwert sich an den schlechten Service.',
      'Sie beschwert sich auf den schlechten Service.'
    ],
    'correctAnswer': 0,
    'explanation': '\'sich beschweren über\' + Akkusativ ist die korrekte feste Verbindung.',
    'subcategory': 'Präpositionen',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-049',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Solange du hier bist, musst du die Regeln befolgen.',
      'Solange du hier bist, du musst die Regeln befolgen.',
      'Solange du bist hier, musst du die Regeln befolgen.',
      'Solange hier du bist, musst du die Regeln befolgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im \'solange\'-Nebensatz steht das Verb am Ende; Inversion im Hauptsatz.',
    'subcategory': 'Nebensätze',
    'tags': ['satzbildung', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b1-satzbildung-p4-050',
    'level': 'b1',
    'category': 'Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Er stellt das Glas auf den Tisch.',
      'Er stellt das Glas auf dem Tisch.',
      'Er stellt das Glas auf der Tisch.',
      'Er stellt der Glas auf den Tisch.'
    ],
    'correctAnswer': 0,
    'explanation': '\'stellen auf\' = Richtung (wohin?) -> Akkusativ: auf den Tisch.',
    'subcategory': 'Wechselpräpositionen',
    'tags': ['satzbildung', 'grammatik']
  }
];

export default questions;
