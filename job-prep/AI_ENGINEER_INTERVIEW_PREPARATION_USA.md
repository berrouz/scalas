# AI Engineer Interview Preparation Guide (USA 2025-2026)

Complete guide to preparing for AI Engineer interviews in the United States.

---

## 1. Overview

### What Is an AI Engineer?

An **AI Engineer** builds production AI systems, bridging the gap between research and deployed products. The role emerged as a distinct discipline in 2023-2024 with the explosion of LLM-powered applications and has become one of the most in-demand positions in tech by 2025-2026.

**AI Engineer vs. Related Roles:**

| Role | Focus | Primary Output |
|------|-------|----------------|
| **AI Engineer** | Building production AI systems, LLM integration, RAG, agents, ML infrastructure | Deployed AI features & pipelines |
| **ML Engineer** | Training/optimizing models, feature engineering, model serving | Trained models & serving infra |
| **Data Scientist** | Analysis, experimentation, statistical modeling | Insights, experiments, prototypes |
| **Research Scientist** | Novel algorithms, publishing papers, pushing SOTA | Papers, new architectures |
| **ML Platform Engineer** | Infrastructure for ML workflows (training, serving, monitoring) | ML platforms & tooling |

### Key Skills for AI Engineers (2025-2026)

1. **LLM Engineering** — prompt engineering, RAG, agents, fine-tuning, evaluation
2. **ML Fundamentals** — supervised/unsupervised learning, deep learning, optimization
3. **Python Proficiency** — NumPy, Pandas, PyTorch, production-quality code
4. **System Design** — designing end-to-end ML systems for scale
5. **Production ML** — deployment, monitoring, CI/CD for ML, latency optimization
6. **Software Engineering** — APIs, distributed systems, databases, testing

---

## 2. Target Companies & Compensation

### Tier 1: AI-First Research Labs
- **OpenAI** — GPT series, ChatGPT, API platform
- **Anthropic** — Claude, constitutional AI, safety research
- **Google DeepMind** — Gemini, AlphaFold, foundational research
- **Meta AI (FAIR)** — LLaMA, open-source models, AR/VR AI
- **Apple ML** — On-device ML, Siri, Apple Intelligence

### Tier 2: AI-Focused Companies
- **Cohere** — Enterprise LLMs, embeddings, Rerank
- **Mistral** — Open-weight models, European AI leader
- **Stability AI** — Stable Diffusion, generative AI
- **Hugging Face** — Model hub, Transformers library, open-source AI
- **Databricks** — MLflow, lakehouse AI, DBRX
- **Scale AI** — Data labeling, RLHF, government AI
- **Perplexity** — AI-powered search
- **Cursor / Replit** — AI-powered developer tools

### Tier 3: AI Teams at Top Tech Companies
- **Stripe** — fraud detection, payment optimization
- **Notion** — AI-powered workspace features
- **Figma** — AI design tools
- **Airbnb** — search ranking, pricing, recommendations
- **Netflix** — recommendation systems, content optimization
- **Uber** — demand forecasting, routing, ETA prediction
- **Spotify** — music recommendation, audio understanding
- **Discord** — content moderation, AI features

### Salary Ranges 2025-2026 (Total Compensation)

| Level | YoE | Base Salary | Total Compensation |
|-------|-----|-------------|-------------------|
| Junior / AI Engineer I | 0-2 years | $130K-$170K | $150K-$220K |
| Mid / AI Engineer II | 2-5 years | $170K-$230K | $220K-$380K |
| Senior / AI Engineer III | 5+ years | $220K-$300K | $350K-$550K |
| Staff / AI Engineer IV | 8+ years | $280K-$380K | $500K-$800K+ |

> **Note:** OpenAI, Anthropic, and DeepMind typically pay at the top of these ranges. Equity at
> pre-IPO companies (Anthropic, OpenAI) can significantly increase TC but carries risk.
> San Francisco / NYC command the highest salaries. Remote roles may pay 10-20% less.

### Compensation Breakdown (Typical)
- **Base Salary:** 40-60% of TC
- **Equity (RSU/Options):** 30-50% of TC (higher at startups)
- **Annual Bonus:** 10-20% of base
- **Signing Bonus:** $20K-$100K (one-time)

---

## 3. Interview Structure

### Typical Process (4-5 Rounds)

#### Round 1: Phone Screen (45-60 min)
- **Coding:** Python algorithms, data manipulation
- **ML Basics:** "Explain overfitting", "What is cross-validation?"
- **Background:** "Walk me through your most impactful ML project"
- **Motivation:** "Why AI Engineering?", "Why this company?"

#### Round 2: Coding Round (60-90 min)
- **Python algorithms** — trees, graphs, dynamic programming
- **Data manipulation** — NumPy/Pandas problems
- **ML coding** — implement gradient descent, k-means, attention
- Focus on clean, efficient, Pythonic code

#### Round 3: ML System Design (60 min)
- Design an end-to-end ML system
- Common problems: recommendation system, search ranking, content moderation, RAG pipeline
- Evaluated on: requirements gathering, data design, model selection, serving, monitoring
- **This round heavily differentiates mid from senior candidates**

#### Round 4: ML Depth / Technical Deep Dive (60 min)
- Deep knowledge of transformers, training dynamics, optimization
- Loss functions, attention mechanisms, RLHF
- Paper discussion: "Explain a recent paper you read"
- Practical experience: "How did you handle data quality issues?"

#### Round 5: Behavioral (45-60 min)
- Collaboration on cross-functional ML projects
- Handling ambiguity ("requirements changed mid-project")
- Project leadership and technical decision-making
- Failure stories and what you learned
- Ethics and responsible AI considerations

### Company-Specific Variations
- **OpenAI/Anthropic:** Heavy focus on LLM internals, safety, alignment
- **Google DeepMind:** More research-oriented, paper discussions
- **Meta:** Strong focus on coding (LeetCode medium/hard) + system design
- **Startups (Tier 2):** More practical/applied focus, less algorithmic
- **Tier 3 companies:** More product-focused, less ML depth required

---

## 4. Topic Breakdown

---

### 4.1 Python & ML Fundamentals

#### NumPy Essentials
```python
import numpy as np

# --- Array Creation ---
arr = np.array([1, 2, 3, 4, 5])
zeros = np.zeros((3, 4))                 # 3x4 matrix of zeros
ones = np.ones((2, 3))                   # 2x3 matrix of ones
identity = np.eye(4)                     # 4x4 identity matrix
linspace = np.linspace(0, 1, 100)        # 100 evenly spaced values
random_arr = np.random.randn(3, 4)       # standard normal distribution

# --- Indexing & Slicing ---
matrix = np.arange(12).reshape(3, 4)
# array([[ 0,  1,  2,  3],
#        [ 4,  5,  6,  7],
#        [ 8,  9, 10, 11]])

row = matrix[1, :]          # [4, 5, 6, 7]
col = matrix[:, 2]          # [2, 6, 10]
submatrix = matrix[0:2, 1:3]  # [[1, 2], [5, 6]]
boolean_idx = matrix[matrix > 5]  # [6, 7, 8, 9, 10, 11]

# --- Broadcasting ---
# NumPy automatically expands dimensions for element-wise operations
a = np.array([[1], [2], [3]])    # shape (3, 1)
b = np.array([10, 20, 30])      # shape (3,)
result = a + b                   # shape (3, 3) — broadcasted
# array([[11, 21, 31],
#        [12, 22, 32],
#        [13, 23, 33]])

# --- Vectorization (avoid Python loops) ---
# Bad: Python loop
def slow_normalize(data):
    result = []
    for x in data:
        result.append((x - min(data)) / (max(data) - min(data)))
    return result

# Good: Vectorized NumPy
def fast_normalize(data):
    return (data - data.min()) / (data.max() - data.min())

# --- Common Interview Operations ---
# Matrix multiplication
A = np.random.randn(3, 4)
B = np.random.randn(4, 5)
C = A @ B                    # or np.dot(A, B), shape (3, 5)

# Softmax (frequently asked)
def softmax(x):
    exp_x = np.exp(x - np.max(x))  # subtract max for numerical stability
    return exp_x / exp_x.sum()

# Cosine similarity
def cosine_similarity(a, b):
    return np.dot(a, b) / (np.linalg.norm(a) * np.linalg.norm(b))
```

