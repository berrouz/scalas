import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'ai-engineer-vector-db-l3-001',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Multi-Vector Representations',
    question: 'How does ColBERT differ from a standard bi-encoder for retrieval?',
    options: [
      'ColBERT produces multiple token-level embeddings per document and uses late interaction (MaxSim) for scoring',
      'ColBERT uses a single vector per document like any bi-encoder',
      'ColBERT is a cross-encoder that processes query-document pairs together',
      'ColBERT only works with image data, not text',
    ],
    correctAnswer: 0,
    explanation:
      'ColBERT (Contextualized Late Interaction over BERT) generates per-token embeddings for both queries and documents. At scoring time, it computes maximum similarity (MaxSim) between each query token and all document tokens, then sums these scores. This provides cross-encoder-like quality with bi-encoder-like efficiency.',
    tags: ['colbert', 'multi-vector', 'late-interaction'],
  },
  {
    id: 'ai-engineer-vector-db-l3-002',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'ANN Algorithms',
    question:
      'In HNSW, why does the algorithm use an exponentially decreasing probability for node insertion into higher layers?',
    options: [
      'To create a navigable hierarchy where upper layers act as express highways for coarse-grained navigation',
      'To ensure all layers have the same number of nodes',
      'To reduce the total number of edges in the graph',
      'To prevent memory overflow on lower layers',
    ],
    correctAnswer: 0,
    explanation:
      'The exponentially decreasing insertion probability creates a hierarchical structure similar to a skip list. Upper layers have few nodes with long-range connections for fast coarse navigation, while lower layers have many nodes for fine-grained search. This gives O(log n) search complexity.',
    tags: ['hnsw', 'ann-algorithms', 'theory'],
  },
  {
    id: 'ai-engineer-vector-db-l3-003',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Quantization',
    question:
      'What is the key advantage of Optimized Product Quantization (OPQ) over standard Product Quantization?',
    options: [
      'OPQ applies a rotation matrix to distribute variance evenly across sub-vectors before quantization',
      'OPQ uses fewer codebook entries than standard PQ',
      'OPQ eliminates the need for training data',
      'OPQ only quantizes the most important dimensions',
    ],
    correctAnswer: 0,
    explanation:
      'Standard PQ assumes independence between sub-vectors, which may not hold. OPQ learns a rotation matrix that decorrelates dimensions and distributes information evenly across sub-vectors, leading to lower quantization error and better recall.',
    tags: ['opq', 'product-quantization', 'quantization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-004',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Training',
    question: 'How does SimCLR create positive pairs for contrastive learning without labeled data?',
    options: [
      'By applying two different random augmentations to the same input to create a positive pair',
      'By using nearest neighbors in a pre-trained embedding space',
      'By splitting documents into consecutive paragraphs',
      'By using machine translation to create paraphrases',
    ],
    correctAnswer: 0,
    explanation:
      'SimCLR creates positive pairs through data augmentation: the same input is augmented twice with random transformations (cropping, color jitter, blur for images). The model is trained to make these augmented views similar while pushing apart views from different inputs.',
    tags: ['simclr', 'contrastive-learning', 'self-supervised'],
  },
  {
    id: 'ai-engineer-vector-db-l3-005',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'ANN Algorithms',
    question:
      'What is anisotropic vector quantization as used in ScaNN, and why is it better than isotropic quantization for retrieval?',
    options: [
      'It penalizes quantization errors in the direction of the original vector more heavily, preserving inner product ordering',
      'It quantizes all directions equally regardless of the vector orientation',
      'It only quantizes the magnitude of vectors, not their direction',
      'It uses different codebook sizes for each dimension',
    ],
    correctAnswer: 0,
    explanation:
      'Anisotropic quantization recognizes that for inner product (or cosine) retrieval, errors parallel to the original vector affect rankings more than perpendicular errors. By penalizing parallel errors more, it preserves the inner product ordering better than isotropic (direction-agnostic) quantization.',
    tags: ['scann', 'anisotropic-quantization', 'ann-algorithms'],
  },
  {
    id: 'ai-engineer-vector-db-l3-006',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Indexing',
    question: 'What is the IVF-PQ composite index strategy, and when would you use it?',
    options: [
      'IVF partitions space into clusters, then PQ compresses residual vectors within each cluster; used for billion-scale datasets',
      'IVF and PQ run in parallel on separate machines; used for low-latency search',
      'PQ is used for indexing and IVF for quantization; used for small datasets',
      'IVF handles text search and PQ handles vector search; used for hybrid retrieval',
    ],
    correctAnswer: 0,
    explanation:
      'IVF-PQ first clusters vectors using IVF, then applies Product Quantization to the residual vectors (difference from cluster centroid) within each cluster. This dramatically reduces memory while maintaining good recall, making it suitable for billion-scale datasets.',
    tags: ['ivf-pq', 'composite-index', 'indexing'],
  },
  {
    id: 'ai-engineer-vector-db-l3-007',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Multi-Vector Representations',
    question:
      'What is the storage challenge with ColBERT-style multi-vector representations, and how is it typically addressed?',
    options: [
      'Each document requires storing many token embeddings; addressed with residual compression and centroid-based quantization (ColBERTv2)',
      'Documents become too large for any database; addressed by using only the first 10 tokens',
      'The embeddings are too high-dimensional; addressed by reducing to 2 dimensions',
      'Multi-vector models are too slow to train; addressed by freezing all layers',
    ],
    correctAnswer: 0,
    explanation:
      'ColBERT stores one embedding per token, so a 200-token document needs 200 vectors instead of 1. ColBERTv2 addresses this with residual compression: vectors are replaced by their residuals from cluster centroids and then heavily quantized, reducing storage by ~30x.',
    tags: ['colbert', 'colbertv2', 'compression'],
  },
  {
    id: 'ai-engineer-vector-db-l3-008',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Scaling',
    question:
      'What is the difference between inter-query and intra-query parallelism in distributed vector search?',
    options: [
      'Inter-query: different queries run on different replicas; Intra-query: a single query is distributed across shards holding different data partitions',
      'Inter-query: same query on all shards; Intra-query: queries are serialized',
      'Inter-query: parallel index building; Intra-query: parallel embedding generation',
      'Inter-query: searching multiple collections; Intra-query: searching one collection',
    ],
    correctAnswer: 0,
    explanation:
      'Inter-query parallelism handles multiple concurrent queries by routing them to different replicas. Intra-query parallelism splits a single query across multiple shards, each searching its partition, then merges the results. Both are needed for high-throughput, low-latency systems.',
    tags: ['parallelism', 'distributed-search', 'scaling'],
  },
  {
    id: 'ai-engineer-vector-db-l3-009',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Training',
    question: 'What is hard negative mining, and why is it important for embedding model training?',
    options: [
      'Selecting negatives that are close to the anchor in embedding space to provide a stronger training signal',
      'Removing easy positive examples from the training set',
      'Mining negative reviews from social media for sentiment training',
      'Randomly sampling negatives from the entire corpus',
    ],
    correctAnswer: 0,
    explanation:
      'Hard negative mining selects negative examples that are close to the positive in embedding space (i.e., the model finds them confusing). These hard negatives provide a stronger learning signal than random negatives, significantly improving the model\'s ability to discriminate between similar but irrelevant items.',
    tags: ['hard-negative-mining', 'embedding-training'],
  },
  {
    id: 'ai-engineer-vector-db-l3-010',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Quantization',
    question: 'What is binary quantization of vectors, and what is its main trade-off?',
    options: [
      'Converting each float dimension to a single bit (0 or 1); extreme compression (32x) but significant accuracy loss unless combined with re-ranking',
      'Storing vectors as binary files on disk; slower I/O but smaller file sizes',
      'Using binary search trees for vector indexing; faster search but more memory',
      'Converting integer vectors to floating-point; higher precision but more storage',
    ],
    correctAnswer: 0,
    explanation:
      'Binary quantization converts each vector dimension to a single bit based on whether it is positive or negative, achieving 32x compression (float32 to 1 bit). Hamming distance replaces cosine similarity. Accuracy drops significantly, so it is typically used as a first-pass filter followed by re-ranking with original vectors.',
    tags: ['binary-quantization', 'quantization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-011',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Matryoshka Embeddings',
    question:
      'How are Matryoshka embeddings trained to ensure smaller truncated dimensions remain useful?',
    options: [
      'By computing the loss at multiple dimensionality truncation points simultaneously during training',
      'By training separate models for each dimensionality',
      'By sorting dimensions by importance after training',
      'By applying PCA to a pre-trained embedding model',
    ],
    correctAnswer: 0,
    explanation:
      'Matryoshka Representation Learning computes the training loss at multiple truncation points (e.g., d=32, 64, 128, 256, 768) simultaneously. The total loss is a weighted sum, forcing the model to encode the most important information in the earlier dimensions.',
    tags: ['matryoshka', 'embedding-training'],
  },
  {
    id: 'ai-engineer-vector-db-l3-012',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Indexing',
    question:
      'What is the DiskANN algorithm, and what problem does it solve?',
    options: [
      'A graph-based ANN index that stores vectors on SSD with a small in-memory footprint, enabling billion-scale search on a single machine',
      'A distributed ANN algorithm that requires many machines for large datasets',
      'An in-memory-only algorithm optimized for small datasets',
      'A disk-based exact nearest neighbor search without approximation',
    ],
    correctAnswer: 0,
    explanation:
      'DiskANN (Vamana) builds a graph index where the graph structure and compressed vectors fit in RAM while full-precision vectors are stored on SSD. It uses a beam search with SSD reads, enabling billion-scale ANN on a single machine with high recall and low latency.',
    tags: ['diskann', 'vamana', 'indexing'],
  },
  {
    id: 'ai-engineer-vector-db-l3-013',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Hybrid Search',
    question:
      'What are learned sparse embeddings (e.g., SPLADE), and how do they improve hybrid search?',
    options: [
      'Neural models that output sparse high-dimensional vectors with term-weighting, combining the benefits of neural understanding and inverted index efficiency',
      'Compressed dense vectors that behave like sparse vectors',
      'Embeddings trained only on rare vocabulary words',
      'Standard TF-IDF vectors with learned stopword removal',
    ],
    correctAnswer: 0,
    explanation:
      'SPLADE (Sparse Lexical and Expansion) learns sparse vectors where dimensions correspond to vocabulary terms with neural-learned weights. It captures semantic expansion (adding related terms) while being efficiently searchable with inverted indexes, bridging dense and sparse retrieval.',
    tags: ['splade', 'learned-sparse', 'hybrid-search'],
  },
  {
    id: 'ai-engineer-vector-db-l3-014',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Fine-tuning',
    question:
      'What is the HNSWLIB "repair" problem when continuously inserting and deleting vectors, and how do databases handle it?',
    options: [
      'Deleted nodes leave broken graph connections reducing recall; handled by periodic graph repair, tombstone markers, or full re-indexing',
      'Insertions slow down linearly; handled by batch processing',
      'The graph runs out of layers; handled by increasing the maximum layer count',
      'Search quality improves after deletions; no handling needed',
    ],
    correctAnswer: 0,
    explanation:
      'When nodes are deleted from an HNSW graph, their connections become dead links. Neighbors that relied on the deleted node for connectivity lose potential search paths, degrading recall. Databases use tombstone markers (lazy deletion), periodic graph repair that reconnects neighbors, or eventually rebuild the index.',
    tags: ['hnsw', 'deletion', 'graph-repair'],
  },
  {
    id: 'ai-engineer-vector-db-l3-015',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Training',
    question:
      'What is the role of temperature in the InfoNCE contrastive loss, and how does it affect training?',
    options: [
      'It scales the similarity scores before softmax; lower temperature sharpens the distribution, making training focus on harder negatives',
      'It controls the learning rate during training',
      'It determines the batch size for contrastive pairs',
      'It sets the maximum number of training epochs',
    ],
    correctAnswer: 0,
    explanation:
      'Temperature (tau) in InfoNCE scales the logits: L = -log(exp(sim(q,k+)/tau) / sum(exp(sim(q,ki)/tau))). Lower temperature sharpens the softmax distribution, amplifying differences between similar scores and making the model focus on hard negatives. Too low causes training instability; too high makes training too easy.',
    tags: ['infonce', 'temperature', 'contrastive-learning'],
  },
  {
    id: 'ai-engineer-vector-db-l3-016',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Scaling',
    question: 'What is the challenge of metadata filtering with pre-filtering in HNSW indexes?',
    options: [
      'The HNSW graph was built on all vectors, so skipping filtered-out nodes during traversal can disconnect the search path and reduce recall',
      'Pre-filtering is always faster so there is no challenge',
      'Metadata cannot be stored alongside HNSW graph nodes',
      'Pre-filtering requires rebuilding the index for each query',
    ],
    correctAnswer: 0,
    explanation:
      'When pre-filtering with HNSW, the graph traversal must skip nodes that do not match the filter. If many nodes are filtered out, the search path becomes disconnected, severely degrading recall. Solutions include over-traversal, filterable HNSW variants, or partition-based approaches.',
    tags: ['hnsw', 'pre-filtering', 'metadata-filtering'],
  },
  {
    id: 'ai-engineer-vector-db-l3-017',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Quantization',
    question:
      'What is Rescoring or Asymmetric Distance Computation (ADC) in the context of Product Quantization?',
    options: [
      'Computing distances using the full-precision query vector against PQ-compressed database vectors, avoiding query quantization error',
      'Quantizing both query and database vectors symmetrically',
      'Computing distances between two quantized vectors',
      'Using different distance metrics for different sub-vectors',
    ],
    correctAnswer: 0,
    explanation:
      'ADC computes the distance between the original (unquantized) query vector and PQ-compressed database vectors. Since only database vectors are quantized, this "asymmetric" approach avoids the additional error from quantizing the query, yielding better accuracy than symmetric distance computation (SDC).',
    tags: ['adc', 'product-quantization', 'quantization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-018',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Multi-Vector Representations',
    question:
      'What is the PLAID engine optimization for ColBERT retrieval?',
    options: [
      'It uses centroid interaction to prune candidate documents before performing full late interaction scoring',
      'It stores each document as a single averaged vector',
      'It replaces MaxSim with simple dot product',
      'It eliminates the need for an index entirely',
    ],
    correctAnswer: 0,
    explanation:
      'PLAID (Performance-optimized Late Interaction Driver) first scores documents against the query using centroid representations (cheap approximation), prunes low-scoring candidates, decompresses only the remaining candidates\' token embeddings, and performs full MaxSim scoring. This makes ColBERT retrieval practical at scale.',
    tags: ['plaid', 'colbert', 'optimization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-019',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Training',
    question:
      'What is the "in-batch negatives" technique in contrastive embedding training?',
    options: [
      'Using other positive examples within the same batch as negative examples for each anchor, maximizing training efficiency',
      'Removing negative examples from each batch',
      'Using examples from the previous batch as negatives',
      'Limiting the batch to contain only negative examples',
    ],
    correctAnswer: 0,
    explanation:
      'In-batch negatives reuse the positive documents of other pairs in the batch as negatives for the current query. For a batch of N pairs, each query gets N-1 negatives "for free" without extra computation, dramatically increasing the number of contrastive comparisons.',
    tags: ['in-batch-negatives', 'contrastive-learning'],
  },
  {
    id: 'ai-engineer-vector-db-l3-020',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Indexing',
    question:
      'What is the trade-off between IVF and HNSW indexes for ANN search?',
    options: [
      'IVF uses less memory and is faster to build but HNSW generally achieves higher recall at the same query latency',
      'HNSW uses less memory than IVF in all cases',
      'IVF always achieves higher recall than HNSW',
      'There is no trade-off; they are equivalent in all aspects',
    ],
    correctAnswer: 0,
    explanation:
      'IVF indexes are faster to build and use less memory (only centroids + inverted lists). HNSW requires storing the graph structure (significant memory overhead) but typically achieves higher recall at equivalent latency. The choice depends on memory budget, dataset size, and accuracy requirements.',
    tags: ['ivf', 'hnsw', 'indexing', 'comparison'],
  },
  {
    id: 'ai-engineer-vector-db-l3-021',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Fine-tuning',
    question:
      'What is Matryoshka + binary quantization as a combined strategy, and why is it powerful?',
    options: [
      'Truncate Matryoshka embeddings to fewer dimensions, then binary-quantize them, enabling fast coarse retrieval with extreme compression followed by re-ranking',
      'Train two separate models and merge their outputs',
      'Apply binary quantization first, then train Matryoshka on the binary vectors',
      'Use Matryoshka for queries and binary for documents',
    ],
    correctAnswer: 0,
    explanation:
      'By first truncating Matryoshka embeddings (e.g., 1024 to 128 dims) then applying binary quantization (128 bits = 16 bytes per vector), you get extremely compact representations for fast first-stage retrieval. Re-ranking with full-precision vectors restores accuracy. This can reduce storage by ~256x.',
    tags: ['matryoshka', 'binary-quantization', 'optimization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-022',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Scaling',
    question:
      'What is the challenge of maintaining consistency during index updates in a distributed vector database?',
    options: [
      'New vectors must be visible across all shards and replicas without stale reads, requiring careful coordination between write paths and search paths',
      'Indexes cannot be updated once created',
      'All queries must be paused during any update',
      'Updates only affect metadata, not vectors',
    ],
    correctAnswer: 0,
    explanation:
      'In distributed vector databases, ensuring that newly inserted, updated, or deleted vectors are consistently visible across all replicas and shards is challenging. Write-ahead logs, segment-based architectures, and eventually consistent replication are common strategies to balance consistency with availability.',
    tags: ['consistency', 'distributed-systems', 'scaling'],
  },
  {
    id: 'ai-engineer-vector-db-l3-023',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'ANN Algorithms',
    question:
      'What is Locality-Sensitive Hashing (LSH), and why has it largely been replaced by graph-based methods?',
    options: [
      'LSH uses random hash functions to bucket similar vectors together; it has been replaced because graph-based methods like HNSW achieve much better recall-speed trade-offs',
      'LSH is a neural network approach; replaced because it requires too much training data',
      'LSH provides exact search; replaced because approximate search is preferred',
      'LSH only works with binary data; replaced to support floating-point vectors',
    ],
    correctAnswer: 0,
    explanation:
      'LSH uses families of hash functions where similar vectors are likely to hash to the same bucket. While theoretically elegant with sub-linear guarantees, in practice graph-based methods (HNSW) and quantization methods (IVF-PQ) consistently achieve superior recall-vs-latency and recall-vs-memory trade-offs.',
    tags: ['lsh', 'ann-algorithms', 'comparison'],
  },
  {
    id: 'ai-engineer-vector-db-l3-024',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Hybrid Search',
    question:
      'What is the advantage of using a single model that produces both dense and sparse representations (like BGE-M3)?',
    options: [
      'It generates aligned dense, sparse, and ColBERT representations in one forward pass, simplifying the pipeline and improving hybrid retrieval',
      'It eliminates the need for vector storage entirely',
      'It produces smaller vectors than any single-purpose model',
      'It only works for English text',
    ],
    correctAnswer: 0,
    explanation:
      'Models like BGE-M3 produce dense embeddings, learned sparse (lexical) weights, and multi-vector (ColBERT) representations simultaneously from a single forward pass. This eliminates the need for separate models, ensures representation alignment, and simplifies hybrid search pipelines.',
    tags: ['bge-m3', 'multi-representation', 'hybrid-search'],
  },
  {
    id: 'ai-engineer-vector-db-l3-025',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Training',
    question:
      'What is knowledge distillation for embedding models, and how is it used to create smaller, faster models?',
    options: [
      'Training a smaller student model to mimic the similarity scores of a larger teacher model, preserving retrieval quality with fewer parameters',
      'Removing layers from a large model without any retraining',
      'Copying the weights from the last layer of a large model',
      'Training two identical models on different data subsets',
    ],
    correctAnswer: 0,
    explanation:
      'Knowledge distillation trains a compact student embedding model to match the output distribution (similarity scores or rankings) of a larger, more accurate teacher model. The student learns to approximate the teacher\'s embedding space, achieving competitive retrieval quality with significantly fewer parameters and faster inference.',
    tags: ['knowledge-distillation', 'embedding-training', 'optimization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-026',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Indexing',
    question:
      'What is the "segment" architecture used by Milvus and similar vector databases?',
    options: [
      'Data is organized into immutable sealed segments and a growing mutable segment; sealed segments are indexed while the growing segment handles new writes',
      'The index is split into equal-sized fixed partitions',
      'Each vector is stored in its own file',
      'Segments refer to GPU memory partitions for parallel processing',
    ],
    correctAnswer: 0,
    explanation:
      'Milvus uses an LSM-like segment architecture. New vectors go into a growing (mutable) segment. When it reaches a threshold, it is sealed and an optimized ANN index is built on it. This separates the write path from the read path, enabling concurrent insertions and searches.',
    tags: ['milvus', 'segment-architecture', 'indexing'],
  },
  {
    id: 'ai-engineer-vector-db-l3-027',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Dimensionality Reduction',
    question:
      'Why might PCA-based dimensionality reduction be suboptimal for retrieval-oriented embeddings, and what is a better alternative?',
    options: [
      'PCA preserves maximum variance, not retrieval-relevant structure; supervised or task-aware methods like Matryoshka training or linear probing preserve retrieval quality better',
      'PCA is always the best approach for dimensionality reduction',
      'PCA cannot be applied to floating-point vectors',
      'PCA increases the number of dimensions instead of reducing them',
    ],
    correctAnswer: 0,
    explanation:
      'PCA optimizes for variance preservation, which may not align with preserving the nearest-neighbor structure critical for retrieval. Dimensions with high variance might not be the most discriminative for similarity search. Matryoshka training or supervised dimensionality reduction preserves the ranking structure that matters for retrieval.',
    tags: ['pca', 'dimensionality-reduction', 'matryoshka'],
  },
  {
    id: 'ai-engineer-vector-db-l3-028',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Metadata Filtering',
    question:
      'What is the "filtered HNSW" or "ACORN" approach to combining metadata filtering with graph-based ANN search?',
    options: [
      'Modifying the HNSW graph construction and traversal to be filter-aware, maintaining connectivity for filtered subsets of the graph',
      'Building a separate HNSW index for each possible filter value',
      'Applying filters only after search is complete',
      'Removing filtered nodes from the graph permanently',
    ],
    correctAnswer: 0,
    explanation:
      'Filtered HNSW approaches modify graph construction to ensure connectivity is maintained even when large subsets of nodes are filtered out. ACORN, for example, augments HNSW with additional edges that maintain reachability under various filter predicates, avoiding the recall degradation of naive skip-based filtering.',
    tags: ['filtered-hnsw', 'acorn', 'metadata-filtering'],
  },
  {
    id: 'ai-engineer-vector-db-l3-029',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Training',
    question:
      'What is the GISTEmbed or Guided In-sample Selection of Training Negatives approach?',
    options: [
      'Using a separate guide model to select the most informative negatives from the in-batch candidates during contrastive training',
      'Randomly selecting negatives from the training corpus',
      'Using only manually curated negative examples',
      'Training without any negative examples',
    ],
    correctAnswer: 0,
    explanation:
      'GISTEmbed uses a pre-trained guide model (e.g., a cross-encoder) to score in-batch negatives and select the hardest/most informative ones for each anchor. This improves training efficiency by focusing the contrastive loss on the negatives that provide the strongest learning signal.',
    tags: ['gistembed', 'negative-selection', 'embedding-training'],
  },
  {
    id: 'ai-engineer-vector-db-l3-030',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Scaling',
    question:
      'What is the "streaming" or "online" indexing challenge for ANN algorithms, and how do modern systems address it?',
    options: [
      'Maintaining index quality while continuously inserting new vectors without full rebuilds; addressed with incremental graph updates, segment-based architectures, and background compaction',
      'Processing search queries in real-time; addressed with caching',
      'Streaming video data into the database; addressed with chunking',
      'Sending index updates over a network; addressed with compression',
    ],
    correctAnswer: 0,
    explanation:
      'Many ANN indexes (especially IVF-based) assume a static dataset and degrade with updates. Modern systems address this with HNSW (naturally supports incremental inserts), segment-based architectures (new data goes into fresh segments), and background compaction/re-indexing to maintain quality over time.',
    tags: ['online-indexing', 'streaming', 'scaling'],
  },
  {
    id: 'ai-engineer-vector-db-l3-031',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Encoders',
    question:
      'What is "late interaction" and how does it differ from full cross-attention in cross-encoders?',
    options: [
      'Late interaction computes independent token embeddings then uses a lightweight interaction function (like MaxSim); cross-encoders use full self-attention across concatenated inputs',
      'Late interaction and cross-attention are identical mechanisms',
      'Late interaction processes inputs sequentially; cross-attention processes them in parallel',
      'Late interaction only works with image data',
    ],
    correctAnswer: 0,
    explanation:
      'Late interaction (as in ColBERT) encodes query and document independently through separate forward passes, then computes token-level interactions (MaxSim) cheaply. Cross-encoders concatenate query and document, running full self-attention across all tokens jointly. Late interaction is much faster but slightly less expressive.',
    tags: ['late-interaction', 'cross-encoder', 'comparison'],
  },
  {
    id: 'ai-engineer-vector-db-l3-032',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Quantization',
    question:
      'What is RABITQ (Randomized Binary Quantization) and how does it differ from naive binary quantization?',
    options: [
      'RABITQ applies random rotations before binary quantization to distribute information across dimensions, providing theoretical error bounds and better accuracy',
      'RABITQ uses three quantization levels instead of two',
      'RABITQ only works with GPU-accelerated databases',
      'RABITQ is the same as standard binary quantization with a different name',
    ],
    correctAnswer: 0,
    explanation:
      'RABITQ applies a random orthogonal rotation to vectors before binary quantization. This ensures that quantization error is distributed evenly across dimensions regardless of the original vector distribution. It provides theoretical bounds on the quantization error and consistently outperforms naive sign-based binary quantization.',
    tags: ['rabitq', 'binary-quantization', 'quantization'],
  },
  {
    id: 'ai-engineer-vector-db-l3-033',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Vector Databases & Embeddings',
    subcategory: 'Embedding Fine-tuning',
    question:
      'What is the "embedding space alignment" problem when fine-tuning embeddings, and how can it be mitigated?',
    options: [
      'Fine-tuning shifts the embedding space so previously indexed vectors become incompatible with new query vectors; mitigated by compatible training objectives or re-encoding the corpus',
      'Fine-tuning makes embeddings too large to store; mitigated by quantization',
      'Fine-tuning always improves all queries equally; no mitigation needed',
      'Fine-tuning only changes the query encoder; mitigated by freezing it',
    ],
    correctAnswer: 0,
    explanation:
      'When an embedding model is fine-tuned, the output space shifts, making previously indexed document embeddings incompatible with new query embeddings. Solutions include: re-encoding the entire corpus (expensive), compatible training that constrains drift from the original space, or adaptor-based approaches that transform queries to match the old space.',
    tags: ['embedding-alignment', 'fine-tuning', 'index-compatibility'],
  },
];

export default questions;
