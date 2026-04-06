import { Question } from '@/types/question';

const questions: Question[] = [
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-001', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'das Kind, ___ dort spielt\' (neutrum Nominativ)', 'options': ['das', 'deren', 'dem', 'wo'], 'correctAnswer': 0, 'explanation': 'Das Relativpronomen ist \'das\' (neutrum Nominativ).', 'grammarRule': 'Relativpronomen: Genus/Numerus vom Bezugswort, Kasus vom Verb im Nebensatz', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-002', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Wo steht das konjugierte Verb im Relativsatz?', 'options': ['auf Position 2', 'am Ende des Relativsatzes', 'direkt nach dem Relativpronomen', 'vor dem Relativpronomen'], 'correctAnswer': 1, 'explanation': 'Wie in allen Nebensätzen steht das Verb am Ende des Relativsatzes.', 'exampleSentence': 'Der Mann, der dort steht, ist mein Freund.', 'grammarRule': 'Relativsatz = Nebensatz -> Verb am Ende', 'subcategory': 'Verbposition', 'tags': ['relativsaetze', 'verbposition'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-009', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'die Stadt, ___ ich fahre\' (Richtungsangabe)', 'options': ['wo', 'dessen', 'dem', 'wohin'], 'correctAnswer': 3, 'explanation': 'Das Relativpronomen ist \'wohin\' (Richtungsangabe).', 'grammarRule': 'Relativpronomen: Genus/Numerus vom Bezugswort, Kasus vom Verb im Nebensatz', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-011', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'die Frau, ___ dort steht\' (feminin Nominativ)', 'options': ['wohin', 'dem', 'der', 'die'], 'correctAnswer': 3, 'explanation': 'Das Relativpronomen ist \'die\' (feminin Nominativ).', 'grammarRule': 'Relativpronomen: Genus/Numerus vom Bezugswort, Kasus vom Verb im Nebensatz', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-015', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'der Mann, ___ ich helfe\' (maskulin Dativ)', 'options': ['deren', 'dem', 'die', 'wohin'], 'correctAnswer': 1, 'explanation': 'Das Relativpronomen ist \'dem\' (maskulin Dativ).', 'grammarRule': 'Relativpronomen: Genus/Numerus vom Bezugswort, Kasus vom Verb im Nebensatz', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-017', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'die Frau, ___ Buch ich lese\' (feminin Genitiv)', 'options': ['dem', 'deren', 'wohin', 'die'], 'correctAnswer': 1, 'explanation': 'Das Relativpronomen ist \'deren\' (feminin Genitiv).', 'grammarRule': 'Relativpronomen: Genus/Numerus vom Bezugswort, Kasus vom Verb im Nebensatz', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-022', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'die Leute, ___ ich eingeladen habe\' (Plural Akkusativ)', 'options': ['denen', 'die', 'deren', 'dem'], 'correctAnswer': 1, 'explanation': '\'die\' ist das Relativpronomen im Plural Akkusativ.', 'grammarRule': 'Plural Relativpronomen: Nom./Akk. = die, Dat. = denen, Gen. = deren', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-023', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'die Kollegen, ___ ich gedankt habe\' (Plural Dativ)', 'options': ['die', 'denen', 'deren', 'den'], 'correctAnswer': 1, 'explanation': '\'denen\' ist das Relativpronomen im Plural Dativ (danken + Dativ).', 'grammarRule': 'Plural Dativ Relativpronomen = denen', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-026', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Ergänzen Sie: \'Das ist die Frau, für ___ ich arbeite.\' (feminin Akkusativ)', 'options': ['der', 'die', 'deren', 'dem'], 'correctAnswer': 1, 'explanation': '\'die\' ist das Relativpronomen im feminin Akkusativ (für + Akkusativ).', 'grammarRule': 'Präposition bestimmt den Kasus des Relativpronomens', 'subcategory': 'Relativpronomen wählen', 'tags': ['relativsaetze', 'pronomen'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-033', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Wo steht die Präposition im Relativsatz mit Präposition?', 'options': ['Am Ende des Relativsatzes', 'Vor dem Relativpronomen', 'Nach dem Verb', 'An beliebiger Stelle'], 'correctAnswer': 1, 'explanation': 'Die Präposition steht vor dem Relativpronomen: \'...in dem, für die, mit dem\'.', 'grammarRule': 'Präposition + Relativpronomen am Anfang des Relativsatzes', 'subcategory': 'Satzstellung', 'tags': ['relativsaetze', 'satzstellung'] },
  { 'language': 'german', 'id': 'b1-relativsaetze-p2-039', 'level': 'b1', 'category': 'Relativsätze', 'question': 'Wann verwendet man \'wo\' statt eines Relativpronomens?', 'options': ['Bei Personen', 'Bei Ortsangaben (Städte, Länder, Orte)', 'Bei Zeitangaben', 'Bei abstrakten Begriffen'], 'correctAnswer': 1, 'explanation': '\'wo\' kann bei Ortsangaben das Relativpronomen ersetzen: \'Die Stadt, wo ich wohne.\'', 'grammarRule': 'wo = Ortsangabe, wohin = Richtung, woher = Herkunft', 'subcategory': 'Regel', 'tags': ['relativsaetze', 'regel'] },
  {
    'language': 'german', 'id': 'b1-relativsaetze-p2-044',
    'level': 'b1',
    'category': 'Relativsätze',
    'question': 'Ergänzen Sie: \'der Mann, ___ dort steht\' (maskulin Nominativ)',
    'options': [
      'den',
      'der',
      'dessen',
      'dem'
    ],
    'correctAnswer': 1,
    'explanation': '\'der\' ist das Relativpronomen für maskulin Nominativ.',
    'grammarRule': 'Maskulin Nominativ: der',
    'subcategory': 'Relativpronomen wählen',
    'tags': [
      'relativsaetze',
      'pronomen'
    ]
  },
  {
    'language': 'german', 'id': 'b1-relativsaetze-p2-059',
    'level': 'b1',
    'category': 'Relativsätze',
    'question': 'Wo steht das Verb im Relativsatz \'Der Mann, der dort steht, ist mein Freund.\'?',
    'options': [
      'am Ende des Relativsatzes',
      'direkt nach dem Relativpronomen',
      'auf Position 2',
      'vor dem Komma'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Relativsatz steht das Verb am Ende.',
    'grammarRule': 'Relativsatz = Nebensatz: Verb am Ende',
    'subcategory': 'Verbposition',
    'tags': [
      'relativsaetze',
      'verbposition'
    ]
  },
  {
    'language': 'german', 'id': 'b1-relativsaetze-p2-060',
    'level': 'b1',
    'category': 'Relativsätze',
    'question': 'Welcher Satzteil ist der Relativsatz: \'Die Frau, die dort wohnt, ist nett.\'?',
    'options': [
      'Die Frau',
      'die dort wohnt',
      'ist nett',
      'Die Frau ist nett'
    ],
    'correctAnswer': 1,
    'explanation': '\'die dort wohnt\' ist der Relativsatz.',
    'grammarRule': 'Der Relativsatz steht zwischen Kommas',
    'subcategory': 'Satzstellung',
    'tags': [
      'relativsaetze',
      'satzstellung'
    ]
  },
  {
    'language': 'german', 'id': 'b1-relativsaetze-p2-069',
    'level': 'b1',
    'category': 'Relativsätze',
    'question': 'Welches Wort leitet einen Relativsatz ein?',
    'options': [
      'weil',
      'dass',
      'der/die/das',
      'ob'
    ],
    'correctAnswer': 2,
    'explanation': 'Relativsätze werden durch Relativpronomen (der/die/das) eingeleitet.',
    'grammarRule': 'Relativpronomen leiten Relativsätze ein',
    'subcategory': 'Regel',
    'tags': [
      'relativsaetze',
      'regel'
    ]
  }
];

export default questions;
