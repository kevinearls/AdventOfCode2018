package com.kevinearls.adventofcode2018.inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagement {
    /**
     * To make sure you didn't miss any, you scan the likely candidate boxes again,
     * counting the number that have an ID containing exactly two of any letter
     * and then separately counting those with exactly three of any letter. You
     * can multiply those two counts together to get a rudimentary checksum and
     * compare it to what your device predicts.
     *
     * For example, if you see the following box IDs:
     *
     * abcdef contains no letters that appear exactly two or three times.
     * bababc contains two a and three b, so it counts for both.
     * abbcde contains two b, but no letter appears exactly three times.
     * abcccd contains three c, but no letter appears exactly two times.
     * aabcdd contains two a and two d, but it only counts once.
     * abcdee contains two e.
     * ababab contains three a and three b, but it only counts once.
     *
     * Of these box IDs, four of them contain a letter which appears exactly twice,
     * and three of them contain a letter which appears exactly three times.
     * Multiplying these together produces a checksum of 4 * 3 = 12.
     */
    public int calculateCheckSum(List<String> input) {
        int occursTwice = 0;
        int occursThreeTimes = 0;

        for (String s : input) {
            s = s.trim();
            boolean twice = false;
            boolean thrice = false;
            Map<String, Integer> occurences = new HashMap<>();

            for (Character c : s.toCharArray()) {
                String c1 = String.valueOf(c);
                if (occurences.containsKey(c1)) {
                    Integer count = occurences.get(c1);
                    count++;
                    occurences.put(c1, count);
                } else {
                    occurences.put(c1, 1);
                }
            }

            for (String key : occurences.keySet()) {
                Integer value = occurences.get(key);
                if (value.equals(2)) {
                    twice = true;
                } else if (value.equals(3)) {
                    thrice = true;
                }
            }

            if (twice) {
                occursTwice++;
            }
            if (thrice) {
                occursThreeTimes++;
            }
        }

        return occursThreeTimes * occursTwice;
    }

    /*
    Confident that your list of box IDs is complete, you're ready to find the
    boxes full of prototype fabric.

    The boxes will have IDs which differ by exactly one character at the same position
    in both strings. For example, given the following box IDs:

    abcde
    fghij
    klmno
    pqrst
    fguij
    axcye
    wvxyz

        The IDs abcde and axcye are close, but they differ by two characters (the second and fourth).
        However, the IDs fghij and fguij differ by exactly one character, the third (h and u). Those must be the correct boxes.

        What letters are common between the two correct box IDs? (In the example above, this is found by
        removing the differing character from either ID, producing fgij.)
     */
    public String differByOne(List<String> input) {
        int currentPosition = 0;        // TODO rename
        for (String target : input) {
            target = target.trim();
            currentPosition++;
            List<String> remainder = input.subList(currentPosition, input.size());

            for (String r : remainder) {
                r = r.trim();
                int differences = 0;
                if (r.length() == target.length()) {
                    for (int i = 0; i < target.length(); i++) {
                        if (target.charAt(i) != r.charAt(i)) {
                            differences++;
                        }
                    }

                    String common = "";
                    if (differences == 1) {
                        System.out.println("FOUND IT! target [" + target + "] and r [" + r + "]");
                        for (int i = 0; i < target.length(); i++) {
                            if (target.charAt(i) == r.charAt(i)) {
                                common += target.charAt(i);
                            }
                        }
                        System.out.println("COMMON: [" + common + "]");
                        return common;
                    }
                }
            }
        }

        return "";
    }


    /**
     * Load data from a file on the classpath.  TODO make this a global utility
     *
     * @param filename
     * @return
     * @throws Exception
     */
    public List<String> loadFromFile(String filename) throws Exception {
        List<String> contents = new ArrayList<>();
        File target = Paths.get(getClass().getClassLoader().getResource(filename).toURI()).toFile();
        BufferedReader br = new BufferedReader(new FileReader(target));

        String line = br.readLine();
        while (line != null) {
            contents.add(line.trim());
            line = br.readLine();
        }

        return contents;
    }
}
