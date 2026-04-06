import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-001',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Umso dringlicher ist es, Maßnahmen zu ergreifen.',
      'Umso dringlicher es ist, Maßnahmen zu ergreifen.',
      'Umso dringlicher ist, es Maßnahmen zu ergreifen.',
      'Umso es ist dringlicher, Maßnahmen zu ergreifen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach umso + Komparativ im Vorfeld steht das Verb an zweiter Stelle: ist es.',
    'exampleSentence': 'Umso dringlicher ist es, Maßnahmen zu ergreifen.',
    'grammarRule': 'Wortstellung: umso + Komparativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-002',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Enteignung privaten Eigentums ist verfassungswidrig.',
      'Die Enteignung privates Eigentum ist verfassungswidrig.',
      'Die Enteignung privatem Eigentums ist verfassungswidrig.',
      'Die Enteignung privaten Eigentums sind verfassungswidrig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Enteignung + Genitiv (privaten Eigentums). Subjekt Singular → ist.',
    'exampleSentence': 'Die Enteignung privaten Eigentums ist verfassungswidrig.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-003',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der vom Verlag herausgegebene Sammelband enthält 20 Beiträge.',
      'Der vom Verlag herausgegebenen Sammelband enthält 20 Beiträge.',
      'Der vom Verlag herausgegebener Sammelband enthält 20 Beiträge.',
      'Der vom Verlag herausgebende Sammelband enthält 20 Beiträge.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II: herausgegebene (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der vom Verlag herausgegebene Sammelband enthält 20 Beiträge.',
    'grammarRule': 'Erweitertes Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-004',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Premierminister betonte, sein Land bleibe dem Bündnis treu.',
      'Der Premierminister betonte, sein Land bleibt dem Bündnis treu.',
      'Der Premierminister betonte, sein Land bleibe dem Bündnis treu bleibt.',
      'Der Premierminister betonte, sein Land bliebe dem Bündnis treu.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: bleibe (3. Person Singular von bleiben).',
    'exampleSentence': 'Der Premierminister betonte, sein Land bleibe dem Bündnis treu.',
    'grammarRule': 'Konjunktiv I: bleiben → bleibe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-005',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Problematik lässt sich nicht auf einen Faktor reduzieren.',
      'Die Problematik lässt nicht sich auf einen Faktor reduzieren.',
      'Die Problematik lässt sich nicht auf einen Faktor zu reduzieren.',
      'Die Problematik lässt sich nicht auf einen Faktor reduziert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lässt sich reduzieren (= kann reduziert werden).',
    'exampleSentence': 'Die Problematik lässt sich nicht auf einen Faktor reduzieren.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-006',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insofern die Bedingungen erfüllt sind, kann eine Genehmigung erteilt werden.',
      'Insofern die Bedingungen erfüllt sind, eine Genehmigung kann erteilt werden.',
      'Insofern die Bedingungen sind erfüllt, kann eine Genehmigung erteilt werden.',
      'Insofern die Bedingungen erfüllt sind, kann erteilt werden eine Genehmigung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konditionalsatz mit insofern: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Insofern die Bedingungen erfüllt sind, kann eine Genehmigung erteilt werden.',
    'grammarRule': 'Satzgefüge: insofern + Konditionalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-007',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat Beschwerde gegen das Urteil eingelegt.',
      'Sie hat Beschwerde gegen das Urteil gemacht.',
      'Sie hat Beschwerde gegen das Urteil genommen.',
      'Sie hat Beschwerde gegen das Urteil gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Beschwerde einlegen gegen + Akkusativ (= sich beschweren).',
    'exampleSentence': 'Sie hat Beschwerde gegen das Urteil eingelegt.',
    'grammarRule': 'Funktionsverbgefüge: Beschwerde einlegen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-008',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Laut des Vertrags sind beide Parteien zur Geheimhaltung verpflichtet.',
      'Laut dem Vertrag sind beide Parteien zur Geheimhaltung verpflichtet.',
      'Laut den Vertrag sind beide Parteien zur Geheimhaltung verpflichtet.',
      'Laut ein Vertrag sind beide Parteien zur Geheimhaltung verpflichtet.'
    ],
    'correctAnswer': 1,
    'explanation': 'Laut wird standardsprachlich mit Dativ verwendet: laut dem Vertrag.',
    'exampleSentence': 'Laut dem Vertrag sind beide Parteien zur Geheimhaltung verpflichtet.',
    'grammarRule': 'Präposition laut + Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-009',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insbesondere gilt es, die Schwächsten zu schützen.',
      'Insbesondere es gilt, die Schwächsten zu schützen.',
      'Insbesondere gilt, es die Schwächsten zu schützen.',
      'Insbesondere die Schwächsten gilt es zu schützen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach insbesondere im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Insbesondere gilt es, die Schwächsten zu schützen.',
    'grammarRule': 'Wortstellung nach Adverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-010',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Einbeziehung aller Stakeholder ist von großer Bedeutung.',
      'Die Einbeziehung allen Stakeholdern ist von großer Bedeutung.',
      'Die Einbeziehung alle Stakeholder ist von großer Bedeutung.',
      'Die Einbeziehung aller Stakeholder sind von großer Bedeutung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Einbeziehung + Genitiv Plural (aller Stakeholder). Subjekt Singular → ist.',
    'exampleSentence': 'Die Einbeziehung aller Stakeholder ist von großer Bedeutung.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-011',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die von der Kommission vorgeschlagenen Reformen sind weitreichend.',
      'Die von der Kommission vorgeschlagene Reformen sind weitreichend.',
      'Die von der Kommission vorgeschlagener Reformen sind weitreichend.',
      'Die von der Kommission vorschlagende Reformen sind weitreichend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Erweitertes Partizip II Plural: vorgeschlagenen (Nominativ Plural mit bestimmtem Artikel: -en).',
    'exampleSentence': 'Die von der Kommission vorgeschlagenen Reformen sind weitreichend.',
    'grammarRule': 'Erweitertes Partizip II Plural als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-012',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Professor erklärte, diese Theorie gelte als überholt.',
      'Der Professor erklärte, diese Theorie gilt als überholt.',
      'Der Professor erklärte, diese Theorie gelte als überholt gilt.',
      'Der Professor erklärte, diese Theorie gälte als überholt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: gelte (3. Person Singular von gelten).',
    'exampleSentence': 'Der Professor erklärte, diese Theorie gelte als überholt.',
    'grammarRule': 'Konjunktiv I: gelten → gelte',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-013',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ergebnisse sind mit Vorsicht zu interpretieren.',
      'Die Ergebnisse sind mit Vorsicht interpretieren zu.',
      'Die Ergebnisse sind mit Vorsicht zu interpretiert.',
      'Die Ergebnisse sind mit Vorsicht interpretieren.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind zu interpretieren (= müssen interpretiert werden).',
    'exampleSentence': 'Die Ergebnisse sind mit Vorsicht zu interpretieren.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-014',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstatt dass er zur Ruhe kam, arbeitete er weiter.',
      'Anstatt dass er zur Ruhe kam, er arbeitete weiter.',
      'Anstatt dass er kam zur Ruhe, arbeitete er weiter.',
      'Anstatt dass er zur Ruhe kam, arbeitete weiter er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Substitutivsatz mit anstatt dass: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Anstatt dass er zur Ruhe kam, arbeitete er weiter.',
    'grammarRule': 'Satzgefüge: anstatt dass',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-015',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Redner hat scharfe Kritik an der Politik geübt.',
      'Der Redner hat scharfe Kritik an der Politik gemacht.',
      'Der Redner hat scharfe Kritik an der Politik genommen.',
      'Der Redner hat scharfe Kritik an der Politik gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Kritik üben an + Dativ (= kritisieren).',
    'exampleSentence': 'Der Redner hat scharfe Kritik an der Politik geübt.',
    'grammarRule': 'Funktionsverbgefüge: Kritik üben an',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-016',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Halber der Gerechtigkeit muss dieser Fall neu aufgerollt werden.',
      'Der Gerechtigkeit halber muss dieser Fall neu aufgerollt werden.',
      'Die Gerechtigkeit halber muss dieser Fall neu aufgerollt werden.',
      'Dem Gerechtigkeit halber muss dieser Fall neu aufgerollt werden.'
    ],
    'correctAnswer': 1,
    'explanation': 'Halber steht nachgestellt mit Genitiv: der Gerechtigkeit halber.',
    'exampleSentence': 'Der Gerechtigkeit halber muss dieser Fall neu aufgerollt werden.',
    'grammarRule': 'Nachgestellte Präposition halber + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-017',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Jedenfalls steht fest, dass Handlungsbedarf besteht.',
      'Jedenfalls fest steht, dass Handlungsbedarf besteht.',
      'Jedenfalls steht, fest dass Handlungsbedarf besteht.',
      'Jedenfalls dass Handlungsbedarf besteht, steht fest.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach jedenfalls im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Jedenfalls steht fest, dass Handlungsbedarf besteht.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-018',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Herstellung der Produkte erfolgt unter strengen Auflagen.',
      'Die Herstellung den Produkten erfolgt unter strengen Auflagen.',
      'Die Herstellung der Produkte erfolgen unter strengen Auflagen.',
      'Die Herstellung die Produkte erfolgt unter strengen Auflagen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Herstellung + Genitiv Plural (der Produkte). Subjekt Singular → erfolgt.',
    'exampleSentence': 'Die Herstellung der Produkte erfolgt unter strengen Auflagen.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-019',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die stetig wachsende Bevölkerung stellt das Land vor Probleme.',
      'Die stetig wachsenden Bevölkerung stellt das Land vor Probleme.',
      'Die stetig wachsender Bevölkerung stellt das Land vor Probleme.',
      'Die stetig gewachsene Bevölkerung stellt das Land vor Probleme.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Attribut: wachsende (Nominativ feminin Singular mit bestimmtem Artikel: -e). Partizip I für andauernden Prozess.',
    'exampleSentence': 'Die stetig wachsende Bevölkerung stellt das Land vor Probleme.',
    'grammarRule': 'Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-020',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Wissenschaftler erklärte, die Studie belege einen Zusammenhang.',
      'Der Wissenschaftler erklärte, die Studie belegt einen Zusammenhang.',
      'Der Wissenschaftler erklärte, die Studie belege einen Zusammenhang belegt.',
      'Der Wissenschaftler erklärte, die Studie belegte einen Zusammenhang.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: belege (3. Person Singular von belegen).',
    'exampleSentence': 'Der Wissenschaftler erklärte, die Studie belege einen Zusammenhang.',
    'grammarRule': 'Konjunktiv I: belegen → belege',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-021',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Angaben sind sorgfältig zu prüfen.',
      'Die Angaben sind sorgfältig prüfen zu.',
      'Die Angaben sind sorgfältig zu geprüft.',
      'Die Angaben sind sorgfältig prüfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sein + zu + Infinitiv: sind zu prüfen (= müssen geprüft werden).',
    'exampleSentence': 'Die Angaben sind sorgfältig zu prüfen.',
    'grammarRule': 'Passiversatzform: sein + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-022',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Solange keine bessere Lösung vorliegt, bleibt alles beim Alten.',
      'Solange keine bessere Lösung vorliegt, alles bleibt beim Alten.',
      'Solange keine bessere Lösung vorliegt, beim Alten bleibt alles.',
      'Solange vorliegt keine bessere Lösung, bleibt alles beim Alten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Temporalsatz mit solange: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Solange keine bessere Lösung vorliegt, bleibt alles beim Alten.',
    'grammarRule': 'Satzgefüge: solange + Temporalsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-023',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat Bezug auf den früheren Beschluss genommen.',
      'Er hat Bezug auf den früheren Beschluss gemacht.',
      'Er hat Bezug auf den früheren Beschluss gestellt.',
      'Er hat Bezug auf den früheren Beschluss gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: Bezug nehmen auf + Akkusativ (= sich beziehen auf).',
    'exampleSentence': 'Er hat Bezug auf den früheren Beschluss genommen.',
    'grammarRule': 'Funktionsverbgefüge: Bezug nehmen auf',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-024',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Trotz des erbitterten Widerstands wurde die Reform durchgesetzt.',
      'Trotz dem erbitterten Widerstand wurde die Reform durchgesetzt.',
      'Trotz des erbitterten Widerstand wurde die Reform durchgesetzt.',
      'Trotz den erbitterten Widerstands wurde die Reform durchgesetzt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Trotz verlangt den Genitiv: trotz des erbitterten Widerstands.',
    'exampleSentence': 'Trotz des erbitterten Widerstands wurde die Reform durchgesetzt.',
    'grammarRule': 'Präposition trotz + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-025',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vielmehr sollte man das Problem an der Wurzel packen.',
      'Vielmehr man sollte das Problem an der Wurzel packen.',
      'Vielmehr sollte das Problem an der Wurzel packen man.',
      'Vielmehr das Problem sollte man an der Wurzel packen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach vielmehr im Vorfeld steht das finite Verb an zweiter Stelle (Inversion).',
    'exampleSentence': 'Vielmehr sollte man das Problem an der Wurzel packen.',
    'grammarRule': 'Wortstellung nach Konjunktionaladverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-026',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Vermittlung grundlegender Kompetenzen ist Aufgabe der Schule.',
      'Die Vermittlung grundlegenden Kompetenzen ist Aufgabe der Schule.',
      'Die Vermittlung grundlegende Kompetenzen ist Aufgabe der Schule.',
      'Die Vermittlung grundlegender Kompetenzen sind Aufgabe der Schule.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Vermittlung + Genitiv Plural (grundlegender Kompetenzen). Subjekt Singular → ist.',
    'exampleSentence': 'Die Vermittlung grundlegender Kompetenzen ist Aufgabe der Schule.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-027',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ein gut funktionierendes System bedarf keiner ständigen Kontrolle.',
      'Ein gut funktionierenden System bedarf keiner ständigen Kontrolle.',
      'Ein gut funktionierender System bedarf keiner ständigen Kontrolle.',
      'Ein gut funktioniertem System bedarf keiner ständigen Kontrolle.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I als Attribut: funktionierendes (Nominativ neutrum Singular mit unbestimmtem Artikel: -es).',
    'exampleSentence': 'Ein gut funktionierendes System bedarf keiner ständigen Kontrolle.',
    'grammarRule': 'Partizip I als Attribut mit unbestimmtem Artikel',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-028',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Sprecherin sagte, die Regierung beabsichtige, das Gesetz zu ändern.',
      'Die Sprecherin sagte, die Regierung beabsichtigt, das Gesetz zu ändern.',
      'Die Sprecherin sagte, die Regierung beabsichtige, das Gesetz zu ändern beabsichtigt.',
      'Die Sprecherin sagte, die Regierung beabsichtigte, das Gesetz zu ändern.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: beabsichtige (3. Person Singular von beabsichtigen).',
    'exampleSentence': 'Die Sprecherin sagte, die Regierung beabsichtige, das Gesetz zu ändern.',
    'grammarRule': 'Konjunktiv I: beabsichtigen → beabsichtige',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-029',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bleibt zu klären, wer die Verantwortung trägt.',
      'Es bleibt klären, wer die Verantwortung trägt.',
      'Es bleibt zu klären zu, wer die Verantwortung trägt.',
      'Es bleibt geklärt, wer die Verantwortung trägt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: bleiben + zu + Infinitiv: bleibt zu klären (= muss noch geklärt werden).',
    'exampleSentence': 'Es bleibt zu klären, wer die Verantwortung trägt.',
    'grammarRule': 'Passiversatzform: bleiben + zu + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-030',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Obwohl viel Geld investiert wurde, blieben die Ergebnisse hinter den Erwartungen zurück.',
      'Obwohl viel Geld investiert wurde, die Ergebnisse blieben hinter den Erwartungen zurück.',
      'Obwohl viel Geld wurde investiert, blieben die Ergebnisse hinter den Erwartungen zurück.',
      'Obwohl viel Geld investiert wurde, blieben hinter den Erwartungen die Ergebnisse zurück.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konzessivsatz mit obwohl: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Obwohl viel Geld investiert wurde, blieben die Ergebnisse hinter den Erwartungen zurück.',
    'grammarRule': 'Satzgefüge: obwohl + Konzessivsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-031',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat eine Klage gegen das Unternehmen erhoben.',
      'Er hat eine Klage gegen das Unternehmen gemacht.',
      'Er hat eine Klage gegen das Unternehmen genommen.',
      'Er hat eine Klage gegen das Unternehmen gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: eine Klage erheben gegen + Akkusativ (= klagen).',
    'exampleSentence': 'Er hat eine Klage gegen das Unternehmen erhoben.',
    'grammarRule': 'Funktionsverbgefüge: eine Klage erheben',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-032',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Infolge mangelnder Wartung kam es zu einem Ausfall.',
      'Infolge mangelnden Wartung kam es zu einem Ausfall.',
      'Infolge mangelnde Wartung kam es zu einem Ausfall.',
      'Infolge mangelndem Wartung kam es zu einem Ausfall.'
    ],
    'correctAnswer': 0,
    'explanation': 'Infolge verlangt den Genitiv: infolge mangelnder Wartung (Genitiv feminin ohne Artikel).',
    'exampleSentence': 'Infolge mangelnder Wartung kam es zu einem Ausfall.',
    'grammarRule': 'Präposition infolge + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-033',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ebenso verhält es sich mit dem zweiten Argument.',
      'Ebenso es verhält sich mit dem zweiten Argument.',
      'Ebenso verhält mit dem zweiten Argument es sich.',
      'Ebenso sich verhält es mit dem zweiten Argument.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach ebenso im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Ebenso verhält es sich mit dem zweiten Argument.',
    'grammarRule': 'Wortstellung nach Adverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-034',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Ablehnung des Antrags wurde schriftlich mitgeteilt.',
      'Die Ablehnung dem Antrag wurde schriftlich mitgeteilt.',
      'Die Ablehnung des Antrags wurden schriftlich mitgeteilt.',
      'Die Ablehnung den Antrags wurde schriftlich mitgeteilt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Ablehnung + Genitiv (des Antrags). Subjekt Singular → wurde.',
    'exampleSentence': 'Die Ablehnung des Antrags wurde schriftlich mitgeteilt.',
    'grammarRule': 'Nominalstil mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-035',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die noch zu klärende Frage betrifft die Finanzierung.',
      'Die noch zu klärenden Frage betrifft die Finanzierung.',
      'Die noch zu klärender Frage betrifft die Finanzierung.',
      'Die noch zu geklärte Frage betrifft die Finanzierung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: zu klärende (Nominativ feminin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Die noch zu klärende Frage betrifft die Finanzierung.',
    'grammarRule': 'Gerundiv: zu + Partizip I als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-036',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Insider berichtete, das Unternehmen plane einen Börsengang.',
      'Der Insider berichtete, das Unternehmen plant einen Börsengang.',
      'Der Insider berichtete, das Unternehmen plane einen Börsengang plant.',
      'Der Insider berichtete, das Unternehmen plante einen Börsengang.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: plane (3. Person Singular von planen).',
    'exampleSentence': 'Der Insider berichtete, das Unternehmen plane einen Börsengang.',
    'grammarRule': 'Konjunktiv I: planen → plane',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-037',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Vorgehensweise gilt als vorbildlich.',
      'Die Vorgehensweise gilt als vorbildliche.',
      'Die Vorgehensweise gilt für vorbildlich.',
      'Die Vorgehensweise gilt wie vorbildlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gelten als + Adjektiv (prädikativ): gilt als vorbildlich.',
    'exampleSentence': 'Die Vorgehensweise gilt als vorbildlich.',
    'grammarRule': 'Gelten als + Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-038',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wohingegen die erste Methode schneller ist, liefert die zweite genauere Ergebnisse.',
      'Wohingegen die erste Methode schneller ist, die zweite liefert genauere Ergebnisse.',
      'Wohingegen die erste Methode ist schneller, liefert die zweite genauere Ergebnisse.',
      'Wohingegen die erste Methode schneller ist, liefert genauere Ergebnisse die zweite.'
    ],
    'correctAnswer': 0,
    'explanation': 'Adversativsatz mit wohingegen: Nebensatz mit Verb am Ende, Hauptsatz mit Inversion.',
    'exampleSentence': 'Wohingegen die erste Methode schneller ist, liefert die zweite genauere Ergebnisse.',
    'grammarRule': 'Satzgefüge: wohingegen + Adversativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-039',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Problem wurde in den Vordergrund gerückt.',
      'Das Problem wurde in den Vordergrund gebracht.',
      'Das Problem wurde in den Vordergrund genommen.',
      'Das Problem wurde in den Vordergrund gezogen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: etwas in den Vordergrund rücken (= betonen).',
    'exampleSentence': 'Das Problem wurde in den Vordergrund gerückt.',
    'grammarRule': 'Funktionsverbgefüge: in den Vordergrund rücken',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-040',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Anstelle des geplanten Neubaus wird das alte Gebäude renoviert.',
      'Anstelle dem geplanten Neubau wird das alte Gebäude renoviert.',
      'Anstelle des geplanten Neubau wird das alte Gebäude renoviert.',
      'Anstelle den geplanten Neubaus wird das alte Gebäude renoviert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Anstelle verlangt den Genitiv: anstelle des geplanten Neubaus.',
    'exampleSentence': 'Anstelle des geplanten Neubaus wird das alte Gebäude renoviert.',
    'grammarRule': 'Präposition anstelle + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-041',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Kurzum, es muss gehandelt werden.',
      'Kurzum, gehandelt werden muss es.',
      'Kurzum, es gehandelt werden muss.',
      'Kurzum, muss es gehandelt werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach kurzum als einleitendem Wort folgt ein Hauptsatz mit normaler Wortstellung.',
    'exampleSentence': 'Kurzum, es muss gehandelt werden.',
    'grammarRule': 'Wortstellung nach einleitendem Adverb',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-042',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Neuregelung der Zuständigkeiten tritt ab Januar in Kraft.',
      'Die Neuregelung den Zuständigkeiten tritt ab Januar in Kraft.',
      'Die Neuregelung der Zuständigkeiten treten ab Januar in Kraft.',
      'Die Neuregelung die Zuständigkeiten tritt ab Januar in Kraft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Neuregelung + Genitiv Plural (der Zuständigkeiten). Subjekt Singular → tritt.',
    'exampleSentence': 'Die Neuregelung der Zuständigkeiten tritt ab Januar in Kraft.',
    'grammarRule': 'Nominalstil mit Genitiv Plural',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-043',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Partizipien',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der international renommierte Forscher erhielt den Preis.',
      'Der international renommierten Forscher erhielt den Preis.',
      'Der international renommierter Forscher erhielt den Preis.',
      'Der international renommierende Forscher erhielt den Preis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II als Attribut: renommierte (Nominativ maskulin Singular mit bestimmtem Artikel: -e).',
    'exampleSentence': 'Der international renommierte Forscher erhielt den Preis.',
    'grammarRule': 'Partizip II als Attribut',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-044',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Konjunktiv I',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie verlautet, solle der Minister zurücktreten.',
      'Wie verlautet, soll der Minister zurücktreten.',
      'Wie verlautet, solle der Minister zurücktreten soll.',
      'Wie verlautet, sollte der Minister zurücktreten.'
    ],
    'correctAnswer': 0,
    'explanation': 'Konjunktiv I in indirekter Rede: solle (3. Person Singular von sollen).',
    'exampleSentence': 'Wie verlautet, solle der Minister zurücktreten.',
    'grammarRule': 'Konjunktiv I: sollen → solle',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-045',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Passiversatzformen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Vertrag lässt sich jederzeit kündigen.',
      'Der Vertrag lässt jederzeit sich kündigen.',
      'Der Vertrag lässt sich jederzeit zu kündigen.',
      'Der Vertrag lässt sich jederzeit gekündigt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Passiversatzform: sich lassen + Infinitiv: lässt sich kündigen (= kann gekündigt werden).',
    'exampleSentence': 'Der Vertrag lässt sich jederzeit kündigen.',
    'grammarRule': 'Passiversatzform: sich lassen + Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-046',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Satzgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wie bereits ausgeführt, bedarf die Angelegenheit einer sorgfältigen Prüfung.',
      'Wie bereits ausgeführt, die Angelegenheit bedarf einer sorgfältigen Prüfung.',
      'Wie ausgeführt bereits, bedarf die Angelegenheit einer sorgfältigen Prüfung.',
      'Wie bereits ausgeführt, bedarf einer sorgfältigen Prüfung die Angelegenheit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach der Wendung wie bereits ausgeführt steht das Verb im Hauptsatz an zweiter Stelle (Inversion).',
    'exampleSentence': 'Wie bereits ausgeführt, bedarf die Angelegenheit einer sorgfältigen Prüfung.',
    'grammarRule': 'Wortstellung nach eingeschobener Wendung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-047',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Funktionsverbgefüge',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Verhandlungen haben zu einem Ergebnis geführt.',
      'Die Verhandlungen haben zu einem Ergebnis gebracht.',
      'Die Verhandlungen haben zu einem Ergebnis genommen.',
      'Die Verhandlungen haben zu einem Ergebnis gestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Funktionsverbgefüge: zu einem Ergebnis führen (= ergeben).',
    'exampleSentence': 'Die Verhandlungen haben zu einem Ergebnis geführt.',
    'grammarRule': 'Funktionsverbgefüge: zu einem Ergebnis führen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-048',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Kasus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Zugunsten des Angeklagten wurde auf eine Strafe verzichtet.',
      'Zugunsten dem Angeklagten wurde auf eine Strafe verzichtet.',
      'Zugunsten des Angeklagtem wurde auf eine Strafe verzichtet.',
      'Zugunsten den Angeklagten wurde auf eine Strafe verzichtet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Zugunsten verlangt den Genitiv: zugunsten des Angeklagten.',
    'exampleSentence': 'Zugunsten des Angeklagten wurde auf eine Strafe verzichtet.',
    'grammarRule': 'Präposition zugunsten + Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-049',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Schließlich und endlich muss eine Entscheidung getroffen werden.',
      'Schließlich und endlich eine Entscheidung muss getroffen werden.',
      'Schließlich und endlich muss getroffen werden eine Entscheidung.',
      'Schließlich und endlich getroffen werden muss eine Entscheidung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach schließlich und endlich im Vorfeld steht das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Schließlich und endlich muss eine Entscheidung getroffen werden.',
    'grammarRule': 'Wortstellung nach Adverb im Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c1-satzkorrektur-p10-050',
    'level': 'c1',
    'category': 'Satzkorrektur',
    'subcategory': 'Nominalstil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Vereinbarkeit von Familie und Beruf bleibt eine Herausforderung.',
      'Die Vereinbarkeit von Familie und Beruf bleiben eine Herausforderung.',
      'Die Vereinbarkeit von Familien und Berufe bleibt eine Herausforderung.',
      'Die Vereinbarkeit von Familie und Beruf bleibt einen Herausforderung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nominalstil: Vereinbarkeit von + Dativ. Subjekt Singular → bleibt. Herausforderung ist feminin → eine.',
    'exampleSentence': 'Die Vereinbarkeit von Familie und Beruf bleibt eine Herausforderung.',
    'grammarRule': 'Nominalstil: Vereinbarkeit von + Dativ',
    'tags': ['satzkorrektur']
  }
];

export default questions;
