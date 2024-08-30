package formCustomer.demo.entity.system;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.Date;

@Entity
@Table(name="Forms")//資料庫名稱
public class Form {
    //主鍵
    @Id
    @Column(name = "FormID")
    private int formId;

    @Column(name = "SubmitterID", length = 20)
    private String submitterId;

    @Column(name = "SubmitDate")
    private Date submitDate;

    @Column(name = "FormType", length = 50)
    private String formType;

    // Constructors
    public Form() {}

    public Form(int formId, String submitterId, Date submitDate, String formType) {
        this.formId = formId;
        this.submitterId = submitterId;
        this.submitDate = submitDate;
        this.formType = formType;
    }

    // Getters and Setters
    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

}