#### Pandas Essentials
```python
import pandas as pd

# --- Data Loading & Inspection ---
df = pd.read_csv("data.csv")
df.head()              # first 5 rows
df.info()              # column types, null counts
df.describe()          # summary statistics
df.isnull().sum()      # count nulls per column

# --- GroupBy & Aggregation ---
# Common interview pattern: compute statistics per group
sales = pd.DataFrame({
    "region": ["East", "West", "East", "West", "East"],
    "product": ["A", "B", "A", "A", "B"],
    "revenue": [100, 200, 150, 300, 250]
})

# Revenue by region
sales.groupby("region")["revenue"].agg(["mean", "sum", "count"])

# Pivot table
sales.pivot_table(values="revenue", index="region",
                  columns="product", aggfunc="sum", fill_value=0)

# --- Window Functions ---
df["rolling_avg"] = df["revenue"].rolling(window=7).mean()
df["cumulative_sum"] = df["revenue"].cumsum()
df["pct_change"] = df["revenue"].pct_change()

# --- Merging & Joining ---
users = pd.DataFrame({"user_id": [1, 2, 3], "name": ["Alice", "Bob", "Carol"]})
orders = pd.DataFrame({"user_id": [1, 1, 2], "amount": [50, 30, 100]})
merged = users.merge(orders, on="user_id", how="left")
```

#### Key Interview Patterns
- **Vectorization over loops** — always prefer NumPy/Pandas operations
- **Numerical stability** — subtract max before exp, use log-sum-exp
- **Memory efficiency** — use appropriate dtypes, chunked processing
- **Idiomatic code** — list comprehensions, generators, f-strings, type hints

#### Common Questions
1. "Implement softmax from scratch using NumPy"
2. "Given a DataFrame of user events, compute 7-day rolling active users"
3. "Implement cosine similarity between two vectors"
4. "Explain broadcasting in NumPy"
5. "How would you handle a dataset that doesn't fit in memory?"

---

### 4.2 Machine Learning Core

#### Supervised Learning

```python
# --- Linear Regression from Scratch ---
class LinearRegression:
    def __init__(self, lr=0.01, n_iters=1000):
        self.lr = lr
        self.n_iters = n_iters
        self.weights = None
        self.bias = None

    def fit(self, X, y):
        n_samples, n_features = X.shape
        self.weights = np.zeros(n_features)
        self.bias = 0

        for _ in range(self.n_iters):
            y_pred = X @ self.weights + self.bias
            dw = (1 / n_samples) * (X.T @ (y_pred - y))
            db = (1 / n_samples) * np.sum(y_pred - y)
            self.weights -= self.lr * dw
            self.bias -= self.lr * db

    def predict(self, X):
        return X @ self.weights + self.bias
```

#### Bias-Variance Tradeoff
- **Bias:** Error from overly simplistic model assumptions (underfitting)
- **Variance:** Error from sensitivity to training data fluctuations (overfitting)
- **Total Error = Bias^2 + Variance + Irreducible Noise**
- Simple models: high bias, low variance (linear regression on complex data)
- Complex models: low bias, high variance (deep neural net on small data)
- **Solution:** Regularization, cross-validation, ensemble methods

#### Regularization
- **L1 (Lasso):** Adds |w| penalty. Produces sparse weights (feature selection). Good when you expect few relevant features.
- **L2 (Ridge):** Adds w^2 penalty. Shrinks all weights toward zero. Better when all features contribute. More stable gradients.
- **Elastic Net:** Combines L1 + L2. Best of both worlds.
- **Dropout:** Neural network regularization, randomly zeros activations during training.

#### Ensemble Methods
- **Bagging (Random Forest):** Train multiple models on bootstrapped data, average predictions. Reduces variance.
- **Boosting (XGBoost, LightGBM):** Train models sequentially, each correcting the previous model's errors. Reduces bias.
- **Stacking:** Train a meta-model on predictions from multiple base models.

#### Evaluation Metrics
| Task | Metric | When to Use |
|------|--------|-------------|
| Classification | Accuracy | Balanced classes |
| Classification | Precision / Recall / F1 | Imbalanced classes |
| Classification | AUC-ROC | Ranking quality, threshold-independent |
| Classification | Log Loss | Probability calibration |
| Regression | MSE / RMSE | Penalize large errors more |
| Regression | MAE | Robust to outliers |
| Regression | R-squared | Explained variance |
| Ranking | NDCG, MAP | Search/recommendation |

#### Common Questions
1. "Explain the bias-variance tradeoff. How do you diagnose each?"
2. "When would you use L1 vs L2 regularization?"
3. "Explain gradient boosting step by step"
4. "Why does Random Forest reduce variance but not bias?"
5. "How do you handle class imbalance?" (oversampling, SMOTE, weighted loss, threshold tuning)
6. "What is cross-validation and why do we use it?"
7. "Explain precision vs recall. When would you optimize for each?"

---

### 4.3 Deep Learning

#### PyTorch Training Loop (Must Know)
```python
import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import DataLoader, Dataset

# --- Define Model ---
class SimpleNet(nn.Module):
    def __init__(self, input_dim, hidden_dim, output_dim):
        super().__init__()
        self.net = nn.Sequential(
            nn.Linear(input_dim, hidden_dim),
            nn.ReLU(),
            nn.BatchNorm1d(hidden_dim),
            nn.Dropout(0.3),
            nn.Linear(hidden_dim, hidden_dim),
            nn.ReLU(),
            nn.Dropout(0.3),
            nn.Linear(hidden_dim, output_dim),
        )

    def forward(self, x):
        return self.net(x)

# --- Training Loop ---
def train(model, train_loader, val_loader, epochs=10, lr=1e-3):
    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    model = model.to(device)
    optimizer = optim.AdamW(model.parameters(), lr=lr, weight_decay=1e-4)
    scheduler = optim.lr_scheduler.CosineAnnealingLR(optimizer, T_max=epochs)
    criterion = nn.CrossEntropyLoss()

    for epoch in range(epochs):
        # Training phase
        model.train()
        train_loss = 0
        for batch_x, batch_y in train_loader:
            batch_x, batch_y = batch_x.to(device), batch_y.to(device)

            optimizer.zero_grad()
            output = model(batch_x)
            loss = criterion(output, batch_y)
            loss.backward()
            torch.nn.utils.clip_grad_norm_(model.parameters(), max_norm=1.0)
            optimizer.step()

            train_loss += loss.item()

        # Validation phase
        model.eval()
        val_loss = 0
        correct = 0
        total = 0
        with torch.no_grad():
            for batch_x, batch_y in val_loader:
                batch_x, batch_y = batch_x.to(device), batch_y.to(device)
                output = model(batch_x)
                val_loss += criterion(output, batch_y).item()
                preds = output.argmax(dim=1)
                correct += (preds == batch_y).sum().item()
                total += batch_y.size(0)

        scheduler.step()
        print(f"Epoch {epoch+1}: train_loss={train_loss:.4f}, "
              f"val_loss={val_loss:.4f}, val_acc={correct/total:.4f}")
```

#### Backpropagation
- **Forward pass:** compute output layer by layer
- **Backward pass:** compute gradients via chain rule, starting from loss
- **Key insight:** each layer's gradient depends on the downstream gradient (chain rule)
- **Vanishing gradients:** gradients shrink through many layers (sigmoids). Solutions: ReLU, residual connections, proper initialization, batch norm.
- **Exploding gradients:** gradients grow uncontrollably. Solutions: gradient clipping, weight initialization, careful learning rate.

