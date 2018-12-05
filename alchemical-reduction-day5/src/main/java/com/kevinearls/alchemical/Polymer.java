package com.kevinearls.alchemical;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Polymer {
    public int react(String input) {
        List<String> content = new LinkedList<>(Arrays.asList(input.split("")));

        int position = 0;
        String current = "";
        String next = "";
        while (position < content.size() - 1) { // TODO or length - 1?
            current = content.get(position);
            next = content.get(position + 1);

            if ((!current.equals(next)) && (current.equalsIgnoreCase(next))) {
                content.remove(position);
                content.remove(position);
                if (position > 0) {
                    position--;
                }
            } else {
                position++;
            }
        }

        return content.size();
    }

    // For part 2
    public int improvedReact(String input) {
        int shortestLength = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++ ) {
            String target = "[" + c + String.valueOf(c).toUpperCase() + "]";
            String strippedInput = input.replaceAll(target, "");
            int length = react(strippedInput);
            if (length < shortestLength) {
                shortestLength = length;
            }
        }

        return shortestLength;
    }
}
