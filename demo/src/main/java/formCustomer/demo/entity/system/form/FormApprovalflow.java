package formCustomer.demo.entity.system.form;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "formapprovalflow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormApprovalflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_id")
    private Integer flowId;

    @ManyToOne
    @JoinColumn(name = "form_id", foreignKey = @ForeignKey(name = "formapprovalflow_deviceform_form_id_fk"))
    private DeviceForm deviceForm;

    @Column(name = "staff_code", length = 20)
    private String staffCode;

    @Column(name = "approval_order")
    private Integer approvalOrder;

    @Column(name = "approval_status", length = 20)
    private String approvalStatus;

    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;

    @Column(name = "comments", length = 255)
    private String comments;

    public FormApprovalflow(DeviceForm deviceForm, String staffCode, Integer approvalOrder, String approvalStatus, Date approvalDate, String comments) {
        this.deviceForm = deviceForm;
        this.staffCode = staffCode;
        this.approvalOrder = approvalOrder;
        this.approvalStatus = approvalStatus;
        this.approvalDate = approvalDate;
        this.comments = comments;
    }

}
