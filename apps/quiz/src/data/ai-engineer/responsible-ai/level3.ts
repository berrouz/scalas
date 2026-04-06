import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'ai-engineer-responsible-ai-l3-001',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Fairness',
    question:
      'The impossibility theorem of fairness (Chouldechova, 2017) proves that calibration, false positive rate balance, and false negative rate balance cannot all hold simultaneously when:',
    options: [
      'The model has too many parameters',
      'The base rates (prevalence) differ across groups',
      'The dataset is too large',
      'The model is non-linear',
    ],
    correctAnswer: 1,
    explanation:
      'Chouldechova (2017) proved that when base rates differ between groups, it is mathematically impossible to simultaneously achieve calibration (equal PPV across groups), false positive rate balance, and false negative rate balance, except in degenerate cases. This forces practitioners to make explicit trade-offs.',
    tags: ['fairness', 'impossibility-theorem', 'calibration', 'trade-offs'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-002',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Fairness',
    question:
      'In the context of causal fairness, what does "counterfactual fairness" require?',
    options: [
      'That the model accuracy is the same in counterfactual scenarios',
      'That a prediction for an individual would remain the same in a counterfactual world where the individual belonged to a different demographic group',
      'That the model uses counterfactual data augmentation during training',
      'That the model can generate counterfactual explanations',
    ],
    correctAnswer: 1,
    explanation:
      'Counterfactual fairness (Kusner et al., 2017) requires that a model prediction for an individual would be the same in a counterfactual world where the individual sensitive attribute (e.g., race, gender) had been different, while all other non-descendant variables remain the same. This requires a causal model of the data-generating process.',
    tags: ['fairness', 'counterfactual-fairness', 'causal-inference'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-003',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'In differential privacy, what is the composition theorem and why is it important?',
    options: [
      'It describes how to compose multiple neural network layers',
      'It quantifies how privacy loss accumulates when multiple differentially private mechanisms are applied to the same dataset',
      'It explains how to combine multiple datasets',
      'It defines how to compose multiple loss functions',
    ],
    correctAnswer: 1,
    explanation:
      'The composition theorem states that the total privacy loss from running k differentially private mechanisms on the same data accumulates. Under basic composition, the total epsilon is the sum of individual epsilons. Advanced composition provides tighter bounds, growing as O(sqrt(k) * epsilon). This is critical for managing the overall privacy budget in iterative algorithms like training neural networks with DP-SGD.',
    tags: ['privacy', 'differential-privacy', 'composition-theorem'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-004',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'How does DP-SGD (Differentially Private Stochastic Gradient Descent) achieve differential privacy during model training?',
    options: [
      'By encrypting the model weights after each update',
      'By clipping per-sample gradients to a maximum norm and adding calibrated Gaussian noise to the aggregated gradient before updating model parameters',
      'By training on anonymized data only',
      'By limiting the number of training epochs',
    ],
    correctAnswer: 1,
    explanation:
      'DP-SGD achieves differential privacy by: (1) computing per-sample gradients, (2) clipping each gradient to a maximum L2 norm to bound sensitivity, (3) aggregating the clipped gradients, and (4) adding Gaussian noise calibrated to the clipping threshold and desired privacy budget. The privacy cost is tracked using privacy accounting methods like the moments accountant.',
    tags: ['privacy', 'DP-SGD', 'differential-privacy', 'training'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-005',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'What is Renyi Differential Privacy (RDP) and what advantage does it provide over standard (epsilon, delta)-differential privacy?',
    options: [
      'RDP is a weaker privacy guarantee that is faster to compute',
      'RDP uses Renyi divergence to provide tighter composition bounds, enabling more accurate privacy accounting for iterative mechanisms',
      'RDP eliminates the need for the delta parameter entirely',
      'RDP only applies to linear models',
    ],
    correctAnswer: 1,
    explanation:
      'Renyi Differential Privacy (RDP) defines privacy using Renyi divergence of order alpha. It provides tighter privacy composition bounds compared to standard advanced composition, which is particularly important for iterative mechanisms like DP-SGD where many gradient steps are applied. RDP can be converted back to (epsilon, delta)-DP for final reporting.',
    tags: ['privacy', 'RDP', 'differential-privacy', 'privacy-accounting'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-006',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Explainability',
    question:
      'What is the computational complexity challenge with exact SHAP value computation, and how is it addressed in practice?',
    options: [
      'SHAP values can always be computed in linear time',
      'Computing exact SHAP values requires evaluating all 2^n feature subsets, so approximations like KernelSHAP or model-specific algorithms like TreeSHAP are used',
      'SHAP values only work with small models',
      'SHAP computation is always O(n log n)',
    ],
    correctAnswer: 1,
    explanation:
      'Exact SHAP value computation requires evaluating the model for all 2^n possible feature subsets, which is exponential and intractable for models with many features. KernelSHAP uses a weighted sampling approach, while TreeSHAP exploits the tree structure for polynomial-time computation in tree-based models. DeepSHAP adapts DeepLIFT for neural networks.',
    tags: ['explainability', 'SHAP', 'computational-complexity', 'TreeSHAP'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-007',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Explainability',
    question:
      'How does Grad-CAM++ improve upon the original Grad-CAM for visual explanations?',
    options: [
      'It uses a completely different algorithm unrelated to gradients',
      'It uses pixel-wise weighting of gradients using second and third-order derivatives, providing better localization for multiple instances of the same class',
      'It only works with recurrent neural networks',
      'It removes the need for backpropagation entirely',
    ],
    correctAnswer: 1,
    explanation:
      'Grad-CAM++ improves upon Grad-CAM by using a weighted combination of positive partial derivatives of the class score with respect to the feature maps. It leverages higher-order gradients to compute pixel-wise weights, providing better localization especially when multiple instances of the same object class appear in the image.',
    tags: ['explainability', 'Grad-CAM', 'Grad-CAM++', 'visual-explanations'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-008',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Bias Mitigation',
    question:
      'What is the "fairness through awareness" framework and what does it require?',
    options: [
      'Simply being aware that bias exists in the data',
      'A framework requiring a task-specific similarity metric where similar individuals receive similar outcomes, formalized as a Lipschitz condition on the mapping from individuals to distributions over outcomes',
      'Logging all predictions for fairness auditing',
      'Training separate models for each demographic group',
    ],
    correctAnswer: 1,
    explanation:
      'Fairness through awareness (Dwork et al., 2012) formalizes individual fairness as a Lipschitz condition: the distance between the outcome distributions for two individuals should be bounded by their distance under a task-specific similarity metric. The key challenge is defining an appropriate similarity metric, which requires domain expertise.',
    tags: ['fairness', 'individual-fairness', 'Lipschitz-condition', 'similarity-metric'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-009',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Bias Mitigation',
    question:
      'What is the "learning fair representations" approach to bias mitigation?',
    options: [
      'Using representation learning to find data encodings that are useful for downstream tasks but invariant to protected attributes',
      'Training separate encoders for each protected group',
      'Using only fair features selected by domain experts',
      'Applying PCA to remove bias from the data',
    ],
    correctAnswer: 0,
    explanation:
      'Learning fair representations (Zemel et al., 2013) uses an autoencoder-like framework to learn intermediate representations that preserve information useful for classification while being invariant to protected attributes. This is typically achieved by including a fairness regularization term in the loss function alongside reconstruction and prediction objectives.',
    tags: ['bias-mitigation', 'representation-learning', 'in-processing'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-010',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Adversarial Attacks',
    question:
      'What is a backdoor attack in machine learning, and how does it differ from standard data poisoning?',
    options: [
      'A backdoor attack and data poisoning are identical concepts',
      'A backdoor attack inserts a trigger pattern into poisoned training data so the model behaves normally on clean inputs but produces attacker-chosen outputs when the trigger is present',
      'A backdoor attack only targets the model deployment infrastructure',
      'A backdoor attack modifies the model architecture, not the training data',
    ],
    correctAnswer: 1,
    explanation:
      'A backdoor attack is a specific form of data poisoning where the adversary inserts a trigger pattern (e.g., a small patch in images) into a subset of training samples and relabels them. The trained model performs normally on clean inputs but produces the attacker desired output whenever the trigger is present. This makes backdoors particularly stealthy compared to general data poisoning.',
    tags: ['adversarial-attacks', 'backdoor-attacks', 'data-poisoning'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-011',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Adversarial Attacks',
    question:
      'What is certified adversarial robustness and how does randomized smoothing achieve it?',
    options: [
      'A guarantee that is validated through empirical testing only',
      'A provable guarantee that no adversarial perturbation within a certain radius can change the prediction, achieved by classifying based on the most probable class under Gaussian noise perturbations of the input',
      'A certificate issued by a regulatory body confirming the model is robust',
      'A technique that only works for decision tree models',
    ],
    correctAnswer: 1,
    explanation:
      'Certified adversarial robustness provides a mathematical proof that no perturbation within a specified L2 ball can change the prediction. Randomized smoothing achieves this by creating a smoothed classifier that returns the class most likely to be predicted when Gaussian noise is added to the input. The certification radius depends on the gap between the top two class probabilities under the noise distribution.',
    tags: ['adversarial-attacks', 'certified-robustness', 'randomized-smoothing'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-012',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Regulation',
    question:
      'Under the EU AI Act, what specific obligations apply to providers of high-risk AI systems?',
    options: [
      'Only publishing the source code',
      'Implementing risk management systems, ensuring data governance, maintaining technical documentation, providing transparency to users, enabling human oversight, and ensuring accuracy, robustness, and cybersecurity',
      'Simply registering the AI system with a national authority',
      'Only conducting annual audits',
    ],
    correctAnswer: 1,
    explanation:
      'Providers of high-risk AI systems under the EU AI Act must: establish risk management systems throughout the AI lifecycle, ensure training data quality and governance, maintain detailed technical documentation, provide transparency and information to users, enable human oversight, and meet standards for accuracy, robustness, and cybersecurity. They must also implement a quality management system and conduct conformity assessments.',
    tags: ['regulation', 'EU-AI-Act', 'high-risk', 'compliance-requirements'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-013',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Regulation',
    question:
      'How does the EU AI Act classify general-purpose AI (GPAI) models, and what additional obligations apply to GPAI with systemic risk?',
    options: [
      'All GPAI models are banned under the Act',
      'All GPAI providers must maintain documentation and comply with copyright law; GPAI with systemic risk must additionally perform model evaluations, assess and mitigate systemic risks, conduct adversarial testing, and report serious incidents',
      'GPAI models are exempt from the EU AI Act entirely',
      'Only open-source GPAI models face additional obligations',
    ],
    correctAnswer: 1,
    explanation:
      'The EU AI Act requires all GPAI providers to maintain technical documentation, provide transparency information, and comply with EU copyright law. GPAI models classified as having systemic risk (e.g., trained with compute exceeding 10^25 FLOPs) face additional obligations including model evaluations, systemic risk assessment and mitigation, adversarial testing (red teaming), and reporting serious incidents to authorities.',
    tags: ['regulation', 'EU-AI-Act', 'GPAI', 'systemic-risk'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-014',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Red Teaming',
    question:
      'What is the "crescendo" attack pattern in LLM red teaming?',
    options: [
      'Gradually increasing the model temperature during generation',
      'Gradually escalating the severity of requests across a multi-turn conversation to incrementally push the model past its safety boundaries',
      'Increasing the input token length until the model fails',
      'Sending multiple parallel requests to overwhelm the model',
    ],
    correctAnswer: 1,
    explanation:
      'The crescendo attack pattern involves gradually escalating requests across multiple conversation turns, starting with benign queries and progressively moving toward harmful content. Each turn slightly pushes the boundary, exploiting the model tendency to maintain conversational consistency and making it incrementally more likely to comply with harmful requests.',
    tags: ['red-teaming', 'LLM', 'crescendo-attack', 'multi-turn'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-015',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'What is secure aggregation in federated learning, and what privacy guarantees does it provide?',
    options: [
      'Encrypting the final model before deployment',
      'A cryptographic protocol that allows a server to compute the aggregate of client model updates without learning any individual client update',
      'Using SSL/TLS for communication between clients and server',
      'Averaging model updates in plaintext on the server',
    ],
    correctAnswer: 1,
    explanation:
      'Secure aggregation is a cryptographic protocol used in federated learning where clients encrypt their model updates in a way that allows the server to compute only the aggregate (e.g., sum or average) without learning any individual client contribution. This prevents the server from performing gradient inversion attacks on individual updates. Common implementations use secret sharing or homomorphic encryption.',
    tags: ['privacy', 'federated-learning', 'secure-aggregation', 'cryptography'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-016',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Explainability',
    question:
      'What is the problem of "explanation faithfulness" and why do some post-hoc methods fail at it?',
    options: [
      'Explanations that are too long for humans to read',
      'The concern that post-hoc explanations may not accurately reflect the actual reasoning process of the model, instead providing plausible but incorrect justifications',
      'The problem of generating explanations in multiple languages',
      'The cost of computing explanations being too high',
    ],
    correctAnswer: 1,
    explanation:
      'Explanation faithfulness refers to whether an explanation accurately represents the true decision-making process of the model. Post-hoc methods like LIME can produce explanations that are locally inaccurate due to sampling variance, kernel function choice, or the gap between the simple surrogate and the true model. Unfaithful explanations can be misleading and dangerous, especially in high-stakes applications.',
    tags: ['explainability', 'faithfulness', 'post-hoc', 'limitations'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-017',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Fairness',
    question:
      'What is the Rawlsian approach to algorithmic fairness (minimax fairness)?',
    options: [
      'Maximizing overall accuracy across all groups',
      'Optimizing model performance for the worst-off group, ensuring the minimum performance across all groups is maximized',
      'Treating all groups identically regardless of context',
      'Randomly assigning outcomes to ensure statistical independence',
    ],
    correctAnswer: 1,
    explanation:
      'Minimax fairness, inspired by Rawls theory of justice (maximin principle), optimizes for the worst-off group by maximizing the minimum performance (e.g., accuracy, recall) across all demographic groups. This approach does not require the same performance for all groups but ensures that no group is disproportionately harmed.',
    tags: ['fairness', 'minimax', 'Rawlsian', 'worst-case'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-018',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Bias Mitigation',
    question:
      'What is the "calibrated equalized odds" post-processing method, and how does it work?',
    options: [
      'A method that recalibrates model confidence scores',
      'A method that finds optimal probability thresholds for each group by solving a linear program to satisfy equalized odds while maintaining calibration within groups',
      'A method that trains separate calibrated models for each group',
      'A method that removes all calibration from the model',
    ],
    correctAnswer: 1,
    explanation:
      'Calibrated equalized odds (Pleiss et al., 2017) is a post-processing approach that adjusts the model predicted probabilities for each group to satisfy equalized odds while preserving calibration within each group. It optimizes group-specific thresholds or randomization parameters through a constrained optimization (linear program) that minimizes a cost function subject to equalized odds constraints.',
    tags: ['bias-mitigation', 'post-processing', 'calibrated-equalized-odds'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-019',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Adversarial Attacks',
    question:
      'What is the Carlini & Wagner (C&W) attack, and why is it considered stronger than FGSM and PGD?',
    options: [
      'C&W is faster but less effective than FGSM',
      'C&W formulates adversarial example generation as an optimization problem that minimizes perturbation size while ensuring misclassification, often defeating defenses like defensive distillation',
      'C&W only works on text data',
      'C&W is an ensemble of FGSM and PGD attacks',
    ],
    correctAnswer: 1,
    explanation:
      'The Carlini & Wagner attack formulates adversarial example generation as an optimization problem that directly minimizes the Lp norm of the perturbation subject to a misclassification constraint. It uses a carefully designed objective function and optimizer to find minimal perturbations. C&W is considered stronger because it can defeat defenses like defensive distillation that are effective against simpler attacks like FGSM.',
    tags: ['adversarial-attacks', 'C&W', 'optimization-based', 'robustness'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-020',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'What is the difference between local and global differential privacy?',
    options: [
      'Local DP applies to local models, global DP applies to cloud models',
      'In local DP, each individual randomizes their own data before sharing; in global DP, a trusted curator collects raw data and applies noise to the output, providing better utility for the same privacy level',
      'Local DP is weaker than global DP in all scenarios',
      'There is no meaningful difference between local and global DP',
    ],
    correctAnswer: 1,
    explanation:
      'In local differential privacy (LDP), each individual perturbs their own data before sending it to the curator, requiring no trusted party but resulting in lower utility. In global (central) differential privacy, a trusted curator collects raw data and adds noise only to the aggregate output. Global DP provides significantly better utility-privacy trade-offs (by a factor of sqrt(n)) but requires trusting the curator.',
    tags: ['privacy', 'differential-privacy', 'local-DP', 'global-DP'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-021',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Governance',
    question:
      'What is "algorithmic recourse" and why is it important for responsible AI governance?',
    options: [
      'The ability to revert a deployed model to a previous version',
      'The ability of individuals affected by algorithmic decisions to understand what actions they can take to obtain a more favorable outcome in the future',
      'The legal process for suing an AI company',
      'The process of recycling old AI models',
    ],
    correctAnswer: 1,
    explanation:
      'Algorithmic recourse refers to providing individuals who receive unfavorable automated decisions with actionable steps they can take to change the outcome. It is closely related to counterfactual explanations but focuses on feasible, actionable changes. It is important for governance because it ensures individuals are not trapped by algorithmic decisions and have agency to improve their situation.',
    tags: ['governance', 'algorithmic-recourse', 'counterfactuals', 'agency'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-022',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Explainability',
    question:
      'What is the stability problem with LIME explanations, and what causes it?',
    options: [
      'LIME always produces identical explanations for the same input',
      'LIME explanations can vary significantly across runs for the same input due to the random sampling of perturbations and the sensitivity of the local linear approximation to the sampled neighborhood',
      'LIME is unstable because it modifies the original model',
      'LIME only works with stable models',
    ],
    correctAnswer: 1,
    explanation:
      'LIME explanations can be unstable across runs because the method relies on random sampling of perturbations around the input. Different samples can lead to different local neighborhoods being explored, resulting in different linear approximations and thus different feature importance rankings. This instability undermines trust in the explanations and can be mitigated by increasing sample size, using deterministic sampling, or applying BayLIME.',
    tags: ['explainability', 'LIME', 'stability', 'limitations'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-023',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Environmental Impact',
    question:
      'How is the carbon footprint of training a large AI model typically estimated?',
    options: [
      'By counting the number of model parameters only',
      'By estimating total energy consumption (GPU hours x power consumption x PUE) and multiplying by the carbon intensity of the electricity grid where training occurs',
      'By measuring the physical weight of the servers used',
      'By counting the number of training examples processed',
    ],
    correctAnswer: 1,
    explanation:
      'The carbon footprint is estimated as: CO2 = Energy x Carbon Intensity. Energy is calculated from GPU hours, hardware power draw, and the Power Usage Effectiveness (PUE) of the data center. This is then multiplied by the carbon intensity (g CO2/kWh) of the local electricity grid. Strubell et al. (2019) highlighted that training a large transformer can emit as much CO2 as five cars over their lifetimes.',
    tags: ['environmental-impact', 'carbon-footprint', 'energy-consumption'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-024',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Red Teaming',
    question:
      'What is automated red teaming using LLMs, and what are its advantages and limitations compared to human red teaming?',
    options: [
      'Using LLMs to automatically generate adversarial test cases, which scales better than human red teaming but may miss novel attack vectors that require human creativity and domain expertise',
      'Replacing all human testers with AI systems permanently',
      'Using LLMs only to summarize human red team findings',
      'Automated red teaming is always superior to human red teaming',
    ],
    correctAnswer: 0,
    explanation:
      'Automated red teaming uses LLMs to generate diverse adversarial prompts at scale, discovering potential vulnerabilities more efficiently than manual testing. Advantages include scalability, consistency, and breadth of coverage. Limitations include potential blind spots (automated systems may not discover novel attack categories), lack of real-world context that human testers bring, and the risk of automation bias. Best practice combines both approaches.',
    tags: ['red-teaming', 'automated-testing', 'LLM', 'scalability'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-025',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Fairness',
    question:
      'What is "intersectional fairness" and why does it present additional challenges beyond single-attribute fairness?',
    options: [
      'Fairness for intersection roads in autonomous driving',
      'Considering fairness across combinations of protected attributes (e.g., race and gender simultaneously), which is challenging due to exponential growth of subgroups and sparse data within intersections',
      'Ensuring fairness at the intersection of training and test data',
      'A fairness metric that only applies to binary classification',
    ],
    correctAnswer: 1,
    explanation:
      'Intersectional fairness (Buolamwini & Gebru, 2018; Kearns et al., 2018) examines fairness across combinations of multiple protected attributes simultaneously. Challenges include: exponential growth of subgroups (e.g., race x gender x age), data sparsity within intersectional groups making reliable estimation difficult, and the fact that a model can appear fair on each attribute individually while being unfair for specific intersections (gerrymandering).',
    tags: ['fairness', 'intersectionality', 'subgroup-fairness'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-026',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'What is a gradient inversion attack in federated learning, and what defenses exist against it?',
    options: [
      'An attack that reverses the gradient descent optimization',
      'An attack that reconstructs training data from shared gradients by optimizing a dummy input to produce matching gradients, defended against by secure aggregation, differential privacy noise, and gradient compression',
      'An attack that changes the gradient direction to slow training',
      'An attack that only works on models without gradient computation',
    ],
    correctAnswer: 1,
    explanation:
      'Gradient inversion attacks (Zhu et al., 2019) reconstruct private training data by optimizing a random dummy input such that its gradient matches the shared gradient from a client. This can recover high-fidelity images and text. Defenses include: secure aggregation (hiding individual gradients), adding differential privacy noise to gradients, gradient compression/sparsification, and increasing batch sizes to make inversion harder.',
    tags: ['privacy', 'federated-learning', 'gradient-inversion', 'attacks'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-027',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Explainability',
    question:
      'What are integrated gradients, and what axioms do they satisfy that standard gradient-based attribution methods do not?',
    options: [
      'Integrated gradients average gradients across training epochs',
      'Integrated gradients accumulate gradients along a straight-line path from a baseline to the input, satisfying the completeness axiom (attributions sum to the prediction difference) and sensitivity (non-zero attribution for features that influence the output)',
      'Integrated gradients integrate over the model architecture',
      'Integrated gradients only work with recurrent neural networks',
    ],
    correctAnswer: 1,
    explanation:
      'Integrated gradients (Sundararajan et al., 2017) compute attributions by integrating the gradients of the model output with respect to the input along a straight-line path from a baseline (e.g., zero input) to the actual input. They uniquely satisfy two axioms: sensitivity (if a feature changes the output, it receives non-zero attribution) and implementation invariance (attributions are the same for functionally equivalent networks). They also satisfy completeness, meaning attributions sum exactly to the prediction minus the baseline prediction.',
    tags: ['explainability', 'integrated-gradients', 'axioms', 'attribution'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-028',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Governance',
    question:
      'What is a "regulatory sandbox" for AI, and how does it function?',
    options: [
      'A sandboxed computing environment for training AI models',
      'A controlled environment established by regulators where AI innovators can test novel AI systems under regulatory supervision with relaxed requirements, providing real-world feedback for both innovation and regulation',
      'A database of all AI regulations worldwide',
      'A children playground with AI-powered equipment',
    ],
    correctAnswer: 1,
    explanation:
      'AI regulatory sandboxes are controlled environments where companies can develop, test, and validate innovative AI systems under the supervision of regulators, with temporarily relaxed regulatory requirements. The EU AI Act explicitly provides for such sandboxes. They allow regulators to understand emerging technologies while providing innovators guidance, and the findings inform future regulations.',
    tags: ['governance', 'regulatory-sandbox', 'EU-AI-Act', 'innovation'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-029',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Bias Mitigation',
    question:
      'What is the "exponentiated gradient" approach to fair classification (Agarwal et al., 2018)?',
    options: [
      'Using exponential activation functions in neural networks',
      'A reduction approach that converts fair classification into a sequence of cost-sensitive classification problems, using an exponentiated gradient optimizer to find the best trade-off between accuracy and multiple fairness constraints',
      'Applying exponential smoothing to gradient updates',
      'A technique that exponentially increases the training dataset size',
    ],
    correctAnswer: 1,
    explanation:
      'The exponentiated gradient approach (Agarwal et al., 2018) frames fair classification as a constrained optimization problem and reduces it to a sequence of cost-sensitive classification problems. It uses a two-player game formulation where a Learner minimizes error and a Auditor enforces fairness constraints, solved via an exponentiated gradient algorithm. This approach supports multiple fairness constraints simultaneously and works with any base classifier.',
    tags: ['bias-mitigation', 'in-processing', 'exponentiated-gradient', 'constrained-optimization'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-030',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Adversarial Attacks',
    question:
      'What is model extraction (model stealing), and what are its implications for responsible AI?',
    options: [
      'Extracting features from a model for transfer learning',
      'Reconstructing a functionally equivalent copy of a proprietary model by querying its API, threatening intellectual property, enabling adversarial attack creation, and bypassing safety measures',
      'Removing unnecessary layers from a model to reduce its size',
      'Extracting the training code from a repository',
    ],
    correctAnswer: 1,
    explanation:
      'Model extraction attacks reconstruct a functionally equivalent model by systematically querying a target model API and training a substitute. Implications include: IP theft of proprietary models, enabling efficient white-box adversarial attacks against the original model, bypassing safety guardrails by analyzing the stolen model, and undermining API-based access controls. Defenses include query rate limiting, watermarking, and monitoring for suspicious query patterns.',
    tags: ['adversarial-attacks', 'model-extraction', 'IP-theft', 'security'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-031',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Responsible Deployment',
    question:
      'What is the concept of "machine unlearning" and why is it relevant to responsible AI deployment?',
    options: [
      'Reducing model performance intentionally',
      'The ability to remove the influence of specific training data points from a trained model without full retraining, relevant for GDPR right to erasure and removing biased or poisoned data',
      'Forgetting previous model versions in a registry',
      'Uninstalling machine learning software',
    ],
    correctAnswer: 1,
    explanation:
      'Machine unlearning refers to techniques that remove the influence of specific data points from a trained model, ideally producing results indistinguishable from retraining from scratch without that data. This is crucial for GDPR compliance (right to erasure), removing poisoned data, and correcting for biased training examples. Exact unlearning is computationally expensive; approximate methods trade completeness for efficiency.',
    tags: ['deployment', 'machine-unlearning', 'GDPR', 'data-removal'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-032',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Ethics',
    question:
      'What is the "value alignment" challenge for RLHF-trained models, and what are known failure modes?',
    options: [
      'RLHF models always perfectly align with human values',
      'RLHF can lead to sycophancy (telling users what they want to hear), reward hacking (optimizing for the reward model rather than true preferences), and encoding the biases of the annotator population rather than broader human values',
      'RLHF eliminates all biases from the model',
      'RLHF only affects model training speed, not values',
    ],
    correctAnswer: 1,
    explanation:
      'RLHF faces several value alignment challenges: sycophancy (models learn to agree with users rather than be truthful), reward hacking (exploiting flaws in the reward model), distribution of annotator values (reflecting the biases and preferences of a limited annotator pool), specification gaming, and the difficulty of capturing nuanced human values in scalar reward signals. These issues mean RLHF-trained models can appear aligned while having subtle misalignment.',
    tags: ['ethics', 'RLHF', 'value-alignment', 'failure-modes'],
  },
  {
    id: 'ai-engineer-responsible-ai-l3-033',
    language: 'ai-engineer',
    level: 'level3',
    category: 'Responsible AI',
    subcategory: 'Privacy',
    question:
      'What is homomorphic encryption and how can it be applied to privacy-preserving machine learning inference?',
    options: [
      'A method for compressing encrypted data',
      'An encryption scheme that allows computation on encrypted data without decryption, enabling models to perform inference on encrypted inputs and return encrypted results that only the data owner can decrypt',
      'A technique for encrypting model weights during training',
      'A method that converts all data to the same format before encryption',
    ],
    correctAnswer: 1,
    explanation:
      'Fully homomorphic encryption (FHE) allows mathematical operations to be performed directly on ciphertexts, producing encrypted results that, when decrypted, match the result of the operations on the plaintext. For ML inference, a client can send encrypted data to a server running the model, which computes on the encrypted data and returns encrypted predictions. The server never sees the raw data. Challenges include high computational overhead (orders of magnitude slower) and limited supported operations.',
    tags: ['privacy', 'homomorphic-encryption', 'encrypted-inference', 'cryptography'],
  },
];
export default questions;
