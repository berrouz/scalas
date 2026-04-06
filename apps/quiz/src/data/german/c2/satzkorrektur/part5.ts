import { Question } from '@/types/question';

const questions: Question[] = [
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-001',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er entsagte allem irdischen Besitz.',
      'Er entsagte allen irdischen Besitz.',
      'Er entsagte allem irdischem Besitz.',
      'Er entsagte alles irdische Besitz.'
    ],
    'correctAnswer': 0,
    'explanation': '"Entsagen" regiert den Dativ: "allem irdischen Besitz".',
    'exampleSentence': 'Er entsagte allem irdischen Besitz.',
    'grammarRule': 'Dativrektion bei "entsagen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-002',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ging, um frische Luft zu schnappen, in den Park.',
      'Er ging um frische Luft zu schnappen in den Park.',
      'Er ging, um frische Luft zu schnappen in den Park.',
      'Er ging um frische Luft, zu schnappen, in den Park.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die eingeschobene Infinitivgruppe mit "um ... zu" wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Er ging, um frische Luft zu schnappen, in den Park.',
    'grammarRule': 'Paarige Kommas bei eingeschobener Finalgruppe',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-003',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Responsum des Experten lag vor.',
      'Der Responsum des Experten lag vor.',
      'Die Responsum des Experten lag vor.',
      'Das Responsum dem Experten lag vor.'
    ],
    'correctAnswer': 0,
    'explanation': '"Responsum" ist Neutrum: das Responsum.',
    'exampleSentence': 'Das Responsum des Experten lag vor.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-004',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Alle, die gekommen waren, wurden herzlich empfangen.',
      'Alle, die gekommen waren, wurde herzlich empfangen.',
      'Alle, die gekommen war, wurden herzlich empfangen.',
      'Allen, die gekommen waren, wurden herzlich empfangen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Alle" (Plural) verlangt "wurden". Im Relativsatz: "die ... waren" (Plural).',
    'exampleSentence': 'Alle, die gekommen waren, wurden herzlich empfangen.',
    'grammarRule': 'Kongruenz bei Pluralpronomen mit Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-005',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er entbot ihr seinen Gruß.',
      'Er entbietete ihr seinen Gruß.',
      'Er entbot sie seinen Gruß.',
      'Er entbot ihr sein Gruß.'
    ],
    'correctAnswer': 0,
    'explanation': '"Entbieten" (darbieten) hat das Präteritum "entbot". Dativ der Person: "ihr".',
    'exampleSentence': 'Er entbot ihr seinen Gruß.',
    'grammarRule': 'Archaisches starkes Verb mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-006',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Bezüglich Ihres Antrags möchte ich Folgendes mitteilen.',
      'Bezüglich Ihrem Antrag möchte ich Folgendes mitteilen.',
      'Bezüglich Ihres Antrags möchte ich folgendes mitteilen.',
      'Bezüglich Ihren Antrag möchte ich Folgendes mitteilen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bezüglich" regiert den Genitiv. "Folgendes" wird als Substantivierung groß geschrieben.',
    'exampleSentence': 'Bezüglich Ihres Antrags möchte ich Folgendes mitteilen.',
    'grammarRule': 'Amtssprachliche Präposition mit Genitiv und Substantivierung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-007',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Auf keinen Fall dürfen diese Unterlagen weitergegeben werden.',
      'Auf keinen Fall diese Unterlagen dürfen weitergegeben werden.',
      'Auf keinen Fall dürfen weitergegeben werden diese Unterlagen.',
      'Diese Unterlagen auf keinen Fall dürfen weitergegeben werden.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem negierten Adverbial im Vorfeld folgt das finite Verb an zweiter Stelle.',
    'exampleSentence': 'Auf keinen Fall dürfen diese Unterlagen weitergegeben werden.',
    'grammarRule': 'Verbzweitstellung nach negiertem adverbialem Vorfeld',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-008',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Stier bei den Hörnern gepackt.',
      'Er hat den Stier bei den Hörner gepackt.',
      'Er hat dem Stier bei den Hörnern gepackt.',
      'Er hat den Stier bei die Hörnern gepackt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Den Stier bei den Hörnern packen" (entschlossen handeln). Akkusativ: "den Stier", Dativ: "den Hörnern".',
    'exampleSentence': 'Er hat den Stier bei den Hörnern gepackt.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ und Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-009',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Insofern, als die Umstände es zulassen, wird man helfen.',
      'Insofern als die Umstände es zulassen wird man helfen.',
      'Insofern als die Umstände es zulassen, wird man helfen.',
      'Insofern, als die Umstände es zulassen wird man helfen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "insofern" und nach dem Nebensatz mit "als" stehen Kommas.',
    'exampleSentence': 'Insofern, als die Umstände es zulassen, wird man helfen.',
    'grammarRule': 'Kommasetzung bei "insofern, als"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-010',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat sich der Aufgabe angenommen.',
      'Sie hat sich die Aufgabe angenommen.',
      'Sie hat sich dem Aufgabe angenommen.',
      'Sie hat sich der Aufgabe angenommt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache annehmen" regiert den Genitiv: "der Aufgabe".',
    'exampleSentence': 'Sie hat sich der Aufgabe angenommen.',
    'grammarRule': 'Genitivrektion bei "sich annehmen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-011',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Die Prämisse seiner Argumentation ist fragwürdig.',
      'Der Prämisse seiner Argumentation ist fragwürdig.',
      'Das Prämisse seiner Argumentation ist fragwürdig.',
      'Die Prämisse sein Argumentation ist fragwürdig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Prämisse" ist Femininum: die Prämisse.',
    'exampleSentence': 'Die Prämisse seiner Argumentation ist fragwürdig.',
    'grammarRule': 'Genus bei Fachbegriffen aus dem Lateinischen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-012',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es sind dies die Fragen, die noch geklärt werden müssen.',
      'Es ist dies die Fragen, die noch geklärt werden müssen.',
      'Es sind dies die Fragen, die noch geklärt werden muss.',
      'Es ist dies die Fragen, die noch geklärt werden muss.'
    ],
    'correctAnswer': 0,
    'explanation': '"Es sind dies die Fragen" mit Plural-Verb, da sich "sind" nach "Fragen" richtet.',
    'exampleSentence': 'Es sind dies die Fragen, die noch geklärt werden müssen.',
    'grammarRule': 'Kongruenz bei Sätzen mit expletivem "es"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-013',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ward nicht mehr gesehen.',
      'Er wurd nicht mehr gesehen.',
      'Er würd nicht mehr gesehen.',
      'Er ward nicht mehr gesieht.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ward" ist die archaische Präteritumform von "werden" (Passiv): "Er ward nicht mehr gesehen."',
    'exampleSentence': 'Er ward nicht mehr gesehen.',
    'grammarRule': 'Archaisches Passiv mit "ward"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-014',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Vonnöten wäre eine gründliche Überarbeitung.',
      'Vonnöten wäre einen gründliche Überarbeitung.',
      'Von Nöten wäre eine gründliche Überarbeitung.',
      'Vonnöten wäre einer gründlichen Überarbeitung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Vonnöten" (zusammengeschrieben) ist ein gehobenes Prädikativ. "Eine Überarbeitung" im Nominativ als Subjekt.',
    'exampleSentence': 'Vonnöten wäre eine gründliche Überarbeitung.',
    'grammarRule': 'Gehobenes Prädikativ "vonnöten"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-015',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Wohl wissend, dass er Unrecht hatte, schwieg er.',
      'Wohl wissend dass er Unrecht hatte, schwieg er.',
      'Wohl wissend, dass er Unrecht hatte schwieg er.',
      'Wissend wohl, dass er Unrecht hatte, schwieg er.'
    ],
    'correctAnswer': 0,
    'explanation': 'Die partizipiale Konstruktion "wohl wissend" wird durch Komma abgetrennt. Nach dem Nebensatz steht ebenfalls ein Komma.',
    'exampleSentence': 'Wohl wissend, dass er Unrecht hatte, schwieg er.',
    'grammarRule': 'Partizipiale Vorfeldkonstruktion mit Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-016',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat das Heft in die Hand genommen.',
      'Er hat das Heft in der Hand genommen.',
      'Er hat dem Heft in die Hand genommen.',
      'Er hat das Heft in den Hand genommen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Das Heft in die Hand nehmen" (die Führung übernehmen). Akkusativ: "in die Hand".',
    'exampleSentence': 'Er hat das Heft in die Hand genommen.',
    'grammarRule': 'Idiomatische Wendung mit Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-017',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es fragt sich, ob und inwieweit dies zutrifft.',
      'Es fragt sich ob und inwieweit dies zutrifft.',
      'Es fragt sich, ob und, inwieweit dies zutrifft.',
      'Es fragt, sich ob und inwieweit dies zutrifft.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor den koordinierten Nebensätzen mit "ob und inwieweit" steht ein Komma.',
    'exampleSentence': 'Es fragt sich, ob und inwieweit dies zutrifft.',
    'grammarRule': 'Kommasetzung bei koordinierten indirekten Fragesätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-018',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie war der Aufgabe gewachsen.',
      'Sie war die Aufgabe gewachsen.',
      'Sie war dem Aufgabe gewachsen.',
      'Sie war der Aufgabe gewachst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache gewachsen sein" regiert den Dativ: "der Aufgabe".',
    'exampleSentence': 'Sie war der Aufgabe gewachsen.',
    'grammarRule': 'Dativrektion bei prädikativem Adjektiv "gewachsen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-019',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Odium des Misstrauens lag über der Verhandlung.',
      'Der Odium des Misstrauens lag über der Verhandlung.',
      'Die Odium des Misstrauens lag über der Verhandlung.',
      'Das Odium dem Misstrauens lag über der Verhandlung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Odium" ist Neutrum: das Odium.',
    'exampleSentence': 'Das Odium des Misstrauens lag über der Verhandlung.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -um',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-020',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Einer der Gründe, die dafür sprechen, ist überzeugend.',
      'Einer der Gründe, der dafür spricht, ist überzeugend.',
      'Einer der Gründe, die dafür sprechen, sind überzeugend.',
      'Einen der Gründe, die dafür sprechen, ist überzeugend.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der Relativsatz bezieht sich auf "Gründe" (Plural): "die ... sprechen". Das Hauptverb richtet sich nach "einer" (Singular).',
    'exampleSentence': 'Einer der Gründe, die dafür sprechen, ist überzeugend.',
    'grammarRule': 'Kongruenz bei partitivem Pronomen mit Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-021',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Hinfort möge niemand ihn belästigen!',
      'Hinfort möge niemanden ihn belästigen!',
      'Hinfort mag niemand ihn belästigen!',
      'Hin fort möge niemand ihn belästigen!'
    ],
    'correctAnswer': 0,
    'explanation': '"Hinfort" (von nun an) ist ein archaisches Adverb. "Möge" ist Konjunktiv I (Jussiv).',
    'exampleSentence': 'Hinfort möge niemand ihn belästigen!',
    'grammarRule': 'Archaisches Adverb mit jussivem Konjunktiv I',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-022',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Ungeachtet dessen besteht er auf seiner Forderung.',
      'Ungeachtet dem besteht er auf seiner Forderung.',
      'Ungeachtet dessen besteht er auf seine Forderung.',
      'Ungeachtet desses besteht er auf seiner Forderung.'
    ],
    'correctAnswer': 0,
    'explanation': '"Ungeachtet dessen" mit Demonstrativpronomen im Genitiv. "Bestehen auf" regiert den Dativ.',
    'exampleSentence': 'Ungeachtet dessen besteht er auf seiner Forderung.',
    'grammarRule': 'Gehobene Wendung mit Genitiv und Dativrektion',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-023',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Inwieweit dies zutrifft, sei dahingestellt.',
      'Inwieweit dies zutrifft, dahingestellt sei.',
      'Inwieweit zutrifft dies, sei dahingestellt.',
      'Inwieweit dies zutrifft sei dahingestellt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Im Nebensatz mit "inwieweit" steht das Verb am Ende. Der Hauptsatz beginnt mit dem finiten Verb.',
    'exampleSentence': 'Inwieweit dies zutrifft, sei dahingestellt.',
    'grammarRule': 'Verbstellung in Nebensatz-Hauptsatz-Folge',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-024',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm den Kopf gewaschen.',
      'Sie hat ihn den Kopf gewaschen.',
      'Sie hat ihm den Kopf gewaschte.',
      'Sie hat ihm dem Kopf gewaschen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem den Kopf waschen" (jemanden zurechtweisen). Dativ: "ihm", Akkusativ: "den Kopf".',
    'exampleSentence': 'Sie hat ihm den Kopf gewaschen.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-025',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es ist wichtig, dass du kommst, nicht wann.',
      'Es ist wichtig dass du kommst nicht wann.',
      'Es ist wichtig, dass du kommst nicht wann.',
      'Es ist wichtig dass du kommst, nicht wann.'
    ],
    'correctAnswer': 0,
    'explanation': 'Vor "dass" steht ein Komma, ebenso vor dem elliptischen Nachtrag "nicht wann".',
    'exampleSentence': 'Es ist wichtig, dass du kommst, nicht wann.',
    'grammarRule': 'Kommasetzung bei Nebensatz und elliptischem Nachtrag',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-026',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war des Wartens müde.',
      'Er war dem Warten müde.',
      'Er war das Warten müde.',
      'Er war des Warten müde.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache müde sein" regiert den Genitiv: "des Wartens".',
    'exampleSentence': 'Er war des Wartens müde.',
    'grammarRule': 'Genitivrektion bei prädikativem Adjektiv "müde"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-027',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Nexus zwischen beiden Ereignissen ist offensichtlich.',
      'Das Nexus zwischen beiden Ereignissen ist offensichtlich.',
      'Die Nexus zwischen beiden Ereignissen ist offensichtlich.',
      'Der Nexus zwischen beide Ereignisse ist offensichtlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nexus" ist Maskulinum: der Nexus. "Zwischen" regiert hier den Dativ: "beiden Ereignissen".',
    'exampleSentence': 'Der Nexus zwischen beiden Ereignissen ist offensichtlich.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -us',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-028',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Es bedarf einiger Anstrengungen, dieses Ziel zu erreichen.',
      'Es bedarf einige Anstrengungen, dieses Ziel zu erreichen.',
      'Es bedürfen einiger Anstrengungen, dieses Ziel zu erreichen.',
      'Es bedarf einigen Anstrengungen, dieses Ziel zu erreichen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Bedürfen" verlangt Genitiv: "einiger Anstrengungen". Das Subjekt "es" verlangt Singular: "bedarf".',
    'exampleSentence': 'Es bedarf einiger Anstrengungen, dieses Ziel zu erreichen.',
    'grammarRule': 'Genitivrektion und Kongruenz bei "bedürfen"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-029',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er wandte sich fürbaß und verschwand im Dunkel.',
      'Er wandte sich fürbass und verschwand im Dunkel.',
      'Er wandte sich fürbaß und verschwand in Dunkel.',
      'Er wendete sich fürbaß und verschwand im Dunkeln.'
    ],
    'correctAnswer': 0,
    'explanation': '"Fürbaß" (vorwärts, weiter) ist ein archaisches Adverb. "Im Dunkel" ist korrekt.',
    'exampleSentence': 'Er wandte sich fürbaß und verschwand im Dunkel.',
    'grammarRule': 'Archaisches Adverb der Richtung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-030',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Innerhalb des vorgegebenen Rahmens ist dies möglich.',
      'Innerhalb dem vorgegebenen Rahmen ist dies möglich.',
      'Innerhalb des vorgegebene Rahmens ist dies möglich.',
      'Innerhalb den vorgegebenen Rahmens ist dies möglich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Innerhalb" regiert den Genitiv: "des vorgegebenen Rahmens".',
    'exampleSentence': 'Innerhalb des vorgegebenen Rahmens ist dies möglich.',
    'grammarRule': 'Präposition "innerhalb" mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-031',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'So sprach er, und alle verstummten.',
      'So sprach er und alle verstummten.',
      'So er sprach, und alle verstummten.',
      'So sprach er, und verstummten alle.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach dem narrativen "so sprach er" steht ein Komma vor "und", da zwei Hauptsätze verbunden werden.',
    'exampleSentence': 'So sprach er, und alle verstummten.',
    'grammarRule': 'Komma zwischen selbstständigen Hauptsätzen',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-032',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat ihr Sand in die Augen gestreut.',
      'Er hat ihr Sand in den Augen gestreut.',
      'Er hat sie Sand in die Augen gestreut.',
      'Er hat ihr Sand in die Augen gestreit.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem Sand in die Augen streuen" (jemanden täuschen). Dativ: "ihr", Akkusativ: "in die Augen".',
    'exampleSentence': 'Er hat ihr Sand in die Augen gestreut.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Akkusativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-033',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Antrag wurde, wie nicht anders zu erwarten war, abgelehnt.',
      'Der Antrag wurde wie nicht anders zu erwarten war abgelehnt.',
      'Der Antrag wurde, wie nicht anders zu erwarten war abgelehnt.',
      'Der Antrag wurde wie nicht anders zu erwarten war, abgelehnt.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der eingeschobene Vergleichssatz wird durch paarige Kommas abgetrennt.',
    'exampleSentence': 'Der Antrag wurde, wie nicht anders zu erwarten war, abgelehnt.',
    'grammarRule': 'Paarige Kommas bei eingeschobenem Vergleichssatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-034',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er war seiner Sache gewiss.',
      'Er war seine Sache gewiss.',
      'Er war seinem Sache gewiss.',
      'Er war seiner Sache gewisst.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache gewiss sein" regiert den Genitiv: "seiner Sache".',
    'exampleSentence': 'Er war seiner Sache gewiss.',
    'grammarRule': 'Genitivrektion bei prädikativem Adjektiv "gewiss"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-035',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Der Lapsus wurde schnell korrigiert.',
      'Das Lapsus wurde schnell korrigiert.',
      'Die Lapsus wurde schnell korrigiert.',
      'Der Lapsus wurden schnell korrigiert.'
    ],
    'correctAnswer': 0,
    'explanation': '"Lapsus" ist Maskulinum: der Lapsus.',
    'exampleSentence': 'Der Lapsus wurde schnell korrigiert.',
    'grammarRule': 'Genus bei lateinischen Fremdwörtern auf -us',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-036',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichts von dem, was er sagte, war wahr.',
      'Nichts von dem, was er sagte, waren wahr.',
      'Nichts von dem, das er sagte, war wahr.',
      'Nichts von dem, was er sagte, war wahres.'
    ],
    'correctAnswer': 0,
    'explanation': '"Nichts" verlangt Singular: "war". Nach "dem" folgt "was" als Relativpronomen.',
    'exampleSentence': 'Nichts von dem, was er sagte, war wahr.',
    'grammarRule': 'Kongruenz bei "nichts" mit Relativsatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-037',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er zog von dannen und kam nie wieder.',
      'Er zog von dannen und kam nie wieder zurück.',
      'Er zog vondannen und kam nie wieder.',
      'Er zogt von dannen und kam nie wieder.'
    ],
    'correctAnswer': 0,
    'explanation': '"Von dannen" (von dort weg) ist eine archaische Adverbialphrase. "Zog" ist Präteritum von "ziehen".',
    'exampleSentence': 'Er zog von dannen und kam nie wieder.',
    'grammarRule': 'Archaische Adverbialphrase der Richtung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-038',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Aufgrund der vorliegenden Erkenntnisse ist eine Neubewertung erforderlich.',
      'Aufgrund den vorliegenden Erkenntnissen ist eine Neubewertung erforderlich.',
      'Aufgrund der vorliegende Erkenntnisse ist eine Neubewertung erforderlich.',
      'Aufgrund der vorliegenden Erkenntnisse ist einer Neubewertung erforderlich.'
    ],
    'correctAnswer': 0,
    'explanation': '"Aufgrund" regiert den Genitiv: "der vorliegenden Erkenntnisse".',
    'exampleSentence': 'Aufgrund der vorliegenden Erkenntnisse ist eine Neubewertung erforderlich.',
    'grammarRule': 'Kausale Präposition mit Genitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-039',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Je nachdem, wie das Wetter wird, fahren wir ans Meer.',
      'Je nachdem wie das Wetter wird, fahren wir ans Meer.',
      'Je nachdem, wie das Wetter wird fahren wir ans Meer.',
      'Je nachdem, wie wird das Wetter, fahren wir ans Meer.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "je nachdem" steht ein Komma. Im Nebensatz mit "wie" steht das Verb am Ende.',
    'exampleSentence': 'Je nachdem, wie das Wetter wird, fahren wir ans Meer.',
    'grammarRule': 'Kommasetzung und Verbstellung bei "je nachdem"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-040',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat den Stein ins Rollen gebracht.',
      'Er hat den Stein im Rollen gebracht.',
      'Er hat dem Stein ins Rollen gebracht.',
      'Er hat den Stein ins Rollen gebringen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Den Stein ins Rollen bringen" (etwas in Gang setzen). "Ins" = in das (Akkusativ).',
    'exampleSentence': 'Er hat den Stein ins Rollen gebracht.',
    'grammarRule': 'Idiomatische Wendung mit substantiviertem Infinitiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-041',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Gerade weil er so begabt ist, erwartet man mehr von ihm.',
      'Gerade weil er so begabt ist erwartet man mehr von ihm.',
      'Gerade, weil er so begabt ist, erwartet man mehr von ihm.',
      'Gerade weil er so begabt ist, erwartet man mehr, von ihm.'
    ],
    'correctAnswer': 0,
    'explanation': 'Der kausale Nebensatz mit "weil" wird durch Komma vom Hauptsatz getrennt. "Gerade" gehört zum Nebensatz.',
    'exampleSentence': 'Gerade weil er so begabt ist, erwartet man mehr von ihm.',
    'grammarRule': 'Kommasetzung nach kausalem Nebensatz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-042',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er ist des Lesens und Schreibens kundig.',
      'Er ist dem Lesen und Schreiben kundig.',
      'Er ist das Lesen und Schreiben kundig.',
      'Er ist des Lesen und Schreibens kundig.'
    ],
    'correctAnswer': 0,
    'explanation': '"Einer Sache kundig sein" regiert den Genitiv: "des Lesens und Schreibens".',
    'exampleSentence': 'Er ist des Lesens und Schreibens kundig.',
    'grammarRule': 'Genitivrektion bei prädikativem Adjektiv "kundig"',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-043',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Genus',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Faible des Professors für alte Handschriften war bekannt.',
      'Der Faible des Professors für alte Handschriften war bekannt.',
      'Die Faible des Professors für alte Handschriften war bekannt.',
      'Das Faible dem Professor für alte Handschriften war bekannt.'
    ],
    'correctAnswer': 0,
    'explanation': '"Faible" ist Neutrum: das Faible.',
    'exampleSentence': 'Das Faible des Professors für alte Handschriften war bekannt.',
    'grammarRule': 'Genus bei französischen Fremdwörtern',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-044',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kongruenz',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Das Wenige, was er besaß, teilte er mit anderen.',
      'Das Wenige, was er besaß, teilten er mit anderen.',
      'Das Wenige, das er besaß, teilte er mit anderen.',
      'Den Wenigen, was er besaß, teilte er mit anderen.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "das Wenige" folgt "was" als Relativpronomen. "Teilte" kongruiert mit "er" (Singular).',
    'exampleSentence': 'Das Wenige, was er besaß, teilte er mit anderen.',
    'grammarRule': 'Relativpronomen nach substantiviertem Adjektiv',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-045',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Archaismen',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er stand allein, von aller Welt verlassen.',
      'Er stand allein, von alle Welt verlassen.',
      'Er stand allein, von aller Welt verliest.',
      'Er stund allein, von aller Welt verlassen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Von aller Welt verlassen" ist eine gehobene Partizipialkonstruktion. "Aller" ist Dativ Singular.',
    'exampleSentence': 'Er stand allein, von aller Welt verlassen.',
    'grammarRule': 'Gehobene Partizipialkonstruktion mit Dativ',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-046',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Stil',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Diesbezüglich möchte ich auf Folgendes hinweisen.',
      'Diesbezüglich möchte ich auf folgendes hinweisen.',
      'Dies bezüglich möchte ich auf Folgendes hinweisen.',
      'Diesbezüglich möchte ich auf Folgenden hinweisen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Diesbezüglich" (zusammengeschrieben). "Folgendes" als Substantivierung groß geschrieben.',
    'exampleSentence': 'Diesbezüglich möchte ich auf Folgendes hinweisen.',
    'grammarRule': 'Amtssprachliches Adverb und Substantivierung',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-047',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Wortstellung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Daran, dass er kommen würde, zweifelte niemand.',
      'Daran dass er kommen würde, zweifelte niemand.',
      'Daran, dass er kommen würde zweifelte niemand.',
      'Daran, dass kommen er würde, zweifelte niemand.'
    ],
    'correctAnswer': 0,
    'explanation': 'Nach "daran" steht ein Komma vor "dass". Im Nebensatz steht das Verb am Ende.',
    'exampleSentence': 'Daran, dass er kommen würde, zweifelte niemand.',
    'grammarRule': 'Korrelat "daran" mit nachfolgendem "dass"-Satz',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-048',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Idiomatik',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Sie hat ihm auf den Zahn gefühlt.',
      'Sie hat ihm auf dem Zahn gefühlt.',
      'Sie hat ihn auf den Zahn gefühlt.',
      'Sie hat ihm auf den Zahn gefühlen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Jemandem auf den Zahn fühlen" (jemanden genau prüfen). Dativ: "ihm", Akkusativ: "auf den Zahn".',
    'exampleSentence': 'Sie hat ihm auf den Zahn gefühlt.',
    'grammarRule': 'Idiomatische Wendung mit Dativ und Wechselpräposition',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-049',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Kommasetzung',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Nichtsdestotrotz, oder besser gesagt, gerade deswegen fuhr er fort.',
      'Nichtsdestotrotz oder besser gesagt gerade deswegen fuhr er fort.',
      'Nichtsdestotrotz, oder besser gesagt gerade deswegen fuhr er fort.',
      'Nichtsdestotrotz oder, besser gesagt, gerade deswegen fuhr er fort.'
    ],
    'correctAnswer': 3,
    'explanation': '"Besser gesagt" als eingeschobener Kommentar wird durch paarige Kommas eingeschlossen.',
    'exampleSentence': 'Nichtsdestotrotz oder, besser gesagt, gerade deswegen fuhr er fort.',
    'grammarRule': 'Paarige Kommas bei parenthetischem Einschub',
    'tags': ['satzkorrektur']
  },
  {
    'language': 'german', 'id': 'c2-satzkorrektur-p5-050',
    'level': 'c2',
    'category': 'Satzkorrektur',
    'subcategory': 'Rektion',
    'question': 'Welcher Satz ist grammatisch korrekt?',
    'options': [
      'Er hat sich des Problems erbarmt.',
      'Er hat sich dem Problem erbarmt.',
      'Er hat sich das Problem erbarmt.',
      'Er hat sich des Problems erbarmen.'
    ],
    'correctAnswer': 0,
    'explanation': '"Sich einer Sache erbarmen" regiert den Genitiv: "des Problems".',
    'exampleSentence': 'Er hat sich des Problems erbarmt.',
    'grammarRule': 'Genitivrektion bei "sich erbarmen"',
    'tags': ['satzkorrektur']
  }
];

export default questions;
