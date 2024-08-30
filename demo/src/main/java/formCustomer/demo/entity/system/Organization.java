package formCustomer.demo.entity.system;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orgId;

    @Column(name = "Org_Name", length = 100, nullable = false)
    private String orgName;

    @Column(name = "Org_Code", length = 10, nullable = false, unique = true)
    private String orgCode;

    public Organization(String orgName, String orgCode) {
        this.orgName = orgName;
        this.orgCode = orgCode;
    }




}
