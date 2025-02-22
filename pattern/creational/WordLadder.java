package creational;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String start, String target, Set<String> dictionary) {
        if (start.equals(target)) {
            return 1;
        }

        Set<String> dict = new HashSet<>(dictionary);
        if (!dict.contains(target)) {
            return 0; // According to problem statement, this case shouldn't happen
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] arr = current.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'A'; c <= 'Z'; c++) {
                        if (c == original) {
                            continue;
                        }
                        arr[j] = c;
                        String variation = new String(arr);
                        if (variation.equals(target)) {
                            return level + 1;
                        }
                        if (dict.contains(variation)) {
                            queue.add(variation);
                            dict.remove(variation);
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }

        return 0;
    }


    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList("POON", "PLEE", "SAME", "POIE", "PLIE", "PLEA", "PLIN"));
        String start = "TOON";
        String target = "PLEA";

        int result = ladderLength(start, target, dictionary);
        System.out.println("Shortest transformation length: " + result);
    }
}