#### Key Concepts to Know Deeply

**Batch Normalization:**
- Normalizes layer inputs to zero mean, unit variance
- Reduces internal covariate shift
- During training: uses batch statistics
- During inference: uses running mean/variance (exponential moving average)
- Contains learnable scale (gamma) and shift (beta) parameters

**Dropout:**
- Randomly zeros activations with probability p during training
- At inference: multiply weights by (1-p) or use inverted dropout (scale during training)
- Acts as ensemble of sub-networks
- Common rates: 0.1-0.5

**Learning Rate Scheduling:**
- Warmup: start with small LR, linearly increase (critical for transformers)
- Cosine annealing: smoothly decay LR following cosine curve
- Step decay: reduce LR by factor every N epochs
- One-cycle: warmup then cosine decay (good default)

**Weight Initialization:**
- Xavier/Glorot: for sigmoid/tanh activations
- Kaiming/He: for ReLU activations
- Why it matters: bad init leads to vanishing/exploding gradients from the start

#### Common Questions
1. "Implement a training loop in PyTorch from scratch"
2. "Explain backpropagation step by step"
3. "What causes vanishing gradients and how do you fix it?"
4. "Explain batch normalization. What happens during training vs inference?"
5. "What is the difference between SGD, Adam, and AdamW?"
6. "Why do we use warmup for learning rate?"

---

### 4.4 NLP & Transformers

#### Attention Mechanism (Critical Knowledge)

```python
import torch
import torch.nn as nn
import torch.nn.functional as F
import math

class SelfAttention(nn.Module):
    """Scaled dot-product self-attention."""
    def __init__(self, embed_dim):
        super().__init__()
        self.embed_dim = embed_dim
        self.W_q = nn.Linear(embed_dim, embed_dim)
        self.W_k = nn.Linear(embed_dim, embed_dim)
        self.W_v = nn.Linear(embed_dim, embed_dim)

    def forward(self, x, mask=None):
        # x shape: (batch_size, seq_len, embed_dim)
        Q = self.W_q(x)  # Queries
        K = self.W_k(x)  # Keys
        V = self.W_v(x)  # Values

        # Scaled dot-product attention
        # scores shape: (batch_size, seq_len, seq_len)
        scores = torch.matmul(Q, K.transpose(-2, -1)) / math.sqrt(self.embed_dim)

        if mask is not None:
            scores = scores.masked_fill(mask == 0, float("-inf"))

        attention_weights = F.softmax(scores, dim=-1)

        # Weighted sum of values
        output = torch.matmul(attention_weights, V)
        return output, attention_weights


class MultiHeadAttention(nn.Module):
    """Multi-head attention as described in 'Attention Is All You Need'."""
    def __init__(self, embed_dim, num_heads):
        super().__init__()
        assert embed_dim % num_heads == 0, "embed_dim must be divisible by num_heads"

        self.embed_dim = embed_dim
        self.num_heads = num_heads
        self.head_dim = embed_dim // num_heads

        self.W_q = nn.Linear(embed_dim, embed_dim)
        self.W_k = nn.Linear(embed_dim, embed_dim)
        self.W_v = nn.Linear(embed_dim, embed_dim)
        self.W_o = nn.Linear(embed_dim, embed_dim)

    def forward(self, x, mask=None):
        batch_size, seq_len, _ = x.shape

        # Linear projections then split into heads
        Q = self.W_q(x).view(batch_size, seq_len, self.num_heads, self.head_dim)
        K = self.W_k(x).view(batch_size, seq_len, self.num_heads, self.head_dim)
        V = self.W_v(x).view(batch_size, seq_len, self.num_heads, self.head_dim)

        # Transpose to (batch, heads, seq_len, head_dim)
        Q = Q.transpose(1, 2)
        K = K.transpose(1, 2)
        V = V.transpose(1, 2)

        # Scaled dot-product attention per head
        scores = torch.matmul(Q, K.transpose(-2, -1)) / math.sqrt(self.head_dim)

        if mask is not None:
            scores = scores.masked_fill(mask == 0, float("-inf"))

        attn_weights = F.softmax(scores, dim=-1)
        context = torch.matmul(attn_weights, V)

        # Concatenate heads and final linear projection
        context = context.transpose(1, 2).contiguous().view(batch_size, seq_len, self.embed_dim)
        output = self.W_o(context)
        return output


class TransformerBlock(nn.Module):
    """Single transformer block with attention + feed-forward."""
    def __init__(self, embed_dim, num_heads, ff_dim, dropout=0.1):
        super().__init__()
        self.attention = MultiHeadAttention(embed_dim, num_heads)
        self.norm1 = nn.LayerNorm(embed_dim)
        self.norm2 = nn.LayerNorm(embed_dim)
        self.feed_forward = nn.Sequential(
            nn.Linear(embed_dim, ff_dim),
            nn.GELU(),
            nn.Dropout(dropout),
            nn.Linear(ff_dim, embed_dim),
            nn.Dropout(dropout),
        )

    def forward(self, x, mask=None):
        # Pre-norm architecture (used in modern transformers like GPT-2+)
        attn_out = self.attention(self.norm1(x), mask)
        x = x + attn_out  # residual connection
        ff_out = self.feed_forward(self.norm2(x))
        x = x + ff_out    # residual connection
        return x
```

#### BERT vs GPT (Key Comparison)

| Aspect | BERT | GPT |
|--------|------|-----|
| Architecture | Encoder-only | Decoder-only |
| Attention | Bidirectional (sees all tokens) | Causal (sees only past tokens) |
| Pre-training | Masked Language Model + Next Sentence Prediction | Next token prediction (autoregressive) |
| Best for | Classification, NER, extractive QA | Text generation, chat, reasoning |
| Masking | Randomly mask 15% of tokens | Causal mask (lower triangular) |
| Key models | BERT, RoBERTa, DeBERTa, ALBERT | GPT-2/3/4, LLaMA, Mistral, Claude |

#### Tokenization
- **BPE (Byte-Pair Encoding):** Used by GPT models. Iteratively merges most frequent character pairs. Handles unknown words via subword pieces.
- **WordPiece:** Used by BERT. Similar to BPE but uses likelihood-based merging.
- **SentencePiece:** Language-agnostic tokenizer (used by LLaMA, T5).
- **Why it matters:** Tokenization affects context window usage, multilingual performance, and cost.

#### Positional Encoding
```python
class PositionalEncoding(nn.Module):
    """Sinusoidal positional encoding from the original Transformer paper."""
    def __init__(self, embed_dim, max_len=5000):
        super().__init__()
        pe = torch.zeros(max_len, embed_dim)
        position = torch.arange(0, max_len).unsqueeze(1).float()
        div_term = torch.exp(
            torch.arange(0, embed_dim, 2).float() * (-math.log(10000.0) / embed_dim)
        )
        pe[:, 0::2] = torch.sin(position * div_term)
        pe[:, 1::2] = torch.cos(position * div_term)
        self.register_buffer("pe", pe.unsqueeze(0))

    def forward(self, x):
        return x + self.pe[:, :x.size(1)]
```

**Modern alternatives:**
- **RoPE (Rotary Position Embedding):** Used by LLaMA, Mistral. Encodes relative position via rotation matrices. Supports length extrapolation.
- **ALiBi (Attention with Linear Biases):** Adds linear bias to attention scores based on distance. No learned parameters.

#### Common Questions
1. "Implement self-attention from scratch" (see code above)
2. "Explain the difference between BERT and GPT architectures"
3. "Why do we scale dot products by sqrt(d_k) in attention?"
4. "What is the purpose of multi-head attention vs single-head?"
5. "Explain positional encoding. Why do transformers need it?"
6. "What is the computational complexity of self-attention? How can you reduce it?"
7. "Explain RoPE and why it is preferred over absolute positional encoding"

---

