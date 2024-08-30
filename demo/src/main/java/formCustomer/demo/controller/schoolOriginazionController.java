package formCustomer.demo.controller;


import formCustomer.demo.entity.system.Organization;
import formCustomer.demo.service.OrganizationService;
import formCustomer.demo.vo.response.Person;
import formCustomer.demo.entity.RestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class schoolOriginazionController {


    private final OrganizationService organizationService;

    @Autowired
    public schoolOriginazionController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    //傳送部們編號 回傳人員名單
    @GetMapping("persons")
    public String schoolOriginazionePeople(@RequestParam String depId) {
        ArrayList<Person> persons = new ArrayList<>();
        switch (depId) {
            case "fin":
                persons.add(new Person("fin10012", "王美麗","二級專員"));
                persons.add(new Person("fin54122", "林大名","二級專員"));
                persons.add(new Person("fin10087", "宏大中","二級專員"));
                break;

            case "pur":
                persons.add(new Person("pur10121", "王一一","二級專員"));
                persons.add(new Person("pur54782", "林施韓","一級專員"));
                persons.add(new Person("pur44155", "林與中","二級專員"));
                break;
            case "per":
                persons.add(new Person("per15642","林至涵","主任秘書"));
                persons.add(new Person("per25642","簡玲玉","主任副秘書"));
                persons.add(new Person("per24232","師裕隆","副理"));
                break;

        }


        return RestBean.success(persons).asJsonString();
    }

    /*回傳學校所有組織列表*/
    @GetMapping("department")
    public String schoolDepartment() {


        List<Organization> organizations=organizationService.getAllOrganizations();



        return RestBean.success(organizations).asJsonString();
    }

}
