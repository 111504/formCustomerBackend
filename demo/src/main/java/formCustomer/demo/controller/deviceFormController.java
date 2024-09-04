package formCustomer.demo.controller;


import formCustomer.demo.dto.DeviceFormDto;
import formCustomer.demo.dto.FormFromOwnDto;
import formCustomer.demo.dto.FormToSignDto;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.service.FormService;
import formCustomer.demo.vo.response.FormStation;
import formCustomer.demo.entity.RestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/forms")
public class deviceFormController {

    private final FormService service;
    private final FormService formService;

    @Autowired
    public deviceFormController(FormService service, FormService formService) {
        this.service = service;
        this.formService = formService;
    }


    @GetMapping("/test")
    public String test() {

        return RestBean.success("success").asJsonString();
    }

    //傳送表單編號
    @GetMapping("/formType")
    public String submitForm(@RequestParam String formType) {
        // 傳輸表單事件編號 回傳表單資訊
        List<Staff> staffs;
        staffs = service.getStaffDefaultByFormType(formType);
        if (staffs.isEmpty()) {
            return RestBean.error("error ,no Result").asJsonString();
        } else {
            staffs.forEach(System.out::println);
        }
        return RestBean.success(staffs).asJsonString();

    }

    //傳送表單內容 以及 表單修改後的簽核順序 創建人
    @PostMapping("/formContent")
    public String submitFormContent(@RequestBody DeviceFormDto deviceFormDto) {
        try {
            formService.processFormSubmission(deviceFormDto);
            return RestBean.success().asJsonString();
        } catch (Exception e) {
            return RestBean.failure(504,"error").asJsonString();
        }
    }

    //傳送員工編號 回傳該員工需要簽核的表單資訊
    @GetMapping("/formNeedToSign")
    public String submitFormNeedToSign(@RequestParam String currentApprovalId) {
        System.out.println(currentApprovalId);
    // 從 Service 層取得需要簽核的表單
        List<FormToSignDto> formsToSign = service.getFormNeedToSign(currentApprovalId);
        if (formsToSign.isEmpty()) {
            return RestBean.success().asJsonString();
        }
        System.out.println("formsToSign="+formsToSign);
        return RestBean.success(formsToSign).asJsonString();
    }
    @GetMapping("/formOwnSub")
    //傳送員工編號 回傳該員工需要簽核的表單資訊
    public String FormOwnSubmit(@RequestParam String currentApprovalId){

        List<FormFromOwnDto> formFromOwnDtos=service.getOwnFormSubmit(currentApprovalId);
        if (formFromOwnDtos.isEmpty()) {
            return RestBean.success().asJsonString();
        }
        System.out.println("formFromOwnDtos="+formFromOwnDtos);
        return RestBean.success(formFromOwnDtos).asJsonString();
    }

}


