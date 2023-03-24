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

//import View.SendMailView;

import java.util.ArrayList;
import java.util.List;
//Tenant class containing the tenant info and the leases held by the tenant
public class Tenant implements TenantObserver, TenantInterface {
    private String name;
    private String email;
    private String phone;
    private List<Lease> leases;

    public Tenant(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.leases = new ArrayList<>();
    }

    public Tenant(String name, String email, String phone, List<Lease> leases) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.leases = leases;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Tenant clone() {
        return new Tenant(name, email, phone, leases);
    }

    public void addLease(Lease lease) {
        leases.add(lease);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLeases() {
        StringBuilder sb = new StringBuilder();
        for (Lease lease : leases) {
            sb.append("\nLease:\n")
                    .append("Start date: ").append(lease.getStartDate()).append("\n")
                    .append("End date: ").append(lease.getEndDate()).append("\n")
                    .append("Property address: ").append(lease.getProperty().getAddress()).append("\n")
                    .append("Rent amount: ").append(lease.getRentAmount()).append("\n")
                    .append("Rent paid: ").append(lease.isRentPaid()).append("\n");
        }
        return sb.toString();
    }


    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    @Override
    public String toString() {
        String leases = getLeases();
        return "Tenant Details: "+"\n" +
                "name ='" + name + '\'' +
                ", email ='" + email + '\'' +
                ", phone ='" + phone + '\'' +
                leases ;
    }

    @Override
    public void update(Property property) {
//        SendMailView sendMailView = new SendMailView();
//        sendMailView.display(this.getEmail(), property.getAddress());
    }
}
