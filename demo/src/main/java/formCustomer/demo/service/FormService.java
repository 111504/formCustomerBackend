package formCustomer.demo.service;


import formCustomer.demo.dto.DeviceFormDto;
import formCustomer.demo.entity.system.form.DeviceForm;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.entity.system.form.DeviceFormContent;
import formCustomer.demo.entity.system.form.DeviceFormItem;
import formCustomer.demo.repository.*;
import formCustomer.demo.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static formCustomer.demo.util.Tool.getCurrentDate;

@Service
public class FormService {


    private final FormRepository formRepository;
    private final FormApprovalflowRepository formApprovalflowRepository ;
    private final StaffRepository staffRepository;
    private final DeviceFormContenRepository deviceFormContenRepository;
    private final DeviceFormRepository deviceFormRepository;

    @Autowired
    public FormService(FormRepository formRepository, OrganizationStaffRepository organizationStaffRepository, FormApprovalflowRepository formApprovalflowRepository, StaffRepository staffRepository, DeviceFormContenRepository deviceFormContenRepository, DeviceFormRepository deviceFormRepository) {
        this.formRepository = formRepository;
        this.formApprovalflowRepository = formApprovalflowRepository;
        this.staffRepository = staffRepository;
        this.deviceFormContenRepository = deviceFormContenRepository;
        this.deviceFormRepository = deviceFormRepository;
    }
    //列出所有表單
    public List<DeviceForm> getAllForms() {
        return formRepository.findAll();
    }

    //查詢表單資訊
    public Optional<DeviceForm> getFormById(int id) {
        return formRepository.findById(id);
    }
    //儲存表單資訊
    public DeviceForm saveForm(DeviceForm deviceForm) {
        return formRepository.save(deviceForm);
    }
    //刪除表單
    public void deleteFormById(int id) {
        formRepository.deleteById(id);
    }

    //根據表單編號回傳(預設)簽核站點
    public  List<Staff> getStaffDefaultByFormType(String formType) {
        return staffRepository.findStaffDefaultByFormType(formType);
    }

    //處理表單傳送過來的訊息
    public void processFormSubmission(DeviceFormDto deviceFormDto) {

        System.out.println("開始處理表單資訊"+deviceFormDto);
        //產生表單事件編號
        String formId= Tool.generateRandomString(7);

        //提取簽核順序的第一位員工
        DeviceFormDto.StationDto firstStation =deviceFormDto.getStations().get(0);

        // 使用第一个 StationDto 对象初始化 DeviceForm
        DeviceForm deviceForm = new DeviceForm(formId,"HR001",Tool.getCurrentDate(),"device",1,firstStation.getStaffCode());

        //填入表單資訊
        DeviceFormContent deviceFormContent = new DeviceFormContent();
        deviceFormContent.setForm(deviceForm);
        deviceFormContent.setApplicant(deviceFormDto.getApplicant());
        deviceFormContent.setPurchaseDate(deviceFormDto.getPurchaseDate());
        deviceFormContent.setPurchaseNo(deviceFormDto.getPurchaseNo());
        deviceFormContent.setPurchaseDept(deviceFormDto.getPurchaseDept());
        deviceFormContent.setCompanyName(deviceFormDto.getCompanyName());
        deviceFormContent.setVendorNo(deviceFormDto.getVendorNo());
        deviceFormContent.setRemarks(deviceFormDto.getRemarks());

        //表單更新時間以及創建時間填入當前時間
        deviceFormContent.setCreatedAt(Tool.getCurrentDate());
        deviceFormContent.setUpdatedAt(Tool.getCurrentDate());



        deviceFormContenRepository.save(deviceFormContent);

    }
}
