package com.reverse.userservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProfilePictureTest {
    @Test
    void testEquals() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");
        assertFalse(profilePicture.equals(null));
    }

    @Test
    void testEquals2() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");
        assertFalse(profilePicture.equals("Different type to ProfilePicture"));
    }

    @Test
    void testEquals3() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");
        assertTrue(profilePicture.equals(profilePicture));
        int expectedHashCodeResult = profilePicture.hashCode();
        assertEquals(expectedHashCodeResult, profilePicture.hashCode());
    }

    @Test
    void testEquals4() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");

        ProfilePicture profilePicture1 = new ProfilePicture();
        profilePicture1.setId(1);
        profilePicture1.setImageLocation(imageLocation1);
        profilePicture1.setImageName("Image Name");
        assertTrue(profilePicture.equals(profilePicture1));
        int expectedHashCodeResult = profilePicture.hashCode();
        assertEquals(expectedHashCodeResult, profilePicture1.hashCode());
    }

    @Test
    void testEquals5() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(123);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");

        ProfilePicture profilePicture1 = new ProfilePicture();
        profilePicture1.setId(1);
        profilePicture1.setImageLocation(imageLocation1);
        profilePicture1.setImageName("Image Name");
        assertFalse(profilePicture.equals(profilePicture1));
    }

    @Test
    void testEquals6() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");
        assertFalse(profilePicture.equals(null));
    }

    @Test
    void testEquals7() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");
        assertFalse(profilePicture.equals("Different type to ProfilePicture"));
    }

    @Test
    void testEquals8() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");
        assertTrue(profilePicture.equals(profilePicture));
        int expectedHashCodeResult = profilePicture.hashCode();
        assertEquals(expectedHashCodeResult, profilePicture.hashCode());
    }

    @Test
    void testEquals9() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(1);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");

        ProfilePicture profilePicture1 = new ProfilePicture();
        profilePicture1.setId(1);
        profilePicture1.setImageLocation(imageLocation1);
        profilePicture1.setImageName("Image Name");
        assertTrue(profilePicture.equals(profilePicture1));
        int expectedHashCodeResult = profilePicture.hashCode();
        assertEquals(expectedHashCodeResult, profilePicture1.hashCode());
    }

    @Test
    void testEquals10() {
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(1);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(123);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(1);
        imageLocation1.setUrl("https://example.org/example");

        ProfilePicture profilePicture1 = new ProfilePicture();
        profilePicture1.setId(1);
        profilePicture1.setImageLocation(imageLocation1);
        profilePicture1.setImageName("Image Name");
        assertFalse(profilePicture.equals(profilePicture1));
    }
}

