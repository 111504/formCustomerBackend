package formCustomer.demo.controller;


import formCustomer.demo.entity.Person;
import formCustomer.demo.entity.RestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/Originization")
public class schoolOriginazionController {
    //傳送部們編號 回傳人員名單
    @GetMapping("/persons")
    public String schoolOriginazionePeople() {
        List<Person> persons = Arrays.asList(
                new Person("pur10012", "王美麗"),
                new Person("pur54451", "林大名"),
                new Person("fin65487", "洪大俠")
        );
        return RestBean.success(persons).asJsonString();
    }


    @GetMapping("/originazione")
    public String schoolOriginazione() {
        List<Person> persons = Arrays.asList(
                new Person("pur10012", "王美麗"),
                new Person("pur54451", "林大名"),
                new Person("fin65487", "洪大俠")
        );
        return RestBean.success(persons).asJsonString();
    }

}