### 4.5 LLM Engineering (MOST IMPORTANT FOR 2025-2026)

This is the **highest-signal topic** for AI Engineer interviews in 2025-2026. Companies expect hands-on experience building LLM-powered systems.

#### Prompt Engineering

```python
from openai import OpenAI

client = OpenAI()

# --- Basic Prompt Patterns ---

# 1. System prompt for role and constraints
def classify_sentiment(text: str) -> str:
    response = client.chat.completions.create(
        model="gpt-4o",
        messages=[
            {
                "role": "system",
                "content": (
                    "You are a sentiment classifier. Respond with exactly one word: "
                    "'positive', 'negative', or 'neutral'. No explanation."
                ),
            },
            {"role": "user", "content": text},
        ],
        temperature=0,  # deterministic output for classification
    )
    return response.choices[0].message.content.strip().lower()


# 2. Few-shot prompting
def extract_entities(text: str) -> str:
    response = client.chat.completions.create(
        model="gpt-4o",
        messages=[
            {
                "role": "system",
                "content": "Extract named entities from text. Return JSON.",
            },
            {
                "role": "user",
                "content": "Apple announced a new iPhone at their Cupertino headquarters.",
            },
            {
                "role": "assistant",
                "content": '{"organizations": ["Apple"], "products": ["iPhone"], "locations": ["Cupertino"]}',
            },
            {
                "role": "user",
                "content": "Elon Musk visited the Tesla factory in Austin, Texas.",
            },
            {
                "role": "assistant",
                "content": '{"people": ["Elon Musk"], "organizations": ["Tesla"], "locations": ["Austin", "Texas"]}',
            },
            {"role": "user", "content": text},
        ],
        temperature=0,
    )
    return response.choices[0].message.content


# 3. Chain-of-thought prompting
def solve_problem(problem: str) -> str:
    response = client.chat.completions.create(
        model="gpt-4o",
        messages=[
            {
                "role": "system",
                "content": (
                    "You are a problem-solving assistant. Think step by step. "
                    "First analyze the problem, then show your reasoning, "
                    "then give the final answer."
                ),
            },
            {"role": "user", "content": problem},
        ],
        temperature=0.2,
    )
    return response.choices[0].message.content
```

#### RAG (Retrieval-Augmented Generation)

```python
# --- Complete RAG Pipeline ---
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_openai import OpenAIEmbeddings, ChatOpenAI
from langchain_community.vectorstores import FAISS
from langchain.prompts import ChatPromptTemplate
from langchain.schema.runnable import RunnablePassthrough

# Step 1: Document chunking
def chunk_documents(documents: list[str], chunk_size=500, overlap=50):
    """Split documents into overlapping chunks for embedding."""
    splitter = RecursiveCharacterTextSplitter(
        chunk_size=chunk_size,
        chunk_overlap=overlap,
        separators=["\n\n", "\n", ". ", " ", ""],
    )
    chunks = []
    for doc in documents:
        chunks.extend(splitter.split_text(doc))
    return chunks

# Step 2: Create vector store
def build_index(chunks: list[str]):
    """Embed chunks and build FAISS index."""
    embeddings = OpenAIEmbeddings(model="text-embedding-3-small")
    vectorstore = FAISS.from_texts(chunks, embeddings)
    return vectorstore

# Step 3: Retrieval + Generation
def create_rag_chain(vectorstore):
    """Build a RAG chain: retrieve context then generate answer."""
    retriever = vectorstore.as_retriever(
        search_type="similarity",
        search_kwargs={"k": 5},
    )

    prompt = ChatPromptTemplate.from_template("""
    Answer the question based on the following context. If the context
    doesn't contain enough information, say "I don't have enough
    information to answer this."

    Context:
    {context}

    Question: {question}

    Answer:""")

    llm = ChatOpenAI(model="gpt-4o", temperature=0)

    chain = (
        {"context": retriever, "question": RunnablePassthrough()}
        | prompt
        | llm
    )
    return chain

# Step 4: Query
# chain = create_rag_chain(vectorstore)
# answer = chain.invoke("What is the refund policy?")
```

**RAG Design Decisions (Common Interview Discussion):**

| Decision | Options | Tradeoffs |
|----------|---------|-----------|
| Chunk size | 256-2048 tokens | Smaller = more precise retrieval, larger = more context |
| Chunk overlap | 10-20% of chunk size | More overlap = better continuity, higher storage |
| Embedding model | OpenAI, Cohere, open-source | Cost vs quality vs latency vs privacy |
| Retrieval | Dense, sparse (BM25), hybrid | Dense = semantic, sparse = keyword, hybrid = best of both |
| Top-k | 3-10 chunks | More = better recall, worse precision, higher cost |
| Reranking | Cohere Rerank, cross-encoder | Improves precision, adds latency |

#### Agents and Tool Use

```python
# --- Simple Agent with Tool Use ---
import json

TOOLS = {
    "search": {
        "description": "Search the web for current information",
        "parameters": {"query": "string"},
    },
    "calculator": {
        "description": "Perform mathematical calculations",
        "parameters": {"expression": "string"},
    },
    "database_query": {
        "description": "Query the product database",
        "parameters": {"sql": "string"},
    },
}

def run_agent(user_query: str, max_steps: int = 5):
    """Simple ReAct-style agent loop."""
    messages = [
        {
            "role": "system",
            "content": f"""You are a helpful assistant with access to tools.
Available tools: {json.dumps(TOOLS)}

To use a tool, respond with:
TOOL: <tool_name>
INPUT: <json_input>

When you have the final answer, respond with:
ANSWER: <your_answer>""",
        },
        {"role": "user", "content": user_query},
    ]

    for step in range(max_steps):
        response = client.chat.completions.create(
            model="gpt-4o",
            messages=messages,
        )
        reply = response.choices[0].message.content

        if reply.startswith("ANSWER:"):
            return reply[7:].strip()

        if reply.startswith("TOOL:"):
            tool_name, tool_input = parse_tool_call(reply)
            tool_result = execute_tool(tool_name, tool_input)
            messages.append({"role": "assistant", "content": reply})
            messages.append({
                "role": "user",
                "content": f"Tool result: {tool_result}",
            })
        else:
            messages.append({"role": "assistant", "content": reply})

    return "Agent reached max steps without a final answer."
```

#### Fine-Tuning: LoRA and QLoRA

```python
# --- LoRA Fine-Tuning with PEFT ---
from transformers import AutoModelForCausalLM, AutoTokenizer, TrainingArguments
from peft import LoraConfig, get_peft_model, TaskType
from trl import SFTTrainer

# Load base model
model_name = "meta-llama/Llama-3.1-8B"
model = AutoModelForCausalLM.from_pretrained(
    model_name,
    torch_dtype=torch.bfloat16,
    device_map="auto",
)
tokenizer = AutoTokenizer.from_pretrained(model_name)

# Configure LoRA
# LoRA: Low-Rank Adaptation — adds small trainable matrices to frozen weights
# Instead of updating W (d x d), we learn A (d x r) and B (r x d) where r << d
# Effective update: W' = W + A @ B
lora_config = LoraConfig(
    task_type=TaskType.CAUSAL_LM,
    r=16,                      # rank — lower = fewer parameters, higher = more expressive
    lora_alpha=32,             # scaling factor (effective lr multiplier = alpha/r)
    lora_dropout=0.05,
    target_modules=["q_proj", "k_proj", "v_proj", "o_proj"],  # which layers to adapt
)

model = get_peft_model(model, lora_config)
model.print_trainable_parameters()
# Example output: "trainable params: 6M || all params: 8B || trainable%: 0.075%"

# Training
training_args = TrainingArguments(
    output_dir="./lora-output",
    num_train_epochs=3,
    per_device_train_batch_size=4,
    gradient_accumulation_steps=4,
    learning_rate=2e-4,
    bf16=True,
    warmup_ratio=0.1,
    logging_steps=10,
    save_strategy="epoch",
)

trainer = SFTTrainer(
    model=model,
    args=training_args,
    train_dataset=dataset,
    tokenizer=tokenizer,
    max_seq_length=2048,
)

trainer.train()
```

