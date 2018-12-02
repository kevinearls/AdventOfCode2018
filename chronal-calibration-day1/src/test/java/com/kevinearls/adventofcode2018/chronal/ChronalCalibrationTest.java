package com.kevinearls.adventofcode2018.chronal;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChronalCalibrationTest {
    private ChronalCalibration cc=new ChronalCalibration();

    @BeforeEach
    public void setup() {
        cc = new ChronalCalibration();
    }

    @Test
    public void testWithExampleData() {
        List<Integer> testData1 = List.of(1, 1, 1);
        List<Integer> testData2 = List.of(1, 1, -2);
        List<Integer> testData3 = List.of(-1, -2, -3);

        assertEquals(3, cc.calibrate(testData1));
        assertEquals(0, cc.calibrate(testData2));
        assertEquals(-6, cc.calibrate(testData3));
    }

    @Test
    public void Part1() throws Exception {
        List<String> input = cc.loadFromFile("part1input.txt");
        List<Integer> data = new ArrayList<>();
        for (String i : input) {
            data.add(Integer.valueOf(i));
        }

        int total = cc.calibrate(data);
        assertEquals(538, total);
    }

    @Test
    public void testPart2WithExampleData() {
        List<Integer> testData0 = List.of(1, -1);
        List<Integer> testData1 = List.of(3, 3, 4, -2, -4);
        List<Integer> testData2 = List.of(-6, 3, 8, 5, -6);
        List<Integer> testData3 = List.of(7, 7, -2, -7, -4);

        assertEquals(0, cc.findFirstRepeatedFrequency(testData0));
        assertEquals(10, cc.findFirstRepeatedFrequency(testData1));
        assertEquals(5, cc.findFirstRepeatedFrequency(testData2));
        assertEquals(14, cc.findFirstRepeatedFrequency(testData3));
    }

    @Test
    public void Part2() throws Exception {
        List<String> input = cc.loadFromFile("part1input.txt");
        List<Integer> data = new ArrayList<>();
        for (String i : input) {
            data.add(Integer.valueOf(i));
        }

        int total = cc.findFirstRepeatedFrequency(data);
        assertEquals(77271, total);
    }
}

