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

import Model.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyTests {

    @Test
    public void testApartmentCreation() {
        Address address = new Address("123 Main St", "Anytown", "Anystate", "12345");

        PropertyCreator creator = new ApartmentCreator();
        Property apartment = creator.createProperty("123", address, 1, 2, 1, 1000);

        assertEquals("Apt #1, " + address, apartment.getAddress());
        assertEquals(1, apartment.getUnitNumber());
        assertEquals(2, apartment.getNumberOfBedrooms());
        assertEquals(1, apartment.getNumberOfBathrooms());
        assertEquals(1000, apartment.getSquareFootage());
        assertTrue(apartment.isAvailable());
    }

    @Test
    public void testApartmentAddress() {
        Address address = new Address("123 Main St", "Anytown", "Anystate", "12345");
        PropertyCreator creator = new ApartmentCreator();
        Property apartment = creator.createProperty("123", address, 1, 2, 1, 1000);

        assertEquals("Apt #1, streetName='123 Main St', city='Anytown', province='Anystate', postalCode='12345'", apartment.getAddress());
    }

    @Test
    public void testApartmentAvailability() {
        Address address = new Address("123 Main St", "Anytown", "Anystate", "12345");
        PropertyCreator creator = new ApartmentCreator();
        Property apartment = creator.createProperty("123", address, 1, 2, 1, 1000);

        apartment.setAvailability(false);
        assertFalse(apartment.isAvailable());

        apartment.setAvailability(true);
        assertTrue(apartment.isAvailable());
    }

    @Test
    public void testApartmentToString() {
        Address address = new Address("123 Main St", "Anytown", "Anystate", "12345");
        PropertyCreator creator = new ApartmentCreator();
        Property apartment = creator.createProperty("123", address, 1, 2, 1, 1000);

        String expected = "Apartment Details: Apt #1, streetName='123 Main St', city='Anytown', province='Anystate', postalCode='12345', numberOfBedrooms=2, numberOfBathrooms=1, squareFootage=1000, available=true";

        assertEquals(expected, apartment.toString());
    }

    @Test
    public void testApartmentCreator() {
        Address address = new Address("123 Main St", "Anytown", "Anystate", "12345");
        PropertyCreator creator = new ApartmentCreator();
        Property property = creator.createProperty("", address, 1, 2, 1, 1000);

        assertTrue(property instanceof Apartment);
    }

    private final Tenant testTenant = new Tenant("AFJ", "afj@example.com", "123-456-7890");
    private final Apartment testApartment = new Apartment(new Address("123 Main St", "Anytown", "Anystate", "12345"), 1, 2, 1, 1000);

    @Test
    public void testRegisterTenant() {
        // register the test tenant with the test apartment
        testApartment.registerTenant(testTenant);

        // assert that the tenant is now in the list of observers
        assertTrue(testApartment.observers.contains(testTenant));
    }

    @Test
    public void testDeregisterTenant() {
        // register the test tenant with the test apartment
        testApartment.registerTenant(testTenant);

        // deregister the test tenant from the test apartment
        testApartment.deregisterTenant(testTenant);

        // assert that the tenant is no longer in the list of observers
        assertFalse(testApartment.observers.contains(testTenant));
    }

    @Test
    public void testNotifyTenant() {
        testApartment.registerTenant(testTenant);

        testApartment.setAvailable(false);

        testApartment.notifyTenant();
    }
}

