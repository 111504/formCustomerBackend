package formCustomer.demo.entity.system.form;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name= "deviceform")//資料庫名稱
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceForm {
    //主鍵
    @Id
    @Column(name = "form_id")
    private String formId;

    @Column(name = "submitter_id", length = 20)
    private String submitterId;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "form_type", length = 50)
    private String formType;

    @Column(name = "current_approval_order")
    private int currentApprovalOrder;

    @Column(name = "current_approver_id" ,length = 20)
    private String currentApprovalId;

}
