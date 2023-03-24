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
//HouseCreator is the concrete creator for a house. This is used to create a house.

public class HouseCreator extends PropertyCreator {
    @Override
    public Property createProperty(String streetNumber, Address address, int apartmentNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage) {
        return new House(streetNumber, address, numberOfBedrooms, numberOfBathrooms, squareFootage);
    }
}
