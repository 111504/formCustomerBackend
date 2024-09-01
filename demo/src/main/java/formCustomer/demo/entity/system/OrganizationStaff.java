package formCustomer.demo.entity.system;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="organization_staff")
public class OrganizationStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "org_code", nullable = false)
    private String orgCode;

    @Column(name = "staff_code", nullable = false)
    private String staffCode;

    // 外键关联到 Organization 表的 org_code 列
    @ManyToOne
    @JoinColumn(name = "org_code", referencedColumnName = "org_code", insertable = false, updatable = false)
    private Organization organization;

    // 外键关联到 Staff 表的 staff_code 列
    @ManyToOne
    @JoinColumn(name = "staff_code", referencedColumnName = "staff_code", insertable = false, updatable = false)
    private Staff staff;

    public OrganizationStaff(String orgCode, String staffCode) {
        this.orgCode = orgCode;
        this.staffCode = staffCode;
    }
}
