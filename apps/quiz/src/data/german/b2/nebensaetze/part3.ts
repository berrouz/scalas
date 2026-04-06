import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-007', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Subjunktion passt: \'Ich weiß nicht, ___ es heute regnet.\' (indirekte Ja/Nein-Frage)',
    'options': ['ob', 'weil', 'seit/seitdem', 'obwohl'],
    'correctAnswer': 0,
    'explanation': 'Für indirekte Ja/Nein-Frage verwendet man \'ob\'.',
    'subcategory': 'Auswahl', 'tags': ['nebensaetze', 'auswahl']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-008', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'insoweit\' aus?',
    'options': ['Zeitpunkt', 'Einschränkende Bedingung', 'Folge', 'Grund'],
    'correctAnswer': 1,
    'explanation': '\'insoweit\' = in dem Maße, wie (einschränkend).',
    'grammarRule': 'insoweit + Verbendstellung = einschränkender Konditionalsatz',
    'subcategory': 'Konditionalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-012', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'je ... desto\' aus?',
    'options': ['Grund und Folge', 'Proportionalen Zusammenhang', 'Gegensatz', 'Zeitliche Abfolge'],
    'correctAnswer': 1,
    'explanation': '\'je ... desto\' = proportionaler Zusammenhang: \'Je mehr man übt, desto besser wird man.\'',
    'grammarRule': 'je + Komparativ, desto + Komparativ = Proportionalsatz', 'subcategory': 'Proportionalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-013', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Ergänzen Sie: \'___ höher man steigt, ___ kälter wird es.\'',
    'options': ['Je ... desto', 'Weil ... deshalb', 'Wenn ... dann', 'Obwohl ... trotzdem'],
    'correctAnswer': 0,
    'explanation': '\'je ... desto\' = proportionaler Zusammenhang.',
    'grammarRule': 'je + Komparativ, desto + Komparativ = Proportionalsatz', 'subcategory': 'Proportionalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-014', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konjunktion leitet einen Wunschsatz ein?',
    'options': ['weil', 'wenn + doch/nur', 'damit', 'sodass'],
    'correctAnswer': 1,
    'explanation': '\'wenn + doch/nur + Konjunktiv II\' = Wunschsatz: \'Wenn er doch nur käme!\'',
    'grammarRule': 'wenn + doch/nur + Konjunktiv II = Wunschsatz', 'subcategory': 'Konditionalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-018', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was bedeutet \'nicht zuletzt, weil\'?',
    'options': ['Trotzdem', 'Besonders/vor allem weil', 'Ohne Grund', 'Vorher'],
    'correctAnswer': 1,
    'explanation': '\'nicht zuletzt, weil\' = besonders/vor allem weil (verstärkter Grund).',
    'grammarRule': 'nicht zuletzt, weil = verstärkter Kausalsatz', 'subcategory': 'Kausalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-020', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konjunktion drückt Art und Weise aus?',
    'options': ['weil', 'indem', 'obwohl', 'nachdem'],
    'correctAnswer': 1,
    'explanation': '\'indem\' = dadurch, dass: Art und Weise.',
    'grammarRule': 'indem + Verbendstellung = Modalsatz (Art und Weise)', 'subcategory': 'Modalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-022', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was bedeutet \'als wenn\' im Vergleich zu \'als ob\'?',
    'options': ['Kein Unterschied in der Bedeutung', '\'als wenn\' ist stärker', '\'als ob\' ist umgangssprachlich', '\'als wenn\' drückt einen Grund aus'],
    'correctAnswer': 0,
    'explanation': '\'als wenn\' = \'als ob\' = irrealer Vergleich. Kein Bedeutungsunterschied.',
    'grammarRule': 'als wenn = als ob (synonyme Varianten)', 'subcategory': 'Vergleichssatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-024', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konstruktion ersetzt \'damit\' bei gleichem Subjekt?',
    'options': ['ohne ... zu', 'anstatt ... zu', 'um ... zu', 'statt ... zu'],
    'correctAnswer': 2,
    'explanation': '\'um ... zu + Infinitiv\' ersetzt \'damit\' bei gleichem Subjekt.',
    'grammarRule': 'um ... zu + Infinitiv = Finalsatz (gleiches Subjekt)', 'subcategory': 'Finalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-026', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'soweit\' aus?',
    'options': ['Folge', 'Einschränkung (in dem Maße, wie)', 'Gegensatz', 'Zeitpunkt'],
    'correctAnswer': 1,
    'explanation': '\'soweit\' = in dem Maße, wie: \'Soweit ich weiß, ist er verreist.\'',
    'grammarRule': 'soweit + Verbendstellung = einschränkender Nebensatz', 'subcategory': 'Konditionalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-029', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konjunktion leitet einen Temporalsatz der Gleichzeitigkeit ein?',
    'options': ['nachdem', 'bevor', 'während', 'sobald'],
    'correctAnswer': 2,
    'explanation': '\'während\' drückt Gleichzeitigkeit aus.',
    'grammarRule': 'während + Verbendstellung = Temporalsatz (Gleichzeitigkeit)', 'subcategory': 'Temporalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-032', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Ergänzen Sie: \'Er verließ die Party, ___ sich zu verabschieden.\'',
    'options': ['anstatt', 'ohne', 'um', 'statt'],
    'correctAnswer': 1,
    'explanation': '\'ohne ... zu + Infinitiv\' = ohne dass er sich verabschiedete.',
    'grammarRule': 'ohne ... zu + Infinitiv = Modalsatz', 'subcategory': 'Modalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-035', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'als\' nach einem Komparativ aus?',
    'options': ['Gleichheit', 'Ungleichheit', 'Zeitpunkt', 'Grund'],
    'correctAnswer': 1,
    'explanation': '\'als\' nach Komparativ = Ungleichheit: \'besser als\'.',
    'grammarRule': 'Komparativ + als = Vergleich (Ungleichheit)', 'subcategory': 'Vergleichssatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-039', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was bedeutet \'geschweige denn, dass\'?',
    'options': ['Besonders weil', 'Noch viel weniger', 'Trotzdem', 'Obwohl'],
    'correctAnswer': 1,
    'explanation': '\'geschweige denn, dass\' = noch viel weniger/und erst recht nicht.',
    'grammarRule': 'geschweige denn, dass = steigernd verneinend', 'subcategory': 'Modalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-041', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konjunktion leitet einen Modalsatz ein (Art und Weise)?',
    'options': ['weil', 'indem', 'obwohl', 'damit'],
    'correctAnswer': 1,
    'explanation': '\'indem\' drückt die Art und Weise aus.',
    'grammarRule': 'indem + Verbendstellung = Modalsatz', 'subcategory': 'Modalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-043', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Ergänzen Sie: \'Er ging weg, ___ zu helfen.\'',
    'options': ['um', 'ohne', 'anstatt', 'statt'],
    'correctAnswer': 2,
    'explanation': '\'anstatt ... zu + Infinitiv\' = statt zu helfen.',
    'grammarRule': 'anstatt ... zu + Infinitiv = Modalsatz (Alternative)', 'subcategory': 'Modalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-046', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Tempuskombination ist korrekt bei \'nachdem\' + Hauptsatz im Präsens?',
    'options': ['Nebensatz im Präsens', 'Nebensatz im Perfekt', 'Nebensatz im Futur', 'Nebensatz im Plusquamperfekt'],
    'correctAnswer': 1,
    'explanation': 'nachdem + Perfekt → Hauptsatz im Präsens (Vorzeitigkeit).',
    'grammarRule': 'nachdem + Perfekt → Hauptsatz im Präsens', 'subcategory': 'Temporalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p3-050', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Wo steht das Verb im Nebensatz bei trennbaren Verben?',
    'options': ['Das Verb wird getrennt', 'Das Verb steht als ganzes Wort am Ende', 'Der trennbare Teil steht am Anfang', 'Es gibt keine Regel'],
    'correctAnswer': 1,
    'explanation': 'Im Nebensatz stehen trennbare Verben als ein Wort am Ende: \'...weil er aufsteht\' (nicht \'...weil er steht auf\').',
    'grammarRule': 'Im Nebensatz: trennbare Verben als ein Wort am Ende', 'subcategory': 'Verbposition', 'tags': ['nebensaetze', 'verbposition']
  },
  { 'language': 'german', 'id': 'b2-nebensaetze-p3-009', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Welche Konjunktion passt: \'Er blieb zu Hause, ___ zur Arbeit zu gehen.\'', 'options': ['um', 'ohne', 'anstatt', 'statt'], 'correctAnswer': 2, 'explanation': '\'anstatt ... zu + Infinitiv\' = statt zur Arbeit zu gehen.', 'grammarRule': 'anstatt zu = Modalsatz (Alternative)', 'subcategory': 'Modalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p3-016', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was bedeutet \'umso mehr, als\' im Satz?', 'options': ['Folge', 'Verstärkter Grund', 'Bedingung', 'Gegensatz'], 'correctAnswer': 1, 'explanation': '\'umso mehr, als\' = besonders/erst recht weil.', 'grammarRule': 'umso mehr, als = verstärkter Kausalsatz', 'subcategory': 'Kausalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p3-036', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was drückt \'es sei denn\' aus?', 'options': ['Zweck', 'Ausnahme (= außer wenn)', 'Folge', 'Grund'], 'correctAnswer': 1, 'explanation': '\'es sei denn\' = außer wenn / wenn nicht.', 'grammarRule': 'es sei denn = Konditionalsatz (Ausnahme)', 'subcategory': 'Konditionalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p3-049', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was drückt \'abgesehen davon, dass\' aus?', 'options': ['Ausnahme / Einschränkung', 'Grund', 'Zweck', 'Folge'], 'correctAnswer': 0, 'explanation': '\'abgesehen davon, dass\' = außer / wenn man davon absieht, dass.', 'grammarRule': 'abgesehen davon, dass = einschränkender Nebensatz', 'subcategory': 'Konzessivsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p3-051', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Ergänzen Sie: \'___ sie das Angebot annimmt, hängt vom Gehalt ab.\'', 'options': ['Dass', 'Ob', 'Weil', 'Damit'], 'correctAnswer': 1, 'explanation': '\'Ob\' = indirekte Frage als Subjekt.', 'grammarRule': 'ob = indirekte Frage', 'subcategory': 'Inhaltssatz', 'tags': ['nebensaetze', 'b2'] }
];

export default questions;
