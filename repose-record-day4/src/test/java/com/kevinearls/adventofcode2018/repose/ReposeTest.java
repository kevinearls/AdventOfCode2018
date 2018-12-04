package com.kevinearls.adventofcode2018.repose;

import java.util.List;

import com.kevinearls.adventofcode2018.common.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReposeTest {
    @Test
    public void testPart1WithExampleData() throws Exception {
        List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        Repose repose = new Repose();
        repose.loadGuards(input);
        int result = repose.strategyOne();
        assertEquals(240, result);
    }

    @Test
    public void testPart1() throws Exception {
        List<String> input = Utils.loadFromFile("part1InputSorted.txt");
        Repose repose = new Repose();
        repose.loadGuards(input);
        int result = repose.strategyOne();
        assertEquals(76357, result);
    }

    @Test
    public void testPart2WithExampleData() throws Exception {
        List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        Repose repose = new Repose();
        repose.loadGuards(input);
        int result = repose.strategyTwo();
        assertEquals(4455, result);
    }

    @Test
    public void testPart2() throws Exception {
        List<String> input = Utils.loadFromFile("part1InputSorted.txt");
        Repose repose = new Repose();
        repose.loadGuards(input);
        int result = repose.strategyTwo();
        assertEquals(41668, result);
    }
}
