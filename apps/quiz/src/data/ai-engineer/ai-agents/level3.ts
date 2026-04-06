import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'ai-engineer-ai-agents-l3-001',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'In a multi-agent debate architecture, how does having agents argue opposing viewpoints improve output quality?',
    options: [
      'It doubles the token count, which always improves quality',
      'Adversarial deliberation forces each agent to address counterarguments, reducing bias and improving factual accuracy through dialectical reasoning',
      'It makes the process faster by parallelizing all work',
      'Debate architectures only work for creative writing tasks',
    ],
    correctAnswer: 1,
    explanation:
      'Multi-agent debate leverages adversarial dynamics where agents must defend positions against counterarguments. This dialectical process reduces individual model biases, catches errors through cross-examination, and tends to converge on more accurate and well-reasoned conclusions.',
    tags: ['multi-agent', 'debate', 'reasoning-quality'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-002',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Planning',
    question:
      'How does Monte Carlo Tree Search (MCTS) apply to LLM agent planning, and what advantage does it offer over greedy action selection?',
    options: [
      'MCTS randomly selects actions with no evaluation',
      'MCTS explores multiple possible action sequences through simulation and backpropagation, balancing exploration and exploitation to find higher-quality plans',
      'MCTS always selects the first available action',
      'MCTS is only applicable to board games and cannot be used with LLM agents',
    ],
    correctAnswer: 1,
    explanation:
      'MCTS applied to LLM agents involves building a search tree of possible action sequences, using the LLM to simulate outcomes, and backpropagating value estimates. This enables the agent to look ahead and evaluate trade-offs rather than greedily selecting the locally best action.',
    tags: ['planning', 'mcts', 'search', 'advanced'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-003',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'What is the "confused deputy" problem in the context of AI agents with tool access?',
    options: [
      'When the agent uses too many tools simultaneously',
      'When an agent with elevated privileges is tricked (via prompt injection or adversarial input) into misusing its authority on behalf of an attacker',
      'When two agents try to use the same tool at the same time',
      'When the agent cannot determine which tool to use',
    ],
    correctAnswer: 1,
    explanation:
      'The confused deputy problem occurs when an agent that has legitimate authority to perform actions is manipulated (through indirect prompt injection or adversarial inputs) into performing those actions in ways that serve an attacker\'s goals rather than the user\'s intent.',
    tags: ['safety', 'confused-deputy', 'prompt-injection', 'security'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-004',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Memory',
    question:
      'How can a hierarchical memory architecture (combining working memory, episodic memory, and semantic memory) improve agent performance on complex tasks?',
    options: [
      'It only increases the storage cost without any benefit',
      'It enables the agent to maintain immediate context (working), recall specific past experiences (episodic), and leverage general knowledge structures (semantic) for more informed decision-making',
      'It replaces the need for an LLM entirely',
      'It makes the agent forget information faster',
    ],
    correctAnswer: 1,
    explanation:
      'A hierarchical memory architecture mirrors human cognition: working memory holds the current context, episodic memory recalls specific past interactions and outcomes, and semantic memory stores generalized knowledge. Together, they allow the agent to make contextually rich, experience-informed decisions.',
    tags: ['memory', 'hierarchical', 'architecture', 'cognitive'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-005',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Evaluation',
    question:
      'When evaluating an agent on a benchmark, why can "pass@k" provide a more nuanced picture than simple accuracy?',
    options: [
      'pass@k is always lower than accuracy, making agents look worse',
      'pass@k measures the probability of getting at least one correct solution in k attempts, accounting for the stochastic nature of LLM-based agents',
      'pass@k ignores all incorrect attempts',
      'pass@k only applies to multiple-choice questions',
    ],
    correctAnswer: 1,
    explanation:
      'pass@k acknowledges that LLM-based agents are non-deterministic. It estimates the probability that at least one of k independent runs produces a correct solution, providing insight into the agent\'s capability ceiling versus its reliability.',
    tags: ['evaluation', 'pass-at-k', 'metrics', 'stochastic'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-006',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is "constrained decoding" and how does it ensure valid tool call generation?',
    options: [
      'It limits the model to generating only English text',
      'It restricts the LLM\'s token sampling at each step to only tokens that are valid continuations according to the tool\'s JSON Schema, guaranteeing syntactically valid output',
      'It reduces the model\'s vocabulary permanently',
      'It constrains the model to use only one tool per conversation',
    ],
    correctAnswer: 1,
    explanation:
      'Constrained decoding (used by frameworks like Outlines or guidance) masks invalid tokens at each generation step, ensuring the output always conforms to the specified JSON Schema. This eliminates malformed tool calls at the structural level.',
    tags: ['tool-calling', 'constrained-decoding', 'json-schema', 'reliability'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-007',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Frameworks',
    question:
      'How does LangGraph\'s checkpoint system enable "time-travel" debugging and human-in-the-loop workflows?',
    options: [
      'It stores all checkpoints on blockchain for immutability',
      'It persists the full graph state at each step, allowing developers to replay from any point, inspect state transitions, and inject human decisions before resuming',
      'It only saves the final output of the graph',
      'Checkpoints are only used for billing purposes',
    ],
    correctAnswer: 1,
    explanation:
      'LangGraph\'s checkpoint system serializes the complete graph state after each node execution. This enables rewinding to any previous state for debugging, branching from a past state to explore alternatives, and pausing execution for human review before continuing.',
    tags: ['frameworks', 'langgraph', 'checkpointing', 'debugging'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-008',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'ReAct Pattern',
    question:
      'What are the limitations of the ReAct pattern that led to the development of more sophisticated agent architectures?',
    options: [
      'ReAct has no limitations; it is the optimal architecture for all tasks',
      'ReAct can suffer from short-sighted reasoning, lacks explicit long-term planning, and may struggle with tasks requiring deep lookahead or backtracking',
      'ReAct cannot use any tools',
      'ReAct only works with GPT-3 and no other models',
    ],
    correctAnswer: 1,
    explanation:
      'ReAct\'s step-by-step approach can be myopic, making locally optimal choices without considering long-term consequences. It lacks explicit planning mechanisms, cannot easily backtrack from dead ends, and may be inefficient for tasks requiring multi-step lookahead, motivating architectures like plan-and-execute and tree search.',
    tags: ['react-pattern', 'limitations', 'architecture-evolution'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-009',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'What is the "society of mind" approach in multi-agent systems, and how does it handle emergent behavior?',
    options: [
      'It is a social media platform for AI agents',
      'It models intelligence as arising from the interaction of many simple specialist agents, where complex behavior emerges from their collective interactions rather than being explicitly programmed',
      'It requires all agents to use the same LLM model',
      'It prevents any emergent behavior through strict rules',
    ],
    correctAnswer: 1,
    explanation:
      'Inspired by Minsky\'s theory, the "society of mind" approach builds complex intelligent behavior from many simpler agents. Each handles a specific capability, and sophisticated behavior emerges from their interactions, allowing systems to tackle problems no single agent could solve.',
    tags: ['multi-agent', 'society-of-mind', 'emergence', 'architecture'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-010',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'How can formal verification techniques be applied to ensure AI agent safety in critical applications?',
    options: [
      'By simply testing the agent on a few examples',
      'By mathematically proving that the agent\'s tool call sequences satisfy safety invariants, such as never executing destructive operations without prior approval checks',
      'By running the agent faster to reduce error rates',
      'Formal verification cannot be applied to AI agents',
    ],
    correctAnswer: 1,
    explanation:
      'Formal verification can define safety properties as logical invariants (e.g., "delete operations always preceded by confirmation") and use model checking or theorem proving on the agent\'s workflow graph to guarantee these properties hold for all possible execution paths.',
    tags: ['safety', 'formal-verification', 'invariants', 'critical-systems'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-011',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Chain-of-Thought',
    question:
      'How does "self-consistency" improve chain-of-thought reasoning in agents, and what are its trade-offs?',
    options: [
      'It generates a single chain-of-thought and always uses it',
      'It samples multiple reasoning chains, selects the most common answer via majority voting, improving accuracy at the cost of increased inference compute',
      'It ensures all chain-of-thought steps are the same length',
      'It eliminates the need for chain-of-thought entirely',
    ],
    correctAnswer: 1,
    explanation:
      'Self-consistency generates multiple independent chain-of-thought paths for the same problem and selects the answer that appears most frequently (majority voting). This marginalizes over different reasoning paths, improving robustness but multiplying inference cost by the number of samples.',
    tags: ['chain-of-thought', 'self-consistency', 'reasoning', 'trade-offs'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-012',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Code Generation Agents',
    question:
      'What techniques do advanced code generation agents like Devin or OpenHands use to handle repository-level tasks that span many files?',
    options: [
      'They only modify one file at a time and cannot understand cross-file dependencies',
      'They use repository mapping, AST analysis, code search tools, and iterative test-driven development to build understanding across the codebase before making changes',
      'They rewrite the entire repository from scratch',
      'They only work with single-file scripts',
    ],
    correctAnswer: 1,
    explanation:
      'Advanced code agents build repo-level understanding through repository maps (file trees, dependency graphs), AST-based code analysis, semantic search over the codebase, and test-driven iteration. They plan changes across multiple files while respecting existing architecture.',
    tags: ['code-generation', 'repository-level', 'advanced-techniques'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-013',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Retrieval-Augmented Agents',
    question:
      'What is "adaptive retrieval" in agent systems and how does it differ from naive retrieve-then-generate?',
    options: [
      'It always retrieves the maximum number of documents',
      'The agent dynamically decides whether to retrieve, what query to use, how many results to fetch, and whether to re-rank or re-query based on intermediate reasoning about information sufficiency',
      'It only retrieves documents once at the start of the conversation',
      'Adaptive retrieval uses a fixed set of pre-defined queries',
    ],
    correctAnswer: 1,
    explanation:
      'Adaptive retrieval gives the agent control over the retrieval process: it reasons about what information is missing, formulates targeted queries, evaluates result quality, and iteratively refines its search strategy. This contrasts with naive RAG which retrieves once with a fixed query.',
    tags: ['retrieval-augmented', 'adaptive-retrieval', 'advanced'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-014',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Evaluation',
    question:
      'How does "reward hacking" manifest in agent evaluation, and how can it be mitigated?',
    options: [
      'It is a type of cybersecurity attack on the reward system',
      'Agents find shortcuts that maximize evaluation metrics without actually solving the intended task, mitigated by diverse test cases, human evaluation, and measuring process quality alongside outcomes',
      'It occurs when the reward is too small for the agent to notice',
      'Reward hacking only happens during training, never during evaluation',
    ],
    correctAnswer: 1,
    explanation:
      'Reward hacking occurs when agents exploit loopholes in evaluation metrics to achieve high scores without genuine task completion. Mitigation includes diverse and adversarial test sets, evaluating trajectories (not just outcomes), human judgment, and multi-dimensional metrics.',
    tags: ['evaluation', 'reward-hacking', 'robustness'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-015',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Memory',
    question:
      'What are the trade-offs between using vector similarity search versus knowledge graphs for agent long-term memory?',
    options: [
      'There are no trade-offs; vector search is always better',
      'Vector search excels at fuzzy semantic matching but lacks structured relationships, while knowledge graphs capture explicit relationships and enable reasoning but require more curation and structured data ingestion',
      'Knowledge graphs are always faster than vector search',
      'Vector search cannot store text data',
    ],
    correctAnswer: 1,
    explanation:
      'Vector similarity search provides flexible semantic matching for unstructured data but loses explicit relationships. Knowledge graphs preserve structured relationships enabling multi-hop reasoning but require schema design and entity extraction. Hybrid approaches combining both are often most effective.',
    tags: ['memory', 'vector-search', 'knowledge-graphs', 'trade-offs'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-016',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is "tool learning" or "tool creation" in the context of advanced AI agents?',
    options: [
      'Manually coding new tools for the agent',
      'The agent\'s ability to autonomously compose existing tools into new higher-level tools or generate tool implementations (code) to extend its own capabilities',
      'Teaching users how to use tools',
      'Removing tools that the agent does not need',
    ],
    correctAnswer: 1,
    explanation:
      'Tool learning/creation refers to agents that can create new tools by composing existing ones, writing code to implement new capabilities, or abstracting repeated action sequences into reusable tools, effectively expanding their own toolset without human intervention.',
    tags: ['tool-calling', 'tool-learning', 'tool-creation', 'advanced'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-017',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Planning',
    question:
      'What is "hierarchical task network" (HTN) planning and how can it be adapted for LLM-based agents?',
    options: [
      'A flat list of tasks with no hierarchy',
      'A planning approach that decomposes abstract tasks into networks of subtasks using domain-specific methods, adaptable to LLM agents by using the LLM to generate decomposition rules and select methods',
      'A neural network architecture for classification tasks',
      'A technique for training agents on hierarchical datasets',
    ],
    correctAnswer: 1,
    explanation:
      'HTN planning decomposes high-level tasks into subtask networks using predefined methods. For LLM agents, the LLM can serve as both the method selector and subtask generator, leveraging its world knowledge to create decompositions without hand-coded domain rules.',
    tags: ['planning', 'htn', 'hierarchical', 'advanced'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-018',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Debugging',
    question:
      'What is "counterfactual analysis" in agent debugging and how does it help identify root causes of failures?',
    options: [
      'It counts the number of facts in the agent\'s memory',
      'It involves replaying the agent\'s trajectory with modified inputs or tool results at specific steps to determine which factors causally influenced the failure',
      'It analyzes the agent\'s performance in a different country',
      'It removes all debugging information from the logs',
    ],
    correctAnswer: 1,
    explanation:
      'Counterfactual analysis systematically modifies individual elements of a failed trajectory (e.g., different tool results, alternative observations) and re-runs from that point to isolate which specific input or decision causally led to the failure, enabling precise root cause identification.',
    tags: ['debugging', 'counterfactual', 'root-cause-analysis'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-019',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Autonomous Agents',
    question:
      'What is the "alignment tax" problem specific to autonomous agents, and how does it affect system design?',
    options: [
      'A government tax on AI systems',
      'The performance and capability cost incurred by adding safety constraints and alignment measures, creating tension between agent autonomy and controllability',
      'The cost of purchasing aligned GPUs',
      'A fee charged for using aligned language models',
    ],
    correctAnswer: 1,
    explanation:
      'The alignment tax refers to the trade-off where adding safety measures (confirmation steps, restricted actions, output filtering) reduces agent autonomy, speed, and potentially capability. System designers must balance how much capability to sacrifice for safety guarantees.',
    tags: ['autonomous-agents', 'alignment', 'safety', 'design-trade-offs'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-020',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'How do "shared blackboard" architectures differ from "message passing" architectures in multi-agent systems?',
    options: [
      'They are identical architectures with different names',
      'Blackboard systems use a shared memory space that all agents read from and write to, enabling implicit coordination, while message passing requires explicit point-to-point or broadcast communication',
      'Message passing is always slower',
      'Blackboard systems cannot handle more than two agents',
    ],
    correctAnswer: 1,
    explanation:
      'In blackboard architectures, agents coordinate by reading from and writing to a shared state, enabling loose coupling and opportunistic problem-solving. Message passing requires explicit communication channels. Blackboards simplify coordination but can create contention; message passing offers better isolation but requires explicit routing.',
    tags: ['multi-agent', 'blackboard', 'message-passing', 'architecture'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-021',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'What is "capability overhang" in autonomous agents and why is it a safety concern?',
    options: [
      'When an agent\'s memory capacity is exceeded',
      'When an agent possesses latent capabilities (through its tool access or model abilities) that go beyond what has been tested or intended, potentially activating unexpectedly',
      'When the agent cannot learn any new capabilities',
      'When multiple agents share the same capabilities',
    ],
    correctAnswer: 1,
    explanation:
      'Capability overhang occurs when an agent has access to tool combinations or model abilities that, in composition, enable actions far beyond what was tested. A seemingly safe set of individual tools might combine to enable dangerous capabilities that were not anticipated during design.',
    tags: ['safety', 'capability-overhang', 'autonomous-agents', 'risk'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-022',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Frameworks',
    question:
      'How does the "graph of thoughts" approach extend chain-of-thought and tree-of-thought reasoning for complex agent tasks?',
    options: [
      'It restricts reasoning to a single linear chain',
      'It models reasoning as a directed graph where thoughts can merge, branch, and form loops, enabling the agent to combine partial solutions and revisit earlier reasoning paths',
      'It eliminates the need for any reasoning',
      'It only works with graph databases',
    ],
    correctAnswer: 1,
    explanation:
      'Graph of Thoughts generalizes linear (CoT) and tree (ToT) reasoning into a full graph structure. Thoughts can be combined (merging branches), refined (loops), and evaluated in parallel. This enables more flexible reasoning strategies like combining partial solutions from different branches.',
    tags: ['frameworks', 'graph-of-thoughts', 'reasoning', 'advanced'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-023',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Human-in-the-Loop',
    question:
      'How can "active learning" principles be applied to optimize when an agent requests human intervention?',
    options: [
      'The agent should always request human help for every decision',
      'The agent estimates its uncertainty on critical decisions and selectively requests human input only when the expected value of information exceeds the cost of interruption',
      'Active learning cannot be applied to agent systems',
      'The agent should never request human help',
    ],
    correctAnswer: 1,
    explanation:
      'By applying active learning, agents can model their own uncertainty and assess the potential impact of each decision. They request human input strategically, when uncertainty is high and the decision is consequential, minimizing interruptions while maximizing the value of human oversight.',
    tags: ['human-in-the-loop', 'active-learning', 'uncertainty', 'optimization'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-024',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is the "Model Context Protocol" (MCP) and how does it standardize tool integration for AI agents?',
    options: [
      'A protocol for compressing model weights',
      'An open standard that provides a unified interface for connecting LLMs to external tools and data sources, enabling interoperable tool definitions across different agent frameworks',
      'A networking protocol for distributed training',
      'A protocol for encrypting model outputs',
    ],
    correctAnswer: 1,
    explanation:
      'MCP (created by Anthropic) is an open protocol that standardizes how AI agents connect to external tools and data sources. It provides a common interface so tools can be defined once and used across different agent frameworks, similar to how USB standardized device connections.',
    tags: ['tool-calling', 'mcp', 'standardization', 'interoperability'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-025',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Evaluation',
    question:
      'What is "curriculum-based evaluation" for agents and why is it more informative than flat benchmark scores?',
    options: [
      'It teaches the agent during evaluation',
      'It organizes test tasks by increasing difficulty, revealing the agent\'s capability frontier and failure modes at each complexity level rather than collapsing everything into a single score',
      'It only evaluates the agent on easy tasks',
      'It evaluates the curriculum of the researchers, not the agent',
    ],
    correctAnswer: 1,
    explanation:
      'Curriculum-based evaluation structures tests from simple to complex, revealing where exactly the agent\'s capabilities break down. This provides actionable insights about specific failure modes at each difficulty level, unlike a single aggregate score that masks where the agent succeeds and fails.',
    tags: ['evaluation', 'curriculum', 'difficulty-levels', 'diagnostics'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-026',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Retrieval-Augmented Agents',
    question:
      'How can "agentic chunking" strategies improve retrieval quality for agent systems compared to fixed-size chunking?',
    options: [
      'By always using smaller chunks',
      'By using an LLM to create semantically meaningful chunks based on content structure and propositions, preserving context boundaries and creating better retrieval units',
      'By storing all documents as a single chunk',
      'By randomly splitting documents',
    ],
    correctAnswer: 1,
    explanation:
      'Agentic chunking uses an LLM to identify natural content boundaries, extract propositions, and create semantically coherent chunks rather than splitting at arbitrary character counts. This produces retrieval units that preserve complete ideas, improving both retrieval precision and the quality of agent reasoning over retrieved content.',
    tags: ['retrieval-augmented', 'chunking', 'advanced', 'quality'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-027',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Planning',
    question:
      'What is "world model" based planning for agents, and how does it enable more robust action selection?',
    options: [
      'A 3D rendering of the physical world',
      'The agent maintains an internal model predicting how the environment changes in response to actions, allowing it to mentally simulate outcomes before acting',
      'A database of all countries in the world',
      'A model that only works with geographic data',
    ],
    correctAnswer: 1,
    explanation:
      'World model planning involves the agent maintaining a predictive model of how the environment responds to actions. By mentally simulating action consequences before committing, the agent can evaluate multiple strategies, avoid harmful actions, and select plans with higher expected success rates.',
    tags: ['planning', 'world-model', 'simulation', 'advanced'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-028',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Debugging',
    question:
      'What are "semantic assertions" for agent testing and how do they differ from traditional unit tests?',
    options: [
      'They are identical to standard assertEquals calls',
      'They use an LLM as a judge to evaluate whether agent outputs satisfy semantic criteria expressed in natural language, enabling testing of open-ended agent behaviors',
      'They only check for spelling errors',
      'They are assertions that run without any test framework',
    ],
    correctAnswer: 1,
    explanation:
      'Semantic assertions use an LLM evaluator to judge whether agent outputs meet criteria expressed in natural language (e.g., "the response should be helpful and not reveal sensitive information"). This enables testing open-ended behaviors that cannot be captured by exact string matching or traditional assertions.',
    tags: ['debugging', 'testing', 'semantic-assertions', 'llm-as-judge'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-029',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'What is the "principal hierarchy" problem in multi-agent systems and how does it relate to alignment?',
    options: [
      'A problem with sorting agents alphabetically',
      'The challenge of maintaining alignment when sub-agents serve multiple principals (supervisor agents, users, system policies) with potentially conflicting objectives',
      'A hierarchy of school principals',
      'The problem of agents not having enough compute resources',
    ],
    correctAnswer: 1,
    explanation:
      'In multi-agent systems, sub-agents may receive instructions from orchestrators, users, and system policies simultaneously. When these principals have conflicting objectives, the agent faces a hierarchy problem: whose instructions take priority? This is a critical alignment challenge requiring explicit priority rules.',
    tags: ['multi-agent', 'alignment', 'principal-hierarchy', 'conflict-resolution'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-030',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Autonomous Agents',
    question:
      'How does "constitutional AI" apply to constraining autonomous agent behavior?',
    options: [
      'It requires agents to follow the US Constitution',
      'It provides a set of explicit principles (a constitution) that the agent uses to self-critique and revise its planned actions, ensuring they align with specified values and constraints',
      'It prevents agents from operating in certain countries',
      'It is only applicable to chatbots, not agents',
    ],
    correctAnswer: 1,
    explanation:
      'Constitutional AI provides agents with explicit principles they must follow. Before executing actions, the agent can self-critique against these principles, revising plans that violate safety or ethical guidelines. This creates an internalized set of constraints that scales better than exhaustive rule lists.',
    tags: ['autonomous-agents', 'constitutional-ai', 'self-critique', 'alignment'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-031',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Code Generation Agents',
    question:
      'What is "speculative execution" in code generation agents and how does it improve efficiency?',
    options: [
      'Executing code without any planning',
      'The agent generates and tentatively executes multiple candidate solutions in parallel, validating results against test cases to quickly identify the correct approach',
      'Delaying all code execution indefinitely',
      'Executing only code written by humans',
    ],
    correctAnswer: 1,
    explanation:
      'Speculative execution allows code generation agents to explore multiple solution strategies simultaneously, running them against test cases in parallel. Correct solutions are accepted quickly while failed branches are pruned, significantly reducing the time for iterative code refinement.',
    tags: ['code-generation', 'speculative-execution', 'efficiency', 'parallelism'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-032',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'What is "defense in depth" as applied to AI agent security architecture?',
    options: [
      'Using a single very strong security measure',
      'Layering multiple independent security controls (input validation, tool sandboxing, output filtering, audit logging, rate limiting) so that failure of any single layer does not compromise the system',
      'Making the agent operate only in deep neural networks',
      'Keeping all agent code deeply nested in directories',
    ],
    correctAnswer: 1,
    explanation:
      'Defense in depth applies multiple, independent security layers: input sanitization, prompt injection detection, tool-level permission controls, sandbox isolation, output content filtering, anomaly detection, audit logging, and rate limiting. No single layer is relied upon exclusively.',
    tags: ['safety', 'defense-in-depth', 'security-architecture', 'layers'],
  },
  {
    id: 'ai-engineer-ai-agents-l3-033',
    language: 'ai-engineer',
    level: 'level3',
    category: 'AI Agents & Tool Use',
    subcategory: 'Frameworks',
    question:
      'How does "dynamic tool selection" at scale work when an agent has access to hundreds or thousands of tools?',
    options: [
      'The agent loads all tools into the context window regardless of relevance',
      'A retrieval step first identifies the most relevant tools for the current task using embedding similarity or a classifier, then only those tools are included in the prompt',
      'The agent randomly selects tools',
      'Having more than 10 tools is not supported by any framework',
    ],
    correctAnswer: 1,
    explanation:
      'With large tool registries, including all tools in the prompt is impractical. Dynamic tool selection uses semantic search (embedding similarity between the task and tool descriptions) or learned classifiers to retrieve the most relevant subset of tools, keeping the context focused and reducing confusion.',
    tags: ['frameworks', 'tool-selection', 'scalability', 'retrieval'],
  },
];

export default questions;
