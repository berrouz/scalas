import { Question } from '@/types/question';

const questions: Question[] = [
  {
    "language": "english", "id": "c1-startup-p2-001",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'TAM' in a startup market analysis?",
    "options": [
      "Total Available Metrics",
      "Total Addressable Market — the entire potential revenue opportunity",
      "Technology Adoption Model",
      "Team Achievement Measurement"
    ],
    "correctAnswer": 1,
    "explanation": "TAM (Total Addressable Market) is the total revenue opportunity if a company captured 100% of its market. Investors look for large TAMs to justify high startup valuations and growth potential.",
    "subcategory": "market analysis",
    "tags": ["business-english", "startup", "tam", "market-size"]
  },
  {
    "language": "english", "id": "c1-startup-p2-002",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'SAM' in market sizing?",
    "options": [
      "Software Asset Management",
      "Serviceable Available Market — the portion of TAM your startup can reach",
      "Structured Annual Metrics",
      "Strategic Addressable Market"
    ],
    "correctAnswer": 1,
    "explanation": "SAM (Serviceable Addressable Market) is the segment of the TAM that a startup can realistically serve with its current product and distribution. It is always smaller than TAM.",
    "subcategory": "market analysis",
    "tags": ["business-english", "startup", "sam", "market-size"]
  },
  {
    "language": "english", "id": "c1-startup-p2-003",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is the 'SOM' in market sizing?",
    "options": [
      "Share of Market — the portion of SAM a startup realistically aims to capture",
      "Speed of Market growth",
      "Scale of Market investment",
      "Software Operational Model"
    ],
    "correctAnswer": 0,
    "explanation": "SOM (Serviceable Obtainable Market) is the realistic market share a startup can capture in the near term, given competition and resources. It is used in forecasts and investor pitches.",
    "subcategory": "market analysis",
    "tags": ["business-english", "startup", "som", "market-size"]
  },
  {
    "language": "english", "id": "c1-startup-p2-004",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'PMF' stand for?",
    "options": [
      "Product Market Fit",
      "Platform Monetisation Framework",
      "Pre-Market Funding",
      "Project Management File"
    ],
    "correctAnswer": 0,
    "explanation": "PMF (Product-Market Fit) is achieved when a product satisfies a strong market need. It is often described as the feeling that the product is 'pulling itself' through the market.",
    "subcategory": "product-market fit",
    "tags": ["business-english", "startup", "pmf", "product-market-fit"]
  },
  {
    "language": "english", "id": "c1-startup-p2-005",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'problem statement' in a startup pitch?",
    "options": [
      "A list of internal team disputes",
      "A clear articulation of the specific problem the startup is solving",
      "A legal complaint filed by the company",
      "A statement of the company's financial losses"
    ],
    "correctAnswer": 1,
    "explanation": "A problem statement clearly defines the pain point or unmet need the startup addresses. Strong problem statements are specific, backed by data, and make the solution feel necessary.",
    "subcategory": "investor pitch",
    "tags": ["business-english", "startup", "problem-statement", "pitch"]
  },
  {
    "language": "english", "id": "c1-startup-p2-006",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'value proposition' in a startup context?",
    "options": [
      "The monetary value of a company's stock",
      "A clear statement of how the product delivers value and solves the customer's problem",
      "The proposed salary for new hires",
      "A proposal for company values and culture"
    ],
    "correctAnswer": 1,
    "explanation": "A value proposition clearly explains how a product or service benefits customers, solves their problem, and why it is better than alternatives. It is the foundation of all marketing and sales communication.",
    "subcategory": "investor pitch",
    "tags": ["business-english", "startup", "value-proposition"]
  },
  {
    "language": "english", "id": "c1-startup-p2-007",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'DAU' stand for?",
    "options": [
      "Daily Active Users",
      "Data Analytics Unit",
      "Distributed Application Usage",
      "Digital Advertising Updates"
    ],
    "correctAnswer": 0,
    "explanation": "DAU (Daily Active Users) measures how many unique users actively engage with a product each day. It is a key health metric for consumer apps and social platforms.",
    "subcategory": "startup metrics",
    "tags": ["business-english", "startup", "dau", "metrics"]
  },
  {
    "language": "english", "id": "c1-startup-p2-008",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'MAU' stand for in digital products?",
    "options": [
      "Monthly Active Users",
      "Maximum Addressable Users",
      "Market Analysis Unit",
      "Mobile App Users"
    ],
    "correctAnswer": 0,
    "explanation": "MAU (Monthly Active Users) measures the number of unique users who engage with a product in a given month. The DAU/MAU ratio indicates how 'sticky' a product is.",
    "subcategory": "startup metrics",
    "tags": ["business-english", "startup", "mau", "metrics"]
  },
  {
    "language": "english", "id": "c1-startup-p2-009",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'gross margin' in a startup financial context?",
    "options": [
      "Total revenue minus all operating costs",
      "Revenue minus the cost of goods sold (COGS), expressed as a percentage",
      "The maximum profit possible",
      "Revenue before taxes are applied"
    ],
    "correctAnswer": 1,
    "explanation": "Gross margin = (Revenue - COGS) / Revenue × 100. SaaS companies typically aim for 70%+ gross margins. It indicates how much of each sale becomes profit before operating expenses.",
    "subcategory": "startup finance",
    "tags": ["business-english", "startup", "gross-margin", "finance"]
  },
  {
    "language": "english", "id": "c1-startup-p2-010",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'pivot-or-persevere' meeting?",
    "options": [
      "A meeting to decide on gym memberships for employees",
      "A meeting where startup leadership analyses data to decide whether to change direction or continue",
      "A board meeting to discuss dividends",
      "A meeting to decide on a merger"
    ],
    "correctAnswer": 1,
    "explanation": "A pivot-or-persevere meeting is a key lean startup practice where founders regularly review traction data and decide: should we fundamentally change our strategy (pivot) or continue refining the current approach (persevere)?",
    "subcategory": "lean startup",
    "tags": ["business-english", "startup", "pivot", "lean-startup"]
  },
  {
    "language": "english", "id": "c1-startup-p2-011",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'equity crowdfunding'?",
    "options": [
      "Raising small donations from the public",
      "Raising capital by selling equity stakes to many small investors via online platforms",
      "Funding from a group of equity analysts",
      "A method of crowdsourcing product ideas"
    ],
    "correctAnswer": 1,
    "explanation": "Equity crowdfunding (e.g., Crowdcube, SeedInvest) allows startups to raise money from large numbers of retail investors, each receiving a small equity stake. It democratises startup investment.",
    "subcategory": "fundraising",
    "tags": ["business-english", "startup", "crowdfunding", "equity"]
  },
  {
    "language": "english", "id": "c1-startup-p2-012",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'hockey stick' growth chart?",
    "options": [
      "A graph showing declining sales over time",
      "A growth curve that shows slow initial growth followed by rapid exponential growth",
      "A visual showing stable, consistent growth",
      "A chart shape showing seasonal fluctuations"
    ],
    "correctAnswer": 1,
    "explanation": "A hockey stick growth curve (shaped like a hockey stick) shows flat growth initially followed by a sharp upward curve. This is the growth trajectory investors hope to see in high-growth startups.",
    "subcategory": "startup metrics",
    "tags": ["business-english", "startup", "hockey-stick-growth"]
  },
  {
    "language": "english", "id": "c1-startup-p2-013",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is an 'incubator' in the startup context?",
    "options": [
      "A device that keeps products warm during shipping",
      "An organisation that supports early-stage startups with resources, mentorship, and often workspace",
      "A type of investment fund",
      "A company that develops hardware products"
    ],
    "correctAnswer": 1,
    "explanation": "A startup incubator helps very early-stage companies develop their business model and product. Unlike accelerators (which are time-limited), incubators typically have no fixed end date.",
    "subcategory": "startup ecosystem",
    "tags": ["business-english", "startup", "incubator"]
  },
  {
    "language": "english", "id": "c1-startup-p2-014",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'product-led growth' (PLG) mean?",
    "options": [
      "The CEO personally leads all product decisions",
      "A strategy where the product itself drives acquisition, conversion, and retention",
      "Growing by expanding the product catalogue",
      "Leading with product marketing before building the product"
    ],
    "correctAnswer": 1,
    "explanation": "PLG is a go-to-market strategy where the product drives user acquisition and expansion. Users try it, love it, and spread it organically. Slack, Dropbox, and Figma are examples of PLG companies.",
    "subcategory": "growth strategy",
    "tags": ["business-english", "startup", "plg", "product-led-growth"]
  },
  {
    "language": "english", "id": "c1-startup-p2-015",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'post-money valuation' mean?",
    "options": [
      "A company's value after it becomes profitable",
      "A company's value after a new investment has been added",
      "The value of a startup after it goes public",
      "The valuation after all debts are paid"
    ],
    "correctAnswer": 1,
    "explanation": "Post-money valuation = pre-money valuation + new investment. If a startup is valued at $8M pre-money and raises $2M, the post-money valuation is $10M and the investor owns 20%.",
    "subcategory": "valuation",
    "tags": ["business-english", "startup", "post-money-valuation", "fundraising"]
  },
  {
    "language": "english", "id": "c1-startup-p2-016",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is an 'exit strategy' for a startup?",
    "options": [
      "A plan for employees to leave the company",
      "A plan for founders and investors to monetise their ownership (e.g., IPO, acquisition)",
      "A fire evacuation plan",
      "A plan to exit a foreign market"
    ],
    "correctAnswer": 1,
    "explanation": "An exit strategy is how founders and investors eventually 'exit' their investment and realise returns. Common exits include IPO, strategic acquisition, or merger.",
    "subcategory": "exit strategy",
    "tags": ["business-english", "startup", "exit-strategy"]
  },
  {
    "language": "english", "id": "c1-startup-p2-017",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'M&A' stand for in business?",
    "options": [
      "Management and Administration",
      "Mergers and Acquisitions",
      "Marketing and Advertising",
      "Metrics and Analysis"
    ],
    "correctAnswer": 1,
    "explanation": "M&A (Mergers and Acquisitions) refers to transactions where companies combine (merger) or one buys another (acquisition). For startups, being acquired is a common and often lucrative exit route.",
    "subcategory": "exit strategy",
    "tags": ["business-english", "startup", "ma", "mergers-acquisitions"]
  },
  {
    "language": "english", "id": "c1-startup-p2-018",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'term sheet clause' called a 'pro-rata right'?",
    "options": [
      "The right to proportional pay",
      "The right for existing investors to maintain their ownership % by investing in future rounds",
      "A clause preventing founders from leaving",
      "A proportional profit-sharing arrangement"
    ],
    "correctAnswer": 1,
    "explanation": "Pro-rata rights allow existing investors to participate in future funding rounds to maintain their ownership percentage and avoid dilution. It is a commonly negotiated investor protection.",
    "subcategory": "term sheet",
    "tags": ["business-english", "startup", "pro-rata", "term-sheet"]
  },
  {
    "language": "english", "id": "c1-startup-p2-019",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'anti-dilution' protection in a startup investment?",
    "options": [
      "Keeping the product quality high over time",
      "A mechanism protecting investors if new shares are issued at a lower valuation",
      "A clause preventing too many investors from joining a round",
      "Protection against competitor copying"
    ],
    "correctAnswer": 1,
    "explanation": "Anti-dilution clauses protect investors from a down round (when new shares are issued at a lower price than previous rounds). They typically adjust the investor's conversion price to compensate.",
    "subcategory": "term sheet",
    "tags": ["business-english", "startup", "anti-dilution", "investment"]
  },
  {
    "language": "english", "id": "c1-startup-p2-020",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'drag-along rights' in startup equity agreements?",
    "options": [
      "The right to recruit new employees",
      "Majority shareholders can force minority shareholders to agree to a sale of the company",
      "The ability to drag data files between servers",
      "A provision for founders to remain on the board"
    ],
    "correctAnswer": 1,
    "explanation": "Drag-along rights allow majority shareholders (often investors) to force minority shareholders (including founders) to agree to a company sale. This ensures a willing majority buyer isn't blocked by a small minority.",
    "subcategory": "term sheet",
    "tags": ["business-english", "startup", "drag-along-rights"]
  },
  {
    "language": "english", "id": "c1-startup-p2-021",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'tag-along rights' protect in equity agreements?",
    "options": [
      "The right to attend board meetings",
      "Minority shareholders' right to join a sale if majority shareholders sell their stake",
      "The right to add additional equity to a round",
      "Employees' right to follow their manager to a new company"
    ],
    "correctAnswer": 1,
    "explanation": "Tag-along (co-sale) rights protect minority shareholders by giving them the right to sell their shares under the same terms as majority shareholders if those shareholders sell. This prevents minority investors being left behind.",
    "subcategory": "term sheet",
    "tags": ["business-english", "startup", "tag-along-rights"]
  },
  {
    "language": "english", "id": "c1-startup-p2-022",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is an 'ESOP' in a startup?",
    "options": [
      "Enterprise Software Operating Protocol",
      "Employee Stock Ownership Plan — a pool of equity reserved for employees",
      "Early Stage Operating Procedure",
      "External Support Options Package"
    ],
    "correctAnswer": 1,
    "explanation": "An ESOP (Employee Stock Ownership Plan) or option pool is a portion of company equity set aside to attract, retain, and motivate employees through stock options. Typical ESOP pools are 10-20% of total equity.",
    "subcategory": "equity/vesting",
    "tags": ["business-english", "startup", "esop", "equity"]
  },
  {
    "language": "english", "id": "c1-startup-p2-023",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'reverse vesting' in founder agreements?",
    "options": [
      "When a founder gives their equity back voluntarily",
      "When a founder's equity is subject to forfeiture if they leave early, similar to an employee vesting schedule",
      "When equity vests immediately upon founding",
      "When investors' equity reverses to founders"
    ],
    "correctAnswer": 1,
    "explanation": "Reverse vesting applies to founders: they are treated as if their equity vests over time. If a founder leaves early, unvested shares are bought back. This protects investors and remaining co-founders.",
    "subcategory": "equity/vesting",
    "tags": ["business-english", "startup", "reverse-vesting", "founder-equity"]
  },
  {
    "language": "english", "id": "c1-startup-p2-024",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'down round' in startup fundraising?",
    "options": [
      "A funding round completed quickly",
      "A funding round at a lower valuation than the previous round, signalling difficulty",
      "The final small round before profitability",
      "Raising from investors in southern countries"
    ],
    "correctAnswer": 1,
    "explanation": "A down round occurs when a startup raises money at a lower valuation than its previous round. It is damaging to morale, triggers anti-dilution clauses, and signals financial difficulty.",
    "subcategory": "fundraising",
    "tags": ["business-english", "startup", "down-round", "fundraising"]
  },
  {
    "language": "english", "id": "c1-startup-p2-025",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'OKR' stand for in startup goal-setting?",
    "options": [
      "Objectives and Key Results",
      "Operational Knowledge Repository",
      "Output Key Reporting",
      "Organisational Knowledge Review"
    ],
    "correctAnswer": 0,
    "explanation": "OKRs (Objectives and Key Results) is a goal-setting framework used by startups (and large companies like Google). An Objective is the ambitious goal; Key Results are measurable milestones to track progress.",
    "subcategory": "startup management",
    "tags": ["business-english", "startup", "okr", "goal-setting"]
  },
  {
    "language": "english", "id": "c1-startup-p2-026",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'technical debt' in a tech startup?",
    "options": [
      "Money borrowed to buy software licences",
      "The accumulated cost of shortcuts or poor code choices that will need to be fixed later",
      "Hardware equipment financed on credit",
      "Loans taken to hire developers"
    ],
    "correctAnswer": 1,
    "explanation": "Technical debt refers to the future cost of fixing quick-and-dirty code choices made under pressure. High technical debt slows future development and increases the cost of changes.",
    "subcategory": "tech startup vocabulary",
    "tags": ["business-english", "startup", "technical-debt"]
  },
  {
    "language": "english", "id": "c1-startup-p2-027",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'agile' development methodology involve?",
    "options": [
      "Completing the full project plan before writing any code",
      "Iterative development in short 'sprints', with frequent feedback and adaptation",
      "Only hiring physically agile developers",
      "Outsourcing all development to another country"
    ],
    "correctAnswer": 1,
    "explanation": "Agile is a software development methodology based on iterative development, collaboration, and responsiveness to change. Teams work in short sprints (1-2 weeks) and regularly review and adapt.",
    "subcategory": "tech startup methodology",
    "tags": ["business-english", "startup", "agile", "development"]
  },
  {
    "language": "english", "id": "c1-startup-p2-028",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'sprint' in agile development?",
    "options": [
      "A fast-paced investor meeting",
      "A fixed short period (usually 1-2 weeks) during which a team completes a set of development tasks",
      "The final phase before a product launch",
      "A marketing push over a short period"
    ],
    "correctAnswer": 1,
    "explanation": "A sprint is a time-boxed iteration in agile development. At the start of each sprint, the team selects tasks from the backlog; at the end, they review and demo what was built.",
    "subcategory": "agile methodology",
    "tags": ["business-english", "startup", "sprint", "agile"]
  },
  {
    "language": "english", "id": "c1-startup-p2-029",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'scrum' in the context of software development?",
    "options": [
      "A messy, disorganised team meeting",
      "An agile framework using short sprints, daily standups, and defined roles",
      "A type of server architecture",
      "A coding competition"
    ],
    "correctAnswer": 1,
    "explanation": "Scrum is a popular agile framework with defined roles (Scrum Master, Product Owner, Dev Team), events (sprint planning, daily standup, retrospective), and artefacts (product backlog, sprint backlog).",
    "subcategory": "agile methodology",
    "tags": ["business-english", "startup", "scrum", "agile"]
  },
  {
    "language": "english", "id": "c1-startup-p2-030",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'API' stand for and why does it matter for startups?",
    "options": [
      "Automated Programming Interface",
      "Application Programming Interface — allows different software to communicate and integrate",
      "Annual Progress Index",
      "Agile Product Increment"
    ],
    "correctAnswer": 1,
    "explanation": "An API (Application Programming Interface) is a set of rules that allows different software systems to talk to each other. APIs enable startups to build on existing platforms (Stripe for payments, Twilio for messaging) quickly.",
    "subcategory": "tech vocabulary",
    "tags": ["business-english", "startup", "api", "tech"]
  },
  {
    "language": "english", "id": "c1-startup-p2-031",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'SaaS'?",
    "options": [
      "Sales as a System",
      "Software as a Service — software delivered via the internet on a subscription basis",
      "Startup as a Service",
      "Software and Analytics Suite"
    ],
    "correctAnswer": 1,
    "explanation": "SaaS (Software as a Service) delivers software applications over the internet on a subscription basis rather than installed software. Examples: Salesforce, Zoom, HubSpot. It offers predictable recurring revenue.",
    "subcategory": "business models",
    "tags": ["business-english", "startup", "saas", "business-model"]
  },
  {
    "language": "english", "id": "c1-startup-p2-032",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'network effects' in a startup context?",
    "options": [
      "The impact of social media on brand awareness",
      "When a product becomes more valuable as more people use it",
      "The efficiency gained from a large team",
      "The cost of building a computer network"
    ],
    "correctAnswer": 1,
    "explanation": "Network effects occur when a product's value increases as more users join. Platforms like Facebook, WhatsApp, and Airbnb have strong network effects — each new user makes the platform more valuable for existing ones.",
    "subcategory": "growth strategy",
    "tags": ["business-english", "startup", "network-effects"]
  },
  {
    "language": "english", "id": "c1-startup-p2-033",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'virality' as a growth metric?",
    "options": [
      "The spread of illness in a startup office",
      "The rate at which existing users refer new users to a product",
      "The speed of social media content spread",
      "A measure of email open rates"
    ],
    "correctAnswer": 1,
    "explanation": "Virality in growth means the product spreads through word of mouth or sharing. The viral coefficient (K-factor) measures how many new users each existing user brings in. K > 1 means exponential growth.",
    "subcategory": "growth hacking",
    "tags": ["business-english", "startup", "virality", "growth"]
  },
  {
    "language": "english", "id": "c1-startup-p2-034",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'A/B testing' in a startup context?",
    "options": [
      "Testing two different products before deciding which to build",
      "Comparing two versions of a product feature to see which performs better",
      "Evaluating two potential co-founders",
      "The first and second rounds of investor testing"
    ],
    "correctAnswer": 1,
    "explanation": "A/B testing (split testing) involves showing two versions (A and B) of a web page, feature, or message to different user groups to determine which performs better based on a specific metric.",
    "subcategory": "growth hacking",
    "tags": ["business-english", "startup", "ab-testing"]
  },
  {
    "language": "english", "id": "c1-startup-p2-035",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'content marketing' as a growth strategy?",
    "options": [
      "Marketing that involves designing product packaging",
      "Creating and distributing valuable content to attract and retain a target audience",
      "Counting the word content in all marketing materials",
      "A strategy for physical product demonstrations"
    ],
    "correctAnswer": 1,
    "explanation": "Content marketing involves creating blogs, videos, podcasts, and other content that attracts potential customers organically. It builds trust and SEO rather than relying solely on paid advertising.",
    "subcategory": "marketing strategy",
    "tags": ["business-english", "startup", "content-marketing"]
  },
  {
    "language": "english", "id": "c1-startup-p2-036",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'SEO' in digital marketing?",
    "options": [
      "Senior Executive Officer",
      "Search Engine Optimisation — improving a website's visibility in search results",
      "Social Engagement Outreach",
      "Software Engineering Output"
    ],
    "correctAnswer": 1,
    "explanation": "SEO (Search Engine Optimisation) is the process of optimising a website to rank higher in search engine results (Google, Bing). It is a key organic growth channel for startups.",
    "subcategory": "digital marketing",
    "tags": ["business-english", "startup", "seo", "marketing"]
  },
  {
    "language": "english", "id": "c1-startup-p2-037",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'monthly recurring revenue' (MRR)?",
    "options": [
      "Total revenue earned in a single month from one-time sales",
      "The predictable revenue a subscription business earns each month from active subscribers",
      "Monthly revenue minus all operating costs",
      "The revenue target set by the board for each month"
    ],
    "correctAnswer": 1,
    "explanation": "MRR (Monthly Recurring Revenue) is a critical SaaS and subscription business metric. It measures the predictable, stable revenue generated each month and is used to track growth, forecast revenue, and evaluate business health.",
    "subcategory": "startup metrics",
    "tags": ["business-english", "startup", "mrr", "saas", "metrics"]
  },
  {
    "language": "english", "id": "c1-startup-p2-038",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'cold outreach' in startup sales?",
    "options": [
      "Calling potential customers in cold weather",
      "Contacting potential customers who have had no prior relationship with the company",
      "Reaching out to lapsed customers",
      "Sending physical mail campaigns"
    ],
    "correctAnswer": 1,
    "explanation": "Cold outreach involves contacting potential customers (via email, phone, or LinkedIn) who have no existing relationship with the startup. Effective cold outreach is personalised and clearly communicates value.",
    "subcategory": "sales strategy",
    "tags": ["business-english", "startup", "cold-outreach", "sales"]
  },
  {
    "language": "english", "id": "c1-startup-p2-039",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'social proof' in startup marketing?",
    "options": [
      "Evidence that a company has social media accounts",
      "Testimonials, reviews, case studies, or endorsements that build trust with potential customers",
      "Legal proof of social enterprise status",
      "Evidence of community investment"
    ],
    "correctAnswer": 1,
    "explanation": "Social proof is evidence that others have used and benefited from a product — reviews, logos of well-known clients, case studies, testimonials, or user counts. It reduces purchase anxiety for new customers.",
    "subcategory": "marketing strategy",
    "tags": ["business-english", "startup", "social-proof", "marketing"]
  },
  {
    "language": "english", "id": "c1-startup-p2-040",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'customer persona' in startup product development?",
    "options": [
      "A legal identity created for customer data protection",
      "A fictional profile representing a typical target customer",
      "A customer's personal data file",
      "A profile of a startup's best investor"
    ],
    "correctAnswer": 1,
    "explanation": "A customer persona (or buyer persona) is a semi-fictional representation of an ideal customer based on research and data. It includes demographics, goals, challenges, and behaviours to guide product and marketing decisions.",
    "subcategory": "product development",
    "tags": ["business-english", "startup", "customer-persona"]
  },
  {
    "language": "english", "id": "c1-startup-p2-041",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'product discovery' in a startup?",
    "options": [
      "Finding out what competitors have built",
      "The process of researching and validating what to build before building it",
      "Discovering bugs in a product after launch",
      "The legal process of filing patents"
    ],
    "correctAnswer": 1,
    "explanation": "Product discovery is the research phase where product teams identify the right problem to solve and validate potential solutions before committing to full development. It avoids building features nobody wants.",
    "subcategory": "product management",
    "tags": ["business-english", "startup", "product-discovery"]
  },
  {
    "language": "english", "id": "c1-startup-p2-042",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'user interview' mean in startup product research?",
    "options": [
      "An interview process for hiring users as employees",
      "A research conversation where a team member asks a user about their needs, behaviours, and pain points",
      "A review of users' social media profiles",
      "Asking users to write product reviews"
    ],
    "correctAnswer": 1,
    "explanation": "User interviews are qualitative research conversations where product teams explore users' real-world problems, motivations, and behaviours. Insights guide product design and feature prioritisation.",
    "subcategory": "product development",
    "tags": ["business-english", "startup", "user-interview"]
  },
  {
    "language": "english", "id": "c1-startup-p2-043",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'unit economics' in startup analysis?",
    "options": [
      "The cost of a single unit of production",
      "The direct revenues and costs associated with a single unit of business (e.g., one customer)",
      "The economic theory underlying a startup",
      "The financial performance of each business department"
    ],
    "correctAnswer": 1,
    "explanation": "Unit economics examines the revenue and costs on a per-unit (usually per-customer) basis. Healthy unit economics (LTV > CAC) indicates a sustainable business model.",
    "subcategory": "startup finance",
    "tags": ["business-english", "startup", "unit-economics"]
  },
  {
    "language": "english", "id": "c1-startup-p2-044",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'revenue recognition' mean for a SaaS startup?",
    "options": [
      "When a startup's brand becomes well-known",
      "The accounting principle governing when revenue is recorded in financial statements",
      "The process of recognising key revenue-generating employees",
      "The moment a customer first pays"
    ],
    "correctAnswer": 1,
    "explanation": "Revenue recognition determines when revenue is officially recorded. For SaaS, a 12-month prepaid subscription is not recognised all at once — it is recognised monthly over the subscription period.",
    "subcategory": "startup finance",
    "tags": ["business-english", "startup", "revenue-recognition"]
  },
  {
    "language": "english", "id": "c1-startup-p2-045",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'cash flow positive' for a startup?",
    "options": [
      "When a startup has received its first investment",
      "When a startup's cash inflows exceed its cash outflows in a given period",
      "When a startup's bank account balance is high",
      "When a startup's investors feel positive about the outlook"
    ],
    "correctAnswer": 1,
    "explanation": "Cash flow positive means the startup generates more cash than it spends in a given period. This is different from profitable — a company can be profitable but have negative cash flow due to timing.",
    "subcategory": "startup finance",
    "tags": ["business-english", "startup", "cash-flow"]
  },
  {
    "language": "english", "id": "c1-startup-p2-046",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is a 'pitch competition'?",
    "options": [
      "A competition between salespeople for the best sales pitch",
      "An event where startups present to judges for prizes, investment, or visibility",
      "A competition to design the best pitch deck template",
      "A debate competition for business students"
    ],
    "correctAnswer": 1,
    "explanation": "Pitch competitions (like TechCrunch Disrupt, Demo Day, or Startup Weekend) give founders the opportunity to pitch for investment, prizes, and media attention. Winning provides both capital and credibility.",
    "subcategory": "startup ecosystem",
    "tags": ["business-english", "startup", "pitch-competition"]
  },
  {
    "language": "english", "id": "c1-startup-p2-047",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'sweat equity' in a startup?",
    "options": [
      "Equity earned through physical labour",
      "Equity given to founders or early contributors in exchange for their work rather than cash",
      "A gym membership benefit for startup employees",
      "Revenue earned from fitness-related products"
    ],
    "correctAnswer": 1,
    "explanation": "Sweat equity is ownership stake given to founders, early employees, or contributors in lieu of a full salary. It compensates people for their early 'sweat' (effort) when cash is limited.",
    "subcategory": "equity",
    "tags": ["business-english", "startup", "sweat-equity"]
  },
  {
    "language": "english", "id": "c1-startup-p2-048",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What does 'scalable infrastructure' mean for a tech startup?",
    "options": [
      "An office building with multiple floors",
      "Technology that can handle growing demand without proportional cost increases",
      "A physical workspace that can expand",
      "Hiring more developers as revenue grows"
    ],
    "correctAnswer": 1,
    "explanation": "Scalable infrastructure (often cloud-based) allows a startup to handle 10x or 100x the users without rebuilding everything. Cloud platforms like AWS and Google Cloud enable this scalability on demand.",
    "subcategory": "tech infrastructure",
    "tags": ["business-english", "startup", "scalable-infrastructure"]
  },
  {
    "language": "english", "id": "c1-startup-p2-049",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'PLG' versus 'SLG' in startup go-to-market strategy?",
    "options": [
      "Product-Led Growth versus Sales-Led Growth",
      "Platform Licensing Guide versus Software Licensing Guide",
      "Project Lifecycle Guide versus Software Lifecycle Guide",
      "Product Launch Guide versus Sales Launch Guide"
    ],
    "correctAnswer": 0,
    "explanation": "PLG (Product-Led Growth) relies on the product itself driving adoption. SLG (Sales-Led Growth) relies on a sales team to close deals. Many startups blend both — PLG to acquire and SLG to expand enterprise accounts.",
    "subcategory": "growth strategy",
    "tags": ["business-english", "startup", "plg-slg", "growth"]
  },
  {
    "language": "english", "id": "c1-startup-p2-050",
    "level": "c1",
    "category": "Startup & Tech Business",
    "question": "What is 'stealth mode' for a startup?",
    "options": [
      "Operating a company secretly without a public profile to avoid copying",
      "A security feature in cloud software",
      "Hiring employees without advertising publicly",
      "A stage of funding that is undisclosed"
    ],
    "correctAnswer": 0,
    "explanation": "Stealth mode means a startup operates quietly without publicising its product, identity, or plans, usually to protect its idea from copycats before launch. Some investors and founders are disclosed privately.",
    "subcategory": "startup lifecycle",
    "tags": ["business-english", "startup", "stealth-mode"]
  }
];

export default questions;
