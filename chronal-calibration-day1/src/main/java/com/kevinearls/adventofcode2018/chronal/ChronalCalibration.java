package com.kevinearls.adventofcode2018.chronal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChronalCalibration {

    /* For Part 1
     */
    public int calibrate(List<Integer> input) {
        int total = 0;
        for (int currnet : input) {
            total += currnet;
        }

        return total;
    }

    public int findFirstRepeatedFrequency(List<Integer> input) {
        Set<Integer> foundFrequencies = new HashSet<>();
        int frequency = 0;
        foundFrequencies.add(frequency);
        while (true) {
            for (int current : input) {
                frequency += current;
                if (foundFrequencies.contains(frequency)) {
                    return frequency;
                }
                foundFrequencies.add(frequency);
            }
        }
    }

    /**
     * Load data from a file on the classpath.  TODO make this a global utility
     *
     * @param filename
     * @return
     * @throws Exception
     */
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
