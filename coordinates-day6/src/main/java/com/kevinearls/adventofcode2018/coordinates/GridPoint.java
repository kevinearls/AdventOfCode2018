package com.kevinearls.adventofcode2018.coordinates;

public class GridPoint {
    public boolean occupied;
    public Point occupier;
    public Point nearestOccupiedPoint;


    public GridPoint() {
        this.occupied = false;
        this.occupier = null;
        this.nearestOccupiedPoint = null;
    }

    public GridPoint(boolean occupied, Point occupier) {
        this.occupied = occupied;
        this.occupier = occupier;
    }

    @Override
    public String toString() {
        if (occupied) {
            return "C" + occupier;
        } else {
            return "N " + nearestOccupiedPoint;
        }

        //return "GridPoint{" + "occupied=" + occupied + ", occupier=" + occupier + ", nearestOccupiedPoint=" + nearestOccupiedPoint + '}';
    }
}
