package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land map;

    @BeforeEach
    void setUp() {
        map = new Land();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getGrid() {
        assertEquals(new ArrayList<StringBuilder>(), map.getGrid());
    }

    @Test
    void setGrind() {
    }
//    @Test
//    void addGridRow() {
//        StringBuilder row = new StringBuilder("-------------------------");
//        ArrayList<StringBuilder> expected = new ArrayList<StringBuilder>();
//        expected.add(row);
//        map.addGridRow(row);
//        assertEquals(expected, map.getGrid());
//    }

//    @Test
//    void buildGrid() {
//        ArrayList<StringBuilder> expected = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            StringBuilder row = new StringBuilder("-------------------------");
//            expected.add(row);
//        }
//        map.buildGrid();
//        assertEquals(expected.size(), map.getGrid().size());
//    }

    @Test
    void setGrindLocation() {
        map.buildGrid();
        Hashtable<String, Integer> coords = new Hashtable<>();
        coords.put("row", 2);
        coords.put("column", 2);
        map.setGridLocation(coords, 'H');
        assertEquals('H', map.getTileUtf(2,2));
    }

    @Test
    void inBoundsCheckTrue() {
        Hashtable<String, Integer> coordinates = new Hashtable<>();
        coordinates.put("row", 9);
        coordinates.put("column", 20);

        assertTrue(map.inBoundsCheck(9,10));
    }
    @Test
    void inBoundsCheckFalseRow() {
        Hashtable<String, Integer> coordinates = new Hashtable<>();
        coordinates.put("row", 10);
        coordinates.put("column", 20);

        assertFalse(map.inBoundsCheck(10,20));
    }

    @Test
    void inBoundsCheckFalseColumn() {
        Hashtable<String, Integer> coordinates = new Hashtable<>();
        coordinates.put("row", 9);
        coordinates.put("column", -1);

        assertFalse(map.inBoundsCheck(9, -1));
    }

    @Test
    void getAndSetNorthBound() {
        assertEquals(-1, map.getNorthBound());
    }

    @Test
    void getAndSetEastBound() {
        assertEquals(25, map.getEastBound());
    }

    @Test
    void getSouthBound() {
        assertEquals(10, map.getSouthBound());
    }

    @Test
    void getWestBound() {
        assertEquals(-1, map.getWestBound());
    }


}