**LoRA vs QLoRA vs Full Fine-Tuning:**

| Method | Trainable Params | Memory (8B model) | Quality | When to Use |
|--------|-----------------|-------------------|---------|-------------|
| Full fine-tune | 100% | ~60GB+ | Best | Unlimited compute, large dataset |
| LoRA | 0.05-0.1% | ~16-20GB | Very good | Production fine-tuning |
| QLoRA | 0.05-0.1% | ~6-10GB | Good | Limited GPU memory |

#### RLHF and DPO

**RLHF (Reinforcement Learning from Human Feedback):**
1. Supervised fine-tune on demonstrations
2. Train a reward model on human preference pairs
3. Optimize the policy (LLM) with PPO against the reward model + KL penalty

**DPO (Direct Preference Optimization):**
- Eliminates the reward model step entirely
- Directly optimizes the policy using preference pairs
- Simpler, more stable, fewer hyperparameters
- Loss: `L = -log(sigma(beta * (log(pi(y_w|x)/pi_ref(y_w|x)) - log(pi(y_l|x)/pi_ref(y_l|x)))))`
- Where y_w = preferred response, y_l = rejected response

#### LLM Evaluation

```python
# --- Common Evaluation Approaches ---

# 1. Automated metrics
from rouge_score import rouge_scorer

def evaluate_summary(generated: str, reference: str) -> dict:
    scorer = rouge_scorer.RougeScorer(["rouge1", "rouge2", "rougeL"])
    scores = scorer.score(reference, generated)
    return {k: v.fmeasure for k, v in scores.items()}

# 2. LLM-as-Judge (increasingly common in 2025)
def llm_judge(question: str, answer: str, reference: str) -> dict:
    response = client.chat.completions.create(
        model="gpt-4o",
        messages=[
            {
                "role": "system",
                "content": """Rate the answer on a scale of 1-5 for:
- Correctness: Is the answer factually correct?
- Completeness: Does it fully address the question?
- Relevance: Is the answer focused on the question?

Return JSON: {"correctness": N, "completeness": N, "relevance": N, "explanation": "..."}""",
            },
            {
                "role": "user",
                "content": f"Question: {question}\nReference: {reference}\nAnswer: {answer}",
            },
        ],
        temperature=0,
    )
    return json.loads(response.choices[0].message.content)

# 3. Human evaluation (gold standard)
# - Blind A/B testing
# - Elo rating across models
# - Task-specific rubrics
```

#### Key Frameworks for 2025-2026
- **LangChain / LangGraph** — chains, agents, tool use, graph-based workflows
- **LlamaIndex** — data ingestion, indexing, RAG pipelines
- **DSPy** — programmatic prompt optimization
- **Instructor** — structured output extraction from LLMs
- **vLLM** — high-throughput LLM serving
- **Ollama / llama.cpp** — local model inference

#### Common Questions
1. "Design a RAG system for a customer support chatbot"
2. "How would you evaluate the quality of an LLM's output?"
3. "When would you fine-tune vs use RAG vs prompt engineering?"
4. "Explain LoRA. Why does low-rank adaptation work?"
5. "How would you reduce hallucination in an LLM application?"
6. "Design an agent system for automating data analysis"
7. "What is DPO and how does it compare to RLHF?"
8. "How do you handle context window limitations?"

---

### 4.6 Computer Vision

#### CNNs (Convolutional Neural Networks)

```python
class SimpleCNN(nn.Module):
    """Basic CNN for image classification."""
    def __init__(self, num_classes=10):
        super().__init__()
        self.features = nn.Sequential(
            nn.Conv2d(3, 32, kernel_size=3, padding=1),   # (B, 32, H, W)
            nn.BatchNorm2d(32),
            nn.ReLU(),
            nn.MaxPool2d(2),                               # (B, 32, H/2, W/2)
            nn.Conv2d(32, 64, kernel_size=3, padding=1),   # (B, 64, H/2, W/2)
            nn.BatchNorm2d(64),
            nn.ReLU(),
            nn.MaxPool2d(2),                               # (B, 64, H/4, W/4)
            nn.Conv2d(64, 128, kernel_size=3, padding=1),  # (B, 128, H/4, W/4)
            nn.BatchNorm2d(128),
            nn.ReLU(),
            nn.AdaptiveAvgPool2d(1),                       # (B, 128, 1, 1)
        )
        self.classifier = nn.Linear(128, num_classes)

    def forward(self, x):
        x = self.features(x)
        x = x.view(x.size(0), -1)
        return self.classifier(x)
```

#### Key Architectures
- **ResNet:** Residual connections (skip connections), enables very deep networks (50-152 layers). Solves vanishing gradients in deep CNNs.
- **EfficientNet:** Compound scaling (depth, width, resolution). Best accuracy/compute tradeoff for CNNs.
- **ViT (Vision Transformer):** Splits image into patches, treats patches as tokens, applies transformer. Dominant for large-scale vision. Needs more data than CNNs.
- **CLIP:** Contrastive learning between images and text. Enables zero-shot classification. Used for image search, multimodal systems.

#### Detection and Segmentation
- **Object Detection:** YOLO (real-time), DETR (transformer-based), Faster R-CNN (two-stage)
- **Semantic Segmentation:** U-Net, DeepLab, SegFormer
- **Instance Segmentation:** Mask R-CNN, SAM (Segment Anything)

#### Common Questions
1. "Explain how convolution works. What do filters learn?"
2. "Why do ResNets work better than plain deep networks?"
3. "Compare CNN vs ViT. When would you use each?"
4. "What is transfer learning and why is it effective?"
5. "Explain CLIP and how it enables zero-shot classification"

---

### 4.7 MLOps

#### Model Serving Architecture

```
Request → Load Balancer → Model Server → Model → Response
                ↓
         Feature Store → Pre-processing
                ↓
         Model Registry → Model Versioning
                ↓
         Monitoring → Alerts / Retraining Triggers
```

#### Key MLOps Concepts

**Model Deployment Patterns:**
- **Online serving:** Low-latency predictions via REST/gRPC API
- **Batch inference:** Process large datasets offline (e.g., nightly recommendations)
- **Streaming:** Real-time predictions on event streams (Kafka + model)
- **Edge deployment:** On-device inference (mobile, IoT)

**Model Monitoring:**
- **Data drift:** Input distribution shifts from training data (PSI, KS test)
- **Concept drift:** Relationship between inputs and outputs changes
- **Performance degradation:** Model accuracy drops over time
- **Latency monitoring:** P50, P95, P99 inference times

**CI/CD for ML:**
- Version control: code, data, model, config (DVC, MLflow)
- Automated testing: unit tests, integration tests, model quality tests
- Canary deployments: route small % of traffic to new model
- A/B testing: compare models on live traffic with statistical significance
- Shadow mode: run new model alongside old, compare outputs without serving

**Feature Stores:**
- Centralized repository for feature computation and serving
- Ensures consistency between training and serving (training-serving skew)
- Tools: Feast, Tecton, Databricks Feature Store

#### Common Questions
1. "How do you detect model drift in production?"
2. "Design a model serving system that handles 10K QPS"
3. "How do you ensure consistency between training and serving features?"
4. "Explain canary deployment vs A/B testing for ML models"
5. "How would you set up monitoring for an LLM-powered application?"
6. "What is training-serving skew and how do you prevent it?"

---

### 4.8 Vector Databases & Embeddings

#### How Vector Search Works

