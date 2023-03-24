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
//PropertyCreator is the abstract  creator for a property. This is used by subclass creator classes.

public abstract class PropertyCreator {
    public abstract Property createProperty(String streetNumber, Address address, int apartmentNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage);
}
