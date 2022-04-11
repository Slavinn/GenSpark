package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

public class Land {
    private ArrayList<ArrayList<Tile>> grid;
    private static final int northBound = -1;
    private static final int eastBound = 25;
    private static final int southBound = 10;
    private static final int westBound = -1;

    private class Tile {
        private Hashtable<String, Integer> coordinates;
        private Humanoid humanoid;
        private char utf;

        public Tile(Hashtable<String, Integer> coordinates) {
            this.coordinates = coordinates;
            this.humanoid = null;
            this.utf = '_';
        }

        public Humanoid getHumanoid() {
            return humanoid;
        }

        public void setHumanoid(Humanoid humanoid) {
            this.humanoid = humanoid;
        }

        public char getUtf() {
            return utf;
        }

        public void setUtf(char utf) {
            this.utf = utf;
        }
    }

    public char getTileUtf(Integer row, Integer column) {
        return grid.get(row).get(column).getUtf();
    }
    public Humanoid getTileHumanoid(Integer row, Integer column) {
        return grid.get(row).get(column).getHumanoid();
    }

    public Land() {
        this.grid = buildGrid();
    }

    public ArrayList<ArrayList<Tile>> getGrid() {
        return this.grid;
    }

    public void setGrid(ArrayList<ArrayList<Tile>> grid) {
        this.grid = grid;
    }

    public void addGridRow(ArrayList<Tile> row) {
        this.grid.add(row);
    }

    public ArrayList<ArrayList<Tile>> buildGrid() {

        ArrayList<ArrayList<Tile>> grid = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < 25; j++) {
                Hashtable<String, Integer> tile = new Hashtable<>();
                tile.put("row", i);
                tile.put("column", j);
                row.add(new Tile(tile));
            }
            grid.add(row);
        }
        return grid;
    }

    public void setGridLocation(Hashtable<String, Integer> coordinates, char utf) {
        ArrayList<ArrayList<Tile>> grid = getGrid();
        int row = coordinates.get("row");
        int column = coordinates.get("column");
        grid.get(row).get(column).setUtf(utf);
        setGrid(grid);
    }

    public void printGrind() {
        ArrayList<ArrayList<Tile>> grind = getGrid();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 25; j++) {
                System.out.print(getTileUtf(i,j));
            }
            System.out.println();
        }
    }


    public boolean inBoundsCheck(Hashtable<String, Integer> coordinates) {
        int row = coordinates.get("row");
        int column = coordinates.get("column");
        if (row <= getNorthBound() || row >= getSouthBound()) {
            return false;
        }
        if (column <= getWestBound() || column >= getEastBound()) {
            return false;
        }
        return true;
    }

    public int getNorthBound() {
        return northBound;
    }

    public int getEastBound() {
        return eastBound;
    }

    public int getSouthBound() {
        return southBound;
    }

    public int getWestBound() {
        return westBound;
    }

}
