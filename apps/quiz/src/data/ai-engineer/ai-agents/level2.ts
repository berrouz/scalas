import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'ai-engineer-ai-agents-l2-001',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'ReAct Pattern',
    question:
      'How does ReAct improve over pure chain-of-thought prompting for agent tasks?',
    options: [
      'It removes the need for reasoning entirely',
      'It interleaves reasoning with concrete actions and observations, grounding the reasoning in real feedback',
      'It only works with smaller models',
      'It eliminates the need for tools',
    ],
    correctAnswer: 1,
    explanation:
      'ReAct improves over pure chain-of-thought by grounding the reasoning process in actual observations from the environment. While CoT reasons in isolation, ReAct alternates between thinking and acting, allowing the agent to verify and adjust its reasoning with real data.',
    tags: ['react-pattern', 'chain-of-thought', 'comparison'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-002',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'When defining a tool schema, why is it important to include detailed parameter descriptions?',
    options: [
      'To make the schema file larger for security purposes',
      'Because the LLM uses these descriptions to understand how to correctly populate the parameters',
      'Parameter descriptions are optional and have no effect',
      'To satisfy JSON Schema validation requirements only',
    ],
    correctAnswer: 1,
    explanation:
      'Detailed parameter descriptions serve as natural language guidance for the LLM, helping it understand the purpose, expected format, and constraints of each parameter so it can generate correct tool calls.',
    tags: ['tool-calling', 'json-schema', 'best-practices'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-003',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Memory',
    question: 'What is "episodic memory" in the context of AI agents?',
    options: [
      'Memory of the model\'s training episodes',
      'A record of past experiences and interactions that the agent can reference to inform future decisions',
      'Memory used only during evaluation episodes',
      'The memory consumed by each GPU episode',
    ],
    correctAnswer: 1,
    explanation:
      'Episodic memory stores records of past experiences, interactions, and their outcomes. The agent can retrieve relevant episodes to learn from past successes and failures, improving its decision-making over time.',
    tags: ['memory', 'episodic-memory'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-004',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Planning',
    question:
      'What is a key advantage of the plan-and-execute pattern over a simple ReAct loop?',
    options: [
      'It uses fewer API calls in all cases',
      'It provides a high-level roadmap before diving into execution, enabling better handling of complex multi-step tasks',
      'It does not require any LLM calls',
      'It never needs to revise its plan',
    ],
    correctAnswer: 1,
    explanation:
      'Plan-and-execute separates planning from execution, allowing the agent to create a coherent strategy upfront. This helps with complex tasks where a reactive step-by-step approach might lose track of the overall goal.',
    tags: ['planning', 'plan-and-execute', 'comparison'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-005',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'In a multi-agent system, what is the role of an "orchestrator" agent?',
    options: [
      'It performs all tasks by itself without delegating',
      'It coordinates the workflow, delegates tasks to specialized agents, and aggregates their results',
      'It only handles error logging',
      'It is responsible solely for authentication',
    ],
    correctAnswer: 1,
    explanation:
      'An orchestrator agent serves as the central coordinator in a multi-agent system. It receives the overall task, breaks it down, delegates sub-tasks to specialized agents, monitors progress, and synthesizes the final result.',
    tags: ['multi-agent', 'orchestrator', 'coordination'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-006',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'What is "sandboxing" in the context of AI agent safety?',
    options: [
      'Running the agent in a desert environment',
      'Isolating the agent\'s execution environment to limit its access to sensitive resources and prevent harmful actions',
      'Giving the agent unrestricted access to all systems',
      'Training the agent on filtered data only',
    ],
    correctAnswer: 1,
    explanation:
      'Sandboxing means running the agent in an isolated environment with restricted permissions, limiting its ability to access sensitive files, make dangerous system calls, or affect production systems. This is crucial for code execution agents.',
    tags: ['safety', 'sandboxing', 'isolation'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-007',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is the difference between "tool_choice: auto" and "tool_choice: required" in OpenAI\'s function calling API?',
    options: [
      'There is no difference; they behave identically',
      '"auto" lets the model decide whether to call a tool, while "required" forces the model to call at least one tool',
      '"required" disables all tools',
      '"auto" always calls all available tools',
    ],
    correctAnswer: 1,
    explanation:
      'With "auto", the model decides whether a tool call is needed based on the conversation. With "required", the model must generate at least one tool call in its response, which is useful when you always expect a structured output.',
    tags: ['tool-calling', 'openai', 'tool-choice'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-008',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Debugging',
    question:
      'What is "trajectory evaluation" when debugging or evaluating agents?',
    options: [
      'Measuring the physical path of a robot agent',
      'Analyzing the sequence of thoughts, actions, and observations the agent took to assess quality and correctness',
      'Evaluating the speed of the agent\'s API calls',
      'Counting the total number of tokens used',
    ],
    correctAnswer: 1,
    explanation:
      'Trajectory evaluation examines the entire sequence of steps an agent took (thoughts, tool calls, observations) rather than just the final output. This helps identify inefficient paths, unnecessary tool calls, or reasoning errors.',
    tags: ['evaluation', 'debugging', 'trajectory'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-009',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Retrieval-Augmented Agents',
    question:
      'How does a retrieval-augmented agent differ from a standard RAG pipeline?',
    options: [
      'They are exactly the same thing',
      'A retrieval-augmented agent can decide when and what to retrieve dynamically, while standard RAG always retrieves before generating',
      'Standard RAG uses agents but retrieval-augmented agents do not',
      'Retrieval-augmented agents never use vector databases',
    ],
    correctAnswer: 1,
    explanation:
      'In standard RAG, retrieval always happens as a fixed step before generation. A retrieval-augmented agent uses retrieval as a tool, deciding dynamically when to search, what queries to use, and whether the retrieved information is sufficient.',
    tags: ['retrieval-augmented', 'rag', 'comparison'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-010',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Chain-of-Thought',
    question:
      'What is "inner monologue" in the context of LLM agents, and how does it relate to chain-of-thought?',
    options: [
      'It is a separate model that runs alongside the main LLM',
      'It is the agent\'s internal reasoning that is hidden from the user but guides its actions, often implemented via CoT',
      'It is audio output generated by the model',
      'It is a technique for reducing latency',
    ],
    correctAnswer: 1,
    explanation:
      'Inner monologue refers to the agent\'s internal reasoning process that is used for decision-making but may be hidden from the end user. It leverages chain-of-thought to reason through problems step by step before choosing actions.',
    tags: ['chain-of-thought', 'inner-monologue', 'reasoning'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-011',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Frameworks',
    question:
      'In LangGraph, what do "nodes" and "edges" represent in an agent graph?',
    options: [
      'Nodes are databases and edges are API calls',
      'Nodes represent processing steps (functions), and edges define the control flow between them including conditional routing',
      'Nodes are user messages and edges are agent responses',
      'Nodes are LLM models and edges are prompts',
    ],
    correctAnswer: 1,
    explanation:
      'In LangGraph, nodes are functions that process the current state, and edges define how control flows between nodes. Edges can be static or conditional, allowing for branching logic and cycles in the agent workflow.',
    tags: ['frameworks', 'langgraph', 'graph-structure'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-012',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Code Generation Agents',
    question:
      'Why do code generation agents typically use a sandboxed execution environment?',
    options: [
      'To make the code run faster',
      'To safely execute LLM-generated code without risking harm to the host system or data',
      'Because the code cannot run outside a sandbox',
      'To bypass security restrictions',
    ],
    correctAnswer: 1,
    explanation:
      'LLM-generated code can contain errors or unintended operations. A sandbox (like a Docker container or isolated REPL) ensures that executing this code cannot damage the host system, access sensitive data, or cause security issues.',
    tags: ['code-generation', 'sandboxing', 'safety'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-013',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Memory',
    question:
      'How can an agent manage the context window limitation when short-term memory grows too large?',
    options: [
      'By switching to a model with unlimited context',
      'By summarizing older parts of the conversation, using sliding windows, or offloading to external storage',
      'By ignoring all previous messages',
      'By reducing the model\'s vocabulary size',
    ],
    correctAnswer: 1,
    explanation:
      'When conversation history exceeds the context window, agents can use strategies like summarizing older messages, implementing a sliding window over recent messages, or storing older context in external memory for retrieval when needed.',
    tags: ['memory', 'context-window', 'management'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-014',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Human-in-the-Loop',
    question:
      'At what points in an agent workflow is human-in-the-loop most commonly implemented?',
    options: [
      'Only at the very beginning of the workflow',
      'Before irreversible or high-risk actions, when the agent is uncertain, or for quality review of outputs',
      'Only after the agent has completely finished all tasks',
      'Human-in-the-loop is never implemented in practice',
    ],
    correctAnswer: 1,
    explanation:
      'Human-in-the-loop checkpoints are typically placed before actions that are irreversible (like sending emails, making payments), when the agent reports low confidence, or at quality gates for reviewing important outputs.',
    tags: ['human-in-the-loop', 'checkpoints', 'workflow'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-015',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is "tool result injection" and why is it a security concern?',
    options: [
      'A method for speeding up tool execution',
      'When tool output contains instructions that manipulate the LLM\'s behavior, a form of indirect prompt injection',
      'A technique for adding new tools at runtime',
      'Injecting dependencies into tool functions',
    ],
    correctAnswer: 1,
    explanation:
      'Tool result injection is a security risk where the output from a tool (e.g., web page content, email body) contains adversarial text that manipulates the LLM into performing unintended actions, a form of indirect prompt injection.',
    tags: ['tool-calling', 'security', 'prompt-injection'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-016',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Evaluation',
    question:
      'Which metric is commonly used to evaluate whether an agent successfully completed a task?',
    options: [
      'Perplexity',
      'Task completion rate (success rate)',
      'BLEU score',
      'F1 score on token classification',
    ],
    correctAnswer: 1,
    explanation:
      'Task completion rate measures the percentage of tasks the agent successfully completes. It is the most direct metric for evaluating agent effectiveness, often combined with metrics like efficiency (steps taken) and cost.',
    tags: ['evaluation', 'metrics', 'task-completion'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-017',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'What is the "supervisor" pattern in multi-agent architectures?',
    options: [
      'A pattern where all agents have equal authority',
      'A hierarchical pattern where a supervisor agent routes tasks, reviews outputs, and coordinates worker agents',
      'A pattern where agents compete against each other',
      'A pattern with no inter-agent communication',
    ],
    correctAnswer: 1,
    explanation:
      'In the supervisor pattern, a central supervisor agent receives requests, decides which worker agent should handle each part, routes tasks accordingly, reviews results, and can re-route or request corrections.',
    tags: ['multi-agent', 'supervisor', 'architecture'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-018',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Planning',
    question:
      'What is "goal decomposition" and how does it help agents handle complex tasks?',
    options: [
      'Removing unnecessary goals from the system',
      'Breaking a high-level goal into a hierarchy of sub-goals, each more concrete and achievable than the parent',
      'Combining multiple goals into one',
      'Converting goals into natural language descriptions',
    ],
    correctAnswer: 1,
    explanation:
      'Goal decomposition breaks a complex, abstract goal into a hierarchy of progressively more concrete sub-goals. This allows the agent to focus on achievable steps while maintaining alignment with the overall objective.',
    tags: ['planning', 'goal-decomposition'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-019',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'What are "permission scopes" for agent tools and why are they important?',
    options: [
      'They define the visual layout of the tool UI',
      'They restrict what a tool can access or modify, following the principle of least privilege',
      'They measure the performance of each tool',
      'They determine the cost of each tool call',
    ],
    correctAnswer: 1,
    explanation:
      'Permission scopes define the boundaries of what each tool can do (e.g., read-only vs. read-write, which directories can be accessed). Following least privilege, tools should have only the minimum permissions needed for their function.',
    tags: ['safety', 'permissions', 'least-privilege'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-020',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Frameworks',
    question:
      'What is the concept of "state" in LangGraph, and why is it important for agents?',
    options: [
      'State refers to the geographic location of the server',
      'State is a shared data structure passed between nodes that accumulates information as the graph executes',
      'State only stores error messages',
      'State is the version number of the framework',
    ],
    correctAnswer: 1,
    explanation:
      'In LangGraph, state is a typed data structure (often a TypedDict or Pydantic model) that is passed between nodes. It accumulates messages, tool results, and intermediate data, providing continuity across the agent\'s execution steps.',
    tags: ['frameworks', 'langgraph', 'state-management'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-021',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Debugging',
    question:
      'What is "LangSmith" commonly used for in the LangChain ecosystem?',
    options: [
      'Training new language models',
      'Tracing, debugging, and evaluating LLM applications and agent runs',
      'Deploying models to edge devices',
      'Managing cloud billing',
    ],
    correctAnswer: 1,
    explanation:
      'LangSmith is an observability platform in the LangChain ecosystem that provides tracing of agent runs (each step, tool call, and LLM invocation), debugging capabilities, and evaluation tools for assessing agent performance.',
    tags: ['debugging', 'langsmith', 'observability'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-022',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is the benefit of providing few-shot examples in tool descriptions?',
    options: [
      'It makes the tool definition file larger',
      'It helps the LLM understand the expected input format and correct usage patterns for the tool',
      'It prevents the tool from being called',
      'It replaces the need for parameter schemas',
    ],
    correctAnswer: 1,
    explanation:
      'Including few-shot examples in tool descriptions demonstrates the expected parameter format and common usage patterns, helping the LLM generate more accurate and correctly formatted tool calls, especially for complex tools.',
    tags: ['tool-calling', 'few-shot', 'best-practices'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-023',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Autonomous Agents',
    question:
      'What is a key challenge with fully autonomous agents running for extended periods?',
    options: [
      'They always produce perfect results',
      'Error accumulation and compounding mistakes over many steps can lead to significant drift from the intended goal',
      'They use less memory over time',
      'They become faster with each iteration',
    ],
    correctAnswer: 1,
    explanation:
      'Over many steps, small errors in reasoning or tool use can compound, causing the agent to drift further from the correct path. This error accumulation is a fundamental challenge for long-running autonomous agents.',
    tags: ['autonomous-agents', 'error-accumulation', 'challenges'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-024',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Multi-Agent Systems',
    question:
      'What communication pattern do agents in CrewAI typically use?',
    options: [
      'Direct memory sharing without any message passing',
      'Sequential or hierarchical task passing where agents hand off work in a defined process',
      'Agents cannot communicate with each other',
      'Random message broadcasting to all agents simultaneously',
    ],
    correctAnswer: 1,
    explanation:
      'CrewAI supports sequential processes (agents work in order, passing results to the next) and hierarchical processes (a manager agent delegates and coordinates), enabling structured collaboration between role-based agents.',
    tags: ['multi-agent', 'crewai', 'communication'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-025',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Retrieval-Augmented Agents',
    question:
      'What is "self-reflective RAG" or "corrective RAG" in agent systems?',
    options: [
      'A RAG system that only uses cached results',
      'An agent that evaluates the relevance of retrieved documents and can re-query or reformulate searches if results are insufficient',
      'A RAG system that corrects spelling errors',
      'A system that never retrieves documents',
    ],
    correctAnswer: 1,
    explanation:
      'Self-reflective or corrective RAG involves the agent evaluating whether retrieved documents are relevant and sufficient. If not, it can reformulate the query, try different search strategies, or use alternative sources.',
    tags: ['retrieval-augmented', 'self-reflection', 'corrective-rag'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-026',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Fundamentals',
    question:
      'What is the difference between "reactive" and "proactive" agent behavior?',
    options: [
      'They are the same thing',
      'Reactive agents respond to stimuli, while proactive agents take initiative and plan ahead to achieve goals',
      'Reactive agents are faster than proactive agents',
      'Proactive agents never respond to user input',
    ],
    correctAnswer: 1,
    explanation:
      'Reactive agents respond to incoming stimuli or requests (e.g., answering a question). Proactive agents take initiative, anticipating needs, setting goals, and taking actions without explicit prompts to achieve objectives.',
    tags: ['agent-fundamentals', 'reactive-vs-proactive'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-027',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Code Generation Agents',
    question:
      'What is the typical workflow of a code generation agent when solving a programming problem?',
    options: [
      'Generate code once and return it without testing',
      'Understand the problem, generate code, execute it, observe output/errors, and iteratively refine until correct',
      'Only search for existing code solutions online',
      'Ask the user to write the code and just review it',
    ],
    correctAnswer: 1,
    explanation:
      'Code generation agents typically follow an iterative cycle: understand the problem, write code, execute it in a sandbox, observe the output or errors, and refine the code based on feedback until the solution works correctly.',
    tags: ['code-generation', 'workflow', 'iterative'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-028',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Safety',
    question:
      'What is "output validation" as a guardrail for AI agents?',
    options: [
      'Checking if the output is in English',
      'Verifying that the agent\'s responses and tool call arguments meet predefined rules, formats, or safety criteria before execution',
      'Making the output longer',
      'Converting the output to a different file format',
    ],
    correctAnswer: 1,
    explanation:
      'Output validation checks the agent\'s generated outputs (both text responses and tool call arguments) against predefined rules and safety criteria. This can include format validation, content filtering, and business logic checks before actions are executed.',
    tags: ['safety', 'guardrails', 'output-validation'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-029',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Evaluation',
    question:
      'What is the purpose of "benchmark suites" like SWE-bench for evaluating agents?',
    options: [
      'To measure the speed of the hardware',
      'To provide standardized, reproducible tasks for comparing different agent implementations on real-world problems',
      'To generate training data for the models',
      'To benchmark internet connection speed',
    ],
    correctAnswer: 1,
    explanation:
      'Benchmark suites like SWE-bench provide standardized real-world tasks (e.g., fixing actual GitHub issues) that allow researchers and practitioners to compare agent approaches on a level playing field with reproducible evaluations.',
    tags: ['evaluation', 'benchmarks', 'swe-bench'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-030',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Planning',
    question:
      'What is "replanning" in agent systems and when is it triggered?',
    options: [
      'Creating a plan for the first time',
      'Updating the agent\'s plan when new information is received or when the current plan fails or becomes suboptimal',
      'Deleting all plans permanently',
      'Converting plans from one language to another',
    ],
    correctAnswer: 1,
    explanation:
      'Replanning occurs when the agent revises its existing plan based on new information, failed steps, or changed conditions. It allows the agent to adapt dynamically rather than rigidly following an initial plan that may no longer be valid.',
    tags: ['planning', 'replanning', 'adaptability'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-031',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Tool Calling',
    question:
      'What is "structured output" and how does it relate to tool calling?',
    options: [
      'Output formatted as a Word document',
      'The LLM generating responses in a predefined structured format (like JSON), which is the same mechanism used for generating tool call arguments',
      'Output that is always in bullet points',
      'A technique for compressing output size',
    ],
    correctAnswer: 1,
    explanation:
      'Structured output constrains the LLM to generate responses in a specific format (typically JSON matching a schema). Tool calling is a specialized form of structured output where the generated JSON specifies function names and arguments.',
    tags: ['tool-calling', 'structured-output', 'json'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-032',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Agent Debugging',
    question:
      'What is a common cause of an agent getting stuck in a loop, repeatedly calling the same tool?',
    options: [
      'The model is too large',
      'The tool keeps returning results that the agent misinterprets, or the agent lacks clear criteria for when to stop',
      'The internet connection is too fast',
      'The tool schema is too short',
    ],
    correctAnswer: 1,
    explanation:
      'Agents can get stuck in loops when tool results are ambiguous or consistently misinterpreted, when the agent lacks clear stopping criteria, or when the prompt does not adequately define what constitutes success or when to try a different approach.',
    tags: ['debugging', 'loops', 'common-issues'],
  },
  {
    id: 'ai-engineer-ai-agents-l2-033',
    language: 'ai-engineer',
    level: 'level2',
    category: 'AI Agents & Tool Use',
    subcategory: 'Frameworks',
    question:
      'What distinguishes AutoGen\'s approach to multi-agent systems from CrewAI?',
    options: [
      'AutoGen does not support multiple agents',
      'AutoGen is centered on agent conversations and message passing, while CrewAI focuses on role-based task-oriented crews with defined processes',
      'CrewAI uses more API calls',
      'They are identical frameworks with different names',
    ],
    correctAnswer: 1,
    explanation:
      'AutoGen emphasizes conversational patterns between agents, using chat-based interactions as the primary mechanism. CrewAI takes a more structured approach with role-defined agents organized into crews that follow sequential or hierarchical processes.',
    tags: ['frameworks', 'autogen', 'crewai', 'comparison'],
  },
];

export default questions;
