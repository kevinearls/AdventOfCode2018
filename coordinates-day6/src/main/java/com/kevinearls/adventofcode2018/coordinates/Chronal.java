package com.kevinearls.adventofcode2018.coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chronal {
    List<Point> points = new ArrayList<>();
    List<Point> candidates = new ArrayList<>();
    int rows = 360;    // FIXME calculate from data
    int columns = 348;
    GridPoint[][] grid ;


    // FIXME calculate from input
    public Chronal(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new GridPoint[rows][columns];
    }

    public int findLargestArea(List<String> coordinates) {
        for (String line : coordinates) {
            String[] parts = line.trim().split(",");
            Point p = new Point(Integer.valueOf(parts[0].trim()), Integer.valueOf(parts[1].trim()));
            points.add(p);
        }

        int largestX = Integer.MIN_VALUE;
        int largestY = Integer.MIN_VALUE;
        int smallestX = Integer.MAX_VALUE;
        int smallestY = Integer.MAX_VALUE;
        for (Point p : points) {
            if (hasNonInfiniteArea(p)) {
                candidates.add(p);
            }

            if (p.x < smallestX) {
                smallestX = p.x;
            } else if (p.x > largestX) {
                largestX = p.x;
            }
            if (p.y < smallestY) {
                smallestY = p.y;
            } else if (p.y > largestY) {
                largestY = p.y;
            }
            //System.out.println(p + ": " + hasNonInfiniteArea(p));
        }
        System.out.println(points.size() + " total " + candidates.size() + " candidates");
        System.out.println("Smallest x " + smallestX + " y " + smallestY + " Largest x " + largestX + " y " + largestY );

        // Initialize grid
        //grid = new GridPoint[largestY + 1][largestX + 1];  // FIXME y = rows, x = columns?
        for (int row=0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                grid[row][col] = new GridPoint();
            }
        }

        // Add points to grid
        for (Point p : points) {
            grid[p.y][p.x] = new GridPoint(true, p);
        }

        //printGrid();
        System.out.println("--------------------------------");

        // Calculate distances
        for (int row=0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                GridPoint gp = grid[col][row];
                if (!gp.occupied) {
                    // FIXME!!!! need to deal with matches
                    Point nearestPoint = getClosestPoint(new Point(row, col));
                    gp.nearestOccupiedPoint = nearestPoint;
                }
            }
        }
       //printGrid();

        //
        Map<Point, Integer> closestCounts = new HashMap<>();
        for (int row=0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                GridPoint gp = grid[row][col];
                if (!gp.occupied && gp.nearestOccupiedPoint != null && candidates.contains(gp.nearestOccupiedPoint)) {
                    // FIXME!!!! need to deal with matches
                    //Point nearestPoint = getClosestPoint(new Point(row, col));
                    //gp.nearestOccupiedPoint = nearestPoint;
                    //System.out.println("Got point " + gp.nearestOccupiedPoint);
                    Integer count = closestCounts.get(gp.nearestOccupiedPoint);
                    if (count == null) {
                        count = 1;
                    } else {
                        count++;
                    }
                    closestCounts.put(gp.nearestOccupiedPoint, count);
                }
            }
        }

        System.out.println("ClosestCounts has " + closestCounts.size() + " entries");
        // TODO be sure to ignore non-candidates
        Integer highest = Integer.MIN_VALUE;
        Point hp = new Point(0, 0);
        for (Point p : closestCounts.keySet()) {
            Integer count = closestCounts.get(p);
            System.out.println("Count " + p + ": " + count);
            if (count > highest) {
                highest = count;
                hp = p;
            }
        }

        System.out.println("Highest is point " + hp + " with " + highest);

        // What is closest to the first point, 1,1?
        //Point closest = getClosestPoint(new Point(0,5));
        //System.out.println("Closest to 1,1: " + closest);

        return highest;
    }

    public void printGrid() {
        for (int row = 0; row < grid.length; row++) {
            System.out.printf("|");
            for (int column = 0; column < grid[row].length; column++) {
                System.out.printf(grid[row][column] + "|");
            }
            System.out.println();
        }
    }

    /**
     * Explain this better:
     * @return
     */
    private boolean hasNonInfiniteArea(Point target) {
        boolean infinite = false;
        // FIXME come up with a more efficient, less hacky solution
        // What am I looking for?  for this point to be non-infinite, there need to be points which have:
        //  - lower x
        // - higher x
        // lower y
        // higher y
        // TODO what about equals?
        boolean lowerX = false;
        boolean lowerY = false;
        boolean higherX = false;
        boolean higherY = false;

        for (Point p : points) {
            if (p.y < target.y) {
                lowerY = true;
            }
            if (p.x < target.x) {
                lowerX = true;
            }
            if (p.y > target.y) {
                higherY = true;
            }
            if (p.x > target.x) {
                higherX = true;
            }
        }

        return lowerX && higherX && lowerY && higherY;
    }

    /**
     * Using only the Manhattan distance, determine the area around each coordinate by
     * counting the number of integer X,Y locations that are closest to that coordinate
     * (and aren't tied in distance to any other coordinate).
     *
     * @return
     */
    public int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public Point getClosestPoint(Point target) {
        int closestDistance = Integer.MAX_VALUE;
        Point closest = new Point(0,0);

        for (Point p : points) {
            if (!p.equals(target)) {
                int manhattanDistance = getManhattanDistance(target, p);
                // System.out.println("Distance to " + p + " is " + manhattanDistance);
                if (manhattanDistance == closestDistance) {
                    closest = null;
                }
                else if (manhattanDistance < closestDistance) {
                    closestDistance = manhattanDistance;
                    closest = p;
                }
            }
        }

        return closest;
    }
}
