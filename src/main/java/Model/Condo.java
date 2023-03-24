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
package Model;

import java.util.ArrayList;
import java.util.List;
// Condo class is the subclass of Property class.
public class Condo implements Property {
    private final List<TenantObserver> observers = new ArrayList<>();
    private String streetNumber;
    private Address address;
    private int unitNumber;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int squareFootage;
    private boolean available;

    public Condo(String streetNumber, Address address, int unitNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage) {
        this.streetNumber = streetNumber;
        this.address = address;
        this.unitNumber = unitNumber;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.squareFootage = squareFootage;
        this.available = true;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Condo details: " +
                getAddress() +
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", squareFootage=" + squareFootage +
                ", available=" + available ;
    }

    @Override
    public String getAddress() {
        return "UnitNumber=" + unitNumber + ", StreetNumber='" + streetNumber + '\'' + ", " + address.toString();
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailability(boolean available) {
        this.available = available;
        if (available) {
            notifyTenant();
        }
    }
    @Override
    public String getType() {
        return "Condo";
    }
    // Method to register a tenant to waiting list
    @Override
    public void registerTenant(TenantObserver tenant) {
        observers.add(tenant);
    }
    // Method to deregister a tenant to waiting list
    @Override
    public void deregisterTenant(TenantObserver tenant) {
        observers.remove(tenant);
    }
    // Method to notify a tenant
    @Override
    public void notifyTenant() {
        if (available) {
            for (TenantObserver tenant : observers) {
                tenant.update(this);
            }
        }

    }
}
