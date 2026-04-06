import { Question, Language } from '@/types/question';
import { languages, isMultiLevelLanguage, getMultiLevelCategories } from '@/data/registry';

export async function loadAllQuestions(language: string, levelSlug?: string): Promise<Question[]> {
  if (isMultiLevelLanguage(language)) {
    if (!levelSlug) return [];
    const categories = getMultiLevelCategories(language);
    const imports = categories.flatMap((cat) =>
      Array.from({ length: cat.parts! }, (_, i) =>
        import(`@/data/${language}/${levelSlug}/${cat.slug}/part${i + 1}`)
          .then((mod) => (mod.default || mod.questions || []) as Question[])
          .catch(() => [] as Question[])
      )
    );
    const results = await Promise.all(imports);
    return results.flat();
  }

  const lang = languages.find((l) => l.slug === language);
  if (!lang) return [];

  const levels = ['level1', 'level2', 'level3', 'level4'];
  const imports = lang.categories.flatMap((cat) =>
    levels.map((level) =>
      import(`@/data/${language}/${cat.slug}/${level}`)
        .then((mod) => (mod.default || mod.questions || []) as Question[])
        .catch(() => [] as Question[])
    )
  );
  const results = await Promise.all(imports);
  return results.flat();
}
