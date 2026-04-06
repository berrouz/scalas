import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-004',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Die Mutter erzählt den Kindern Geschichten.',
      'Die Mutter erzählt Geschichten den Kindern.',
      'Den Kindern die Mutter erzählt Geschichten.',
      'Die Mutter den Kindern Geschichten erzählt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Dativ vor Akkusativ bei Nomen-Objekten.',
    'exampleSentence': 'Die Mutter erzählt den Kindern Geschichten.',
    'grammarRule': 'Dativ vor Akkusativ',
    'tags': ['satzbildung', 'wortstellung']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-013',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Mag sein, dass er recht hat, doch überzeugt mich das nicht.',
      'Mag sein, dass er recht hat, doch das überzeugt nicht mich.',
      'Mag es sein, dass recht hat er, doch überzeugt mich das nicht.',
      'Sein mag, dass er recht hat, doch überzeugt mich das nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Einräumung: Mag sein, dass + Nebensatz, doch + Hauptsatz mit Inversion.',
    'exampleSentence': 'Mag sein, dass er recht hat, doch überzeugt mich das nicht.',
    'grammarRule': 'Konzessive Einräumung mit mag sein',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-014',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei erwähnt, dass dieser Brauch jahrhundertealt ist.',
      'Es sei erwähnen, dass dieser Brauch jahrhundertealt ist.',
      'Erwähnt sei es, dass dieser Brauch jahrhundertealt ist.',
      'Es sei erwähnt, dass jahrhundertealt ist dieser Brauch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in formellen Erwähnungen: Es sei erwähnt + dass-Nebensatz.',
    'exampleSentence': 'Es sei erwähnt, dass dieser Brauch jahrhundertealt ist.',
    'grammarRule': 'Konjunktiv I in formellen Erwähnungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-015',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Vergebens hatte er versucht, die Mauern zu überwinden.',
      'Vergebens er hatte versucht, die Mauern zu überwinden.',
      'Vergebens hatte versucht er, die Mauern zu überwinden.',
      'Hatte er vergebens versucht, die Mauern zu überwinden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vergebens (= ohne Erfolg) + Inversion: hatte + er + versucht.',
    'exampleSentence': 'Vergebens hatte er versucht, die Mauern zu überwinden.',
    'grammarRule': 'Inversion nach vorangestelltem Adverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-016',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Obschon die Beweislage dünn war, wurde er verurteilt.',
      'Obschon die Beweislage dünn war, er wurde verurteilt.',
      'Obschon war die Beweislage dünn, wurde er verurteilt.',
      'Obschon die Beweislage dünn war, verurteilt wurde er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes obschon (= obwohl) + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Obschon die Beweislage dünn war, wurde er verurteilt.',
    'grammarRule': 'Konzessivsatz mit obschon',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-017',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Gott sei es gedankt, dass wir gesund geblieben sind.',
      'Gott es sei gedankt, dass wir gesund geblieben sind.',
      'Gedankt sei Gott es, dass wir gesund geblieben sind.',
      'Gott sei es gedankt, dass gesund geblieben wir sind.'
    ],
    'correctAnswer': 0,
    'explanation': 'Archaische Dankesformel: Gott sei es gedankt (Konjunktiv I) + dass-Nebensatz.',
    'exampleSentence': 'Gott sei es gedankt, dass wir gesund geblieben sind.',
    'grammarRule': 'Archaische Dankesformel mit Konjunktiv I',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-018',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zutiefst erschüttert verließ er den Saal.',
      'Zutiefst erschüttert den Saal verließ er.',
      'Verließ er zutiefst erschüttert den Saal.',
      'Er zutiefst erschüttert verließ den Saal.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorangestelltes Partizipialattribut: Zutiefst erschüttert + Inversion: verließ + er.',
    'exampleSentence': 'Zutiefst erschüttert verließ er den Saal.',
    'grammarRule': 'Vorangestelltes Partizipialattribut mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-019',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Wie auch immer man die Sache betrachtet, es bleibt ein Rätsel.',
      'Wie auch immer man die Sache betrachtet, bleibt es ein Rätsel.',
      'Wie auch immer betrachtet man die Sache, es bleibt ein Rätsel.',
      'Man wie auch immer die Sache betrachtet, es bleibt ein Rätsel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessiver Relativsatz: Wie auch immer + Verb am Ende, dann Hauptsatz.',
    'exampleSentence': 'Wie auch immer man die Sache betrachtet, es bleibt ein Rätsel.',
    'grammarRule': 'Konzessiver Relativsatz mit wie auch immer',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-020',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man vergegenwärtige sich die Tragweite dieser Entscheidung.',
      'Man vergegenwärtigt sich die Tragweite dieser Entscheidung.',
      'Man vergegenwärtige die Tragweite sich dieser Entscheidung.',
      'Vergegenwärtige man sich die Tragweite dieser Entscheidung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als gehobene Aufforderung: Man vergegenwärtige sich.',
    'exampleSentence': 'Man vergegenwärtige sich die Tragweite dieser Entscheidung.',
    'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-021',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Weitaus schwerwiegender als die Kosten wiegen die sozialen Folgen.',
      'Weitaus schwerwiegender als die Kosten die sozialen Folgen wiegen.',
      'Weitaus schwerwiegender wiegen als die Kosten die sozialen Folgen.',
      'Die sozialen Folgen weitaus schwerwiegender als die Kosten wiegen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Voranstellung: Weitaus schwerwiegender als X + Inversion: wiegen + Subjekt.',
    'exampleSentence': 'Weitaus schwerwiegender als die Kosten wiegen die sozialen Folgen.',
    'grammarRule': 'Vorangestellter Komparativ mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-023',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei daran erinnert, dass diese Tradition uralt ist.',
      'Es sei daran erinnern, dass diese Tradition uralt ist.',
      'Daran sei es erinnert, dass diese Tradition uralt ist.',
      'Es sei daran erinnert, dass uralt ist diese Tradition.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in formellen Erinnerungen: Es sei daran erinnert + dass-Nebensatz.',
    'exampleSentence': 'Es sei daran erinnert, dass diese Tradition uralt ist.',
    'grammarRule': 'Konjunktiv I in formellen Erinnerungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-024',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Zurecht wird darauf hingewiesen, dass Handlungsbedarf besteht.',
      'Zurecht darauf wird hingewiesen, dass Handlungsbedarf besteht.',
      'Zurecht wird darauf hingewiesen, dass besteht Handlungsbedarf.',
      'Darauf zurecht wird hingewiesen, dass Handlungsbedarf besteht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zurecht + Inversion: wird + Präpositionaladverb + Partizip + dass-Nebensatz.',
    'exampleSentence': 'Zurecht wird darauf hingewiesen, dass Handlungsbedarf besteht.',
    'grammarRule': 'Gehobener Ausdruck mit zurecht',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-025',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Angesichts der Tatsache, dass die Zeit drängt, müssen wir handeln.',
      'Angesichts die Tatsache, dass die Zeit drängt, müssen wir handeln.',
      'Angesichts der Tatsache, dass die Zeit drängt, wir müssen handeln.',
      'Angesichts der Tatsache, dass drängt die Zeit, müssen wir handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Angesichts + Genitiv + dass-Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Angesichts der Tatsache, dass die Zeit drängt, müssen wir handeln.',
    'grammarRule': 'Gehobene Konstruktion mit angesichts + dass',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-026',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Man stelle sich vor, welche Auswirkungen das hätte.',
      'Man stellt sich vor, welche Auswirkungen das hätte.',
      'Man stelle vor sich, welche Auswirkungen das hätte.',
      'Stelle man sich vor, welche Auswirkungen das hätte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I als gehobene Aufforderung: Man stelle sich vor + indirekter Fragesatz.',
    'exampleSentence': 'Man stelle sich vor, welche Auswirkungen das hätte.',
    'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-027',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Umsonst waren all seine Bemühungen gewesen.',
      'Umsonst all seine Bemühungen waren gewesen.',
      'Umsonst waren gewesen all seine Bemühungen.',
      'All seine Bemühungen umsonst waren gewesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Voranstellung von umsonst + Inversion: waren + Subjekt + Partizip.',
    'exampleSentence': 'Umsonst waren all seine Bemühungen gewesen.',
    'grammarRule': 'Inversion nach vorangestelltem Adverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-028',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Unbeirrt von der Kritik verfolgte er seinen Weg.',
      'Unbeirrt von der Kritik er verfolgte seinen Weg.',
      'Unbeirrt von der Kritik verfolgte seinen Weg er.',
      'Von der Kritik unbeirrt seinen Weg er verfolgte.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vorangestelltes Partizipialattribut: Unbeirrt von + Dativ + Inversion.',
    'exampleSentence': 'Unbeirrt von der Kritik verfolgte er seinen Weg.',
    'grammarRule': 'Vorangestelltes Partizipialattribut mit Inversion',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-029',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es ziemt sich, dem Gastgeber zu danken.',
      'Es ziemt sich, dem Gastgeber danken zu.',
      'Es ziemt, dem Gastgeber sich zu danken.',
      'Sich ziemt es, dem Gastgeber zu danken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Verb: Es ziemt sich (= es gehört sich) + Infinitiv mit zu.',
    'exampleSentence': 'Es ziemt sich, dem Gastgeber zu danken.',
    'grammarRule': 'Gehobenes Verb ziemen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-030',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ohnedies war die Sache längst entschieden.',
      'Ohnedies die Sache war längst entschieden.',
      'Ohnedies war die Sache entschieden längst.',
      'Die Sache ohnedies war längst entschieden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ohnedies (= sowieso) + Inversion: war + Subjekt.',
    'exampleSentence': 'Ohnedies war die Sache längst entschieden.',
    'grammarRule': 'Gehobenes Adverb mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-031',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Soweit mir bekannt ist, wurde kein Antrag gestellt.',
      'Soweit mir bekannt ist, kein Antrag wurde gestellt.',
      'Soweit bekannt mir ist, wurde kein Antrag gestellt.',
      'Mir soweit bekannt ist, wurde kein Antrag gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Soweit + Nebensatz (Verb am Ende) + Hauptsatz mit Inversion.',
    'exampleSentence': 'Soweit mir bekannt ist, wurde kein Antrag gestellt.',
    'grammarRule': 'Einschränkungssatz mit soweit',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-032',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es sei dahingestellt, ob er die Wahrheit sagt.',
      'Es sei dahingestellt, ob sagt er die Wahrheit.',
      'Dahingestellt sei es, ob er die Wahrheit sagt.',
      'Es sei dahinstellen, ob er die Wahrheit sagt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I: Es sei dahingestellt (= es bleibe offen) + ob-Nebensatz.',
    'exampleSentence': 'Es sei dahingestellt, ob er die Wahrheit sagt.',
    'grammarRule': 'Konjunktiv I mit dahingestellt sein',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-033',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Längst schon hatte sich das Blatt gewendet.',
      'Längst schon sich hatte das Blatt gewendet.',
      'Längst schon hatte das Blatt gewendet sich.',
      'Sich längst schon hatte das Blatt gewendet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Längst schon + Inversion: hatte + sich + Subjekt + Partizip.',
    'exampleSentence': 'Längst schon hatte sich das Blatt gewendet.',
    'grammarRule': 'Inversion nach temporalem Adverb',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-034',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es lässt sich nicht leugnen, dass Fortschritte erzielt wurden.',
      'Es lässt nicht sich leugnen, dass Fortschritte erzielt wurden.',
      'Es lässt sich nicht leugnen, dass erzielt wurden Fortschritte.',
      'Nicht lässt es sich leugnen, dass Fortschritte erzielt wurden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es lässt sich nicht leugnen + dass-Nebensatz (Verb am Ende).',
    'exampleSentence': 'Es lässt sich nicht leugnen, dass Fortschritte erzielt wurden.',
    'grammarRule': 'Gehobene Wendung: sich leugnen lassen',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-035',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es bedarf keiner weiteren Erklärung.',
      'Es bedarf keine weiteren Erklärung.',
      'Es bedarf keiner weiterer Erklärung.',
      'Keiner weiteren Erklärung es bedarf.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobenes Verb bedürfen + Genitiv: keiner weiteren Erklärung.',
    'exampleSentence': 'Es bedarf keiner weiteren Erklärung.',
    'grammarRule': 'Gehobenes Verb bedürfen + Genitiv',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-036',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Indessen war die Lage unübersichtlich geworden.',
      'Indessen die Lage war unübersichtlich geworden.',
      'Indessen war unübersichtlich die Lage geworden.',
      'Die Lage indessen war geworden unübersichtlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Literarisches indessen (= inzwischen) + Inversion: war + Subjekt.',
    'exampleSentence': 'Indessen war die Lage unübersichtlich geworden.',
    'grammarRule': 'Gehobenes Adverb indessen mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-037',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Stilistisch gehobene Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Ganz gleich, welchen Weg man wählt, es gibt Risiken.',
      'Ganz gleich, welchen Weg man wählt, gibt es Risiken.',
      'Ganz gleich, welchen Weg wählt man, es gibt Risiken.',
      'Welchen Weg ganz gleich man wählt, es gibt Risiken.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivkonstruktion: Ganz gleich, welch- + Verb am Ende, dann Hauptsatz.',
    'exampleSentence': 'Ganz gleich, welchen Weg man wählt, es gibt Risiken.',
    'grammarRule': 'Konzessivsatz mit ganz gleich',
    'tags': ['satzbildung', 'stilistisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-038',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Archaische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Es empfiehlt sich, die Anweisungen sorgfältig zu lesen.',
      'Es empfiehlt, die Anweisungen sich sorgfältig zu lesen.',
      'Es empfiehlt sich, die Anweisungen sorgfältig lesen zu.',
      'Sich empfiehlt es, die Anweisungen sorgfältig zu lesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gehobene Wendung: Es empfiehlt sich (= es ist ratsam) + Infinitiv mit zu.',
    'exampleSentence': 'Es empfiehlt sich, die Anweisungen sorgfältig zu lesen.',
    'grammarRule': 'Gehobene Wendung mit sich empfehlen',
    'tags': ['satzbildung', 'archaisch']
  },
  {
    'language': 'german', 'id': 'c2-satzbildung-p5-050',
    'level': 'c2',
    'category': 'Satzbildung',
    'subcategory': 'Literarische Satzbildung',
    'question': 'Welcher Satz ist grammatisch richtig?',
    'options': [
      'Fortan widmete er sich ausschließlich der Forschung.',
      'Fortan er widmete sich ausschließlich der Forschung.',
      'Fortan widmete sich er ausschließlich der Forschung.',
      'Er widmete fortan ausschließlich der Forschung sich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Fortan (= von nun an) + Inversion: widmete + er + sich.',
    'exampleSentence': 'Fortan widmete er sich ausschließlich der Forschung.',
    'grammarRule': 'Gehobenes Temporaladverb mit Inversion',
    'tags': ['satzbildung', 'literarisch']
  },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-039', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Außer Frage steht, dass Handlungsbedarf besteht.', 'Außer Frage steht, dass besteht Handlungsbedarf.', 'Außer Frage es steht, dass Handlungsbedarf besteht.', 'Steht außer Frage, dass Handlungsbedarf besteht.'], 'correctAnswer': 0, 'explanation': 'Außer Frage stehen + dass-Nebensatz.', 'exampleSentence': 'Außer Frage steht, dass Handlungsbedarf besteht.', 'grammarRule': 'Gehobene Wendung: außer Frage stehen', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-040', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei in aller Deutlichkeit gesagt, dass Kompromisse nötig sind.', 'Es sei in aller Deutlichkeit sagen, dass Kompromisse nötig sind.', 'In aller Deutlichkeit sei es gesagt, dass Kompromisse nötig sind.', 'Es sei in aller Deutlichkeit gesagt, dass nötig sind Kompromisse.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Es sei ... gesagt + dass-Nebensatz.', 'exampleSentence': 'Es sei in aller Deutlichkeit gesagt, dass Kompromisse nötig sind.', 'grammarRule': 'Konjunktiv I in formellen Betonungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-041', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Hinfort wurde jede Entscheidung sorgfältig abgewogen.', 'Hinfort jede Entscheidung wurde sorgfältig abgewogen.', 'Hinfort wurde sorgfältig abgewogen jede Entscheidung.', 'Jede Entscheidung hinfort wurde sorgfältig abgewogen.'], 'correctAnswer': 0, 'explanation': 'Hinfort (= von nun an, archaisch) + Inversion: wurde + Subjekt + Partizip.', 'exampleSentence': 'Hinfort wurde jede Entscheidung sorgfältig abgewogen.', 'grammarRule': 'Archaisches Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-042', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Vorrangig gilt es, das Vertrauen wiederherzustellen.', 'Vorrangig es gilt, das Vertrauen wiederherzustellen.', 'Vorrangig gilt es, das Vertrauen wiederherstellen zu.', 'Es gilt vorrangig, wiederherzustellen das Vertrauen.'], 'correctAnswer': 0, 'explanation': 'Vorrangig + Inversion: gilt + es + Infinitiv mit zu.', 'exampleSentence': 'Vorrangig gilt es, das Vertrauen wiederherzustellen.', 'grammarRule': 'Gehobener Ausdruck mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-043', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man halte inne und überdenke die Lage.', 'Man hält inne und überdenkt die Lage.', 'Man halte inne und überdenke die Lage nicht.', 'Halte man inne und überdenke die Lage.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man halte inne und überdenke (koordinierte Konjunktiv-I-Formen).', 'exampleSentence': 'Man halte inne und überdenke die Lage.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-044', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Immerdar hatte er von dieser Stunde geträumt.', 'Immerdar er hatte von dieser Stunde geträumt.', 'Immerdar hatte von dieser Stunde er geträumt.', 'Er immerdar hatte von dieser Stunde geträumt.'], 'correctAnswer': 0, 'explanation': 'Immerdar (= immer, archaisch) + Inversion: hatte + er.', 'exampleSentence': 'Immerdar hatte er von dieser Stunde geträumt.', 'grammarRule': 'Archaisches Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-045', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es steht zu vermuten, dass weitere Kürzungen folgen.', 'Es steht vermuten zu, dass weitere Kürzungen folgen.', 'Zu vermuten steht es, dass weitere Kürzungen folgen.', 'Es steht zu vermuten, dass folgen weitere Kürzungen.'], 'correctAnswer': 0, 'explanation': 'Gehobene Wendung: Es steht zu vermuten + dass-Nebensatz.', 'exampleSentence': 'Es steht zu vermuten, dass weitere Kürzungen folgen.', 'grammarRule': 'Gehobene Wendung: stehen + zu + Infinitiv', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-046', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es gebührt den Helfern großer Dank.', 'Es gebührt die Helfer großer Dank.', 'Den Helfern gebührt es großer Dank.', 'Es gebührt den Helfern großen Dank.'], 'correctAnswer': 0, 'explanation': 'Gehobenes gebühren + Dativ: den Helfern + Nominativ: großer Dank.', 'exampleSentence': 'Es gebührt den Helfern großer Dank.', 'grammarRule': 'Gehobenes Verb gebühren + Dativ', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-047', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Alleweil herrschte reges Treiben auf dem Marktplatz.', 'Alleweil reges Treiben herrschte auf dem Marktplatz.', 'Alleweil herrschte auf dem Marktplatz reges Treiben.', 'Auf dem Marktplatz alleweil herrschte reges Treiben.'], 'correctAnswer': 0, 'explanation': 'Alleweil (= die ganze Zeit, archaisch) + Inversion: herrschte + Subjekt.', 'exampleSentence': 'Alleweil herrschte reges Treiben auf dem Marktplatz.', 'grammarRule': 'Archaisches Temporaladverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-048', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Maßgeblich beeinflusst wurde die Entscheidung durch neue Erkenntnisse.', 'Maßgeblich beeinflusst die Entscheidung wurde durch neue Erkenntnisse.', 'Maßgeblich wurde beeinflusst die Entscheidung durch neue Erkenntnisse.', 'Die Entscheidung maßgeblich beeinflusst wurde durch neue Erkenntnisse.'], 'correctAnswer': 0, 'explanation': 'Maßgeblich beeinflusst + Inversion: wurde + Subjekt + durch.', 'exampleSentence': 'Maßgeblich beeinflusst wurde die Entscheidung durch neue Erkenntnisse.', 'grammarRule': 'Vorangestelltes Partizip mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-049', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei gestattet, auf einen wichtigen Punkt hinzuweisen.', 'Es sei gestatten, auf einen wichtigen Punkt hinzuweisen.', 'Gestattet sei es, auf einen wichtigen Punkt hinzuweisen.', 'Es sei gestattet, auf einen wichtigen Punkt hinweisen zu.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I in höflicher Bitte: Es sei gestattet + Infinitiv mit zu.', 'exampleSentence': 'Es sei gestattet, auf einen wichtigen Punkt hinzuweisen.', 'grammarRule': 'Konjunktiv I in höflichen Bitten', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-051', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Vermehrt treten derartige Probleme in Großstädten auf.', 'Vermehrt derartige Probleme treten in Großstädten auf.', 'Vermehrt treten in Großstädten derartige Probleme auf.', 'Derartige Probleme vermehrt treten in Großstädten auf.'], 'correctAnswer': 0, 'explanation': 'Vermehrt + Inversion: treten + Subjekt + Lokalangabe + auf.', 'exampleSentence': 'Vermehrt treten derartige Probleme in Großstädten auf.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-052', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Nichtsdestoweniger bleibt Optimismus angebracht.', 'Nichtsdestoweniger Optimismus bleibt angebracht.', 'Nichtsdestoweniger bleibt angebracht Optimismus.', 'Optimismus nichtsdestoweniger bleibt angebracht.'], 'correctAnswer': 0, 'explanation': 'Nichtsdestoweniger + Inversion: bleibt + Subjekt + Adjektiv.', 'exampleSentence': 'Nichtsdestoweniger bleibt Optimismus angebracht.', 'grammarRule': 'Gehobenes Adverb mit Inversion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-053', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es sei noch einmal unterstrichen, dass die Sicherheit Vorrang hat.', 'Es sei noch einmal unterstreichen, dass die Sicherheit Vorrang hat.', 'Unterstrichen sei es noch einmal, dass die Sicherheit Vorrang hat.', 'Es sei noch einmal unterstrichen, dass Vorrang hat die Sicherheit.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Es sei ... unterstrichen + dass-Nebensatz.', 'exampleSentence': 'Es sei noch einmal unterstrichen, dass die Sicherheit Vorrang hat.', 'grammarRule': 'Konjunktiv I in formellen Betonungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-054', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Zumal die Ergebnisse eindeutig sind, besteht kein Zweifel.', 'Zumal die Ergebnisse eindeutig sind, kein Zweifel besteht.', 'Zumal eindeutig sind die Ergebnisse, besteht kein Zweifel.', 'Zumal die Ergebnisse sind eindeutig, besteht kein Zweifel.'], 'correctAnswer': 0, 'explanation': 'Zumal + Nebensatz (Verb am Ende), dann Hauptsatz mit Inversion.', 'exampleSentence': 'Zumal die Ergebnisse eindeutig sind, besteht kein Zweifel.', 'grammarRule': 'Kausalsatz mit zumal', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-055', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Ungeachtet der Schwierigkeiten wurde das Projekt fortgeführt.', 'Ungeachtet die Schwierigkeiten wurde das Projekt fortgeführt.', 'Ungeachtet der Schwierigkeiten das Projekt wurde fortgeführt.', 'Ungeachtet der Schwierigkeiten wurde fortgeführt das Projekt.'], 'correctAnswer': 0, 'explanation': 'Ungeachtet + Genitiv: der Schwierigkeiten. Inversion im Hauptsatz.', 'exampleSentence': 'Ungeachtet der Schwierigkeiten wurde das Projekt fortgeführt.', 'grammarRule': 'Gehobene Konzessivkonstruktion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-056', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Man möge bedenken, dass Zeit ein kostbares Gut ist.', 'Man bedenkt möge, dass Zeit ein kostbares Gut ist.', 'Man möge bedenken, dass ein kostbares Gut ist Zeit.', 'Bedenken möge man, dass Zeit ein kostbares Gut ist.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I: Man möge bedenken + dass-Nebensatz.', 'exampleSentence': 'Man möge bedenken, dass Zeit ein kostbares Gut ist.', 'grammarRule': 'Konjunktiv I in gehobenen Aufforderungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-057', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Insofern als die Fakten stimmen, hat er recht.', 'Insofern als die Fakten stimmen, er hat recht.', 'Insofern als stimmen die Fakten, hat er recht.', 'Insofern als die Fakten stimmen, hat recht er.'], 'correctAnswer': 0, 'explanation': 'Insofern als + Nebensatz, dann Hauptsatz mit Inversion.', 'exampleSentence': 'Insofern als die Fakten stimmen, hat er recht.', 'grammarRule': 'Gehobene Konditionalkonstruktion', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-058', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fürwahr hat sich die Lage dramatisch verschlechtert.', 'Fürwahr die Lage hat sich dramatisch verschlechtert.', 'Fürwahr hat die Lage sich dramatisch verschlechtert.', 'Die Lage fürwahr hat sich dramatisch verschlechtert.'], 'correctAnswer': 0, 'explanation': 'Fürwahr (= wahrhaftig) + Inversion: hat + sich + Subjekt.', 'exampleSentence': 'Fürwahr hat sich die Lage dramatisch verschlechtert.', 'grammarRule': 'Archaische Bekräftigung mit Inversion', 'tags': ['satzbildung', 'literarisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-059', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Archaische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Es werde hiermit klargestellt, dass die Regelung für alle gilt.', 'Es werde hiermit klarstellen, dass die Regelung für alle gilt.', 'Klargestellt werde es hiermit, dass die Regelung für alle gilt.', 'Es werde hiermit klargestellt, dass für alle gilt die Regelung.'], 'correctAnswer': 0, 'explanation': 'Konjunktiv I Passiv: Es werde klargestellt + dass-Nebensatz.', 'exampleSentence': 'Es werde hiermit klargestellt, dass die Regelung für alle gilt.', 'grammarRule': 'Konjunktiv I Passiv in Klarstellungen', 'tags': ['satzbildung', 'archaisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-060', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Stilistisch gehobene Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Unbestritten ist, dass sofortiges Handeln erforderlich ist.', 'Unbestritten, dass sofortiges Handeln erforderlich ist, ist.', 'Ist unbestritten, dass sofortiges Handeln erforderlich ist.', 'Unbestritten ist, dass erforderlich ist sofortiges Handeln.'], 'correctAnswer': 0, 'explanation': 'Vorangestelltes Adjektiv: Unbestritten + ist + dass-Nebensatz.', 'exampleSentence': 'Unbestritten ist, dass sofortiges Handeln erforderlich ist.', 'grammarRule': 'Vorangestelltes Adjektiv + ist + dass', 'tags': ['satzbildung', 'stilistisch'] },
  { 'language': 'german', 'id': 'c2-satzbildung-p5-061', 'level': 'c2', 'category': 'Satzbildung', 'subcategory': 'Literarische Satzbildung', 'question': 'Welcher Satz ist grammatisch richtig?', 'options': ['Fürwahr war dies ein denkwürdiger Moment.', 'Fürwahr dies war ein denkwürdiger Moment.', 'Fürwahr war ein denkwürdiger Moment dies.', 'Dies fürwahr war ein denkwürdiger Moment.'], 'correctAnswer': 0, 'explanation': 'Fürwahr (= wahrhaftig) + Inversion: war + dies.', 'exampleSentence': 'Fürwahr war dies ein denkwürdiger Moment.', 'grammarRule': 'Archaische Bekräftigung mit Inversion', 'tags': ['satzbildung', 'literarisch'] }
];

export default questions;
