package com.kevinearls.adventofcode2018.common;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {
    @Test
    public void testUtilsLoadFile() throws Exception{
        List<String> entries = Utils.loadFromFile("fud.txt");
        assertEquals(3, entries.size())
    }

}
