import { LanguageMeta, CategoryMeta, GermanLevelMeta } from '@/types/question';

// German-specific metadata
export const germanLevels: GermanLevelMeta[] = [
  { slug: 'b1', name: 'B1', fullName: 'B1 — Mittelstufe', icon: '🟢', color: 'from-green-500 to-emerald-600', totalQuestions: 11700 },
  { slug: 'b2', name: 'B2', fullName: 'B2 — Gute Mittelstufe', icon: '🔵', color: 'from-blue-500 to-cyan-600', totalQuestions: 11700 },
  { slug: 'c1', name: 'C1', fullName: 'C1 — Fortgeschritten', icon: '🟠', color: 'from-orange-500 to-amber-600', totalQuestions: 11700 },
  { slug: 'c2', name: 'C2', fullName: 'C2 — Annähernd muttersprachlich', icon: '🔴', color: 'from-red-500 to-rose-600', totalQuestions: 11700 },
];

export const germanCategories: CategoryMeta[] = [
  { slug: 'artikel', name: 'Artikel & Genus', description: 'der/die/das, Genusregeln', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'pluralbildung', name: 'Pluralbildung', description: 'Pluralendungen, unregelmäßige Formen', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'konjugation', name: 'Verbkonjugation', description: 'Präsens, Präteritum, Perfekt', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'modalverben', name: 'Modalverben', description: 'können, müssen, dürfen, sollen, wollen', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'passiv', name: 'Passiv', description: 'Vorgangs-/Zustandspassiv', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'konjunktiv', name: 'Konjunktiv I & II', description: 'Indirekte Rede, Irrealis', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'praepositionen', name: 'Präpositionen', description: 'Wechselpräpositionen, Verb-Präp.-Verbindungen', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'adjektivdeklination', name: 'Adjektivdeklination', description: 'starke/schwache/gemischte Deklination', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'pronomen', name: 'Pronomen', description: 'Personal-, Relativ-, Reflexivpronomen', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'satzbau', name: 'Satzstruktur', description: 'Hauptsatz, Inversion, Satzklammer', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'nebensaetze', name: 'Nebensätze', description: 'weil/dass/ob/wenn + Verbendstellung', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'relativsaetze', name: 'Relativsätze', description: 'Relativpronomen, wo/wohin', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'nv-verbindungen', name: 'Nomen-Verb-Verbindungen', description: 'Entscheidung treffen, Rücksicht nehmen', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'wortschatz', name: 'Wortschatz', description: 'Synonyme, Antonyme, Wortfamilien', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'redewendungen', name: 'Redewendungen', description: 'Idiome, Sprichwörter', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'wortbildung', name: 'Wortbildung', description: 'Komposita, Präfixe, Suffixe', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'konnektoren', name: 'Konnektoren', description: 'zweiteilige Konnektoren, Satzadverbien', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'zeitformen', name: 'Zeitformen & Tempus', description: 'Futur, Plusquamperfekt, Tempuswahl', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'indirekte-rede', name: 'Indirekte Rede', description: 'Konjunktiv I in Berichten', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'textgrammatik', name: 'Textgrammatik', description: 'Kohäsion, Textsorten, Register', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'satzkorrektur', name: 'Satzkorrektur', description: 'Finde und korrigiere den Fehler im Satz', questionCount: 500, levels: {}, parts: 10 },
  { slug: 'satzbildung', name: 'Satzbildung', description: 'Wähle den grammatisch richtigen Satz', questionCount: 500, levels: {}, parts: 10 },
  { slug: 'lueckentext', name: 'Lückentext', description: 'Ergänze das fehlende Wort im Satz', questionCount: 500, levels: {}, parts: 10 },
  { slug: 'umformung', name: 'Umformung', description: 'Formuliere den Satz korrekt um', questionCount: 500, levels: {}, parts: 10 },
  { slug: 'satzmix', name: 'Satzmix', description: 'Gemischte Satzübungen — alle Grammatikthemen', questionCount: 500, levels: {}, parts: 10 },
  { slug: 'sprichwoerter', name: 'Sprichwörter & Redewendungen', description: 'Bedeutung von Redewendungen, Sprichwörtern und Idiomen', questionCount: 1250, levels: {}, parts: 25 },
  { slug: 'daf-wortschatz', name: 'DAF-Wortschatz B2–C1', description: 'Prüfungswortschatz für DAF C1 — Synonyme, Redemittel, Wissenschaftssprache', questionCount: 750, levels: {}, parts: 15, availableLevels: ['b2', 'c1'] },
  { slug: 'umgangssprache', name: 'Umgangssprache', description: 'Alltagsdeutsch — Slang, Partikel, Smalltalk, Ironie, Verschleifungen, Dialekte', questionCount: 1460, levels: {}, parts: 30 },
  { slug: 'verb-praepositionen', name: 'Verb + Präposition', description: 'warten auf, sich freuen über, denken an — feste Verb-Präposition-Verbindungen', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'nominalstil', name: 'Nominalstil / Verbalstil', description: 'Verbal- und Nominalumformung — Analyse → analysieren', questionCount: 150, levels: {}, parts: 3 },
  { slug: 'partizipialattribute', name: 'Partizipialattribute', description: 'Erweiterte Partizipien als Attribute — der am Fenster stehende Mann', questionCount: 100, levels: {}, parts: 2 },
  { slug: 'redemittel', name: 'Redemittel', description: 'Formelle Wendungen für Einleitung, Argumentation, Schluss', questionCount: 100, levels: {}, parts: 2 },
  { slug: 'wissenschaftssprache', name: 'Wissenschaftssprache', description: 'Akademischer Wortschatz — konstatieren, verifizieren, signifikant', questionCount: 150, levels: {}, parts: 3 },
  { slug: 'genitiv', name: 'Genitiv-Konstruktionen', description: 'Genitiv-Präpositionen, -attribute und -formen', questionCount: 150, levels: {}, parts: 3 },
];

