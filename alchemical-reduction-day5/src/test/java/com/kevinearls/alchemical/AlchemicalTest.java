package com.kevinearls.alchemical;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.kevinearls.adventofcode2018.common.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlchemicalTest {
    @Test
    public void testPart1WithExampleData() {
        String input = "dabAcCaCBAcCcaDA";
        Polymer polymer = new Polymer();
        int result = polymer.react(input);
        System.out.println("Result " + result);
        assertEquals(10, result);
    }

    @Test
    public void testPart1() throws Exception {
        List<String> input = Utils.loadFromFile("part1Input.txt");
        assertEquals(1, input.size());
        Polymer polymer = new Polymer();
        int result = polymer.react(input.get(0));
        System.out.println("Result " + result);
        assertEquals(11540, result);
    }

}
