package com.kevinearls.adventofcode2018.chronal;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChronalCalibrationTest {
    private ChronalCalibration cc;

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
}