// English Business — levels & categories
export const englishLevels: GermanLevelMeta[] = [
  { slug: 'b1', name: 'B1', fullName: 'B1 — Intermediate', icon: '🟢', color: 'from-green-500 to-emerald-600', totalQuestions: 3550 },
  { slug: 'b2', name: 'B2', fullName: 'B2 — Upper Intermediate', icon: '🔵', color: 'from-blue-500 to-cyan-600', totalQuestions: 3550 },
  { slug: 'c1', name: 'C1', fullName: 'C1 — Advanced', icon: '🟠', color: 'from-orange-500 to-amber-600', totalQuestions: 3550 },
  { slug: 'c2', name: 'C2', fullName: 'C2 — Proficiency', icon: '🔴', color: 'from-red-500 to-rose-600', totalQuestions: 3550 },
];

export const englishCategories: CategoryMeta[] = [
  { slug: 'email', name: 'Email & Written Communication', description: 'Subject lines, tone, follow-ups, formal vs semi-formal', questionCount: 300, levels: {}, parts: 6 },
  { slug: 'meetings', name: 'Meetings & Calls', description: 'Chairing, interrupting, summarizing, action items', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'presentations', name: 'Presentations & Pitches', description: 'Opening hooks, transitions, data commentary, Q&A', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'negotiations', name: 'Negotiations & Deals', description: 'Offers, counter-offers, concessions, closing deals', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'smalltalk', name: 'Smalltalk & Networking', description: 'Elevator pitch, events, LinkedIn, breaking ice', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'hr', name: 'HR & Hiring', description: 'Interviews, feedback, performance reviews, onboarding', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'finance', name: 'Finance & Numbers', description: 'Reports, P&L, KPIs, budgets, forecasts', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'marketing', name: 'Marketing & Sales', description: 'Funnel, conversion, ROI, pitch decks, proposals', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'project-mgmt', name: 'Project Management', description: 'Scrum terms, deadlines, blockers, status updates', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'legal', name: 'Legal & Contracts', description: 'NDA, SLA, terms & conditions, compliance', questionCount: 150, levels: {}, parts: 3 },
  { slug: 'idioms', name: 'Business Idioms', description: 'Move the needle, low-hanging fruit, circle back', questionCount: 250, levels: {}, parts: 5 },
  { slug: 'phrasal-verbs', name: 'Business Phrasal Verbs', description: 'Roll out, ramp up, sign off, follow up', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'confusing-words', name: 'Confusing Words & Grammar', description: 'Affect/effect, ensure/insure, tense in reports', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'cross-cultural', name: 'Cross-cultural Communication', description: 'US vs UK vs AU, directness, humor, hierarchy', questionCount: 150, levels: {}, parts: 3 },
  { slug: 'startup', name: 'Startup & Tech Business', description: 'Fundraising, pivoting, burn rate, term sheets', questionCount: 200, levels: {}, parts: 4 },
  { slug: 'leadership', name: 'Leadership & Management', description: 'Delegation, 1-on-1s, OKRs, conflict resolution', questionCount: 150, levels: {}, parts: 3 },
  { slug: 'remote-work', name: 'Remote Work & Slack', description: 'Async communication, Slack etiquette, standups', questionCount: 150, levels: {}, parts: 3 },
  { slug: 'diplomacy', name: 'Formal Register & Diplomacy', description: 'Softening, hedging, passive for politics', questionCount: 150, levels: {}, parts: 3 },
];

