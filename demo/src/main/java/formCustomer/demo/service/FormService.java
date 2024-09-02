package formCustomer.demo.service;


import formCustomer.demo.entity.system.Form;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.repository.FormApprovalflowRepository;
import formCustomer.demo.repository.FormRepository;
import formCustomer.demo.repository.OrganizationStaffRepository;
import formCustomer.demo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {


    private final FormRepository formRepository;
    private final FormApprovalflowRepository formApprovalflowRepository ;
    private final StaffRepository staffRepository;

    @Autowired
    public FormService(FormRepository formRepository, OrganizationStaffRepository organizationStaffRepository, FormApprovalflowRepository formApprovalflowRepository, StaffRepository staffRepository) {
        this.formRepository = formRepository;
        this.formApprovalflowRepository = formApprovalflowRepository;

        this.staffRepository = staffRepository;
    }
    //列出所有表單
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    //查詢表單資訊
    public Optional<Form> getFormById(int id) {
        return formRepository.findById(id);
    }
    //儲存表單資訊
    public Form saveForm(Form form) {
        return formRepository.save(form);
    }
    //刪除表單
    public void deleteFormById(int id) {
        formRepository.deleteById(id);
    }

    //根據表單編號回傳簽核站點
    public  List<Staff> getStaffDetailsByFormId(int formId) {
        return staffRepository.findStaffDetailsByFormId(formId);
    }

}
