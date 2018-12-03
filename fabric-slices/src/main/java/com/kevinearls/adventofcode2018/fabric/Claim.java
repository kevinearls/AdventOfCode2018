package com.kevinearls.adventofcode2018.fabric;

public class Claim {
    public String id;
    public int startRow;
    public int startColumn;
    public int rows;
    public int columns;

    public Claim(String input) {
        input = input.trim();
        // IN a input like "#1277 @ 651,49: 14x14" get rid of characters we don't need
        input = input.replace("#", "");
        input = input.replace(":", "");
        input = input.replace("@", "");

        String[] parts = input.split("\\s+");
        id = parts[0];
        String[] coordinates = parts[1].split(",");
        startRow = Integer.valueOf(coordinates[0]);
        startColumn = Integer.valueOf(coordinates[1]);

        String[] limits = parts[2].split("x");
        rows = Integer.valueOf(limits[0]);
        columns = Integer.valueOf(limits[1]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
