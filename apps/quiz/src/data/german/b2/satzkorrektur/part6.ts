import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-002',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hätte er das vorher gewusst, wäre alles anders gelaufen.',
      'Hat er das vorher gewusst, wäre alles anders gelaufen.',
      'Hätte er das vorher gewusst, ist alles anders gelaufen.',
      'Hätte er das vorher gewusst, war alles anders gelaufen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Vergangenheitssatz: Hätte + Partizip II → wäre + Partizip II.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-003',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die E-Mail wurde an alle Mitarbeiter verschickt.',
      'Die E-Mail wurde an alle Mitarbeiter verschicken.',
      'Die E-Mail worden an alle Mitarbeiter verschickt.',
      'Die E-Mail wurde an alle Mitarbeiter verschicken worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präteritum Passiv: wurde + Partizip II (verschickt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-004',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Grund, warum er abgesagt hat, ist mir unklar.',
      'Der Grund, weshalb er abgesagt hat, ist mir unklar.',
      'Der Grund, wofür er abgesagt hat, ist mir unklar.',
      'Sowohl A als auch B sind korrekt.'
    ],
    'correctAnswer': 3,
    'explanation': 'Nach "Grund" kann man "warum" oder "weshalb" verwenden. Beide sind korrekt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-005',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich bemüht, den Termin einzuhalten.',
      'Sie hat sich bemüht, den Termin einhalten.',
      'Sie hat sich bemüht, den Termin zu einhalten.',
      'Sie hat sich bemüht, den Termin eingehalten zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": einzuhalten.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-006',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unter keinen Umständen dürfen Sie das Gebäude verlassen.',
      'Unter keinen Umständen Sie dürfen das Gebäude verlassen.',
      'Unter keinen Umständen dürfen das Gebäude Sie verlassen.',
      'Unter keinen Umständen verlassen dürfen Sie das Gebäude.'
    ],
    'correctAnswer': 0,
    'explanation': 'Negativer Ausdruck an Position 1 erfordert Inversion: dürfen Sie.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-007',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wohingegen er Sport liebt, zieht sie Musik vor.',
      'Wohingegen er Sport liebt, sie zieht Musik vor.',
      'Wohingegen liebt er Sport, zieht sie Musik vor.',
      'Wohingegen er liebt Sport, zieht sie Musik vor.'
    ],
    'correctAnswer': 0,
    'explanation': '"Wohingegen" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-008',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er gedenkt der Opfer des Krieges.',
      'Er gedenkt die Opfer des Krieges.',
      'Er gedenkt den Opfern des Krieges.',
      'Er gedenkt dem Opfer des Krieges.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gedenken" verlangt den Genitiv: der Opfer.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-009',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kurz zusammengefasst lautet das Ergebnis wie folgt.',
      'Kurz zusammenfassend lautet das Ergebnis wie folgt.',
      'Kurz zusammengefassten lautet das Ergebnis wie folgt.',
      'Kurz zusammenfassen lautet das Ergebnis wie folgt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: zusammengefasst (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-010',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er verlangte, dass man ihn in Ruhe lasse.',
      'Er verlangte, dass man ihn in Ruhe lässt.',
      'Er verlangte, dass man ihn in Ruhe ließe.',
      'Er verlangte, dass man ihn in Ruhe gelassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Rede / Forderung: Konjunktiv I: man lasse.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-011',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Fehler hätte vermieden werden können.',
      'Der Fehler hätte vermieden werden gekonnt.',
      'Der Fehler hätte vermieden geworden können.',
      'Der Fehler hätte vermeiden werden können.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv II Vergangenheit Passiv + Modalverb: hätte + Partizip II + werden + Infinitiv Modalverb.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-012',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Hotel, in dem wir übernachtet haben, war ausgezeichnet.',
      'Das Hotel, in den wir übernachtet haben, war ausgezeichnet.',
      'Das Hotel, in das wir übernachtet haben, war ausgezeichnet.',
      'Das Hotel, in die wir übernachtet haben, war ausgezeichnet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Wo? → Dativ neutrum: in dem (in dem Hotel).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-013',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Brief liegen lassen.',
      'Er hat den Brief liegen gelassen.',
      'Er hat den Brief gelegen lassen.',
      'Er hat den Brief liegen zu lassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Lassen" im Perfekt mit Ersatzinfinitiv: hat liegen lassen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-014',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf gar keinen Fall lasse ich mir das gefallen.',
      'Auf gar keinen Fall ich lasse mir das gefallen.',
      'Auf gar keinen Fall lasse mir das ich gefallen.',
      'Auf gar keinen Fall mir lasse ich das gefallen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Negativer Ausdruck an Position 1 erfordert Inversion: lasse ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-015',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sei denn, du hast einen guten Grund, musst du kommen.',
      'Es sei denn, du hast einen guten Grund, du musst kommen.',
      'Es sei denn, hast du einen guten Grund, musst du kommen.',
      'Es sei denn, du einen guten Grund hast, musst du kommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es sei denn" leitet eine Ausnahme ein. Der angeschlossene Satz hat Hauptsatzstellung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-016',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kraft seines Amtes durfte er entscheiden.',
      'Kraft seinem Amt durfte er entscheiden.',
      'Kraft seinen Amtes durfte er entscheiden.',
      'Kraft sein Amt durfte er entscheiden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Kraft" als Präposition verlangt den Genitiv: kraft seines Amtes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-017',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die rasch ansteigende Temperatur beunruhigte die Forscher.',
      'Die rasch angestiegene Temperatur beunruhigte die Forscher.',
      'Die rasch ansteigend Temperatur beunruhigte die Forscher.',
      'Die rasch ansteigen Temperatur beunruhigte die Forscher.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv (gleichzeitig, aktiv): ansteigende Temperatur.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-018',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er tut so, als verstünde er alles.',
      'Er tut so, als versteht er alles.',
      'Er tut so, als er alles verstünde.',
      'Er tut so, als verstand er alles.'
    ],
    'correctAnswer': 0,
    'explanation': '"Als" (ohne "ob") + Konjunktiv II mit Inversion: als verstünde er.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-019',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ihm ist mitgeteilt worden, dass die Stelle besetzt ist.',
      'Er ist mitgeteilt worden, dass die Stelle besetzt ist.',
      'Ihm hat mitgeteilt worden, dass die Stelle besetzt ist.',
      'Ihm ist mitteilen worden, dass die Stelle besetzt ist.'
    ],
    'correctAnswer': 0,
    'explanation': '"Mitteilen" + Dativ → Passiv mit Dativ: Ihm ist mitgeteilt worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-020',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat einen Bruder, der in den USA lebt.',
      'Er hat einen Bruder, den in den USA lebt.',
      'Er hat einen Bruder, dem in den USA lebt.',
      'Er hat einen Bruder, dessen in den USA lebt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Nominativ maskulin: der (der Bruder lebt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-021',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kinder haben den ganzen Tag draußen gespielt.',
      'Die Kinder sind den ganzen Tag draußen gespielt.',
      'Die Kinder haben den ganzen Tag draußen gespielen.',
      'Die Kinder haben den ganzen Tag draußen spielen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt von "spielen": haben + Partizip II (gespielt).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-022',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Warum er das getan hat, weiß niemand.',
      'Warum er das getan hat, niemand weiß.',
      'Warum hat er das getan, weiß niemand.',
      'Warum er hat das getan, weiß niemand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekter Fragesatz als Subjekt (Verb am Ende), dann Hauptsatz mit Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-023',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insoweit die Voraussetzungen erfüllt sind, kann der Antrag genehmigt werden.',
      'Insoweit die Voraussetzungen erfüllt sind, der Antrag kann genehmigt werden.',
      'Insoweit erfüllt sind die Voraussetzungen, kann der Antrag genehmigt werden.',
      'Insoweit die Voraussetzungen sind erfüllt, kann der Antrag genehmigt werden.'
    ],
    'correctAnswer': 0,
    'explanation': '"Insoweit" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-024',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anlässlich des Jubiläums gab es eine Feier.',
      'Anlässlich dem Jubiläum gab es eine Feier.',
      'Anlässlich den Jubiläum gab es eine Feier.',
      'Anlässlich das Jubiläum gab es eine Feier.'
    ],
    'correctAnswer': 0,
    'explanation': '"Anlässlich" verlangt den Genitiv: anlässlich des Jubiläums.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-025',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gelinde gesagt, war das eine Katastrophe.',
      'Gelinde sagend, war das eine Katastrophe.',
      'Gelinde gesagen, war das eine Katastrophe.',
      'Gelinde sagen, war das eine Katastrophe.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: gelinde gesagt (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-026',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wäre ich an seiner Stelle, würde ich anders handeln.',
      'Bin ich an seiner Stelle, würde ich anders handeln.',
      'Wäre ich an seiner Stelle, handele ich anders.',
      'Sei ich an seiner Stelle, würde ich anders handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'Irrealer Konditionalsatz ohne "wenn": Wäre ich + würde ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-027',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Dokumente sind bereits unterschrieben worden.',
      'Die Dokumente sind bereits unterschrieben geworden.',
      'Die Dokumente haben bereits unterschrieben worden.',
      'Die Dokumente sind bereits unterschreiben worden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Perfekt Passiv: sind + Partizip II + worden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-028',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Konzert, auf das ich mich freue, ist morgen.',
      'Das Konzert, auf dem ich mich freue, ist morgen.',
      'Das Konzert, auf den ich mich freue, ist morgen.',
      'Das Konzert, auf der ich mich freue, ist morgen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich freuen auf" + Akkusativ neutrum: auf das.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-029',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat versucht, sie anzurufen.',
      'Er hat versucht, sie anrufen.',
      'Er hat versucht, sie zu anrufen.',
      'Er hat versucht, sie angerufen zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trennbares Verb + "zu": anzurufen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-030',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einerseits ist die Idee gut, andererseits ist sie schwer umzusetzen.',
      'Einerseits die Idee ist gut, andererseits sie ist schwer umzusetzen.',
      'Einerseits ist gut die Idee, andererseits ist schwer umzusetzen sie.',
      'Einerseits gut ist die Idee, andererseits schwer ist sie umzusetzen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einerseits ... andererseits" als Adverbien an Position 1 erfordern Inversion.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-031',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Geschweige denn, dass er sich entschuldigt hätte.',
      'Geschweige denn, dass er sich entschuldigt hat.',
      'Geschweige denn, dass er hätte sich entschuldigt.',
      'Geschweige denn, dass sich entschuldigt er hätte.'
    ],
    'correctAnswer': 0,
    'explanation': '"Geschweige denn, dass" + Konjunktiv II (hätte) im Nebensatz (Verb am Ende).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-032',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie erfreut sich bester Gesundheit.',
      'Sie erfreut sich beste Gesundheit.',
      'Sie erfreut sich besten Gesundheit.',
      'Sie erfreut sich bestem Gesundheit.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich erfreuen" + Genitiv: bester Gesundheit.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-033',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Überwältigt von der Schönheit der Landschaft, blieb er stehen.',
      'Überwältigend von der Schönheit der Landschaft, blieb er stehen.',
      'Überwältigen von der Schönheit der Landschaft, blieb er stehen.',
      'Überwältiget von der Schönheit der Landschaft, blieb er stehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als adverbiale Bestimmung (Zustand): überwältigt.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-034',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er benahm sich, als gehöre ihm die ganze Welt.',
      'Er benahm sich, als gehört ihm die ganze Welt.',
      'Er benahm sich, als ihm die ganze Welt gehöre.',
      'Er benahm sich, als gehörte ihm die ganze Welt.'
    ],
    'correctAnswer': 3,
    'explanation': '"Als" (vergleichend irreal) + Konjunktiv II mit Inversion: als gehörte ihm.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-035',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Über den Vorfall darf nicht gesprochen werden.',
      'Über den Vorfall darf nicht sprechen werden.',
      'Über den Vorfall darf nicht gesprochen wird.',
      'Über den Vorfall darf nicht gesprochen geworden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Modalverb + Passiv: darf + Partizip II + werden.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-036',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er behauptet, davon nichts gewusst zu haben.',
      'Er behauptet, davon nichts gewusst haben.',
      'Er behauptet, davon nichts zu gewusst haben.',
      'Er behauptet, davon nichts gewusst zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infinitiv Perfekt: Partizip II + zu haben: gewusst zu haben.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-037',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gerade deshalb sollten wir vorsichtig sein.',
      'Gerade deshalb wir sollten vorsichtig sein.',
      'Gerade deshalb sollten vorsichtig wir sein.',
      'Gerade deshalb vorsichtig sollten wir sein.'
    ],
    'correctAnswer': 0,
    'explanation': '"Gerade deshalb" an Position 1 erfordert Inversion: sollten wir.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-038',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Statt dass er sich beschwerte, akzeptierte er die Situation.',
      'Statt dass er sich beschwerte, er akzeptierte die Situation.',
      'Statt dass beschwerte er sich, akzeptierte er die Situation.',
      'Statt dass er beschwerte sich, akzeptierte er die Situation.'
    ],
    'correctAnswer': 0,
    'explanation': '"Statt dass" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-039',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Seitens der Regierung gibt es keine Stellungnahme.',
      'Seitens die Regierung gibt es keine Stellungnahme.',
      'Seitens dem Regierung gibt es keine Stellungnahme.',
      'Seitens den Regierung gibt es keine Stellungnahme.'
    ],
    'correctAnswer': 0,
    'explanation': '"Seitens" verlangt den Genitiv: seitens der Regierung.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-040',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Genau betrachtet ist die Sache komplizierter.',
      'Genau betrachtend ist die Sache komplizierter.',
      'Genau betrachten ist die Sache komplizierter.',
      'Genau betrachtete ist die Sache komplizierter.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Partizipialkonstruktion: genau betrachtet (Partizip II).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-041',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ich hätte gern eine Tasse Kaffee.',
      'Ich habe gern eine Tasse Kaffee.',
      'Ich hatte gern eine Tasse Kaffee.',
      'Ich hättet gern eine Tasse Kaffee.'
    ],
    'correctAnswer': 0,
    'explanation': 'Höfliche Bestellung: Konjunktiv II: Ich hätte gern.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-042',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Brücke wird zurzeit renoviert.',
      'Die Brücke wird zurzeit renovieren.',
      'Die Brücke werden zurzeit renoviert.',
      'Die Brücke wird zurzeit renovieret.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II (renoviert).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-043',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Relativsätze',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Schüler, dessen Arbeit am besten war, bekam einen Preis.',
      'Der Schüler, deren Arbeit am besten war, bekam einen Preis.',
      'Der Schüler, dem Arbeit am besten war, bekam einen Preis.',
      'Der Schüler, wessen Arbeit am besten war, bekam einen Preis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Relativpronomen Genitiv maskulin: dessen (der Schüler → dessen Arbeit).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-044',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Verbformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Aufgabe ist schwer zu lösen.',
      'Die Aufgabe ist schwer zu gelöst.',
      'Die Aufgabe ist schwer lösen.',
      'Die Aufgabe ist schwer gelöst zu.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sein" + "zu" + Infinitiv drückt passive Möglichkeit/Notwendigkeit aus: ist zu lösen.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-045',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Erst jetzt verstehe ich, was er gemeint hat.',
      'Erst jetzt ich verstehe, was er gemeint hat.',
      'Erst jetzt verstehe, was ich er gemeint hat.',
      'Erst jetzt was verstehe ich, er gemeint hat.'
    ],
    'correctAnswer': 0,
    'explanation': '"Erst jetzt" an Position 1 erfordert Inversion: verstehe ich.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-046',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktionen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bis er fertig ist, warten wir hier.',
      'Bis er fertig ist, wir warten hier.',
      'Bis fertig er ist, warten wir hier.',
      'Bis er ist fertig, warten wir hier.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bis" leitet einen Nebensatz ein (Verb am Ende). Hauptsatz: Verb an Position 1.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-047',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Oberhalb des Dorfes liegt eine alte Burg.',
      'Oberhalb dem Dorf liegt eine alte Burg.',
      'Oberhalb den Dorf liegt eine alte Burg.',
      'Oberhalb das Dorf liegt eine alte Burg.'
    ],
    'correctAnswer': 0,
    'explanation': '"Oberhalb" verlangt den Genitiv: oberhalb des Dorfes.',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-048',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die in der Diskussion aufgeworfene Frage blieb unbeantwortet.',
      'Die in der Diskussion aufwerfende Frage blieb unbeantwortet.',
      'Die in der Diskussion aufgeworfen Frage blieb unbeantwortet.',
      'Die in der Diskussion aufworfene Frage blieb unbeantwortet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Adjektiv: aufgeworfene (die aufgeworfene Frage).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-049',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie dem auch sei, wir müssen eine Lösung finden.',
      'Wie dem auch ist, wir müssen eine Lösung finden.',
      'Wie dem auch wäre, wir müssen eine Lösung finden.',
      'Wie dem auch war, wir müssen eine Lösung finden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Feste Wendung: "Wie dem auch sei" (Konjunktiv I).',
    'tags': ['satzkorrektur', 'grammatik']
  },
  {
    'language': 'german', 'id': 'b2-satzkorrektur-p6-050',
    'level': 'b2',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiv',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das neue Gesetz wird ab nächstem Monat angewendet.',
      'Das neue Gesetz wird ab nächstem Monat anwenden.',
      'Das neue Gesetz werden ab nächstem Monat angewendet.',
      'Das neue Gesetz wird ab nächsten Monat angewendet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Präsens Passiv: wird + Partizip II. "Ab" + Dativ: ab nächstem Monat.',
    'tags': ['satzkorrektur', 'grammatik']
  }
];

export default questions;
