package com.kevinearls.alchemical;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Polymer {
    public int react(String input) {
        List<String> content = new LinkedList<>(Arrays.asList(input.split("")));
        System.out.println("Size " + content.size());

        int position = 0;
        String current = "";
        String next = "";
        while (position < content.size() - 1) { // TODO or length - 1?
            current = content.get(position);
            next = content.get(position + 1);

            if ((!current.equals(next)) && (current.equalsIgnoreCase(next))) {
                //System.out.println("Removing " + current + next + " at position " + position);
                content.remove(position);
                content.remove(position);
                //System.out.println("After remove [" + content.toString() + "]");
                if (position > 0) {
                    position--;
                }
            } else {
                position++;
            }
        }

        return content.size();
    }
}
