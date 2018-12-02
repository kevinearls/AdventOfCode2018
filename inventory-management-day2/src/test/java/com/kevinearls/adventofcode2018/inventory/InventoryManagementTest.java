package com.kevinearls.adventofcode2018.inventory;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryManagementTest {
    // TODO how to get @BeforeEach to work with junit5?
    InventoryManagement im = new InventoryManagement();

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
    @Test
    public void testPart1ExampleData() throws Exception {
        List<String> part1ExampleInput = im.loadFromFile("part1ExampleInput.txt");
        int result = im.calculateCheckSum(part1ExampleInput);
        System.out.println("GOT: " + result);
        assertEquals(12, result);

    }

    @Test
    public void testPart1() throws Exception {
        List<String> part1Input = im.loadFromFile("part1input.txt");
        int result = im.calculateCheckSum(part1Input);
        System.out.println("GOT: " + result);
        assertEquals(3952, result);

    }
}
