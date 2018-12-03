package com.kevinearls.adventofcode2018.fabric;

import java.util.List;

import com.kevinearls.adventofcode2018.common.Utils;

public class FabricSlices {
    private Integer gridSize =0;

    public FabricSlices(Integer gridSize) {
        this.gridSize = gridSize;
    }

    public Integer countOverlap(List<String> input) throws Exception {
        String[][] grid = new String[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            for (int col=0; col < gridSize; col++) {
                grid[row][col] = "0";
            }
        }

        //List<String> input = Utils.loadFromFile("part1ExampleInput.txt");
        for (String line : input) {
            // IN a line like "#1277 @ 651,49: 14x14" get rid of characters we don't need
            line = line.replace("#", "");
            line = line.replace(":", "");
            line = line.replace("@", "");

            String[] parts = line.split("\\s+");
            String id = parts[0];
            String[] coordinates = parts[1].split(",");
            int startRow = Integer.valueOf(coordinates[0]);
            int startColumn = Integer.valueOf(coordinates[1]);

            String[] limits = parts[2].split("x");
            int rows = Integer.valueOf(limits[0]);
            int columns = Integer.valueOf(limits[1]);

            //System.out.println(id + ": " + startRow + ", " + startColumn + ": " + rows + " X " + columns);

            for (int row = startRow; row < startRow + rows; row++) {
                for (int column = startColumn; column < startColumn + columns; column++) {
                    if (grid[row][column].equals("0")) {
                        grid[row][column] = id;
                    } else {
                        grid[row][column] = "X";
                    }
                }
            }
        }

        int overlaps = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0 ; column < gridSize; column++) {
                //System.out.print(grid[row][column] + " ");
                if (grid[row][column].equals("X")) {
                    overlaps++;
                }
            }
        }

        return overlaps;
    }
}


