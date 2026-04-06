import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-003',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Das Kind spielt Fußball im Park.',
      'Das Kind spielt im Park Fußball.',
      'Das Kind Fußball spielt im Park.',
      'Im Park das Kind Fußball spielt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Subjekt + Verb + Lokalangabe + Akkusativobjekt.',
    'exampleSentence': 'Das Kind spielt im Park Fußball.',
    'grammarRule': 'SVO + Lokalangabe',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-004',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ich vorbereite mich auf die Prüfung.',
      'Mich bereite ich auf die Prüfung vor.',
      'Ich bereite auf die Prüfung mich vor.',
      'Ich bereite mich auf die Prüfung vor.'
    ],
    'correctAnswer': 3,
    'explanation': 'Trennbares Verb: Ich bereite ... vor. Reflexivpronomen nach dem Verbteil.',
    'exampleSentence': 'Ich bereite mich auf die Prüfung vor.',
    'grammarRule': 'Trennbares Verb + Reflexivpronomen',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-013',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unbeschadet der Tatsache, dass er recht hatte, wurde er überstimmt.',
      'Unbeschadet die Tatsache, dass er recht hatte, wurde er überstimmt.',
      'Unbeschadet der Tatsache, dass er recht hatte, er wurde überstimmt.',
      'Unbeschadet der Tatsache, dass hatte er recht, wurde er überstimmt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unbeschadet + Genitiv: der Tatsache. Dass-Nebensatz mit Verb am Ende. Hauptsatz mit Inversion.',
    'exampleSentence': 'Unbeschadet der Tatsache, dass er recht hatte, wurde er überstimmt.',
    'grammarRule': 'Gehobene Konzessivkonstruktion mit unbeschadet',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-015',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nirgends sonst findet man eine derartige Vielfalt.',
      'Nirgends sonst man findet eine derartige Vielfalt.',
      'Nirgends sonst findet eine derartige Vielfalt man.',
      'Findet man nirgends sonst eine derartige Vielfalt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach nirgends sonst folgt Inversion: findet + man.',
    'exampleSentence': 'Nirgends sonst findet man eine derartige Vielfalt.',
    'grammarRule': 'Inversion nach negiertem Lokaladverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-016',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zumal die Lage sich verschärft hat, sind neue Maßnahmen nötig.',
      'Zumal sich die Lage verschärft hat, sind neue Maßnahmen nötig.',
      'Zumal die Lage sich verschärft hat, neue Maßnahmen sind nötig.',
      'Zumal hat sich die Lage verschärft, sind neue Maßnahmen nötig.'
    ],
    'correctAnswer': 1,
    'explanation': 'Zumal (= besonders weil) + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'Zumal sich die Lage verschärft hat, sind neue Maßnahmen nötig.',
    'grammarRule': 'Kausalsatz mit zumal',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-017',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Sei es drum, wir werden es versuchen.',
      'Drum sei es, wir werden es versuchen.',
      'Es sei drum, wir werden es versuchen.',
      'Sei drum es, wir werden es versuchen.'
    ],
    'correctAnswer': 2,
    'explanation': 'Feste Wendung: Es sei drum (= es sei so, es ist egal). Konjunktiv I.',
    'exampleSentence': 'Es sei drum, wir werden es versuchen.',
    'grammarRule': 'Archaische Wendung mit Konjunktiv I',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-018',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dergestalt war seine Rede, dass alle verstummten.',
      'Dergestalt seine Rede war, dass alle verstummten.',
      'Dergestalt war seine Rede, dass verstummten alle.',
      'Seine Rede dergestalt war, dass alle verstummten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Adverb dergestalt (= so beschaffen) + Inversion + dass-Nebensatz.',
    'exampleSentence': 'Dergestalt war seine Rede, dass alle verstummten.',
    'grammarRule': 'Gehobener Ausdruck mit dergestalt',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-019',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dafür, dass er erst kürzlich angefangen hat, leistet er Beachtliches.',
      'Dafür, dass er erst kürzlich hat angefangen, leistet er Beachtliches.',
      'Dafür, dass er erst kürzlich angefangen hat, er leistet Beachtliches.',
      'Dass er erst kürzlich angefangen hat dafür, leistet er Beachtliches.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dafür, dass + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Dafür, dass er erst kürzlich angefangen hat, leistet er Beachtliches.',
    'grammarRule': 'Konzessivsatz mit dafür, dass',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-020',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man bedenke, welche Folgen das haben könnte.',
      'Man bedenkt, welche Folgen das haben könnte.',
      'Man bedenke, welche Folgen könnte das haben.',
      'Bedenke man, welche Folgen das haben könnte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als gehobene Aufforderung: Man bedenke + indirekter Fragesatz.',
    'exampleSentence': 'Man bedenke, welche Folgen das haben könnte.',
    'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-021',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Nichtsdestoweniger hielt er an seinem Vorhaben fest.',
      'Nichtsdestoweniger er hielt an seinem Vorhaben fest.',
      'Nichtsdestoweniger hielt an seinem Vorhaben er fest.',
      'Er hielt nichtsdestoweniger seinem Vorhaben an fest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nichtsdestoweniger (= trotzdem) + Inversion: hielt + er.',
    'exampleSentence': 'Nichtsdestoweniger hielt er an seinem Vorhaben fest.',
    'grammarRule': 'Gehobenes Adverb mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-022',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'So weit es ihn betrifft, ist die Angelegenheit erledigt.',
      'So weit es ihn betrifft, die Angelegenheit ist erledigt.',
      'So weit betrifft es ihn, ist die Angelegenheit erledigt.',
      'Es betrifft ihn so weit, ist die Angelegenheit erledigt.'
    ],
    'correctAnswer': 0,
    'explanation': 'So weit es + Akk. + betrifft (Verb am Ende im Nebensatz), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'So weit es ihn betrifft, ist die Angelegenheit erledigt.',
    'grammarRule': 'Einschränkungssatz mit so weit',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-023',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei angemerkt, dass diese Regel Ausnahmen kennt.',
      'Es sei anmerken, dass diese Regel Ausnahmen kennt.',
      'Angemerkt sei es, dass diese Regel Ausnahmen kennt.',
      'Es sei angemerkt, dass Ausnahmen kennt diese Regel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in formellen Anmerkungen: Es sei angemerkt + dass-Nebensatz.',
    'exampleSentence': 'Es sei angemerkt, dass diese Regel Ausnahmen kennt.',
    'grammarRule': 'Konjunktiv I in formellen Anmerkungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-024',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wie dem auch gewesen sein mag, das Ergebnis spricht für sich.',
      'Wie dem auch gewesen sein mag, spricht das Ergebnis für sich.',
      'Wie auch dem gewesen sein mag, das Ergebnis spricht für sich.',
      'Dem wie auch gewesen sein mag, das Ergebnis spricht für sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessive Wendung: Wie dem auch + Verb am Ende, dann Hauptsatz ohne Inversion.',
    'exampleSentence': 'Wie dem auch gewesen sein mag, das Ergebnis spricht für sich.',
    'grammarRule': 'Gehobene Konzessivwendung',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-025',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Anstatt sich zu beklagen, sollte man handeln.',
      'Anstatt sich beklagen zu, sollte man handeln.',
      'Anstatt zu sich beklagen, sollte man handeln.',
      'Anstatt sich zu beklagen, man sollte handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anstatt + sich + zu + Infinitiv. Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Anstatt sich zu beklagen, sollte man handeln.',
    'grammarRule': 'Infinitivsatz mit anstatt...zu',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-026',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es geziemt sich nicht, andere zu beleidigen.',
      'Es geziemt nicht sich, andere zu beleidigen.',
      'Es geziemt sich nicht, andere beleidigen zu.',
      'Sich geziemt es nicht, andere zu beleidigen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Verb: Es geziemt sich nicht (= es gehört sich nicht) + Infinitiv mit zu.',
    'exampleSentence': 'Es geziemt sich nicht, andere zu beleidigen.',
    'grammarRule': 'Gehobenes Verb geziemen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-027',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Indes die Sonne unterging, begann das Fest.',
      'Indes unterging die Sonne, begann das Fest.',
      'Indes die Sonne unterging, das Fest begann.',
      'Die Sonne indes unterging, begann das Fest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Literarisches indes (= während) + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.',
    'exampleSentence': 'Indes die Sonne unterging, begann das Fest.',
    'grammarRule': 'Literarischer Temporalsatz mit indes',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-028',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Umso mehr gilt es, die verbleibende Zeit zu nutzen.',
      'Umso mehr es gilt, die verbleibende Zeit zu nutzen.',
      'Umso mehr gilt es, die verbleibende Zeit nutzen zu.',
      'Es gilt umso mehr, die verbleibende Zeit zu nutzen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Umso mehr + Inversion (gilt es) + Infinitiv mit zu.',
    'exampleSentence': 'Umso mehr gilt es, die verbleibende Zeit zu nutzen.',
    'grammarRule': 'Gehobener Ausdruck mit umso mehr',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-029',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es oblag ihm, für die Familie zu sorgen.',
      'Es oblag ihn, für die Familie zu sorgen.',
      'Es oblag ihm, für die Familie sorgen zu.',
      'Ihm oblag es, für die Familie zu sorgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Verb obliegen (Präteritum: oblag) + Dativ: ihm + Infinitiv mit zu.',
    'exampleSentence': 'Es oblag ihm, für die Familie zu sorgen.',
    'grammarRule': 'Gehobenes Verb obliegen im Präteritum',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-030',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ebenso wenig wie er das Problem erkannte, vermochte er es zu lösen.',
      'Ebenso wenig wie er das Problem erkannte, er vermochte es zu lösen.',
      'Ebenso wenig wie erkannte er das Problem, vermochte er es zu lösen.',
      'Er erkannte ebenso wenig das Problem, wie vermochte er es zu lösen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ebenso wenig wie + Nebensatz, + Hauptsatz mit Inversion.',
    'exampleSentence': 'Ebenso wenig wie er das Problem erkannte, vermochte er es zu lösen.',
    'grammarRule': 'Vergleichender Negationssatz',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-031',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es versteht sich von selbst, dass Diskretion gewahrt wird.',
      'Es versteht von selbst sich, dass Diskretion gewahrt wird.',
      'Es versteht sich von selbst, dass Diskretion wird gewahrt.',
      'Von selbst versteht es sich, dass Diskretion gewahrt wird.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es versteht sich von selbst + dass-Nebensatz (Verb am Ende).',
    'exampleSentence': 'Es versteht sich von selbst, dass Diskretion gewahrt wird.',
    'grammarRule': 'Gehobene Wendung mit es versteht sich',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-032',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei denn, er ändert seine Meinung.',
      'Es sei denn, er ändere seine Meinung.',
      'Denn es sei, er ändert seine Meinung.',
      'Es sei denn, seine Meinung er ändert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Wendung: Es sei denn (= außer wenn) + Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Es sei denn, er ändert seine Meinung.',
    'grammarRule': 'Feste Wendung es sei denn',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-033',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Alldieweil die Verhandlungen stockten, wuchs die Ungeduld.',
      'Alldieweil stockten die Verhandlungen, wuchs die Ungeduld.',
      'Alldieweil die Verhandlungen stockten, die Ungeduld wuchs.',
      'Die Verhandlungen alldieweil stockten, wuchs die Ungeduld.'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaisches alldieweil (= weil/während) + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Alldieweil die Verhandlungen stockten, wuchs die Ungeduld.',
    'grammarRule': 'Archaische Konjunktion alldieweil',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-034',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Abgesehen davon, dass es regnet, ist das Wetter angenehm.',
      'Abgesehen davon, dass es regnet, das Wetter ist angenehm.',
      'Abgesehen davon, dass regnet es, ist das Wetter angenehm.',
      'Davon abgesehen, dass es regnet, angenehm ist das Wetter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Abgesehen davon, dass + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Abgesehen davon, dass es regnet, ist das Wetter angenehm.',
    'grammarRule': 'Einschränkungssatz mit abgesehen davon',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-035',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Dessen bin ich mir wohl bewusst.',
      'Dessen ich mir bin wohl bewusst.',
      'Ich bin mir dessen wohl bewusst.',
      'Mir bin ich dessen wohl bewusst.'
    ],
    'correctAnswer': 2,
    'explanation': 'Gehobener Ausdruck: sich einer Sache bewusst sein. Genitiv: dessen.',
    'exampleSentence': 'Ich bin mir dessen wohl bewusst.',
    'grammarRule': 'Gehobener Ausdruck mit Genitiv',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-036',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Weitaus bedeutsamer als die Form ist der Inhalt.',
      'Weitaus bedeutsamer als die Form der Inhalt ist.',
      'Weitaus bedeutsamer ist als die Form der Inhalt.',
      'Als die Form weitaus bedeutsamer ist der Inhalt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Voranstellung des Komparativs: Weitaus bedeutsamer als X + Inversion: ist + Subjekt.',
    'exampleSentence': 'Weitaus bedeutsamer als die Form ist der Inhalt.',
    'grammarRule': 'Vorangestellter Komparativ mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-037',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'So paradox es klingen mag, das Scheitern war ein Gewinn.',
      'So paradox klingen es mag, das Scheitern war ein Gewinn.',
      'So paradox es klingen mag, war das Scheitern ein Gewinn.',
      'Paradox so es klingen mag, das Scheitern war ein Gewinn.'
    ],
    'correctAnswer': 0,
    'explanation': 'So + Adjektiv + es + Infinitiv + mag (Verb am Ende), dann Hauptsatz.',
    'exampleSentence': 'So paradox es klingen mag, das Scheitern war ein Gewinn.',
    'grammarRule': 'Konzessivsatz mit so...es...mag',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-038',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Kraft seiner Befugnis ordnete er die Evakuierung an.',
      'Kraft seine Befugnis ordnete er die Evakuierung an.',
      'Kraft seiner Befugnis er ordnete die Evakuierung an.',
      'Kraft seiner Befugnis ordnete die Evakuierung er an.'
    ],
    'correctAnswer': 0,
    'explanation': 'Kraft + Genitiv: seiner Befugnis. Inversion im Hauptsatz.',
    'exampleSentence': 'Kraft seiner Befugnis ordnete er die Evakuierung an.',
    'grammarRule': 'Gehobene Präposition kraft + Genitiv',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p3-050',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mitnichten lässt sich behaupten, dass er unschuldig war.',
      'Mitnichten sich lässt behaupten, dass er unschuldig war.',
      'Mitnichten lässt sich behaupten, dass unschuldig er war.',
      'Lässt sich mitnichten behaupten, dass er unschuldig war.'
    ],
    'correctAnswer': 0,
    'explanation': 'Mitnichten (= keineswegs) + Inversion: lässt sich + Infinitiv + dass-Nebensatz.',
    'exampleSentence': 'Mitnichten lässt sich behaupten, dass er unschuldig war.',
    'grammarRule': 'Archaisches Adverb mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-039', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ferner ist zu beachten, dass die Fristen einzuhalten sind.', 'Ferner zu beachten ist, dass die Fristen einzuhalten sind.', 'Ferner ist zu beachten, dass einzuhalten sind die Fristen.', 'Ist ferner zu beachten, dass die Fristen einzuhalten sind.'], 'correctAnswer': 0, 'explanation': 'Ferner + Inversion: ist + zu beachten + dass-Nebensatz.', 'exampleSentence': 'Ferner ist zu beachten, dass die Fristen einzuhalten sind.', 'grammarRule': 'Gehobener Ausdruck mit ferner', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-040', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei nachdrücklich darauf hingewiesen, dass Vorsicht geboten ist.', 'Es sei nachdrücklich darauf hinweisen, dass Vorsicht geboten ist.', 'Nachdrücklich sei es darauf hingewiesen, dass Vorsicht geboten ist.', 'Es sei nachdrücklich darauf hingewiesen, dass geboten ist Vorsicht.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Es sei ... darauf hingewiesen + dass-Nebensatz.', 'exampleSentence': 'Es sei nachdrücklich darauf hingewiesen, dass Vorsicht geboten ist.', 'grammarRule': 'Konjunktiv I in formellen Hinweisen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-041', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zumal in Zeiten der Unsicherheit bedarf es starker Führung.', 'Zumal in Zeiten der Unsicherheit es bedarf starker Führung.', 'Zumal in Zeiten der Unsicherheit bedarf starker Führung es.', 'Es bedarf zumal in Zeiten der Unsicherheit starker Führung.'], 'correctAnswer': 0, 'explanation': 'Zumal in Zeiten + Genitiv + Inversion: bedarf + es + Genitiv.', 'exampleSentence': 'Zumal in Zeiten der Unsicherheit bedarf es starker Führung.', 'grammarRule': 'Gehobener Ausdruck mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-042', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Offen bleibt die Frage, ob die Strategie aufgeht.', 'Offen die Frage bleibt, ob die Strategie aufgeht.', 'Offen bleibt die Frage, ob aufgeht die Strategie.', 'Die Frage offen bleibt, ob die Strategie aufgeht.'], 'correctAnswer': 0, 'explanation': 'Vorangestelltes Adjektiv: Offen + Inversion: bleibt + Subjekt + ob-Nebensatz.', 'exampleSentence': 'Offen bleibt die Frage, ob die Strategie aufgeht.', 'grammarRule': 'Vorangestelltes Adjektiv mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-043', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge sich die Konsequenzen vor Augen führen.', 'Man möge sich vor Augen die Konsequenzen führen.', 'Möge man sich die Konsequenzen vor Augen führen.', 'Man möge die Konsequenzen sich vor Augen führen.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man möge + sich + Objekt + Infinitiv.', 'exampleSentence': 'Man möge sich die Konsequenzen vor Augen führen.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-044', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Sogleich machte er sich an die Arbeit.', 'Sogleich er machte sich an die Arbeit.', 'Sogleich machte sich er an die Arbeit.', 'Er sogleich machte sich an die Arbeit.'], 'correctAnswer': 0, 'explanation': 'Sogleich (= sofort, gehoben) + Inversion: machte + er + sich.', 'exampleSentence': 'Sogleich machte er sich an die Arbeit.', 'grammarRule': 'Gehobenes Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-045', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zweifellos hat die Forschung bedeutende Fortschritte erzielt.', 'Zweifellos die Forschung hat bedeutende Fortschritte erzielt.', 'Zweifellos hat bedeutende Fortschritte die Forschung erzielt.', 'Hat zweifellos die Forschung bedeutende Fortschritte erzielt.'], 'correctAnswer': 0, 'explanation': 'Zweifellos + Inversion: hat + Subjekt + Objekt + Partizip.', 'exampleSentence': 'Zweifellos hat die Forschung bedeutende Fortschritte erzielt.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-046', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei unbenommen, einen anderen Standpunkt zu vertreten.', 'Es sei unbenehmen, einen anderen Standpunkt zu vertreten.', 'Unbenommen sei es, einen anderen Standpunkt zu vertreten.', 'Es sei unbenommen, einen anderen Standpunkt vertreten zu.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Es sei unbenommen (= es steht frei) + Infinitiv mit zu.', 'exampleSentence': 'Es sei unbenommen, einen anderen Standpunkt zu vertreten.', 'grammarRule': 'Konjunktiv I in gehobenen Erlaubnissen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-047', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unverzüglich wurden Gegenmaßnahmen eingeleitet.', 'Unverzüglich Gegenmaßnahmen wurden eingeleitet.', 'Unverzüglich wurden eingeleitet Gegenmaßnahmen.', 'Gegenmaßnahmen unverzüglich wurden eingeleitet.'], 'correctAnswer': 0, 'explanation': 'Unverzüglich (= sofort, gehoben) + Inversion: wurden + Subjekt + Partizip.', 'exampleSentence': 'Unverzüglich wurden Gegenmaßnahmen eingeleitet.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-048', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Entscheidend ist, dass wir einen gemeinsamen Nenner finden.', 'Entscheidend ist, dass finden wir einen gemeinsamen Nenner.', 'Entscheidend, dass wir einen gemeinsamen Nenner finden, ist.', 'Ist entscheidend, dass wir einen gemeinsamen Nenner finden.'], 'correctAnswer': 0, 'explanation': 'Vorangestelltes Adjektiv: Entscheidend + ist + dass-Nebensatz.', 'exampleSentence': 'Entscheidend ist, dass wir einen gemeinsamen Nenner finden.', 'grammarRule': 'Vorangestelltes Adjektiv + ist + dass', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-049', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man beachte hierbei, dass Sorgfalt oberstes Gebot ist.', 'Man beachtet hierbei, dass Sorgfalt oberstes Gebot ist.', 'Man beachte hierbei, dass oberstes Gebot ist Sorgfalt.', 'Hierbei beachte man, dass Sorgfalt oberstes Gebot ist.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man beachte + dass-Nebensatz.', 'exampleSentence': 'Man beachte hierbei, dass Sorgfalt oberstes Gebot ist.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-051', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Derweilen harrte das Volk der Dinge, die da kommen sollten.', 'Derweilen das Volk harrte der Dinge, die da kommen sollten.', 'Derweilen harrte der Dinge das Volk, die da kommen sollten.', 'Das Volk derweilen harrte der Dinge, die da kommen sollten.'], 'correctAnswer': 0, 'explanation': 'Derweilen (= inzwischen, archaisch) + Inversion: harrte + Subjekt + Genitiv.', 'exampleSentence': 'Derweilen harrte das Volk der Dinge, die da kommen sollten.', 'grammarRule': 'Archaisches Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-052', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nichtsdestoweniger wurde der Plan weiterverfolgt.', 'Nichtsdestoweniger der Plan wurde weiterverfolgt.', 'Nichtsdestoweniger wurde weiterverfolgt der Plan.', 'Der Plan nichtsdestoweniger wurde weiterverfolgt.'], 'correctAnswer': 0, 'explanation': 'Nichtsdestoweniger (= trotzdem) + Inversion: wurde + Subjekt.', 'exampleSentence': 'Nichtsdestoweniger wurde der Plan weiterverfolgt.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-053', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge in Betracht ziehen, dass die Umstände sich geändert haben.', 'Man zieht möge in Betracht, dass die Umstände sich geändert haben.', 'Man möge in Betracht ziehen, dass sich geändert haben die Umstände.', 'Ziehen möge man in Betracht, dass die Umstände sich geändert haben.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man möge + Infinitiv + dass-Nebensatz.', 'exampleSentence': 'Man möge in Betracht ziehen, dass die Umstände sich geändert haben.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-054', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fürwahr hat er sich große Verdienste erworben.', 'Fürwahr er hat sich große Verdienste erworben.', 'Fürwahr hat sich große Verdienste er erworben.', 'Er fürwahr hat sich große Verdienste erworben.'], 'correctAnswer': 0, 'explanation': 'Fürwahr (= wahrhaftig, archaisch) + Inversion: hat + er.', 'exampleSentence': 'Fürwahr hat er sich große Verdienste erworben.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-055', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zumal die Lage ernst ist, müssen wir entschlossen handeln.', 'Zumal die Lage ernst ist, wir müssen entschlossen handeln.', 'Zumal ernst ist die Lage, müssen wir entschlossen handeln.', 'Zumal die Lage ist ernst, müssen wir entschlossen handeln.'], 'correctAnswer': 0, 'explanation': 'Zumal + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Zumal die Lage ernst ist, müssen wir entschlossen handeln.', 'grammarRule': 'Kausalsatz mit zumal', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-056', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei an dieser Stelle erwähnt, dass Fortschritte erzielt wurden.', 'Es sei an dieser Stelle erwähnen, dass Fortschritte erzielt wurden.', 'Erwähnt sei es an dieser Stelle, dass Fortschritte erzielt wurden.', 'Es sei an dieser Stelle erwähnt, dass erzielt wurden Fortschritte.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es sei erwähnt + dass-Nebensatz.', 'exampleSentence': 'Es sei an dieser Stelle erwähnt, dass Fortschritte erzielt wurden.', 'grammarRule': 'Konjunktiv I Passiv in formeller Sprache', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-057', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ungeachtet der Kritik hielt er an seinem Kurs fest.', 'Ungeachtet die Kritik hielt er an seinem Kurs fest.', 'Ungeachtet der Kritik er hielt an seinem Kurs fest.', 'Ungeachtet der Kritik hielt an seinem Kurs er fest.'], 'correctAnswer': 0, 'explanation': 'Ungeachtet + Genitiv: der Kritik. Inversion im Hauptsatz.', 'exampleSentence': 'Ungeachtet der Kritik hielt er an seinem Kurs fest.', 'grammarRule': 'Gehobene Konzessivkonstruktion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-058', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Insofern als die Daten zuverlässig sind, lässt sich ein Trend erkennen.', 'Insofern als die Daten zuverlässig sind, ein Trend lässt sich erkennen.', 'Insofern als zuverlässig sind die Daten, lässt sich ein Trend erkennen.', 'Insofern als die Daten sind zuverlässig, lässt sich ein Trend erkennen.'], 'correctAnswer': 0, 'explanation': 'Insofern als + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Insofern als die Daten zuverlässig sind, lässt sich ein Trend erkennen.', 'grammarRule': 'Gehobene Konditionalkonstruktion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-059', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es werde hiermit angeordnet, dass alle Akten gesichert werden.', 'Es wird hiermit angeordnet, dass alle Akten gesichert werden.', 'Angeordnet werde es hiermit, dass alle Akten gesichert werden.', 'Es werde hiermit anordnen, dass alle Akten gesichert werden.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es werde angeordnet + dass-Nebensatz.', 'exampleSentence': 'Es werde hiermit angeordnet, dass alle Akten gesichert werden.', 'grammarRule': 'Konjunktiv I Passiv in Anordnungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-060', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Allenthalben zeigten sich Spuren des Verfalls.', 'Allenthalben Spuren des Verfalls zeigten sich.', 'Allenthalben zeigten Spuren sich des Verfalls.', 'Spuren des Verfalls allenthalben zeigten sich.'], 'correctAnswer': 0, 'explanation': 'Allenthalben (= überall, archaisch) + Inversion: zeigten + sich + Subjekt.', 'exampleSentence': 'Allenthalben zeigten sich Spuren des Verfalls.', 'grammarRule': 'Archaisches Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p3-061', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unbestritten ist, dass die Wirtschaft wächst.', 'Unbestritten, dass die Wirtschaft wächst, ist.', 'Ist unbestritten, dass die Wirtschaft wächst.', 'Unbestritten ist, dass wächst die Wirtschaft.'], 'correctAnswer': 0, 'explanation': 'Vorangestelltes Adjektiv: Unbestritten + ist + dass-Nebensatz.', 'exampleSentence': 'Unbestritten ist, dass die Wirtschaft wächst.', 'grammarRule': 'Vorangestelltes Adjektiv + ist + dass', 'tags': ['satzbildung', 'stilistisch'] }
];

export default questions;
