package formCustomer.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
//回傳個人需要簽核的表單
public class FormToSignDto {
    String formId;  //表單編號
    String submitter_id;//提交者員工id
    Date submitter_data;//表單創建時間
    String formtype;//表單名稱
    String staffName;//提交者姓名


    public FormToSignDto(String formId, String submitter_id, Date submitter_data, String formtype, String staffName) {
        this.formId = formId;
        this.submitter_id = submitter_id;
        this.submitter_data = submitter_data;
        this.formtype = formtype;
        this.staffName = staffName;
    }
}
