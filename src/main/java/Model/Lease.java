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

import java.util.Date;
// Lease class is the class for lease which attaches a property to a tenant
public class Lease {
    private Tenant tenant;
    private Property property;
    private Date startDate;
    private Date endDate;
    private double rentAmount;
    private boolean rentPaid;

    public Lease(Tenant tenant, Property property, Date startDate, Date endDate, double rentAmount) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.rentPaid = true;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public boolean isRentPaid() {
        return rentPaid;
    }

    public void setRentPaid(boolean rentPaid) {
        this.rentPaid = rentPaid;
    }

    @Override
    public String toString() {
        return "Lease -->"+tenant  + property ;
    }
}
