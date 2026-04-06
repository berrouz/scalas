import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-002', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Subjunktion passt: \'___ es regnet, bleibe ich zu Hause.\' (Gegengrund/Konzession)',
    'options': ['falls', 'während', 'obwohl', 'wenn'],
    'correctAnswer': 2,
    'explanation': 'Für Gegengrund/Konzession verwendet man \'obwohl\'.',
    'subcategory': 'Auswahl', 'tags': ['nebensaetze', 'auswahl']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-003', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Bedeutung hat die Subjunktion \'damit\'?',
    'options': ['Zweck/Absicht', 'mögliche Bedingung', 'Grund/Ursache', 'Inhalt/Tatsache'],
    'correctAnswer': 0,
    'explanation': '\'damit\' drückt Zweck/Absicht aus.',
    'exampleSentence': 'Ich lerne Deutsch, damit ich in Deutschland arbeiten kann.',
    'subcategory': 'Bedeutung', 'tags': ['nebensaetze', 'subjunktion']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-005', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'solange\' als temporale Konjunktion aus?',
    'options': ['Vorzeitigkeit', 'Dauer der Gleichzeitigkeit', 'Nachzeitigkeit', 'Anfangszeitpunkt'],
    'correctAnswer': 1,
    'explanation': '\'solange\' = für die Dauer, dass: \'Solange es regnet, bleibe ich drinnen.\'',
    'grammarRule': 'solange + Verbendstellung = Temporalsatz (Dauer)', 'subcategory': 'Temporalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-013', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was bedeutet \'trotzdem, dass\'?',
    'options': ['Grund', 'Trotz/Einräumung', 'Bedingung', 'Zweck'],
    'correctAnswer': 1,
    'explanation': '\'trotzdem, dass\' = obwohl (umgangssprachlich). Besser: \'obwohl\'.',
    'grammarRule': 'trotzdem, dass = obwohl (umgangssprachlich)', 'subcategory': 'Konzessivsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-023', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konjunktion drückt einen Zweck aus?',
    'options': ['weil', 'damit', 'obwohl', 'nachdem'],
    'correctAnswer': 1,
    'explanation': '\'damit\' drückt einen Zweck/Absicht aus (Finalsatz).',
    'grammarRule': 'damit + Verbendstellung = Finalsatz', 'subcategory': 'Finalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-029', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'wie\' als Konjunktion im Vergleich aus?',
    'options': ['Ungleichheit', 'Gleichheit', 'Zeitpunkt', 'Grund'],
    'correctAnswer': 1,
    'explanation': '\'wie\' = Gleichheit: \'so groß wie\'.',
    'grammarRule': 'wie = Vergleich (Gleichheit)', 'subcategory': 'Vergleichssatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-036', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Was drückt \'bis\' als temporale Konjunktion aus?',
    'options': ['Anfangszeitpunkt', 'Endzeitpunkt', 'Gleichzeitigkeit', 'Vorzeitigkeit'],
    'correctAnswer': 1,
    'explanation': '\'bis\' = Endzeitpunkt: \'Warte, bis ich komme.\'',
    'grammarRule': 'bis + Verbendstellung = Temporalsatz (Endzeitpunkt)', 'subcategory': 'Temporalsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-038', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Welche Konjunktion leitet einen Konsekutivsatz ein?',
    'options': ['weil', 'sodass', 'obwohl', 'damit'],
    'correctAnswer': 1,
    'explanation': '\'sodass\' drückt eine Folge/Konsequenz aus.',
    'grammarRule': 'sodass + Verbendstellung = Konsekutivsatz', 'subcategory': 'Konsekutivsatz', 'tags': ['nebensaetze', 'b2']
  },
  {
    'language': 'german', 'id': 'b2-nebensaetze-p4-048', 'level': 'b2', 'category': 'Nebensätze',
    'question': 'Ergänzen Sie: \'Sie lernt Deutsch, ___ in Deutschland zu studieren.\'',
    'options': ['ohne', 'anstatt', 'um', 'statt'],
    'correctAnswer': 2,
    'explanation': '\'um ... zu + Infinitiv\' = Finalsatz (Zweck) bei gleichem Subjekt.',
    'grammarRule': 'um ... zu + Infinitiv = Finalsatz', 'subcategory': 'Finalsatz', 'tags': ['nebensaetze', 'b2']
  },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-007', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was drückt \'als dass\' aus?', 'options': ['Vergleich', 'Zu ... als dass = negative Folge', 'Grund', 'Zeitpunkt'], 'correctAnswer': 1, 'explanation': '\'zu + Adj. + als dass\' = so sehr, dass nicht: \'Er ist zu jung, als dass er das verstünde.\'', 'grammarRule': 'zu + Adj., als dass + Konj. II = negative Konsekutive', 'subcategory': 'Konsekutivsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-022', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was drückt \'kaum dass\' aus?', 'options': ['Dauer', 'Unmittelbare zeitliche Abfolge', 'Grund', 'Konzession'], 'correctAnswer': 1, 'explanation': '\'kaum dass\' = sobald / kaum war es geschehen, da ...', 'grammarRule': 'kaum dass = unmittelbare Abfolge', 'subcategory': 'Temporalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-027', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was bedeutet \'sofern\' als Konjunktion?', 'options': ['Obwohl', 'Unter der Voraussetzung, dass', 'Sodass', 'Weil'], 'correctAnswer': 1, 'explanation': '\'sofern\' = wenn / unter der Voraussetzung, dass.', 'grammarRule': 'sofern = einschränkender Konditionalsatz', 'subcategory': 'Konditionalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-030', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Welche Konjunktion passt: \'___ mehr man liest, ___ besser schreibt man.\'', 'options': ['Weil ... deshalb', 'Je ... desto', 'Wenn ... dann', 'Obwohl ... trotzdem'], 'correctAnswer': 1, 'explanation': '\'je ... desto\' = proportionaler Zusammenhang.', 'grammarRule': 'je + Komparativ, desto + Komparativ', 'subcategory': 'Proportionalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-031', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Was drückt \'zumal\' aus?', 'options': ['Obwohl', 'Besonders da / vor allem weil', 'Damit', 'Sobald'], 'correctAnswer': 1, 'explanation': '\'zumal\' = besonders da / vor allem weil.', 'grammarRule': 'zumal = verstärkter Kausalsatz', 'subcategory': 'Kausalsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-053', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Ergänzen Sie: \'___ er auch gerufen haben mag, niemand hat ihn gehört.\'', 'options': ['Weil laut', 'So laut', 'Damit laut', 'Falls laut'], 'correctAnswer': 1, 'explanation': '\'So laut er auch gerufen haben mag\' = Konzessivsatz.', 'grammarRule': 'so + Adj./Adv. + auch = Konzessivsatz', 'subcategory': 'Konzessivsatz', 'tags': ['nebensaetze', 'b2'] },
  { 'language': 'german', 'id': 'b2-nebensaetze-p4-069', 'level': 'b2', 'category': 'Nebensätze', 'question': 'Ergänzen Sie: \'___ sicher zu gehen, hat er doppelt geprüft.\'', 'options': ['Ohne', 'Anstatt', 'Um', 'Statt'], 'correctAnswer': 2, 'explanation': '\'Um zu + Infinitiv\' = Finalsatz.', 'grammarRule': 'um zu = Finalsatz', 'subcategory': 'Finalsatz', 'tags': ['nebensaetze', 'b2'] }
];

export default questions;
