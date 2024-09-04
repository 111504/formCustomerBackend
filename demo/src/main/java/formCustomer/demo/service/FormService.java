package formCustomer.demo.service;


import formCustomer.demo.dto.DeviceFormDto;
import formCustomer.demo.dto.FormFromOwnDto;
import formCustomer.demo.dto.FormToSignDto;
import formCustomer.demo.entity.system.form.DeviceForm;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.entity.system.form.DeviceFormContent;
import formCustomer.demo.entity.system.form.DeviceFormItem;
import formCustomer.demo.entity.system.form.FormApprovalflow;
import formCustomer.demo.repository.*;
import formCustomer.demo.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private final DeviceFormItemRepository deviceFormItemRepository;

    @Autowired
    public FormService(FormRepository formRepository, OrganizationStaffRepository organizationStaffRepository, FormApprovalflowRepository formApprovalflowRepository, StaffRepository staffRepository, DeviceFormContenRepository deviceFormContenRepository, DeviceFormRepository deviceFormRepository, DeviceFormItemRepository deviceFormItemRepository) {
        this.formRepository = formRepository;
        this.formApprovalflowRepository = formApprovalflowRepository;
        this.staffRepository = staffRepository;
        this.deviceFormContenRepository = deviceFormContenRepository;
        this.deviceFormRepository = deviceFormRepository;
        this.deviceFormItemRepository = deviceFormItemRepository;
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

    //根據使用者員工編號 回傳需要簽核的表單
    public List<FormToSignDto> getFormNeedToSign(String currentApprovalId){

        List<Object[]> results=deviceFormRepository.findFormNeedToSign(currentApprovalId);
        List<FormToSignDto> formsToSign = new ArrayList<>();
        // 打印每一行結果
        for (Object[] row : results) {
            System.out.println("Form ID: " + row[0]);
            System.out.println("Submitter ID: " + row[1]);
            System.out.println("Submit Date: " + row[2]);
            System.out.println("Form Type: " + row[3]);
            System.out.println("Submitter Name: " + row[4]);
            System.out.println("---------------");
        }

        for (Object[] row : results) {
            FormToSignDto dto = new FormToSignDto(
                    (String) row[0], // form_id
                    (String) row[1], // submitter_id
                    (Date) row[2],   // submit_date
                    (String) row[3], // form_type
                    (String) row[4]  // staff_name
            );
            formsToSign.add(dto);
        }
        return formsToSign;

    }

    public List<FormFromOwnDto> getOwnFormSubmit(String currentSubmit){
        List<Object[]> results=deviceFormRepository.findFormOwnSub(currentSubmit);
        List<FormFromOwnDto> formFromOwnDtos = new ArrayList<>();
        for (Object[] row : results) {
            System.out.println("Form ID: " + row[0]);
            System.out.println("Current Approval ID: " + row[1]);
            System.out.println("Current Approval Order: " + row[2]);
            System.out.println("Submit Date: " + row[3]);
            System.out.println("Form type: " + row[4]);
            System.out.println("Staff name: " + row[4]);
            System.out.println("---------------");
        }
        for (Object[] row : results) {
            FormFromOwnDto dto = new FormFromOwnDto(
                    (String) row[0], // form_id
                    (String) row[1], // Current Approval ID
                    (int) row[2],   // Current Approval Order
                    (Date) row[3], // Submit Date
                    (String) row[4],  // Form type
                    (String) row[5]  //stuffName
            );
            formFromOwnDtos.add(dto);
        }
        return formFromOwnDtos;
    }

    //處理表單傳送過來的訊息
    public void processFormSubmission(DeviceFormDto deviceFormDto) {

        System.out.println("開始處理表單資訊"+deviceFormDto);
        //產生表單事件編號
        String formId= Tool.generateRandomString(7);

        //提取簽核順序的第一位員工
        DeviceFormDto.StationDto firstStation =deviceFormDto.getStations().get(0);

        // 使用第一个 StationDto 对象初始化 DeviceForm
        DeviceForm deviceForm = new DeviceForm(formId,"HR001", getCurrentDate(),"device",1,firstStation.getStaffCode());

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
        deviceFormContent.setCreatedAt(getCurrentDate());
        deviceFormContent.setUpdatedAt(getCurrentDate());

        deviceFormContenRepository.save(deviceFormContent);

        //提取所有簽核站點
        List<DeviceFormDto.StationDto>stations=deviceFormDto.getStations();
        for(int i=0;i<stations.size();i++){
            DeviceFormDto.StationDto stationDto=stations.get(i);
            FormApprovalflow formApprovalflow=new FormApprovalflow(deviceForm,stationDto.getStaffCode(),(i+1),"Pending", getCurrentDate(),"");
            formApprovalflowRepository.save(formApprovalflow);
        }

        //儲存item項目
        List<DeviceFormDto.ItemDto>items=deviceFormDto.getItems();
        for(int i=0;i<items.size();i++){
            DeviceFormDto.ItemDto itemDto=items.get(i);
            DeviceFormItem deviceFormItem=new DeviceFormItem(deviceForm,itemDto.getItemCode(),itemDto.getItemName(),itemDto.getItemQty(),itemDto.getItemPrice(),itemDto.getItemAmount());
            deviceFormItemRepository.save(deviceFormItem);
        }


    }
}
