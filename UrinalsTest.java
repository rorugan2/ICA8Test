package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    Urinals u = new Urinals();

    @Test
    void main() {
    }

    @Test
    void getUrinals() {
        assertEquals(1,u.getUrinals("10001"));
        assertEquals(0,u.getUrinals("1001"));
        assertEquals(3,u.getUrinals("00000"));
        assertEquals(2,u.getUrinals("0000"));
        assertEquals(1,u.getUrinals("01000"));
        assertEquals(-1,u.getUrinals("011"));

    }

    @Test
    void goodString() {
        assertEquals(false, Urinals.goodString("abc"));
        assertEquals(true, Urinals.goodString("10101"));
        assertEquals(false, Urinals.goodString("1182"));
    }
}