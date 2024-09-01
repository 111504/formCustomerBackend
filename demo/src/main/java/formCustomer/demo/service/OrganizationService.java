package formCustomer.demo.service;

import formCustomer.demo.entity.system.Organization;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.repository.OrganizationRepository;
import formCustomer.demo.repository.OrganizationStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService   {

    private final OrganizationRepository organizationRepository;
    private final OrganizationStaffRepository organizationStaffRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, OrganizationStaffRepository organizationStaffRepository) {
        this.organizationRepository = organizationRepository;
        this.organizationStaffRepository = organizationStaffRepository;
    }

    public  List<Organization> getAllOrganizations() {   List<Organization> organizations = organizationRepository.findAll();
        System.out.println("Organizations: " + organizations);
        return organizations;
    }

    public Optional<Organization> getOrganizationById(int id) {return organizationRepository.findById(id);}

    public Organization saveOrganization(Organization organization) {return organizationRepository.save(organization);}

    public void deleteOrganizationById(int id) {organizationRepository.deleteById(id);}

    //除入部門編號 回傳該部門人員
    public List<Staff> getStaffByOrganizationCode(String orgCode) {
        return organizationStaffRepository.findStaffByOrgCode(orgCode);
    }


}
