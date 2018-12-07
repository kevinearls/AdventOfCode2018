package com.kevinearls.adventofcode2018.sumofpartsday7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.kevinearls.adventofcode2018.common.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfItsPartsTest {
    @Test
    public void testPart1WithExampleData() throws Exception {
        List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        SumOfItsParts soit = new SumOfItsParts();
        soit.load(input);
        String order = soit.getOrder();
        System.out.println(order);
        assertEquals("CABDFE", order);
    }

    @Test
    public void testPart1() throws Exception {
        List<String> input = Utils.loadFromFile("part1Input.txt");
        SumOfItsParts soit = new SumOfItsParts();
        soit.load(input);
        String order = soit.getOrder();
        System.out.println(order);
        assertEquals("FHICMRTXYDBOAJNPWQGVZUEKLS", order);
    }
}
