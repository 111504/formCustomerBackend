package formCustomer.demo.entity.system;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Organization")
public class Organization {
    @Id
    @Column(name = "OrgID")
    private int orgId;

    @Column(name = "OrgName", length = 100, nullable = false)
    private String orgName;

    @Column(name = "OrgCode", length = 10, nullable = false, unique = true)
    private String orgCode;

    // Constructors
    public Organization() {}

    public Organization(int orgId, String orgName, String orgCode) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgCode = orgCode;
    }

    // Getters and Setters
    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
