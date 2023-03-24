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
// PropertiesSubject is the interface for registering,de-registering and notifying a tenant.
public interface PropertiesSubject {

    void registerTenant(TenantObserver tenant);

    void deregisterTenant(TenantObserver tenant);

    void notifyTenant();

}