```python
import numpy as np
from typing import List, Tuple

# --- Similarity Metrics ---
def cosine_similarity(a: np.ndarray, b: np.ndarray) -> float:
    return np.dot(a, b) / (np.linalg.norm(a) * np.linalg.norm(b))

def euclidean_distance(a: np.ndarray, b: np.ndarray) -> float:
    return np.linalg.norm(a - b)

def dot_product_similarity(a: np.ndarray, b: np.ndarray) -> float:
    return np.dot(a, b)

# --- Brute Force Search (baseline, O(n*d)) ---
def brute_force_search(
    query: np.ndarray, vectors: np.ndarray, k: int
) -> List[Tuple[int, float]]:
    scores = vectors @ query / (
        np.linalg.norm(vectors, axis=1) * np.linalg.norm(query)
    )
    top_k = np.argsort(scores)[-k:][::-1]
    return [(idx, scores[idx]) for idx in top_k]
```

#### HNSW (Hierarchical Navigable Small World)
- Most popular ANN algorithm (used by Pinecone, Weaviate, Qdrant, pgvector)
- Builds a multi-layer graph where each layer is a navigable small world graph
- Search: start from top layer (sparse), greedy traverse to nearest neighbor, descend to next layer (denser), repeat
- **Time complexity:** O(log n) search, O(n log n) build
- **Tradeoff parameter (ef):** higher ef = better recall, slower search

#### Product Quantization (PQ)
- Compresses vectors to reduce memory usage
- Splits d-dimensional vector into m sub-vectors
- Each sub-vector quantized to nearest centroid from a learned codebook
- Reduces memory by 4-32x with moderate accuracy loss
- Used by FAISS for billion-scale search

#### Vector Database Landscape (2025)

| Database | Type | Key Features |
|----------|------|-------------|
| Pinecone | Managed | Serverless, easy scaling, metadata filtering |
| Weaviate | Open-source | Hybrid search, multi-modal, generative search |
| Qdrant | Open-source | Rust-based, fast, rich filtering |
| ChromaDB | Open-source | Simple, embedded, good for prototyping |
| pgvector | Extension | PostgreSQL extension, familiar SQL interface |
| FAISS | Library | Meta's library, highly optimized, not a database |
| Milvus | Open-source | Distributed, GPU-accelerated |

#### Embedding Models
- **OpenAI text-embedding-3-small/large:** Strong general-purpose, API-based
- **Cohere embed-v3:** Strong multilingual support, input types
- **BGE / E5:** Open-source, competitive with proprietary models
- **Sentence-BERT:** Classic, good baseline
- **CLIP embeddings:** Multimodal (text + image in same space)

#### Common Questions
1. "How does HNSW work? What are the tradeoffs?"
2. "Explain product quantization and when to use it"
3. "How would you build a semantic search system for 100M documents?"
4. "Compare dense vs sparse retrieval. When to use hybrid?"
5. "How do you evaluate retrieval quality?" (Recall@k, MRR, NDCG)
6. "What happens when you need to update embeddings when the model changes?"

---

### 4.9 AI System Design

This is the most critical round for senior candidates. Use a structured framework.

#### System Design Framework

```
1. REQUIREMENTS (5 min)
   - What exactly are we building?
   - Scale: users, QPS, data volume
   - Latency requirements
   - Quality requirements (accuracy, fairness)
   - Constraints: cost, privacy, real-time vs batch

2. DATA (10 min)
   - What data is available?
   - Labels: how to get them? (explicit, implicit, heuristic)
   - Data pipeline: collection → cleaning → feature engineering
   - Training/validation/test split strategy

3. FEATURES (5 min)
   - Raw features vs engineered features
   - Feature store for online/offline consistency
   - Real-time vs batch features

4. MODEL (10 min)
   - Model architecture selection and justification
   - Training strategy: loss function, optimizer, hyperparameters
   - Offline evaluation: metrics, baseline comparisons
   - Iteration strategy: start simple, add complexity

5. SERVING (10 min)
   - Online vs batch inference
   - Latency optimization: caching, quantization, distillation
   - Scaling: horizontal scaling, load balancing
   - Fallback strategy: what if model fails?

6. MONITORING & ITERATION (5 min)
   - Metrics to track: model performance, business metrics, latency
   - Data drift detection
   - A/B testing framework
   - Feedback loop for continuous improvement
```

#### Common Design Problems

**1. Recommendation System (e.g., Netflix, Spotify)**
- Two-stage: candidate generation (approximate, fast) + ranking (precise, slow)
- Candidate generation: collaborative filtering, content-based, ANN search
- Ranking: learning-to-rank model (features: user, item, context, interaction)
- Cold start: content-based features, popularity, exploration

**2. Search Ranking (e.g., Google, Airbnb)**
- Query understanding → retrieval → ranking → re-ranking
- Retrieval: inverted index (BM25) + embedding-based (ANN)
- Ranking: gradient boosted trees or transformer model
- Features: query-document relevance, freshness, quality, user personalization

**3. Content Moderation (e.g., social media)**
- Multi-stage: fast classifier → detailed model → human review
- Multi-modal: text + image + video + audio
- Handle: hate speech, NSFW, misinformation, spam
- Key challenges: adversarial attacks, context-dependence, multilingual

**4. RAG-Based Q&A System**
- Document ingestion → chunking → embedding → vector store
- Query → embedding → retrieval → reranking → LLM generation
- Key decisions: chunk size, embedding model, retrieval strategy, prompt design
- Evaluation: retrieval accuracy, answer accuracy, hallucination rate

**5. Fraud Detection**
- Real-time scoring: features computed from event stream
- Model: gradient boosted trees (interpretable) or deep learning (accuracy)
- Features: transaction patterns, device fingerprinting, graph features
- Key challenges: extreme class imbalance (0.1% fraud), evolving patterns, latency

#### Common Questions
1. "Design a recommendation system for a music streaming service"
2. "Design a search ranking system for an e-commerce platform"
3. "Design a content moderation system for a social media platform"
4. "Design a RAG-based customer support chatbot"
5. "Design a fraud detection system for a payment company"
6. "Design an LLM-powered code review system"

---

### 4.10 Math & Statistics

#### Linear Algebra (Essential)

**Vectors and Matrices:**
- Dot product: `a . b = sum(a_i * b_i) = |a| |b| cos(theta)`
- Matrix multiplication: (m x n) @ (n x p) = (m x p)
- Transpose, inverse, determinant
- Eigenvalues/eigenvectors: `Av = lambda * v`

**Key for ML:**
- SVD (Singular Value Decomposition): `A = U * S * V^T` — used in PCA, recommendation, LoRA
- PCA: project data onto directions of maximum variance (eigenvectors of covariance matrix)
- Matrix rank: relates to dimensionality, LoRA exploits low-rank structure

#### Probability & Statistics

**Distributions:**
- Bernoulli: binary outcomes (coin flip)
- Binomial: number of successes in n trials
- Gaussian/Normal: continuous, bell curve, central limit theorem
- Poisson: count of events in fixed interval

**Key Concepts:**
- Bayes' theorem: `P(A|B) = P(B|A) * P(A) / P(B)`
- Maximum Likelihood Estimation (MLE): find parameters that maximize `P(data | params)`
- MAP (Maximum A Posteriori): MLE + prior = regularization
- Confidence intervals: range where true parameter lies with specified probability
- Hypothesis testing: A/B test analysis, p-values, statistical significance

#### Optimization

**Gradient Descent Variants:**
- SGD: update per mini-batch, noisy but fast
- Momentum: exponential moving average of gradients, smooths updates
- Adam: adaptive learning rates per parameter + momentum. Default choice.
- AdamW: Adam with decoupled weight decay. Preferred for transformers.

**Key Concepts:**
- Convexity: global minimum exists, no local minima
- Learning rate: too high = diverge, too low = slow convergence
- Loss landscape: neural networks are highly non-convex but SGD finds good minima

#### Information Theory

