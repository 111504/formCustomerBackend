package formCustomer.demo.controller;


import formCustomer.demo.entity.system.Organization;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.service.OrganizationService;
import formCustomer.demo.entity.RestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class originazionController {


    private final OrganizationService organizationService;

    @Autowired
    public originazionController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    //傳送部們編號 回傳人員名單
    @GetMapping("persons")
    public String schoolOriginazionePeople(@RequestParam String depId) {
        System.out.println("depId="+depId);
        List<Staff> staffs;
        staffs =  organizationService.getStaffByOrganizationCode(depId);


        if(staffs.isEmpty()){
            return RestBean.error("error ,no Result").asJsonString();
        }else{
            staffs.forEach(staff -> System.out.println(staff));
        }
        return RestBean.success(staffs).asJsonString();
    }

    /*回傳學校所有組織列表*/
    @GetMapping("department")
    public String schoolDepartment() {
        List<Organization> organizations=organizationService.getAllOrganizations();
        return RestBean.success(organizations).asJsonString();
    }

}
