package formCustomer.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import formCustomer.demo.vo.request.FormInfoRequest;


@RestController
@RequestMapping("/api/v1/forms")
public class deviceFormController {


    //傳送表單編號
    @PostMapping("/formId")
    public ResponseEntity<String> submitForm(@RequestBody FormInfoRequest formInfoRequest) {
        // 傳輸表單編號 回傳表單資訊
        Long formId = formInfoRequest.getFormId();
        /*
            兩部分 是這表單預設的
            職位
            姓名
        *
        *

        * */
        // 假設後端成功處理，回應狀態碼200 OK
        return ResponseEntity.ok("Form ID " + formId + " submitted successfully.");
    }

}
