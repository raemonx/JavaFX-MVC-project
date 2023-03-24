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
//Property interface for properties
public interface Property extends PropertiesSubject{
    String getAddress();

    boolean isAvailable();

    void setAvailability(boolean available);

    String getType();

    int getUnitNumber();

    int getNumberOfBedrooms();

    int getNumberOfBathrooms();

    int getSquareFootage();

    String getStreetNumber();

    String toString();
}
