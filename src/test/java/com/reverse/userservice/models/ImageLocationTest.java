package com.reverse.userservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ImageLocationTest {
    @Test
    void testEquals() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals(null));
    }

    @Test
    void testEquals2() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals("Different type to ImageLocation"));
    }

    @Test
    void testEquals3() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");
        assertTrue(imageLocation.equals(imageLocation));
        int expectedHashCodeResult = imageLocation.hashCode();
        assertEquals(expectedHashCodeResult, imageLocation.hashCode());
    }

    @Test
    void testEquals4() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");
        assertTrue(imageLocation.equals(imageLocation1));
        int expectedHashCodeResult = imageLocation.hashCode();
        assertEquals(expectedHashCodeResult, imageLocation1.hashCode());
    }

    @Test
    void testEquals5() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(123);
        imageLocation.setUrl("https://example.org/example");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals(imageLocation1));
    }

    @Test
    void testEquals6() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("Url");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals(imageLocation1));
    }

    @Test
    void testEquals7() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals(null));
    }

    @Test
    void testEquals8() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals("Different type to ImageLocation"));
    }

    @Test
    void testEquals9() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");
        assertTrue(imageLocation.equals(imageLocation));
        int expectedHashCodeResult = imageLocation.hashCode();
        assertEquals(expectedHashCodeResult, imageLocation.hashCode());
    }

    @Test
    void testEquals10() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");
        assertTrue(imageLocation.equals(imageLocation1));
        int expectedHashCodeResult = imageLocation.hashCode();
        assertEquals(expectedHashCodeResult, imageLocation1.hashCode());
    }

    @Test
    void testEquals11() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(123);
        imageLocation.setUrl("https://example.org/example");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals(imageLocation1));
    }

    @Test
    void testEquals12() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("Url");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");
        assertFalse(imageLocation.equals(imageLocation1));
    }
}

