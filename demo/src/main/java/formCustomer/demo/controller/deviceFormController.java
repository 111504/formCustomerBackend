package formCustomer.demo.controller;


import formCustomer.demo.vo.response.FormStation;
import formCustomer.demo.entity.RestBean;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/forms")
public class deviceFormController {


    @GetMapping("/test")
    public String test() {

        return RestBean.success("success").asJsonString();
    }
    //傳送表單編號
    @GetMapping("/formId")
    public String submitForm(@RequestParam String formId ) {
        // 傳輸表單編號 回傳表單資訊
        List<FormStation>  formStations = Arrays.asList(
                new FormStation(1, "二級專員","王治中"),
                new FormStation(2, "一級專員","林愈停"),
                new FormStation(3, "主任秘書", "陳詩涵")
        );
        return RestBean.success(formStations).asJsonString();

    }
    //傳送表單內容 以及 表單修改後的簽核順序 創建人
    @PostMapping("/formContent")
    public String submitFormContent(@RequestParam String formId ) {
        // 傳輸表單內容 簽核順序  創建人 創建表單時間 產生表單唯一編號  是哪一種表單

        return RestBean.success().asJsonString();

    }




}
