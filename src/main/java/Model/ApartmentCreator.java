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
// ApartmentCreator is the concrete creator for an apartment. This is used to create an apartment.
public class ApartmentCreator extends PropertyCreator {
    @Override
    public Property createProperty(String streetNumber, Address address, int apartmentNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage) {
        return new Apartment(address, apartmentNumber, numberOfBedrooms, numberOfBathrooms, squareFootage);
    }
}
