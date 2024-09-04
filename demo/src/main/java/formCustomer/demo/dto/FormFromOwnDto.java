package formCustomer.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormFromOwnDto {
    private String formId;
    private String currentApprovalId;
    private int currentApprovalOrder;
    private Date submittedDate;
    private String formType;
    private String stuffName;


}
