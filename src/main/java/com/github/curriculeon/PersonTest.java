package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    // given
    private void testConstructor(final Long expectedId, final String expectedName) {
        // when
        final Person person = new Person(expectedId, expectedName);

        // then
        final Long actualId = person.getId();
        final String actualName = person.getName();
        Assert.assertEquals(expectedId, actualId);
        Assert.assertEquals(expectedName, actualName);
    }

    // given
    private void testSetName(final String expectedName) {
        final Person person = new Person(null, null);
        Assert.assertNotEquals(expectedName, person.getName());

        // when
        person.setName(expectedName);

        // then
        final String actualName = person.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetNameWithLeon() {
        testSetName("Leon");
    }

    @Test
    public void testSetNameWithHunter() {
        testSetName("Hunter");
    }

    @Test
    public void testConstructorWith10AndLeon() {
        testConstructor(10L, "Leon");
    }

    @Test
    public void testConstructorWith15AndHunter() {
        testConstructor(15L, "Hunter");
    }
}
