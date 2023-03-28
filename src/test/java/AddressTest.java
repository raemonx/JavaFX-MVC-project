/***
 * ............................................................
 *    Project Phase 1 , SOEN 6441
 *    ©(Faraaz, Himangshu, Shivesh)
 *    Written by:
 *                @author Himangshu Shekhar Baruah , Student ID 40229774
 *                @author Ahmad Faraaz Jafri, Student ID 40232742
 *                @author Shivesh Chaudhary, Student ID 40228107
 * ............................................................
 */

import Model.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    @org.junit.jupiter.api.Test
    public void testGetStreetName() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        assertEquals("2/262 Vikas Khand", address.getStreetName());
    }

    @org.junit.jupiter.api.Test
    public void testGetCity() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        assertEquals("Lucknow", address.getCity());
    }

    @org.junit.jupiter.api.Test
    public void testGetProvince() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        assertEquals("UP", address.getProvince());
    }

    @org.junit.jupiter.api.Test
    public void testGetPostalCode() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        assertEquals("226010", address.getPostalCode());
    }

    @org.junit.jupiter.api.Test
    public void testSetStreetName() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        address.setStreetName("456 Queen St");
        assertEquals("456 Queen St", address.getStreetName());
    }

    @org.junit.jupiter.api.Test
    public void testSetCity() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        address.setCity("Ottawa");
        assertEquals("Ottawa", address.getCity());
    }

    @org.junit.jupiter.api.Test
    public void testSetProvince() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        address.setProvince("QC");
        assertEquals("QC", address.getProvince());
    }

    @org.junit.jupiter.api.Test
    public void testSetPostalCode() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        address.setPostalCode("H3B 2Y5");
        assertEquals("H3B 2Y5", address.getPostalCode());
    }

    @org.junit.jupiter.api.Test
    public void testToString() {
        Address address = new Address("2/262 Vikas Khand", "Lucknow", "UP", "226010");
        String expectedString = "streetName='2/262 Vikas Khand', city='Lucknow', province='UP', postalCode='226010'";
        assertEquals(expectedString, address.toString());
    }
}

