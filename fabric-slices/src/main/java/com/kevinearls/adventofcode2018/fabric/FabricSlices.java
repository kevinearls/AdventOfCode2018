package com.kevinearls.adventofcode2018.fabric;

import java.util.ArrayList;
import java.util.List;

public class FabricSlices {
    private Integer gridSize =0;

    public FabricSlices(Integer gridSize) {
        this.gridSize = gridSize;
    }

    public Integer countOverlap(List<String> input) {
        String[][] grid = new String[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            for (int col=0; col < gridSize; col++) {
                grid[row][col] = "0";
            }
        }

        for (String line : input) {
            Claim claim = new Claim(line);
            for (int row = claim.startRow; row < claim.startRow + claim.rows; row++) {
                for (int column = claim.startColumn; column < claim.startColumn + claim.columns; column++) {
                    if (grid[row][column].equals("0")) {
                        grid[row][column] = claim.id;
                    } else {
                        grid[row][column] = "X";
                    }
                }
            }
        }

        int overlaps = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0 ; column < gridSize; column++) {
                if (grid[row][column].equals("X")) {
                    overlaps++;
                }
            }
        }

        return overlaps;
    }

    public String findNonOverlappingClaim(List<String> input) {
        List<Claim> candidates = new ArrayList<>();
        // Build the grid, and keep track of any claims that don't hit overlap during construction.  This will at least reduce the
        // candidates.
        String[][] grid = new String[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            for (int col=0; col < gridSize; col++) {
                grid[row][col] = "0";
            }
        }

        for (String line : input) {
            Claim claim = new Claim(line);
            boolean overlaps = false;
            for (int row = claim.startRow; row < claim.startRow + claim.rows; row++) {
                for (int column = claim.startColumn; column < claim.startColumn + claim.columns; column++) {
                    if (grid[row][column].equals("0")) {
                        grid[row][column] = claim.id;
                    } else {
                        grid[row][column] = "X";
                        overlaps = true;
                    }
                }
            }
            if (!overlaps) {
                candidates.add(claim);
            }
        }

        System.out.println("Found " + candidates.size() + " candidates out of " + input.size() + " claims");

        for (Claim claim : candidates) {
            boolean overlaps = false;
            for (int row = claim.startRow; row < claim.startRow + claim.rows; row++) {
                for (int column = claim.startColumn; column < claim.startColumn + claim.columns; column++) {
                    if (grid[row][column].equals("X")) {
                        overlaps = true;
                    }
                }
            }
            if (!overlaps) {
                return claim.id;
            }
        }

        return "-1";
    }
}


