package com.kevinearls.adventofcode2018.fabric;

import java.util.List;

import com.kevinearls.adventofcode2018.common.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricSlicesTest {

    @Test
    public void testPart1WithExampleData() throws Exception {
        FabricSlices slices = new FabricSlices(10);
        List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        int overlap = slices.countOverlap(input);
        assertEquals(4, overlap);
    }

    @Test
    public void testPart1() throws Exception {
        FabricSlices slices = new FabricSlices(1000);
        List<String> input = Utils.loadFromFile("part1Input.txt");
        int overlap = slices.countOverlap(input);
        assertEquals(107820, overlap);
    }

    @Test
    public void testPart2WithExampleData() throws Exception {
        FabricSlices slices = new FabricSlices(10);
        List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        String id = slices.findNonOverlappingClaim(input);
        assertEquals("3", id);
    }

    @Test
    public void testPart2() throws Exception {
        FabricSlices slices = new FabricSlices(1000);
        List<String> input = Utils.loadFromFile("part1Input.txt");
        String id = slices.findNonOverlappingClaim(input);
        assertEquals("661", id);
    }




}
