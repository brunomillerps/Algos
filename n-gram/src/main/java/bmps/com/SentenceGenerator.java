package bmps.com;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

public class SentenceGenerator {

    private final String REGEX_ALPHANUMERIC = "^[a-zA-Z0-9]*$";
    private Map<String, List<String>> n_gram = new HashMap<>();

    public String generate(int number_word) {
        final List<String[]> sentences = new ArrayList<>();

        sentences.add(
                "However, external caches come with their own set of shortcomings to consider. The first is an increased overall system complexity and operational load, since there is an additional fleet to monitor, manage, and scale. The availability characteristics of the cache fleet will be different from the dependent service it is acting as a cache for. The cache fleet can often be less available, for example, if it doesn’t have support for zero-downtime upgrades and if it requires maintenance windows.".split(" ")
        );

        sentences.add(
                "As we can see, we have the readability-performance tradeoff. More readable and more declarative solutions tend to be less performant. At the same time, please note that unnecessary optimization may do more harm than good. Thus, for most applications, regex is a good and clean solution that can be easily extended.".split(" ")
        );

        sentences.add(
                "Bringing Wide & Deep from idea, research to implementation has been a huge team effort. We'd to like to thank all the people who have contributed to the project or have given us advice, including: Heng-Tze Cheng, Mustafa Ispir, Zakaria Haque, Lichan Hong, Rohan Anil, Denis Baylor, Vihan Jain, Salem Haykal, Robson Araujo, Xiaobing Liu, Yonghui Wu, Thomas Strohmann, Tal Shaked, Jeremiah Harmsen, Greg Corrado, Glen Anderson, D. Sculley, Tushar Chandra, Ed Chi, Rajat Monga, Rob von Behren, Jarek Wilkiewicz, Christine Robson, Illia Polosukhin, Martin Wicke, Gus Katsiapis, Alexandre Passos, Olivier Chapelle, Levent Koc, Akshay Naresh Modi, Wei Chai, Hrishi Aradhye, Othar Hansson, Xinran He, Martin Zinkevich, Joe Toth, Anton Rusanov, Hemal Shah, Petros Mol, Frank Li, Yutaka Suematsu, Sameer Ahuja, Eugene Brevdo, Philip Tucker, Shanqing Cai, Kester Tong, and more.".split(" ")
        );

        sentences.add(
                "As we add capacity to the cache fleet, we take care to do so in a way that doesn't cause an outage or a massive loss of cache data. Different caching technologies have unique considerations. For example, some cache servers don't support adding nodes to a cluster without downtime, and not all cache client libraries provide consistent hashing, which is necessary to add nodes to the cache fleet and redistribute cached data. Due to the variability in client implementations of consistent hashing and the discovery of nodes in the cache fleet, we thoroughly test adding and removing cache servers before going to production.".split(" ")
        );

        sentences.add(
                "Another decision we need to make when we evaluate different caching approaches is the choice between inline and side caches. Inline caches, or read-through/write-through caches, embed cache management into the main data access API, making cache management an implementation detail of that API. Examples include application-specific implementations like Amazon DynamoDB Accelerator (DAX) and standards-based implementations like HTTP caching (either with a local caching client or an external cache server like Nginx or Varnish). Side caches, in contrast, are generic object stores such as the ones provided by Amazon ElastiCache (Memcached and Redis) or libraries like Ehcache and Google Guava for in-memory caches. With side caches, the application code directly manipulates the cache before and after calls to the data source, checking for cached objects before making the downstream calls, and putting objects in the cache after those calls are completed.".split(" ")
        );

        for (String[] sentence : sentences) {
            if (!sentence[0].matches(REGEX_ALPHANUMERIC)) {
                continue;
            }

            for (int i = 0; i < sentence.length - 1; i++) {
                n_gram.putIfAbsent(sentence[i], new ArrayList<>());
                n_gram.get(sentence[i]).add(sentence[i + 1]);
            }
        }

        List<String> wordsChoose = new ArrayList<>(n_gram.keySet());

        Random random = new Random();
        var next_random = random.nextInt(n_gram.keySet().size());
        var next_word = wordsChoose.get(next_random);

        List<String> words = new ArrayList<>();
        words.add(next_word);

        while(words.size() < number_word) {
            next_random = random.nextInt(n_gram.get(next_word).size());
            next_word = n_gram.get(next_word).get(next_random);
            words.add(next_word);
        }

        return String.join(" ", words);
    }
}
