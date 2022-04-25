package com.example.guihvg.datamodel;

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
        public Hashtable<String, Integer> getCoordinates () {
            return coordinates;
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

    public void setTileUTF(Integer row, Integer column, char utf) {
        this.grid.get(row).get(column).setUtf(utf);
    }

    public char getTileUtf(Integer row, Integer column) {
        return grid.get(row).get(column).getUtf();
    }

    public void setTileHumanoid(Integer row, Integer column, Humanoid humanoid) {
        this.grid.get(row).get(column).setHumanoid(humanoid);
    }

    public Humanoid getTileHumanoid(Integer row, Integer column) {
        return grid.get(row).get(column).getHumanoid();
    }
    public Hashtable<String, Integer> getTileCoords(Integer row, Integer column) {
        return grid.get(row).get(column).coordinates;
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

    public ArrayList<String> getCharacterGrid() {
        ArrayList<String> map = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String row = new String();
            for (int j = 0; j < 25; j++) {
                row += getTileUtf(i, j);
            }
            row += "\n";
            map.add(row);
        }
        return map;
    }

    public void move(Human human, Goblin goblin) {
        int rowHuman = human.getCoordinates().get("row");
        int columnHuman = human.getCoordinates().get("column");
        int rowGoblin = goblin.getCoordinates().get("row");
        int columnGoblin = goblin.getCoordinates().get("column");
        // set human tile to empty
        setTileUTF(rowHuman,columnHuman, '_');
        setTileHumanoid(rowHuman, columnHuman, null);
        human.setCoordinates(goblin.getCoordinates());
        // set goblin tile to human
        setTileHumanoid(rowGoblin, columnGoblin, human);
        setTileUTF(rowGoblin, columnGoblin, human.getIdentifier());
    }

    public Goblin move(Humanoid humanoid, char input) {
        int row = humanoid.getCoordinates().get("row");
        int column = humanoid.getCoordinates().get("column");

        switch (input) {
            case 'w':
                if (inBoundsCheck(row - 1, column)) {
                    if (humanoid.collide(row - 1, column, this)) {
                        return (Goblin) getTileHumanoid(row - 1, column);
                    } else {
                        // set current tile humanoid to null
                        setTileHumanoid(row, column, null);
                        // set current tile utf to default
                        setTileUTF(row, column, '_');
                        // move human to next tile
                        setTileHumanoid(row-1, column, humanoid);
                        // change new tiles utf
                        setTileUTF(row-1, column, humanoid.getIdentifier());
                        humanoid.setCoordinates(getTileCoords(row-1, column));

                    }
                }
                break;
            case 'a':
                if (inBoundsCheck(row, column - 1)) {
                    if (humanoid.collide(row, column - 1, this)) {
                        return (Goblin) getTileHumanoid(row, column - 1);

                    } else {
                        // set current tile humanoid to null
                        setTileHumanoid(row, column, null);
                        // set current tile utf to default
                        setTileUTF(row, column, '_');
                        // move human to next tile
                        setTileHumanoid(row, column -1, humanoid);
                        // change new tiles utf
                        setTileUTF(row, column -1, humanoid.getIdentifier());
                        humanoid.setCoordinates(getTileCoords(row, column -1));
                    }
                }
                break;
            case 's':
                if (inBoundsCheck(row + 1, column)) {
                    if (humanoid.collide(row + 1, column, this)) {
                        return (Goblin) getTileHumanoid(row + 1, column);
                    } else {
                        // set current tile humanoid to null
                        setTileHumanoid(row, column, null);
                        // set current tile utf to default
                        setTileUTF(row, column, '_');
                        // move human to next tile
                        setTileHumanoid(row+1, column, humanoid);
                        // change new tiles utf
                        setTileUTF(row+1, column, humanoid.getIdentifier());
                        humanoid.setCoordinates(getTileCoords(row+1, column));

                    }
                }
                break;
            case 'd':
                if (inBoundsCheck(row, column + 1)) {
                    if (humanoid.collide(row, column + 1, this)) {
                        return (Goblin) getTileHumanoid(row, column +1);
                    } else {
                        // set current tile humanoid to null
                        setTileHumanoid(row, column, null);
                        // set current tile utf to default
                        setTileUTF(row, column, '_');
                        // move human to next tile
                        setTileHumanoid(row, column + 1, humanoid);
                        // change new tiles utf
                        setTileUTF(row, column + 1, humanoid.getIdentifier());
                        humanoid.setCoordinates(getTileCoords(row, column+1));

                    }
                }
                break;
            default:
                break;
        }
        return null;

    }

    public boolean inBoundsCheck(int row, int column) {
        if ((row > getNorthBound() && row < getSouthBound()) && (column > getWestBound() && column < getEastBound())) {
            return true;
        }
        return false;
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
