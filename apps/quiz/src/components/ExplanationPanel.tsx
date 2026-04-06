import CodeBlock from './CodeBlock';
import GrammarRuleBox from './GrammarRuleBox';
import ExampleSentence from './ExampleSentence';

interface ExplanationPanelProps {
  explanation: string;
  codeSnippet?: string;
  language?: string;
  exampleSentence?: string;
  grammarRule?: string;
}

export default function ExplanationPanel({ explanation, codeSnippet, language, exampleSentence, grammarRule }: ExplanationPanelProps) {
  const isGerman = language === 'german';
  return (
    <div className="mt-4 p-4 bg-blue-900/30 border border-blue-700/50 rounded-lg">
      <h4 className="text-blue-400 font-semibold mb-2">{isGerman ? 'Erklärung' : 'Explanation'}</h4>
      <p className="text-gray-300 leading-relaxed">{explanation}</p>
      {codeSnippet && <CodeBlock code={codeSnippet} language={language} />}
      {grammarRule && <GrammarRuleBox rule={grammarRule} />}
      {exampleSentence && <ExampleSentence sentence={exampleSentence} />}
    </div>
  );
}
