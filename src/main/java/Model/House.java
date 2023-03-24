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

public class House implements Property {
    private final List<TenantObserver> observers = new ArrayList<>();
    private final String streetNumber;
    private final Address address;
    private final int numberOfBedrooms;
    private final int numberOfBathrooms;
    private final int squareFootage;
    private boolean available;

    public House(String streetNumber, Address address, int numberOfBedrooms, int numberOfBathrooms, int squareFootage) {
        this.streetNumber = streetNumber;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.squareFootage = squareFootage;
        this.available = true;
    }

    @Override
    public String getAddress() {
        return "streetNumber='" + streetNumber + '\'' +
                "," + address.toString();
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
        return "House";
    }

    @Override
    public int getUnitNumber() {
        return 0;
    }

    @Override
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    @Override
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    @Override
    public int getSquareFootage() {
        return squareFootage;
    }

    @Override
    public String getStreetNumber() {
        return streetNumber;
    }

    @Override
    public String toString() {
        return "House details: " +
                getAddress() +
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", squareFootage=" + squareFootage +
                ", available=" + available;
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