- **Entropy:** `H(X) = -sum(p(x) * log(p(x)))` — measures uncertainty
- **Cross-entropy:** `H(p,q) = -sum(p(x) * log(q(x)))` — loss function for classification
- **KL Divergence:** `D_KL(p||q) = sum(p(x) * log(p(x)/q(x)))` — measures how different two distributions are. Not symmetric. Used in VAEs, DPO, RLHF.
- **Mutual Information:** `I(X;Y) = H(X) - H(X|Y)` — shared information between variables

#### Common Questions
1. "Derive the gradient of cross-entropy loss for softmax output"
2. "Explain KL divergence. Why is it used in VAEs?"
3. "What is the relationship between MLE and cross-entropy loss?"
4. "Explain PCA mathematically. How does SVD relate?"
5. "Why does Adam work better than SGD for transformers?"
6. "Derive the backpropagation update for a single linear layer"

---

### 4.11 Responsible AI

#### Bias and Fairness

**Types of Bias:**
- **Data bias:** Training data doesn't represent the target population
- **Selection bias:** Non-random sampling of training data
- **Measurement bias:** Labels are systematically wrong for some groups
- **Aggregation bias:** Model works well on average but fails for subgroups
- **Historical bias:** Data reflects existing societal inequities

**Fairness Metrics:**
- **Demographic parity:** P(positive | group A) = P(positive | group B)
- **Equalized odds:** Equal TPR and FPR across groups
- **Individual fairness:** Similar individuals get similar predictions
- **Calibration:** Predicted probabilities match actual outcomes per group
- Note: it is mathematically impossible to satisfy all fairness criteria simultaneously

**Bias Mitigation:**
- Pre-processing: resampling, reweighting, data augmentation
- In-processing: adversarial debiasing, fairness constraints in loss
- Post-processing: threshold adjustment per group

#### AI Safety & Alignment

**Key Concepts:**
- **RLHF:** Train reward model on human preferences, optimize with RL
- **Constitutional AI (Anthropic):** Self-critique using a set of principles
- **Red teaming:** Adversarial testing to find failure modes
- **Guardrails:** Input/output filters, content policies, safety classifiers

**LLM-Specific Safety:**
- Prompt injection: adversarial inputs that override system instructions
- Jailbreaking: techniques to bypass safety training
- Hallucination: confident generation of false information
- Data poisoning: adversarial training data
- Privacy: model memorization of training data

#### Regulations (2025-2026)
- **EU AI Act:** Risk-based regulation, effective 2025-2026
- **US Executive Order on AI:** Reporting requirements for large models
- **State laws:** California, Colorado, New York AI regulations
- **Industry standards:** NIST AI Risk Management Framework

#### Common Questions
1. "How would you detect bias in a hiring model?"
2. "Explain RLHF and its limitations"
3. "How do you prevent prompt injection in an LLM application?"
4. "What are the tradeoffs between different fairness metrics?"
5. "How would you handle a model that performs well overall but poorly for a minority group?"
6. "What is your approach to reducing hallucination in production LLM systems?"

---

## 5. Study Plans

### 4-Week Intensive Plan

For experienced ML practitioners switching to AI Engineering roles.

**Week 1: Foundations**
| Day | Topic | Focus |
|-----|-------|-------|
| Mon | Python & NumPy | Vectorization, broadcasting, common patterns |
| Tue | Pandas & Data Manipulation | GroupBy, merges, window functions |
| Wed | ML Core | Supervised learning, bias-variance, regularization |
| Thu | ML Core | Ensemble methods, evaluation metrics, cross-validation |
| Fri | Math Refresher | Linear algebra, probability, optimization basics |
| Sat | Practice | Coding exercises from sections 4.1 and 4.2 |
| Sun | Review | Weak areas, flashcards for key formulas |

**Week 2: Deep Learning & NLP**
| Day | Topic | Focus |
|-----|-------|-------|
| Mon | Deep Learning | PyTorch training loop, backpropagation |
| Tue | Deep Learning | BatchNorm, dropout, learning rate scheduling |
| Wed | NLP & Transformers | Attention mechanism, implement self-attention |
| Thu | NLP & Transformers | BERT vs GPT, tokenization, positional encoding |
| Fri | Computer Vision | CNNs, ResNet, ViT, CLIP |
| Sat | Practice | Implement transformer block from scratch |
| Sun | Review | Paper reading: "Attention Is All You Need" |

**Week 3: LLM Engineering & Vector DBs**
| Day | Topic | Focus |
|-----|-------|-------|
| Mon | LLM Engineering | Prompt engineering patterns, API usage |
| Tue | LLM Engineering | RAG pipeline: chunking, embedding, retrieval |
| Wed | LLM Engineering | Agents, tool use, evaluation |
| Thu | LLM Engineering | Fine-tuning: LoRA, QLoRA, DPO |
| Fri | Vector Databases | FAISS, HNSW, embedding models |
| Sat | Practice | Build a complete RAG system end-to-end |
| Sun | Review | LLM evaluation, hallucination mitigation |

**Week 4: System Design & Polish**
| Day | Topic | Focus |
|-----|-------|-------|
| Mon | ML System Design | Framework, recommendation system design |
| Tue | ML System Design | Search ranking, content moderation design |
| Wed | MLOps | Deployment, monitoring, CI/CD for ML |
| Thu | Responsible AI | Bias, fairness, safety, alignment |
| Fri | Mock Interview 1 | Coding + ML depth |
| Sat | Mock Interview 2 | System design + behavioral |
| Sun | Final Review | Weak areas, top 50 questions review |

---

### 8-Week Standard Plan

For engineers with some ML experience who need thorough preparation.

**Weeks 1-2: Foundations**
- Week 1: Python fundamentals, NumPy, Pandas, data manipulation
- Week 2: ML core (supervised, unsupervised, evaluation, regularization)
- Daily: 2 hours study + 1 hour practice problems
- Goal: comfortable with all ML basics and Python coding

**Weeks 3-4: Deep Learning & NLP**
- Week 3: Deep learning fundamentals, PyTorch, training loops, backpropagation
- Week 4: NLP, transformers, attention mechanism, BERT vs GPT
- Project: implement a transformer from scratch
- Paper: "Attention Is All You Need"

**Weeks 5-6: LLM Engineering & RAG**
- Week 5: Prompt engineering, RAG, chunking strategies, evaluation
- Week 6: Agents, tool use, fine-tuning (LoRA/QLoRA), DPO
- Project: build a RAG chatbot with evaluation pipeline
- Explore: LangChain, LlamaIndex, DSPy

**Week 7: System Design & Specialization**
- ML system design framework and practice problems
- MLOps: deployment, monitoring, feature stores
- Computer Vision basics (CNNs, ViT, CLIP)
- Responsible AI: bias, fairness, safety

**Week 8: Mock Interviews & Polish**
- 3-4 mock interviews (coding, system design, ML depth, behavioral)
- Review weak areas identified in mocks
- Practice top 50 questions across all topics
- Prepare your "story" (project walkthroughs, failure stories, leadership examples)

---

### 12-Week Comprehensive Plan

For career changers or those building ML knowledge from scratch.

**Weeks 1-3: Foundations**
- Week 1: Python proficiency, data structures, algorithms
- Week 2: NumPy, Pandas, data manipulation, visualization
- Week 3: Math refresher (linear algebra, probability, calculus, optimization)
- Daily: 3 hours study + 1 hour practice
- Assessment: can you solve medium LeetCode in Python? Can you explain gradient descent mathematically?

**Weeks 4-6: Machine Learning & Deep Learning**
- Week 4: Supervised learning (linear models, trees, SVMs)
- Week 5: Unsupervised learning, ensemble methods, evaluation
- Week 6: Deep learning fundamentals, PyTorch, CNNs
- Project: train a model end-to-end on a real dataset
- Course: Stanford CS229 lectures (ML fundamentals)

**Weeks 7-9: NLP, Transformers & LLM Engineering**
- Week 7: NLP basics, transformers, attention mechanism
- Week 8: LLM engineering: prompt engineering, RAG, evaluation
- Week 9: Advanced LLM: agents, fine-tuning, RLHF/DPO
- Project: build a full RAG application with evaluation
- Paper reading: 2-3 key papers per week

