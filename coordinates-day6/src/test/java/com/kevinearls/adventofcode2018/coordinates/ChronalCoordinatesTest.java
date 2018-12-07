package com.kevinearls.adventofcode2018.coordinates;

import java.util.List;

import com.kevinearls.adventofcode2018.common.Utils;
import org.junit.jupiter.api.Test;

public class ChronalCoordinatesTest {
    @Test
    public void testPart1WithExampleInput() throws Exception {
        List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        Chronal chronal = new Chronal(10, 10);
        int distance = chronal.findLargestArea(input);
        System.out.println(distance);
    }

    @Test
    public void testPart1() throws Exception {
        List<String> input = Utils.loadFromFile("part1Input.txt");
        Chronal chronal = new Chronal(360, 360);
        int distance = chronal.findLargestArea(input);    // higher than 5940
        System.out.println(distance);
    }
}