export const languages: LanguageMeta[] = [
  {
    slug: 'java',
    name: 'Java',
    icon: '☕',
    color: 'from-orange-500 to-red-600',
    totalQuestions: 3500,
    categories: [
      { slug: 'core', name: 'Core Java', description: 'Primitives, strings, operators, control flow, exceptions', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'oop', name: 'OOP', description: 'Classes, inheritance, polymorphism, interfaces, abstract classes', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'collections', name: 'Collections', description: 'List, Set, Map, Queue, internals, performance', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'concurrency', name: 'Concurrency', description: 'Threads, synchronization, executors, locks, atomic', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'streams', name: 'Streams & Lambdas', description: 'Functional interfaces, streams API, Optional, method references', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'jvm', name: 'JVM & GC', description: 'Memory model, garbage collectors, class loading, JIT', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'spring', name: 'Spring', description: 'IoC, DI, Spring Boot, MVC, Security, Data', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'patterns', name: 'Design Patterns', description: 'GoF patterns, SOLID, architectural patterns', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'testing', name: 'Testing', description: 'JUnit, Mockito, TDD, integration testing', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'sql', name: 'SQL & JDBC', description: 'SQL queries, JDBC, connection pooling, transactions', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
    ],
  },
  {
    slug: 'scala',
    name: 'Scala',
    icon: '🔴',
    color: 'from-red-500 to-pink-600',
    totalQuestions: 4900,
    categories: [
      { slug: 'core', name: 'Core Scala', description: 'Vals, vars, types, pattern matching, case classes', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'fp', name: 'Functional Programming', description: 'HOFs, immutability, monads, for-comprehensions', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'collections', name: 'Collections', description: 'Seq, Set, Map, immutable vs mutable, LazyList', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'concurrency', name: 'Concurrency', description: 'Futures, Promises, parallel collections, async', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'typesystem', name: 'Type System', description: 'Generics, variance, type bounds, implicits, type classes', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'zio', name: 'ZIO', description: 'ZIO effects, layers, fibers, error handling', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'cats', name: 'Cats', description: 'Typeclasses, Monad, Applicative, IO, tagless final', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'akka', name: 'Akka', description: 'Actors, streams, supervision, clustering', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'http4s', name: 'http4s & Play', description: 'HTTP servers, routing, middleware, JSON', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'testing', name: 'Testing', description: 'ScalaTest, specs2, property-based testing', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'scala3', name: 'Scala 3', description: 'Enums, given/using, opaque types, extension methods, new syntax', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'patterns', name: 'Design Patterns', description: 'Cake pattern, tagless final, type classes, lens/optics', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'db', name: 'Database & Persistence', description: 'Slick, Doobie, Quill, Skunk, transactions', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'spark', name: 'Apache Spark', description: 'RDDs, DataFrames, SparkSQL, Streaming, Catalyst', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
    ],
  },
  {
    slug: 'kotlin',
    name: 'Kotlin',
    icon: '🟣',
    color: 'from-purple-500 to-indigo-600',
    totalQuestions: 3000,
    categories: [
      { slug: 'core', name: 'Core Kotlin', description: 'Null safety, data classes, sealed classes, extensions', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'coroutines', name: 'Coroutines', description: 'Suspend functions, dispatchers, channels, structured concurrency', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'collections', name: 'Collections', description: 'Sequences, grouping, transformations, performance', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'arrow', name: 'Arrow & FP', description: 'Either, Option, IO, optics, functional patterns', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'ktor', name: 'Ktor', description: 'Server, client, routing, serialization, plugins', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'flow', name: 'Flow', description: 'Cold/hot flows, StateFlow, SharedFlow, operators', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'android', name: 'Android Basics', description: 'Activities, fragments, Jetpack Compose, ViewModel', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'testing', name: 'Testing', description: 'JUnit5, MockK, coroutine testing, UI testing', questionCount: 333, levels: { level1: 84, level2: 83, level3: 83, level4: 83 } },
      { slug: 'gradle', name: 'Gradle & Build', description: 'Kotlin DSL, plugins, multi-module, dependency management', questionCount: 336, levels: { level1: 84, level2: 84, level3: 84, level4: 84 } },
    ],
  },
  {
    slug: 'flutter',
    name: 'Flutter',
    icon: '💙',
    color: 'from-sky-400 to-blue-600',
    totalQuestions: 4200,
    categories: [
      { slug: 'dart-core', name: 'Dart Core', description: 'Variables, types, null safety, async/await, streams, isolates', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'widgets', name: 'Widgets', description: 'StatelessWidget, StatefulWidget, lifecycle, keys, BuildContext, InheritedWidget', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'state', name: 'State Management', description: 'setState, Provider, Riverpod, ChangeNotifier, ValueNotifier', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'bloc', name: 'BLoC Pattern', description: 'Cubit, Bloc, BlocProvider, BlocBuilder, BlocListener, events, states', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'navigation', name: 'Navigation & Routing', description: 'Navigator 1.0/2.0, GoRouter, deep linking, named routes, route guards', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'layout', name: 'Layout & UI', description: 'Row, Column, Stack, Flex, constraints, responsive design, Slivers', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'animations', name: 'Animations', description: 'Implicit/explicit animations, Hero, AnimationController, Tween, CustomPainter', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'networking', name: 'Networking & Data', description: 'HTTP, Dio, REST APIs, JSON serialization, GraphQL, WebSockets', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'storage', name: 'Persistence & Storage', description: 'SharedPreferences, Hive, Drift/SQLite, Firebase, secure storage', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'testing', name: 'Testing', description: 'Widget testing, unit testing, integration testing, golden tests, mocking', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'platform', name: 'Platform Integration', description: 'Platform channels, plugins, FFI, platform-specific code, method channels', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'performance', name: 'Performance & DevTools', description: 'Widget rebuild optimization, DevTools, profiling, tree shaking, const constructors', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
    ],
  },
  {
    slug: 'ddia',
    name: 'DDIA',
    icon: '📖',
    color: 'from-emerald-500 to-teal-600',
    totalQuestions: 816,
    categories: [
      { slug: 'reliability', name: 'Reliability & Scalability', description: 'Reliability, scalability, maintainability, load parameters, latency percentiles', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'data-models', name: 'Data Models', description: 'Relational model, document model, graph model, query languages, Datalog', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'storage', name: 'Storage & Retrieval', description: 'Log-structured storage, B-Trees, hash indexes, LSM-Trees, column storage, OLAP', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'encoding', name: 'Encoding & Evolution', description: 'JSON/XML/Binary, Thrift/Protocol Buffers, Avro, schema evolution, compatibility', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'replication', name: 'Replication', description: 'Single-leader, multi-leader, leaderless, quorums, conflict resolution', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'partitioning', name: 'Partitioning', description: 'Key-range, hash partitioning, secondary indexes, rebalancing, request routing', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'transactions', name: 'Transactions', description: 'ACID, isolation levels, snapshot isolation, serializability, 2PL, SSI', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'distributed', name: 'Distributed Problems', description: 'Unreliable networks, clocks, process pauses, Byzantine faults, failure detection', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'consistency', name: 'Consistency & Consensus', description: 'Linearizability, causal consistency, total order broadcast, Raft, Paxos, ZooKeeper', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'batch', name: 'Batch Processing', description: 'MapReduce, dataflow engines, sort-merge joins, broadcast joins, materialized views', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'stream', name: 'Stream Processing', description: 'Event sourcing, CDC, stream joins, time windows, exactly-once semantics', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
      { slug: 'future', name: 'Future of Data Systems', description: 'Data integration, unbundling databases, lambda architecture, end-to-end arguments, ethics', questionCount: 68, levels: { level1: 17, level2: 17, level3: 17, level4: 17 } },
    ],
  },
  {
    slug: 'ai-engineer',
    name: 'AI Engineer',
    icon: '🤖',
    color: 'from-cyan-500 to-blue-600',
    totalQuestions: 1700,
    categories: [
      { slug: 'python-ml', name: 'Python & ML Fundamentals', description: 'NumPy, Pandas, data structures, generators, async Python', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'ml-core', name: 'Machine Learning Core', description: 'Classical ML, metrics, boosting, causal inference, feature engineering', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'deep-learning', name: 'Deep Learning', description: 'Neural networks, RNNs, CNNs, quantization, diffusion models', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'nlp-transformers', name: 'NLP & Transformers', description: 'Tokenizers, attention mechanisms, MoE, long context handling', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'llm-engineering', name: 'LLM Engineering', description: 'Prompt engineering, RAG, LoRA, fine-tuning, inference optimization', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'computer-vision', name: 'Computer Vision', description: 'Image processing, object detection, 3D vision, NAS', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'mlops', name: 'MLOps', description: 'Experiment tracking, pipelines, model drift, ML platforms', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'vector-db', name: 'Vector Databases & Embeddings', description: 'Embeddings, ANN search, hybrid search, training strategies', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'ai-system-design', name: 'AI System Design', description: 'System design for ML, caching, multi-tenant platforms, scaling', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'math-stats', name: 'Math & Statistics', description: 'Linear algebra, probability, kernels, variational inference', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'responsible-ai', name: 'Responsible AI', description: 'Fairness, privacy, red teaming, EU AI Act, bias mitigation', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'ai-agents', name: 'AI Agents & Tool Use', description: 'Tool calling, ReAct, multi-agent systems, planning, orchestration', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'data-engineering', name: 'Data Engineering for AI', description: 'Data quality, ETL pipelines, streaming, data mesh, feature stores', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'model-eval', name: 'Model Evaluation', description: 'Metrics, A/B testing, calibration, fairness evaluation, experimentation', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'multimodal', name: 'Multimodal AI', description: 'Image-text models, audio processing, video understanding, multimodal RAG', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'production-infra', name: 'Production AI Infrastructure', description: 'Model serving, GPU optimization, autoscaling, edge deployment', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
      { slug: 'ai-safety', name: 'AI Safety & Alignment', description: 'Content filtering, RLHF, watermarking, oversight, alignment research', questionCount: 100, levels: { level1: 34, level2: 33, level3: 33, level4: 33 } },
    ],
  },
  {
    slug: 'kafka',
    name: 'Apache Kafka',
    icon: '📨',
    color: 'from-slate-600 to-gray-800',
    totalQuestions: 460,
    categories: [
      { slug: 'core', name: 'Core Concepts', description: 'Topics, partitions, offsets, brokers, ZooKeeper/KRaft', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'producers', name: 'Producers', description: 'Acks, batching, idempotency, serialization, partitioning', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'consumers', name: 'Consumers', description: 'Consumer groups, rebalancing, commits, lag, polling', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'streams', name: 'Kafka Streams', description: 'KTable, KStream, joins, windowing, state stores', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'connect', name: 'Kafka Connect', description: 'Source/sink connectors, SMTs, distributed mode', questionCount: 40, levels: { level1: 10, level2: 10, level3: 10, level4: 10 } },
      { slug: 'schema', name: 'Schema Registry', description: 'Avro, Protobuf, JSON Schema, compatibility modes', questionCount: 40, levels: { level1: 10, level2: 10, level3: 10, level4: 10 } },
      { slug: 'security', name: 'Security', description: 'SASL, ACLs, SSL/TLS, authentication, authorization', questionCount: 30, levels: { level1: 8, level2: 8, level3: 7, level4: 7 } },
      { slug: 'ops', name: 'Operations & Internals', description: 'Replication, ISR, leader election, log compaction, monitoring', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'performance', name: 'Performance Tuning', description: 'Throughput, latency, compression, batch size, linger.ms', questionCount: 40, levels: { level1: 10, level2: 10, level3: 10, level4: 10 } },
      { slug: 'transactions', name: 'Transactions & EOS', description: 'Exactly-once semantics, transactional producers, isolation levels', questionCount: 30, levels: { level1: 8, level2: 8, level3: 7, level4: 7 } },
      { slug: 'scala-kafka', name: 'Kafka with Scala', description: 'ZIO-kafka, fs2-kafka, Alpakka Kafka, Akka Streams Kafka', questionCount: 30, levels: { level1: 8, level2: 8, level3: 7, level4: 7 } },
    ],
  },
  {
    slug: 'algorithms',
    name: 'Algorithms & Data Structures',
    icon: '🧩',
    color: 'from-violet-500 to-purple-600',
    totalQuestions: 1200,
    categories: [
      { slug: 'arrays-strings', name: 'Arrays & Strings', description: 'Two pointers, sliding window, prefix sums, in-place manipulation', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'hash-maps', name: 'Hash Maps & Sets', description: 'Frequency counting, anagram patterns, two sum, grouping', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'linked-lists', name: 'Linked Lists', description: 'Reversal, cycle detection, merge, slow/fast pointers, doubly linked', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'stacks-queues', name: 'Stacks & Queues', description: 'Monotonic stack, BFS with queue, valid parentheses, min stack', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'trees-bst', name: 'Trees & BST', description: 'Traversals, LCA, serialization, balanced trees, segment trees', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'graphs', name: 'Graphs', description: 'DFS/BFS, topological sort, shortest path, union-find, MST', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'dynamic-programming', name: 'Dynamic Programming', description: 'Memoization, tabulation, knapsack, subsequences, interval DP', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'binary-search', name: 'Binary Search', description: 'On sorted arrays, on answer space, rotated arrays, search bounds', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'heap-priority-queue', name: 'Heap & Priority Queue', description: 'Top-K elements, merge K sorted, median from stream, scheduling', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'recursion-backtracking', name: 'Recursion & Backtracking', description: 'Permutations, combinations, N-queens, sudoku, constraint propagation', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'sorting-searching', name: 'Sorting & Searching', description: 'Merge sort, quick sort, counting sort, comparators, order statistics', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'bit-manipulation-math', name: 'Bit Manipulation & Math', description: 'XOR tricks, power of 2, GCD, modular arithmetic, combinatorics', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
    ],
  },
  {
    slug: 'behavioral',
    name: 'Behavioral Interview',
    icon: '🎯',
    color: 'from-amber-500 to-orange-600',
    totalQuestions: 1200,
    categories: [
      { slug: 'conflict-resolution', name: 'Conflict Resolution', description: 'Disagreements with teammates, managers, cross-team friction, difficult conversations', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'communication', name: 'Communication & Collaboration', description: 'Giving/receiving feedback, status updates, cross-functional alignment, active listening', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'leadership', name: 'Leadership & Influence', description: 'Leading without authority, driving alignment, mentoring, sponsoring others', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'decision-making', name: 'Decision Making & Judgment', description: 'Trade-off analysis, reversible vs irreversible decisions, data-driven choices, risk assessment', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'ambiguity', name: 'Dealing with Ambiguity', description: 'Unclear requirements, shifting priorities, incomplete information, scoping undefined problems', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'prioritization', name: 'Prioritization & Time Management', description: 'Competing deadlines, saying no, urgency vs importance, managing interruptions', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'failure-resilience', name: 'Failure & Resilience', description: 'Handling mistakes, postmortems, bouncing back, accountability, learning from failure', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'technical-leadership', name: 'Technical Leadership', description: 'Architecture decisions, tech debt negotiations, code review culture, design doc processes', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'stakeholder-mgmt', name: 'Stakeholder Management', description: 'Managing up, cross-org alignment, executive communication, expectation setting', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'project-delivery', name: 'Project Delivery & Execution', description: 'Scoping, estimation, unblocking teams, shipping under pressure, managing dependencies', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'growth-mindset', name: 'Growth & Self-Awareness', description: 'Receiving feedback, identifying blind spots, career growth, self-reflection, adapting style', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
      { slug: 'team-culture', name: 'Team Culture & Inclusion', description: 'Psychological safety, onboarding, DEI in practice, building trust, remote dynamics', questionCount: 100, levels: { level1: 25, level2: 25, level3: 25, level4: 25 } },
    ],
  },
  {
    slug: 'git',
    name: 'Git',
    icon: '🔀',
    color: 'from-orange-600 to-red-700',
    totalQuestions: 710,
    categories: [
      { slug: 'basics', name: 'Basics', description: 'init, clone, add, commit, status, diff, log, .gitignore', questionCount: 80, levels: { level1: 20, level2: 20, level3: 20, level4: 20 } },
      { slug: 'branching', name: 'Branching & Merging', description: 'branch, merge, fast-forward, conflicts, strategies', questionCount: 80, levels: { level1: 20, level2: 20, level3: 20, level4: 20 } },
      { slug: 'remote', name: 'Remote Operations', description: 'push, pull, fetch, remote, upstream, fork workflow', questionCount: 60, levels: { level1: 15, level2: 15, level3: 15, level4: 15 } },
      { slug: 'rebase', name: 'Rebase & History', description: 'rebase, interactive rebase, squash, cherry-pick, reflog', questionCount: 70, levels: { level1: 18, level2: 18, level3: 17, level4: 17 } },
      { slug: 'stash', name: 'Stash & Worktree', description: 'stash push/pop/apply, worktree add, partial stash', questionCount: 40, levels: { level1: 10, level2: 10, level3: 10, level4: 10 } },
      { slug: 'reset', name: 'Reset & Revert', description: 'reset soft/mixed/hard, revert, restore, checkout --, clean', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'tags', name: 'Tags & Releases', description: 'lightweight vs annotated, signing, pushing tags, semver', questionCount: 30, levels: { level1: 8, level2: 8, level3: 7, level4: 7 } },
      { slug: 'internals', name: 'Git Internals', description: 'objects (blob/tree/commit/tag), SHA-1, packfiles, index', questionCount: 60, levels: { level1: 15, level2: 15, level3: 15, level4: 15 } },
      { slug: 'config', name: 'Advanced Config', description: 'aliases, hooks, gitattributes, sparse checkout', questionCount: 40, levels: { level1: 10, level2: 10, level3: 10, level4: 10 } },
      { slug: 'submodules', name: 'Submodules & Subtrees', description: 'submodule add/update, subtree merge, monorepo patterns', questionCount: 30, levels: { level1: 8, level2: 8, level3: 7, level4: 7 } },
      { slug: 'workflows', name: 'Git Workflows', description: 'GitFlow, trunk-based, GitHub Flow, feature flags', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'debugging', name: 'Debugging & Forensics', description: 'bisect, blame, log --grep, fsck, rerere', questionCount: 40, levels: { level1: 10, level2: 10, level3: 10, level4: 10 } },
      { slug: 'github', name: 'GitHub/GitLab Features', description: 'PRs, code review, Actions/CI, protected branches, CODEOWNERS', questionCount: 50, levels: { level1: 13, level2: 13, level3: 12, level4: 12 } },
      { slug: 'scale', name: 'Performance & Scale', description: 'shallow clone, partial clone, git-lfs, large repos', questionCount: 30, levels: { level1: 8, level2: 8, level3: 7, level4: 7 } },
    ],
  },
  {
    slug: 'docker',
    name: 'Docker',
    icon: '🐳',
    color: 'from-blue-500 to-sky-600',
    totalQuestions: 2800,
    categories: [
      { slug: 'core', name: 'Core Concepts', description: 'Images, containers, layers, registries, Docker Engine', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'dockerfile', name: 'Dockerfile', description: 'FROM, RUN, COPY, ENTRYPOINT, multi-stage builds, best practices', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'networking', name: 'Networking', description: 'Bridge, host, overlay, port mapping, DNS, service discovery', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'volumes', name: 'Volumes & Storage', description: 'Volumes, bind mounts, tmpfs, storage drivers, data persistence', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'compose', name: 'Docker Compose', description: 'Services, depends_on, networks, volumes, profiles, watch', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'security', name: 'Security', description: 'Rootless, capabilities, seccomp, AppArmor, image scanning, secrets', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'orchestration', name: 'Orchestration', description: 'Docker Swarm, Kubernetes basics, scaling, rolling updates, health checks', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'cicd', name: 'CI/CD & DevOps', description: 'GitHub Actions, GitLab CI, buildx, multi-platform, caching, registries', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
    ],
  },
  {
    slug: 'kubernetes',
    name: 'Kubernetes',
    icon: '☸️',
    color: 'from-indigo-500 to-blue-700',
    totalQuestions: 3850,
    categories: [
      { slug: 'core', name: 'Core Concepts', description: 'Pods, Nodes, Namespaces, clusters, API server, etcd, kubelet', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'workloads', name: 'Workloads & Controllers', description: 'Deployments, ReplicaSets, StatefulSets, DaemonSets, Jobs, CronJobs', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'networking', name: 'Services & Networking', description: 'ClusterIP, NodePort, LoadBalancer, Ingress, NetworkPolicies, DNS, CNI', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'storage', name: 'Storage', description: 'PersistentVolumes, PVCs, StorageClasses, CSI drivers, volume types', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'configuration', name: 'Configuration', description: 'ConfigMaps, Secrets, env vars, resource limits, LimitRanges, ResourceQuotas', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'security', name: 'Security & RBAC', description: 'Roles, ClusterRoles, ServiceAccounts, PodSecurityStandards, OPA/Gatekeeper', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'helm', name: 'Helm & Packaging', description: 'Charts, values, templates, hooks, repositories, Kustomize', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'observability', name: 'Observability', description: 'Metrics Server, Prometheus, probes, logging, events, kubectl debug', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'crds', name: 'CRDs & Operators', description: 'Custom Resource Definitions, operator pattern, controller-runtime, OLM', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'scheduling', name: 'Scheduling & Scaling', description: 'Affinity, taints/tolerations, HPA, VPA, cluster autoscaler, PDB', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'troubleshooting', name: 'Troubleshooting', description: 'CrashLoopBackOff, ImagePullBackOff, kubectl logs/describe/exec, debugging', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
    ],
  },
  {
    slug: 'postgresql',
    name: 'PostgreSQL & SQL',
    icon: '🐘',
    color: 'from-blue-600 to-indigo-700',
    totalQuestions: 2800,
    categories: [
      { slug: 'sql-basics', name: 'SQL Fundamentals', description: 'SELECT, INSERT, UPDATE, DELETE, WHERE, JOIN basics', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'joins-subqueries', name: 'JOINs & Subqueries', description: 'INNER, LEFT, RIGHT, FULL, CROSS JOIN, CTEs, correlated subqueries', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'indexes', name: 'Indexes & Performance', description: 'B-tree, GiST, GIN, BRIN, EXPLAIN ANALYZE, query optimization', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'transactions', name: 'Transactions & Concurrency', description: 'ACID, isolation levels, MVCC, locks, deadlocks', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'data-types', name: 'Data Types & Functions', description: 'JSON/JSONB, arrays, hstore, window functions, aggregates', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'schema-design', name: 'Schema Design', description: 'Normalization, constraints, foreign keys, partitioning, inheritance', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'admin', name: 'Administration', description: 'pg_dump, replication, VACUUM, WAL, connection pooling, monitoring', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
      { slug: 'advanced', name: 'Advanced PostgreSQL', description: 'Extensions, PL/pgSQL, triggers, FDW, logical replication, pg_stat', questionCount: 350, levels: { level1: 88, level2: 88, level3: 87, level4: 87 } },
    ],
  },
  {
    slug: 'german',
    name: 'Deutsche Grammatik',
    icon: '🇩🇪',
    color: 'from-yellow-500 to-red-600',
    totalQuestions: 46800,
    categories: [],
  },
  {
    slug: 'english',
    name: 'Business English',
    icon: '🇬🇧',
    color: 'from-blue-500 to-indigo-600',
    totalQuestions: 14200,
    categories: [],
  },
];

export function getLanguageMeta(slug: string): LanguageMeta | undefined {
  return languages.find((l) => l.slug === slug);
}

export function getCategoryMeta(languageSlug: string, categorySlug: string): CategoryMeta | undefined {
  const lang = getLanguageMeta(languageSlug);
  return lang?.categories.find((c) => c.slug === categorySlug);
}

export function getGermanLevelMeta(slug: string): GermanLevelMeta | undefined {
  return germanLevels.find((l) => l.slug === slug);
}

export function getGermanCategoryMeta(slug: string): CategoryMeta | undefined {
  return germanCategories.find((c) => c.slug === slug);
}

export function getEnglishLevelMeta(slug: string): GermanLevelMeta | undefined {
  return englishLevels.find((l) => l.slug === slug);
}

export function getEnglishCategoryMeta(slug: string): CategoryMeta | undefined {
  return englishCategories.find((c) => c.slug === slug);
}

// Multi-level languages (German, English) — use B1-C2 levels with parts
export const multiLevelLanguages = ['german', 'english'] as const;
export type MultiLevelLanguage = typeof multiLevelLanguages[number];

export function isMultiLevelLanguage(slug: string): slug is MultiLevelLanguage {
  return (multiLevelLanguages as readonly string[]).includes(slug);
}

export function getMultiLevelLevels(slug: string): GermanLevelMeta[] {
  if (slug === 'german') return germanLevels;
  if (slug === 'english') return englishLevels;
  return [];
}

export function getMultiLevelCategories(slug: string): CategoryMeta[] {
  if (slug === 'german') return germanCategories;
  if (slug === 'english') return englishCategories;
  return [];
}

export function getMultiLevelCategoryMeta(language: string, slug: string): CategoryMeta | undefined {
  return getMultiLevelCategories(language).find((c) => c.slug === slug);
}
