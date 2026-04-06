import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'ai-engineer-python-ml-l3-001',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'What does np.einsum("ij,jk->ik", A, B) compute?',
    options: [
      'Matrix multiplication of A and B',
      'Element-wise multiplication of A and B',
      'The trace of A @ B',
      'The outer product of A and B',
    ],
    correctAnswer: 0,
    explanation: 'Einstein summation notation "ij,jk->ik" sums over the shared index j, which is exactly matrix multiplication. einsum is a powerful generalization of many array operations.',
    tags: ['numpy', 'einsum', 'advanced'],
  },
  {
    id: 'ai-engineer-python-ml-l3-002',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'What does np.einsum("ii->", A) compute for a square matrix A?',
    options: [
      'The trace (sum of diagonal elements)',
      'The determinant',
      'The Frobenius norm',
      'The diagonal elements as an array',
    ],
    correctAnswer: 0,
    explanation: '"ii->" selects diagonal elements (where both indices are equal) and sums them (no output indices), computing the trace of the matrix.',
    tags: ['numpy', 'einsum', 'trace'],
  },
  {
    id: 'ai-engineer-python-ml-l3-003',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Memory',
    question: 'What is the purpose of np.ascontiguousarray()?',
    options: [
      'Ensures the array is stored in C-contiguous (row-major) memory layout',
      'Compresses the array to save memory',
      'Creates a read-only copy of the array',
      'Converts the array to Fortran order',
    ],
    correctAnswer: 0,
    explanation: 'C-contiguous means rows are stored in contiguous memory. Some operations (e.g., certain BLAS routines) require contiguous arrays. Transposed or sliced arrays may not be contiguous.',
    tags: ['numpy', 'memory', 'contiguous'],
  },
  {
    id: 'ai-engineer-python-ml-l3-004',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'What does np.stride_tricks.as_strided() allow you to do?',
    options: [
      'Create custom views of memory with arbitrary strides for advanced windowing',
      'Speed up array sorting',
      'Convert arrays between dtypes without copying',
      'Parallelize array operations across CPU cores',
    ],
    correctAnswer: 0,
    explanation: 'as_strided() creates views with custom shapes and strides, enabling sliding window operations and other memory-efficient tricks. It is dangerous if misused, as it can read invalid memory.',
    tags: ['numpy', 'strides', 'advanced'],
  },
  {
    id: 'ai-engineer-python-ml-l3-005',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Linear Algebra',
    question: 'When should you use np.linalg.lstsq() instead of np.linalg.solve()?',
    options: [
      'When the system is overdetermined (more equations than unknowns)',
      'When the matrix is square',
      'When you need exact solutions only',
      'When dealing with sparse matrices',
    ],
    correctAnswer: 0,
    explanation: 'lstsq() computes the least-squares solution, which works for overdetermined systems (no exact solution). solve() requires a square, non-singular matrix for exact solutions.',
    tags: ['numpy', 'linear-algebra', 'least-squares'],
  },
  {
    id: 'ai-engineer-python-ml-l3-006',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Linear Algebra',
    question: 'What does Singular Value Decomposition (SVD) decompose a matrix M into?',
    codeSnippet: `U, S, Vt = np.linalg.svd(M)`,
    options: [
      'U (left singular vectors), S (singular values), Vt (right singular vectors transposed)',
      'U (upper triangular), S (diagonal), Vt (lower triangular)',
      'U (unitary), S (symmetric), Vt (variance)',
      'U (eigenvectors), S (eigenvalues), Vt (inverse)',
    ],
    correctAnswer: 0,
    explanation: 'SVD decomposes M = U @ diag(S) @ Vt. U contains left singular vectors, S contains singular values (sorted descending), and Vt contains right singular vectors transposed.',
    tags: ['numpy', 'svd', 'linear-algebra'],
  },
  {
    id: 'ai-engineer-python-ml-l3-007',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Pandas Advanced',
    question: 'What is the advantage of using pd.Categorical for a column with few unique values?',
    options: [
      'Significantly reduces memory usage and speeds up groupby operations',
      'Enables GPU acceleration for that column',
      'Automatically handles missing values',
      'Converts strings to numerical embeddings',
    ],
    correctAnswer: 0,
    explanation: 'Categorical dtype stores data as integer codes + a small lookup table of unique values, dramatically reducing memory for columns with low cardinality and speeding up groupby.',
    tags: ['pandas', 'categorical', 'optimization'],
  },
  {
    id: 'ai-engineer-python-ml-l3-008',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Pandas Advanced',
    question: 'What does df.pipe() enable?',
    codeSnippet: `def clean(df):
    return df.dropna()

def normalize(df, columns):
    df[columns] = (df[columns] - df[columns].mean()) / df[columns].std()
    return df

result = (df
    .pipe(clean)
    .pipe(normalize, columns=['a', 'b']))`,
    options: [
      'Method chaining with functions that take a DataFrame as the first argument',
      'Parallel processing of DataFrame operations',
      'Unix-style piping of DataFrames between processes',
      'Lazy evaluation of DataFrame transformations',
    ],
    correctAnswer: 0,
    explanation: 'pipe() enables clean method chaining by passing the DataFrame as the first argument to the given function. Additional arguments can be passed as keyword arguments.',
    tags: ['pandas', 'pipe', 'method-chaining'],
  },
  {
    id: 'ai-engineer-python-ml-l3-009',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Pandas Advanced',
    question: 'When would you use df.eval() and df.query() over standard Pandas operations?',
    codeSnippet: `# Standard
result = df[(df['a'] > 5) & (df['b'] < 10)]

# Using query
result = df.query('a > 5 and b < 10')`,
    options: [
      'For large DataFrames, as they avoid creating intermediate arrays and can be faster',
      'For small DataFrames only, as they have high overhead',
      'When you need to use Python functions in expressions',
      'When working with non-numeric data exclusively',
    ],
    correctAnswer: 0,
    explanation: 'eval() and query() use numexpr under the hood, avoiding temporary array allocation. For large DataFrames, this can significantly reduce memory usage and improve performance.',
    tags: ['pandas', 'eval', 'query', 'performance'],
  },
  {
    id: 'ai-engineer-python-ml-l3-010',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Python Generators',
    question: 'What does the send() method do on a generator?',
    codeSnippet: `def accumulator():
    total = 0
    while True:
        value = yield total
        total += value

gen = accumulator()
next(gen)       # prime the generator
print(gen.send(10))
print(gen.send(20))`,
    options: [
      'Sends a value into the generator, resuming it and returning the next yielded value (prints 10, then 30)',
      'Replaces the last yielded value (prints 10, then 20)',
      'Creates a new generator with the sent value (prints 0, then 0)',
      'Raises StopIteration immediately',
    ],
    correctAnswer: 0,
    explanation: 'send() resumes the generator and provides a value that becomes the result of the yield expression. After send(10), total=10 and yield produces 10. After send(20), total=30 and yield produces 30.',
    tags: ['python', 'generators', 'send', 'coroutines'],
  },
  {
    id: 'ai-engineer-python-ml-l3-011',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Python Async',
    question: 'What is the difference between asyncio.create_task() and simply awaiting a coroutine?',
    options: [
      'create_task() schedules concurrent execution; await runs sequentially',
      'create_task() runs in a thread; await runs in the event loop',
      'There is no difference in behavior',
      'create_task() is for CPU-bound tasks; await is for I/O-bound tasks',
    ],
    correctAnswer: 0,
    explanation: 'create_task() wraps a coroutine in a Task and schedules it to run concurrently on the event loop. Simply awaiting a coroutine runs it sequentially, blocking until it completes.',
    tags: ['python', 'async', 'create-task'],
  },
  {
    id: 'ai-engineer-python-ml-l3-012',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Python Async',
    question: 'What does an async generator look like and how is it consumed?',
    codeSnippet: `async def async_range(n):
    for i in range(n):
        await asyncio.sleep(0.1)
        yield i

# How to consume?`,
    options: [
      'async for i in async_range(5): ...',
      'for i in async_range(5): ...',
      'await for i in async_range(5): ...',
      'for i in await async_range(5): ...',
    ],
    correctAnswer: 0,
    explanation: 'Async generators (using async def with yield) are consumed with async for. This allows awaiting between iterations, useful for streaming data from async sources.',
    tags: ['python', 'async', 'async-generator'],
  },
  {
    id: 'ai-engineer-python-ml-l3-013',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Type Hints',
    question: 'What does TypeVar with bound accomplish?',
    codeSnippet: `from typing import TypeVar

T = TypeVar('T', bound='Animal')

def clone(obj: T) -> T:
    return obj.copy()`,
    options: [
      'T can be Animal or any subclass, and the return type matches the input type',
      'T can only be exactly Animal, not subclasses',
      'T can be any type at all',
      'T is always inferred as Animal regardless of input',
    ],
    correctAnswer: 0,
    explanation: 'TypeVar with bound restricts T to the bound type or its subclasses, while preserving the specific subtype. If called with a Dog (subclass of Animal), the return type is Dog.',
    tags: ['python', 'type-hints', 'typevar', 'generics'],
  },
  {
    id: 'ai-engineer-python-ml-l3-014',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Type Hints',
    question: 'What is the purpose of Protocol in Python typing?',
    codeSnippet: `from typing import Protocol

class Drawable(Protocol):
    def draw(self) -> None: ...

def render(obj: Drawable) -> None:
    obj.draw()`,
    options: [
      'Structural subtyping (duck typing with static type checking)',
      'Runtime interface enforcement like Java interfaces',
      'Creating abstract base classes',
      'Defining serialization protocols',
    ],
    correctAnswer: 0,
    explanation: 'Protocol enables structural subtyping: any class with a draw() method satisfies Drawable without explicitly inheriting from it. This formalizes duck typing for type checkers.',
    tags: ['python', 'type-hints', 'protocol', 'structural-subtyping'],
  },
  {
    id: 'ai-engineer-python-ml-l3-015',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Dataclasses',
    question: 'How do you create an immutable dataclass that is also hashable?',
    codeSnippet: `from dataclasses import dataclass

@dataclass(frozen=True)
class Vector:
    x: float
    y: float`,
    options: [
      'frozen=True makes instances immutable and auto-generates __hash__',
      'frozen=True only prevents attribute assignment but does not affect hashing',
      'You must manually implement __hash__ even with frozen=True',
      'Dataclasses cannot be made hashable',
    ],
    correctAnswer: 0,
    explanation: 'frozen=True prevents attribute modification after creation and automatically generates __hash__ based on all fields, making instances usable as dict keys and in sets.',
    tags: ['python', 'dataclasses', 'frozen', 'hashable'],
  },
  {
    id: 'ai-engineer-python-ml-l3-016',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Dataclasses',
    question: 'What does __post_init__ do in a dataclass?',
    codeSnippet: `@dataclass
class Rectangle:
    width: float
    height: float
    area: float = field(init=False)

    def __post_init__(self):
        self.area = self.width * self.height`,
    options: [
      'Runs additional initialization logic after the auto-generated __init__',
      'Validates types at runtime',
      'Replaces the auto-generated __init__ entirely',
      'Runs before __init__ to set defaults',
    ],
    correctAnswer: 0,
    explanation: '__post_init__ is called at the end of the auto-generated __init__. It is used for derived fields, validation, or any setup that depends on the initialized values.',
    tags: ['python', 'dataclasses', 'post-init'],
  },
  {
    id: 'ai-engineer-python-ml-l3-017',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'SciPy Advanced',
    question: 'What does scipy.sparse.csr_matrix represent and when should you use it?',
    options: [
      'Compressed Sparse Row format, efficient for row slicing and matrix-vector products',
      'Column-Sorted Rows format, efficient for column operations',
      'Cache-friendly Sparse Representation, for GPU operations',
      'Condensed Sparse Rectangular format, for non-square matrices only',
    ],
    correctAnswer: 0,
    explanation: 'CSR (Compressed Sparse Row) stores non-zero values with their column indices and row pointers. It is efficient for row slicing, matrix-vector multiplication, and is the standard format for many ML algorithms.',
    tags: ['scipy', 'sparse', 'csr'],
  },
  {
    id: 'ai-engineer-python-ml-l3-018',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'SciPy Advanced',
    question: 'What is the difference between scipy.sparse.csr_matrix and csc_matrix?',
    options: [
      'CSR is efficient for row operations; CSC is efficient for column operations',
      'CSR uses less memory than CSC for the same data',
      'CSC is the compressed version of CSR',
      'CSR is for real numbers; CSC is for complex numbers',
    ],
    correctAnswer: 0,
    explanation: 'CSR (Compressed Sparse Row) is optimized for row slicing and row-based operations. CSC (Compressed Sparse Column) is optimized for column slicing. Choose based on your access patterns.',
    tags: ['scipy', 'sparse', 'csr', 'csc'],
  },
  {
    id: 'ai-engineer-python-ml-l3-019',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'What does np.vectorize() actually do under the hood?',
    options: [
      'Wraps a Python function to accept arrays, but does NOT provide true vectorization speedup',
      'Compiles the function to C for optimal performance',
      'Parallelizes the function across multiple CPU cores',
      'Converts the function to use SIMD instructions',
    ],
    correctAnswer: 0,
    explanation: 'np.vectorize() is essentially a convenience wrapper that loops over elements in Python. It does not provide the performance benefits of true NumPy vectorization. For speed, use native NumPy operations.',
    tags: ['numpy', 'vectorize', 'performance'],
  },
  {
    id: 'ai-engineer-python-ml-l3-020',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'How does np.meshgrid() work and what is it used for?',
    codeSnippet: `x = np.array([1, 2, 3])
y = np.array([4, 5])
X, Y = np.meshgrid(x, y)
print(X.shape, Y.shape)`,
    options: [
      '(2, 3) (2, 3) — creates coordinate matrices for evaluating functions over a grid',
      '(3, 2) (3, 2) — creates transposed coordinate matrices',
      '(6,) (6,) — creates flattened coordinate arrays',
      '(3, 3) (2, 2) — creates square grids for each input',
    ],
    correctAnswer: 0,
    explanation: 'meshgrid creates coordinate matrices from coordinate vectors. With x of length 3 and y of length 2, both outputs have shape (2, 3). This is essential for evaluating 2D functions on grids.',
    tags: ['numpy', 'meshgrid', 'grid'],
  },
  {
    id: 'ai-engineer-python-ml-l3-021',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Pandas Performance',
    question: 'Why is iterating over DataFrame rows with iterrows() generally discouraged?',
    options: [
      'It is very slow because it converts each row to a Series, losing dtype optimization',
      'It modifies the DataFrame in place',
      'It only works with numeric columns',
      'It skips rows with missing values',
    ],
    correctAnswer: 0,
    explanation: 'iterrows() creates a new Series for each row, which is extremely slow for large DataFrames. Use vectorized operations, apply(), or itertuples() (faster) instead.',
    tags: ['pandas', 'performance', 'iterrows'],
  },
  {
    id: 'ai-engineer-python-ml-l3-022',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Pandas Performance',
    question: 'What does df.select_dtypes(include=["number"]) return?',
    options: [
      'A DataFrame with only numeric columns',
      'The dtypes of numeric columns as a Series',
      'A boolean mask of numeric values',
      'Converts all columns to numeric types',
    ],
    correctAnswer: 0,
    explanation: 'select_dtypes() filters columns based on their dtype. include=["number"] selects int and float columns. This is useful for applying operations only to numeric data.',
    tags: ['pandas', 'dtypes', 'selection'],
  },
  {
    id: 'ai-engineer-python-ml-l3-023',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'String Processing',
    question: 'What is the output of this code using f-string debugging?',
    codeSnippet: `x = 42
y = "hello"
print(f"{x=}, {y=}, {x*2=}")`,
    options: [
      "x=42, y='hello', x*2=84",
      '42, hello, 84',
      'x:42, y:hello, x*2:84',
      'Error: invalid f-string syntax',
    ],
    correctAnswer: 0,
    explanation: 'The = specifier in f-strings (Python 3.8+) outputs both the expression text and its value. This is a powerful debugging feature.',
    tags: ['python', 'f-strings', 'debugging'],
  },
  {
    id: 'ai-engineer-python-ml-l3-024',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'String Processing',
    question: 'What does this code produce?',
    codeSnippet: `import re
text = "Price: $12.50, Discount: $3.25"
prices = re.findall(r'\\$(\\d+\\.\\d{2})', text)
print(prices)`,
    options: [
      "['12.50', '3.25']",
      "['$12.50', '$3.25']",
      "['12', '3']",
      "['Price: $12.50', 'Discount: $3.25']",
    ],
    correctAnswer: 0,
    explanation: 'The capturing group (\\d+\\.\\d{2}) matches the numeric part after $. findall() returns only the captured group contents, not the full match including $.',
    tags: ['python', 'regex', 'capturing-groups'],
  },
  {
    id: 'ai-engineer-python-ml-l3-025',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Data Structures',
    question: 'What is the purpose of __slots__ in a Python class for ML pipelines?',
    codeSnippet: `class Feature:
    __slots__ = ['name', 'value', 'dtype']
    def __init__(self, name, value, dtype):
        self.name = name
        self.value = value
        self.dtype = dtype`,
    options: [
      'Reduces memory per instance by avoiding __dict__ and speeds up attribute access',
      'Makes the class thread-safe',
      'Enables automatic serialization',
      'Restricts inheritance to listed attributes only',
    ],
    correctAnswer: 0,
    explanation: '__slots__ replaces the per-instance __dict__ with a fixed-size structure. This can save significant memory when creating millions of instances (e.g., feature objects in ML).',
    tags: ['python', 'slots', 'memory-optimization'],
  },
  {
    id: 'ai-engineer-python-ml-l3-026',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Data Structures',
    question: 'What is a LRU cache and how is it implemented in Python?',
    codeSnippet: `from functools import lru_cache

@lru_cache(maxsize=128)
def expensive_computation(n: int) -> int:
    return sum(i**2 for i in range(n))`,
    options: [
      'Least Recently Used cache backed by a dict + doubly linked list; functools.lru_cache provides it as a decorator',
      'Last Read Updated cache using a simple list',
      'Lazy Resource Utilization cache using a heap',
      'Linear Recency Update cache using a queue',
    ],
    correctAnswer: 0,
    explanation: 'LRU (Least Recently Used) cache evicts the least recently accessed entries when full. Python\'s lru_cache uses a dict for O(1) lookups and a doubly linked list to track access order.',
    tags: ['python', 'caching', 'lru-cache'],
  },
  {
    id: 'ai-engineer-python-ml-l3-027',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'What does np.frompyfunc() do and how does it differ from np.vectorize()?',
    options: [
      'Creates a NumPy ufunc from a Python function; returns object arrays unlike vectorize which can specify output types',
      'Compiles a Python function to native code; vectorize does not',
      'They are exactly the same function with different names',
      'frompyfunc works only with scalar inputs; vectorize works with arrays',
    ],
    correctAnswer: 0,
    explanation: 'np.frompyfunc() creates a true ufunc (supporting broadcasting, reduce, etc.) but always returns object arrays. np.vectorize() wraps frompyfunc but adds output type specification.',
    tags: ['numpy', 'ufunc', 'frompyfunc'],
  },
  {
    id: 'ai-engineer-python-ml-l3-028',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Matplotlib Advanced',
    question: 'How do you create a custom colormap in matplotlib?',
    codeSnippet: `from matplotlib.colors import LinearSegmentedColormap

custom_cmap = LinearSegmentedColormap.from_list(
    'custom', ['blue', 'white', 'red'], N=256
)`,
    options: [
      'LinearSegmentedColormap.from_list() creates a smooth gradient between specified colors',
      'This creates a discrete colormap with exactly 3 colors',
      'from_list() only works with RGB tuples, not color names',
      'N parameter specifies the number of colors in the input list',
    ],
    correctAnswer: 0,
    explanation: 'from_list() creates a colormap by linearly interpolating between the given colors. N=256 means the gradient has 256 discrete levels for smooth rendering.',
    tags: ['matplotlib', 'colormap', 'advanced'],
  },
  {
    id: 'ai-engineer-python-ml-l3-029',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'SciPy Advanced',
    question: 'What does scipy.optimize.minimize() return and what is the Nelder-Mead method?',
    options: [
      'An OptimizeResult object; Nelder-Mead is a derivative-free simplex method',
      'A single float (the minimum); Nelder-Mead uses gradient descent',
      'A tuple (x, fval); Nelder-Mead is a second-order Newton method',
      'An array of local minima; Nelder-Mead uses genetic algorithms',
    ],
    correctAnswer: 0,
    explanation: 'minimize() returns an OptimizeResult with attributes x (solution), fun (function value), success, etc. Nelder-Mead is a derivative-free method using a simplex, useful when gradients are unavailable.',
    tags: ['scipy', 'optimization', 'nelder-mead'],
  },
  {
    id: 'ai-engineer-python-ml-l3-030',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Python Generators',
    question: 'How do you implement a memory-efficient sliding window using generators?',
    codeSnippet: `from collections import deque

def sliding_window(iterable, n):
    it = iter(iterable)
    window = deque(maxlen=n)
    for _ in range(n):
        window.append(next(it))
    yield tuple(window)
    for item in it:
        window.append(item)
        yield tuple(window)`,
    options: [
      'Uses a deque with maxlen to maintain a fixed-size window, yielding tuples lazily',
      'Loads the entire iterable into memory and slices it',
      'Uses recursion to generate all possible windows',
      'Requires the input to be a list for random access',
    ],
    correctAnswer: 0,
    explanation: 'This generator uses deque(maxlen=n) which automatically drops the oldest element when a new one is appended. Combined with yield, it processes iterables of any size with O(n) memory.',
    tags: ['python', 'generators', 'sliding-window', 'memory-efficiency'],
  },
  {
    id: 'ai-engineer-python-ml-l3-031',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Type Hints',
    question: 'What is the purpose of @overload in Python typing?',
    codeSnippet: `from typing import overload

@overload
def process(data: str) -> list[str]: ...
@overload
def process(data: bytes) -> list[bytes]: ...
def process(data):
    if isinstance(data, str):
        return data.split()
    return data.split(b' ')`,
    options: [
      'Declares multiple type signatures for type checkers without runtime dispatch',
      'Creates actual method overloading like in Java',
      'Automatically dispatches to the correct implementation at runtime',
      'Generates separate compiled functions for each type',
    ],
    correctAnswer: 0,
    explanation: '@overload is purely for static type checkers. It declares different input-output type relationships. The actual implementation is the non-decorated function that handles all cases.',
    tags: ['python', 'type-hints', 'overload'],
  },
  {
    id: 'ai-engineer-python-ml-l3-032',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'NumPy Advanced',
    question: 'What is the purpose of np.newaxis and how does it relate to None?',
    codeSnippet: `a = np.array([1, 2, 3])  # shape (3,)
b = a[:, np.newaxis]     # shape (3, 1)
c = a[np.newaxis, :]     # shape (1, 3)`,
    options: [
      'np.newaxis is None; it inserts a new axis of size 1 for broadcasting',
      'np.newaxis creates a copy with an extra dimension',
      'np.newaxis is -1; it reshapes the array automatically',
      'np.newaxis only works with 1D arrays',
    ],
    correctAnswer: 0,
    explanation: 'np.newaxis is literally None. When used in indexing, it inserts a new dimension of size 1 at that position. This is essential for controlling broadcasting behavior.',
    tags: ['numpy', 'newaxis', 'broadcasting'],
  },
  {
    id: 'ai-engineer-python-ml-l3-033',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Python & ML Fundamentals',
    subcategory: 'Data Structures',
    question: 'How would you implement a memory-efficient feature store for ML using Python?',
    codeSnippet: `import numpy as np
from dataclasses import dataclass, field

@dataclass(frozen=True)
class FeatureKey:
    entity_id: str
    feature_name: str
    __slots__ = ['entity_id', 'feature_name']

class FeatureStore:
    def __init__(self):
        self._store: dict[str, np.ndarray] = {}
        self._index: dict[str, dict[str, int]] = {}`,
    options: [
      'Use frozen dataclass keys with __slots__ for low-overhead hashing, and columnar numpy storage for values',
      'Store all features as Python dicts with string keys',
      'Use SQLite for all feature storage regardless of size',
      'Store each feature as a separate pickle file on disk',
    ],
    correctAnswer: 0,
    explanation: 'Combining frozen dataclasses (hashable keys) with __slots__ (memory-efficient) and columnar numpy arrays (cache-friendly, typed) provides an efficient in-memory feature store pattern.',
    tags: ['python', 'data-structures', 'feature-store', 'memory-efficiency'],
  },
];

export default questions;
