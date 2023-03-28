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
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TenantTest {
    private Tenant tenant;
    private Property property;
    private Property newproperty;

    @Before
    public void setUp() {
        tenant = new Tenant("AFJ", "AFJ@example.com", "123-456-7890");
        PropertyCreator propertyCreator = new ApartmentCreator();
        property = propertyCreator.createProperty("2/262", new Address("Vikas Khand", "Lucknow", "UP", "226010"), 38, 4, 2,1000);
        PropertyCreator newpropertyCreator = new HouseCreator();
        newproperty = newpropertyCreator.createProperty("new 2/262", new Address("new Vikas Khand", "new Lucknow", "new UP", "new 226010"), 38, 4, 2,1000);
        Lease lease1 = new Lease(tenant, property, new Date(), new Date(), 1000.0);
        Lease lease2 = new Lease(tenant, newproperty, new Date(), new Date(), 2000.0);
        tenant.addLease(lease1);
        tenant.addLease(lease2);
    }

    @Test
    public void testGetName() {
        assertEquals("AFJ", tenant.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("AFJ@example.com", tenant.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals("123-456-7890", tenant.getPhone());
    }

    @Test
    public void testGetLeases() {
        assertNotNull(tenant.getLeases());
    }

    @Test
    public void testSetPhone() {
        tenant.setPhone("555-555-5555");
        assertEquals("555-555-5555", tenant.getPhone());
    }

    @Test
    public void testClone() {
        Tenant clone = tenant.clone();
        assertEquals(tenant.getName(), clone.getName());
        assertEquals(tenant.getEmail(), clone.getEmail());
        assertEquals(tenant.getPhone(), clone.getPhone());
        assertEquals(tenant.getLeases(), clone.getLeases());
    }
}
