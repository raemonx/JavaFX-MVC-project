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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
// Class to refresh leases based on the date given by user and delete the leases which expires
public class RefreshLease {
    public void refresh(List<Lease> leases, Date date) {
        Iterator<Lease> iterator = leases.iterator();
        while (iterator.hasNext()) {
            Lease lease = iterator.next();
            if (lease.getEndDate().before(date)) {
                lease.getProperty().setAvailability(true);
                lease.getTenant().setLeases(new ArrayList<Lease>());
                iterator.remove();
            }
        }
    }
}
