package com.kevinearls.adventofcode2018.chronal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ChronalCalibration {

    public int calibrate(List<Integer> input) {
        int total = 0;
        for (int currnet : input) {
            total += currnet;
        }

        return total;
    }

    public List<String> loadFromFile(String filename) throws Exception {
        List<String> contents = new ArrayList<>();
        File target = Paths.get(getClass().getClassLoader().getResource(filename).toURI()).toFile();
        BufferedReader br = new BufferedReader(new FileReader(target));

        String line = br.readLine();
        while (line != null) {
            contents.add(line.trim());
            line = br.readLine();
        }

        return contents;
    }

    public static void main(String[] args) {
        ChronalCalibration cc = new ChronalCalibration();

        /*
            +1, +1, +1 results in  3
            +1, +1, -2 results in  0
            -1, -2, -3 results in -6
         */

        List<Integer> testData = List.of(1, 1, 1);
        int result = cc.calibrate(testData);
        System.out.println(result);
    }
}
