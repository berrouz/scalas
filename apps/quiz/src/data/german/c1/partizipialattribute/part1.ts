import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-001',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Das Dokument, das von der Behörde ausgestellt wurde, ist gültig.\'',
    'options': [
      'Das von der Behörde ausgestellte Dokument ist gültig.',
      'Das von der Behörde ausstellende Dokument ist gültig.',
      'Das von die Behörde ausgestellte Dokument ist gültig.',
      'Das von der Behörde ausgestelltes Dokument ist gültig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'ausgestellt\' + Adjektivendung -e (Nominativ, das Dokument). Option B: Partizip I statt II. Option C: falscher Kasus \'die\' statt \'der\'. Option D: falsche Endung \'-es\' statt \'-e\'.',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-002',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: Welcher Satz drückt korrekt eine Notwendigkeit aus? \'Das Problem muss sofort gelöst werden.\'',
    'options': [
      'Das sofort zu lösende Problem erfordert Aufmerksamkeit.',
      'Das sofort lösende Problem erfordert Aufmerksamkeit.',
      'Das sofort gelöste Problem erfordert Aufmerksamkeit.',
      'Das sofort zu gelöste Problem erfordert Aufmerksamkeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I drückt Notwendigkeit/Möglichkeit aus (= muss gelöst werden). Option B: fehlendes \'zu\' (nur Partizip I, keine Notwendigkeit). Option C: Partizip II drückt abgeschlossene Handlung aus. Option D: falsche Konstruktion \'zu gelöste\' statt \'zu lösende\'.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-003',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Entscheidung, die unter Berücksichtigung aller relevanten Faktoren getroffen wurde, ist endgültig.\'',
    'options': [
      'Die unter Berücksichtigung aller relevanten Faktoren getroffene Entscheidung ist endgültig.',
      'Die unter Berücksichtigung aller relevanten Faktoren treffende Entscheidung ist endgültig.',
      'Die unter Berücksichtigung aller relevanten Faktoren getroffener Entscheidung ist endgültig.',
      'Die unter Berücksichtigung alle relevanten Faktoren getroffene Entscheidung ist endgültig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'getroffen\' + Endung -e (Nominativ feminin). Option B: Partizip I statt II (die Entscheidung wurde getroffen, passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'alle\' statt \'aller\' (Genitiv Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-004',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Aufgaben, die noch erledigt werden müssen, sind zahlreich.\'',
    'options': [
      'Die noch zu erledigenden Aufgaben sind zahlreich.',
      'Die noch erledigenden Aufgaben sind zahlreich.',
      'Die noch zu erledigten Aufgaben sind zahlreich.',
      'Die noch zu erledigen Aufgaben sind zahlreich.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'erledigend\' + Endung -en (Plural). Option B: fehlendes \'zu\' (nur Partizip I). Option C: falsche Konstruktion \'zu erledigten\' (Partizip II statt I). Option D: fehlende Adjektivendung bei \'erledigen\'.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-005',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Vorschlag, der von dem seit langem in der Branche tätigen Experten vorgelegt wurde, überzeugt.\'',
    'options': [
      'Der von dem seit langem in der Branche tätigen Experten vorgelegte Vorschlag überzeugt.',
      'Der von dem seit langem in der Branche tätigen Experten vorlegende Vorschlag überzeugt.',
      'Der von dem seit langem in der Branche tätigen Experten vorgelegter Vorschlag überzeugt.',
      'Der von dem seit langem in der Branche tätige Experten vorgelegte Vorschlag überzeugt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'vorgelegt\' + Endung -e (Nominativ maskulin). Option B: Partizip I statt II (der Vorschlag wurde vorgelegt, passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'tätige\' statt \'tätigen\' (Dativ).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-006',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Der Bericht, der bis morgen abgegeben werden muss, ist fast fertig.\'',
    'options': [
      'Der bis morgen abzugebende Bericht ist fast fertig.',
      'Der bis morgen abgebende Bericht ist fast fertig.',
      'Der bis morgen abzugegebene Bericht ist fast fertig.',
      'Der bis morgen abzugeben Bericht ist fast fertig.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'ab\' + \'zu\' + \'gebend\' + Endung -e. Option B: fehlendes \'zu\' und falsches Partizip. Option C: falsche Konstruktion \'abzugegebene\'. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-007',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Maßnahmen, die von der auf internationaler Ebene agierenden Organisation ergriffen wurden, zeigen Wirkung.\'',
    'options': [
      'Die von der auf internationaler Ebene agierenden Organisation ergriffenen Maßnahmen zeigen Wirkung.',
      'Die von der auf internationaler Ebene agierenden Organisation ergreifenden Maßnahmen zeigen Wirkung.',
      'Die von der auf internationaler Ebene agierenden Organisation ergriffene Maßnahmen zeigen Wirkung.',
      'Die von der auf internationale Ebene agierenden Organisation ergriffenen Maßnahmen zeigen Wirkung.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'ergriffen\' + Endung -en (Nominativ Plural). Verschachtelte Partizipien: \'agierend\' beschreibt die Organisation. Option B: Partizip I statt II. Option C: falsche Endung \'-e\' statt \'-en\' (Plural). Option D: falscher Kasus \'internationale\' statt \'internationaler\' (Dativ feminin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-008',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Kosten, die nicht unterschätzt werden dürfen, belasten den Haushalt.\'',
    'options': [
      'Die nicht zu unterschätzenden Kosten belasten den Haushalt.',
      'Die nicht unterschätzenden Kosten belasten den Haushalt.',
      'Die nicht zu unterschätzten Kosten belasten den Haushalt.',
      'Die nicht zu unterschätzen Kosten belasten den Haushalt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'unterschätzend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion \'unterschätzten\' (Partizip II statt I). Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-009',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Wissenschaftler, der in einer bahnbrechenden, kürzlich veröffentlichten Studie zitiert wird, hält einen Vortrag.\'',
    'options': [
      'Der in einer bahnbrechenden, kürzlich veröffentlichten Studie zitierte Wissenschaftler hält einen Vortrag.',
      'Der in einer bahnbrechenden, kürzlich veröffentlichten Studie zitierende Wissenschaftler hält einen Vortrag.',
      'Der in einer bahnbrechenden, kürzlich veröffentlichten Studie zitierter Wissenschaftler hält einen Vortrag.',
      'Der in einer bahnbrechende, kürzlich veröffentlichten Studie zitierte Wissenschaftler hält einen Vortrag.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'zitiert\' + Endung -e (Nominativ maskulin). Option B: Partizip I statt II (der Wissenschaftler wird zitiert, passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'bahnbrechende\' statt \'bahnbrechenden\' (Dativ feminin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-010',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Frist, die unbedingt eingehalten werden muss, endet morgen.\'',
    'options': [
      'Die unbedingt einzuhaltende Frist endet morgen.',
      'Die unbedingt einhaltende Frist endet morgen.',
      'Die unbedingt einzuhaltene Frist endet morgen.',
      'Die unbedingt einzugehalten Frist endet morgen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'ein\' + \'zu\' + \'haltend\' + Endung -e. Option B: fehlendes \'zu\'. Option C: falsche Bildung \'einzuhaltene\'. Option D: falsche Konstruktion mit Partizip II.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-011',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Patienten, die mit einer von Nebenwirkungen begleiteten Therapie behandelt werden, müssen regelmäßig untersucht werden.\'',
    'options': [
      'Die mit einer von Nebenwirkungen begleiteten Therapie behandelten Patienten müssen regelmäßig untersucht werden.',
      'Die mit einer von Nebenwirkungen begleiteten Therapie behandelnden Patienten müssen regelmäßig untersucht werden.',
      'Die mit einer von Nebenwirkungen begleiteten Therapie behandelte Patienten müssen regelmäßig untersucht werden.',
      'Die mit einer von Nebenwirkungen begleitete Therapie behandelten Patienten müssen regelmäßig untersucht werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'behandelt\' + Endung -en (Nominativ Plural). Verschachteltes Partizip II \'begleitet\' beschreibt die Therapie. Option B: Partizip I statt II (die Patienten werden behandelt, passiv). Option C: falsche Endung \'-e\' statt \'-en\' (Plural). Option D: falsche Endung bei \'begleitete\' statt \'begleiteten\' (Dativ feminin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-012',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Vorschriften, die streng zu beachten sind, stehen im Handbuch.\'',
    'options': [
      'Die streng zu beachtenden Vorschriften stehen im Handbuch.',
      'Die streng beachtenden Vorschriften stehen im Handbuch.',
      'Die streng zu beachteten Vorschriften stehen im Handbuch.',
      'Die streng zu beachtend Vorschriften stehen im Handbuch.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'beachtend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-013',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Konferenz, die von dem für seine kontroversen Thesen bekannten Professor organisiert wurde, findet im Mai statt.\'',
    'options': [
      'Die von dem für seine kontroversen Thesen bekannten Professor organisierte Konferenz findet im Mai statt.',
      'Die von dem für seine kontroversen Thesen bekannten Professor organisierende Konferenz findet im Mai statt.',
      'Die von dem für seine kontroversen Thesen bekannten Professor organisierter Konferenz findet im Mai statt.',
      'Die von dem für seine kontroversen Thesen bekannte Professor organisierte Konferenz findet im Mai statt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'organisiert\' + Endung -e (Nominativ feminin). Verschachteltes Adjektiv \'bekannt\' beschreibt den Professor. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'bekannte\' statt \'bekannten\' (Dativ maskulin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-014',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Angeklagte, der trotz der von seinem Anwalt vorgebrachten Argumente verurteilt wurde, legte Berufung ein.\'',
    'options': [
      'Der trotz der von seinem Anwalt vorgebrachten Argumente verurteilte Angeklagte legte Berufung ein.',
      'Der trotz der von seinem Anwalt vorgebrachten Argumente verurteilende Angeklagte legte Berufung ein.',
      'Der trotz der von seinem Anwalt vorgebrachten Argumente verurteilter Angeklagte legte Berufung ein.',
      'Der trotz der von seinen Anwalt vorgebrachten Argumente verurteilte Angeklagte legte Berufung ein.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'verurteilt\' + Endung -e (Nominativ maskulin). Verschachteltes Partizip II \'vorgebracht\' beschreibt die Argumente. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'seinen\' statt \'seinem\' (Dativ maskulin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-015',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Der Fehler, der auf keinen Fall wiederholt werden darf, wurde dokumentiert.\'',
    'options': [
      'Der auf keinen Fall zu wiederholende Fehler wurde dokumentiert.',
      'Der auf keinen Fall wiederholende Fehler wurde dokumentiert.',
      'Der auf keinen Fall zu wiederholte Fehler wurde dokumentiert.',
      'Der auf keinen Fall zu wiederholen Fehler wurde dokumentiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'wiederholend\' + Endung -e (Nominativ maskulin). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-016',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Autorin, die sich auf das in akademischen Kreisen heiß diskutierte Thema spezialisiert hat, publiziert viel.\'',
    'options': [
      'Die sich auf das in akademischen Kreisen heiß diskutierte Thema spezialisierte Autorin publiziert viel.',
      'Die sich auf das in akademischen Kreisen heiß diskutierte Thema spezialisierende Autorin publiziert viel.',
      'Die sich auf das in akademischen Kreisen heiß diskutiertes Thema spezialisierte Autorin publiziert viel.',
      'Die sich auf das in akademische Kreisen heiß diskutierte Thema spezialisierte Autorin publiziert viel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'spezialisiert\' + Endung -e (Nominativ feminin, reflexiv \'sich\' bleibt). Option B: Partizip I suggeriert laufenden Prozess, aber sie hat sich spezialisiert. Option C: falsche Endung \'-es\' bei \'diskutiertes\' statt \'-e\'. Option D: falscher Kasus \'akademische\' statt \'akademischen\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-017',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Akten, die sorgfältig aufzubewahren sind, dürfen nicht vernichtet werden.\'',
    'options': [
      'Die sorgfältig aufzubewahrenden Akten dürfen nicht vernichtet werden.',
      'Die sorgfältig aufbewahrenden Akten dürfen nicht vernichtet werden.',
      'Die sorgfältig aufzubewahrten Akten dürfen nicht vernichtet werden.',
      'Die sorgfältig aufzubewahrend Akten dürfen nicht vernichtet werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'auf\' + \'zu\' + \'bewahrend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-018',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Das Gutachten, das von den mit der Materie bestens vertrauten Sachverständigen verfasst wurde, ist umfassend.\'',
    'options': [
      'Das von den mit der Materie bestens vertrauten Sachverständigen verfasste Gutachten ist umfassend.',
      'Das von den mit der Materie bestens vertrauten Sachverständigen verfassende Gutachten ist umfassend.',
      'Das von den mit der Materie bestens vertrauten Sachverständigen verfasstes Gutachten ist umfassend.',
      'Das von den mit der Materie bestens vertraute Sachverständigen verfasste Gutachten ist umfassend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'verfasst\' + Endung -e (Nominativ neutrum). Verschachteltes Adjektiv \'vertraut\' beschreibt die Sachverständigen. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-es\' statt \'-e\'. Option D: falscher Kasus \'vertraute\' statt \'vertrauten\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-019',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Politiker, der sich wiederholt zu den immer komplexer werdenden Herausforderungen äußert, verliert an Glaubwürdigkeit.\'',
    'options': [
      'Der sich wiederholt zu den immer komplexer werdenden Herausforderungen äußernde Politiker verliert an Glaubwürdigkeit.',
      'Der sich wiederholt zu den immer komplexer werdenden Herausforderungen geäußerte Politiker verliert an Glaubwürdigkeit.',
      'Der sich wiederholt zu den immer komplexer werdenden Herausforderungen äußernder Politiker verliert an Glaubwürdigkeit.',
      'Der sich wiederholt zu den immer komplexer werdende Herausforderungen äußernde Politiker verliert an Glaubwürdigkeit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'äußernd\' + Endung -e (Nominativ maskulin). Verschachteltes Partizip I \'werdend\' beschreibt die Herausforderungen. Option B: Partizip II statt I (aktiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'werdende\' statt \'werdenden\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-020',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Risiken, die sorgfältig abzuwägen sind, betreffen alle.\'',
    'options': [
      'Die sorgfältig abzuwägenden Risiken betreffen alle.',
      'Die sorgfältig abwägenden Risiken betreffen alle.',
      'Die sorgfältig abzuwägten Risiken betreffen alle.',
      'Die sorgfältig abzuwägend Risiken betreffen alle.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'ab\' + \'zu\' + \'wägend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-021',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Verhandlungen, die von den um einen Kompromiss ringenden Delegierten geführt wurden, dauerten bis Mitternacht.\'',
    'options': [
      'Die von den um einen Kompromiss ringenden Delegierten geführten Verhandlungen dauerten bis Mitternacht.',
      'Die von den um einen Kompromiss ringenden Delegierten führenden Verhandlungen dauerten bis Mitternacht.',
      'Die von den um einen Kompromiss ringenden Delegierten geführte Verhandlungen dauerten bis Mitternacht.',
      'Die von den um ein Kompromiss ringenden Delegierten geführten Verhandlungen dauerten bis Mitternacht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'geführt\' + Endung -en (Nominativ Plural). Verschachteltes Partizip I \'ringend\' beschreibt die Delegierten. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-e\' statt \'-en\' (Plural). Option D: falscher Artikel \'ein\' statt \'einen\' (Akkusativ maskulin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-022',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Der Vertrag, der noch zu unterzeichnen ist, liegt bereit.\'',
    'options': [
      'Der noch zu unterzeichnende Vertrag liegt bereit.',
      'Der noch unterzeichnende Vertrag liegt bereit.',
      'Der noch zu unterzeichnete Vertrag liegt bereit.',
      'Der noch zu unterzeichnend Vertrag liegt bereit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'unterzeichnend\' + Endung -e (Nominativ maskulin). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-023',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Reform, die trotz des von Kritikern heftig beklagten Widerstands durchgesetzt wurde, zeigt erste Erfolge.\'',
    'options': [
      'Die trotz des von Kritikern heftig beklagten Widerstands durchgesetzte Reform zeigt erste Erfolge.',
      'Die trotz des von Kritikern heftig beklagten Widerstands durchsetzende Reform zeigt erste Erfolge.',
      'Die trotz des von Kritikern heftig beklagten Widerstands durchgesetzter Reform zeigt erste Erfolge.',
      'Die trotz des von Kritikern heftig beklagte Widerstands durchgesetzte Reform zeigt erste Erfolge.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'durchgesetzt\' + Endung -e (Nominativ feminin). Verschachteltes Partizip II \'beklagt\' beschreibt den Widerstand. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'beklagte\' statt \'beklagten\' (Genitiv maskulin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-024',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Künstler, der in der von zahlreichen Kritikern hoch gelobten Ausstellung ausstellt, ist stolz.\'',
    'options': [
      'Der in der von zahlreichen Kritikern hoch gelobten Ausstellung ausstellende Künstler ist stolz.',
      'Der in der von zahlreichen Kritikern hoch gelobten Ausstellung ausgestellte Künstler ist stolz.',
      'Der in der von zahlreichen Kritikern hoch gelobten Ausstellung ausstellender Künstler ist stolz.',
      'Der in der von zahlreiche Kritikern hoch gelobten Ausstellung ausstellende Künstler ist stolz.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'ausstellend\' + Endung -e (Nominativ maskulin, der Künstler stellt aktiv aus). Verschachteltes Partizip II \'gelobt\' beschreibt die Ausstellung. Option B: Partizip II (der Künstler stellt aus, aktiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'zahlreiche\' statt \'zahlreichen\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-025',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Mängel, die unverzüglich zu beseitigen sind, gefährden die Sicherheit.\'',
    'options': [
      'Die unverzüglich zu beseitigenden Mängel gefährden die Sicherheit.',
      'Die unverzüglich beseitigenden Mängel gefährden die Sicherheit.',
      'Die unverzüglich zu beseitigten Mängel gefährden die Sicherheit.',
      'Die unverzüglich zu beseitigend Mängel gefährden die Sicherheit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'beseitigend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-026',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Das Unternehmen, das von dem für seine visionären Ideen geschätzten Gründer geleitet wird, expandiert.\'',
    'options': [
      'Das von dem für seine visionären Ideen geschätzten Gründer geleitete Unternehmen expandiert.',
      'Das von dem für seine visionären Ideen geschätzten Gründer leitende Unternehmen expandiert.',
      'Das von dem für seine visionären Ideen geschätzten Gründer geleitetes Unternehmen expandiert.',
      'Das von dem für seine visionäre Ideen geschätzten Gründer geleitete Unternehmen expandiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'geleitet\' + Endung -e (Nominativ neutrum). Option B: Partizip I statt II (das Unternehmen wird geleitet, passiv). Option C: falsche Endung \'-es\' statt \'-e\'. Option D: falscher Kasus \'visionäre\' statt \'visionären\' (Akkusativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-027',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Journalistin, die über die durch den Klimawandel verursachten Katastrophen berichtet, erhielt einen Preis.\'',
    'options': [
      'Die über die durch den Klimawandel verursachten Katastrophen berichtende Journalistin erhielt einen Preis.',
      'Die über die durch den Klimawandel verursachten Katastrophen berichtete Journalistin erhielt einen Preis.',
      'Die über die durch den Klimawandel verursachten Katastrophen berichtender Journalistin erhielt einen Preis.',
      'Die über die durch dem Klimawandel verursachten Katastrophen berichtende Journalistin erhielt einen Preis.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'berichtend\' + Endung -e (Nominativ feminin, die Journalistin berichtet aktiv). Verschachteltes Partizip II \'verursacht\' beschreibt die Katastrophen. Option B: Partizip II statt I (aktiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'dem\' statt \'den\' (Akkusativ maskulin nach \'durch\').',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-028',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Infrastruktur, die dringend zu modernisieren ist, bremst die Wirtschaft.\'',
    'options': [
      'Die dringend zu modernisierende Infrastruktur bremst die Wirtschaft.',
      'Die dringend modernisierende Infrastruktur bremst die Wirtschaft.',
      'Die dringend zu modernisierte Infrastruktur bremst die Wirtschaft.',
      'Die dringend zu modernisierend Infrastruktur bremst die Wirtschaft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'modernisierend\' + Endung -e (Nominativ feminin). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-029',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Ingenieur, der an dem von der Regierung mit Milliarden finanzierten Projekt arbeitet, ist spezialisiert.\'',
    'options': [
      'Der an dem von der Regierung mit Milliarden finanzierten Projekt arbeitende Ingenieur ist spezialisiert.',
      'Der an dem von der Regierung mit Milliarden finanzierten Projekt gearbeitete Ingenieur ist spezialisiert.',
      'Der an dem von der Regierung mit Milliarden finanzierten Projekt arbeitender Ingenieur ist spezialisiert.',
      'Der an dem von der Regierung mit Milliarden finanzierte Projekt arbeitende Ingenieur ist spezialisiert.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'arbeitend\' + Endung -e (Nominativ maskulin, aktiv). Verschachteltes Partizip II \'finanziert\' beschreibt das Projekt. Option B: Partizip II statt I (aktiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'finanzierte\' statt \'finanzierten\' (Dativ neutrum).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-030',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Das Formular, das vollständig auszufüllen ist, finden Sie online.\'',
    'options': [
      'Das vollständig auszufüllende Formular finden Sie online.',
      'Das vollständig ausfüllende Formular finden Sie online.',
      'Das vollständig auszufüllte Formular finden Sie online.',
      'Das vollständig auszufüllend Formular finden Sie online.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'aus\' + \'zu\' + \'füllend\' + Endung -e (Nominativ neutrum). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-031',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Strategie, die von dem sich in einer schwierigen Lage befindenden Vorstand entwickelt wurde, ist riskant.\'',
    'options': [
      'Die von dem sich in einer schwierigen Lage befindenden Vorstand entwickelte Strategie ist riskant.',
      'Die von dem sich in einer schwierigen Lage befindenden Vorstand entwickelnde Strategie ist riskant.',
      'Die von dem sich in einer schwierigen Lage befindenden Vorstand entwickelter Strategie ist riskant.',
      'Die von dem sich in einer schwierige Lage befindenden Vorstand entwickelte Strategie ist riskant.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'entwickelt\' + Endung -e (Nominativ feminin). Verschachteltes Partizip I \'befindend\' beschreibt den Vorstand. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'schwierige\' statt \'schwierigen\' (Dativ feminin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-032',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Richter, der über den seit Wochen die Öffentlichkeit beschäftigenden Fall urteilt, steht unter Druck.\'',
    'options': [
      'Der über den seit Wochen die Öffentlichkeit beschäftigenden Fall urteilende Richter steht unter Druck.',
      'Der über den seit Wochen die Öffentlichkeit beschäftigenden Fall geurteilte Richter steht unter Druck.',
      'Der über den seit Wochen die Öffentlichkeit beschäftigenden Fall urteilender Richter steht unter Druck.',
      'Der über den seit Wochen die Öffentlichkeit beschäftigende Fall urteilende Richter steht unter Druck.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'urteilend\' + Endung -e (Nominativ maskulin). Verschachteltes Partizip I \'beschäftigend\' beschreibt den Fall. Option B: Partizip II statt I (der Richter urteilt aktiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'beschäftigende\' statt \'beschäftigenden\' (Akkusativ maskulin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-033',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Unterlagen, die bis Freitag einzureichen sind, liegen bereit.\'',
    'options': [
      'Die bis Freitag einzureichenden Unterlagen liegen bereit.',
      'Die bis Freitag einreichenden Unterlagen liegen bereit.',
      'Die bis Freitag einzureichten Unterlagen liegen bereit.',
      'Die bis Freitag einzureichend Unterlagen liegen bereit.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'ein\' + \'zu\' + \'reichend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-034',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Analyse, die auf den vom Ministerium bereitgestellten Daten basiert, wird morgen veröffentlicht.\'',
    'options': [
      'Die auf den vom Ministerium bereitgestellten Daten basierende Analyse wird morgen veröffentlicht.',
      'Die auf den vom Ministerium bereitgestellten Daten basierte Analyse wird morgen veröffentlicht.',
      'Die auf den vom Ministerium bereitgestellten Daten basierender Analyse wird morgen veröffentlicht.',
      'Die auf den vom Ministerium bereitgestellte Daten basierende Analyse wird morgen veröffentlicht.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'basierend\' + Endung -e (Nominativ feminin, die Analyse basiert aktiv). Option B: Partizip II statt I (aktiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'bereitgestellte\' statt \'bereitgestellten\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-035',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Das Abkommen, das unter dem von allen Seiten ausgeübten Druck zustande kam, ist fragil.\'',
    'options': [
      'Das unter dem von allen Seiten ausgeübten Druck zustande gekommene Abkommen ist fragil.',
      'Das unter dem von allen Seiten ausgeübten Druck zustande kommende Abkommen ist fragil.',
      'Das unter dem von allen Seiten ausgeübten Druck zustande gekommenes Abkommen ist fragil.',
      'Das unter dem von alle Seiten ausgeübten Druck zustande gekommene Abkommen ist fragil.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'zustande gekommen\' + Endung -e (Nominativ neutrum, das Abkommen kam zustande). Option B: Partizip I drückt Gleichzeitigkeit aus, aber das Abkommen ist bereits zustande gekommen. Option C: falsche Endung \'-es\' statt \'-e\'. Option D: falscher Kasus \'alle\' statt \'allen\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-036',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Der Schaden, der kaum zu reparieren ist, kostet Millionen.\'',
    'options': [
      'Der kaum zu reparierende Schaden kostet Millionen.',
      'Der kaum reparierende Schaden kostet Millionen.',
      'Der kaum zu reparierte Schaden kostet Millionen.',
      'Der kaum zu reparierend Schaden kostet Millionen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'reparierend\' + Endung -e (Nominativ maskulin). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-037',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Kandidatin, die von der einstimmig hinter ihr stehenden Fraktion nominiert wurde, gewann die Wahl.\'',
    'options': [
      'Die von der einstimmig hinter ihr stehenden Fraktion nominierte Kandidatin gewann die Wahl.',
      'Die von der einstimmig hinter ihr stehenden Fraktion nominierende Kandidatin gewann die Wahl.',
      'Die von der einstimmig hinter ihr stehenden Fraktion nominierter Kandidatin gewann die Wahl.',
      'Die von der einstimmig hinter ihr stehende Fraktion nominierte Kandidatin gewann die Wahl.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'nominiert\' + Endung -e (Nominativ feminin). Verschachteltes Partizip I \'stehend\' beschreibt die Fraktion. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'stehende\' statt \'stehenden\' (Dativ feminin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-038',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Forscher, die an einer möglicherweise revolutionären, noch nicht abgeschlossenen Studie arbeiten, publizieren vorläufige Ergebnisse.\'',
    'options': [
      'Die an einer möglicherweise revolutionären, noch nicht abgeschlossenen Studie arbeitenden Forscher publizieren vorläufige Ergebnisse.',
      'Die an einer möglicherweise revolutionären, noch nicht abgeschlossenen Studie gearbeiteten Forscher publizieren vorläufige Ergebnisse.',
      'Die an einer möglicherweise revolutionären, noch nicht abgeschlossenen Studie arbeitende Forscher publizieren vorläufige Ergebnisse.',
      'Die an einer möglicherweise revolutionäre, noch nicht abgeschlossenen Studie arbeitenden Forscher publizieren vorläufige Ergebnisse.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'arbeitend\' + Endung -en (Nominativ Plural). Option B: Partizip II statt I (die Forscher arbeiten aktiv). Option C: falsche Endung \'-e\' statt \'-en\' (Plural). Option D: falscher Kasus \'revolutionäre\' statt \'revolutionären\' (Dativ feminin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-039',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Bestimmungen, die zwingend einzuhalten sind, werden im Vertrag aufgeführt.\'',
    'options': [
      'Die zwingend einzuhaltenden Bestimmungen werden im Vertrag aufgeführt.',
      'Die zwingend einhaltenden Bestimmungen werden im Vertrag aufgeführt.',
      'Die zwingend einzuhalteten Bestimmungen werden im Vertrag aufgeführt.',
      'Die zwingend einzuhaltend Bestimmungen werden im Vertrag aufgeführt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'ein\' + \'zu\' + \'haltend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-040',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Bürgermeister, der von den mit der Stadtentwicklung unzufriedenen Bürgern kritisiert wird, reagiert gelassen.\'',
    'options': [
      'Der von den mit der Stadtentwicklung unzufriedenen Bürgern kritisierte Bürgermeister reagiert gelassen.',
      'Der von den mit der Stadtentwicklung unzufriedenen Bürgern kritisierende Bürgermeister reagiert gelassen.',
      'Der von den mit der Stadtentwicklung unzufriedenen Bürgern kritisierter Bürgermeister reagiert gelassen.',
      'Der von den mit der Stadtentwicklung unzufriedene Bürgern kritisierte Bürgermeister reagiert gelassen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'kritisiert\' + Endung -e (Nominativ maskulin). Adjektiv \'unzufrieden\' beschreibt die Bürger. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'unzufriedene\' statt \'unzufriedenen\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-041',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Delegation, die bei den von Spannungen geprägten Gesprächen anwesend war, berichtete dem Parlament.\'',
    'options': [
      'Die bei den von Spannungen geprägten Gesprächen anwesende Delegation berichtete dem Parlament.',
      'Die bei den von Spannungen geprägten Gesprächen angewesene Delegation berichtete dem Parlament.',
      'Die bei den von Spannungen geprägten Gesprächen anwesender Delegation berichtete dem Parlament.',
      'Die bei den von Spannungen geprägte Gesprächen anwesende Delegation berichtete dem Parlament.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'anwesend\' als Adjektiv + Endung -e (Nominativ feminin). Option B: falsches Partizip II \'angewesen\' existiert nicht. Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'geprägte\' statt \'geprägten\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-042',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Gefahren, die keinesfalls zu ignorieren sind, müssen ernst genommen werden.\'',
    'options': [
      'Die keinesfalls zu ignorierenden Gefahren müssen ernst genommen werden.',
      'Die keinesfalls ignorierenden Gefahren müssen ernst genommen werden.',
      'Die keinesfalls zu ignorierten Gefahren müssen ernst genommen werden.',
      'Die keinesfalls zu ignorierend Gefahren müssen ernst genommen werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'ignorierend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-043',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Das Gesetz, das nach jahrelanger, von Kontroversen begleiteter Debatte verabschiedet wurde, tritt in Kraft.\'',
    'options': [
      'Das nach jahrelanger, von Kontroversen begleiteter Debatte verabschiedete Gesetz tritt in Kraft.',
      'Das nach jahrelanger, von Kontroversen begleiteter Debatte verabschiedende Gesetz tritt in Kraft.',
      'Das nach jahrelanger, von Kontroversen begleiteter Debatte verabschiedetes Gesetz tritt in Kraft.',
      'Das nach jahrelanger, von Kontroversen begleitete Debatte verabschiedete Gesetz tritt in Kraft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'verabschiedet\' + Endung -e (Nominativ neutrum). Partizip II \'begleitet\' beschreibt die Debatte (Dativ feminin: \'begleiteter\'). Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-es\' statt \'-e\'. Option D: falscher Kasus \'begleitete\' statt \'begleiteter\' (Dativ feminin ohne Artikel).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-044',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Der Architekt, der mit dem unter Denkmalschutz stehenden Gebäude beauftragt ist, plant den Umbau.\'',
    'options': [
      'Der mit dem unter Denkmalschutz stehenden Gebäude beauftragte Architekt plant den Umbau.',
      'Der mit dem unter Denkmalschutz stehenden Gebäude beauftragend Architekt plant den Umbau.',
      'Der mit dem unter Denkmalschutz stehenden Gebäude beauftragter Architekt plant den Umbau.',
      'Der mit dem unter Denkmalschutz stehende Gebäude beauftragte Architekt plant den Umbau.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'beauftragt\' + Endung -e (Nominativ maskulin). Partizip I \'stehend\' beschreibt das Gebäude. Option B: fehlende Adjektivendung bei \'beauftragend\'. Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'stehende\' statt \'stehenden\' (Dativ neutrum).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-045',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Bedingungen, die vor Vertragsabschluss zu klären sind, werden im Anhang aufgelistet.\'',
    'options': [
      'Die vor Vertragsabschluss zu klärenden Bedingungen werden im Anhang aufgelistet.',
      'Die vor Vertragsabschluss klärenden Bedingungen werden im Anhang aufgelistet.',
      'Die vor Vertragsabschluss zu geklärten Bedingungen werden im Anhang aufgelistet.',
      'Die vor Vertragsabschluss zu klärend Bedingungen werden im Anhang aufgelistet.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'klärend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-046',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Investoren, die an dem vielversprechenden, von der Regierung unterstützten Projekt teilnehmen, erwarten hohe Renditen.\'',
    'options': [
      'Die an dem vielversprechenden, von der Regierung unterstützten Projekt teilnehmenden Investoren erwarten hohe Renditen.',
      'Die an dem vielversprechenden, von der Regierung unterstützten Projekt teilgenommenen Investoren erwarten hohe Renditen.',
      'Die an dem vielversprechenden, von der Regierung unterstützten Projekt teilnehmende Investoren erwarten hohe Renditen.',
      'Die an dem vielversprechende, von der Regierung unterstützten Projekt teilnehmenden Investoren erwarten hohe Renditen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip I \'teilnehmend\' + Endung -en (Nominativ Plural). Option B: Partizip II statt I (die Investoren nehmen aktiv teil). Option C: falsche Endung \'-e\' statt \'-en\' (Plural). Option D: falscher Kasus \'vielversprechende\' statt \'vielversprechenden\' (Dativ neutrum).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-047',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Das Medikament, das nach langwierigen, von Rückschlägen geprägten Versuchen zugelassen wurde, rettet Leben.\'',
    'options': [
      'Das nach langwierigen, von Rückschlägen geprägten Versuchen zugelassene Medikament rettet Leben.',
      'Das nach langwierigen, von Rückschlägen geprägten Versuchen zulassende Medikament rettet Leben.',
      'Das nach langwierigen, von Rückschlägen geprägten Versuchen zugelassenes Medikament rettet Leben.',
      'Das nach langwierigen, von Rückschlägen geprägte Versuchen zugelassene Medikament rettet Leben.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'zugelassen\' + Endung -e (Nominativ neutrum). Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-es\' statt \'-e\'. Option D: falscher Kasus \'geprägte\' statt \'geprägten\' (Dativ Plural).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-048',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Schulden, die schnellstmöglich abzubauen sind, belasten die Gemeinde.\'',
    'options': [
      'Die schnellstmöglich abzubauenden Schulden belasten die Gemeinde.',
      'Die schnellstmöglich abbauenden Schulden belasten die Gemeinde.',
      'Die schnellstmöglich abzugebauten Schulden belasten die Gemeinde.',
      'Die schnellstmöglich abzubauend Schulden belasten die Gemeinde.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv bei trennbaren Verben: \'ab\' + \'zu\' + \'bauend\' + Endung -en (Plural). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-049',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Relativsatz -> Partizipialattribut: \'Die Mannschaft, die von dem in der Halbzeit eingewechselten Spieler inspiriert wurde, gewann das Spiel.\'',
    'options': [
      'Die von dem in der Halbzeit eingewechselten Spieler inspirierte Mannschaft gewann das Spiel.',
      'Die von dem in der Halbzeit eingewechselten Spieler inspirierende Mannschaft gewann das Spiel.',
      'Die von dem in der Halbzeit eingewechselten Spieler inspirierter Mannschaft gewann das Spiel.',
      'Die von dem in der Halbzeit eingewechselte Spieler inspirierte Mannschaft gewann das Spiel.'
    ],
    'correctAnswer': 0,
    'explanation': 'Partizip II \'inspiriert\' + Endung -e (Nominativ feminin). Verschachteltes Partizip II \'eingewechselt\' beschreibt den Spieler. Option B: Partizip I statt II (passiv). Option C: falsche Endung \'-er\' statt \'-e\'. Option D: falscher Kasus \'eingewechselte\' statt \'eingewechselten\' (Dativ maskulin).',
    'subcategory': 'Relativsatz -> Partizip',
    'tags': ['partizipialattribute']
  },
  {
    'language': 'german',
    'id': 'c1-partizipialattribute-p1-050',
    'level': 'c1',
    'category': 'Partizipialattribute',
    'question': 'Gerundiv: \'Die Chance, die nicht zu versäumen ist, bietet sich nur einmal.\'',
    'options': [
      'Die nicht zu versäumende Chance bietet sich nur einmal.',
      'Die nicht versäumende Chance bietet sich nur einmal.',
      'Die nicht zu versäumte Chance bietet sich nur einmal.',
      'Die nicht zu versäumend Chance bietet sich nur einmal.'
    ],
    'correctAnswer': 0,
    'explanation': 'Gerundiv: \'zu\' + Partizip I \'versäumend\' + Endung -e (Nominativ feminin). Option B: fehlendes \'zu\'. Option C: falsche Konstruktion mit Partizip II. Option D: fehlende Adjektivendung.',
    'subcategory': 'Gerundiv',
    'tags': ['partizipialattribute', 'gerundiv']
  }
];

export default questions;