package com.reverse.userservice.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchLocationTest {
    @Test
    void testEquals() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");
        assertFalse(branchLocation.equals(null));
    }

    @Test
    void testEquals2() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");
        assertFalse(branchLocation.equals("Different type to BranchLocation"));
    }

    @Test
    void testEquals3() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");
        assertTrue(branchLocation.equals(branchLocation));
        int expectedHashCodeResult = branchLocation.hashCode();
        assertEquals(expectedHashCodeResult, branchLocation.hashCode());
    }

    @Test
    void testEquals4() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertTrue(branchLocation.equals(branchLocation1));
        int expectedHashCodeResult = branchLocation.hashCode();
        assertEquals(expectedHashCodeResult, branchLocation1.hashCode());
    }

    @Test
    void testEquals5() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GBR");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals6() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(123);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals7() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("City");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals8() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("Branch Name");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals9() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("State");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals10() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");
        assertFalse(branchLocation.equals(null));
    }

    @Test
    void testEquals11() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");
        assertFalse(branchLocation.equals("Different type to BranchLocation"));
    }

    @Test
    void testEquals12() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");
        assertTrue(branchLocation.equals(branchLocation));
        int expectedHashCodeResult = branchLocation.hashCode();
        assertEquals(expectedHashCodeResult, branchLocation.hashCode());
    }

    @Test
    void testEquals13() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertTrue(branchLocation.equals(branchLocation1));
        int expectedHashCodeResult = branchLocation.hashCode();
        assertEquals(expectedHashCodeResult, branchLocation1.hashCode());
    }

    @Test
    void testEquals14() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GBR");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals15() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(123);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals16() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("City");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals17() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("Branch Name");
        branchLocation.setState("MD");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }

    @Test
    void testEquals18() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(1);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("State");

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(1);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");
        assertFalse(branchLocation.equals(branchLocation1));
    }
}

