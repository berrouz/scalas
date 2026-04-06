import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-009',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt: \'Wo wohnst du?\'',
    'options': [
      'Sie sagt, sie habe Hunger.',
      'Er fragt, wo sie wohne.',
      'Er sagt, er habe das Buch gelesen.',
      'Sie sagt, sie koenne kommen.'
    ],
    'correctAnswer': 1,
    'explanation': 'In der indirekten Rede: W-Frage -> W-Wort + K.I.',
    'grammarRule': 'Indirekte Rede: Konjunktiv I. Wenn = Indikativ -> Konjunktiv II als Ersatz.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-010',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Warum verwendet man in der indirekten Rede manchmal Konjunktiv II statt Konjunktiv I?',
    'options': [
      'Wenn Konjunktiv I mit dem Indikativ identisch ist.',
      'Wenn der Satz besonders lang ist.',
      'Wenn man hoeflich sein moechte.',
      'Wenn es sich um eine Frage handelt.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.II wird als Ersatzform verwendet, wenn K.I = Indikativ (z.B. sie haben = sie haben).',
    'grammarRule': 'K.I = Indikativ -> Konjunktiv II als Ersatz (z.B. sie haetten statt sie haben).',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-011',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Schueler sagen: \'Wir haben die Aufgaben gemacht.\'',
    'options': [
      'Die Schueler sagen, sie haetten die Aufgaben gemacht.',
      'Die Schueler sagen, sie haben die Aufgaben gemacht.',
      'Die Schueler sagen, sie habe die Aufgaben gemacht.',
      'Die Schueler sagen, sie hatten die Aufgaben gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von haben (1. Pl.) = haben = Indikativ, daher Ersatz: haetten (K.II).',
    'grammarRule': 'Wenn K.I = Indikativ, verwendet man K.II: haben -> haetten.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-012',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Die Mitarbeiter sagen, sie ___ mit der Entscheidung nicht einverstanden.',
    'options': [
      'seien',
      'sind',
      'waeren',
      'sein'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von sein (3. Pl.) = seien (verschieden vom Indikativ sind).',
    'grammarRule': 'sein: K.I Plural = seien (nicht identisch mit Indikativ sind).',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-013',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er behauptet: \'Ich habe das Geld nicht gestohlen.\'',
    'options': [
      'Er behauptet, er habe das Geld nicht gestohlen.',
      'Er behauptet, er hat das Geld nicht gestohlen.',
      'Er behauptet, er haette das Geld nicht gestohlen.',
      'Er behauptet, er stahl das Geld nicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'behaupten als Einleitungsverb; habe gestohlen (K.I Perfekt).',
    'grammarRule': 'Verschiedene Einleitungsverben: behaupten, erklaeren, meinen + K.I.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'redeverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-014',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Nachbarn sagen: \'Wir hoeren oft Laerm.\'',
    'options': [
      'Die Nachbarn sagen, sie hoerten oft Laerm.',
      'Die Nachbarn sagen, sie hoeren oft Laerm.',
      'Die Nachbarn sagen, sie hoere oft Laerm.',
      'Die Nachbarn sagen, sie gehoert oft Laerm.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von hoeren (3. Pl.) = hoeren = Indikativ, daher K.II: hoerten.',
    'grammarRule': 'K.I = Indikativ -> K.II als Ersatz: hoeren -> hoerten.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-015',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Er meint, er ___ das Problem loesen.',
    'options': [
      'koenne',
      'kann',
      'koennte',
      'konnte'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von koennen (3. Sg.) = koenne (verschieden von Indikativ kann).',
    'grammarRule': 'Modalverben im K.I: koennen -> koenne.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-016',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Die Regierung erklaert: \'Wir werden Massnahmen ergreifen.\'',
    'options': [
      'Die Regierung erklaert, sie werde Massnahmen ergreifen.',
      'Die Regierung erklaert, sie werden Massnahmen ergreifen.',
      'Die Regierung erklaert, sie wuerden Massnahmen ergreifen.',
      'Die Regierung erklaert, sie ergreifen Massnahmen.'
    ],
    'correctAnswer': 2,
    'explanation': 'K.I von werden (3. Pl.) = werden = Indikativ, daher K.II: wuerden.',
    'grammarRule': 'K.I = Indikativ -> K.II als Ersatz: werden -> wuerden.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-017',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Der Zeuge gibt an, er ___ den Unfall beobachtet.',
    'options': [
      'habe',
      'hat',
      'haette',
      'hatte'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von haben (3. Sg.) = habe (verschieden von Indikativ hat).',
    'grammarRule': 'haben im K.I: er habe (eindeutig, kein Ersatz noetig).',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-018',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er versichert: \'Ich werde puenktlich sein.\'',
    'options': [
      'Er versichert, er werde puenktlich sein.',
      'Er versichert, er wird puenktlich sein.',
      'Er versichert, er wuerde puenktlich sein.',
      'Er versichert, er ist puenktlich.'
    ],
    'correctAnswer': 0,
    'explanation': 'werde ist K.I von werden (3. Sg.), eindeutig verschieden von wird.',
    'grammarRule': 'werden im K.I: er werde (eindeutig).',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'futur']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-019',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Studenten sagen: \'Wir brauchen mehr Zeit.\'',
    'options': [
      'Die Studenten sagen, sie brauchten mehr Zeit.',
      'Die Studenten sagen, sie brauchen mehr Zeit.',
      'Die Studenten sagen, sie brauche mehr Zeit.',
      'Die Studenten sagen, sie gebraucht mehr Zeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I (3. Pl.) = brauchen = Indikativ, daher K.II: brauchten.',
    'grammarRule': 'K.I = Indikativ -> K.II als Ersatz.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-020',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Der Angeklagte beteuert, er ___ unschuldig.',
    'options': [
      'sei',
      'ist',
      'waere',
      'war'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von sein (3. Sg.) = sei (eindeutig verschieden von ist).',
    'grammarRule': 'sein im K.I: er sei (immer eindeutig).',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-021',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Praesident betont: \'Die Wirtschaft waechst.\'',
    'options': [
      'Der Praesident betont, die Wirtschaft wachse.',
      'Der Praesident betont, die Wirtschaft waechst.',
      'Der Praesident betont, die Wirtschaft wuechse.',
      'Der Praesident betont, die Wirtschaft wuchs.'
    ],
    'correctAnswer': 0,
    'explanation': 'wachse ist K.I von wachsen (3. Sg.); kein Umlaut im K.I.',
    'grammarRule': 'K.I hat keinen Umlaut: wachsen -> wachse.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-022',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Zeugen berichten: \'Wir sahen einen roten Wagen.\'',
    'options': [
      'Die Zeugen berichten, sie haetten einen roten Wagen gesehen.',
      'Die Zeugen berichten, sie sahen einen roten Wagen.',
      'Die Zeugen berichten, sie haben einen roten Wagen gesehen.',
      'Die Zeugen berichten, sie sehen einen roten Wagen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Praeteritum -> K.I Perfekt; K.I haben (3. Pl.) = Indikativ, daher K.II: haetten.',
    'grammarRule': 'Praeteritum -> K.I/K.II Perfekt. K.I = Indikativ -> K.II als Ersatz.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-023',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Der Arzt sagt, der Patient ___ sich mehr bewegen.',
    'options': [
      'solle',
      'soll',
      'sollte',
      'muss'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von sollen (3. Sg.) = solle (verschieden von Indikativ soll).',
    'grammarRule': 'Modalverben im K.I: sollen -> solle.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-024',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie gibt man eine indirekte Aufforderung mit moegen wieder?',
    'options': [
      'Er bittet, man moege ihm helfen.',
      'Er bittet, man muss ihm helfen.',
      'Er bittet, man hat ihm geholfen.',
      'Er bittet, man hilft ihm.'
    ],
    'correctAnswer': 0,
    'explanation': 'Indirekte Aufforderungen: moegen im K.I (moege) + Infinitiv.',
    'grammarRule': 'Formelle indirekte Aufforderung: moegen im K.I (moege/moegen).',
    'subcategory': 'Indirekte Aufforderungen',
    'tags': ['indirekte-rede', 'indirekte-aufforderungen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-025',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Sprecher erklaert: \'Es gibt keine Alternative.\'',
    'options': [
      'Der Sprecher erklaert, es gebe keine Alternative.',
      'Der Sprecher erklaert, es gibt keine Alternative.',
      'Der Sprecher erklaert, es gaebe keine Alternative.',
      'Der Sprecher erklaert, es gab keine Alternative.'
    ],
    'correctAnswer': 0,
    'explanation': 'gebe ist K.I von geben (3. Sg., es gebe).',
    'grammarRule': 'es gibt -> es gebe (K.I).',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-026',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Frage: Er fragt mich: \'Hast du den Bericht gelesen?\'',
    'options': [
      'Er fragt mich, ob ich den Bericht gelesen habe.',
      'Er fragt mich, dass ich den Bericht gelesen habe.',
      'Er fragt mich, ob ich den Bericht gelesen hatte.',
      'Er fragt mich, habe ich den Bericht gelesen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Ja/Nein-Frage: ob + K.I; du -> ich (Sprecher berichtet ueber sich selbst).',
    'grammarRule': 'Pronomen richten sich nach der Perspektive des Berichtenden.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-027',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Die Firma teilt mit, sie ___ 100 neue Stellen schaffen.',
    'options': [
      'werde',
      'wird',
      'wuerde',
      'wurde'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von werden (3. Sg.) = werde (verschieden von wird). Die Firma = sie (Sg.).',
    'grammarRule': 'werden im K.I: er/sie/es werde.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'futur']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-028',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Eltern sagen: \'Wir wissen nicht, was passiert ist.\'',
    'options': [
      'Die Eltern sagen, sie wuessten nicht, was passiert sei.',
      'Die Eltern sagen, sie wissen nicht, was passiert ist.',
      'Die Eltern sagen, sie wisse nicht, was passiert sei.',
      'Die Eltern sagen, sie wussten nicht, was passiert war.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I wissen (3. Pl.) = wissen = Indikativ, daher K.II: wuessten; passiert sei (K.I).',
    'grammarRule': 'Verschachtelte indirekte Rede: Haupt- und Nebensatz im K.I/K.II.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-029',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Minister sagt: \'Man muss handeln.\'',
    'options': [
      'Der Minister sagt, man muesse handeln.',
      'Der Minister sagt, man muss handeln.',
      'Der Minister sagt, man muesste handeln.',
      'Der Minister sagt, man musste handeln.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von muessen (3. Sg. mit man) = muesse.',
    'grammarRule': 'Modalverben im K.I: muessen -> muesse.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-030',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Sie berichtet: \'Ich hatte Angst.\'',
    'options': [
      'Sie berichtet, sie habe Angst gehabt.',
      'Sie berichtet, sie hatte Angst.',
      'Sie berichtet, sie haette Angst gehabt.',
      'Sie berichtet, sie hat Angst.'
    ],
    'correctAnswer': 0,
    'explanation': 'Praeteritum (hatte) -> K.I Perfekt: habe gehabt.',
    'grammarRule': 'Praeteritum -> K.I Perfekt in der indirekten Rede.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-031',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Er erwaehnt, sein Kollege ___ seit drei Jahren in Japan.',
    'options': [
      'lebe',
      'lebt',
      'lebte',
      'gelebt'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von leben (3. Sg.) = lebe (verschieden von Indikativ lebt).',
    'grammarRule': 'K.I 3. Person Singular: Stamm + e.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-032',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Kollegen meinen: \'Wir koennen das Projekt rechtzeitig abschliessen.\'',
    'options': [
      'Die Kollegen meinen, sie koennten das Projekt rechtzeitig abschliessen.',
      'Die Kollegen meinen, sie koennen das Projekt rechtzeitig abschliessen.',
      'Die Kollegen meinen, sie koenne das Projekt rechtzeitig abschliessen.',
      'Die Kollegen meinen, sie konnten das Projekt rechtzeitig abschliessen.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I koennen (3. Pl.) = koennen = Indikativ, daher K.II: koennten.',
    'grammarRule': 'K.I = Indikativ -> K.II als Ersatz: koennen -> koennten.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-033',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Richter fragt: \'Was haben Sie am Abend des 5. Juni gemacht?\'',
    'options': [
      'Der Richter fragt, was er am Abend des 5. Juni gemacht habe.',
      'Der Richter fragt, was er am Abend des 5. Juni gemacht hat.',
      'Der Richter fragt, ob er am Abend des 5. Juni etwas gemacht habe.',
      'Der Richter fragt, was hat er am Abend des 5. Juni gemacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'W-Frage: was bleibt; haben gemacht -> habe gemacht (K.I Perfekt); Sie -> er.',
    'grammarRule': 'W-Fragen mit Perfekt in der indirekten Rede.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-034',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Konjunktiv-I-Form ist fuer du korrekt: wissen?',
    'options': [
      'wissest',
      'weisst',
      'wusstest',
      'wuesstest'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I 2. Person Singular: Stamm + est. wissen -> wiss- + est = wissest.',
    'grammarRule': 'K.I Endungen: ich -e, du -est, er -e, wir -en, ihr -et, sie -en.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-035',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er gesteht: \'Ich habe gelogen.\'',
    'options': [
      'Er gesteht, er habe gelogen.',
      'Er gesteht, er hat gelogen.',
      'Er gesteht, er haette gelogen.',
      'Er gesteht, er log.'
    ],
    'correctAnswer': 0,
    'explanation': 'gestehen als Einleitungsverb; habe gelogen (K.I Perfekt).',
    'grammarRule': 'Verschiedene Einleitungsverben: gestehen, zugeben, einraeumen + K.I.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'redeverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-036',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Anwohner klagen: \'Wir muessen den Laerm ertragen.\'',
    'options': [
      'Die Anwohner klagen, sie muessten den Laerm ertragen.',
      'Die Anwohner klagen, sie muessen den Laerm ertragen.',
      'Die Anwohner klagen, sie muesse den Laerm ertragen.',
      'Die Anwohner klagen, sie mussten den Laerm ertragen.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I muessen (3. Pl.) = muessen = Indikativ, daher K.II: muessten.',
    'grammarRule': 'K.I = Indikativ -> K.II: muessen -> muessten.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-037',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede mit verschachteltem Nebensatz: Er sagt: \'Ich glaube, dass sie recht hat.\'',
    'options': [
      'Er sagt, er glaube, dass sie recht habe.',
      'Er sagt, er glaube, dass sie recht hat.',
      'Er sagt, er glaubt, dass sie recht habe.',
      'Er sagt, er glaube, dass sie recht haette.'
    ],
    'correctAnswer': 0,
    'explanation': 'Beide Verben im K.I: glaube, habe. Der Nebensatz bleibt auch im K.I.',
    'grammarRule': 'Bei verschachtelten Saetzen bleiben alle Verben im K.I.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'nebensaetze']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-038',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Die Sprecherin teilt mit, die Verhandlungen ___ gut.',
    'options': [
      'liefen',
      'laufen',
      'laufe',
      'gelaufen'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von laufen (3. Pl.) = laufen = Indikativ, daher K.II: liefen.',
    'grammarRule': 'K.I = Indikativ -> K.II: laufen -> liefen.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-039',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Experte warnt: \'Die Lage ist ernst.\'',
    'options': [
      'Der Experte warnt, die Lage sei ernst.',
      'Der Experte warnt, die Lage ist ernst.',
      'Der Experte warnt, die Lage waere ernst.',
      'Der Experte warnt, die Lage war ernst.'
    ],
    'correctAnswer': 0,
    'explanation': 'sei ist K.I von sein (3. Sg.); die Lage als Subjekt.',
    'grammarRule': 'sein im K.I: er/sie/es sei.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-040',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Aufforderung: Der Chef sagt zu ihm: \'Erledigen Sie das sofort!\'',
    'options': [
      'Der Chef sagt, er moege das sofort erledigen.',
      'Der Chef sagt, erledigen Sie das sofort.',
      'Der Chef sagt, er erledigt das sofort.',
      'Der Chef sagt, dass erledigen sofort.'
    ],
    'correctAnswer': 0,
    'explanation': 'Formelle Aufforderung -> moegen im K.I (moege) + Infinitiv.',
    'grammarRule': 'Indirekte Aufforderungen: moegen (K.I) oder sollen (K.I) + Infinitiv.',
    'subcategory': 'Indirekte Aufforderungen',
    'tags': ['indirekte-rede', 'indirekte-aufforderungen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-041',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er gibt zu: \'Ich habe einen Fehler gemacht.\'',
    'options': [
      'Er gibt zu, er habe einen Fehler gemacht.',
      'Er gibt zu, er hat einen Fehler gemacht.',
      'Er gibt zu, er haette einen Fehler gemacht.',
      'Er gibt zu, er machte einen Fehler.'
    ],
    'correctAnswer': 0,
    'explanation': 'zugeben als Einleitungsverb; habe gemacht (K.I Perfekt).',
    'grammarRule': 'zugeben, eingestehen, einraeumen als Einleitungsverben.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'redeverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-042',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche K.I-Form ist fuer ihr korrekt: gehen?',
    'options': [
      'gehet',
      'geht',
      'ginget',
      'gegangen'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I 2. Person Plural: Stamm + et. gehen -> geh- + et = gehet.',
    'grammarRule': 'K.I Endungen: ihr -et (selten verwendet, aber korrekt).',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-043',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Die Polizei berichtet: \'Der Verdaechtige ist geflohen.\'',
    'options': [
      'Die Polizei berichtet, der Verdaechtige sei geflohen.',
      'Die Polizei berichtet, der Verdaechtige ist geflohen.',
      'Die Polizei berichtet, der Verdaechtige waere geflohen.',
      'Die Polizei berichtet, der Verdaechtige floh.'
    ],
    'correctAnswer': 0,
    'explanation': 'sei geflohen ist K.I Perfekt mit sein.',
    'grammarRule': 'Perfekt mit sein in der indirekten Rede: sei + Partizip II.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-044',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Teilnehmer sagen: \'Wir wollen eine Loesung finden.\'',
    'options': [
      'Die Teilnehmer sagen, sie wollten eine Loesung finden.',
      'Die Teilnehmer sagen, sie wollen eine Loesung finden.',
      'Die Teilnehmer sagen, sie wolle eine Loesung finden.',
      'Die Teilnehmer sagen, sie gewollt eine Loesung finden.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I wollen (3. Pl.) = wollen = Indikativ, daher K.II: wollten.',
    'grammarRule': 'K.I = Indikativ -> K.II: wollen -> wollten.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-045',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Der Sprecher erklaert, die Reform ___ notwendig.',
    'options': [
      'sei',
      'ist',
      'waere',
      'war'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von sein (3. Sg.) = sei. Die Reform = sie (Sg.).',
    'grammarRule': 'sein im K.I: er/sie/es sei.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-046',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er fragt seinen Kollegen: \'Koenntest du mir den Bericht schicken?\'',
    'options': [
      'Er fragt seinen Kollegen, ob er ihm den Bericht schicken koenne.',
      'Er fragt seinen Kollegen, ob er ihm den Bericht schicken koennte.',
      'Er fragt seinen Kollegen, ob er ihm den Bericht schicken kann.',
      'Er fragt seinen Kollegen, dass er ihm den Bericht schicken koenne.'
    ],
    'correctAnswer': 0,
    'explanation': 'Auch hoefliche Fragen werden mit ob + K.I wiedergegeben; koenne statt koennte.',
    'grammarRule': 'In der indirekten Rede wird K.II -> K.I zurueckgefuehrt, wenn moeglich.',
    'subcategory': 'Indirekte Fragen',
    'tags': ['indirekte-rede', 'indirekte-fragen', 'modalverben']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-047',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Der Wissenschaftler stellt fest: \'Die Ergebnisse bestaetigen die Hypothese.\'',
    'options': [
      'Der Wissenschaftler stellt fest, die Ergebnisse bestaetigten die Hypothese.',
      'Der Wissenschaftler stellt fest, die Ergebnisse bestaetigen die Hypothese.',
      'Der Wissenschaftler stellt fest, die Ergebnisse bestaetigt die Hypothese.',
      'Der Wissenschaftler stellt fest, die Ergebnisse bestaetigt habe die Hypothese.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I bestaetigen (3. Pl.) = bestaetigen = Indikativ, daher K.II: bestaetigten.',
    'grammarRule': 'K.I = Indikativ -> K.II als Ersatz.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-048',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich wuerde gern mitkommen.\'',
    'options': [
      'Er sagt, er wuerde gern mitkommen.',
      'Er sagt, er komme gern mit.',
      'Er sagt, er wolle gern mitkommen.',
      'Er sagt, er moege gern mitkommen.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.II im direkten Zitat bleibt K.II in der indirekten Rede.',
    'grammarRule': 'Wenn das Original K.II enthaelt (wuerde), bleibt K.II erhalten.',
    'subcategory': 'Umformung',
    'tags': ['indirekte-rede', 'konjunktiv-ii']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-049',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Welche Form ist korrekt: Sie berichtet, ihr Mann ___ oft auf Geschaeftsreise.',
    'options': [
      'sei',
      'ist',
      'waere',
      'war'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I von sein (3. Sg.) = sei (eindeutig verschieden von ist).',
    'grammarRule': 'sein im K.I: er sei.',
    'subcategory': 'Konjunktiv I Formen',
    'tags': ['indirekte-rede', 'konjunktiv-i']
  },
  {
    'language': 'german', 'id': 'b2-indirekte-rede-p1-050',
    'level': 'b2',
    'category': 'Indirekte Rede',
    'question': 'Wie lautet die korrekte Ersatzform: Die Buerger fordern: \'Wir duerfen nicht laenger warten.\'',
    'options': [
      'Die Buerger fordern, sie duerften nicht laenger warten.',
      'Die Buerger fordern, sie duerfen nicht laenger warten.',
      'Die Buerger fordern, sie duerfe nicht laenger warten.',
      'Die Buerger fordern, sie durften nicht laenger warten.'
    ],
    'correctAnswer': 0,
    'explanation': 'K.I duerfen (3. Pl.) = duerfen = Indikativ, daher K.II: duerften.',
    'grammarRule': 'K.I = Indikativ -> K.II: duerfen -> duerften.',
    'subcategory': 'Ersatzformen',
    'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen']
  },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-051', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Welche Form ist korrekt: Er erklaert, die Aufgabe ___ schwierig.', 'options': ['sei', 'ist', 'waere', 'war'], 'correctAnswer': 0, 'explanation': 'K.I von sein (3. Sg.) = sei.', 'grammarRule': 'sein im K.I: sie sei.', 'subcategory': 'Konjunktiv I Formen', 'tags': ['indirekte-rede', 'konjunktiv-i'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-052', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Wie lautet die Ersatzform: Die Schueler sagen: \'Wir lernen fleissig.\'', 'options': ['Die Schueler sagen, sie lernten fleissig.', 'Die Schueler sagen, sie lernen fleissig.', 'Die Schueler sagen, sie lerne fleissig.', 'Die Schueler sagen, sie gelernt fleissig.'], 'correctAnswer': 0, 'explanation': 'K.I lernen (3. Pl.) = lernen = Indikativ, daher K.II: lernten.', 'grammarRule': 'K.I = Indikativ -> K.II als Ersatz.', 'subcategory': 'Ersatzformen', 'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-053', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Frage: Er fragt: \'Soll ich das Fenster schliessen?\'', 'options': ['Er fragt, ob er das Fenster schliessen solle.', 'Er fragt, ob er das Fenster schliessen soll.', 'Er fragt, dass er das Fenster schliessen solle.', 'Er fragt, ob er das Fenster schliessen sollte.'], 'correctAnswer': 0, 'explanation': 'Ja/Nein-Frage: ob + K.I (solle).', 'grammarRule': 'Indirekte Fragen mit Modalverben: ob + K.I.', 'subcategory': 'Indirekte Fragen', 'tags': ['indirekte-rede', 'indirekte-fragen', 'modalverben'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-054', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Rede: Er sagt: \'Ich wurde befördert.\'', 'options': ['Er sagt, er sei befoerdert worden.', 'Er sagt, er wurde befoerdert.', 'Er sagt, er waere befoerdert worden.', 'Er sagt, er ist befoerdert worden.'], 'correctAnswer': 0, 'explanation': 'Passiv Praeteritum -> K.I Perfekt Passiv: sei befoerdert worden.', 'grammarRule': 'Passiv Praeteritum -> K.I Perfekt Passiv.', 'subcategory': 'Umformung', 'tags': ['indirekte-rede', 'konjunktiv-i', 'passiv'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-055', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Welche Form ist korrekt: Er meint, die Idee ___ vielversprechend.', 'options': ['sei', 'ist', 'waere', 'war'], 'correctAnswer': 0, 'explanation': 'K.I von sein (3. Sg.) = sei.', 'grammarRule': 'sein im K.I: sie sei.', 'subcategory': 'Konjunktiv I Formen', 'tags': ['indirekte-rede', 'konjunktiv-i'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-056', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Wie lautet die Ersatzform: Die Vertreter sagen: \'Wir fordern eine Nachbesserung.\'', 'options': ['Die Vertreter sagen, sie forderten eine Nachbesserung.', 'Die Vertreter sagen, sie fordern eine Nachbesserung.', 'Die Vertreter sagen, sie fordere eine Nachbesserung.', 'Die Vertreter sagen, sie gefordert eine Nachbesserung.'], 'correctAnswer': 0, 'explanation': 'K.I fordern (3. Pl.) = fordern = Indikativ, daher K.II: forderten.', 'grammarRule': 'K.I = Indikativ -> K.II als Ersatz.', 'subcategory': 'Ersatzformen', 'tags': ['indirekte-rede', 'konjunktiv-ii', 'ersatzformen'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-057', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Rede: Er fragt: \'Darf ich hier parken?\'', 'options': ['Er fragt, ob er dort parken duerfe.', 'Er fragt, ob er dort parken darf.', 'Er fragt, dass er dort parken duerfe.', 'Er fragt, ob er dort parken durfte.'], 'correctAnswer': 0, 'explanation': 'Ja/Nein-Frage: ob + K.I (duerfe); hier -> dort.', 'grammarRule': 'Ja/Nein-Fragen mit Modalverben + Perspektivwechsel.', 'subcategory': 'Indirekte Fragen', 'tags': ['indirekte-rede', 'indirekte-fragen', 'modalverben'] },
  { 'language': 'german', 'id': 'b2-indirekte-rede-p1-058', 'level': 'b2', 'category': 'Indirekte Rede', 'question': 'Wie lautet die indirekte Rede: Sie berichtet: \'Der Patient hat sich erholt.\'', 'options': ['Sie berichtet, der Patient habe sich erholt.', 'Sie berichtet, der Patient hat sich erholt.', 'Sie berichtet, der Patient haette sich erholt.', 'Sie berichtet, der Patient erholte sich.'], 'correctAnswer': 0, 'explanation': 'habe sich erholt (K.I Perfekt + Reflexivpronomen).', 'grammarRule': 'K.I Perfekt: habe + sich + Partizip II.', 'subcategory': 'Umformung', 'tags': ['indirekte-rede', 'konjunktiv-i', 'perfekt', 'reflexiv'] }
];

export default questions;
