import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'ai-engineer-llm-engineering-l3-001',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question:
      'In PagedAttention (used by vLLM), how is the KV cache managed to reduce memory fragmentation?',
    options: [
      'By pre-allocating a single contiguous block for each request',
      'By dividing the KV cache into fixed-size blocks (pages) that are allocated on demand and can be non-contiguous in physical memory',
      'By compressing all KV cache entries using lossy compression',
      'By sharing a single KV cache across all requests without isolation',
    ],
    correctAnswer: 1,
    explanation:
      'PagedAttention manages the KV cache like an OS virtual memory system. It divides the cache into fixed-size blocks (pages) that are allocated dynamically as tokens are generated. Pages can be non-contiguous in GPU memory, virtually eliminating memory fragmentation and waste from over-allocation.',
    tags: ['inference-optimization', 'vllm', 'paged-attention', 'kv-cache'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-002',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question:
      'In speculative decoding, what determines whether a drafted token from the small model is accepted?',
    options: [
      'The token is always accepted if it matches any token in the vocabulary',
      'The token is accepted if its probability under the large model is at least as high as under the draft model, with a rejection sampling scheme for borderline cases',
      'The token is accepted only if it exactly matches the top-1 prediction of the large model',
      'Tokens are accepted randomly with a 50% probability',
    ],
    correctAnswer: 1,
    explanation:
      'Speculative decoding uses a modified rejection sampling scheme. A drafted token is accepted if p_large(token) >= p_draft(token). If p_large < p_draft, it is accepted with probability p_large/p_draft. Rejected tokens are resampled from an adjusted distribution. This guarantees the output distribution is identical to the large model alone.',
    tags: ['inference-optimization', 'speculative-decoding', 'rejection-sampling'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-003',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question:
      'What is the primary bottleneck in autoregressive LLM inference that makes it memory-bound rather than compute-bound?',
    options: [
      'The softmax operation in the attention mechanism',
      'The token embedding lookup table being too large',
      'Loading model weights from GPU memory for each token generation step, with low arithmetic intensity per memory access',
      'The tokenizer decoding step at the end',
    ],
    correctAnswer: 2,
    explanation:
      'During autoregressive decoding, each token generation requires loading all model weights from GPU HBM but performs relatively few arithmetic operations per weight (low arithmetic intensity). This means the GPU spends more time waiting for memory transfers than computing, making inference memory-bandwidth-bound.',
    tags: ['inference-optimization', 'memory-bound', 'arithmetic-intensity'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-004',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Fine-Tuning',
    question:
      'In QLoRA, what is the purpose of the "double quantization" technique?',
    options: [
      'Quantizing the model twice for extra speed',
      'Quantizing the quantization constants themselves to further reduce the memory footprint of the base model',
      'Applying quantization to both input and output embeddings only',
      'Running quantization on two different GPUs in parallel',
    ],
    correctAnswer: 1,
    explanation:
      'Double quantization in QLoRA quantizes the quantization scaling factors (constants) themselves using 8-bit precision. Since each block of weights has its own scaling factor, quantizing these factors saves additional memory (approximately 0.37 bits per parameter), enabling even larger models to fit in memory.',
    tags: ['fine-tuning', 'qlora', 'double-quantization'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-005',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Fine-Tuning',
    question:
      'What is "catastrophic forgetting" in the context of LLM fine-tuning, and how does LoRA help mitigate it?',
    options: [
      'The model forgetting its API key; LoRA stores keys separately',
      'The model losing its general capabilities when fine-tuned on narrow data; LoRA mitigates this by keeping original weights frozen and adding small trainable adapters',
      'The model running out of GPU memory; LoRA uses less memory',
      'The model forgetting the most recent training examples; LoRA retrains on all data',
    ],
    correctAnswer: 1,
    explanation:
      'Catastrophic forgetting occurs when fine-tuning overwrites the pre-trained knowledge, degrading general capabilities. LoRA mitigates this by freezing all original weights and only training small adapter matrices. The original knowledge is preserved, and the adapters can even be removed to revert to the base model.',
    tags: ['fine-tuning', 'lora', 'catastrophic-forgetting'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-006',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Fine-Tuning',
    question:
      'When choosing which layers to apply LoRA adapters to, what is a common finding from research?',
    options: [
      'LoRA should only be applied to the first and last layers',
      'Applying LoRA to all linear layers (Q, K, V, O projections and FFN) generally performs better than applying to only attention layers',
      'LoRA should only be applied to the embedding layer',
      'The layer choice has no impact on performance',
    ],
    correctAnswer: 1,
    explanation:
      'Research has shown that applying LoRA adapters to all linear layers (attention Q, K, V, O projections plus feed-forward network layers) typically yields better results than restricting adapters to only the query and value projections, as it provides more capacity for adaptation across the model.',
    tags: ['fine-tuning', 'lora', 'layer-selection'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-007',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'RAG',
    question:
      'What is "hypothetical document embedding" (HyDE) in the context of RAG retrieval?',
    options: [
      'Embedding documents that do not exist yet in the corpus',
      'Using the LLM to generate a hypothetical answer to the query, embedding that answer, and using it as the search query for retrieval',
      'Creating random embeddings to test the vector database',
      'Embedding the query with hypothetical noise for data augmentation',
    ],
    correctAnswer: 1,
    explanation:
      'HyDE first uses the LLM to generate a hypothetical document/answer for the user query (without retrieval). This generated text is then embedded and used as the query vector for retrieval. The hypothesis is that the generated answer is closer in embedding space to relevant documents than the original query.',
    tags: ['rag', 'hyde', 'retrieval'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-008',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'RAG',
    question:
      'What is "reciprocal rank fusion" (RRF) and when is it used in RAG?',
    options: [
      'A method for fusing multiple LLM outputs',
      'A technique for combining ranked results from multiple retrieval methods (e.g., BM25 + vector search) into a single ranked list using reciprocal rank scores',
      'A ranking method that selects the lowest-ranked document',
      'A fusion technique for combining multiple LoRA adapters',
    ],
    correctAnswer: 1,
    explanation:
      'Reciprocal Rank Fusion (RRF) combines results from multiple retrieval systems by assigning each document a score of 1/(k + rank) for each system, then summing across systems. It is commonly used in hybrid search to merge BM25 and vector search results without needing score normalization.',
    tags: ['rag', 'hybrid-search', 'rrf', 're-ranking'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-009',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'RAG',
    question:
      'What is "query decomposition" in advanced RAG systems?',
    options: [
      'Breaking down the vector database into smaller databases',
      'Decomposing a complex user query into multiple simpler sub-queries that can each be used for independent retrieval, then synthesizing results',
      'Decomposing the embedding vector into individual dimensions',
      'Splitting the query tokens into characters',
    ],
    correctAnswer: 1,
    explanation:
      'Query decomposition breaks a complex, multi-faceted question into simpler sub-questions. Each sub-question is used for independent retrieval, and the results are combined to provide comprehensive context for the LLM. This addresses the limitation that a single query embedding may not capture all aspects of a complex question.',
    tags: ['rag', 'query-decomposition', 'advanced-retrieval'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-010',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'RAG',
    question:
      'What is "contextual compression" in RAG pipelines?',
    options: [
      'Compressing the vector database to save disk space',
      'Using an LLM or extraction model to extract only the most relevant information from retrieved chunks before passing them to the generation model',
      'Compressing the model weights during retrieval',
      'Reducing the context window size of the model',
    ],
    correctAnswer: 1,
    explanation:
      'Contextual compression reduces noise in the retrieved context by using a secondary model to extract or summarize only the most relevant portions from each retrieved chunk. This ensures the generation model receives focused, high-signal context rather than entire chunks that may contain irrelevant information.',
    tags: ['rag', 'contextual-compression', 'retrieval'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-011',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Prompt Engineering',
    question:
      'What is "tree-of-thought" (ToT) prompting and how does it extend chain-of-thought?',
    options: [
      'A prompting technique for generating tree-structured data like XML',
      'An approach where the model explores multiple reasoning branches in parallel, evaluates each path, and uses search strategies (BFS/DFS) to find the best solution',
      'A technique for creating hierarchical prompt templates',
      'A method for organizing few-shot examples in a tree structure',
    ],
    correctAnswer: 1,
    explanation:
      'Tree-of-Thought extends chain-of-thought by allowing the model to explore multiple reasoning paths simultaneously rather than following a single linear chain. At each step, multiple candidate thoughts are generated and evaluated. Search algorithms (BFS or DFS) guide exploration, enabling backtracking from unpromising paths.',
    tags: ['prompt-engineering', 'tree-of-thought', 'reasoning'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-012',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Prompt Engineering',
    question:
      'What is "constitutional AI" (CAI) as it relates to prompt-based alignment?',
    options: [
      'An AI system that follows the constitution of a country',
      'A method where the model critiques and revises its own outputs based on a set of principles (a "constitution"), used for self-alignment',
      'A technique for encrypting prompts according to constitutional law',
      'A method for training AI to pass legal bar exams',
    ],
    correctAnswer: 1,
    explanation:
      'Constitutional AI uses a set of explicitly stated principles (the "constitution") to guide model self-improvement. The model generates a response, then critiques and revises it based on these principles. This process generates training data for RLHF, enabling alignment with minimal human feedback on individual outputs.',
    tags: ['prompt-engineering', 'constitutional-ai', 'alignment'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-013',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Embedding Models',
    question:
      'What is "Matryoshka Representation Learning" (MRL) in the context of embedding models?',
    options: [
      'A technique for nesting multiple models inside each other',
      'Training embeddings where the first d dimensions of a larger embedding form a useful d-dimensional embedding, allowing flexible dimensionality reduction at inference time',
      'A Russian language-specific embedding technique',
      'A method for creating embeddings of embeddings',
    ],
    correctAnswer: 1,
    explanation:
      'Matryoshka Representation Learning trains embedding models so that truncating the embedding to any prefix of dimensions (e.g., first 256 of 1536 dimensions) still yields a useful embedding. This allows trading off between embedding quality and storage/compute costs at deployment time without retraining.',
    tags: ['embeddings', 'matryoshka', 'dimensionality-reduction'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-014',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question:
      'What is "tensor parallelism" and when is it necessary for LLM inference?',
    options: [
      'Running the same model on multiple machines with different inputs',
      'Splitting individual weight matrices across multiple GPUs so that a single layer computation is distributed, necessary when the model does not fit on a single GPU',
      'Using tensor cores for faster matrix multiplication',
      'Parallelizing the tokenizer across multiple CPU cores',
    ],
    correctAnswer: 1,
    explanation:
      'Tensor parallelism splits individual weight tensors across multiple GPUs, distributing the computation of each layer. This is necessary when a model is too large to fit on a single GPU and is distinct from pipeline parallelism (which splits layers across GPUs). It requires high-bandwidth interconnects (like NVLink) due to frequent inter-GPU communication.',
    tags: ['inference-optimization', 'tensor-parallelism', 'distributed'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-015',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question: 'What is "Flash Attention" and what problem does it solve?',
    options: [
      'A technique for making models respond to prompts faster by caching common responses',
      'An IO-aware attention algorithm that reduces memory reads/writes by tiling the computation and keeping intermediate results in SRAM rather than HBM',
      'A type of attention mechanism that uses flash memory instead of GPU memory',
      'A shortcut that skips attention computation for non-important tokens',
    ],
    correctAnswer: 1,
    explanation:
      'Flash Attention is an IO-aware exact attention algorithm that tiles the attention computation to minimize memory reads and writes between GPU high-bandwidth memory (HBM) and on-chip SRAM. It avoids materializing the full N x N attention matrix, reducing memory usage from O(N^2) to O(N) and significantly speeding up both training and inference.',
    tags: ['inference-optimization', 'flash-attention', 'memory'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-016',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'LLM Evaluation',
    question:
      'What is "contamination" in the context of LLM benchmarks and why is it problematic?',
    options: [
      'When the benchmark data is corrupted or contains errors',
      'When the benchmark test data appears in the model training data, leading to artificially inflated performance scores that do not reflect true generalization',
      'When the benchmark is run on contaminated hardware',
      'When multiple benchmarks use the same scoring system',
    ],
    correctAnswer: 1,
    explanation:
      'Benchmark contamination occurs when test data from evaluation benchmarks leaks into the training corpus. The model may memorize answers rather than demonstrating genuine reasoning or knowledge, making benchmark scores unreliable indicators of real-world performance. This is a growing concern as training corpora encompass more of the internet.',
    tags: ['evaluation', 'contamination', 'benchmarks'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-017',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'LLM Evaluation',
    question:
      'What is the difference between "pointwise", "pairwise", and "listwise" LLM-as-judge evaluation approaches?',
    options: [
      'They refer to different types of scoring scales (1-point, 2-point, and list-based)',
      'Pointwise scores a single output independently, pairwise compares two outputs head-to-head, and listwise ranks multiple outputs simultaneously',
      'They are different methods for evaluating embedding quality',
      'They refer to evaluating single tokens, token pairs, and token lists',
    ],
    correctAnswer: 1,
    explanation:
      'In LLM-as-judge: pointwise evaluation scores each output independently on criteria (e.g., 1-5 scale); pairwise presents two outputs and asks which is better (reducing bias from absolute scoring); listwise ranks multiple outputs at once. Pairwise is often preferred as it is more reliable than pointwise absolute scoring.',
    tags: ['evaluation', 'llm-as-judge', 'evaluation-methods'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-018',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Guardrails',
    question:
      'What is "prompt shield" or "sandwich defense" against prompt injection attacks?',
    options: [
      'Encrypting the prompt before sending it to the model',
      'Placing system instructions both before and after the user input, with the post-input instructions reminding the model to ignore any conflicting instructions from the user message',
      'Using a hardware firewall for the API',
      'Running the prompt through two different models',
    ],
    correctAnswer: 1,
    explanation:
      'The sandwich defense places critical system instructions both before and after the user input. The post-user-input instructions serve as a reminder to follow the original system instructions and ignore any attempts to override them. This makes prompt injection harder because the model sees the reinforced instructions after the attack attempt.',
    tags: ['guardrails', 'prompt-injection', 'security'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-019',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Guardrails',
    question:
      'What is "output parsing with retry logic" as a guardrail strategy?',
    options: [
      'Retrying API calls when the network fails',
      'Attempting to parse LLM output against a schema, and if parsing fails, sending the output and error back to the LLM to fix the formatting issues',
      'Parsing the output multiple times with different parsers',
      'Retrying the model training when validation loss increases',
    ],
    correctAnswer: 1,
    explanation:
      'Output parsing with retry logic validates the LLM output against the expected schema. If parsing fails (e.g., invalid JSON, missing fields), the raw output and the specific parsing error are sent back to the LLM with instructions to fix the formatting. This auto-correction loop typically succeeds within 1-2 retries.',
    tags: ['guardrails', 'structured-output', 'retry-logic'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-020',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'RAG',
    question:
      'What is "parent document retrieval" in advanced RAG architectures?',
    options: [
      'Retrieving documents from a parent directory',
      'Storing small chunks for embedding/retrieval but returning the larger parent document or section when a chunk matches, providing more context to the LLM',
      'Retrieving the original training documents used for the model',
      'A technique for retrieving documents from a hierarchical database',
    ],
    correctAnswer: 1,
    explanation:
      'Parent document retrieval decouples the retrieval unit from the context unit. Small chunks are used for precise embedding and retrieval (better matching), but when a chunk matches, the system returns its larger parent document or section to the LLM (better context). This balances retrieval precision with generation context quality.',
    tags: ['rag', 'parent-document-retrieval', 'chunking'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-021',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Fine-Tuning',
    question:
      'What is "DPO" (Direct Preference Optimization) and how does it compare to RLHF?',
    options: [
      'A database optimization technique for storing model parameters',
      'An alignment method that directly optimizes the policy model using preference pairs without needing a separate reward model, simplifying the RLHF pipeline',
      'A method for optimizing the data preprocessing pipeline',
      'A technique for directly optimizing the model architecture',
    ],
    correctAnswer: 1,
    explanation:
      'DPO eliminates the need for a separate reward model and RL training loop used in RLHF. Instead, it directly optimizes the language model policy using pairs of preferred and dispreferred responses. The loss function implicitly defines a reward, making alignment simpler, more stable, and computationally cheaper than traditional RLHF.',
    tags: ['fine-tuning', 'dpo', 'alignment', 'rlhf'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-022',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question: 'What is "prefix caching" in LLM serving systems?',
    options: [
      'Caching the first few tokens of each response',
      'Reusing the computed KV cache from a shared prompt prefix across multiple requests that share the same system prompt or few-shot examples',
      'Caching DNS prefixes for faster API resolution',
      'Pre-computing all possible completions for common prefixes',
    ],
    correctAnswer: 1,
    explanation:
      'Prefix caching stores the KV cache computed for common prompt prefixes (e.g., system prompts, few-shot examples, or RAG context). When multiple requests share the same prefix, the cached KV values are reused, avoiding redundant computation and significantly reducing time-to-first-token (TTFT) and compute costs.',
    tags: ['inference-optimization', 'prefix-caching', 'kv-cache'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-023',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Hallucination Mitigation',
    question:
      'What is "self-reflection" or "introspective verification" as a hallucination mitigation strategy?',
    options: [
      'Using a mirror API to duplicate responses',
      'Having the LLM generate an answer, then prompting it to critically evaluate its own response for factual accuracy and logical consistency, and revise accordingly',
      'Reflecting the output to multiple users for voting',
      'Using self-supervised learning during inference',
    ],
    correctAnswer: 1,
    explanation:
      'Self-reflection prompts the LLM to review its own output for potential errors, unsupported claims, or logical inconsistencies. The model acts as its own critic, identifying potential hallucinations and correcting them. This can be done in a single pass or iteratively for higher-stakes applications.',
    tags: ['hallucination', 'self-reflection', 'verification'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-024',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Embedding Models',
    question:
      'What is the difference between "symmetric" and "asymmetric" embedding models, and when would you choose each?',
    options: [
      'Symmetric uses the same number of dimensions for all inputs, asymmetric uses variable dimensions',
      'Symmetric models embed queries and documents identically (same encoder), while asymmetric models use different encoding strategies for queries vs. documents, better suited for retrieval where queries and documents differ in length/style',
      'Symmetric models work on pairs, asymmetric on single inputs',
      'There is no practical difference between them',
    ],
    correctAnswer: 1,
    explanation:
      'Symmetric models (e.g., for semantic similarity) encode both inputs the same way, ideal when comparing similar-length texts. Asymmetric models use different instruction prefixes or encoders for queries (short) vs. documents (long), optimized for retrieval tasks where the query style differs significantly from the document style.',
    tags: ['embeddings', 'symmetric', 'asymmetric', 'retrieval'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-025',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Function Calling',
    question:
      'What is "parallel function calling" and what challenge does it introduce?',
    options: [
      'Calling the same function multiple times with the same arguments',
      'The LLM generating multiple function calls in a single turn that can be executed concurrently, with the challenge of handling dependencies between calls and aggregating results',
      'Running function calls on parallel GPU threads',
      'Calling functions from multiple programming languages simultaneously',
    ],
    correctAnswer: 1,
    explanation:
      'Parallel function calling allows the LLM to request multiple independent function calls in one response. The application must identify which calls are independent (can run concurrently) vs. dependent (must run sequentially), execute them accordingly, and return all results to the LLM for synthesis. Incorrect dependency handling can lead to errors or inconsistent results.',
    tags: ['function-calling', 'parallel', 'tool-use'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-026',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'RAG',
    question: 'What is "RAPTOR" (Recursive Abstractive Processing for Tree-Organized Retrieval)?',
    options: [
      'A dinosaur-themed LLM model',
      'A RAG technique that recursively clusters and summarizes document chunks into a tree structure, enabling retrieval at different levels of abstraction',
      'A rapid prototyping tool for RAG applications',
      'A method for quickly training retrieval models',
    ],
    correctAnswer: 1,
    explanation:
      'RAPTOR builds a hierarchical tree over a document corpus by recursively clustering chunks based on embedding similarity and summarizing each cluster. Retrieval can then happen at leaf level (detailed) or higher levels (abstract summaries), enabling the system to answer both specific and broad questions effectively.',
    tags: ['rag', 'raptor', 'hierarchical-retrieval'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-027',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'LLM Evaluation',
    question:
      'What are "adversarial evaluation" techniques for LLMs and why are they important?',
    options: [
      'Evaluating the model on easy tasks to build confidence',
      'Systematically testing the model with edge cases, adversarial inputs, and stress tests designed to expose weaknesses like hallucinations, prompt injection vulnerabilities, and reasoning failures',
      'Having two models compete against each other in a game',
      'Evaluating the model against an adversarial network (GAN)',
    ],
    correctAnswer: 1,
    explanation:
      'Adversarial evaluation involves crafting challenging inputs specifically designed to expose model weaknesses: trick questions, prompt injections, contradictory context, unanswerable questions, and boundary cases. This is critical for understanding failure modes before deployment and building appropriate guardrails.',
    tags: ['evaluation', 'adversarial', 'red-teaming'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-028',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Inference Optimization',
    question: 'What is "Grouped Query Attention" (GQA) and why is it used in modern LLMs?',
    options: [
      'A method for grouping user queries together for batch processing',
      'An attention variant that uses fewer key-value heads than query heads (groups of query heads share KV heads), reducing KV cache size and memory bandwidth while maintaining quality close to multi-head attention',
      'An attention mechanism that groups tokens by their semantic similarity',
      'A technique for grouping attention layers together for parallel execution',
    ],
    correctAnswer: 1,
    explanation:
      'GQA is a middle ground between Multi-Head Attention (MHA, one KV head per query head) and Multi-Query Attention (MQA, single KV head for all query heads). GQA uses a small number of KV head groups, with multiple query heads sharing each group. This significantly reduces KV cache size and memory bandwidth during inference while preserving most of the quality of MHA.',
    tags: ['inference-optimization', 'gqa', 'attention'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-029',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Structured Output',
    question:
      'How does "constrained decoding" (grammar-guided generation) guarantee valid structured output at the token level?',
    options: [
      'By post-processing the output and fixing any errors',
      'By masking out logits of tokens that would violate the grammar at each generation step, ensuring only valid tokens can be sampled',
      'By training the model exclusively on structured data',
      'By running a validator in parallel and regenerating invalid tokens',
    ],
    correctAnswer: 1,
    explanation:
      'Constrained decoding maintains a grammar state (e.g., a JSON parser state machine) during generation. At each step, it masks the logits of tokens that would produce an invalid continuation according to the grammar, ensuring that only tokens leading to valid structured output can be selected. This provides a hard guarantee of structural validity.',
    tags: ['structured-output', 'constrained-decoding', 'grammar'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-030',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Token Management',
    question:
      'What is the "lost in the middle" phenomenon in long-context LLMs?',
    options: [
      'Tokens in the middle of the vocabulary are rarely used',
      'LLMs tend to recall information from the beginning and end of long contexts better than information placed in the middle, even within the supported context window',
      'The middle layers of the transformer are less effective',
      'Middle-length prompts (neither short nor long) produce the worst results',
    ],
    correctAnswer: 1,
    explanation:
      'Research has shown that LLMs exhibit a U-shaped attention pattern in long contexts: they recall information better when it appears at the beginning or end of the context, while information in the middle is more likely to be overlooked. This has practical implications for how retrieved documents should be ordered in RAG pipelines.',
    tags: ['token-management', 'context-window', 'lost-in-the-middle'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-031',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Fine-Tuning',
    question:
      'What is "merge" of LoRA adapters and what are the trade-offs?',
    options: [
      'Combining the training data from multiple fine-tuning runs',
      'Adding the trained LoRA matrices back into the base model weights to create a single model without adapter overhead, trading the ability to swap/combine adapters for inference speed',
      'Merging multiple LLMs into a single larger model',
      'Combining the outputs of multiple LoRA adapters at inference time',
    ],
    correctAnswer: 1,
    explanation:
      'LoRA merge adds the low-rank adapter matrices (A * B * scaling) back into the original weight matrices, producing a single model. Benefits: no adapter overhead during inference, simpler deployment. Trade-offs: loses the ability to hot-swap adapters, cannot easily serve multiple tasks with different adapters from the same base model.',
    tags: ['fine-tuning', 'lora', 'merge', 'deployment'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-032',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Semantic Search',
    question:
      'What are "approximate nearest neighbor" (ANN) algorithms and why are they preferred over exact nearest neighbor for vector search at scale?',
    options: [
      'ANN algorithms find the approximate location of the database server nearest to the user',
      'ANN algorithms trade a small amount of recall accuracy for dramatically faster search speeds (sub-linear time) compared to exact brute-force search, making them practical for millions/billions of vectors',
      'ANN algorithms are less accurate but easier to implement',
      'ANN algorithms only work with small datasets',
    ],
    correctAnswer: 1,
    explanation:
      'Exact nearest neighbor search requires comparing the query against every vector (O(n) time), which is impractical for large-scale deployments. ANN algorithms (like HNSW, IVF, ScaNN) use indexing structures to find approximate nearest neighbors in sub-linear time, with tunable trade-offs between recall and speed. Most production systems achieve >95% recall at orders of magnitude faster speed.',
    tags: ['semantic-search', 'ann', 'vector-search', 'hnsw'],
  },
  {
    id: 'ai-engineer-llm-engineering-l3-033',
    language: 'ai-engineer',
    level: 'level3',
    category: 'LLM Engineering',
    subcategory: 'Hallucination Mitigation',
    question:
      'What is "citation generation" as a hallucination detection mechanism in RAG systems?',
    options: [
      'Generating academic citations in a bibliography format',
      'Requiring the LLM to include inline citations referencing specific retrieved chunks for each claim, enabling verification that statements are grounded in the provided context',
      'Citing the model version and training data in each response',
      'Generating citations for the model architecture paper',
    ],
    correctAnswer: 1,
    explanation:
      'Citation generation instructs the LLM to cite the specific retrieved document or chunk that supports each factual claim in its response (e.g., [1], [2]). This enables automated verification that claims are grounded in the retrieved context, makes hallucinations more detectable (uncited claims or incorrect citations), and builds user trust through transparency.',
    tags: ['hallucination', 'citation', 'rag', 'grounding'],
  },
];

export default questions;
