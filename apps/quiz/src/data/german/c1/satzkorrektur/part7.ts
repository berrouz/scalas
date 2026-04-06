import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die weitreichenden Konsequenzen des Beschlusses sind nicht abzusehen.',
      'Die weitreichende Konsequenzen des Beschlusses sind nicht abzusehen.',
      'Die weitreichender Konsequenzen des Beschlusses sind nicht abzusehen.',
      'Die weitreichendem Konsequenzen des Beschlusses sind nicht abzusehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Adjektiv Plural: weitreichenden (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die weitreichenden Konsequenzen des Beschlusses sind nicht abzusehen.',
    'grammarRule': 'Partizip I als Adjektiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verlagerung der Produktion ins Ausland ist geplant.',
      'Die Verlagerung den Produktion ins Ausland ist geplant.',
      'Die Verlagerung der Produktion ins Ausland sind geplant.',
      'Die Verlagerung die Produktion ins Ausland ist geplant.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Verlagerung + Genitiv (der Produktion). Subjekt Singular → ist.',
    'exampleSentence': 'Die Verlagerung der Produktion ins Ausland ist geplant.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Geschäftsführer teilte mit, die Firma befinde sich in einer Krise.',
      'Der Geschäftsführer teilte mit, die Firma befindet sich in einer Krise.',
      'Der Geschäftsführer teilte mit, die Firma befinde sich in einer Krise befindet.',
      'Der Geschäftsführer teilte mit, die Firma befände sich in einer Krise.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: befinde (3. Person Singular von sich befinden).',
    'exampleSentence': 'Der Geschäftsführer teilte mit, die Firma befinde sich in einer Krise.',
    'grammarRule': 'Konjunktiv I: sich befinden → befinde sich',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Kosten sind kaum kalkulierbar.',
      'Die Kosten sind kaum kalkulierbare.',
      'Die Kosten sind kaum zu kalkulierbar.',
      'Die Kosten sind kaum kalkulierbarem.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform mit Adjektiv auf -bar: kalkulierbar (= kann kalkuliert werden). Prädikativ.',
    'exampleSentence': 'Die Kosten sind kaum kalkulierbar.',
    'grammarRule': 'Passiversatzform: Adjektiv auf -bar',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Falls sich herausstellen sollte, dass Fehler vorliegen, wird nachgebessert.',
      'Falls sich herausstellen sollte, dass Fehler vorliegen, nachgebessert wird.',
      'Falls sich sollte herausstellen, dass Fehler vorliegen, wird nachgebessert.',
      'Falls sich herausstellen sollte, dass vorliegen Fehler, wird nachgebessert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit falls: Verb am Ende des Nebensatzes, Hauptsatz mit Inversion.',
    'exampleSentence': 'Falls sich herausstellen sollte, dass Fehler vorliegen, wird nachgebessert.',
    'grammarRule': 'Satzgefüge: falls + Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Man hat ihm den Vorwurf gemacht, unzuverlässig zu sein.',
      'Man hat ihm den Vorwurf gestellt, unzuverlässig zu sein.',
      'Man hat ihm den Vorwurf gezogen, unzuverlässig zu sein.',
      'Man hat ihm den Vorwurf gebracht, unzuverlässig zu sein.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: jemandem einen Vorwurf machen (= vorwerfen).',
    'exampleSentence': 'Man hat ihm den Vorwurf gemacht, unzuverlässig zu sein.',
    'grammarRule': 'Funktionsverbgefüge: einen Vorwurf machen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Unterhalb des Meeresspiegels liegen viele Gebiete der Niederlande.',
      'Unterhalb dem Meeresspiegel liegen viele Gebiete der Niederlande.',
      'Unterhalb des Meeresspiegel liegen viele Gebiete der Niederlande.',
      'Unterhalb den Meeresspiegels liegen viele Gebiete der Niederlande.'
    ],
    'correctAnswer': 0,
    'explanation': 'Unterhalb verlangt den Genitiv: unterhalb des Meeresspiegels.',
    'exampleSentence': 'Unterhalb des Meeresspiegels liegen viele Gebiete der Niederlande.',
    'grammarRule': 'Präposition unterhalb + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Überdies muss beachtet werden, dass die Frist bald abläuft.',
      'Überdies beachtet werden muss, dass die Frist bald abläuft.',
      'Überdies muss werden beachtet, dass die Frist bald abläuft.',
      'Überdies dass die Frist bald abläuft, muss beachtet werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach überdies im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Überdies muss beachtet werden, dass die Frist bald abläuft.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Einschränkung persönlicher Freiheiten ist nur im Notfall zulässig.',
      'Die Einschränkung persönlichen Freiheiten ist nur im Notfall zulässig.',
      'Die Einschränkung persönliche Freiheiten ist nur im Notfall zulässig.',
      'Die Einschränkung persönlicher Freiheiten sind nur im Notfall zulässig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Einschränkung + Genitiv Plural (persönlicher Freiheiten). Subjekt Singular → ist.',
    'exampleSentence': 'Die Einschränkung persönlicher Freiheiten ist nur im Notfall zulässig.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der in der Fachwelt anerkannte Experte hielt einen Vortrag.',
      'Der in der Fachwelt anerkannten Experte hielt einen Vortrag.',
      'Der in der Fachwelt anerkannter Experte hielt einen Vortrag.',
      'Der in der Fachwelt anerkennende Experte hielt einen Vortrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: anerkannte (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der in der Fachwelt anerkannte Experte hielt einen Vortrag.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es wurde mitgeteilt, die Konferenz finde wie geplant statt.',
      'Es wurde mitgeteilt, die Konferenz findet wie geplant statt.',
      'Es wurde mitgeteilt, die Konferenz finde wie geplant statt findet.',
      'Es wurde mitgeteilt, die Konferenz fände wie geplant statt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: finde ... statt (3. Person Singular von stattfinden).',
    'exampleSentence': 'Es wurde mitgeteilt, die Konferenz finde wie geplant statt.',
    'grammarRule': 'Konjunktiv I: stattfinden → finde statt',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Bestimmungen sind strikt einzuhalten.',
      'Die Bestimmungen sind strikt einhalten.',
      'Die Bestimmungen sind strikt zu eingehalten.',
      'Die Bestimmungen sind strikt eingehalten zu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind einzuhalten (= müssen eingehalten werden).',
    'exampleSentence': 'Die Bestimmungen sind strikt einzuhalten.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Desto länger man wartet, desto schwieriger wird es.',
      'Je länger man wartet, desto schwieriger wird es.',
      'Je länger wartet man, desto schwieriger wird es.',
      'Je länger man wartet, desto wird es schwieriger.'
    ],
    'correctAnswer': 1,
    'explanation': 'Proportionalsatz: je + Komparativ ... desto + Komparativ + Verb + Subjekt. Nicht desto ... desto.',
    'exampleSentence': 'Je länger man wartet, desto schwieriger wird es.',
    'grammarRule': 'Proportionalsatz: je ... desto',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Maßnahme wurde in Kraft gesetzt.',
      'Die Maßnahme wurde in Kraft genommen.',
      'Die Maßnahme wurde in Kraft gebracht.',
      'Die Maßnahme wurde in Kraft gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in Kraft setzen (= gültig machen). Passiv: wurde in Kraft gesetzt.',
    'exampleSentence': 'Die Maßnahme wurde in Kraft gesetzt.',
    'grammarRule': 'Funktionsverbgefüge: in Kraft setzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vonseiten der Opposition wurde heftige Kritik geübt.',
      'Vonseiten den Opposition wurde heftige Kritik geübt.',
      'Vonseiten der Opposition wurden heftige Kritik geübt.',
      'Vonseiten die Opposition wurde heftige Kritik geübt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vonseiten verlangt den Genitiv: vonseiten der Opposition.',
    'exampleSentence': 'Vonseiten der Opposition wurde heftige Kritik geübt.',
    'grammarRule': 'Präposition vonseiten + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Mitnichten kann man behaupten, das Problem sei gelöst.',
      'Mitnichten man kann behaupten, das Problem sei gelöst.',
      'Mitnichten kann behaupten man, das Problem sei gelöst.',
      'Mitnichten das Problem sei gelöst, kann man behaupten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach mitnichten im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Mitnichten kann man behaupten, das Problem sei gelöst.',
    'grammarRule': 'Inversion nach negativem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Beibehaltung des bisherigen Kurses wird empfohlen.',
      'Die Beibehaltung dem bisherigen Kurs wird empfohlen.',
      'Die Beibehaltung des bisherigen Kurses werden empfohlen.',
      'Die Beibehaltung den bisherigen Kurses wird empfohlen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Beibehaltung + Genitiv (des bisherigen Kurses). Subjekt Singular → wird.',
    'exampleSentence': 'Die Beibehaltung des bisherigen Kurses wird empfohlen.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die im Internet kursierenden Gerüchte sind unbegründet.',
      'Die im Internet kursierende Gerüchte sind unbegründet.',
      'Die im Internet kursierender Gerüchte sind unbegründet.',
      'Die im Internet kursierten Gerüchte sind unbegründet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip I Plural: kursierenden (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die im Internet kursierenden Gerüchte sind unbegründet.',
    'grammarRule': 'Erweitertes Partizip I Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Sprecher erklärte, man habe alle notwendigen Schritte eingeleitet.',
      'Der Sprecher erklärte, man hat alle notwendigen Schritte eingeleitet.',
      'Der Sprecher erklärte, man habe alle notwendigen Schritte eingeleitet hat.',
      'Der Sprecher erklärte, man hätte alle notwendigen Schritte eingeleitet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I Perfekt: habe eingeleitet (indirekte Rede).',
    'exampleSentence': 'Der Sprecher erklärte, man habe alle notwendigen Schritte eingeleitet.',
    'grammarRule': 'Konjunktiv I Perfekt: habe + Partizip II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Resultate lassen sich reproduzieren.',
      'Die Resultate lassen reproduzieren sich.',
      'Die Resultate lassen sich reproduzieren zu.',
      'Die Resultate lassen sich reproduziert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lassen sich reproduzieren (= können reproduziert werden).',
    'exampleSentence': 'Die Resultate lassen sich reproduzieren.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie dem auch sei, wir müssen weitermachen.',
      'Wie dem auch sei, weitermachen wir müssen.',
      'Wie dem sei auch, wir müssen weitermachen.',
      'Wie dem auch sei, müssen wir weitermachen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessiver Ausdruck: Wie dem auch sei (feststehende Wendung), dann Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Wie dem auch sei, wir müssen weitermachen.',
    'grammarRule': 'Konzessiver Ausdruck: wie dem auch sei',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Patient hat eine rasche Genesung genommen.',
      'Der Patient hat Abschied von seinen Kollegen genommen.',
      'Der Patient hat Abschied von seinen Kollegen gemacht.',
      'Der Patient hat Abschied von seinen Kollegen gestellt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Funktionsverbgefüge: Abschied nehmen von + Dativ (= sich verabschieden).',
    'exampleSentence': 'Der Patient hat Abschied von seinen Kollegen genommen.',
    'grammarRule': 'Funktionsverbgefüge: Abschied nehmen von',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Beiderseits der Straße stehen alte Bäume.',
      'Beiderseits dem Straße stehen alte Bäume.',
      'Beiderseits den Straße stehen alte Bäume.',
      'Beiderseits die Straße stehen alte Bäume.'
    ],
    'correctAnswer': 0,
    'explanation': 'Beiderseits verlangt den Genitiv: beiderseits der Straße.',
    'exampleSentence': 'Beiderseits der Straße stehen alte Bäume.',
    'grammarRule': 'Präposition beiderseits + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Immerhin konnte ein Teilerfolg erzielt werden.',
      'Immerhin ein Teilerfolg konnte erzielt werden.',
      'Immerhin konnte erzielt werden ein Teilerfolg.',
      'Immerhin erzielt werden konnte ein Teilerfolg.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach immerhin im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Immerhin konnte ein Teilerfolg erzielt werden.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Abwägung der Vor- und Nachteile ist unerlässlich.',
      'Die Abwägung den Vor- und Nachteilen ist unerlässlich.',
      'Die Abwägung der Vor- und Nachteile sind unerlässlich.',
      'Die Abwägung die Vor- und Nachteile ist unerlässlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Abwägung + Genitiv Plural (der Vor- und Nachteile). Subjekt Singular → ist.',
    'exampleSentence': 'Die Abwägung der Vor- und Nachteile ist unerlässlich.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das von vielen als revolutionär bezeichnete Produkt wird bald eingeführt.',
      'Das von vielen als revolutionär bezeichneten Produkt wird bald eingeführt.',
      'Das von vielen als revolutionär bezeichnetes Produkt wird bald eingeführt.',
      'Das von vielen als revolutionär bezeichnende Produkt wird bald eingeführt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: bezeichnete (Nominativ neutrum Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Das von vielen als revolutionär bezeichnete Produkt wird bald eingeführt.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut dem Bericht liege die Arbeitslosenquote bei zehn Prozent.',
      'Laut dem Bericht liegt die Arbeitslosenquote bei zehn Prozent.',
      'Laut dem Bericht liege die Arbeitslosenquote bei zehn Prozent liegt.',
      'Laut dem Bericht läge die Arbeitslosenquote bei zehn Prozent.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: liege (3. Person Singular von liegen).',
    'exampleSentence': 'Laut dem Bericht liege die Arbeitslosenquote bei zehn Prozent.',
    'grammarRule': 'Konjunktiv I: liegen → liege',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Termin ist noch zu bestätigen.',
      'Der Termin ist noch bestätigen zu.',
      'Der Termin ist noch zu bestätigt.',
      'Der Termin ist noch bestätigen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: ist zu bestätigen (= muss bestätigt werden).',
    'exampleSentence': 'Der Termin ist noch zu bestätigen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Angenommen, er hätte recht, müssten wir alles ändern.',
      'Angenommen, er hätte recht, wir müssten alles ändern.',
      'Angenommen, hätte er recht, müssten wir alles ändern.',
      'Angenommen, er recht hätte, müssten wir alles ändern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit angenommen: Hauptsatzwortstellung im ersten Teil, Inversion im Hauptsatz.',
    'exampleSentence': 'Angenommen, er hätte recht, müssten wir alles ändern.',
    'grammarRule': 'Satzgefüge: angenommen + Konjunktiv II',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Erkenntnis hat ihn zum Umdenken gebracht.',
      'Die Erkenntnis hat ihn zum Umdenken genommen.',
      'Die Erkenntnis hat ihn zum Umdenken gestellt.',
      'Die Erkenntnis hat ihn zum Umdenken gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: jemanden zum Umdenken bringen (= veranlassen umzudenken).',
    'exampleSentence': 'Die Erkenntnis hat ihn zum Umdenken gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zum Umdenken bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anhand zahlreicher Beispiele wurde die These untermauert.',
      'Anhand zahlreichen Beispielen wurde die These untermauert.',
      'Anhand zahlreiche Beispiele wurde die These untermauert.',
      'Anhand zahlreichem Beispiel wurde die These untermauert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anhand verlangt den Genitiv: anhand zahlreicher Beispiele (Genitiv Plural ohne Artikel).',
    'exampleSentence': 'Anhand zahlreicher Beispiele wurde die These untermauert.',
    'grammarRule': 'Präposition anhand + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nur unter der Bedingung, dass alle zustimmen, wird der Vertrag gültig.',
      'Nur unter der Bedingung, dass alle zustimmen, der Vertrag wird gültig.',
      'Nur unter der Bedingung, dass zustimmen alle, wird der Vertrag gültig.',
      'Nur unter der Bedingung, dass alle zustimmen, wird gültig der Vertrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Nur unter der Bedingung, dass alle zustimmen, wird der Vertrag gültig.',
    'grammarRule': 'Wortstellung: Konditionalsatz + Inversion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Einhaltung der Vorschriften wird streng kontrolliert.',
      'Die Einhaltung den Vorschriften wird streng kontrolliert.',
      'Die Einhaltung der Vorschriften werden streng kontrolliert.',
      'Die Einhaltung die Vorschriften wird streng kontrolliert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Einhaltung + Genitiv Plural (der Vorschriften). Subjekt Singular → wird.',
    'exampleSentence': 'Die Einhaltung der Vorschriften wird streng kontrolliert.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein nicht zu verachtendes Detail wurde übersehen.',
      'Ein nicht zu verachtenden Detail wurde übersehen.',
      'Ein nicht zu verachtender Detail wurde übersehen.',
      'Ein nicht zu verachtendem Detail wurde übersehen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu verachtendes (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein nicht zu verachtendes Detail wurde übersehen.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er sagte, er könne die Frist nicht einhalten.',
      'Er sagte, er kann die Frist nicht einhalten.',
      'Er sagte, er könne die Frist nicht einhalten kann.',
      'Er sagte, er könnte die Frist nicht einhalten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: könne (3. Person Singular von können).',
    'exampleSentence': 'Er sagte, er könne die Frist nicht einhalten.',
    'grammarRule': 'Konjunktiv I: können → könne',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Differenzen lassen sich durch Verhandlungen beilegen.',
      'Die Differenzen lassen durch Verhandlungen sich beilegen.',
      'Die Differenzen lassen sich durch Verhandlungen zu beilegen.',
      'Die Differenzen lassen sich durch Verhandlungen beigelegt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lassen sich beilegen (= können beigelegt werden).',
    'exampleSentence': 'Die Differenzen lassen sich durch Verhandlungen beilegen.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obschon die Mittel knapp waren, gelang das Vorhaben.',
      'Obschon die Mittel knapp waren, das Vorhaben gelang.',
      'Obschon die Mittel waren knapp, gelang das Vorhaben.',
      'Obschon die Mittel knapp waren, gelang das Vorhaben gelang.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit obschon: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Obschon die Mittel knapp waren, gelang das Vorhaben.',
    'grammarRule': 'Satzgefüge: obschon + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verhandlung wurde zu Ende gebracht.',
      'Die Verhandlung wurde zu Ende genommen.',
      'Die Verhandlung wurde zu Ende gestellt.',
      'Die Verhandlung wurde zu Ende gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas zu Ende bringen (= abschließen).',
    'exampleSentence': 'Die Verhandlung wurde zu Ende gebracht.',
    'grammarRule': 'Funktionsverbgefüge: zu Ende bringen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Namens der Belegschaft wurde eine Erklärung abgegeben.',
      'Namens dem Belegschaft wurde eine Erklärung abgegeben.',
      'Namens den Belegschaft wurde eine Erklärung abgegeben.',
      'Namens die Belegschaft wurde eine Erklärung abgegeben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Namens (= im Namen) verlangt den Genitiv: namens der Belegschaft.',
    'exampleSentence': 'Namens der Belegschaft wurde eine Erklärung abgegeben.',
    'grammarRule': 'Präposition namens + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Infolgedessen mussten die Pläne geändert werden.',
      'Infolgedessen die Pläne mussten geändert werden.',
      'Infolgedessen mussten geändert werden die Pläne.',
      'Infolgedessen die Pläne geändert werden mussten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach infolgedessen im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Infolgedessen mussten die Pläne geändert werden.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zwecks Überprüfung der Angaben wird eine Frist gesetzt.',
      'Zwecks Überprüfung den Angaben wird eine Frist gesetzt.',
      'Zwecks Überprüfung der Angaben werden eine Frist gesetzt.',
      'Zwecks Überprüfung die Angaben wird eine Frist gesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: zwecks Überprüfung + Genitiv Plural (der Angaben). Subjekt Singular → wird.',
    'exampleSentence': 'Zwecks Überprüfung der Angaben wird eine Frist gesetzt.',
    'grammarRule': 'Nominalstil: zwecks + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die über Jahre hinweg aufgebaute Sammlung ist beeindruckend.',
      'Die über Jahre hinweg aufgebauten Sammlung ist beeindruckend.',
      'Die über Jahre hinweg aufgebauter Sammlung ist beeindruckend.',
      'Die über Jahre hinweg aufbauende Sammlung ist beeindruckend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: aufgebaute (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die über Jahre hinweg aufgebaute Sammlung ist beeindruckend.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ministerin sagte, sie stehe zu ihrer Entscheidung.',
      'Die Ministerin sagte, sie steht zu ihrer Entscheidung.',
      'Die Ministerin sagte, sie stehe zu ihrer Entscheidung steht.',
      'Die Ministerin sagte, sie stünde zu ihrer Entscheidung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: stehe (3. Person Singular von stehen).',
    'exampleSentence': 'Die Ministerin sagte, sie stehe zu ihrer Entscheidung.',
    'grammarRule': 'Konjunktiv I: stehen → stehe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es gilt zu berücksichtigen, dass die Umstände sich geändert haben.',
      'Es gilt berücksichtigen, dass die Umstände sich geändert haben.',
      'Es gilt zu berücksichtigen zu, dass die Umstände sich geändert haben.',
      'Es gilt berücksichtigt, dass die Umstände sich geändert haben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: es gilt + zu + Infinitiv: gilt zu berücksichtigen (= muss berücksichtigt werden).',
    'exampleSentence': 'Es gilt zu berücksichtigen, dass die Umstände sich geändert haben.',
    'grammarRule': 'Passiversatzform: es gilt + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Egal wie man es betrachtet, das Ergebnis ist enttäuschend.',
      'Egal wie man es betrachtet, enttäuschend ist das Ergebnis.',
      'Egal wie man betrachtet es, das Ergebnis ist enttäuschend.',
      'Egal wie es man betrachtet, das Ergebnis ist enttäuschend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit egal wie: Nebensatz mit Verb am Ende, Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Egal wie man es betrachtet, das Ergebnis ist enttäuschend.',
    'grammarRule': 'Satzgefüge: egal wie + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Regierung hat Anstrengungen unternommen, das Problem zu lösen.',
      'Die Regierung hat Anstrengungen gemacht, das Problem zu lösen.',
      'Die Regierung hat Anstrengungen genommen, das Problem zu lösen.',
      'Die Regierung hat Anstrengungen gestellt, das Problem zu lösen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Anstrengungen unternehmen (= sich bemühen).',
    'exampleSentence': 'Die Regierung hat Anstrengungen unternommen, das Problem zu lösen.',
    'grammarRule': 'Funktionsverbgefüge: Anstrengungen unternehmen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Halber der Vollständigkeit sei noch Folgendes erwähnt.',
      'Der Vollständigkeit halber sei noch Folgendes erwähnt.',
      'Die Vollständigkeit halber sei noch Folgendes erwähnt.',
      'Dem Vollständigkeit halber sei noch Folgendes erwähnt.'
    ],
    'correctAnswer': 1,
    'explanation': 'Halber steht nachgestellt mit Genitiv: der Vollständigkeit halber.',
    'exampleSentence': 'Der Vollständigkeit halber sei noch Folgendes erwähnt.',
    'grammarRule': 'Nachgestellte Präposition halber + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Lediglich ein kleiner Teil der Befragten stimmte zu.',
      'Lediglich stimmte ein kleiner Teil der Befragten zu.',
      'Lediglich ein kleiner Teil der Befragten zu stimmte.',
      'Lediglich zu stimmte ein kleiner Teil der Befragten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Lediglich modifiziert das Subjekt. Verb an zweiter Stelle: stimmte zu.',
    'exampleSentence': 'Lediglich ein kleiner Teil der Befragten stimmte zu.',
    'grammarRule': 'Wortstellung mit Fokuspartikel lediglich',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Stärkung des Zusammenhalts ist das Ziel der Initiative.',
      'Die Stärkung dem Zusammenhalt ist das Ziel der Initiative.',
      'Die Stärkung des Zusammenhalts sind das Ziel der Initiative.',
      'Die Stärkung den Zusammenhalts ist das Ziel der Initiative.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Stärkung + Genitiv (des Zusammenhalts). Subjekt Singular → ist.',
    'exampleSentence': 'Die Stärkung des Zusammenhalts ist das Ziel der Initiative.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p7-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die auf Nachhaltigkeit ausgerichteten Strategien zeigen Wirkung.',
      'Die auf Nachhaltigkeit ausgerichtete Strategien zeigen Wirkung.',
      'Die auf Nachhaltigkeit ausgerichteter Strategien zeigen Wirkung.',
      'Die auf Nachhaltigkeit ausrichtenden Strategien zeigen Wirkung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: ausgerichteten (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die auf Nachhaltigkeit ausgerichteten Strategien zeigen Wirkung.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  }
];

export default questions;
