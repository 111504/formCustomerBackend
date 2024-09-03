package formCustomer.demo.entity.system.form;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="device_form_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceFormContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL) // 级联保存 DeviceForm
    @JoinColumn(name = "form_id", nullable = false,foreignKey = @ForeignKey(name = "device_form_deviceform_form_id_k"))
    private DeviceForm form;  // 關聯到主表單

    @Column(name = "applicant")
    private String applicant;

    @Column(name = "purchase_date")
    private String purchaseDate;

    @Column(name = "purchase_no")
    private String purchaseNo;

    @Column(name = "purchase_dept")
    private String purchaseDept;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "vendor_no")
    private String vendorNo;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    public DeviceFormContent(DeviceForm form, String applicant, String purchaseDate, String purchaseNo, String purchaseDept, String companyName, String vendorNo, String remarks, Date createdAt, Date updatedAt) {
        this.form = form;
        this.applicant = applicant;
        this.purchaseDate = purchaseDate;
        this.purchaseNo = purchaseNo;
        this.purchaseDept = purchaseDept;
        this.companyName = companyName;
        this.vendorNo = vendorNo;
        this.remarks = remarks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
