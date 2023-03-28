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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaseTest {
    private Tenant tenant;
    private Property property;
    private Date startDate;
    private Date endDate;
    private double rentAmount;
    private Lease lease;
    private Tenant newTenant;
    private Property newproperty;

    @Before
    public void setUp() {
        tenant = new Tenant("AFJ", "AFJ@example.com", "123-456-7890");
        newTenant = new Tenant("newAFJ", "newAFJ@example.com", "123-456-7890");
        PropertyCreator propertyCreator = new ApartmentCreator();
        property = propertyCreator.createProperty("2/262", new Address("Vikas Khand", "Lucknow", "UP", "226010"), 38, 4, 2,1000);
        PropertyCreator newpropertyCreator = new HouseCreator();
        newproperty = newpropertyCreator.createProperty("new 2/262", new Address("new Vikas Khand", "new Lucknow", "new UP", "new 226010"), 38, 4, 2,1000);
        startDate = new Date();
        endDate = new Date();
        rentAmount = 1000.0;
        lease = new Lease(tenant, property, startDate, endDate, rentAmount);
    }

    @Test
    public void testGetTenant() {
        assertEquals(tenant, lease.getTenant());
    }

    @Test
    public void testGetProperty() {
        assertEquals(property, lease.getProperty());
    }

    @Test
    public void testSetProperty() {
        assertEquals(property, lease.getProperty());
        lease.setProperty(newproperty);
        assertEquals(newproperty, lease.getProperty());
    }

    @Test
    public void testSetTenant() {
        assertEquals(tenant, lease.getTenant());
        lease.setTenant(newTenant);
        assertEquals(newTenant, lease.getTenant());
    }

    @Test
    public void testGetStartDate() {
        assertEquals(startDate, lease.getStartDate());
    }

    @Test
    public void testSetStartDate() {
        assertEquals(startDate, lease.getStartDate());
        Date newStartDate = new Date(2022, 4, 1);
        lease.setStartDate(newStartDate);
        assertEquals(newStartDate, lease.getStartDate());

    }

    @Test
    public void testGetEndDate() {
        assertEquals(endDate, lease.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        assertEquals(endDate, lease.getEndDate());
        Date newEndDate = new Date(2022, 4, 1);
        lease.setEndDate(newEndDate);
        assertEquals(newEndDate, lease.getEndDate());

    }

    @Test
    public void testGetRentAmount() {
        assertEquals(rentAmount, lease.getRentAmount());
    }

    @Test
    public void testSetRentAmount() {
        assertEquals(rentAmount, lease.getRentAmount());
        double newRentAmount = 1600.0;
        lease.setRentAmount(newRentAmount);
        assertEquals(newRentAmount, lease.getRentAmount(), 0);
    }

    @Test
    public void testIsRentPaid() {
        lease.setRentPaid(false);
        assertFalse(lease.isRentPaid());
        lease.setRentPaid(true);
        assertTrue(lease.isRentPaid());
    }
}
