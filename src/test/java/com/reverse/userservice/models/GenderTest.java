package com.reverse.userservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GenderTest {
    @Test
    void testEquals() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);
        assertFalse(gender4.equals(null));
    }

    @Test
    void testEquals2() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);
        assertFalse(gender4.equals("Different type to Gender"));
    }

    @Test
    void testEquals3() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);
        assertTrue(gender4.equals(gender4));
        int expectedHashCodeResult = gender4.hashCode();
        assertEquals(expectedHashCodeResult, gender4.hashCode());
    }

    @Test
    void testEquals4() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setGender(gender3);

        Gender gender5 = new Gender();
        gender5.setId(1);
        gender5.setGender(gender4);

        Gender gender6 = new Gender();
        gender6.setId(1);
        gender6.setGender(gender5);

        Gender gender7 = new Gender();
        gender7.setId(1);
        gender7.setGender(gender6);

        Gender gender8 = new Gender();
        gender8.setId(1);
        gender8.setGender(gender7);

        Gender gender9 = new Gender();
        gender9.setId(1);
        gender9.setGender(gender8);

        Gender gender10 = new Gender();
        gender10.setId(1);
        gender10.setGender(new Gender());

        Gender gender11 = new Gender();
        gender11.setId(1);
        gender11.setGender(gender10);

        Gender gender12 = new Gender();
        gender12.setId(1);
        gender12.setGender(gender11);

        Gender gender13 = new Gender();
        gender13.setId(1);
        gender13.setGender(gender12);

        Gender gender14 = new Gender();
        gender14.setId(1);
        gender14.setGender(gender13);
        assertFalse(gender9.equals(gender14));
    }

    @Test
    void testEquals5() {
        Gender gender = new Gender();
        gender.setId(1);

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);

        Gender gender5 = new Gender();
        gender5.setId(1);
        gender5.setGender(gender4);

        Gender gender6 = new Gender();
        gender6.setId(1);
        gender6.setGender(new Gender());

        Gender gender7 = new Gender();
        gender7.setId(1);
        gender7.setGender(gender6);

        Gender gender8 = new Gender();
        gender8.setId(1);
        gender8.setGender(gender7);

        Gender gender9 = new Gender();
        gender9.setId(1);
        gender9.setGender(gender8);

        Gender gender10 = new Gender();
        gender10.setId(1);
        gender10.setGender(gender9);
        assertFalse(gender5.equals(gender10));
    }

    @Test
    void testEquals6() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);
        assertFalse(gender4.equals(null));
    }

    @Test
    void testEquals7() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);
        assertFalse(gender4.equals("Different type to Gender"));
    }

    @Test
    void testEquals8() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);
        assertTrue(gender4.equals(gender4));
        int expectedHashCodeResult = gender4.hashCode();
        assertEquals(expectedHashCodeResult, gender4.hashCode());
    }

    @Test
    void testEquals9() {
        Gender gender = new Gender();
        gender.setId(1);
        gender.setGender(new Gender());

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setGender(gender3);

        Gender gender5 = new Gender();
        gender5.setId(1);
        gender5.setGender(gender4);

        Gender gender6 = new Gender();
        gender6.setId(1);
        gender6.setGender(gender5);

        Gender gender7 = new Gender();
        gender7.setId(1);
        gender7.setGender(gender6);

        Gender gender8 = new Gender();
        gender8.setId(1);
        gender8.setGender(gender7);

        Gender gender9 = new Gender();
        gender9.setId(1);
        gender9.setGender(gender8);

        Gender gender10 = new Gender();
        gender10.setId(1);
        gender10.setGender(new Gender());

        Gender gender11 = new Gender();
        gender11.setId(1);
        gender11.setGender(gender10);

        Gender gender12 = new Gender();
        gender12.setId(1);
        gender12.setGender(gender11);

        Gender gender13 = new Gender();
        gender13.setId(1);
        gender13.setGender(gender12);

        Gender gender14 = new Gender();
        gender14.setId(1);
        gender14.setGender(gender13);
        assertFalse(gender9.equals(gender14));
    }

    @Test
    void testEquals10() {
        Gender gender = new Gender();
        gender.setId(1);

        Gender gender1 = new Gender();
        gender1.setId(1);
        gender1.setGender(gender);

        Gender gender2 = new Gender();
        gender2.setId(1);
        gender2.setGender(gender1);

        Gender gender3 = new Gender();
        gender3.setId(1);
        gender3.setGender(gender2);

        Gender gender4 = new Gender();
        gender4.setId(1);
        gender4.setGender(gender3);

        Gender gender5 = new Gender();
        gender5.setId(1);
        gender5.setGender(gender4);

        Gender gender6 = new Gender();
        gender6.setId(1);
        gender6.setGender(new Gender());

        Gender gender7 = new Gender();
        gender7.setId(1);
        gender7.setGender(gender6);

        Gender gender8 = new Gender();
        gender8.setId(1);
        gender8.setGender(gender7);

        Gender gender9 = new Gender();
        gender9.setId(1);
        gender9.setGender(gender8);

        Gender gender10 = new Gender();
        gender10.setId(1);
        gender10.setGender(gender9);
        assertFalse(gender5.equals(gender10));
    }
}