**Weeks 10-11: System Design & Production ML**
- Week 10: ML system design (5 practice problems with full writeups)
- Week 11: MLOps, vector databases, responsible AI
- Project: deploy a model with monitoring
- Practice: explain designs out loud (record yourself)

**Week 12: Interview Simulation**
- 4-5 full mock interviews (with feedback)
- Review all weak areas
- Prepare behavioral stories (STAR format)
- Final review of top 100 questions
- Rest the day before interviews

---

## 6. Resources

### Must-Read Papers
1. **"Attention Is All You Need"** (Vaswani et al., 2017) — the Transformer architecture
2. **"BERT: Pre-training of Deep Bidirectional Transformers"** (Devlin et al., 2019)
3. **"Language Models are Few-Shot Learners"** (Brown et al., 2020) — GPT-3
4. **"LoRA: Low-Rank Adaptation of Large Language Models"** (Hu et al., 2021)
5. **"Retrieval-Augmented Generation for Knowledge-Intensive NLP Tasks"** (Lewis et al., 2020)
6. **"Training language models to follow instructions with human feedback"** (Ouyang et al., 2022) — InstructGPT/RLHF
7. **"Direct Preference Optimization"** (Rafailov et al., 2023) — DPO
8. **"LLaMA: Open and Efficient Foundation Language Models"** (Touvron et al., 2023)
9. **"An Image is Worth 16x16 Words"** (Dosovitskiy et al., 2020) — ViT
10. **"Learning Transferable Visual Models From Natural Language Supervision"** (Radford et al., 2021) — CLIP

### Books
- **"Deep Learning"** by Goodfellow, Bengio, Courville — comprehensive DL reference
- **"Designing Machine Learning Systems"** by Chip Huyen — production ML systems (essential)
- **"Hands-On Large Language Models"** by Jay Alammar, Maarten Grootendorst — practical LLM guide
- **"Speech and Language Processing"** by Jurafsky & Martin — NLP fundamentals
- **"Pattern Recognition and Machine Learning"** by Bishop — mathematical ML
- **"AI Engineering"** by Chip Huyen (2025) — building LLM applications

### Courses
- **Stanford CS229** — Machine Learning (Andrew Ng)
- **Stanford CS231n** — Convolutional Neural Networks for Visual Recognition
- **Stanford CS224n** — Natural Language Processing with Deep Learning
- **Stanford CS25** — Transformers United
- **fast.ai** — Practical Deep Learning for Coders
- **DeepLearning.AI** — LLM specialization courses
- **Andrej Karpathy's YouTube** — "Let's build GPT", neural networks from scratch

### Practice
- **This repo's exercises** — structured progression through all topics
- **LeetCode** — Python algorithms (focus on medium difficulty)
- **ML system design practice** — design a new system weekly
- **Kaggle competitions** — hands-on ML practice
- **Papers with Code** — implement papers from scratch
- **Hugging Face tutorials** — transformer model usage and fine-tuning
- **LangChain/LlamaIndex docs** — build RAG and agent systems

### Communities & Staying Current
- **arXiv** — daily ML paper releases
- **Hacker News** — AI/ML discussions
- **Twitter/X** — follow AI researchers and engineers
- **Discord** — Hugging Face, LangChain, LAION communities
- **Reddit** — r/MachineLearning, r/LocalLLaMA

---

## 7. Interview Tips

### General
- **Always clarify requirements** before solving. Ask: "What scale?", "What latency?", "What metrics matter?"
- **Think out loud** — interviewers evaluate your thought process, not just the final answer
- **Start simple, then iterate** — propose a baseline, then improve it
- **Know tradeoffs** — accuracy vs latency, cost vs quality, complexity vs maintainability
- **Be honest** about what you don't know. "I haven't worked with that directly, but here's how I'd approach it..."

### Coding Round
- Write clean, readable Python with type hints
- Use NumPy/Pandas idiomatically (vectorized over loops)
- Test your solution with edge cases
- Discuss time/space complexity
- For ML coding: know how to implement gradient descent, attention, common loss functions from scratch

### ML System Design
- Use the structured framework (requirements, data, features, model, serving, monitoring)
- Draw diagrams (even in virtual interviews, use a shared whiteboard)
- Discuss scale explicitly: "At 1M users, we'd need..."
- Always mention monitoring and iteration — interviewers love candidates who think about production
- Mention business metrics alongside ML metrics

### ML Depth / Technical
- Be ready to go deep on 2-3 areas (e.g., transformers + RAG + evaluation)
- Know the math: loss functions, gradients, attention computation
- Be ready to discuss papers you've read
- Have strong opinions, loosely held — show you can reason about tradeoffs

### Behavioral
- Prepare 5-6 stories using STAR format (Situation, Task, Action, Result)
- Stories should cover: technical leadership, conflict resolution, failure/learning, ambiguity, impact
- Quantify impact: "Reduced latency by 40%", "Increased accuracy by 5%", "Saved $200K/year"
- Show growth mindset and intellectual curiosity

### LLM-Specific Tips (2025-2026)
- Show practical experience with LLM APIs (OpenAI, Anthropic, open-source)
- Discuss evaluation — how do you know your LLM system is working?
- Know RAG deeply: chunking strategies, embedding selection, retrieval optimization
- Understand cost optimization: caching, model selection, prompt optimization
- Be ready to discuss safety: prompt injection, hallucination, content filtering

### Negotiation Tips
- Never give a number first. Say: "I'd like to understand the full compensation package before discussing numbers"
- Research ranges on levels.fyi, Glassdoor, Blind, and team-specific data
- Negotiate total compensation, not just base salary
- Consider: equity type (RSU vs options), vesting schedule, signing bonus, WFH policy
- Having competing offers significantly strengthens your position

---

## 8. How to Use This Repository

### Getting Started

1. **Assess your level** using the topic breakdown in Section 4. Rate yourself 1-5 on each topic.
2. **Choose a study plan** from Section 5 based on your timeline and experience.
3. **Start with your weakest areas** — this gives the highest return on study time.

### Exercise Structure

Each exercise file contains 5 exercises progressing in difficulty:
- **Level 1:** Basic concepts and implementations
- **Level 2:** Intermediate problems requiring deeper understanding
- **Level 3:** Advanced challenges similar to real interview questions

### Running Exercises

```bash
# Verify all exercises are discoverable
python -m pytest ai-engineer/ --collect-only

# Run a specific exercise file
python ai-engineer/05_llm_engineering/level1_basics/llm_001_prompt_engineering.py

# Run all exercises for a topic
python -m pytest ai-engineer/05_llm_engineering/ -v

# Run with detailed output
python -m pytest ai-engineer/ -v --tb=short
```

### Recommended Study Flow

```
1. Read the topic section in this guide
2. Study the code examples and key concepts
3. Attempt the exercises without looking at solutions
4. Review your solutions against the provided answers
5. Re-attempt failed exercises after 2-3 days (spaced repetition)
6. Do a mock interview covering the topic
```

### Topic Priority for 2025-2026

If you have limited time, prioritize in this order:

1. **LLM Engineering (4.5)** — highest signal for AI Engineer roles
2. **AI System Design (4.9)** — differentiates senior candidates
3. **NLP & Transformers (4.4)** — fundamental knowledge
4. **Python & ML Fundamentals (4.1 + 4.2)** — table stakes
5. **Deep Learning (4.3)** — core technical knowledge
6. **Vector Databases (4.8)** — critical for RAG systems
7. **MLOps (4.7)** — production readiness
8. **Math & Statistics (4.10)** — foundations
9. **Computer Vision (4.6)** — unless targeting CV roles
10. **Responsible AI (4.11)** — increasingly important, lower question frequency

---

**Good luck with your interviews! The AI engineering field is evolving rapidly — stay curious, build projects, and keep learning.**
