import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kafka-security-l4-001',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'SASL/OAUTHBEARER',
    question: 'In a production SASL/OAUTHBEARER deployment, what must you implement to replace the default unsecured callback handler?',
    options: [
      'A custom `AuthorizerPlugin` that validates JWT signatures',
      'Custom `AuthenticateCallbackHandler` implementations for both login and server-side validation',
      'A ZooKeeper watcher that refreshes tokens every 5 minutes',
      'A custom `SslEngineFactory` that embeds OAuth token exchange',
    ],
    correctAnswer: 1,
    explanation: 'You must provide a custom `AuthenticateCallbackHandler` for the login side (token retrieval) and another for the broker side (token validation/signature verification), registered via `sasl.login.callback.handler.class` and `sasl.server.callback.handler.class`.',
    codeSnippet: `sasl.login.callback.handler.class=com.example.MyTokenRetriever
sasl.server.callback.handler.class=com.example.MyTokenValidator`,
    tags: ['kafka', 'oauth', 'oauthbearer', 'callback-handler'],
  },
  {
    id: 'kafka-security-l4-002',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'SSL/TLS',
    question: 'What is the purpose of `ssl.principal.mapping.rules` in Kafka?',
    options: [
      'It defines cipher suite priority order for TLS negotiation',
      'It applies regex-based transformation rules to convert the SSL certificate DN into a short Kafka principal name',
      'It restricts which IP addresses can present SSL certificates',
      'It maps Kerberos realms to SSL certificate issuers',
    ],
    correctAnswer: 1,
    explanation: '`ssl.principal.mapping.rules` (formerly `ssl.principal.name`) uses a list of RULE:/pattern/replacement/ expressions to shorten DNs like `CN=alice,OU=eng,O=corp` into just `alice`.',
    codeSnippet: 'ssl.principal.mapping.rules=RULE:^CN=(.*?),.*$${\\1}/,DEFAULT',
    tags: ['kafka', 'ssl', 'principal-mapping', 'dn'],
  },
  {
    id: 'kafka-security-l4-003',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'Authorization',
    question: 'What does Kafka\'s `AclAuthorizer` do when it receives an authorization request for a prefixed resource pattern?',
    options: [
      'It ignores prefix patterns and only evaluates literal matches',
      'It matches the request against all PREFIXED ACLs whose pattern is a prefix of the resource name, as well as any LITERAL or WILDCARD ACLs',
      'It delegates to ZooKeeper for all prefix evaluations',
      'It always denies access if multiple prefix patterns match',
    ],
    correctAnswer: 1,
    explanation: 'Kafka ACLs support LITERAL, PREFIXED, and WILDCARD resource patterns. The authorizer evaluates all matching patterns and grants access if any Allow ACL matches and no Deny ACL takes precedence.',
    tags: ['kafka', 'acl', 'prefix-pattern', 'authorization'],
  },
  {
    id: 'kafka-security-l4-004',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'SASL/SCRAM',
    question: 'In KRaft mode (without ZooKeeper), where are SASL/SCRAM credentials stored?',
    options: [
      'In a local file on each broker\'s data directory',
      'In the `__cluster_metadata` topic managed by the KRaft controller',
      'In a dedicated `__scram_credentials` internal topic',
      'SCRAM is not supported in KRaft mode',
    ],
    correctAnswer: 1,
    explanation: 'KRaft stores all cluster metadata including SCRAM credentials in the `__cluster_metadata` topic, replacing the ZooKeeper `/config/users` path.',
    tags: ['kafka', 'scram', 'kraft', 'credentials'],
  },
  {
    id: 'kafka-security-l4-005',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'Inter-broker Security',
    question: 'What is the risk of using a different listener for inter-broker replication vs. client-facing communication, and how is this controlled?',
    options: [
      'Different listeners cause partition skew; use `replication.factor=1` to avoid it',
      'Brokers might advertise the wrong listener to clients; controlled by `inter.broker.listener.name` which must match one defined in `listener.security.protocol.map`',
      'Using multiple listeners doubles memory usage for SSL sessions',
      'The risk is duplicated ACL checks; resolved by setting `skip.inter.broker.acl=true`',
    ],
    correctAnswer: 1,
    explanation: '`inter.broker.listener.name` pins the listener brokers use among themselves; mismatches between listener names and `listener.security.protocol.map` entries can cause replication failures.',
    codeSnippet: `listeners=CLIENT://0.0.0.0:9092,REPLICATION://0.0.0.0:9093
inter.broker.listener.name=REPLICATION
listener.security.protocol.map=CLIENT:SASL_SSL,REPLICATION:SSL`,
    tags: ['kafka', 'inter-broker', 'listener', 'security'],
  },
  {
    id: 'kafka-security-l4-006',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'ACLs',
    question: 'What happens when you add a DENY ACL and an ALLOW ACL for the same principal and resource in Kafka?',
    options: [
      'The ALLOW ACL wins because it is more specific',
      'The DENY ACL always wins over ALLOW for the same principal',
      'Both are ignored and the `allow.everyone.if.no.acl.found` setting determines access',
      'Kafka throws a configuration exception and rejects one of the ACLs',
    ],
    correctAnswer: 1,
    explanation: 'Kafka\'s ACL semantics follow a deny-overrides model: if any DENY ACL matches, access is rejected regardless of matching ALLOW ACLs.',
    tags: ['kafka', 'acl', 'deny', 'authorization-semantics'],
  },
  {
    id: 'kafka-security-l4-007',
    language: 'kafka',
    level: 'level4',
    category: 'Security',
    subcategory: 'SASL/GSSAPI',
    question: 'What is the purpose of the `refreshKrb5Config` option in a Kafka Kerberos JAAS config?',
    options: [
      'It forces the broker to re-read `krb5.conf` on every authentication, useful when the KDC address changes dynamically',
      'It refreshes the ticket-granting ticket every 30 minutes without any config reload',
      'It enables Kerberos credential delegation to downstream services',
      'It rotates the Kerberos keytab file automatically',
    ],
    correctAnswer: 0,
    explanation: 'Setting `refreshKrb5Config=true` in the JAAS `Krb5LoginModule` causes the JVM to reload `krb5.conf` on every login attempt, enabling dynamic KDC configuration in cloud environments.',
    codeSnippet: `KafkaClient {
  com.sun.security.auth.module.Krb5LoginModule required
  useKeyTab=true
  keyTab="/etc/kafka/kafka.keytab"
  refreshKrb5Config=true
  principal="kafka/host@REALM";
};`,
    tags: ['kafka', 'kerberos', 'jaas', 'gssapi'],
  },
];

export default questions;
