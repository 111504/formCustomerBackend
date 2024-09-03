package formCustomer.demo.entity.system.form;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "default_approval_flow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultApprovalFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_id")
    private Integer flowId;

    @Column(name = "form_type")
    private String formType;

    @Column(name = "approval_order")
    private Integer approvalOrder;


    @Column(name = "default_staff_code")
    private String defaultStaffCode;
}
