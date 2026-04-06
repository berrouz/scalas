package org.shevchyk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Stream;

public class HashMapUtils {
    public static void main(String[] args) {
        TreeSet<Map.Entry<String, Integer>> set =
                new TreeSet<>(Map.Entry.comparingByKey());

        new HashMap<>().entrySet();

        Comparator<Map.Entry<String, Integer>> c = (o1, o2) -> (o1.getKey().equals(o2.getKey())) ?
                    o1.getValue().compareTo(o2.getValue()) :o1.getKey().compareTo(o2.getKey());

        Stream<String> result = set.descendingSet().stream().map(Map.Entry::getKey);

        result.toList();
    }


}
