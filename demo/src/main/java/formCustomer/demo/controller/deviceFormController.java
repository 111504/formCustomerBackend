package formCustomer.demo.controller;


import formCustomer.demo.dto.DeviceFormDto;
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
        // 傳輸表單內容 簽核順序  創建人 創建表單時間 產生表單唯一編號  是哪一種表單
        try {
            //
            System.out.println("表單資訊"+deviceFormDto);
            formService.processFormSubmission(deviceFormDto);
            return RestBean.success().asJsonString();
        } catch (Exception e) {
            return RestBean.success().asJsonString();
        }
    }
}


